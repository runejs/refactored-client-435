package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.GameObject;

public class Texture extends Node {
    public static int[] pixelBuffer;
    public int direction;
    public int rgb;
    public int[] unusedArray;
    public int[] pixels;
    public int[] renderTypes;
    public int speed;
    public boolean opaque;
    public int[] spriteIds;
    public int[] colors;
    public boolean aBoolean2146 = false;

    public Texture(Buffer buffer) {
        rgb = buffer.getUnsignedShortBE();
        opaque = buffer.getUnsignedByte() == 1;
        int spriteCount = buffer.getUnsignedByte();
        if(spriteCount < 1 || spriteCount > 4)
            throw new RuntimeException();
        spriteIds = new int[spriteCount];
        for(int i = 0; i < spriteCount; i++)
            spriteIds[i] = buffer.getUnsignedShortBE();
        if(spriteCount > 1) {
            renderTypes = new int[spriteCount - 1];
            for(int i = 0; i < spriteCount - 1; i++)
                renderTypes[i] = buffer.getUnsignedByte();
        }
        if(spriteCount > 1) {
            unusedArray = new int[spriteCount - 1];
            for(int i = 0; i < spriteCount - 1; i++)
                unusedArray[i] = buffer.getUnsignedByte();
        }
        colors = new int[spriteCount];
        for(int i = 0; i < spriteCount; i++)
            colors[i] = buffer.getIntBE();
        direction = buffer.getUnsignedByte();
        speed = buffer.getUnsignedByte();
        pixels = null;
    }

    public void method868(int arg0) {
        if(pixels != null) {
            if(direction == 1 || direction == 3) {
                if(pixelBuffer == null || pixelBuffer.length < pixels.length)
                    pixelBuffer = new int[pixels.length];
                int i;
                if(pixels.length == 16384)
                    i = 64;
                else
                    i = 128;
                int i_0_ = pixels.length / 4;
                int i_1_ = i * arg0 * speed;
                int i_2_ = i_0_ - 1;
                if(direction == 1)
                    i_1_ = -i_1_;
                for(int i_3_ = 0; i_3_ < i_0_; i_3_++) {
                    int i_4_ = i_3_ + i_1_ & i_2_;
                    pixelBuffer[i_3_] = pixels[i_4_];
                    pixelBuffer[i_3_ + i_0_] = pixels[i_4_ + i_0_];
                    pixelBuffer[i_3_ + i_0_ + i_0_] = pixels[i_4_ + i_0_ + i_0_];
                    pixelBuffer[i_3_ + i_0_ + i_0_ + i_0_] = pixels[i_4_ + i_0_ + i_0_ + i_0_];
                }
                int[] is = pixels;
                pixels = pixelBuffer;
                pixelBuffer = is;
            }
            if(direction == 2 || direction == 4) {
                if(pixelBuffer == null || pixelBuffer.length < pixels.length)
                    pixelBuffer = new int[pixels.length];
                int i;
                if(pixels.length == 16384)
                    i = 64;
                else
                    i = 128;
                int i_5_ = pixels.length / 4;
                int i_6_ = arg0 * speed;
                int i_7_ = i - 1;
                if(direction == 2)
                    i_6_ = -i_6_;
                for(int i_8_ = 0; i_8_ < i_5_; i_8_ += i) {
                    for(int i_9_ = 0; i_9_ < i; i_9_++) {
                        int i_10_ = i_8_ + i_9_;
                        int i_11_ = i_8_ + (i_9_ + i_6_ & i_7_);
                        pixelBuffer[i_10_] = pixels[i_11_];
                        pixelBuffer[i_10_ + i_5_] = pixels[i_11_ + i_5_];
                        pixelBuffer[i_10_ + i_5_ + i_5_] = pixels[i_11_ + i_5_ + i_5_];
                        pixelBuffer[i_10_ + i_5_ + i_5_ + i_5_] = pixels[i_11_ + i_5_ + i_5_ + i_5_];
                    }
                }
                int[] is = pixels;
                pixels = pixelBuffer;
                pixelBuffer = is;
            }
        }
    }

    public boolean method869(double arg0, int arg1, CacheArchive arg2) {
        for(int i = 0; i < spriteIds.length; i++) {
            if(arg2.method193(spriteIds[i]) == null)
                return false;
        }
        int i = arg1 * arg1;
        pixels = new int[i * 4];
        for(int i_12_ = 0; i_12_ < spriteIds.length; i_12_++) {
            IndexedImage indexedImage = GameObject.method769(2, arg2, spriteIds[i_12_]);
            indexedImage.resizeToLibSize();
            byte[] is = indexedImage.imgPixels;
            int[] is_13_ = indexedImage.palette;
            int i_14_ = colors[i_12_];
            if((i_14_ & ~0xffffff) == 50331648) {
                int i_15_ = i_14_ & 0xff00ff;
                int i_16_ = i_14_ >> 8 & 0xff;
                for(int i_17_ = 0; i_17_ < is_13_.length; i_17_++) {
                    int i_18_ = is_13_[i_17_];
                    if((i_18_ & 0xffff) == i_18_ >> 8) {
                        i_18_ &= 0xff;
                        is_13_[i_17_] = i_15_ * i_18_ >> 8 & 0xff00ff | i_16_ * i_18_ & 0xff00;
                    }
                }
            }
            for(int i_19_ = 0; i_19_ < is_13_.length; i_19_++)
                is_13_[i_19_] = Rasterizer3D.method707(is_13_[i_19_], arg0);
            int i_20_;
            if(i_12_ == 0)
                i_20_ = 0;
            else
                i_20_ = renderTypes[i_12_ - 1];
            if(i_20_ == 0) {
                if(indexedImage.imgWidth == arg1) {
                    for(int i_21_ = 0; i_21_ < i; i_21_++)
                        pixels[i_21_] = is_13_[is[i_21_] & 0xff];
                } else if(indexedImage.imgWidth == 64 && arg1 == 128) {
                    int i_22_ = 0;
                    for(int i_23_ = 0; i_23_ < arg1; i_23_++) {
                        for(int i_24_ = 0; i_24_ < arg1; i_24_++)
                            pixels[i_22_++] = is_13_[is[(i_24_ >> 1) + (i_23_ >> 1 << 6)] & 0xff];
                    }
                } else if(indexedImage.imgWidth == 128 && arg1 == 64) {
                    int i_25_ = 0;
                    for(int i_26_ = 0; i_26_ < arg1; i_26_++) {
                        for(int i_27_ = 0; i_27_ < arg1; i_27_++)
                            pixels[i_25_++] = is_13_[is[(i_27_ << 1) + (i_26_ << 1 << 7)] & 0xff];
                    }
                } else
                    throw new RuntimeException();
            }
        }
        for(int i_28_ = 0; i_28_ < i; i_28_++) {
            pixels[i_28_] &= 0xf8f8ff;
            int i_29_ = pixels[i_28_];
            pixels[i_28_ + i] = i_29_ - (i_29_ >>> 3) & 0xf8f8ff;
            pixels[i_28_ + i + i] = i_29_ - (i_29_ >>> 2) & 0xf8f8ff;
            pixels[i_28_ + i + i + i] = i_29_ - (i_29_ >>> 2) - (i_29_ >>> 3) & 0xf8f8ff;
        }
        return true;
    }

    public void resetPixels() {
        pixels = null;
    }
}
