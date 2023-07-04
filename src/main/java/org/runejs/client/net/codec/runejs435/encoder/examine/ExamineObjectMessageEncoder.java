package org.runejs.client.net.codec.runejs435.encoder.examine;

import org.runejs.client.message.outbound.examine.ExamineObjectOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes a {@link ExamineObjectOutboundMessage} into a {@link PacketBuffer}.
 */
public class ExamineObjectMessageEncoder implements MessageEncoder<ExamineObjectOutboundMessage> {
    @Override
    public PacketBuffer encode(ExamineObjectOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 148);

        buffer.putShortLE(message.objectId);

        return buffer;
    }
}
