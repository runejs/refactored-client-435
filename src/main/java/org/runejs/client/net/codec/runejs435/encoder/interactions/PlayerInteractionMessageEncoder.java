
package org.runejs.client.net.codec.runejs435.encoder.interactions;

import org.runejs.client.message.outbound.interactions.PlayerInteractionOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes an {@link PlayerInteractionOutboundMessage} into a {@link PacketBuffer}.
 */
public class PlayerInteractionMessageEncoder implements MessageEncoder<PlayerInteractionOutboundMessage> {

    @Override
    public PacketBuffer encode(PlayerInteractionOutboundMessage message) {
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
    private PacketBuffer encodeOption1Interaction(PlayerInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 68);

        buffer.putShortLE(message.playerIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the second option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption2Interaction(PlayerInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 211);

        buffer.putShortLE(message.playerIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the third option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption3Interaction(PlayerInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 220);

        buffer.putShortBE(message.playerIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the fourth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption4Interaction(PlayerInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 96);

        buffer.putShortBE(message.playerIndex);

        return buffer;
    }

    /**
     * Encodes an interaction for the fifth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption5Interaction(PlayerInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 187);

        buffer.putShortLE(message.playerIndex);

        return buffer;
    }
}