package com.jagex.runescape.scene;

import com.jagex.runescape.Class27;
import com.jagex.runescape.Class68;
import com.jagex.runescape.RSString;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.media.renderable.Renderable;

public class InteractiveObject {
    public static Cache aClass9_470 = new Cache(10);
    public static int menuOffsetX;
    public static RSString aClass1_478 = RSString.CreateString("(Z");
    public static Class68 aClass68_482;
    public static int[] firstMenuOperand = new int[500];
    public static Class27 aClass27_485 = new Class27();
    public static int anInt487 = 0;
    public static CacheIndex aCacheIndex_488;
    public static RSString aClass1_489 = RSString.CreateString("Public chat");
    public static byte[][][] aByteArrayArrayArray492;
    public static int playerRights = 0;
    public static RSString aClass1_494;
    public static RSString aClass1_495 = aClass1_489;
    public static boolean showFps = false;

    static {
        aClass1_494 = RSString.CreateString("@gr3@");
    }

    public int z;
    public int hash;
    public int config = 0;
    public int worldY;
    public int tileLeft;
    public Renderable renderable;
    public int worldX;
    public int tileBottom;
    public int worldZ;
    public int rotation;
    public int tileTop;
    public int tileRight;
    public int cycle;
    public int anInt491;

    public InteractiveObject() {
        hash = 0;
    }

    public static RSString method279(byte[] arg0, boolean arg1, int arg2, int arg3) {
        RSString class1 = new RSString();
        class1.length = 0;
        class1.chars = new byte[arg3];
        if(!arg1)
            aClass1_495 = null;
        for(int i = arg2; arg3 + arg2 > i; i++) {
            if(arg0[i] != 0)
                class1.chars[class1.length++] = arg0[i];
        }
        return class1;
    }

    public static void method280() {
        aClass1_495 = null;
        aClass1_494 = null;
        aClass68_482 = null;
        aClass1_489 = null;
        aClass27_485 = null;
        aByteArrayArrayArray492 = null;
        aClass9_470 = null;
        aClass1_478 = null;
        firstMenuOperand = null;
        aCacheIndex_488 = null;
    }
}
