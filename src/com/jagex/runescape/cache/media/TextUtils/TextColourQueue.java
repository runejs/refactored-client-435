package com.jagex.runescape.cache.media.TextUtils;


import com.jagex.runescape.RSString;

public class TextColourQueue {
    private final int defaultColour;
    private TextColourNode head;
    private TextColourNode tail;
    private int size = 0;

    public TextColourQueue(int defaultColour) {
        this.defaultColour = defaultColour;
    }

    public TextColourNode peek() {
        return this.tail;
    }

    public boolean isEmpty() {
        return 0 == size;
    }


    public void push(TextColourNode node) {
        if(this.tail == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
        }
       this.tail = node;
    }

    public int getColour() {
        if(this.tail != null){
            return this.tail.getColour();
        }
        return this.defaultColour;
    }

    public TextColourNode pop() {
        TextColourNode currentTail = this.tail;
        TextColourNode nextTail = this.tail.getPrevious();
        if(nextTail == null){
            this.head = nextTail;
        }
        this.tail = nextTail;
        return currentTail;
    }
}
