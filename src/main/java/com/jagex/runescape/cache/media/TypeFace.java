package com.jagex.runescape.cache.media;

import com.jagex.runescape.Class17;
import com.jagex.runescape.RSString;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.textUtils.TextColourNode;
import com.jagex.runescape.cache.media.textUtils.TextColourQueue;
import com.jagex.runescape.cache.media.textUtils.TextTagNode;
import com.jagex.runescape.cache.media.textUtils.TextTagQueue;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.scene.GroundItemTile;

import java.awt.*;
import java.util.Random;

import static com.jagex.runescape.Class40_Sub5_Sub13.moderatorIcon;

public class TypeFace extends Rasterizer {

    public static TypeFace fontBold;
    public static TypeFace fontSmall;
    public static NodeCache typeFaceCache = new NodeCache(20);
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
    private static String italicsStart = "i";
    private static String italicsEnd = "/i";
    private static String registeredTrademark = "reg";
    private static int strikethroughColor = -1;
    private static boolean italics = false;
    private static int underlineColor = -1;
    private static int defaultTextColor = 0;
    private static int opacity = 256;
    private static int defaultOpacity = 256;
    private static int defaultShadowColor = -1;
    private static int shadowColor = -1;
    private static int textColor = 0xff00ff;
    private static int whiteSpace = 0;

