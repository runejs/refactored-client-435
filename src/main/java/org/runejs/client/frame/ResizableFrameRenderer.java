package org.runejs.client.frame;

import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.frame.tab.TabProducer;
import org.runejs.client.media.Rasterizer;

public class ResizableFrameRenderer implements FrameRenderer {
    public final MinimapRenderer minimap = new MinimapRenderer();
    public final TabProducer tabProducer = new TabProducer();
    public final ChatBoxRenderer chatbox = new ChatBoxRenderer();

    private Thread drawingThread;

    private int drawWidth;
    private int drawHeight;

    private boolean canDraw;

    public ResizableFrameRenderer() {
        drawingThread = new Thread(this);
        drawingThread.start();
    }

    @Override
    public void run() {
        while(true){
            if(canDraw && Game.gameStatusCode <= 35 && Game.gameStatusCode >= 30){
                minimap.RenderResizableMiniMapArea(ScreenController.drawWidth - 210, 0);
                tabProducer.RenderResizableSideBarArea();
                chatbox.render();
            }
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDrawSize(int drawWidth, int drawHeight) {
        this.drawWidth = drawWidth;
        this.drawHeight = drawHeight;
    }

    private void drawToScreen() {
        minimap.draw(drawWidth, drawHeight);
        tabProducer.draw(drawWidth, drawHeight);
        chatbox.draw(drawWidth, drawHeight);
    }

    /**
     * Draw the debug view over the top
     *
     * TODO (jkm) remove static Rasterizer calls here
     *
     * @param mX Mouse position X
     * @param mY Mouse position Y
     */
    private void drawDebugView(int mX, int mY) {
        int[] tabInterFaceCoords= tabProducer.getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));
        int[] tabInterFaceTop = tabProducer.getTopBarCoordSize(drawWidth - 241, drawHeight - (334));
        int[] tabInterFaceBottom = tabProducer.getBottomBarCoordSize(drawWidth - 241, drawHeight - (334));
        if (isCoordinatesIn3dScreen(mX, mY)) {
            Rasterizer.drawFilledRectangleAlpha(0, 0, drawWidth, drawHeight, 0x00FF00, 90);
        } else {
            Rasterizer.drawFilledRectangleAlpha(0, 0, drawWidth, drawHeight, 0xFF00FF, 90);
        }
        if (isCoordinatesInExtendedTabArea(mX, mY) && !isCoordinatesInTabArea(mX, mY)) {
            Rasterizer.drawFilledRectangleAlpha(tabInterFaceTop[0], tabInterFaceTop[1], tabInterFaceTop[2], tabInterFaceTop[3], 0x00FF00, 90);
            Rasterizer.drawFilledRectangleAlpha(tabInterFaceBottom[0], tabInterFaceBottom[1], tabInterFaceBottom[2], tabInterFaceBottom[3], 0x00FF00, 90);
        } else {
            Rasterizer.drawFilledRectangleAlpha(tabInterFaceTop[0], tabInterFaceTop[1], tabInterFaceTop[2], tabInterFaceTop[3], 0x0000FF, 90);
            Rasterizer.drawFilledRectangleAlpha(tabInterFaceBottom[0], tabInterFaceBottom[1], tabInterFaceBottom[2], tabInterFaceBottom[3], 0x0000FF, 90);
        }
        if (isCoordinatesInTabArea(mX, mY)) {
            Rasterizer.drawFilledRectangleAlpha(tabInterFaceCoords[0], tabInterFaceCoords[1], MovedStatics.tabImageProducer.width, MovedStatics.tabImageProducer.height, 0x00FF00, 90);
        } else {
            Rasterizer.drawFilledRectangleAlpha(tabInterFaceCoords[0], tabInterFaceCoords[1], MovedStatics.tabImageProducer.width, MovedStatics.tabImageProducer.height, 0x0000FF, 90);
        }
        if (isCoordinatesInExtendedChatArea(mX, mY) && !isCoordinatesInChatArea(mX, mY)) {
            Rasterizer.drawFilledRectangleAlpha(0, drawHeight - (162), 516, drawHeight, 0x00FF00, 90);
        } else {
            Rasterizer.drawFilledRectangleAlpha(0, drawHeight - (162), 516, drawHeight, 0x0000FF, 90);
        }
        if (isCoordinatesInChatArea(mX, mY)) {
            Rasterizer.drawFilledRectangleAlpha(17, drawHeight - (162) + 16, ChatBox.chatBoxImageProducer.width, ChatBox.chatBoxImageProducer.height, 0x00FF00, 90);
        } else {
            Rasterizer.drawFilledRectangleAlpha(17, drawHeight - (162) + 16, ChatBox.chatBoxImageProducer.width, ChatBox.chatBoxImageProducer.height, 0x0000FF, 90);
        }
        if (isCoordinatesInMinimapArea(mX, mY)) {
            Rasterizer.drawFilledRectangleAlpha(drawWidth - 210, 0, 210, 210, 0x00FF00, 90);
        } else {
            Rasterizer.drawFilledRectangleAlpha(drawWidth - 210, 0, 210, 210, 0x0000FF, 90);
        }

        Rasterizer.drawFilledRectangle(mX - 4, mY - 4, 4, 4, 0xFF0000);
    }

    public boolean isCoordinatesInChatArea(int x, int y) {
        int minX = 17;
        int minY = drawHeight - (162) + 16;
        // TODO (jkm) point these elsewhere
        int maxX = minX + ChatBox.chatBoxImageProducer.width;
        int maxY = minY + ChatBox.chatBoxImageProducer.height;
        return x > minX && y > minY && x < maxX && y < maxY;
    }

    public boolean isCoordinatesIn3dScreen(int x, int y) {
        return x > 0 && y > 0 && x < drawWidth && y < drawHeight && !isCoordinatesInExtendedTabArea(x, y) && !isCoordinatesInTabArea(x, y) && !isCoordinatesInMinimapArea(x, y) && !isCoordinatesInExtendedChatArea(x, y);
    }

    public boolean isCoordinatesInMinimapArea(int x, int y) {
        return x > drawWidth - 210 && y < 210;
    }

    public boolean isCoordinatesInTabArea(int x, int y) {
        int[] tabInterFaceCoords= tabProducer.getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));

        int minX = tabInterFaceCoords[0];
        int minY = tabInterFaceCoords[1];
        int maxX = minX + tabInterFaceCoords[2];
        int maxY = minY + tabInterFaceCoords[3];
        return x > minX && y > minY && x < maxX && y < maxY;
    }

    public boolean isCoordinatesInExtendedTabArea(int x, int y) {
        int[] top = tabProducer.getTopBarCoordSize(drawWidth - 241, drawHeight - (334));
        int[] bottom = tabProducer.getBottomBarCoordSize(drawWidth - 241, drawHeight - (334));
        if(x > top[0] && x < top[0]+top[2] && y > top[1] && y < top[1]+top[3]) {
            return true;
        } else return x > bottom[0] && x < bottom[0] + bottom[2] && y > bottom[1] && y < bottom[1] + bottom[3];
    }

    public boolean isCoordinatesInExtendedChatArea(int x, int y) {
        return x > 0 && y > drawHeight - 184 && x < 516;
    }

    public TabProducer getTabProducer() {
        return tabProducer;
    }

    public void draw(int mouseX, int mouseY, boolean debugView) {
        canDraw = true;

        drawToScreen();

        if (debugView) {
            drawDebugView(mouseX, mouseY);
        }

        if (MovedStatics.menuOpen) {
            MovedStatics.drawMenu(0, 0);
        }
    }
}
