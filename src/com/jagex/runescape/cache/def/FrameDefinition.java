package com.jagex.runescape.cache.def;

import com.jagex.runescape.io.Buffer;

public class FrameDefinition {
    public static int[] scratchTranslatorY = new int[500];
    public static int[] indexFrameIds = new int[500];
    public static int[] scratchTranslatorX = new int[500];
    public static int[] scratchTranslatorZ = new int[500];

    public int translatorCount;
    public int[] translator_x;
    public FramemapDefinition framemap;
    public int[] index_frame_ids;
    public boolean aBoolean985 = false;
    public int[] translator_z;
    public int[] translator_y;

    public FrameDefinition(byte[] b, FramemapDefinition framemap) {
        this.framemap = framemap;
        Buffer in = new Buffer(b);
        Buffer data = new Buffer(b);
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
            if(this.framemap.types[i] != 0) {
                for(int var10 = i - 1; var10 > lasIndex; var10--) {
                    if(this.framemap.types[var10] == 0) {
                        indexFrameIds[index] = var10;
                        scratchTranslatorX[index] = 0;
                        scratchTranslatorY[index] = 0;
                        scratchTranslatorZ[index] = 0;
                        index++;
                        break;
                    }
                }
            }
            indexFrameIds[index] = i;
            int var11 = 0;
            if(this.framemap.types[i] == 3)
                var11 = 128;
            if((var9 & 0x1) != 0)
                scratchTranslatorX[index] = data.getUnsignedSmart();
            else
                scratchTranslatorX[index] = var11;
            if((var9 & 0x2) != 0)
                scratchTranslatorY[index] = data.getUnsignedSmart();
            else
                scratchTranslatorY[index] = var11;
            if((var9 & 0x4) != 0)
                scratchTranslatorZ[index] = data.getUnsignedSmart();
            else
                scratchTranslatorZ[index] = var11;
            lasIndex = i;
            index++;
            if(this.framemap.types[i] == 5)
                aBoolean985 = true;
        }
        if(data.currentPosition != b.length)
            throw new RuntimeException();
        translatorCount = index;
        index_frame_ids = new int[index];
        translator_x = new int[index];
        translator_y = new int[index];
        translator_z = new int[index];
        for(int i = 0; i < index; i++) {
            index_frame_ids[i] = indexFrameIds[i];
            translator_x[i] = scratchTranslatorX[i];
            translator_y[i] = scratchTranslatorY[i];
            translator_z[i] = scratchTranslatorZ[i];
        }
    }

    public static void method881() {
        indexFrameIds = null;
        scratchTranslatorX = null;
        scratchTranslatorY = null;
        scratchTranslatorZ = null;
    }
}
