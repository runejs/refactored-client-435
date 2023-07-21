package org.runejs.client;

import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.RasterizerInstanced;

import java.awt.*;

public abstract class ProducingGraphicsBuffer {
    public int height;
    public int width;
    public int[] pixels;
    public Image image;

    public abstract void method1041(int i, int i_2_, Component component, int i_3_);
    public abstract void method1041(int i, int i_2_, Component component, int i_3_, RasterizerInstanced rasterizerInstance);

    public abstract void drawGraphics(int x, int y, Graphics graphics);
    public abstract void paintComponent(int x, int y, Graphics graphics);

    public void prepareRasterizer(RasterizerInstanced rasterizerInstance) {
        if (rasterizerInstance == null) {
            Rasterizer.prepare(pixels, width, height);
        } else {
            rasterizerInstance.prepare(pixels, width, height);
        }
    }

    public void prepareRasterizer() {
        prepareRasterizer(null);
    }
}
