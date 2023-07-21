package org.runejs.client;

import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.RasterizerInstanced;

import java.awt.*;
import java.awt.image.*;

public class ProducingGraphicsBuffer_Sub1 extends ProducingGraphicsBuffer implements ImageProducer, ImageObserver {
    public ColorModel colorModel;
    public ImageConsumer imageConsumer;

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

    public void method1041(int arg0, int arg1, Component arg2, int arg3, RasterizerInstanced rasterizerInstanced) {
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
        this.prepareRasterizer(rasterizerInstanced);
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
        method1041(arg0, arg1, arg2, arg3, null);
    }

    public void startProduction(ImageConsumer arg0) {
        addConsumer(arg0);
    }

    public void requestTopDownLeftRightResend(ImageConsumer ic) {

    }
}
