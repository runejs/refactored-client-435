package org.runejs.client.renderer.gpu;

import org.lwjgl.system.MemoryUtil;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.scene.Point3d;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.camera.Camera;
import org.runejs.client.scene.camera.CameraRotation;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_BGRA;
import static org.lwjgl.opengl.GL12.GL_UNSIGNED_INT_8_8_8_8_REV;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform1i;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;
import static org.lwjgl.opengl.GL30.*;

/**
 * Draws the 3D scene with OpenGL instead of {@code Rasterizer3D}, into the same pixel buffer the client draws
 * its interface over afterwards. The context is offscreen, so nothing about the window, the 2D layer, the menu
 * or the headless harness changes; the scene is rendered to a framebuffer object and read back.
 *
 * The client's own lighting, projection constants and hover tests are kept. What changes is that the whole loaded
 * region is drawn every frame from buffers uploaded when the region loaded, with a depth buffer settling order,
 * so the draw distance is no longer bounded by what a software rasterizer can fill.
 */
public final class GpuSceneRenderer {
    private static final float NEAR_PLANE = 50f;
    /**
     * With {@code -Drunejs.gpu.stats=true} a line of frame timings is printed every {@link #STATS_INTERVAL} frames.
     */
    private static final boolean STATS = Boolean.getBoolean("runejs.gpu.stats");
    private static final int STATS_INTERVAL = 100;

    private final int drawDistanceTiles;
    private final boolean fog;
    private final int extendedTerrainTiles;

    private GlContext context;
    private ShaderProgram program;
    private int uniformViewProjection;
    private int uniformFogStart;
    private int uniformFogEnd;

    private TextureArray textures;
    private ModelEmitter emitter;
    private StaticScene staticScene;
    private ExtendedTerrain extendedTerrain;
    private GpuSceneTraversal traversal;
    private Scene builtScene;
    private int builtGeneration;

    private final VertexStream dynamicOpaque = new VertexStream(1 << 16);
    private final VertexStream dynamicAlpha = new VertexStream(1 << 12);
    private int dynamicOpaqueVbo;
    private int dynamicOpaqueVao;
    private int dynamicAlphaVbo;
    private int dynamicAlphaVao;

    private int framebuffer;
    private int colourTexture;
    private int depthBuffer;
    private int framebufferWidth;
    private int framebufferHeight;
    private IntBuffer readback;

    private final float[] matrix = new float[16];
    private boolean initialised;
    private boolean failed;

    private int statsFrames;
    private long statsTraversalNanos;
    private long statsDrawNanos;
    private long statsReadbackNanos;
    private int statsDynamicTriangles;

    /**
     * @param drawDistanceTiles how far, in tiles, the world stays visible before fog takes it; also sets the far
     *                          clipping plane
     * @param fog               whether distant geometry fades to the background rather than ending abruptly
     * @param extendedTerrainTiles how many tiles of ground to draw beyond each edge of the loaded region, from
     *                          the map files in the cache; 0 stops at the region edge
     */
    public GpuSceneRenderer(int drawDistanceTiles, boolean fog, int extendedTerrainTiles) {
        this.drawDistanceTiles = Math.max(1, drawDistanceTiles);
        this.fog = fog;
        this.extendedTerrainTiles = Math.max(0, extendedTerrainTiles);
    }

    /**
     * Renders one frame into {@code Rasterizer.destinationPixels}, which the caller has pointed at the scene
     * buffer. Returns false once this renderer has given up on this machine; the caller should then draw with the
     * software rasterizer for the rest of the session.
     */
    public boolean render(Scene scene, Camera camera, int plane) {
        if (failed) {
            return false;
        }
        try {
            if (!initialised) {
                initialise();
            }
            context.makeCurrent();
            frame(scene, camera, plane);
            return true;
        } catch (Throwable problem) {
            failed = true;
            System.err.println("GPU renderer disabled, falling back to software rendering: " + problem);
            problem.printStackTrace();
            release();
            return false;
        }
    }

    private void initialise() {
        context = GlContext.create();
        System.out.println("GPU renderer: " + glGetString(GL_RENDERER) + ", OpenGL " + glGetString(GL_VERSION));
        program = new ShaderProgram(Shaders.VERTEX, Shaders.FRAGMENT);
        uniformViewProjection = program.uniform("uViewProjection");
        uniformFogStart = program.uniform("uFogStart");
        uniformFogEnd = program.uniform("uFogEnd");
        program.use();
        glUniform1i(program.uniform("uTextures"), 0);
        dynamicOpaqueVbo = glGenBuffers();
        dynamicOpaqueVao = VertexLayout.createVertexArray(dynamicOpaqueVbo);
        dynamicAlphaVbo = glGenBuffers();
        dynamicAlphaVao = VertexLayout.createVertexArray(dynamicAlphaVbo);
        framebuffer = glGenFramebuffers();
        colourTexture = glGenTextures();
        depthBuffer = glGenRenderbuffers();
        initialised = true;
    }

