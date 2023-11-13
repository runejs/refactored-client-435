package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class ItemDefinitionLoader implements DefinitionLoader<ItemDefinition> {
    @Override
    public ItemDefinition load(ItemDefinition definition, Buffer data) {
        while(true) {
            int opcode = data.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(definition, opcode, data);
        }

        return definition;
    }

    private void readValue(ItemDefinition definition, int opcode, Buffer buffer) {
        if(opcode == 1) {
            definition.inventoryModelId = buffer.getUnsignedShortBE();
        } else if(opcode == 2) {
            definition.name = buffer.getString();
        } else if(opcode == 4) {
            definition.zoom2d = buffer.getUnsignedShortBE();
        } else if(opcode == 5) {
            definition.xan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 6) {
            definition.yan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 7) {
            definition.xOffset2d = buffer.getUnsignedShortBE();
            if(definition.xOffset2d > 32767) {
                definition.xOffset2d -= 65536;
            }
        } else if(opcode == 8) {
            definition.yOffset2d = buffer.getUnsignedShortBE();
            if(definition.yOffset2d > 32767) {
                definition.yOffset2d -= 65536;
            }
        } else if(opcode == 10) {
            buffer.getUnsignedShortBE(); // Dummy
        } else if(opcode == 11) {
            definition.stackable = 1;
        } else if(opcode == 12) {
            definition.cost = buffer.getIntBE();
        } else if(opcode == 16) {
            definition.members = true;
        } else if(opcode == 23) {
            definition.maleModel0 = buffer.getUnsignedShortBE();
            definition.maleOffset = buffer.getUnsignedByte();
        } else if(opcode == 24) {
            definition.maleModel1 = buffer.getUnsignedShortBE();
        } else if(opcode == 25) {
            definition.femaleModel0 = buffer.getUnsignedShortBE();
            definition.femaleOffset = buffer.getUnsignedByte();
        } else if(opcode == 26) {
            definition.femaleModel1 = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            definition.groundOptions[-30 + opcode] = buffer.getString();
            if(definition.groundOptions[opcode + -30].equalsIgnoreCase("Hidden")) {
                definition.groundOptions[opcode + -30] = null;
            }
        } else if(opcode >= 35 && opcode < 40) {
            definition.interfaceOptions[opcode + -35] = buffer.getString();
        } else if(opcode == 40) {
            int colorCount = buffer.getUnsignedByte();
            definition.destColors = new int[colorCount];
            definition.originalColours = new int[colorCount];
            for(int colorIndex = 0; colorIndex < colorCount; colorIndex++) {
                definition.originalColours[colorIndex] = buffer.getUnsignedShortBE();
                definition.destColors[colorIndex] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 78) {
            definition.maleModel2 = buffer.getUnsignedShortBE();
        } else if(opcode == 79) {
            definition.femaleModel2 = buffer.getUnsignedShortBE();
        } else if(opcode == 90) {
            definition.primaryMaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 91) {
            definition.primaryFemaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 92) {
            definition.secondaryMaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 93) {
            definition.secondaryFemaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 95) {
            definition.zan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 97) {
            definition.notedId = buffer.getUnsignedShortBE();
        } else if(opcode == 98) {
            definition.noteTemplateId = buffer.getUnsignedShortBE();
        } else if(opcode >= 100 && opcode < 110) {
            if(definition.stackIds == null) {
                definition.stackableAmounts = new int[10];
                definition.stackIds = new int[10];
            }
            definition.stackIds[-100 + opcode] = buffer.getUnsignedShortBE();
            definition.stackableAmounts[-100 + opcode] = buffer.getUnsignedShortBE();
        } else if(opcode == 110) {
            definition.groundScaleX = buffer.getUnsignedShortBE();
        } else if(opcode == 111) {
            definition.groundScaleY = buffer.getUnsignedShortBE();
        } else if(opcode == 112) {
            definition.groundScaleZ = buffer.getUnsignedShortBE();
        } else if(opcode == 113) {
            definition.ambient = buffer.getByte();
        } else if(opcode == 114) {
            definition.contrast = buffer.getByte() * 5;
        } else if(opcode == 115) {
            definition.teamIndex = buffer.getUnsignedByte();
        }
    }
}
