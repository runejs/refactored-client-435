package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.GameObject;

public class Texture extends Node {
    public static int[] anIntArray2141;
    public int anInt2136;
    public int anInt2137;
    public int[] anIntArray2138;
    public int[] pixels_maybe;
    public int[] anIntArray2140;
    public int anInt2142;
    public boolean opaque;
    public int[] spriteIds;
    public int[] colors;
    public boolean aBoolean2146 = false;

    public Texture(Buffer textureBuffer) {
        anInt2137 = textureBuffer.getUnsignedShortBE();
        opaque = textureBuffer.getUnsignedByte() == 1;
        int i = textureBuffer.getUnsignedByte();
        if(i < 1 || i > 4)
            throw new RuntimeException();
        spriteIds = new int[i];
        for(int i_30_ = 0; i_30_ < i; i_30_++)
            spriteIds[i_30_] = textureBuffer.getUnsignedShortBE();
        if(i > 1) {
            anIntArray2140 = new int[i - 1];
            for(int i_31_ = 0; i_31_ < i - 1; i_31_++)
                anIntArray2140[i_31_] = textureBuffer.getUnsignedByte();
        }
        if(i > 1) {
            anIntArray2138 = new int[i - 1];
            for(int i_32_ = 0; i_32_ < i - 1; i_32_++)
                anIntArray2138[i_32_] = textureBuffer.getUnsignedByte();
        }
        colors = new int[i];
        for(int i_33_ = 0; i_33_ < i; i_33_++)
            colors[i_33_] = textureBuffer.getIntBE();
        anInt2136 = textureBuffer.getUnsignedByte();
        anInt2142 = textureBuffer.getUnsignedByte();
        pixels_maybe = null;
    }

    public void method868(int arg0) {
        if(pixels_maybe != null) {
            if(anInt2136 == 1 || anInt2136 == 3) {
                if(anIntArray2141 == null || anIntArray2141.length < pixels_maybe.length)
                    anIntArray2141 = new int[pixels_maybe.length];
                int i;
                if(pixels_maybe.length == 16384)
                    i = 64;
                else
                    i = 128;
                int i_0_ = pixels_maybe.length / 4;
                int i_1_ = i * arg0 * anInt2142;
                int i_2_ = i_0_ - 1;
                if(anInt2136 == 1)
                    i_1_ = -i_1_;
                for(int i_3_ = 0; i_3_ < i_0_; i_3_++) {
                    int i_4_ = i_3_ + i_1_ & i_2_;
                    anIntArray2141[i_3_] = pixels_maybe[i_4_];
                    anIntArray2141[i_3_ + i_0_] = pixels_maybe[i_4_ + i_0_];
                    anIntArray2141[i_3_ + i_0_ + i_0_] = pixels_maybe[i_4_ + i_0_ + i_0_];
                    anIntArray2141[i_3_ + i_0_ + i_0_ + i_0_] = pixels_maybe[i_4_ + i_0_ + i_0_ + i_0_];
                }
                int[] is = pixels_maybe;
                pixels_maybe = anIntArray2141;
                anIntArray2141 = is;
            }
            if(anInt2136 == 2 || anInt2136 == 4) {
                if(anIntArray2141 == null || anIntArray2141.length < pixels_maybe.length)
                    anIntArray2141 = new int[pixels_maybe.length];
                int i;
                if(pixels_maybe.length == 16384)
                    i = 64;
                else
                    i = 128;
                int i_5_ = pixels_maybe.length / 4;
                int i_6_ = arg0 * anInt2142;
                int i_7_ = i - 1;
                if(anInt2136 == 2)
                    i_6_ = -i_6_;
                for(int i_8_ = 0; i_8_ < i_5_; i_8_ += i) {
                    for(int i_9_ = 0; i_9_ < i; i_9_++) {
                        int i_10_ = i_8_ + i_9_;
                        int i_11_ = i_8_ + (i_9_ + i_6_ & i_7_);
                        anIntArray2141[i_10_] = pixels_maybe[i_11_];
                        anIntArray2141[i_10_ + i_5_] = pixels_maybe[i_11_ + i_5_];
                        anIntArray2141[i_10_ + i_5_ + i_5_] = pixels_maybe[i_11_ + i_5_ + i_5_];
                        anIntArray2141[i_10_ + i_5_ + i_5_ + i_5_] = pixels_maybe[i_11_ + i_5_ + i_5_ + i_5_];
                    }
                }
                int[] is = pixels_maybe;
                pixels_maybe = anIntArray2141;
                anIntArray2141 = is;
            }
        }
    }

