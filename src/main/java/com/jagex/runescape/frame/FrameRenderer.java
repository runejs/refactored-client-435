package com.jagex.runescape.frame;

import com.jagex.runescape.Class51;

public class FrameRenderer implements Runnable {
    private final Minimap minimap;

    public FrameRenderer(Minimap minimap) {
        this.minimap = minimap;
    }

    @Override
    public void run() {
        while(true){
//            System.out.println("Rendering");

            if(Class51.anInt1197 <= 35 && Class51.anInt1197 >= 30){
                minimap.RenderResizableMiniMapArea(ScreenController.drawWidth - 210, 0);
            }
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
