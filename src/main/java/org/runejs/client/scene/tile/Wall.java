package org.runejs.client.scene.tile;

import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.renderer.gpu.StaticRange;

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
    /**
     * Where the GPU renderer keeps the two wall models, when it has uploaded them.
     */
    public StaticRange gpuPrimary;
    public StaticRange gpuSecondary;

    public Wall() {
        hash = 0;
    }
}