    public boolean method869(double arg0, int textureSize, CacheArchive imageArchive) {
        for(int i = 0; i < spriteIds.length; i++) {
            if(imageArchive.method193(spriteIds[i]) == null)
                return false;
        }
        int i = textureSize * textureSize;
        pixels_maybe = new int[i * 4];
        for(int i_12_ = 0; i_12_ < spriteIds.length; i_12_++) {
            IndexedImage image = GameObject.method769(2, imageArchive, spriteIds[i_12_]);
            image.resizeToLibSize();
            byte[] imgPixels = image.imgPixels;
            int[] imgPalette = image.palette;
            int color = colors[i_12_];
            if((color & ~0xffffff) == 50331648) {
                int i_15_ = color & 0xff00ff;
                int i_16_ = color >> 8 & 0xff;
                for(int i_17_ = 0; i_17_ < imgPalette.length; i_17_++) {
                    int i_18_ = imgPalette[i_17_];
                    if((i_18_ & 0xffff) == i_18_ >> 8) {
                        i_18_ &= 0xff;
                        imgPalette[i_17_] = i_15_ * i_18_ >> 8 & 0xff00ff | i_16_ * i_18_ & 0xff00;
                    }
                }
            }
            for(int i_19_ = 0; i_19_ < imgPalette.length; i_19_++)
                imgPalette[i_19_] = Rasterizer3D.adjustBrightness(imgPalette[i_19_], arg0);
            int i_20_;
            if(i_12_ == 0)
                i_20_ = 0;
            else
                i_20_ = anIntArray2140[i_12_ - 1];
            if(i_20_ == 0) {
                if(image.imgWidth == textureSize) {
                    for(int i_21_ = 0; i_21_ < i; i_21_++)
                        pixels_maybe[i_21_] = imgPalette[imgPixels[i_21_] & 0xff];
                } else if(image.imgWidth == 64 && textureSize == 128) {
                    int i_22_ = 0;
                    for(int i_23_ = 0; i_23_ < textureSize; i_23_++) {
                        for(int i_24_ = 0; i_24_ < textureSize; i_24_++)
                            pixels_maybe[i_22_++] = imgPalette[imgPixels[(i_24_ >> 1) + (i_23_ >> 1 << 6)] & 0xff];
                    }
                } else if(image.imgWidth == 128 && textureSize == 64) {
                    int i_25_ = 0;
                    for(int i_26_ = 0; i_26_ < textureSize; i_26_++) {
                        for(int i_27_ = 0; i_27_ < textureSize; i_27_++)
                            pixels_maybe[i_25_++] = imgPalette[imgPixels[(i_27_ << 1) + (i_26_ << 1 << 7)] & 0xff];
                    }
                } else
                    throw new RuntimeException();
            }
        }
        for(int pixelIndex = 0; pixelIndex < i; pixelIndex++) {
            pixels_maybe[pixelIndex] &= 0xf8f8ff;
            int pixel = pixels_maybe[pixelIndex];
            pixels_maybe[pixelIndex + i] = pixel - (pixel >>> 3) & 0xf8f8ff;
            pixels_maybe[pixelIndex + i + i] = pixel - (pixel >>> 2) & 0xf8f8ff;
            pixels_maybe[pixelIndex + i + i + i] = pixel - (pixel >>> 2) - (pixel >>> 3) & 0xf8f8ff;
        }
        return true;
    }

    public void clearPixels() {
        pixels_maybe = null;
    }
}
