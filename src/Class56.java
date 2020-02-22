/* Class56 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class56 {
    public static int anInt1310;
    public static int anInt1311;
    public static int anInt1312;
    public static RSString aClass1_1314;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_1315;
    public static RSString aClass1_1316 = Class58.method978("Zu viele Verbindungen von Ihrer Adresse)3");
    public static int anInt1317;
    public static int anInt1318;
    public static int anInt1319;
    public static Class61[] aClass61Array1320;
    public static int anInt1322;
    public static Class6_Sub1 aClass6_Sub1_1323;
    public static int anInt1325;
    public static int anInt1326;
    public static int anInt1327;
    public static int anInt1328;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_1329;

    static {
        aClass1_1314 = Class58.method978(" weitere Optionen");
        anInt1318 = 3353893;
        aClass61Array1320 = new Class61[50];
    }

    public Class67 aClass67_1309;
    public Class67 aClass67_1313 = null;
    public int anInt1321;
    public int anInt1324;

    public Class56(int arg0, Class67 arg1, Class67 arg2, int arg3) {
        aClass67_1309 = null;
        anInt1321 = 65000;
        try {
            anInt1321 = arg3;
            aClass67_1313 = arg2;
            aClass67_1309 = arg1;
            anInt1324 = arg0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("sa.<init>(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + (arg2 != null ? "{...}" : "null") + ',' + arg3 + ')'));
        }
    }

    public static void method967(int arg0) {
        try {
            aClass1_1314 = null;
            aClass61Array1320 = null;
            aClass40_Sub5_Sub14_Sub2_1315 = null;
            aClass6_Sub1_1323 = null;
            if(arg0 <= 20)
                method967(97);
            aClass1_1316 = null;
            aClass40_Sub5_Sub14_Sub2_1329 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "sa.F(" + arg0 + ')');
        }
    }

    public static RSString[] method968(RSString[] arg0, boolean arg1) {
        try {
            if(arg1 != false)
                method972((byte) -104);
            RSString[] class1s = new RSString[5];
            anInt1317++;
            for(int i = 0; (i ^ 0xffffffff) > -6; i++) {
                class1s[i] = (Class40_Sub5_Sub17_Sub6.method832(-69, new RSString[]{HashTable.method334(i, -1), ISAAC.aClass1_515}));
                if(arg0 != null && arg0[i] != null)
                    class1s[i] = Class40_Sub5_Sub17_Sub6.method832(117, (new RSString[]{class1s[i], arg0[i]}));
            }
            return class1s;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("sa.E(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public static Class38 method972(byte arg0) {
        try {
            if(arg0 != 47)
                method968(null, true);
            anInt1310++;
            try {
                return (Class38) Class.forName("Class38_Sub2").newInstance();
            } catch(Throwable throwable) {
                return new Class38_Sub1();
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "sa.B(" + arg0 + ')');
        }
    }

    public static void method973(int arg0) {
        try {
            Class67.anIntArray1579 = null;
            SceneTile.anIntArray2048 = null;
            if(arg0 >= -57)
                aClass1_1314 = null;
            FloorDecoration.anIntArray612 = null;
            Class6.anIntArrayArrayArray262 = null;
            Class40_Sub5_Sub7.anIntArrayArray2490 = null;
            Class35.aByteArrayArrayArray1745 = null;
            Class59.anIntArray1398 = null;
            Class19.aByteArrayArrayArray492 = null;
            Floor.aByteArrayArrayArray2335 = null;
            Class62.aByteArrayArrayArray1473 = null;
            anInt1312++;
            Class42.aByteArrayArrayArray993 = null;
            Class40_Sub5_Sub17_Sub6.anIntArray3250 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "sa.D(" + arg0 + ')');
        }
    }

    public String toString() {
        try {
            anInt1326++;
            return "Cache:" + anInt1324;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "sa.toString(" + ')');
        }
    }

    public byte[] method969(int arg0, byte arg1) {
        try {
            anInt1322++;
            int i = -83 / ((-49 - arg1) / 47);
            synchronized(aClass67_1309) {
                try {
                    if(aClass67_1313.method1032(0) < (long) (6 + arg0 * 6))
                        return null;
                    aClass67_1313.method1031(0, (long) (6 * arg0));
                    aClass67_1313.method1035(0, (byte) -49, 6, NpcDefinition.aByteArray2416);
                    int i_0_ = ((0xff00 & (NpcDefinition.aByteArray2416[4] << 2112382504)) + ((0xff & NpcDefinition.aByteArray2416[3]) << -1692209456) + (0xff & NpcDefinition.aByteArray2416[5]));
                    int i_1_ = ((0xff & NpcDefinition.aByteArray2416[2]) + (((NpcDefinition.aByteArray2416[0] & 0xff) << 2016836816) + ((0xff & NpcDefinition.aByteArray2416[1]) << 1439956072)));
                    if(i_1_ < 0 || (i_1_ ^ 0xffffffff) < (anInt1321 ^ 0xffffffff))
                        return null;
                    if(i_0_ <= 0 || (((long) i_0_ ^ 0xffffffffffffffffL) < (aClass67_1309.method1032(0) / 520L ^ 0xffffffffffffffffL)))
                        return null;
                    int i_2_ = 0;
                    int i_3_ = 0;
                    byte[] is = new byte[i_1_];
                    while((i_1_ ^ 0xffffffff) < (i_2_ ^ 0xffffffff)) {
                        if((i_0_ ^ 0xffffffff) == -1)
                            return null;
                        aClass67_1309.method1031(0, (long) (i_0_ * 520));
                        int i_4_ = -i_2_ + i_1_;
                        if((i_4_ ^ 0xffffffff) < -513)
                            i_4_ = 512;
                        aClass67_1309.method1035(0, (byte) -14, 8 + i_4_, (NpcDefinition.aByteArray2416));
                        int i_5_ = ((0xff00 & (NpcDefinition.aByteArray2416[0] << -1509655160)) + (0xff & NpcDefinition.aByteArray2416[1]));
                        int i_6_ = ((NpcDefinition.aByteArray2416[6] & 0xff) + ((0xff & NpcDefinition.aByteArray2416[5]) << -109515864) + ((0xff & NpcDefinition.aByteArray2416[4]) << -873067312));
                        int i_7_ = ((0xff00 & (NpcDefinition.aByteArray2416[2] << 52160136)) + (0xff & NpcDefinition.aByteArray2416[3]));
                        int i_8_ = 0xff & NpcDefinition.aByteArray2416[7];
                        if((i_5_ ^ 0xffffffff) != (arg0 ^ 0xffffffff) || (i_7_ ^ 0xffffffff) != (i_3_ ^ 0xffffffff) || (i_8_ ^ 0xffffffff) != (anInt1324 ^ 0xffffffff))
                            return null;
                        if((i_6_ ^ 0xffffffff) > -1 || (((long) i_6_ ^ 0xffffffffffffffffL) < (aClass67_1309.method1032(0) / 520L ^ 0xffffffffffffffffL)))
                            return null;
                        i_3_++;
                        for(int i_9_ = 0; (i_9_ ^ 0xffffffff) > (i_4_ ^ 0xffffffff); i_9_++)
                            is[i_2_++] = NpcDefinition.aByteArray2416[8 + i_9_];
                        i_0_ = i_6_;
                    }
                    return is;
                } catch(java.io.IOException ioexception) {
                    return null;
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "sa.G(" + arg0 + ',' + arg1 + ')');
        }
    }

    public boolean method970(byte[] arg0, int arg1, boolean arg2, int arg3, byte arg4) {
        try {
            anInt1325++;
            synchronized(aClass67_1309) {
                try {
                    if(arg4 >= -80)
                        method969(91, (byte) 63);
                    int i;
                    if(arg2) {
                        if(aClass67_1313.method1032(0) < (long) (6 + 6 * arg3))
                            return false;
                        aClass67_1313.method1031(0, (long) (arg3 * 6));
                        aClass67_1313.method1035(0, (byte) -111, 6, (NpcDefinition.aByteArray2416));
                        i = ((NpcDefinition.aByteArray2416[5] & 0xff) + (((NpcDefinition.aByteArray2416[3] & 0xff) << 244380432) + ((NpcDefinition.aByteArray2416[4] & 0xff) << -1843041752)));
                        if((i ^ 0xffffffff) >= -1 || (((long) i ^ 0xffffffffffffffffL) < (aClass67_1309.method1032(0) / 520L ^ 0xffffffffffffffffL)))
                            return false;
                    } else {
                        i = (int) ((519L + aClass67_1309.method1032(0)) / 520L);
                        if(i == 0)
                            i = 1;
                    }
                    NpcDefinition.aByteArray2416[0] = (byte) (arg1 >> -897009424);
                    NpcDefinition.aByteArray2416[1] = (byte) (arg1 >> 2120801992);
                    NpcDefinition.aByteArray2416[2] = (byte) arg1;
                    int i_10_ = 0;
                    NpcDefinition.aByteArray2416[3] = (byte) (i >> -1783240816);
                    int i_11_ = 0;
                    NpcDefinition.aByteArray2416[4] = (byte) (i >> -102164472);
                    NpcDefinition.aByteArray2416[5] = (byte) i;
                    aClass67_1313.method1031(0, (long) (arg3 * 6));
                    aClass67_1313.method1033(0, -16777216, 6, NpcDefinition.aByteArray2416);
                    int i_12_;
                    for(/**/; i_10_ < arg1; i_10_ += i_12_) {
                        int i_13_ = 0;
                        if(arg2) {
                            aClass67_1309.method1031(0, (long) (520 * i));
                            try {
                                aClass67_1309.method1035(0, (byte) -106, 8, (NpcDefinition.aByteArray2416));
                            } catch(java.io.EOFException eofexception) {
                                break;
                            }
                            i_13_ = ((NpcDefinition.aByteArray2416[6] & 0xff) + (((NpcDefinition.aByteArray2416[4] << 809811568) & 0xff0000) + (0xff00 & (NpcDefinition.aByteArray2416[5]) << -83110776)));
                            i_12_ = ((NpcDefinition.aByteArray2416[1] & 0xff) + ((NpcDefinition.aByteArray2416[0] << 1593639048) & 0xff00));
                            int i_14_ = NpcDefinition.aByteArray2416[7] & 0xff;
                            int i_15_ = ((NpcDefinition.aByteArray2416[3] & 0xff) + ((0xff & NpcDefinition.aByteArray2416[2]) << -1878865912));
                            if(arg3 != i_12_ || (i_15_ ^ 0xffffffff) != (i_11_ ^ 0xffffffff) || (i_14_ ^ 0xffffffff) != (anInt1324 ^ 0xffffffff))
                                return false;
                            if(i_13_ < 0 || (aClass67_1309.method1032(0) / 520L < (long) i_13_))
                                return false;
                        }
                        if(i_13_ == 0) {
                            arg2 = false;
                            i_13_ = (int) ((519L + aClass67_1309.method1032(0)) / 520L);
                            if((i_13_ ^ 0xffffffff) == -1)
                                i_13_++;
                            if(i == i_13_)
                                i_13_++;
                        }
                        NpcDefinition.aByteArray2416[0] = (byte) (arg3 >> 989037448);
                        if(-i_10_ + arg1 <= 512)
                            i_13_ = 0;
                        NpcDefinition.aByteArray2416[1] = (byte) arg3;
                        i_12_ = -i_10_ + arg1;
                        if((i_12_ ^ 0xffffffff) < -513)
                            i_12_ = 512;
                        NpcDefinition.aByteArray2416[2] = (byte) (i_11_ >> 436921608);
                        NpcDefinition.aByteArray2416[3] = (byte) i_11_;
                        NpcDefinition.aByteArray2416[4] = (byte) (i_13_ >> 1862596560);
                        NpcDefinition.aByteArray2416[5] = (byte) (i_13_ >> 154341896);
                        i_11_++;
                        NpcDefinition.aByteArray2416[6] = (byte) i_13_;
                        NpcDefinition.aByteArray2416[7] = (byte) anInt1324;
                        aClass67_1309.method1031(0, (long) (520 * i));
                        aClass67_1309.method1033(0, -16777216, 8, (NpcDefinition.aByteArray2416));
                        i = i_13_;
                        aClass67_1309.method1033(i_10_, -16777216, i_12_, arg0);
                    }
                    return true;
                } catch(java.io.IOException ioexception) {
                    return false;
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("sa.C(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ')'));
        }
    }

    public boolean method971(byte[] arg0, int arg1, int arg2, int arg3) {
        try {
            anInt1328++;
            synchronized(aClass67_1309) {
                if(arg2 < 0 || arg2 > anInt1321)
                    throw new IllegalArgumentException();
                if(arg1 != 1862596560)
                    method971(null, 96, -29, 88);
                boolean bool = method970(arg0, arg2, true, arg3, (byte) -120);
                if(!bool)
                    bool = method970(arg0, arg2, false, arg3, (byte) -114);
                return bool;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("sa.A(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ',' + arg3 + ')'));
        }
    }
}
