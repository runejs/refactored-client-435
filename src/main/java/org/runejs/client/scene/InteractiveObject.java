package org.runejs.client.scene;

import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.renderer.gpu.StaticRange;

public class InteractiveObject {
    public int z;
    public int hash;
    public int config = 0;
    public int worldY;
    public int tileLeft;
    public Renderable renderable;
    public int worldX;
    public int tileBottom;
    public int worldZ;
    public int rotation;
    public int tileTop;
    public int tileRight;
    public int cycle;
    public int anInt491;
    /**
     * Where the GPU renderer keeps the model, when it has uploaded it; null for anything that moves or animates.
     */
    public StaticRange gpu;
    /**
     * The last frame in which the GPU renderer gathered this object's range, so an object spanning several tiles
     * is drawn once.
     */
    public int gpuCollectStamp;

    public InteractiveObject() {
        hash = 0;
    }


}
