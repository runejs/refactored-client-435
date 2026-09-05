package org.runejs.client.renderer.gpu;

import org.runejs.client.Landscape;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.def.UnderlayDefinition;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.Native;
import org.runejs.client.scene.tile.ComplexTile;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.util.PerlinNoise;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

/**
 * Ground-level terrain around the loaded region, decoded straight from the map files in the cache so that the
 * horizon does not end at the region's edge. It is what {@link Landscape} does for the region, ported to an area
 * of any size and to terrain alone: the same tile format, height defaults, underlay blending, lighting and tile
 * shapes, so the far ground matches the near ground where they meet. Objects are not placed out there, and only
 * the ground floor is drawn.
 *
 * Map files that the cache does not hold yet are requested from the update server and the build waits for them
 * a while, then goes ahead without whatever is still missing.
 */
final class ExtendedTerrain {
    private static final int REGION_TILES = 104;
    private static final int MAP_SQUARE_TILES = 64;
    private static final int PLANES = 4;
    private static final int BLEND_RADIUS = 5;
    private static final int HIDDEN_COLOUR = 12345678;
    private static final int TRANSPARENT_OVERLAY_COLOUR = 16711935;
    /**
     * Frames to wait for map files before building with the ones that have arrived.
     */
    private static final int MAX_WAIT_FRAMES = 500;

    private final int extentTiles;
    private final TerrainEmitter terrainEmitter;
    private final VertexStream stream = new VertexStream(1 << 18);
    private final int vbo;
    private final int vao;
    private int vertexCount;

    private int builtGeneration = Integer.MIN_VALUE;
    private int builtBaseX;
    private int builtBaseY;
    private boolean built;
    private int waitedFrames;
    private int[] squareX;
    private int[] squareY;
    private int[] squareGroup;

    /**
     * @param extentTiles how many tiles beyond each edge of the loaded region to draw
     */
    ExtendedTerrain(int extentTiles, TerrainEmitter terrainEmitter) {
        this.extentTiles = extentTiles;
        this.terrainEmitter = terrainEmitter;
        vbo = glGenBuffers();
        vao = VertexLayout.createVertexArray(vbo);
    }

    /**
     * Called every frame; rebuilds after a region change once the map files are in.
     */
    void update(int generation, int baseX, int baseY) {
        if (generation != builtGeneration || baseX != builtBaseX || baseY != builtBaseY) {
            builtGeneration = generation;
            builtBaseX = baseX;
            builtBaseY = baseY;
            built = false;
            waitedFrames = 0;
            vertexCount = 0;
            listSquares(baseX, baseY);
        }
        if (built) {
            return;
        }
        if (Landscape.loadGeneratedMap || CacheArchive.gameWorldMapCacheArchive == null) {
            built = true;
            return;
        }
        boolean allLoaded = true;
        for (int i = 0; i < squareGroup.length; i++) {
            if (squareGroup[i] >= 0 && !CacheArchive.gameWorldMapCacheArchive.loaded(squareGroup[i], 0)) {
                allLoaded = false;
            }
        }
        if (!allLoaded && ++waitedFrames < MAX_WAIT_FRAMES) {
            return;
        }
        build(baseX, baseY);
        built = true;
    }

    private void listSquares(int baseX, int baseY) {
        int firstX = Math.floorDiv(baseX - extentTiles, MAP_SQUARE_TILES);
        int lastX = Math.floorDiv(baseX + REGION_TILES + extentTiles - 1, MAP_SQUARE_TILES);
        int firstY = Math.floorDiv(baseY - extentTiles, MAP_SQUARE_TILES);
        int lastY = Math.floorDiv(baseY + REGION_TILES + extentTiles - 1, MAP_SQUARE_TILES);
        int count = (lastX - firstX + 1) * (lastY - firstY + 1);
        squareX = new int[count];
        squareY = new int[count];
        squareGroup = new int[count];
        int i = 0;
        for (int x = firstX; x <= lastX; x++) {
            for (int y = firstY; y <= lastY; y++) {
                squareX[i] = x;
                squareY[i] = y;
                squareGroup[i] = CacheArchive.gameWorldMapCacheArchive == null ? -1
                        : CacheArchive.gameWorldMapCacheArchive.getGroupIdByName(Native.MAP_NAME_PREFIX_M + x + Native.MAP_NAME_UNDERSCORE + y);
                i++;
            }
        }
    }

