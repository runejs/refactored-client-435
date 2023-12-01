package org.runejs.client.cache.def;

import org.runejs.client.cache.def.loading.CacheDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;

public class FramemapDefinition extends Node implements CacheDefinition {
    public int[][] frameMaps;
    public int length;
    public int id;
    public int[] types;

    public FramemapDefinition(int id, DefinitionLoader<FramemapDefinition> loader, byte[] data) {
        this.id = id;

        loader.load(this, new Buffer(data));
    }

    @Override
    public int getId() { return this.id; }
}
