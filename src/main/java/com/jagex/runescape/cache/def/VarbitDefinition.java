package com.jagex.runescape.cache.def;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.util.BitUtils;

public class VarbitDefinition extends CachedNode {
    public static int[] varbitMasks = new int[32];
    public static NodeCache varbitDefinitionCache = new NodeCache(64);
    public static CacheArchive gameDefinitionsCacheArchive;

    // Pre-calculate varbit masks
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
        VarbitDefinition varbitDefinition = (VarbitDefinition) varbitDefinitionCache.get(varbitId);
        if (varbitDefinition != null)
            return varbitDefinition;
        byte[] cacheData = gameDefinitionsCacheArchive.getFile(14, varbitId);
        varbitDefinition = new VarbitDefinition();
        if (cacheData != null)
            varbitDefinition.readValues(new Buffer(cacheData));
        varbitDefinitionCache.put(varbitId, varbitDefinition);
        return varbitDefinition;
    }

    /**
     * Returns the varbit value from a varp, respecting the varbit MSB and LSB
     * @param varbitId The varbit ID to fetch the value for
     * @return the varbit value as currently stored in the client
     */
    public static int getVarbitValue(int varbitId) {
        VarbitDefinition varbitDefinition = getDefinition(varbitId);
        int varPlayerIndex = varbitDefinition.index;
        int mostSignificantBit = varbitDefinition.mostSignificantBit;
        int leastSignificantBit = varbitDefinition.leastSignificantBit;
        int mask = varbitMasks[mostSignificantBit - leastSignificantBit];
        return VarPlayerDefinition.varPlayers[varPlayerIndex] >> leastSignificantBit & mask;
    }

    public static void setVarbitValue(int value, int varbitId) {
        VarbitDefinition varbitDefinition = getDefinition(varbitId);
        int index = varbitDefinition.index;
        int leastSignificantBit = varbitDefinition.leastSignificantBit;
        int mostSignificantBit = varbitDefinition.mostSignificantBit;
        int mask = varbitMasks[mostSignificantBit + -leastSignificantBit];
        if (value < 0 || mask < value)
            value = 0;
        mask <<= leastSignificantBit;
        VarPlayerDefinition.varPlayers[index] = BitUtils.bitWiseOR(BitUtils.bitWiseAND(VarPlayerDefinition.varPlayers[index], mask ^ 0xffffffff), BitUtils.bitWiseAND(mask, value << leastSignificantBit));
    }

    public static void initializeVarbitDefinitionCache(CacheArchive cacheArchive) {
        gameDefinitionsCacheArchive = cacheArchive;

    }

    public static void clearVarbitDefinitionCache() {
        varbitDefinitionCache.clear();
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