    private String[] aClass1Array2897 = new String[100];
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
            if(arg3[i_47_] == 1) {
                i = (byte) i_47_;
            }
        }
        characterPixels = arg4;
        int i_48_ = Integer.MAX_VALUE;
        int i_49_ = Integer.MIN_VALUE;
        for(int i_50_ = 0; i_50_ < 256; i_50_++) {
            if(characterYOffsets[i_50_] < i_48_) {
                i_48_ = characterYOffsets[i_50_];
            }
            if(characterYOffsets[i_50_] + characterHeights[i_50_] > i_49_) {
                i_49_ = characterYOffsets[i_50_] + characterHeights[i_50_];
            }
            byte[] is = characterPixels[i_50_];
            int i_51_ = is.length;
            for(int i_52_ = 0; i_52_ < i_51_; i_52_++) {
                is[i_52_] = is[i_52_] == i ? (byte) 0 : (byte) 1;
            }
        }
        characterDefaultHeight = characterYOffsets[32] + characterHeights[32];
        anInt2920 = characterDefaultHeight - i_48_;
        anInt2919 = i_49_ - characterDefaultHeight;
    }

    public static TypeFace constructFont() {
        TypeFace class40_sub5_sub14_sub1 = new TypeFace(Actor.anIntArray3111, Class17.anIntArray456, Npc.anIntArray3312,
                Buffer.anIntArray1972, GroundItemTile.aByteArrayArray1370
        );
        ActorDefinition.method569();
        return class40_sub5_sub14_sub1;
    }

    public static TypeFace getFont(CacheArchive cacheArchive, int arg0, int fontId) {
        if(!ImageRGB.spriteExists(arg0, fontId, cacheArchive)) {
            return null;
        }
        return constructFont();
    }

    public static TypeFace loadTypeFace(CacheArchive arg0, String arg2, String arg3) {
        int i = arg0.getHash(arg3);
        int i_50_ = arg0.method179(i, arg2);
        return getFont(arg0, i_50_, i);
    }


    public void drawText(
            String text, int x, int arg2, int arg3, int arg4, int colour, boolean shadow, int xAlignment,
            int yAlignment, int arg9
    ) {
        // this function seems like a general draw all, mostly used for interfaces
        if(text != null) {
            int i = 0;
            int i_3_ = 0;
            String resultText = "";
            int i_4_ = -1;
            int i_5_ = 0;
            String stylingTag = null;
            String fontStyleTag = null;
            TextTagQueue stylingQueue = new TextTagQueue();
            TextTagQueue fontStyle = new TextTagQueue();
            if(arg9 == 0) {
                arg9 = anInt2920;
            }
            boolean bool = true;
            if(arg4 < anInt2920 + anInt2919 + arg9 && arg4 < arg9 + arg9) {
                bool = false;
            }
            int i_7_ = 0;
            int length = text.length();
            int index = -1;
            for(int idx = 0; idx < length; idx++) {
                int character = text.charAt(idx);
                if(character == '\\' && !this.isIgnored(idx, text)) {
                    continue;
                }
                if(character == 60 && !this.isIgnored(idx, text)) { // 60 = <
                    index = idx;
                } else if(character == 62 && index != -1) { // 62 == >
                    String effect = text.substring(index + 1, idx);
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
                                //                                resultText = stylingNode.applyTo(resultText);
                                resultText = resultText + stylingNode.tag;

                                stylingQueue.push(stylingNode);
                            }
                            if(effect.startsWith(endColor, 0)) {
                                stylingTag = text.substring(oldindex, idx + 1);
                                //                                resultText.add(stylingTag);
                                //                                resultText = stylingTag + resultText;
                                resultText = resultText + stylingTag;

                                stylingQueue.pop();
                                stylingTag = null;
                            }
                            if(effect.startsWith(italicsStart, 0)) {
                                TextTagNode stylingNode = new TextTagNode(text.substring(oldindex, idx + 1));
                                resultText = resultText + stylingNode.tag;
                                fontStyle.push(stylingNode);
                            }
                            if(effect.startsWith(startStrikethrough, 0)) {
                                TextTagNode stylingNode = new TextTagNode(text.substring(oldindex, idx + 1));
                                resultText = resultText + stylingNode.tag;
                                fontStyle.push(stylingNode);
                            }
                            if(effect.startsWith(startDefaultStrikeThrough, 0)) {
                                TextTagNode stylingNode = new TextTagNode(text.substring(oldindex, idx + 1));
                                resultText = resultText + stylingNode.tag;
                                fontStyle.push(stylingNode);
                            }
                            if(effect.startsWith(italicsEnd, 0)) {
                                fontStyleTag = text.substring(oldindex, idx + 1);
                                //                                resultText.add(stylingTag);
                                //                                resultText = stylingTag + resultText;
                                resultText = resultText + fontStyleTag;

                                fontStyle.pop();
                                fontStyleTag = null;
                            }
                            if(effect.startsWith(endStrikeThrough, 0)) {
                                fontStyleTag = text.substring(oldindex, idx + 1);
                                //                                resultText.add(stylingTag);
                                //                                resultText = stylingTag + resultText;
                                resultText = resultText + fontStyleTag;

                                fontStyle.pop();
                                fontStyleTag = null;
                            }
                            continue;
                        }
                        character = 174;

                    }
                }
                if(character == 64 && idx + 4 < length && text.charAt(idx + 4) == 64) { // 64 = @
                    stylingTag = text.substring(idx, idx + 5);
                    //                    resultText.add(stylingTag);
                    resultText = resultText + stylingTag;
                    idx += 4;
                } else if(character == 92 && idx + 1 < length && text.charAt(idx + 1) == 110) { // 92 = \ 110 = n
                    stylingTag = null;
                    fontStyleTag = null;
                    aClass1Array2897[i_7_++] = resultText.substring(i_3_).trim();
                    i_3_ = resultText.length();
                    i = 0;
                    i_4_ = -1;
                    idx++;
                } else if(index == -1) {
                    resultText = resultText + (char) character;
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
                        if(!stylingQueue.isEmpty() && i_3_ > 4 && !fontStyle.isEmpty()) {
                            resultText = stylingQueue.applyAll(resultText);
                            resultText = fontStyle.applyAll(resultText);
                        } else if(stylingTag != null && i_3_ > 4) {
                            i_3_ -= 5;
                            //                            resultText = stylingTag + resultText;
                            RSString.prepend(resultText, stylingTag, i_3_);
                            //                            resultText.prepend(stylingTag, i_3_);
                        }
                    }
                }
            }
            int strlenght = this.getStringTextWidth(resultText);

            if(strlenght > i_3_) {
                aClass1Array2897[i_7_++] = resultText.substring(i_3_, resultText.length()).trim();
            }
            if(yAlignment == 3 && i_7_ == 1) {
                yAlignment = 1;
            }
            int y;
            if(yAlignment == 0) {
                y = arg2 + anInt2920;
            } else if(yAlignment == 1) {
                y = arg2 + anInt2920 + (arg4 - anInt2920 - anInt2919 - (i_7_ - 1) * arg9) / 2;
            } else if(yAlignment == 2) {
                y = arg2 + arg4 - anInt2919 - (i_7_ - 1) * arg9;
            } else {
                int i_12_ = (arg4 - anInt2920 - anInt2919 - (i_7_ - 1) * arg9) / (i_7_ + 1);
                if(i_12_ < 0) {
                    i_12_ = 0;
                }
                y = arg2 + anInt2920 + i_12_;
                arg9 += i_12_;
            }
            for(int i_13_ = 0; i_13_ < i_7_; i_13_++) {
                if(xAlignment == 0) {
                    drawShadowedString(aClass1Array2897[i_13_], x, y, shadow, colour);
                } else if(xAlignment == 1) {
                    drawShadowedStringCenter(aClass1Array2897[i_13_], x + arg3 / 2, y, colour, shadow);
                } else if(xAlignment == 2) {
                    drawShadowedStringRight(aClass1Array2897[i_13_], x + arg3, y, colour, shadow);
                } else if(i_13_ == i_7_ - 1) {
                    drawShadowedString(aClass1Array2897[i_13_], x, y, shadow, colour);
                } else {
                    System.out.println("Using Weird print");
                    //                    method680(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6, arg3);
                }
                y += arg9;
            }
        }
    }

    public void drawText(
            RSString text, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, int arg7, int arg8, int arg9
    ) {
        drawText(text.toString(), arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }


    public void drawShadowedStringRight(String arg0, int arg1, int arg2, int arg3, boolean arg4) {
        drawShadowedString(arg0, arg1 - getTextDisplayedWidth(arg0), arg2, arg4, arg3);
    }


    public int getTextDisplayedWidth(RSString string) {
        return this.getStringWidth(string.toString());
    }

    public int getTextDisplayedWidth(String string) {
        return this.getStringWidth(string);
    }


    public void drawShadowedString(RSString string, int x, int y, boolean shadowed, int colour) {
        drawShadowedString(string.toString(), x, y, shadowed, colour);
    }


    public int getStringWidth(RSString string) {
        return this.getStringWidth(string.toString());
    }

    public void drawShadowedStringCenter(String str, int drawX, int drawY, int colour, boolean shadowed) {
        drawShadowedString(str, drawX - getStringWidth(str) / 2, drawY, shadowed, colour);
    }

    public int method689(int arg0) {
        return characterScreenWidths[arg0 & 0xff];
    }

    public void drawString(RSString string, int x, int y, int colour) {
        this.drawString(string.toString(), x, y, colour);
    }


    public void drawStringRight(String string, int x, int y, int colour) {
        drawString(string, x - getStringWidth(string), y, colour);
    }

    public void drawStringLeft(String string, int x, int y, int colour) {
        drawString(string, x - getStringWidth(string) / 2, y, colour);
    }


    public int getStringEffectWidth(String string) {
        return getStringWidth(string);
    }

    public final int getStringWidth(String string) {
        if(string == null) {
            return 0;
        }


        int index = -1;
        int width = 0;
        int length = string.length();

        for(int idx = 0; idx < length; ++idx) {
            int character = string.charAt(idx);
            if(character == '\\' && !this.isIgnored(idx, string)) {
                continue;
            }
            if(character == 60 && !this.isIgnored(idx, string)) { // 60 = <
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
            if(character == '\\' && !this.isIgnored(idx, string)) {
                continue;
            }
            if(character == 60 && !this.isIgnored(idx, string)) {
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
    }

    public void drawCenteredStringWaveY(String string, int x, int y, int wave, int colour) {
        if(string == null) {
            return;
        }
        x -= getStringWidth(string) / 2;
        y -= characterDefaultHeight;
        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if(character != ' ') {
                drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character] + (int) (Math.sin(
                        index / 2D + wave / 5D) * 5D), characterScreenWidths[character], characterHeights[character],
                        colour
                );
            }
            x += characterScreenWidths[character];
        }

    }

    public void drawCenteredString(String text, int x, int y, int color, int shadow) {
        if(text != null) {
            setEffects(color, shadow);
            drawBasicString(text, x - getStringWidth(text) / 2, y);
        }
    }

    public void drawCenteredStringWaveXY(String string, int x, int y, int wave, int colour) {
        if(string == null) {
            return;
        }
        x -= getStringWidth(string) / 2;
        y -= characterDefaultHeight;
        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if(character != ' ') {
                drawCharacterLegacy(characterPixels[character], x + (int) (Math.sin(index / 5D + wave / 5D) * 5D),
                        y + characterYOffsets[character] + (int) (Math.sin(index / 3D + wave / 5D) * 5D),
                        characterScreenWidths[character], characterHeights[character], colour
                );
            }
            x += characterScreenWidths[character];
        }

    }

    public void drawCenteredStringWaveXYMove(String string, int x, int y, int waveAmount, int waveSpeed, int colour) {
        if(string == null) {
            return;
        }
        double speed = 7D - waveSpeed / 8D;
        if(speed < 0.0D) {
            speed = 0.0D;
        }
        x -= getStringWidth(string) / 2;
        y -= characterDefaultHeight;
        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if(character != ' ') {
                drawCharacterLegacy(characterPixels[character], x, y + characterYOffsets[character] + (int) (Math.sin(
                        index / 1.5D + waveAmount) * speed), characterScreenWidths[character],
                        characterHeights[character], colour
                );
            }
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
    }

    public void drawShadowedSeededAlphaString(String string, int x, int y, int colour, boolean shadowed, int seed) {
        if(string == null) {
            return;
        }
        random.setSeed(seed);
        int alpha = 192 + (random.nextInt() & 0x1f);
        if(shadowed) {
            setEffectsAlpha(colour, 0, alpha);
        } else {
            setEffectsAlpha(colour, -1, alpha);
        }
        drawBasicString(string, x, y);
    }


    public int getColour(String code) {
        if(code.equals("red")) {
            return 0xff0000;
        }
        if(code.equals("gre")) {
            return 65280;
        }
        if(code.equals("blu")) {
            return 255;
        }
        if(code.equals("yel")) {
            return 0xffff00;
        }
        if(code.equals("cya")) {
            return 0x00ffff;
        }
        if(code.equals("mag")) {
            return 0xff00ff;
        }
        if(code.equals("whi")) {
            return 0xffffff;
        }
        if(code.equals("bla")) {
            return 0;
        }
        if(code.equals("lre")) {
            return 0xff9040;
        }
        if(code.equals("dre")) {
            return 0x800000;
        }
        if(code.equals("dbl")) {
            return 0x80;
        }
        if(code.equals("or1")) {
            return 0xffb000;
        }
        if(code.equals("or2")) {
            return 0xff7000;
        }
        if(code.equals("or3")) {
            return 0xff3000;
        }
        if(code.equals("gr1")) {
            return 0xc0ff00;
        }
        if(code.equals("gr2")) {
            return 0x80ff00;
        }
        if(code.equals("gr3")) {
            return 0x40ff00;
        }
        if(code.equals("str")) {
            strikethroughColor = 0;
        }
        if(code.equals("end")) {
            strikethroughColor = -1;
        }
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
            drawCharacterPixels(characterPixels[character], Rasterizer.destinationPixels, characterPixel,
                    rasterizerPixel, characterPixelOffset, rasterizerPixelOffset, width, height, colour
            );

        }
    }

    public void drawCharacterItalics(int character, int x, int y, int width, int height, int colour) {
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
            drawCharacterPixelsItalic(characterPixels[character], Rasterizer.destinationPixels, characterPixel,
                    rasterizerPixel, characterPixelOffset, rasterizerPixelOffset, width, height, colour
            );
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
        if(y + height >= Rasterizer.viewportBottom) {
            height -= y + height - Rasterizer.viewportBottom + 1;
        }
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
            int endOffsetX = x + width - Rasterizer.viewportRight + 1;
            width -= endOffsetX;
            characterPixelOffset += endOffsetX;
            remainingWidth += endOffsetX;
        }
        if(width > 0 && height > 0) {
            drawCharacterPixels(pixels, Rasterizer.destinationPixels, characterPixel, rasterizerPixel,
                    characterPixelOffset, remainingWidth, width, height, colour
            );
        }
    }


    public void drawCharacterPixelsItalic(
            byte[] characterPixels, int[] rasterizerPixels, int characterPixel, int rasterizerPixel,
            int characterPixelOffset, int rasterizerPixelOffset, int width, int height, int colour
    ) {
        int shouldItalic = 0;

        int negativeQuaterWidth = -(width >> 2);
        width = -(width & 3);
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = negativeQuaterWidth; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }

            }

            for(int widthCounter = width; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
            }
            shouldItalic++;

            if(shouldItalic > 3) {

                rasterizerPixel += rasterizerPixelOffset - 1;
                shouldItalic = 0;
            } else {
                rasterizerPixel += rasterizerPixelOffset;

            }
            characterPixel += characterPixelOffset;
        }

    }

    public void drawCharacterPixels(
            byte[] characterPixels, int[] rasterizerPixels, int characterPixel, int rasterizerPixel,
            int characterPixelOffset, int rasterizerPixelOffset, int width, int height, int colour
    ) {
        int negativeQuaterWidth = -(width >> 2);
        width = -(width & 3);
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = negativeQuaterWidth; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
            }

            for(int widthCounter = width; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] != 0) {
                    rasterizerPixels[rasterizerPixel++] = colour;
                } else {
                    rasterizerPixel++;
                }
            }

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
            } else if(string.startsWith(italicsStart)) {
                italics = true;
            } else if(string.startsWith(italicsEnd)) {
                italics = false;
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
            if(character == '\\' && !this.isIgnored(pos, string)) {
                continue;
            }
            if(character == 60 && !this.isIgnored(pos, string)) {

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
                                        image.drawImage(
                                                drawX + xOff, drawY + characterDefaultHeight - imageHeight + yOffset);
                                    } else {
                                        image.drawImageAlpha(drawX + xOff,
                                                drawY + characterDefaultHeight - imageHeight + yOffset, opacity
                                        );
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
                    if(stringColour != -1) {
                        textColor = stringColour;
                    }
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
                                drawCharacter(character, drawX + 1 + yOffset,
                                        drawY + characterYOffsets[character] + 1 + symbolWidth, cWidth, xOff,
                                        shadowColor
                                );
                            }

                            drawCharacter(character, drawX + yOffset,
                                    drawY + characterYOffsets[character] + symbolWidth, cWidth, xOff,
                                    this.textcolour.getColour()
                            );
                        } else {
                            if(shadowColor != -1) {
                                drawCharacterAlpha(character, drawX + 1 + yOffset,
                                        drawY + characterYOffsets[character] + 1 + symbolWidth, cWidth, xOff,
                                        shadowColor, opacity
                                );
                            }

                            drawCharacterAlpha(character, drawX + yOffset,
                                    drawY + characterYOffsets[character] + symbolWidth, cWidth, xOff,
                                    this.textcolour.getColour(), opacity
                            );
                        }
                    }

                    int charWidth = characterScreenWidths[character];
                    if(strikethroughColor != -1) {
                        if(opacity > 255) {
                            Rasterizer.drawHorizontalLine(drawX, drawY + (int) ((double) characterDefaultHeight * 0.7D),
                                    charWidth, strikethroughColor
                            );
                        } else {
                            Rasterizer.drawHorizontalLineAlpha(drawX,
                                    drawY + (int) ((double) characterDefaultHeight * 0.7D), charWidth,
                                    strikethroughColor, opacity
                            );

                        }
                    }

                    if(underlineColor != -1) {
                        if(opacity > 255) {
                            Rasterizer.drawHorizontalLine(
                                    drawX, drawY + characterDefaultHeight, charWidth, underlineColor);

                        } else {

                            Rasterizer.drawHorizontalLineAlpha(
                                    drawX, drawY + characterDefaultHeight, charWidth, underlineColor, opacity);
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
            drawBasicString(string, x - getStringWidth(string), y);
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

            drawBasicStringXYMods(string, x - getStringWidth(string) / 2, y, var8, var9);
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

            drawBasicStringXYMods(string, x - getStringWidth(string) / 2, y, (int[]) null, vertWaveOffset);
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

            drawBasicStringXYMods(var1, var2 - getStringWidth(var1) / 2, var3, (int[]) null, xmod);
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
            if(c == '\\' && !this.isIgnored(character, string)) {
                continue;
            }
            if(c == 60 && !this.isIgnored(character, string)) {
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
                                if(italics) {
                                    drawCharacterItalics(
                                            c, x + 1, y + characterYOffsets[c] + 1, width, height, shadowColor);
                                } else {
                                    drawCharacter(c, x + 1, y + characterYOffsets[c] + 1, width, height, shadowColor);
                                }
                            }
                            if(italics) {
                                drawCharacterItalics(
                                        c, x, y + characterYOffsets[c], width, height, this.textcolour.getColour());
                            } else {
                                drawCharacter(
                                        c, x, y + characterYOffsets[c], width, height, this.textcolour.getColour());
                            }
                        } else {

                            if(shadowColor != -1) {
                                if(italics) {
                                    drawCharacterAlphaItalics(c, x + 1, y + characterYOffsets[c] + 1, width, height,
                                            shadowColor, opacity
                                    );
                                } else {
                                    drawCharacterAlpha(c, x + 1, y + characterYOffsets[c] + 1, width, height,
                                            shadowColor, opacity
                                    );
                                }
                            }
                            if(italics) {
                                drawCharacterAlphaItalics(c, x, y + characterYOffsets[c], width, height,
                                        this.textcolour.getColour(), opacity
                                );
                            } else {
                                drawCharacterAlpha(c, x, y + characterYOffsets[c], width, height,
                                        this.textcolour.getColour(), opacity
                                );
                            }
                        }
                    }

                    int charWidth = characterScreenWidths[c];
                    if(strikethroughColor != -1) {
                        Rasterizer.drawHorizontalLine(
                                x, y + (int) ((double) characterDefaultHeight * 0.7D), charWidth, strikethroughColor);
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

    private boolean isIgnored(int index, String text) {
        boolean isTag = false;
        boolean isNextTag = false;
        if(index < text.length()) {
            if(text.charAt(index) == '<') {
                isTag = true;
            }
        }
        if(index < text.length() - 1) {
            if(text.charAt(index + 1) == '<') {
                isNextTag = true;
            }
        }
        if(index > 0) {
            if(text.charAt(index - 1) == '\\') {
                return isTag;
            }
        }
        if(isNextTag) {
            return false;
        }
        return !isTag;

    }


    public void drawBasicStringLegacy(String string, int x, int y) {
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


            if(c == '@' && character + 4 < string.length() && string.charAt(character + 4) == '@') {
                int stringColour = getColour(string.substring(character + 1, character + 4));
                if(stringColour != -1) {
                    textColor = stringColour;
                    this.textcolour.push(new TextColourNode(textColor));
                }
                character += 4;
                continue;
            }
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
                    drawCharacterAlpha(
                            c, x, y + characterYOffsets[c], width, height, this.textcolour.getColour(), opacity);
                }
            }

            int charWidth = characterScreenWidths[c];
            if(strikethroughColor != -1) {
                Rasterizer.drawHorizontalLine(
                        x, y + (int) ((double) characterDefaultHeight * 0.7D), charWidth, strikethroughColor);
            }
            if(underlineColor != -1) {
                Rasterizer.drawHorizontalLine(x, y + characterDefaultHeight + 1, charWidth, underlineColor);
            }
            x += charWidth;
            var5 = c;


        }

    }

    public void drawCharacterAlpha(int character, int x, int y, int width, int height, int colour, int alpha) {
        this.drawAlphaCharacter(characterPixels[character], x, y, width, height, colour, alpha);
    }

    public void drawCharacterAlphaItalics(int character, int x, int y, int width, int height, int colour, int alpha) {
        this.drawAlphaCharacterItalics(characterPixels[character], x, y, width, height, colour, alpha);
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
        if(y + height >= Rasterizer.viewportBottom) {
            height -= y + height - Rasterizer.viewportBottom + 1;
        }
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
            int widthoffset = x + width - Rasterizer.viewportRight + 1;
            width -= widthoffset;
            characterPixelOffset += widthoffset;
            rasterizerPixelOffset += widthoffset;
        }
        if(width > 0 && height > 0) {
            drawCharacterPixelsAlpha(characterPixel, rasterizerPixelOffset, characterPixelOffset, rasterizerPixel,
                    alpha, Rasterizer.destinationPixels, colour, height, width, characterPixels
            );
        }
    }

    public void drawAlphaCharacterItalics(
            byte[] characterPixels, int x, int y, int width, int height, int colour, int alpha
    ) {
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
        if(y + height >= Rasterizer.viewportBottom) {
            height -= y + height - Rasterizer.viewportBottom + 1;
        }
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
            int widthoffset = x + width - Rasterizer.viewportRight + 1;
            width -= widthoffset;
            characterPixelOffset += widthoffset;
            rasterizerPixelOffset += widthoffset;
        }
        if(width > 0 && height > 0) {
            drawCharacterPixelsAlphaItalics(characterPixel, rasterizerPixelOffset, characterPixelOffset,
                    rasterizerPixel, alpha, Rasterizer.destinationPixels, colour, height, width, characterPixels
            );
        }
    }


    public void drawCharacterPixelsAlpha(
            int characterPixel, int rasterizerPixelOffset, int characterPixelOffset, int rasterizerPixel, int alpha,
            int[] rasterizerPixels, int colour, int height, int width, byte[] characterPixels
    ) {
        colour = ((colour & 0xff00ff) * alpha & 0xff00ff00) + ((colour & 0xff00) * alpha & 0xff0000) >> 8;
        alpha = 256 - alpha;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] == 0) {
                    rasterizerPixel++;
                } else {
                    int rasterizerPixelColor = rasterizerPixels[rasterizerPixel];
                    rasterizerPixels[rasterizerPixel++] = (((rasterizerPixelColor & 0xff00ff) * alpha & 0xff00ff00) +
                            ((rasterizerPixelColor & 0xff00) * alpha & 0xff0000) >> 8) + colour;
                }
            }

            rasterizerPixel += rasterizerPixelOffset;
            characterPixel += characterPixelOffset;
        }

    }

    public void drawCharacterPixelsAlphaItalics(
            int characterPixel, int rasterizerPixelOffset, int characterPixelOffset, int rasterizerPixel, int alpha,
            int[] rasterizerPixels, int colour, int height, int width, byte[] characterPixels
    ) {
        int shouldItalic = 0;
        colour = ((colour & 0xff00ff) * alpha & 0xff00ff00) + ((colour & 0xff00) * alpha & 0xff0000) >> 8;
        alpha = 256 - alpha;
        for(int heightCounter = -height; heightCounter < 0; heightCounter++) {
            for(int widthCounter = -width; widthCounter < 0; widthCounter++) {
                if(characterPixels[characterPixel++] == 0) {
                    rasterizerPixel++;
                } else {
                    int rasterizerPixelColor = rasterizerPixels[rasterizerPixel];
                    rasterizerPixels[rasterizerPixel++] = (((rasterizerPixelColor & 0xff00ff) * alpha & 0xff00ff00) +
                            ((rasterizerPixelColor & 0xff00) * alpha & 0xff0000) >> 8) + colour;
                }
            }

            shouldItalic++;

            if(shouldItalic > 3) {
                rasterizerPixel += rasterizerPixelOffset - 1;
                shouldItalic = 0;
            } else {
                rasterizerPixel += rasterizerPixelOffset;

            }
            characterPixel += characterPixelOffset;
        }

    }


}
