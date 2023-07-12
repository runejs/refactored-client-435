package org.runejs.client.message.inbound.chat;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to indicate that a private message has been received.
 */
public class ReceivePrivateMessageInboundMessage implements InboundMessage {
    /**
     * The index of the player who sent the message.
     */
    public final long fromPlayerIndex;

    /**
     * The chat id modifier.
     */
    public final long chatIdModifier;

    /**
     * The private message counter.
     */
    public final long privateMessageCounter;

    /**
     * The rights of the player who sent the message.
     */
    public final int fromPlayerRights;

    /**
     * The private message text.
     */
    public final String privateMessage;

    /**
     * Constructs a new private message inbound message.
     * 
     * @param fromPlayerIndex The index of the player who sent the message.
     * @param chatIdModifier The chat id modifier.
     * @param privateMessageCounter The private message counter.
     * @param fromPlayerRights The rights of the player who sent the message.
     * @param privateMessage The private message.
     */
    public ReceivePrivateMessageInboundMessage(long chatIdModifier, long privateMessageCounter, long fromPlayerIndex, int fromPlayerRights, String privateMessage) {
        this.fromPlayerIndex = fromPlayerIndex;
        this.chatIdModifier = chatIdModifier;
        this.privateMessageCounter = privateMessageCounter;
        this.fromPlayerRights = fromPlayerRights;
        this.privateMessage = privateMessage;
    }
}
