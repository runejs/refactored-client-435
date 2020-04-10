package com.jagex.runescape.scene;

import com.jagex.runescape.Class13;
import com.jagex.runescape.Landscape;
import com.jagex.runescape.LinkedList;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.scene.tile.*;

import java.util.Arrays;

public class Scene {
    public static int cameraPosX;
    public static int clickY = 0;
    public static int clickedTileX = -1;
    public static int cameraPositionTileX;
    public static int[] faceOffsetX2 = new int[]{53, -53, -53, 53};
    public static int clickedTileY = -1;
    public static int hoveredTileY = -1;
    public static int hoveredTileX = -1;
    public static int anInt82;
    public static int anInt84;
    public static int anInt85 = 0;
    public static int cycle;
    public static int anInt87;
    public static boolean lowMemory = true;
    public static int cameraPosZ;
    public static int anInt90 = 4;
    public static int clickX = 0;
    public static int[] faceOffsetX3 = new int[]{-45, 45, 45, -45};
    public static int anInt95;
    public static int anInt96 = 0;
    public static int cameraPosY;
    public static int anInt99;
    public static int cameraPositionTileY;
    public static int[] cullingClusterPointer = new int[anInt90];
    public static int[] faceOffsetY3 = new int[]{45, 45, -45, -45};
    public static int anInt104;
    public static InteractiveObject[] interactiveObjects = new InteractiveObject[100];
    public static SceneCluster[] processedCullingClusters = new SceneCluster[500];
    public static LinkedList tileList = new LinkedList();
    public static int anInt109 = 0;
    public static int anInt110;
    public static int anInt111;
    public static int[] faceOffsetY2 = new int[]{-53, -53, 53, 53};
    public static SceneCluster[][] cullingClusters = new SceneCluster[anInt90][500];
    public static boolean clicked = false;
    public static int[] anIntArray117 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
    public static int anInt118;
    public static int[] anIntArray119 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
    public static int[] anIntArray120 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
    public static int anInt122;
    public static int anInt124;
    public static int[] anIntArray125 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
    public static int anInt128;
    public static int[] anIntArray130 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
    public static int[] anIntArray131 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
    public static int[] anIntArray132 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
    public static boolean[][] aBooleanArrayArray133;
    public static boolean[][][][] aBooleanArrayArrayArrayArray134 = new boolean[8][32][51][51];
    public static int anInt135;
    public static int anInt136;

    public SceneTile[][][] tileArray;
    public int[][][] anIntArrayArrayArray83;
    public int sceneSpawnRequestsCacheCurrentPos;
    public InteractiveObject[] sceneSpawnRequestsCache = new InteractiveObject[5000];
    public int mapSizeX;
    public int currentPositionZ = 0;
    public int[][][] heightMap;
    public int mapSizeZ;
    public int mapSizeY;
    public int[][] anIntArrayArray121;
    public int[] anIntArray123;
    public int anInt126;
    public int[] anIntArray127;
    public int[][] anIntArrayArray129;

