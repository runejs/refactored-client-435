package org.runejs.client.node;


public class HashTable {
    public long lastFetchedNodeKey;
    public int size;
    public Node lastFetchedNode;
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

    public Node getNode(long key) {
        lastFetchedNodeKey = key;
        Node node = nodes[(int) ((long) (size + -1) & key)];
        for(lastFetchedNode = node.next; node != lastFetchedNode; lastFetchedNode = lastFetchedNode.next) {
            if(lastFetchedNode.key == key) {
                Node foundNode = lastFetchedNode;
                lastFetchedNode = lastFetchedNode.next;
                return foundNode;
            }
        }
        lastFetchedNode = null;
        return null;
    }

    public Node getLastFetchedNode() {
        if(lastFetchedNode == null)
            return null;
        for(Node node = nodes[(int) (lastFetchedNodeKey & (long) (-1 + size))]; node != lastFetchedNode; lastFetchedNode = lastFetchedNode.next) {
            if(lastFetchedNodeKey == lastFetchedNode.key) {
                Node foundNode = lastFetchedNode;
                lastFetchedNode = lastFetchedNode.next;
                return foundNode;
            }
        }
        lastFetchedNode = null;
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
