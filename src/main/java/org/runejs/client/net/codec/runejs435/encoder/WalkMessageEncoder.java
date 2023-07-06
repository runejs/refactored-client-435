package org.runejs.client.net.codec.runejs435.encoder;

import org.runejs.client.message.outbound.WalkOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.VariableLengthPacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class WalkMessageEncoder implements MessageEncoder<WalkOutboundMessage> {
    @Override
    public PacketBuffer encode(WalkOutboundMessage message) {
        VariableLengthPacketBuffer buffer = OutgoingPackets.openVariableSizePacket(this.getOpcodeForWalkType(message.type));

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

        // Map type walking has 14 bytes of junk on the end
        if (message.type == WalkOutboundMessage.WalkType.MAP) {
            buffer.currentPosition += 14;
        }

        buffer.writePacketLength();

        return buffer;
    }

    private int getOpcodeForWalkType(WalkOutboundMessage.WalkType walkType) {
        if (walkType == WalkOutboundMessage.WalkType.TILE) {
            return 73;
        }

        if (walkType == WalkOutboundMessage.WalkType.INTERACTION) {
            return 89;
        }

        if (walkType == WalkOutboundMessage.WalkType.MAP) {
            return 236;
        }

        throw new RuntimeException("Unhandled walk type");
    }
}
