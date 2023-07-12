package org.runejs.client.frame;

import org.runejs.client.Game;
import org.runejs.client.frame.tab.TabProducer;

public class FrameRenderer implements Runnable {
    private final Minimap minimap;
    private final TabProducer tabProducer;

    public FrameRenderer(Minimap minimap, TabProducer tabProducer) {
        this.minimap = minimap;
        this.tabProducer = tabProducer;
    }

    @Override
    public void run() {
        while(true){
//            System.out.println("Rendering");

            if(Game.gameStatusCode <= 35 && Game.gameStatusCode >= 30){
                minimap.RenderResizableMiniMapArea(ScreenController.drawWidth - 210, 0);
            }
            if(Game.gameStatusCode <= 35 && Game.gameStatusCode >= 30){
                tabProducer.RenderResizableSideBarArea();
            }
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
