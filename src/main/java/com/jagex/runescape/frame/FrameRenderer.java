package com.jagex.runescape.frame;

import com.jagex.runescape.Class51;
import com.jagex.runescape.frame.tab.TabProducer;

public class FrameRenderer implements Runnable {
    private final Minimap minimap;
    private final TabProducer tabProducer;

    public FrameRenderer(Minimap minimap, TabProducer tabProducer) {
        this.minimap = minimap;
        this.tabProducer = tabProducer;
    }

    @Override
    public void run() {
        while(true) {
            if(Class51.currentAction <= 35 && Class51.currentAction >= 30) {
                minimap.RenderResizableMiniMapArea(ScreenController.drawWidth - 210, 0);
            }
            if(Class51.currentAction <= 35 && Class51.currentAction >= 30) {
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
