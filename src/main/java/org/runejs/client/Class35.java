package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.io.Buffer;

public class Class35 implements Interface3 {
    public static int anInt1730 = 0;
    public static boolean aBoolean1734 = false;
    public static boolean aBoolean1735 = true;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1744;
    public static byte[][][] tile_overlay_rotation;

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

    public static Class40_Sub5_Sub15 method421(CacheArchive skeletonArchive, int arg2, CacheArchive skinArchive, boolean arg4) {
        boolean bool = true;
        int[] is = skeletonArchive.method192(arg2, true);
        for(int i = 0; is.length > i; i++) {
            byte[] is_0_ = skeletonArchive.method182(is[i], arg2);
            if(is_0_ == null)
                bool = false;
            else {
                int i_1_ = 0xff & is_0_[1] | (0xff & is_0_[0]) << 8;
                byte[] is_2_;
                if(arg4)
                    is_2_ = skinArchive.method182(i_1_, 0);
                else
                    is_2_ = skinArchive.method182(0, i_1_);
                if(is_2_ == null)
                    bool = false;
            }
        }
        if(!bool)
            return null;
        try {
            return new Class40_Sub5_Sub15(skeletonArchive, skinArchive, arg2, arg4);
        } catch(Exception exception) {
            return null;
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

    public int[] getTexturePixels(int junk, int textureId) {
        Texture texture = textures[textureId];
        if (texture != null) {
            if (texture.pixels_maybe != null) {
                textureCache.addFirst(0, texture);
                texture.aBoolean2146 = true;
                return texture.pixels_maybe;
            }

            boolean bool = texture.method869(brightness, textureSize, gameImageCacheArchive);
            if (bool) {
                if (anInt1753 == 0) {
                    Texture class40_sub10_3_ = (Texture) textureCache.removeLast((byte) 87);
                    class40_sub10_3_.clearPixels();
                } else
                    anInt1753--;
                textureCache.addFirst(0, texture);
                texture.aBoolean2146 = true;
                return texture.pixels_maybe;
            }
        }
        return null;
    }

    public int getAverageTextureColour(boolean arg0, int arg1) {
        if(!arg0)
            return 115;
        if(textures[arg1] != null)
            return textures[arg1].anInt2137;
        return 0;
    }

    public boolean isTextureOpaque(byte arg0, int textureId) {
        if(arg0 > -99)
            return true;
        return textures[textureId].opaque;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
        clearTextures();
    }

    public void method425(byte arg0, int arg1) {
        int i = 0;
        if(arg0 == 6) {
            for(/**/; i < textures.length; i++) {
                Texture class40_sub10 = textures[i];
                if(class40_sub10 != null && class40_sub10.anInt2136 != 0 && class40_sub10.aBoolean2146) {
                    class40_sub10.method868(arg1);
                    class40_sub10.aBoolean2146 = false;
                }
            }
        }
    }

    public boolean method15(int arg0, byte arg1) {
        if(arg1 != -90)
            return false;
        return textureSize == 64;
    }
}
