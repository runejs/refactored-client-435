/* Class48 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class48 {
    public static RSString aClass1_1122;
    public static RSString aClass1_1123;
    public static RSString aClass1_1124;
    public static RSString aClass1_1125;
    public static int anInt1126;
    public static int anInt1127;
    public static RSString aClass1_1129 = Class58.method978("RuneScape is loading )2 please wait)3)3)3");
    public static int anInt1130;
    public static Buffer aClass40_Sub1_1132;
    public static int anInt1134;
    public static int anInt1135;
    public static int anInt1136;
    public static RSString aClass1_1137;
    public static int anInt1138;
    public static int anInt1139;
    public static int anInt1140;
    public static int anInt1141;

    static {
        anInt1127 = 0;
        aClass1_1122 = aClass1_1129;
        anInt1126 = 0;
        aClass1_1125 = Class58.method978("Loading title screen )2 ");
        aClass1_1137 = Class58.method978("M");
        aClass1_1124 = aClass1_1125;
        anInt1138 = -1;
        aClass1_1123 = Class58.method978(" ");
    }

    public int[][] anIntArrayArray1128;
    public int anInt1131;
    public int anInt1133;

    public Class48(int arg0, int arg1) {
        try {
            int i = Class55.method963(arg1, (byte) -62, arg0);
            arg0 /= i;
            anInt1131 = arg0;
            arg1 /= i;
            anInt1133 = arg1;
            if(arg1 != arg0) {
                anIntArrayArray1128 = new int[arg0][14];
                for(int i_25_ = 0; (i_25_ ^ 0xffffffff) > (arg0 ^ 0xffffffff); i_25_++) {
                    int[] is = anIntArrayArray1128[i_25_];
                    double d = (double) i_25_ / (double) arg0 + 6.0;
                    double d_26_ = (double) arg1 / (double) arg0;
                    int i_27_ = (int) Math.floor(-7.0 + d + 1.0);
                    int i_28_ = (int) Math.ceil(7.0 + d);
                    if((i_27_ ^ 0xffffffff) > -1)
                        i_27_ = 0;
                    if(i_28_ > 14)
                        i_28_ = 14;
                    for(/**/; i_28_ > i_27_; i_27_++) {
                        double d_29_ = d_26_;
                        double d_30_ = 3.141592653589793 * (-d + (double) i_27_);
                        if(d_30_ < -1.0E-4 || d_30_ > 1.0E-4)
                            d_29_ *= Math.sin(d_30_) / d_30_;
                        d_29_ *= 0.54 + 0.46 * Math.cos(0.2243994752564138 * (-d + (double) i_27_));
                        is[i_27_] = (int) Math.floor(0.5 + d_29_ * 65536.0);
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "qb.<init>(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method922(int arg0, int arg1, Buffer arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        anInt1139++;
        if(arg0 >= 0 && (arg0 ^ 0xffffffff) > -105 && (arg4 ^ 0xffffffff) <= -1 && (arg4 ^ 0xffffffff) > -105) {
            Floor.tile_flags[arg7][arg0][arg4] = (byte) 0;
            for(; ; ) {
                int i = arg2.method468(false);
                if((i ^ 0xffffffff) == -1) {
                    if(arg7 == 0)
                        Class40_Sub6.tile_height[0][arg0][arg4] = -Class42.method888(arg6 + (arg0 + 932731), (byte) -45, arg5 + 556238 + arg4) * 8;
                    else
                        Class40_Sub6.tile_height[arg7][arg0][arg4] = -240 + (Class40_Sub6.tile_height[arg7 + -1][arg0][arg4]);
                    break;
                }
                if(i == 1) {
                    int i_0_ = arg2.method468(false);
                    if(i_0_ == 1)
                        i_0_ = 0;
                    if((arg7 ^ 0xffffffff) != -1)
                        Class40_Sub6.tile_height[arg7][arg0][arg4] = (Class40_Sub6.tile_height[-1 + arg7][arg0][arg4]) + -(8 * i_0_);
                    else
                        Class40_Sub6.tile_height[0][arg0][arg4] = 8 * -i_0_;
                    break;
                }
                if(i <= 49) {
                    Class62.aByteArrayArrayArray1473[arg7][arg0][arg4] = arg2.get(105);
                    Floor.aByteArrayArrayArray2335[arg7][arg0][arg4] = (byte) ((i + -2) / 4);
                    Class35.aByteArrayArrayArray1745[arg7][arg0][arg4] = (byte) Class66.method1021(arg1 + -2 + i, 3);
                } else if(i <= 81)
                    Floor.tile_flags[arg7][arg0][arg4] = (byte) (-49 + i);
                else
                    Class42.aByteArrayArrayArray993[arg7][arg0][arg4] = (byte) (-81 + i);
            }
        } else {
            for(; ; ) {
                int i = arg2.method468(false);
                if((i ^ 0xffffffff) == -1)
                    break;
                if(i == 1) {
                    arg2.method468(false);
                    break;
                }
                if((i ^ 0xffffffff) >= -50)
                    arg2.method468(false);
            }
        }
        if(arg3 > -62)
            aClass1_1124 = null;
    }

    public static void method924(byte arg0) {
        try {
            aClass1_1137 = null;
            aClass40_Sub1_1132 = null;
            aClass1_1123 = null;
            int i = -6 % ((-6 - arg0) / 49);
            aClass1_1129 = null;
            aClass1_1122 = null;
            aClass1_1124 = null;
            aClass1_1125 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "qb.A(" + arg0 + ')');
        }
    }

    public static void method925(int arg0, Class40_Sub5_Sub12[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        try {
            anInt1141++;
            if(arg2 <= arg8 && arg4 >= arg9 && (arg8 ^ 0xffffffff) > (arg11 ^ 0xffffffff) && (arg4 ^ 0xffffffff) > (arg0 ^ 0xffffffff)) {
                for(int i = arg5; arg1.length > i; i++) {
                    Class40_Sub5_Sub12 class40_sub5_sub12 = arg1[i];
                    if(class40_sub5_sub12 != null && arg6 == class40_sub5_sub12.anInt2648) {
                        int i_1_ = class40_sub5_sub12.anInt2696 - (-arg9 + arg3);
                        int i_2_ = -arg10 + (class40_sub5_sub12.anInt2656 + arg2);
                        if(class40_sub5_sub12.anInt2683 == 8 && (i_2_ ^ 0xffffffff) >= (arg8 ^ 0xffffffff) && i_1_ <= arg4 && arg8 < i_2_ + class40_sub5_sub12.anInt2692 && ((arg4 ^ 0xffffffff) > (class40_sub5_sub12.anInt2643 + i_1_ ^ 0xffffffff)))
                            Class40_Sub5_Sub17_Sub3.anInt3065 = i;
                        if((class40_sub5_sub12.anInt2721 >= 0 || class40_sub5_sub12.anInt2719 != 0) && i_2_ <= arg8 && i_1_ <= arg4 && arg8 < i_2_ + class40_sub5_sub12.anInt2692 && ((arg4 ^ 0xffffffff) > (class40_sub5_sub12.anInt2643 + i_1_ ^ 0xffffffff))) {
                            if(class40_sub5_sub12.anInt2721 >= 0)
                                Floor.anInt2328 = class40_sub5_sub12.anInt2721;
                            else
                                Floor.anInt2328 = i;
                        }
                        if(class40_sub5_sub12.anInt2683 == 0) {
                            if(!class40_sub5_sub12.aBoolean2750 || Class29.method371(8247, arg7, i) || PacketBuffer.aBoolean2236) {
                                method925(i_1_ + class40_sub5_sub12.anInt2643, arg1, i_2_, class40_sub5_sub12.anInt2731, arg4, arg5, i, arg7, arg8, i_1_, class40_sub5_sub12.anInt2746, (i_2_ + class40_sub5_sub12.anInt2692));
                                if((class40_sub5_sub12.aClass40_Sub5_Sub12Array2713) != null)
                                    method925(i_1_ + class40_sub5_sub12.anInt2643, (class40_sub5_sub12.aClass40_Sub5_Sub12Array2713), i_2_, class40_sub5_sub12.anInt2731, arg4, 0, class40_sub5_sub12.anInt2689, arg7, arg8, i_1_, class40_sub5_sub12.anInt2746, class40_sub5_sub12.anInt2692 + i_2_);
                                if((class40_sub5_sub12.anInt2643 ^ 0xffffffff) > (class40_sub5_sub12.anInt2720 ^ 0xffffffff))
                                    Class5.method168(class40_sub5_sub12.anInt2643, arg4, arg8, class40_sub5_sub12.anInt2720, (byte) 69, class40_sub5_sub12, class40_sub5_sub12.anInt2692 + i_2_, arg7, i_1_);
                            }
                        } else {
                            if(class40_sub5_sub12.anInt2714 == 1 && (i_2_ ^ 0xffffffff) >= (arg8 ^ 0xffffffff) && (i_1_ ^ 0xffffffff) >= (arg4 ^ 0xffffffff) && (class40_sub5_sub12.anInt2692 + i_2_ ^ 0xffffffff) < (arg8 ^ 0xffffffff) && (class40_sub5_sub12.anInt2643 + i_1_ ^ 0xffffffff) < (arg4 ^ 0xffffffff)) {
                                boolean bool = false;
                                if(class40_sub5_sub12.anInt2639 != 0)
                                    bool = (Class68_Sub1.method1051(300, class40_sub5_sub12));
                                if(!bool) {
                                    Class32.anInt754++;
                                    Floor.method558(0, class40_sub5_sub12.aClass1_2676, class40_sub5_sub12.anInt2689, -501, 0, 42, Class66.aClass1_1567);
                                }
                            }
                            if(((class40_sub5_sub12.anInt2714 ^ 0xffffffff) == -3) && (Main.anInt1773 ^ 0xffffffff) == -1 && arg8 >= i_2_ && (arg4 ^ 0xffffffff) <= (i_1_ ^ 0xffffffff) && arg8 < class40_sub5_sub12.anInt2692 + i_2_ && ((arg4 ^ 0xffffffff) > (i_1_ + class40_sub5_sub12.anInt2643 ^ 0xffffffff))) {
                                Floor.method558(0, class40_sub5_sub12.aClass1_2664, class40_sub5_sub12.anInt2689, -501, 0, 33, (Class40_Sub5_Sub17_Sub6.method832(102, new RSString[]{Landscape.aClass1_1162, (class40_sub5_sub12.aClass1_2709)})));
                                Class68.anInt1616++;
                            }
                            if(((class40_sub5_sub12.anInt2714 ^ 0xffffffff) == -4) && (arg8 ^ 0xffffffff) <= (i_2_ ^ 0xffffffff) && (arg4 ^ 0xffffffff) <= (i_1_ ^ 0xffffffff) && i_2_ + class40_sub5_sub12.anInt2692 > arg8 && (arg4 < i_1_ + class40_sub5_sub12.anInt2643)) {
                                Floor.anInt2347++;
                                int i_3_;
                                if(arg7 != 3)
                                    i_3_ = 9;
                                else
                                    i_3_ = 40;
                                Floor.method558(0, VertexNormal.aClass1_1090, class40_sub5_sub12.anInt2689, arg5 ^ ~0x1f4, 0, i_3_, Class66.aClass1_1567);
                            }
                            if(((class40_sub5_sub12.anInt2714 ^ 0xffffffff) == -5) && arg8 >= i_2_ && i_1_ <= arg4 && arg8 < class40_sub5_sub12.anInt2692 + i_2_ && (class40_sub5_sub12.anInt2643 + i_1_ ^ 0xffffffff) < (arg4 ^ 0xffffffff)) {
                                Floor.method558(0, class40_sub5_sub12.aClass1_2676, class40_sub5_sub12.anInt2689, -501, 0, 23, Class66.aClass1_1567);
                                Class40_Sub5_Sub17_Sub4.anInt3128++;
                            }
                            if(class40_sub5_sub12.anInt2714 == 5 && (i_2_ ^ 0xffffffff) >= (arg8 ^ 0xffffffff) && i_1_ <= arg4 && arg8 < i_2_ + class40_sub5_sub12.anInt2692 && (i_1_ + class40_sub5_sub12.anInt2643 ^ 0xffffffff) < (arg4 ^ 0xffffffff)) {
                                Class10.anInt345++;
                                Floor.method558(0, class40_sub5_sub12.aClass1_2676, class40_sub5_sub12.anInt2689, -501, 0, 57, Class66.aClass1_1567);
                            }
                            if(class40_sub5_sub12.anInt2714 == 6 && (Class6_Sub1.anInt1819 ^ 0xffffffff) == 0 && (i_2_ ^ 0xffffffff) >= (arg8 ^ 0xffffffff) && i_1_ <= arg4 && arg8 < i_2_ + class40_sub5_sub12.anInt2692 && ((arg4 ^ 0xffffffff) > (class40_sub5_sub12.anInt2643 + i_1_ ^ 0xffffffff))) {
                                Floor.method558(0, class40_sub5_sub12.aClass1_2676, class40_sub5_sub12.anInt2689, -501, 0, 54, Class66.aClass1_1567);
                                VertexNormal.anInt1101++;
                            }
                            if((class40_sub5_sub12.anInt2683 ^ 0xffffffff) == -3) {
                                int i_4_ = 0;
                                for(int i_5_ = 0; ((i_5_ ^ 0xffffffff) > (class40_sub5_sub12.anInt2643 ^ 0xffffffff)); i_5_++) {
                                    for(int i_6_ = 0; i_6_ < class40_sub5_sub12.anInt2692; i_6_++) {
                                        int i_7_ = (i_6_ * ((class40_sub5_sub12.anInt2749) + 32) + i_2_);
                                        int i_8_ = (i_1_ + ((32 + (class40_sub5_sub12.anInt2667)) * i_5_));
                                        if(i_4_ < 20) {
                                            i_7_ += (class40_sub5_sub12.anIntArray2699[i_4_]);
                                            i_8_ += (class40_sub5_sub12.anIntArray2708[i_4_]);
                                        }
                                        if(arg8 >= i_7_ && i_8_ <= arg4 && i_7_ + 32 > arg8 && ((arg4 ^ 0xffffffff) > (32 + i_8_ ^ 0xffffffff))) {
                                            RSRuntimeException.anInt1642 = class40_sub5_sub12.anInt2689;
                                            Class55.anInt1288 = i_4_;
                                            if(((class40_sub5_sub12.anIntArray2685[i_4_]) ^ 0xffffffff) < -1) {
                                                ItemDefinition class40_sub5_sub16 = (Class44.method897((-1 + (class40_sub5_sub12.anIntArray2685[i_4_])), 10));
                                                if((Class8.anInt301 ^ 0xffffffff) != -2 || !(class40_sub5_sub12.aBoolean2727)) {
                                                    if(Main.anInt1773 == 1 && (class40_sub5_sub12.aBoolean2727)) {
                                                        if(((ItemDefinition.anInt2815) & 0x10) == 16) {
                                                            Class40_Sub11.anInt2152++;
                                                            Floor.method558((class40_sub5_sub16.anInt2852), (Class38_Sub1.aClass1_1918), (class40_sub5_sub12.anInt2689), -501, i_4_, 37, (Class40_Sub5_Sub17_Sub6.method832(107, (new RSString[]{(FloorDecoration.aClass1_611), (Class5.aClass1_206), (class40_sub5_sub16.aClass1_2796)}))));
                                                        }
                                                    } else {
                                                        Class67.anInt1576++;
                                                        RSString[] class1s = (class40_sub5_sub16.options);
                                                        if(Class60.aBoolean1402)
                                                            class1s = (Class56.method968(class1s, false));
                                                        if(class40_sub5_sub12.aBoolean2727) {
                                                            for(int i_9_ = 4; ((i_9_ ^ 0xffffffff) <= -4); i_9_--) {
                                                                if((class1s != null) && ((class1s[i_9_]) != null)) {
                                                                    Class26.anInt628++;
                                                                    int i_10_;
                                                                    if(i_9_ != 3)
                                                                        i_10_ = 11;
                                                                    else
                                                                        i_10_ = 43;
                                                                    Floor.method558((class40_sub5_sub16.anInt2852), (class1s[i_9_]), (class40_sub5_sub12.anInt2689), (arg5 ^ ~0x1f4), i_4_, i_10_, (Class40_Sub5_Sub17_Sub6.method832(-128, (new RSString[]{VertexNormal.aClass1_1114, class40_sub5_sub16.aClass1_2796}))));
                                                                } else if((i_9_ ^ 0xffffffff) == -5) {
                                                                    Floor.method558((class40_sub5_sub16.anInt2852), (Cache.dropStringInstance), (class40_sub5_sub12.anInt2689), -501, i_4_, 11, (Class40_Sub5_Sub17_Sub6.method832(94, (new RSString[]{VertexNormal.aClass1_1114, class40_sub5_sub16.aClass1_2796}))));
                                                                    Class4.anInt184++;
                                                                }
                                                            }
                                                        }
                                                        if(class40_sub5_sub12.aBoolean2655) {
                                                            Floor.method558((class40_sub5_sub16.anInt2852), (Main.aClass1_1763), (class40_sub5_sub12.anInt2689), -501, i_4_, 19, (Class40_Sub5_Sub17_Sub6.method832(58, (new RSString[]{(VertexNormal.aClass1_1114), (class40_sub5_sub16.aClass1_2796)}))));
                                                            GameObject.anInt3028++;
                                                        }
                                                        if((class40_sub5_sub12.aBoolean2727) && (class1s != null)) {
                                                            for(int i_11_ = 2; i_11_ >= 0; i_11_--) {
                                                                if((class1s[i_11_]) != null) {
                                                                    int i_12_ = 0;
                                                                    if(i_11_ == 0)
                                                                        i_12_ = 52;
                                                                    Class44.anInt1050++;
                                                                    if(i_11_ == 1)
                                                                        i_12_ = 6;
                                                                    if((i_11_ ^ 0xffffffff) == -3)
                                                                        i_12_ = 31;
                                                                    Floor.method558((class40_sub5_sub16.anInt2852), (class1s[i_11_]), (class40_sub5_sub12.anInt2689), -501, i_4_, i_12_, (Class40_Sub5_Sub17_Sub6.method832(-66, (new RSString[]{VertexNormal.aClass1_1114, class40_sub5_sub16.aClass1_2796}))));
                                                                }
                                                            }
                                                        }
                                                        class1s = (class40_sub5_sub12.aClass1Array2698);
                                                        if(Class60.aBoolean1402)
                                                            class1s = (Class56.method968(class1s, false));
                                                        if(class1s != null) {
                                                            for(int i_13_ = 4; i_13_ >= 0; i_13_--) {
                                                                if((class1s[i_13_]) != null) {
                                                                    Class40_Sub5_Sub17_Sub4.anInt3146++;
                                                                    int i_14_ = 0;
                                                                    if((i_13_ ^ 0xffffffff) == -1)
                                                                        i_14_ = 53;
                                                                    if(i_13_ == 1)
                                                                        i_14_ = 25;
                                                                    if((i_13_ ^ 0xffffffff) == -3)
                                                                        i_14_ = 55;
                                                                    if((i_13_ ^ 0xffffffff) == -4)
                                                                        i_14_ = 48;
                                                                    if((i_13_ ^ 0xffffffff) == -5)
                                                                        i_14_ = 24;
                                                                    Floor.method558((class40_sub5_sub16.anInt2852), (class1s[i_13_]), (class40_sub5_sub12.anInt2689), (arg5 + -501), i_4_, i_14_, (Class40_Sub5_Sub17_Sub6.method832(68, (new RSString[]{VertexNormal.aClass1_1114, class40_sub5_sub16.aClass1_2796}))));
                                                                }
                                                            }
                                                        }
                                                        Floor.method558((class40_sub5_sub16.anInt2852), (Class40_Sub5_Sub15.aClass1_2774), (class40_sub5_sub12.anInt2689), -501, i_4_, 1006, (Class40_Sub5_Sub17_Sub6.method832(118, (new RSString[]{(VertexNormal.aClass1_1114), (class40_sub5_sub16.aClass1_2796)}))));
                                                    }
                                                } else if((((class40_sub5_sub12.anInt2689) ^ 0xffffffff) != ((ISAAC.anInt525) ^ 0xffffffff)) || (((Class45.anInt1061) ^ 0xffffffff) != (i_4_ ^ 0xffffffff))) {
                                                    Floor.method558((class40_sub5_sub16.anInt2852), Main.aClass1_1763, (class40_sub5_sub12.anInt2689), -501, i_4_, 56, (Class40_Sub5_Sub17_Sub6.method832(arg5 ^ 0x53, (new RSString[]{(NPC.aClass1_3295), (Class5.aClass1_206), (class40_sub5_sub16.aClass1_2796)}))));
                                                    Class37.anInt863++;
                                                }
                                            }
                                        }
                                        i_4_++;
                                    }
                                }
                            }
                            if(class40_sub5_sub12.aBoolean2636 && ((class40_sub5_sub12.anInt2718 ^ 0xffffffff) != 0) && (arg8 ^ 0xffffffff) <= (i_2_ ^ 0xffffffff) && (arg4 ^ 0xffffffff) <= (i_1_ ^ 0xffffffff) && ((arg8 ^ 0xffffffff) > (class40_sub5_sub12.anInt2692 + i_2_ ^ 0xffffffff)) && ((arg4 ^ 0xffffffff) > (i_1_ + class40_sub5_sub12.anInt2643 ^ 0xffffffff))) {
                                Class67.anInt1576++;
                                ItemDefinition class40_sub5_sub16 = Class44.method897((class40_sub5_sub12.anInt2718), 10);
                                if(class40_sub5_sub12.aBoolean2727) {
                                    RSString[] class1s = class40_sub5_sub16.options;
                                    if(Class60.aBoolean1402)
                                        class1s = Class56.method968(class1s, false);
                                    if(class1s == null || class1s[4] == null)
                                        Floor.method558(class40_sub5_sub16.anInt2852, Cache.dropStringInstance, class40_sub5_sub12.anInt2689, -501, -1 + class40_sub5_sub12.anInt2736, 11, (Class40_Sub5_Sub17_Sub6.method832(107, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                    else
                                        Floor.method558(class40_sub5_sub16.anInt2852, class1s[4], class40_sub5_sub12.anInt2689, -501, class40_sub5_sub12.anInt2736 + -1, 11, (Class40_Sub5_Sub17_Sub6.method832(-41, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                    if(class1s != null && class1s[3] != null)
                                        Floor.method558(class40_sub5_sub16.anInt2852, class1s[3], class40_sub5_sub12.anInt2689, -501, -1 + class40_sub5_sub12.anInt2736, 43, (Class40_Sub5_Sub17_Sub6.method832(57, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                    if(class1s != null && class1s[2] != null)
                                        Floor.method558(class40_sub5_sub16.anInt2852, class1s[2], class40_sub5_sub12.anInt2689, -501, class40_sub5_sub12.anInt2736 - 1, 31, (Class40_Sub5_Sub17_Sub6.method832(-113, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                    if(class1s != null && class1s[1] != null)
                                        Floor.method558(class40_sub5_sub16.anInt2852, class1s[1], class40_sub5_sub12.anInt2689, -501, -1 + class40_sub5_sub12.anInt2736, 6, (Class40_Sub5_Sub17_Sub6.method832(74, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                    if(class1s != null && class1s[0] != null)
                                        Floor.method558(class40_sub5_sub16.anInt2852, class1s[0], class40_sub5_sub12.anInt2689, -501, -1 + class40_sub5_sub12.anInt2736, 52, (Class40_Sub5_Sub17_Sub6.method832(73, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                }
                                if(class40_sub5_sub12.anInt2689 >= 0)
                                    Floor.method558(class40_sub5_sub16.anInt2852, Class40_Sub5_Sub15.aClass1_2774, class40_sub5_sub12.anInt2689, -501, -1, 1007, (Class40_Sub5_Sub17_Sub6.method832(98, new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)})));
                                else
                                    Floor.method558(class40_sub5_sub16.anInt2852, Class40_Sub5_Sub15.aClass1_2774, class40_sub5_sub12.anInt2648, -501, class40_sub5_sub12.anInt2689 & 0x7fff, 1007, (Class40_Sub5_Sub17_Sub6.method832(68, new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)})));
                            }
                            if(class40_sub5_sub12.aBoolean2688 && class40_sub5_sub12.aClass1Array2661 != null && (i_2_ ^ 0xffffffff) >= (arg8 ^ 0xffffffff) && (i_1_ ^ 0xffffffff) >= (arg4 ^ 0xffffffff) && class40_sub5_sub12.anInt2692 + i_2_ > arg8 && (arg4 < i_1_ + class40_sub5_sub12.anInt2643)) {
                                RSString class1 = Class66.aClass1_1567;
                                if(class40_sub5_sub12.anInt2718 != -1) {
                                    ItemDefinition class40_sub5_sub16 = Class44.method897((class40_sub5_sub12.anInt2718), arg5 ^ 0xa);
                                    class1 = (Class40_Sub5_Sub17_Sub6.method832(arg5 + -67, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)})));
                                }
                                for(int i_15_ = ((class40_sub5_sub12.aClass1Array2661).length - 1); (i_15_ ^ 0xffffffff) <= -1; i_15_--) {
                                    if((class40_sub5_sub12.aClass1Array2661[i_15_]) != null) {
                                        if(class40_sub5_sub12.anInt2689 < 0)
                                            Floor.method558(i_15_ + 1, (class40_sub5_sub12.aClass1Array2661[i_15_]), class40_sub5_sub12.anInt2648, arg5 ^ ~0x1f4, 0x7fff & (class40_sub5_sub12.anInt2689), 50, class1);
                                        else
                                            Floor.method558(i_15_ + 1, (class40_sub5_sub12.aClass1Array2661[i_15_]), class40_sub5_sub12.anInt2689, arg5 ^ ~0x1f4, 0, 50, class1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("qb.F(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ',' + arg7 + ',' + arg8 + ',' + arg9 + ',' + arg10 + ',' + arg11 + ')'));
        }
    }

    public static DirectColorSprite method927(int arg0, Class6 arg1, boolean arg2, int arg3) {
        try {
            anInt1134++;
            if(!Class52.method948(arg0, arg3, arg1, -3844))
                return null;
            if(arg2 != true)
                method922(3, -92, null, -95, -119, -82, -28, -32);
            return NpcDefinition.method578(-120);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("qb.D(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public static void method928(int arg0) {
        try {
            anInt1130++;
            if(Class40_Sub6.aClass64_2098 != null) {
                Class40_Sub6.aClass64_2098.method1009(75);
                Class40_Sub6.aClass64_2098 = null;
            }
            RSCanvas.method46(0);
            NPC.aScene_3301.method98();
            int i = 0;
            if(arg0 != -7225)
                aClass40_Sub1_1132 = null;
            for(/**/; i < 4; i++)
                Landscape.aCollisionMapArray1167[i].method146(arg0 + 16784441);
            System.gc();
            Class33.method405(arg0 ^ ~0x5e71, 10);
            Class35.anInt1733 = 0;
            Class62.anInt1457 = -1;
            Class37.method436(arg0 + 7352);
            Floor.method559(10, -76);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "qb.H(" + arg0 + ')');
        }
    }

    public int method921(int arg0, int arg1) {
        try {
            if(anIntArrayArray1128 != null)
                arg0 = 7 + anInt1133 * arg0 / anInt1131;
            if(arg1 != 54)
                return 55;
            anInt1135++;
            return arg0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "qb.G(" + arg0 + ',' + arg1 + ')');
        }
    }

    public int method923(int arg0, int arg1) {
        try {
            if(arg1 != 4)
                return -128;
            anInt1140++;
            if(anIntArrayArray1128 != null)
                arg0 = anInt1133 * arg0 / anInt1131;
            return arg0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "qb.C(" + arg0 + ',' + arg1 + ')');
        }
    }

    public byte[] method926(byte[] arg0, boolean arg1) {
        try {
            anInt1136++;
            if(anIntArrayArray1128 != null) {
                int i = 14 + arg0.length * anInt1133 / anInt1131;
                int i_16_ = 0;
                int[] is = new int[i];
                int i_17_ = 0;
                for(int i_18_ = 0; i_18_ < arg0.length; i_18_++) {
                    int i_19_ = arg0[i_18_];
                    int[] is_20_ = anIntArrayArray1128[i_17_];
                    for(int i_21_ = 0; i_21_ < 14; i_21_++)
                        is[i_21_ + i_16_] += is_20_[i_21_] * i_19_;
                    i_17_ += anInt1133;
                    int i_22_ = i_17_ / anInt1131;
                    i_17_ -= i_22_ * anInt1131;
                    i_16_ += i_22_;
                }
                arg0 = new byte[i];
                for(int i_23_ = 0; i > i_23_; i_23_++) {
                    int i_24_ = 32768 + is[i_23_] >> -1925341008;
                    if((i_24_ ^ 0xffffffff) <= 127) {
                        if((i_24_ ^ 0xffffffff) < -128)
                            arg0[i_23_] = (byte) 127;
                        else
                            arg0[i_23_] = (byte) i_24_;
                    } else
                        arg0[i_23_] = (byte) -128;
                }
            }
            if(arg1 != false)
                method927(-84, null, true, -86);
            return arg0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("qb.E(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }
}
