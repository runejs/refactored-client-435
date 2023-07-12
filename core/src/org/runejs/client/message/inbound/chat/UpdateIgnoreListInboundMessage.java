package org.runejs.client.message.inbound.chat;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to update the local player's ignore list.
 */
public class UpdateIgnoreListInboundMessage implements InboundMessage {
    public final long[] ignores;

    public UpdateIgnoreListInboundMessage(long[] ignores) {
        this.ignores = ignores;
    }
}
