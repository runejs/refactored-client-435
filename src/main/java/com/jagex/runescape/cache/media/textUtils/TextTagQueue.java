package com.jagex.runescape.cache.media.textUtils;


public class TextTagQueue {
    private TextTagNode head;
    private TextTagNode tail;
    private int size = 0;

    public TextTagNode peek() {
        return this.tail;
    }

    public boolean isEmpty() {
        return 0 == size;
    }


    public void push(TextTagNode node) {
        if(this.tail == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
        }
        this.tail = node;
    }

    public String applyAll(String targetText) {
        TextTagNode currentNode = head;
        while(currentNode != null) {
            targetText = currentNode.applyTo(targetText);
            currentNode = head.getNext();
        }
        return targetText;
    }

    public TextTagNode pop() {
        TextTagNode currentTail = this.tail;
        TextTagNode nextTail = this.tail.getPrevious();
        if(nextTail == null) {
            this.head = nextTail;
        }
        this.tail = nextTail;
        return currentTail;
    }
}
