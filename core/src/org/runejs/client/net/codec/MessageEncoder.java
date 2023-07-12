package org.runejs.client.net.codec;

import org.runejs.client.net.PacketBuffer;
import org.runejs.client.message.OutboundMessage;

/**
 * A message decoder is responsible for encoding a specific type of message.
 * 
 * It constructs a PacketBuffer from an OutboundMessage.
 * 
 * @see org.runejs.client.message.OutboundMessage
 * 
 * @param <TMessage> The type of message to encode.
 */
public interface MessageEncoder<TMessage extends OutboundMessage> {
    /**
     * Creates a PacketBuffer from the given TMessage.
     * 
     * @param message The TMessage to encode.
     * 
     * @return The encoded PacketBuffer.
     */
    PacketBuffer encode(TMessage message);
}
