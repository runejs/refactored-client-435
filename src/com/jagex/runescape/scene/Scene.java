package com.jagex.runescape.scene;

import com.jagex.runescape.*;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;

public class Scene {
    public static int cameraPosX;
    public static int anInt77 = 0;
    public static int anInt78 = -1;
    public static int cameraPositionTileX;
    public static int[] faceOffsetX2 = new int[]{53, -53, -53, 53};
    public static int anInt81 = -1;
    public static int anInt82;
    public static int anInt84;
    public static int anInt85 = 0;
    public static int cycle;
    public static int anInt87;
    public static boolean aBoolean88 = true;
    public static int anInt89;
    public static int anInt90 = 4;
    public static int anInt91 = 0;
    public static int[] faceOffsetX3 = new int[]{-45, 45, 45, -45};
    public static int anInt95;
    public static int anInt96 = 0;
    public static int cameraPosY;
    public static int anInt99;
    public static int cameraPositionTileY;
    public static int[] anIntArray101 = new int[anInt90];
    public static int[] faceOffsetY3 = new int[]{45, 45, -45, -45};
    public static int anInt104;
    public static InteractiveObject[] sceneSpawnRequestsCache = new InteractiveObject[100];
    public static SceneCluster[] processedCullingClusters = new SceneCluster[500];
    public static LinkedList tileList = new LinkedList();
    public static int anInt109 = 0;
    public static int anInt110;
    public static int anInt111;
    public static int[] faceOffsetY2 = new int[]{-53, -53, 53, 53};
    public static SceneCluster[][] cullingClusters = new SceneCluster[anInt90][500];
    public static boolean aBoolean114 = false;
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
    public int anInt92;
    public InteractiveObject[] aInteractiveObjectArray93 = new InteractiveObject[5000];
    public int mapSizeX;
    public int anInt103 = 0;
    public int[][][] heightMap;
    public int anInt115;
    public int mapSizeY;
    public int[][] anIntArrayArray121;
    public int[] anIntArray123;
    public int anInt126;
    public int[] anIntArray127;
    public int[][] anIntArrayArray129;

