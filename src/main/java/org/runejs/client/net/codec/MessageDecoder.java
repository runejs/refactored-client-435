package org.runejs.client.net.codec;

import org.runejs.client.net.PacketBuffer;
import org.runejs.client.message.InboundMessage;

/**
 * A message decoder is responsible for decoding a specific type of message.
 * 
 * It takes a PacketBuffer and reads data from it to construct a message.
 * 
 * @see org.runejs.client.message.InboundMessage
 * 
 * @param <TMessage> The type of message to decode.
 */
public interface MessageDecoder<TMessage extends InboundMessage> {
    /**
     * Decodes a message from the given PacketBuffer.
     * 
     * @param buffer The PacketBuffer to read from.
     * 
     * @return The decoded TMessage.
     */
    TMessage decode(PacketBuffer buffer);
}
