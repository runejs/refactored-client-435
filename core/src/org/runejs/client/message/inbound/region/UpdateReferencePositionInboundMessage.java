package org.runejs.client.message.inbound.region;

import org.runejs.client.message.InboundMessage;

/**
 * An {@link InboundMessage} sent to update the reference position of the client.
 */
public class UpdateReferencePositionInboundMessage implements InboundMessage {
    /**
     * The new x coordinate of the reference position.
     */
    public final int x;

    /**
     * The new y coordinate of the reference position.
     */
    public final int y;

    /**
     * Creates a new {@link UpdateReferencePositionInboundMessage}.
     * @param x The new x coordinate of the reference position.
     * @param y The new y coordinate of the reference position.
     */
    public UpdateReferencePositionInboundMessage(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
