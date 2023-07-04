package org.runejs.client.net.codec.runejs435.encoder;

import org.runejs.client.message.outbound.WalkOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class WalkMessageEncoder implements MessageEncoder<WalkOutboundMessage> {
    @Override
    public PacketBuffer encode(WalkOutboundMessage message) {
        PacketBuffer buffer = this.createBufferForWalkType(message.type, message.steps.length);

        buffer.putShortLE(message.startY);
        buffer.putByte(message.running ? 1 : 0);
        buffer.putShortLE(message.startX);

        for(WalkOutboundMessage.WalkStep step : message.steps) {
            if (step == null) {
                continue;
            }

            buffer.putByte(step.x);
            buffer.putByte(step.y);
        }

        return buffer;
    }

    private PacketBuffer createBufferForWalkType(WalkOutboundMessage.WalkType walkType, int pathSize) {
        if (walkType == WalkOutboundMessage.WalkType.TILE) {
            return OutgoingPackets.openFixedSizePacket(3 + pathSize + pathSize, 73);
        }

        if (walkType == WalkOutboundMessage.WalkType.INTERACTION) {
            return OutgoingPackets.openFixedSizePacket(3 + pathSize + pathSize, 89);
        }

        if (walkType == WalkOutboundMessage.WalkType.INTERACTION) {
            return OutgoingPackets.openFixedSizePacket(3 + pathSize + pathSize + 14, 236);
        }

        throw new RuntimeException("Unhandled walk type");
    }
}
