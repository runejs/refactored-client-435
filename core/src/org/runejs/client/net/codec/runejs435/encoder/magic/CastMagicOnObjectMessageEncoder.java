package org.runejs.client.net.codec.runejs435.encoder.magic;

import org.runejs.client.message.outbound.magic.CastMagicOnObjectOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link CastMagicOnObjectOutboundMessage}.
 */
public class CastMagicOnObjectMessageEncoder implements MessageEncoder<CastMagicOnObjectOutboundMessage> {
    @Override
    public PacketBuffer encode(CastMagicOnObjectOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(10, 225);

        buffer.putShortBE(message.objectId);
        buffer.putShortLE(message.y);
        buffer.putIntME1(message.spellId);
        buffer.putShortLE(message.x);

        return buffer;
    }
}
