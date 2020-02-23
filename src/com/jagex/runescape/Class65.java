package com.jagex.runescape;

import java.util.zip.CRC32;

public class Class65 {
    public static RSString aClass1_1530 = RSString.CreateString("Abbrechen");
    public static CRC32 aCRC32_1531 = new CRC32();
    public static int anInt1532;
    public static CacheIndex_Sub1 aClass6_Sub1_1533;
    public static int anInt1534;
    public static RSString aClass1_1535 = RSString.CreateString("Please reload this page)3");
    public static RSString aClass1_1536 = RSString.CreateString(" x ");
    public static int anInt1537;
    public static RSString aClass1_1538 = aClass1_1535;
    public static int anInt1539;

    static {
        anInt1537 = 128;
    }

    public static void method1017(byte arg0) {

        aClass6_Sub1_1533 = null;
        aCRC32_1531 = null;
        aClass1_1530 = null;
        aClass1_1538 = null;
        if(arg0 >= -10)
            anInt1537 = 31;
        aClass1_1536 = null;
        aClass1_1535 = null;

    }

    public static void method1018(byte arg0) {

        int i = -125 % ((arg0 - 2) / 56);
        anInt1539++;
        Class40_Sub5_Sub4.aClass68_2350.method1046((byte) 90);
        Class24.anIntArray577 = R3D.method708(Class24.anIntArray577);

    }

    public static void method1019(int arg0) {

        anInt1534++;
        if(Class5.aClass22_189 != null) {
            Class22.method308(arg0 + -191);
            if(arg0 == 104) {
                if(RSCanvas.anInt54 > 0) {
                    Class5.aClass22_189.method301(256, 0);
                    RSCanvas.anInt54 = 0;
                }
                Class5.aClass22_189.method306((byte) 101);
                Class5.aClass22_189 = null;
            }
        }

    }

    public static void method1020(boolean arg0) {

        Class59.anIntArray1398 = new int[104];
        Floor.aByteArrayArrayArray2335 = new byte[4][104][104];
        anInt1532++;
        CacheIndex.anIntArrayArrayArray262 = new int[4][105][105];
        if(arg0 != true)
            aClass1_1530 = null;
        Class64.setZ = 99;
        Class19.aByteArrayArrayArray492 = new byte[4][105][105];
        FloorDecoration.anIntArray612 = new int[104];
        Class67.anIntArray1579 = new int[104];
        SceneTile.anIntArray2048 = new int[104];
        Class40_Sub5_Sub7.anIntArrayArray2490 = new int[105][105];
        GameFrame.aByteArrayArrayArray1473 = new byte[4][104][104];
        Class40_Sub5_Sub17_Sub6.anIntArray3250 = new int[104];
        Class35.aByteArrayArrayArray1745 = new byte[4][104][104];
        Class42.aByteArrayArrayArray993 = new byte[4][104][104];

    }
}
