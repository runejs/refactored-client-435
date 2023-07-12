package org.runejs.client.media.renderable;

import org.runejs.client.cache.def.*;

public class Item extends Renderable {
    public int itemCount;
    public int itemId;

    public Model getRotatedModel() {
        return ItemDefinition.forId(itemId, 10).asGroundStack(true, itemCount);
    }
}
