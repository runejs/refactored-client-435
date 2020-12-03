package com.jagex.runescape;

import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;

public class Class65 {
    public static int cameraVertical;

    static {
        cameraVertical = 128;
    }


    public static void method1018() {
        VarbitDefinition.gameScreenImageProducer.prepareRasterizer();
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
        Class59.anIntArray1398 = new int[104];
        OverlayDefinition.tile_underlay_path = new byte[4][104][104];
        MovedStatics.anIntArrayArrayArray262 = new int[4][105][105];
        Class64.lowestPlane = 99;
        InteractiveObject.aByteArrayArrayArray492 = new byte[4][105][105];
        FloorDecoration.anIntArray612 = new int[104];
        MovedStatics.anIntArray1579 = new int[104];
        SceneTile.anIntArray2048 = new int[104];
        AnimationSequence.anIntArrayArray2490 = new int[105][105];
        MouseHandler.tile_overlayids = new byte[4][104][104];
        Class40_Sub5_Sub17_Sub6.anIntArray3250 = new int[104];
        Class35.tile_overlay_rotation = new byte[4][104][104];
        Class42.tile_underlayids = new byte[4][104][104];
    }
}
