package org.runejs.client.net.codec.runejs435.encoder.useitem;

import org.runejs.client.message.outbound.useitem.UseItemOnWidgetItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link UseItemOnWidgetItemOutboundMessage}.
 */
public class UseItemOnWidgetItemMessageEncoder implements MessageEncoder<UseItemOnWidgetItemOutboundMessage> {
    @Override
    public PacketBuffer encode(UseItemOnWidgetItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(16, 40);

        buffer.putShortLE(message.targetItemId);
        buffer.putShortLE(message.targetSlot);
        buffer.putIntLE((message.targetWidgetId << 16) | message.targetContainerId);
        buffer.putIntLE((message.widgetId << 16) | message.containerId);
        buffer.putShortLE(message.itemId);
        buffer.putShortBE(message.slot);

        return buffer;
    }
}
