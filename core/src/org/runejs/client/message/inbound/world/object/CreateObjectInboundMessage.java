package org.runejs.client.message.inbound.world.object;

import org.runejs.client.message.InboundMessage;

public class CreateObjectInboundMessage implements InboundMessage {
    public final int x;

    public final int y;

    public final int id;

    public final int type;

    public final int orientation;

    public CreateObjectInboundMessage(int x, int y, int id, int type, int orientation) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.orientation = orientation;
    }
}
