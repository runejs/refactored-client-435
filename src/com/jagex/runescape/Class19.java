package com.jagex.runescape;

import com.jagex.runescape.media.renderable.Renderable;

public class Class19 {
    public static int anInt467;
    public static Cache aClass9_470 = new Cache(10);
    public static int anInt475;
    public static RSString aClass1_478 = Class58.method978("(Z");
    public static Class68 aClass68_482;
    public static int[] anIntArray483 = new int[500];
    public static Class27 aClass27_485 = new Class27();
    public static int anInt487 = 0;
    public static Class6 aClass6_488;
    public static RSString aClass1_489 = Class58.method978("Public chat");
    public static boolean aBoolean490 = false;
    public static byte[][][] aByteArrayArrayArray492;
    public static int anInt493 = 0;
    public static RSString aClass1_494;
    public static RSString aClass1_495 = aClass1_489;
    public static boolean aBoolean496 = false;

    static {
        aClass1_494 = Class58.method978("@gr3@");
    }

    public int anInt468;
    public int anInt469;
    public int anInt471 = 0;
    public int anInt472;
    public int anInt473;
    public Renderable aRenderable_474;
    public int anInt476;
    public int anInt477;
    public int anInt479;
    public int anInt480;
    public int anInt481;
    public int anInt484;
    public int anInt486;
    public int anInt491;

    public Class19() {
        anInt469 = 0;
    }

    public static RSString method279(byte[] arg0, boolean arg1, int arg2, int arg3) {

        anInt467++;
            RSString class1 = new RSString();
        class1.length = 0;
        class1.chars = new byte[arg3];
            if(arg1 != true)
                aClass1_495 = null;
            for(int i = arg2; arg3 + arg2 > i; i++) {
                if((arg0[i] ^ 0xffffffff) != -1)
                    class1.chars[class1.length++] = arg0[i];
            }
            return class1;

    }

    public static void method280(boolean arg0) {

        aClass1_495 = null;
            aClass1_494 = null;
            aClass68_482 = null;
            aClass1_489 = null;
            aClass27_485 = null;
            aByteArrayArrayArray492 = null;
            aClass9_470 = null;
            aClass1_478 = null;
            if(arg0 != true)
                method280(false);
            anIntArray483 = null;
            aClass6_488 = null;

    }
}
