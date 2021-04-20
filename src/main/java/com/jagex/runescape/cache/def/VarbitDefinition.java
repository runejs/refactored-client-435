package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.scene.GroundItemTile;

public class VarbitDefinition extends CachedNode {
    public static ProducingGraphicsBuffer gameScreenImageProducer;
    public static int anInt2359 = 0;
    public static int[] anIntArray2361 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647, -1};
    public static CacheArchive aCacheArchive_2364;
    public static int destinationX = 0;
    public static int[] varbitMasks = new int[32];

    static {
        int i = 2;
        for(int i_7_ = 0; i_7_ < 32; i_7_++) {
            varbitMasks[i_7_] = -1 + i;
            i += i;
        }
    }

    public int index;
    public int leastSignificantBit;
    public int mostSignificantBit;

    public static VarbitDefinition getDefinition(int varbitId) {
        VarbitDefinition varbitDefinition = (VarbitDefinition) Class57.varbitDefinitionCache.get(varbitId);
        if (varbitDefinition != null)
            return varbitDefinition;
        byte[] is = RSCanvas.aCacheArchive_61.getFile(14, varbitId);
        varbitDefinition = new VarbitDefinition();
        if (is != null)
            varbitDefinition.readValues(new Buffer(is));
        Class57.varbitDefinitionCache.put(varbitId, varbitDefinition);
        return varbitDefinition;
    }

    /**
     * Returns the varbit value from a varPlayer, respecting the varbit MSB and LSB
     * @param varbitId The varbit ID to fetch the value for
     * @return the varbit value as currently stored in the client
     */
    public static int getVarbitValue(int varbitId) {
        VarbitDefinition varbitDefinition = getDefinition(varbitId);
        int varPlayerIndex = varbitDefinition.index;
        int mostSignificantBit = varbitDefinition.mostSignificantBit;
        int leastSignificantBit = varbitDefinition.leastSignificantBit;
        int mask = varbitMasks[mostSignificantBit - leastSignificantBit];
        return GroundItemTile.varPlayers[varPlayerIndex] >> leastSignificantBit & mask;
    }

    public void readValues(Buffer buffer) {
        while(true) {
            int opCode = buffer.getUnsignedByte();
            if(opCode == 0)
                break;
            if(opCode == 1) {
                index = buffer.getUnsignedShortBE();
                leastSignificantBit = buffer.getUnsignedByte();
                mostSignificantBit = buffer.getUnsignedByte();
            }
        }
    }


}
