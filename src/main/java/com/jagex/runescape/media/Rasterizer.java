package com.jagex.runescape.media;

import com.jagex.runescape.SubNode;
import com.jagex.runescape.media.renderable.Model;

public class Rasterizer extends SubNode {
    public static int[] destinationPixels;
    public static int viewportTop = 0;
    public static int destinationWidth;
    public static int destinationHeight;
    public static int viewportBottom = 0;
    public static int viewportLeft = 0;
    public static int viewportRight = 0;
    public static int viewportRightX = 0;
    public static int viewportCenterX = 0;
    public static int viewportCenterY = 0;

    // used for drawing circles
    private static final int[] tmpX = new int[64];
    private static final int[] tmpY = new int[64];

    public static void prepare(int[] pixels, int width, int height) {
        Rasterizer.destinationPixels = pixels;
        Rasterizer.destinationWidth = width;
        Rasterizer.destinationHeight = height;
        setBounds(0, 0, height, width);
    }

    public static void resetBounds() {
        viewportLeft = 0;
        viewportTop = 0;
        viewportRight = destinationWidth;
        viewportBottom = destinationHeight;
        viewportRightX = viewportRight - 1;
        viewportCenterX = viewportRight / 2;
        viewportCenterY = viewportBottom / 2;
    }

    public static void setBounds(int x0, int y0, int y1, int x1) {
        if(x0 < 0)
            x0 = 0;
        if(y0 < 0)
            y0 = 0;
        if(x1 > Rasterizer.destinationWidth)
            x1 = Rasterizer.destinationWidth;
        if(y1 > Rasterizer.destinationHeight)
            y1 = Rasterizer.destinationHeight;
        viewportLeft = x0;
        viewportTop = y0;
        viewportRight = x1;
        viewportBottom = y1;
        viewportRightX = viewportRight - 1;
        viewportCenterX = viewportRight / 2;
        viewportCenterY = viewportBottom / 2;
    }

    public static void clear() {
        int pixelCount = destinationWidth * destinationHeight;
        for (int pixel = 0; pixel < pixelCount; pixel++)
            destinationPixels[pixel] = 0;
    }

    public static void fillOval(int x, int y, int w, int h, int rgb, int segments) {
        int cx = x + (w / 2);
        int cy = y + (h / 2);

        for (int i = 0; i < segments; i++) {
            int angle = (i << 11) / segments;

            tmpX[i] = x + ((w * Model.COSINE[angle]) >> 16);
            tmpY[i] = y + ((h * Model.SINE[angle]) >> 16);
        }

        for (int i = 1; i < segments; i++) {
            x = tmpX[i - 1];
            y = tmpY[i - 1];
            int x1 = tmpX[i];
            int y1 = tmpY[i];

            Rasterizer3D.drawFlatTriangle(cx, cy, x, y, x1, y1, rgb);
        }
    }

    public static void drawUnfilledRectangleAlpha(int x, int y, int width, int height, int colour, int alpha) {
        drawHorizontalLineAlpha(x, y, width, colour, alpha);
        drawHorizontalLineAlpha(x, y + height - 1, width, colour, alpha);
        if(height >= 3) {
            drawVerticalLineAlpha(x, y + 1, height - 2, colour, alpha);
            drawVerticalLineAlpha(x + width - 1, y + 1, height - 2, colour, alpha);
        }
    }

