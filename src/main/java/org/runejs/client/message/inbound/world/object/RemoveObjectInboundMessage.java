package org.runejs.client.message.inbound.world.object;

import org.runejs.client.message.InboundMessage;

public class RemoveObjectInboundMessage implements InboundMessage {
    public final int x;

    public final int y;

    public final int type;

    public final int orientation;

    public RemoveObjectInboundMessage(int x, int y, int type, int orientation) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.orientation = orientation;
    }
}
