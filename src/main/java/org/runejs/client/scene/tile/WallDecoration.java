package org.runejs.client.scene.tile;

import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.renderer.gpu.StaticRange;

public class WallDecoration {

    public int configBits;
    public int z;
    public Renderable renderable;
    public int face;
    public int config = 0;
    public int y;
    public int x;
    public int hash = 0;
    /**
     * Where the GPU renderer keeps the decoration's model, when it has uploaded it. A decoration that shows on both
     * sides of its wall (config bits 0x300) is uploaded twice, inset and outset.
     */
    public StaticRange gpu;
    public StaticRange gpuOutset;

}
