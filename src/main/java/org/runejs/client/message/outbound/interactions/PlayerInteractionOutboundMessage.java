package org.runejs.client.message.outbound.interactions;

import org.runejs.client.message.OutboundMessage;

/**
 * Represents a message sent to the server when a player interacts with another player.
 * 
 * e.g. trading, following, attacking
 */
public class PlayerInteractionOutboundMessage implements OutboundMessage {
    /**
     * Which option on the player was clicked
     * 
     * i.e. 1 = first option, 2 = second option, etc.
     */
    public final int option;

    /**
     * The index of the player
     */
    public final int playerIndex;

    public PlayerInteractionOutboundMessage(int option, int playerIndex) {
        this.option = option;
        this.playerIndex = playerIndex;
    }
}
