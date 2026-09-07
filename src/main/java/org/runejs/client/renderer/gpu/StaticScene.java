package org.runejs.client.renderer.gpu;

import org.lwjgl.system.MemoryUtil;
import org.runejs.client.Landscape;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneRenderer;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.scene.tile.WallDecoration;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL14.glMultiDrawArrays;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

/**
 * Everything in the scene that does not move: terrain and the models the landscape placed on it. It is uploaded
 * once per region load, in tile order, and every element remembers where its triangles are. Each frame the
 * visible tiles' ranges are gathered, neighbouring runs are merged, and the lot is drawn with a handful of
 * multi-draw calls. Nothing here depends on the camera, so the whole region is drawn whatever the distance.
 */
final class StaticScene {
    private final ModelEmitter emitter;
    private final TerrainEmitter terrainEmitter;
    /**
     * Terrain is kept apart from the models so it can be drawn with a depth bias: the software renderer paints
     * a tile's models over its ground, and a flat model lying on the ground (a ripple, a carpet) has to win the
     * depth test the same way.
     */
    private final VertexStream terrain = new VertexStream(1 << 18);
    private final VertexStream opaque = new VertexStream(1 << 20);
    private final VertexStream alpha = new VertexStream(1 << 16);
    private final int terrainVbo;
    private final int terrainVao;
    private final int opaqueVbo;
    private final int opaqueVao;
    private final int alphaVbo;
    private final int alphaVao;
    private final RangeList terrainRanges = new RangeList();
    private final RangeList opaqueRanges = new RangeList();
    private final RangeList alphaRanges = new RangeList();
    private int collectStamp;

    StaticScene(ModelEmitter emitter, TerrainEmitter terrainEmitter) {
        this.emitter = emitter;
        this.terrainEmitter = terrainEmitter;
        terrainVbo = glGenBuffers();
        terrainVao = VertexLayout.createVertexArray(terrainVbo);
        opaqueVbo = glGenBuffers();
        opaqueVao = VertexLayout.createVertexArray(opaqueVbo);
        alphaVbo = glGenBuffers();
        alphaVao = VertexLayout.createVertexArray(alphaVbo);
    }

