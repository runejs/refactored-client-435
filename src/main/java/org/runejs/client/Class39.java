package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.input.MouseHandler;

public class Class39 implements Runnable {
    public static int anInt901;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_907;
    public static ProducingGraphicsBuffer mapbackLeft;
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_918;
    public Object objectLock;
    public boolean aBoolean913 = true;
    public int[] coordsY;
    public int coord;
    public int[] coordsX;

    public Class39() {
        objectLock = new Object();
        coord = 0;
        coordsY = new int[500];
        coordsX = new int[500];
    }

    public static void method451(Class40_Sub3 arg0) {
        int i = 0;
        int i_0_ = -1;
        int i_1_ = 0;
        if(arg0.anInt2027 == 0)
            i = Game.currentScene.method122(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        int i_2_ = 0;
        if(arg0.anInt2027 == 1)
            i = Game.currentScene.method91(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        if(arg0.anInt2027 == 2)
            i = Game.currentScene.getLocationHash(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        if(arg0.anInt2027 == 3)
            i = Game.currentScene.getFloorDecorationHash(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        if (i != 0) {
            int i_3_ = Game.currentScene.getArrangement(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038, i);
            i_0_ = (0x1fffe692 & i) >> 14;
            i_2_ = (i_3_ & 0xde) >> 6;
            i_1_ = i_3_ & 0x1f;
        }
        arg0.anInt2025 = i_2_;
        arg0.anInt2028 = i_0_;
        arg0.anInt2036 = i_1_;
    }

    public void run() {
        while(aBoolean913) {
            synchronized(objectLock) {
                if(coord < 500) {
                    coordsX[coord] = MouseHandler.mouseX;
                    coordsY[coord] = MouseHandler.mouseY;
                    coord++;
                }
            }
            MovedStatics.threadSleep(50L);
        }
    }
}
