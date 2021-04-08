package com.jagex.runescape.node;


public class HashTable {

    public long aLong550;
    public int size;
    public Node aClass40_566;
    public Node aClass40_574;
    public Node[] nodes;
    public int anInt572 = 0;

    public HashTable(int size) {
        this.size = size;
        nodes = new Node[size];

        for(int i = 0; size > i; i++) {
            Node node = nodes[i] = new Node();
            node.next = node;
            node.previous = node;
        }
    }

    public Node method329() {
        anInt572 = 0;
        return method336();
    }

    public void put(long key, Node node) {
        if(node.previous != null) {
            node.remove();
        }
        Node node1 = nodes[(int) ((long) (-1 + size) & key)];
        node.next = node1;
        node.key = key;
        node.previous = node1.previous;
        node.previous.next = node;
        node.next.previous = node;
    }

    public Node method331(long key) {
        aLong550 = key;
        Node class40 = nodes[(int) ((long) (size + -1) & key)];
        for(aClass40_566 = class40.next; class40 != aClass40_566; aClass40_566 = aClass40_566.next) {
            if(aClass40_566.key == key) {
                Node class40_0_ = aClass40_566;
                aClass40_566 = aClass40_566.next;
                return class40_0_;
            }
        }
        aClass40_566 = null;
        return null;
    }

    public Node method333() {
        if(aClass40_566 == null) {
            return null;
        }
        for(
                Node node = nodes[(int) (aLong550 & (long) (-1 + size))]; node != aClass40_566;
                aClass40_566 = aClass40_566.next
        ) {
            if(aLong550 == aClass40_566.key) {
                Node class40_1_ = aClass40_566;
                aClass40_566 = aClass40_566.next;
                return class40_1_;
            }
        }
        aClass40_566 = null;
        return null;
    }

    public Node method336() {
        if(anInt572 > 0 && aClass40_574 != nodes[anInt572 - 1]) {
            Node node = aClass40_574;
            aClass40_574 = node.next;
            return node;
        }
        while(size > anInt572) {
            Node class40 = nodes[anInt572++].next;
            if(class40 != nodes[anInt572 - 1]) {
                aClass40_574 = class40.next;
                return class40;
            }
        }
        return null;
    }
}
