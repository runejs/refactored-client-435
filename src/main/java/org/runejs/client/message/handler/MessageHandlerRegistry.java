package org.runejs.client.message.handler;

import org.runejs.client.message.InboundMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * Observers told about every message just before its handler applies it to the client's state.
     */
    private final List<InboundMessageListener> listeners = new ArrayList<>();

    /**
     * Something that wants to see every inbound message as it is handled, without changing what happens to it.
     */
    public interface InboundMessageListener {
        void onMessage(InboundMessage message);
    }

    public void addListener(InboundMessageListener listener) {
        listeners.add(listener);
    }

    public void removeListener(InboundMessageListener listener) {
        listeners.remove(listener);
    }

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
        final MessageHandler<TMessage> handler = (MessageHandler<TMessage>) handlers.get(messageClass);
        if (handler == null || listeners.isEmpty()) {
            return handler;
        }

        return new MessageHandler<TMessage>() {
            @Override
            public void handle(TMessage message) {
                for (InboundMessageListener listener : listeners) {
                    listener.onMessage(message);
                }
                handler.handle(message);
            }
        };
    }
}
