package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;
import org.runejs.client.util.BitUtils;

public class VarbitDefinition extends CachedNode {
    public static NodeCache varbitDefinitionCache = new NodeCache(64);
    public static CacheArchive gameDefinitionsCacheArchive;

    /**
     * Contains information on the bit mask to use per specified bits.
     * Example:
     *      We want to have a mask of 6 bits, which would look like this: 00111111 (decimal: 63)
     *      Since this array starts from index 0, the 6th index is varbitMasks[5].
     *      So varbitMasks[5] == 63 == 00111111
     *      The mask can then be used together with "varPlayerValue >> LSB" to find the actual varbit value.
     */
    public static int[] varbitMasks = new int[32];
    static {
        int currentBitAsDecimal = 2;
        for(int currentBitPosition = 0; currentBitPosition < 32; currentBitPosition++) {
            varbitMasks[currentBitPosition] = currentBitAsDecimal - 1;
            currentBitAsDecimal += currentBitAsDecimal;
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
