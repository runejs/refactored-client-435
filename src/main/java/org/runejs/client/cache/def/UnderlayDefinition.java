package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.loading.CacheDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.UnderlayDefinitionLoader;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class UnderlayDefinition extends CachedNode implements CacheDefinition {
    public static DefinitionLoader<UnderlayDefinition> loader = new UnderlayDefinitionLoader();
    private static NodeCache definitionCache = new NodeCache(64);
    private static CacheArchive definitionArchive;

    public int id;
    public int lightness;
    public int hue;
    public int hueMultiplier;
    public int saturation;
    public int color = 0;

    public static void initializeUnderlayDefinitionCache(CacheArchive cacheArchive) {
        definitionArchive = cacheArchive;
    }

    public static UnderlayDefinition getDefinition(int underlayId) {
        UnderlayDefinition underlayDefinition = (UnderlayDefinition) definitionCache.get(underlayId);
        if (underlayDefinition != null)
            return underlayDefinition;
        byte[] is = definitionArchive.getFile(1, underlayId);
        underlayDefinition = new UnderlayDefinition();
        underlayDefinition.id = underlayId;
        if (is != null) {
            loader.load(underlayDefinition, new Buffer(is));
        }
        underlayDefinition.calculateHsl();
        definitionCache.put(underlayId, underlayDefinition);
        return underlayDefinition;
    }

    public static void clearUnderlayDefinitionCache() {
        definitionCache.clear();
    }


    public void calculateHsl() {
        double r = (double) (color >> 16 & 0xff) / 256.0;
        double g = (double) ((color & 0xff68) >> 8) / 256.0;
        double b = (double) (color & 0xff) / 256.0;
        double cmin = r;
        if(cmin > g) {
            cmin = g;
        }
        if(b < cmin) {
            cmin = b;
        }
        double cmax = r;
        if(cmax < g) {
            cmax = g;
        }
        double h = 0.0;
        if(cmax < b) {
            cmax = b;
        }
        double l = (cmax + cmin) / 2.0;
        lightness = (int) (l * 256.0);
        double s = 0.0;

        if(cmax != cmin) {
            if(l < 0.5) {
                s = (cmax - cmin) / (cmax + cmin);
            }
            if(l >= 0.5) {
                s = (-cmin + cmax) / (-cmin + (-cmax + 2.0));
            }
            if(r == cmax) {
                h = (-b + g) / (-cmin + cmax);
            } else if(cmax == g) {
                h = 2.0 + (b - r) / (cmax - cmin);
            } else if(cmax == b) {
                h = (r - g) / (-cmin + cmax) + 4.0;
            }
        }

        h /= 6.0;

        if(lightness >= 0) {
            if(lightness > 255) {
                lightness = 255;
            }
        } else {
            lightness = 0;
        }
        if(l > 0.5) {
            hueMultiplier = (int) ((-l + 1.0) * s * 512.0);
        } else {
            hueMultiplier = (int) (l * s * 512.0);
        }
        saturation = (int) (256.0 * s);
        if(hueMultiplier < 1) {
            hueMultiplier = 1;
        }
        hue = (int) (h * (double) hueMultiplier);
        if(saturation >= 0) {
            if(saturation > 255) {
                saturation = 255;
            }
        } else {
            saturation = 0;
        }
    }

    @Override
    public int getId() { return this.id; }
}
