package org.runejs.client.frame;

import org.runejs.client.frame.tab.TabProducer;
import org.runejs.client.media.RasterizerInstanced;

public interface FrameRenderer extends Runnable {
    void setDrawSize(int drawWidth, int drawHeight);

    boolean isCoordinatesInChatArea(int x, int y);
    boolean isCoordinatesIn3dScreen(int x, int y);
    boolean isCoordinatesInMinimapArea(int x, int y);
    boolean isCoordinatesInTabArea(int x, int y);
    boolean isCoordinatesInExtendedTabArea(int x, int y);
    boolean isCoordinatesInExtendedChatArea(int x, int y);

    TabProducer getTabProducer();

    void setRasterizer(RasterizerInstanced rasterizer);

    void draw(int mouseX, int mouseY, boolean debugView);
    void stop();
}
