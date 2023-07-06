package org.runejs.client.net.codec.runejs435.encoder.examine;

import org.runejs.client.message.outbound.examine.ExamineNPCOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes a {@link ExamineNPCOutboundMessage} into a {@link PacketBuffer}.
 */
public class ExamineNPCMessageEncoder implements MessageEncoder<ExamineNPCOutboundMessage> {
    @Override
    public PacketBuffer encode(ExamineNPCOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 247);

        buffer.putShortLE(message.npcId);

        return buffer;
    }
}
