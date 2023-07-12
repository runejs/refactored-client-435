package org.runejs.client.net.codec;

import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.OutboundMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Based on `Release.java` from `Apollo`
 *
 * Copyright (c) 2010-2011 Graham Edgecombe
 * Copyright (c) 2011-2016 Major <major.emrs@gmail.com> and other apollo contributors
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

/**
 * A {@link MessagePacketCodec} is a class which manages the encoding and decoding of messages to and from packets.
 */
public class MessagePacketCodec {
    private int[] packetLengths;

    /**
     * The array of message decoders.
     */
    private final MessageDecoder<?>[] decoders = new MessageDecoder<?>[256];

	/**
	 * The map of message classes to message encoders.
	 */
	private final Map<Class<? extends OutboundMessage>, MessageEncoder<?>> encoders = new HashMap<>();

    /**
     * Creates a new {@link MessagePacketCodec} with the specified packet sizes.
     */
    public MessagePacketCodec(int[] packetLengths) {
        this.packetLengths = packetLengths;
    }

    /**
     * Gets the packet length for the specified opcode.
     */
    public int getPacketLength(int opcode) {
        return this.packetLengths[opcode];
    }


    /**
     * Gets the {@link MessageEncoder} for the specified message type.
     *
     * @param type The type of message.
     * @return The message encoder.
     */
    @SuppressWarnings("unchecked")
    public <TMessage extends OutboundMessage> MessageEncoder<TMessage> getMessageEncoder(Class<TMessage> type) {
        return (MessageEncoder<TMessage>) encoders.get(type);
    }

    /**
     * Gets the {@link MessageDecoder} for the specified opcode.
     *
     * @param opcode The opcode.
     * @return The message decoder.
     * @throws IndexOutOfBoundsException If the opcode is less than 0, or greater than 255.
     */
    public MessageDecoder<?> getMessageDecoder(int opcode) {
        if (opcode >= decoders.length) {
            throw new IndexOutOfBoundsException("Opcode out of bounds");
        }

        return decoders[opcode];
    }

    /**
     * Registers a {@link MessageEncoder} for the specified message type.
     * 
     * @param messageType The message type.
     * @param encoder The message encoder.
     */
    public <M extends OutboundMessage> void register(Class<M> messageType, MessageEncoder<M> encoder) {
        encoders.put(messageType, encoder);
    }

    /**
     * Registers a {@link MessageDecoder} for the specified opcode.
     *
     * @param opcode The opcode, between 0 and 255 inclusive.
     * @param decoder The message decoder.
     * @throws IndexOutOfBoundsException If the opcode is less than 0, or greater than 255.
     */
    public <M extends InboundMessage> void register(int opcode, MessageDecoder<M> decoder) {
        if (opcode >= decoders.length) {
            throw new IndexOutOfBoundsException("Opcode out of bounds");
        }

        decoders[opcode] = decoder;
    }
}
