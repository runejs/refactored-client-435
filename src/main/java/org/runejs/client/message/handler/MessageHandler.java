package org.runejs.client.message.handler;

import org.runejs.client.message.InboundMessage;

/**
 * A message handler is responsible for handling a specific type of message.
 * 
 * @param <TMessage> The type of message to handle.
 */
public interface MessageHandler<TMessage extends InboundMessage> {
    /**
     * Handles the message, i.e. applies the message to the game state.
     */
    void handle(TMessage message);
}