    /**
     * Decodes, lights and colours the whole extended area at ground level, then emits every tile that the region
     * itself does not draw: the region creates tiles for local coordinates 1 to 102, so its outer ring is drawn
     * here as well.
     */
    private void build(int baseX, int baseY) {
        int origin = -extentTiles;
        int size = REGION_TILES + 2 * extentTiles;
        int[][] heights = new int[size + 1][size + 1];
        byte[][] underlays = new byte[size][size];
        byte[][] overlays = new byte[size][size];
        byte[][] shapes = new byte[size][size];
        byte[][] rotations = new byte[size][size];
        boolean[][] present = new boolean[size + 1][size + 1];

        int loadedSquares = 0;
        for (int i = 0; i < squareGroup.length; i++) {
            byte[] data = squareGroup[i] < 0 ? null : CacheArchive.gameWorldMapCacheArchive.getFile(squareGroup[i], 0);
            if (data == null) {
                continue;
            }
            loadedSquares++;
            decodeSquare(new Buffer(data), squareX[i] * MAP_SQUARE_TILES - baseX - origin, squareY[i] * MAP_SQUARE_TILES - baseY - origin,
                    squareX[i] * MAP_SQUARE_TILES, squareY[i] * MAP_SQUARE_TILES, size, heights, underlays, overlays, shapes, rotations, present);
        }

        int[][] light = computeLight(heights, size);
        stream.clear();
        emitTiles(size, origin, heights, underlays, overlays, shapes, rotations, present, light);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, stream.upload(), GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        vertexCount = stream.vertexCount();
        System.out.println("GPU renderer: terrain beyond the region, " + loadedSquares + " of " + squareGroup.length + " map squares, "
                + vertexCount / 3 + " triangles");
    }

    /**
     * {@code Landscape.method922} for one map square: the tile stream covers all four planes in order, so every
     * plane is parsed even though only the ground floor is kept.
     */
    private static void decodeSquare(Buffer buffer, int offsetX, int offsetY, int absoluteX, int absoluteY, int size,
                                     int[][] heights, byte[][] underlays, byte[][] overlays, byte[][] shapes, byte[][] rotations, boolean[][] present) {
        for (int plane = 0; plane < PLANES; plane++) {
            for (int tileX = 0; tileX < MAP_SQUARE_TILES; tileX++) {
                for (int tileY = 0; tileY < MAP_SQUARE_TILES; tileY++) {
                    int x = offsetX + tileX;
                    int y = offsetY + tileY;
                    boolean keep = plane == 0 && x >= 0 && x < size && y >= 0 && y < size;
                    if (keep) {
                        present[x][y] = true;
                    }
                    for (; ; ) {
                        int opcode = buffer.getUnsignedByte();
                        if (opcode == 0) {
                            if (keep) {
                                heights[x][y] = -perlinHeight(absoluteX + tileX + 932731, absoluteY + tileY + 556238) * 8;
                            }
                            break;
                        }
                        if (opcode == 1) {
                            int height = buffer.getUnsignedByte();
                            if (keep) {
                                if (height == 1) {
                                    height = 0;
                                }
                                heights[x][y] = -8 * height;
                            }
                            break;
                        }
                        if (opcode <= 49) {
                            byte overlay = buffer.getByte();
                            if (keep) {
                                overlays[x][y] = overlay;
                                shapes[x][y] = (byte) ((opcode - 2) / 4);
                                rotations[x][y] = (byte) (opcode - 2 & 0x3);
                            }
                        } else if (opcode > 81 && keep) {
                            underlays[x][y] = (byte) (opcode - 81);
                        }
                    }
                }
            }
        }
    }

    /**
     * {@code Landscape.getPerlinVertexHeight}: the default height of a tile the map file says nothing about.
     */
    private static int perlinHeight(int x, int y) {
        int height = -128 + PerlinNoise.get(x + 45365, 91923 + y, 4) - (-(PerlinNoise.get(x + 10294, 37821 + y, 2) - 128 >> 1) + -(-128 + PerlinNoise.get(x, y, 1) >> 2));
        height = 35 + (int) (0.3 * (double) height);
        if (height >= 10) {
            if (height > 60) {
                height = 60;
            }
        } else {
            height = 10;
        }
        return height;
    }

