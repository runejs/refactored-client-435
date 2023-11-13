package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.loading.CacheDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.OverlayDefinitionLoader;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class OverlayDefinition extends CachedNode implements CacheDefinition {
    public static DefinitionLoader<OverlayDefinition> loader = new OverlayDefinitionLoader();

    private static NodeCache definitionCache = new NodeCache(64);
    private static CacheArchive definitionArchive;

    public int saturation;
    public int texture;
    public int otherSaturation;
    public int hue;
    public int otherHue;
    public int secondaryColor;
    public int lightness;
    public boolean hideOverlay = true;
    public int color;
    public int otherLightness;
    public int id;

    public OverlayDefinition() {
        texture = -1;
        secondaryColor = -1;
        color = 0;
    }

    public static OverlayDefinition getDefinition(int id, int archiveId) {
        OverlayDefinition overlayDefinition = (OverlayDefinition) definitionCache.get(id);
        if(overlayDefinition != null)
            return overlayDefinition;
        byte[] is = definitionArchive.getFile(archiveId, id);
        overlayDefinition = new OverlayDefinition();
        overlayDefinition.id = id;
        if(is != null) {
            loader.load(overlayDefinition, new Buffer(is));
        }
        overlayDefinition.calculateHsl();
        definitionCache.put(id, overlayDefinition);
        return overlayDefinition;
    }

    public static void initializeOverlayDefinitionCache(CacheArchive cacheArchive) {
        definitionArchive = cacheArchive;
    }

    public static void clearOverlayDefinitionCache() {
        definitionCache.clear();
    }

    public void calculateHsl() {
        if (secondaryColor != -1) {
            calculateHsl(secondaryColor);
            otherSaturation = saturation;
            otherLightness = lightness;
            otherHue = hue;
        }
        calculateHsl(color);
    }

    public void calculateHsl(int color) {
        double r = (double) (0xff & color >> 16) / 256.0;
        double g = (double) ((0xff2d & color) >> 8) / 256.0;
        double b = (double) (0xff & color) / 256.0;
        double var10 = r;
        if (g < var10)
            var10 = g;
        if (var10 > b)
            var10 = b;
        double var11 = r;
        if (g > var11)
            var11 = g;
        double var12 = 0.0;
        double var16 = 0.0;
        if (b > var11)
            var11 = b;
        double var14 = (var11 + var10) / 2.0;
        if (var10 != var11) {
            if (var14 < 0.5)
                var16 = (var11 - var10) / (var11 + var10);
            if (var14 >= 0.5)
                var16 = (-var10 + var11) / (-var10 + (2.0 - var11));
            if (var11 != r) {
                if (g == var11)
                    var12 = 2.0 + (b - r) / (var11 - var10);
                else if (var11 == b)
                    var12 = (-g + r) / (-var10 + var11) + 4.0;
            } else
                var12 = (g - b) / (var11 - var10);
        }
        var12 /= 6.0;
        hue = (int) (var12 * 256.0);
        saturation = (int) (256.0 * var14);
        lightness = (int) (var16 * 256.0);
        if (lightness < 0)
            lightness = 0;
        else if (lightness > 255)
            lightness = 255;
        if (saturation < 0)
            saturation = 0;
        else if (saturation > 255)
            saturation = 255;
    }

    @Override
    public int getId() { return this.id; }
}
