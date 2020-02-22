package com.jagex.runescape;

import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;

public class Scene {
    public static int anInt76;
    public static int anInt77;
    public static int anInt78 = -1;
    public static int anInt79;
    public static int[] anIntArray80;
    public static int anInt81;
    public static int anInt82;
    public static int anInt84;
    public static int anInt85;
    public static int anInt86;
    public static int anInt87;
    public static boolean aBoolean88;
    public static int anInt89;
    public static int anInt90;
    public static int anInt91;
    public static int[] anIntArray94;
    public static int anInt95;
    public static int anInt96;
    public static int anInt98;
    public static int anInt99;
    public static int anInt100;
    public static int[] anIntArray101;
    public static int[] anIntArray102;
    public static int anInt104;
    public static Class19[] aClass19Array106;
    public static Class32[] aClass32Array107;
    public static Class45 aClass45_108;
    public static int anInt109;
    public static int anInt110;
    public static int anInt111;
    public static int[] anIntArray112;
    public static Class32[][] aClass32ArrayArray113;
    public static boolean aBoolean114;
    public static int[] anIntArray117;
    public static int anInt118;
    public static int[] anIntArray119;
    public static int[] anIntArray120;
    public static int anInt122;
    public static int anInt124;
    public static int[] anIntArray125;
    public static int anInt128;
    public static int[] anIntArray130;
    public static int[] anIntArray131;
    public static int[] anIntArray132;
    public static boolean[][] aBooleanArrayArray133;
    public static boolean[][][][] aBooleanArrayArrayArrayArray134;
    public static int anInt135;
    public static int anInt136;

    static {
        anInt77 = 0;
        anInt81 = -1;
        anIntArray80 = new int[]{53, -53, -53, 53};
        anInt96 = 0;
        anInt91 = 0;
        anIntArray102 = new int[]{45, 45, -45, -45};
        anInt85 = 0;
        anInt90 = 4;
        aBoolean88 = true;
        anIntArray101 = new int[anInt90];
        anIntArray94 = new int[]{-45, 45, 45, -45};
        anInt109 = 0;
        aBoolean114 = false;
        anIntArray112 = new int[]{-53, -53, 53, 53};
        aClass32ArrayArray113 = new Class32[anInt90][500];
        aClass32Array107 = new Class32[500];
        aClass19Array106 = new Class19[100];
        aClass45_108 = new Class45();
        anIntArray117 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
        anIntArray119 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
        anIntArray120 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
        anIntArray130 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
        aBooleanArrayArrayArrayArray134 = new boolean[8][32][51][51];
        anIntArray131 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
        anIntArray125 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
        anIntArray132 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
    }

