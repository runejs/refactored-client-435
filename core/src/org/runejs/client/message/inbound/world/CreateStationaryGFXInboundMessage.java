package org.runejs.client.message.inbound.world;

import org.runejs.client.message.InboundMessage;

/**
 * Creates a stationary gfx in the world.
 */
public class CreateStationaryGFXInboundMessage implements InboundMessage {
    public final int id;
    public final int x;
    public final int y;
    public final int drawHeight;
    public final int delay;

    public CreateStationaryGFXInboundMessage(int id, int x, int y, int drawHeight, int delay) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.drawHeight = drawHeight;
        this.delay = delay;
    }
}
