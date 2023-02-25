package org.runejs.client.net.codec.runejs435.encoder.interactions;

import org.runejs.client.message.outbound.interactions.ObjectInteractionOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class ObjectInteractionMessageEncoder implements MessageEncoder<ObjectInteractionOutboundMessage> {

    @Override
    public PacketBuffer encode(ObjectInteractionOutboundMessage message) {
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

    private PacketBuffer encodeOption1Interaction(ObjectInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 30);

        buffer.putShortBE(message.objectId);
        buffer.putShortBE(message.y);
        buffer.putShortLE(message.x);

        return buffer;
    }

    private PacketBuffer encodeOption2Interaction(ObjectInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 164);

        buffer.putShortLE(message.x);
        buffer.putShortLE(message.y);
        buffer.putShortLE(message.objectId);

        return buffer;
    }

    private PacketBuffer encodeOption3Interaction(ObjectInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 183);

        buffer.putShortBE(message.y);
        buffer.putShortBE(message.objectId);
        buffer.putShortBE(message.x);

        return buffer;
    }

    private PacketBuffer encodeOption4Interaction(ObjectInteractionOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 229);

        buffer.putShortLE(message.x);
        buffer.putShortLE(message.objectId);
        buffer.putShortLE(message.y);

        return buffer;
    }
    
}
