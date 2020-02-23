package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class40_Sub5_Sub4 extends SubNode {
    public static Class6 aClass6_2349;
    public static Class68 aClass68_2350;
    public static RSString aClass1_2351;
    public static RSString aClass1_2352 = Class58.method978("Login");
    public static int anInt2353;
    public static RSString aClass1_2354;
    public static int anInt2355;
    public static Class56 aClass56_2356;
    public static RSString aClass1_2357;
    public static int anInt2359 = 0;
    public static int anInt2360;
    public static int[] anIntArray2361;
    public static int anInt2362;
    public static int anInt2363;
    public static Class6 aClass6_2364;
    public static int anInt2365;
    public static int anInt2366;
    public static RSString aClass1_2367 = Class58.method978("Please subscribe)1 or use a different world)3");
    public static int anInt2369;
    public static int anInt2371;

    static {
        aClass1_2357 = aClass1_2367;
        anIntArray2361 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647, -1};
        aClass1_2351 = aClass1_2352;
        anInt2366 = 0;
        aClass1_2354 = Class58.method978("Unerwartete Antwort vom Anmelde)2Server");
    }

    public int anInt2358;
    public int anInt2368;
    public int anInt2370;

    public static int method564(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, byte arg6) {

        arg4 &= 0x3;
        anInt2371++;
        if((arg5 & 0x1) == 1) {
            int i = arg3;
            arg3 = arg1;
            arg1 = i;
        }
        if((arg4 ^ 0xffffffff) == -1)
            return arg0;
        if(arg4 == 1)
            return 1 + (-arg3 + 7 - arg2);
        if(arg6 > -64)
            method564(12, 96, -19, -17, -19, 1, (byte) -99);
        if((arg4 ^ 0xffffffff) == -3)
            return -arg1 + 1 + (-arg0 + 7);
        return arg2;

    }

    public static void method565(int arg0) {

        aClass1_2351 = null;
        if(arg0 <= -120) {
            aClass6_2364 = null;
            aClass68_2350 = null;
            aClass6_2349 = null;
            aClass1_2357 = null;
            anIntArray2361 = null;
            aClass56_2356 = null;
            aClass1_2354 = null;
            aClass1_2367 = null;
            aClass1_2352 = null;
        }

    }

    public static void method566(int arg0, boolean arg1, int arg2, byte[] arg3, int arg4) {

        anInt2365++;
        if(arg4 != -27520)
            method565(49);
        if(Class5.aClass22_189 != null) {
            if(Class62.anInt1450 >= 0) {
                arg2 -= 20;
                if((arg2 ^ 0xffffffff) > -2)
                    arg2 = 1;
                RSCanvas.anInt54 = arg2;
                if((Class62.anInt1450 ^ 0xffffffff) == -1)
                    Buffer.anInt1982 = 0;
                else {
                    int i = Class29.method372(113, Class62.anInt1450);
                    i -= Class39.anInt909;
                    Buffer.anInt1982 = (-1 + (arg2 + 3600 + i)) / arg2;
                }
                Player.aByteArray3270 = arg3;
                PacketBuffer.anInt2258 = arg0;
                Class30.aBoolean687 = arg1;
            } else if((RSCanvas.anInt54 ^ 0xffffffff) == -1)
                RSString.method56(2037, arg1, arg3, arg0);
            else {
                PacketBuffer.anInt2258 = arg0;
                Class30.aBoolean687 = arg1;
                Player.aByteArray3270 = arg3;
            }
        }

    }

    public void method562(int arg0, Buffer arg1) {
        anInt2353++;
        for(; ; ) {
            int i = arg1.getUnsignedByte();
            if(i == 0)
                break;
            method563(arg1, arg0 + 26283, i);
        }
        if(arg0 != 0)
            aClass56_2356 = null;
    }

    public void method563(Buffer arg0, int arg1, int arg2) {
        anInt2360++;
        if((arg2 ^ 0xffffffff) == -2) {
            anInt2358 = arg0.getUnsignedShortBE();
            anInt2368 = arg0.getUnsignedByte();
            anInt2370 = arg0.getUnsignedByte();
        }
        if(arg1 != 26283)
            aClass56_2356 = null;
    }
}
