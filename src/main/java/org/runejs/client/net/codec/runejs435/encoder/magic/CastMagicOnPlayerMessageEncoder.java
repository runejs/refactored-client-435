package org.runejs.client.net.codec.runejs435.encoder.magic;

import org.runejs.client.message.outbound.magic.CastMagicOnPlayerOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link CastMagicOnPlayerOutboundMessage}.
 */
public class CastMagicOnPlayerMessageEncoder implements MessageEncoder<CastMagicOnPlayerOutboundMessage> {
    @Override
    public PacketBuffer encode(CastMagicOnPlayerOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 221);

        buffer.putIntME1(message.spellId);
        buffer.putShortLE(message.playerId);

        return buffer;
    }
}
