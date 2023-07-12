package org.runejs.client.message.inbound.world.object;

import org.runejs.client.message.InboundMessage;

public class RotateAnimateObjectInboundMessage implements InboundMessage {
    public final int x;

    public final int y;

    public final int type;

    /**
     * The new orientation to apply.
     */
    public final int orientation;

    /**
     * The animation id.
     */
    public final int animationId;

    public RotateAnimateObjectInboundMessage(int x, int y, int type, int orientation, int animationId) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.orientation = orientation;
        this.animationId = animationId;
    }
}
