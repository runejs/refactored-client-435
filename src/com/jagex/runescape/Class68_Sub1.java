package com.jagex.runescape;

import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;

import java.awt.*;
import java.awt.image.*;

public class Class68_Sub1 extends Class68 implements ImageProducer, ImageObserver {
    public static RSString aClass1_2198 = RSString.CreateString("Name eingeben:");
    public static int[] anIntArray2199 = new int[32];
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2204;
    public static int[] anIntArray2207 = {0, -1, 0, 1};
    public static RSString aClass1_2209 = RSString.CreateString("Login server offline)3");
    public static int anInt2210;
    public static int anInt2211 = 2;
    public static Class68 aClass68_2213;

    static {
        int i = 2;
        for(int i_7_ = 0; i_7_ < 32; i_7_++) {
            anIntArray2199[i_7_] = -1 + i;
            i += i;
        }
    }

    public ColorModel colorModel;
    public ImageConsumer anImageConsumer2197;

    public static void method1047() {
        aClass68_2213 = null;
        aClass40_Sub5_Sub14_Sub4Array2204 = null;
        aClass1_2209 = null;
        aClass1_2198 = null;
        anIntArray2199 = null;
        anIntArray2207 = null;
    }

    public static AnimationSequence method1050(int arg0, int arg1) {
        AnimationSequence animationSequence = ((AnimationSequence) Class40_Sub5_Sub6.aClass9_2439.get((long) arg0, (byte) 47));
        if(arg1 != 2)
            anInt2211 = -106;
        if(animationSequence != null)
            return animationSequence;
        byte[] is = AnimationSequence.aCacheIndex_2484.getFile(arg0, 12);
        animationSequence = new AnimationSequence();
        if(is != null)
            animationSequence.method594(-1, new Buffer(is));
        animationSequence.method591((byte) 37);
        Class40_Sub5_Sub6.aClass9_2439.put(arg1 + -7210, (long) arg0, animationSequence);
        return animationSequence;
    }

    public static boolean method1051(int arg0, Widget arg1) {
        if(arg0 != 300)
            return false;
        int i = arg1.contentType;
        if(i >= 1 && i <= 200 || i >= 701 && i <= 900) {
            if(i >= 801)
                i -= 701;
            else if(i >= 701)
                i -= 601;
            else if(i < 101)
                i--;
            else
                i -= 101;
            Class40_Sub7.anInt2122++;
            OverlayDefinition.method558(0, HuffmanEncoding.aClass1_1572, 0, arg0 + -801, 0, 13, Class40_Sub5_Sub17_Sub6.method832(arg0 ^ ~0x103, (new RSString[]{Class26.aClass1_620, (Class40_Sub11.aClass1Array2147[i])})));
            OverlayDefinition.method558(0, Class58.aClass1_1354, 0, -501, 0, 18, Class40_Sub5_Sub17_Sub6.method832(arg0 + -192, (new RSString[]{Class26.aClass1_620, (Class40_Sub11.aClass1Array2147[i])})));
            return true;
        }
        if(i >= 401 && i <= 500) {
            CacheIndex_Sub1.anInt1793++;
            OverlayDefinition.method558(0, HuffmanEncoding.aClass1_1572, 0, -501, 0, 35, (Class40_Sub5_Sub17_Sub6.method832(115, (new RSString[]{Class26.aClass1_620, arg1.text}))));
            return true;
        }
        return false;
    }

    public static int method1052(int arg0, RSString arg1, Buffer arg2) {
        if(arg0 < 24)
            aClass1_2209 = null;
        int i = arg2.currentPosition;
        arg2.putSmart(arg1.length);
        arg2.currentPosition += (IdentityKit.aHuffmanEncoding_2590.encrypt(-18678, 0, arg2.currentPosition, arg1.length, arg1.chars, arg2.buffer));
        return -i + arg2.currentPosition;

    }

    public synchronized boolean isConsumer(ImageConsumer arg0) {
        return anImageConsumer2197 == arg0;
    }

    public synchronized void method1048(byte arg0) {
        if(anImageConsumer2197 != null) {
            int i = -99 / ((7 - arg0) / 62);
            anImageConsumer2197.setPixels(0, 0, anInt1619, anInt1617, colorModel, anIntArray1621, 0, anInt1619);
            anImageConsumer2197.imageComplete(2);
        }
    }

    public void method1044(int arg0, int arg1, Graphics arg2, int arg3) {
        if(arg0 != 0)
            anIntArray2199 = null;
        method1048((byte) -65);
        arg2.drawImage(anImage1625, arg1, arg3, this);
    }

    public synchronized void removeConsumer(ImageConsumer arg0) {
        if(arg0 == anImageConsumer2197)
            anImageConsumer2197 = null;
    }


    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        return true;
    }

    public synchronized void addConsumer(ImageConsumer arg0) {
        anImageConsumer2197 = arg0;
        arg0.setDimensions(anInt1619, anInt1617);
        arg0.setProperties(null);
        arg0.setColorModel(colorModel);
        arg0.setHints(14);
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
        anIntArray1621 = new int[1 + arg1 * arg3];
        anInt1619 = arg1;
        anInt1617 = arg3;
        colorModel = new DirectColorModel(32, 16711680, 65280, 255);
        anImage1625 = arg2.createImage(this);
        method1048((byte) -100);
        arg2.prepareImage(anImage1625, this);
        if(arg0 < 4)
            method1048((byte) -7);
        method1048((byte) -95);
        arg2.prepareImage(anImage1625, this);
        method1048((byte) -81);
        arg2.prepareImage(anImage1625, this);
        this.method1046((byte) 90);
    }

    public void startProduction(ImageConsumer arg0) {
        addConsumer(arg0);
    }

    public void requestTopDownLeftRightResend(ImageConsumer ic) {

    }
}
