package org.runejs.client.net.codec.runejs435.encoder.widget.container;

import org.runejs.client.message.outbound.widget.container.DragWidgetItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class DragWidgetItemMessageEncoder implements MessageEncoder<DragWidgetItemOutboundMessage> {
    @Override
    public PacketBuffer encode(DragWidgetItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(9, 83);
        
        buffer.putByte(message.moveType);
        buffer.putShortBE(message.fromSlot);
        buffer.putShortLE(message.toSlot);
        buffer.putIntME2(message.widgetId);
        
        return buffer;
    }
}
