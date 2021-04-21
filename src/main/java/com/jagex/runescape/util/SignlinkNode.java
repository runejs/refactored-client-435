package com.jagex.runescape.util;

public class SignlinkNode {
    public int integerData;
    public int type;

    /**
     * 0 = Not initialized
     * 1 = Initialized
     * 2 = Errored
     */
    public volatile int status = 0;

    public Object objectData;
    public SignlinkNode prev;
    public volatile Object value;
}
