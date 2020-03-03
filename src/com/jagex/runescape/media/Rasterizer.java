package com.jagex.runescape.media;

import com.jagex.runescape.SubNode;

public class Rasterizer extends SubNode {
    public static int[] pixels;
    public static int viewport_top = 0;
    public static int width;
    public static int height;
    public static int viewport_bottom;
    public static int viewport_left;
    public static int viewport_right = 0;

    static {
        viewport_left = 0;
        viewport_bottom = 0;
    }

    public static void drawUnfilledRectangleAlpha(int x, int y, int width, int height, int colour, int alpha) {
        drawHorizontalLineAlpha(x, y, width, colour, alpha);
        drawHorizontalLineAlpha(x, y + height - 1, width, colour, alpha);
        if(height >= 3) {
            drawVerticalLineAlpha(x, y + 1, height - 2, colour, alpha);
            drawVerticalLineAlpha(x + width - 1, y + 1, height - 2, colour, alpha);
        }
    }

    public static void setCoordinates(int arg0, int arg1, int height, int width) {
        if(arg0 < 0)
            arg0 = 0;
        if(arg1 < 0)
            arg1 = 0;
        if(width > width)
            width = width;
        if(height > Rasterizer.height)
            height = Rasterizer.height;
        viewport_left = arg0;
        viewport_top = arg1;
        viewport_right = width;
        viewport_bottom = height;
    }

