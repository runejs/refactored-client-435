/* Class30 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class30 {
    public static int[] anIntArray680;
    public static int anInt681;
    public static RSString aClass1_682;
    public static int[] anIntArray684;
    public static int[] anIntArray685;
    public static RSString aClass1_686 = Class58.method978(-11538, "*6n");
    public static boolean aBoolean687;
    public static int[] anIntArray688;
    public static int anInt689;
    public static int anInt690;
    public static int anInt691;
    public static Class67 aClass67_693;
    public static int anInt694;
    public static int[] anIntArray695;
    public static RSString[] aClass1Array697;
    public static RSString aClass1_698;
    public static RSString aClass1_699;
    public static int anInt700;
    public static RSString aClass1_701;
    public static int anInt702;
    public static int anInt703;
    public static int anInt704 = 0;
    public static int anInt705;
    public static int anInt706;
    public static int anInt707;
    public static int anInt708;
    public static int anInt709;
    public static RSString aClass1_710;
    public static int anInt711;
    public static int[] anIntArray712;
    public static Class68 aClass68_714;
    public static int[] anIntArray715;
    public static RSString aClass1_716;
    public static Class64 aClass64_717;

    static {
        aClass1_699 = Class58.method978(-11538, "Trade)4compete");
        aClass1_701 = aClass1_699;
        aClass1_710 = Class58.method978(-11538, "Off");
        anInt709 = 50;
        anIntArray712 = new int[anInt709];
        anIntArray684 = new int[anInt709];
        anIntArray680 = new int[anInt709];
        anIntArray715 = new int[anInt709];
        aClass1_682 = aClass1_710;
        anIntArray688 = new int[anInt709];
        aClass1_698 = Class58.method978(-11538, "(U(Y");
        anIntArray695 = new int[anInt709];
        anInt708 = -1;
        anIntArray685 = new int[anInt709];
        aClass1Array697 = new RSString[anInt709];
        aClass1_716 = Class58.method978(-11538, "scape main");
    }

    public boolean aBoolean683;
    public int[] anIntArray692;
    public int anInt696;
    public int[] anIntArray713;
    public long aLong718;
    public long aLong719;

    public static void method376(int arg0) {
        try {
            anIntArray712 = null;
            anIntArray688 = null;
            aClass64_717 = null;
            if (arg0 != 13429)
                method381(-90, null);
            anIntArray695 = null;
            anIntArray685 = null;
            anIntArray715 = null;
            aClass1_686 = null;
            aClass1_710 = null;
            aClass1Array697 = null;
            aClass67_693 = null;
            aClass1_699 = null;
            anIntArray684 = null;
            anIntArray680 = null;
            aClass68_714 = null;
            aClass1_701 = null;
            aClass1_682 = null;
            aClass1_698 = null;
            aClass1_716 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "la.H(" + arg0 + ')');
        }
    }

    public static void method381(int arg0, Class40_Sub5_Sub17_Sub4 arg1) {
        try {
            if (arg0 != 22378)
                method376(90);
            if ((arg1.anInt3107 ^ 0xffffffff) == (Node.anInt926
                    ^ 0xffffffff)
                    || (arg1.anInt3141 ^ 0xffffffff) == 0
                    || (arg1.anInt3122 ^ 0xffffffff) != -1
                    || arg1.anInt3115 - -1 > (Class68_Sub1.method1050
                    (arg1.anInt3141, 2).anIntArray2466
                    [arg1.anInt3104])) {
                int i = -arg1.anInt3112 + arg1.anInt3107;
                int i_16_ = -arg1.anInt3112 + Node.anInt926;
                int i_17_ = arg1.anInt3125 * 128 - -(64 * arg1.anInt3096);
                int i_18_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3081;
                int i_19_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3099;
                int i_20_ = 128 * arg1.anInt3127 + arg1.anInt3096 * 64;
                arg1.anInt3098 = ((i - i_16_) * i_17_ + i_16_ * i_19_) / i;
                arg1.anInt3089 = (i_18_ * (i + -i_16_) + i_16_ * i_20_) / i;
            }
            if (arg1.anInt3073 == 0)
                arg1.anInt3080 = 1024;
            anInt700++;
            arg1.anInt3074 = 0;
            if ((arg1.anInt3073 ^ 0xffffffff) == -2)
                arg1.anInt3080 = 1536;
            if ((arg1.anInt3073 ^ 0xffffffff) == -3)
                arg1.anInt3080 = 0;
            if (arg1.anInt3073 == 3)
                arg1.anInt3080 = 512;
            arg1.anInt3118 = arg1.anInt3080;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("la.J(" + arg0 + ','
                            + (arg1 != null ? "{...}" : "null")
                            + ')'));
        }
    }

    public int method374(int arg0) {
        try {
            anInt702++;
            if (arg0 != -20874)
                return 109;
            if ((anInt696 ^ 0xffffffff) != 0)
                return (Landscape.method932((byte) -105, anInt696).anInt2427
                        + 305419896);
            return (anIntArray692[1] + (anIntArray692[11] << -991626235)
                    + ((anIntArray713[4] << -1350296556)
                    + ((anIntArray713[0] << 1525506553)
                    - -(anIntArray692[0] << 1592541583))
                    - -(anIntArray692[8] << 307187338)));
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "la.K(" + arg0 + ')');
        }
    }

    public void method375(int arg0, Buffer arg1) {
        try {
            arg1.put(aBoolean683 ? 1 : 0, (byte) -128);
            anInt706++;
            for (int i = arg0; i < 7; i++) {
                int i_0_ = anIntArray692[Class40_Sub5_Sub15.anIntArray2777[i]];
                if ((i_0_ ^ 0xffffffff) != -1)
                    arg1.put(-256 + i_0_, (byte) -128);
                else
                    arg1.put(-1, (byte) -128);
            }
            for (int i = 0; (i ^ 0xffffffff) > -6; i++)
                arg1.put(anIntArray713[i], (byte) -128);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("la.B(" + arg0 + ','
                            + (arg1 != null ? "{...}" : "null")
                            + ')'));
        }
    }

    public Model method377(Class40_Sub5_Sub7 arg0,
                           Class40_Sub5_Sub7 arg1, int arg2,
                           int arg3, byte arg4) {
        try {
            anInt694++;
            if ((anInt696 ^ 0xffffffff) != 0)
                return Landscape.method932((byte) -101, anInt696)
                        .method568((byte) -50, arg0, arg1, arg2, arg3);
            long l = aLong718;
            int[] is = anIntArray692;
            if (arg0 != null && ((arg0.anInt2477 ^ 0xffffffff) <= -1
                    || arg0.anInt2489 >= 0)) {
                is = new int[12];
                for (int i = 0; i < 12; i++)
                    is[i] = anIntArray692[i];
                if (arg0.anInt2477 >= 0) {
                    l += (long) (arg0.anInt2477 + -anIntArray692[5]
                            << 535923240);
                    is[5] = arg0.anInt2477;
                }
                if (arg0.anInt2489 >= 0) {
                    l += (long) (arg0.anInt2489 + -anIntArray692[3]
                            << -1236609968);
                    is[3] = arg0.anInt2489;
                }
            }
            if (arg4 >= -84)
                return null;
            Model class40_sub5_sub17_sub5
                    = ((Model)
                    Class6.aClass9_229.method231(l, (byte) 66));
            if (class40_sub5_sub17_sub5 == null) {
                boolean bool = false;
                for (int i = 0; i < 12; i++) {
                    int i_1_ = is[i];
                    if ((i_1_ ^ 0xffffffff) <= -257 && i_1_ < 512
                            && !Buffer.method501((byte) -94, -256 + i_1_)
                            .method623(true))
                        bool = true;
                    if (i_1_ >= 512
                            && !Class44.method897(i_1_ + -512, 10)
                            .method739(aBoolean683, (byte) 127))
                        bool = true;
                }
                if (bool) {
                    if (aLong719 != -1L)
                        class40_sub5_sub17_sub5
                                = ((Model)
                                Class6.aClass9_229.method231(aLong719,
                                        (byte) 123));
                    if (class40_sub5_sub17_sub5 == null)
                        return null;
                }
                if (class40_sub5_sub17_sub5 == null) {
                    Model[] class40_sub5_sub17_sub5s
                            = new Model[12];
                    int i = 0;
                    for (int i_2_ = 0; i_2_ < 12; i_2_++) {
                        int i_3_ = is[i_2_];
                        if (i_3_ >= 256 && (i_3_ ^ 0xffffffff) > -513) {
                            Model class40_sub5_sub17_sub5_4_
                                    = Buffer.method501
                                    ((byte) -94, i_3_ + -256)
                                    .method630(false);
                            if (class40_sub5_sub17_sub5_4_ != null)
                                class40_sub5_sub17_sub5s[i++]
                                        = class40_sub5_sub17_sub5_4_;
                        }
                        if ((i_3_ ^ 0xffffffff) <= -513) {
                            Model class40_sub5_sub17_sub5_5_
                                    = Class44.method897(i_3_ - 512, 10)
                                    .method740(aBoolean683, -32);
                            if (class40_sub5_sub17_sub5_5_ != null)
                                class40_sub5_sub17_sub5s[i++]
                                        = class40_sub5_sub17_sub5_5_;
                        }
                    }
                    class40_sub5_sub17_sub5
                            = new Model(class40_sub5_sub17_sub5s,
                            i);
                    for (int i_6_ = 0; (i_6_ ^ 0xffffffff) > -6; i_6_++) {
                        if (anIntArray713[i_6_] != 0) {
                            class40_sub5_sub17_sub5.method803
                                    ((Class40_Sub5_Sub17_Sub6.anIntArrayArray3238
                                                    [i_6_][0]),
                                            (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238
                                                    [i_6_][anIntArray713[i_6_]]));
                            if (i_6_ == 1)
                                class40_sub5_sub17_sub5.method803
                                        (Class35.anIntArray1738[0],
                                                (Class35.anIntArray1738
                                                        [anIntArray713[i_6_]]));
                        }
                    }
                    class40_sub5_sub17_sub5.method810();
                    class40_sub5_sub17_sub5.method802(64, 850, -30, -50, -30,
                            true);
                    Class6.aClass9_229.method230(-7208, l,
                            class40_sub5_sub17_sub5);
                    aLong719 = l;
                }
            }
            Model class40_sub5_sub17_sub5_7_;
            if (arg0 != null || arg1 != null) {
                if (arg0 == null || arg1 == null) {
                    if (arg0 == null)
                        class40_sub5_sub17_sub5_7_
                                = arg1.method599(arg2, class40_sub5_sub17_sub5,
                                false);
                    else
                        class40_sub5_sub17_sub5_7_
                                = arg0.method599(arg3, class40_sub5_sub17_sub5,
                                false);
                } else
                    class40_sub5_sub17_sub5_7_
                            = arg0.method590(class40_sub5_sub17_sub5, arg1, arg3,
                            arg2, (byte) 63);
            } else
                return class40_sub5_sub17_sub5;
            return class40_sub5_sub17_sub5_7_;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("la.F(" + (arg0 != null ? "{...}" : "null")
                            + ',' + (arg1 != null ? "{...}" : "null")
                            + ',' + arg2 + ',' + arg3 + ',' + arg4
                            + ')'));
        }
    }

    public void method378(int arg0) {
        anInt690++;
        int i = anIntArray692[9];
        int i_8_ = anIntArray692[5];
        long l = aLong718;
        anIntArray692[5] = i;
        anIntArray692[9] = i_8_;
        aLong718 = 0L;
        for (int i_9_ = 0; i_9_ < 12; i_9_++) {
            aLong718 <<= 4;
            if (anIntArray692[i_9_] >= 256)
                aLong718 += (long) (anIntArray692[i_9_] + -256);
        }
        if ((anIntArray692[0] ^ 0xffffffff) <= -257)
            aLong718 += (long) (-256 + anIntArray692[0] >> -2026194140);
        if ((anIntArray692[1] ^ 0xffffffff) <= -257)
            aLong718 += (long) (-256 + anIntArray692[1] >> -70019256);
        for (int i_10_ = 0; i_10_ < 5; i_10_++) {
            aLong718 <<= 3;
            aLong718 += (long) anIntArray713[i_10_];
        }
        if (arg0 <= 94)
            method375(70, null);
        aLong718 <<= 1;
        Class30 class30 = this;
        class30.aLong718 = class30.aLong718 + (long) (aBoolean683 ? 1 : 0);
        anIntArray692[5] = i_8_;
        anIntArray692[9] = i;
        if (l != 0L
                && (aLong718 ^ 0xffffffffffffffffL) != (l ^ 0xffffffffffffffffL))
            Class6.aClass9_229.removeAll(l, 108);
    }

    public Model method379(int arg0) {
        try {
            anInt689++;
            if (anInt696 != -1)
                return Landscape.method932((byte) -117, anInt696)
                        .method575((byte) 111);
            boolean bool = false;
            for (int i = 0; i < 12; i++) {
                int i_11_ = anIntArray692[i];
                if (i_11_ >= 256 && (i_11_ ^ 0xffffffff) > -513
                        && !Buffer.method501((byte) -94, i_11_ - 256)
                        .method624(false))
                    bool = true;
                if ((i_11_ ^ 0xffffffff) <= -513
                        && !Class44.method897(-512 + i_11_, 10)
                        .method738((byte) 44, aBoolean683))
                    bool = true;
            }
            if (arg0 <= 20)
                anInt681 = 106;
            if (bool)
                return null;
            Model[] class40_sub5_sub17_sub5s
                    = new Model[12];
            int i = 0;
            for (int i_12_ = 0; (i_12_ ^ 0xffffffff) > -13; i_12_++) {
                int i_13_ = anIntArray692[i_12_];
                if (i_13_ >= 256 && i_13_ < 512) {
                    Model class40_sub5_sub17_sub5
                            = Buffer.method501((byte) -94, -256 + i_13_)
                            .method629((byte) -100);
                    if (class40_sub5_sub17_sub5 != null)
                        class40_sub5_sub17_sub5s[i++]
                                = class40_sub5_sub17_sub5;
                }
                if ((i_13_ ^ 0xffffffff) <= -513) {
                    Model class40_sub5_sub17_sub5
                            = Class44.method897(i_13_ - 512, 10)
                            .method747(aBoolean683, (byte) 25);
                    if (class40_sub5_sub17_sub5 != null)
                        class40_sub5_sub17_sub5s[i++]
                                = class40_sub5_sub17_sub5;
                }
            }
            Model class40_sub5_sub17_sub5
                    = new Model(class40_sub5_sub17_sub5s, i);
            for (int i_14_ = 0; i_14_ < 5; i_14_++) {
                if ((anIntArray713[i_14_] ^ 0xffffffff) != -1) {
                    class40_sub5_sub17_sub5.method803
                            (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_14_][0],
                                    (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_14_]
                                            [anIntArray713[i_14_]]));
                    if (i_14_ == 1)
                        class40_sub5_sub17_sub5.method803
                                (Class35.anIntArray1738[0],
                                        Class35.anIntArray1738[anIntArray713[i_14_]]);
                }
            }
            return class40_sub5_sub17_sub5;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "la.D(" + arg0 + ')');
        }
    }

    public void method380(int[] arg0, boolean arg1, int arg2, int[] arg3,
                          int arg4) {
        try {
            if (arg0 == null) {
                arg0 = new int[12];
                for (int i = 0; i < 7; i++) {
                    for (int i_15_ = 0; PacketBuffer.anInt2257 > i_15_;
                         i_15_++) {
                        Class40_Sub5_Sub10 class40_sub5_sub10
                                = Buffer.method501((byte) -94, i_15_);
                        if (class40_sub5_sub10 != null
                                && !class40_sub5_sub10.aBoolean2606
                                && ((i + (!arg1 ? 0 : 7) ^ 0xffffffff)
                                == (class40_sub5_sub10.anInt2599
                                ^ 0xffffffff))) {
                            arg0[Class40_Sub5_Sub15.anIntArray2777[i]]
                                    = i_15_ - -256;
                            break;
                        }
                    }
                }
            }
            anInt696 = arg4;
            aBoolean683 = arg1;
            anIntArray692 = arg0;
            anIntArray713 = arg3;
            anInt691++;
            if (arg2 == 7)
                method378(97);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("la.C(" + (arg0 != null ? "{...}" : "null")
                            + ',' + arg1 + ',' + arg2 + ','
                            + (arg3 != null ? "{...}" : "null") + ','
                            + arg4 + ')'));
        }
    }

    public void method382(int arg0, boolean arg1, int arg2) {
        try {
            anInt711++;
            if (arg0 != 1 || !aBoolean683) {
                int i = anIntArray692[Class40_Sub5_Sub15.anIntArray2777[arg0]];
                if (i != 0) {
                    i -= 256;
                    if (arg2 > 3) {
                        Class40_Sub5_Sub10 class40_sub5_sub10;
                        do {
                            if (arg1) {
                                i++;
                                if ((PacketBuffer.anInt2257 ^ 0xffffffff)
                                        >= (i ^ 0xffffffff))
                                    i = 0;
                            } else if ((--i ^ 0xffffffff) > -1)
                                i = -1 + PacketBuffer.anInt2257;
                            class40_sub5_sub10
                                    = Buffer.method501((byte) -94, i);
                        } while (class40_sub5_sub10 == null
                                || class40_sub5_sub10.aBoolean2606
                                || (class40_sub5_sub10.anInt2599
                                != arg0 - -(!aBoolean683 ? 0 : 7)));
                        anIntArray692[Class40_Sub5_Sub15.anIntArray2777[arg0]]
                                = i - -256;
                        method378(117);
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("la.I(" + arg0 + ',' + arg1 + ',' + arg2
                            + ')'));
        }
    }

    public void method383(boolean arg0, byte arg1) {
        try {
            anInt705++;
            if (!aBoolean683 != !arg0) {
                if (arg1 != -110)
                    method382(57, false, 67);
                method380(null, arg0, 7, anIntArray713, -1);
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "la.E(" + arg0 + ',' + arg1 + ')');
        }
    }

    public void method384(int arg0, boolean arg1, int arg2) {
        try {
            int i = -67 % ((-30 - arg0) / 56);
            anInt703++;
            int i_21_ = anIntArray713[arg2];
            if (!arg1) {
                if ((--i_21_ ^ 0xffffffff) > -1)
                    i_21_ = -1 + (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238
                            [arg2]).length;
            } else if ((++i_21_ ^ 0xffffffff)
                    <= ((Class40_Sub5_Sub17_Sub6.anIntArrayArray3238
                    [arg2]).length
                    ^ 0xffffffff))
                i_21_ = 0;
            anIntArray713[arg2] = i_21_;
            method378(119);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("la.A(" + arg0 + ',' + arg1 + ',' + arg2
                            + ')'));
        }
    }
}