    public SceneTile[][][] tileArray;
    public int[][][] anIntArrayArrayArray83;
    public int anInt92;
    public Class19[] aClass19Array93 = new Class19[5000];
    public int anInt97;
    public int anInt103 = 0;
    public int[][][] anIntArrayArrayArray105;
    public int anInt115;
    public int anInt116;
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
        anInt97 = arg1;
        anInt116 = arg2;
        tileArray = new SceneTile[arg0][arg1][arg2];
        anIntArrayArrayArray83 = new int[arg0][arg1 + 1][arg2 + 1];
        anIntArrayArrayArray105 = arg3;
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
        if(arg1 < 2)
            arg1 = 2;
        else if(arg1 > 126)
            arg1 = 126;
        return (arg0 & 0xff80) + arg1;
    }

    public static boolean method113(int arg0, int arg1, int arg2) {
        int i = arg2 * anInt104 + arg0 * anInt99 >> 16;
        int i_145_ = arg2 * anInt99 - arg0 * anInt104 >> 16;
        int i_146_ = arg1 * anInt82 + i_145_ * anInt110 >> 16;
        int i_147_ = arg1 * anInt110 - i_145_ * anInt82 >> 16;
        if(i_146_ < 50 || i_146_ > 3500)
            return false;
        int i_148_ = anInt122 + (i << 9) / i_146_;
        int i_149_ = anInt135 + (i_147_ << 9) / i_146_;
        return i_148_ >= anInt118 && i_148_ <= anInt136 && i_149_ >= anInt124 && i_149_ <= anInt128;
    }

    public static void method114() {
        aClass19Array106 = null;
        anIntArray80 = null;
        anIntArray112 = null;
        anIntArray94 = null;
        anIntArray102 = null;
        anIntArray101 = null;
        aClass32ArrayArray113 = null;
        aClass32Array107 = null;
        aClass45_108 = null;
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

    public static void method116(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        Class32 class32 = new Class32();
        class32.anInt757 = arg2 / 128;
        class32.anInt762 = arg3 / 128;
        class32.anInt745 = arg4 / 128;
        class32.anInt746 = arg5 / 128;
        class32.anInt756 = arg1;
        class32.anInt755 = arg2;
        class32.anInt748 = arg3;
        class32.anInt751 = arg4;
        class32.anInt758 = arg5;
        class32.anInt763 = arg6;
        class32.anInt759 = arg7;
        aClass32ArrayArray113[arg0][anIntArray101[arg0]++] = class32;
    }

    public int method91(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null || sceneTile.aClass53_2079 == null)
            return 0;
        return sceneTile.aClass53_2079.anInt1262;
    }

    public void method92(int arg0, int arg1) {
        SceneTile sceneTile = tileArray[0][arg0][arg1];
        for(int i = 0; i < 3; i++) {
            SceneTile sceneTile_0_ = (tileArray[i][arg0][arg1] = tileArray[i + 1][arg0][arg1]);
            if(sceneTile_0_ != null) {
                sceneTile_0_.anInt2066--;
                for(int i_1_ = 0; i_1_ < sceneTile_0_.anInt2080; i_1_++) {
                    Class19 class19 = sceneTile_0_.aClass19Array2065[i_1_];
                    if((class19.anInt469 >> 29 & 0x3) == 2 && class19.anInt473 == arg0 && class19.anInt481 == arg1)
                        class19.anInt468--;
                }
            }
        }
        if(tileArray[0][arg0][arg1] == null)
            tileArray[0][arg0][arg1] = new SceneTile(0, arg0, arg1);
        tileArray[0][arg0][arg1].aSceneTile_2058 = sceneTile;
        tileArray[3][arg0][arg1] = null;
    }

    public int method93(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null || sceneTile.floorDecoration == null)
            return 0;
        return sceneTile.floorDecoration.hash;
    }

    public void method94(int arg0, int arg1, int arg2, int arg3, Renderable arg4, Renderable arg5, int arg6, int arg7, int arg8, int arg9) {
        if(arg4 != null || arg5 != null) {
            Class10 class10 = new Class10();
            class10.anInt336 = arg8;
            class10.anInt348 = arg9;
            class10.anInt334 = arg1 * 128 + 64;
            class10.anInt355 = arg2 * 128 + 64;
            class10.anInt342 = arg3;
            class10.aRenderable_341 = arg4;
            class10.aRenderable_340 = arg5;
            class10.anInt337 = arg6;
            class10.anInt347 = arg7;
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null)
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
            }
            tileArray[arg0][arg1][arg2].aClass10_2072 = class10;
        }
    }

    public void method96(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        SceneTile sceneTile = tileArray[arg3][arg4][arg5];
        if(sceneTile != null) {
            Class52 class52 = sceneTile.aClass52_2070;
            if(class52 != null) {
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
            } else {
                Class11 class11 = sceneTile.aClass11_2068;
                if(class11 != null) {
                    int i = class11.anInt373;
                    int i_16_ = class11.anInt364;
                    int i_17_ = class11.anInt379;
                    int i_18_ = class11.anInt366;
                    int[] is = anIntArrayArray129[i];
                    int[] is_19_ = anIntArrayArray121[i_16_];
                    int i_20_ = 0;
                    if(i_17_ != 0) {
                        for(int i_21_ = 0; i_21_ < 4; i_21_++) {
                            arg0[arg1] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg0[arg1 + 1] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg0[arg1 + 2] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg0[arg1 + 3] = is[is_19_[i_20_++]] == 0 ? i_17_ : i_18_;
                            arg1 += arg2;
                        }
                    } else {
                        for(int i_22_ = 0; i_22_ < 4; i_22_++) {
                            if(is[is_19_[i_20_++]] != 0)
                                arg0[arg1] = i_18_;
                            if(is[is_19_[i_20_++]] != 0)
                                arg0[arg1 + 1] = i_18_;
                            if(is[is_19_[i_20_++]] != 0)
                                arg0[arg1 + 2] = i_18_;
                            if(is[is_19_[i_20_++]] != 0)
                                arg0[arg1 + 3] = i_18_;
                            arg1 += arg2;
                        }
                    }
                }
            }
        }
    }

    public void method97(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 < 0)
            arg0 = 0;
        else if(arg0 >= anInt97 * 128)
            arg0 = anInt97 * 128 - 1;
        if(arg2 < 0)
            arg2 = 0;
        else if(arg2 >= anInt116 * 128)
            arg2 = anInt116 * 128 - 1;
        anInt86++;
        anInt82 = Model.SINE[arg3];
        anInt110 = Model.COSINE[arg3];
        anInt104 = Model.SINE[arg4];
        anInt99 = Model.COSINE[arg4];
        aBooleanArrayArray133 = aBooleanArrayArrayArrayArray134[(arg3 - 128) / 32][arg4 / 64];
        anInt76 = arg0;
        anInt89 = arg1;
        anInt98 = arg2;
        anInt79 = arg0 / 128;
        anInt100 = arg2 / 128;
        anInt85 = arg5;
        anInt95 = anInt79 - 25;
        if(anInt95 < 0)
            anInt95 = 0;
        anInt87 = anInt100 - 25;
        if(anInt87 < 0)
            anInt87 = 0;
        anInt84 = anInt79 + 25;
        if(anInt84 > anInt97)
            anInt84 = anInt97;
        anInt111 = anInt100 + 25;
        if(anInt111 > anInt116)
            anInt111 = anInt116;
        method123();
        anInt109 = 0;
        for(int i = anInt103; i < anInt115; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for(int i_23_ = anInt95; i_23_ < anInt84; i_23_++) {
                for(int i_24_ = anInt87; i_24_ < anInt111; i_24_++) {
                    SceneTile sceneTile = sceneTiles[i_23_][i_24_];
                    if(sceneTile != null) {
                        if(sceneTile.anInt2063 > arg5 || (!(aBooleanArrayArray133[i_23_ - anInt79 + 25][i_24_ - anInt100 + 25]) && (anIntArrayArrayArray105[i][i_23_][i_24_] - arg1) < 2000)) {
                            sceneTile.aBoolean2071 = false;
                            sceneTile.aBoolean2077 = false;
                            sceneTile.anInt2067 = 0;
                        } else {
                            sceneTile.aBoolean2071 = true;
                            sceneTile.aBoolean2077 = true;
                            sceneTile.aBoolean2062 = sceneTile.anInt2080 > 0;
                            anInt109++;
                        }
                    }
                }
            }
        }
        for(int i = anInt103; i < anInt115; i++) {
            SceneTile[][] sceneTiles = tileArray[i];
            for(int i_25_ = -25; i_25_ <= 0; i_25_++) {
                int i_26_ = anInt79 + i_25_;
                int i_27_ = anInt79 - i_25_;
                if(i_26_ >= anInt95 || i_27_ < anInt84) {
                    for(int i_28_ = -25; i_28_ <= 0; i_28_++) {
                        int i_29_ = anInt100 + i_28_;
                        int i_30_ = anInt100 - i_28_;
                        if(i_26_ >= anInt95) {
                            if(i_29_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_29_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, true);
                            }
                            if(i_30_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_30_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, true);
                            }
                        }
                        if(i_27_ < anInt84) {
                            if(i_29_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_29_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, true);
                            }
                            if(i_30_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_30_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, true);
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
                int i_32_ = anInt79 + i_31_;
                int i_33_ = anInt79 - i_31_;
                if(i_32_ >= anInt95 || i_33_ < anInt84) {
                    for(int i_34_ = -25; i_34_ <= 0; i_34_++) {
                        int i_35_ = anInt100 + i_34_;
                        int i_36_ = anInt100 - i_34_;
                        if(i_32_ >= anInt95) {
                            if(i_35_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_35_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, false);
                            }
                            if(i_36_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_36_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, false);
                            }
                        }
                        if(i_33_ < anInt84) {
                            if(i_35_ >= anInt87) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_35_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, false);
                            }
                            if(i_36_ < anInt111) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_36_];
                                if(sceneTile != null && sceneTile.aBoolean2071)
                                    method106(sceneTile, false);
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
            for(int i_37_ = 0; i_37_ < anInt97; i_37_++) {
                for(int i_38_ = 0; i_38_ < anInt116; i_38_++)
                    tileArray[i][i_37_][i_38_] = null;
            }
        }
        for(int i = 0; i < anInt90; i++) {
            for(int i_39_ = 0; i_39_ < anIntArray101[i]; i_39_++)
                aClass32ArrayArray113[i][i_39_] = null;
            anIntArray101[i] = 0;
        }
        for(int i = 0; i < anInt92; i++)
            aClass19Array93[i] = null;
        anInt92 = 0;
        for(int i = 0; i < aClass19Array106.length; i++)
            aClass19Array106[i] = null;
    }

    public void method99(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19) {
        if(arg3 == 0) {
            Class52 class52 = new Class52(arg10, arg11, arg12, arg13, -1, arg18, false);
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null)
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
            }
            tileArray[arg0][arg1][arg2].aClass52_2070 = class52;
        } else if(arg3 == 1) {
            Class52 class52 = new Class52(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null)
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
            }
            tileArray[arg0][arg1][arg2].aClass52_2070 = class52;
        } else {
            Class11 class11 = new Class11(arg3, arg4, arg5, arg1, arg2, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null)
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
            }
            tileArray[arg0][arg1][arg2].aClass11_2068 = class11;
        }
    }

    public Class53 method100(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null)
            return null;
        return sceneTile.aClass53_2079;
    }

    public boolean method101(int arg0, int arg1, int arg2) {
        int i = anIntArrayArrayArray83[arg0][arg1][arg2];
        if(i == -anInt86)
            return false;
        if(i == anInt86)
            return true;
        int i_40_ = arg1 << 7;
        int i_41_ = arg2 << 7;
        if(method103(i_40_ + 1, anIntArrayArrayArray105[arg0][arg1][arg2], i_41_ + 1) && method103(i_40_ + 128 - 1, anIntArrayArrayArray105[arg0][arg1 + 1][arg2], i_41_ + 1) && method103(i_40_ + 128 - 1, anIntArrayArrayArray105[arg0][arg1 + 1][arg2 + 1], i_41_ + 128 - 1) && method103(i_40_ + 1, anIntArrayArrayArray105[arg0][arg1][arg2 + 1], i_41_ + 128 - 1)) {
            anIntArrayArrayArray83[arg0][arg1][arg2] = anInt86;
            return true;
        }
        anIntArrayArrayArray83[arg0][arg1][arg2] = -anInt86;
        return false;
    }

    public boolean method102(int arg0, int arg1, int arg2, int arg3) {
        if(!method101(arg0, arg1, arg2))
            return false;
        int i = arg1 << 7;
        int i_42_ = arg2 << 7;
        int i_43_ = anIntArrayArrayArray105[arg0][arg1][arg2] - 1;
        int i_44_ = i_43_ - 120;
        int i_45_ = i_43_ - 230;
        int i_46_ = i_43_ - 238;
        if(arg3 < 16) {
            if(arg3 == 1) {
                if(i > anInt76) {
                    if(!method103(i, i_43_, i_42_))
                        return false;
                    if(!method103(i, i_43_, i_42_ + 128))
                        return false;
                }
                if(arg0 > 0) {
                    if(!method103(i, i_44_, i_42_))
                        return false;
                    if(!method103(i, i_44_, i_42_ + 128))
                        return false;
                }
                if(!method103(i, i_45_, i_42_))
                    return false;
                return method103(i, i_45_, i_42_ + 128);
            }
            if(arg3 == 2) {
                if(i_42_ < anInt98) {
                    if(!method103(i, i_43_, i_42_ + 128))
                        return false;
                    if(!method103(i + 128, i_43_, i_42_ + 128))
                        return false;
                }
                if(arg0 > 0) {
                    if(!method103(i, i_44_, i_42_ + 128))
                        return false;
                    if(!method103(i + 128, i_44_, i_42_ + 128))
                        return false;
                }
                if(!method103(i, i_45_, i_42_ + 128))
                    return false;
                return method103(i + 128, i_45_, i_42_ + 128);
            }
            if(arg3 == 4) {
                if(i < anInt76) {
                    if(!method103(i + 128, i_43_, i_42_))
                        return false;
                    if(!method103(i + 128, i_43_, i_42_ + 128))
                        return false;
                }
                if(arg0 > 0) {
                    if(!method103(i + 128, i_44_, i_42_))
                        return false;
                    if(!method103(i + 128, i_44_, i_42_ + 128))
                        return false;
                }
                if(!method103(i + 128, i_45_, i_42_))
                    return false;
                return method103(i + 128, i_45_, i_42_ + 128);
            }
            if(arg3 == 8) {
                if(i_42_ > anInt98) {
                    if(!method103(i, i_43_, i_42_))
                        return false;
                    if(!method103(i + 128, i_43_, i_42_))
                        return false;
                }
                if(arg0 > 0) {
                    if(!method103(i, i_44_, i_42_))
                        return false;
                    if(!method103(i + 128, i_44_, i_42_))
                        return false;
                }
                if(!method103(i, i_45_, i_42_))
                    return false;
                return method103(i + 128, i_45_, i_42_);
            }
        }
        if(!method103(i + 64, i_46_, i_42_ + 64))
            return false;
        if(arg3 == 16) {
            return method103(i, i_45_, i_42_ + 128);
        }
        if(arg3 == 32) {
            return method103(i + 128, i_45_, i_42_ + 128);
        }
        if(arg3 == 64) {
            return method103(i + 128, i_45_, i_42_);
        }
        if(arg3 == 128) {
            return method103(i, i_45_, i_42_);
        }
        return true;
    }

    public boolean method103(int arg0, int arg1, int arg2) {
        for(int i = 0; i < anInt96; i++) {
            Class32 class32 = aClass32Array107[i];
            if(class32.anInt749 == 1) {
                int i_47_ = class32.anInt755 - arg0;
                if(i_47_ > 0) {
                    int i_48_ = class32.anInt751 + (class32.anInt752 * i_47_ >> 8);
                    int i_49_ = class32.anInt758 + (class32.anInt743 * i_47_ >> 8);
                    int i_50_ = class32.anInt763 + (class32.anInt750 * i_47_ >> 8);
                    int i_51_ = class32.anInt759 + (class32.anInt760 * i_47_ >> 8);
                    if(arg2 >= i_48_ && arg2 <= i_49_ && arg1 >= i_50_ && arg1 <= i_51_)
                        return true;
                }
            } else if(class32.anInt749 == 2) {
                int i_52_ = arg0 - class32.anInt755;
                if(i_52_ > 0) {
                    int i_53_ = class32.anInt751 + (class32.anInt752 * i_52_ >> 8);
                    int i_54_ = class32.anInt758 + (class32.anInt743 * i_52_ >> 8);
                    int i_55_ = class32.anInt763 + (class32.anInt750 * i_52_ >> 8);
                    int i_56_ = class32.anInt759 + (class32.anInt760 * i_52_ >> 8);
                    if(arg2 >= i_53_ && arg2 <= i_54_ && arg1 >= i_55_ && arg1 <= i_56_)
                        return true;
                }
            } else if(class32.anInt749 == 3) {
                int i_57_ = class32.anInt751 - arg2;
                if(i_57_ > 0) {
                    int i_58_ = class32.anInt755 + (class32.anInt742 * i_57_ >> 8);
                    int i_59_ = class32.anInt748 + (class32.anInt764 * i_57_ >> 8);
                    int i_60_ = class32.anInt763 + (class32.anInt750 * i_57_ >> 8);
                    int i_61_ = class32.anInt759 + (class32.anInt760 * i_57_ >> 8);
                    if(arg0 >= i_58_ && arg0 <= i_59_ && arg1 >= i_60_ && arg1 <= i_61_)
                        return true;
                }
            } else if(class32.anInt749 == 4) {
                int i_62_ = arg2 - class32.anInt751;
                if(i_62_ > 0) {
                    int i_63_ = class32.anInt755 + (class32.anInt742 * i_62_ >> 8);
                    int i_64_ = class32.anInt748 + (class32.anInt764 * i_62_ >> 8);
                    int i_65_ = class32.anInt763 + (class32.anInt750 * i_62_ >> 8);
                    int i_66_ = class32.anInt759 + (class32.anInt760 * i_62_ >> 8);
                    if(arg0 >= i_63_ && arg0 <= i_64_ && arg1 >= i_65_ && arg1 <= i_66_)
                        return true;
                }
            } else if(class32.anInt749 == 5) {
                int i_67_ = arg1 - class32.anInt763;
                if(i_67_ > 0) {
                    int i_68_ = class32.anInt755 + (class32.anInt742 * i_67_ >> 8);
                    int i_69_ = class32.anInt748 + (class32.anInt764 * i_67_ >> 8);
                    int i_70_ = class32.anInt751 + (class32.anInt752 * i_67_ >> 8);
                    int i_71_ = class32.anInt758 + (class32.anInt743 * i_67_ >> 8);
                    if(arg0 >= i_68_ && arg0 <= i_69_ && arg2 >= i_70_ && arg2 <= i_71_)
                        return true;
                }
            }
        }
        return false;
    }

    public void method104() {
        for(int i = 0; i < anInt92; i++) {
            Class19 class19 = aClass19Array93[i];
            method105(class19);
            aClass19Array93[i] = null;
        }
        anInt92 = 0;
    }

    public void method105(Class19 arg0) {
        for(int i = arg0.anInt473; i <= arg0.anInt484; i++) {
            for(int i_72_ = arg0.anInt481; i_72_ <= arg0.anInt477; i_72_++) {
                SceneTile sceneTile = tileArray[arg0.anInt468][i][i_72_];
                if(sceneTile != null) {
                    for(int i_73_ = 0; i_73_ < sceneTile.anInt2080; i_73_++) {
                        if(sceneTile.aClass19Array2065[i_73_] == arg0) {
                            sceneTile.anInt2080--;
                            for(int i_74_ = i_73_; i_74_ < sceneTile.anInt2080; i_74_++) {
                                sceneTile.aClass19Array2065[i_74_] = (sceneTile.aClass19Array2065[i_74_ + 1]);
                                sceneTile.anIntArray2074[i_74_] = sceneTile.anIntArray2074[i_74_ + 1];
                            }
                            sceneTile.aClass19Array2065[(sceneTile.anInt2080)] = null;
                            break;
                        }
                    }
                    sceneTile.anInt2073 = 0;
                    for(int i_75_ = 0; i_75_ < sceneTile.anInt2080; i_75_++)
                        sceneTile.anInt2073 |= sceneTile.anIntArray2074[i_75_];
                }
            }
        }
    }

    public void method106(SceneTile arg0, boolean arg1) {
        aClass45_108.method904(arg0, -69);
        for(; ; ) {
            SceneTile sceneTile = (SceneTile) aClass45_108.method913(25447);
            if(sceneTile == null)
                break;
            if(sceneTile.aBoolean2077) {
                int i = sceneTile.anInt2061;
                int i_76_ = sceneTile.anInt2078;
                int i_77_ = sceneTile.anInt2066;
                int i_78_ = sceneTile.anInt2069;
                SceneTile[][] sceneTiles = tileArray[i_77_];
                if(sceneTile.aBoolean2071) {
                    if(arg1) {
                        if(i_77_ > 0) {
                            SceneTile sceneTile_79_ = (tileArray[i_77_ - 1][i][i_76_]);
                            if(sceneTile_79_ != null && sceneTile_79_.aBoolean2077)
                                continue;
                        }
                        if(i <= anInt79 && i > anInt95) {
                            SceneTile sceneTile_80_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_80_ != null && sceneTile_80_.aBoolean2077 && (sceneTile_80_.aBoolean2071 || (sceneTile.anInt2073 & 0x1) == 0))
                                continue;
                        }
                        if(i >= anInt79 && i < anInt84 - 1) {
                            SceneTile sceneTile_81_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_81_ != null && sceneTile_81_.aBoolean2077 && (sceneTile_81_.aBoolean2071 || (sceneTile.anInt2073 & 0x4) == 0))
                                continue;
                        }
                        if(i_76_ <= anInt100 && i_76_ > anInt87) {
                            SceneTile sceneTile_82_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_82_ != null && sceneTile_82_.aBoolean2077 && (sceneTile_82_.aBoolean2071 || (sceneTile.anInt2073 & 0x8) == 0))
                                continue;
                        }
                        if(i_76_ >= anInt100 && i_76_ < anInt111 - 1) {
                            SceneTile sceneTile_83_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_83_ != null && sceneTile_83_.aBoolean2077 && (sceneTile_83_.aBoolean2071 || (sceneTile.anInt2073 & 0x2) == 0))
                                continue;
                        }
                    } else
                        arg1 = true;
                    sceneTile.aBoolean2071 = false;
                    if(sceneTile.aSceneTile_2058 != null) {
                        SceneTile sceneTile_84_ = sceneTile.aSceneTile_2058;
                        if(sceneTile_84_.aClass52_2070 != null) {
                            if(!method101(0, i, i_76_))
                                method128(sceneTile_84_.aClass52_2070, 0, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                        } else if(sceneTile_84_.aClass11_2068 != null && !method101(0, i, i_76_))
                            method138(sceneTile_84_.aClass11_2068, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                        Class10 class10 = sceneTile_84_.aClass10_2072;
                        if(class10 != null)
                            class10.aRenderable_341.method755(0, anInt82, anInt110, anInt104, anInt99, class10.anInt334 - anInt76, class10.anInt342 - anInt89, class10.anInt355 - anInt98, class10.anInt336);
                        for(int i_85_ = 0; i_85_ < sceneTile_84_.anInt2080; i_85_++) {
                            Class19 class19 = sceneTile_84_.aClass19Array2065[i_85_];
                            if(class19 != null)
                                class19.aRenderable_474.method755(class19.anInt480, anInt82, anInt110, anInt104, anInt99, class19.anInt476 - anInt76, class19.anInt479 - anInt89, class19.anInt472 - anInt98, class19.anInt469);
                        }
                    }
                    boolean bool = false;
                    if(sceneTile.aClass52_2070 != null) {
                        if(!method101(i_78_, i, i_76_)) {
                            bool = true;
                            method128(sceneTile.aClass52_2070, i_78_, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                        }
                    } else if(sceneTile.aClass11_2068 != null && !method101(i_78_, i, i_76_)) {
                        bool = true;
                        method138(sceneTile.aClass11_2068, anInt82, anInt110, anInt104, anInt99, i, i_76_);
                    }
                    int i_86_ = 0;
                    int i_87_ = 0;
                    Class10 class10 = sceneTile.aClass10_2072;
                    Class53 class53 = sceneTile.aClass53_2079;
                    if(class10 != null || class53 != null) {
                        if(anInt79 == i)
                            i_86_++;
                        else if(anInt79 < i)
                            i_86_ += 2;
                        if(anInt100 == i_76_)
                            i_86_ += 3;
                        else if(anInt100 > i_76_)
                            i_86_ += 6;
                        i_87_ = anIntArray120[i_86_];
                        sceneTile.anInt2064 = anIntArray130[i_86_];
                    }
                    if(class10 != null) {
                        if((class10.anInt337 & anIntArray117[i_86_]) != 0) {
                            if(class10.anInt337 == 16) {
                                sceneTile.anInt2067 = 3;
                                sceneTile.anInt2076 = anIntArray119[i_86_];
                                sceneTile.anInt2059 = 3 - sceneTile.anInt2076;
                            } else if(class10.anInt337 == 32) {
                                sceneTile.anInt2067 = 6;
                                sceneTile.anInt2076 = anIntArray125[i_86_];
                                sceneTile.anInt2059 = 6 - sceneTile.anInt2076;
                            } else if(class10.anInt337 == 64) {
                                sceneTile.anInt2067 = 12;
                                sceneTile.anInt2076 = anIntArray132[i_86_];
                                sceneTile.anInt2059 = 12 - sceneTile.anInt2076;
                            } else {
                                sceneTile.anInt2067 = 9;
                                sceneTile.anInt2076 = anIntArray131[i_86_];
                                sceneTile.anInt2059 = 9 - sceneTile.anInt2076;
                            }
                        } else
                            sceneTile.anInt2067 = 0;
                        if((class10.anInt337 & i_87_) != 0 && !method102(i_78_, i, i_76_, class10.anInt337))
                            class10.aRenderable_341.method755(0, anInt82, anInt110, anInt104, anInt99, class10.anInt334 - anInt76, class10.anInt342 - anInt89, class10.anInt355 - anInt98, class10.anInt336);
                        if((class10.anInt347 & i_87_) != 0 && !method102(i_78_, i, i_76_, class10.anInt347))
                            class10.aRenderable_340.method755(0, anInt82, anInt110, anInt104, anInt99, class10.anInt334 - anInt76, class10.anInt342 - anInt89, class10.anInt355 - anInt98, class10.anInt336);
                    }
                    if(class53 != null && !method111(i_78_, i, i_76_, (class53.aRenderable_1249.anInt2861))) {
                        if((class53.anInt1242 & i_87_) != 0)
                            class53.aRenderable_1249.method755(class53.anInt1252, anInt82, anInt110, anInt104, anInt99, class53.anInt1261 - anInt76, class53.anInt1244 - anInt89, class53.anInt1254 - anInt98, class53.anInt1262);
                        else if((class53.anInt1242 & 0x300) != 0) {
                            int i_88_ = class53.anInt1261 - anInt76;
                            int i_89_ = class53.anInt1244 - anInt89;
                            int i_90_ = class53.anInt1254 - anInt98;
                            int i_91_ = class53.anInt1252;
                            int i_92_;
                            if(i_91_ == 1 || i_91_ == 2)
                                i_92_ = -i_88_;
                            else
                                i_92_ = i_88_;
                            int i_93_;
                            if(i_91_ == 2 || i_91_ == 3)
                                i_93_ = -i_90_;
                            else
                                i_93_ = i_90_;
                            if((class53.anInt1242 & 0x100) != 0 && i_93_ < i_92_) {
                                int i_94_ = i_88_ + anIntArray80[i_91_];
                                int i_95_ = i_90_ + anIntArray112[i_91_];
                                class53.aRenderable_1249.method755(i_91_ * 512 + 256, anInt82, anInt110, anInt104, anInt99, i_94_, i_89_, i_95_, class53.anInt1262);
                            }
                            if((class53.anInt1242 & 0x200) != 0 && i_93_ > i_92_) {
                                int i_96_ = i_88_ + anIntArray94[i_91_];
                                int i_97_ = i_90_ + anIntArray102[i_91_];
                                class53.aRenderable_1249.method755(i_91_ * 512 + 1280 & 0x7ff, anInt82, anInt110, anInt104, anInt99, i_96_, i_89_, i_97_, class53.anInt1262);
                            }
                        }
                    }
                    if(bool) {
                        FloorDecoration floorDecoration = sceneTile.floorDecoration;
                        if(floorDecoration != null)
                            floorDecoration.renderable.method755(0, anInt82, anInt110, anInt104, anInt99, floorDecoration.x - anInt76, floorDecoration.z - anInt89, floorDecoration.y - anInt98, floorDecoration.hash);
                        Class58 class58 = sceneTile.aClass58_2060;
                        if(class58 != null && class58.anInt1371 == 0) {
                            if(class58.aRenderable_1362 != null)
                                class58.aRenderable_1362.method755(0, anInt82, anInt110, anInt104, anInt99, class58.anInt1372 - anInt76, class58.anInt1361 - anInt89, class58.anInt1355 - anInt98, class58.anInt1366);
                            if(class58.aRenderable_1363 != null)
                                class58.aRenderable_1363.method755(0, anInt82, anInt110, anInt104, anInt99, class58.anInt1372 - anInt76, class58.anInt1361 - anInt89, class58.anInt1355 - anInt98, class58.anInt1366);
                            if(class58.aRenderable_1353 != null)
                                class58.aRenderable_1353.method755(0, anInt82, anInt110, anInt104, anInt99, class58.anInt1372 - anInt76, class58.anInt1361 - anInt89, class58.anInt1355 - anInt98, class58.anInt1366);
                        }
                    }
                    int i_98_ = sceneTile.anInt2073;
                    if(i_98_ != 0) {
                        if(i < anInt79 && (i_98_ & 0x4) != 0) {
                            SceneTile sceneTile_99_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_99_ != null && sceneTile_99_.aBoolean2077)
                                aClass45_108.method904(sceneTile_99_, -115);
                        }
                        if(i_76_ < anInt100 && (i_98_ & 0x2) != 0) {
                            SceneTile sceneTile_100_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_100_ != null && sceneTile_100_.aBoolean2077)
                                aClass45_108.method904(sceneTile_100_, 127);
                        }
                        if(i > anInt79 && (i_98_ & 0x1) != 0) {
                            SceneTile sceneTile_101_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_101_ != null && sceneTile_101_.aBoolean2077)
                                aClass45_108.method904(sceneTile_101_, -106);
                        }
                        if(i_76_ > anInt100 && (i_98_ & 0x8) != 0) {
                            SceneTile sceneTile_102_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_102_ != null && sceneTile_102_.aBoolean2077)
                                aClass45_108.method904(sceneTile_102_, -81);
                        }
                    }
                }
                if(sceneTile.anInt2067 != 0) {
                    boolean bool = true;
                    for(int i_103_ = 0; i_103_ < sceneTile.anInt2080; i_103_++) {
                        if((sceneTile.aClass19Array2065[i_103_].anInt486 != anInt86) && ((sceneTile.anIntArray2074[i_103_] & sceneTile.anInt2067) == sceneTile.anInt2076)) {
                            bool = false;
                            break;
                        }
                    }
                    if(bool) {
                        Class10 class10 = sceneTile.aClass10_2072;
                        if(!method102(i_78_, i, i_76_, class10.anInt337))
                            class10.aRenderable_341.method755(0, anInt82, anInt110, anInt104, anInt99, class10.anInt334 - anInt76, class10.anInt342 - anInt89, class10.anInt355 - anInt98, class10.anInt336);
                        sceneTile.anInt2067 = 0;
                    }
                }
                if(sceneTile.aBoolean2062) {
                    try {
                        int i_104_ = sceneTile.anInt2080;
                        sceneTile.aBoolean2062 = false;
                        int i_105_ = 0;
                        while_2_:
                        for(int i_106_ = 0; i_106_ < i_104_; i_106_++) {
                            Class19 class19 = sceneTile.aClass19Array2065[i_106_];
                            if(class19.anInt486 != anInt86) {
                                for(int i_107_ = class19.anInt473; i_107_ <= class19.anInt484; i_107_++) {
                                    for(int i_108_ = class19.anInt481; i_108_ <= class19.anInt477; i_108_++) {
                                        SceneTile sceneTile_109_ = sceneTiles[i_107_][i_108_];
                                        if(sceneTile_109_.aBoolean2071) {
                                            sceneTile.aBoolean2062 = true;
                                            continue while_2_;
                                        }
                                        if(sceneTile_109_.anInt2067 != 0) {
                                            int i_110_ = 0;
                                            if(i_107_ > class19.anInt473)
                                                i_110_++;
                                            if(i_107_ < class19.anInt484)
                                                i_110_ += 4;
                                            if(i_108_ > class19.anInt481)
                                                i_110_ += 8;
                                            if(i_108_ < class19.anInt477)
                                                i_110_ += 2;
                                            if((i_110_ & sceneTile_109_.anInt2067) == sceneTile.anInt2059) {
                                                sceneTile.aBoolean2062 = true;
                                                continue while_2_;
                                            }
                                        }
                                    }
                                }
                                aClass19Array106[i_105_++] = class19;
                                int i_111_ = anInt79 - class19.anInt473;
                                int i_112_ = class19.anInt484 - anInt79;
                                if(i_112_ > i_111_)
                                    i_111_ = i_112_;
                                int i_113_ = anInt100 - class19.anInt481;
                                int i_114_ = class19.anInt477 - anInt100;
                                if(i_114_ > i_113_)
                                    class19.anInt491 = i_111_ + i_114_;
                                else
                                    class19.anInt491 = i_111_ + i_113_;
                            }
                        }
                        while(i_105_ > 0) {
                            int i_115_ = -50;
                            int i_116_ = -1;
                            for(int i_117_ = 0; i_117_ < i_105_; i_117_++) {
                                Class19 class19 = aClass19Array106[i_117_];
                                if(class19.anInt486 != anInt86) {
                                    if(class19.anInt491 > i_115_) {
                                        i_115_ = class19.anInt491;
                                        i_116_ = i_117_;
                                    } else if(class19.anInt491 == i_115_) {
                                        int i_118_ = class19.anInt476 - anInt76;
                                        int i_119_ = class19.anInt472 - anInt98;
                                        int i_120_ = ((aClass19Array106[i_116_].anInt476) - anInt76);
                                        int i_121_ = ((aClass19Array106[i_116_].anInt472) - anInt98);
                                        if(i_118_ * i_118_ + i_119_ * i_119_ > (i_120_ * i_120_ + i_121_ * i_121_))
                                            i_116_ = i_117_;
                                    }
                                }
                            }
                            if(i_116_ == -1)
                                break;
                            Class19 class19 = aClass19Array106[i_116_];
                            class19.anInt486 = anInt86;
                            if(!method119(i_78_, class19.anInt473, class19.anInt484, class19.anInt481, class19.anInt477, (class19.aRenderable_474.anInt2861)))
                                class19.aRenderable_474.method755(class19.anInt480, anInt82, anInt110, anInt104, anInt99, class19.anInt476 - anInt76, class19.anInt479 - anInt89, class19.anInt472 - anInt98, class19.anInt469);
                            for(int i_122_ = class19.anInt473; i_122_ <= class19.anInt484; i_122_++) {
                                for(int i_123_ = class19.anInt481; i_123_ <= class19.anInt477; i_123_++) {
                                    SceneTile sceneTile_124_ = sceneTiles[i_122_][i_123_];
                                    if(sceneTile_124_.anInt2067 != 0)
                                        aClass45_108.method904(sceneTile_124_, 108);
                                    else if((i_122_ != i || i_123_ != i_76_) && sceneTile_124_.aBoolean2077)
                                        aClass45_108.method904(sceneTile_124_, 92);
                                }
                            }
                        }
                        if(sceneTile.aBoolean2062)
                            continue;
                    } catch(Exception exception) {
                        sceneTile.aBoolean2062 = false;
                    }
                }
                if(sceneTile.aBoolean2077) {
                    if(sceneTile.anInt2067 == 0) {
                        if(i <= anInt79 && i > anInt95) {
                            SceneTile sceneTile_125_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_125_ != null && sceneTile_125_.aBoolean2077)
                                continue;
                        }
                        if(i >= anInt79 && i < anInt84 - 1) {
                            SceneTile sceneTile_126_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_126_ != null && sceneTile_126_.aBoolean2077)
                                continue;
                        }
                        if(i_76_ <= anInt100 && i_76_ > anInt87) {
                            SceneTile sceneTile_127_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_127_ != null && sceneTile_127_.aBoolean2077)
                                continue;
                        }
                        if(i_76_ >= anInt100 && i_76_ < anInt111 - 1) {
                            SceneTile sceneTile_128_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_128_ != null && sceneTile_128_.aBoolean2077)
                                continue;
                        }
                        sceneTile.aBoolean2077 = false;
                        anInt109--;
                        Class58 class58 = sceneTile.aClass58_2060;
                        if(class58 != null && class58.anInt1371 != 0) {
                            if(class58.aRenderable_1362 != null)
                                class58.aRenderable_1362.method755(0, anInt82, anInt110, anInt104, anInt99, class58.anInt1372 - anInt76, (class58.anInt1361 - anInt89 - class58.anInt1371), class58.anInt1355 - anInt98, class58.anInt1366);
                            if(class58.aRenderable_1363 != null)
                                class58.aRenderable_1363.method755(0, anInt82, anInt110, anInt104, anInt99, class58.anInt1372 - anInt76, (class58.anInt1361 - anInt89 - class58.anInt1371), class58.anInt1355 - anInt98, class58.anInt1366);
                            if(class58.aRenderable_1353 != null)
                                class58.aRenderable_1353.method755(0, anInt82, anInt110, anInt104, anInt99, class58.anInt1372 - anInt76, (class58.anInt1361 - anInt89 - class58.anInt1371), class58.anInt1355 - anInt98, class58.anInt1366);
                        }
                        if(sceneTile.anInt2064 != 0) {
                            Class53 class53 = sceneTile.aClass53_2079;
                            if(class53 != null && !method111(i_78_, i, i_76_, (class53.aRenderable_1249.anInt2861))) {
                                if((class53.anInt1242 & sceneTile.anInt2064) != 0)
                                    class53.aRenderable_1249.method755(class53.anInt1252, anInt82, anInt110, anInt104, anInt99, class53.anInt1261 - anInt76, class53.anInt1244 - anInt89, class53.anInt1254 - anInt98, class53.anInt1262);
                                else if((class53.anInt1242 & 0x300) != 0) {
                                    int i_129_ = class53.anInt1261 - anInt76;
                                    int i_130_ = class53.anInt1244 - anInt89;
                                    int i_131_ = class53.anInt1254 - anInt98;
                                    int i_132_ = class53.anInt1252;
                                    int i_133_;
                                    if(i_132_ == 1 || i_132_ == 2)
                                        i_133_ = -i_129_;
                                    else
                                        i_133_ = i_129_;
                                    int i_134_;
                                    if(i_132_ == 2 || i_132_ == 3)
                                        i_134_ = -i_131_;
                                    else
                                        i_134_ = i_131_;
                                    if((class53.anInt1242 & 0x100) != 0 && i_134_ >= i_133_) {
                                        int i_135_ = i_129_ + anIntArray80[i_132_];
                                        int i_136_ = i_131_ + anIntArray112[i_132_];
                                        class53.aRenderable_1249.method755(i_132_ * 512 + 256, anInt82, anInt110, anInt104, anInt99, i_135_, i_130_, i_136_, class53.anInt1262);
                                    }
                                    if((class53.anInt1242 & 0x200) != 0 && i_134_ <= i_133_) {
                                        int i_137_ = i_129_ + anIntArray94[i_132_];
                                        int i_138_ = i_131_ + anIntArray102[i_132_];
                                        class53.aRenderable_1249.method755(i_132_ * 512 + 1280 & 0x7ff, anInt82, anInt110, anInt104, anInt99, i_137_, i_130_, i_138_, class53.anInt1262);
                                    }
                                }
                            }
                            Class10 class10 = sceneTile.aClass10_2072;
                            if(class10 != null) {
                                if((class10.anInt347 & sceneTile.anInt2064) != 0 && !method102(i_78_, i, i_76_, class10.anInt347))
                                    class10.aRenderable_340.method755(0, anInt82, anInt110, anInt104, anInt99, class10.anInt334 - anInt76, class10.anInt342 - anInt89, class10.anInt355 - anInt98, class10.anInt336);
                                if((class10.anInt337 & sceneTile.anInt2064) != 0 && !method102(i_78_, i, i_76_, class10.anInt337))
                                    class10.aRenderable_341.method755(0, anInt82, anInt110, anInt104, anInt99, class10.anInt334 - anInt76, class10.anInt342 - anInt89, class10.anInt355 - anInt98, class10.anInt336);
                            }
                        }
                        if(i_77_ < anInt115 - 1) {
                            SceneTile sceneTile_139_ = (tileArray[i_77_ + 1][i][i_76_]);
                            if(sceneTile_139_ != null && sceneTile_139_.aBoolean2077)
                                aClass45_108.method904(sceneTile_139_, -88);
                        }
                        if(i < anInt79) {
                            SceneTile sceneTile_140_ = sceneTiles[i + 1][i_76_];
                            if(sceneTile_140_ != null && sceneTile_140_.aBoolean2077)
                                aClass45_108.method904(sceneTile_140_, 63);
                        }
                        if(i_76_ < anInt100) {
                            SceneTile sceneTile_141_ = sceneTiles[i][i_76_ + 1];
                            if(sceneTile_141_ != null && sceneTile_141_.aBoolean2077)
                                aClass45_108.method904(sceneTile_141_, -81);
                        }
                        if(i > anInt79) {
                            SceneTile sceneTile_142_ = sceneTiles[i - 1][i_76_];
                            if(sceneTile_142_ != null && sceneTile_142_.aBoolean2077)
                                aClass45_108.method904(sceneTile_142_, 89);
                        }
                        if(i_76_ > anInt100) {
                            SceneTile sceneTile_143_ = sceneTiles[i][i_76_ - 1];
                            if(sceneTile_143_ != null && sceneTile_143_.aBoolean2077)
                                aClass45_108.method904(sceneTile_143_, -125);
                        }
                    }
                }
            }
        }
    }

    public Class19 method107(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null)
            return null;
        for(int i = 0; i < sceneTile.anInt2080; i++) {
            Class19 class19 = sceneTile.aClass19Array2065[i];
            if((class19.anInt469 >> 29 & 0x3) == 2 && class19.anInt473 == arg1 && class19.anInt481 == arg2)
                return class19;
        }
        return null;
    }

    public void method109(int arg0, int arg1, int arg2, int arg3, Renderable arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        if(arg4 != null) {
            Class53 class53 = new Class53();
            class53.anInt1262 = arg9;
            class53.anInt1253 = arg10;
            class53.anInt1261 = arg1 * 128 + 64 + arg7;
            class53.anInt1254 = arg2 * 128 + 64 + arg8;
            class53.anInt1244 = arg3;
            class53.aRenderable_1249 = arg4;
            class53.anInt1242 = arg5;
            class53.anInt1252 = arg6;
            for(int i = arg0; i >= 0; i--) {
                if(tileArray[i][arg1][arg2] == null)
                    tileArray[i][arg1][arg2] = new SceneTile(i, arg1, arg2);
            }
            tileArray[arg0][arg1][arg2].aClass53_2079 = class53;
        }
    }

    public int method110(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null)
            return 0;
        for(int i = 0; i < sceneTile.anInt2080; i++) {
            Class19 class19 = sceneTile.aClass19Array2065[i];
            if((class19.anInt469 >> 29 & 0x3) == 2 && class19.anInt473 == arg1 && class19.anInt481 == arg2)
                return class19.anInt469;
        }
        return 0;
    }

    public boolean method111(int arg0, int arg1, int arg2, int arg3) {
        if(!method101(arg0, arg1, arg2))
            return false;
        int i = arg1 << 7;
        int i_144_ = arg2 << 7;
        return method103(i + 1, anIntArrayArrayArray105[arg0][arg1][arg2] - arg3, i_144_ + 1) && method103(i + 128 - 1, anIntArrayArrayArray105[arg0][arg1 + 1][arg2] - arg3, i_144_ + 1) && method103(i + 128 - 1, (anIntArrayArrayArray105[arg0][arg1 + 1][arg2 + 1] - arg3), i_144_ + 128 - 1) && method103(i + 1, anIntArrayArrayArray105[arg0][arg1][arg2 + 1] - arg3, i_144_ + 128 - 1);
    }

    public boolean method112(int arg0, int arg1, int arg2, int arg3, int arg4, Renderable arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        if(arg5 == null)
            return true;
        return method140(arg0, arg8, arg9, arg10 - arg8 + 1, arg11 - arg9 + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
    }

    public void method115(int arg0, int arg1, int arg2, int arg3) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            Class53 class53 = sceneTile.aClass53_2079;
            if(class53 != null) {
                int i = arg1 * 128 + 64;
                int i_150_ = arg2 * 128 + 64;
                class53.anInt1261 = i + (class53.anInt1261 - i) * arg3 / 16;
                class53.anInt1254 = i_150_ + (class53.anInt1254 - i_150_) * arg3 / 16;
            }
        }
    }

    public void method117(Model arg0, int arg1, int arg2, int arg3) {
        if(arg2 < anInt97) {
            SceneTile sceneTile = tileArray[arg1][arg2 + 1][arg3];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null)
                    method121(arg0, class40_sub5_sub17_sub5, 128, 0, 0, true);
            }
        }
        if(arg3 < anInt97) {
            SceneTile sceneTile = tileArray[arg1][arg2][arg3 + 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null)
                    method121(arg0, class40_sub5_sub17_sub5, 0, 0, 128, true);
            }
        }
        if(arg2 < anInt97 && arg3 < anInt116) {
            SceneTile sceneTile = tileArray[arg1][arg2 + 1][arg3 + 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null)
                    method121(arg0, class40_sub5_sub17_sub5, 128, 0, 128, true);
            }
        }
        if(arg2 < anInt97 && arg3 > 0) {
            SceneTile sceneTile = tileArray[arg1][arg2 + 1][arg3 - 1];
            if(sceneTile != null && sceneTile.floorDecoration != null && (sceneTile.floorDecoration.renderable instanceof Model)) {
                Model class40_sub5_sub17_sub5 = ((Model) sceneTile.floorDecoration.renderable);
                if(class40_sub5_sub17_sub5.verticesNormal != null)
                    method121(arg0, class40_sub5_sub17_sub5, 128, 0, -128, true);
            }
        }
    }

    public void method118(int arg0, int arg1, int arg2) {
        for(int i = 0; i < anInt115; i++) {
            for(int i_151_ = 0; i_151_ < anInt97; i_151_++) {
                for(int i_152_ = 0; i_152_ < anInt116; i_152_++) {
                    SceneTile sceneTile = tileArray[i][i_151_][i_152_];
                    if(sceneTile != null) {
                        Class10 class10 = sceneTile.aClass10_2072;
                        if(class10 != null && (class10.aRenderable_341 instanceof Model)) {
                            Model class40_sub5_sub17_sub5 = ((Model) class10.aRenderable_341);
                            if(class40_sub5_sub17_sub5.verticesNormal != null) {
                                method129(class40_sub5_sub17_sub5, i, i_151_, i_152_, 1, 1);
                                if(class10.aRenderable_340 instanceof Model) {
                                    Model class40_sub5_sub17_sub5_153_ = ((Model) class10.aRenderable_340);
                                    if((class40_sub5_sub17_sub5_153_.verticesNormal) != null) {
                                        method129(class40_sub5_sub17_sub5_153_, i, i_151_, i_152_, 1, 1);
                                        method121(class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_153_, 0, 0, 0, false);
                                        class40_sub5_sub17_sub5_153_.method826(arg0, arg1, arg2);
                                    }
                                }
                                class40_sub5_sub17_sub5.method826(arg0, arg1, arg2);
                            }
                        }
                        for(int i_154_ = 0; i_154_ < sceneTile.anInt2080; i_154_++) {
                            Class19 class19 = sceneTile.aClass19Array2065[i_154_];
                            if(class19 != null && (class19.aRenderable_474 instanceof Model)) {
                                Model class40_sub5_sub17_sub5 = ((Model) class19.aRenderable_474);
                                if(class40_sub5_sub17_sub5.verticesNormal != null) {
                                    method129(class40_sub5_sub17_sub5, i, i_151_, i_152_, (class19.anInt484 - class19.anInt473 + 1), (class19.anInt477 - class19.anInt481 + 1));
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

    public boolean method119(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg1 == arg2 && arg3 == arg4) {
            if(!method101(arg0, arg1, arg3))
                return false;
            int i = arg1 << 7;
            int i_155_ = arg3 << 7;
            return method103(i + 1, anIntArrayArrayArray105[arg0][arg1][arg3] - arg5, i_155_ + 1) && method103(i + 128 - 1, (anIntArrayArrayArray105[arg0][arg1 + 1][arg3] - arg5), i_155_ + 1) && method103(i + 128 - 1, (anIntArrayArrayArray105[arg0][arg1 + 1][arg3 + 1] - arg5), i_155_ + 128 - 1) && method103(i + 1, (anIntArrayArrayArray105[arg0][arg1][arg3 + 1] - arg5), i_155_ + 128 - 1);
        }
        for(int i = arg1; i <= arg2; i++) {
            for(int i_156_ = arg3; i_156_ <= arg4; i_156_++) {
                if(anIntArrayArrayArray83[arg0][i][i_156_] == -anInt86)
                    return false;
            }
        }
        int i = (arg1 << 7) + 1;
        int i_157_ = (arg3 << 7) + 2;
        int i_158_ = anIntArrayArrayArray105[arg0][arg1][arg3] - arg5;
        if(!method103(i, i_158_, i_157_))
            return false;
        int i_159_ = (arg2 << 7) - 1;
        if(!method103(i_159_, i_158_, i_157_))
            return false;
        int i_160_ = (arg4 << 7) - 1;
        if(!method103(i, i_158_, i_160_))
            return false;
        return method103(i_159_, i_158_, i_160_);
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
                if(anIntArray127[arg0.trianglePointsX[i_170_]] == anInt126 && anIntArray127[arg0.trianglePointsY[i_170_]] == anInt126 && anIntArray127[arg0.trianglePointsZ[i_170_]] == anInt126)
                    arg0.triangleDrawType[i_170_] = -1;
            }
            for(int i_171_ = 0; i_171_ < arg1.triangleCount; i_171_++) {
                if(anIntArray123[arg1.trianglePointsX[i_171_]] == anInt126 && anIntArray123[arg1.trianglePointsY[i_171_]] == anInt126 && anIntArray123[arg1.trianglePointsZ[i_171_]] == anInt126)
                    arg1.triangleDrawType[i_171_] = -1;
            }
        }
    }

    public int method122(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null || sceneTile.aClass10_2072 == null)
            return 0;
        return sceneTile.aClass10_2072.anInt336;
    }

    public void method123() {
        int i = anIntArray101[anInt85];
        Class32[] class32s = aClass32ArrayArray113[anInt85];
        anInt96 = 0;
        for(int i_172_ = 0; i_172_ < i; i_172_++) {
            Class32 class32 = class32s[i_172_];
            if(class32.anInt756 == 1) {
                int i_173_ = class32.anInt757 - anInt79 + 25;
                if(i_173_ >= 0 && i_173_ <= 50) {
                    int i_174_ = class32.anInt745 - anInt100 + 25;
                    if(i_174_ < 0)
                        i_174_ = 0;
                    int i_175_ = class32.anInt746 - anInt100 + 25;
                    if(i_175_ > 50)
                        i_175_ = 50;
                    boolean bool = false;
                    while(i_174_ <= i_175_) {
                        if(aBooleanArrayArray133[i_173_][i_174_++]) {
                            bool = true;
                            break;
                        }
                    }
                    if(bool) {
                        int i_176_ = anInt76 - class32.anInt755;
                        if(i_176_ > 32)
                            class32.anInt749 = 1;
                        else {
                            if(i_176_ >= -32)
                                continue;
                            class32.anInt749 = 2;
                            i_176_ = -i_176_;
                        }
                        class32.anInt752 = (class32.anInt751 - anInt98 << 8) / i_176_;
                        class32.anInt743 = (class32.anInt758 - anInt98 << 8) / i_176_;
                        class32.anInt750 = (class32.anInt763 - anInt89 << 8) / i_176_;
                        class32.anInt760 = (class32.anInt759 - anInt89 << 8) / i_176_;
                        aClass32Array107[anInt96++] = class32;
                    }
                }
            } else if(class32.anInt756 == 2) {
                int i_177_ = class32.anInt745 - anInt100 + 25;
                if(i_177_ >= 0 && i_177_ <= 50) {
                    int i_178_ = class32.anInt757 - anInt79 + 25;
                    if(i_178_ < 0)
                        i_178_ = 0;
                    int i_179_ = class32.anInt762 - anInt79 + 25;
                    if(i_179_ > 50)
                        i_179_ = 50;
                    boolean bool = false;
                    while(i_178_ <= i_179_) {
                        if(aBooleanArrayArray133[i_178_++][i_177_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(bool) {
                        int i_180_ = anInt98 - class32.anInt751;
                        if(i_180_ > 32)
                            class32.anInt749 = 3;
                        else {
                            if(i_180_ >= -32)
                                continue;
                            class32.anInt749 = 4;
                            i_180_ = -i_180_;
                        }
                        class32.anInt742 = (class32.anInt755 - anInt76 << 8) / i_180_;
                        class32.anInt764 = (class32.anInt748 - anInt76 << 8) / i_180_;
                        class32.anInt750 = (class32.anInt763 - anInt89 << 8) / i_180_;
                        class32.anInt760 = (class32.anInt759 - anInt89 << 8) / i_180_;
                        aClass32Array107[anInt96++] = class32;
                    }
                }
            } else if(class32.anInt756 == 4) {
                int i_181_ = class32.anInt763 - anInt89;
                if(i_181_ > 128) {
                    int i_182_ = class32.anInt745 - anInt100 + 25;
                    if(i_182_ < 0)
                        i_182_ = 0;
                    int i_183_ = class32.anInt746 - anInt100 + 25;
                    if(i_183_ > 50)
                        i_183_ = 50;
                    if(i_182_ <= i_183_) {
                        int i_184_ = class32.anInt757 - anInt79 + 25;
                        if(i_184_ < 0)
                            i_184_ = 0;
                        int i_185_ = class32.anInt762 - anInt79 + 25;
                        if(i_185_ > 50)
                            i_185_ = 50;
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
                            class32.anInt749 = 5;
                            class32.anInt742 = (class32.anInt755 - anInt76 << 8) / i_181_;
                            class32.anInt764 = (class32.anInt748 - anInt76 << 8) / i_181_;
                            class32.anInt752 = (class32.anInt751 - anInt98 << 8) / i_181_;
                            class32.anInt743 = (class32.anInt758 - anInt98 << 8) / i_181_;
                            aClass32Array107[anInt96++] = class32;
                        }
                    }
                }
            }
        }
    }

    public void method124(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null)
            sceneTile.aClass10_2072 = null;
    }

    public void method125(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null)
            sceneTile.aClass58_2060 = null;
    }

    public Class10 method126(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null)
            return null;
        return sceneTile.aClass10_2072;
    }

    public void method127(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null)
            sceneTile.aClass53_2079 = null;
    }

    public void method128(Class52 arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        int i_188_;
        int i = i_188_ = (arg6 << 7) - anInt76;
        int i_190_;
        int i_189_ = i_190_ = (arg7 << 7) - anInt98;
        int i_192_;
        int i_191_ = i_192_ = i + 128;
        int i_194_;
        int i_193_ = i_194_ = i_189_ + 128;
        int i_195_ = anIntArrayArrayArray105[arg1][arg6][arg7] - anInt89;
        int i_196_ = anIntArrayArrayArray105[arg1][arg6 + 1][arg7] - anInt89;
        int i_197_ = anIntArrayArrayArray105[arg1][arg6 + 1][arg7 + 1] - anInt89;
        int i_198_ = anIntArrayArrayArray105[arg1][arg6][arg7 + 1] - anInt89;
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
                        int i_200_ = (R3D.anInt2937 + (i << 9) / i_189_);
                        int i_201_ = (R3D.anInt2931 + (i_195_ << 9) / i_189_);
                        int i_202_ = (R3D.anInt2937 + (i_191_ << 9) / i_190_);
                        int i_203_ = (R3D.anInt2931 + (i_196_ << 9) / i_190_);
                        int i_204_ = (R3D.anInt2937 + (i_192_ << 9) / i_193_);
                        int i_205_ = (R3D.anInt2931 + (i_197_ << 9) / i_193_);
                        int i_206_ = (R3D.anInt2937 + (i_188_ << 9) / i_194_);
                        int i_207_ = (R3D.anInt2931 + (i_198_ << 9) / i_194_);
                        R3D.anInt2933 = 0;
                        if(((i_204_ - i_206_) * (i_203_ - i_207_) - (i_205_ - i_207_) * (i_202_ - i_206_)) > 0) {
                            R3D.aBoolean2947 = i_204_ < 0 || i_206_ < 0 || i_202_ < 0 || i_204_ > R3D.anInt2945 || i_206_ > R3D.anInt2945 || i_202_ > R3D.anInt2945;
                            if(aBoolean114 && method142(anInt91, anInt77, i_205_, i_207_, i_203_, i_204_, i_206_, i_202_)) {
                                anInt78 = arg6;
                                anInt81 = arg7;
                            }
                            if(arg0.anInt1220 == -1) {
                                if(arg0.anInt1235 != 12345678)
                                    R3D.method706(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, arg0.anInt1235, arg0.anInt1232, arg0.anInt1225);
                            } else if(!aBoolean88) {
                                if(arg0.aBoolean1229)
                                    R3D.method699(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, arg0.anInt1235, arg0.anInt1232, arg0.anInt1225, i, i_191_, i_188_, i_195_, i_196_, i_198_, i_189_, i_190_, i_194_, arg0.anInt1220);
                                else
                                    R3D.method699(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, arg0.anInt1235, arg0.anInt1232, arg0.anInt1225, i_192_, i_188_, i_191_, i_197_, i_198_, i_196_, i_193_, i_194_, i_190_, arg0.anInt1220);
                            } else {
                                int i_208_ = R3D.anInterface3_2939.method14(true, arg0.anInt1220);
                                R3D.method706(i_205_, i_207_, i_203_, i_204_, i_206_, i_202_, method108(i_208_, arg0.anInt1235), method108(i_208_, arg0.anInt1232), method108(i_208_, arg0.anInt1225));
                            }
                        }
                        if(((i_200_ - i_202_) * (i_207_ - i_203_) - (i_201_ - i_203_) * (i_206_ - i_202_)) > 0) {
                            R3D.aBoolean2947 = i_200_ < 0 || i_202_ < 0 || i_206_ < 0 || i_200_ > R3D.anInt2945 || i_202_ > R3D.anInt2945 || i_206_ > R3D.anInt2945;
                            if(aBoolean114 && method142(anInt91, anInt77, i_201_, i_203_, i_207_, i_200_, i_202_, i_206_)) {
                                anInt78 = arg6;
                                anInt81 = arg7;
                            }
                            if(arg0.anInt1220 == -1) {
                                if(arg0.anInt1231 != 12345678)
                                    R3D.method706(i_201_, i_203_, i_207_, i_200_, i_202_, i_206_, arg0.anInt1231, arg0.anInt1225, arg0.anInt1232);
                            } else if(!aBoolean88)
                                R3D.method699(i_201_, i_203_, i_207_, i_200_, i_202_, i_206_, arg0.anInt1231, arg0.anInt1225, arg0.anInt1232, i, i_191_, i_188_, i_195_, i_196_, i_198_, i_189_, i_190_, i_194_, arg0.anInt1220);
                            else {
                                int i_209_ = R3D.anInterface3_2939.method14(true, arg0.anInt1220);
                                R3D.method706(i_201_, i_203_, i_207_, i_200_, i_202_, i_206_, method108(i_209_, arg0.anInt1231), method108(i_209_, arg0.anInt1225), method108(i_209_, arg0.anInt1232));
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
                    if(i_214_ >= 0 && i_214_ < anInt97) {
                        for(int i_215_ = i_211_; i_215_ <= i_212_; i_215_++) {
                            if(i_215_ >= 0 && i_215_ < anInt116 && (!bool || i_214_ >= i_210_ || i_215_ >= i_212_ || i_215_ < arg3 && i_214_ != arg2)) {
                                SceneTile sceneTile = (tileArray[i_213_][i_214_][i_215_]);
                                if(sceneTile != null) {
                                    int i_216_ = (((anIntArrayArrayArray105[i_213_][i_214_][i_215_]) + (anIntArrayArrayArray105[i_213_][i_214_ + 1][i_215_]) + (anIntArrayArrayArray105[i_213_][i_214_][i_215_ + 1]) + (anIntArrayArrayArray105[i_213_][i_214_ + 1][i_215_ + 1])) / 4 - ((anIntArrayArrayArray105[arg1][arg2][arg3]) + (anIntArrayArrayArray105[arg1][arg2 + 1][arg3]) + (anIntArrayArrayArray105[arg1][arg2][arg3 + 1]) + (anIntArrayArrayArray105[arg1][arg2 + 1][arg3 + 1])) / 4);
                                    Class10 class10 = sceneTile.aClass10_2072;
                                    if(class10 != null) {
                                        if(class10.aRenderable_341 instanceof Model) {
                                            Model class40_sub5_sub17_sub5 = ((Model) (class10.aRenderable_341));
                                            if((class40_sub5_sub17_sub5.verticesNormal) != null)
                                                method121(arg0, class40_sub5_sub17_sub5, ((i_214_ - arg2) * 128 + (1 - arg4) * 64), i_216_, ((i_215_ - arg3) * 128 + (1 - arg5) * 64), bool);
                                        }
                                        if(class10.aRenderable_340 instanceof Model) {
                                            Model class40_sub5_sub17_sub5 = ((Model) (class10.aRenderable_340));
                                            if((class40_sub5_sub17_sub5.verticesNormal) != null)
                                                method121(arg0, class40_sub5_sub17_sub5, ((i_214_ - arg2) * 128 + (1 - arg4) * 64), i_216_, ((i_215_ - arg3) * 128 + (1 - arg5) * 64), bool);
                                        }
                                    }
                                    for(int i_217_ = 0; i_217_ < sceneTile.anInt2080; i_217_++) {
                                        Class19 class19 = (sceneTile.aClass19Array2065[i_217_]);
                                        if(class19 != null && (class19.aRenderable_474 instanceof Model)) {
                                            Model class40_sub5_sub17_sub5 = ((Model) (class19.aRenderable_474));
                                            if((class40_sub5_sub17_sub5.verticesNormal) != null) {
                                                int i_218_ = (class19.anInt484 - class19.anInt473 + 1);
                                                int i_219_ = (class19.anInt477 - class19.anInt481 + 1);
                                                method121(arg0, class40_sub5_sub17_sub5, ((class19.anInt473 - arg2) * 128 + (i_218_ - arg4) * 64), i_216_, ((class19.anInt481 - arg3) * 128 + (i_219_ - arg5) * 64), bool);
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
        if(sceneTile != null)
            tileArray[arg0][arg1][arg2].anInt2063 = arg3;
    }

    public void method131(int level, int x, int y) {
        SceneTile sceneTile = tileArray[level][x][y];
        if(sceneTile != null)
            sceneTile.floorDecoration = null;
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
            if(tileArray[z][x][y] == null)
                tileArray[z][x][y] = new SceneTile(z, x, y);
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
        if(arg5 == null)
            return true;
        int i = arg1 - arg4;
        int i_220_ = arg2 - arg4;
        int i_221_ = arg1 + arg4;
        int i_222_ = arg2 + arg4;
        if(arg8) {
            if(arg6 > 640 && arg6 < 1408)
                i_222_ += 128;
            if(arg6 > 1152 && arg6 < 1920)
                i_221_ += 128;
            if(arg6 > 1664 || arg6 < 384)
                i_220_ -= 128;
            if(arg6 > 128 && arg6 < 896)
                i -= 128;
        }
        i /= 128;
        i_220_ /= 128;
        i_221_ /= 128;
        i_222_ /= 128;
        return method140(arg0, i, i_220_, i_221_ - i + 1, i_222_ - i_220_ + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
    }

    public void method135(int arg0, int arg1, int arg2) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            for(int i = 0; i < sceneTile.anInt2080; i++) {
                Class19 class19 = sceneTile.aClass19Array2065[i];
                if((class19.anInt469 >> 29 & 0x3) == 2 && class19.anInt473 == arg1 && class19.anInt481 == arg2) {
                    method105(class19);
                    break;
                }
            }
        }
    }

    public void method136(int arg0) {
        anInt103 = arg0;
        for(int i = 0; i < anInt97; i++) {
            for(int i_223_ = 0; i_223_ < anInt116; i_223_++) {
                if(tileArray[arg0][i][i_223_] == null)
                    tileArray[arg0][i][i_223_] = new SceneTile(arg0, i, i_223_);
            }
        }
    }

    public boolean method137(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Renderable arg6, int arg7, int arg8, int arg9) {
        if(arg6 == null)
            return true;
        int i = arg1 * 128 + 64 * arg4;
        int i_224_ = arg2 * 128 + 64 * arg5;
        return method140(arg0, arg1, arg2, arg4, arg5, i, i_224_, arg3, arg6, arg7, false, arg8, arg9);
    }

    public void method138(Class11 arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        int i = arg0.anIntArray359.length;
        for(int i_225_ = 0; i_225_ < i; i_225_++) {
            int i_226_ = arg0.anIntArray359[i_225_] - anInt76;
            int i_227_ = arg0.anIntArray376[i_225_] - anInt89;
            int i_228_ = arg0.anIntArray378[i_225_] - anInt98;
            int i_229_ = i_228_ * arg3 + i_226_ * arg4 >> 16;
            i_228_ = i_228_ * arg4 - i_226_ * arg3 >> 16;
            i_226_ = i_229_;
            i_229_ = i_227_ * arg2 - i_228_ * arg1 >> 16;
            i_228_ = i_227_ * arg1 + i_228_ * arg2 >> 16;
            i_227_ = i_229_;
            if(i_228_ < 50)
                return;
            if(arg0.anIntArray361 != null) {
                Class11.anIntArray370[i_225_] = i_226_;
                Class11.anIntArray375[i_225_] = i_227_;
                Class11.anIntArray360[i_225_] = i_228_;
            }
            Class11.anIntArray363[i_225_] = R3D.anInt2937 + (i_226_ << 9) / i_228_;
            Class11.anIntArray358[i_225_] = R3D.anInt2931 + (i_227_ << 9) / i_228_;
        }
        R3D.anInt2933 = 0;
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
                R3D.aBoolean2947 = i_234_ < 0 || i_235_ < 0 || i_236_ < 0 || i_234_ > R3D.anInt2945 || i_235_ > R3D.anInt2945 || i_236_ > R3D.anInt2945;
                if(aBoolean114 && method142(anInt91, anInt77, i_237_, i_238_, i_239_, i_234_, i_235_, i_236_)) {
                    anInt78 = arg5;
                    anInt81 = arg6;
                }
                if(arg0.anIntArray361 == null || arg0.anIntArray361[i_230_] == -1) {
                    if(arg0.anIntArray367[i_230_] != 12345678)
                        R3D.method706(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, arg0.anIntArray367[i_230_], arg0.anIntArray369[i_230_], arg0.anIntArray372[i_230_]);
                } else if(!aBoolean88) {
                    if(arg0.aBoolean365)
                        R3D.method699(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, arg0.anIntArray367[i_230_], arg0.anIntArray369[i_230_], arg0.anIntArray372[i_230_], Class11.anIntArray370[0], Class11.anIntArray370[1], Class11.anIntArray370[3], Class11.anIntArray375[0], Class11.anIntArray375[1], Class11.anIntArray375[3], Class11.anIntArray360[0], Class11.anIntArray360[1], Class11.anIntArray360[3], arg0.anIntArray361[i_230_]);
                    else
                        R3D.method699(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, arg0.anIntArray367[i_230_], arg0.anIntArray369[i_230_], arg0.anIntArray372[i_230_], Class11.anIntArray370[i_231_], Class11.anIntArray370[i_232_], Class11.anIntArray370[i_233_], Class11.anIntArray375[i_231_], Class11.anIntArray375[i_232_], Class11.anIntArray375[i_233_], Class11.anIntArray360[i_231_], Class11.anIntArray360[i_232_], Class11.anIntArray360[i_233_], arg0.anIntArray361[i_230_]);
                } else {
                    int i_240_ = R3D.anInterface3_2939.method14(true, arg0.anIntArray361[i_230_]);
                    R3D.method706(i_237_, i_238_, i_239_, i_234_, i_235_, i_236_, method108(i_240_, arg0.anIntArray367[i_230_]), method108(i_240_, arg0.anIntArray369[i_230_]), method108(i_240_, arg0.anIntArray372[i_230_]));
                }
            }
        }
    }

    public void method139(int arg0, int arg1, int arg2, int arg3, Renderable arg4, int arg5, Renderable arg6, Renderable arg7) {
        Class58 class58 = new Class58();
        class58.aRenderable_1353 = arg4;
        class58.anInt1372 = arg1 * 128 + 64;
        class58.anInt1355 = arg2 * 128 + 64;
        class58.anInt1361 = arg3;
        class58.anInt1366 = arg5;
        class58.aRenderable_1362 = arg6;
        class58.aRenderable_1363 = arg7;
        int i = 0;
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile != null) {
            for(int i_241_ = 0; i_241_ < sceneTile.anInt2080; i_241_++) {
                if(((sceneTile.aClass19Array2065[i_241_].anInt471 & 0x100) == 256) && ((sceneTile.aClass19Array2065[i_241_].aRenderable_474) instanceof Model)) {
                    Model class40_sub5_sub17_sub5 = ((Model) (sceneTile.aClass19Array2065[i_241_].aRenderable_474));
                    class40_sub5_sub17_sub5.method799();
                    if(class40_sub5_sub17_sub5.anInt2861 > i)
                        i = class40_sub5_sub17_sub5.anInt2861;
                }
            }
        }
        class58.anInt1371 = i;
        if(tileArray[arg0][arg1][arg2] == null)
            tileArray[arg0][arg1][arg2] = new SceneTile(arg0, arg1, arg2);
        tileArray[arg0][arg1][arg2].aClass58_2060 = class58;
    }

    public boolean method140(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Renderable arg8, int arg9, boolean arg10, int arg11, int arg12) {
        for(int i = arg1; i < arg1 + arg3; i++) {
            for(int i_242_ = arg2; i_242_ < arg2 + arg4; i_242_++) {
                if(i < 0 || i_242_ < 0 || i >= anInt97 || i_242_ >= anInt116)
                    return false;
                SceneTile sceneTile = tileArray[arg0][i][i_242_];
                if(sceneTile != null && sceneTile.anInt2080 >= 5)
                    return false;
            }
        }
        Class19 class19 = new Class19();
        class19.anInt469 = arg11;
        class19.anInt471 = arg12;
        class19.anInt468 = arg0;
        class19.anInt476 = arg5;
        class19.anInt472 = arg6;
        class19.anInt479 = arg7;
        class19.aRenderable_474 = arg8;
        class19.anInt480 = arg9;
        class19.anInt473 = arg1;
        class19.anInt481 = arg2;
        class19.anInt484 = arg1 + arg3 - 1;
        class19.anInt477 = arg2 + arg4 - 1;
        for(int i = arg1; i < arg1 + arg3; i++) {
            for(int i_243_ = arg2; i_243_ < arg2 + arg4; i_243_++) {
                int i_244_ = 0;
                if(i > arg1)
                    i_244_++;
                if(i < arg1 + arg3 - 1)
                    i_244_ += 4;
                if(i_243_ > arg2)
                    i_244_ += 8;
                if(i_243_ < arg2 + arg4 - 1)
                    i_244_ += 2;
                for(int i_245_ = arg0; i_245_ >= 0; i_245_--) {
                    if(tileArray[i_245_][i][i_243_] == null)
                        tileArray[i_245_][i][i_243_] = new SceneTile(i_245_, i, i_243_);
                }
                SceneTile sceneTile = tileArray[arg0][i][i_243_];
                sceneTile.aClass19Array2065[sceneTile.anInt2080] = class19;
                sceneTile.anIntArray2074[sceneTile.anInt2080] = i_244_;
                sceneTile.anInt2073 |= i_244_;
                sceneTile.anInt2080++;
            }
        }
        if(arg10)
            aClass19Array93[anInt92++] = class19;
        return true;
    }

    public int method141(int arg0, int arg1, int arg2, int arg3) {
        SceneTile sceneTile = tileArray[arg0][arg1][arg2];
        if(sceneTile == null)
            return -1;
        if(sceneTile.aClass10_2072 != null && sceneTile.aClass10_2072.anInt336 == arg3)
            return sceneTile.aClass10_2072.anInt348 & 0xff;
        if(sceneTile.aClass53_2079 != null && sceneTile.aClass53_2079.anInt1262 == arg3)
            return sceneTile.aClass53_2079.anInt1253 & 0xff;
        if(sceneTile.floorDecoration != null && sceneTile.floorDecoration.hash == arg3)
            return sceneTile.floorDecoration.config & 0xff;
        for(int i = 0; i < sceneTile.anInt2080; i++) {
            if(sceneTile.aClass19Array2065[i].anInt469 == arg3)
                return sceneTile.aClass19Array2065[i].anInt471 & 0xff;
        }
        return -1;
    }

    public boolean method142(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg1 < arg2 && arg1 < arg3 && arg1 < arg4)
            return false;
        if(arg1 > arg2 && arg1 > arg3 && arg1 > arg4)
            return false;
        if(arg0 < arg5 && arg0 < arg6 && arg0 < arg7)
            return false;
        if(arg0 > arg5 && arg0 > arg6 && arg0 > arg7)
            return false;
        int i = (arg1 - arg2) * (arg6 - arg5) - (arg0 - arg5) * (arg3 - arg2);
        int i_246_ = (arg1 - arg4) * (arg5 - arg7) - (arg0 - arg7) * (arg2 - arg4);
        int i_247_ = (arg1 - arg3) * (arg7 - arg6) - (arg0 - arg6) * (arg4 - arg3);
        return i * i_247_ > 0 && i_247_ * i_246_ > 0;
    }
}
