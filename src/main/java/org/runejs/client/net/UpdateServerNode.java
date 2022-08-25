package org.runejs.client.net;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.node.CachedNode;


public class UpdateServerNode extends CachedNode {

    public CacheArchive cacheArchive;
    public byte versionSize;
    public int crc;

}
