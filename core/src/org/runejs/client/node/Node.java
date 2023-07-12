package org.runejs.client.node;

public class Node {

    public long key;
    public Node next;
    public Node previous;

    public boolean hasPrevious() {
        return previous != null;
    }

    public void unlink() {
        if(previous != null) {
            previous.next = next;
            next.previous = previous;
            previous = null;
            next = null;
        }
    }
}
