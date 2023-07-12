package org.runejs.client;

import org.runejs.client.input.MouseHandler;

public class MouseCapturer implements Runnable {
    public Object objectLock;
    public boolean aBoolean913 = true;
    public int[] coordsY;
    public int coord;
    public int[] coordsX;

    public MouseCapturer() {
        objectLock = new Object();
        coord = 0;
        coordsY = new int[500];
        coordsX = new int[500];
    }

    public void run() {
        while(aBoolean913) {
            synchronized(objectLock) {
                if(coord < 500) {
                    coordsX[coord] = MouseHandler.mouseX;
                    coordsY[coord] = MouseHandler.mouseY;
                    coord++;
                }
            }
            MovedStatics.threadSleep(50L);
        }
    }
}