    public Scene(int arg0, int arg1, int arg2, int[][][] arg3) {
        anInt92 = 0;
        anIntArrayArray121 = (new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}});
        anIntArray123 = new int[10000];
        anInt126 = 0;
        anIntArray127 = new int[10000];
        anIntArrayArray129 = new int[][]{new int[16], {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
        anInt115 = arg0;
        mapSizeX = arg1;
        mapSizeY = arg2;
        tileArray = new SceneTile[arg0][arg1][arg2];
        anIntArrayArrayArray83 = new int[arg0][arg1 + 1][arg2 + 1];
        heightMap = arg3;
        method98();
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
        sceneSpawnRequestsCache = null;
        faceOffsetX2 = null;
        faceOffsetY2 = null;
        faceOffsetX3 = null;
        faceOffsetY3 = null;
        anIntArray101 = null;
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
        cullingClusters[z][anIntArray101[z]++] = sceneCluster;
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
            Class52 class52 = sceneTile.aClass52_2070;
            if(class52 == null) {
                Class11 class11 = sceneTile.aClass11_2068;
                if(class11 != null) {
                    int i = class11.anInt373;
                    int i_16_ = class11.anInt364;
                    int i_17_ = class11.anInt379;
                    int i_18_ = class11.anInt366;
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
                int i = class52.anInt1226;
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

    public void method97(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
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
        anInt89 = arg1;
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
        for(int i = anInt103; i < anInt115; i++) {
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
        for(int i = anInt103; i < anInt115; i++) {
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
                            aBoolean114 = false;
                            return;
                        }
                    }
                }
            }
        }
        for(int i = anInt103; i < anInt115; i++) {
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
                            aBoolean114 = false;
                            return;
                        }
                    }
                }
            }
        }
        aBoolean114 = false;
    }

    public void method98() {
        for(int i = 0; i < anInt115; i++) {
            for(int i_37_ = 0; i_37_ < mapSizeX; i_37_++) {
                for(int i_38_ = 0; i_38_ < mapSizeY; i_38_++) {
                    tileArray[i][i_37_][i_38_] = null;
                }
            }
        }
        for(int i = 0; i < anInt90; i++) {
            for(int i_39_ = 0; i_39_ < anIntArray101[i]; i_39_++) {
                cullingClusters[i][i_39_] = null;
            }
            anIntArray101[i] = 0;
        }
        for(int i = 0; i < anInt92; i++) {
            aInteractiveObjectArray93[i] = null;
        }
        anInt92 = 0;
        for(int i = 0; i < sceneSpawnRequestsCache.length; i++) {
            sceneSpawnRequestsCache[i] = null;
        }
    }

    public void method99(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19) {
        if(arg3 == 0) {
            Class52 class52 = new Class52(arg10, arg11, arg12, arg13, -1, arg18, false);
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null) {
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
                }
            }
            tileArray[arg0][arg1][arg2].aClass52_2070 = class52;
        } else if(arg3 == 1) {
            Class52 class52 = new Class52(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null) {
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
                }
            }
            tileArray[arg0][arg1][arg2].aClass52_2070 = class52;
        } else {
            Class11 class11 = new Class11(arg3, arg4, arg5, arg1, arg2, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null) {
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
                }
            }
            tileArray[arg0][arg1][arg2].aClass11_2068 = class11;
        }
    }

    public WallDecoration method100(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
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

    public void method104() {
        for(int i = 0; i < anInt92; i++) {
            InteractiveObject interactiveObject = aInteractiveObjectArray93[i];
            method105(interactiveObject);
            aInteractiveObjectArray93[i] = null;
        }
        anInt92 = 0;
    }

    public void method105(InteractiveObject arg0) {
        for(int i = arg0.tileLeft; i <= arg0.tileRight; i++) {
            for(int i_72_ = arg0.tileTop; i_72_ <= arg0.tileBottom; i_72_++) {
                SceneTile sceneTile = tileArray[arg0.z][i][i_72_];
                if(sceneTile != null) {
                    for(int i_73_ = 0; i_73_ < sceneTile.entityCount; i_73_++) {
                        if(sceneTile.interactiveObjects[i_73_] == arg0) {
                            sceneTile.entityCount--;
                            for(int i_74_ = i_73_; i_74_ < sceneTile.entityCount; i_74_++) {
                                sceneTile.interactiveObjects[i_74_] = (sceneTile.interactiveObjects[i_74_ + 1]);
                                sceneTile.sceneSpawnRequestsSize[i_74_] = sceneTile.sceneSpawnRequestsSize[i_74_ + 1];
                            }
                            sceneTile.interactiveObjects[(sceneTile.entityCount)] = null;
                            break;
                        }
                    }
                    sceneTile.interactiveObjectsSizeOR = 0;
                    for(int i_75_ = 0; i_75_ < sceneTile.entityCount; i_75_++) {
                        sceneTile.interactiveObjectsSizeOR |= sceneTile.sceneSpawnRequestsSize[i_75_];
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
                        if(sceneTile_84_.aClass52_2070 != null) {
                            if(!isTileOccluded(i, i_76_, 0)) {
                                method128(sceneTile_84_.aClass52_2070, 0, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                            }
                        } else if(sceneTile_84_.aClass11_2068 != null && !isTileOccluded(i, i_76_, 0)) {
                            method138(sceneTile_84_.aClass11_2068, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                        }
                        Wall wall = sceneTile_84_.wall;
                        if(wall != null) {
                            wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - anInt89, wall.y - cameraPosY, wall.hash);
                        }
                        for(int i_85_ = 0; i_85_ < sceneTile_84_.entityCount; i_85_++) {
                            InteractiveObject interactiveObject = sceneTile_84_.interactiveObjects[i_85_];
                            if(interactiveObject != null) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, anInt82, anInt110, anInt104, anInt99, interactiveObject.worldX - cameraPosX, interactiveObject.worldZ - anInt89, interactiveObject.worldY - cameraPosY, interactiveObject.hash);
                            }
                        }
                    }
                    boolean bool = false;
                    if(groundTile.aClass52_2070 != null) {
                        if(!isTileOccluded(i, i_76_, i_78_)) {
                            bool = true;
                            method128(groundTile.aClass52_2070, i_78_, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                        }
                    } else if(groundTile.aClass11_2068 != null && !isTileOccluded(i, i_76_, i_78_)) {
                        bool = true;
                        method138(groundTile.aClass11_2068, anInt82, anInt110, anInt104, anInt99, i, i_76_);
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
                            wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - anInt89, wall.y - cameraPosY, wall.hash);
                        }
                        if((wall.orientation2 & i_87_) != 0 && !isWallOccluded(i_78_, i, i_76_, wall.orientation2)) {
                            wall.secondary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - anInt89, wall.y - cameraPosY, wall.hash);
                        }
                    }
                    if(wallDecoration != null && !isOccluded(i_78_, i, i_76_, (wallDecoration.renderable.modelHeight))) {
                        if((wallDecoration.configBits & i_87_) != 0) {
                            wallDecoration.renderable.renderAtPoint(wallDecoration.face, anInt82, anInt110, anInt104, anInt99, wallDecoration.x - cameraPosX, wallDecoration.z - anInt89, wallDecoration.y - cameraPosY, wallDecoration.hash);
                        } else if((wallDecoration.configBits & 0x300) != 0) {
                            int i_88_ = wallDecoration.x - cameraPosX;
                            int i_89_ = wallDecoration.z - anInt89;
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
                            floorDecoration.renderable.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, floorDecoration.x - cameraPosX, floorDecoration.z - anInt89, floorDecoration.y - cameraPosY, floorDecoration.hash);
                        }
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if(groundItemTile != null && groundItemTile.anInt1371 == 0) {
                            if(groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, groundItemTile.z - anInt89, groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, groundItemTile.z - anInt89, groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, groundItemTile.z - anInt89, groundItemTile.y - cameraPosY, groundItemTile.hash);
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
                            wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - anInt89, wall.y - cameraPosY, wall.hash);
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
                                sceneSpawnRequestsCache[i_105_++] = entity;
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
                                InteractiveObject interactiveObject = sceneSpawnRequestsCache[i_117_];
                                if(interactiveObject.cycle != cycle) {
                                    if(interactiveObject.anInt491 > i_115_) {
                                        i_115_ = interactiveObject.anInt491;
                                        i_116_ = i_117_;
                                    } else if(interactiveObject.anInt491 == i_115_) {
                                        int i_118_ = interactiveObject.worldX - cameraPosX;
                                        int i_119_ = interactiveObject.worldY - cameraPosY;
                                        int i_120_ = ((sceneSpawnRequestsCache[i_116_].worldX) - cameraPosX);
                                        int i_121_ = ((sceneSpawnRequestsCache[i_116_].worldY) - cameraPosY);
                                        if(i_118_ * i_118_ + i_119_ * i_119_ > (i_120_ * i_120_ + i_121_ * i_121_)) {
                                            i_116_ = i_117_;
                                        }
                                    }
                                }
                            }
                            if(i_116_ == -1) {
                                break;
                            }
                            InteractiveObject interactiveObject = sceneSpawnRequestsCache[i_116_];
                            interactiveObject.cycle = cycle;
                            if(!isAreaOccluded(i_78_, interactiveObject.tileLeft, interactiveObject.tileRight, interactiveObject.tileTop, interactiveObject.tileBottom, (interactiveObject.renderable.modelHeight))) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, anInt82, anInt110, anInt104, anInt99, interactiveObject.worldX - cameraPosX, interactiveObject.worldZ - anInt89, interactiveObject.worldY - cameraPosY, interactiveObject.hash);
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
                                groundItemTile.secondGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, (groundItemTile.z - anInt89 - groundItemTile.anInt1371), groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, (groundItemTile.z - anInt89 - groundItemTile.anInt1371), groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                            if(groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, groundItemTile.x - cameraPosX, (groundItemTile.z - anInt89 - groundItemTile.anInt1371), groundItemTile.y - cameraPosY, groundItemTile.hash);
                            }
                        }
                        if(groundTile.anInt2064 != 0) {
                            WallDecoration wallDecoration = groundTile.wallDecoration;
                            if(wallDecoration != null && !isOccluded(i_78_, i, i_76_, (wallDecoration.renderable.modelHeight))) {
                                if((wallDecoration.configBits & groundTile.anInt2064) != 0) {
                                    wallDecoration.renderable.renderAtPoint(wallDecoration.face, anInt82, anInt110, anInt104, anInt99, wallDecoration.x - cameraPosX, wallDecoration.z - anInt89, wallDecoration.y - cameraPosY, wallDecoration.hash);
                                } else if((wallDecoration.configBits & 0x300) != 0) {
                                    int i_129_ = wallDecoration.x - cameraPosX;
                                    int i_130_ = wallDecoration.z - anInt89;
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
                                    wall.secondary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - anInt89, wall.y - cameraPosY, wall.hash);
                                }
                                if((wall.orientation & groundTile.anInt2064) != 0 && !isWallOccluded(i_78_, i, i_76_, wall.orientation)) {
                                    wall.primary.renderAtPoint(0, anInt82, anInt110, anInt104, anInt99, wall.x - cameraPosX, wall.z - anInt89, wall.y - cameraPosY, wall.hash);
                                }
                            }
                        }
                        if(i_77_ < anInt115 - 1) {
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
        return addRenderableC(arg0, arg8, arg9, arg10 - arg8 + 1, arg11 - arg9 + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
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

    public void method117(Model arg0, int arg1, int arg2, int arg3) {
        if(arg2 < mapSizeX) {
            SceneTile sceneTile = tileArray[arg1][arg2 + 1][arg3];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null) {
                    method121(arg0, class40_sub5_sub17_sub5, 128, 0, 0, true);
                }
            }
        }
        if(arg3 < mapSizeX) {
            SceneTile sceneTile = tileArray[arg1][arg2][arg3 + 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null) {
                    method121(arg0, class40_sub5_sub17_sub5, 0, 0, 128, true);
                }
            }
        }
        if(arg2 < mapSizeX && arg3 < mapSizeY) {
            SceneTile sceneTile = tileArray[arg1][arg2 + 1][arg3 + 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null) {
                    method121(arg0, class40_sub5_sub17_sub5, 128, 0, 128, true);
                }
            }
        }
        if(arg2 < mapSizeX && arg3 > 0) {
            SceneTile sceneTile = tileArray[arg1][arg2 + 1][arg3 - 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null) {
                    method121(arg0, class40_sub5_sub17_sub5, 128, 0, -128, true);
                }
            }
        }
    }

    public void method118(int arg0, int arg1, int arg2) {
        for(int i = 0; i < anInt115; i++) {
            for(int i_151_ = 0; i_151_ < mapSizeX; i_151_++) {
                for(int i_152_ = 0; i_152_ < mapSizeY; i_152_++) {
                    SceneTile sceneTile = tileArray[i][i_151_][i_152_];
                    if(sceneTile != null) {
                        Wall wall = sceneTile.wall;
                        if(wall != null && (wall.primary instanceof Model)) {
                            Model class40_sub5_sub17_sub5 = ((Model) wall.primary);
                            if(class40_sub5_sub17_sub5.verticesNormal != null) {
                                method129(class40_sub5_sub17_sub5, i, i_151_, i_152_, 1, 1);
                                if(wall.secondary instanceof Model) {
                                    Model class40_sub5_sub17_sub5_153_ = ((Model) wall.secondary);
                                    if((class40_sub5_sub17_sub5_153_.verticesNormal) != null) {
                                        method129(class40_sub5_sub17_sub5_153_, i, i_151_, i_152_, 1, 1);
                                        method121(class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_153_, 0, 0, 0, false);
                                        class40_sub5_sub17_sub5_153_.method826(arg0, arg1, arg2);
                                    }
                                }
                                class40_sub5_sub17_sub5.method826(arg0, arg1, arg2);
                            }
                        }
                        for(int i_154_ = 0; i_154_ < sceneTile.entityCount; i_154_++) {
                            InteractiveObject interactiveObject = sceneTile.interactiveObjects[i_154_];
                            if(interactiveObject != null && (interactiveObject.renderable instanceof Model)) {
                                Model class40_sub5_sub17_sub5 = ((Model) interactiveObject.renderable);
                                if(class40_sub5_sub17_sub5.verticesNormal != null) {
                                    method129(class40_sub5_sub17_sub5, i, i_151_, i_152_, (interactiveObject.tileRight - interactiveObject.tileLeft + 1), (interactiveObject.tileBottom - interactiveObject.tileTop + 1));
                                    class40_sub5_sub17_sub5.method826(arg0, arg1, arg2);
                                }
                            }
                        }
                        FloorDecoration floorDecoration = sceneTile.floorDecoration;
                        if(floorDecoration != null && (floorDecoration.renderable instanceof Model)) {
                            Model class40_sub5_sub17_sub5 = ((Model) floorDecoration.renderable);
                            if(class40_sub5_sub17_sub5.verticesNormal != null) {
                                method117(class40_sub5_sub17_sub5, i, i_151_, i_152_);
                                class40_sub5_sub17_sub5.method826(arg0, arg1, arg2);
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
        aBoolean114 = true;
        anInt91 = arg0;
        anInt77 = arg1;
        anInt78 = -1;
        anInt81 = -1;
    }

    public void method121(Model arg0, Model arg1, int arg2, int arg3, int arg4, boolean arg5) {
        arg1.method822();
        anInt126++;
        int i = 0;
        int[] is = arg1.verticesX;
        int i_161_ = arg1.vertexCount;
        for(int i_162_ = 0; i_162_ < arg0.vertexCount; i_162_++) {
            VertexNormal class46 = arg0.verticesNormal[i_162_];
            VertexNormal class46_163_ = arg0.vertexNormalOffset[i_162_];
            if(class46_163_.magnitude != 0) {
                int i_164_ = arg0.verticesY[i_162_] - arg3;
                if(i_164_ <= arg1.anInt3175) {
                    int i_165_ = arg0.verticesX[i_162_] - arg2;
                    if(i_165_ >= arg1.anInt3171 && i_165_ <= arg1.anInt3163) {
                        int i_166_ = arg0.verticesZ[i_162_] - arg4;
                        if(i_166_ >= arg1.anInt3177 && i_166_ <= arg1.anInt3189) {
                            for(int i_167_ = 0; i_167_ < i_161_; i_167_++) {
                                VertexNormal class46_168_ = arg1.verticesNormal[i_167_];
                                VertexNormal class46_169_ = arg1.vertexNormalOffset[i_167_];
                                if(i_165_ == is[i_167_] && i_166_ == arg1.verticesZ[i_167_] && i_164_ == arg1.verticesY[i_167_] && class46_169_.magnitude != 0) {
                                    class46.x += class46_169_.x;
                                    class46.y += class46_169_.y;
                                    class46.z += class46_169_.z;
                                    class46.magnitude += class46_169_.magnitude;
                                    class46_168_.x += class46_163_.x;
                                    class46_168_.y += class46_163_.y;
                                    class46_168_.z += class46_163_.z;
                                    class46_168_.magnitude += class46_163_.magnitude;
                                    i++;
                                    anIntArray127[i_162_] = anInt126;
                                    anIntArray123[i_167_] = anInt126;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(i >= 3 && arg5) {
            for(int i_170_ = 0; i_170_ < arg0.triangleCount; i_170_++) {
                if(anIntArray127[arg0.trianglePointsX[i_170_]] == anInt126 && anIntArray127[arg0.trianglePointsY[i_170_]] == anInt126 && anIntArray127[arg0.trianglePointsZ[i_170_]] == anInt126) {
                    arg0.triangleDrawType[i_170_] = -1;
                }
            }
            for(int i_171_ = 0; i_171_ < arg1.triangleCount; i_171_++) {
                if(anIntArray123[arg1.trianglePointsX[i_171_]] == anInt126 && anIntArray123[arg1.trianglePointsY[i_171_]] == anInt126 && anIntArray123[arg1.trianglePointsZ[i_171_]] == anInt126) {
                    arg1.triangleDrawType[i_171_] = -1;
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
        int i = anIntArray101[anInt85];
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
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - anInt89 << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - anInt89 << 8) / i_176_;
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
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - anInt89 << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - anInt89 << 8) / i_180_;
                        processedCullingClusters[anInt96++] = sceneCluster;
                    }
                }
            } else if(sceneCluster.searchMask == 4) {
                int i_181_ = sceneCluster.worldEndZ - anInt89;
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

    public void method128(Class52 arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        int i_188_;
        int i = i_188_ = (arg6 << 7) - cameraPosX;
        int i_190_;
        int i_189_ = i_190_ = (arg7 << 7) - cameraPosY;
        int i_192_;
        int i_191_ = i_192_ = i + 128;
        int i_194_;
        int i_193_ = i_194_ = i_189_ + 128;
        int i_195_ = heightMap[arg1][arg6][arg7] - anInt89;
        int i_196_ = heightMap[arg1][arg6 + 1][arg7] - anInt89;
        int i_197_ = heightMap[arg1][arg6 + 1][arg7 + 1] - anInt89;
        int i_198_ = heightMap[arg1][arg6][arg7 + 1] - anInt89;
        int i_199_ = i_189_ * arg4 + i * arg5 >> 16;
        i_189_ = i_189_ * arg5 - i * arg4 >> 16;
        i = i_199_;
        i_199_ = i_195_ * arg3 - i_189_ * arg2 >> 16;
        i_189_ = i_195_ * arg2 + i_189_ * arg3 >> 16;
        i_195_ = i_199_;
        if(i_189_ >= 50) {
            i_199_ = i_190_ * arg4 + i_191_ * arg5 >> 16;
            i_190_ = i_190_ * arg5 - i_191_ * arg4 >> 16;
            i_191_ = i_199_;
            i_199_ = i_196_ * arg3 - i_190_ * arg2 >> 16;
            i_190_ = i_196_ * arg2 + i_190_ * arg3 >> 16;
            i_196_ = i_199_;
            if(i_190_ >= 50) {
                i_199_ = i_193_ * arg4 + i_192_ * arg5 >> 16;
                i_193_ = i_193_ * arg5 - i_192_ * arg4 >> 16;
                i_192_ = i_199_;
                i_199_ = i_197_ * arg3 - i_193_ * arg2 >> 16;
                i_193_ = i_197_ * arg2 + i_193_ * arg3 >> 16;
                i_197_ = i_199_;
                if(i_193_ >= 50) {
                    i_199_ = i_194_ * arg4 + i_188_ * arg5 >> 16;
                    i_194_ = i_194_ * arg5 - i_188_ * arg4 >> 16;
                    i_188_ = i_199_;
                    i_199_ = i_198_ * arg3 - i_194_ * arg2 >> 16;
                    i_194_ = i_198_ * arg2 + i_194_ * arg3 >> 16;
                    i_198_ = i_199_;
                    if(i_194_ >= 50) {
                        int i_200_ = (Rasterizer3D.anInt2937 + (i << 9) / i_189_);
                        int i_201_ = (Rasterizer3D.anInt2931 + (i_195_ << 9) / i_189_);
                        int i_202_ = (Rasterizer3D.anInt2937 + (i_191_ << 9) / i_190_);
                        int i_203_ = (Rasterizer3D.anInt2931 + (i_196_ << 9) / i_190_);
                        int i_204_ = (Rasterizer3D.anInt2937 + (i_192_ << 9) / i_193_);
                        int i_205_ = (Rasterizer3D.anInt2931 + (i_197_ << 9) / i_193_);
                        int i_206_ = (Rasterizer3D.anInt2937 + (i_188_ << 9) / i_194_);
                        int i_207_ = (Rasterizer3D.anInt2931 + (i_198_ << 9) / i_194_);
                        Rasterizer3D.anInt2933 = 0;
                        if(((i_204_ - i_206_) * (i_203_ - i_207_) - (i_205_ - i_207_) * (i_202_ - i_206_)) > 0) {
                            Rasterizer3D.aBoolean2947 = i_204_ < 0 || i_206_ < 0 || i_202_ < 0 || i_204_ > Rasterizer3D.anInt2945 || i_206_ > Rasterizer3D.anInt2945 || i_202_ > Rasterizer3D.anInt2945;
                            if(aBoolean114 && method142(anInt91, anInt77, i_205_, i_207_, i_203_, i_204_, i_206_, i_202_)) {
                                anInt78 = arg6;
                                anInt81 = arg7;
                            }
                            if(arg0.anInt1220 == -1) {
                                if(arg0.anInt1235 != 12345678) {
                                    Rasterizer3D.method706(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, arg0.anInt1235, arg0.anInt1232, arg0.anInt1225);
                                }
                            } else if(aBoolean88) {
                                int i_208_ = Rasterizer3D.anInterface3_2939.method14(true, arg0.anInt1220);
                                Rasterizer3D.method706(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, method108(i_208_, arg0.anInt1235), method108(i_208_, arg0.anInt1232), method108(i_208_, arg0.anInt1225));
                            } else if(arg0.aBoolean1229) {
                                Rasterizer3D.method699(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, arg0.anInt1235, arg0.anInt1232, arg0.anInt1225, i, i_191_, i_188_, i_195_, i_196_, i_198_, i_189_, i_190_, i_194_, arg0.anInt1220);
                            } else {
                                Rasterizer3D.method699(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, arg0.anInt1235, arg0.anInt1232, arg0.anInt1225, i_192_, i_188_, i_191_, i_197_, i_198_, i_196_, i_193_, i_194_, i_190_, arg0.anInt1220);
                            }
                        }
                        if(((i_200_ - i_202_) * (i_207_ - i_203_) - (i_201_ - i_203_) * (i_206_ - i_202_)) > 0) {
                            Rasterizer3D.aBoolean2947 = i_200_ < 0 || i_202_ < 0 || i_206_ < 0 || i_200_ > Rasterizer3D.anInt2945 || i_202_ > Rasterizer3D.anInt2945 || i_206_ > Rasterizer3D.anInt2945;
                            if(aBoolean114 && method142(anInt91, anInt77, i_201_, i_203_, i_207_, i_200_, i_202_, i_206_)) {
                                anInt78 = arg6;
                                anInt81 = arg7;
                            }
                            if(arg0.anInt1220 == -1) {
                                if(arg0.anInt1231 != 12345678) {
                                    Rasterizer3D.method706(i_201_, i_203_, i_207_, i_200_, i_202_, i_206_, arg0.anInt1231, arg0.anInt1225, arg0.anInt1232);
                                }
                            } else if(aBoolean88) {
                                int i_209_ = Rasterizer3D.anInterface3_2939.method14(true, arg0.anInt1220);
                                Rasterizer3D.method706(i_201_, i_203_, i_207_, i_200_, i_202_, i_206_, method108(i_209_, arg0.anInt1231), method108(i_209_, arg0.anInt1225), method108(i_209_, arg0.anInt1232));
                            } else {
                                Rasterizer3D.method699(i_201_, i_203_, i_207_, i_200_, i_202_, i_206_, arg0.anInt1231, arg0.anInt1225, arg0.anInt1232, i, i_191_, i_188_, i_195_, i_196_, i_198_, i_189_, i_190_, i_194_, arg0.anInt1220);
                            }
                        }
                    }
                }
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
            if(i_213_ != anInt115) {
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
                                            Model class40_sub5_sub17_sub5 = ((Model) (wall.primary));
                                            if((class40_sub5_sub17_sub5.verticesNormal) != null) {
                                                method121(arg0, class40_sub5_sub17_sub5, ((i_214_ - arg2) * 128 + (1 - arg4) * 64), i_216_, ((i_215_ - arg3) * 128 + (1 - arg5) * 64), bool);
                                            }
                                        }
                                        if(wall.secondary instanceof Model) {
                                            Model class40_sub5_sub17_sub5 = ((Model) (wall.secondary));
                                            if((class40_sub5_sub17_sub5.verticesNormal) != null) {
                                                method121(arg0, class40_sub5_sub17_sub5, ((i_214_ - arg2) * 128 + (1 - arg4) * 64), i_216_, ((i_215_ - arg3) * 128 + (1 - arg5) * 64), bool);
                                            }
                                        }
                                    }
                                    for(int i_217_ = 0; i_217_ < sceneTile.entityCount; i_217_++) {
                                        InteractiveObject interactiveObject = (sceneTile.interactiveObjects[i_217_]);
                                        if(interactiveObject != null && (interactiveObject.renderable instanceof Model)) {
                                            Model class40_sub5_sub17_sub5 = ((Model) (interactiveObject.renderable));
                                            if((class40_sub5_sub17_sub5.verticesNormal) != null) {
                                                int i_218_ = (interactiveObject.tileRight - interactiveObject.tileLeft + 1);
                                                int i_219_ = (interactiveObject.tileBottom - interactiveObject.tileTop + 1);
                                                method121(arg0, class40_sub5_sub17_sub5, ((interactiveObject.tileLeft - arg2) * 128 + (i_218_ - arg4) * 64), i_216_, ((interactiveObject.tileTop - arg3) * 128 + (i_219_ - arg5) * 64), bool);
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
        return addRenderableC(arg0, i, i_220_, i_221_ - i + 1, i_222_ - i_220_ + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
    }

    public void method135(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            for(int i = 0; i < sceneTile.entityCount; i++) {
                InteractiveObject interactiveObject = sceneTile.interactiveObjects[i];
                if((interactiveObject.hash >> 29 & 0x3) == 2 && interactiveObject.tileLeft == arg1 && interactiveObject.tileTop == arg2) {
                    method105(interactiveObject);
                    break;
                }
            }
        }
    }

    public void method136(int arg0) {
        anInt103 = arg0;
        for(int i = 0; i < mapSizeX; i++) {
            for(int i_223_ = 0; i_223_ < mapSizeY; i_223_++) {
                if(tileArray[arg0][i][i_223_] == null) {
                    tileArray[arg0][i][i_223_] = new SceneTile(arg0, i, i_223_);
                }
            }
        }
    }

    public boolean method137(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Renderable arg6, int arg7, int arg8, int arg9) {
        if(arg6 == null) {
            return true;
        }
        int i = arg1 * 128 + 64 * arg4;
        int i_224_ = arg2 * 128 + 64 * arg5;
        return addRenderableC(arg0, arg1, arg2, arg4, arg5, i, i_224_, arg3, arg6, arg7, false, arg8, arg9);
    }

    public void method138(Class11 arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        int i = arg0.anIntArray359.length;
        for(int i_225_ = 0; i_225_ < i; i_225_++) {
            int i_226_ = arg0.anIntArray359[i_225_] - cameraPosX;
            int i_227_ = arg0.anIntArray376[i_225_] - anInt89;
            int i_228_ = arg0.anIntArray378[i_225_] - cameraPosY;
            int i_229_ = i_228_ * arg3 + i_226_ * arg4 >> 16;
            i_228_ = i_228_ * arg4 - i_226_ * arg3 >> 16;
            i_226_ = i_229_;
            i_229_ = i_227_ * arg2 - i_228_ * arg1 >> 16;
            i_228_ = i_227_ * arg1 + i_228_ * arg2 >> 16;
            i_227_ = i_229_;
            if(i_228_ < 50) {
                return;
            }
            if(arg0.anIntArray361 != null) {
                Class11.anIntArray370[i_225_] = i_226_;
                Class11.anIntArray375[i_225_] = i_227_;
                Class11.anIntArray360[i_225_] = i_228_;
            }
            Class11.anIntArray363[i_225_] = Rasterizer3D.anInt2937 + (i_226_ << 9) / i_228_;
            Class11.anIntArray358[i_225_] = Rasterizer3D.anInt2931 + (i_227_ << 9) / i_228_;
        }
        Rasterizer3D.anInt2933 = 0;
        i = arg0.anIntArray374.length;
        for(int i_230_ = 0; i_230_ < i; i_230_++) {
            int i_231_ = arg0.anIntArray374[i_230_];
            int i_232_ = arg0.anIntArray362[i_230_];
            int i_233_ = arg0.anIntArray368[i_230_];
            int i_234_ = Class11.anIntArray363[i_231_];
            int i_235_ = Class11.anIntArray363[i_232_];
            int i_236_ = Class11.anIntArray363[i_233_];
            int i_237_ = Class11.anIntArray358[i_231_];
            int i_238_ = Class11.anIntArray358[i_232_];
            int i_239_ = Class11.anIntArray358[i_233_];
            if(((i_234_ - i_235_) * (i_239_ - i_238_) - (i_237_ - i_238_) * (i_236_ - i_235_)) > 0) {
                Rasterizer3D.aBoolean2947 = i_234_ < 0 || i_235_ < 0 || i_236_ < 0 || i_234_ > Rasterizer3D.anInt2945 || i_235_ > Rasterizer3D.anInt2945 || i_236_ > Rasterizer3D.anInt2945;
                if(aBoolean114 && method142(anInt91, anInt77, i_237_, i_238_, i_239_, i_234_, i_235_, i_236_)) {
                    anInt78 = arg5;
                    anInt81 = arg6;
                }
                if(arg0.anIntArray361 == null || arg0.anIntArray361[i_230_] == -1) {
                    if(arg0.anIntArray367[i_230_] != 12345678) {
                        Rasterizer3D.method706(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, arg0.anIntArray367[i_230_], arg0.anIntArray369[i_230_], arg0.anIntArray372[i_230_]);
                    }
                } else if(aBoolean88) {
                    int i_240_ = Rasterizer3D.anInterface3_2939.method14(true, arg0.anIntArray361[i_230_]);
                    Rasterizer3D.method706(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, method108(i_240_, arg0.anIntArray367[i_230_]), method108(i_240_, arg0.anIntArray369[i_230_]), method108(i_240_, arg0.anIntArray372[i_230_]));
                } else if(arg0.aBoolean365) {
                    Rasterizer3D.method699(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, arg0.anIntArray367[i_230_], arg0.anIntArray369[i_230_], arg0.anIntArray372[i_230_], Class11.anIntArray370[0], Class11.anIntArray370[1], Class11.anIntArray370[3], Class11.anIntArray375[0], Class11.anIntArray375[1], Class11.anIntArray375[3], Class11.anIntArray360[0], Class11.anIntArray360[1], Class11.anIntArray360[3], arg0.anIntArray361[i_230_]);
                } else {
                    Rasterizer3D.method699(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, arg0.anIntArray367[i_230_], arg0.anIntArray369[i_230_], arg0.anIntArray372[i_230_], Class11.anIntArray370[i_231_], Class11.anIntArray370[i_232_], Class11.anIntArray370[i_233_], Class11.anIntArray375[i_231_], Class11.anIntArray375[i_232_], Class11.anIntArray375[i_233_], Class11.anIntArray360[i_231_], Class11.anIntArray360[i_232_], Class11.anIntArray360[i_233_], arg0.anIntArray361[i_230_]);
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

    public boolean addRenderableC(int z, int minX, int minY, int tileHeight, int tileWidth, int worldX, int worldY, int worldZ, Renderable arg8, int arg9, boolean arg10, int hash, int config) {
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
        interactiveObject.renderable = arg8;
        interactiveObject.rotation = arg9;
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
        if(arg10) {
            aInteractiveObjectArray93[anInt92++] = interactiveObject;
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

    public boolean method142(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
            return false;
        }
        if(arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
            return false;
        }
        if(arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
            return false;
        }
        if(arg0 > arg5 && arg0 > arg6 && arg0 > arg7) {
            return false;
        }
        int i = (arg1 - arg2) * (arg6 - arg5) - (arg0 - arg5) * (arg3 - arg2);
        int i_246_ = (arg1 - arg4) * (arg5 - arg7) - (arg0 - arg7) * (arg2 - arg4);
        int i_247_ = (arg1 - arg3) * (arg7 - arg6) - (arg0 - arg6) * (arg4 - arg3);
        return i * i_247_ > 0 && i_247_ * i_246_ > 0;
    }
}
