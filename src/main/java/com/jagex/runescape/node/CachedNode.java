package com.jagex.runescape.node;

public class CachedNode extends Node {

    public CachedNode nextCachedNode;
    public CachedNode previousCachedNode;

    public void clear() {
        if(previousCachedNode != null) {
            previousCachedNode.nextCachedNode = nextCachedNode;
            nextCachedNode.previousCachedNode = previousCachedNode;
            previousCachedNode = null;
            nextCachedNode = null;
        }
    }

}
