package com.jagex.runescape.cache.def;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.node.NodeCache;

public class VarPlayerDefinition extends CachedNode {
    public static NodeCache varPlayerDefinitionCache = new NodeCache(64);
    public static CacheArchive gameDefinitionsCacheArchive;
    public static int varPlayerDefinitionsSize;
    public int type = 0;

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
