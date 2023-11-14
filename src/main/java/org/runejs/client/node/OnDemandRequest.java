package org.runejs.client.node;

import org.runejs.client.OnDemandRequestProcessor;
import org.runejs.client.cache.CacheIndex;
import org.runejs.client.cache.CacheArchive;

public class OnDemandRequest extends Node {
    /**
     * 0 = load from byte array data
     * 1 = load from CacheArchive cacheArchive
     */
    public int type;

    public byte[] data;
    public CacheArchive cacheArchive;
    public CacheIndex cacheIndex;

    public static void createByteArrayOnDemandRequest(byte[] data, CacheIndex cacheIndex, int cacheIndexId) {
        OnDemandRequest onDemandRequest = new OnDemandRequest();
        onDemandRequest.type = 0;
        onDemandRequest.key = cacheIndexId;
        onDemandRequest.cacheIndex = cacheIndex;
        onDemandRequest.data = data;
        synchronized(OnDemandRequestProcessor.aLinkedList_53) {
            OnDemandRequestProcessor.aLinkedList_53.addLast(onDemandRequest);
        }
        OnDemandRequestProcessor.create(600);
    }

    public static void createCacheArchiveOnDemandRequest(int key, CacheArchive archive, CacheIndex index) {
        OnDemandRequest onDemandRequest = new OnDemandRequest();
        onDemandRequest.type = 1;
        onDemandRequest.key = (long) key;
        onDemandRequest.cacheIndex = index;
        onDemandRequest.cacheArchive = archive;
        synchronized(OnDemandRequestProcessor.aLinkedList_53) {
            OnDemandRequestProcessor.aLinkedList_53.addLast(onDemandRequest);
        }
        OnDemandRequestProcessor.create(600);
    }
}
