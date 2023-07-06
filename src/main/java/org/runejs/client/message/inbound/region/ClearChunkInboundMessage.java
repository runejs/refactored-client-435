package org.runejs.client.message.inbound.region;

import org.runejs.client.message.InboundMessage;

/**
 * An {@link InboundMessage} sent to clear a chunk.
 */
public class ClearChunkInboundMessage implements InboundMessage {
    /**
     * The chunk x offset.
     */
    public final int x;

    /**
     * The chunk y offset.
     */
    public final int y;

    /**
     * Creates a new {@link ClearChunkInboundMessage}.
     * @param x The chunk x offset.
     * @param y The chunk y offset.
     */
    public ClearChunkInboundMessage(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
