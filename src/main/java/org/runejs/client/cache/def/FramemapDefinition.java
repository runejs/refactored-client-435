package org.runejs.client.cache.def;

import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;

public class FramemapDefinition extends Node {
    public int[][] frameMaps;
    public int length;
    public int id;
    public int[] types;

    public FramemapDefinition(int id, byte[] data) {
        this.id = id;
        Buffer buffer = new Buffer(data);
        length = buffer.getUnsignedByte();
        types = new int[length];
        frameMaps = new int[length][];
        for(int i = 0; i < length; i++)
            types[i] = buffer.getUnsignedByte();
        for(int i = 0; length > i; i++)
            frameMaps[i] = new int[buffer.getUnsignedByte()];
        for(int i = 0; i < length; i++) {
            for(int i_38_ = 0; frameMaps[i].length > i_38_; i_38_++)
                frameMaps[i][i_38_] = buffer.getUnsignedByte();
        }

    }
}
