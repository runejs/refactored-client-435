package com.jagex.runescape;

import com.jagex.runescape.cache.MemoryCache;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.awt.*;

public abstract class ProducingGraphicsBuffer {
    public static MemoryCache aClass9_1615 = new MemoryCache(64);
    public static int anInt1618 = 0;
    public static int anInt1623 = 0;
    public static int oneMouseButton = 0;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1631;
    public static SignlinkNode aSignlinkNode_1632;
    public static int anInt1634 = 0;
    public static int anInt1637 = 0;

    public int height;
    public int width;
    public int[] pixels;
    public Image image;

    public static void method1040(Component arg0, int arg1, Signlink arg2) {
        try {
            Class8_Sub1 class8_sub1 = new Class8_Sub1_Sub2();
            class8_sub1.method222(arg2, 2048);
            CollisionMap.aClass8_166 = class8_sub1;
        } catch (Throwable throwable) {
            try {
                CollisionMap.aClass8_166 = new Class8_Sub1_Sub1(arg2, arg0);
            } catch (Throwable throwable_0_) {
                if (arg1 <= Signlink.aString735.toLowerCase().indexOf("microsoft")) {
                    try {
                        CollisionMap.aClass8_166 = new Class8_Sub2();
                        return;
                    } catch (Throwable throwable_1_) {
                        /* empty */
                    }
                }
                CollisionMap.aClass8_166 = new Class8(8000);
            }
        }

    }


    public abstract void method1041(int i, int i_2_, Component component, int i_3_);

    public abstract void drawGraphics(int x, int y, Graphics graphics);
    public abstract void paintComponent(int x, int y, Graphics graphics);

    public void prepareRasterizer() {
        Rasterizer.prepare(pixels, width, height);
    }
}
