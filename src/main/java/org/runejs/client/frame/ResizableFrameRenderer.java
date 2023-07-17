package org.runejs.client.frame;

import org.runejs.client.Game;
import org.runejs.client.frame.tab.TabProducer;

public class ResizableFrameRenderer implements FrameRenderer {
    private final Minimap minimap;
    private final TabProducer tabProducer;
    private final ChatBoxRenderer chatbox;

    public ResizableFrameRenderer(Minimap minimap, TabProducer tabProducer, ChatBoxRenderer chatbox) {
        this.minimap = minimap;
        this.tabProducer = tabProducer;
        this.chatbox = chatbox;
    }

    @Override
    public void run() {
        while(true){
            if(Game.gameStatusCode <= 35 && Game.gameStatusCode >= 30){
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
}
