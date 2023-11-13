package org.runejs.client.cache.def.loading.rs435;

import org.runejs.client.cache.def.FrameDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.io.Buffer;

public class FrameDefinitionLoader implements DefinitionLoader<FrameDefinition> {
    @Override
    public FrameDefinition load(FrameDefinition definition, Buffer data) {
        // TODO (jkm) rethink use of statics in this class

        int originalLength = data.buffer.length;
        Buffer in = new Buffer(data.buffer);

        in.currentPosition = 2;
        int length = in.getUnsignedByte();
        int lasIndex = -1;
        int index = 0;
        data.currentPosition = in.currentPosition + length;
        for(int i = 0; i < length; i++) {
            int var9 = in.getUnsignedByte();
            if(var9 <= 0) {
                continue;
            }
            if(definition.framemap.types[i] != 0) {
                for(int var10 = i - 1; var10 > lasIndex; var10--) {
                    if(definition.framemap.types[var10] == 0) {
                        FrameDefinition.indexFrameIds[index] = var10;
                        FrameDefinition.scratchTranslatorX[index] = 0;
                        FrameDefinition.scratchTranslatorY[index] = 0;
                        FrameDefinition.scratchTranslatorZ[index] = 0;
                        index++;
                        break;
                    }
                }
            }
            FrameDefinition.indexFrameIds[index] = i;
            int var11 = 0;
            if(definition.framemap.types[i] == 3)
                var11 = 128;
            if((var9 & 0x1) != 0)
                FrameDefinition.scratchTranslatorX[index] = data.getUnsignedSmart();
            else
                FrameDefinition.scratchTranslatorX[index] = var11;
            if((var9 & 0x2) != 0)
                FrameDefinition.scratchTranslatorY[index] = data.getUnsignedSmart();
            else
                FrameDefinition.scratchTranslatorY[index] = var11;
            if((var9 & 0x4) != 0)
                FrameDefinition.scratchTranslatorZ[index] = data.getUnsignedSmart();
            else
                FrameDefinition.scratchTranslatorZ[index] = var11;
            lasIndex = i;
            index++;
            if(definition.framemap.types[i] == 5)
                definition.aBoolean985 = true;
        }
        if(data.currentPosition != originalLength)
            throw new RuntimeException();
        definition.translatorCount = index;
        definition.index_frame_ids = new int[index];
        definition.translator_x = new int[index];
        definition.translator_y = new int[index];
        definition.translator_z = new int[index];
        for(int i = 0; i < index; i++) {
            definition.index_frame_ids[i] = FrameDefinition.indexFrameIds[i];
            definition.translator_x[i] = FrameDefinition.scratchTranslatorX[i];
            definition.translator_y[i] = FrameDefinition.scratchTranslatorY[i];
            definition.translator_z[i] = FrameDefinition.scratchTranslatorZ[i];
        }

        return definition;
    }
}
