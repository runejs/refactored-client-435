package org.runejs.client.cache.def;

import org.runejs.client.io.Buffer;

// archive 0: anims
public class AnimationFrameDefinition {
    public static int[] scratchBases = new int[500];
    public static int[] scratchTranslatorX = new int[500];
    public static int[] scratchTranslatorY = new int[500];
    public static int[] scratchTranslatorZ = new int[500];

    public int translatorCount;
    public AnimationBaseDefinition animationBaseDefinition;
    public int[] baseIndexes;
    public int[] translatorX;
    public int[] translatorY;
    public int[] translatorZ;
    public boolean showing = false;

    // flat file of groups within archive 0 (anims)
    public AnimationFrameDefinition(byte[] b, AnimationBaseDefinition animationBaseDefinition) {
        this.animationBaseDefinition = animationBaseDefinition;
        Buffer opcodeReader = new Buffer(b);
        Buffer animReader = new Buffer(b);
        opcodeReader.currentPosition = 2;
        int length = opcodeReader.getUnsignedByte();
        int lastIndex = -1;
        int index = 0;
        animReader.currentPosition = opcodeReader.currentPosition + length;
        for(int i = 0; i < length; i++) {
            int opcode = opcodeReader.getUnsignedByte();
            if(opcode <= 0) {
                continue;
            }
            if(this.animationBaseDefinition.types[i] != 0) {
                for(int j = i - 1; j > lastIndex; j--) {
                    if(this.animationBaseDefinition.types[j] == 0) {
                        scratchBases[index] = j;
                        scratchTranslatorX[index] = 0;
                        scratchTranslatorY[index] = 0;
                        scratchTranslatorZ[index] = 0;
                        index++;
                        break;
                    }
                }
            }
            scratchBases[index] = i;
            int var11 = 0;
            if(this.animationBaseDefinition.types[i] == 3)
                var11 = 128;
            if((opcode & 0x1) != 0)
                scratchTranslatorX[index] = animReader.getUnsignedSmart();
            else
                scratchTranslatorX[index] = var11;
            if((opcode & 0x2) != 0)
                scratchTranslatorY[index] = animReader.getUnsignedSmart();
            else
                scratchTranslatorY[index] = var11;
            if((opcode & 0x4) != 0)
                scratchTranslatorZ[index] = animReader.getUnsignedSmart();
            else
                scratchTranslatorZ[index] = var11;
            lastIndex = i;
            index++;
            if(this.animationBaseDefinition.types[i] == 5)
                showing = true;
        }
        if(animReader.currentPosition != b.length)
            throw new RuntimeException();
        translatorCount = index;
        baseIndexes = new int[index];
        translatorX = new int[index];
        translatorY = new int[index];
        translatorZ = new int[index];
        for(int i = 0; i < index; i++) {
            baseIndexes[i] = scratchBases[i];
            translatorX[i] = scratchTranslatorX[i];
            translatorY[i] = scratchTranslatorY[i];
            translatorZ[i] = scratchTranslatorZ[i];
        }
    }

}
