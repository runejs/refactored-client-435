package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class VarPlayerDefinitionLoader implements DefinitionLoader<VarPlayerDefinition> {
    @Override
    public VarPlayerDefinition load(VarPlayerDefinition definition, Buffer data) {
        while(true) {
            int opcode = data.getUnsignedByte();
            if(opcode == 0)
                break;
            if(opcode == 5)
                definition.type = data.getUnsignedShortBE();
        }

        return definition;
    }
}
