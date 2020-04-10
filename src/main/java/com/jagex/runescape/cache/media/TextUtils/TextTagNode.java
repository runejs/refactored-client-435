package com.jagex.runescape.cache.media.TextUtils;

import com.jagex.runescape.RSString;

public class TextTagNode {
    private TextTagNode previous = null;
    private TextTagNode next = null;
    private RSString tag;

    public TextTagNode(RSString tag) {
        this.tag = tag;
    }

    public void applyTo(RSString string) {
        string.add(tag);
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
