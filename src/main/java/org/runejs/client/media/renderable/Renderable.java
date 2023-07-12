package org.runejs.client.media.renderable;

import org.runejs.client.node.CachedNode;

public abstract class Renderable extends CachedNode {
    public int modelHeight = 1000;

    public void renderAtPoint(int arg0, int arg1, int arg2, int arg3, int arg4, int x, int z, int y, int arg8) {
        Model class40_sub5_sub17_sub5 = getRotatedModel();
        if(class40_sub5_sub17_sub5 != null) {
            modelHeight = class40_sub5_sub17_sub5.modelHeight;
            class40_sub5_sub17_sub5.renderAtPoint(arg0, arg1, arg2, arg3, arg4, x, z, y, arg8);
        }
    }

    public Model getRotatedModel() {
        return null;
    }
}
