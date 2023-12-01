package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.UnderlayDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class UnderlayDefinitionLoader implements DefinitionLoader<UnderlayDefinition> {
    @Override
    public UnderlayDefinition load(UnderlayDefinition definition, Buffer data) {
        while(true) {
            int opcode = data.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(definition, data, opcode);
        }

        return definition;
    }

    private void readValue(UnderlayDefinition definition, Buffer buffer, int opcode) {
        if(opcode == 1) {
            definition.color = buffer.getMediumBE();
        }
    }
}
