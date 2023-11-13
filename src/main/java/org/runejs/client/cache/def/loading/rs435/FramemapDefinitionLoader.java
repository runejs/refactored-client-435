package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.FramemapDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class FramemapDefinitionLoader implements DefinitionLoader<FramemapDefinition> {
    @Override
    public FramemapDefinition load(FramemapDefinition definition, Buffer data) {
        definition.length = data.getUnsignedByte();
        definition.types = new int[definition.length];
        definition.frameMaps = new int[definition.length][];
        for(int i = 0; i < definition.length; i++)
            definition.types[i] = data.getUnsignedByte();
        for(int i = 0; definition.length > i; i++)
            definition.frameMaps[i] = new int[data.getUnsignedByte()];
        for(int i = 0; i < definition.length; i++) {
            for(int i_38_ = 0; definition.frameMaps[i].length > i_38_; i_38_++)
                definition.frameMaps[i][i_38_] = data.getUnsignedByte();
        }

        return definition;
    }
}