    public static void drawFilledRectangle(int x, int y, int width, int height, int colour) {
        if(x < viewportLeft) {
            width -= viewportLeft - x;
            x = viewportLeft;
        }
        if(y < viewportTop) {
            height -= viewportTop - y;
            y = viewportTop;
        }
        if(x + width > viewportRight)
            width = viewportRight - x;
        if(y + height > viewportBottom)
            height = viewportBottom - y;
        int pixelOffset = Rasterizer.destinationWidth - width;
        int pixel = x + y * Rasterizer.destinationWidth;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++)
                destinationPixels[pixel++] = colour;
            pixel += pixelOffset;
        }
    }

    public static void method657(int[] arg0) {
        viewportLeft = arg0[0];
        viewportTop = arg0[1];
        viewportRight = arg0[2];
        viewportBottom = arg0[3];
    }


    public static void method661(int[] arg0) {
        arg0[0] = viewportLeft;
        arg0[1] = viewportTop;
        arg0[2] = viewportRight;
        arg0[3] = viewportBottom;
    }


    public static void drawHorizontalLineAlpha(int x, int y, int length, int arg3, int alpha) {
        if(y < viewportTop || y >= viewportBottom) {
            return;
        }
        if(x < viewportLeft) {
            length -= viewportLeft - x;
            x = viewportLeft;
        }
        if(x + length > viewportRight)
            length = viewportRight - x;
        int a = 256 - alpha;
        int r = (arg3 >> 16 & 0xff) * alpha;
        int g = (arg3 >> 8 & 0xff) * alpha;
        int b = (arg3 & 0xff) * alpha;
        int pixelOffset = x + y * destinationWidth;
        for(int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int red = (destinationPixels[pixelOffset] >> 16 & 0xff) * a;
            int green = (destinationPixels[pixelOffset] >> 8 & 0xff) * a;
            int blue = (destinationPixels[pixelOffset] & 0xff) * a;
            int rgba = ((r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8));
            destinationPixels[pixelOffset++] = rgba;
        }
    }

    public static void drawHorizontalLine(int x, int y, int length, int colour) {
        if(y < viewportTop || y >= viewportBottom) {
            return;
        }
        if(x < viewportLeft) {
            length -= viewportLeft - x;
            x = viewportLeft;
        }
        if(x + length > viewportRight)
            length = viewportRight - x;
        int pixelOffset = x + y * destinationWidth;
        for(int pixel = 0; pixel < length; pixel++)
            destinationPixels[pixelOffset + pixel] = colour;
    }

    public static void drawVerticalLineAlpha(int x, int y, int length, int colour, int alpha) {
        if(x < viewportLeft || x >= viewportRight) {
            return;
        }
        if(y < viewportTop) {
            length -= viewportTop - y;
            y = viewportTop;
        }
        if(y + length > viewportBottom)
            length = viewportBottom - y;
        int a = 256 - alpha;
        int r = (colour >> 16 & 0xff) * alpha;
        int g = (colour >> 8 & 0xff) * alpha;
        int b = (colour & 0xff) * alpha;
        int pixelOffset = x + y * destinationWidth;
        for(int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int red = (destinationPixels[pixelOffset] >> 16 & 0xff) * a;
            int green = (destinationPixels[pixelOffset] >> 8 & 0xff) * a;
            int blue = (destinationPixels[pixelOffset] & 0xff) * a;
            int rgba = ((r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8));
            destinationPixels[pixelOffset] = rgba;
            pixelOffset += destinationWidth;
        }
    }





    public static void drawFilledRectangleAlpha(int x, int y, int width, int height, int colour, int alpha) {
        if(x < viewportLeft) {
            width -= viewportLeft - x;
            x = viewportLeft;
        }
        if(y < viewportTop) {
            height -= viewportTop - y;
            y = viewportTop;
        }
        if(x + width > viewportRight)
            width = viewportRight - x;
        if(y + height > viewportBottom)
            height = viewportBottom - y;
        int a = 256 - alpha;
        int r = (colour >> 16 & 0xff) * alpha;
        int g = (colour >> 8 & 0xff) * alpha;
        int b = (colour & 0xff) * alpha;
        int widthOffset = Rasterizer.destinationWidth - width;
        int pixel = x + y * Rasterizer.destinationWidth;
        for(int heightCounter = 0; heightCounter < height; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++) {
                int red = (destinationPixels[pixel] >> 16 & 0xff) * a;
                int green = (destinationPixels[pixel] >> 8 & 0xff) * a;
                int blue = (destinationPixels[pixel] & 0xff) * a;
                int rgba = ((r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8));
                destinationPixels[pixel++] = rgba;
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
                if(x < viewportLeft) {
                    y += i * (viewportLeft - x);
                    x = viewportLeft;
                }
                if(destX >= viewportRight)
                    destX = viewportRight - 1;
                for(/**/; x <= destX; x++) {
                    int i_34_ = y >> 16;
                    if(i_34_ >= viewportTop && i_34_ < viewportBottom)
                        destinationPixels[x + i_34_ * destinationWidth] = colour;
                    y += i;
                }
            } else {
                x <<= 16;
                x += 32768;
                destX <<= 16;
                int i = (int) Math.floor((double) destX / (double) destY + 0.5);
                destY += y;
                if(y < viewportTop) {
                    x += i * (viewportTop - y);
                    y = viewportTop;
                }
                if(destY >= viewportBottom)
                    destY = viewportBottom - 1;
                for(/**/; y <= destY; y++) {
                    int i_35_ = x >> 16;
                    if(i_35_ >= viewportLeft && i_35_ < viewportRight)
                        destinationPixels[i_35_ + y * destinationWidth] = colour;
                    x += i;
                }
            }
        }
    }

    public static void method667() {
        destinationPixels = null;
    }

    public static void drawVerticalLine(int x, int y, int length, int colour) {
        if(x < viewportLeft || x >= viewportRight) {
            return;
        }
        if(y < viewportTop) {
            length -= viewportTop - y;
            y = viewportTop;
        }
        if(y + length > viewportBottom)
            length = viewportBottom - y;
        int pixelOffset = x + y * destinationWidth;
        for(int pixel = 0; pixel < length; pixel++)
            destinationPixels[pixelOffset + pixel * destinationWidth] = colour;
    }


}