    private void frame(Scene scene, Camera camera, int plane) {
        int width = Rasterizer.destinationWidth;
        int height = Rasterizer.destinationHeight;
        if (width <= 0 || height <= 0) {
            return;
        }
        if (Rasterizer3D.interface3 == null) {
            // Textures are not loaded yet; there is nothing the scene could be drawn with.
            return;
        }
        if (textures == null) {
            textures = new TextureArray(Rasterizer3D.interface3);
            emitter = new ModelEmitter(textures.layers);
            TerrainEmitter terrainEmitter = new TerrainEmitter(emitter);
            staticScene = new StaticScene(emitter, terrainEmitter);
            if (extendedTerrainTiles > 0) {
                extendedTerrain = new ExtendedTerrain(extendedTerrainTiles, terrainEmitter);
            }
            traversal = new GpuSceneTraversal(emitter);
        }
        ensureFramebuffer(width, height);
        if (scene != builtScene || scene.generation != builtGeneration) {
            long started = System.nanoTime();
            staticScene.build(scene);
            builtScene = scene;
            builtGeneration = scene.generation;
            System.out.println("GPU renderer: uploaded region, " + staticScene.terrainVertexCount() / 3 + " terrain, "
                    + staticScene.opaqueVertexCount() / 3 + " opaque and " + staticScene.alphaVertexCount() / 3
                    + " translucent triangles in " + (System.nanoTime() - started) / 1000000 + " ms");
        }
        if (extendedTerrain != null) {
            extendedTerrain.update(scene.generation, MovedStatics.baseX, MovedStatics.baseY);
        }

        Point3d position = camera.getPosition();
        CameraRotation rotation = camera.getRotation();
        float farPlane = drawDistanceTiles * 128f * 1.5f + 256f;
        viewProjection(position, rotation, width, height, Rasterizer3D.center_x, Rasterizer3D.center_y, NEAR_PLANE, farPlane);

        program.use();
        glUniformMatrix4fv(uniformViewProjection, false, matrix);
        float fogEnd = fog ? drawDistanceTiles * 128f : 0f;
        glUniform1f(uniformFogStart, fogEnd * 0.7f);
        glUniform1f(uniformFogEnd, fogEnd);

        glBindFramebuffer(GL_FRAMEBUFFER, framebuffer);
        glViewport(0, 0, width, height);
        glClearColor(0f, 0f, 0f, 1f);
        glClearDepth(1.0);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);
        glDepthMask(true);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glFrontFace(GL_CW);
        glDisable(GL_BLEND);

        long traversalStarted = System.nanoTime();
        staticScene.collect(scene, plane);
        dynamicOpaque.clear();
        dynamicAlpha.clear();
        traversal.run(scene, camera, plane, dynamicOpaque, dynamicAlpha);
        long drawStarted = System.nanoTime();

        glActiveTexture(GL_TEXTURE0);
        textures.refresh(emitter.referencedTextures());
        textures.bind();

        // Ground first, pushed back a little so that models lying flat on it win, as they do in painter's order.
        glEnable(GL_POLYGON_OFFSET_FILL);
        glPolygonOffset(1f, 2f);
        staticScene.drawTerrain();
        if (extendedTerrain != null) {
            extendedTerrain.draw();
        }
        glDisable(GL_POLYGON_OFFSET_FILL);
        staticScene.drawOpaque();
        drawStream(dynamicOpaqueVao, dynamicOpaqueVbo, dynamicOpaque);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDepthMask(false);
        staticScene.drawAlpha();
        drawStream(dynamicAlphaVao, dynamicAlphaVbo, dynamicAlpha);
        glDepthMask(true);
        glDisable(GL_BLEND);

        long readbackStarted = System.nanoTime();
        readback.clear();
        glReadPixels(0, 0, width, height, GL_BGRA, GL_UNSIGNED_INT_8_8_8_8_REV, readback);
        readback.get(Rasterizer.destinationPixels, 0, width * height);
        glBindFramebuffer(GL_FRAMEBUFFER, 0);

