package org.runejs.client.net.codec.runejs435.encoder.interactions;

import org.runejs.client.message.outbound.interactions.WidgetV1ItemInteractionOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link WidgetV1ItemInteractionOutboundMessage}.
 */
public class WidgetV1ItemInteractionMessageEncoder implements MessageEncoder<WidgetV1ItemInteractionOutboundMessage> {
    @Override
    public PacketBuffer encode(WidgetV1ItemInteractionOutboundMessage message) {
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
    private PacketBuffer encodeOption1Interaction(WidgetV1ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 38);

        buffer.putShortBE(message.itemId);
        buffer.putShortLE(message.slot);
        buffer.putIntME1((message.widgetId << 16) | message.containerId);

        return buffer;
    }

    /**
     * Encodes an interaction for the second option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption2Interaction(WidgetV1ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 228);

        buffer.putShortLE(message.itemId);
        buffer.putIntLE((message.widgetId << 16) | message.containerId);
        buffer.putShortLE(message.slot);

        return buffer;
    }

    /**
     * Encodes an interaction for the third option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption3Interaction(WidgetV1ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 26);

        buffer.putShortBE(message.slot);
        buffer.putIntLE((message.widgetId << 16) | message.containerId);
        buffer.putShortBE(message.itemId);

        return buffer;
    }

    /**
     * Encodes an interaction for the fourth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption4Interaction(WidgetV1ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 147);

        buffer.putShortBE(message.itemId);
        buffer.putShortLE(message.slot);
        buffer.putIntLE((message.widgetId << 16) | message.containerId);

        return buffer;
    }

    /**
     * Encodes an interaction for the fifth option.
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeOption5Interaction(WidgetV1ItemInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 124);

        buffer.putShortBE(message.slot);
        buffer.putIntLE((message.widgetId << 16) | message.containerId);
        buffer.putShortBE(message.itemId);

        return buffer;
    }
}
