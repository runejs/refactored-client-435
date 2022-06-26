package org.runejs.client;

import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.scene.Scene;

public class Class65 {
    public static int cameraVertical;

    static {
        cameraVertical = 128;
    }


    public static void method1018() {
        MovedStatics.gameScreenImageProducer.prepareRasterizer();
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(Class24.fullScreenTextureArray);
    }

    public static void method1019(int arg0) {
        if(MovedStatics.aClass22_189 != null) {
            Class22.method308();
            if(arg0 == 104) {
                if(RSCanvas.anInt54 > 0) {
                    MovedStatics.aClass22_189.method301(256, 0);
                    RSCanvas.anInt54 = 0;
                }
                MovedStatics.aClass22_189.method306((byte) 101);
                MovedStatics.aClass22_189 = null;
            }
        }
    }

    public static void method1020() {
        Scene.lightnessBuffer = new int[104];
        Scene.tileUnderlayPaths = new byte[4][104][104];
        MovedStatics.anIntArrayArrayArray262 = new int[4][105][105];
        MovedStatics.lowestPlane = 99;
        Scene.objectShadowData = new byte[4][105][105];
        Scene.bufferLength = new int[104];
        Scene.hueMultiplierBuffer = new int[104];
        Scene.saturationBuffer = new int[104];
        Scene.tileLightness = new int[105][105];
        Scene.tileOverlayIds = new byte[4][104][104];
        Scene.hueBuffer = new int[104];
        Scene.tileOverlayRotations = new byte[4][104][104];
        Scene.tileUnderlayIds = new byte[4][104][104];
    }
}
