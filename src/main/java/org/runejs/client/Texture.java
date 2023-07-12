package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.Rasterizer3D;

public class Texture extends Node {
    /**
     * Temporary array used while animating textures.
     */
    public static int[] animationPixels;
    /**
     * Which direction should the texture move in?
     *
     * 1: down
     * 2: left
     * 3: up
     * 4: right
     */
    public int animateDirection;
    public int anInt2137;
    public int[] anIntArray2138;
    public int[] pixels;
    public int[] anIntArray2140;
    public int animateSpeed;
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
        animateDirection = textureBuffer.getUnsignedByte();
        animateSpeed = textureBuffer.getUnsignedByte();
        pixels = null;
    }

    public void animate(int deltaT) {
        if (pixels == null) {
            return;
        }

        if (animationPixels == null || animationPixels.length < pixels.length)
            animationPixels = new int[pixels.length];

        int dimension;
        if (pixels.length == 16384)
            dimension = 64;
        else
            dimension = 128;

        // TODO (jkm) what is this quarterLength? Are there 4 "channels" (i.e. rgb (a?)) in the pixel array?
        int quarterLength = pixels.length / 4;

        // up or down
        if (animateDirection == 1 || animateDirection == 3) {
            int offset = dimension * deltaT * animateSpeed;
            int i_2_ = quarterLength - 1;
            if (animateDirection == 1)
                offset = -offset;
            for (int counter = 0; counter < quarterLength; counter++) {
                int index = counter + offset & i_2_;
                animationPixels[counter] = pixels[index];
                animationPixels[counter + quarterLength] = pixels[index + quarterLength];
                animationPixels[counter + quarterLength + quarterLength] = pixels[index + quarterLength + quarterLength];
                animationPixels[counter + quarterLength + quarterLength + quarterLength] = pixels[index + quarterLength + quarterLength + quarterLength];
            }
        }
        // left or right
        if (animateDirection == 2 || animateDirection == 4) {
            int offset = deltaT * animateSpeed;
            int i_7_ = dimension - 1;
            if (animateDirection == 2)
                offset = -offset;
            for (int counter = 0; counter < quarterLength; counter += dimension) {
                for (int d = 0; d < dimension; d++) {
                    int index = counter + d;
                    int otherIndex = counter + (d + offset & i_7_);
                    animationPixels[index] = pixels[otherIndex];
                    animationPixels[index + quarterLength] = pixels[otherIndex + quarterLength];
                    animationPixels[index + quarterLength + quarterLength] = pixels[otherIndex + quarterLength + quarterLength];
                    animationPixels[index + quarterLength + quarterLength + quarterLength] = pixels[otherIndex + quarterLength + quarterLength + quarterLength];
                }
            }
        }

        int[] tmp = pixels;
        pixels = animationPixels;
        animationPixels = tmp;
    }

    public boolean method869(double arg0, int textureSize, CacheArchive imageArchive) {
        for(int i = 0; i < spriteIds.length; i++) {
            if(imageArchive.method193(spriteIds[i]) == null)
                return false;
        }
        int i = textureSize * textureSize;
        pixels = new int[i * 4];
        for(int i_12_ = 0; i_12_ < spriteIds.length; i_12_++) {
            IndexedImage image = MovedStatics.method769(2, imageArchive, spriteIds[i_12_]);
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
                        pixels[i_21_] = imgPalette[imgPixels[i_21_] & 0xff];
                } else if(image.imgWidth == 64 && textureSize == 128) {
                    int i_22_ = 0;
                    for(int i_23_ = 0; i_23_ < textureSize; i_23_++) {
                        for(int i_24_ = 0; i_24_ < textureSize; i_24_++)
                            pixels[i_22_++] = imgPalette[imgPixels[(i_24_ >> 1) + (i_23_ >> 1 << 6)] & 0xff];
                    }
                } else if(image.imgWidth == 128 && textureSize == 64) {
                    int i_25_ = 0;
                    for(int i_26_ = 0; i_26_ < textureSize; i_26_++) {
                        for(int i_27_ = 0; i_27_ < textureSize; i_27_++)
                            pixels[i_25_++] = imgPalette[imgPixels[(i_27_ << 1) + (i_26_ << 1 << 7)] & 0xff];
                    }
                } else
                    throw new RuntimeException();
            }
        }
        for(int pixelIndex = 0; pixelIndex < i; pixelIndex++) {
            pixels[pixelIndex] &= 0xf8f8ff;
            int pixel = pixels[pixelIndex];
            pixels[pixelIndex + i] = pixel - (pixel >>> 3) & 0xf8f8ff;
            pixels[pixelIndex + i + i] = pixel - (pixel >>> 2) & 0xf8f8ff;
            pixels[pixelIndex + i + i + i] = pixel - (pixel >>> 2) - (pixel >>> 3) & 0xf8f8ff;
        }
        return true;
    }

    public void clearPixels() {
        pixels = null;
    }
}
