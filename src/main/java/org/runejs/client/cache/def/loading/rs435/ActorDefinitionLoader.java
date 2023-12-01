package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;

public class ActorDefinitionLoader implements DefinitionLoader<ActorDefinition> {
    @Override
    public ActorDefinition load(ActorDefinition definition, Buffer data) {
        while(true) {
            int opcode = data.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(definition, data, opcode);
        }

        return definition;
    }

    private void readValue(ActorDefinition definition, Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            definition.models = new int[length];
            for(int idx = 0; idx < length; ++idx) {
                definition.models[idx] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 2) {
            definition.name = buffer.getString();
        } else if(opcode == 12) {
            definition.boundaryDimension = buffer.getUnsignedByte();
        } else if(opcode == 13) {
            definition.stanceAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 14) {
            definition.walkAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 15) {
            definition.rotateLeftAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 16) {
            definition.rotateRightAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 17) {
            definition.walkAnimation = buffer.getUnsignedShortBE();
            definition.rotate180Animation = buffer.getUnsignedShortBE();
            definition.rotate90RightAnimation = buffer.getUnsignedShortBE();
            definition.rotate90LeftAnimation = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            definition.options[opcode - 30] = buffer.getString();
            if(definition.options[opcode - 30].equalsIgnoreCase(English.hidden)) {
                definition.options[-30 + opcode] = null;
            }
        } else if(opcode == 40) {
            int length = buffer.getUnsignedByte();
            definition.originalModelColors = new int[length];
            definition.modifiedModelColors = new int[length];
            for(int i_2_ = 0; i_2_ < length; i_2_++) {
                definition.modifiedModelColors[i_2_] = buffer.getUnsignedShortBE();
                definition.originalModelColors[i_2_] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 60) {
            int length = buffer.getUnsignedByte();
            definition.headModelIndexes = new int[length];
            for(int i_4_ = 0; length > i_4_; i_4_++) {
                definition.headModelIndexes[i_4_] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 93) {
            definition.renderOnMinimap = false;
        } else if(opcode == 95) {
            definition.combatLevel = buffer.getUnsignedShortBE();
        } else if(opcode == 97) {
            definition.resizeX = buffer.getUnsignedShortBE();
        } else if(opcode == 98) {
            definition.resizeY = buffer.getUnsignedShortBE();
        } else if(opcode == 99) {
            definition.hasRenderPriority = true;
        } else if(opcode == 100) {
            definition.ambient = buffer.getByte();
        } else if(opcode == 101) {
            definition.contrast = buffer.getByte() * 5;
        } else if(opcode == 102) {
            definition.headIcon = buffer.getUnsignedShortBE();
        } else if(opcode == 103) {
            definition.degreesToTurn = buffer.getUnsignedShortBE();
        } else if(opcode == 106) {
            definition.varbitId = buffer.getUnsignedShortBE();
            if(definition.varbitId == 65535) {
                definition.varbitId = -1;
            }
            definition.varPlayerIndex = buffer.getUnsignedShortBE();
            if(definition.varPlayerIndex == 65535) {
                definition.varPlayerIndex = -1;
            }
            int childrenCount = buffer.getUnsignedByte();
            definition.childIds = new int[childrenCount + 1];
            for(int idx = 0; childrenCount >= idx; idx++) {
                definition.childIds[idx] = buffer.getUnsignedShortBE();
                if(definition.childIds[idx] == 0xFFFF) {
                    definition.childIds[idx] = -1;
                }
            }
        } else if(opcode == 107) {
            definition.isClickable = false;
        }
    }
}
