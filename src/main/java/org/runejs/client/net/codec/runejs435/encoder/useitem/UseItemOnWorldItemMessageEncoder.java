package org.runejs.client.net.codec.runejs435.encoder.useitem;

import org.runejs.client.message.outbound.useitem.UseItemOnWorldItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link UseItemOnWorldItemOutboundMessage}.
 */
public class UseItemOnWorldItemMessageEncoder implements MessageEncoder<UseItemOnWorldItemOutboundMessage> {
    @Override
    public PacketBuffer encode(UseItemOnWorldItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(14, 172);

        buffer.putShortBE(message.x);
        buffer.putShortBE(message.slot);
        buffer.putShortBE(message.targetItemId);
        buffer.putIntME2((message.widgetId << 16) | message.containerId);
        buffer.putShortLE(message.y);
        buffer.putShortLE(message.itemId);

        return buffer;
    }
}
