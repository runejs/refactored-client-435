package org.runejs.client;

import org.runejs.client.node.NodeCache;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.util.SignlinkNode;

import java.awt.*;

public abstract class ProducingGraphicsBuffer {
    public static NodeCache aClass9_1615 = new NodeCache(64);
    public static int anInt1623 = 0;
    public static int oneMouseButton = 0;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1631;
    public static SignlinkNode updateServerSignlinkNode;
    public static int anInt1634 = 0;

    /**
     * Position of the hint icon in world coordinates (e.g. 3222,3222)
     */
    public static int hintIconPosX = 0;
    public static ProducingGraphicsBuffer muteButton;

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
