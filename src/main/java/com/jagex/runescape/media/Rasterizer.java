package com.jagex.runescape.media;

import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.node.CachedNode;

public class Rasterizer extends CachedNode {
    // used for drawing circles
    private static final int[] tmpX = new int[64];
    private static final int[] tmpY = new int[64];
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

    public static void prepare(int[] pixels, int width, int height) {
        Rasterizer.destinationPixels = pixels;
        Rasterizer.destinationWidth = width;
        Rasterizer.destinationHeight = height;
        setBounds(0, 0, width, height);
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

    public static void setBounds(int minX, int minY, int maxX, int maxY) {
        if(minX < 0) {
            minX = 0;
        }
        if(minY < 0) {
            minY = 0;
        }
        if(maxX > Rasterizer.destinationWidth) {
            maxX = Rasterizer.destinationWidth;
        }
        if(maxY > Rasterizer.destinationHeight) {
            maxY = Rasterizer.destinationHeight;
        }
        viewportLeft = minX;
        viewportTop = minY;
        viewportRight = maxX;
        viewportBottom = maxY;
        viewportRightX = viewportRight - 1;
        viewportCenterX = viewportRight / 2;
        viewportCenterY = viewportBottom / 2;
    }

    public static void resetPixels() {
        int pixelCount = destinationWidth * destinationHeight;
        for(int pixel = 0; pixel < pixelCount; pixel++) {
            destinationPixels[pixel] = 0;
        }
    }

    public static void fillOval(int x, int y, int w, int h, int rgb, int segments) {
        int cx = x + w / 2;
        int cy = y + h / 2;

        for(int i = 0; i < segments; i++) {
            int angle = (i << 11) / segments;

            tmpX[i] = x + (w * Model.COSINE[angle] >> 16);
            tmpY[i] = y + (h * Model.SINE[angle] >> 16);
        }

        for(int i = 1; i < segments; i++) {
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
        if(x + width > viewportRight) {
            width = viewportRight - x;
        }
        if(y + height > viewportBottom) {
            height = viewportBottom - y;
        }
        int pixelOffset = Rasterizer.destinationWidth - width;
        int pixel = x + y * Rasterizer.destinationWidth;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++) {
                destinationPixels[pixel++] = colour;
            }
            pixel += pixelOffset;
        }
    }

    public static void setViewportDimensions(int[] arg0) {
        viewportLeft = arg0[0];
        viewportTop = arg0[1];
        viewportRight = arg0[2];
        viewportBottom = arg0[3];
    }


