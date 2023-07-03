package org.runejs.client.message.outbound.chat;

import org.runejs.client.chat.*;
import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server when the player sends a chat message.
 */
public class SendChatMessageOutboundMessage implements OutboundMessage {
    /**
     * The color effect of the message, e.g. "red" or "flash1"
     */
    public final ChatColorEffect chatColorEffect;

    /**
     * The shape effect of the message, e.g. "scroll" or "wave"
     */
    public final ChatShapeEffect chatShapeEffect;
    
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
    public SendChatMessageOutboundMessage(ChatColorEffect chatColorEffect, ChatShapeEffect chatShapeEffect, String message) {
        this.chatColorEffect = chatColorEffect;
        this.chatShapeEffect = chatShapeEffect;
        this.message = message;
    }
}
