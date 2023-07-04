package org.runejs.client.net.codec.runejs435.encoder.useitem;

import org.runejs.client.message.outbound.useitem.UseItemOnPlayerOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link UseItemOnPlayerOutboundMessage}.
 */
public class UseItemOnPlayerMessageEncoder implements MessageEncoder<UseItemOnPlayerOutboundMessage> {
    @Override
    public PacketBuffer encode(UseItemOnPlayerOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(10, 110);

        buffer.putShortLE(message.playerId);
        buffer.putIntME1((message.widgetId << 16) | message.containerId);
        buffer.putShortBE(message.itemId);
        buffer.putShortBE(message.slot);

        return buffer;
    }
}
