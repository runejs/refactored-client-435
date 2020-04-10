package com.jagex.runescape.cache.media.TextUtils;

public class TextColourNode {
    private TextColourNode previous = null;
    private TextColourNode next = null;
    private int colour;

    public TextColourNode(int colour) {
        this.colour = colour;
    }

    public int getColour() {
        return colour;
    }

    public void setNext(TextColourNode node) {
        this.next = node;
    }

    public TextColourNode getNext() {
        return this.next;
    }

    public TextColourNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(TextColourNode node) {
        this.previous = node;
    }
}
