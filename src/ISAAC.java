/* Class20 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class ISAAC {
    public static int anInt499;
    public static int anInt500;
    public static int anInt501;
    public static int anInt503;
    public static int anInt504;
    public static boolean aBoolean505 = false;
    public static RSString aClass1_506
            = Class58.method978(-11538, "titlebutton");
    public static int anInt507;
    public static int anInt509 = 0;
    public static Cache aClass9_510 = new Cache(64);
    public static boolean aBoolean512;
    public static int anInt514;
    public static RSString aClass1_515 = Class58.method978(-11538, ": ");
    public static Cache aClass9_516;
    public static RSString aClass1_517;
    public static RSString aClass1_518;
    public static boolean aBoolean519 = true;
    public static int anInt520;
    public static Signlink aClass31_521;
    public static int anInt522;
    public static RSString aClass1_523;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_524;
    public static int anInt525;
    public static RSString aClass1_526;
    public static RSString aClass1_527;
    public static int[] anIntArray528;
    public static RSString aClass1_529;

    static {
        aClass1_517 = Class58.method978(-11538, "Gegenstand f-Ur Mitglieder");
        anInt522 = -1;
        aClass1_518
                = Class58.method978(-11538, "Invalid username or password)3");
        aClass1_526 = aClass1_518;
        aClass1_527 = Class58.method978(-11538, "blinken3:");
        aClass1_523
                = Class58.method978(-11538,
                "oberen Rand der Webseite ausw-=hlen)3");
        aClass9_516 = new Cache(64);
        aClass1_529
                = Class58.method978(-11538,
                "Begeben Sie sich in ein freies Gebiet)1 um");
    }

    public int anInt497;
    public int anInt498;
    public int anInt502;
    public int[] anIntArray508;
    public int[] anIntArray511;
    public int anInt513;

    public ISAAC(int[] arg0) {
        try {
            anIntArray511 = new int[256];
            anIntArray508 = new int[256];
            for (int i = 0; arg0.length > i; i++)
                anIntArray508[i] = arg0[i];
            method287(true);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "gb.<init>(" + (arg0 != null ? "{...}"
                            : "null") + ')');
        }
    }

    public static void method281(Class2 arg0, int arg1, Class3[] arg2) {
        try {
            for (int i = 0; (i ^ 0xffffffff) > -5; i++) {
                for (int i_0_ = 0; (i_0_ ^ 0xffffffff) > -105; i_0_++) {
                    for (int i_1_ = 0; i_1_ < 104; i_1_++) {
                        if ((0x1 & (Floor.aByteArrayArrayArray2323
                                [i][i_0_][i_1_]))
                                == 1) {
                            int i_2_ = i;
                            if ((0x2 & (Floor
                                    .aByteArrayArrayArray2323[1][i_0_]
                                    [i_1_])
                                    ^ 0xffffffff)
                                    == -3)
                                i_2_--;
                            if ((i_2_ ^ 0xffffffff) <= -1)
                                arg2[i_2_].method151((byte) -28, i_1_, i_0_);
                        }
                    }
                }
            }
            Class40_Sub5_Sub15.anInt2791 += (int) (5.0 * Math.random()) + -2;
            Class40_Sub5_Sub17_Sub4.anInt3151
                    += -2 + (int) (5.0 * Math.random());
            anInt504++;
            if ((Class40_Sub5_Sub15.anInt2791 ^ 0xffffffff) > 7)
                Class40_Sub5_Sub15.anInt2791 = -8;
            if (Class40_Sub5_Sub15.anInt2791 > 8)
                Class40_Sub5_Sub15.anInt2791 = 8;
            if ((Class40_Sub5_Sub17_Sub4.anInt3151 ^ 0xffffffff) > 15)
                Class40_Sub5_Sub17_Sub4.anInt3151 = -16;
            if ((Class40_Sub5_Sub17_Sub4.anInt3151 ^ 0xffffffff) < -17)
                Class40_Sub5_Sub17_Sub4.anInt3151 = 16;
            for (int i = 0; i < 4; i++) {
                byte[][] is = Class19.aByteArrayArrayArray492[i];
                int i_3_ = (int) Math.sqrt(5100.0);
                int i_4_ = i_3_ * 768 >> 1067645288;
                for (int i_5_ = 1; (i_5_ ^ 0xffffffff) > -104; i_5_++) {
                    for (int i_6_ = 1; i_6_ < 103; i_6_++) {
                        int i_7_ = (-(Class40_Sub6.anIntArrayArrayArray2099[i]
                                [i_6_ - 1][i_5_])
                                + (Class40_Sub6.anIntArrayArrayArray2099[i]
                                [1 + i_6_][i_5_]));
                        int i_8_ = ((Class40_Sub6.anIntArrayArrayArray2099[i]
                                [i_6_][i_5_ - -1])
                                + -(Class40_Sub6.anIntArrayArrayArray2099
                                [i][i_6_][i_5_ + -1]));
                        int i_9_ = (int) Math.sqrt((double) (i_8_ * i_8_
                                + i_7_ * i_7_
                                + 65536));
                        int i_10_ = 65536 / i_9_;
                        int i_11_ = ((is[i_6_][i_5_] >> -552359871)
                                + ((is[i_6_][-1 + i_5_] >> -723267166)
                                + (is[1 + i_6_][i_5_] >> -2018462045)
                                + (is[i_6_ - 1][i_5_] >> -175607742)
                                + (is[i_6_][1 + i_5_] >> -178577309)));
                        int i_12_ = (i_7_ << 705744584) / i_9_;
                        int i_13_ = (i_8_ << -882987384) / i_9_;
                        int i_14_ = 96 + (i_12_ * -50 - -(-10 * i_10_)
                                + i_13_ * -50) / i_4_;
                        Class40_Sub5_Sub7.anIntArrayArray2490[i_6_][i_5_]
                                = i_14_ + -i_11_;
                    }
                }
                for (int i_15_ = 0; i_15_ < 104; i_15_++) {
                    Class40_Sub5_Sub17_Sub6.anIntArray3250[i_15_] = 0;
                    Class59.anIntArray1398[i_15_] = 0;
                    Class40_Sub4.anIntArray2048[i_15_] = 0;
                    Class67.anIntArray1579[i_15_] = 0;
                    Class25.anIntArray612[i_15_] = 0;
                }
                for (int i_16_ = -5; i_16_ < 109; i_16_++) {
                    for (int i_17_ = 0; (i_17_ ^ 0xffffffff) > -105; i_17_++) {
                        int i_18_ = 5 + i_16_;
                        if ((i_18_ ^ 0xffffffff) <= -1
                                && (i_18_ ^ 0xffffffff) > -105) {
                            int i_19_ = 0xff & (Class42.aByteArrayArrayArray993
                                    [i][i_18_][i_17_]);
                            if ((i_19_ ^ 0xffffffff) < -1) {
                                Class40_Sub5_Sub9 class40_sub5_sub9
                                        = Class40_Sub3.method531((byte) -66,
                                        i_19_ - 1);
                                Class40_Sub5_Sub17_Sub6.anIntArray3250[i_17_]
                                        += class40_sub5_sub9.anInt2565;
                                Class59.anIntArray1398[i_17_]
                                        += class40_sub5_sub9.anInt2574;
                                Class40_Sub4.anIntArray2048[i_17_]
                                        += class40_sub5_sub9.anInt2563;
                                Class67.anIntArray1579[i_17_]
                                        += class40_sub5_sub9.anInt2568;
                                Class25.anIntArray612[i_17_]++;
                            }
                        }
                        int i_20_ = i_16_ - 5;
                        if ((i_20_ ^ 0xffffffff) <= -1
                                && (i_20_ ^ 0xffffffff) > -105) {
                            int i_21_ = 0xff & (Class42.aByteArrayArrayArray993
                                    [i][i_20_][i_17_]);
                            if ((i_21_ ^ 0xffffffff) < -1) {
                                Class40_Sub5_Sub9 class40_sub5_sub9
                                        = Class40_Sub3.method531((byte) -95,
                                        -1 + i_21_);
                                Class40_Sub5_Sub17_Sub6.anIntArray3250[i_17_]
                                        -= class40_sub5_sub9.anInt2565;
                                Class59.anIntArray1398[i_17_]
                                        -= class40_sub5_sub9.anInt2574;
                                Class40_Sub4.anIntArray2048[i_17_]
                                        -= class40_sub5_sub9.anInt2563;
                                Class67.anIntArray1579[i_17_]
                                        -= class40_sub5_sub9.anInt2568;
                                Class25.anIntArray612[i_17_]--;
                            }
                        }
                    }
                    if (i_16_ >= 1 && i_16_ < 103) {
                        int i_22_ = 0;
                        int i_23_ = 0;
                        int i_24_ = 0;
                        int i_25_ = 0;
                        int i_26_ = 0;
                        for (int i_27_ = -5; i_27_ < 109; i_27_++) {
                            int i_28_ = i_27_ - -5;
                            int i_29_ = i_27_ + -5;
                            if (i_28_ >= 0 && i_28_ < 104) {
                                i_26_ += Class67.anIntArray1579[i_28_];
                                i_23_ += Class59.anIntArray1398[i_28_];
                                i_25_ += Class25.anIntArray612[i_28_];
                                i_24_ += Class40_Sub4.anIntArray2048[i_28_];
                                i_22_ += (Class40_Sub5_Sub17_Sub6
                                        .anIntArray3250[i_28_]);
                            }
                            if ((i_29_ ^ 0xffffffff) <= -1 && i_29_ < 104) {
                                i_23_ -= Class59.anIntArray1398[i_29_];
                                i_25_ -= Class25.anIntArray612[i_29_];
                                i_24_ -= Class40_Sub4.anIntArray2048[i_29_];
                                i_26_ -= Class67.anIntArray1579[i_29_];
                                i_22_ -= (Class40_Sub5_Sub17_Sub6
                                        .anIntArray3250[i_29_]);
                            }
                            if (i_27_ >= 1 && i_27_ < 103
                                    && (!Class46.aBoolean1112
                                    || (0x2 & (Floor
                                    .aByteArrayArrayArray2323[0]
                                    [i_16_][i_27_])
                                    ^ 0xffffffff) != -1
                                    || ((0x10 & (Floor
                                    .aByteArrayArrayArray2323[i]
                                    [i_16_][i_27_])
                                    ^ 0xffffffff) == -1
                                    && ((Class59.method986(i, i_27_, 0,
                                    i_16_)
                                    ^ 0xffffffff)
                                    == (Class40_Sub6.anInt2120
                                    ^ 0xffffffff))))) {
                                if ((i ^ 0xffffffff)
                                        > (Class64.anInt1529 ^ 0xffffffff))
                                    Class64.anInt1529 = i;
                                int i_30_ = ((Class42.aByteArrayArrayArray993
                                        [i][i_16_][i_27_])
                                        & 0xff);
                                int i_31_ = ((Class62.aByteArrayArrayArray1473
                                        [i][i_16_][i_27_])
                                        & 0xff);
                                if (i_30_ > 0 || (i_31_ ^ 0xffffffff) < -1) {
                                    int i_32_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099[i]
                                            [i_16_][i_27_]);
                                    int i_33_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099[i]
                                            [i_16_ - -1][i_27_]);
                                    int i_34_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099[i]
                                            [i_16_ + 1][1 + i_27_]);
                                    int i_35_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099[i]
                                            [i_16_][i_27_ + 1]);
                                    int i_36_
                                            = (Class40_Sub5_Sub7
                                            .anIntArrayArray2490[i_16_][i_27_]);
                                    int i_37_ = (Class40_Sub5_Sub7
                                            .anIntArrayArray2490
                                            [i_16_ + 1][i_27_]);
                                    int i_38_ = (Class40_Sub5_Sub7
                                            .anIntArrayArray2490
                                            [i_16_ + 1][i_27_ - -1]);
                                    int i_39_ = -1;
                                    int i_40_ = (Class40_Sub5_Sub7
                                            .anIntArrayArray2490[i_16_]
                                            [i_27_ + 1]);
                                    int i_41_ = -1;
                                    if ((i_30_ ^ 0xffffffff) < -1) {
                                        int i_42_ = 256 * i_22_ / i_26_;
                                        int i_43_ = i_23_ / i_25_;
                                        int i_44_ = i_24_ / i_25_;
                                        i_39_
                                                = Class13.method244(i_43_, i_44_,
                                                arg1 + -27260,
                                                i_42_);
                                        i_44_ += (Class40_Sub5_Sub17_Sub4
                                                .anInt3151);
                                        i_42_ = i_42_ - -(Class40_Sub5_Sub15
                                                .anInt2791) & 0xff;
                                        if (i_44_ >= 0) {
                                            if (i_44_ > 255)
                                                i_44_ = 255;
                                        } else
                                            i_44_ = 0;
                                        i_41_ = Class13.method244(i_43_, i_44_,
                                                44, i_42_);
                                    }
                                    if ((i ^ 0xffffffff) < -1) {
                                        boolean bool = true;
                                        if (i_30_ == 0
                                                && ((Floor
                                                .aByteArrayArrayArray2335[i]
                                                [i_16_][i_27_])
                                                ^ 0xffffffff) != -1)
                                            bool = false;
                                        if (i_31_ > 0
                                                && !(NPC
                                                .loadFloor
                                                        (-1 + i_31_, arg1 + -27320)
                                                .aBoolean2338))
                                            bool = false;
                                        if (bool
                                                && ((i_33_ ^ 0xffffffff)
                                                == (i_32_ ^ 0xffffffff))
                                                && i_34_ == i_32_
                                                && ((i_35_ ^ 0xffffffff)
                                                == (i_32_ ^ 0xffffffff)))
                                            Class6.anIntArrayArrayArray262
                                                    [i][i_16_][i_27_]
                                                    = (Class40_Sub5_Sub9.method619
                                                    ((Class6
                                                                    .anIntArrayArrayArray262
                                                                    [i][i_16_][i_27_]),
                                                            2340));
                                    }
                                    int i_45_ = 0;
                                    if (i_41_ != -1)
                                        i_45_ = (R3D
                                                .anIntArray2932
                                                [(Class40_Sub5_Sub17_Sub6
                                                .method831
                                                        (i_41_, 96, (byte) 73))]);
                                    if (i_31_ != 0) {
                                        int i_46_
                                                = 1 + (Floor
                                                .aByteArrayArrayArray2335[i]
                                                [i_16_][i_27_]);
                                        byte i_47_
                                                = (Class35.aByteArrayArrayArray1745
                                                [i][i_16_][i_27_]);
                                        Floor class40_sub5_sub3
                                                = NPC
                                                .loadFloor(-1 + i_31_, 4);
                                        int i_48_
                                                = class40_sub5_sub3.anInt2322;
                                        int i_49_;
                                        int i_50_;
                                        if (i_48_ >= 0) {
                                            i_49_ = -1;
                                            i_50_ = R3D
                                                    .anInterface3_2939
                                                    .method14(true, i_48_);
                                        } else if (class40_sub5_sub3.anInt2345
                                                != 16711935) {
                                            i_49_ = (Class13.method244
                                                    ((class40_sub5_sub3
                                                                    .anInt2337),
                                                            (class40_sub5_sub3
                                                                    .anInt2320),
                                                            -120,
                                                            (class40_sub5_sub3
                                                                    .anInt2332)));
                                            int i_51_
                                                    = (Class40_Sub5_Sub15.anInt2791
                                                    + (class40_sub5_sub3
                                                    .anInt2332)) & 0xff;
                                            int i_52_
                                                    = ((Class40_Sub5_Sub17_Sub4
                                                    .anInt3151)
                                                    + (class40_sub5_sub3
                                                    .anInt2320));
                                            if ((i_52_ ^ 0xffffffff) > -1)
                                                i_52_ = 0;
                                            else if ((i_52_ ^ 0xffffffff)
                                                    < -256)
                                                i_52_ = 255;
                                            i_50_ = (Class13.method244
                                                    ((class40_sub5_sub3
                                                                    .anInt2337),
                                                            i_52_, arg1 ^ ~0x6acb,
                                                            i_51_));
                                        } else {
                                            i_49_ = -2;
                                            i_48_ = -1;
                                            i_50_ = -2;
                                        }
                                        int i_53_ = 0;
                                        if (i_50_ != -2)
                                            i_53_
                                                    = (R3D
                                                    .anIntArray2932
                                                    [Class34.method420(i_50_,
                                                    96,
                                                    true)]);
                                        if (class40_sub5_sub3.anInt2336
                                                != -1) {
                                            int i_54_
                                                    = 0xff & ((Class40_Sub5_Sub15
                                                    .anInt2791)
                                                    + (class40_sub5_sub3
                                                    .anInt2334));
                                            int i_55_
                                                    = (class40_sub5_sub3.anInt2330
                                                    + (Class40_Sub5_Sub17_Sub4
                                                    .anInt3151));
                                            if ((i_55_ ^ 0xffffffff) <= -1) {
                                                if (i_55_ > 255)
                                                    i_55_ = 255;
                                            } else
                                                i_55_ = 0;
                                            i_50_ = (Class13.method244
                                                    ((class40_sub5_sub3
                                                                    .anInt2346),
                                                            i_55_, arg1 + -27445,
                                                            i_54_));
                                            i_53_
                                                    = (R3D
                                                    .anIntArray2932
                                                    [Class34.method420(i_50_,
                                                    96,
                                                    true)]);
                                        }
                                        arg0.method99
                                                (i, i_16_, i_27_, i_46_, i_47_,
                                                        i_48_, i_32_, i_33_, i_34_, i_35_,
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_36_, (byte) 73)),
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_37_, (byte) 73)),
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_38_, (byte) 73)),
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_40_, (byte) 73)),
                                                        Class34.method420(i_49_, i_36_,
                                                                true),
                                                        Class34.method420(i_49_, i_37_,
                                                                true),
                                                        Class34.method420(i_49_, i_38_,
                                                                true),
                                                        Class34.method420(i_49_, i_40_,
                                                                true),
                                                        i_45_, i_53_);
                                    } else
                                        arg0.method99
                                                (i, i_16_, i_27_, 0, 0, -1, i_32_,
                                                        i_33_, i_34_, i_35_,
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_36_, (byte) 73)),
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_37_, (byte) 73)),
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_38_, (byte) 73)),
                                                        (Class40_Sub5_Sub17_Sub6.method831
                                                                (i_39_, i_40_, (byte) 73)),
                                                        0, 0, 0, 0, i_45_, 0);
                                }
                            }
                        }
                    }
                }
                for (int i_56_ = 1; i_56_ < 103; i_56_++) {
                    for (int i_57_ = 1; i_57_ < 103; i_57_++)
                        arg0.method130(i, i_57_, i_56_,
                                Class59.method986(i, i_56_, 0, i_57_));
                }
                Class42.aByteArrayArrayArray993[i] = null;
                Class62.aByteArrayArrayArray1473[i] = null;
                Floor.aByteArrayArrayArray2335[i] = null;
                Class35.aByteArrayArrayArray1745[i] = null;
                Class19.aByteArrayArrayArray492[i] = null;
            }
            arg0.method118(-50, -10, -50);
            for (int i = 0; (i ^ 0xffffffff) > -105; i++) {
                for (int i_58_ = 0; (i_58_ ^ 0xffffffff) > -105; i_58_++) {
                    if (((Floor.aByteArrayArrayArray2323[1][i]
                            [i_58_]) & 0x2
                            ^ 0xffffffff)
                            == -3)
                        arg0.method92(i, i_58_);
                }
            }
            int i = 1;
            int i_59_ = 2;
            int i_60_ = 4;
            if (arg1 != 27324)
                method281(null, 6, null);
            for (int i_61_ = 0; (i_61_ ^ 0xffffffff) > -5; i_61_++) {
                if ((i_61_ ^ 0xffffffff) < -1) {
                    i <<= 3;
                    i_60_ <<= 3;
                    i_59_ <<= 3;
                }
                for (int i_62_ = 0;
                     (i_62_ ^ 0xffffffff) >= (i_61_ ^ 0xffffffff); i_62_++) {
                    for (int i_63_ = 0; i_63_ <= 104; i_63_++) {
                        for (int i_64_ = 0; i_64_ <= 104; i_64_++) {
                            if (((Class6.anIntArrayArrayArray262[i_62_][i_64_]
                                    [i_63_]) & i
                                    ^ 0xffffffff)
                                    != -1) {
                                int i_65_;
                                for (i_65_ = i_63_;
                                     ((i_65_ ^ 0xffffffff) < -1
                                             && (i & (Class6.anIntArrayArrayArray262
                                             [i_62_][i_64_][-1 + i_65_])
                                             ^ 0xffffffff) != -1);
                                     i_65_--) {
                                    /* empty */
                                }
                                int i_66_;
                                for (i_66_ = i_63_;
                                     ((i_66_ ^ 0xffffffff) > -105
                                             && ((Class6.anIntArrayArrayArray262
                                             [i_62_][i_64_][i_66_ - -1])
                                             & i) != 0);
                                     i_66_++) {
                                    /* empty */
                                }
                                int i_67_ = i_62_;
                                int i_68_ = i_62_;
                                while_4_:
                                for (/**/; i_67_ > 0; i_67_--) {
                                    for (int i_69_ = i_65_;
                                         ((i_69_ ^ 0xffffffff)
                                                 >= (i_66_ ^ 0xffffffff));
                                         i_69_++) {
                                        if (((Class6.anIntArrayArrayArray262
                                                [-1 + i_67_][i_64_][i_69_]) & i
                                                ^ 0xffffffff)
                                                == -1)
                                            break while_4_;
                                    }
                                }
                                while_5_:
                                for (/**/; i_68_ < i_61_; i_68_++) {
                                    for (int i_70_ = i_65_;
                                         ((i_70_ ^ 0xffffffff)
                                                 >= (i_66_ ^ 0xffffffff));
                                         i_70_++) {
                                        if ((i
                                                & (Class6.anIntArrayArrayArray262
                                                [i_68_ - -1][i_64_][i_70_]))
                                                == 0)
                                            break while_5_;
                                    }
                                }
                                int i_71_ = ((-i_65_ + (i_66_ - -1))
                                        * (-i_67_ + (i_68_ + 1)));
                                if (i_71_ >= 8) {
                                    int i_72_ = 240;
                                    int i_73_
                                            = -i_72_ + (Class40_Sub6
                                            .anIntArrayArrayArray2099
                                            [i_68_][i_64_][i_65_]);
                                    int i_74_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099
                                            [i_67_][i_64_][i_65_]);
                                    Class2.method116(i_61_, 1, 128 * i_64_,
                                            128 * i_64_, 128 * i_65_,
                                            128 + 128 * i_66_, i_73_,
                                            i_74_);
                                    for (int i_75_ = i_67_;
                                         ((i_75_ ^ 0xffffffff)
                                                 >= (i_68_ ^ 0xffffffff));
                                         i_75_++) {
                                        for (int i_76_ = i_65_;
                                             ((i_76_ ^ 0xffffffff)
                                                     >= (i_66_ ^ 0xffffffff));
                                             i_76_++)
                                            Class6.anIntArrayArrayArray262
                                                    [i_75_][i_64_][i_76_]
                                                    = (Class66.method1021
                                                    ((Class6
                                                                    .anIntArrayArrayArray262
                                                                    [i_75_][i_64_][i_76_]),
                                                            i ^ 0xffffffff));
                                    }
                                }
                            }
                            if ((i_59_ & (Class6.anIntArrayArrayArray262[i_62_]
                                    [i_64_][i_63_]))
                                    != 0) {
                                int i_77_;
                                for (i_77_ = i_64_;
                                     (i_77_ > 0
                                             && (i_59_ & (Class6
                                             .anIntArrayArrayArray262
                                             [i_62_][i_77_ - 1][i_63_])
                                             ^ 0xffffffff) != -1);
                                     i_77_--) {
                                    /* empty */
                                }
                                int i_78_ = i_62_;
                                int i_79_ = i_64_;
                                int i_80_ = i_62_;
                                for (/**/; (i_79_ ^ 0xffffffff) > -105;
                                         i_79_++) {
                                    if ((i_59_
                                            & (Class6.anIntArrayArrayArray262
                                            [i_62_][1 + i_79_][i_63_]))
                                            == 0)
                                        break;
                                }
                                while_6_:
                                for (/**/; (i_80_ ^ 0xffffffff) < -1;
                                         i_80_--) {
                                    for (int i_81_ = i_77_; i_81_ <= i_79_;
                                         i_81_++) {
                                        if (((Class6.anIntArrayArrayArray262
                                                [i_80_ + -1][i_81_][i_63_])
                                                & i_59_)
                                                == 0)
                                            break while_6_;
                                    }
                                }
                                while_7_:
                                for (/**/; i_78_ < i_61_; i_78_++) {
                                    for (int i_82_ = i_77_;
                                         ((i_82_ ^ 0xffffffff)
                                                 >= (i_79_ ^ 0xffffffff));
                                         i_82_++) {
                                        if (((i_59_
                                                & (Class6.anIntArrayArrayArray262
                                                [1 + i_78_][i_82_][i_63_]))
                                                ^ 0xffffffff)
                                                == -1)
                                            break while_7_;
                                    }
                                }
                                int i_83_ = ((i_79_ - i_77_ - -1)
                                        * (-i_80_ + 1 + i_78_));
                                if (i_83_ >= 8) {
                                    int i_84_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099
                                            [i_80_][i_77_][i_63_]);
                                    int i_85_ = 240;
                                    int i_86_ = ((Class40_Sub6
                                            .anIntArrayArrayArray2099
                                            [i_78_][i_77_][i_63_])
                                            - i_85_);
                                    Class2.method116(i_61_, 2, 128 * i_77_,
                                            128 * i_79_ + 128,
                                            128 * i_63_, i_63_ * 128,
                                            i_86_, i_84_);
                                    for (int i_87_ = i_80_;
                                         ((i_78_ ^ 0xffffffff)
                                                 <= (i_87_ ^ 0xffffffff));
                                         i_87_++) {
                                        for (int i_88_ = i_77_; i_88_ <= i_79_;
                                             i_88_++)
                                            Class6.anIntArrayArrayArray262
                                                    [i_87_][i_88_][i_63_]
                                                    = (Class66.method1021
                                                    ((Class6
                                                                    .anIntArrayArrayArray262
                                                                    [i_87_][i_88_][i_63_]),
                                                            i_59_ ^ 0xffffffff));
                                    }
                                }
                            }
                            if (((Class6.anIntArrayArrayArray262[i_62_][i_64_]
                                    [i_63_]) & i_60_
                                    ^ 0xffffffff)
                                    != -1) {
                                int i_89_ = i_64_;
                                int i_90_ = i_64_;
                                int i_91_ = i_63_;
                                int i_92_ = i_63_;
                                for (/**/; (i_91_ ^ 0xffffffff) < -1;
                                         i_91_--) {
                                    if (((Class6.anIntArrayArrayArray262[i_62_]
                                            [i_64_][-1 + i_91_])
                                            & i_60_)
                                            == 0)
                                        break;
                                }
                                for (/**/; (i_92_ ^ 0xffffffff) > -105;
                                         i_92_++) {
                                    if ((i_60_ & (Class6
                                            .anIntArrayArrayArray262
                                            [i_62_][i_64_][i_92_ - -1])
                                            ^ 0xffffffff)
                                            == -1)
                                        break;
                                }
                                while_8_:
                                for (/**/; (i_89_ ^ 0xffffffff) < -1;
                                         i_89_--) {
                                    for (int i_93_ = i_91_; i_93_ <= i_92_;
                                         i_93_++) {
                                        if (((i_60_
                                                & (Class6.anIntArrayArrayArray262
                                                [i_62_][i_89_ + -1][i_93_]))
                                                ^ 0xffffffff)
                                                == -1)
                                            break while_8_;
                                    }
                                }
                                while_9_:
                                for (/**/; (i_90_ ^ 0xffffffff) > -105;
                                         i_90_++) {
                                    for (int i_94_ = i_91_;
                                         ((i_92_ ^ 0xffffffff)
                                                 <= (i_94_ ^ 0xffffffff));
                                         i_94_++) {
                                        if (((i_60_
                                                & (Class6.anIntArrayArrayArray262
                                                [i_62_][1 + i_90_][i_94_]))
                                                ^ 0xffffffff)
                                                == -1)
                                            break while_9_;
                                    }
                                }
                                if ((-i_89_ + i_90_ + 1) * (1 + i_92_ - i_91_)
                                        >= 4) {
                                    int i_95_ = (Class40_Sub6
                                            .anIntArrayArrayArray2099
                                            [i_62_][i_89_][i_91_]);
                                    Class2.method116(i_61_, 4, i_89_ * 128,
                                            i_90_ * 128 + 128,
                                            128 * i_91_,
                                            i_92_ * 128 + 128, i_95_,
                                            i_95_);
                                    for (int i_96_ = i_89_;
                                         ((i_96_ ^ 0xffffffff)
                                                 >= (i_90_ ^ 0xffffffff));
                                         i_96_++) {
                                        for (int i_97_ = i_91_;
                                             ((i_92_ ^ 0xffffffff)
                                                     <= (i_97_ ^ 0xffffffff));
                                             i_97_++)
                                            Class6.anIntArrayArrayArray262
                                                    [i_62_][i_96_][i_97_]
                                                    = (Class66.method1021
                                                    ((Class6
                                                                    .anIntArrayArrayArray262
                                                                    [i_62_][i_96_][i_97_]),
                                                            i_60_ ^ 0xffffffff));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("gb.A(" + (arg0 != null ? "{...}" : "null")
                            + ',' + arg1 + ','
                            + (arg2 != null ? "{...}" : "null")
                            + ')'));
        }
    }

    public static void method282(boolean arg0) {
        try {
            aClass1_529 = null;
            aClass1_515 = null;
            aClass1_518 = null;
            aClass1_526 = null;
            aClass40_Sub5_Sub14_Sub2_524 = null;
            aClass1_506 = null;
            aClass9_510 = null;
            aClass1_527 = null;
            aClass9_516 = null;
            aClass1_523 = null;
            if (arg0 == true) {
                aClass31_521 = null;
                anIntArray528 = null;
                aClass1_517 = null;
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "gb.B(" + arg0 + ')');
        }
    }

    public static void method283(long arg0, int arg1) {
        try {
            try {
                int i = -93 / ((-50 - arg1) / 45);
                Thread.sleep(arg0);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
            anInt507++;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "gb.C(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method285(byte arg0) {
        try {
            anInt514++;
            if (arg0 != 118)
                aBoolean519 = true;
            for (Class40_Sub3 class40_sub3
                 = ((Class40_Sub3)
                    Class45.aClass45_1064.method902((byte) -90));
                 class40_sub3 != null;
                 class40_sub3
                         = (Class40_Sub3) Class45.aClass45_1064.method909(-4)) {
                if ((class40_sub3.anInt2031 ^ 0xffffffff) != 0)
                    class40_sub3.method457(arg0 ^ ~0x76);
                else {
                    class40_sub3.anInt2033 = 0;
                    Class39.method451(class40_sub3, 19813);
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "gb.G(" + arg0 + ')');
        }
    }

    public static int method288(byte arg0) {
        try {
            if (arg0 < 117)
                method288((byte) 125);
            anInt500++;
            return 5;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "gb.F(" + arg0 + ')');
        }
    }

    public void method284(byte arg0) {
        try {
            anInt513 += ++anInt502;
            anInt501++;
            int i = -29 % ((arg0 - -18) / 58);
            for (int i_98_ = 0; (i_98_ ^ 0xffffffff) > -257; i_98_++) {
                int i_99_ = anIntArray511[i_98_];
                if ((i_98_ & 0x2) == 0) {
                    if ((0x1 & i_98_) == 0)
                        anInt498 ^= anInt498 << -1775138835;
                    else
                        anInt498 ^= anInt498 >>> -249040506;
                } else if ((i_98_ & 0x1) != 0)
                    anInt498 ^= anInt498 >>> 2020813872;
                else
                    anInt498 ^= anInt498 << -154663678;
                anInt498 += anIntArray511[0xff & 128 + i_98_];
                int i_100_;
                anIntArray511[i_98_] = i_100_
                        = anIntArray511[(Class66.method1021(i_99_, 1020)
                        >> 107120354)] + (anInt498 + anInt513);
                anIntArray508[i_98_] = anInt513
                        = (i_99_
                        + anIntArray511[Class66.method1021((i_100_ >> -488567000
                                >> -1522276318),
                        255)]);
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "gb.D(" + arg0 + ')');
        }
    }

    public int method286(int arg0) {
        try {
            anInt520++;
            if (arg0 > -54)
                return -67;
            if (anInt497-- == 0) {
                method284((byte) -92);
                anInt497 = 255;
            }
            return anIntArray508[anInt497];
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "gb.E(" + arg0 + ')');
        }
    }

    public void method287(boolean arg0) {
        try {
            anInt503++;
            int i_101_;
            int i_102_;
            int i_103_;
            int i_104_;
            int i_105_;
            int i_106_;
            int i_107_;
            int i = (i_101_ = i_102_ = i_103_ = i_104_ = i_105_ = i_106_
                    = i_107_ = -1640531527);
            for (int i_108_ = 0; i_108_ < 4; i_108_++) {
                i ^= i_101_ << -1915247189;
                i_103_ += i;
                i_101_ += i_102_;
                i_101_ ^= i_102_ >>> -1129151966;
                i_102_ += i_103_;
                i_102_ ^= i_103_ << -900908184;
                i_105_ += i_102_;
                i_104_ += i_101_;
                i_103_ += i_104_;
                i_103_ ^= i_104_ >>> 1581552336;
                i_106_ += i_103_;
                i_104_ += i_105_;
                i_104_ ^= i_105_ << 1384803626;
                i_107_ += i_104_;
                i_105_ += i_106_;
                i_105_ ^= i_106_ >>> -1750417532;
                i_106_ += i_107_;
                i_106_ ^= i_107_ << 1936636392;
                i_101_ += i_106_;
                i += i_105_;
                i_107_ += i;
                i_107_ ^= i >>> 166072873;
                i_102_ += i_107_;
                i += i_101_;
            }
            for (int i_109_ = 0; i_109_ < 256; i_109_ += 8) {
                i_107_ += anIntArray508[7 + i_109_];
                i_103_ += anIntArray508[3 + i_109_];
                i += anIntArray508[i_109_];
                i_101_ += anIntArray508[i_109_ + 1];
                i_104_ += anIntArray508[4 + i_109_];
                i_106_ += anIntArray508[i_109_ + 6];
                i_105_ += anIntArray508[5 + i_109_];
                i_102_ += anIntArray508[2 + i_109_];
                i ^= i_101_ << -790042005;
                i_103_ += i;
                i_101_ += i_102_;
                i_101_ ^= i_102_ >>> 1388196098;
                i_104_ += i_101_;
                i_102_ += i_103_;
                i_102_ ^= i_103_ << 1436572424;
                i_103_ += i_104_;
                i_105_ += i_102_;
                i_103_ ^= i_104_ >>> -835938960;
                i_104_ += i_105_;
                i_106_ += i_103_;
                i_104_ ^= i_105_ << -2084310486;
                i_107_ += i_104_;
                i_105_ += i_106_;
                i_105_ ^= i_106_ >>> -1146757436;
                i_106_ += i_107_;
                i += i_105_;
                i_106_ ^= i_107_ << 603045960;
                i_107_ += i;
                i_101_ += i_106_;
                i_107_ ^= i >>> -1011620151;
                i += i_101_;
                i_102_ += i_107_;
                anIntArray511[i_109_] = i;
                anIntArray511[i_109_ - -1] = i_101_;
                anIntArray511[i_109_ - -2] = i_102_;
                anIntArray511[3 + i_109_] = i_103_;
                anIntArray511[i_109_ + 4] = i_104_;
                anIntArray511[i_109_ - -5] = i_105_;
                anIntArray511[i_109_ + 6] = i_106_;
                anIntArray511[7 + i_109_] = i_107_;
            }
            int i_110_ = 0;
            if (arg0 != true)
                aClass9_516 = null;
            for (/**/; (i_110_ ^ 0xffffffff) > -257; i_110_ += 8) {
                i_107_ += anIntArray511[7 + i_110_];
                i_106_ += anIntArray511[i_110_ - -6];
                i_102_ += anIntArray511[2 + i_110_];
                i_103_ += anIntArray511[3 + i_110_];
                i_105_ += anIntArray511[i_110_ - -5];
                i += anIntArray511[i_110_];
                i_104_ += anIntArray511[4 + i_110_];
                i_101_ += anIntArray511[i_110_ - -1];
                i ^= i_101_ << 105759243;
                i_103_ += i;
                i_101_ += i_102_;
                i_101_ ^= i_102_ >>> 1456202018;
                i_102_ += i_103_;
                i_102_ ^= i_103_ << -2127856632;
                i_105_ += i_102_;
                i_104_ += i_101_;
                i_103_ += i_104_;
                i_103_ ^= i_104_ >>> 1872814192;
                i_106_ += i_103_;
                i_104_ += i_105_;
                i_104_ ^= i_105_ << -224288950;
                i_107_ += i_104_;
                i_105_ += i_106_;
                i_105_ ^= i_106_ >>> 206611140;
                i += i_105_;
                i_106_ += i_107_;
                i_106_ ^= i_107_ << 1636820520;
                i_107_ += i;
                i_107_ ^= i >>> 1387696009;
                i_101_ += i_106_;
                i += i_101_;
                i_102_ += i_107_;
                anIntArray511[i_110_] = i;
                anIntArray511[1 + i_110_] = i_101_;
                anIntArray511[i_110_ - -2] = i_102_;
                anIntArray511[3 + i_110_] = i_103_;
                anIntArray511[i_110_ - -4] = i_104_;
                anIntArray511[i_110_ - -5] = i_105_;
                anIntArray511[i_110_ - -6] = i_106_;
                anIntArray511[7 + i_110_] = i_107_;
            }
            method284((byte) -90);
            anInt497 = 256;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "gb.H(" + arg0 + ')');
        }
    }
}
