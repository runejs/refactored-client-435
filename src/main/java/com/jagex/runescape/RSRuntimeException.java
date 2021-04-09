package com.jagex.runescape;

import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class RSRuntimeException extends RuntimeException {
    public static int anInt1641 = 0;
    public static int lastActiveInvInterface = 0;
    public static int anInt1651 = 0;
    /*synthetic*/ public static Class aClass1654;

    public Throwable aThrowable1652;
    public String aString1653;

    public RSRuntimeException(Throwable arg0, String arg1) {
        aString1653 = arg1;
        aThrowable1652 = arg0;
    }

    public static void method1054(byte arg0) {
        if(CollisionMap.aClass8_166 != null) {
            long l = System.currentTimeMillis();
            if(Class8.aLong288 < l) {
                CollisionMap.aClass8_166.method212(l);
                int i = (int) (-Class8.aLong288 + l);
                Class8.aLong288 = l;
                synchronized(aClass1654 != null ? aClass1654 : (aClass1654 = method1058(
                        "com.jagex.runescape.Class8"))) {
                    if(arg0 <= 81) {
                        method1054((byte) -96);
                    }
                    MovedStatics.anInt2081 += CollisionMap.anInt141 * i;
                    int i_0_ = (-(2000 * CollisionMap.anInt141) + MovedStatics.anInt2081) / 1000;
                    if(i_0_ > 0) {
                        if(FloorDecoration.aClass40_Sub9_608 != null) {
                            FloorDecoration.aClass40_Sub9_608.method843(i_0_);
                        }
                        MovedStatics.anInt2081 -= i_0_ * 1000;
                    }
                }
            }
        }
    }

    public static void method1056(Component arg0, byte arg1) {
        arg0.addMouseListener(GameObject.frame);
        int i = -23 / ((-32 - arg1) / 47);
        arg0.addMouseMotionListener(GameObject.frame);
        arg0.addFocusListener(GameObject.frame);
        arg0.addMouseWheelListener(GameObject.frame);
    }

    public static void method1057(int arg0) {
        SceneCluster.aTimer_768.reset();
        for(int i = 0; i < 32; i++) {
            GameShell.aLongArray4[i] = 0L;
        }
        for(int i = 0; i < 32; i++) {
            MovedStatics.aLongArray1614[i] = 0L;
        }
        if(arg0 <= 67) {
            lastActiveInvInterface = -3;
        }
        Class40_Sub3.anInt2020 = 0;
    }

    /*synthetic*/
    public static Class method1058(String arg0) {
        try {
            return Class.forName(arg0);
        } catch(ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}
