package com.jagex.runescape.cache.media;

import com.jagex.runescape.Class40_Sub5_Sub17_Sub3;
import com.jagex.runescape.RSString;
import com.jagex.runescape.Rasterizer;

import java.util.Random;

public class TypeFace extends Rasterizer {
    private RSString[] aClass1Array2897 = new RSString[100];
    private RSString col_cyan = RSString.CreateString("cya");
    private RSString col_light_orange = RSString.CreateString("or1");
    private RSString col_blue = RSString.CreateString("blu");
    private RSString col_magenta = RSString.CreateString("mag");
    private RSString col_white = RSString.CreateString("whi");
    private RSString col_dark_red_dbl = RSString.CreateString("dbl");
    private RSString col_yellow_green = RSString.CreateString("gr1");
    private RSString col_light_green = RSString.CreateString("gr2");
    private RSString col_red = RSString.CreateString("red");
    private RSString col_green = RSString.CreateString("gre");
    private RSString col_orange = RSString.CreateString("or2");
    private RSString col_black = RSString.CreateString("bla");
    private RSString col_red_orange = RSString.CreateString("or3");
    private RSString col_orange_lre = RSString.CreateString("lre");
    private RSString col_dark_red = RSString.CreateString("dre");
    private RSString col_green_gr3 = RSString.CreateString("gr3");
    private RSString col_yellow = RSString.CreateString("yel");
    private RSString effect_strikethough = RSString.CreateString("str");

    private Random random;
    private int[] characterScreenWidths;
    public int characterDefaultHeight;
    private int[] characterYOffsets;
    private byte[][] characterPixels;
    private int[] anIntArray2915;
    private boolean strikethrough;
    private int anInt2919;
    private int anInt2920;

    public TypeFace(int[] arg0, int[] arg1, int[] arg2, int[] arg3, byte[][] arg4) {
        characterDefaultHeight = 0;
        random = new Random();
        strikethrough = false;
        characterYOffsets = arg0;
        characterScreenWidths = arg1;
        anIntArray2915 = arg2;
        byte i = 0;
        for(int i_47_ = 1; i_47_ < arg3.length; i_47_++) {
            if(arg3[i_47_] == 1)
                i = (byte) i_47_;
        }
        characterPixels = arg4;
        int i_48_ = 2147483647;
        int i_49_ = -2147483648;
        for(int i_50_ = 0; i_50_ < 256; i_50_++) {
            if(characterYOffsets[i_50_] < i_48_)
                i_48_ = characterYOffsets[i_50_];
            if(characterYOffsets[i_50_] + anIntArray2915[i_50_] > i_49_)
                i_49_ = characterYOffsets[i_50_] + anIntArray2915[i_50_];
            byte[] is = characterPixels[i_50_];
            int i_51_ = is.length;
            for(int i_52_ = 0; i_52_ < i_51_; i_52_++)
                is[i_52_] = is[i_52_] == i ? (byte) 0 : (byte) 1;
        }
        characterDefaultHeight = characterYOffsets[32] + anIntArray2915[32];
        anInt2920 = characterDefaultHeight - i_48_;
        anInt2919 = i_49_ - characterDefaultHeight;
    }

    private int getColour(RSString getColour) {
        if(getColour.equals(col_red))
            return 0xff0000;
        if(getColour.equals(col_green))
            return 0x00ff00;
        if(getColour.equals(col_blue))
            return 0x0000ff;
        if(getColour.equals(col_yellow))
            return 0xffff00;
        if(getColour.equals(col_cyan))
            return 0x00ffff;
        if(getColour.equals(col_magenta))
            return 0xff00ff;
        if(getColour.equals(col_white))
            return 0xffffff;
        if(getColour.equals(col_black))
            return 0x000000;
        if(getColour.equals(col_orange_lre))
            return 0xff9040;
        if(getColour.equals(col_dark_red))
            return 0x800000;
        if(getColour.equals(col_dark_red_dbl))
            return 0x800000;
        if(getColour.equals(col_light_orange))
            return 0xffb000;
        if(getColour.equals(col_orange))
            return 0xff7000;
        if(getColour.equals(col_red_orange))
            return 0xff3000;
        if(getColour.equals(col_yellow_green))
            return 0xc0ff00;
        if(getColour.equals(col_light_green))
            return 0x80ff00;
        if(getColour.equals(col_green_gr3))
            return 0x40ff00;
        if(getColour.equals(effect_strikethough))
            strikethrough = true;
        return -1;
    }

