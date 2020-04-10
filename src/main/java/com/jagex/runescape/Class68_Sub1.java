package com.jagex.runescape;

import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.scene.GroundItemTile;

import java.awt.*;
import java.awt.image.*;

public class Class68_Sub1 extends Class68 implements ImageProducer, ImageObserver {
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
    public ImageConsumer imageConsumer;

    public static void method1047() {
        aClass68_2213 = null;
        aClass40_Sub5_Sub14_Sub4Array2204 = null;
        aClass1_2209 = null;
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
        Class40_Sub5_Sub6.aClass9_2439.put((long) arg0, animationSequence);
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
            OverlayDefinition.addActionRow(HuffmanEncoding.aClass1_1572, 0, 0, 0, 13, RSString.linkRSStrings((new RSString[]{Class26.aClass1_620, (Class40_Sub11.friendUsernames[i])})));
            OverlayDefinition.addActionRow(GroundItemTile.aClass1_1354, 0, 0, 0, 18, RSString.linkRSStrings((new RSString[]{Class26.aClass1_620, (Class40_Sub11.friendUsernames[i])})));
            return true;
        }
        if(i >= 401 && i <= 500) {
            OverlayDefinition.addActionRow(HuffmanEncoding.aClass1_1572, 0, 0, 0, 35, (RSString.linkRSStrings((new RSString[]{Class26.aClass1_620, arg1.disabledText}))));
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
        return imageConsumer == arg0;
    }

    public synchronized void drawPixels() {
        if(imageConsumer != null) {
            imageConsumer.setPixels(0, 0, width, height, colorModel, pixels, 0, width);
            imageConsumer.imageComplete(2);
        }
    }

    public void drawGraphics(int x, int y, Graphics graphics) {
        Rasterizer.prepare(pixels, width, height);

        drawPixels();
        graphics.drawImage(image, x, y, this);
    }

    public synchronized void removeConsumer(ImageConsumer arg0) {
        if(arg0 == imageConsumer)
            imageConsumer = null;
    }


    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        return true;
    }

    public synchronized void addConsumer(ImageConsumer arg0) {
        imageConsumer = arg0;
        arg0.setDimensions(width, height);
        arg0.setProperties(null);
        arg0.setColorModel(colorModel);
        arg0.setHints(14);
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
        pixels = new int[1 + arg1 * arg3];
        width = arg1;
        height = arg3;
        colorModel = new DirectColorModel(32, 16711680, 65280, 255);
        image = arg2.createImage(this);
        drawPixels();
        arg2.prepareImage(image, this);
        if(arg0 < 4)
            drawPixels();
        drawPixels();
        arg2.prepareImage(image, this);
        drawPixels();
        arg2.prepareImage(image, this);
        this.method1046((byte) 90);
    }

    public void startProduction(ImageConsumer arg0) {
        addConsumer(arg0);
    }

    public void requestTopDownLeftRightResend(ImageConsumer ic) {

    }
}
