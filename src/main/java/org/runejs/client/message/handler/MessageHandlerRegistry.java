package org.runejs.client.message.handler;

import org.runejs.client.message.InboundMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * A registry of message handlers, containing a mapping of message class to handler.
 * 
 * Used to look up the appropriate handler for a given message.
 */
public class MessageHandlerRegistry {
    /**
     * A mapping of message class to handler.
     */
    private final Map<Class<? extends InboundMessage>, MessageHandler<? extends InboundMessage>> handlers = new HashMap<>();

    /**
     * Registers a message handler for a given message class.
     * 
     * Usage: {@code register(UpdatePlayerMessage.class, new UpdatePlayerMessageHandler());}
     * 
     * @param messageClass The message class.
     * @param handler The message handler.
     * @param <TMessage> The message type.
     */
    public <TMessage extends InboundMessage> void register(Class<TMessage> messageClass, MessageHandler<TMessage> handler) {
        this.handlers.put(messageClass, handler);
    }

    /**
     * Gets the message handler for a given message class.
     * 
     * Usage: {@code MessageHandler<UpdatePlayerMessage> handler = getMessageHandler(UpdatePlayerMessage.class);}
     * 
     * @param messageClass The message class.
     * @param <TMessage> The message type.
     * @return The message handler.
     */
    public <TMessage extends InboundMessage> MessageHandler<TMessage> getMessageHandler(Class<TMessage> messageClass) {
        return (MessageHandler<TMessage>) handlers.get(messageClass);
    }
}
