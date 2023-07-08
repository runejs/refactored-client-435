package org.runejs.client;

import org.runejs.client.cache.def.IdentityKit;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.actor.Player;

import java.awt.*;
import java.awt.image.*;
import java.nio.charset.StandardCharsets;

public class ProducingGraphicsBuffer_Sub1 extends ProducingGraphicsBuffer implements ImageProducer, ImageObserver {
    /**
     * Overhead icon sprites, e.g. overhead prayers
     */
    public static ImageRGB[] headIconSprites;
    public static int[] anIntArray2207 = {0, -1, 0, 1};
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2213;

    public ColorModel colorModel;
    public ImageConsumer imageConsumer;


    public static AnimationSequence getAnimationSequence(int animationId) {
        AnimationSequence animationSequence = (AnimationSequence) MovedStatics.aClass9_2439.get((long) animationId);

        if(animationSequence != null)
            return animationSequence;
        byte[] is = AnimationSequence.aCacheArchive_2484.getFile(12, animationId);
        animationSequence = new AnimationSequence();
        if(is != null)
            animationSequence.decodeAllAnimationSequences(new Buffer(is));
        animationSequence.method591();
        MovedStatics.aClass9_2439.put((long) animationId, animationSequence);
        return animationSequence;
    }

    public static boolean method1051(int arg0, GameInterface gameInterface) {
        if(arg0 != 300)
            return false;
        int i = gameInterface.contentType;
        if(i >= 1 && i <= 200 || i >= 701 && i <= 900) {
            if(i >= 801)
                i -= 701;
            else if(i >= 701)
                i -= 601;
            else if(i < 101)
                i--;
            else
                i -= 101;
            MovedStatics.addActionRow(English.remove, 0, 0, 0, ActionRowType.REMOVE_FRIEND.getId(), Native.white + Player.friendUsernames[i]);
            MovedStatics.addActionRow(English.message, 0, 0, 0, ActionRowType.MESSAGE_FRIEND.getId(), Native.white + Player.friendUsernames[i]);
            return true;
        }
        if(i >= 401 && i <= 500) {
            MovedStatics.addActionRow(English.remove, 0, 0, 0, ActionRowType.REMOVE_IGNORE.getId(), Native.white + gameInterface.disabledText);
            return true;
        }
        return false;
    }

    public static int method1052(String value, Buffer buffer) {
        int startingPosition = buffer.currentPosition;
        byte[] strBytes = value.getBytes(StandardCharsets.UTF_8);
        buffer.putSmart(strBytes.length);
        buffer.currentPosition += IdentityKit.aHuffmanEncoding_2590.encrypt(0, buffer.currentPosition, strBytes.length, strBytes, buffer.buffer);
        return buffer.currentPosition - startingPosition;

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
