package org.runejs.client;

import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.scene.SceneCluster;

import java.awt.*;

public class RSRuntimeException extends RuntimeException {
    public static int anInt1641 = 0;
    public static int lastActiveInvInterface = 0;
    public static int anInt1651 = 0;
    public Throwable aThrowable1652;
    public String aString1653;

    public RSRuntimeException(Throwable arg0, String arg1) {
        aString1653 = arg1;
        aThrowable1652 = arg0;
    }

    public static void method1056(Component arg0, byte arg1) {
        arg0.addMouseListener(GameObject.frame);
        int i = -23 / ((-32 - arg1) / 47);
        arg0.addMouseMotionListener(GameObject.frame);
        arg0.addFocusListener(GameObject.frame);
        arg0.addMouseWheelListener(GameObject.frame);
    }

    public static void method1057(int arg0) {
        SceneCluster.gameTimer.reset();
        for(int i = 0; i < 32; i++)
            GameShell.tickSamples[i] = 0L;
        for(int i = 0; i < 32; i++)
            MovedStatics.tickSamples[i] = 0L;
        if(arg0 <= 67)
            lastActiveInvInterface = -3;
        Class40_Sub3.ticksPerLoop = 0;
    }
}
