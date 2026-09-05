package org.runejs.client.scene.tile;

import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.renderer.gpu.StaticRange;

public class FloorDecoration {
    public int config;
    public int hash;
    public int x;
    public Renderable renderable;
    public int y;
    public int z;
    /**
     * Where the GPU renderer keeps the decoration's model, when it has uploaded it.
     */
    public StaticRange gpu;
}
