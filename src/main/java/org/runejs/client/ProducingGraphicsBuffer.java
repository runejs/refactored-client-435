package org.runejs.client;

import org.runejs.client.media.Rasterizer;

import java.awt.*;

public abstract class ProducingGraphicsBuffer {
    public int height;
    public int width;
    public int[] pixels;
    public Image image;

    public abstract void method1041(int i, int i_2_, Component component, int i_3_);

    public abstract void drawGraphics(int x, int y, Graphics graphics);
    public abstract void paintComponent(int x, int y, Graphics graphics);

    public void prepareRasterizer() {
        Rasterizer.prepare(pixels, width, height);
    }
}
