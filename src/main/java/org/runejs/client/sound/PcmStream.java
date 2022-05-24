package org.runejs.client.sound;

import org.runejs.client.node.Node;

public abstract class PcmStream extends Node {
    public boolean active;
    public AbstractSound sound;

    public abstract void skip(int i);

    public abstract int fill(int[] is, int i, int i_0_);

    public int method845() {
        return 255;
    }
}
