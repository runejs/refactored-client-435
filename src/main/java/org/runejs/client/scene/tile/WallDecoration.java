package org.runejs.client.scene.tile;

import org.runejs.client.node.NodeCache;
import org.runejs.client.media.renderable.Renderable;

public class WallDecoration {
    public static NodeCache modelCache = new NodeCache(50);

    public int configBits;
    public int z;
    public Renderable renderable;
    public int face;
    public int config = 0;
    public int y;
    public int x;
    public int hash = 0;

}
