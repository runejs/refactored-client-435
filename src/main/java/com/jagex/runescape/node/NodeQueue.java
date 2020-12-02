package com.jagex.runescape.node;


public class Class27 {

    public CachedNode cachedNode = new CachedNode();

    public Class27() {
        cachedNode.previousCachedNode = cachedNode;
        cachedNode.nextCachedNode = cachedNode;
    }

    public CachedNode method351() {
        CachedNode cachedNode = this.cachedNode.nextCachedNode;
        if(cachedNode == this.cachedNode) {
            return null;
        }
        cachedNode.clear();
        return cachedNode;
    }

    public void method352(CachedNode arg1) {
        if(arg1.previousCachedNode != null) {
            arg1.clear();
        }
        arg1.nextCachedNode = cachedNode;
        arg1.previousCachedNode = cachedNode.previousCachedNode;
        arg1.previousCachedNode.nextCachedNode = arg1;
        arg1.nextCachedNode.previousCachedNode = arg1;
    }

    public CachedNode method362() {
        CachedNode class40_sub5 = cachedNode.nextCachedNode;
        if(class40_sub5 == cachedNode) {
            return null;
        }
        return class40_sub5;
    }

    public void method367(CachedNode arg1) {
        if(arg1.previousCachedNode != null) {
            arg1.clear();
        }
        arg1.nextCachedNode = cachedNode.nextCachedNode;
        arg1.previousCachedNode = cachedNode;
        arg1.previousCachedNode.nextCachedNode = arg1;
        arg1.nextCachedNode.previousCachedNode = arg1;
    }
}