    void build(Scene scene) {
        terrain.clear();
        opaque.clear();
        alpha.clear();
        Landscape landscape = scene.landscape;
        for (int z = 0; z < scene.mapSizeZ; z++) {
            for (int x = 0; x < scene.mapSizeX; x++) {
                for (int y = 0; y < scene.mapSizeY; y++) {
                    SceneTile tile = scene.tileArray[z][x][y];
                    if (tile == null) {
                        continue;
                    }
                    uploadTile(tile, landscape);
                    if (tile.aSceneTile_2058 != null) {
                        uploadTile(tile.aSceneTile_2058, landscape);
                    }
                }
            }
        }
        glBindBuffer(GL_ARRAY_BUFFER, terrainVbo);
        glBufferData(GL_ARRAY_BUFFER, terrain.upload(), GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, opaqueVbo);
        glBufferData(GL_ARRAY_BUFFER, opaque.upload(), GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, alphaVbo);
        glBufferData(GL_ARRAY_BUFFER, alpha.upload(), GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    int terrainVertexCount() {
        return terrain.vertexCount();
    }

    int opaqueVertexCount() {
        return opaque.vertexCount();
    }

    int alphaVertexCount() {
        return alpha.vertexCount();
    }

    private void uploadTile(SceneTile tile, Landscape landscape) {
        int x = tile.anInt2061;
        int y = tile.anInt2078;
        int heightPlane = tile.anInt2069;
        StaticRange ground = new StaticRange();
        ground.opaqueFirst = terrain.vertexCount();
        if (tile.plainTile != null) {
            int[][] heights = landscape.tile_height[heightPlane];
            terrainEmitter.plainTile(terrain, tile.plainTile, x, y, heights[x][y], heights[x + 1][y], heights[x + 1][y + 1], heights[x][y + 1]);
        } else if (tile.shapedTile != null) {
            terrainEmitter.shapedTile(terrain, tile.shapedTile, x, y);
        }
        ground.opaqueCount = terrain.vertexCount() - ground.opaqueFirst;
        tile.gpuTerrain = ground;

        Wall wall = tile.wall;
        if (wall != null) {
            wall.gpuPrimary = uploadModel(wall.primary, 0, wall.x, wall.z, wall.y);
            wall.gpuSecondary = uploadModel(wall.secondary, 0, wall.x, wall.z, wall.y);
        }
        WallDecoration decoration = tile.wallDecoration;
        if (decoration != null) {
            int face = decoration.face;
            if ((decoration.configBits & 0x300) == 0) {
                decoration.gpu = uploadModel(decoration.renderable, face, decoration.x, decoration.z, decoration.y);
            } else {
                decoration.gpu = uploadModel(decoration.renderable, face * 512 + 256,
                        decoration.x + SceneRenderer.WALL_DECORATION_INSET_X[face], decoration.z, decoration.y + SceneRenderer.WALL_DECORATION_INSET_Y[face]);
                decoration.gpuOutset = uploadModel(decoration.renderable, face * 512 + 1280 & 0x7ff,
                        decoration.x + SceneRenderer.WALL_DECORATION_OUTSET_X[face], decoration.z, decoration.y + SceneRenderer.WALL_DECORATION_OUTSET_Y[face]);
            }
        }
        FloorDecoration floor = tile.floorDecoration;
        if (floor != null) {
            floor.gpu = uploadModel(floor.renderable, 0, floor.x, floor.z, floor.y);
        }
        for (int e = 0; e < tile.entityCount; e++) {
            InteractiveObject entity = tile.interactiveObjects[e];
            // A multi-tile object is listed by every tile it covers; the first one uploads it.
            if (entity != null && entity.gpu == null) {
                entity.gpu = uploadModel(entity.renderable, entity.rotation, entity.worldX, entity.worldZ, entity.worldY);
            }
        }
    }

    /**
     * Only a plain {@link Model} is static. Anything else re-computes its model every frame (animated objects,
     * actors) and is streamed by the traversal instead.
     */
    private StaticRange uploadModel(Renderable renderable, int rotation, int x, int height, int north) {
        if (!(renderable instanceof Model)) {
            return null;
        }
        StaticRange range = begin();
        emitter.emit((Model) renderable, rotation, x, height, north, opaque, alpha);
        return end(range);
    }

    private StaticRange begin() {
        StaticRange range = new StaticRange();
        range.opaqueFirst = opaque.vertexCount();
        range.alphaFirst = alpha.vertexCount();
        return range;
    }

    private StaticRange end(StaticRange range) {
        range.opaqueCount = opaque.vertexCount() - range.opaqueFirst;
        range.alphaCount = alpha.vertexCount() - range.alphaFirst;
        return range;
    }

    /**
     * Gathers the ranges of every tile that is on a drawn level and not hidden by the roof rule, exactly the test
     * the software traversal applies before it draws a tile.
     */
    void collect(Scene scene, int plane) {
        terrainRanges.clear();
        opaqueRanges.clear();
        alphaRanges.clear();
        collectStamp++;
        for (int z = scene.plane; z < scene.mapSizeZ; z++) {
            SceneTile[][] tiles = scene.tileArray[z];
            for (int x = 0; x < scene.mapSizeX; x++) {
                SceneTile[] column = tiles[x];
                for (int y = 0; y < scene.mapSizeY; y++) {
                    SceneTile tile = column[y];
                    if (tile == null || tile.drawLevel > plane) {
                        continue;
                    }
                    collectTile(tile);
                    if (tile.aSceneTile_2058 != null) {
                        collectTile(tile.aSceneTile_2058);
                    }
                }
            }
        }
    }

    private void collectTile(SceneTile tile) {
        if (tile.gpuTerrain != null && tile.gpuTerrain.opaqueCount > 0) {
            terrainRanges.add(tile.gpuTerrain.opaqueFirst, tile.gpuTerrain.opaqueCount);
        }
        Wall wall = tile.wall;
        if (wall != null) {
            add(wall.gpuPrimary);
            add(wall.gpuSecondary);
        }
        WallDecoration decoration = tile.wallDecoration;
        if (decoration != null) {
            add(decoration.gpu);
            add(decoration.gpuOutset);
        }
        FloorDecoration floor = tile.floorDecoration;
        if (floor != null) {
            add(floor.gpu);
        }
        for (int e = 0; e < tile.entityCount; e++) {
            InteractiveObject entity = tile.interactiveObjects[e];
            if (entity != null && entity.gpu != null && entity.gpuCollectStamp != collectStamp) {
                entity.gpuCollectStamp = collectStamp;
                add(entity.gpu);
            }
        }
    }

    private void add(StaticRange range) {
        if (range == null) {
            return;
        }
        if (range.opaqueCount > 0) {
            opaqueRanges.add(range.opaqueFirst, range.opaqueCount);
        }
        if (range.alphaCount > 0) {
            alphaRanges.add(range.alphaFirst, range.alphaCount);
        }
    }

    void drawTerrain() {
        terrainRanges.draw(terrainVao);
    }

    void drawOpaque() {
        opaqueRanges.draw(opaqueVao);
    }

    void drawAlpha() {
        alphaRanges.draw(alphaVao);
    }

    int drawCallCount() {
        return terrainRanges.size + opaqueRanges.size + alphaRanges.size;
    }

    void delete() {
        glDeleteBuffers(terrainVbo);
        glDeleteBuffers(opaqueVbo);
        glDeleteBuffers(alphaVbo);
        terrain.free();
        opaque.free();
        alpha.free();
        terrainRanges.free();
        opaqueRanges.free();
        alphaRanges.free();
    }

    /**
     * (first, count) pairs for glMultiDrawArrays. Consecutive runs are merged as they arrive, so a fully visible
     * region collapses to a few draws and hidden roofs only split where they sit.
     */
    private static final class RangeList {
        private IntBuffer firsts = MemoryUtil.memAllocInt(4096);
        private IntBuffer counts = MemoryUtil.memAllocInt(4096);
        private int size;

        void clear() {
            size = 0;
        }

        void add(int first, int count) {
            if (size > 0) {
                int last = size - 1;
                if (firsts.get(last) + counts.get(last) == first) {
                    counts.put(last, counts.get(last) + count);
                    return;
                }
            }
            if (size == firsts.capacity()) {
                firsts = MemoryUtil.memRealloc(firsts, size * 2);
                counts = MemoryUtil.memRealloc(counts, size * 2);
            }
            firsts.put(size, first);
            counts.put(size, count);
            size++;
        }

        void draw(int vao) {
            if (size == 0) {
                return;
            }
            firsts.position(0).limit(size);
            counts.position(0).limit(size);
            glBindVertexArray(vao);
            glMultiDrawArrays(GL_TRIANGLES, firsts, counts);
            firsts.clear();
            counts.clear();
        }

        void free() {
            MemoryUtil.memFree(firsts);
            MemoryUtil.memFree(counts);
        }
    }
}
