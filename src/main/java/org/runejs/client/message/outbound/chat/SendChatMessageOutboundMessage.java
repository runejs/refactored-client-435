package org.runejs.client.message.outbound.chat;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server when the player sends a chat message.
 */
public class SendChatMessageOutboundMessage implements OutboundMessage {
    /**
     * The color effect of the message, e.g. "red" or "flash1"
     * 
     * TODO (Jameskmonger) could use an enum here
     */
    public final int chatColorEffect;

    /**
     * The shape effect of the message, e.g. "scroll" or "wave"
     * 
     * TODO (Jameskmonger) could use an enum here
     */
    public final int chatShapeEffect;
    
    /**
     * The message to send
     */
    public final String message;

    /**
     * Creates a new chat message to send to the server
     * 
     * @param chatColorEffect The color effect for the message
     * @param chatShapeEffect The shape effect for the message
     * @param message The message to send
     */
    public SendChatMessageOutboundMessage(int chatColorEffect, int chatShapeEffect, String message) {
        this.chatColorEffect = chatColorEffect;
        this.chatShapeEffect = chatShapeEffect;
        this.message = message;
    }
}