    private void drawCharacterPixels(byte[] characterPixels, int[] rasterizerPixels, int characterPixel, int rasterizerPixel, int characterPixelOffset, int rasterizerPixelOffset, int width, int height, int colour) {
        int negativeQuaterWidth = -(width >> 2);
        width = -(width & 0x3);
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = negativeQuaterWidth; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] != 0)
                    rasterizerPixels[rasterizerPixel++] = colour;
                else
                    rasterizerPixel++;
                if(characterPixels[characterPixel++] != 0)
                    rasterizerPixels[rasterizerPixel++] = colour;
                else
                    rasterizerPixel++;
                if(characterPixels[characterPixel++] != 0)
                    rasterizerPixels[rasterizerPixel++] = colour;
                else
                    rasterizerPixel++;
                if(characterPixels[characterPixel++] != 0)
                    rasterizerPixels[rasterizerPixel++] = colour;
                else
                    rasterizerPixel++;
            }
            for(int widthCounter = width; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] != 0)
                    rasterizerPixels[rasterizerPixel++] = colour;
                else
                    rasterizerPixel++;
            }
            rasterizerPixel += rasterizerPixelOffset;
            characterPixel += characterPixelOffset;
        }
    }

    public void method672(RSString arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, int arg7, int arg8, int arg9) {
        if(arg0 != null) {
            int i = 0;
            int i_3_ = 0;
            RSString class1 = Class40_Sub5_Sub17_Sub3.method777(-18596, 100);
            int i_4_ = -1;
            int i_5_ = 0;
            RSString class1_6_ = null;
            if(arg9 == 0)
                arg9 = anInt2920;
            boolean bool = true;
            if(arg4 < anInt2920 + anInt2919 + arg9 && arg4 < arg9 + arg9)
                bool = false;
            int i_7_ = 0;
            int i_8_ = arg0.length();
            for(int i_9_ = 0; i_9_ < i_8_; i_9_++) {
                int i_10_ = arg0.method55(i_9_, false);
                if(i_10_ == 64 && i_9_ + 4 < i_8_ && arg0.method55(i_9_ + 4, false) == 64) {
                    class1_6_ = arg0.substring(i_9_, i_9_ + 5);
                    class1.method72(class1_6_, (byte) -87);
                    i_9_ += 4;
                } else if(i_10_ == 92 && i_9_ + 1 < i_8_ && arg0.method55(i_9_ + 1, false) == 110) {
                    class1_6_ = null;
                    aClass1Array2897[i_7_++] = class1.substring(i_3_, class1.length()).trim();
                    i_3_ = class1.length();
                    i = 0;
                    i_4_ = -1;
                    i_9_++;
                } else {
                    class1.method78(-62, i_10_);
                    i += method689(i_10_);
                    if(i_10_ == 32 || i_10_ == 45) {
                        i_4_ = class1.length();
                        i_5_ = i;
                    }
                    if(bool && i > arg3 && i_4_ >= 0) {
                        aClass1Array2897[i_7_++] = class1.substring(i_3_, i_4_).trim();
                        i_3_ = i_4_;
                        i_4_ = -1;
                        i -= i_5_;
                        if(class1_6_ != null && i_3_ > 4) {
                            i_3_ -= 5;
                            class1.method69(class1_6_, 16039, i_3_);
                        }
                    }
                }
            }
            if(class1.length() > i_3_)
                aClass1Array2897[i_7_++] = class1.substring(i_3_, class1.length()).trim();
            if(arg8 == 3 && i_7_ == 1)
                arg8 = 1;
            int i_11_;
            if(arg8 == 0)
                i_11_ = arg2 + anInt2920;
            else if(arg8 == 1)
                i_11_ = arg2 + anInt2920 + (arg4 - anInt2920 - anInt2919 - (i_7_ - 1) * arg9) / 2;
            else if(arg8 == 2)
                i_11_ = arg2 + arg4 - anInt2919 - (i_7_ - 1) * arg9;
            else {
                int i_12_ = ((arg4 - anInt2920 - anInt2919 - (i_7_ - 1) * arg9) / (i_7_ + 1));
                if(i_12_ < 0)
                    i_12_ = 0;
                i_11_ = arg2 + anInt2920 + i_12_;
                arg9 += i_12_;
            }
            for(int i_13_ = 0; i_13_ < i_7_; i_13_++) {
                if(arg7 == 0)
                    method683(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6);
                else if(arg7 == 1)
                    method688(aClass1Array2897[i_13_], arg1 + arg3 / 2, i_11_, arg5, arg6);
                else if(arg7 == 2)
                    method677(aClass1Array2897[i_13_], arg1 + arg3, i_11_, arg5, arg6);
                else if(i_13_ == i_7_ - 1)
                    method683(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6);
                else
                    method680(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6, arg3);
                i_11_ += arg9;
            }
        }
    }

    public void method673(RSString arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg0 != null) {
            arg1 -= getStringWidth(arg0) / 2;
            arg2 -= characterDefaultHeight;
            for(int index = 0; index < arg0.length; index++) {
                int character = arg0.chars[index] & 0xff;
                if(character != ' ')
                    drawCharacterLegacy(characterPixels[character], arg1, (arg2 + characterYOffsets[character] + (int) (Math.sin((double) index / 2.0 + (double) arg4 / 5.0) * 5.0)), characterScreenWidths[character], anIntArray2915[character], arg3);
                arg1 += characterScreenWidths[character];
            }
        }
    }

    private void method674(int[] arg0, byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        arg2 = ((arg2 & 0xff00ff) * arg9 & ~0xff00ff) + ((arg2 & 0xff00) * arg9 & 0xff0000) >> 8;
        arg9 = 256 - arg9;
        for(int i = -arg6; i < 0; i++) {
            for(int i_15_ = -arg5; i_15_ < 0; i_15_++) {
                if(arg1[arg3++] != 0) {
                    int i_16_ = arg0[arg4];
                    arg0[arg4++] = ((((i_16_ & 0xff00ff) * arg9 & ~0xff00ff) + ((i_16_ & 0xff00) * arg9 & 0xff0000)) >> 8) + arg2;
                } else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public void method675(RSString arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg0 != null) {
            arg1 -= getStringWidth(arg0) / 2;
            arg2 -= characterDefaultHeight;
            for(int index = 0; index < arg0.length(); index++) {
                int character = arg0.chars[index] & 0xff;
                if(character != ' ')
                    drawCharacterLegacy(characterPixels[character], arg1 + (int) (Math.sin((double) index / 5.0 + (double) arg4 / 5.0) * 5.0), (arg2 + characterYOffsets[character] + (int) (Math.sin((double) index / 3.0 + (double) arg4 / 5.0) * 5.0)), characterScreenWidths[character], anIntArray2915[character], arg3);
                arg1 += characterScreenWidths[character];
            }
        }
    }

    public void method677(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        method683(arg0, arg1 - method681(arg0), arg2, arg3, arg4);
    }

    public void method678(RSString arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 != null) {
            double d = 7.0 - (double) arg5 / 8.0;
            if(d < 0.0)
                d = 0.0;
            arg1 -= getStringWidth(arg0) / 2;
            arg2 -= characterDefaultHeight;
            for(int i = 0; i < arg0.length(); i++) {
                int i_18_ = arg0.chars[i] & 0xff;
                if(i_18_ != ' ')
                    drawCharacterLegacy(characterPixels[i_18_], arg1, (arg2 + characterYOffsets[i_18_] + (int) (Math.sin((double) i / 1.5 + (double) arg4) * d)), characterScreenWidths[i_18_], anIntArray2915[i_18_], arg3);
                arg1 += characterScreenWidths[i_18_];
            }
        }
    }

    private void method679(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        int i = arg1 + arg2 * Rasterizer.width;
        int i_19_ = Rasterizer.width - arg3;
        int i_20_ = 0;
        int i_21_ = 0;
        if(arg2 < Rasterizer.viewport_top) {
            int i_22_ = Rasterizer.viewport_top - arg2;
            arg4 -= i_22_;
            arg2 = Rasterizer.viewport_top;
            i_21_ += i_22_ * arg3;
            i += i_22_ * Rasterizer.width;
        }
        if(arg2 + arg4 > Rasterizer.viewport_bottom)
            arg4 -= arg2 + arg4 - Rasterizer.viewport_bottom;
        if(arg1 < Rasterizer.viewport_left) {
            int i_23_ = Rasterizer.viewport_left - arg1;
            arg3 -= i_23_;
            arg1 = Rasterizer.viewport_left;
            i_21_ += i_23_;
            i += i_23_;
            i_20_ += i_23_;
            i_19_ += i_23_;
        }
        if(arg1 + arg3 > Rasterizer.viewport_right) {
            int i_24_ = arg1 + arg3 - Rasterizer.viewport_right;
            arg3 -= i_24_;
            i_20_ += i_24_;
            i_19_ += i_24_;
        }
        if(arg3 > 0 && arg4 > 0)
            method674(Rasterizer.pixels, arg0, arg5, i_21_, i, arg3, arg4, i_19_, i_20_, arg6);
    }

    private void method680(RSString arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        arg0 = arg0.trim();
        int i = 0;
        for(int i_25_ = 0; i_25_ < arg0.length(); i_25_++) {
            if(arg0.method55(i_25_, false) == 32)
                i++;
        }
        int i_26_ = 0;
        int i_27_ = 0;
        if(i > 0)
            i_26_ = (arg5 - method681(arg0)) * 256 / i;
        strikethrough = false;
        int i_28_ = arg1;
        if(arg0 != null) {
            arg2 -= characterDefaultHeight;
            for(int i_29_ = 0; i_29_ < arg0.length; i_29_++) {
                if(arg0.chars[i_29_] == '@' && i_29_ + 4 < arg0.length && arg0.chars[i_29_ + 4] == '@') {
                    int i_30_ = getColour(arg0.substring(i_29_ + 1, i_29_ + 4));
                    if(i_30_ != -1)
                        arg3 = i_30_;
                    i_29_ += 4;
                } else {
                    int i_31_ = arg0.chars[i_29_] & 0xff;
                    if(i_31_ != 32) {
                        if(arg4)
                            drawCharacterLegacy(characterPixels[i_31_], arg1 + 1, arg2 + characterYOffsets[i_31_] + 1, characterScreenWidths[i_31_], anIntArray2915[i_31_], 0);
                        drawCharacterLegacy(characterPixels[i_31_], arg1, arg2 + characterYOffsets[i_31_], characterScreenWidths[i_31_], anIntArray2915[i_31_], arg3);
                    }
                    arg1 += characterScreenWidths[i_31_];
                    if(i_31_ == 32) {
                        i_27_ += i_26_;
                        arg1 += i_27_ / 256;
                        i_27_ &= 0xff;
                    }
                }
            }
            if(strikethrough)
                Rasterizer.method659(i_28_, arg2 + (int) ((double) characterDefaultHeight * 0.7), arg1 - i_28_, 8388608);
        }
    }

    public int method681(RSString string) {
        if(string == null)
            return 0;
        int i = 0;
        for(int idx = 0; idx < string.length; idx++) {
            if(string.chars[idx] == '@' && idx + 4 < string.length && string.chars[idx + 4] == '@')
                idx += 4;
            else
                i += characterScreenWidths[string.chars[idx] & 0xff];
        }
        return i;
    }

    private void drawCharacterLegacy(byte[] pixels, int x, int y, int width, int height, int colour) {
        int rasterizerPixel = x + y * Rasterizer.width;
        int remainingWidth = Rasterizer.width - width;
        int characterPixelOffset = 0;
        int characterPixel = 0;
        if(y < Rasterizer.viewport_top) {
            int offsetY = Rasterizer.viewport_top - y;
            height -= offsetY;
            y = Rasterizer.viewport_top;
            characterPixel += offsetY * width;
            rasterizerPixel += offsetY * Rasterizer.width;
        }
        if(y + height > Rasterizer.viewport_bottom)
            height -= y + height - Rasterizer.viewport_bottom;
        if(x < Rasterizer.viewport_left) {
            int offsetX = Rasterizer.viewport_left - x;
            width -= offsetX;
            x = Rasterizer.viewport_left;
            characterPixel += offsetX;
            rasterizerPixel += offsetX;
            characterPixelOffset += offsetX;
            remainingWidth += offsetX;
        }
        if(x + width > Rasterizer.viewport_right) {
            int endOffsetX = x + width - Rasterizer.viewport_right;
            width -= endOffsetX;
            characterPixelOffset += endOffsetX;
            remainingWidth += endOffsetX;
        }
        if(width > 0 && height > 0)
            drawCharacterPixels(pixels, Rasterizer.pixels, characterPixel, rasterizerPixel, characterPixelOffset, remainingWidth, width, height, colour);
    }

    public void method683(RSString string, int arg1, int arg2, int arg3, boolean arg4) {
        strikethrough = false;
        int i = arg1;
        if(string != null) {
            arg2 -= characterDefaultHeight;
            for(int index = 0; index < string.length; index++) {
                if(string.chars[index] == 64 && index + 4 < string.length && string.chars[index + 4] == 64) {
                    int i_40_ = getColour(string.substring(index + 1, index + 4));
                    if(i_40_ != -1)
                        arg3 = i_40_;
                    index += 4;
                } else {
                    int character = string.chars[index] & 0xff;
                    if(character != ' ') {
                        if(arg4)
                            drawCharacterLegacy(characterPixels[character], arg1 + 1, arg2 + characterYOffsets[character] + 1, characterScreenWidths[character], anIntArray2915[character], 0);
                        drawCharacterLegacy(characterPixels[character], arg1, arg2 + characterYOffsets[character], characterScreenWidths[character], anIntArray2915[character], arg3);
                    }
                    arg1 += characterScreenWidths[character];
                }
            }
            if(strikethrough)
                Rasterizer.method659(i, arg2 + (int) ((double) characterDefaultHeight * 0.7), arg1 - i, 8388608);
        }
    }

    public void method684(RSString string, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        if(string != null) {
            random.setSeed((long) arg5);
            int i = 192 + (random.nextInt() & 0x1f);
            arg2 -= characterDefaultHeight;
            for(int index = 0; index < string.length; index++) {
                if(string.chars[index] == '@' && index + 4 < string.length && string.chars[index + 4] == '@') {
                    int i_43_ = getColour(string.substring(index + 1, index + 4));
                    if(i_43_ != -1)
                        arg3 = i_43_;
                    index += 4;
                } else {
                    int character = string.chars[index] & 0xff;
                    if(character != ' ') {
                        if(arg4)
                            method679(characterPixels[character], arg1 + 1, arg2 + characterYOffsets[character] + 1, characterScreenWidths[character], anIntArray2915[character], 0, 192);
                        method679(characterPixels[character], arg1, arg2 + characterYOffsets[character], characterScreenWidths[character], anIntArray2915[character], arg3, i);
                    }
                    arg1 += characterScreenWidths[character];
                    if((random.nextInt() & 0x3) == 0)
                        arg1++;
                }
            }
        }
    }

    public int getStringWidth(RSString string) {
        if(string == null)
            return 0;
        int i = 0;
        for(int idx = 0; idx < string.length; idx++)
            i += characterScreenWidths[string.chars[idx] & 0xff];
        return i;
    }

    public void method686(RSString arg0, int arg1, int arg2, int arg3) {
        drawString(arg0, arg1 - getStringWidth(arg0) / 2, arg2, arg3);
    }

    public void method687(RSString arg0, int arg1, int arg2, int arg3) {
        drawString(arg0, arg1 - getStringWidth(arg0), arg2, arg3);
    }

    public void method688(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        method683(arg0, arg1 - method681(arg0) / 2, arg2, arg3, arg4);
    }

    public int method689(int arg0) {
        return characterScreenWidths[arg0 & 0xff];
    }

    public void drawString(RSString string, int x, int y, int colour) {
        if(string != null) {
            y -= characterDefaultHeight;
            for(int index = 0; index < string.length; index++) {
                int character = string.chars[index] & 0xff;
                if(character != ' ')
                    drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character], characterScreenWidths[character], anIntArray2915[character], colour);
                x += characterScreenWidths[character];
            }
        }
    }
}
