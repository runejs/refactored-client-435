package org.runejs.client;

import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.scene.InteractiveObject;

public class Class65 {
    public static void method1018() {
        MovedStatics.gameScreenImageProducer.prepareRasterizer();
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(Class24.fullScreenTextureArray);
    }

    public static void method1020() {
        Landscape.blendedSaturation = new int[104];
        OverlayDefinition.tile_underlay_path = new byte[4][104][104];
        MovedStatics.tileCullingBitsets = new int[4][105][105];
        MovedStatics.lowestPlane = 99;
        InteractiveObject.tileShadowIntensity = new byte[4][105][105];
        Landscape.blendDirectionTracker = new int[104];
        Landscape.blendedHueMultiplier = new int[104];
        Landscape.blendedLightness = new int[104];
        AnimationSequence.tileLightIntensity = new int[105][105];
        MouseHandler.tile_overlayids = new byte[4][104][104];
        Landscape.blendedHue = new int[104];
        Class35.tile_overlay_rotation = new byte[4][104][104];
        MovedStatics.tile_underlayids = new byte[4][104][104];
    }
}
