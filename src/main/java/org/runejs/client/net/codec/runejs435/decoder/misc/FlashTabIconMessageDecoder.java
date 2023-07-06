package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.FlashTabIconInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class FlashTabIconMessageDecoder implements MessageDecoder<FlashTabIconInboundMessage> {
    @Override
    public FlashTabIconInboundMessage decode(PacketBuffer buffer) {
        int tabId = buffer.getUnsignedByte();

        return new FlashTabIconInboundMessage(tabId);
    }
}
