package org.runejs.client.scene;

import org.runejs.client.Landscape;
import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.frame.Minimap;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.scene.camera.Camera;
import org.runejs.client.scene.camera.CameraRotation;
import org.runejs.client.scene.tile.*;

import java.util.Arrays;

public class Scene {
    public static int[] WALL_DECORATION_INSET_X = new int[]{53, -53, -53, 53};
    public static int[] WALL_DECORATION_INSET_Y = new int[]{-53, -53, 53, 53};
    public static int[] WALL_DECORATION_OUTSET_X = new int[]{-45, 45, 45, -45};
    public static int[] WALL_DECORATION_OUTSET_Y = new int[]{45, 45, -45, -45};

    public static int[] ROTATION_WALL_TYPE = {1, 2, 4, 8};
    public static int[] ROTATION_WALL_CORNER_TYPE = new int[]{16, 32, 64, 128};
    public static int[] FRONT_WALL_TYPES = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
    public static int[] DIRECTION_ALLOW_WALL_CORNER_TYPE = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
    public static int[] BACK_WALL_TYPES = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
    public static int[] WALL_CORNER_TYPE_16_BLOCK_OBJ_SPANS = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
    public static int[] WALL_CORNER_TYPE_32_BLOCK_OBJ_SPANS = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
    public static int[] WALL_CORNER_TYPE_64_BLOCK_OBJ_SPANS = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
    public static int[] WALL_CORNER_TYPE_128_BLOCK_OBJ_SPANS = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};


    private static final int TILE_DRAW_DISTANCE = 75;


    public static boolean lowMemory = true;
    public static int cycle;
    public static InteractiveObject[] interactiveObjects = new InteractiveObject[100];
    public static LinkedList tileList = new LinkedList();
    public static int anInt109 = 0;

    public SceneTile[][][] tileArray;
    public int[][][] tileOcclusionCycles;
    public int sceneSpawnRequestsCacheCurrentPos = 0;
    public InteractiveObject[] sceneSpawnRequestsCache = new InteractiveObject[5000];
    public int plane = 0;
    public int[][][] heightMap;
    public int mergeIndexTmp = 0;
    public int[] mergeIndexA = new int[10000];
    public int[] mergeIndexB = new int[10000];

    private int[] screenX = new int[6];
    private int[] screenY = new int[6];
    private int[] viewspaceX = new int[6];
    private int[] viewspaceZ = new int[6];
    private int[] viewspaceY = new int[6];

    private boolean clicked = false;
    private int clickX = 0;
    private int clickY = 0;

    /**
     * Clicked tile X coordinate
     */
    public int clickedTileX = -1;
    /**
     * Clicked tile Y coordinate
     */
    public int clickedTileY = -1;

    /**
     * Currently hovered tile X coordinate
     */
    public int hoveredTileX = -1;
    /**
     * Currently hovered tile Y coordinate
     */
    public int hoveredTileY = -1;

    private int drawFromTileX;
    private int drawFromTileY;

    private int drawToTileX;
    private int drawToTileY;

    public int mapSizeX = 104;
    public int mapSizeY = 104;
    public int mapSizeZ = 4;

    private int activeOccluderCount = 0;
    private SceneCluster[][] cullingClusters = new SceneCluster[mapSizeZ][500];
    private SceneCluster[] processedCullingClusters = new SceneCluster[500];
    private int[] cullingClusterPointer = new int[mapSizeZ];
    private boolean[][] currentTileVisibilityMap;
    private int currentCameraY;
    private int currentCameraTileY;
    private int currentCameraX;
    private int currentCameraTileX;
    private int currentCameraZ;

    private Camera currentCamera;
    private CameraRotation currentCameraRotation;
    private CameraTileVisibility tileVisibilityInfo;

    public Scene(int[][][] heightMap) {
        tileArray = new SceneTile[mapSizeZ][mapSizeX][mapSizeY];
        tileOcclusionCycles = new int[mapSizeZ][mapSizeX + 1][mapSizeY + 1];
        this.heightMap = heightMap;
        initToNull();
    }

    public void precalculateTileVisibility(int viewportWidth, int viewportHeight, int minHeight, int maxHeight, int[] heightsForPitch) {
        tileVisibilityInfo = new CameraTileVisibility(viewportWidth, viewportHeight, TILE_DRAW_DISTANCE, minHeight, maxHeight, heightsForPitch);
    }

    public static int adjustLightness(int hsl, int lightness) {
        lightness = (127 - lightness) * (hsl & 0x7f) >> 7;
        if (lightness < 2) {
            lightness = 2;
        } else if (lightness > 126) {
            lightness = 126;
        }
        return (hsl & 0xff80) + lightness;
    }


    public void createOccluder(int z, int searchMask, int lowestX, int highestX, int lowestY, int highestY, int highestZ, int lowestZ) {
        SceneCluster sceneCluster = new SceneCluster();
        sceneCluster.tileStartX = lowestX / 128;
        sceneCluster.tileEndX = highestX / 128;
        sceneCluster.tileStartY = lowestY / 128;
        sceneCluster.tileEndY = highestY / 128;
        sceneCluster.searchMask = searchMask;
        sceneCluster.worldStartX = lowestX;
        sceneCluster.worldEndX = highestX;
        sceneCluster.worldStartY = lowestY;
        sceneCluster.worldEndY = highestY;
        sceneCluster.worldEndZ = highestZ;
        sceneCluster.worldStartZ = lowestZ;
        cullingClusters[z][cullingClusterPointer[z]++] = sceneCluster;
    }

    public int getWallDecorationHash(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile == null || sceneTile.wallDecoration == null) {
            return 0;
        }
        return sceneTile.wallDecoration.hash;
    }

    public void setTileBridge(int x, int y) {
        // Get the initial base tile at the specified coordinates
        SceneTile baseTile = tileArray[0][x][y];

        // Shift each tile down by one level
        for (int plane = 0; plane < 3; plane++) {
            SceneTile currentTile = tileArray[plane][x][y] = tileArray[plane + 1][x][y];
            if (currentTile != null) {
                // Decrement the plane index of the tile
                currentTile.anInt2066--;

                // Shift down interactive objects within the tile that are on the same (x, y)
                for (int i = 0; i < currentTile.entityCount; i++) {
                    InteractiveObject interactiveObject = currentTile.interactiveObjects[i];
                    if ((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == x && interactiveObject.tileTop == y) {
                        interactiveObject.z--;
                    }
                }
            }
        }

        // If the base level is now null, create a new SceneTile at that position
        if (tileArray[0][x][y] == null) {
            tileArray[0][x][y] = new SceneTile(0, x, y);
        }

        // The base tile now becomes a "bridge" to the original base tile
        tileArray[0][x][y].aSceneTile_2058 = baseTile;

        // The top level is set to null since we've moved all the tiles down
        tileArray[3][x][y] = null;
    }

    public int getFloorDecorationHash(int z, int x, int y) {
        SceneTile sceneTile = tileArray[z][x][y];
        if (sceneTile == null || sceneTile.floorDecoration == null) {
            return 0;
        }
        return sceneTile.floorDecoration.hash;
    }

    public void addWall(int x, int y, int z, int drawHeight, int orientation, int orientation2, int hash, Renderable primary, Renderable secondary, int config) {
        if (primary != null || secondary != null) {
            Wall wall = new Wall();
            wall.hash = hash;
            wall.config = config;
            wall.x = x * 128 + 64;
            wall.y = y * 128 + 64;
            wall.z = drawHeight;
            wall.primary = primary;
            wall.secondary = secondary;
            wall.orientationA = orientation;
            wall.orientationB = orientation2;
            for (int _z = z; _z >= 0; _z--) {
                if (tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[z][x][y].wall = wall;
        }
    }

    public void drawMinimapTile(int[] destPixels, int offset, int step, int plane, int tileX, int tileY) {
        SceneTile sceneTile = tileArray[plane][tileX][tileY];
        if (sceneTile != null) {
            GenericTile genericTile = sceneTile.plainTile;
            if (genericTile == null) {
                ComplexTile complexTile = sceneTile.shapedTile;
                if (complexTile != null) {
                    int shape = complexTile.shape;
                    int rotation = complexTile.rotation;
                    int underlayColor = complexTile.underlayRGB;
                    int overlayColor = complexTile.overlayRGB;
                    int[] is = Minimap.anIntArrayArray129[shape];
                    int[] is_19_ = Minimap.anIntArrayArray121[rotation];
                    int pointer = 0;
                    if (underlayColor == 0) {
                        for (int i_22_ = 0; i_22_ < 4; i_22_++) {
                            if (is[is_19_[pointer++]] != 0) {
                                destPixels[offset] = overlayColor;
                            }
                            if (is[is_19_[pointer++]] != 0) {
                                destPixels[offset + 1] = overlayColor;
                            }
                            if (is[is_19_[pointer++]] != 0) {
                                destPixels[offset + 2] = overlayColor;
                            }
                            if (is[is_19_[pointer++]] != 0) {
                                destPixels[offset + 3] = overlayColor;
                            }
                            offset += step;
                        }
                    } else {
                        for (int i = 0; i < 4; i++) {
                            destPixels[offset] = is[is_19_[pointer++]] == 0 ? underlayColor : overlayColor;
                            destPixels[offset + 1] = is[is_19_[pointer++]] == 0 ? underlayColor : overlayColor;
                            destPixels[offset + 2] = is[is_19_[pointer++]] == 0 ? underlayColor : overlayColor;
                            destPixels[offset + 3] = is[is_19_[pointer++]] == 0 ? underlayColor : overlayColor;
                            offset += step;
                        }
                    }
                }
            } else {
                int color = genericTile.rgbColor;
                if (color != 0) {
                    for (int i = 0; i < 4; i++) {
                        destPixels[offset] = color;
                        destPixels[offset + 1] = color;
                        destPixels[offset + 2] = color;
                        destPixels[offset + 3] = color;
                        offset += step;
                    }
                }
            }
        }
    }

    public void render(Camera camera, int plane) {
        Point3d cameraPos = camera.getPosition();
        CameraRotation cameraRotation = camera.getRotation();

        currentCamera = camera;
        currentCameraRotation = cameraRotation;

        int cameraPosX = cameraPos.x;
        int cameraPosY = cameraPos.y;
        int cameraPosZ = cameraPos.z;
        int yaw = cameraRotation.yaw;
        int pitch = cameraRotation.pitch;

        // keep the camera within bounds
        if (cameraPosX < 0) {
            cameraPosX = 0;
        } else if (cameraPosX >= mapSizeX * 128) {
            cameraPosX = mapSizeX * 128 - 1;
        }
        if (cameraPosY < 0) {
            cameraPosY = 0;
        } else if (cameraPosY >= mapSizeY * 128) {
            cameraPosY = mapSizeY * 128 - 1;
        }

        cycle++;
        currentTileVisibilityMap = tileVisibilityInfo.visibilityInfo[(pitch - 128) / 32][yaw / 64];
        currentCameraX = cameraPosX;
        currentCameraZ = cameraPosZ;
        currentCameraY = cameraPosY;
        currentCameraTileX = cameraPosX / 128;
        currentCameraTileY = cameraPosY / 128;
        drawFromTileX = currentCameraTileX - TILE_DRAW_DISTANCE;
        if (drawFromTileX < 0) {
            drawFromTileX = 0;
        }
        drawFromTileY = currentCameraTileY - TILE_DRAW_DISTANCE;
        if (drawFromTileY < 0) {
            drawFromTileY = 0;
        }
        drawToTileX = currentCameraTileX + TILE_DRAW_DISTANCE;
        if (drawToTileX > mapSizeX) {
            drawToTileX = mapSizeX;
        }
        drawToTileY = currentCameraTileY + TILE_DRAW_DISTANCE;
        if (drawToTileY > mapSizeY) {
            drawToTileY = mapSizeY;
        }
        processCulling(plane);
        anInt109 = 0;
        for (int z = this.plane; z < mapSizeZ; z++) {
            SceneTile[][] sceneTiles = tileArray[z];
            for (int x = drawFromTileX; x < drawToTileX; x++) {
                for (int y = drawFromTileY; y < drawToTileY; y++) {
                    SceneTile sceneTile = sceneTiles[x][y];
                    if (sceneTile != null) {
                        if (sceneTile.drawLevel > plane || !currentTileVisibilityMap[x - currentCameraTileX + TILE_DRAW_DISTANCE][y - currentCameraTileY + TILE_DRAW_DISTANCE] && heightMap[z][x][y] - cameraPosZ < 70000) {
                            sceneTile.draw = false;
                            sceneTile.visible = false;
                            sceneTile.wallCullDirection = 0;
                        } else {
                            sceneTile.draw = true;
                            sceneTile.visible = true;
                            sceneTile.drawEntities = sceneTile.entityCount > 0;
                            anInt109++;
                        }
                    }
                }
            }
        }
        for (int i = this.plane; i < mapSizeZ; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for (int i_25_ = -TILE_DRAW_DISTANCE; i_25_ <= 0; i_25_++) {
                int i_26_ = currentCameraTileX + i_25_;
                int i_27_ = currentCameraTileX - i_25_;
                if (i_26_ >= drawFromTileX || i_27_ < drawToTileX) {
                    for (int i_28_ = -TILE_DRAW_DISTANCE; i_28_ <= 0; i_28_++) {
                        int i_29_ = currentCameraTileY + i_28_;
                        int i_30_ = currentCameraTileY - i_28_;
                        if (i_26_ >= drawFromTileX) {
                            if (i_29_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_29_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                            if (i_30_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_30_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                        }
                        if (i_27_ < drawToTileX) {
                            if (i_29_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_29_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                            if (i_30_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_30_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                        }
                        if (anInt109 == 0) {
                            clicked = false;
                            return;
                        }
                    }
                }
            }
        }
        for (int i = this.plane; i < mapSizeZ; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for (int i_31_ = -TILE_DRAW_DISTANCE; i_31_ <= 0; i_31_++) {
                int i_32_ = currentCameraTileX + i_31_;
                int i_33_ = currentCameraTileX - i_31_;
                if (i_32_ >= drawFromTileX || i_33_ < drawToTileX) {
                    for (int i_34_ = -TILE_DRAW_DISTANCE; i_34_ <= 0; i_34_++) {
                        int i_35_ = currentCameraTileY + i_34_;
                        int i_36_ = currentCameraTileY - i_34_;
                        if (i_32_ >= drawFromTileX) {
                            if (i_35_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_35_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                            if (i_36_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_36_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                        }
                        if (i_33_ < drawToTileX) {
                            if (i_35_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_35_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                            if (i_36_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_36_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                        }
                        if (anInt109 == 0) {
                            clicked = false;
                            return;
                        }
                    }
                }
            }
        }
        clicked = false;
    }

    public void initToNull() {
        for (int z = 0; z < mapSizeZ; z++) {
            for (int x = 0; x < mapSizeX; x++) {
                for (int y = 0; y < mapSizeY; y++) {
                    tileArray[z][x][y] = null;
                }
            }
        }
        for (int i = 0; i < mapSizeZ; i++) {
            for (int i_39_ = 0; i_39_ < cullingClusterPointer[i]; i_39_++) {
                cullingClusters[i][i_39_] = null;
            }
            cullingClusterPointer[i] = 0;
        }
        for (int i = 0; i < sceneSpawnRequestsCacheCurrentPos; i++) {
            sceneSpawnRequestsCache[i] = null;
        }
        sceneSpawnRequestsCacheCurrentPos = 0;
        Arrays.fill(interactiveObjects, null);
    }

    public void addTile(int plane, int x, int y, int shape, int clippingPathRotation, int textureId, int vertexHeightSW, int vertexHeightSE, int vertexHeightNE, int vertexHeightNW, int overlayColourA, int overlayColourB, int overlayColourD, int overlayColourC, int underlayColourA, int underlayColourB, int underlayColourD, int underlayColourC, int underlayRGB, int overlayRGB) {
        if (shape == 0) {
            GenericTile genericTile = new GenericTile(overlayColourA, overlayColourB, overlayColourC, overlayColourD, -1, underlayRGB, false);
            for (int _z = plane; _z >= 0; _z--) {
                if (tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[plane][x][y].plainTile = genericTile;
        } else if (shape == 1) {
            GenericTile genericTile = new GenericTile(underlayColourA, underlayColourB, underlayColourC, underlayColourD, textureId, overlayRGB, vertexHeightSW == vertexHeightSE && vertexHeightSW == vertexHeightNE && vertexHeightSW == vertexHeightNW);
            for (int _z = plane; _z >= 0; _z--) {
                if (tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[plane][x][y].plainTile = genericTile;
        } else {
            ComplexTile complexTile = new ComplexTile(x, vertexHeightSW, vertexHeightSE, vertexHeightNW, vertexHeightNE, y, clippingPathRotation, textureId, shape, overlayColourA, underlayColourA, overlayColourB, underlayColourB, overlayColourD, underlayColourD, overlayColourC, underlayColourC, overlayRGB, underlayRGB);
            for (int _z = plane; _z >= 0; _z--) {
                if (tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[plane][x][y].shapedTile = complexTile;
        }
    }

    public WallDecoration getWallDecoration(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if (sceneTile == null) {
            return null;
        }
        return sceneTile.wallDecoration;
    }

    public boolean isTileOccluded(int x, int y, int z) {
        int i = tileOcclusionCycles[z][x][y];
        if (i == -cycle) {
            return false;
        }
        if (i == cycle) {
            return true;
        }
        int worldX = x << 7;
        int worldY = y << 7;
        if (isPointOccluded(worldX + 1, heightMap[z][x][y], worldY + 1) && isPointOccluded(worldX + 128 - 1, heightMap[z][x + 1][y], worldY + 1) && isPointOccluded(worldX + 128 - 1, heightMap[z][x + 1][y + 1], worldY + 128 - 1) && isPointOccluded(worldX + 1, heightMap[z][x][y + 1], worldY + 128 - 1)) {
            tileOcclusionCycles[z][x][y] = cycle;
            return true;
        }
        tileOcclusionCycles[z][x][y] = -cycle;
        return false;
    }

    public boolean isWallOccluded(int level, int x, int y, int wallType) {
        if (!isTileOccluded(x, y, level)) {
            return false;
        }
        int posX = x << 7;
        int posY = y << 7;
        int posZ = heightMap[level][x][y] - 1;
        int z1 = posZ - 120;
        int z2 = posZ - 230;
        int z3 = posZ - 238;
        if (wallType < 16) {
            if (wallType == 1) {
                if (posX > currentCameraX) {
                    if (!isPointOccluded(posX, posZ, posY)) {
                        return false;
                    }
                    if (!isPointOccluded(posX, posZ, posY + 128)) {
                        return false;
                    }
                }
                if (level > 0) {
                    if (!isPointOccluded(posX, z1, posY)) {
                        return false;
                    }
                    if (!isPointOccluded(posX, z1, posY + 128)) {
                        return false;
                    }
                }
                if (!isPointOccluded(posX, z2, posY)) {
                    return false;
                }
                return isPointOccluded(posX, z2, posY + 128);
            }
            if (wallType == 2) {
                if (posY < currentCameraY) {
                    if (!isPointOccluded(posX, posZ, posY + 128)) {
                        return false;
                    }
                    if (!isPointOccluded(posX + 128, posZ, posY + 128)) {
                        return false;
                    }
                }
                if (level > 0) {
                    if (!isPointOccluded(posX, z1, posY + 128)) {
                        return false;
                    }
                    if (!isPointOccluded(posX + 128, z1, posY + 128)) {
                        return false;
                    }
                }
                if (!isPointOccluded(posX, z2, posY + 128)) {
                    return false;
                }
                return isPointOccluded(posX + 128, z2, posY + 128);
            }
            if (wallType == 4) {
                if (posX < currentCameraX) {
                    if (!isPointOccluded(posX + 128, posZ, posY)) {
                        return false;
                    }
                    if (!isPointOccluded(posX + 128, posZ, posY + 128)) {
                        return false;
                    }
                }
                if (level > 0) {
                    if (!isPointOccluded(posX + 128, z1, posY)) {
                        return false;
                    }
                    if (!isPointOccluded(posX + 128, z1, posY + 128)) {
                        return false;
                    }
                }
                if (!isPointOccluded(posX + 128, z2, posY)) {
                    return false;
                }
                return isPointOccluded(posX + 128, z2, posY + 128);
            }
            if (wallType == 8) {
                if (posY > currentCameraY) {
                    if (!isPointOccluded(posX, posZ, posY)) {
                        return false;
                    }
                    if (!isPointOccluded(posX + 128, posZ, posY)) {
                        return false;
                    }
                }
                if (level > 0) {
                    if (!isPointOccluded(posX, z1, posY)) {
                        return false;
                    }
                    if (!isPointOccluded(posX + 128, z1, posY)) {
                        return false;
                    }
                }
                if (!isPointOccluded(posX, z2, posY)) {
                    return false;
                }
                return isPointOccluded(posX + 128, z2, posY);
            }
        }
        if (!isPointOccluded(posX + 64, z3, posY + 64)) {
            return false;
        }
        if (wallType == 16) {
            return isPointOccluded(posX, z2, posY + 128);
        }
        if (wallType == 32) {
            return isPointOccluded(posX + 128, z2, posY + 128);
        }
        if (wallType == 64) {
            return isPointOccluded(posX + 128, z2, posY);
        }
        if (wallType == 128) {
            return isPointOccluded(posX, z2, posY);
        }
        return true;
    }

    public boolean isPointOccluded(int posX, int posZ, int posY) {
        for (int i = 0; i < activeOccluderCount; i++) {
            SceneCluster sceneCluster = processedCullingClusters[i];
            if (sceneCluster.tileDistanceEnum == 1) {
                int deltaX = sceneCluster.worldStartX - posX;
                if (deltaX > 0) {
                    int i_48_ = sceneCluster.worldStartY + (sceneCluster.worldDistanceFromCameraStartY * deltaX >> 8);
                    int i_49_ = sceneCluster.worldEndY + (sceneCluster.worldDistanceFromCameraEndY * deltaX >> 8);
                    int i_50_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * deltaX >> 8);
                    int i_51_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * deltaX >> 8);
                    if (posY >= i_48_ && posY <= i_49_ && posZ >= i_50_ && posZ <= i_51_) {
                        return true;
                    }
                }
            } else if (sceneCluster.tileDistanceEnum == 2) {
                int deltaX = posX - sceneCluster.worldStartX;
                if (deltaX > 0) {
                    int i_53_ = sceneCluster.worldStartY + (sceneCluster.worldDistanceFromCameraStartY * deltaX >> 8);
                    int i_54_ = sceneCluster.worldEndY + (sceneCluster.worldDistanceFromCameraEndY * deltaX >> 8);
                    int i_55_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * deltaX >> 8);
                    int i_56_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * deltaX >> 8);
                    if (posY >= i_53_ && posY <= i_54_ && posZ >= i_55_ && posZ <= i_56_) {
                        return true;
                    }
                }
            } else if (sceneCluster.tileDistanceEnum == 3) {
                int deltaX = sceneCluster.worldStartY - posY;
                if (deltaX > 0) {
                    int i_58_ = sceneCluster.worldStartX + (sceneCluster.worldDistanceFromCameraStartX * deltaX >> 8);
                    int i_59_ = sceneCluster.worldEndX + (sceneCluster.worldDistanceFromCameraEndX * deltaX >> 8);
                    int i_60_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * deltaX >> 8);
                    int i_61_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * deltaX >> 8);
                    if (posX >= i_58_ && posX <= i_59_ && posZ >= i_60_ && posZ <= i_61_) {
                        return true;
                    }
                }
            } else if (sceneCluster.tileDistanceEnum == 4) {
                int deltaX = posY - sceneCluster.worldStartY;
                if (deltaX > 0) {
                    int i_63_ = sceneCluster.worldStartX + (sceneCluster.worldDistanceFromCameraStartX * deltaX >> 8);
                    int i_64_ = sceneCluster.worldEndX + (sceneCluster.worldDistanceFromCameraEndX * deltaX >> 8);
                    int i_65_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * deltaX >> 8);
                    int i_66_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * deltaX >> 8);
                    if (posX >= i_63_ && posX <= i_64_ && posZ >= i_65_ && posZ <= i_66_) {
                        return true;
                    }
                }
            } else if (sceneCluster.tileDistanceEnum == 5) {
                int deltaX = posZ - sceneCluster.worldEndZ;
                if (deltaX > 0) {
                    int i_68_ = sceneCluster.worldStartX + (sceneCluster.worldDistanceFromCameraStartX * deltaX >> 8);
                    int i_69_ = sceneCluster.worldEndX + (sceneCluster.worldDistanceFromCameraEndX * deltaX >> 8);
                    int i_70_ = sceneCluster.worldStartY + (sceneCluster.worldDistanceFromCameraStartY * deltaX >> 8);
                    int i_71_ = sceneCluster.worldEndY + (sceneCluster.worldDistanceFromCameraEndY * deltaX >> 8);
                    if (posX >= i_68_ && posX <= i_69_ && posY >= i_70_ && posY <= i_71_) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clearInteractiveObjectCache() {
        for (int i = 0; i < sceneSpawnRequestsCacheCurrentPos; i++) {
            InteractiveObject interactiveObject = sceneSpawnRequestsCache[i];
            remove(interactiveObject);
            sceneSpawnRequestsCache[i] = null;
        }
        sceneSpawnRequestsCacheCurrentPos = 0;
    }

    public void remove(InteractiveObject entity) {
        for (int x = entity.tileLeft; x <= entity.tileRight; x++) {
            for (int y = entity.tileTop; y <= entity.tileBottom; y++) {
                SceneTile tile = tileArray[entity.z][x][y];
                if (tile != null) {
                    for (int e = 0; e < tile.entityCount; e++) {
                        if (tile.interactiveObjects[e] == entity) {
                            tile.entityCount--;
                            for (int e2 = e; e2 < tile.entityCount; e2++) {
                                tile.interactiveObjects[e2] = tile.interactiveObjects[e2 + 1];
                                tile.sceneSpawnRequestsSize[e2] = tile.sceneSpawnRequestsSize[e2 + 1];
                            }
                            tile.interactiveObjects[tile.entityCount] = null;
                            break;
                        }
                    }
                    tile.interactiveObjectsSizeOR = 0;
                    for (int i_75_ = 0; i_75_ < tile.entityCount; i_75_++) {
                        tile.interactiveObjectsSizeOR |= tile.sceneSpawnRequestsSize[i_75_];
                    }
                }
            }
        }
    }

    public void renderTile(SceneTile _tile, boolean arg1) {
        tileList.addLast(_tile);
        for (; ; ) {
            SceneTile groundTile = (SceneTile) tileList.removeFirst();
            if (groundTile == null) {
                break;
            }
            if (groundTile.visible) {
                int x = groundTile.anInt2061;
                int y = groundTile.anInt2078;
                int z = groundTile.anInt2066;
                int i_78_ = groundTile.anInt2069;
                SceneTile[][] sceneTiles = tileArray[z];
                if (groundTile.draw) {
                    if (arg1) {
                        if (z > 0) {
                            SceneTile tile = tileArray[z - 1][x][y];
                            if (tile != null && tile.visible) {
                                continue;
                            }
                        }
                        if (x <= currentCameraTileX && x > drawFromTileX) {
                            SceneTile tile = sceneTiles[x - 1][y];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x1) == 0)) {
                                continue;
                            }
                        }
                        if (x >= currentCameraTileX && x < drawToTileX - 1) {
                            SceneTile tile = sceneTiles[x + 1][y];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x4) == 0)) {
                                continue;
                            }
                        }
                        if (y <= currentCameraTileY && y > drawFromTileY) {
                            SceneTile tile = sceneTiles[x][y - 1];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x8) == 0)) {
                                continue;
                            }
                        }
                        if (y >= currentCameraTileY && y < drawToTileY - 1) {
                            SceneTile tile = sceneTiles[x][y + 1];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x2) == 0)) {
                                continue;
                            }
                        }
                    } else {
                        arg1 = true;
                    }
                    groundTile.draw = false;
                    if (groundTile.aSceneTile_2058 != null) {
                        SceneTile tile = groundTile.aSceneTile_2058;
                        if (tile.plainTile != null) {
                            if (!isTileOccluded(x, y, 0)) {
                                renderPlainTile(tile.plainTile, 0, x, y);
                            }
                        } else if (tile.shapedTile != null && !isTileOccluded(x, y, 0)) {
                            renderShapedTile(tile.shapedTile, x, y);
                        }
                        Wall wall = tile.wall;
                        if (wall != null) {
                            wall.primary.renderAtPoint(0, currentCameraRotation, wall.x - currentCameraX, wall.z - currentCameraZ, wall.y - currentCameraY, wall.hash);
                        }
                        for (int e = 0; e < tile.entityCount; e++) {
                            InteractiveObject interactiveObject = tile.interactiveObjects[e];
                            if (interactiveObject != null) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, currentCameraRotation, interactiveObject.worldX - currentCameraX, interactiveObject.worldZ - currentCameraZ, interactiveObject.worldY - currentCameraY, interactiveObject.hash);
                            }
                        }
                    }
                    boolean bool = false;
                    if (groundTile.plainTile != null) {
                        if (!isTileOccluded(x, y, i_78_)) {
                            bool = true;
                            try {
                                renderPlainTile(groundTile.plainTile, i_78_, x, y);
                            } catch (Exception e) {

                            }
                        }
                    } else if (groundTile.shapedTile != null && !isTileOccluded(x, y, i_78_)) {
                        bool = true;
                        renderShapedTile(groundTile.shapedTile, x, y);
                    }
                    int i_86_ = 0;
                    int i_87_ = 0;
                    Wall wall = groundTile.wall;
                    WallDecoration wallDecoration = groundTile.wallDecoration;
                    if (wall != null || wallDecoration != null) {
                        if (currentCameraTileX == x) {
                            i_86_++;
                        } else if (currentCameraTileX < x) {
                            i_86_ += 2;
                        }
                        if (currentCameraTileY == y) {
                            i_86_ += 3;
                        } else if (currentCameraTileY > y) {
                            i_86_ += 6;
                        }
                        i_87_ = FRONT_WALL_TYPES[i_86_];
                        groundTile.anInt2064 = BACK_WALL_TYPES[i_86_];
                    }
                    if (wall != null) {
                        if ((wall.orientationA & DIRECTION_ALLOW_WALL_CORNER_TYPE[i_86_]) != 0) {
                            if (wall.orientationA == 16) {
                                groundTile.wallCullDirection = 3;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_16_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 3 - groundTile.wallUncullDirection;
                            } else if (wall.orientationA == 32) {
                                groundTile.wallCullDirection = 6;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_32_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 6 - groundTile.wallUncullDirection;
                            } else if (wall.orientationA == 64) {
                                groundTile.wallCullDirection = 12;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_64_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 12 - groundTile.wallUncullDirection;
                            } else {
                                groundTile.wallCullDirection = 9;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_128_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 9 - groundTile.wallUncullDirection;
                            }
                        } else {
                            groundTile.wallCullDirection = 0;
                        }
                        if ((wall.orientationA & i_87_) != 0 && !isWallOccluded(i_78_, x, y, wall.orientationA)) {
                            wall.primary.renderAtPoint(0, currentCameraRotation, wall.x - currentCameraX, wall.z - currentCameraZ, wall.y - currentCameraY, wall.hash);
                        }
                        if ((wall.orientationB & i_87_) != 0 && !isWallOccluded(i_78_, x, y, wall.orientationB)) {
                            wall.secondary.renderAtPoint(0, currentCameraRotation, wall.x - currentCameraX, wall.z - currentCameraZ, wall.y - currentCameraY, wall.hash);
                        }
                    }
                    if (wallDecoration != null && !isOccluded(i_78_, x, y, wallDecoration.renderable.modelHeight)) {
                        if ((wallDecoration.configBits & i_87_) != 0) {
                            wallDecoration.renderable.renderAtPoint(wallDecoration.face, currentCameraRotation, wallDecoration.x - currentCameraX, wallDecoration.z - currentCameraZ, wallDecoration.y - currentCameraY, wallDecoration.hash);
                        } else if ((wallDecoration.configBits & 0x300) != 0) {
                            int i_88_ = wallDecoration.x - currentCameraX;
                            int i_89_ = wallDecoration.z - currentCameraZ;
                            int i_90_ = wallDecoration.y - currentCameraY;
                            int i_91_ = wallDecoration.face;
                            int i_92_;
                            if (i_91_ == 1 || i_91_ == 2) {
                                i_92_ = -i_88_;
                            } else {
                                i_92_ = i_88_;
                            }
                            int i_93_;
                            if (i_91_ == 2 || i_91_ == 3) {
                                i_93_ = -i_90_;
                            } else {
                                i_93_ = i_90_;
                            }
                            if ((wallDecoration.configBits & 0x100) != 0 && i_93_ < i_92_) {
                                int i_94_ = i_88_ + WALL_DECORATION_INSET_X[i_91_];
                                int i_95_ = i_90_ + WALL_DECORATION_INSET_Y[i_91_];
                                wallDecoration.renderable.renderAtPoint(i_91_ * 512 + 256, currentCameraRotation, i_94_, i_89_, i_95_, wallDecoration.hash);
                            }
                            if ((wallDecoration.configBits & 0x200) != 0 && i_93_ > i_92_) {
                                int i_96_ = i_88_ + WALL_DECORATION_OUTSET_X[i_91_];
                                int i_97_ = i_90_ + WALL_DECORATION_OUTSET_Y[i_91_];
                                wallDecoration.renderable.renderAtPoint(i_91_ * 512 + 1280 & 0x7ff, currentCameraRotation, i_96_, i_89_, i_97_, wallDecoration.hash);
                            }
                        }
                    }
                    if (bool) {
                        FloorDecoration floorDecoration = groundTile.floorDecoration;
                        if (floorDecoration != null) {
                            floorDecoration.renderable.renderAtPoint(0, currentCameraRotation, floorDecoration.x - currentCameraX, floorDecoration.z - currentCameraZ, floorDecoration.y - currentCameraY, floorDecoration.hash);
                        }
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if (groundItemTile != null && groundItemTile.anInt1371 == 0) {
                            if (groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, currentCameraRotation, groundItemTile.x - currentCameraX, groundItemTile.z - currentCameraZ, groundItemTile.y - currentCameraY, groundItemTile.hash);
                            }
                            if (groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, currentCameraRotation, groundItemTile.x - currentCameraX, groundItemTile.z - currentCameraZ, groundItemTile.y - currentCameraY, groundItemTile.hash);
                            }
                            if (groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, currentCameraRotation, groundItemTile.x - currentCameraX, groundItemTile.z - currentCameraZ, groundItemTile.y - currentCameraY, groundItemTile.hash);
                            }
                        }
                    }
                    int i_98_ = groundTile.interactiveObjectsSizeOR;
                    if (i_98_ != 0) {
                        if (x < currentCameraTileX && (i_98_ & 0x4) != 0) {
                            SceneTile sceneTile_99_ = sceneTiles[x + 1][y];
                            if (sceneTile_99_ != null && sceneTile_99_.visible) {
                                tileList.addLast(sceneTile_99_);
                            }
                        }
                        if (y < currentCameraTileY && (i_98_ & 0x2) != 0) {
                            SceneTile sceneTile_100_ = sceneTiles[x][y + 1];
                            if (sceneTile_100_ != null && sceneTile_100_.visible) {
                                tileList.addLast(sceneTile_100_);
                            }
                        }
                        if (x > currentCameraTileX && (i_98_ & 0x1) != 0) {
                            SceneTile sceneTile_101_ = sceneTiles[x - 1][y];
                            if (sceneTile_101_ != null && sceneTile_101_.visible) {
                                tileList.addLast(sceneTile_101_);
                            }
                        }
                        if (y > currentCameraTileY && (i_98_ & 0x8) != 0) {
                            SceneTile tile = sceneTiles[x][y - 1];
                            if (tile != null && tile.visible) {
                                tileList.addLast(tile);
                            }
                        }
                    }
                }
                if (groundTile.wallCullDirection != 0) {
                    boolean bool = true;
                    for (int i_103_ = 0; i_103_ < groundTile.entityCount; i_103_++) {
                        if (groundTile.interactiveObjects[i_103_].cycle != cycle && (groundTile.sceneSpawnRequestsSize[i_103_] & groundTile.wallCullDirection) == groundTile.wallUncullDirection) {
                            bool = false;
                            break;
                        }
                    }
                    if (bool) {
                        Wall wall = groundTile.wall;
                        if (!isWallOccluded(i_78_, x, y, wall.orientationA)) {
                            wall.primary.renderAtPoint(0, currentCameraRotation, wall.x - currentCameraX, wall.z - currentCameraZ, wall.y - currentCameraY, wall.hash);
                        }
                        groundTile.wallCullDirection = 0;
                    }
                }
                if (groundTile.drawEntities) {
                    try {
                        int i_104_ = groundTile.entityCount;
                        groundTile.drawEntities = false;
                        int i_105_ = 0;
                        while_2_:
                        for (int i_106_ = 0; i_106_ < i_104_; i_106_++) {
                            InteractiveObject entity = groundTile.interactiveObjects[i_106_];
                            if (entity.cycle != cycle) {
                                for (int i_107_ = entity.tileLeft; i_107_ <= entity.tileRight; i_107_++) {
                                    for (int i_108_ = entity.tileTop; i_108_ <= entity.tileBottom; i_108_++) {
                                        SceneTile tile = sceneTiles[i_107_][i_108_];
                                        if (tile.draw) {
                                            groundTile.drawEntities = true;
                                            continue while_2_;
                                        }
                                        if (tile.wallCullDirection != 0) {
                                            int i_110_ = 0;
                                            if (i_107_ > entity.tileLeft) {
                                                i_110_++;
                                            }
                                            if (i_107_ < entity.tileRight) {
                                                i_110_ += 4;
                                            }
                                            if (i_108_ > entity.tileTop) {
                                                i_110_ += 8;
                                            }
                                            if (i_108_ < entity.tileBottom) {
                                                i_110_ += 2;
                                            }
                                            if ((i_110_ & tile.wallCullDirection) == groundTile.wallCullOppositeDirection) {
                                                groundTile.drawEntities = true;
                                                continue while_2_;
                                            }
                                        }
                                    }
                                }
                                interactiveObjects[i_105_++] = entity;
                                int i_111_ = currentCameraTileX - entity.tileLeft;
                                int i_112_ = entity.tileRight - currentCameraTileX;
                                if (i_112_ > i_111_) {
                                    i_111_ = i_112_;
                                }
                                int i_113_ = currentCameraTileY - entity.tileTop;
                                int i_114_ = entity.tileBottom - currentCameraTileY;
                                if (i_114_ > i_113_) {
                                    entity.anInt491 = i_111_ + i_114_;
                                } else {
                                    entity.anInt491 = i_111_ + i_113_;
                                }
                            }
                        }
                        while (i_105_ > 0) {
                            int i_115_ = -50;
                            int i_116_ = -1;
                            for (int i_117_ = 0; i_117_ < i_105_; i_117_++) {
                                InteractiveObject interactiveObject = interactiveObjects[i_117_];
                                if (interactiveObject.cycle != cycle) {
                                    if (interactiveObject.anInt491 > i_115_) {
                                        i_115_ = interactiveObject.anInt491;
                                        i_116_ = i_117_;
                                    } else if (interactiveObject.anInt491 == i_115_) {
                                        int i_118_ = interactiveObject.worldX - currentCameraX;
                                        int i_119_ = interactiveObject.worldY - currentCameraY;
                                        int i_120_ = interactiveObjects[i_116_].worldX - currentCameraX;
                                        int i_121_ = interactiveObjects[i_116_].worldY - currentCameraY;
                                        if (i_118_ * i_118_ + i_119_ * i_119_ > i_120_ * i_120_ + i_121_ * i_121_) {
                                            i_116_ = i_117_;
                                        }
                                    }
                                }
                            }
                            if (i_116_ == -1) {
                                break;
                            }
                            InteractiveObject interactiveObject = interactiveObjects[i_116_];
                            interactiveObject.cycle = cycle;
                            if (!isAreaOccluded(i_78_, interactiveObject.tileLeft, interactiveObject.tileRight, interactiveObject.tileTop, interactiveObject.tileBottom, interactiveObject.renderable.modelHeight)) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, currentCameraRotation, interactiveObject.worldX - currentCameraX, interactiveObject.worldZ - currentCameraZ, interactiveObject.worldY - currentCameraY, interactiveObject.hash);
                            }
                            for (int i_122_ = interactiveObject.tileLeft; i_122_ <= interactiveObject.tileRight; i_122_++) {
                                for (int i_123_ = interactiveObject.tileTop; i_123_ <= interactiveObject.tileBottom; i_123_++) {
                                    SceneTile sceneTile_124_ = sceneTiles[i_122_][i_123_];
                                    if (sceneTile_124_.wallCullDirection != 0) {
                                        tileList.addLast(sceneTile_124_);
                                    } else if ((i_122_ != x || i_123_ != y) && sceneTile_124_.visible) {
                                        tileList.addLast(sceneTile_124_);
                                    }
                                }
                            }
                        }
                        if (groundTile.drawEntities) {
                            continue;
                        }
                    } catch (Exception exception) {
                        groundTile.drawEntities = false;
                    }
                }
                if (groundTile.visible) {
                    if (groundTile.wallCullDirection == 0) {
                        if (x <= currentCameraTileX && x > drawFromTileX) {
                            SceneTile sceneTile_125_ = sceneTiles[x - 1][y];
                            if (sceneTile_125_ != null && sceneTile_125_.visible) {
                                continue;
                            }
                        }
                        if (x >= currentCameraTileX && x < drawToTileX - 1) {
                            SceneTile sceneTile_126_ = sceneTiles[x + 1][y];
                            if (sceneTile_126_ != null && sceneTile_126_.visible) {
                                continue;
                            }
                        }
                        if (y <= currentCameraTileY && y > drawFromTileY) {
                            SceneTile sceneTile_127_ = sceneTiles[x][y - 1];
                            if (sceneTile_127_ != null && sceneTile_127_.visible) {
                                continue;
                            }
                        }
                        if (y >= currentCameraTileY && y < drawToTileY - 1) {
                            SceneTile sceneTile_128_ = sceneTiles[x][y + 1];
                            if (sceneTile_128_ != null && sceneTile_128_.visible) {
                                continue;
                            }
                        }
                        groundTile.visible = false;
                        anInt109--;
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if (groundItemTile != null && groundItemTile.anInt1371 != 0) {
                            if (groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, currentCameraRotation, groundItemTile.x - currentCameraX, groundItemTile.z - currentCameraZ - groundItemTile.anInt1371, groundItemTile.y - currentCameraY, groundItemTile.hash);
                            }
                            if (groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, currentCameraRotation, groundItemTile.x - currentCameraX, groundItemTile.z - currentCameraZ - groundItemTile.anInt1371, groundItemTile.y - currentCameraY, groundItemTile.hash);
                            }
                            if (groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, currentCameraRotation, groundItemTile.x - currentCameraX, groundItemTile.z - currentCameraZ - groundItemTile.anInt1371, groundItemTile.y - currentCameraY, groundItemTile.hash);
                            }
                        }
                        if (groundTile.anInt2064 != 0) {
                            WallDecoration wallDecoration = groundTile.wallDecoration;
                            if (wallDecoration != null && !isOccluded(i_78_, x, y, wallDecoration.renderable.modelHeight)) {
                                if ((wallDecoration.configBits & groundTile.anInt2064) != 0) {
                                    wallDecoration.renderable.renderAtPoint(wallDecoration.face, currentCameraRotation, wallDecoration.x - currentCameraX, wallDecoration.z - currentCameraZ, wallDecoration.y - currentCameraY, wallDecoration.hash);
                                } else if ((wallDecoration.configBits & 0x300) != 0) {
                                    int i_129_ = wallDecoration.x - currentCameraX;
                                    int i_130_ = wallDecoration.z - currentCameraZ;
                                    int i_131_ = wallDecoration.y - currentCameraY;
                                    int i_132_ = wallDecoration.face;
                                    int i_133_;
                                    if (i_132_ == 1 || i_132_ == 2) {
                                        i_133_ = -i_129_;
                                    } else {
                                        i_133_ = i_129_;
                                    }
                                    int i_134_;
                                    if (i_132_ == 2 || i_132_ == 3) {
                                        i_134_ = -i_131_;
                                    } else {
                                        i_134_ = i_131_;
                                    }
                                    if ((wallDecoration.configBits & 0x100) != 0 && i_134_ >= i_133_) {
                                        int i_135_ = i_129_ + WALL_DECORATION_INSET_X[i_132_];
                                        int i_136_ = i_131_ + WALL_DECORATION_INSET_Y[i_132_];
                                        wallDecoration.renderable.renderAtPoint(i_132_ * 512 + 256, currentCameraRotation, i_135_, i_130_, i_136_, wallDecoration.hash);
                                    }
                                    if ((wallDecoration.configBits & 0x200) != 0 && i_134_ <= i_133_) {
                                        int i_137_ = i_129_ + WALL_DECORATION_OUTSET_X[i_132_];
                                        int i_138_ = i_131_ + WALL_DECORATION_OUTSET_Y[i_132_];
                                        wallDecoration.renderable.renderAtPoint(i_132_ * 512 + 1280 & 0x7ff, currentCameraRotation, i_137_, i_130_, i_138_, wallDecoration.hash);
                                    }
                                }
                            }
                            Wall wall = groundTile.wall;
                            if (wall != null) {
                                if ((wall.orientationB & groundTile.anInt2064) != 0 && !isWallOccluded(i_78_, x, y, wall.orientationB)) {
                                    wall.secondary.renderAtPoint(0, currentCameraRotation, wall.x - currentCameraX, wall.z - currentCameraZ, wall.y - currentCameraY, wall.hash);
                                }
                                if ((wall.orientationA & groundTile.anInt2064) != 0 && !isWallOccluded(i_78_, x, y, wall.orientationA)) {
                                    wall.primary.renderAtPoint(0, currentCameraRotation, wall.x - currentCameraX, wall.z - currentCameraZ, wall.y - currentCameraY, wall.hash);
                                }
                            }
                        }
                        if (z < mapSizeZ - 1) {
                            SceneTile sceneTile_139_ = tileArray[z + 1][x][y];
                            if (sceneTile_139_ != null && sceneTile_139_.visible) {
                                tileList.addLast(sceneTile_139_);
                            }
                        }
                        if (x < currentCameraTileX) {
                            SceneTile sceneTile_140_ = sceneTiles[x + 1][y];
                            if (sceneTile_140_ != null && sceneTile_140_.visible) {
                                tileList.addLast(sceneTile_140_);
                            }
                        }
                        if (y < currentCameraTileY) {
                            SceneTile sceneTile_141_ = sceneTiles[x][y + 1];
                            if (sceneTile_141_ != null && sceneTile_141_.visible) {
                                tileList.addLast(sceneTile_141_);
                            }
                        }
                        if (x > currentCameraTileX) {
                            SceneTile sceneTile_142_ = sceneTiles[x - 1][y];
                            if (sceneTile_142_ != null && sceneTile_142_.visible) {
                                tileList.addLast(sceneTile_142_);
                            }
                        }
                        if (y > currentCameraTileY) {
                            SceneTile sceneTile_143_ = sceneTiles[x][y - 1];
                            if (sceneTile_143_ != null && sceneTile_143_.visible) {
                                tileList.addLast(sceneTile_143_);
                            }
                        }
                    }
                }
            }
        }
    }

    public InteractiveObject getObject(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile == null) {
            return null;
        }
        for (int i = 0; i < sceneTile.entityCount; i++) {
            InteractiveObject interactiveObject = sceneTile.interactiveObjects[i];
            if ((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == arg1 && interactiveObject.tileTop == arg2) {
                return interactiveObject;
            }
        }
        return null;
    }

    public void addWallDecoration(int x, int y, int z, int drawHeight, int offsetX, int offsetY, int face, int hash, Renderable renderable, int config, int configBits) {
        if (renderable != null) {
            WallDecoration wallDecoration = new WallDecoration();
            wallDecoration.hash = hash;
            wallDecoration.config = config;
            wallDecoration.x = x * 128 + 64 + offsetX;
            wallDecoration.y = y * 128 + 64 + offsetY;
            wallDecoration.z = drawHeight;
            wallDecoration.renderable = renderable;
            wallDecoration.configBits = configBits;
            wallDecoration.face = face;
            for (int plane = z; plane >= 0; plane--) {
                if (tileArray[plane][x][y] == null) {
                    tileArray[plane][x][y] = new SceneTile(plane, x, y);
                }
            }
            tileArray[z][x][y].wallDecoration = wallDecoration;
        }
    }

    public int getLocationHash(int z, int x, int y) {
        SceneTile sceneTile = tileArray[z][x][y];
        if (sceneTile == null) {
            return 0;
        }
        for (int i = 0; i < sceneTile.entityCount; i++) {
            InteractiveObject interactiveObject = sceneTile.interactiveObjects[i];
            if ((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == x && interactiveObject.tileTop == y) {
                return interactiveObject.hash;
            }
        }
        return 0;
    }

    public boolean isOccluded(int z, int x, int y, int arg3) {
        if (!isTileOccluded(x, y, z)) {
            return false;
        }
        int i = x << 7;
        int i_144_ = y << 7;
        return isPointOccluded(i + 1, heightMap[z][x][y] - arg3, i_144_ + 1) && isPointOccluded(i + 128 - 1, heightMap[z][x + 1][y] - arg3, i_144_ + 1) && isPointOccluded(i + 128 - 1, heightMap[z][x + 1][y + 1] - arg3, i_144_ + 128 - 1) && isPointOccluded(i + 1, heightMap[z][x][y + 1] - arg3, i_144_ + 128 - 1);
    }

    public boolean method112(int arg0, int arg1, int arg2, int arg3, int arg4, Renderable arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        if (arg5 == null) {
            return true;
        }
        return addRenderableC(arg8, arg9, arg0, arg1, arg2, arg3, arg6, arg11 - arg9 + 1, arg10 - arg8 + 1, arg7, arg5, true, 0);
    }

    public void setWallDecorationOffset(int plane, int tileX, int tileY, int offset) {
        SceneTile sceneTile = tileArray[plane][tileX][tileY];
        if (sceneTile != null) {
            WallDecoration wallDecoration = sceneTile.wallDecoration;
            if (wallDecoration != null) {
                int sceneX = tileX * 128 + 64;
                int sceneY = tileY * 128 + 64;
                wallDecoration.x = sceneX + (wallDecoration.x - sceneX) * offset / 16;
                wallDecoration.y = sceneY + (wallDecoration.y - sceneY) * offset / 16;
            }
        }
    }

    public void mergeFloorDecorationNormals(Model model, int z, int x, int y) {
        if (x < mapSizeX) {
            SceneTile sceneTile = tileArray[z][x + 1][y];
            if (sceneTile != null && sceneTile.floorDecoration != null && sceneTile.floorDecoration.renderable instanceof Model) {
                Model _model = (Model) sceneTile.floorDecoration.renderable;
                if (_model.verticesNormal != null) {
                    mergeNormals(model, _model, 128, 0, 0, true);
                }
            }
        }
        if (y < mapSizeX) {
            SceneTile sceneTile = tileArray[z][x][y + 1];
            if (sceneTile != null && sceneTile.floorDecoration != null && sceneTile.floorDecoration.renderable instanceof Model) {
                Model _model = (Model) sceneTile.floorDecoration.renderable;
                if (_model.verticesNormal != null) {
                    mergeNormals(model, _model, 0, 0, 128, true);
                }
            }
        }
        if (x < mapSizeX && y < mapSizeY) {
            SceneTile sceneTile = tileArray[z][x + 1][y + 1];
            if (sceneTile != null && sceneTile.floorDecoration != null && sceneTile.floorDecoration.renderable instanceof Model) {
                Model _model = (Model) sceneTile.floorDecoration.renderable;
                if (_model.verticesNormal != null) {
                    mergeNormals(model, _model, 128, 0, 128, true);
                }
            }
        }
        if (x < mapSizeX && y > 0) {
            SceneTile sceneTile = tileArray[z][x + 1][y - 1];
            if (sceneTile != null && sceneTile.floorDecoration != null && sceneTile.floorDecoration.renderable instanceof Model) {
                Model _model = (Model) sceneTile.floorDecoration.renderable;
                if (_model.verticesNormal != null) {
                    mergeNormals(model, _model, 128, 0, -128, true);
                }
            }
        }
    }

    public void buildModels(int arg0, int arg1, int arg2) {
        for (int _z = 0; _z < mapSizeZ; _z++) {
            for (int _x = 0; _x < mapSizeX; _x++) {
                for (int _y = 0; _y < mapSizeY; _y++) {
                    SceneTile tile = tileArray[_z][_x][_y];
                    if (tile != null) {
                        Wall wall = tile.wall;
                        if (wall != null && wall.primary instanceof Model) {
                            Model model = (Model) wall.primary;
                            if (model.verticesNormal != null) {
                                mergeObjectNormals(model, _z, _x, _y, 1, 1);
                                if (wall.secondary instanceof Model) {
                                    Model _model = (Model) wall.secondary;
                                    if (_model.verticesNormal != null) {
                                        mergeObjectNormals(_model, _z, _x, _y, 1, 1);
                                        mergeNormals(model, _model, 0, 0, 0, false);
                                        _model.handleShading(arg0, arg1, arg2);
                                    }
                                }
                                model.handleShading(arg0, arg1, arg2);
                            }
                        }
                        for (int e = 0; e < tile.entityCount; e++) {
                            InteractiveObject interactiveObject = tile.interactiveObjects[e];
                            if (interactiveObject != null && interactiveObject.renderable instanceof Model) {
                                Model model = (Model) interactiveObject.renderable;
                                if (model.verticesNormal != null) {
                                    mergeObjectNormals(model, _z, _x, _y, interactiveObject.tileRight - interactiveObject.tileLeft + 1, interactiveObject.tileBottom - interactiveObject.tileTop + 1);
                                    model.handleShading(arg0, arg1, arg2);
                                }
                            }
                        }
                        FloorDecoration floorDecoration = tile.floorDecoration;
                        if (floorDecoration != null && floorDecoration.renderable instanceof Model) {
                            Model model = (Model) floorDecoration.renderable;
                            if (model.verticesNormal != null) {
                                mergeFloorDecorationNormals(model, _z, _x, _y);
                                model.handleShading(arg0, arg1, arg2);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isAreaOccluded(int z, int minimumX, int maximumX, int minimumY, int maximumY, int offsetZ) {
        if (minimumX == maximumX && minimumY == maximumY) {
            if (!isTileOccluded(minimumX, minimumY, z)) {
                return false;
            }
            int worldX = minimumX << 7;
            int worldY = minimumY << 7;
            return isPointOccluded(worldX + 1, heightMap[z][minimumX][minimumY] - offsetZ, worldY + 1) && isPointOccluded(worldX + 128 - 1, heightMap[z][minimumX + 1][minimumY] - offsetZ, worldY + 1) && isPointOccluded(worldX + 128 - 1, heightMap[z][minimumX + 1][minimumY + 1] - offsetZ, worldY + 128 - 1) && isPointOccluded(worldX + 1, heightMap[z][minimumX][minimumY + 1] - offsetZ, worldY + 128 - 1);
        }
        for (int x = minimumX; x <= maximumX; x++) {
            for (int y = minimumY; y <= maximumY; y++) {
                if (tileOcclusionCycles[z][x][y] == -cycle) {
                    return false;
                }
            }
        }
        int _x = (minimumX << 7) + 1;
        int _y = (minimumY << 7) + 2;
        int _z = heightMap[z][minimumX][minimumY] - offsetZ;
        if (!isPointOccluded(_x, _z, _y)) {
            return false;
        }
        int i_159_ = (maximumX << 7) - 1;
        if (!isPointOccluded(i_159_, _z, _y)) {
            return false;
        }
        int i_160_ = (maximumY << 7) - 1;
        if (!isPointOccluded(_x, _z, i_160_)) {
            return false;
        }
        return isPointOccluded(i_159_, _z, i_160_);
    }

    public void click(int arg0, int arg1) {
        clicked = true;
        clickX = arg0;
        clickY = arg1;
        clickedTileX = -1;
        clickedTileY = -1;
    }

    public void mergeNormals(Model modelA, Model modelB, int i, int j, int k, boolean arg5) {
        modelB.method822();
        mergeIndexTmp++;
        int count = 0;
        int[] vertices = modelB.verticesX;
        int vertexCount = modelB.vertexCount;
        for (int vertex = 0; vertex < modelA.vertexCount; vertex++) {
            VertexNormal vertexNormal = modelA.verticesNormal[vertex];
            VertexNormal offsetVertexNormal = modelA.vertexNormalOffset[vertex];
            if (offsetVertexNormal.magnitude != 0) {
                int y = modelA.verticesY[vertex] - j;
                if (y <= modelB.maxY) {
                    int x = modelA.verticesX[vertex] - i;
                    if (x >= modelB.diagonal2DAboveOrigin && x <= modelB.diagonal3D) {
                        int z = modelA.verticesZ[vertex] - k;
                        if (z >= modelB.anInt3177 && z <= modelB.anInt3189) {
                            for (int v = 0; v < vertexCount; v++) {
                                VertexNormal _vertexNormal = modelB.verticesNormal[v];
                                VertexNormal _offsetVertexNormal = modelB.vertexNormalOffset[v];
                                if (x == vertices[v] && z == modelB.verticesZ[v] && y == modelB.verticesY[v] && _offsetVertexNormal.magnitude != 0) {
                                    vertexNormal.x += _offsetVertexNormal.x;
                                    vertexNormal.y += _offsetVertexNormal.y;
                                    vertexNormal.z += _offsetVertexNormal.z;
                                    vertexNormal.magnitude += _offsetVertexNormal.magnitude;
                                    _vertexNormal.x += offsetVertexNormal.x;
                                    _vertexNormal.y += offsetVertexNormal.y;
                                    _vertexNormal.z += offsetVertexNormal.z;
                                    _vertexNormal.magnitude += offsetVertexNormal.magnitude;
                                    count++;
                                    mergeIndexA[vertex] = mergeIndexTmp;
                                    mergeIndexB[v] = mergeIndexTmp;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count >= 3 && arg5) {
            for (int tri = 0; tri < modelA.triangleCount; tri++) {
                if (mergeIndexA[modelA.trianglePointsX[tri]] == mergeIndexTmp && mergeIndexA[modelA.trianglePointsY[tri]] == mergeIndexTmp && mergeIndexA[modelA.trianglePointsZ[tri]] == mergeIndexTmp) {
                    modelA.triangleDrawType[tri] = -1;
                }
            }
            for (int tri = 0; tri < modelB.triangleCount; tri++) {
                if (mergeIndexB[modelB.trianglePointsX[tri]] == mergeIndexTmp && mergeIndexB[modelB.trianglePointsY[tri]] == mergeIndexTmp && mergeIndexB[modelB.trianglePointsZ[tri]] == mergeIndexTmp) {
                    modelB.triangleDrawType[tri] = -1;
                }
            }
        }
    }

    public int getWallHash(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile == null || sceneTile.wall == null) {
            return 0;
        }
        return sceneTile.wall.hash;
    }

    public void processCulling(int plane) {
        int i = cullingClusterPointer[plane];
        SceneCluster[] sceneClusters = cullingClusters[plane];
        activeOccluderCount = 0;
        for (int i_172_ = 0; i_172_ < i; i_172_++) {
            SceneCluster sceneCluster = sceneClusters[i_172_];
            if (sceneCluster.searchMask == 1) {
                int i_173_ = sceneCluster.tileStartX - currentCameraTileX + TILE_DRAW_DISTANCE;
                if (i_173_ >= 0 && i_173_ <= 50) {
                    int i_174_ = sceneCluster.tileStartY - currentCameraTileY + TILE_DRAW_DISTANCE;
                    if (i_174_ < 0) {
                        i_174_ = 0;
                    }
                    int i_175_ = sceneCluster.tileEndY - currentCameraTileY + TILE_DRAW_DISTANCE;
                    if (i_175_ > 50) {
                        i_175_ = 50;
                    }
                    boolean bool = false;
                    while (i_174_ <= i_175_) {
                        if (currentTileVisibilityMap[i_173_][i_174_++]) {
                            bool = true;
                            break;
                        }
                    }
                    if (bool) {
                        int i_176_ = currentCameraX - sceneCluster.worldStartX;
                        if (i_176_ > 32) {
                            sceneCluster.tileDistanceEnum = 1;
                        } else {
                            if (i_176_ >= -32) {
                                continue;
                            }
                            sceneCluster.tileDistanceEnum = 2;
                            i_176_ = -i_176_;
                        }
                        sceneCluster.worldDistanceFromCameraStartY = (sceneCluster.worldStartY - currentCameraY << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndY = (sceneCluster.worldEndY - currentCameraY << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - currentCameraZ << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - currentCameraZ << 8) / i_176_;
                        processedCullingClusters[activeOccluderCount++] = sceneCluster;
                    }
                }
            } else if (sceneCluster.searchMask == 2) {
                int i_177_ = sceneCluster.tileStartY - currentCameraTileY + TILE_DRAW_DISTANCE;
                if (i_177_ >= 0 && i_177_ <= 50) {
                    int i_178_ = sceneCluster.tileStartX - currentCameraTileX + TILE_DRAW_DISTANCE;
                    if (i_178_ < 0) {
                        i_178_ = 0;
                    }
                    int i_179_ = sceneCluster.tileEndX - currentCameraTileX + TILE_DRAW_DISTANCE;
                    if (i_179_ > 50) {
                        i_179_ = 50;
                    }
                    boolean bool = false;
                    while (i_178_ <= i_179_) {
                        if (currentTileVisibilityMap[i_178_++][i_177_]) {
                            bool = true;
                            break;
                        }
                    }
                    if (bool) {
                        int i_180_ = currentCameraY - sceneCluster.worldStartY;
                        if (i_180_ > 32) {
                            sceneCluster.tileDistanceEnum = 3;
                        } else {
                            if (i_180_ >= -32) {
                                continue;
                            }
                            sceneCluster.tileDistanceEnum = 4;
                            i_180_ = -i_180_;
                        }
                        sceneCluster.worldDistanceFromCameraStartX = (sceneCluster.worldStartX - currentCameraX << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndX = (sceneCluster.worldEndX - currentCameraX << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - currentCameraZ << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - currentCameraZ << 8) / i_180_;
                        processedCullingClusters[activeOccluderCount++] = sceneCluster;
                    }
                }
            } else if (sceneCluster.searchMask == 4) {
                int i_181_ = sceneCluster.worldEndZ - currentCameraZ;
                if (i_181_ > 128) {
                    int i_182_ = sceneCluster.tileStartY - currentCameraTileY + TILE_DRAW_DISTANCE;
                    if (i_182_ < 0) {
                        i_182_ = 0;
                    }
                    int i_183_ = sceneCluster.tileEndY - currentCameraTileY + TILE_DRAW_DISTANCE;
                    if (i_183_ > 50) {
                        i_183_ = 50;
                    }
                    if (i_182_ <= i_183_) {
                        int i_184_ = sceneCluster.tileStartX - currentCameraTileX + TILE_DRAW_DISTANCE;
                        if (i_184_ < 0) {
                            i_184_ = 0;
                        }
                        int i_185_ = sceneCluster.tileEndX - currentCameraTileX + TILE_DRAW_DISTANCE;
                        if (i_185_ > 50) {
                            i_185_ = 50;
                        }
                        boolean bool = false;
                        while_3_:
                        for (int i_186_ = i_184_; i_186_ <= i_185_; i_186_++) {
                            for (int i_187_ = i_182_; i_187_ <= i_183_; i_187_++) {
                                if (currentTileVisibilityMap[i_186_][i_187_]) {
                                    bool = true;
                                    break while_3_;
                                }
                            }
                        }
                        if (bool) {
                            sceneCluster.tileDistanceEnum = 5;
                            sceneCluster.worldDistanceFromCameraStartX = (sceneCluster.worldStartX - currentCameraX << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraEndX = (sceneCluster.worldEndX - currentCameraX << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraStartY = (sceneCluster.worldStartY - currentCameraY << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraEndY = (sceneCluster.worldEndY - currentCameraY << 8) / i_181_;
                            processedCullingClusters[activeOccluderCount++] = sceneCluster;
                        }
                    }
                }
            }
        }
    }

    public void removeWall(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile != null) {
            sceneTile.wall = null;
        }
    }

    public void removeGroundItems(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile != null) {
            sceneTile.groundItemTile = null;
        }
    }

    public Wall getWall(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile == null) {
            return null;
        }
        return sceneTile.wall;
    }

    public void removeWallDecoration(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile != null) {
            sceneTile.wallDecoration = null;
        }
    }

    public void renderPlainTile(GenericTile plainTile, int arg1, int tileX, int tileY) {
        int xC;
        int xA = xC = (tileX << 7) - currentCameraX;
        int yB;
        int yA = yB = (tileY << 7) - currentCameraY;
        int xD;
        int xB = xD = xA + 128;
        int yC;
        int yD = yC = yA + 128;
        int zA = heightMap[arg1][tileX][tileY] - currentCameraZ;
        int zB = heightMap[arg1][tileX + 1][tileY] - currentCameraZ;
        int zC = heightMap[arg1][tileX + 1][tileY + 1] - currentCameraZ;
        int zD = heightMap[arg1][tileX][tileY + 1] - currentCameraZ;

        int sinX = currentCameraRotation.yawSine;
        int cosineX = currentCameraRotation.yawCosine;
        int sinY = currentCameraRotation.pitchSine;
        int cosineY = currentCameraRotation.pitchCosine;

        int temp = yA * sinX + xA * cosineX >> 16;
        yA = yA * cosineX - xA * sinX >> 16;
        xA = temp;
        temp = zA * cosineY - yA * sinY >> 16;
        yA = zA * sinY + yA * cosineY >> 16;
        zA = temp;
        if (yA < 50) {
            return;
        }
        temp = yB * sinX + xB * cosineX >> 16;
        yB = yB * cosineX - xB * sinX >> 16;
        xB = temp;
        temp = zB * cosineY - yB * sinY >> 16;
        yB = zB * sinY + yB * cosineY >> 16;
        zB = temp;
        if (yB < 50) {
            return;
        }
        temp = yD * sinX + xD * cosineX >> 16;
        yD = yD * cosineX - xD * sinX >> 16;
        xD = temp;
        temp = zC * cosineY - yD * sinY >> 16;
        yD = zC * sinY + yD * cosineY >> 16;
        zC = temp;
        if (yD < 50) {
            return;
        }
        temp = yC * sinX + xC * cosineX >> 16;
        yC = yC * cosineX - xC * sinX >> 16;
        xC = temp;
        temp = zD * cosineY - yC * sinY >> 16;
        yC = zD * sinY + yC * cosineY >> 16;
        zD = temp;
        if (yC < 50) {
            return;
        }
        int screenXA = Rasterizer3D.center_x + (xA << 9) / yA;
        int screenYA = Rasterizer3D.center_y + (zA << 9) / yA;
        int screenXB = Rasterizer3D.center_x + (xB << 9) / yB;
        int screenYB = Rasterizer3D.center_y + (zB << 9) / yB;
        int screenXD = Rasterizer3D.center_x + (xD << 9) / yD;
        int screenYD = Rasterizer3D.center_y + (zC << 9) / yD;
        int screenXC = Rasterizer3D.center_x + (xC << 9) / yC;
        int screenYC = Rasterizer3D.center_y + (zD << 9) / yC;
        Rasterizer3D.alpha = 0;
        if ((screenXD - screenXC) * (screenYB - screenYC) - (screenYD - screenYC) * (screenXB - screenXC) > 0) {
            Rasterizer3D.restrict_edges = screenXD < 0 || screenXC < 0 || screenXB < 0 || screenXD > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx;
            if (clicked && isMouseWithinTriangle(clickX, clickY, screenYD, screenYC, screenYB, screenXD, screenXC, screenXB)) {
                clickedTileX = tileX;
                clickedTileY = tileY;
            }
            if (isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, screenYD, screenYC, screenYB, screenXD, screenXC, screenXB)) {
                hoveredTileX = tileX;
                hoveredTileY = tileY;
            }
            if (plainTile.texture == -1) {
                if (plainTile.colourD != 12345678) {
                    Rasterizer3D.drawShadedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB);
                }
            } else if (lowMemory) {
                int rgb = Rasterizer3D.interface3.getAverageTextureColour(plainTile.texture);
                Rasterizer3D.drawShadedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, adjustLightness(rgb, plainTile.colourD), adjustLightness(rgb, plainTile.colourC), adjustLightness(rgb, plainTile.colourB));
            } else if (plainTile.flat) {
                Rasterizer3D.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xA, xB, xC, zA, zB, zD, yA, yB, yC, plainTile.texture);
            } else {
                Rasterizer3D.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xD, xC, xB, zC, zD, zB, yD, yC, yB, plainTile.texture);
            }
        }
        if ((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB) > 0) {
            Rasterizer3D.restrict_edges = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx;
            if (clicked && isMouseWithinTriangle(clickX, clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                clickedTileX = tileX;
                clickedTileY = tileY;
            }

            if (isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                hoveredTileX = tileX;
                hoveredTileY = tileY;
            }
            if (plainTile.texture == -1) {
                if (plainTile.colourA != 12345678) {
                    Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC);
                }
            } else if (lowMemory) {
                int i_209_ = Rasterizer3D.interface3.getAverageTextureColour(plainTile.texture);
                Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, adjustLightness(i_209_, plainTile.colourA), adjustLightness(i_209_, plainTile.colourB), adjustLightness(i_209_, plainTile.colourC));
            } else {
                Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC, xA, xB, xC, zA, zB, zD, yA, yB, yC, plainTile.texture);
            }
        }
    }

    public void mergeObjectNormals(Model arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        boolean bool = true;
        int i = arg2;
        int i_210_ = arg2 + arg4;
        int i_211_ = arg3 - 1;
        int i_212_ = arg3 + arg5;
        for (int i_213_ = arg1; i_213_ <= arg1 + 1; i_213_++) {
            if (i_213_ != mapSizeZ) {
                for (int i_214_ = i; i_214_ <= i_210_; i_214_++) {
                    if (i_214_ >= 0 && i_214_ < mapSizeX) {
                        for (int i_215_ = i_211_; i_215_ <= i_212_; i_215_++) {
                            if (i_215_ >= 0 && i_215_ < mapSizeY && (!bool || i_214_ >= i_210_ || i_215_ >= i_212_ || i_215_ < arg3 && i_214_ != arg2)) {
                                SceneTile sceneTile = tileArray[i_213_][i_214_][i_215_];
                                if (sceneTile != null) {
                                    int i_216_ = (heightMap[i_213_][i_214_][i_215_] + heightMap[i_213_][i_214_ + 1][i_215_] + heightMap[i_213_][i_214_][i_215_ + 1] + heightMap[i_213_][i_214_ + 1][i_215_ + 1]) / 4 - (heightMap[arg1][arg2][arg3] + heightMap[arg1][arg2 + 1][arg3] + heightMap[arg1][arg2][arg3 + 1] + heightMap[arg1][arg2 + 1][arg3 + 1]) / 4;
                                    Wall wall = sceneTile.wall;
                                    if (wall != null) {
                                        if (wall.primary instanceof Model) {
                                            Model model = (Model) wall.primary;
                                            if (model.verticesNormal != null) {
                                                mergeNormals(arg0, model, (i_214_ - arg2) * 128 + (1 - arg4) * 64, i_216_, (i_215_ - arg3) * 128 + (1 - arg5) * 64, bool);
                                            }
                                        }
                                        if (wall.secondary instanceof Model) {
                                            Model model = (Model) wall.secondary;
                                            if (model.verticesNormal != null) {
                                                mergeNormals(arg0, model, (i_214_ - arg2) * 128 + (1 - arg4) * 64, i_216_, (i_215_ - arg3) * 128 + (1 - arg5) * 64, bool);
                                            }
                                        }
                                    }
                                    for (int i_217_ = 0; i_217_ < sceneTile.entityCount; i_217_++) {
                                        InteractiveObject interactiveObject = sceneTile.interactiveObjects[i_217_];
                                        if (interactiveObject != null && interactiveObject.renderable instanceof Model) {
                                            Model model = (Model) interactiveObject.renderable;
                                            if (model.verticesNormal != null) {
                                                int i_218_ = interactiveObject.tileRight - interactiveObject.tileLeft + 1;
                                                int i_219_ = interactiveObject.tileBottom - interactiveObject.tileTop + 1;
                                                mergeNormals(arg0, model, (interactiveObject.tileLeft - arg2) * 128 + (i_218_ - arg4) * 64, i_216_, (interactiveObject.tileTop - arg3) * 128 + (i_219_ - arg5) * 64, bool);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i--;
                bool = false;
            }
        }
    }

    public void setDrawLevel(int arg0, int arg1, int arg2, int arg3) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if (sceneTile != null) {
            tileArray[arg0][arg1][arg2].drawLevel = arg3;
        }
    }

    public void removeFloorDecoration(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if (sceneTile != null) {
            sceneTile.floorDecoration = null;
        }
    }

    public void addGroundDecoration(int x, int y, int z, int drawHeight, int hash, Renderable renderable, int config) {
        if (renderable != null) {
            FloorDecoration floorDecoration = new FloorDecoration();
            floorDecoration.renderable = renderable;
            floorDecoration.x = x * 128 + 64;
            floorDecoration.y = y * 128 + 64;
            floorDecoration.z = drawHeight;
            floorDecoration.hash = hash;
            floorDecoration.config = config;
            if (tileArray[z][x][y] == null) {
                tileArray[z][x][y] = new SceneTile(z, x, y);
            }
            tileArray[z][x][y].floorDecoration = floorDecoration;
        }
    }

    public FloorDecoration getFloorDecoration(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if (sceneTile == null || sceneTile.floorDecoration == null) {
            return null;
        }
        return sceneTile.floorDecoration;
    }

    public boolean method134(int arg0, int arg1, int arg2, int arg3, int arg4, Renderable arg5, int arg6, int arg7, boolean arg8) {
        if (arg5 == null) {
            return true;
        }
        int i = arg1 - arg4;
        int i_220_ = arg2 - arg4;
        int i_221_ = arg1 + arg4;
        int i_222_ = arg2 + arg4;
        if (arg8) {
            if (arg6 > 640 && arg6 < 1408) {
                i_222_ += 128;
            }
            if (arg6 > 1152 && arg6 < 1920) {
                i_221_ += 128;
            }
            if (arg6 > 1664 || arg6 < 384) {
                i_220_ -= 128;
            }
            if (arg6 > 128 && arg6 < 896) {
                i -= 128;
            }
        }
        i /= 128;
        i_220_ /= 128;
        i_221_ /= 128;
        i_222_ /= 128;
        return addRenderableC(i, i_220_, arg0, arg1, arg2, arg3, arg6, i_222_ - i_220_ + 1, i_221_ - i + 1, arg7, arg5, true, 0);
    }

    public void removeInteractiveObject(int z, int x, int y) {
        SceneTile sceneTile = tileArray[z][x][y];
        if (sceneTile == null) {
            return;
        }
        for (int e = 0; e < sceneTile.entityCount; e++) {
            InteractiveObject interactiveObject = sceneTile.interactiveObjects[e];
            if ((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == x && interactiveObject.tileTop == y) {
                remove(interactiveObject);
                break;
            }
        }
    }

    public void setPlane(int plane) {
        this.plane = plane;
        for (int x = 0; x < mapSizeX; x++) {
            for (int y = 0; y < mapSizeY; y++) {
                if (tileArray[plane][x][y] == null) {
                    tileArray[plane][x][y] = new SceneTile(plane, x, y);
                }
            }
        }
    }

    public boolean addEntityB(int x, int y, int z, int worldZ, int rotation, int tileWidth, int tileHeight, int uid, Renderable entity, int config) {
        if (entity == null) {
            return true;
        }
        int worldX = x * 128 + 64 * tileHeight;
        int worldY = y * 128 + 64 * tileWidth;
        return addRenderableC(x, y, z, worldX, worldY, worldZ, rotation, tileWidth, tileHeight, uid, entity, false, config);
    }

    public void renderShapedTile(ComplexTile shapedTile, int tileX, int tileY) {
        int sineX = currentCameraRotation.yawSine;
        int cosineX = currentCameraRotation.yawCosine;
        int sineY = currentCameraRotation.pitchSine;
        int cosineY = currentCameraRotation.pitchCosine;


        int triangleCount = shapedTile.originalVertexX.length;
        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int viewX = shapedTile.originalVertexX[triangle] - currentCameraX;
            int viewY = shapedTile.originalVertexY[triangle] - currentCameraZ;
            int viewZ = shapedTile.originalVertexZ[triangle] - currentCameraY;
            int temp = viewZ * sineX + viewX * cosineX >> 16;
            viewZ = viewZ * cosineX - viewX * sineX >> 16;
            viewX = temp;
            temp = viewY * cosineY - viewZ * sineY >> 16;
            viewZ = viewY * sineY + viewZ * cosineY >> 16;
            viewY = temp;
            if (viewZ < 50) {
                return;
            }
            if (shapedTile.triangleTexture != null) {
                viewspaceX[triangle] = viewX;
                viewspaceY[triangle] = viewY;
                viewspaceZ[triangle] = viewZ;
            }
            screenX[triangle] = Rasterizer3D.center_x + (viewX << 9) / viewZ;
            screenY[triangle] = Rasterizer3D.center_y + (viewY << 9) / viewZ;
        }
        Rasterizer3D.alpha = 0;
        triangleCount = shapedTile.triangleA.length;
        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int a = shapedTile.triangleA[triangle];
            int b = shapedTile.triangleB[triangle];
            int c = shapedTile.triangleC[triangle];
            int screenXA = screenX[a];
            int screenXB = screenX[b];
            int screenXC = screenX[c];
            int screenYA = screenY[a];
            int screenYB = screenY[b];
            int screenYC = screenY[c];
            if ((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB) > 0) {
                Rasterizer3D.restrict_edges = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx;
                if (clicked && isMouseWithinTriangle(clickX, clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                    clickedTileX = tileX;
                    clickedTileY = tileY;
                }

                if (isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                    hoveredTileX = tileX;
                    hoveredTileY = tileY;
                }

                if (shapedTile.triangleTexture == null || shapedTile.triangleTexture[triangle] == -1) {
                    if (shapedTile.triangleHSLA[triangle] != 0xbc614e) {
                        Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle]);
                    }
                } else if (lowMemory) {
                    int i_240_ = Rasterizer3D.interface3.getAverageTextureColour(shapedTile.triangleTexture[triangle]);
                    Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, adjustLightness(i_240_, shapedTile.triangleHSLA[triangle]), adjustLightness(i_240_, shapedTile.triangleHSLB[triangle]), adjustLightness(i_240_, shapedTile.triangleHSLC[triangle]));
                } else if (shapedTile.flat) {
                    Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle], viewspaceX[0], viewspaceX[1], viewspaceX[3], viewspaceY[0], viewspaceY[1], viewspaceY[3], viewspaceZ[0], viewspaceZ[1], viewspaceZ[3], shapedTile.triangleTexture[triangle]);
                } else {
                    Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle], viewspaceX[a], viewspaceX[b], viewspaceX[c], viewspaceY[a], viewspaceY[b], viewspaceY[c], viewspaceZ[a], viewspaceZ[b], viewspaceZ[c], shapedTile.triangleTexture[triangle]);
                }
            }
        }
    }

    public void addGroundItemTile(int x, int y, int z, int drawHeight, int hash, Renderable firstGroundItem, Renderable secondGroundItem, Renderable thirdGroundItem) {
        GroundItemTile groundItemTile = new GroundItemTile();
        groundItemTile.firstGroundItem = firstGroundItem;
        groundItemTile.x = x * 128 + 64;
        groundItemTile.y = y * 128 + 64;
        groundItemTile.z = drawHeight;
        groundItemTile.hash = hash;
        groundItemTile.secondGroundItem = secondGroundItem;
        groundItemTile.thirdGroundItem = thirdGroundItem;
        int i = 0;
        SceneTile sceneTile = tileArray[z][x][y];
        if (sceneTile != null) {
            for (int e = 0; e < sceneTile.entityCount; e++) {
                if ((sceneTile.interactiveObjects[e].config & 0x100) == 256 && sceneTile.interactiveObjects[e].renderable instanceof Model) {
                    Model model = (Model) sceneTile.interactiveObjects[e].renderable;
                    model.method799();
                    if (model.modelHeight > i) {
                        i = model.modelHeight;
                    }
                }
            }
        }
        groundItemTile.anInt1371 = i;
        if (tileArray[z][x][y] == null) {
            tileArray[z][x][y] = new SceneTile(z, x, y);
        }
        tileArray[z][x][y].groundItemTile = groundItemTile;
    }

    public boolean addRenderableC(int minX, int minY, int z, int worldX, int worldY, int worldZ, int rotation, int tileWidth, int tileHeight, int hash, Renderable renderable, boolean isDynamic, int config) {
        for (int x = minX; x < minX + tileHeight; x++) {
            for (int y = minY; y < minY + tileWidth; y++) {
                if (x < 0 || y < 0 || x >= mapSizeX || y >= mapSizeY) {
                    return false;
                }
                SceneTile sceneTile = tileArray[z][x][y];
                if (sceneTile != null && sceneTile.entityCount >= 5) {
                    return false;
                }
            }
        }
        InteractiveObject interactiveObject = new InteractiveObject();
        interactiveObject.hash = hash;
        interactiveObject.config = config;
        interactiveObject.z = z;
        interactiveObject.worldX = worldX;
        interactiveObject.worldY = worldY;
        interactiveObject.worldZ = worldZ;
        interactiveObject.renderable = renderable;
        interactiveObject.rotation = rotation;
        interactiveObject.tileLeft = minX;
        interactiveObject.tileTop = minY;
        interactiveObject.tileRight = minX + tileHeight - 1;
        interactiveObject.tileBottom = minY + tileWidth - 1;
        for (int i = minX; i < minX + tileHeight; i++) {
            for (int i_243_ = minY; i_243_ < minY + tileWidth; i_243_++) {
                int i_244_ = 0;
                if (i > minX) {
                    i_244_++;
                }
                if (i < minX + tileHeight - 1) {
                    i_244_ += 4;
                }
                if (i_243_ > minY) {
                    i_244_ += 8;
                }
                if (i_243_ < minY + tileWidth - 1) {
                    i_244_ += 2;
                }
                for (int i_245_ = z; i_245_ >= 0; i_245_--) {
                    if (tileArray[i_245_][i][i_243_] == null) {
                        tileArray[i_245_][i][i_243_] = new SceneTile(i_245_, i, i_243_);
                    }
                }
                SceneTile sceneTile = tileArray[z][i][i_243_];
                sceneTile.interactiveObjects[sceneTile.entityCount] = interactiveObject;
                sceneTile.sceneSpawnRequestsSize[sceneTile.entityCount] = i_244_;
                sceneTile.interactiveObjectsSizeOR |= i_244_;
                sceneTile.entityCount++;
            }
        }
        if (isDynamic) {
            sceneSpawnRequestsCache[sceneSpawnRequestsCacheCurrentPos++] = interactiveObject;
        }
        return true;
    }

    public int getArrangement(int z, int x, int y, int hash) {
        SceneTile sceneTile = tileArray[z][x][y];
        if (sceneTile == null) {
            return -1;
        }
        if (sceneTile.wall != null && sceneTile.wall.hash == hash) {
            return sceneTile.wall.config & 0xff;
        }
        if (sceneTile.wallDecoration != null && sceneTile.wallDecoration.hash == hash) {
            return sceneTile.wallDecoration.config & 0xff;
        }
        if (sceneTile.floorDecoration != null && sceneTile.floorDecoration.hash == hash) {
            return sceneTile.floorDecoration.config & 0xff;
        }
        for (int i = 0; i < sceneTile.entityCount; i++) {
            if (sceneTile.interactiveObjects[i].hash == hash) {
                return sceneTile.interactiveObjects[i].config & 0xff;
            }
        }
        return -1;
    }

    public boolean isMouseWithinTriangle(int mouseX, int mouseY, int pointAY, int pointBY, int pointCY, int pointAX, int pointBX, int pointCX) {
        if (mouseY < pointAY && mouseY < pointBY && mouseY < pointCY) {
            return false;
        }
        if (mouseY > pointAY && mouseY > pointBY && mouseY > pointCY) {
            return false;
        }
        if (mouseX < pointAX && mouseX < pointBX && mouseX < pointCX) {
            return false;
        }
        if (mouseX > pointAX && mouseX > pointBX && mouseX > pointCX) {
            return false;
        }
        int b1 = (mouseY - pointAY) * (pointBX - pointAX) - (mouseX - pointAX) * (pointBY - pointAY);
        int b2 = (mouseY - pointCY) * (pointAX - pointCX) - (mouseX - pointCX) * (pointAY - pointCY);
        int b3 = (mouseY - pointBY) * (pointCX - pointBX) - (mouseX - pointBX) * (pointCY - pointBY);
        return b1 * b3 > 0 && b3 * b2 > 0;
    }

    /**
     * Returns the floor height at a given x,y coordinate in 3D space.
     * The calculation takes into account the surrounding tile heights and the specific position within a tile,
     * performing a form of bilinear interpolation to determine the precise height.
     *
     * @param plane The current plane (or level) within the 3D space
     * @param x The x coordinate in the 3D space
     * @param y The y coordinate in the 3D space
     * @param tileHeights A 3D array containing the heights of each tile
     * @param tileFlags A 3D array containing the flags for each tile (e.g. whether it's a bridge)
     * @return The height of the floor at the given x,y coordinate
     */
    public int getFloorDrawHeight(int plane, int x, int y, int[][][] tileHeights, byte[][][] tileFlags) {
        // Convert x and y into 'tile space' by dividing by 128 (right shifting by 7 bits)
        int groundX = x >> 7;
        int groundY = y >> 7;

        // Check if the x and y values in 'tile space' are within the game world (0-103 inclusive)
        if(groundX < 0 || groundY < 0 || groundX > 103 || groundY > 103)
            return 0;

        // Initialize groundZ as the given plane level
        int groundZ = plane;

        // If we're not on the top plane and we're on a bridge tile (indicated by the tile flag)
        // then we increment the Z coordinate to take into account the bridge's height
        if(groundZ < 3 && (tileFlags[1][groundX][groundY] & 0x2) == 2)
            groundZ++;

        // Calculate the position within the tile on X-axis and Y-axis (range 0 to 127)
        int tilePositionX = x & 0x7f;
        int tilePositionY = y & 0x7f;

        // Interpolate the height for the X-axis at Y position 'groundY' based on tile position X
        // It's a weighted average between the height at groundX and groundX+1
        int interpolatedHeightX1 = ((128 - tilePositionX) * tileHeights[groundZ][groundX][groundY] + tilePositionX * tileHeights[groundZ][groundX + 1][groundY]) >> 7;

        // Interpolate the height for the X-axis at Y position 'groundY+1' based on tile position X
        // Similar to above, but one step forward in the Y-axis
        int interpolatedHeightX2 = (tilePositionX * tileHeights[groundZ][groundX + 1][groundY + 1] + tileHeights[groundZ][groundX][groundY + 1] * (128 - tilePositionX)) >> 7;

        // Interpolate between the two interpolated X-axis heights, based on the tile position Y
        // This results in a height that takes into account the position within the tile in both the X and Y directions
        return ((128 - tilePositionY) * interpolatedHeightX1 + interpolatedHeightX2 * tilePositionY) >> 7;

    }

    public int getFloorDrawHeight(int plane, int x, int y) {
        return getFloorDrawHeight(plane, x, y, Landscape.tile_height, MovedStatics.tile_flags);
    }
}
