/* Class10 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class10 {
    public static int anInt335;
    public static RSString aClass1_338 = Class58.method978(-11538, "backhmid1");
    public static int anInt339;
    public static RSString aClass1_343;
    public static RSString aClass1_344;
    public static int anInt345;
    public static RSString aClass1_346;
    public static int anInt349 = 0;
    public static int anInt350;
    public static int[] anIntArray351;
    public static RSString aClass1_352;
    public static Class40_Sub5_Sub12 aClass40_Sub5_Sub12_353;
    public static int[] anIntArray354;
    public static int anInt356;
    public static Class45[][][] aClass45ArrayArrayArray357;

    static {
        aClass1_346
                = Class58.method978(-11538, "The server is being updated)3");
        aClass1_344 = aClass1_346;
        aClass1_352 = Class58.method978(-11538, "Neuer Benutzer");
        anIntArray351 = new int[4000];
        aClass1_343
                = Class58.method978(-11538, "Geben Sie Ihren Benutzernamen");
        anIntArray354 = new int[25];
        aClass40_Sub5_Sub12_353 = null;
        anInt356 = 0;
        aClass45ArrayArrayArray357 = new Class45[4][104][104];
    }

    public int anInt334;
    public int anInt336;
    public int anInt337;
    public Class40_Sub5_Sub17 aClass40_Sub5_Sub17_340;
    public Class40_Sub5_Sub17 aClass40_Sub5_Sub17_341;
    public int anInt342;
    public int anInt347;
    public int anInt348 = 0;
    public int anInt355;

    public Class10() {
        anInt336 = 0;
    }

    public static void method237(int arg0) {
        aClass1_352 = null;
        aClass1_344 = null;
        aClass1_338 = null;
        anIntArray354 = null;
        aClass45ArrayArrayArray357 = null;
        aClass1_343 = null;
        aClass1_346 = null;
        anIntArray351 = null;
        aClass40_Sub5_Sub12_353 = null;
        if (arg0 <= 54)
            method237(102);
    }

    public static void method238(int arg0) {
        anInt335++;
        if ((Class3.anInt165 ^ 0xffffffff) != -1) {
            RSFont class40_sub5_sub14_sub1
                    = Class53.aClass40_Sub5_Sub14_Sub1_1268;
            int i = 0;
            if (Class40_Sub5_Sub15.anInt2782 != 0)
                i = 1;
            for (int i_0_ = 0; i_0_ < 100; i_0_++) {
                if (Class40_Sub5_Sub17_Sub4.aClass1Array3160[i_0_] != null) {
                    RSString class1 = Class40_Sub5_Sub17.aClass1Array2856[i_0_];
                    int i_1_ = 0;
                    int i_2_ = Class66.anIntArray1569[i_0_];
                    if (class1 != null
                            && class1.method75((byte) 116, Class51.aClass1_1210)) {
                        class1 = class1.method50((byte) 95, 5);
                        i_1_ = 1;
                    }
                    if (class1 != null
                            && class1.method75((byte) 116,
                            Class40_Sub5_Sub12.aClass1_2729)) {
                        class1 = class1.method50((byte) 95, 5);
                        i_1_ = 2;
                    }
                    if (((i_2_ ^ 0xffffffff) == -4 || i_2_ == 7)
                            && (i_2_ == 7 || Class4.anInt185 == 0
                            || ((Class4.anInt185 ^ 0xffffffff) == -2
                            && Class40_Sub2.method523(class1, -32624)))) {
                        int i_3_ = 329 - 13 * i;
                        int i_4_ = 4;
                        i++;
                        class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub6
                                        .aClass1_2458),
                                i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub6
                                        .aClass1_2458),
                                i_4_, -1 + i_3_,
                                65535);
                        i_4_ += class40_sub5_sub14_sub1
                                .method685(Class40_Sub5_Sub6.aClass1_2458);
                        i_4_ += class40_sub5_sub14_sub1.method689(32);
                        if ((i_1_ ^ 0xffffffff) == -2) {
                            Class40_Sub5_Sub13
                                    .aClass40_Sub5_Sub14_Sub2Array2753[0]
                                    .method692(i_4_, i_3_ - 12);
                            i_4_ += 14;
                        }
                        if ((i_1_ ^ 0xffffffff) == -3) {
                            Class40_Sub5_Sub13
                                    .aClass40_Sub5_Sub14_Sub2Array2753[1]
                                    .method692(i_4_, -12 + i_3_);
                            i_4_ += 14;
                        }
                        class40_sub5_sub14_sub1.method690
                                ((Class40_Sub5_Sub17_Sub6.method832
                                                (-44,
                                                        new RSString[]{class1, ISAAC.aClass1_515,
                                                                (Class40_Sub5_Sub17_Sub4
                                                                        .aClass1Array3160[i_0_])})),
                                        i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.method690
                                ((Class40_Sub5_Sub17_Sub6.method832
                                                (56,
                                                        new RSString[]{class1, ISAAC.aClass1_515,
                                                                (Class40_Sub5_Sub17_Sub4
                                                                        .aClass1Array3160[i_0_])})),
                                        i_4_, -1 + i_3_, 65535);
                        if (i >= 5)
                            return;
                    }
                    if (i_2_ == 5 && Class4.anInt185 < 2) {
                        int i_5_ = -(i * 13) + 329;
                        i++;
                        class40_sub5_sub14_sub1.method690
                                (Class40_Sub5_Sub17_Sub4.aClass1Array3160[i_0_], 4,
                                        i_5_, 0);
                        class40_sub5_sub14_sub1.method690
                                (Class40_Sub5_Sub17_Sub4.aClass1Array3160[i_0_], 4,
                                        i_5_ - 1, 65535);
                        if ((i ^ 0xffffffff) <= -6)
                            return;
                    }
                    if ((i_2_ ^ 0xffffffff) == -7 && Class4.anInt185 < 2) {
                        int i_6_ = -(13 * i) + 329;
                        i++;
                        class40_sub5_sub14_sub1.method690
                                ((Class40_Sub5_Sub17_Sub6.method832
                                                (-58,
                                                        new RSString[]{Class40_Sub5_Sub1.aClass1_2274,
                                                                Class48.aClass1_1123, class1,
                                                                ISAAC.aClass1_515,
                                                                (Class40_Sub5_Sub17_Sub4
                                                                        .aClass1Array3160[i_0_])})),
                                        4, i_6_, 0);
                        class40_sub5_sub14_sub1.method690
                                ((Class40_Sub5_Sub17_Sub6.method832
                                                (-81,
                                                        new RSString[]{Class40_Sub5_Sub1.aClass1_2274,
                                                                Class48.aClass1_1123, class1,
                                                                ISAAC.aClass1_515,
                                                                (Class40_Sub5_Sub17_Sub4
                                                                        .aClass1Array3160[i_0_])})),
                                        4, i_6_ + -1, 65535);
                        if ((i ^ 0xffffffff) <= -6)
                            return;
                    }
                }
            }
            if (arg0 != 4)
                method238(-13);
        }
    }
}
