package org.runejs.client.net.codec.runejs435.encoder.examine;

import org.runejs.client.message.outbound.examine.ExamineItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes a {@link ExamineItemOutboundMessage} into a {@link PacketBuffer}.
 */
public class ExamineItemMessageEncoder implements MessageEncoder<ExamineItemOutboundMessage> {
    @Override
    public PacketBuffer encode(ExamineItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 151);

        buffer.putShortLE(message.itemId);

        return buffer;
    }
}
