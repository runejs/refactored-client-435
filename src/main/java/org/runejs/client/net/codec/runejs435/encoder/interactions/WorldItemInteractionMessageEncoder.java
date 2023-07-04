
package org.runejs.client.net.codec.runejs435.encoder.interactions;

import org.runejs.client.message.outbound.interactions.WorldItemInteractionOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes an {@link WorldItemInteractionOutboundMessage} into a {@link PacketBuffer}.
 */
public class WorldItemInteractionMessageEncoder implements MessageEncoder<WorldItemInteractionOutboundMessage> {

    @Override
    public PacketBuffer encode(WorldItemInteractionOutboundMessage message) {
        switch (message.option) {
            case 1:
                return encodeOption1Interaction(message);
            case 2:
                return encodeOption2Interaction(message);
            case 3:
                return encodeOption3Interaction(message);
            case 4:
                return encodeOption4Interaction(message);
            case 5:
                return encodeOption5Interaction(message);
            default:
                throw new RuntimeException("Invalid option: " + message.option);
        }
    }

    /**
     * Encodes an interaction for the first option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption1Interaction(WorldItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 244);

        buffer.putShortLE(message.x);
        buffer.putShortBE(message.y);
        buffer.putShortBE(message.itemId);

        return buffer;
    }

    /**
     * Encodes an interaction for the second option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption2Interaction(WorldItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 190);

        buffer.putShortLE(message.x);
        buffer.putShortBE(message.itemId);
        buffer.putShortBE(message.y);

        return buffer;
    }

    /**
     * Encodes an interaction for the third option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption3Interaction(WorldItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 85);

        buffer.putShortBE(message.y);
        buffer.putShortBE(message.itemId);
        buffer.putShortLE(message.x);

        return buffer;
    }

    /**
     * Encodes an interaction for the fourth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption4Interaction(WorldItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 65);

        buffer.putShortBE(message.itemId);
        buffer.putShortBE(message.y);
        buffer.putShortLE(message.x);

        return buffer;
    }

    /**
     * Encodes an interaction for the fifth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption5Interaction(WorldItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 27);

        buffer.putShortBE(message.x);
        buffer.putShortBE(message.itemId);
        buffer.putShortBE(message.y);

        return buffer;
    }
}