    public static void copyPixels(int[] pixels, int width, int height, int paintX, int paintY) {
        int sourcePixel = 0;
        if(paintX < viewportLeft) {
            width -= viewportLeft - paintX;
            paintX = viewportLeft;
        }
        if(paintY < viewportTop) {
            height -= viewportTop - paintY;
            paintY = viewportTop;
        }
        if(paintX + width > viewportRight) {
            width = viewportRight - paintX;
        }
        if(paintY + height > viewportBottom) {
            height = viewportBottom - paintY;
        }
        int pixelOffset = Rasterizer.destinationWidth - width;
        int pixel = paintX + paintY * Rasterizer.destinationWidth;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++) {
                if(pixels[sourcePixel] != Integer.MAX_VALUE) {
                    destinationPixels[pixel] = pixels[sourcePixel];
                }
                pixel++;
                sourcePixel++;
            }
            pixel += pixelOffset;
        }
    }

    public static void copyPixelsCutOff(
            int[] pixels, int srcWidth, int srcHeight, int paintX, int paintY, int drawWidth, int drawHeight,
            int offsetX, int offsetY
    ) {
        int sourcePixel = offsetX + offsetY * srcWidth;
        if(paintX < viewportLeft) {
            drawWidth -= viewportLeft - paintX;
            paintX = viewportLeft;
        }
        if(paintY < viewportTop) {
            drawHeight -= viewportTop - paintY;
            paintY = viewportTop;
        }
        if(paintX + drawWidth > viewportRight) {
            drawWidth = viewportRight - paintX;
        }
        if(paintY + drawHeight > viewportBottom) {
            drawHeight = viewportBottom - paintY;
        }
        int pixelOffset = Rasterizer.destinationWidth - (drawWidth);
        int pixel = paintX + paintY * Rasterizer.destinationWidth;
        for(int heightCounter = -(drawHeight); heightCounter < 0; heightCounter++) {
            for(int widthCounter = -(drawWidth); widthCounter < 0; widthCounter++) {
                destinationPixels[pixel++] = pixels[sourcePixel++];
            }
            pixel += pixelOffset;
            sourcePixel += srcWidth - drawWidth;
        }
    }


    private static void drawPixel(int x, int y, int color) {
        if(x >= viewportLeft && y >= viewportTop && x < viewportRight && y < viewportBottom) {
            destinationPixels[x + y * destinationWidth] = color;
        }
    }


    public static void drawCircle(int x, int y, int radius, int color) {
        if(radius == 0) {
            drawPixel(x, y, color);
        } else {
            if(radius < 0) {
                radius = -radius;
            }
            int var4 = y - radius;
            if(var4 < viewportTop) {
                var4 = viewportTop;
            }
            int var5 = y + radius + 1;
            if(var5 > viewportBottom) {
                var5 = viewportBottom;
            }
            int var6 = var4;
            int var7 = radius * radius;
            int var8 = 0;
            int var9 = y - var4;
            int var10 = var9 * var9;
            int var11 = var10 - var9;
            if(y > var5) {
                y = var5;
            }
            int var12;
            int var13;
            int var14;
            int var15;
            while(var6 < y) {
                while(var11 <= var7 || var10 <= var7) {
                    var10 += var8 + var8;
                    var11 += var8++ + var8;
                }
                var12 = x - var8 + 1;
                if(var12 < viewportLeft) {
                    var12 = viewportLeft;
                }
                var13 = x + var8;
                if(var13 > viewportRight) {
                    var13 = viewportRight;
                }
                var14 = var12 + var6 * destinationWidth;
                for(var15 = var12; var15 < var13; ++var15) {
                    destinationPixels[var14++] = color;
                }
                ++var6;
                var10 -= var9-- + var9;
                var11 -= var9 + var9;
            }
            var8 = radius;
            var9 = var6 - y;
            var11 = var9 * var9 + var7;
            var10 = var11 - radius;
            for(var11 -= var9; var6 < var5; var10 += var9++ + var9) {
                while(var11 > var7 && var10 > var7) {
                    var11 -= var8-- + var8;
                    var10 -= var8 + var8;
                }
                var12 = x - var8;
                if(var12 < viewportLeft) {
                    var12 = viewportLeft;
                }
                var13 = x + var8;
                if(var13 > viewportRight - 1) {
                    var13 = viewportRight - 1;
                }
                var14 = var12 + var6 * destinationWidth;
                for(var15 = var12; var15 <= var13; ++var15) {
                    destinationPixels[var14++] = color;
                }
                ++var6;
                var11 += var9 + var9;
            }
        }
    }

    public static void drawCircleAlpha(int x, int y, int radius, int color, int alpha) {
        if(alpha != 0) {
            if(alpha == 256) {
                drawCircle(x, y, radius, color);
            } else {
                if(radius < 0) {
                    radius = -radius;
                }
                int a = 256 - alpha;
                int r = (color >> 16 & 255) * alpha;
                int g = (color >> 8 & 255) * alpha;
                int b = (color & 255) * alpha;
                int topY = y - radius;
                if(topY < Rasterizer.viewportTop) {
                    topY = Rasterizer.viewportTop;
                }
                int bottomY = y + radius + 1;
                if(bottomY > Rasterizer.viewportBottom) {
                    bottomY = Rasterizer.viewportBottom;
                }
                int var14 = topY;
                int var15 = radius * radius;
                int var16 = 0;
                int var17 = y - topY;
                int var18 = var17 * var17;
                int var19 = var18 - var17;
                if(y > bottomY) {
                    y = bottomY;
                }
                int var9;
                int var10;
                int var11;
                int var21;
                int var20;
                int var23;
                int var22;
                int var24;
                while(var14 < y) {
                    while(var19 <= var15 || var18 <= var15) {
                        var18 += var16 + var16;
                        var19 += var16++ + var16;
                    }
                    var20 = x - var16 + 1;
                    if(var20 < viewportLeft) {
                        var20 = viewportLeft;
                    }
                    var21 = x + var16;
                    if(var21 > viewportRight) {
                        var21 = viewportRight;
                    }
                    var22 = var20 + var14 * Rasterizer.destinationWidth;
                    for(var23 = var20; var23 < var21; ++var23) {
                        var9 = (destinationPixels[var22] >> 16 & 255) * a;
                        var10 = (destinationPixels[var22] >> 8 & 255) * a;
                        var11 = (destinationPixels[var22] & 255) * a;
                        var24 = (r + var9 >> 8 << 16) + (g + var10 >> 8 << 8) + (b + var11 >> 8);
                        destinationPixels[var22++] = var24;
                    }
                    ++var14;
                    var18 -= var17-- + var17;
                    var19 -= var17 + var17;
                }
                var16 = radius;
                var17 = -var17;
                var19 = var17 * var17 + var15;
                var18 = var19 - radius;
                for(var19 -= var17; var14 < bottomY; var18 += var17++ + var17) {
                    while(var19 > var15 && var18 > var15) {
                        var19 -= var16-- + var16;
                        var18 -= var16 + var16;
                    }
                    var20 = x - var16;
                    if(var20 < viewportLeft) {
                        var20 = viewportLeft;
                    }
                    var21 = x + var16;
                    if(var21 > viewportRight - 1) {
                        var21 = viewportRight - 1;
                    }
                    var22 = var20 + var14 * Rasterizer.destinationWidth;
                    for(var23 = var20; var23 <= var21; ++var23) {
                        var9 = (destinationPixels[var22] >> 16 & 255) * a;
                        var10 = (destinationPixels[var22] >> 8 & 255) * a;
                        var11 = (destinationPixels[var22] & 255) * a;
                        var24 = (r + var9 >> 8 << 16) + (g + var10 >> 8 << 8) + (b + var11 >> 8);
                        destinationPixels[var22++] = var24;
                    }
                    ++var14;
                    var19 += var17 + var17;
                }
            }
        }
    }

    public static void getViewportDimensions(int[] arg0) {
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
        if(x + length > viewportRight) {
            length = viewportRight - x;
        }
        int a = 256 - alpha;
        int r = (arg3 >> 16 & 0xff) * alpha;
        int g = (arg3 >> 8 & 0xff) * alpha;
        int b = (arg3 & 0xff) * alpha;
        int pixelOffset = x + y * destinationWidth;
        for(int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int red = (destinationPixels[pixelOffset] >> 16 & 0xff) * a;
            int green = (destinationPixels[pixelOffset] >> 8 & 0xff) * a;
            int blue = (destinationPixels[pixelOffset] & 0xff) * a;
            int rgba = (r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8);
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
        if(x + length > viewportRight) {
            length = viewportRight - x;
        }
        int pixelOffset = x + y * destinationWidth;
        for(int pixel = 0; pixel < length; pixel++) {
            destinationPixels[pixelOffset + pixel] = colour;
        }
    }

    public static void drawVerticalLineAlpha(int x, int y, int length, int colour, int alpha) {
        if(x < viewportLeft || x >= viewportRight) {
            return;
        }
        if(y < viewportTop) {
            length -= viewportTop - y;
            y = viewportTop;
        }
        if(y + length > viewportBottom) {
            length = viewportBottom - y;
        }
        int a = 256 - alpha;
        int r = (colour >> 16 & 0xff) * alpha;
        int g = (colour >> 8 & 0xff) * alpha;
        int b = (colour & 0xff) * alpha;
        int pixelOffset = x + y * destinationWidth;
        for(int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int red = (destinationPixels[pixelOffset] >> 16 & 0xff) * a;
            int green = (destinationPixels[pixelOffset] >> 8 & 0xff) * a;
            int blue = (destinationPixels[pixelOffset] & 0xff) * a;
            int rgba = (r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8);
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
        if(x + width > viewportRight) {
            width = viewportRight - x;
        }
        if(y + height > viewportBottom) {
            height = viewportBottom - y;
        }
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
                int rgba = (r + red >> 8 << 16) + (g + green >> 8 << 8) + (b + blue >> 8);
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
            if(destX >= 0) {
                drawHorizontalLine(x, y, destX + 1, colour);
            } else {
                drawHorizontalLine(x + destX, y, -destX + 1, colour);
            }
        } else if(destX == 0) {
            if(destY >= 0) {
                drawVerticalLine(x, y, destY + 1, colour);
            } else {
                drawVerticalLine(x, y + destY, -destY + 1, colour);
            }
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
                if(destX >= viewportRight) {
                    destX = viewportRight - 1;
                }
                for(/**/; x <= destX; x++) {
                    int i_34_ = y >> 16;
                    if(i_34_ >= viewportTop && i_34_ < viewportBottom) {
                        destinationPixels[x + i_34_ * destinationWidth] = colour;
                    }
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
                if(destY >= viewportBottom) {
                    destY = viewportBottom - 1;
                }
                for(/**/; y <= destY; y++) {
                    int i_35_ = x >> 16;
                    if(i_35_ >= viewportLeft && i_35_ < viewportRight) {
                        destinationPixels[i_35_ + y * destinationWidth] = colour;
                    }
                    x += i;
                }
            }
        }
    }


    public static void drawVerticalLine(int x, int y, int length, int colour) {
        if(x < viewportLeft || x >= viewportRight) {
            return;
        }
        if(y < viewportTop) {
            length -= viewportTop - y;
            y = viewportTop;
        }
        if(y + length > viewportBottom) {
            length = viewportBottom - y;
        }
        int pixelOffset = x + y * destinationWidth;
        for(int pixel = 0; pixel < length; pixel++) {
            destinationPixels[pixelOffset + pixel * destinationWidth] = colour;
        }
    }


}
