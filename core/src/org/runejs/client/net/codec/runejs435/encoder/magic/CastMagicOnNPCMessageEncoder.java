package org.runejs.client.net.codec.runejs435.encoder.magic;

import org.runejs.client.message.outbound.magic.CastMagicOnNPCOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link CastMagicOnNPCOutboundMessage}.
 */
public class CastMagicOnNPCMessageEncoder implements MessageEncoder<CastMagicOnNPCOutboundMessage> {
    @Override
    public PacketBuffer encode(CastMagicOnNPCOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 253);

        buffer.putShortBE(message.npcId);
        buffer.putIntME1(message.spellId);

        return buffer;
    }
}
