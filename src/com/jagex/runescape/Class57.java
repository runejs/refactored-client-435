package com.jagex.runescape;

import com.jagex.runescape.cache.media.IndexedImage;

public class Class57 {
    public static int anInt1330;
    public static Cache aClass9_1331 = new Cache(64);
    public static Class45 aClass45_1332;
    public static RSString aClass1_1333;
    public static int[] anIntArray1334 = new int[2048];
    public static int[][] anIntArrayArray1335;
    public static RSString aClass1_1336;
    public static int incomingPacket;
    public static int anInt1338;
    public static RSString aClass1_1339;
    public static RSString aClass1_1340 = RSString.CreateString("Ihr Spielkonto wird bereits benutzt)3");
    public static RSString aClass1_1341;
    public static int anInt1342;
    public static RSString aClass1_1343;
    public static RSString aClass1_1344;
    public static Class64 aClass64_1345;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1346;
    public static int[] anIntArray1347;
    public static RSString aClass1_1348;

    static {
        anInt1338 = 0;
        aClass1_1341 = RSString.CreateString("This world is full)3");
        aClass1_1339 = aClass1_1341;
        aClass1_1336 = RSString.CreateString("To create a new account you need to");
        incomingPacket = 0;
        anIntArrayArray1335 = new int[104][104];
        aClass1_1344 = RSString.CreateString("flash3:");
        anInt1342 = 0;
        aClass1_1343 = aClass1_1344;
        aClass1_1333 = aClass1_1336;
        aClass45_1332 = new Class45();
        aClass1_1348 = RSString.CreateString("0(U");
    }

    public static void method974(int arg0) {

        aClass45_1332 = null;
        aClass1_1348 = null;
        aClass40_Sub5_Sub14_Sub2_1346 = null;
        anIntArrayArray1335 = null;
        aClass9_1331 = null;
        aClass1_1336 = null;
        aClass1_1344 = null;
        aClass64_1345 = null;
        aClass1_1339 = null;
        aClass1_1340 = null;
        aClass1_1343 = null;
        anIntArray1347 = null;
        anIntArray1334 = null;
        aClass1_1341 = null;
        aClass1_1333 = null;
        int i = -39 % ((70 - arg0) / 56);

    }

    public static void method975(int arg0, byte arg1, int arg2) {

        if(arg1 == 110) {
            if((RSCanvas.anInt60 ^ 0xffffffff) != -1 && arg2 != -1) {
                Class33.method414(false, 1, arg2, RSCanvas.anInt60, 0, VertexNormal.aClass6_Sub1_1104, arg1 ^ ~0x6e);
                Class35.anInt1733 = arg0;
            }
            anInt1330++;
        }

    }
}
