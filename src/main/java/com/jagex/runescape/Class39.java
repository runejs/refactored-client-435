package com.jagex.runescape;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.util.Signlink;

public class Class39 implements Runnable {
    public static int anInt901;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_907;
    public static ProducingGraphicsBuffer mapbackLeft;
    public static int anInt909 = 0;
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

    public static void method451(Class40_Sub3 arg0, int arg1) {
        int i = 0;
        int i_0_ = -1;
        int i_1_ = 0;
        if(arg0.anInt2027 == 0)
            i = Npc.currentScene.method122(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        int i_2_ = 0;
        if(arg0.anInt2027 == 1)
            i = Npc.currentScene.method91(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        if(arg0.anInt2027 == 2)
            i = Npc.currentScene.getLocationHash(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        if(arg0.anInt2027 == 3)
            i = Npc.currentScene.getFloorDecorationHash(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038);
        if(arg1 == 19813) {
            if(i != 0) {
                int i_3_ = Npc.currentScene.getArrangement(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038, i);
                i_0_ = (0x1fffe692 & i) >> 14;
                i_2_ = (i_3_ & 0xde) >> 6;
                i_1_ = i_3_ & 0x1f;
            }
            arg0.anInt2025 = i_2_;
            arg0.anInt2028 = i_0_;
            arg0.anInt2036 = i_1_;
        }
    }

    public static boolean method452(Signlink arg0, boolean arg2) {
        RSCanvas.anInt54 = 20;
        try {
            MovedStatics.aClass22_189 = new Class22_Sub2_Sub1(); // Java Midi Based
            return true;
        } catch(Throwable throwable) {
            Runnable_Impl1 runnable_impl1 = arg0.method391();
            if(runnable_impl1 != null) {
                MovedStatics.aClass22_189 = new Class22_Sub2_Sub2(arg0, runnable_impl1); // ???
                return true;
            }
            if(arg2) {
                MovedStatics.aClass22_189 = new Class22_Sub1(arg0); // JS based
                return true;
            }
            return false;
        }
//        return false;
    }


    public void run() {
        while(aBoolean913) {
            synchronized(objectLock) {
                if(coord < 500) {
                    coordsX[coord] = Class13.mouseX;
                    coordsY[coord] = Landscape.mouseY;
                    coord++;
                }
            }
            Class43.threadSleep(50L);
        }
    }
}
