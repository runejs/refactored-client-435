package com.jagex.runescape.cache.media.textUtils;

public class TextTagNode {
    public String tag;
    private TextTagNode previous = null;
    private TextTagNode next = null;

    public TextTagNode(String tag) {
        this.tag = tag;
    }

    public String applyTo(String string) {
        return tag + string;
    }

    public TextTagNode getNext() {
        return this.next;
    }

    public void setNext(TextTagNode node) {
        this.next = node;
    }

    public TextTagNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(TextTagNode node) {
        this.previous = node;
    }
}
