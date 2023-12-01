package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.IdentityKit;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class IdentityKitDefinitionLoader implements DefinitionLoader<IdentityKit> {
    @Override
    public IdentityKit load(IdentityKit definition, Buffer data) {
        while(true) {
            int opcode = data.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(definition, data, opcode);
        }

        return definition;
    }

    private void readValue(IdentityKit definition, Buffer buffer, int opcode) {
        if(opcode == 1) {
            definition.bodyPartId = buffer.getUnsignedByte();
        } else if(opcode == 2) {
            int modelCount = buffer.getUnsignedByte();
            definition.modelId = new int[modelCount];
            for(int model = 0; model < modelCount; model++) {
                definition.modelId[model] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 3) {
            definition.nonSelectable = true;
        } else if(opcode >= 40 && opcode < 50) {
            definition.recolorToFind[opcode + -40] = buffer.getUnsignedShortBE();
        } else if(opcode >= 50 && opcode < 60) {
            definition.recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        } else if(opcode >= 60 && opcode < 70) {
            definition.models[-60 + opcode] = buffer.getUnsignedShortBE();
        }
    }
}
