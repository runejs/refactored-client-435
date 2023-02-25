package org.runejs.client.net.codec.runejs435.encoder.interactions;

import org.runejs.client.message.outbound.interactions.NPCInteractionOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes an {@link NPCInteractionOutboundMessage} into a {@link PacketBuffer}.
 */
public class NPCInteractionMessageEncoder implements MessageEncoder<NPCInteractionOutboundMessage> {

    @Override
    public PacketBuffer encode(NPCInteractionOutboundMessage message) {
        switch (message.option) {
            case 1:
                return encodeOption1Interaction(message);
            case 2:
                return encodeOption2Interaction(message);
            case 3:
                return encodeOption3Interaction(message);
            case 4:
                return encodeOption4Interaction(message);
            default:
                throw new RuntimeException("Invalid option: " + message.option);
        }
    }

    /**
     * Encodes an interaction for the first option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption1Interaction(NPCInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 63);

        buffer.putShortLE(message.npcIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the second option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption2Interaction(NPCInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 57);

        buffer.putShortBE(message.npcIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the third option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption3Interaction(NPCInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 116);

        buffer.putShortLE(message.npcIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the fourth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption4Interaction(NPCInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 0);

        buffer.putShortBE(message.npcIndex);

        return buffer;
    }
}
