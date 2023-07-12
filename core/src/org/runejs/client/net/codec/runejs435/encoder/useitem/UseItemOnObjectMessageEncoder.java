package org.runejs.client.net.codec.runejs435.encoder.useitem;

import org.runejs.client.message.outbound.useitem.UseItemOnObjectOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link UseItemOnObjectOutboundMessage}.
 */
public class UseItemOnObjectMessageEncoder implements MessageEncoder<UseItemOnObjectOutboundMessage> {
    @Override
    public PacketBuffer encode(UseItemOnObjectOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(14, 24);

        buffer.putShortLE(message.y);
        buffer.putShortBE(message.itemId);
        buffer.putShortLE(message.objectId);
        buffer.putShortLE(message.slot);
        buffer.putIntME1((message.widgetId << 16) | message.containerId);
        buffer.putShortLE(message.x);

        return buffer;
    }
}
