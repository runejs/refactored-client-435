package com.jagex.runescape;

public class IndexedImage extends Rasterizer {
    public int imgWidth;
    public int[] palette;
    public int maxWidth;
    public int maxHeight;
    public byte[] imgPixels;
    public int imgHeight;
    public int yDrawOffset;
    public int xDrawOffset;

    public IndexedImage() {
        /* empty */
    }

    public IndexedImage(int arg0, int arg1, int arg2) {
        maxWidth = imgWidth = arg0;
        maxHeight = imgHeight = arg1;
        xDrawOffset = yDrawOffset = 0;
        imgPixels = new byte[arg0 * arg1];
        palette = new int[arg2];
    }

    public IndexedImage method691() {
        IndexedImage class40_sub5_sub14_sub2 = new IndexedImage(imgWidth, imgHeight, palette.length);
        class40_sub5_sub14_sub2.maxWidth = maxWidth;
        class40_sub5_sub14_sub2.maxHeight = maxHeight;
        class40_sub5_sub14_sub2.xDrawOffset = xDrawOffset;
        class40_sub5_sub14_sub2.yDrawOffset = yDrawOffset;
        int i = imgPixels.length;
        for(int i_0_ = 0; i_0_ < i; i_0_++)
            class40_sub5_sub14_sub2.imgPixels[i_0_] = imgPixels[i_0_];
        i = palette.length;
        for(int i_1_ = 0; i_1_ < i; i_1_++)
            class40_sub5_sub14_sub2.palette[i_1_] = palette[i_1_];
        return class40_sub5_sub14_sub2;
    }

    public void drawImage(int x, int y) {
        x += xDrawOffset;
        y += yDrawOffset;
        int rasterizerOffset = x + y * Rasterizer.width;
        int pixelOffset = 0;
        int imageHeight = imgHeight;
        int imageWidth = imgWidth;
        int deviation = Rasterizer.width - imageWidth;
        int originalDeviation = 0;
        if(y < Rasterizer.viewport_top) {
            int yOffset = Rasterizer.viewport_top - y;
            imageHeight -= yOffset;
            y = Rasterizer.viewport_top;
            pixelOffset += yOffset * imageWidth;
            rasterizerOffset += yOffset * Rasterizer.width;
        }
        if(y + imageHeight > Rasterizer.viewport_bottom)
            imageHeight -= y + imageHeight - Rasterizer.viewport_bottom;
        if(x < Rasterizer.viewport_left) {
            int xOffset = Rasterizer.viewport_left - x;
            imageWidth -= xOffset;
            x = Rasterizer.viewport_left;
            pixelOffset += xOffset;
            rasterizerOffset += xOffset;
            originalDeviation += xOffset;
            deviation += xOffset;
        }
        if(x + imageWidth > Rasterizer.viewport_right) {
            int xOffset = x + imageWidth - Rasterizer.viewport_right;
            imageWidth -= xOffset;
            originalDeviation += xOffset;
            deviation += xOffset;
        }
        if(imageWidth > 0 && imageHeight > 0)
            ImageRGB.shapeImageToPixels(imgPixels, Rasterizer.pixels, pixelOffset, rasterizerOffset, imageWidth, imageHeight, deviation, originalDeviation, palette);
    }

    public void resizeToLibSize() {
        if(imgWidth != maxWidth || imgHeight != maxHeight) {
            byte[] resizedPixels = new byte[maxWidth * maxHeight];
            int pixelCount = 0;
            for(int y = 0; y < imgHeight; y++) {
                for(int x = 0; x < imgWidth; x++)
                    resizedPixels[x + xDrawOffset + (y + yDrawOffset) * maxWidth] = imgPixels[pixelCount++];
            }
            imgPixels = resizedPixels;
            imgWidth = maxWidth;
            imgHeight = maxHeight;
            xDrawOffset = 0;
            yDrawOffset = 0;
        }
    }

    public void flipHorizontal() {
        byte[] flippedPixels = new byte[imgWidth * imgHeight];
        int pixelCount = 0;
        for(int y = 0; y < imgHeight; y++) {
            for(int x = imgWidth - 1; x >= 0; x--)
                flippedPixels[pixelCount++] = imgPixels[x + y * imgWidth];
        }
        imgPixels = flippedPixels;
        xDrawOffset = maxWidth - imgWidth - xDrawOffset;
    }

    public void flipVertical() {
        byte[] flippedPixels = new byte[imgWidth * imgHeight];
        int pixelCount = 0;
        for(int y = imgHeight - 1; y >= 0; y--) {
            for(int x = 0; x < imgWidth; x++)
                flippedPixels[pixelCount++] = imgPixels[x + y * imgWidth];
        }
        imgPixels = flippedPixels;
        yDrawOffset = maxHeight - imgHeight - yDrawOffset;
    }

    public void mixPalette(int red, int green, int blue) {
        for(int index = 0; index < palette.length; index++) {
            int r = palette[index] >> 16 & 0xff;
            r += red;
            if(r < 0)
                r = 0;
            else if(r > 255)
                r = 255;
            int g = palette[index] >> 8 & 0xff;
            g += green;
            if(g < 0)
                g = 0;
            else if(g > 255)
                g = 255;
            int b = palette[index] & 0xff;
            b += blue;
            if(b < 0)
                b = 0;
            else if(b > 255)
                b = 255;
            palette[index] = (r << 16) + (g << 8) + b;
        }
    }
}
