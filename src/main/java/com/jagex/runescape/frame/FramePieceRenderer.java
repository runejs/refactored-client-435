package com.jagex.runescape.frame;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.media.RasterizerInstanced;

public class FramePieceRenderer {
    public RasterizerInstanced rasterizerInstanced;

    public void shapeImageToPixels(
            ImageRGB image, int x, int y, int width, int height, int arg4, int arg5, int k1, int zoom, int[] arg8,
            int[] arg9
    ) {
        try {
            int centerX = -width / 2;
            int centerY = -height / 2;
            int sine = (int) (Math.sin((double) k1 / 326.11) * 65536.0);
            int cosine = (int) (Math.cos((double) k1 / 326.11) * 65536.0);
            sine = sine * zoom >> 8;
            cosine = cosine * zoom >> 8;
            int i_125_ = (arg4 << 16) + centerY * sine + centerX * cosine;
            int i_126_ = (arg5 << 16) + centerY * cosine - centerX * sine;
            int destinationOffset = x + y * rasterizerInstanced.destinationWidth;

            for(y = 0; y < height; y++) {
                int i_128_ = arg8[y];
                int i_129_ = destinationOffset + i_128_;
                int i_130_ = i_125_ + cosine * i_128_;
                int i_131_ = i_126_ - sine * i_128_;
                for(x = -arg9[y]; x < 0; x++) {
                    int pixelToGet = (i_130_ >> 16) + (i_131_ >> 16) * image.imageWidth;
                    int colour = 0;
                    if(!(image.pixels.length < pixelToGet || pixelToGet < 0)) {
                        colour = image.pixels[pixelToGet];
                    }
                    rasterizerInstanced.destinationPixels[i_129_++] = colour;
                    i_130_ += cosine;
                    i_131_ -= sine;
                }
                i_125_ += sine;
                i_126_ += cosine;
                destinationOffset += rasterizerInstanced.destinationWidth;
            }
        } catch(Exception exception) {
            /* empty */
            exception.printStackTrace();
        }
    }

    public void drawImage(ImageRGB image, int x, int y) {
        x += image.offsetX;
        y += image.offsetY;
        int dest_offset = x + y * rasterizerInstanced.destinationWidth;
        int source_offset = 0;
        int line_count = image.imageHeight;
        int line_width = image.imageWidth;
        int line_offset_dest = rasterizerInstanced.destinationWidth - line_width;
        int line_offset_source = 0;
        if(y < rasterizerInstanced.viewportTop) {
            int clip_height = rasterizerInstanced.viewportTop - y;
            line_count -= clip_height;
            y = rasterizerInstanced.viewportTop;
            source_offset += clip_height * line_width;
            dest_offset += clip_height * rasterizerInstanced.destinationWidth;
        }
        if(y + line_count > rasterizerInstanced.viewportBottom) {
            line_count -= y + line_count - rasterizerInstanced.viewportBottom;
        }
        if(x < rasterizerInstanced.viewportLeft) {
            int clip_width = rasterizerInstanced.viewportLeft - x;
            line_width -= clip_width;
            x = rasterizerInstanced.viewportLeft;
            source_offset += clip_width;
            dest_offset += clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > rasterizerInstanced.viewportRight) {
            int clip_width = x + line_width - rasterizerInstanced.viewportRight;
            line_width -= clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(line_width > 0 && line_count > 0) {
            ImageRGB.blockCopyTrans(rasterizerInstanced.destinationPixels, image.pixels, 0, source_offset, dest_offset,
                    line_width, line_count, line_offset_dest, line_offset_source
            );
        }
    }

    public void drawRotated(
            ImageRGB image, int x, int y, int pivotX, int pivotY, int width, int height, int zoom, double angle
    ) {
        try {
            int centerX = -width / 2;
            int centerY = -height / 2;
            int sine = (int) (Math.sin(angle) * 65536.0);
            int cosine = (int) (Math.cos(angle) * 65536.0);
            sine = sine * zoom >> 8;
            cosine = cosine * zoom >> 8;
            int sourceOffsetX = (pivotX << 16) + centerY * sine + centerX * cosine;
            int sourceoffsetY = (pivotY << 16) + centerY * cosine - centerX * sine;
            int destinationOffset = x + y * rasterizerInstanced.destinationWidth;
            for(y = 0; y < height; y++) {
                int i = destinationOffset;
                int offsetX = sourceOffsetX;
                int offsetY = sourceoffsetY;
                for(x = -width; x < 0; x++) {
                    int i_166_ = image.pixels[(offsetX >> 16) + (offsetY >> 16) * image.imageWidth];
                    if(i_166_ != 0) {
                        rasterizerInstanced.destinationPixels[i++] = i_166_;
                    } else {
                        i++;
                    }
                    offsetX += cosine;
                    offsetY -= sine;
                }
                sourceOffsetX += sine;
                sourceoffsetY += cosine;
                destinationOffset += rasterizerInstanced.destinationWidth;
            }
        } catch(Exception exception) {
            /* empty */
            exception.printStackTrace();
        }

    }
}
