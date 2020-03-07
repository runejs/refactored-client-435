package com.jagex.runescape.cache.media.TextUtils;


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
        }
       this.tail = node;
    }
}
