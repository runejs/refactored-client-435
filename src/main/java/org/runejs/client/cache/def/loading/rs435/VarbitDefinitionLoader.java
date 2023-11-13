package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.VarbitDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class VarbitDefinitionLoader implements DefinitionLoader<VarbitDefinition> {
    @Override
    public VarbitDefinition load(VarbitDefinition definition, Buffer data) {
        while(true) {
            int opCode = data.getUnsignedByte();
            if(opCode == 0)
                break;
            if(opCode == 1) {
                definition.index = data.getUnsignedShortBE();
                definition.leastSignificantBit = data.getUnsignedByte();
                definition.mostSignificantBit = data.getUnsignedByte();
            }
        }

        return definition;
    }
}
