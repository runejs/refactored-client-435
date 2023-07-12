package org.runejs.client.message.inbound.chat;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to indicate that a friend has logged in,
 * changed world, or logged out.
 */
public class FriendChangedWorldInboundMessage implements InboundMessage {
    /**
     * The username of the recipient.
     */
    public final long username;

    /**
     * The world ID, or 0 if the player is offline.
     */
    public final int worldId;

    /**
     * Constructs a new private message inbound message.
     * 
     * @param username The username of the recipient.
     * @param worldId The world ID, or 0 if the player is offline.
     */
    public FriendChangedWorldInboundMessage(long username, int worldId) {
        this.username = username;
        this.worldId = worldId;
    }
}
