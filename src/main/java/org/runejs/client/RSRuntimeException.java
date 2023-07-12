package org.runejs.client;

import org.runejs.client.scene.SceneCluster;

public class RSRuntimeException extends RuntimeException {
    public static int lastActiveInvInterface = 0;
    public static int anInt1651 = 0;
    public Throwable aThrowable1652;
    public String aString1653;

    public RSRuntimeException(Throwable arg0, String arg1) {
        aString1653 = arg1;
        aThrowable1652 = arg0;
    }

    public static void method1057(int arg0) {
        SceneCluster.gameTimer.reset();
        for(int i = 0; i < 32; i++)
            GameShell.tickSamples[i] = 0L;
        for(int i = 0; i < 32; i++)
            MovedStatics.tickSamples[i] = 0L;
        if(arg0 <= 67)
            lastActiveInvInterface = -3;
        MovedStatics.ticksPerLoop = 0;
    }
}
