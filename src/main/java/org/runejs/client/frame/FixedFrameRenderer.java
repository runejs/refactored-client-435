package org.runejs.client.frame;

import org.runejs.client.frame.tab.TabProducer;

public class FixedFrameRenderer implements FrameRenderer {
    public final TabProducer tabProducer = new TabProducer();

    private int drawWidth;
    private int drawHeight;

    @Override
    public void setDrawSize(int drawWidth, int drawHeight) {
        this.drawWidth = drawWidth;
        this.drawHeight = drawHeight;
    }

    @Override
    public boolean isCoordinatesInChatArea(int x, int y) {
        return x > 17 && y > 357 && x < 496 && y < 453;
    }

    @Override
    public boolean isCoordinatesIn3dScreen(int x, int y) {
        return x > 4 && y > 4 && x < 516 && y < 338;
    }

    @Override
    public boolean isCoordinatesInMinimapArea(int x, int y) {
        return x > 575 && y < 156;
    }

    @Override
    public boolean isCoordinatesInTabArea(int x, int y) {
        return x > 553 && y > 205 && x < 743 && y < 466;
    }

    @Override
    public boolean isCoordinatesInExtendedTabArea(int x, int y) {
        int[] top = tabProducer.getTopBarCoordSize(drawWidth - 241, drawHeight - (334));
        int[] bottom = tabProducer.getBottomBarCoordSize(drawWidth - 241, drawHeight - (334));
        if(x > top[0] && x < top[0]+top[2] && y > top[1] && y < top[1]+top[3]) {
            return true;
        } else return x > bottom[0] && x < bottom[0] + bottom[2] && y > bottom[1] && y < bottom[1] + bottom[3];
    }

    @Override
    public boolean isCoordinatesInExtendedChatArea(int x, int y) {
        return x > 0 && y > drawHeight - 184 && x < 516;
    }

    @Override
    public TabProducer getTabProducer() {
        return tabProducer;
    }

    @Override
    public void draw(int mouseX, int mouseY, boolean debugView) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void run() {

    }
}
