package org.runejs.client.net.codec.runejs435.encoder.widget.container;

import org.runejs.client.message.outbound.widget.container.DropWidgetItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class DropWidgetItemMessageEncoder implements MessageEncoder<DropWidgetItemOutboundMessage> {
    @Override
    public PacketBuffer encode(DropWidgetItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 29);

        buffer.putIntME1((message.widgetId << 16) | message.containerId);
        buffer.putShortBE(message.slot);
        buffer.putShortLE(message.itemId);

        return buffer;
    }
}
