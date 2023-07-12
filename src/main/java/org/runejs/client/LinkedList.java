package org.runejs.client;

import org.runejs.client.node.Node;

public class LinkedList {

    /**
     * The last element in the LinkedList
     */
    public Node last = new Node();

    /**
     * The first element in the LinkedList
     */
    public Node first;

    public LinkedList() {
        last.previous = last;
        last.next = last;
    }

    public Node removeLast() {
        Node node = last.previous;

        if(node == last)
            return null;

        node.unlink();
        return node;
    }

    public Node peekLast() {
        Node node = last.previous;

        if(node == last) {
            first = null;
            return null;
        }

        first = node.previous;
        return node;
    }

    public Node peekFirst() {
        Node node = last.next;

        if(last == node) {
            first = null;
            return null;
        }

        first = node.next;
        return node;
    }

    /**
     * Appends a node to the end of the LinkedList
     */
    public void addLast(Node node) {
        if(node.previous != null)
            node.unlink();

        node.previous = last.previous;
        node.next = last;
        node.previous.next = node;
        node.next.previous = node;
    }

    /**
     * Adds a node at the start of the LinkedList
     */
    public void addFirst(Node node) {
        if(node.previous != null)
            node.unlink();

        node.previous = last;
        node.next = last.next;
        node.previous.next = node;
        node.next.previous = node;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    public void clear() {
        while (true) {
            Node next = last.next;

            if(next == last)
                return;

            next.unlink();
        }
    }

    /**
     * Retrieves and removes the first element of this list, or returns null if this list is empty.
     */
    public Node pollFirst() {
        Node node = first;

        if(node == last) {
            first = null;
            return null;
        }

        first = node.next;
        return node;
    }

    /**
     * Inserts a node before another node
     *
     * @param existingNode  The node before which `insertingNode` should be added
     * @param insertingNode The node to insert
     */
    public void addBefore(Node existingNode, Node insertingNode) {
        if(insertingNode.previous != null)
            insertingNode.unlink();

        if(true) {
            insertingNode.previous = existingNode.previous;
            insertingNode.next = existingNode;
            insertingNode.previous.next = insertingNode;
            insertingNode.next.previous = insertingNode;
        }
    }

    /**
     * Retrieves and removes the last element of this list, or returns null if this list is empty.
     */
    public Node pollLast() {
        Node node = first;

        if(node == last) {
            first = null;
            return null;
        }

        first = node.previous;
        return node;
    }

    /**
     * Removes and returns the first element from this list.
     */
    public Node removeFirst() {
        Node next = last.next;

        if(last == next)
            return null;

        next.unlink();
        return next;
    }
}
