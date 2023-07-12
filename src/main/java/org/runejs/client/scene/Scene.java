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

    public static int[] ROTATION_WALL_TYPE = {1, 2, 4, 8};
    public static int[] ROTATION_WALL_CORNER_TYPE = new int[]{16, 32, 64, 128};

    public static boolean lowMemory = true;

    public final Landscape landscape;

    public SceneTile[][][] tileArray;
    public int[][][] tileOcclusionCycles;
    public int sceneSpawnRequestsCacheCurrentPos = 0;
    public InteractiveObject[] sceneSpawnRequestsCache = new InteractiveObject[5000];
    public int plane = 0;
    public int[][][] heightMap;
    public int mergeIndexTmp = 0;
    public int[] mergeIndexA = new int[10000];
    public int[] mergeIndexB = new int[10000];

    public int anInt109 = 0;
    public int cycle;

    public boolean clicked = false;
    public int clickX = 0;
    public int clickY = 0;

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

    public int mapSizeX = 104;
    public int mapSizeY = 104;
    public int mapSizeZ = 4;

    public int activeOccluderCount = 0;
    public SceneCluster[][] cullingClusters = new SceneCluster[mapSizeZ][500];
    public SceneCluster[] processedCullingClusters = new SceneCluster[500];
    public int[] cullingClusterPointer = new int[mapSizeZ];

    public InteractiveObject[] interactiveObjects = new InteractiveObject[100];

    public Scene() {
        this.landscape = new Landscape(this);
        tileArray = new SceneTile[mapSizeZ][mapSizeX][mapSizeY];
        tileOcclusionCycles = new int[mapSizeZ][mapSizeX + 1][mapSizeY + 1];
        this.heightMap = this.landscape.tile_height;
        initToNull();
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

    public boolean isWallOccluded(Camera currentCamera, int level, int x, int y, int wallType) {
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
                if (posX > currentCamera.getPosition().x) {
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
                if (posY < currentCamera.getPosition().y) {
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
                if (posX < currentCamera.getPosition().x) {
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
                if (posY > currentCamera.getPosition().y) {
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



    /**
     * Returns the floor height at a given x,y coordinate in 3D space.
     * The calculation takes into account the surrounding tile heights and the specific position within a tile,
     * performing a form of bilinear interpolation to determine the precise height.
     *
     * @param plane The current plane (or level) within the 3D space
     * @param x The x coordinate in the 3D space
     * @param y The y coordinate in the 3D space
     * @param tileFlags A 3D array containing the flags for each tile (e.g. whether it's a bridge)
     * @return The height of the floor at the given x,y coordinate
     */
    public int getFloorDrawHeight(int plane, int x, int y, byte[][][] tileFlags) {
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
        int interpolatedHeightX1 = ((128 - tilePositionX) * landscape.tile_height[groundZ][groundX][groundY] + tilePositionX * landscape.tile_height[groundZ][groundX + 1][groundY]) >> 7;

        // Interpolate the height for the X-axis at Y position 'groundY+1' based on tile position X
        // Similar to above, but one step forward in the Y-axis
        int interpolatedHeightX2 = (tilePositionX * landscape.tile_height[groundZ][groundX + 1][groundY + 1] + landscape.tile_height[groundZ][groundX][groundY + 1] * (128 - tilePositionX)) >> 7;

        // Interpolate between the two interpolated X-axis heights, based on the tile position Y
        // This results in a height that takes into account the position within the tile in both the X and Y directions
        return ((128 - tilePositionY) * interpolatedHeightX1 + interpolatedHeightX2 * tilePositionY) >> 7;

    }

    public int getFloorDrawHeight(int plane, int x, int y) {
        return getFloorDrawHeight(plane, x, y, MovedStatics.tile_flags);
    }
}
