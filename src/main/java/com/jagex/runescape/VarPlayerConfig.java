package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.node.CachedNode;

public class VarPlayerConfig extends CachedNode {
    public int type = 0;

    public void decodeVarPlayerConfig(Buffer buffer) {
        for(; ; ) {
            int opcode = buffer.getUnsignedByte();
            if(opcode == 0)
                break;
            if(opcode == 5)
                type = buffer.getUnsignedShortBE();
        }
    }
}
