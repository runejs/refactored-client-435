package com.jagex.runescape.cache.media;

import com.jagex.runescape.Class17;
import com.jagex.runescape.RSString;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.TextUtils.TextColourNode;
import com.jagex.runescape.cache.media.TextUtils.TextColourQueue;
import com.jagex.runescape.cache.media.TextUtils.TextTagNode;
import com.jagex.runescape.cache.media.TextUtils.TextTagQueue;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.scene.GroundItemTile;

import java.awt.*;
import java.util.Random;

import static com.jagex.runescape.Class40_Sub5_Sub13.moderatorIcon;

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

    private static String greaterThan = "gt";
    private static String lessThan = "lt";
    private static String euroSymbol = "euro";
    private static String startShadow = "shad=";
    private static String softHyphen = "shy";
    private static String startTrans = "trans=";
    private static String startUnderline = "u=";
    private static String startStrikethrough = "str=";
    private static String endColor = "/col";
    private static String endShadow = "/shad";
    private static String endTrans = "/trans";
    private static String endUnderline = "/u";
    private static String endStrikeThrough = "/str";
    private static String startDefaultUnderline = "u";
    private static String startDefaultStrikeThrough = "str";
    private static String startDefaultShadow = "shad";
    private static String startColor = "col=";
    private static String multiplicationSymbol = "times";
    private static String nonBreakingSpace = "nbsp";
    private static String image = "img=";
    private static String copyright = "copy";
    private static String lineBreak = "br";
    private static String registeredTrademark = "reg";
    private static int strikethroughColor = -1;
    private static int underlineColor = -1;
    private static int defaultTextColor = 0;
    private static int opacity = 256;
    private static int defaultOpacity = 256;
    private static int defaultShadowColor = -1;
    private static int shadowColor = -1;
    private static int textColor = 0xff00ff;
    private static int whiteSpace = 0;

    private Random random;
    private int[] characterScreenWidths;
    public int characterDefaultHeight;
    private int[] characterYOffsets;
    private byte[][] characterPixels;
    private int[] characterHeights;
    private boolean strikethrough;
    private int anInt2919;
    private int anInt2920;
    private TextColourQueue textcolour;

    public TypeFace(int[] arg0, int[] arg1, int[] arg2, int[] arg3, byte[][] arg4) {
        characterDefaultHeight = 0;
        random = new Random();
        strikethrough = false;
        characterYOffsets = arg0;
        characterScreenWidths = arg1;
        characterHeights = arg2;
        byte i = 0;
        for(int i_47_ = 1; i_47_ < arg3.length; i_47_++) {
            if(arg3[i_47_] == 1)
                i = (byte) i_47_;
        }
        characterPixels = arg4;
        int i_48_ = Integer.MAX_VALUE;
        int i_49_ = Integer.MIN_VALUE;
        for(int i_50_ = 0; i_50_ < 256; i_50_++) {
            if(characterYOffsets[i_50_] < i_48_)
                i_48_ = characterYOffsets[i_50_];
            if(characterYOffsets[i_50_] + characterHeights[i_50_] > i_49_)
                i_49_ = characterYOffsets[i_50_] + characterHeights[i_50_];
            byte[] is = characterPixels[i_50_];
            int i_51_ = is.length;
            for(int i_52_ = 0; i_52_ < i_51_; i_52_++)
                is[i_52_] = is[i_52_] == i ? (byte) 0 : (byte) 1;
        }
        characterDefaultHeight = characterYOffsets[32] + characterHeights[32];
        anInt2920 = characterDefaultHeight - i_48_;
        anInt2919 = i_49_ - characterDefaultHeight;
    }

    public static TypeFace constructFont() {
        TypeFace class40_sub5_sub14_sub1 = new TypeFace((Actor.anIntArray3111), Class17.anIntArray456, (Npc.anIntArray3312), Buffer.anIntArray1972, GroundItemTile.aByteArrayArray1370);
        ActorDefinition.method569();
        return class40_sub5_sub14_sub1;
    }

    public static TypeFace getFont(CacheIndex arg2, int arg0, int arg3) {
        if(!ImageRGB.spriteExists(arg0, arg3, arg2))
            return null;
        return constructFont();
    }

    public static TypeFace loadTypeFace(CacheIndex arg0, RSString arg2, RSString arg3) {
        int i = arg0.getHash(arg3);
        int i_50_ = arg0.method179(i, arg2);
        return getFont(arg0, i_50_, i);
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


    public void drawText(RSString text, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, int arg7, int arg8, int arg9) {
        // this function seems like a general draw all, mostly used for interfaces
        if(text != null) {
            int i = 0;
            int i_3_ = 0;
            RSString resultText = RSString.createString(100);
            int i_4_ = -1;
            int i_5_ = 0;
            RSString stylingTag = null;
            TextTagQueue stylingQueue = new TextTagQueue();
            if(arg9 == 0)
                arg9 = anInt2920;
            boolean bool = true;
            if(arg4 < anInt2920 + anInt2919 + arg9 && arg4 < arg9 + arg9)
                bool = false;
            int i_7_ = 0;
            int length = text.length();
            int index = -1;
            for(int idx = 0; idx < length; idx++) {
                int character = text.getChar(idx);
                if(character == 60) { // 60 = <
                    index = idx;
                } else if(character == 62 && index != -1) { // 62 == >
                    String effect = text.toString().substring(index + 1, idx);
                    int oldindex = index;
                    index = -1;
                    if(effect.equals(lessThan)) {
                        character = 60;
                    } else if(effect.equals(greaterThan)) {
                        character = 62;
                    } else if(effect.equals(nonBreakingSpace)) {
                        character = 160;
                    } else if(effect.equals(softHyphen)) {
                        character = 173;
                    } else if(effect.equals(multiplicationSymbol)) {
                        character = 215;
                    } else if(effect.equals(euroSymbol)) {
                        character = 128;
                    } else if(effect.equals(copyright)) {
                        character = 169;
                    } else {
                        if(!effect.equals(registeredTrademark)) {
                            if(effect.startsWith(image, 0)) {
                                int icon = Integer.parseInt(effect.substring(4));
                                destinationWidth += moderatorIcon[icon].maxWidth;
                            }
                            if(effect.startsWith(startColor, 0)) {
                                TextTagNode stylingNode = new TextTagNode(text.substring(oldindex, idx + 1));
                                stylingNode.applyTo(resultText);
                                stylingQueue.push(stylingNode);
                            }
                            if(effect.startsWith(endColor, 0)) {
                                stylingTag = text.substring(oldindex, idx + 1);
                                resultText.add(stylingTag);
                                stylingQueue.pop();
                                stylingTag = null;
                            }
                            continue;
                        }
                        character = 174;
                    }
                }
                if(character == 64 && idx + 4 < length && text.getChar(idx + 4) == 64) { // 64 = @
                    stylingTag = text.substring(idx, idx + 5);
                    resultText.add(stylingTag);
                    idx += 4;
                } else if(character == 92 && idx + 1 < length && text.getChar(idx + 1) == 110) { // 92 = \ 110 = n
                    stylingTag = null;
                    aClass1Array2897[i_7_++] = resultText.substring(i_3_, resultText.length()).trim();
                    i_3_ = resultText.length();
                    i = 0;
                    i_4_ = -1;
                    idx++;
                } else if(index == -1) {
                    resultText.method78(character);
                    i += method689(character);
                    if(character == 32 || character == 45) { // 32 = Space 45 == -
                        i_4_ = resultText.length();
                        i_5_ = i;
                    }
                    if(bool && i > arg3 && i_4_ >= 0) {
                        aClass1Array2897[i_7_++] = resultText.substring(i_3_, i_4_).trim();
                        i_3_ = i_4_;
                        i_4_ = -1;
                        i -= i_5_;
                        if(!stylingQueue.isEmpty() && i_3_ > 4) {
                            stylingQueue.applyAll(resultText);
                        } else if(stylingTag != null && i_3_ > 4) {
                            i_3_ -= 5;
                            resultText.prepend(stylingTag, i_3_);
                        }
                    }
                }
            }
            int strlenght = this.getStringTextWidth(resultText.toString());
            if(strlenght > i_3_)
                aClass1Array2897[i_7_++] = resultText.substring(i_3_, resultText.length()).trim();
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
                    drawShadowedString(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6);
                else if(arg7 == 1)
                    method688(aClass1Array2897[i_13_], arg1 + arg3 / 2, i_11_, arg5, arg6);
                else if(arg7 == 2)
                    method677(aClass1Array2897[i_13_], arg1 + arg3, i_11_, arg5, arg6);
                else if(i_13_ == i_7_ - 1)
                    drawShadowedString(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6);
                else
                    method680(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6, arg3);
                i_11_ += arg9;
            }
        }
    }

    public void drawCenteredStringWaveY(RSString arg0, int x, int y, int wave, int colour) {
        drawCenteredStringWaveY(arg0.toString(), x, y, wave, colour);
    }

    public void drawCenteredStringWaveXY(RSString string, int x, int y, int colour, int wave) {
        this.drawCenteredStringWaveXY(string.toString(), x, y, wave, colour);
    }

    public void method677(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        drawShadowedString(arg0, arg1 - getTextDisplayedWidth(arg0), arg2, arg3, arg4);
    }

    public void drawCenteredStringWaveXYMove(RSString string, int x, int y, int colour, int waveAmount, int waveSpeed) {
        this.drawCenteredStringWaveXYMove(string.toString(), x, y, waveAmount, waveSpeed, colour);
    }


    private void method680(RSString arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        arg0 = arg0.trim();
        int i = 0;
        for(int i_25_ = 0; i_25_ < arg0.length(); i_25_++) {
            if(arg0.getChar(i_25_) == 32)
                i++;
        }
        int i_26_ = 0;
        int i_27_ = 0;
        if(i > 0)
            i_26_ = (arg5 - getTextDisplayedWidth(arg0)) * 256 / i;
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
                            drawCharacterLegacy(characterPixels[i_31_], arg1 + 1, arg2 + characterYOffsets[i_31_] + 1, characterScreenWidths[i_31_], characterHeights[i_31_], 0);
                        drawCharacterLegacy(characterPixels[i_31_], arg1, arg2 + characterYOffsets[i_31_], characterScreenWidths[i_31_], characterHeights[i_31_], arg3);
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
                Rasterizer.drawHorizontalLine(i_28_, arg2 + (int) ((double) characterDefaultHeight * 0.7), arg1 - i_28_, 0x800000);
        }
    }

    public int getTextDisplayedWidth(RSString string) {
        return this.getDisplayedWidth(string.toString());
    }


    public void drawShadowedString(RSString string, int x, int y, int colour, boolean shadowed) {
        drawShadowedString(string.toString(), x, y, shadowed, colour);
    }

    public void drawShadowedSeededAlphaString(RSString string, int x, int y, int colour, boolean shadowed, int seed) {
        drawShadowedSeededAlphaString(string.toString(), x, y, colour, shadowed, seed);
    }

    public int getStringWidth(RSString string) {
        return this.getDisplayedWidth(string.toString());
    }

    public void drawStringLeft(RSString arg0, int arg1, int arg2, int arg3) {
        drawString(arg0, arg1 - getStringWidth(arg0) / 2, arg2, arg3);
    }

    public void method687(RSString arg0, int arg1, int arg2, int arg3) {
        drawString(arg0, arg1 - getStringWidth(arg0), arg2, arg3);
    }

    public void method688(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        drawShadowedString(arg0, arg1 - getTextDisplayedWidth(arg0) / 2, arg2, arg3, arg4);
    }

    public int method689(int arg0) {
        return characterScreenWidths[arg0 & 0xff];
    }

    public void drawString(RSString string, int x, int y, int colour) {
        this.drawString(string.toString(), x, y, colour);
        //        if(string != null) {
        //            y -= characterDefaultHeight;
        //            for(int index = 0; index < string.length; index++) {
        //                int character = string.chars[index] & 0xff;
        //                if(character != ' ')
        //                    drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character], characterScreenWidths[character], characterHeights[character], colour);
        //                x += characterScreenWidths[character];
        //            }
        //        }
    }

    /**
     * TODO: new engine
     **/


    public void drawStringRight(String string, int x, int y, int colour) {
        drawString(string, x - getDisplayedWidth(string), y, colour);
    }

    public void drawStringLeft(String string, int x, int y, int colour) {
        drawString(string, x - getDisplayedWidth(string) / 2, y, colour);
    }

    public void drawStringCenter(String string, int x, int y, int colour, boolean shadowed) {
        drawShadowedString(string, x - getStringEffectWidth(string) / 2, y, shadowed, colour);
    }

    public int getStringEffectWidth(String string) {
        return getDisplayedWidth(string);
    }

    public final int getDisplayedWidth(String string) {
        if(string == null) {
            return 0;
        }
        int index = -1;
        int width = 0;
        int length = string.length();

        for(int idx = 0; idx < length; ++idx) {
            int character = string.charAt(idx);
            if(character == 60) { // 60 = <

                index = idx;
            } else {
                if(character == 62 && index != -1) { // 62 == >
                    String effect = string.substring(index + 1, idx);
                    index = -1;
                    if(effect.equals(lessThan)) {
                        character = 60;
                    } else if(effect.equals(greaterThan)) {
                        character = 62;
                    } else if(effect.equals(nonBreakingSpace)) {
                        character = 160;
                    } else if(effect.equals(softHyphen)) {
                        character = 173;
                    } else if(effect.equals(multiplicationSymbol)) {
                        character = 215;
                    } else if(effect.equals(euroSymbol)) {
                        character = 128;
                    } else if(effect.equals(copyright)) {
                        character = 169;
                    } else {
                        if(!effect.equals(registeredTrademark)) {
                            if(effect.startsWith(image, 0)) {
                                try {
                                    int icon = Integer.parseInt(effect.substring(4));
                                    width += moderatorIcon[icon].maxWidth;
                                } catch(Exception var10) {

                                }
                            }
                            continue;
                        }

                        character = 174;
                    }
                }
                if(character == '@' && idx + 4 < string.length() && string.charAt(idx + 4) == '@') {
                    idx += 4;
                    continue;
                }

                if(index == -1) {
                    width += characterScreenWidths[character];
                }
            }
        }

        return width;

    }

    public final int getStringTextWidth(String string) {
        if(string == null) {
            return 0;
        }
        int index = -1;
        int width = 0;
        int length = string.length();

        for(int idx = 0; idx < length; ++idx) {
            int character = string.charAt(idx);
            if(character == 60) {

                index = idx;
            } else {
                if(character == 62 && index != -1) {
                    String effect = string.substring(index + 1, idx);
                    index = -1;
                    if(effect.equals(lessThan)) {
                        character = 60;
                    } else if(effect.equals(greaterThan)) {
                        character = 62;
                    } else if(effect.equals(nonBreakingSpace)) {
                        character = 160;
                    } else if(effect.equals(softHyphen)) {
                        character = 173;
                    } else if(effect.equals(multiplicationSymbol)) {
                        character = 215;
                    } else if(effect.equals(euroSymbol)) {
                        character = 128;
                    } else if(effect.equals(copyright)) {
                        character = 169;
                    } else {
                        if(!effect.equals(registeredTrademark)) {
                            if(effect.startsWith(image, 0)) {
                                try {
                                    int icon = Integer.parseInt(effect.substring(4));
                                    width += moderatorIcon[icon].maxWidth;
                                } catch(Exception var10) {

                                }
                            }
                            continue;
                        }

                        character = 174;
                    }
                }
                if(character == '@' && idx + 4 < string.length() && string.charAt(idx + 4) == '@') {
                    idx += 4;
                    continue;
                }

                if(index == -1 && character != 0) {
                    width += 1;
                }
            }
        }

        return width;

    }

    public void drawString(String string, int x, int y, int colour) {
        this.drawString(string, x, y, colour, -1);
        //        if(string == null)
        //            return;
        //        y -= characterDefaultHeight;
        //        for(int index = 0; index < string.length(); index++) {
        //            char character = string.charAt(index);
        //            if(character != ' ')
        //                drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character], characterScreenWidths[character], characterHeights[character], colour);
        //            x += characterScreenWidths[character];
        //        }


    }

    public void drawCenteredStringWaveY(String string, int x, int y, int wave, int colour) {
        if(string == null)
            return;
        x -= getDisplayedWidth(string) / 2;
        y -= characterDefaultHeight;
        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if(character != ' ')
                drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character] + (int) (Math.sin(index / 2D + wave / 5D) * 5D), characterScreenWidths[character], characterHeights[character], colour);
            x += characterScreenWidths[character];
        }

    }

    public void drawCenteredString(String text, int x, int y, int color, int shadow) {
        if(text != null) {
            setEffects(color, shadow);
            drawBasicString(text, x - getDisplayedWidth(text) / 2, y);
        }
    }

    public void drawCenteredStringWaveXY(String string, int x, int y, int wave, int colour) {
        if(string == null)
            return;
        x -= getDisplayedWidth(string) / 2;
        y -= characterDefaultHeight;
        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if(character != ' ')
                drawCharacterLegacy(characterPixels[character], x + (int) (Math.sin(index / 5D + wave / 5D) * 5D), y + characterYOffsets[character] + (int) (Math.sin(index / 3D + wave / 5D) * 5D), characterScreenWidths[character], characterHeights[character], colour);
            x += characterScreenWidths[character];
        }

    }

    public void drawCenteredStringWaveXYMove(String string, int x, int y, int waveAmount, int waveSpeed, int colour) {
        if(string == null)
            return;
        double speed = 7D - waveSpeed / 8D;
        if(speed < 0.0D)
            speed = 0.0D;
        x -= getDisplayedWidth(string) / 2;
        y -= characterDefaultHeight;
        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if(character != ' ')
                drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character] + (int) (Math.sin(index / 1.5D + waveAmount) * speed), characterScreenWidths[character], characterHeights[character], colour);
            x += characterScreenWidths[character];
        }

    }

    public void drawShadowedString(String string, int x, int y, boolean shadow, int colour) {
        if(shadow) {
            setEffects(colour, 0);
        } else {
            setEffects(colour, -1);
        }
        drawBasicString(string, x, y);
        //        if(!shadow) {
        //            drawString(string, x, y, colour);
        //            return;
        //        }
        //        strikethroughColor = -1;
        //        int originalX = x;
        //        if(string == null)
        //            return;
        //        y -= characterDefaultHeight;
        //        for(int character = 0; character < string.length(); character++)
        //        for(int character = 0; character < string.length(); character++)
        //            if(string.charAt(character) == '@' && character + 4 < string.length() && string.charAt(character + 4) == '@') {
        //                int stringColour = getColour(string.substring(character + 1, character + 4));
        //                if(stringColour != -1)
        //                    colour = stringColour;
        //                character += 4;
        //            } else {
        //                char c = string.charAt(character);
        //                if(c != ' ') {
        //                    if(shadow)
        //                        drawCharacterLegacy(characterPixels[c], x + 1, y + characterYOffsets[c] + 1, characterScreenWidths[c], characterHeights[c], 0);
        //                    drawCharacterLegacy(characterPixels[c], x, y + characterYOffsets[c], characterScreenWidths[c], characterHeights[c], colour);
        //                }
        //                x += characterScreenWidths[c];
        //            }
        //
        //        if(strikethroughColor != -1)
        //            Rasterizer.drawHorizontalLine(originalX, y + (int) (characterDefaultHeight * 0.69999999999999996D), x - originalX, strikethroughColor);
    }

    public void drawShadowedSeededAlphaString(String string, int x, int y, int colour, boolean shadowed, int seed) {
        if(string == null)
            return;
        random.setSeed(seed);
        int alpha = 192 + (random.nextInt() & 0x1f);
        if(shadowed) {
            setEffectsAlpha(colour, 0, alpha);
        } else {
            setEffectsAlpha(colour, -1, alpha);
        }
        drawBasicString(string, x, y);
        //        y -= characterDefaultHeight;
        //        for(int index = 0; index < string.length(); index++)
        //            if(string.charAt(index) == '@' && index + 4 < string.length() && string.charAt(index + 4) == '@') {
        //                int stringColour = getColour(string.substring(index + 1, index + 4));
        //                if(stringColour != -1)
        //                    colour = stringColour;
        //                index += 4;
        //            } else {
        //                char c = string.charAt(index);
        //                if(c != ' ') {
        //                    if(shadowed) {
        //                        drawAlphaCharacter(characterPixels[c], x + 1, y + characterYOffsets[c] + 1, characterScreenWidths[c], characterHeights[c], 0, 192);
        //                    }
        //                    drawAlphaCharacter(characterPixels[c], x, y + characterYOffsets[c], characterScreenWidths[c], characterHeights[c], colour, alpha);
        //                }
        //                x += characterScreenWidths[c];
        //                if((random.nextInt() & 3) == 0)
        //                    x++;
        //            }

    }


    public int getColour(String code) {
        if(code.equals("red"))
            return 0xff0000;
        if(code.equals("gre"))
            return 65280;
        if(code.equals("blu"))
            return 255;
        if(code.equals("yel"))
            return 0xffff00;
        if(code.equals("cya"))
            return 0x00ffff;
        if(code.equals("mag"))
            return 0xff00ff;
        if(code.equals("whi"))
            return 0xffffff;
        if(code.equals("bla"))
            return 0;
        if(code.equals("lre"))
            return 0xff9040;
        if(code.equals("dre"))
            return 0x800000;
        if(code.equals("dbl"))
            return 0x80;
        if(code.equals("or1"))
            return 0xffb000;
        if(code.equals("or2"))
            return 0xff7000;
        if(code.equals("or3"))
            return 0xff3000;
        if(code.equals("gr1"))
            return 0xc0ff00;
        if(code.equals("gr2"))
            return 0x80ff00;
        if(code.equals("gr3"))
            return 0x40ff00;
        if(code.equals("str"))
            strikethroughColor = 0;
        if(code.equals("end"))
            strikethroughColor = -1;
        return -1;
    }


    public void drawCharacter(int character, int x, int y, int width, int height, int colour) {
        int rasterizerPixel = x + y * Rasterizer.destinationWidth;
        int rasterizerPixelOffset = Rasterizer.destinationWidth - width;
        int characterPixelOffset = 0;
        int characterPixel = 0;
        if(y < Rasterizer.viewportTop) {
            int offsetY = Rasterizer.viewportTop - y;
            height -= offsetY;
            y = Rasterizer.viewportTop;
            characterPixel += offsetY * width;
            rasterizerPixel += offsetY * Rasterizer.destinationWidth;
        }
        if(y + height > Rasterizer.viewportBottom) {
            height -= y + height - Rasterizer.viewportBottom;
        }
        if(x < Rasterizer.viewportLeft) {
            int offsetX = Rasterizer.viewportLeft - x;
            width -= offsetX;
            x = Rasterizer.viewportLeft;
            characterPixel += offsetX;
            rasterizerPixel += offsetX;
            characterPixelOffset += offsetX;
            rasterizerPixelOffset += offsetX;
        }
        if(x + width > Rasterizer.viewportRight) {
            int endOffsetX = x + width - Rasterizer.viewportRight;
            width -= endOffsetX;
            characterPixelOffset += endOffsetX;
            rasterizerPixelOffset += endOffsetX;
        }
        if(width > 0 && height > 0) {
            drawCharacterPixels(characterPixels[character], Rasterizer.destinationPixels, characterPixel, rasterizerPixel, characterPixelOffset, rasterizerPixelOffset, width, height, colour);

        }
    }


    public void drawCharacterLegacy(byte[] pixels, int x, int y, int width, int height, int colour) {
        int rasterizerPixel = x + y * Rasterizer.destinationWidth;
        int remainingWidth = Rasterizer.destinationWidth - width;
        int characterPixelOffset = 0;
        int characterPixel = 0;
        if(y < Rasterizer.viewportTop) {
            int offsetY = Rasterizer.viewportTop - y;
            height -= offsetY;
            y = Rasterizer.viewportTop;
            characterPixel += offsetY * width;
            rasterizerPixel += offsetY * Rasterizer.destinationWidth;
        }
        if(y + height >= Rasterizer.viewportBottom)
            height -= ((y + height) - Rasterizer.viewportBottom) + 1;
        if(x < Rasterizer.viewportLeft) {
            int offsetX = Rasterizer.viewportLeft - x;
            width -= offsetX;
            x = Rasterizer.viewportLeft;
            characterPixel += offsetX;
            rasterizerPixel += offsetX;
            characterPixelOffset += offsetX;
            remainingWidth += offsetX;
        }
        if(x + width >= Rasterizer.viewportRight) {
            int endOffsetX = ((x + width) - Rasterizer.viewportRight) + 1;
            width -= endOffsetX;
            characterPixelOffset += endOffsetX;
            remainingWidth += endOffsetX;
        }
        if(width > 0 && height > 0) {
            drawCharacterPixels(pixels, Rasterizer.destinationPixels, characterPixel, rasterizerPixel, characterPixelOffset, remainingWidth, width, height, colour);
        }
    }

    public void drawCharacterPixels(byte[] characterPixels, int[] rasterizerPixels, int characterPixel, int rasterizerPixel, int characterPixelOffset, int rasterizerPixelOffset, int width, int height, int colour) {
        int negativeQuaterWidth = -(width >> 2);
        width = -(width & 3);
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

            for(int widthCounter = width; widthCounter < 0; widthCounter++)
                if(characterPixels[characterPixel++] != 0)
                    rasterizerPixels[rasterizerPixel++] = colour;
                else
                    rasterizerPixel++;

            rasterizerPixel += rasterizerPixelOffset;
            characterPixel += characterPixelOffset;
        }

    }

    public void setEffectsAlpha(int color, int shadow, int opac) {
        strikethroughColor = -1;
        underlineColor = -1;
        defaultShadowColor = shadow;
        shadowColor = shadow;
        defaultTextColor = color;
        textColor = color;
        defaultOpacity = opac;
        opacity = opac;
        whiteSpace = 0;
    }

    public void parseStringForEffects(String string) {
        try {
            if(string.startsWith(startColor)) {
                String color = string.substring(4);
                textColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
                this.textcolour.push(new TextColourNode(textColor));
            } else if(string.equals(endColor)) {
                this.textcolour.pop();
                textColor = this.textcolour.getColour();
            } else if(string.startsWith(startTrans)) {
                opacity = Integer.valueOf(string.substring(6));
            } else if(string.equals(endTrans)) {
                opacity = defaultOpacity;
            } else if(string.startsWith(startStrikethrough)) {
                String color = string.substring(4);
                strikethroughColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
            } else if(string.equals(startDefaultStrikeThrough)) {
                strikethroughColor = 8388608;
            } else if(string.equals(endStrikeThrough)) {
                strikethroughColor = -1;
            } else if(string.startsWith(startUnderline)) {
                String color = string.substring(2);
                underlineColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
            } else if(string.equals(startDefaultUnderline)) {
                underlineColor = 0;
            } else if(string.equals(endUnderline)) {
                underlineColor = -1;
            } else if(string.startsWith(startShadow)) {
                String color = string.substring(5);
                shadowColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
            } else if(string.equals(startDefaultShadow)) {
                shadowColor = 0;
            } else if(string.equals(endShadow)) {
                shadowColor = defaultShadowColor;
            } else {
                if(!string.equals(lineBreak)) {
                    return;
                }
                setEffectsAlpha(defaultTextColor, defaultShadowColor, defaultOpacity);
            }
        } catch(Exception exception) {
            return;
        }
    }

    public final void drawBasicStringXYMods(String string, int drawX, int drawY, int[] xmodifiers, int[] ymodifiers) {
        drawY -= characterDefaultHeight;
        int effect = -1;
        int var7 = 0;
        int modifier = 0;
        int length = string.length();

        for(int pos = 0; pos < length; ++pos) {
            int character = string.charAt(pos);
            if(character == 60) {
                effect = pos;
            } else {
                int xOff;
                int yOffset;
                int symbolWidth;
                if(character == 62 && effect != -1) {
                    String symbol = string.substring(pos, effect + 1);
                    effect = -1;
                    if(symbol.equals(lessThan)) {
                        character = 60;
                    } else if(symbol.equals(greaterThan)) {
                        character = 62;
                    } else if(symbol.equals(nonBreakingSpace)) {
                        character = 160;
                    } else if(symbol.equals(softHyphen)) {
                        character = 173;
                    } else if(symbol.equals(multiplicationSymbol)) {
                        character = 215;
                    } else if(symbol.equals(euroSymbol)) {
                        character = 128;
                    } else if(symbol.equals(copyright)) {
                        character = 169;
                    } else {
                        if(!symbol.equals(registeredTrademark)) {
                            if(symbol.startsWith(image, 0)) {
                                try {
                                    if(xmodifiers == null) {
                                        xOff = 0;
                                    } else {
                                        xOff = xmodifiers[modifier];
                                    }

                                    if(ymodifiers == null) {
                                        yOffset = 0;
                                    } else {
                                        yOffset = ymodifiers[modifier];
                                    }

                                    ++modifier;
                                    symbolWidth = Integer.parseInt(symbol.substring(4));
                                    IndexedImage image = moderatorIcon[symbolWidth];
                                    int imageHeight = image.maxHeight;
                                    if(opacity == 256) {
                                        image.drawImage(drawX + xOff, drawY + characterDefaultHeight - imageHeight + yOffset);
                                    } else {
                                        image.drawImageAlpha(drawX + xOff, drawY + characterDefaultHeight - imageHeight + yOffset, opacity);
                                    }

                                    drawX += image.destinationWidth;
                                    var7 = 0;
                                } catch(Exception var18) {
                                }
                            } else {
                                parseStringForEffects(symbol);
                            }
                            continue;
                        }

                        character = 174;
                    }
                }
                if(character == '@' && character + 4 < string.length() && string.charAt(character + 4) == '@') {
                    int stringColour = getColour(string.substring(character + 1, character + 4));
                    if(stringColour != -1)
                        textColor = stringColour;
                    pos += 4;
                    continue;
                }

                if(effect == -1) {
                    int cWidth = characterScreenWidths[character];
                    xOff = characterHeights[character];
                    if(xmodifiers == null) {
                        yOffset = 0;
                    } else {
                        yOffset = xmodifiers[modifier];
                    }

                    if(ymodifiers == null) {
                        symbolWidth = 0;
                    } else {
                        symbolWidth = ymodifiers[modifier];
                    }

                    ++modifier;
                    if(character != 32) {
                        if(opacity == 256) {
                            if(shadowColor != -1) {
                                drawCharacter(character, drawX + 1 + yOffset, drawY + characterYOffsets[character] + 1 + symbolWidth, cWidth, xOff, shadowColor);
                            }

                            drawCharacter(character, drawX + yOffset, drawY + characterYOffsets[character] + symbolWidth, cWidth, xOff, this.textcolour.getColour());
                        } else {
                            if(shadowColor != -1) {
                                drawCharacterAlpha(character, drawX + 1 + yOffset, drawY + characterYOffsets[character] + 1 + symbolWidth, cWidth, xOff, shadowColor, opacity);
                            }

                            drawCharacterAlpha(character, drawX + yOffset, drawY + characterYOffsets[character] + symbolWidth, cWidth, xOff, this.textcolour.getColour(), opacity);
                        }
                    }

                    int charWidth = characterScreenWidths[character];
                    if(strikethroughColor != -1) {
                        if(opacity > 255) {
                            Rasterizer.drawHorizontalLine(drawX, drawY + (int) ((double) characterDefaultHeight * 0.7D), charWidth, strikethroughColor);
                        } else {
                            Rasterizer.drawHorizontalLineAlpha(drawX, drawY + (int) ((double) characterDefaultHeight * 0.7D), charWidth, strikethroughColor, opacity);

                        }
                    }

                    if(underlineColor != -1) {
                        if(opacity > 255) {
                            Rasterizer.drawHorizontalLine(drawX, drawY + characterDefaultHeight, charWidth, underlineColor);

                        } else {

                            Rasterizer.drawHorizontalLineAlpha(drawX, drawY + characterDefaultHeight, charWidth, underlineColor, opacity);
                        }
                    }

                    drawX += charWidth;
                    var7 = character;
                }
            }
        }

    }

    public void drawString(String string, int x, int y, int color, int shadow) {
        if(string != null) {
            setEffects(color, shadow);
            drawBasicString(string, x, y);
        }
    }


    public void drawStringAlignedLeft(String string, int x, int y, int color, int shadow) {
        if(string != null) {
            setEffects(color, shadow);
            drawBasicString(string, x - getDisplayedWidth(string), y);
        }
    }

    public void drawStringWave(String string, int x, int y, int color, int shadow, int var6) {
        if(string != null) {
            setEffects(color, shadow);
            int length = string.length();
            int[] var8 = new int[length];
            int[] var9 = new int[length];

            for(int pos = 0; pos < length; ++pos) {
                var8[pos] = (int) (Math.sin((double) pos / 5.0D + (double) var6 / 5.0D) * 5.0D);
                var9[pos] = (int) (Math.sin((double) pos / 3.0D + (double) var6 / 5.0D) * 5.0D);
            }

            drawBasicStringXYMods(string, x - getDisplayedWidth(string) / 2, y, var8, var9);
        }
    }

    public void drawStringWaveY(String string, int x, int y, int color, int shadow, int tick) {
        if(string != null) {
            setEffects(color, shadow);
            int var7 = string.length();
            int[] vertWaveOffset = new int[var7];

            for(int whichChar = 0; whichChar < var7; ++whichChar) {
                vertWaveOffset[whichChar] = (int) (Math.sin((double) whichChar / 2.0D + (double) tick / 5.0D) * 5.0D);
            }

            drawBasicStringXYMods(string, x - getDisplayedWidth(string) / 2, y, (int[]) null, vertWaveOffset);
        }
    }


    public void drawCenteredStringXMod(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if(var1 != null) {
            setEffects(var4, var5);
            double amplitude = 7.0D - (double) var7 / 8.0D;
            if(amplitude < 0.0D) {
                amplitude = 0.0D;
            }

            int length = var1.length();
            int[] xmod = new int[length];

            for(int pos = 0; pos < length; ++pos) {
                xmod[pos] = (int) (Math.sin((double) pos / 1.5D + (double) var6 / 1.0D) * amplitude);
            }

            drawBasicStringXYMods(var1, var2 - getDisplayedWidth(var1) / 2, var3, (int[]) null, xmod);
        }
    }


    public void setEffects(int color, int shadow) {
        strikethroughColor = -1;
        underlineColor = -1;
        defaultShadowColor = shadow;
        shadowColor = shadow;
        defaultTextColor = color;
        textColor = color;
        defaultOpacity = 256;
        opacity = 256;
        whiteSpace = 0;
    }

    public void drawBasicString(String string, int x, int y) {
        y -= characterDefaultHeight;
        int effectIndex = -1;
        int var5 = 0;
        int textLength = string.length();
        this.textcolour = new TextColourQueue(defaultTextColor);

        for(int character = 0; character < textLength; ++character) {
            int c = string.charAt(character);
            if(c > 255) {
                c = 32;
            }
            if(c == 60) {
                effectIndex = character;

            } else {
                if(c == 62 && effectIndex != -1) {

                    String effectString = string.substring(effectIndex + 1, character);
                    effectIndex = -1;
                    if(effectString.equals(lessThan)) {
                        c = 60;
                    } else if(effectString.equals(greaterThan)) {
                        c = 62;
                    } else if(effectString.equals(nonBreakingSpace)) {
                        c = 160;
                    } else if(effectString.equals(softHyphen)) {
                        c = 173;
                    } else if(effectString.equals(multiplicationSymbol)) {
                        c = 215;
                    } else if(effectString.equals(euroSymbol)) {
                        c = 128;
                    } else if(effectString.equals(copyright)) {
                        c = 169;
                    } else {
                        if(!effectString.equals(registeredTrademark)) {
                            if(effectString.startsWith(image, 0)) {
                                try {
                                    int icon = Integer.valueOf(effectString.substring(4));
                                    IndexedImage nameIcon = moderatorIcon[icon];
                                    int imageHeight = nameIcon.maxHeight;
                                    if(opacity == 256) {
                                        nameIcon.drawImage(x, y + characterDefaultHeight - imageHeight);
                                    } else {
                                        nameIcon.drawImageAlpha(x, y + characterDefaultHeight - imageHeight, opacity);
                                    }

                                    x += nameIcon.maxWidth;
                                    var5 = 0;
                                } catch(Exception e) {

                                }
                            } else {
                                parseStringForEffects(effectString);
                            }
                            continue;
                        }
                        c = 174;
                    }
                }
                if(c == '@' && character + 4 < string.length() && string.charAt(character + 4) == '@') {
                    int stringColour = getColour(string.substring(character + 1, character + 4));
                    if(stringColour != -1) {
                        textColor = stringColour;
                        this.textcolour.push(new TextColourNode(textColor));
                    }
                    character += 4;
                    continue;
                }
                if(effectIndex == -1) {
                    int width = characterScreenWidths[c];
                    int height = characterHeights[c];
                    if(c != 32) {
                        if(opacity == 256) {

                            if(shadowColor != -1) {
                                drawCharacter(c, x + 1, y + characterYOffsets[c] + 1, width, height, shadowColor);
                            }

                            drawCharacter(c, x, y + characterYOffsets[c], width, height, this.textcolour.getColour());
                        } else {

                            if(shadowColor != -1) {
                                drawCharacterAlpha(c, x + 1, y + characterYOffsets[c] + 1, width, height, shadowColor, opacity);

                            }
                            drawCharacterAlpha(c, x, y + characterYOffsets[c], width, height, this.textcolour.getColour(), opacity);
                        }
                    }

                    int charWidth = characterScreenWidths[c];
                    if(strikethroughColor != -1) {
                        Rasterizer.drawHorizontalLine(x, y + (int) ((double) characterDefaultHeight * 0.7D), charWidth, strikethroughColor);
                    }
                    if(underlineColor != -1) {
                        Rasterizer.drawHorizontalLine(x, y + characterDefaultHeight + 1, charWidth, underlineColor);
                    }
                    x += charWidth;
                    var5 = c;
                }
            }
        }

    }

    public void drawCharacterAlpha(int character, int x, int y, int width, int height, int colour, int alpha) {
        this.drawAlphaCharacter(characterPixels[character], x, y, width, height, colour, alpha);
    }

    public void drawAlphaCharacter(byte[] characterPixels, int x, int y, int width, int height, int colour, int alpha) {
        int rasterizerPixel = x + y * Rasterizer.destinationWidth;
        int rasterizerPixelOffset = Rasterizer.destinationWidth - width;
        int characterPixelOffset = 0;
        int characterPixel = 0;
        if(y < Rasterizer.viewportTop) {
            int yOffset = Rasterizer.viewportTop - y;
            height -= yOffset;
            y = Rasterizer.viewportTop;
            characterPixel += yOffset * width;
            rasterizerPixel += yOffset * Rasterizer.destinationWidth;
        }
        if(y + height >= Rasterizer.viewportBottom)
            height -= ((y + height) - Rasterizer.viewportBottom) + 1;
        if(x < Rasterizer.viewportLeft) {
            int xOffset = Rasterizer.viewportLeft - x;
            width -= xOffset;
            x = Rasterizer.viewportLeft;
            characterPixel += xOffset;
            rasterizerPixel += xOffset;
            characterPixelOffset += xOffset;
            rasterizerPixelOffset += xOffset;
        }
        if(x + width >= Rasterizer.viewportRight) {
            int widthoffset = ((x + width) - Rasterizer.viewportRight) + 1;
            width -= widthoffset;
            characterPixelOffset += widthoffset;
            rasterizerPixelOffset += widthoffset;
        }
        if(width > 0 && height > 0) {
            drawCharacterPixelsAlpha(characterPixel, rasterizerPixelOffset, characterPixelOffset, rasterizerPixel, alpha, Rasterizer.destinationPixels, colour, height, width, characterPixels);
        }
    }


    public void drawCharacterPixelsAlpha(int characterPixel, int rasterizerPixelOffset, int characterPixelOffset, int rasterizerPixel, int alpha, int[] rasterizerPixels, int colour, int height, int width, byte[] characterPixels) {
        colour = ((colour & 0xff00ff) * alpha & 0xff00ff00) + ((colour & 0xff00) * alpha & 0xff0000) >> 8;
        alpha = 256 - alpha;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++)
                if(characterPixels[characterPixel++] == 0) {
                    rasterizerPixel++;
                } else {
                    int rasterizerPixelColor = rasterizerPixels[rasterizerPixel];
                    rasterizerPixels[rasterizerPixel++] = (((rasterizerPixelColor & 0xff00ff) * alpha & 0xff00ff00) + ((rasterizerPixelColor & 0xff00) * alpha & 0xff0000) >> 8) + colour;
                }

            rasterizerPixel += rasterizerPixelOffset;
            characterPixel += characterPixelOffset;
        }

    }


}