        if (STATS) {
            long finished = System.nanoTime();
            statsTraversalNanos += drawStarted - traversalStarted;
            statsDrawNanos += readbackStarted - drawStarted;
            statsReadbackNanos += finished - readbackStarted;
            statsDynamicTriangles += (dynamicOpaque.vertexCount() + dynamicAlpha.vertexCount()) / 3;
            if (++statsFrames == STATS_INTERVAL) {
                System.out.println("GPU renderer: per frame over " + STATS_INTERVAL + " frames: traversal "
                        + statsTraversalNanos / 1000 / STATS_INTERVAL + " us, draw " + statsDrawNanos / 1000 / STATS_INTERVAL
                        + " us (incl. GPU wait), readback " + statsReadbackNanos / 1000 / STATS_INTERVAL + " us, "
                        + statsDynamicTriangles / STATS_INTERVAL + " streamed triangles, " + staticScene.drawCallCount()
                        + " static draw ranges");
                statsFrames = 0;
                statsTraversalNanos = 0;
                statsDrawNanos = 0;
                statsReadbackNanos = 0;
                statsDynamicTriangles = 0;
            }
        }
    }

    private static void drawStream(int vao, int vbo, VertexStream stream) {
        if (stream.isEmpty()) {
            return;
        }
        ByteBuffer data = stream.upload();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, data, GL_STREAM_DRAW);
        glBindVertexArray(vao);
        glDrawArrays(GL_TRIANGLES, 0, stream.vertexCount());
        glBindVertexArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    private void ensureFramebuffer(int width, int height) {
        if (width == framebufferWidth && height == framebufferHeight) {
            return;
        }
        glBindTexture(GL_TEXTURE_2D, colourTexture);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, width, height, 0, GL_BGRA, GL_UNSIGNED_INT_8_8_8_8_REV, (IntBuffer) null);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glBindTexture(GL_TEXTURE_2D, 0);
        glBindRenderbuffer(GL_RENDERBUFFER, depthBuffer);
        glRenderbufferStorage(GL_RENDERBUFFER, GL_DEPTH_COMPONENT24, width, height);
        glBindRenderbuffer(GL_RENDERBUFFER, 0);
        glBindFramebuffer(GL_FRAMEBUFFER, framebuffer);
        glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, colourTexture, 0);
        glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_DEPTH_ATTACHMENT, GL_RENDERBUFFER, depthBuffer);
        int status = glCheckFramebufferStatus(GL_FRAMEBUFFER);
        if (status != GL_FRAMEBUFFER_COMPLETE) {
            throw new IllegalStateException("Scene framebuffer is incomplete: 0x" + Integer.toHexString(status));
        }
        glBindFramebuffer(GL_FRAMEBUFFER, 0);
        if (readback != null) {
            MemoryUtil.memFree(readback);
        }
        readback = MemoryUtil.memAllocInt(width * height);
        framebufferWidth = width;
        framebufferHeight = height;
    }

    /**
     * The client's projection as a matrix. Its view space is: x to the right, y down the screen, z into the
     * screen, with screen x = centreX + 512 x / z and screen y = centreY + 512 y / z. Screen y is mapped to
     * increasing window y, which flips the image in the framebuffer so that a plain readback comes out top row
     * first, the way the client's pixel buffer is laid out.
     *
     * World coordinates are (east, height, north) like every model vertex, camera position is (east, north,
     * height) like {@link Point3d}.
     */
    private void viewProjection(Point3d position, CameraRotation rotation, int width, int height, int centreX, int centreY, float near, float far) {
        double sinYaw = rotation.yawSine / 65536.0;
        double cosYaw = rotation.yawCosine / 65536.0;
        double sinPitch = rotation.pitchSine / 65536.0;
        double cosPitch = rotation.pitchCosine / 65536.0;

        // Rows of the rotation that takes camera-relative (east, height, north) to view (x, y, z).
        double[][] r = {
                {cosYaw, 0.0, sinYaw},
                {sinPitch * sinYaw, cosPitch, -sinPitch * cosYaw},
                {-cosPitch * sinYaw, sinPitch, cosPitch * cosYaw},
        };
        double[] cam = {position.x, position.z, position.y};
        double[][] view = new double[3][4];
        for (int row = 0; row < 3; row++) {
            double translation = 0.0;
            for (int col = 0; col < 3; col++) {
                view[row][col] = r[row][col];
                translation -= r[row][col] * cam[col];
            }
            view[row][3] = translation;
        }

        double scaleX = 1024.0 / width;
        double scaleY = 1024.0 / height;
        double offsetX = (2.0 * centreX - width) / width;
        double offsetY = (2.0 * centreY - height) / height;
        double depthA = (far + near) / (far - near);
        double depthB = -2.0 * far * near / (far - near);

        double[][] result = new double[4][4];
        for (int col = 0; col < 4; col++) {
            result[0][col] = scaleX * view[0][col] + offsetX * view[2][col];
            result[1][col] = scaleY * view[1][col] + offsetY * view[2][col];
            result[2][col] = depthA * view[2][col];
            result[3][col] = view[2][col];
        }
        result[2][3] += depthB;

        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                matrix[col * 4 + row] = (float) result[row][col];
            }
        }
    }

    private void release() {
        try {
            if (context != null) {
                context.makeCurrent();
                if (staticScene != null) {
                    staticScene.delete();
                }
                if (extendedTerrain != null) {
                    extendedTerrain.delete();
                }
                if (textures != null) {
                    textures.delete();
                }
                if (program != null) {
                    program.delete();
                }
                context.destroy();
            }
        } catch (Throwable ignored) {
            // Releasing after a failure is best effort; the software renderer takes over regardless.
        }
        context = null;
        if (readback != null) {
            MemoryUtil.memFree(readback);
            readback = null;
        }
    }
}