    public Scene(int[][][] heightMap) {
        final int length = 104;// was parameter
        final int width = 104;// was parameter
        final int height = 4;// was parameter
        sceneSpawnRequestsCacheCurrentPos = 0;
        anIntArrayArray121 = (new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}});
        anIntArray123 = new int[10000];
        anInt126 = 0;
        anIntArray127 = new int[10000];
        anIntArrayArray129 = new int[][]{new int[16], {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
        mapSizeZ = height;
        mapSizeX = width;
        mapSizeY = length;
        tileArray = new SceneTile[height][width][length];
        anIntArrayArrayArray83 = new int[height][width + 1][length + 1];
        this.heightMap = heightMap;
        initToNull();
    }

    public static void method95(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
        anInt118 = 0;
        anInt124 = 0;
        anInt136 = arg3;
        anInt128 = arg4;
        anInt122 = arg3 / 2;
        anInt135 = arg4 / 2;
        boolean[][][][] bools = new boolean[9][32][53][53];
        for(int i = 128; i <= 384; i += 32) {
            for(int i_2_ = 0; i_2_ < 2048; i_2_ += 64) {
                anInt82 = Model.SINE[i];
                anInt110 = Model.COSINE[i];
                anInt104 = Model.SINE[i_2_];
                anInt99 = Model.COSINE[i_2_];
                int i_3_ = (i - 128) / 32;
                int i_4_ = i_2_ / 64;
                for(int i_5_ = -26; i_5_ <= 26; i_5_++) {
                    for(int i_6_ = -26; i_6_ <= 26; i_6_++) {
                        int i_7_ = i_5_ * 128;
                        int i_8_ = i_6_ * 128;
                        boolean bool = false;
                        for(int i_9_ = -arg1; i_9_ <= arg2; i_9_ += 128) {
                            if(method113(i_7_, arg0[i_3_] + i_9_, i_8_)) {
                                bool = true;
                                break;
                            }
                        }
                        bools[i_3_][i_4_][i_5_ + 25 + 1][i_6_ + 25 + 1] = bool;
                    }
                }
            }
        }
        for(int i = 0; i < 8; i++) {
            for(int i_10_ = 0; i_10_ < 32; i_10_++) {
                for(int i_11_ = -25; i_11_ < 25; i_11_++) {
                    for(int i_12_ = -25; i_12_ < 25; i_12_++) {
                        boolean bool = false;
                        while_0_:
                        for(int i_13_ = -1; i_13_ <= 1; i_13_++) {
                            for(int i_14_ = -1; i_14_ <= 1; i_14_++) {
                                if(bools[i][i_10_][i_11_ + i_13_ + 25 + 1][i_12_ + i_14_ + 25 + 1]) {
                                    bool = true;
                                    break while_0_;
                                }
                                if(bools[i][(i_10_ + 1) % 31][i_11_ + i_13_ + 25 + 1][i_12_ + i_14_ + 25 + 1]) {
                                    bool = true;
                                    break while_0_;
                                }
                                if(bools[i + 1][i_10_][i_11_ + i_13_ + 25 + 1][i_12_ + i_14_ + 25 + 1]) {
                                    bool = true;
                                    break while_0_;
                                }
                                if(bools[i + 1][(i_10_ + 1) % 31][i_11_ + i_13_ + 25 + 1][i_12_ + i_14_ + 25 + 1]) {
                                    bool = true;
                                    break while_0_;
                                }
                            }
                        }
                        aBooleanArrayArrayArrayArray134[i][i_10_][i_11_ + 25][i_12_ + 25] = bool;
                    }
                }
            }
        }
    }

    public static int method108(int arg0, int arg1) {
        arg1 = (127 - arg1) * (arg0 & 0x7f) >> 7;
        if(arg1 < 2) {
            arg1 = 2;
        } else if(arg1 > 126) {
            arg1 = 126;
        }
        return (arg0 & 0xff80) + arg1;
    }

    public static boolean method113(int arg0, int arg1, int arg2) {
        int i = arg2 * anInt104 + arg0 * anInt99 >> 16;
        int i_145_ = arg2 * anInt99 - arg0 * anInt104 >> 16;
        int i_146_ = arg1 * anInt82 + i_145_ * anInt110 >> 16;
        int i_147_ = arg1 * anInt110 - i_145_ * anInt82 >> 16;
        if(i_146_ < 50 || i_146_ > 3500) {
            return false;
        }
        int i_148_ = anInt122 + (i << 9) / i_146_;
        int i_149_ = anInt135 + (i_147_ << 9) / i_146_;
        return i_148_ >= anInt118 && i_148_ <= anInt136 && i_149_ >= anInt124 && i_149_ <= anInt128;
    }

    public static void method114() {
        interactiveObjects = null;
        faceOffsetX2 = null;
        faceOffsetY2 = null;
        faceOffsetX3 = null;
        faceOffsetY3 = null;
        cullingClusterPointer = null;
        cullingClusters = null;
        processedCullingClusters = null;
        tileList = null;
        anIntArray120 = null;
        anIntArray117 = null;
        anIntArray130 = null;
        anIntArray119 = null;
        anIntArray125 = null;
        anIntArray132 = null;
        anIntArray131 = null;
        aBooleanArrayArrayArrayArray134 = null;
        aBooleanArrayArray133 = null;
    }

    public static void method116(int z, int searchMask, int lowestX, int highestX, int lowestY, int highestY, int highestZ, int lowestZ) {
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

    public int method91(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null || sceneTile.wallDecoration == null) {
            return 0;
        }
        return sceneTile.wallDecoration.hash;
    }

    public void method92(int arg0, int arg1) {
        SceneTile sceneTile = tileArray[0][arg0][arg1];
        for(int i = 0; i < 3; i++) {
            SceneTile sceneTile_0_ = (tileArray[i][arg0][arg1] = tileArray[i + 1][arg0][arg1]);
            if(sceneTile_0_ != null) {
                sceneTile_0_.anInt2066--;
                for(int i_1_ = 0; i_1_ < sceneTile_0_.entityCount; i_1_++) {
                    InteractiveObject interactiveObject = sceneTile_0_.interactiveObjects[i_1_];
                    if((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == arg0 && interactiveObject.tileTop == arg1) {
                        interactiveObject.z--;
                    }
                }
            }
        }
        if(tileArray[0][arg0][arg1] == null) {
            tileArray[0][arg0][arg1] = new SceneTile(0, arg0, arg1);
        }
        tileArray[0][arg0][arg1].aSceneTile_2058 = sceneTile;
        tileArray[3][arg0][arg1] = null;
    }

    public int getFloorDecorationHash(int z, int x, int y) {
        SceneTile sceneTile = tileArray[z][x][y];
        if(sceneTile == null || sceneTile.floorDecoration == null) {
            return 0;
        }
        return sceneTile.floorDecoration.hash;
    }

    public void addWall(int x, int y, int z, int drawHeight, int orientation, int orientation2, int hash, Renderable primary, Renderable secondary, int config) {
        if(primary != null || secondary != null) {
            Wall wall = new Wall();
            wall.hash = hash;
            wall.config = config;
            wall.x = x * 128 + 64;
            wall.y = y * 128 + 64;
            wall.z = drawHeight;
            wall.primary = primary;
            wall.secondary = secondary;
            wall.orientation = orientation;
            wall.orientation2 = orientation2;
            for(int _z = z; _z >= 0; _z--) {
                if(tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[z][x][y].wall = wall;
        }
    }

    public void method96(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        SceneTile sceneTile = tileArray[arg3][arg4][arg5];
        if(sceneTile != null) {
            GenericTile genericTile = sceneTile.plainTile;
            if(genericTile == null) {
                ComplexTile complexTile = sceneTile.shapedTile;
                if(complexTile != null) {
                    int i = complexTile.shape;
                    int i_16_ = complexTile.rotation;
                    int i_17_ = complexTile.underlayRGB;
                    int i_18_ = complexTile.overlayRGB;
                    int[] is = anIntArrayArray129[i];
                    int[] is_19_ = anIntArrayArray121[i_16_];
                    int i_20_ = 0;
                    if(i_17_ == 0) {
                        for(int i_22_ = 0; i_22_ < 4; i_22_++) {
                            if(is[is_19_[i_20_++]] != 0) {
                                arg0[arg1] = i_18_;
                            }
                            if(is[is_19_[i_20_++]] != 0) {
                                arg0[arg1 + 1] = i_18_;
                            }
                            if(is[is_19_[i_20_++]] != 0) {
                                arg0[arg1 + 2] = i_18_;
                            }
                            if(is[is_19_[i_20_++]] != 0) {
                                arg0[arg1 + 3] = i_18_;
                            }
                            arg1 += arg2;
                        }
                    } else {
                        for(int i_21_ = 0; i_21_ < 4; i_21_++) {
                            arg0[arg1] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg0[arg1 + 1] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg0[arg1 + 2] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg0[arg1 + 3] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg1 += arg2;
                        }
                    }
                }
            } else {
                int i = genericTile.rgbColor;
                if(i != 0) {
                    for(int i_15_ = 0; i_15_ < 4; i_15_++) {
                        arg0[arg1] = i;
                        arg0[arg1 + 1] = i;
                        arg0[arg1 + 2] = i;
                        arg0[arg1 + 3] = i;
                        arg1 += arg2;
                    }
                }
            }
        }
    }

    public void render(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 < 0) {
            arg0 = 0;
        } else if(arg0 >= mapSizeX * 128) {
            arg0 = mapSizeX * 128 - 1;
        }
        if(arg2 < 0) {
            arg2 = 0;
        } else if(arg2 >= mapSizeY * 128) {
            arg2 = mapSizeY * 128 - 1;
        }
        cycle++;
        anInt82 = Model.SINE[arg3];
        anInt110 = Model.COSINE[arg3];
        anInt104 = Model.SINE[arg4];
        anInt99 = Model.COSINE[arg4];
        aBooleanArrayArray133 = aBooleanArrayArrayArrayArray134[(arg3 - 128) / 32][arg4 / 64];
        cameraPosX = arg0;
        cameraPosZ = arg1;
        cameraPosY = arg2;
        cameraPositionTileX = arg0 / 128;
        cameraPositionTileY = arg2 / 128;
        anInt85 = arg5;
        anInt95 = cameraPositionTileX - 25;
        if(anInt95 < 0) {
            anInt95 = 0;
        }
        anInt87 = cameraPositionTileY - 25;
        if(anInt87 < 0) {
            anInt87 = 0;
        }
        anInt84 = cameraPositionTileX + 25;
        if(anInt84 > mapSizeX) {
            anInt84 = mapSizeX;
        }
        anInt111 = cameraPositionTileY + 25;
        if(anInt111 > mapSizeY) {
            anInt111 = mapSizeY;
        }
        method123();
        anInt109 = 0;
        for(int i = currentPositionZ; i < mapSizeZ; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for(int i_23_ = anInt95; i_23_ < anInt84; i_23_++) {
                for(int i_24_ = anInt87; i_24_ < anInt111; i_24_++) {
                    SceneTile sceneTile = sceneTiles[i_23_][i_24_];
                    if(sceneTile != null) {
                        if(sceneTile.anInt2063 > arg5 || (!(aBooleanArrayArray133[i_23_ - cameraPositionTileX + 25][i_24_ - cameraPositionTileY + 25]) && (heightMap[i][i_23_][i_24_] - arg1) < 2000)) {
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
        for(int i = currentPositionZ; i < mapSizeZ; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for(int i_25_ = -25; i_25_ <= 0; i_25_++) {
                int i_26_ = cameraPositionTileX + i_25_;
                int i_27_ = cameraPositionTileX - i_25_;
                if(i_26_ >= anInt95 || i_27_ < anInt84) {
                    for(int i_28_ = -25; i_28_ <= 0; i_28_++) {
                        int i_29_ = cameraPositionTileY + i_28_;
                        int i_30_ = cameraPositionTileY - i_28_;
                        if(i_26_ >= anInt95) {
                            if(i_29_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_29_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, true);
                                }
                            }
                            if(i_30_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_30_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, true);
                                }
                            }
                        }
                        if(i_27_ < anInt84) {
                            if(i_29_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_29_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, true);
                                }
                            }
                            if(i_30_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_30_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, true);
                                }
                            }
                        }
                        if(anInt109 == 0) {
                            clicked = false;
                            return;
                        }
                    }
                }
            }
        }
        for(int i = currentPositionZ; i < mapSizeZ; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for(int i_31_ = -25; i_31_ <= 0; i_31_++) {
                int i_32_ = cameraPositionTileX + i_31_;
                int i_33_ = cameraPositionTileX - i_31_;
                if(i_32_ >= anInt95 || i_33_ < anInt84) {
                    for(int i_34_ = -25; i_34_ <= 0; i_34_++) {
                        int i_35_ = cameraPositionTileY + i_34_;
                        int i_36_ = cameraPositionTileY - i_34_;
                        if(i_32_ >= anInt95) {
                            if(i_35_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_35_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, false);
                                }
                            }
                            if(i_36_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_36_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, false);
                                }
                            }
                        }
                        if(i_33_ < anInt84) {
                            if(i_35_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_35_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, false);
                                }
                            }
                            if(i_36_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_36_];
                                if(sceneTile != null && sceneTile.draw) {
                                    method106(sceneTile, false);
                                }
                            }
                        }
                        if(anInt109 == 0) {
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
        for(int z = 0; z < mapSizeZ; z++) {
            for(int x = 0; x < mapSizeX; x++) {
                for(int y = 0; y < mapSizeY; y++) {
                    tileArray[z][x][y] = null;
                }
            }
        }
        for(int i = 0; i < anInt90; i++) {
            for(int i_39_ = 0; i_39_ < cullingClusterPointer[i]; i_39_++) {
                cullingClusters[i][i_39_] = null;
            }
            cullingClusterPointer[i] = 0;
        }
        for(int i = 0; i < sceneSpawnRequestsCacheCurrentPos; i++) {
            sceneSpawnRequestsCache[i] = null;
        }
        sceneSpawnRequestsCacheCurrentPos = 0;
        Arrays.fill(interactiveObjects, null);
    }

    public void addTile(int plane, int x, int y, int shape, int clippingPathRotation, int textureId, int vertexHeightSW, int vertexHeightSE, int vertexHeightNE, int vertexHeightNW, int cA, int cB, int cD, int cC, int colourA, int colourB, int colourD, int colourC, int underlayRGB, int overlayRGB) {
        if(shape == 0) {
            GenericTile genericTile = new GenericTile(cA, cB, cC, cD, -1, underlayRGB, false);
            for(int _z = plane; _z >= 0; _z--) {
                if(tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[plane][x][y].plainTile = genericTile;
        } else if(shape == 1) {
            GenericTile genericTile = new GenericTile(colourA, colourB, colourC, colourD, textureId, overlayRGB, vertexHeightSW == vertexHeightSE && vertexHeightSW == vertexHeightNE && vertexHeightSW == vertexHeightNW);
            for(int _z = plane; _z >= 0; _z--) {
                if(tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[plane][x][y].plainTile = genericTile;
        } else {
            ComplexTile complexTile = new ComplexTile(x, vertexHeightSW, vertexHeightSE, vertexHeightNW, vertexHeightNE, y, clippingPathRotation, textureId, shape, cA, colourA, cB, colourB, cD, colourD, cC, colourC, overlayRGB, underlayRGB);
            for(int _z = plane; _z >= 0; _z--) {
                if(tileArray[_z][x][y] == null) {
                    tileArray[_z][x][y] = new SceneTile(_z, x, y);
                }
            }
            tileArray[plane][x][y].shapedTile = complexTile;
        }
    }

    public WallDecoration getWallDecoration(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if(sceneTile == null) {
            return null;
        }
        return sceneTile.wallDecoration;
    }

    public boolean isTileOccluded(int x, int y, int z) {
        int i = anIntArrayArrayArray83[z][x][y];
        if(i == -cycle) {
            return false;
        }
        if(i == cycle) {
            return true;
        }
        int worldX = x << 7;
        int worldY = y << 7;
        if(method103(worldX + 1, heightMap[z][x][y], worldY + 1) && method103(worldX + 128 - 1, heightMap[z][x + 1][y], worldY + 1) && method103(worldX + 128 - 1, heightMap[z][x + 1][y + 1], worldY + 128 - 1) && method103(worldX + 1, heightMap[z][x][y + 1], worldY + 128 - 1)) {
            anIntArrayArrayArray83[z][x][y] = cycle;
            return true;
        }
        anIntArrayArrayArray83[z][x][y] = -cycle;
        return false;
    }

    public boolean isWallOccluded(int level, int x, int y, int wallType) {
        if(!isTileOccluded(x, y, level)) {
            return false;
        }
        int posX = x << 7;
        int posY = y << 7;
        int posZ = heightMap[level][x][y] - 1;
        int z1 = posZ - 120;
        int z2 = posZ - 230;
        int z3 = posZ - 238;
        if(wallType < 16) {
            if(wallType == 1) {
                if(posX > cameraPosX) {
                    if(!method103(posX, posZ, posY)) {
                        return false;
                    }
                    if(!method103(posX, posZ, posY + 128)) {
                        return false;
                    }
                }
                if(level > 0) {
                    if(!method103(posX, z1, posY)) {
                        return false;
                    }
                    if(!method103(posX, z1, posY + 128)) {
                        return false;
                    }
                }
                if(!method103(posX, z2, posY)) {
                    return false;
                }
                return method103(posX, z2, posY + 128);
            }
            if(wallType == 2) {
                if(posY < cameraPosY) {
                    if(!method103(posX, posZ, posY + 128)) {
                        return false;
                    }
                    if(!method103(posX + 128, posZ, posY + 128)) {
                        return false;
                    }
                }
                if(level > 0) {
                    if(!method103(posX, z1, posY + 128)) {
                        return false;
                    }
                    if(!method103(posX + 128, z1, posY + 128)) {
                        return false;
                    }
                }
                if(!method103(posX, z2, posY + 128)) {
                    return false;
                }
                return method103(posX + 128, z2, posY + 128);
            }
            if(wallType == 4) {
                if(posX < cameraPosX) {
                    if(!method103(posX + 128, posZ, posY)) {
                        return false;
                    }
                    if(!method103(posX + 128, posZ, posY + 128)) {
                        return false;
                    }
                }
                if(level > 0) {
                    if(!method103(posX + 128, z1, posY)) {
                        return false;
                    }
                    if(!method103(posX + 128, z1, posY + 128)) {
                        return false;
                    }
                }
                if(!method103(posX + 128, z2, posY)) {
                    return false;
                }
                return method103(posX + 128, z2, posY + 128);
            }
            if(wallType == 8) {
                if(posY > cameraPosY) {
                    if(!method103(posX, posZ, posY)) {
                        return false;
                    }
                    if(!method103(posX + 128, posZ, posY)) {
                        return false;
                    }
                }
                if(level > 0) {
                    if(!method103(posX, z1, posY)) {
                        return false;
                    }
                    if(!method103(posX + 128, z1, posY)) {
                        return false;
                    }
                }
                if(!method103(posX, z2, posY)) {
                    return false;
                }
                return method103(posX + 128, z2, posY);
            }
        }
        if(!method103(posX + 64, z3, posY + 64)) {
            return false;
        }
        if(wallType == 16) {
            return method103(posX, z2, posY + 128);
        }
        if(wallType == 32) {
            return method103(posX + 128, z2, posY + 128);
        }
        if(wallType == 64) {
            return method103(posX + 128, z2, posY);
        }
        if(wallType == 128) {
            return method103(posX, z2, posY);
        }
        return true;
    }

    public boolean method103(int posX, int posZ, int posY) {
        for(int i = 0; i < anInt96; i++) {
            SceneCluster sceneCluster = processedCullingClusters[i];
            if(sceneCluster.tileDistanceEnum == 1) {
                int i_47_ = sceneCluster.worldStartX - posX;
                if(i_47_ > 0) {
                    int i_48_ = sceneCluster.worldStartY + (sceneCluster.worldDistanceFromCameraStartY * i_47_ >> 8);
                    int i_49_ = sceneCluster.worldEndY + (sceneCluster.worldDistanceFromCameraEndY * i_47_ >> 8);
                    int i_50_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * i_47_ >> 8);
                    int i_51_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * i_47_ >> 8);
                    if(posY >= i_48_ && posY <= i_49_ && posZ >= i_50_ && posZ <= i_51_) {
                        return true;
                    }
                }
            } else if(sceneCluster.tileDistanceEnum == 2) {
                int i_52_ = posX - sceneCluster.worldStartX;
                if(i_52_ > 0) {
                    int i_53_ = sceneCluster.worldStartY + (sceneCluster.worldDistanceFromCameraStartY * i_52_ >> 8);
                    int i_54_ = sceneCluster.worldEndY + (sceneCluster.worldDistanceFromCameraEndY * i_52_ >> 8);
                    int i_55_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * i_52_ >> 8);
                    int i_56_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * i_52_ >> 8);
                    if(posY >= i_53_ && posY <= i_54_ && posZ >= i_55_ && posZ <= i_56_) {
                        return true;
                    }
                }
            } else if(sceneCluster.tileDistanceEnum == 3) {
                int i_57_ = sceneCluster.worldStartY - posY;
                if(i_57_ > 0) {
                    int i_58_ = sceneCluster.worldStartX + (sceneCluster.worldDistanceFromCameraStartX * i_57_ >> 8);
                    int i_59_ = sceneCluster.worldEndX + (sceneCluster.worldDistanceFromCameraEndX * i_57_ >> 8);
                    int i_60_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * i_57_ >> 8);
                    int i_61_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * i_57_ >> 8);
                    if(posX >= i_58_ && posX <= i_59_ && posZ >= i_60_ && posZ <= i_61_) {
                        return true;
                    }
                }
            } else if(sceneCluster.tileDistanceEnum == 4) {
                int i_62_ = posY - sceneCluster.worldStartY;
                if(i_62_ > 0) {
                    int i_63_ = sceneCluster.worldStartX + (sceneCluster.worldDistanceFromCameraStartX * i_62_ >> 8);
                    int i_64_ = sceneCluster.worldEndX + (sceneCluster.worldDistanceFromCameraEndX * i_62_ >> 8);
                    int i_65_ = sceneCluster.worldEndZ + (sceneCluster.worldDistanceFromCameraStartZ * i_62_ >> 8);
                    int i_66_ = sceneCluster.worldStartZ + (sceneCluster.worldDistanceFromCameraEndZ * i_62_ >> 8);
                    if(posX >= i_63_ && posX <= i_64_ && posZ >= i_65_ && posZ <= i_66_) {
                        return true;
                    }
                }
            } else if(sceneCluster.tileDistanceEnum == 5) {
                int i_67_ = posZ - sceneCluster.worldEndZ;
                if(i_67_ > 0) {
                    int i_68_ = sceneCluster.worldStartX + (sceneCluster.worldDistanceFromCameraStartX * i_67_ >> 8);
                    int i_69_ = sceneCluster.worldEndX + (sceneCluster.worldDistanceFromCameraEndX * i_67_ >> 8);
                    int i_70_ = sceneCluster.worldStartY + (sceneCluster.worldDistanceFromCameraStartY * i_67_ >> 8);
                    int i_71_ = sceneCluster.worldEndY + (sceneCluster.worldDistanceFromCameraEndY * i_67_ >> 8);
                    if(posX >= i_68_ && posX <= i_69_ && posY >= i_70_ && posY <= i_71_) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clearInteractiveObjectCache() {
        for(int i = 0; i < sceneSpawnRequestsCacheCurrentPos; i++) {
            InteractiveObject interactiveObject = sceneSpawnRequestsCache[i];
            remove(interactiveObject);
            sceneSpawnRequestsCache[i] = null;
        }
        sceneSpawnRequestsCacheCurrentPos = 0;
    }

    public void remove(InteractiveObject entity) {
        for(int x = entity.tileLeft; x <= entity.tileRight; x++) {
            for(int y = entity.tileTop; y <= entity.tileBottom; y++) {
                SceneTile tile = tileArray[entity.z][x][y];
                if(tile != null) {
                    for(int e = 0; e < tile.entityCount; e++) {
                        if(tile.interactiveObjects[e] == entity) {
                            tile.entityCount--;
                            for(int e2 = e; e2 < tile.entityCount; e2++) {
                                tile.interactiveObjects[e2] = (tile.interactiveObjects[e2 + 1]);
                                tile.sceneSpawnRequestsSize[e2] = tile.sceneSpawnRequestsSize[e2 + 1];
                            }
                            tile.interactiveObjects[(tile.entityCount)] = null;
                            break;
                        }
                    }
                    tile.interactiveObjectsSizeOR = 0;
                    for(int i_75_ = 0; i_75_ < tile.entityCount; i_75_++) {
                        tile.interactiveObjectsSizeOR |= tile.sceneSpawnRequestsSize[i_75_];
                    }
                }
            }
        }
    }

    public void method106(SceneTile arg0, boolean arg1) {
        tileList.pushBack(arg0, -69);
        for(; ; ) {
            SceneTile groundTile = (SceneTile) tileList.method913(25447);
            if(groundTile == null) {
                break;
            }
            if(groundTile.visible) {
                int i = groundTile.anInt2061;
                int i_76_ = groundTile.anInt2078;
                int i_77_ = groundTile.anInt2066;
                int i_78_ = groundTile.anInt2069;
                SceneTile[][] sceneTiles = tileArray[i_77_];
                if(groundTile.draw) {
                    if(arg1) {
                        if(i_77_ > 0) {
                            SceneTile sceneTile_79_ = (tileArray[i_77_ - 1][i][i_76_]);
                            if(sceneTile_79_ != null && sceneTile_79_.visible) {
                                continue;
                            }
                        }
                        if(i <= cameraPositionTileX && i > anInt95) {
                            SceneTile sceneTile_80_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_80_ != null && sceneTile_80_.visible && (sceneTile_80_.draw || (groundTile.interactiveObjectsSizeOR & 0x1) == 0)) {
                                continue;
                            }
                        }
                        if(i >= cameraPositionTileX && i < anInt84 - 1) {
                            SceneTile sceneTile_81_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_81_ != null && sceneTile_81_.visible && (sceneTile_81_.draw || (groundTile.interactiveObjectsSizeOR & 0x4) == 0)) {
                                continue;
                            }
                        }
                        if(i_76_ <= cameraPositionTileY && i_76_ > anInt87) {
                            SceneTile sceneTile_82_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_82_ != null && sceneTile_82_.visible && (sceneTile_82_.draw || (groundTile.interactiveObjectsSizeOR & 0x8) == 0)) {
                                continue;
                            }
                        }
                        if(i_76_ >= cameraPositionTileY && i_76_ < anInt111 - 1) {
                            SceneTile sceneTile_83_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_83_ != null && sceneTile_83_.visible && (sceneTile_83_.draw || (groundTile.interactiveObjectsSizeOR & 0x2) == 0)) {
                                continue;
                            }
                        }
                    } else {
                        arg1 = true;
                    }
                    groundTile.draw = false;
                    if(groundTile.aSceneTile_2058 != null) {
                        SceneTile sceneTile_84_ = groundTile.aSceneTile_2058;
                        if(sceneTile_84_.plainTile != null) {
                            if(!isTileOccluded(i, i_76_, 0)) {
                                renderPlainTile(sceneTile_84_.plainTile, 0, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                            }
                        } else if(sceneTile_84_.shapedTile != null && !isTileOccluded(i, i_76_, 0)) {
                            renderShapedTile(sceneTile_84_.shapedTile, i, i_76_, anInt104, anInt99, anInt82, anInt110);
                        }
                        Wall wall = sceneTile_84_.wall;
                        if(wall != null) {
                            wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - cameraPosZ, wall.y - cameraPosY, wall.hash);
                        }
                        for(int i_85_ = 0; i_85_ < sceneTile_84_.entityCount; i_85_++) {
                            InteractiveObject interactiveObject = sceneTile_84_.interactiveObjects[i_85_];
                            if(interactiveObject != null) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, anInt82, anInt110, anInt104, anInt99, interactiveObject.worldX - cameraPosX, interactiveObject.worldZ - cameraPosZ, interactiveObject.worldY - cameraPosY, interactiveObject.hash);
                            }
                        }
                    }
                    boolean bool = false;
                    if(groundTile.plainTile != null) {
                        if(!isTileOccluded(i, i_76_, i_78_)) {
                            bool = true;
                            renderPlainTile(groundTile.plainTile, i_78_, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                        }
                    } else if(groundTile.shapedTile != null && !isTileOccluded(i, i_76_, i_78_)) {
                        bool = true;
                        renderShapedTile(groundTile.shapedTile, i, i_76_, anInt104, anInt99, anInt82, anInt110);
                    }
                    int i_86_ = 0;
                    int i_87_ = 0;
                    Wall wall = groundTile.wall;
                    WallDecoration wallDecoration = groundTile.wallDecoration;
                    if(wall != null || wallDecoration != null) {
                        if(cameraPositionTileX == i) {
                            i_86_++;
                        } else if(cameraPositionTileX < i) {
                            i_86_ += 2;
                        }
                        if(cameraPositionTileY == i_76_) {
                            i_86_ += 3;
                        } else if(cameraPositionTileY > i_76_) {
                            i_86_ += 6;
                        }
                        i_87_ = anIntArray120[i_86_];
                        groundTile.anInt2064 = anIntArray130[i_86_];
                    }
                    if(wall != null) {
                        if((wall.orientation & anIntArray117[i_86_]) != 0) {
                            if(wall.orientation == 16) {
                                groundTile.wallCullDirection = 3;
                                groundTile.wallUncullDirection = anIntArray119[i_86_];
                                groundTile.wallCullOppositeDirection = 3 - groundTile.wallUncullDirection;
                            } else if(wall.orientation == 32) {
                                groundTile.wallCullDirection = 6;
                                groundTile.wallUncullDirection = anIntArray125[i_86_];
                                groundTile.wallCullOppositeDirection = 6 - groundTile.wallUncullDirection;
                            } else if(wall.orientation == 64) {
                                groundTile.wallCullDirection = 12;
                                groundTile.wallUncullDirection = anIntArray132[i_86_];
                                groundTile.wallCullOppositeDirection = 12 - groundTile.wallUncullDirection;
                            } else {
                                groundTile.wallCullDirection = 9;
                                groundTile.wallUncullDirection = anIntArray131[i_86_];
                                groundTile.wallCullOppositeDirection = 9 - groundTile.wallUncullDirection;
                            }
                        } else {
                            groundTile.wallCullDirection = 0;
                        }
                        if((wall.orientation & i_87_) != 0 && !isWallOccluded(i_78_, i, i_76_, wall.orientation)) {
                            wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - cameraPosZ, wall.y - cameraPosY, wall.hash);
                        }
                        if((wall.orientation2 & i_87_) != 0 && !isWallOccluded(i_78_, i, i_76_, wall.orientation2)) {
                            wall.secondary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - cameraPosZ, wall.y - cameraPosY, wall.hash);
                        }
                    }
                    if(wallDecoration != null && !isOccluded(i_78_, i, i_76_, (wallDecoration.renderable.modelHeight))) {
                        if((wallDecoration.configBits & i_87_) != 0) {
                            wallDecoration.renderable.renderAtPoint(wallDecoration.face, anInt82, anInt110, anInt104, anInt99, wallDecoration.x - cameraPosX, wallDecoration.z - cameraPosZ, wallDecoration.y - cameraPosY, wallDecoration.hash);
                        } else if((wallDecoration.configBits & 0x300) != 0) {
                            int i_88_ = wallDecoration.x - cameraPosX;
                            int i_89_ = wallDecoration.z - cameraPosZ;
                            int i_90_ = wallDecoration.y - cameraPosY;
                            int i_91_ = wallDecoration.face;
                            int i_92_;
                            if(i_91_ == 1 || i_91_ == 2) {
                                i_92_ = -i_88_;
                            } else {
                                i_92_ = i_88_;
                            }
                            int i_93_;
                            if(i_91_ == 2 || i_91_ == 3) {
                                i_93_ = -i_90_;
                            } else {
                                i_93_ = i_90_;
                            }
                            if((wallDecoration.configBits & 0x100) != 0 && i_93_ < i_92_) {
                                int i_94_ = i_88_ + faceOffsetX2[i_91_];
                                int i_95_ = i_90_ + faceOffsetY2[i_91_];
                                wallDecoration.renderable.renderAtPoint(i_91_ * 512 + 256, anInt82, anInt110, anInt104, anInt99, i_94_, i_89_, i_95_, wallDecoration.hash);
                            }
                            if((wallDecoration.configBits & 0x200) != 0 && i_93_ > i_92_) {
                                int i_96_ = i_88_ + faceOffsetX3[i_91_];
                                int i_97_ = i_90_ + faceOffsetY3[i_91_];
                                wallDecoration.renderable.renderAtPoint(i_91_ * 512 + 1280 & 0x7ff, anInt82, anInt110, anInt104, anInt99, i_96_, i_89_, i_97_, wallDecoration.hash);
                            }
                        }
                    }
                    if(bool) {
                        FloorDecoration floorDecoration = groundTile.floorDecoration;
                        if(floorDecoration != null) {
                            floorDecoration.renderable.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, floorDecoration.x - cameraPosX, floorDecoration.z - cameraPosZ, floorDecoration.y - cameraPosY, floorDecoration.hash);
                        }
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if(groundItemTile != null && groundItemTile.anInt1371 == 0) {
                            if(groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, groundItemTile.z - cameraPosZ, groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, groundItemTile.z - cameraPosZ, groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, groundItemTile.z - cameraPosZ, groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                        }
                    }
                    int i_98_ = groundTile.interactiveObjectsSizeOR;
                    if(i_98_ != 0) {
                        if(i < cameraPositionTileX && (i_98_ & 0x4) != 0) {
                            SceneTile sceneTile_99_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_99_ != null && sceneTile_99_.visible) {
                                tileList.pushBack(sceneTile_99_, -115);
                            }
                        }
                        if(i_76_ < cameraPositionTileY && (i_98_ & 0x2) != 0) {
                            SceneTile sceneTile_100_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_100_ != null && sceneTile_100_.visible) {
                                tileList.pushBack(sceneTile_100_, 127);
                            }
                        }
                        if(i > cameraPositionTileX && (i_98_ & 0x1) != 0) {
                            SceneTile sceneTile_101_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_101_ != null && sceneTile_101_.visible) {
                                tileList.pushBack(sceneTile_101_, -106);
                            }
                        }
                        if(i_76_ > cameraPositionTileY && (i_98_ & 0x8) != 0) {
                            SceneTile tile = sceneTiles[i][i_76_ - 1];
                            if(tile != null && tile.visible) {
                                tileList.pushBack(tile, -81);
                            }
                        }
                    }
                }
                if(groundTile.wallCullDirection != 0) {
                    boolean bool = true;
                    for(int i_103_ = 0; i_103_ < groundTile.entityCount; i_103_++) {
                        if((groundTile.interactiveObjects[i_103_].cycle != cycle) && ((groundTile.sceneSpawnRequestsSize[i_103_] & groundTile.wallCullDirection) == groundTile.wallUncullDirection)) {
                            bool = false;
                            break;
                        }
                    }
                    if(bool) {
                        Wall wall = groundTile.wall;
                        if(!isWallOccluded(i_78_, i, i_76_, wall.orientation)) {
                            wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - cameraPosZ, wall.y - cameraPosY, wall.hash);
                        }
                        groundTile.wallCullDirection = 0;
                    }
                }
                if(groundTile.drawEntities) {
                    try {
                        int i_104_ = groundTile.entityCount;
                        groundTile.drawEntities = false;
                        int i_105_ = 0;
                        while_2_:
                        for(int i_106_ = 0; i_106_ < i_104_; i_106_++) {
                            InteractiveObject entity = groundTile.interactiveObjects[i_106_];
                            if(entity.cycle != cycle) {
                                for(int i_107_ = entity.tileLeft; i_107_ <= entity.tileRight; i_107_++) {
                                    for(int i_108_ = entity.tileTop; i_108_ <= entity.tileBottom; i_108_++) {
                                        SceneTile tile = sceneTiles[i_107_][i_108_];
                                        if(tile.draw) {
                                            groundTile.drawEntities = true;
                                            continue while_2_;
                                        }
                                        if(tile.wallCullDirection != 0) {
                                            int i_110_ = 0;
                                            if(i_107_ > entity.tileLeft) {
                                                i_110_++;
                                            }
                                            if(i_107_ < entity.tileRight) {
                                                i_110_ += 4;
                                            }
                                            if(i_108_ > entity.tileTop) {
                                                i_110_ += 8;
                                            }
                                            if(i_108_ < entity.tileBottom) {
                                                i_110_ += 2;
                                            }
                                            if((i_110_ & tile.wallCullDirection) == groundTile.wallCullOppositeDirection) {
                                                groundTile.drawEntities = true;
                                                continue while_2_;
                                            }
                                        }
                                    }
                                }
                                interactiveObjects[i_105_++] = entity;
                                int i_111_ = cameraPositionTileX - entity.tileLeft;
                                int i_112_ = entity.tileRight - cameraPositionTileX;
                                if(i_112_ > i_111_) {
                                    i_111_ = i_112_;
                                }
                                int i_113_ = cameraPositionTileY - entity.tileTop;
                                int i_114_ = entity.tileBottom - cameraPositionTileY;
                                if(i_114_ > i_113_) {
                                    entity.anInt491 = i_111_ + i_114_;
                                } else {
                                    entity.anInt491 = i_111_ + i_113_;
                                }
                            }
                        }
                        while(i_105_ > 0) {
                            int i_115_ = -50;
                            int i_116_ = -1;
                            for(int i_117_ = 0; i_117_ < i_105_; i_117_++) {
                                InteractiveObject interactiveObject = interactiveObjects[i_117_];
                                if(interactiveObject.cycle != cycle) {
                                    if(interactiveObject.anInt491 > i_115_) {
                                        i_115_ = interactiveObject.anInt491;
                                        i_116_ = i_117_;
                                    } else if(interactiveObject.anInt491 == i_115_) {
                                        int i_118_ = interactiveObject.worldX - cameraPosX;
                                        int i_119_ = interactiveObject.worldY - cameraPosY;
                                        int i_120_ = ((interactiveObjects[i_116_].worldX) - cameraPosX);
                                        int i_121_ = ((interactiveObjects[i_116_].worldY) - cameraPosY);
                                        if(i_118_ * i_118_ + i_119_ * i_119_ > (i_120_ * i_120_ + i_121_ * i_121_)) {
                                            i_116_ = i_117_;
                                        }
                                    }
                                }
                            }
                            if(i_116_ == -1) {
                                break;
                            }
                            InteractiveObject interactiveObject = interactiveObjects[i_116_];
                            interactiveObject.cycle = cycle;
                            if(!isAreaOccluded(i_78_, interactiveObject.tileLeft, interactiveObject.tileRight, interactiveObject.tileTop, interactiveObject.tileBottom, (interactiveObject.renderable.modelHeight))) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, anInt82, anInt110, anInt104, anInt99, interactiveObject.worldX - cameraPosX, interactiveObject.worldZ - cameraPosZ, interactiveObject.worldY - cameraPosY, interactiveObject.hash);
                            }
                            for(int i_122_ = interactiveObject.tileLeft; i_122_ <= interactiveObject.tileRight; i_122_++) {
                                for(int i_123_ = interactiveObject.tileTop; i_123_ <= interactiveObject.tileBottom; i_123_++) {
                                    SceneTile sceneTile_124_ = sceneTiles[i_122_][i_123_];
                                    if(sceneTile_124_.wallCullDirection != 0) {
                                        tileList.pushBack(sceneTile_124_, 108);
                                    } else if((i_122_ != i || i_123_ != i_76_) && sceneTile_124_.visible) {
                                        tileList.pushBack(sceneTile_124_, 92);
                                    }
                                }
                            }
                        }
                        if(groundTile.drawEntities) {
                            continue;
                        }
                    } catch(Exception exception) {
                        groundTile.drawEntities = false;
                    }
                }
                if(groundTile.visible) {
                    if(groundTile.wallCullDirection == 0) {
                        if(i <= cameraPositionTileX && i > anInt95) {
                            SceneTile sceneTile_125_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_125_ != null && sceneTile_125_.visible) {
                                continue;
                            }
                        }
                        if(i >= cameraPositionTileX && i < anInt84 - 1) {
                            SceneTile sceneTile_126_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_126_ != null && sceneTile_126_.visible) {
                                continue;
                            }
                        }
                        if(i_76_ <= cameraPositionTileY && i_76_ > anInt87) {
                            SceneTile sceneTile_127_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_127_ != null && sceneTile_127_.visible) {
                                continue;
                            }
                        }
                        if(i_76_ >= cameraPositionTileY && i_76_ < anInt111 - 1) {
                            SceneTile sceneTile_128_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_128_ != null && sceneTile_128_.visible) {
                                continue;
                            }
                        }
                        groundTile.visible = false;
                        anInt109--;
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if(groundItemTile != null && groundItemTile.anInt1371 != 0) {
                            if(groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, (groundItemTile.z - cameraPosZ - groundItemTile.anInt1371), groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, (groundItemTile.z - cameraPosZ - groundItemTile.anInt1371), groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, (groundItemTile.z - cameraPosZ - groundItemTile.anInt1371), groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                        }
                        if(groundTile.anInt2064 != 0) {
                            WallDecoration wallDecoration = groundTile.wallDecoration;
                            if(wallDecoration != null && !isOccluded(i_78_, i, i_76_, (wallDecoration.renderable.modelHeight))) {
                                if((wallDecoration.configBits & groundTile.anInt2064) != 0) {
                                    wallDecoration.renderable.renderAtPoint(wallDecoration.face, anInt82, anInt110, anInt104, anInt99, wallDecoration.x - cameraPosX, wallDecoration.z - cameraPosZ, wallDecoration.y - cameraPosY, wallDecoration.hash);
                                } else if((wallDecoration.configBits & 0x300) != 0) {
                                    int i_129_ = wallDecoration.x - cameraPosX;
                                    int i_130_ = wallDecoration.z - cameraPosZ;
                                    int i_131_ = wallDecoration.y - cameraPosY;
                                    int i_132_ = wallDecoration.face;
                                    int i_133_;
                                    if(i_132_ == 1 || i_132_ == 2) {
                                        i_133_ = -i_129_;
                                    } else {
                                        i_133_ = i_129_;
                                    }
                                    int i_134_;
                                    if(i_132_ == 2 || i_132_ == 3) {
                                        i_134_ = -i_131_;
                                    } else {
                                        i_134_ = i_131_;
                                    }
                                    if((wallDecoration.configBits & 0x100) != 0 && i_134_ >= i_133_) {
                                        int i_135_ = i_129_ + faceOffsetX2[i_132_];
                                        int i_136_ = i_131_ + faceOffsetY2[i_132_];
                                        wallDecoration.renderable.renderAtPoint(i_132_ * 512 + 256, anInt82, anInt110, anInt104, anInt99, i_135_, i_130_, i_136_, wallDecoration.hash);
                                    }
                                    if((wallDecoration.configBits & 0x200) != 0 && i_134_ <= i_133_) {
                                        int i_137_ = i_129_ + faceOffsetX3[i_132_];
                                        int i_138_ = i_131_ + faceOffsetY3[i_132_];
                                        wallDecoration.renderable.renderAtPoint(i_132_ * 512 + 1280 & 0x7ff, anInt82, anInt110, anInt104, anInt99, i_137_, i_130_, i_138_, wallDecoration.hash);
                                    }
                                }
                            }
                            Wall wall = groundTile.wall;
                            if(wall != null) {
                                if((wall.orientation2 & groundTile.anInt2064) != 0 && !isWallOccluded(i_78_, i, i_76_, wall.orientation2)) {
                                    wall.secondary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - cameraPosZ, wall.y - cameraPosY, wall.hash);
                                }
                                if((wall.orientation & groundTile.anInt2064) != 0 && !isWallOccluded(i_78_, i, i_76_, wall.orientation)) {
                                    wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - cameraPosZ, wall.y - cameraPosY, wall.hash);
                                }
                            }
                        }
                        if(i_77_ < mapSizeZ - 1) {
                            SceneTile sceneTile_139_ = (tileArray[i_77_ + 1][i][i_76_]);
                            if(sceneTile_139_ != null && sceneTile_139_.visible) {
                                tileList.pushBack(sceneTile_139_, -88);
                            }
                        }
                        if(i < cameraPositionTileX) {
                            SceneTile sceneTile_140_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_140_ != null && sceneTile_140_.visible) {
                                tileList.pushBack(sceneTile_140_, 63);
                            }
                        }
                        if(i_76_ < cameraPositionTileY) {
                            SceneTile sceneTile_141_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_141_ != null && sceneTile_141_.visible) {
                                tileList.pushBack(sceneTile_141_, -81);
                            }
                        }
                        if(i > cameraPositionTileX) {
                            SceneTile sceneTile_142_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_142_ != null && sceneTile_142_.visible) {
                                tileList.pushBack(sceneTile_142_, 89);
                            }
                        }
                        if(i_76_ > cameraPositionTileY) {
                            SceneTile sceneTile_143_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_143_ != null && sceneTile_143_.visible) {
                                tileList.pushBack(sceneTile_143_, -125);
                            }
                        }
                    }
                }
            }
        }
    }

    public InteractiveObject method107(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null) {
            return null;
        }
        for(int i = 0; i < sceneTile.entityCount; i++) {
            InteractiveObject interactiveObject = sceneTile.interactiveObjects[i];
            if((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == arg1 && interactiveObject.tileTop == arg2) {
                return interactiveObject;
            }
        }
        return null;
    }

    public void addWallDecoration(int x, int y, int z, int drawHeight, int offsetX, int offsetY, int face, int hash, Renderable renderable, int config, int configBits) {
        if(renderable != null) {
            WallDecoration wallDecoration = new WallDecoration();
            wallDecoration.hash = hash;
            wallDecoration.config = config;
            wallDecoration.x = x * 128 + 64 + offsetX;
            wallDecoration.y = y * 128 + 64 + offsetY;
            wallDecoration.z = drawHeight;
            wallDecoration.renderable = renderable;
            wallDecoration.configBits = configBits;
            wallDecoration.face = face;
            for(int plane = z; plane >= 0; plane--) {
                if(tileArray[plane][x][y] == null) {
                    tileArray[plane][x][y] = new SceneTile(plane, x, y);
                }
            }
            tileArray[z][x][y].wallDecoration = wallDecoration;
        }
    }

    public int getLocationHash(int z, int x, int y) {
        SceneTile sceneTile = tileArray[z][x][y];
        if(sceneTile == null) {
            return 0;
        }
        for(int i = 0; i < sceneTile.entityCount; i++) {
            InteractiveObject interactiveObject = sceneTile.interactiveObjects[i];
            if((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == x && interactiveObject.tileTop == y) {
                return interactiveObject.hash;
            }
        }
        return 0;
    }

    public boolean isOccluded(int z, int x, int y, int arg3) {
        if(!isTileOccluded(x, y, z)) {
            return false;
        }
        int i = x << 7;
        int i_144_ = y << 7;
        return method103(i + 1, heightMap[z][x][y] - arg3, i_144_ + 1) && method103(i + 128 - 1, heightMap[z][x + 1][y] - arg3, i_144_ + 1) && method103(i + 128 - 1, (heightMap[z][x + 1][y + 1] - arg3), i_144_ + 128 - 1) && method103(i + 1, heightMap[z][x][y + 1] - arg3, i_144_ + 128 - 1);
    }

    public boolean method112(int arg0, int arg1, int arg2, int arg3, int arg4, Renderable arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        if(arg5 == null) {
            return true;
        }
        return addRenderableC(arg8, arg9, arg0, arg1, arg2, arg3, arg6, arg11 - arg9 + 1, arg10 - arg8 + 1, arg7, arg5, true, 0);
    }

    public void method115(int arg0, int arg1, int arg2, int arg3) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            WallDecoration wallDecoration = sceneTile.wallDecoration;
            if(wallDecoration != null) {
                int i = arg1 * 128 + 64;
                int i_150_ = arg2 * 128 + 64;
                wallDecoration.x = i + (wallDecoration.x - i) * arg3 / 16;
                wallDecoration.y = i_150_ + (wallDecoration.y - i_150_) * arg3 / 16;
            }
        }
    }

    public void method117(Model model, int z, int x, int y) {
        if(x < mapSizeX) {
            SceneTile sceneTile = tileArray[z][x + 1][y];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model _model = ((Model) sceneTile.floorDecoration.renderable);
                if(_model.verticesNormal != null) {
                    mergeNormals(model, _model, 128, 0, 0, true);
                }
            }
        }
        if(y < mapSizeX) {
            SceneTile sceneTile = tileArray[z][x][y + 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model _model = ((Model) sceneTile.floorDecoration.renderable);
                if(_model.verticesNormal != null) {
                    mergeNormals(model, _model, 0, 0, 128, true);
                }
            }
        }
        if(x < mapSizeX && y < mapSizeY) {
            SceneTile sceneTile = tileArray[z][x + 1][y + 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model _model = ((Model) sceneTile.floorDecoration.renderable);
                if(_model.verticesNormal != null) {
                    mergeNormals(model, _model, 128, 0, 128, true);
                }
            }
        }
        if(x < mapSizeX && y > 0) {
            SceneTile sceneTile = tileArray[z][x + 1][y - 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model _model = ((Model) sceneTile.floorDecoration.renderable);
                if(_model.verticesNormal != null) {
                    mergeNormals(model, _model, 128, 0, -128, true);
                }
            }
        }
    }

    public void method118(int arg0, int arg1, int arg2) {
        for(int _z = 0; _z < mapSizeZ; _z++) {
            for(int _x = 0; _x < mapSizeX; _x++) {
                for(int _y = 0; _y < mapSizeY; _y++) {
                    SceneTile tile = tileArray[_z][_x][_y];
                    if(tile != null) {
                        Wall wall = tile.wall;
                        if(wall != null && (wall.primary instanceof Model)) {
                            Model model = ((Model) wall.primary);
                            if(model.verticesNormal != null) {
                                method129(model, _z, _x, _y, 1, 1);
                                if(wall.secondary instanceof Model) {
                                    Model _model = ((Model) wall.secondary);
                                    if((_model.verticesNormal) != null) {
                                        method129(_model, _z, _x, _y, 1, 1);
                                        mergeNormals(model, _model, 0, 0, 0, false);
                                        _model.handleShading(arg0, arg1, arg2);
                                    }
                                }
                                model.handleShading(arg0, arg1, arg2);
                            }
                        }
                        for(int e = 0; e < tile.entityCount; e++) {
                            InteractiveObject interactiveObject = tile.interactiveObjects[e];
                            if(interactiveObject != null && (interactiveObject.renderable instanceof Model)) {
                                Model model = ((Model) interactiveObject.renderable);
                                if(model.verticesNormal != null) {
                                    method129(model, _z, _x, _y, (interactiveObject.tileRight - interactiveObject.tileLeft + 1), (interactiveObject.tileBottom - interactiveObject.tileTop + 1));
                                    model.handleShading(arg0, arg1, arg2);
                                }
                            }
                        }
                        FloorDecoration floorDecoration = tile.floorDecoration;
                        if(floorDecoration != null && (floorDecoration.renderable instanceof Model)) {
                            Model model = ((Model) floorDecoration.renderable);
                            if(model.verticesNormal != null) {
                                method117(model, _z, _x, _y);
                                model.handleShading(arg0, arg1, arg2);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isAreaOccluded(int z, int minimumX, int maximumX, int minimumY, int maximumY, int offsetZ) {
        if(minimumX == maximumX && minimumY == maximumY) {
            if(!isTileOccluded(minimumX, minimumY, z)) {
                return false;
            }
            int worldX = minimumX << 7;
            int worldY = minimumY << 7;
            return method103(worldX + 1, heightMap[z][minimumX][minimumY] - offsetZ, worldY + 1) && method103(worldX + 128 - 1, (heightMap[z][minimumX + 1][minimumY] - offsetZ), worldY + 1) && method103(worldX + 128 - 1, (heightMap[z][minimumX + 1][minimumY + 1] - offsetZ), worldY + 128 - 1) && method103(worldX + 1, (heightMap[z][minimumX][minimumY + 1] - offsetZ), worldY + 128 - 1);
        }
        for(int x = minimumX; x <= maximumX; x++) {
            for(int y = minimumY; y <= maximumY; y++) {
                if(anIntArrayArrayArray83[z][x][y] == -cycle) {
                    return false;
                }
            }
        }
        int _x = (minimumX << 7) + 1;
        int _y = (minimumY << 7) + 2;
        int _z = heightMap[z][minimumX][minimumY] - offsetZ;
        if(!method103(_x, _z, _y)) {
            return false;
        }
        int i_159_ = (maximumX << 7) - 1;
        if(!method103(i_159_, _z, _y)) {
            return false;
        }
        int i_160_ = (maximumY << 7) - 1;
        if(!method103(_x, _z, i_160_)) {
            return false;
        }
        return method103(i_159_, _z, i_160_);
    }

    public void method120(int arg0, int arg1) {
        clicked = true;
        clickX = arg0;
        clickY = arg1;
        clickedTileX = -1;
        clickedTileY = -1;
    }

    public void mergeNormals(Model modelA, Model modelB, int i, int j, int k, boolean arg5) {
        modelB.method822();
        anInt126++;
        int count = 0;
        int[] vertices = modelB.verticesX;
        int vertexCount = modelB.vertexCount;
        for(int vertex = 0; vertex < modelA.vertexCount; vertex++) {
            VertexNormal vertexNormal = modelA.verticesNormal[vertex];
            VertexNormal offsetVertexNormal = modelA.vertexNormalOffset[vertex];
            if(offsetVertexNormal.magnitude != 0) {
                int y = modelA.verticesY[vertex] - j;
                if(y <= modelB.maxY) {
                    int x = modelA.verticesX[vertex] - i;
                    if(x >= modelB.anInt3171 && x <= modelB.diagonal3D) {
                        int z = modelA.verticesZ[vertex] - k;
                        if(z >= modelB.anInt3177 && z <= modelB.anInt3189) {
                            for(int v = 0; v < vertexCount; v++) {
                                VertexNormal _vertexNormal = modelB.verticesNormal[v];
                                VertexNormal _offsetVertexNormal = modelB.vertexNormalOffset[v];
                                if(x == vertices[v] && z == modelB.verticesZ[v] && y == modelB.verticesY[v] && _offsetVertexNormal.magnitude != 0) {
                                    vertexNormal.x += _offsetVertexNormal.x;
                                    vertexNormal.y += _offsetVertexNormal.y;
                                    vertexNormal.z += _offsetVertexNormal.z;
                                    vertexNormal.magnitude += _offsetVertexNormal.magnitude;
                                    _vertexNormal.x += offsetVertexNormal.x;
                                    _vertexNormal.y += offsetVertexNormal.y;
                                    _vertexNormal.z += offsetVertexNormal.z;
                                    _vertexNormal.magnitude += offsetVertexNormal.magnitude;
                                    count++;
                                    anIntArray127[vertex] = anInt126;
                                    anIntArray123[v] = anInt126;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(count >= 3 && arg5) {
            for(int i_170_ = 0; i_170_ < modelA.triangleCount; i_170_++) {
                if(anIntArray127[modelA.trianglePointsX[i_170_]] == anInt126 && anIntArray127[modelA.trianglePointsY[i_170_]] == anInt126 && anIntArray127[modelA.trianglePointsZ[i_170_]] == anInt126) {
                    modelA.triangleDrawType[i_170_] = -1;
                }
            }
            for(int i_171_ = 0; i_171_ < modelB.triangleCount; i_171_++) {
                if(anIntArray123[modelB.trianglePointsX[i_171_]] == anInt126 && anIntArray123[modelB.trianglePointsY[i_171_]] == anInt126 && anIntArray123[modelB.trianglePointsZ[i_171_]] == anInt126) {
                    modelB.triangleDrawType[i_171_] = -1;
                }
            }
        }
    }

    public int method122(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null || sceneTile.wall == null) {
            return 0;
        }
        return sceneTile.wall.hash;
    }

    public void method123() {
        int i = cullingClusterPointer[anInt85];
        SceneCluster[] sceneClusters = cullingClusters[anInt85];
        anInt96 = 0;
        for(int i_172_ = 0; i_172_ < i; i_172_++) {
            SceneCluster sceneCluster = sceneClusters[i_172_];
            if(sceneCluster.searchMask == 1) {
                int i_173_ = sceneCluster.tileStartX - cameraPositionTileX + 25;
                if(i_173_ >= 0 && i_173_ <= 50) {
                    int i_174_ = sceneCluster.tileStartY - cameraPositionTileY + 25;
                    if(i_174_ < 0) {
                        i_174_ = 0;
                    }
                    int i_175_ = sceneCluster.tileEndY - cameraPositionTileY + 25;
                    if(i_175_ > 50) {
                        i_175_ = 50;
                    }
                    boolean bool = false;
                    while(i_174_ <= i_175_) {
                        if(aBooleanArrayArray133[i_173_][i_174_++]) {
                            bool = true;
                            break;
                        }
                    }
                    if(bool) {
                        int i_176_ = cameraPosX - sceneCluster.worldStartX;
                        if(i_176_ > 32) {
                            sceneCluster.tileDistanceEnum = 1;
                        } else {
                            if(i_176_ >= -32) {
                                continue;
                            }
                            sceneCluster.tileDistanceEnum = 2;
                            i_176_ = -i_176_;
                        }
                        sceneCluster.worldDistanceFromCameraStartY = (sceneCluster.worldStartY - cameraPosY << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndY = (sceneCluster.worldEndY - cameraPosY << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - cameraPosZ << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - cameraPosZ << 8) / i_176_;
                        processedCullingClusters[anInt96++] = sceneCluster;
                    }
                }
            } else if(sceneCluster.searchMask == 2) {
                int i_177_ = sceneCluster.tileStartY - cameraPositionTileY + 25;
                if(i_177_ >= 0 && i_177_ <= 50) {
                    int i_178_ = sceneCluster.tileStartX - cameraPositionTileX + 25;
                    if(i_178_ < 0) {
                        i_178_ = 0;
                    }
                    int i_179_ = sceneCluster.tileEndX - cameraPositionTileX + 25;
                    if(i_179_ > 50) {
                        i_179_ = 50;
                    }
                    boolean bool = false;
                    while(i_178_ <= i_179_) {
                        if(aBooleanArrayArray133[i_178_++][i_177_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(bool) {
                        int i_180_ = cameraPosY - sceneCluster.worldStartY;
                        if(i_180_ > 32) {
                            sceneCluster.tileDistanceEnum = 3;
                        } else {
                            if(i_180_ >= -32) {
                                continue;
                            }
                            sceneCluster.tileDistanceEnum = 4;
                            i_180_ = -i_180_;
                        }
                        sceneCluster.worldDistanceFromCameraStartX = (sceneCluster.worldStartX - cameraPosX << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndX = (sceneCluster.worldEndX - cameraPosX << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - cameraPosZ << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - cameraPosZ << 8) / i_180_;
                        processedCullingClusters[anInt96++] = sceneCluster;
                    }
                }
            } else if(sceneCluster.searchMask == 4) {
                int i_181_ = sceneCluster.worldEndZ - cameraPosZ;
                if(i_181_ > 128) {
                    int i_182_ = sceneCluster.tileStartY - cameraPositionTileY + 25;
                    if(i_182_ < 0) {
                        i_182_ = 0;
                    }
                    int i_183_ = sceneCluster.tileEndY - cameraPositionTileY + 25;
                    if(i_183_ > 50) {
                        i_183_ = 50;
                    }
                    if(i_182_ <= i_183_) {
                        int i_184_ = sceneCluster.tileStartX - cameraPositionTileX + 25;
                        if(i_184_ < 0) {
                            i_184_ = 0;
                        }
                        int i_185_ = sceneCluster.tileEndX - cameraPositionTileX + 25;
                        if(i_185_ > 50) {
                            i_185_ = 50;
                        }
                        boolean bool = false;
                        while_3_:
                        for(int i_186_ = i_184_; i_186_ <= i_185_; i_186_++) {
                            for(int i_187_ = i_182_; i_187_ <= i_183_; i_187_++) {
                                if(aBooleanArrayArray133[i_186_][i_187_]) {
                                    bool = true;
                                    break while_3_;
                                }
                            }
                        }
                        if(bool) {
                            sceneCluster.tileDistanceEnum = 5;
                            sceneCluster.worldDistanceFromCameraStartX = (sceneCluster.worldStartX - cameraPosX << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraEndX = (sceneCluster.worldEndX - cameraPosX << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraStartY = (sceneCluster.worldStartY - cameraPosY << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraEndY = (sceneCluster.worldEndY - cameraPosY << 8) / i_181_;
                            processedCullingClusters[anInt96++] = sceneCluster;
                        }
                    }
                }
            }
        }
    }

    public void method124(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            sceneTile.wall = null;
        }
    }

    public void method125(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            sceneTile.groundItemTile = null;
        }
    }

    public Wall method126(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null) {
            return null;
        }
        return sceneTile.wall;
    }

    public void method127(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            sceneTile.wallDecoration = null;
        }
    }

    public void renderPlainTile(GenericTile plainTile, int arg1, int sinY, int cosineY, int sinX, int cosineX, int tileX, int tileY) {
        int xC;
        int xA = xC = (tileX << 7) - cameraPosX;
        int yB;
        int yA = yB = (tileY << 7) - cameraPosY;
        int xD;
        int xB = xD = xA + 128;
        int yC;
        int yD = yC = yA + 128;
        int zA = heightMap[arg1][tileX][tileY] - cameraPosZ;
        int zB = heightMap[arg1][tileX + 1][tileY] - cameraPosZ;
        int zC = heightMap[arg1][tileX + 1][tileY + 1] - cameraPosZ;
        int zD = heightMap[arg1][tileX][tileY + 1] - cameraPosZ;
        int temp = yA * sinX + xA * cosineX >> 16;
        yA = yA * cosineX - xA * sinX >> 16;
        xA = temp;
        temp = zA * cosineY - yA * sinY >> 16;
        yA = zA * sinY + yA * cosineY >> 16;
        zA = temp;
        if(yA < 50) {
            return;
        }
        temp = yB * sinX + xB * cosineX >> 16;
        yB = yB * cosineX - xB * sinX >> 16;
        xB = temp;
        temp = zB * cosineY - yB * sinY >> 16;
        yB = zB * sinY + yB * cosineY >> 16;
        zB = temp;
        if(yB < 50) {
            return;
        }
        temp = yD * sinX + xD * cosineX >> 16;
        yD = yD * cosineX - xD * sinX >> 16;
        xD = temp;
        temp = zC * cosineY - yD * sinY >> 16;
        yD = zC * sinY + yD * cosineY >> 16;
        zC = temp;
        if(yD < 50) {
            return;
        }
        temp = yC * sinX + xC * cosineX >> 16;
        yC = yC * cosineX - xC * sinX >> 16;
        xC = temp;
        temp = zD * cosineY - yC * sinY >> 16;
        yC = zD * sinY + yC * cosineY >> 16;
        zD = temp;
        if(yC < 50) {
            return;
        }
        int screenXA = (Rasterizer3D.center_x + (xA << 9) / yA);
        int screenYA = (Rasterizer3D.center_y + (zA << 9) / yA);
        int screenXB = (Rasterizer3D.center_x + (xB << 9) / yB);
        int screenYB = (Rasterizer3D.center_y + (zB << 9) / yB);
        int screenXD = (Rasterizer3D.center_x + (xD << 9) / yD);
        int screenYD = (Rasterizer3D.center_y + (zC << 9) / yD);
        int screenXC = (Rasterizer3D.center_x + (xC << 9) / yC);
        int screenYC = (Rasterizer3D.center_y + (zD << 9) / yC);
        Rasterizer3D.alpha = 0;
        if(((screenXD - screenXC) * (screenYB - screenYC) - (screenYD - screenYC) * (screenXB - screenXC)) > 0) {
            Rasterizer3D.restrict_edges = screenXD < 0 || screenXC < 0 || screenXB < 0 || screenXD > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx;
            if(clicked && isMouseWithinTriangle(clickX, clickY, screenYD, screenYC, screenYB, screenXD, screenXC, screenXB)) {
                clickedTileX = tileX;
                clickedTileY = tileY;
            }
            if(isMouseWithinTriangle(Class13.mouseX, Landscape.mouseY, screenYD, screenYC, screenYB, screenXD, screenXC, screenXB)) {
                hoveredTileX = tileX;
                hoveredTileY = tileY;
            }
            if(plainTile.texture == -1) {
                if(plainTile.colourD != 12345678) {
                    Rasterizer3D.drawShadedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB);
                }
            } else if(lowMemory) {
                int rgb = Rasterizer3D.anInterface3_2939.method14(true, plainTile.texture);
                Rasterizer3D.drawShadedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, method108(rgb, plainTile.colourD), method108(rgb, plainTile.colourC), method108(rgb, plainTile.colourB));
            } else if(plainTile.flat) {
                Rasterizer3D.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xA, xB, xC, zA, zB, zD, yA, yB, yC, plainTile.texture);
            } else {
                Rasterizer3D.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xD, xC, xB, zC, zD, zB, yD, yC, yB, plainTile.texture);
            }
        }
        if(((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB)) > 0) {
            Rasterizer3D.restrict_edges = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx;
            if(clicked && isMouseWithinTriangle(clickX, clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                clickedTileX = tileX;
                clickedTileY = tileY;
            }

            if(isMouseWithinTriangle(Class13.mouseX, Landscape.mouseY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                hoveredTileX = tileX;
                hoveredTileY = tileY;
            }
            if(plainTile.texture == -1) {
                if(plainTile.colourA != 12345678) {
                    Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC);
                }
            } else if(lowMemory) {
                int i_209_ = Rasterizer3D.anInterface3_2939.method14(true, plainTile.texture);
                Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, method108(i_209_, plainTile.colourA), method108(i_209_, plainTile.colourB), method108(i_209_, plainTile.colourC));
            } else {
                Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC, xA, xB, xC, zA, zB, zD, yA, yB, yC, plainTile.texture);
            }
        }
    }

    public void method129(Model arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        boolean bool = true;
        int i = arg2;
        int i_210_ = arg2 + arg4;
        int i_211_ = arg3 - 1;
        int i_212_ = arg3 + arg5;
        for(int i_213_ = arg1; i_213_ <= arg1 + 1; i_213_++) {
            if(i_213_ != mapSizeZ) {
                for(int i_214_ = i; i_214_ <= i_210_; i_214_++) {
                    if(i_214_ >= 0 && i_214_ < mapSizeX) {
                        for(int i_215_ = i_211_; i_215_ <= i_212_; i_215_++) {
                            if(i_215_ >= 0 && i_215_ < mapSizeY && (!bool || i_214_ >= i_210_ || i_215_ >= i_212_ || i_215_ < arg3 && i_214_ != arg2)) {
                                SceneTile sceneTile = (tileArray[i_213_][i_214_][i_215_]);
                                if(sceneTile != null) {
                                    int i_216_ = (((heightMap[i_213_][i_214_][i_215_]) + (heightMap[i_213_][i_214_ + 1][i_215_]) + (heightMap[i_213_][i_214_][i_215_ + 1]) + (heightMap[i_213_][i_214_ + 1][i_215_ + 1])) / 4 - ((heightMap[arg1][arg2][arg3]) + (heightMap[arg1][arg2 + 1][arg3]) + (heightMap[arg1][arg2][arg3 + 1]) + (heightMap[arg1][arg2 + 1][arg3 + 1])) / 4);
                                    Wall wall = sceneTile.wall;
                                    if(wall != null) {
                                        if(wall.primary instanceof Model) {
                                            Model model = ((Model) (wall.primary));
                                            if((model.verticesNormal) != null) {
                                                mergeNormals(arg0, model, ((i_214_ - arg2) * 128 + (1 - arg4) * 64), i_216_, ((i_215_ - arg3) * 128 + (1 - arg5) * 64), bool);
                                            }
                                        }
                                        if(wall.secondary instanceof Model) {
                                            Model model = ((Model) (wall.secondary));
                                            if((model.verticesNormal) != null) {
                                                mergeNormals(arg0, model, ((i_214_ - arg2) * 128 + (1 - arg4) * 64), i_216_, ((i_215_ - arg3) * 128 + (1 - arg5) * 64), bool);
                                            }
                                        }
                                    }
                                    for(int i_217_ = 0; i_217_ < sceneTile.entityCount; i_217_++) {
                                        InteractiveObject interactiveObject = (sceneTile.interactiveObjects[i_217_]);
                                        if(interactiveObject != null && (interactiveObject.renderable instanceof Model)) {
                                            Model model = ((Model) (interactiveObject.renderable));
                                            if((model.verticesNormal) != null) {
                                                int i_218_ = (interactiveObject.tileRight - interactiveObject.tileLeft + 1);
                                                int i_219_ = (interactiveObject.tileBottom - interactiveObject.tileTop + 1);
                                                mergeNormals(arg0, model, ((interactiveObject.tileLeft - arg2) * 128 + (i_218_ - arg4) * 64), i_216_, ((interactiveObject.tileTop - arg3) * 128 + (i_219_ - arg5) * 64), bool);
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

    public void method130(int arg0, int arg1, int arg2, int arg3) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            tileArray[arg0][arg1][arg2].anInt2063 = arg3;
        }
    }

    public void method131(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if(sceneTile != null) {
            sceneTile.floorDecoration = null;
        }
    }

    public void addGroundDecoration(int x, int y, int z, int drawHeight, int hash, Renderable renderable, int config) {
        if(renderable != null) {
            FloorDecoration floorDecoration = new FloorDecoration();
            floorDecoration.renderable = renderable;
            floorDecoration.x = x * 128 + 64;
            floorDecoration.y = y * 128 + 64;
            floorDecoration.z = drawHeight;
            floorDecoration.hash = hash;
            floorDecoration.config = config;
            if(tileArray[z][x][y] == null) {
                tileArray[z][x][y] = new SceneTile(z, x, y);
            }
            tileArray[z][x][y].floorDecoration = floorDecoration;
        }
    }

    public FloorDecoration getFloorDecoration(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if(sceneTile == null || sceneTile.floorDecoration == null) {
            return null;
        }
        return sceneTile.floorDecoration;
    }

    public boolean method134(int arg0, int arg1, int arg2, int arg3, int arg4, Renderable arg5, int arg6, int arg7, boolean arg8) {
        if(arg5 == null) {
            return true;
        }
        int i = arg1 - arg4;
        int i_220_ = arg2 - arg4;
        int i_221_ = arg1 + arg4;
        int i_222_ = arg2 + arg4;
        if(arg8) {
            if(arg6 > 640 && arg6 < 1408) {
                i_222_ += 128;
            }
            if(arg6 > 1152 && arg6 < 1920) {
                i_221_ += 128;
            }
            if(arg6 > 1664 || arg6 < 384) {
                i_220_ -= 128;
            }
            if(arg6 > 128 && arg6 < 896) {
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
        if(sceneTile == null) {
            return;
        }
        for(int e = 0; e < sceneTile.entityCount; e++) {
            InteractiveObject interactiveObject = sceneTile.interactiveObjects[e];
            if((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == x && interactiveObject.tileTop == y) {
                remove(interactiveObject);
                break;
            }
        }
    }

    public void setHeightLevel(int z) {
        currentPositionZ = z;
        for(int x = 0; x < mapSizeX; x++) {
            for(int y = 0; y < mapSizeY; y++) {
                if(tileArray[z][x][y] == null) {
                    tileArray[z][x][y] = new SceneTile(z, x, y);
                }
            }
        }
    }

    public boolean addEntityB(int x, int y, int z, int worldZ, int rotation, int tileWidth, int tileHeight, int uid, Renderable entity, int config) {
        if(entity == null) {
            return true;
        }
        int worldX = x * 128 + 64 * tileHeight;
        int worldY = y * 128 + 64 * tileWidth;
        return addRenderableC(x, y, z, worldX, worldY, worldZ, rotation, tileWidth, tileHeight, uid, entity, false, config);
    }

    public void renderShapedTile(ComplexTile shapedTile, int tileX, int tileY, int sineX, int cosineX, int sineY, int cosineY) {
        int triangleCount = shapedTile.originalVertexX.length;
        for(int triangle = 0; triangle < triangleCount; triangle++) {
            int viewspaceX = shapedTile.originalVertexX[triangle] - cameraPosX;
            int viewspaceY = shapedTile.originalVertexY[triangle] - cameraPosZ;
            int viewspaceZ = shapedTile.originalVertexZ[triangle] - cameraPosY;
            int temp = viewspaceZ * sineX + viewspaceX * cosineX >> 16;
            viewspaceZ = viewspaceZ * cosineX - viewspaceX * sineX >> 16;
            viewspaceX = temp;
            temp = viewspaceY * cosineY - viewspaceZ * sineY >> 16;
            viewspaceZ = viewspaceY * sineY + viewspaceZ * cosineY >> 16;
            viewspaceY = temp;
            if(viewspaceZ < 50) {
                return;
            }
            if(shapedTile.triangleTexture != null) {
                ComplexTile.viewspaceX[triangle] = viewspaceX;
                ComplexTile.viewspaceY[triangle] = viewspaceY;
                ComplexTile.viewspaceZ[triangle] = viewspaceZ;
            }
            ComplexTile.screenX[triangle] = Rasterizer3D.center_x + (viewspaceX << 9) / viewspaceZ;
            ComplexTile.screenY[triangle] = Rasterizer3D.center_y + (viewspaceY << 9) / viewspaceZ;
        }
        Rasterizer3D.alpha = 0;
        triangleCount = shapedTile.triangleA.length;
        for(int triangle = 0; triangle < triangleCount; triangle++) {
            int a = shapedTile.triangleA[triangle];
            int b = shapedTile.triangleB[triangle];
            int c = shapedTile.triangleC[triangle];
            int screenXA = ComplexTile.screenX[a];
            int screenXB = ComplexTile.screenX[b];
            int screenXC = ComplexTile.screenX[c];
            int screenYA = ComplexTile.screenY[a];
            int screenYB = ComplexTile.screenY[b];
            int screenYC = ComplexTile.screenY[c];
            if(((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB)) > 0) {
                Rasterizer3D.restrict_edges = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx;
                if(clicked && isMouseWithinTriangle(clickX, clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                    clickedTileX = tileX;
                    clickedTileY = tileY;
                }

                if(isMouseWithinTriangle(Class13.mouseX, Landscape.mouseY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                    hoveredTileX = tileX;
                    hoveredTileY = tileY;
                }

                if(shapedTile.triangleTexture == null || shapedTile.triangleTexture[triangle] == -1) {
                    if(shapedTile.triangleHSLA[triangle] != 0xbc614e) {
                        Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle]);
                    }
                } else if(lowMemory) {
                    int i_240_ = Rasterizer3D.anInterface3_2939.method14(true, shapedTile.triangleTexture[triangle]);
                    Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, method108(i_240_, shapedTile.triangleHSLA[triangle]), method108(i_240_, shapedTile.triangleHSLB[triangle]), method108(i_240_, shapedTile.triangleHSLC[triangle]));
                } else if(shapedTile.flat) {
                    Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle], ComplexTile.viewspaceX[0], ComplexTile.viewspaceX[1], ComplexTile.viewspaceX[3], ComplexTile.viewspaceY[0], ComplexTile.viewspaceY[1], ComplexTile.viewspaceY[3], ComplexTile.viewspaceZ[0], ComplexTile.viewspaceZ[1], ComplexTile.viewspaceZ[3], shapedTile.triangleTexture[triangle]);
                } else {
                    Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle], ComplexTile.viewspaceX[a], ComplexTile.viewspaceX[b], ComplexTile.viewspaceX[c], ComplexTile.viewspaceY[a], ComplexTile.viewspaceY[b], ComplexTile.viewspaceY[c], ComplexTile.viewspaceZ[a], ComplexTile.viewspaceZ[b], ComplexTile.viewspaceZ[c], shapedTile.triangleTexture[triangle]);
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
        if(sceneTile != null) {
            for(int e = 0; e < sceneTile.entityCount; e++) {
                if(((sceneTile.interactiveObjects[e].config & 0x100) == 256) && ((sceneTile.interactiveObjects[e].renderable) instanceof Model)) {
                    Model model = ((Model) (sceneTile.interactiveObjects[e].renderable));
                    model.method799();
                    if(model.modelHeight > i) {
                        i = model.modelHeight;
                    }
                }
            }
        }
        groundItemTile.anInt1371 = i;
        if(tileArray[z][x][y] == null) {
            tileArray[z][x][y] = new SceneTile(z, x, y);
        }
        tileArray[z][x][y].groundItemTile = groundItemTile;
    }

    public boolean addRenderableC(int minX, int minY, int z, int worldX, int worldY, int worldZ, int rotation, int tileWidth, int tileHeight, int hash, Renderable renderable, boolean isDynamic, int config) {
        for(int x = minX; x < minX + tileHeight; x++) {
            for(int y = minY; y < minY + tileWidth; y++) {
                if(x < 0 || y < 0 || x >= mapSizeX || y >= mapSizeY) {
                    return false;
                }
                SceneTile sceneTile = tileArray[z][x][y];
                if(sceneTile != null && sceneTile.entityCount >= 5) {
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
        for(int i = minX; i < minX + tileHeight; i++) {
            for(int i_243_ = minY; i_243_ < minY + tileWidth; i_243_++) {
                int i_244_ = 0;
                if(i > minX) {
                    i_244_++;
                }
                if(i < minX + tileHeight - 1) {
                    i_244_ += 4;
                }
                if(i_243_ > minY) {
                    i_244_ += 8;
                }
                if(i_243_ < minY + tileWidth - 1) {
                    i_244_ += 2;
                }
                for(int i_245_ = z; i_245_ >= 0; i_245_--) {
                    if(tileArray[i_245_][i][i_243_] == null) {
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
        if(isDynamic) {
            sceneSpawnRequestsCache[sceneSpawnRequestsCacheCurrentPos++] = interactiveObject;
        }
        return true;
    }

    public int getArrangement(int z, int x, int y, int hash) {
        SceneTile sceneTile = tileArray[z][x][y];
        if(sceneTile == null) {
            return -1;
        }
        if(sceneTile.wall != null && sceneTile.wall.hash == hash) {
            return sceneTile.wall.config & 0xff;
        }
        if(sceneTile.wallDecoration != null && sceneTile.wallDecoration.hash == hash) {
            return sceneTile.wallDecoration.config & 0xff;
        }
        if(sceneTile.floorDecoration != null && sceneTile.floorDecoration.hash == hash) {
            return sceneTile.floorDecoration.config & 0xff;
        }
        for(int i = 0; i < sceneTile.entityCount; i++) {
            if(sceneTile.interactiveObjects[i].hash == hash) {
                return sceneTile.interactiveObjects[i].config & 0xff;
            }
        }
        return -1;
    }

    public boolean isMouseWithinTriangle(int mouseX, int mouseY, int pointAY, int pointBY, int pointCY, int pointAX, int pointBX, int pointCX) {
        if(mouseY < pointAY && mouseY < pointBY && mouseY < pointCY) {
            return false;
        }
        if(mouseY > pointAY && mouseY > pointBY && mouseY > pointCY) {
            return false;
        }
        if(mouseX < pointAX && mouseX < pointBX && mouseX < pointCX) {
            return false;
        }
        if(mouseX > pointAX && mouseX > pointBX && mouseX > pointCX) {
            return false;
        }
        int b1 = (mouseY - pointAY) * (pointBX - pointAX) - (mouseX - pointAX) * (pointBY - pointAY);
        int b2 = (mouseY - pointCY) * (pointAX - pointCX) - (mouseX - pointCX) * (pointAY - pointCY);
        int b3 = (mouseY - pointBY) * (pointCX - pointBX) - (mouseX - pointBX) * (pointCY - pointBY);
        return b1 * b3 > 0 && b3 * b2 > 0;
    }
}
