package org.runejs.client.net.codec.runejs435.decoder.config;

import org.runejs.client.message.inbound.config.SetVarpValueInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes a packet sending a varp value as a byte.
 */
public class SetVarpIntMessageDecoder implements MessageDecoder<SetVarpValueInboundMessage> {
    @Override
    public SetVarpValueInboundMessage decode(PacketBuffer buffer) {
        int value = buffer.getIntBE();
        int index = buffer.getUnsignedShortBE();

        return new SetVarpValueInboundMessage(index, value);
    }
}
