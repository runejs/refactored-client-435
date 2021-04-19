package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.node.CachedNode;

public class VarPlayerConfig extends CachedNode {
    public static int anInt2621 = 0;
    public static volatile int eventClickY = 0;
    public static int anInt2628 = 0;
    public static volatile boolean clearScreen = true;

    public int type = 0;

    public void decodeVarPlayerConfig(Buffer buffer) {
        for(; ; ) {
            int i = buffer.getUnsignedByte();
            if(i == 0)
                break;
            if(i == 5)
                type = buffer.getUnsignedShortBE();
        }
    }
}
