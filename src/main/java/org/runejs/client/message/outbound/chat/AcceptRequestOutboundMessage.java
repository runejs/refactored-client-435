package org.runejs.client.message.outbound.chat;

import org.runejs.client.message.OutboundMessage;

/**
 * An {@link OutboundMessage} sent to the server to accept a trade or challenge request.
 */
public class AcceptRequestOutboundMessage implements OutboundMessage {
    public enum RequestType {
        /**
         * A default request type used for defensive programming.
         */
        INVALID,
        /**
         * A trade request.
         */
        TRADE,
        /**
         * A challenge/duel request.
         */
        CHALLENGE
    }

    /**
     * The type of request being accepted.
     */
    public final RequestType type;

    /**
     * The player id of the player who sent the request.
     */
    public final int playerId;

    /**
     * Creates a new {@link AcceptRequestOutboundMessage}.
     * @param type The type of request being accepted.
     * @param playerId The player id of the player who sent the request.
     */
    public AcceptRequestOutboundMessage(RequestType type, int playerId) {
        this.type = type;
        this.playerId = playerId;
    }
}
