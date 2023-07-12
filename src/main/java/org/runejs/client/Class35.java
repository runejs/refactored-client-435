package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;

public class Class35 implements Interface3 {
    public LinkedList textureCache = new LinkedList();
    public Texture[] textures;
    public int textureSize;
    public CacheArchive gameImageCacheArchive;
    public double brightness = 1.0;
    public int anInt1752;
    public int anInt1753;

    public Class35(CacheArchive gameTextureCacheArchive, CacheArchive gameImageCacheArchive, int arg2, double arg3, int arg4) {
        textureSize = 128;
        anInt1753 = 0;
        anInt1752 = arg2;
        this.gameImageCacheArchive = gameImageCacheArchive;
        brightness = arg3;
        textureSize = arg4;
        anInt1753 = anInt1752;
        int[] cacheTextures = gameTextureCacheArchive.method192(0, true);
        int textureCount = cacheTextures.length;
        textures = new Texture[gameTextureCacheArchive.fileLength(0)];
        for(int texturePointer = 0; textureCount > texturePointer; texturePointer++) {
            Buffer textureBuffer = new Buffer(gameTextureCacheArchive.getFile(0, cacheTextures[texturePointer]));
            textures[cacheTextures[texturePointer]] = new Texture(textureBuffer);
        }

    }
    
    public void clearTextures() {
        for(int i = 0; textures.length > i; i++) {
            if(textures[i] != null)
                textures[i].clearPixels();
        }
        textureCache = new LinkedList();
        anInt1753 = anInt1752;
    }

    public int[] getTexturePixels(int textureId) {
        Texture texture = textures[textureId];
        if (texture != null) {
            if (texture.pixels != null) {
                textureCache.addFirst(texture);
                texture.aBoolean2146 = true;
                return texture.pixels;
            }

            boolean bool = texture.method869(brightness, textureSize, gameImageCacheArchive);
            if (bool) {
                if (anInt1753 == 0) {
                    Texture class40_sub10_3_ = (Texture) textureCache.removeLast();
                    class40_sub10_3_.clearPixels();
                } else
                    anInt1753--;
                textureCache.addFirst(texture);
                texture.aBoolean2146 = true;
                return texture.pixels;
            }
        }
        return null;
    }

    public int getAverageTextureColour(int arg1) {
        if(textures[arg1] != null)
            return textures[arg1].anInt2137;
        return 0;
    }

    public boolean isTextureOpaque(int textureId) {
        return textures[textureId].opaque;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
        clearTextures();
    }

    public void animateTextures(int arg1) {
        int i = 0;
        for (/**/; i < textures.length; i++) {
            Texture texture = textures[i];
            if (texture != null && texture.animateDirection != 0 && texture.aBoolean2146) {
                texture.animate(arg1);
                texture.aBoolean2146 = false;
            }
        }
    }

    public boolean method15() {
        return textureSize == 64;
    }
}
