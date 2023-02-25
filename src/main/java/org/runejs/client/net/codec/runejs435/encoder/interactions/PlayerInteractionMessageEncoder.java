
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
}