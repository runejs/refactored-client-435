package org.runejs.client.net.codec.runejs435.encoder.useitem;

import org.runejs.client.message.outbound.useitem.UseItemOnNPCOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link UseItemOnNPCOutboundMessage}.
 */
public class UseItemOnNPCMessageEncoder implements MessageEncoder<UseItemOnNPCOutboundMessage> {
    @Override
    public PacketBuffer encode(UseItemOnNPCOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(10, 208);

        buffer.putShortBE(message.npcId);
        buffer.putShortBE(message.itemId);
        buffer.putShortLE(message.slot);
        buffer.putIntBE((message.widgetId << 16) | message.containerId);

        return buffer;
    }
}
