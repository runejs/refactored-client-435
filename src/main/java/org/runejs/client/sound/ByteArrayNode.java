package org.runejs.client.sound;

import org.runejs.client.node.CachedNode;

public class ByteArrayNode extends CachedNode {
    public byte[] byteArray;
    public ByteArrayNode(byte[] arg0) {
        byteArray = arg0;
    }
}
