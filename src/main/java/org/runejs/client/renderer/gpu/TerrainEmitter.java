package org.runejs.client.renderer.gpu;

import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.tile.ComplexTile;
import org.runejs.client.scene.tile.GenericTile;

/**
 * Turns the client's terrain tiles into triangles: the same two triangles as {@code SceneRenderer.renderPlainTile}
 * and the same fan as {@code renderShapedTile}, in the same vertex order and with the same colours. Tile
 * coordinates are the scene's local tile coordinates, which may lie outside the loaded region for terrain drawn
 * beyond it.
 */
final class TerrainEmitter {
    private static final int HIDDEN_COLOUR = 12345678;

    private final ModelEmitter emitter;

    TerrainEmitter(ModelEmitter emitter) {
        this.emitter = emitter;
    }

    /**
     * @param hSW height of the south-west corner, and so on; heights are negative upwards like everywhere else
     */
    void plainTile(VertexStream out, GenericTile tile, int tileX, int tileY, int hSW, int hSE, int hNE, int hNW) {
        int x0 = tileX << 7;
        int x1 = x0 + 128;
        int y0 = tileY << 7;
        int y1 = y0 + 128;
        int[] hsl2rgb = Rasterizer3D.hsl2rgb;
        if (tile.texture == -1) {
            if (tile.colourNE != HIDDEN_COLOUR) {
                out.put(x1, hNE, y1, opaqueColour(hsl2rgb[tile.colourNE & 0xffff]), 0f, 0f, -1);
                out.put(x0, hNW, y1, opaqueColour(hsl2rgb[tile.colourNW & 0xffff]), 0f, 0f, -1);
                out.put(x1, hSE, y0, opaqueColour(hsl2rgb[tile.colourSE & 0xffff]), 0f, 0f, -1);
            }
            if (tile.colourSW != HIDDEN_COLOUR) {
                out.put(x0, hSW, y0, opaqueColour(hsl2rgb[tile.colourSW & 0xffff]), 0f, 0f, -1);
                out.put(x1, hSE, y0, opaqueColour(hsl2rgb[tile.colourSE & 0xffff]), 0f, 0f, -1);
                out.put(x0, hNW, y1, opaqueColour(hsl2rgb[tile.colourNW & 0xffff]), 0f, 0f, -1);
            }
        } else if (Scene.lowMemory) {
            int average = Rasterizer3D.interface3.getAverageTextureColour(tile.texture);
            out.put(x1, hNE, y1, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.colourNE) & 0xffff]), 0f, 0f, -1);
            out.put(x0, hNW, y1, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.colourNW) & 0xffff]), 0f, 0f, -1);
            out.put(x1, hSE, y0, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.colourSE) & 0xffff]), 0f, 0f, -1);
            out.put(x0, hSW, y0, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.colourSW) & 0xffff]), 0f, 0f, -1);
            out.put(x1, hSE, y0, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.colourSE) & 0xffff]), 0f, 0f, -1);
            out.put(x0, hNW, y1, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.colourNW) & 0xffff]), 0f, 0f, -1);
        } else {
            int texture = tile.texture;
            emitter.markTexture(texture);
            out.put(x1, hNE, y1, shadeColour(tile.colourNE), 1f, 1f, texture);
            out.put(x0, hNW, y1, shadeColour(tile.colourNW), 0f, 1f, texture);
            out.put(x1, hSE, y0, shadeColour(tile.colourSE), 1f, 0f, texture);
            out.put(x0, hSW, y0, shadeColour(tile.colourSW), 0f, 0f, texture);
            out.put(x1, hSE, y0, shadeColour(tile.colourSE), 1f, 0f, texture);
            out.put(x0, hNW, y1, shadeColour(tile.colourNW), 0f, 1f, texture);
        }
    }

    /**
     * Textures are mapped over the tile rather than per triangle; on a flat tile that is what the software path
     * does as well.
     */
    void shapedTile(VertexStream out, ComplexTile tile, int tileX, int tileY) {
        int[] hsl2rgb = Rasterizer3D.hsl2rgb;
        int originX = tileX << 7;
        int originY = tileY << 7;
        int triangleCount = tile.triangleA.length;
        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int a = tile.triangleA[triangle];
            int b = tile.triangleB[triangle];
            int c = tile.triangleC[triangle];
            int texture = tile.triangleTexture == null ? -1 : tile.triangleTexture[triangle];
            if (texture == -1) {
                if (tile.triangleHSLA[triangle] == HIDDEN_COLOUR) {
                    continue;
                }
                shapedVertex(out, tile, a, opaqueColour(hsl2rgb[tile.triangleHSLA[triangle] & 0xffff]), 0, 0, -1);
                shapedVertex(out, tile, b, opaqueColour(hsl2rgb[tile.triangleHSLB[triangle] & 0xffff]), 0, 0, -1);
                shapedVertex(out, tile, c, opaqueColour(hsl2rgb[tile.triangleHSLC[triangle] & 0xffff]), 0, 0, -1);
            } else if (Scene.lowMemory) {
                int average = Rasterizer3D.interface3.getAverageTextureColour(texture);
                shapedVertex(out, tile, a, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.triangleHSLA[triangle]) & 0xffff]), 0, 0, -1);
                shapedVertex(out, tile, b, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.triangleHSLB[triangle]) & 0xffff]), 0, 0, -1);
                shapedVertex(out, tile, c, opaqueColour(hsl2rgb[Scene.adjustLightness(average, tile.triangleHSLC[triangle]) & 0xffff]), 0, 0, -1);
            } else {
                emitter.markTexture(texture);
                shapedVertex(out, tile, a, shadeColour(tile.triangleHSLA[triangle]), originX, originY, texture);
                shapedVertex(out, tile, b, shadeColour(tile.triangleHSLB[triangle]), originX, originY, texture);
                shapedVertex(out, tile, c, shadeColour(tile.triangleHSLC[triangle]), originX, originY, texture);
            }
        }
    }

    private static void shapedVertex(VertexStream out, ComplexTile tile, int vertex, int colour, int originX, int originY, int texture) {
        int x = tile.originalVertexX[vertex];
        int height = tile.originalVertexY[vertex];
        int north = tile.originalVertexZ[vertex];
        out.put(x, height, north, colour, (x - originX) / 128f, (north - originY) / 128f, texture);
    }

    private static int opaqueColour(int rgb) {
        return 0xff000000 | (rgb & 0xffffff);
    }

    private static int shadeColour(int shade) {
        return 0xff000000 | ((shade & 0xff) << 16);
    }
}
