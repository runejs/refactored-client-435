package org.runejs.client.cache.def.loading;

import org.runejs.client.io.Buffer;

public interface DefinitionLoader<TDefinition extends CacheDefinition> {
    TDefinition load(TDefinition definition, Buffer data);
}
