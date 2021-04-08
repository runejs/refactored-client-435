package com.jagex.runescape.cache.media.textUtils;

public class TextColourNode {
    private final int colour;
    private TextColourNode previous = null;
    private TextColourNode next = null;

    public TextColourNode(int colour) {
        this.colour = colour;
    }

    public int getColour() {
        return colour;
    }

    public TextColourNode getNext() {
        return this.next;
    }

    public void setNext(TextColourNode node) {
        this.next = node;
    }

    public TextColourNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(TextColourNode node) {
        this.previous = node;
    }
}