    public static void drawFilledRectangle(int x, int y, int width, int height, int colour) {
        if(x < viewport_left) {
            width -= viewport_left - x;
            x = viewport_left;
        }
        if(y < viewport_top) {
            height -= viewport_top - y;
            y = viewport_top;
        }
        if(x + width > viewport_right)
            width = viewport_right - x;
        if(y + height > viewport_bottom)
            height = viewport_bottom - y;
        int pixelOffset = Rasterizer.width - width;
        int pixel = x + y * Rasterizer.width;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++)
                pixels[pixel++] = colour;
            pixel += pixelOffset;
        }
    }

    public static void method657(int[] arg0) {
        viewport_left = arg0[0];
        viewport_top = arg0[1];
        viewport_right = arg0[2];
        viewport_bottom = arg0[3];
    }

    public static void drawHorizontalLineAlpha(int x, int y, int length, int arg3, int alpha) {
        if(y < viewport_top || y >= viewport_bottom) {
            return;
        }
        if(x < viewport_left) {
            length -= viewport_left - x;
            x = viewport_left;
        }
        if(x + length > viewport_right)
            length = viewport_right - x;
        int a = 256 - alpha;
        int r = (arg3 >> 16 & 0xff) * alpha;
        int g = (arg3 >> 8 & 0xff) * alpha;
        int b = (arg3 & 0xff) * alpha;
        int pixelOffset = x + y * width;
        for(int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int red = (pixels[pixelOffset] >> 16 & 0xff) * a;
            int green = (pixels[pixelOffset] >> 8 & 0xff) * a;
            int blue = (pixels[pixelOffset] & 0xff) * a;
            int rgba = ((r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8));
            pixels[pixelOffset++] = rgba;
        }
    }

    public static void drawHorizontalLine(int x, int y, int length, int colour) {
        if(y < viewport_top || y >= viewport_bottom) {
            return;
        }
        if(x < viewport_left) {
            length -= viewport_left - x;
            x = viewport_left;
        }
        if(x + length > viewport_right)
            length = viewport_right - x;
        int pixelOffset = x + y * width;
        for(int pixel = 0; pixel < length; pixel++)
            pixels[pixelOffset + pixel] = colour;
    }

    public static void drawVerticalLineAlpha(int x, int y, int length, int colour, int alpha) {
        if(x < viewport_left || x >= viewport_right) {
            return;
        }
        if(y < viewport_top) {
            length -= viewport_top - y;
            y = viewport_top;
        }
        if(y + length > viewport_bottom)
            length = viewport_bottom - y;
        int a = 256 - alpha;
        int r = (colour >> 16 & 0xff) * alpha;
        int g = (colour >> 8 & 0xff) * alpha;
        int b = (colour & 0xff) * alpha;
        int pixelOffset = x + y * width;
        for(int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int red = (pixels[pixelOffset] >> 16 & 0xff) * a;
            int green = (pixels[pixelOffset] >> 8 & 0xff) * a;
            int blue = (pixels[pixelOffset] & 0xff) * a;
            int rgba = ((r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8));
            pixels[pixelOffset] = rgba;
            pixelOffset += width;
        }
    }

    public static void method661(int[] arg0) {
        arg0[0] = viewport_left;
        arg0[1] = viewport_top;
        arg0[2] = viewport_right;
        arg0[3] = viewport_bottom;
    }

    public static void resetCoordinates() {
        viewport_left = 0;
        viewport_top = 0;
        viewport_right = width;
        viewport_bottom = height;
    }

    public static void resetPixels() {
        int pixelCount = width * height;
        for (int pixel = 0; pixel < pixelCount; pixel++)
            pixels[pixel] = 0;
    }

    public static void drawFilledRectangleAlpha(int x, int y, int width, int height, int colour, int alpha) {
        if(x < viewport_left) {
            width -= viewport_left - x;
            x = viewport_left;
        }
        if(y < viewport_top) {
            height -= viewport_top - y;
            y = viewport_top;
        }
        if(x + width > viewport_right)
            width = viewport_right - x;
        if(y + height > viewport_bottom)
            height = viewport_bottom - y;
        int a = 256 - alpha;
        int r = (colour >> 16 & 0xff) * alpha;
        int g = (colour >> 8 & 0xff) * alpha;
        int b = (colour & 0xff) * alpha;
        int widthOffset = Rasterizer.width - width;
        int pixel = x + y * Rasterizer.width;
        for(int heightCounter = 0; heightCounter < height; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++) {
                int red = (pixels[pixel] >> 16 & 0xff) * a;
                int green = (pixels[pixel] >> 8 & 0xff) * a;
                int blue = (pixels[pixel] & 0xff) * a;
                int rgba = ((r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8));
                pixels[pixel++] = rgba;
            }
            pixel += widthOffset;
        }
    }

    public static void drawUnfilledRectangle(int x, int y, int width, int height, int colour) {
        drawHorizontalLine(x, y, width, colour);
        drawHorizontalLine(x, y + height - 1, width, colour);
        drawVerticalLine(x, y, height, colour);
        drawVerticalLine(x + width - 1, y, height, colour);
    }

    public static void drawDiagonalLine(int x, int y, int destX, int destY, int colour) {
        destX -= x;
        destY -= y;
        if(destY == 0) {
            if(destX >= 0)
                drawHorizontalLine(x, y, destX + 1, colour);
            else
                drawHorizontalLine(x + destX, y, -destX + 1, colour);
        } else if(destX == 0) {
            if(destY >= 0)
                drawVerticalLine(x, y, destY + 1, colour);
            else
                drawVerticalLine(x, y + destY, -destY + 1, colour);
        } else {
            if(destX + destY < 0) {
                x += destX;
                destX = -destX;
                y += destY;
                destY = -destY;
            }
            if(destX > destY) {
                y <<= 16;
                y += 32768;
                destY <<= 16;
                int i = (int) Math.floor((double) destY / (double) destX + 0.5);
                destX += x;
                if(x < viewport_left) {
                    y += i * (viewport_left - x);
                    x = viewport_left;
                }
                if(destX >= viewport_right)
                    destX = viewport_right - 1;
                for(/**/; x <= destX; x++) {
                    int i_34_ = y >> 16;
                    if(i_34_ >= viewport_top && i_34_ < viewport_bottom)
                        pixels[x + i_34_ * width] = colour;
                    y += i;
                }
            } else {
                x <<= 16;
                x += 32768;
                destX <<= 16;
                int i = (int) Math.floor((double) destX / (double) destY + 0.5);
                destY += y;
                if(y < viewport_top) {
                    x += i * (viewport_top - y);
                    y = viewport_top;
                }
                if(destY >= viewport_bottom)
                    destY = viewport_bottom - 1;
                for(/**/; y <= destY; y++) {
                    int i_35_ = x >> 16;
                    if(i_35_ >= viewport_left && i_35_ < viewport_right)
                        pixels[i_35_ + y * width] = colour;
                    x += i;
                }
            }
        }
    }

    public static void method667() {
        pixels = null;
    }

    public static void drawVerticalLine(int x, int y, int length, int colour) {
        if(x < viewport_left || x >= viewport_right) {
            return;
        }
        if(y < viewport_top) {
            length -= viewport_top - y;
            y = viewport_top;
        }
        if(y + length > viewport_bottom)
            length = viewport_bottom - y;
        int pixelOffset = x + y * width;
        for(int i_36_ = 0; i_36_ < length; i_36_++)
            pixels[pixelOffset + i_36_ * width] = colour;
    }

    public static void createRasterizer(int[] pixels, int width, int height) {
        Rasterizer.pixels = pixels;
        Rasterizer.width = width;
        Rasterizer.height = height;
        setCoordinates(0, 0, height, width);
    }
}
