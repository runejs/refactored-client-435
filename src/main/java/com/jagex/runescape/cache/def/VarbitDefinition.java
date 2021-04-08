package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.node.CachedNode;

public class VarbitDefinition extends CachedNode {
    public static ProducingGraphicsBuffer gameScreenImageProducer;
    public static int anInt2359 = 0;
    public static int[] anIntArray2361 = new int[]{
            0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287,
            1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911,
            1073741823, 2147483647, -1
    };
    public static CacheArchive aCacheArchive_2364;
    public static int destinationX = 0;

    public int index;
    public int leastSignificantBit;
    public int mostSignificantBit;

    public static int method564(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        arg4 &= 0x3;
        if((arg5 & 0x1) == 1) {
            int i = arg3;
            arg3 = arg1;
            arg1 = i;
        }
        if(arg4 == 0) {
            return arg0;
        }
        if(arg4 == 1) {
            return 1 + -arg3 + 7 - arg2;
        }
        if(arg4 == 2) {
            return -arg1 + 1 + -arg0 + 7;
        }
        return arg2;
    }


    public static void method566(int arg0, boolean arg1, int arg2, byte[] arg3) {
        if(MovedStatics.aClass22_189 != null) {
            if(MouseHandler.anInt1450 >= 0) {
                arg2 -= 20;
                if(arg2 < 1) {
                    arg2 = 1;
                }
                RSCanvas.anInt54 = arg2;
                if(MouseHandler.anInt1450 == 0) {
                    Buffer.anInt1982 = 0;
                } else {
                    int i = Class29.method372(MouseHandler.anInt1450);
                    i -= Class39.anInt909;
                    Buffer.anInt1982 = (-1 + arg2 + 3600 + i) / arg2;
                }
                Player.aByteArray3270 = arg3;
                PacketBuffer.anInt2258 = arg0;
                PlayerAppearance.aBoolean687 = arg1;
            } else if(RSCanvas.anInt54 == 0) {
                RSString.method56(arg1, arg3, arg0);
            } else {
                PacketBuffer.anInt2258 = arg0;
                PlayerAppearance.aBoolean687 = arg1;
                Player.aByteArray3270 = arg3;
            }
        }
    }

    public void method562(Buffer arg1) {
        while(true) {
            int i = arg1.getUnsignedByte();
            if(i == 0) {
                break;
            }
            readValues(arg1, i);
        }
    }

    public void readValues(Buffer buffer, int arg2) {
        if(arg2 == 1) {
            index = buffer.getUnsignedShortBE();
            leastSignificantBit = buffer.getUnsignedByte();
            mostSignificantBit = buffer.getUnsignedByte();
        }
    }
}