    /**
     * The directional light of {@code Landscape.createRegion}. There are no objects out here, so there is no
     * object shadow to subtract.
     */
    private static int[][] computeLight(int[][] heights, int size) {
        int[][] light = new int[size + 1][size + 1];
        int directionalLightLength = (int) Math.sqrt(5100.0);
        int specularDistribution = directionalLightLength * 768 >> 8;
        for (int y = 1; y < size - 1; y++) {
            for (int x = 1; x < size - 1; x++) {
                int heightDifferenceX = -heights[x - 1][y] + heights[x + 1][y];
                int heightDifferenceY = heights[x][y + 1] - heights[x][y - 1];
                int normalisedLength = (int) Math.sqrt(heightDifferenceY * heightDifferenceY + heightDifferenceX * heightDifferenceX + 65536);
                int normalisedZ = 65536 / normalisedLength;
                int normalisedX = (heightDifferenceX << 8) / normalisedLength;
                int normalisedY = (heightDifferenceY << 8) / normalisedLength;
                light[x][y] = 96 + (normalisedX * -50 + -10 * normalisedZ + normalisedY * -50) / specularDistribution;
            }
        }
        return light;
    }

    /**
     * The underlay blending and tile creation of {@code Landscape.createRegion}, for the ground floor of the
     * extended area. Underlay colours are a box blur of radius {@link #BLEND_RADIUS} over neighbouring tiles,
     * accumulated column by column as the region code does.
     */
    private void emitTiles(int size, int origin, int[][] heights, byte[][] underlays, byte[][] overlays, byte[][] shapes, byte[][] rotations,
                           boolean[][] present, int[][] light) {
        int[] blendedHue = new int[size];
        int[] blendedSaturation = new int[size];
        int[] blendedLightness = new int[size];
        int[] blendedHueMultiplier = new int[size];
        int[] blendCount = new int[size];
        for (int x = -BLEND_RADIUS; x < size + BLEND_RADIUS; x++) {
            for (int y = 0; y < size; y++) {
                int enteringX = x + BLEND_RADIUS;
                if (enteringX >= 0 && enteringX < size) {
                    int underlayId = underlays[enteringX][y] & 0xff;
                    if (underlayId > 0) {
                        UnderlayDefinition underlay = UnderlayDefinition.getDefinition(underlayId - 1);
                        blendedHue[y] += underlay.hue;
                        blendedSaturation[y] += underlay.saturation;
                        blendedLightness[y] += underlay.lightness;
                        blendedHueMultiplier[y] += underlay.hueMultiplier;
                        blendCount[y]++;
                    }
                }
                int leavingX = x - BLEND_RADIUS;
                if (leavingX >= 0 && leavingX < size) {
                    int underlayId = underlays[leavingX][y] & 0xff;
                    if (underlayId > 0) {
                        UnderlayDefinition underlay = UnderlayDefinition.getDefinition(underlayId - 1);
                        blendedHue[y] -= underlay.hue;
                        blendedSaturation[y] -= underlay.saturation;
                        blendedLightness[y] -= underlay.lightness;
                        blendedHueMultiplier[y] -= underlay.hueMultiplier;
                        blendCount[y]--;
                    }
                }
            }
            if (x < 1 || x >= size - 1) {
                continue;
            }
            int hue = 0;
            int saturation = 0;
            int lightness = 0;
            int count = 0;
            int hueMultiplier = 0;
            for (int y = -BLEND_RADIUS; y < size + BLEND_RADIUS; y++) {
                int enteringY = y + BLEND_RADIUS;
                int leavingY = y - BLEND_RADIUS;
                if (enteringY >= 0 && enteringY < size) {
                    hueMultiplier += blendedHueMultiplier[enteringY];
                    saturation += blendedSaturation[enteringY];
                    count += blendCount[enteringY];
                    lightness += blendedLightness[enteringY];
                    hue += blendedHue[enteringY];
                }
                if (leavingY >= 0 && leavingY < size) {
                    saturation -= blendedSaturation[leavingY];
                    count -= blendCount[leavingY];
                    lightness -= blendedLightness[leavingY];
                    hueMultiplier -= blendedHueMultiplier[leavingY];
                    hue -= blendedHue[leavingY];
                }
                if (y < 1 || y >= size - 1) {
                    continue;
                }
                int localX = x + origin;
                int localY = y + origin;
                if (localX >= 1 && localX <= REGION_TILES - 2 && localY >= 1 && localY <= REGION_TILES - 2) {
                    continue;
                }
                if (!present[x][y] || !present[x + 1][y] || !present[x][y + 1] || !present[x + 1][y + 1]) {
                    continue;
                }
                int underlayId = underlays[x][y] & 0xff;
                int overlayId = overlays[x][y] & 0xff;
                if (underlayId == 0 && overlayId == 0) {
                    continue;
                }
                int hSW = heights[x][y];
                int hSE = heights[x + 1][y];
                int hNE = heights[x + 1][y + 1];
                int hNW = heights[x][y + 1];
                int lSW = light[x][y];
                int lSE = light[x + 1][y];
                int lNE = light[x + 1][y + 1];
                int lNW = light[x][y + 1];
                int underlayHsl = -1;
                if (underlayId > 0 && hueMultiplier != 0 && count != 0) {
                    underlayHsl = generateHslBitset(saturation / count, lightness / count, 256 * hue / hueMultiplier);
                }
                if (overlayId == 0) {
                    GenericTile tile = new GenericTile(mixLightness(underlayHsl, lSW), mixLightness(underlayHsl, lSE),
                            mixLightness(underlayHsl, lNW), mixLightness(underlayHsl, lNE), -1, 0, false);
                    terrainEmitter.plainTile(stream, tile, localX, localY, hSW, hSE, hNE, hNW);
                    continue;
                }
                int shape = 1 + shapes[x][y];
                int rotation = rotations[x][y];
                OverlayDefinition overlay = OverlayDefinition.getDefinition(overlayId - 1, 4);
                int texture = overlay.texture;
                int overlayHsl;
                if (texture >= 0) {
                    overlayHsl = -1;
                } else if (overlay.color == TRANSPARENT_OVERLAY_COLOUR) {
                    overlayHsl = -2;
                    texture = -1;
                } else {
                    overlayHsl = generateHslBitset(overlay.lightness, overlay.saturation, overlay.hue);
                }
                int uSW = mixLightness(underlayHsl, lSW);
                int uSE = mixLightness(underlayHsl, lSE);
                int uNE = mixLightness(underlayHsl, lNE);
                int uNW = mixLightness(underlayHsl, lNW);
                int oSW = MovedStatics.mixLightnessSigned(overlayHsl, lSW);
                int oSE = MovedStatics.mixLightnessSigned(overlayHsl, lSE);
                int oNE = MovedStatics.mixLightnessSigned(overlayHsl, lNE);
                int oNW = MovedStatics.mixLightnessSigned(overlayHsl, lNW);
                if (shape == 1) {
                    boolean flat = hSW == hSE && hSW == hNE && hSW == hNW;
                    GenericTile tile = new GenericTile(oSW, oSE, oNW, oNE, texture, 0, flat);
                    terrainEmitter.plainTile(stream, tile, localX, localY, hSW, hSE, hNE, hNW);
                } else {
                    ComplexTile tile = new ComplexTile(localX, hSW, hSE, hNW, hNE, localY, rotation, texture, shape,
                            uSW, oSW, uSE, oSE, uNE, oNE, uNW, oNW, 0, 0);
                    terrainEmitter.shapedTile(stream, tile, localX, localY);
                }
            }
        }
    }

    /**
     * {@code Landscape.generateHslBitset}.
     */
    private static int generateHslBitset(int s, int l, int h) {
        if (l > 179) {
            s /= 2;
        }
        if (l > 192) {
            s /= 2;
        }
        if (l > 217) {
            s /= 2;
        }
        if (l > 243) {
            s /= 2;
        }
        return l / 2 + (s / 32 << 7) + (h / 4 << 10);
    }

    /**
     * {@code Landscape.mixLightness}: an underlay colour lit for one corner, or the hidden marker when there is
     * no underlay.
     */
    private static int mixLightness(int hsl, int lightness) {
        if (hsl == -1) {
            return HIDDEN_COLOUR;
        }
        lightness = (0x7f & hsl) * lightness / 128;
        if (lightness < 2) {
            lightness = 2;
        } else if (lightness > 126) {
            lightness = 126;
        }
        return lightness + (hsl & 0xff80);
    }

    void draw() {
        if (vertexCount == 0) {
            return;
        }
        glBindVertexArray(vao);
        glDrawArrays(GL_TRIANGLES, 0, vertexCount);
        glBindVertexArray(0);
    }

    void delete() {
        glDeleteBuffers(vbo);
        stream.free();
    }
}
