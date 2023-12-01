package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class SpotAnimDefinitionLoader implements DefinitionLoader<SpotAnimDefinition> {
    @Override
    public SpotAnimDefinition load(SpotAnimDefinition definition, Buffer data) {
        for (; ; ) {
            int opcode = data.getUnsignedByte();
            if (opcode == 0) {
                break;
            }
            readValue(definition, opcode, data);
        }

        return definition;
    }

    private void readValue(SpotAnimDefinition definition, int opcode, Buffer buffer) {
        if (opcode == 1) {
            definition.modelId = buffer.getUnsignedShortBE();
        } else if (opcode == 2) {
            definition.animationId = buffer.getUnsignedShortBE();
        } else if (opcode == 4) {
            definition.resizeX = buffer.getUnsignedShortBE();
        } else if (opcode == 5) {
            definition.resizeY = buffer.getUnsignedShortBE();
        } else if (opcode == 6) {
            definition.rotaton = buffer.getUnsignedShortBE();
        } else if (opcode == 7) {
            definition.ambient = buffer.getUnsignedByte();
        } else if (opcode == 8) {
            definition.contrast = buffer.getUnsignedByte();
        } else if (opcode >= 40 && opcode < 50) {
            definition.recolorToFind[-40 + opcode] = buffer.getUnsignedShortBE();
        } else if (opcode >= 50 && opcode < 60) {
            definition.recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        }
    }
}
