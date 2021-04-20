package com.jagex.runescape;

import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;
import java.awt.image.*;
import java.nio.charset.StandardCharsets;

public class ProducingGraphicsBuffer_Sub1 extends ProducingGraphicsBuffer implements ImageProducer, ImageObserver {
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2204;
    public static int[] anIntArray2207 = {0, -1, 0, 1};
    public static int anInt2210;
    public static int anInt2211 = 2;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2213;

    public ColorModel colorModel;
    public ImageConsumer imageConsumer;


    public static AnimationSequence getAnimationSequence(int animationId) {
        AnimationSequence animationSequence = (AnimationSequence) Class40_Sub5_Sub6.aClass9_2439.get((long) animationId);

        if(animationSequence != null)
            return animationSequence;
        byte[] is = AnimationSequence.aCacheArchive_2484.getFile(12, animationId);
        animationSequence = new AnimationSequence();
        if(is != null)
            animationSequence.decodeAllAnimationSequences(new Buffer(is));
        animationSequence.method591();
        Class40_Sub5_Sub6.aClass9_2439.put((long) animationId, animationSequence);
        return animationSequence;
    }

    public static boolean method1051(int arg0, GameInterface arg1) {
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
            OverlayDefinition.addActionRow(English.remove, 0, 0, 0, 13, Native.white + Player.friendUsernames[i]);
            OverlayDefinition.addActionRow(English.message, 0, 0, 0, 18, Native.white + Player.friendUsernames[i]);
            return true;
        }
        if(i >= 401 && i <= 500) {
            OverlayDefinition.addActionRow(English.remove, 0, 0, 0, 35, Native.white + arg1.disabledText);
            return true;
        }
        return false;
    }

    public static int method1052(String arg1, Buffer arg2) {
        int i = arg2.currentPosition;
        byte[] strBytes = arg1.getBytes(StandardCharsets.UTF_8);
        arg2.putSmart(strBytes.length);
        arg2.currentPosition += IdentityKit.aHuffmanEncoding_2590.encrypt(0, arg2.currentPosition, strBytes.length, strBytes, arg2.buffer);
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

    @Override
    public void paintComponent(int x, int y, Graphics graphics) {

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
        this.prepareRasterizer();
    }

    public void startProduction(ImageConsumer arg0) {
        addConsumer(arg0);
    }

    public void requestTopDownLeftRightResend(ImageConsumer ic) {

    }
}
