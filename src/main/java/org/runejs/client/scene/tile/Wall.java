package org.runejs.client.scene.tile;

import org.runejs.client.media.renderable.Renderable;

public class Wall {
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
