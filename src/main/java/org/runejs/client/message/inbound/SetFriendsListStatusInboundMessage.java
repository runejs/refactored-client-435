package org.runejs.client.message.inbound;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to update the status
 * of the connection to the friends server.
 */
public class SetFriendsListStatusInboundMessage implements InboundMessage {
    /**
     * The status of the connection to the friends server.
     */
    public final int friendListStatus;

    /**
     * Constructs a new SetFriendsListStatusInboundMessage
     * 
     * @param friendListStatus The status of the connection to the friends server.
     */
    public SetFriendsListStatusInboundMessage(int friendListStatus) {
        this.friendListStatus = friendListStatus;
    }
}
