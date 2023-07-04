package org.runejs.client.net.codec.runejs435.encoder.magic;

import org.runejs.client.message.outbound.magic.CastMagicOnWorldItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link CastMagicOnWorldItemOutboundMessage}.
 */
public class CastMagicOnWorldItemMessageEncoder implements MessageEncoder<CastMagicOnWorldItemOutboundMessage> {
    @Override
    public PacketBuffer encode(CastMagicOnWorldItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(10, 168);

        buffer.putShortLE(message.itemId);
        buffer.putShortBE(message.x);
        buffer.putIntME1(message.spellId);
        buffer.putShortBE(message.y);

        return buffer;
    }
}
