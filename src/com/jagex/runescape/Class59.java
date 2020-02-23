package com.jagex.runescape;

import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class59 {
    public static int anInt1380;
    public static int anInt1381;
    public static int anInt1382;
    public static int anInt1383;
    public static int anInt1384;
    public static Buffer aClass40_Sub1_1385 = new Buffer(new byte[5000]);
    public static int anInt1386;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1387;
    public static int anInt1388;
    public static int anInt1389 = 0;
    public static Widget[][] aWidgetArrayArray1390;
    public static RSString aClass1_1391;
    public static Class54 aClass54_1392;
    public static int[] anIntArray1393;
    public static RSString aClass1_1395 = RSString.CreateString("backbase1");
    public static RSString string_Hidden = RSString.CreateString("Hidden");
    public static long[] aLongArray1397;
    public static int[] anIntArray1398;
    public static RSString aClass1_1399;

    static {
        anIntArray1393 = new int[500];
        aClass1_1391 = (RSString.CreateString("Your friendlist is full)3 Max of 100 for free users)1 and 200 for members"));
        aClass1_1399 = aClass1_1391;
        aLongArray1397 = new long[200];
        aClass54_1392 = new Class54();
    }

    public static void dropClient(int arg0) {
        anInt1384++;
        if(Class32.anInt771 > 0)
            Class48.method928(-7225);
        else {
            Floor.method559(40, 99);
            Class30.aClass64_717 = Class40_Sub6.aClass64_2098;
            Class40_Sub6.aClass64_2098 = null;
            if(arg0 != 2578)
                aClass1_1395 = null;
        }
    }

    public static void method983(int arg0) {

        anInt1381++;
        int i = 70 / ((62 - arg0) / 55);
        Scene.aBoolean88 = true;
        VertexNormal.lowMemory = true;

    }

    public static void method984(int arg0) {

        if(arg0 == 0) {
            anInt1380++;
            if(Class5.aClass22_189 != null) {
                if((Class62.anInt1450 ^ 0xffffffff) <= -1) {
                    if(RSCanvas.anInt54 > 0) {
                        Class39.anInt909 += Buffer.anInt1982;
                        Class5.aClass22_189.method304((byte) -97, Class62.anInt1450, Class39.anInt909);
                        RSCanvas.anInt54--;
                        if(RSCanvas.anInt54 == 0) {
                            Class5.aClass22_189.method303((byte) -96);
                            Class62.anInt1450 = -1;
                            RSCanvas.anInt54 = 20;
                        }
                    }
                } else if(RSCanvas.anInt54 > 0) {
                    RSCanvas.anInt54--;
                    if((RSCanvas.anInt54 ^ 0xffffffff) == -1) {
                        if(Player.aByteArray3270 == null)
                            Class5.aClass22_189.method301(256, 0);
                        else {
                            Class5.aClass22_189.method301(PacketBuffer.anInt2258, arg0);
                            Class62.anInt1450 = PacketBuffer.anInt2258;
                            Class5.aClass22_189.method300((Player.aByteArray3270), Class30.aBoolean687, -15910, PacketBuffer.anInt2258);
                            Player.aByteArray3270 = null;
                        }
                        Class39.anInt909 = 0;
                    }
                }
                Class5.aClass22_189.method302(0);
            }
        }

    }

    public static void method985(byte arg0) {

        aClass40_Sub1_1385 = null;
        int i = 84 / ((arg0 + 74) / 47);
        aWidgetArrayArray1390 = null;
        anIntArray1398 = null;
        aClass40_Sub5_Sub14_Sub2_1387 = null;
        aClass1_1399 = null;
        aLongArray1397 = null;
        aClass1_1395 = null;
        aClass54_1392 = null;
        aClass1_1391 = null;
        string_Hidden = null;
        anIntArray1393 = null;

    }

    public static int getVisibilityPlaneFor(int arg0, int arg1, int arg2, int arg3) {

        if(arg2 != 0)
            getVisibilityPlaneFor(-73, 123, 115, 98);
        anInt1382++;
        if(((Floor.tile_flags[arg0][arg3][arg1] & 0x8) ^ 0xffffffff) != -1)
            return 0;
        if((arg0 ^ 0xffffffff) < -1 && ((Floor.tile_flags[1][arg3][arg1] & 0x2) ^ 0xffffffff) != -1)
            return -1 + arg0;
        return arg0;

    }
}
