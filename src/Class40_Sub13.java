/* Class40_Sub13 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class40_Sub13 extends Node {
    public static int anInt2169;
    public static int anInt2170;
    public static RSString aClass1_2172 = Class58.method978("Service unavailable)3");
    public static int anInt2173;
    public static RSString aClass1_2174;
    public static RSString aClass1_2176;
    public static boolean aBoolean2177;
    public static RSString aClass1_2179 = Class58.method978("cross");
    public static int anInt2180;
    public static RSString aClass1_2181;
    public static int anInt2182;
    public static int anInt2183;
    public static int anInt2184;
    public static RSString aClass1_2185;
    public static RSString aClass1_2186;
    public static RSString aClass1_2187;
    public static RSString aClass1_2188;
    public static RSString aClass1_2189;

    static {
        aBoolean2177 = false;
        aClass1_2181 = Class58.method978("Musik)2Engine vorbereitet)3");
        aClass1_2176 = (Class58.method978("Bitte warten Sie )2 es wird versucht)1 die Verbindung wiederherzustellen)3"));
        anInt2183 = 0;
        aClass1_2185 = Class58.method978("Titelbild geladen)3");
        aClass1_2174 = Class58.method978("rot:");
        aClass1_2187 = (Class58.method978("You need a members account to login to this world)3"));
        aClass1_2188 = aClass1_2187;
        aClass1_2186 = Class58.method978(" hat sich eingeloggt)3");
        aClass1_2189 = aClass1_2172;
    }

    public int[][] anIntArrayArray2168;
    public int anInt2171;
    public int anInt2175;
    public int[] anIntArray2178;

    public Class40_Sub13(int arg0, byte[] arg1) {
        try {
            anInt2175 = arg0;
            Buffer class40_sub1 = new Buffer(arg1);
            anInt2171 = class40_sub1.method468(false);
            anIntArrayArray2168 = new int[anInt2171][];
            anIntArray2178 = new int[anInt2171];
            for(int i = 0; i < anInt2171; i++)
                anIntArray2178[i] = class40_sub1.method468(false);
            for(int i = 0; (i ^ 0xffffffff) > (anInt2171 ^ 0xffffffff); i++)
                anIntArrayArray2168[i] = new int[class40_sub1.method468(false)];
            for(int i = 0; i < anInt2171; i++) {
                for(int i_38_ = 0; anIntArrayArray2168[i].length > i_38_; i_38_++)
                    anIntArrayArray2168[i][i_38_] = class40_sub1.method468(false);
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("va.<init>(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static DirectColorSprite method876(int arg0, int arg1, int arg2, int arg3) {
        try {
            anInt2182++;
            if(arg3 == 0) {
                DirectColorSprite class40_sub5_sub14_sub4 = ((DirectColorSprite) Buffer.aClass9_1933.method231((long) arg2, (byte) 56));
                if(class40_sub5_sub14_sub4 != null && class40_sub5_sub14_sub4.anInt2952 != arg1 && (class40_sub5_sub14_sub4.anInt2952 ^ 0xffffffff) != 0) {
                    class40_sub5_sub14_sub4.method457(-1);
                    class40_sub5_sub14_sub4 = null;
                }
                if(class40_sub5_sub14_sub4 != null)
                    return class40_sub5_sub14_sub4;
            }
            ItemDefinition class40_sub5_sub16 = Class44.method897(arg2, 10);
            if(class40_sub5_sub16.anIntArray2831 == null)
                arg1 = -1;
            if((arg1 ^ 0xffffffff) < -2) {
                int i = -1;
                for(int i_0_ = 0; (i_0_ ^ 0xffffffff) > -11; i_0_++) {
                    if(arg1 >= class40_sub5_sub16.anIntArray2834[i_0_] && class40_sub5_sub16.anIntArray2834[i_0_] != 0)
                        i = class40_sub5_sub16.anIntArray2831[i_0_];
                }
                if(i != -1)
                    class40_sub5_sub16 = Class44.method897(i, 10);
            }
            Model class40_sub5_sub17_sub5 = class40_sub5_sub16.method753(true, 1, 26910);
            if(class40_sub5_sub17_sub5 == null)
                return null;
            DirectColorSprite class40_sub5_sub14_sub4 = null;
            if(class40_sub5_sub16.anInt2807 != -1) {
                class40_sub5_sub14_sub4 = method876(-56, 10, class40_sub5_sub16.anInt2812, -1);
                if(class40_sub5_sub14_sub4 == null)
                    return null;
            }
            int[] is = Rasterizer.anIntArray2766;
            int i = Rasterizer.anInt2769;
            int i_1_ = Rasterizer.anInt2768;
            int i_2_ = Rasterizer.anInt2771;
            int i_3_ = 16 / ((arg0 - 26) / 57);
            int i_4_ = Rasterizer.anInt2772;
            int i_5_ = Rasterizer.anInt2767;
            int i_6_ = Rasterizer.anInt2770;
            int[] is_7_ = R3D.method713();
            int i_8_ = R3D.anInt2930;
            int i_9_ = R3D.anInt2945;
            DirectColorSprite class40_sub5_sub14_sub4_10_ = new DirectColorSprite(32, 32);
            Rasterizer.method669(class40_sub5_sub14_sub4_10_.anIntArray2955, 32, 32);
            Class40_Sub5_Sub17_Sub6.anIntArray3253 = R3D.method708(Class40_Sub5_Sub17_Sub6.anIntArray3253);
            Rasterizer.method656(0, 0, 32, 32, 0);
            int i_11_ = class40_sub5_sub16.anInt2817;
            if((arg3 ^ 0xffffffff) == 0)
                i_11_ *= 1.5;
            if(arg3 > 0)
                i_11_ *= 1.04;
            R3D.aBoolean2944 = false;
            int i_12_ = ((R3D.sinetable[class40_sub5_sub16.anInt2844]) * i_11_ >> -1598852880);
            int i_13_ = (i_11_ * (R3D.cosinetable[class40_sub5_sub16.anInt2844]) >> -2129368336);
            class40_sub5_sub17_sub5.method799();
            class40_sub5_sub17_sub5.method812(0, class40_sub5_sub16.anInt2830, class40_sub5_sub16.anInt2827, class40_sub5_sub16.anInt2844, class40_sub5_sub16.anInt2806, (class40_sub5_sub16.anInt2810 + class40_sub5_sub17_sub5.anInt2861 / 2 + i_12_), i_13_ + class40_sub5_sub16.anInt2810);
            for(int i_14_ = 31; i_14_ >= 0; i_14_--) {
                for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                    if(((class40_sub5_sub14_sub4_10_.anIntArray2955[i_14_ + 32 * i_13_]) ^ 0xffffffff) == -1) {
                        if((i_14_ ^ 0xffffffff) < -1 && (class40_sub5_sub14_sub4_10_.anIntArray2955[i_13_ * 32 + (-1 + i_14_)]) > 1)
                            class40_sub5_sub14_sub4_10_.anIntArray2955[i_13_ * 32 + i_14_] = 1;
                        else if((i_13_ ^ 0xffffffff) < -1 && (class40_sub5_sub14_sub4_10_.anIntArray2955[i_14_ + ((i_13_ + -1) * 32)]) > 1)
                            class40_sub5_sub14_sub4_10_.anIntArray2955[i_13_ * 32 + i_14_] = 1;
                        else if((i_14_ ^ 0xffffffff) > -32 && (class40_sub5_sub14_sub4_10_.anIntArray2955[i_13_ * 32 + i_14_ + 1]) > 1)
                            class40_sub5_sub14_sub4_10_.anIntArray2955[i_14_ + i_13_ * 32] = 1;
                        else if(i_13_ < 31 && (class40_sub5_sub14_sub4_10_.anIntArray2955[(i_13_ + 1) * 32 + i_14_]) > 1)
                            class40_sub5_sub14_sub4_10_.anIntArray2955[i_14_ + 32 * i_13_] = 1;
                    }
                }
            }
            if((arg3 ^ 0xffffffff) < -1) {
                for(int i_15_ = 31; i_15_ >= 0; i_15_--) {
                    for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                        if(((class40_sub5_sub14_sub4_10_.anIntArray2955[i_15_ + (i_13_ * 32)]) ^ 0xffffffff) == -1) {
                            if(i_15_ > 0 && ((class40_sub5_sub14_sub4_10_.anIntArray2955[32 * i_13_ + (-1 + i_15_)]) ^ 0xffffffff) == -2)
                                class40_sub5_sub14_sub4_10_.anIntArray2955[i_15_ + i_13_ * 32] = arg3;
                            else if(i_13_ <= 0 || ((class40_sub5_sub14_sub4_10_.anIntArray2955[i_15_ + ((i_13_ + -1) * 32)]) ^ 0xffffffff) != -2) {
                                if((i_15_ ^ 0xffffffff) <= -32 || ((class40_sub5_sub14_sub4_10_.anIntArray2955[1 + i_15_ + (i_13_ * 32)]) ^ 0xffffffff) != -2) {
                                    if((i_13_ ^ 0xffffffff) > -32 && ((class40_sub5_sub14_sub4_10_.anIntArray2955[i_15_ + (32 + 32 * i_13_)]) ^ 0xffffffff) == -2)
                                        class40_sub5_sub14_sub4_10_.anIntArray2955[i_13_ * 32 + i_15_] = arg3;
                                } else
                                    class40_sub5_sub14_sub4_10_.anIntArray2955[i_15_ + (i_13_ * 32)] = arg3;
                            } else
                                class40_sub5_sub14_sub4_10_.anIntArray2955[i_15_ + (i_13_ * 32)] = arg3;
                        }
                    }
                }
            } else if(arg3 == 0) {
                for(int i_16_ = 31; (i_16_ ^ 0xffffffff) <= -1; i_16_--) {
                    for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                        if((class40_sub5_sub14_sub4_10_.anIntArray2955[i_13_ * 32 + i_16_]) == 0 && i_16_ > 0 && (i_13_ ^ 0xffffffff) < -1 && ((class40_sub5_sub14_sub4_10_.anIntArray2955[i_16_ - (1 + -((-1 + i_13_) * 32))]) ^ 0xffffffff) < -1)
                            class40_sub5_sub14_sub4_10_.anIntArray2955[i_16_ + 32 * i_13_] = 3153952;
                    }
                }
            }
            if(class40_sub5_sub16.anInt2807 != -1) {
                int i_17_ = class40_sub5_sub14_sub4.anInt2952;
                int i_18_ = class40_sub5_sub14_sub4.anInt2954;
                class40_sub5_sub14_sub4.anInt2952 = 32;
                class40_sub5_sub14_sub4.anInt2954 = 32;
                class40_sub5_sub14_sub4.method721(0, 0);
                class40_sub5_sub14_sub4.anInt2954 = i_18_;
                class40_sub5_sub14_sub4.anInt2952 = i_17_;
            }
            if(arg3 == 0)
                Buffer.aClass9_1933.method230(-7208, (long) arg2, class40_sub5_sub14_sub4_10_);
            Rasterizer.method669(is, i_1_, i);
            Rasterizer.method655(i_2_, i_5_, i_4_, i_6_);
            R3D.method708(is_7_);
            R3D.anInt2930 = i_8_;
            R3D.anInt2945 = i_9_;
            R3D.method702();
            R3D.aBoolean2944 = true;
            if((class40_sub5_sub16.anInt2795 ^ 0xffffffff) == -2)
                class40_sub5_sub14_sub4_10_.anInt2954 = 33;
            else
                class40_sub5_sub14_sub4_10_.anInt2954 = 32;
            class40_sub5_sub14_sub4_10_.anInt2952 = arg1;
            return class40_sub5_sub14_sub4_10_;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("va.B(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public static void method877(int arg0) {
        try {
            aClass1_2188 = null;
            aClass1_2181 = null;
            aClass1_2179 = null;
            aClass1_2186 = null;
            aClass1_2185 = null;
            aClass1_2176 = null;
            if(arg0 == 0) {
                aClass1_2172 = null;
                aClass1_2174 = null;
                aClass1_2189 = null;
                aClass1_2187 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "va.E(" + arg0 + ')');
        }
    }

    public static Class40_Sub5_Sub12 method878(int arg0, Class40_Sub5_Sub12 arg1) {
        try {
            anInt2169++;
            int i;
            if((arg1.anInt2689 ^ 0xffffffff) > -1)
                i = arg1.anInt2648 >> -1744237840;
            else
                i = arg1.anInt2689 >> -462467952;
            if(!Class68.method1043(i, 126))
                return null;
            if(arg0 != -1598852880)
                method876(44, -123, -88, 35);
            if((arg1.anInt2738 ^ 0xffffffff) <= -1)
                return (Class59.aClass40_Sub5_Sub12ArrayArray1390[i][0xffff & arg1.anInt2738]);
            Class40_Sub5_Sub12 class40_sub5_sub12 = (Class59.aClass40_Sub5_Sub12ArrayArray1390[i][(0x7fff99d9 & arg1.anInt2738) >> -88908881]);
            return (class40_sub5_sub12.aClass40_Sub5_Sub12Array2713[arg1.anInt2738 & 0x7fff]);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("va.D(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method879(int arg0, IndexedColorSprite arg1) {
        anInt2170++;
        int i = 0;
        if(arg0 != -4487)
            method876(112, -38, -90, -56);
        for(/**/; i < Landscape.anIntArray1168.length; i++)
            Landscape.anIntArray1168[i] = 0;
        int i_19_ = 256;
        for(int i_20_ = 0; i_20_ < 5000; i_20_++) {
            int i_21_ = (int) ((double) i_19_ * (128.0 * Math.random()));
            Landscape.anIntArray1168[i_21_] = (int) (256.0 * Math.random());
        }
        for(int i_22_ = 0; (i_22_ ^ 0xffffffff) > -21; i_22_++) {
            for(int i_23_ = 1; (-1 + i_19_ ^ 0xffffffff) < (i_23_ ^ 0xffffffff); i_23_++) {
                for(int i_24_ = 1; i_24_ < 127; i_24_++) {
                    int i_25_ = (i_23_ << 2116521895) + i_24_;
                    Class61.anIntArray1445[i_25_] = (Landscape.anIntArray1168[i_25_ - 128] + Landscape.anIntArray1168[i_25_ + -1] + (Landscape.anIntArray1168[i_25_ + 1] + Landscape.anIntArray1168[128 + i_25_])) / 4;
                }
            }
            int[] is = Landscape.anIntArray1168;
            Landscape.anIntArray1168 = Class61.anIntArray1445;
            Class61.anIntArray1445 = is;
        }
        if(arg1 != null) {
            int i_26_ = 0;
            for(int i_27_ = 0; arg1.anInt2926 > i_27_; i_27_++) {
                for(int i_28_ = 0; (i_28_ ^ 0xffffffff) > (arg1.anInt2921 ^ 0xffffffff); i_28_++) {
                    if((arg1.aByteArray2925[i_26_++] ^ 0xffffffff) != -1) {
                        int i_29_ = arg1.anInt2927 + i_27_ + 16;
                        int i_30_ = arg1.anInt2928 + (i_28_ + 16);
                        int i_31_ = i_30_ + (i_29_ << 692888135);
                        Landscape.anIntArray1168[i_31_] = 0;
                    }
                }
            }
        }
    }

    public static void method880(byte arg0, int arg1, int arg2) {
        try {
            anInt2173++;
            Class45 class45 = (Class10.aClass45ArrayArrayArray357[Player.anInt3267][arg2][arg1]);
            if(class45 == null)
                NPC.aScene_3301.method125(Player.anInt3267, arg2, arg1);
            else {
                int i = -99999999;
                Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3 = null;
                for(Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3_32_ = ((Class40_Sub5_Sub17_Sub3) class45.method902((byte) -90)); class40_sub5_sub17_sub3_32_ != null; class40_sub5_sub17_sub3_32_ = (Class40_Sub5_Sub17_Sub3) class45.method909(-4)) {
                    ItemDefinition class40_sub5_sub16 = Class44.method897((class40_sub5_sub17_sub3_32_.anInt3067), 10);
                    int i_33_ = class40_sub5_sub16.anInt2828;
                    if(class40_sub5_sub16.anInt2795 == 1)
                        i_33_ *= class40_sub5_sub17_sub3_32_.anInt3058 + 1;
                    if((i_33_ ^ 0xffffffff) < (i ^ 0xffffffff)) {
                        i = i_33_;
                        class40_sub5_sub17_sub3 = class40_sub5_sub17_sub3_32_;
                    }
                }
                if(class40_sub5_sub17_sub3 == null)
                    NPC.aScene_3301.method125(Player.anInt3267, arg2, arg1);
                else {
                    if(arg0 != -80)
                        aClass1_2187 = null;
                    Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3_34_ = null;
                    Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3_35_ = null;
                    class45.method905(0, class40_sub5_sub17_sub3);
                    for(Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3_36_ = ((Class40_Sub5_Sub17_Sub3) class45.method902((byte) -90)); class40_sub5_sub17_sub3_36_ != null; class40_sub5_sub17_sub3_36_ = ((Class40_Sub5_Sub17_Sub3) class45.method909(-4))) {
                        if((class40_sub5_sub17_sub3_36_.anInt3067 ^ 0xffffffff) != (class40_sub5_sub17_sub3.anInt3067 ^ 0xffffffff)) {
                            if(class40_sub5_sub17_sub3_35_ == null)
                                class40_sub5_sub17_sub3_35_ = class40_sub5_sub17_sub3_36_;
                            if((class40_sub5_sub17_sub3_35_.anInt3067 != class40_sub5_sub17_sub3_36_.anInt3067) && class40_sub5_sub17_sub3_34_ == null)
                                class40_sub5_sub17_sub3_34_ = class40_sub5_sub17_sub3_36_;
                        }
                    }
                    int i_37_ = 1610612736 + (arg1 << 512988999) + arg2;
                    NPC.aScene_3301.method139(Player.anInt3267, arg2, arg1, Class37.method430((byte) -126, (Player.anInt3267), 64 + 128 * arg2, 64 + 128 * arg1), class40_sub5_sub17_sub3, i_37_, class40_sub5_sub17_sub3_35_, class40_sub5_sub17_sub3_34_);
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("va.A(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }
}
