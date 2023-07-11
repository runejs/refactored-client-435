package org.runejs.client.scene.tile;

import org.runejs.client.LinkedList;
import org.runejs.client.media.renderable.Renderable;

public class Wall {
    public static LinkedList[][][] groundItems = new LinkedList[4][104][104];

    public int hash;
    public int x;
    public int y;
    public int z;
    public int orientationA;
    public int orientationB;
    public Renderable secondary;
    public Renderable primary;
    public int config = 0;

    public Wall() {
        hash = 0;
    }
}
