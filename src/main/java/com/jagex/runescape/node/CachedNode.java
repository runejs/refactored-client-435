package com.jagex.runescape.node;

public class SubNode extends Node {

    public SubNode node1;
    public SubNode node2;

    public void method539() {
        if(node2 != null) {
            node2.node1 = node1;
            node1.node2 = node2;
            node2 = null;
            node1 = null;
        }
    }

}
