package com.jagex.runescape.cache.media.TextUtils;


import com.jagex.runescape.RSString;

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

    public void applyAll(RSString resultText) {
        TextTagNode currentNode = head;
        while(currentNode != null){
            currentNode.applyTo(resultText);
            currentNode = head.getNext();
        }
    }

    public TextTagNode pop() {
        TextTagNode currentTail = this.tail;
        TextTagNode nextTail = this.tail.getPrevious();
        if(nextTail == null){
            this.head = nextTail;
        }
        this.tail = nextTail;
        return currentTail;
    }
}
