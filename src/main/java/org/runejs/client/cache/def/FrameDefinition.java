package org.runejs.client.cache.def;

import org.runejs.client.cache.def.loading.CacheDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class FrameDefinition implements CacheDefinition {
    public static int[] scratchTranslatorY = new int[500];
    public static int[] indexFrameIds = new int[500];
    public static int[] scratchTranslatorX = new int[500];
    public static int[] scratchTranslatorZ = new int[500];

    public int translatorCount;
    public int[] translator_x;
    public FramemapDefinition framemap;
    public int[] index_frame_ids;
    public boolean aBoolean985 = false;
    public int[] translator_z;
    public int[] translator_y;
    public int id;

    public FrameDefinition(int id, DefinitionLoader<FrameDefinition> loader, byte[] b, FramemapDefinition framemap) {
        this.id = id;
        this.framemap = framemap;

        loader.load(this, new Buffer(b));
    }

    @Override
    public int getId() { return this.id; }
}
