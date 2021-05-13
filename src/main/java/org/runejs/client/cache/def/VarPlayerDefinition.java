package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class VarPlayerDefinition extends CachedNode {
    public static NodeCache varPlayerDefinitionCache = new NodeCache(64);
    public static CacheArchive gameDefinitionsCacheArchive;
    public static int varPlayerDefinitionsSize;
    public int type = 0;

    /**
     * An array of varPlayers. You can fetch a varp with a varpId to get the current value, i.e. varpValue = varPlayers[varpId]
     * @implNote If you want to fetch a varbit from this array, use VarbitDefinition.getVarbitValue().
     */
    public static int[] varPlayers = new int[2000]; // TODO find a better place for this, as it does not belong in the definition

    public static VarPlayerDefinition getDefinition(int varPlayerIndex) {
        VarPlayerDefinition definition = (VarPlayerDefinition) varPlayerDefinitionCache.get(varPlayerIndex);
        if (definition != null) {
            return definition;
        }
        byte[] cacheData = gameDefinitionsCacheArchive.getFile(16, varPlayerIndex);
        definition = new VarPlayerDefinition();
        if(cacheData != null) {
            definition.readValues(new Buffer(cacheData));
        }
        varPlayerDefinitionCache.put(varPlayerIndex, definition);
        return definition;
    }

    public static void initializeVarPlayerDefinitionCache(CacheArchive cacheArchive) {
        gameDefinitionsCacheArchive = cacheArchive;
        varPlayerDefinitionsSize = gameDefinitionsCacheArchive.fileLength(16);
    }

    public static void clearVarPlayerDefinitionCache() {
        varPlayerDefinitionCache.clear();
    }

    public void readValues(Buffer buffer) {
        while(true) {
            int opcode = buffer.getUnsignedByte();
            if(opcode == 0)
                break;
            if(opcode == 5)
                type = buffer.getUnsignedShortBE();
        }
    }
}
