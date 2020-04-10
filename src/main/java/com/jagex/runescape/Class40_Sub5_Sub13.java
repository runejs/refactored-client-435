package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.tile.GenericTile;

import java.awt.*;

public class Class40_Sub5_Sub13 extends SubNode {
    public static Buffer aClass40_Sub1_2752;
    public static IndexedImage[] moderatorIcon;
    public static long[] aLongArray2757 = new long[100];
    public static Model[] aClass40_Sub5_Sub17_Sub5Array2762 = new Model[4];
    public static int[] anIntArray2764 = new int[128];
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2765;
    public CacheIndex_Sub1 aClass6_Sub1_2754;
    public byte aByte2758;
    public int anInt2763;

    public static Class68 method649(int arg0, int arg1, Component arg2, int arg3) {
        if(arg3 != -4875)
            aClass40_Sub5_Sub14_Sub4_2765 = null;
        try {
            Class var_class = Class.forName("com.jagex.runescape.Class68_Sub2");
            Class68 class68 = (Class68) var_class.newInstance();
            class68.method1041(13, arg1, arg2, arg0);
            return class68;
        } catch(Throwable throwable) {
            Class68_Sub1 class68_sub1 = new Class68_Sub1();
            class68_sub1.method1041(44, arg1, arg2, arg0);
            return class68_sub1;
        }
    }

    public static void method650(int arg1) {
        LinkedList.anInt1073 = arg1;
    }

    public static void method651(int arg0, int arg1) {
        if(Class5.aClass22_189 != null) {
            if(RSCanvas.anInt54 != 0) {
                if(Player.aByteArray3270 != null)
                    PacketBuffer.anInt2258 = arg1;
            } else if(MouseHandler.anInt1450 >= 0) {
                MouseHandler.anInt1450 = arg1;
                Class5.aClass22_189.method304((byte) -111, arg1, 0);
            }
            if(arg0 != 22741)
                method652();
        }
    }

    public static void method652() {
        for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) LinkedList.aLinkedList_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.method909(-4)) {
            if(class40_sub3.anInt2031 > 0)
                class40_sub3.anInt2031--;
            if(class40_sub3.anInt2031 == 0) {
                if(class40_sub3.anInt2028 < 0 || Node.method459(class40_sub3.anInt2036, class40_sub3.anInt2028, (byte) 103)) {
                    GenericTile.method945(class40_sub3.anInt2038, class40_sub3.anInt2028, class40_sub3.anInt2039, class40_sub3.anInt2036, class40_sub3.anInt2025, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.method457(-1);
                }
            } else {
                if(class40_sub3.anInt2033 > 0)
                    class40_sub3.anInt2033--;
                if(class40_sub3.anInt2033 == 0 && class40_sub3.anInt2039 >= 1 && class40_sub3.anInt2038 >= 1 && class40_sub3.anInt2039 <= 102 && class40_sub3.anInt2038 <= 102 && (class40_sub3.anInt2017 < 0 || Node.method459(class40_sub3.anInt2030, class40_sub3.anInt2017, (byte) 106))) {
                    GenericTile.method945(class40_sub3.anInt2038, class40_sub3.anInt2017, class40_sub3.anInt2039, class40_sub3.anInt2030, class40_sub3.anInt2035, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.anInt2033 = -1;
                    if(class40_sub3.anInt2028 == class40_sub3.anInt2017 && class40_sub3.anInt2028 == -1)
                        class40_sub3.method457(-1);
                    else if((class40_sub3.anInt2028 == class40_sub3.anInt2017) && (class40_sub3.anInt2025 == class40_sub3.anInt2035) && (class40_sub3.anInt2030 == class40_sub3.anInt2036))
                        class40_sub3.method457(-1);
                }
            }
        }
    }

    public static void method653() {
        anIntArray2764 = null;
        aClass40_Sub1_2752 = null;
        Player.localPlayer = null;
        aClass40_Sub5_Sub17_Sub5Array2762 = null;
        aClass40_Sub5_Sub14_Sub4_2765 = null;
        aLongArray2757 = null;
        moderatorIcon = null;
    }
}
