package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.loading.CacheDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.VarPlayerDefinitionLoader;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class VarPlayerDefinition extends CachedNode implements CacheDefinition {
    public static DefinitionLoader<VarPlayerDefinition> loader = new VarPlayerDefinitionLoader();
    private static NodeCache varPlayerDefinitionCache = new NodeCache(64);
    private static CacheArchive gameDefinitionsCacheArchive;
    public static int varPlayerDefinitionsSize;
    public static int[] varpCache = new int[2000];
    public int type = 0;
    public int id;

    /**
     * An array of varPlayers. You can fetch a varp with a varpId to get the current value, i.e. varpValue = varPlayers[varpId]
     * @implNote If you want to fetch a varbit from this array, use VarbitDefinition.getVarbitValue().
     */
    public static int[] varPlayers = new int[2000]; // TODO find a better place for this, as it does not belong in the definition

    public static VarPlayerDefinition getDefinition(int id) {
        VarPlayerDefinition definition = (VarPlayerDefinition) varPlayerDefinitionCache.get(id);
        if (definition != null) {
            return definition;
        }
        byte[] data = gameDefinitionsCacheArchive.getFile(16, id);
        definition = new VarPlayerDefinition();
        definition.id = id;
        if(data != null) {
            loader.load(definition, new Buffer(data));
        }
        varPlayerDefinitionCache.put(id, definition);
        return definition;
    }

    public static void initializeVarPlayerDefinitionCache(CacheArchive cacheArchive) {
        gameDefinitionsCacheArchive = cacheArchive;
        varPlayerDefinitionsSize = gameDefinitionsCacheArchive.fileLength(16);
    }

    public static void clearVarPlayerDefinitionCache() {
        varPlayerDefinitionCache.clear();
    }

    @Override
    public int getId() { return this.id; }
}
