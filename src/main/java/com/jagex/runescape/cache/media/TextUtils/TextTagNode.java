package com.jagex.runescape.cache.media.TextUtils;

public class TextTagNode {
    private TextTagNode previous = null;
    private TextTagNode next = null;
    private String tag;

    public TextTagNode(String tag) {
        this.tag = tag;
    }

    public String applyTo(String string) {
        return tag + string;
    }

    public void setNext(TextTagNode node) {
        this.next = node;
    }

    public TextTagNode getNext() {
        return this.next;
    }

    public TextTagNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(TextTagNode node) {
        this.previous = node;
    }
}
