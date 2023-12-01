package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;

public class GameObjectDefinitionLoader implements DefinitionLoader<GameObjectDefinition> {
    /**
     * TODO (jkm) inject
     */
    private boolean lowMemory = false;

    @Override
    public GameObjectDefinition load(GameObjectDefinition definition, Buffer data) {
        for(; ; ) {
            int opcode = data.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(definition, data, opcode);
        }

        return definition;
    }

    private void readValue(GameObjectDefinition definition, Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            if(length > 0) {
                if(definition.objectModels == null || lowMemory) {
                    definition.objectTypes = new int[length];
                    definition.objectModels = new int[length];
                    for(int index = 0; length > index; index++) {
                        definition.objectModels[index] = buffer.getUnsignedShortBE();
                        definition.objectTypes[index] = buffer.getUnsignedByte();
                    }
                } else {
                    buffer.currentPosition += length * 3;
                }
            }
        } else if(opcode == 2) {
            definition.name = buffer.getString();
        } else if(opcode == 5) {
            int length = buffer.getUnsignedByte();
            if(length > 0) {
                if(definition.objectModels == null || lowMemory) {
                    definition.objectTypes = null;
                    definition.objectModels = new int[length];
                    for(int index = 0; length > index; index++) {
                        definition.objectModels[index] = buffer.getUnsignedShortBE();
                    }
                } else {
                    buffer.currentPosition += 2 * length;
                }
            }
        } else if(opcode == 14) {
            definition.sizeX = buffer.getUnsignedByte();
        } else if(opcode == 15) {
            definition.sizeY = buffer.getUnsignedByte();
        } else if(opcode == 17) {
            definition.solid = false;
        } else if(opcode == 18) {
            definition.walkable = false;
        } else if(opcode == 19) {
            definition.hasActions = buffer.getUnsignedByte();
        } else if(opcode == 21) {
            definition.adjustToTerrain = true;
        } else if(opcode == 22) {
            definition.nonFlatShading = true;
        } else if(opcode == 23) {
            definition.wall = true;
        } else if(opcode == 24) {
            definition.animationId = buffer.getUnsignedShortBE();
            if(definition.animationId == 0xFFFF) {
                definition.animationId = -1;
            }
        } else if(opcode == 28) {
            definition.setDecorDisplacement = buffer.getUnsignedByte();
        } else if(opcode == 29) {
            definition.ambient = buffer.getByte();
        } else if(opcode == 39) {
            definition.contrast = 5 * buffer.getByte();
        } else if(opcode >= 30 && opcode < 35) {
            definition.actions[opcode - 30] = buffer.getString();
            if(definition.actions[opcode + -30].equalsIgnoreCase(English.hidden)) {
                definition.actions[opcode + -30] = null;
            }
        } else if(opcode == 40) {
            int length = buffer.getUnsignedByte();
            definition.recolorToFind = new int[length];
            definition.recolorToReplace = new int[length];
            for(int index = 0; index < length; index++) {
                definition.recolorToFind[index] = buffer.getUnsignedShortBE();
                definition.recolorToReplace[index] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 60) {
            definition.icon = buffer.getUnsignedShortBE();
        } else if(opcode == 62) {
            definition.rotated = true;
        } else if(opcode == 64) {
            definition.castsShadow = false;
        } else if(opcode == 65) {
            definition.modelSizeX = buffer.getUnsignedShortBE();
        } else if(opcode == 66) {
            definition.modelSizeHeight = buffer.getUnsignedShortBE();
        } else if(opcode == 67) {
            definition.modelSizeY = buffer.getUnsignedShortBE();
        } else if(opcode == 68) {
            definition.mapSceneID = buffer.getUnsignedShortBE();
        } else if(opcode == 69) {
            definition.blockingMask = buffer.getUnsignedByte();
        } else if(opcode == 70) {
            definition.offsetX = buffer.getShortBE();
        } else if(opcode == 71) {
            definition.offsetHeight = buffer.getShortBE();
        } else if(opcode == 72) {
            definition.offsetY = buffer.getShortBE();
        } else if(opcode == 73) {
            definition.obstructsGround = true;
        } else if(opcode == 74) {
            definition.hollow = true;
        } else if(opcode == 75) {
            definition.supportsItems = buffer.getUnsignedByte();
        } else if(opcode == 77) {
            definition.varbitId = buffer.getUnsignedShortBE();
            if(definition.varbitId == 0xffff) {
                definition.varbitId = -1;
            }
            definition.configId = buffer.getUnsignedShortBE();
            if(definition.configId == 0xFFFF) {
                definition.configId = -1;
            }
            int length = buffer.getUnsignedByte();
            definition.childIds = new int[1 + length];
            for(int index = 0; index <= length; ++index) {
                definition.childIds[index] = buffer.getUnsignedShortBE();
                if(0xFFFF == definition.childIds[index]) {
                    definition.childIds[index] = -1;
                }
            }
        } else if(opcode == 78) {
            definition.ambientSoundId = buffer.getUnsignedShortBE();
            definition.ambientSoundHearDistance = buffer.getUnsignedByte();
        } else if(opcode == 79) {
            definition.unkn1 = buffer.getUnsignedShortBE();
            definition.unkn2 = buffer.getUnsignedShortBE();
            definition.ambientSoundHearDistance = buffer.getUnsignedByte();
            int length = buffer.getUnsignedByte();
            definition.soundEffectIds = new int[length];
            for(int index = 0; index < length; ++index) {
                definition.soundEffectIds[index] = buffer.getUnsignedShortBE();
            }
        }
    }
}
