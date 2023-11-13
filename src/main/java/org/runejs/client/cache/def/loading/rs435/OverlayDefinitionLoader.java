package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class OverlayDefinitionLoader implements DefinitionLoader<OverlayDefinition> {
    @Override
    public OverlayDefinition load(OverlayDefinition definition, Buffer data) {
        while (true) {
            int opcode = data.getUnsignedByte();
            if (opcode == 0)
                break;
            readValue(definition, data, opcode);
        }

        return definition;
    }

    private void readValue(OverlayDefinition definition, Buffer buffer, int opcode) {
        if (opcode == 1) {
            definition.color = buffer.getMediumBE();
        } else if (opcode == 2) {
            definition.texture = buffer.getUnsignedByte();
        } else if (opcode == 5) {
            definition.hideOverlay = false;
        } else if (opcode == 7) {
            definition.secondaryColor = buffer.getMediumBE();
        }
    }
}
