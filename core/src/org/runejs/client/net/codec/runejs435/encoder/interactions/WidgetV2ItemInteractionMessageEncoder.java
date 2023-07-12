package org.runejs.client.net.codec.runejs435.encoder.interactions;

import org.runejs.client.message.outbound.interactions.WidgetV2ItemInteractionOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link WidgetV2ItemInteractionOutboundMessage}.
 */
public class WidgetV2ItemInteractionMessageEncoder implements MessageEncoder<WidgetV2ItemInteractionOutboundMessage> {
    @Override
    public PacketBuffer encode(WidgetV2ItemInteractionOutboundMessage message) {
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
    private PacketBuffer encodeOption1Interaction(WidgetV2ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 240);

        buffer.putShortLE(message.slot);
        buffer.putShortLE(message.itemId);
        buffer.putIntME2((message.widgetId << 16) | message.containerId);

        return buffer;
    }

    /**
     * Encodes an interaction for the second option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption2Interaction(WidgetV2ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 102);

        buffer.putIntLE((message.widgetId << 16) | message.containerId);
        buffer.putShortLE(message.slot);
        buffer.putShortBE(message.itemId);

        return buffer;
    }

    /**
     * Encodes an interaction for the third option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption3Interaction(WidgetV2ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 163);

        buffer.putShortLE(message.slot);
        buffer.putShortLE(message.itemId);
        buffer.putIntBE((message.widgetId << 16) | message.containerId);

        return buffer;
    }

    /**
     * Encodes an interaction for the fourth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption4Interaction(WidgetV2ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 98);

        buffer.putShortBE(message.slot);
        buffer.putIntME1((message.widgetId << 16) | message.containerId);
        buffer.putShortBE(message.itemId);

        return buffer;
    }

}
