package org.runejs.client.node;


public class NodeCache {

    public CachedNode cachedNode = new CachedNode();
    public int remaining;
    public int size;
    public HashTable hashTable;
    public NodeQueue nodeQueue = new NodeQueue();

    public NodeCache(int size) {
        this.size = size;
        int i;
        i = 1;
        while(i + i < size) {
            i += i;
        }
        remaining = size;

        hashTable = new HashTable(i);
    }


    public void put(long key, CachedNode node) {
        if(remaining == 0) { // no more space, make some room
            CachedNode cachedNode = nodeQueue.pop();
            cachedNode.unlink();
            cachedNode.clear();
            if(cachedNode == this.cachedNode) {
                cachedNode = nodeQueue.pop();
                cachedNode.unlink();
                cachedNode.clear();
            }
        } else {
            remaining--;
        }

        hashTable.put(key, node);
        nodeQueue.push(node);
    }

    public CachedNode get(long key) {
        CachedNode cachedNode = (CachedNode) hashTable.getNode(key);
        if(cachedNode != null)
            nodeQueue.push(cachedNode);
        return cachedNode;
    }

    public void remove(long key) {
        CachedNode cachedNode = (CachedNode) hashTable.getNode(key);
        if(cachedNode == null)
            return;
        cachedNode.unlink();
        cachedNode.clear();
        remaining++;
    }

    public void clear() {
        for(; ; ) {
            CachedNode cachedNode = nodeQueue.pop();
            if(cachedNode == null)
                break;
            cachedNode.unlink();
            cachedNode.clear();
        }
        remaining = size;
    }
}
