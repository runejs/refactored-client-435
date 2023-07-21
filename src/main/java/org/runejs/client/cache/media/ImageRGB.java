package org.runejs.client.cache.media;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.RasterizerInstanced;
import org.runejs.client.util.BitUtils;

import java.awt.*;
import java.awt.image.PixelGrabber;

public class ImageRGB extends Rasterizer {
    public int offsetY;
    public int imageHeight;
    public int imageWidth;
    public int maxHeight;
    public int offsetX;
    public int maxWidth;
    public int[] pixels;

    public ImageRGB() {
        /* empty */
    }

    public ImageRGB(int width, int height) {
        pixels = new int[width * height];
        imageWidth = maxWidth = width;
        imageHeight = maxHeight = height;
        offsetX = offsetY = 0;
    }

    public ImageRGB(byte[] imagedata, Component component) {
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(imagedata);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            imageWidth = image.getWidth(component);
            imageHeight = image.getHeight(component);
            maxWidth = imageWidth;
            maxHeight = imageHeight;
            offsetX = 0;
            offsetY = 0;
            pixels = new int[imageWidth * imageHeight];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, imageWidth, imageHeight, pixels, 0, imageWidth);
            pixelgrabber.grabPixels();
        } catch(InterruptedException interruptedexception) {
            System.out.println("Error converting jpg");
        }
    }

    public static void method715(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        int i = arg3;
        for(int i_0_ = -arg8; i_0_ < 0; i_0_++) {
            int i_1_ = (arg4 >> 16) * arg11;
            for(int i_2_ = -arg7; i_2_ < 0; i_2_++) {
                arg2 = arg1[(arg3 >> 16) + i_1_];
                if(arg2 != 0)
                    arg0[arg5++] = arg2;
                else
                    arg5++;
                arg3 += arg9;
            }
            arg4 += arg10;
            arg3 = i;
            arg5 += arg6;
        }
    }

    public static void blockCopyMask(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, byte[] arg9) {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 0x3);
        for(int i_21_ = -arg6; i_21_ < 0; i_21_++) {
            for(int i_22_ = i; i_22_ < 0; i_22_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            for(int i_23_ = arg5; i_23_ < 0; i_23_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public static void blockCopyTrans(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 0x3);
        for(int i_24_ = -arg6; i_24_ < 0; i_24_++) {
            for(int i_25_ = i; i_25_ < 0; i_25_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            for(int i_26_ = arg5; i_26_ < 0; i_26_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public static void method730(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        int i = 256 - arg9;
        for(int i_167_ = -arg6; i_167_ < 0; i_167_++) {
            for(int i_168_ = -arg5; i_168_ < 0; i_168_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0) {
                    int i_169_ = arg0[arg4];
                    arg0[arg4++] = ((arg2 & 0xff00ff) * arg9 + (i_169_ & 0xff00ff) * i & ~0xff00ff) + ((arg2 & 0xff00) * arg9 + (i_169_ & 0xff00) * i & 0xff0000) >> 8;
                } else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public static void copyPixels(int[] rasterizerPixels, int[] pixels, int pixel, int rasterizerPixel, int width, int height, int rasterizerPixelOffset, int pixelOffset) {
        for(int i = -height; i < 0; i++) {
            int shiftedWidth = rasterizerPixel + width - 3;
            while(rasterizerPixel < shiftedWidth) {
                rasterizerPixels[rasterizerPixel++] = pixels[pixel++];
                rasterizerPixels[rasterizerPixel++] = pixels[pixel++];
                rasterizerPixels[rasterizerPixel++] = pixels[pixel++];
                rasterizerPixels[rasterizerPixel++] = pixels[pixel++];
            }
            shiftedWidth += 3;
            while(rasterizerPixel < shiftedWidth)
                rasterizerPixels[rasterizerPixel++] = pixels[pixel++];
            rasterizerPixel += rasterizerPixelOffset;
            pixel += pixelOffset;
        }
    }

    public static void method733(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        int i = 256 - arg12;
        int i_185_ = arg3;
        for(int i_186_ = -arg8; i_186_ < 0; i_186_++) {
            int i_187_ = (arg4 >> 16) * arg11;
            for(int i_188_ = -arg7; i_188_ < 0; i_188_++) {
                arg2 = arg1[(arg3 >> 16) + i_187_];
                if(arg2 != 0) {
                    int i_189_ = arg0[arg5];
                    arg0[arg5++] = ((arg2 & 0xff00ff) * arg12 + (i_189_ & 0xff00ff) * i & ~0xff00ff) + ((arg2 & 0xff00) * arg12 + (i_189_ & 0xff00) * i & 0xff0000) >> 8;
                } else
                    arg5++;
                arg3 += arg9;
            }
            arg4 += arg10;
            arg3 = i_185_;
            arg5 += arg6;
        }
    }

    public static void shapeImageToPixels(byte[] pixels, int[] rasterizerPixels, int pixel, int rasterizerPixel, int width, int height, int rasterizerPixelOffset, int pixelOffset, int[] palette) {
        int shiftedWidth = -(width >> 2);
        width = -(width & 0x3);
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = shiftedWidth; widthCounter < 0; widthCounter++) {
                int pixelColor = pixels[pixel++];
                if(pixelColor != 0)
                    rasterizerPixels[rasterizerPixel++] = palette[pixelColor & 0xff];
                else
                    rasterizerPixel++;
                pixelColor = pixels[pixel++];
                if(pixelColor != 0)
                    rasterizerPixels[rasterizerPixel++] = palette[pixelColor & 0xff];
                else
                    rasterizerPixel++;
                pixelColor = pixels[pixel++];
                if(pixelColor != 0)
                    rasterizerPixels[rasterizerPixel++] = palette[pixelColor & 0xff];
                else
                    rasterizerPixel++;
                pixelColor = pixels[pixel++];
                if(pixelColor != 0)
                    rasterizerPixels[rasterizerPixel++] = palette[pixelColor & 0xff];
                else
                    rasterizerPixel++;
            }
            for(int widthCounter = width; widthCounter < 0; widthCounter++) {
                int pixelColor = pixels[pixel++];
                if(pixelColor != 0)
                    rasterizerPixels[rasterizerPixel++] = palette[pixelColor & 0xff];
                else
                    rasterizerPixel++;
            }
            rasterizerPixel += rasterizerPixelOffset;
            pixel += pixelOffset;
        }
    }

    public static boolean spriteExists(int arg0, int arg1, CacheArchive cacheArchive) {
        byte[] is = cacheArchive.getFile(arg1, arg0);
        if(is == null)
            return false;
        MovedStatics.method184(is, 0);
        return true;
    }

    public static ImageRGB[] method319() {
	    ImageRGB[] class40_sub5_sub14_sub4s = new ImageRGB[MovedStatics.anInt2581];
	    for(int i = 0; i < MovedStatics.anInt2581; i++) {
	        ImageRGB class40_sub5_sub14_sub4 = class40_sub5_sub14_sub4s[i] = new ImageRGB();
	        class40_sub5_sub14_sub4.maxWidth = MovedStatics.imageMaxWidth;
	        class40_sub5_sub14_sub4.maxHeight = MovedStatics.imageMaxHeight;
	        class40_sub5_sub14_sub4.offsetX = MovedStatics.anIntArray1347[i];
	        class40_sub5_sub14_sub4.offsetY = MovedStatics.anIntArray3111[i];
	        class40_sub5_sub14_sub4.imageWidth = MovedStatics.anIntArray456[i];
	        class40_sub5_sub14_sub4.imageHeight = MovedStatics.anIntArray3312[i];
	        byte[] is = MovedStatics.aByteArrayArray1370[i];
	        int i_4_ = class40_sub5_sub14_sub4.imageHeight * class40_sub5_sub14_sub4.imageWidth;
	        class40_sub5_sub14_sub4.pixels = new int[i_4_];
	        for(int i_5_ = 0; i_5_ < i_4_; i_5_++)
	            class40_sub5_sub14_sub4.pixels[i_5_] = MovedStatics.anIntArray1972[BitUtils.bitWiseAND(255, is[i_5_])];
	    }
	    MovedStatics.method569();
	    return class40_sub5_sub14_sub4s;
	}

    public static ImageRGB[] method944(byte arg0, int arg1, CacheArchive arg2, int arg3) {
        if(!spriteExists(arg3, arg1, arg2))
            return null;
        int i = -59 % ((-60 - arg0) / 34);
        return method319();
    }

    public static ImageRGB[] method526(CacheArchive arg0, String arg2, String arg3) {
        int i = arg0.getHash(arg2);
        int i_4_ = arg0.method179(i, arg3);
        return method944((byte) -3, i, arg0, i_4_);
    }

    public void method716(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg2 > 0 && arg3 > 0) {
            int i = imageWidth;
            int i_3_ = imageHeight;
            int i_4_ = 0;
            int i_5_ = 0;
            int i_6_ = maxWidth;
            int i_7_ = maxHeight;
            int i_8_ = (i_6_ << 16) / arg2;
            int i_9_ = (i_7_ << 16) / arg3;
            if(offsetX > 0) {
                int i_10_ = ((offsetX << 16) + i_8_ - 1) / i_8_;
                arg0 += i_10_;
                i_4_ += i_10_ * i_8_ - (offsetX << 16);
            }
            if(offsetY > 0) {
                int i_11_ = ((offsetY << 16) + i_9_ - 1) / i_9_;
                arg1 += i_11_;
                i_5_ += i_11_ * i_9_ - (offsetY << 16);
            }
            if(i < i_6_)
                arg2 = ((i << 16) - i_4_ + i_8_ - 1) / i_8_;
            if(i_3_ < i_7_)
                arg3 = ((i_3_ << 16) - i_5_ + i_9_ - 1) / i_9_;
            int i_12_ = arg0 + arg1 * Rasterizer.destinationWidth;
            int i_13_ = Rasterizer.destinationWidth - arg2;
            if(arg1 + arg3 > Rasterizer.viewportBottom)
                arg3 -= arg1 + arg3 - Rasterizer.viewportBottom;
            if(arg1 < Rasterizer.viewportTop) {
                int i_14_ = Rasterizer.viewportTop - arg1;
                arg3 -= i_14_;
                i_12_ += i_14_ * Rasterizer.destinationWidth;
                i_5_ += i_9_ * i_14_;
            }
            if(arg0 + arg2 > Rasterizer.viewportRight) {
                int i_15_ = arg0 + arg2 - Rasterizer.viewportRight;
                arg2 -= i_15_;
                i_13_ += i_15_;
            }
            if(arg0 < Rasterizer.viewportLeft) {
                int i_16_ = Rasterizer.viewportLeft - arg0;
                arg2 -= i_16_;
                i_12_ += i_16_;
                i_4_ += i_8_ * i_16_;
                i_13_ += i_16_;
            }
            method733(Rasterizer.destinationPixels, pixels, 0, i_4_, i_5_, i_12_, i_13_, arg2, arg3, i_8_, i_9_, i, arg4);
        }
    }

    public void method717(int arg0, int arg1, int arg2) {
        for(int i = 0; i < pixels.length; i++) {
            int i_17_ = pixels[i];
            if(i_17_ != 0) {
                int i_18_ = i_17_ >> 16 & 0xff;
                i_18_ += arg0;
                if(i_18_ < 1)
                    i_18_ = 1;
                else if(i_18_ > 255)
                    i_18_ = 255;
                int i_19_ = i_17_ >> 8 & 0xff;
                i_19_ += arg1;
                if(i_19_ < 1)
                    i_19_ = 1;
                else if(i_19_ > 255)
                    i_19_ = 255;
                int i_20_ = i_17_ & 0xff;
                i_20_ += arg2;
                if(i_20_ < 1)
                    i_20_ = 1;
                else if(i_20_ > 255)
                    i_20_ = 255;
                pixels[i] = (i_18_ << 16) + (i_19_ << 8) + i_20_;
            }
        }
    }

    public void drawImageWithTexture(int x, int y, int textureId, int arg3) {
        method722(maxWidth << 3, maxHeight << 3, x << 4, y << 4, textureId, arg3);
    }

    public void drawImage(RasterizerInstanced rasterizer, int x, int y) {
        x += offsetX;
        y += offsetY;
        int dest_offset = x + y * rasterizer.destinationWidth;
        int source_offset = 0;
        int line_count = imageHeight;
        int line_width = imageWidth;
        int line_offset_dest = rasterizer.destinationWidth - line_width;
        int line_offset_source = 0;
        if(y < rasterizer.viewportTop) {
            int clip_height = rasterizer.viewportTop - y;
            line_count -= clip_height;
            y = rasterizer.viewportTop;
            source_offset += clip_height * line_width;
            dest_offset += clip_height * rasterizer.destinationWidth;
        }
        if(y + line_count > rasterizer.viewportBottom)
            line_count -= y + line_count - rasterizer.viewportBottom;
        if(x < rasterizer.viewportLeft) {
            int clip_width = rasterizer.viewportLeft - x;
            line_width -= clip_width;
            x = rasterizer.viewportLeft;
            source_offset += clip_width;
            dest_offset += clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > rasterizer.viewportRight) {
            int clip_width = x + line_width - rasterizer.viewportRight;
            line_width -= clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(line_width > 0 && line_count > 0)
            blockCopyTrans(rasterizer.destinationPixels, pixels, 0, source_offset, dest_offset, line_width, line_count, line_offset_dest, line_offset_source);
    }

    public void drawImage(int x, int y) {
        x += offsetX;
        y += offsetY;
        int dest_offset = x + y * Rasterizer.destinationWidth;
        int source_offset = 0;
        int line_count = imageHeight;
        int line_width = imageWidth;
        int line_offset_dest = Rasterizer.destinationWidth - line_width;
        int line_offset_source = 0;
        if(y < Rasterizer.viewportTop) {
            int clip_height = Rasterizer.viewportTop - y;
            line_count -= clip_height;
            y = Rasterizer.viewportTop;
            source_offset += clip_height * line_width;
            dest_offset += clip_height * Rasterizer.destinationWidth;
        }
        if(y + line_count > Rasterizer.viewportBottom)
            line_count -= y + line_count - Rasterizer.viewportBottom;
        if(x < Rasterizer.viewportLeft) {
            int clip_width = Rasterizer.viewportLeft - x;
            line_width -= clip_width;
            x = Rasterizer.viewportLeft;
            source_offset += clip_width;
            dest_offset += clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > Rasterizer.viewportRight) {
            int clip_width = x + line_width - Rasterizer.viewportRight;
            line_width -= clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(line_width > 0 && line_count > 0)
            blockCopyTrans(Rasterizer.destinationPixels, pixels, 0, source_offset, dest_offset, line_width, line_count, line_offset_dest, line_offset_source);
    }

    public void method722(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg5 != 0) {
            arg0 -= offsetX << 4;
            arg1 -= offsetY << 4;
            double d = (double) (arg4 & 0xffff) * 9.587379924285257E-5;
            int i = (int) Math.floor(Math.sin(d) * (double) arg5 + 0.5);
            int i_35_ = (int) Math.floor(Math.cos(d) * (double) arg5 + 0.5);
            int i_36_ = -arg0 * i_35_ + -arg1 * i;
            int i_37_ = arg0 * i + -arg1 * i_35_;
            int i_38_ = ((imageWidth << 4) - arg0) * i_35_ + -arg1 * i;
            int i_39_ = -((imageWidth << 4) - arg0) * i + -arg1 * i_35_;
            int i_40_ = -arg0 * i_35_ + ((imageHeight << 4) - arg1) * i;
            int i_41_ = arg0 * i + ((imageHeight << 4) - arg1) * i_35_;
            int i_42_ = ((imageWidth << 4) - arg0) * i_35_ + ((imageHeight << 4) - arg1) * i;
            int i_43_ = -((imageWidth << 4) - arg0) * i + ((imageHeight << 4) - arg1) * i_35_;
            int i_44_;
            int i_45_;
            if(i_36_ < i_38_) {
                i_44_ = i_36_;
                i_45_ = i_38_;
            } else {
                i_44_ = i_38_;
                i_45_ = i_36_;
            }
            if(i_40_ < i_44_)
                i_44_ = i_40_;
            if(i_42_ < i_44_)
                i_44_ = i_42_;
            if(i_40_ > i_45_)
                i_45_ = i_40_;
            if(i_42_ > i_45_)
                i_45_ = i_42_;
            int i_46_;
            int i_47_;
            if(i_37_ < i_39_) {
                i_46_ = i_37_;
                i_47_ = i_39_;
            } else {
                i_46_ = i_39_;
                i_47_ = i_37_;
            }
            if(i_41_ < i_46_)
                i_46_ = i_41_;
            if(i_43_ < i_46_)
                i_46_ = i_43_;
            if(i_41_ > i_47_)
                i_47_ = i_41_;
            if(i_43_ > i_47_)
                i_47_ = i_43_;
            i_44_ >>= 12;
            i_45_ = i_45_ + 4095 >> 12;
            i_46_ >>= 12;
            i_47_ = i_47_ + 4095 >> 12;
            i_44_ += arg2;
            i_45_ += arg2;
            i_46_ += arg3;
            i_47_ += arg3;
            i_44_ >>= 4;
            i_45_ = i_45_ + 15 >> 4;
            i_46_ >>= 4;
            i_47_ = i_47_ + 15 >> 4;
            if(i_44_ < Rasterizer.viewportLeft)
                i_44_ = Rasterizer.viewportLeft;
            if(i_45_ > Rasterizer.viewportRight)
                i_45_ = Rasterizer.viewportRight;
            if(i_46_ < Rasterizer.viewportTop)
                i_46_ = Rasterizer.viewportTop;
            if(i_47_ > Rasterizer.viewportBottom)
                i_47_ = Rasterizer.viewportBottom;
            i_45_ = i_44_ - i_45_;
            if(i_45_ < 0) {
                i_47_ = i_46_ - i_47_;
                if(i_47_ < 0) {
                    int i_48_ = i_46_ * Rasterizer.destinationWidth + i_44_;
                    double d_49_ = 1.6777216E7 / (double) arg5;
                    int i_50_ = (int) Math.floor(Math.sin(d) * d_49_ + 0.5);
                    int i_51_ = (int) Math.floor(Math.cos(d) * d_49_ + 0.5);
                    int i_52_ = (i_44_ << 4) + 8 - arg2;
                    int i_53_ = (i_46_ << 4) + 8 - arg3;
                    int i_54_ = (arg0 << 8) - (i_53_ * i_50_ >> 4);
                    int i_55_ = (arg1 << 8) + (i_53_ * i_51_ >> 4);
                    if(i_51_ == 0) {
                        if(i_50_ == 0) {
                            int i_56_ = i_47_;
                            while(i_56_ < 0) {
                                int i_57_ = i_48_;
                                int i_58_ = i_54_;
                                int i_59_ = i_55_;
                                int i_60_ = i_45_;
                                if(i_58_ >= 0 && i_59_ >= 0 && i_58_ - (imageWidth << 12) < 0 && i_59_ - (imageHeight << 12) < 0) {
                                    for(/**/; i_60_ < 0; i_60_++) {
                                        int i_61_ = pixels[(i_59_ >> 12) * imageWidth + (i_58_ >> 12)];
                                        if(i_61_ != 0)
                                            Rasterizer.destinationPixels[i_57_++] = i_61_;
                                        else
                                            i_57_++;
                                    }
                                }
                                i_56_++;
                                i_48_ += Rasterizer.destinationWidth;
                            }
                        } else if(i_50_ < 0) {
                            int i_62_ = i_47_;
                            while(i_62_ < 0) {
                                int i_63_ = i_48_;
                                int i_64_ = i_54_;
                                int i_65_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_66_ = i_45_;
                                if(i_64_ >= 0 && i_64_ - (imageWidth << 12) < 0) {
                                    int i_67_;
                                    if((i_67_ = i_65_ - (imageHeight << 12)) >= 0) {
                                        i_67_ = (i_50_ - i_67_) / i_50_;
                                        i_66_ += i_67_;
                                        i_65_ += i_50_ * i_67_;
                                        i_63_ += i_67_;
                                    }
                                    if((i_67_ = (i_65_ - i_50_) / i_50_) > i_66_)
                                        i_66_ = i_67_;
                                    for(/**/; i_66_ < 0; i_66_++) {
                                        int i_68_ = pixels[(i_65_ >> 12) * imageWidth + (i_64_ >> 12)];
                                        if(i_68_ != 0)
                                            Rasterizer.destinationPixels[i_63_++] = i_68_;
                                        else
                                            i_63_++;
                                        i_65_ += i_50_;
                                    }
                                }
                                i_62_++;
                                i_54_ -= i_50_;
                                i_48_ += Rasterizer.destinationWidth;
                            }
                        } else {
                            int i_69_ = i_47_;
                            while(i_69_ < 0) {
                                int i_70_ = i_48_;
                                int i_71_ = i_54_;
                                int i_72_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_73_ = i_45_;
                                if(i_71_ >= 0 && i_71_ - (imageWidth << 12) < 0) {
                                    if(i_72_ < 0) {
                                        int i_74_ = (i_50_ - 1 - i_72_) / i_50_;
                                        i_73_ += i_74_;
                                        i_72_ += i_50_ * i_74_;
                                        i_70_ += i_74_;
                                    }
                                    int i_75_;
                                    if((i_75_ = (1 + i_72_ - (imageHeight << 12) - i_50_) / i_50_) > i_73_)
                                        i_73_ = i_75_;
                                    for(/**/; i_73_ < 0; i_73_++) {
                                        int i_76_ = pixels[(i_72_ >> 12) * imageWidth + (i_71_ >> 12)];
                                        if(i_76_ != 0)
                                            Rasterizer.destinationPixels[i_70_++] = i_76_;
                                        else
                                            i_70_++;
                                        i_72_ += i_50_;
                                    }
                                }
                                i_69_++;
                                i_54_ -= i_50_;
                                i_48_ += Rasterizer.destinationWidth;
                            }
                        }
                    } else if(i_51_ < 0) {
                        if(i_50_ == 0) {
                            int i_77_ = i_47_;
                            while(i_77_ < 0) {
                                int i_78_ = i_48_;
                                int i_79_ = i_54_ + (i_52_ * i_51_ >> 4);
                                int i_80_ = i_55_;
                                int i_81_ = i_45_;
                                if(i_80_ >= 0 && i_80_ - (imageHeight << 12) < 0) {
                                    int i_82_;
                                    if((i_82_ = i_79_ - (imageWidth << 12)) >= 0) {
                                        i_82_ = (i_51_ - i_82_) / i_51_;
                                        i_81_ += i_82_;
                                        i_79_ += i_51_ * i_82_;
                                        i_78_ += i_82_;
                                    }
                                    if((i_82_ = (i_79_ - i_51_) / i_51_) > i_81_)
                                        i_81_ = i_82_;
                                    for(/**/; i_81_ < 0; i_81_++) {
                                        int i_83_ = pixels[(i_80_ >> 12) * imageWidth + (i_79_ >> 12)];
                                        if(i_83_ != 0)
                                            Rasterizer.destinationPixels[i_78_++] = i_83_;
                                        else
                                            i_78_++;
                                        i_79_ += i_51_;
                                    }
                                }
                                i_77_++;
                                i_55_ += i_51_;
                                i_48_ += Rasterizer.destinationWidth;
                            }
                        } else if(i_50_ < 0) {
                            int i_84_ = i_47_;
                            while(i_84_ < 0) {
                                int i_85_ = i_48_;
                                int i_86_ = i_54_ + (i_52_ * i_51_ >> 4);
                                int i_87_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_88_ = i_45_;
                                int i_89_;
                                if((i_89_ = i_86_ - (imageWidth << 12)) >= 0) {
                                    i_89_ = (i_51_ - i_89_) / i_51_;
                                    i_88_ += i_89_;
                                    i_86_ += i_51_ * i_89_;
                                    i_87_ += i_50_ * i_89_;
                                    i_85_ += i_89_;
                                }
                                if((i_89_ = (i_86_ - i_51_) / i_51_) > i_88_)
                                    i_88_ = i_89_;
                                if((i_89_ = i_87_ - (imageHeight << 12)) >= 0) {
                                    i_89_ = (i_50_ - i_89_) / i_50_;
                                    i_88_ += i_89_;
                                    i_86_ += i_51_ * i_89_;
                                    i_87_ += i_50_ * i_89_;
                                    i_85_ += i_89_;
                                }
                                if((i_89_ = (i_87_ - i_50_) / i_50_) > i_88_)
                                    i_88_ = i_89_;
                                for(/**/; i_88_ < 0; i_88_++) {
                                    int i_90_ = pixels[(i_87_ >> 12) * imageWidth + (i_86_ >> 12)];
                                    if(i_90_ != 0)
                                        Rasterizer.destinationPixels[i_85_++] = i_90_;
                                    else
                                        i_85_++;
                                    i_86_ += i_51_;
                                    i_87_ += i_50_;
                                }
                                i_84_++;
                                i_54_ -= i_50_;
                                i_55_ += i_51_;
                                i_48_ += Rasterizer.destinationWidth;
                            }
                        } else {
                            int i_91_ = i_47_;
                            while(i_91_ < 0) {
                                int i_92_ = i_48_;
                                int i_93_ = i_54_ + (i_52_ * i_51_ >> 4);
                                int i_94_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_95_ = i_45_;
                                int i_96_;
                                if((i_96_ = i_93_ - (imageWidth << 12)) >= 0) {
                                    i_96_ = (i_51_ - i_96_) / i_51_;
                                    i_95_ += i_96_;
                                    i_93_ += i_51_ * i_96_;
                                    i_94_ += i_50_ * i_96_;
                                    i_92_ += i_96_;
                                }
                                if((i_96_ = (i_93_ - i_51_) / i_51_) > i_95_)
                                    i_95_ = i_96_;
                                if(i_94_ < 0) {
                                    i_96_ = (i_50_ - 1 - i_94_) / i_50_;
                                    i_95_ += i_96_;
                                    i_93_ += i_51_ * i_96_;
                                    i_94_ += i_50_ * i_96_;
                                    i_92_ += i_96_;
                                }
                                if((i_96_ = (1 + i_94_ - (imageHeight << 12) - i_50_) / i_50_) > i_95_)
                                    i_95_ = i_96_;
                                for(/**/; i_95_ < 0; i_95_++) {
                                    int i_97_ = pixels[(i_94_ >> 12) * imageWidth + (i_93_ >> 12)];
                                    if(i_97_ != 0)
                                        Rasterizer.destinationPixels[i_92_++] = i_97_;
                                    else
                                        i_92_++;
                                    i_93_ += i_51_;
                                    i_94_ += i_50_;
                                }
                                i_91_++;
                                i_54_ -= i_50_;
                                i_55_ += i_51_;
                                i_48_ += Rasterizer.destinationWidth;
                            }
                        }
                    } else if(i_50_ == 0) {
                        int i_98_ = i_47_;
                        while(i_98_ < 0) {
                            int i_99_ = i_48_;
                            int i_100_ = i_54_ + (i_52_ * i_51_ >> 4);
                            int i_101_ = i_55_;
                            int i_102_ = i_45_;
                            if(i_101_ >= 0 && i_101_ - (imageHeight << 12) < 0) {
                                if(i_100_ < 0) {
                                    int i_103_ = (i_51_ - 1 - i_100_) / i_51_;
                                    i_102_ += i_103_;
                                    i_100_ += i_51_ * i_103_;
                                    i_99_ += i_103_;
                                }
                                int i_104_;
                                if((i_104_ = (1 + i_100_ - (imageWidth << 12) - i_51_) / i_51_) > i_102_)
                                    i_102_ = i_104_;
                                for(/**/; i_102_ < 0; i_102_++) {
                                    int i_105_ = pixels[(i_101_ >> 12) * imageWidth + (i_100_ >> 12)];
                                    if(i_105_ != 0)
                                        Rasterizer.destinationPixels[i_99_++] = i_105_;
                                    else
                                        i_99_++;
                                    i_100_ += i_51_;
                                }
                            }
                            i_98_++;
                            i_55_ += i_51_;
                            i_48_ += Rasterizer.destinationWidth;
                        }
                    } else if(i_50_ < 0) {
                        int i_106_ = i_47_;
                        while(i_106_ < 0) {
                            int i_107_ = i_48_;
                            int i_108_ = i_54_ + (i_52_ * i_51_ >> 4);
                            int i_109_ = i_55_ + (i_52_ * i_50_ >> 4);
                            int i_110_ = i_45_;
                            if(i_108_ < 0) {
                                int i_111_ = (i_51_ - 1 - i_108_) / i_51_;
                                i_110_ += i_111_;
                                i_108_ += i_51_ * i_111_;
                                i_109_ += i_50_ * i_111_;
                                i_107_ += i_111_;
                            }
                            int i_112_;
                            if((i_112_ = (1 + i_108_ - (imageWidth << 12) - i_51_) / i_51_) > i_110_)
                                i_110_ = i_112_;
                            if((i_112_ = i_109_ - (imageHeight << 12)) >= 0) {
                                i_112_ = (i_50_ - i_112_) / i_50_;
                                i_110_ += i_112_;
                                i_108_ += i_51_ * i_112_;
                                i_109_ += i_50_ * i_112_;
                                i_107_ += i_112_;
                            }
                            if((i_112_ = (i_109_ - i_50_) / i_50_) > i_110_)
                                i_110_ = i_112_;
                            for(/**/; i_110_ < 0; i_110_++) {
                                int i_113_ = pixels[(i_109_ >> 12) * imageWidth + (i_108_ >> 12)];
                                if(i_113_ != 0)
                                    Rasterizer.destinationPixels[i_107_++] = i_113_;
                                else
                                    i_107_++;
                                i_108_ += i_51_;
                                i_109_ += i_50_;
                            }
                            i_106_++;
                            i_54_ -= i_50_;
                            i_55_ += i_51_;
                            i_48_ += Rasterizer.destinationWidth;
                        }
                    } else {
                        int i_114_ = i_47_;
                        while(i_114_ < 0) {
                            int i_115_ = i_48_;
                            int i_116_ = i_54_ + (i_52_ * i_51_ >> 4);
                            int i_117_ = i_55_ + (i_52_ * i_50_ >> 4);
                            int i_118_ = i_45_;
                            if(i_116_ < 0) {
                                int i_119_ = (i_51_ - 1 - i_116_) / i_51_;
                                i_118_ += i_119_;
                                i_116_ += i_51_ * i_119_;
                                i_117_ += i_50_ * i_119_;
                                i_115_ += i_119_;
                            }
                            int i_120_;
                            if((i_120_ = (1 + i_116_ - (imageWidth << 12) - i_51_) / i_51_) > i_118_)
                                i_118_ = i_120_;
                            if(i_117_ < 0) {
                                i_120_ = (i_50_ - 1 - i_117_) / i_50_;
                                i_118_ += i_120_;
                                i_116_ += i_51_ * i_120_;
                                i_117_ += i_50_ * i_120_;
                                i_115_ += i_120_;
                            }
                            if((i_120_ = (1 + i_117_ - (imageHeight << 12) - i_50_) / i_50_) > i_118_)
                                i_118_ = i_120_;
                            for(/**/; i_118_ < 0; i_118_++) {
                                int i_121_ = pixels[(i_117_ >> 12) * imageWidth + (i_116_ >> 12)];
                                if(i_121_ != 0)
                                    Rasterizer.destinationPixels[i_115_++] = i_121_;
                                else
                                    i_115_++;
                                i_116_ += i_51_;
                                i_117_ += i_50_;
                            }
                            i_114_++;
                            i_54_ -= i_50_;
                            i_55_ += i_51_;
                            i_48_ += Rasterizer.destinationWidth;
                        }
                    }
                }
            }
        }
    }

    public void prepareRasterizer(RasterizerInstanced rasterizer) {
        rasterizer.prepare(pixels, imageWidth, imageHeight);
    }

    public void shapeImageToPixels(RasterizerInstanced rasterizer, int x, int y, int width, int height, int arg4, int arg5, int k1, int zoom, int[] arg8, int[] arg9) {
        try {
            int centerX = -width / 2;
            int centerY = -height / 2;
            int sine = (int) (Math.sin((double) k1 / 326.11) * 65536.0);
            int cosine = (int) (Math.cos((double) k1 / 326.11) * 65536.0);
            sine = sine * zoom >> 8;
            cosine = cosine * zoom >> 8;
            int i_125_ = (arg4 << 16) + centerY * sine + centerX * cosine;
            int i_126_ = (arg5 << 16) + centerY * cosine - centerX * sine;
            int destinationOffset = x + y * rasterizer.destinationWidth;

            for(y = 0; y < height; y++) {
                int i_128_ = arg8[y];
                int i_129_ = destinationOffset + i_128_;
                int i_130_ = i_125_ + cosine * i_128_;
                int i_131_ = i_126_ - sine * i_128_;
                for(x = -arg9[y]; x < 0; x++) {
                    int pixelToGet = (i_130_ >> 16) + (i_131_ >> 16) * imageWidth;
                    int colour = 0;
                    if(!(pixels.length < pixelToGet || pixelToGet < 0)){
                        colour = pixels[pixelToGet];
                    }
                    rasterizer.destinationPixels[i_129_++] = colour;
                    i_130_ += cosine;
                    i_131_ -= sine;
                }
                i_125_ += sine;
                i_126_ += cosine;
                destinationOffset += rasterizer.destinationWidth;
            }
        } catch(Exception exception) {
            /* empty */
            exception.printStackTrace();
        }
    }

    public void drawTo(RasterizerInstanced rasterizer, IndexedImage indexedImage, int x, int y) {
        x += offsetX;
        y += offsetY;
        int dest_ptr = x + y * rasterizer.destinationWidth;
        int source_ptr = 0;
        int line_count = imageHeight;
        int line_width = imageWidth;
        int line_offset_dest = rasterizer.destinationWidth - line_width;
        int line_offset_src = 0;
        if(y < rasterizer.viewportTop) {
            int clip_height = rasterizer.viewportTop - y;
            line_count -= clip_height;
            y = rasterizer.viewportTop;
            source_ptr += clip_height * line_width;
            dest_ptr += clip_height * rasterizer.destinationWidth;
        }
        if(y + line_count > rasterizer.viewportBottom)
            line_count -= y + line_count - rasterizer.viewportBottom;
        if(x < rasterizer.viewportLeft) {
            int clip_width = rasterizer.viewportLeft - x;
            line_width -= clip_width;
            x = rasterizer.viewportLeft;
            source_ptr += clip_width;
            dest_ptr += clip_width;
            line_offset_src += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > rasterizer.viewportRight) {
            int clip_width = x + line_width - rasterizer.viewportRight;
            line_width -= clip_width;
            line_offset_src += clip_width;
            line_offset_dest += clip_width;
        }
        if(line_width > 0 && line_count > 0)
            blockCopyMask(rasterizer.destinationPixels, pixels, 0, source_ptr, dest_ptr, line_width, line_count, line_offset_dest, line_offset_src, indexedImage.imgPixels);
    }

    public void trim() {
        if(imageWidth != maxWidth || imageHeight != maxHeight) {
            int[] newPixels = new int[maxWidth * maxHeight];
            for(int y = 0; y < imageHeight; y++) {
                for(int x = 0; x < imageWidth; x++)
                    newPixels[(y + offsetY) * maxWidth + x + offsetX] = pixels[y * imageWidth + x];
            }
            pixels = newPixels;
            imageWidth = maxWidth;
            imageHeight = maxHeight;
            offsetX = 0;
            offsetY = 0;
        }
    }

    public void drawInverse(RasterizerInstanced rasterizer, int x, int y) {
        x += offsetX;
        y += offsetY;
        int rasterizerPixel = x + y * rasterizer.destinationWidth;
        int pixel = 0;
        int newHeight = imageHeight;
        int newWidth = imageWidth;
        int rasterizerPixelOffset = rasterizer.destinationWidth - newWidth;
        int pixelOffset = 0;
        if(y < rasterizer.viewportTop) {
            int yOffset = rasterizer.viewportTop - y;
            newHeight -= yOffset;
            y = rasterizer.viewportTop;
            pixel += yOffset * newWidth;
            rasterizerPixel += yOffset * rasterizer.destinationWidth;
        }
        if(y + newHeight > rasterizer.viewportBottom)
            newHeight -= y + newHeight - rasterizer.viewportBottom;
        if(x < rasterizer.viewportLeft) {
            int xOffset = rasterizer.viewportLeft - x;
            newWidth -= xOffset;
            x = rasterizer.viewportLeft;
            pixel += xOffset;
            rasterizerPixel += xOffset;
            pixelOffset += xOffset;
            rasterizerPixelOffset += xOffset;
        }
        if(x + newWidth > rasterizer.viewportRight) {
            int widthOffset = x + newWidth - rasterizer.viewportRight;
            newWidth -= widthOffset;
            pixelOffset += widthOffset;
            rasterizerPixelOffset += widthOffset;
        }
        if(newWidth > 0 && newHeight > 0)
            copyPixels(rasterizer.destinationPixels, pixels, pixel, rasterizerPixel, newWidth, newHeight, rasterizerPixelOffset, pixelOffset);
    }

    public void drawInverse(int x, int y) {
        x += offsetX;
        y += offsetY;
        int rasterizerPixel = x + y * Rasterizer.destinationWidth;
        int pixel = 0;
        int newHeight = imageHeight;
        int newWidth = imageWidth;
        int rasterizerPixelOffset = Rasterizer.destinationWidth - newWidth;
        int pixelOffset = 0;
        if(y < Rasterizer.viewportTop) {
            int yOffset = Rasterizer.viewportTop - y;
            newHeight -= yOffset;
            y = Rasterizer.viewportTop;
            pixel += yOffset * newWidth;
            rasterizerPixel += yOffset * Rasterizer.destinationWidth;
        }
        if(y + newHeight > Rasterizer.viewportBottom)
            newHeight -= y + newHeight - Rasterizer.viewportBottom;
        if(x < Rasterizer.viewportLeft) {
            int xOffset = Rasterizer.viewportLeft - x;
            newWidth -= xOffset;
            x = Rasterizer.viewportLeft;
            pixel += xOffset;
            rasterizerPixel += xOffset;
            pixelOffset += xOffset;
            rasterizerPixelOffset += xOffset;
        }
        if(x + newWidth > Rasterizer.viewportRight) {
            int widthOffset = x + newWidth - Rasterizer.viewportRight;
            newWidth -= widthOffset;
            pixelOffset += widthOffset;
            rasterizerPixelOffset += widthOffset;
        }
        if(newWidth > 0 && newHeight > 0)
            copyPixels(Rasterizer.destinationPixels, pixels, pixel, rasterizerPixel, newWidth, newHeight, rasterizerPixelOffset, pixelOffset);
    }

    public void drawImageWithOpacity(int x, int y, int opacity) {
        x += offsetX;
        y += offsetY;
        int i = x + y * Rasterizer.destinationWidth;
        int i_149_ = 0;
        int i_150_ = imageHeight;
        int i_151_ = imageWidth;
        int i_152_ = Rasterizer.destinationWidth - i_151_;
        int i_153_ = 0;
        if(y < Rasterizer.viewportTop) {
            int i_154_ = Rasterizer.viewportTop - y;
            i_150_ -= i_154_;
            y = Rasterizer.viewportTop;
            i_149_ += i_154_ * i_151_;
            i += i_154_ * Rasterizer.destinationWidth;
        }
        if(y + i_150_ > Rasterizer.viewportBottom)
            i_150_ -= y + i_150_ - Rasterizer.viewportBottom;
        if(x < Rasterizer.viewportLeft) {
            int i_155_ = Rasterizer.viewportLeft - x;
            i_151_ -= i_155_;
            x = Rasterizer.viewportLeft;
            i_149_ += i_155_;
            i += i_155_;
            i_153_ += i_155_;
            i_152_ += i_155_;
        }
        if(x + i_151_ > Rasterizer.viewportRight) {
            int i_156_ = x + i_151_ - Rasterizer.viewportRight;
            i_151_ -= i_156_;
            i_153_ += i_156_;
            i_152_ += i_156_;
        }
        if(i_151_ > 0 && i_150_ > 0)
            method730(Rasterizer.destinationPixels, pixels, 0, i_149_, i, i_151_, i_150_, i_152_, i_153_, opacity);
    }

    public void drawRotated(RasterizerInstanced rasterizer, int x, int y, int pivotX, int pivotY, int width, int height, int zoom, double angle) {
        try {
            int centerX = -width / 2;
            int centerY = -height / 2;
            int sine = (int) (Math.sin(angle) * 65536.0);
            int cosine = (int) (Math.cos(angle) * 65536.0);
            sine = sine * zoom >> 8;
            cosine = cosine * zoom >> 8;
            int sourceOffsetX = (pivotX << 16) + centerY * sine + centerX * cosine;
            int sourceoffsetY = (pivotY << 16) + centerY * cosine - centerX * sine;
            int destinationOffset = x + y * rasterizer.destinationWidth;
            for(y = 0; y < height; y++) {
                int i = destinationOffset;
                int offsetX = sourceOffsetX;
                int offsetY = sourceoffsetY;
                for(x = -width; x < 0; x++) {
                    int i_166_ = pixels[(offsetX >> 16) + (offsetY >> 16) * imageWidth];
                    if(i_166_ != 0)
                        rasterizer.destinationPixels[i++] = i_166_;
                    else
                        i++;
                    offsetX += cosine;
                    offsetY -= sine;
                }
                sourceOffsetX += sine;
                sourceoffsetY += cosine;
                destinationOffset += rasterizer.destinationWidth;
            }
        } catch(Exception exception) {
            /* empty */
        }

    }

    public void method732(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 > 0 && arg3 > 0) {
            int i = imageWidth;
            int i_171_ = imageHeight;
            int i_172_ = 0;
            int i_173_ = 0;
            int i_174_ = maxWidth;
            int i_175_ = maxHeight;
            int i_176_ = (i_174_ << 16) / arg2;
            int i_177_ = (i_175_ << 16) / arg3;
            if(offsetX > 0) {
                int i_178_ = ((offsetX << 16) + i_176_ - 1) / i_176_;
                arg0 += i_178_;
                i_172_ += i_178_ * i_176_ - (offsetX << 16);
            }
            if(offsetY > 0) {
                int i_179_ = ((offsetY << 16) + i_177_ - 1) / i_177_;
                arg1 += i_179_;
                i_173_ += i_179_ * i_177_ - (offsetY << 16);
            }
            if(i < i_174_)
                arg2 = ((i << 16) - i_172_ + i_176_ - 1) / i_176_;
            if(i_171_ < i_175_)
                arg3 = ((i_171_ << 16) - i_173_ + i_177_ - 1) / i_177_;
            int i_180_ = arg0 + arg1 * Rasterizer.destinationWidth;
            int i_181_ = Rasterizer.destinationWidth - arg2;
            if(arg1 + arg3 > Rasterizer.viewportBottom)
                arg3 -= arg1 + arg3 - Rasterizer.viewportBottom;
            if(arg1 < Rasterizer.viewportTop) {
                int i_182_ = Rasterizer.viewportTop - arg1;
                arg3 -= i_182_;
                i_180_ += i_182_ * Rasterizer.destinationWidth;
                i_173_ += i_177_ * i_182_;
            }
            if(arg0 + arg2 > Rasterizer.viewportRight) {
                int i_183_ = arg0 + arg2 - Rasterizer.viewportRight;
                arg2 -= i_183_;
                i_181_ += i_183_;
            }
            if(arg0 < Rasterizer.viewportLeft) {
                int i_184_ = Rasterizer.viewportLeft - arg0;
                arg2 -= i_184_;
                i_180_ += i_184_;
                i_172_ += i_176_ * i_184_;
                i_181_ += i_184_;
            }
            method715(Rasterizer.destinationPixels, pixels, 0, i_172_, i_173_, i_180_, i_181_, arg2, arg3, i_176_, i_177_, i);
        }
    }
}
