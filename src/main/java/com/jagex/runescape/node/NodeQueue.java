package com.jagex.runescape.node;


public class NodeQueue {

    public CachedNode head = new CachedNode();

    public NodeQueue() {
        head.previousCachedNode = head;
        head.nextCachedNode = head;
    }

    public CachedNode pop() {
        CachedNode nextNode = this.head.nextCachedNode;
        if(nextNode == this.head) {
            return null;
        }
        nextNode.clear();
        return nextNode;
    }

    public void push(CachedNode cachedNode) {
        if(cachedNode.previousCachedNode != null) {
            cachedNode.clear();
        }
        cachedNode.nextCachedNode = head;
        cachedNode.previousCachedNode = head.previousCachedNode;
        cachedNode.previousCachedNode.nextCachedNode = cachedNode;
        cachedNode.nextCachedNode.previousCachedNode = cachedNode;
    }

    public CachedNode next() {
        CachedNode nextNode = head.nextCachedNode;
        if(nextNode == head) {
            return null;
        }
        return nextNode;
    }

    public void unshift(CachedNode cachedNode) {
        if(cachedNode.previousCachedNode != null) {
            cachedNode.clear();
        }
        cachedNode.nextCachedNode = head.nextCachedNode;
        cachedNode.previousCachedNode = head;
        cachedNode.previousCachedNode.nextCachedNode = cachedNode;
        cachedNode.nextCachedNode.previousCachedNode = cachedNode;
    }
}
