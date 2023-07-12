package org.runejs.client.net.codec.runejs435.decoder.widget.container;

import org.runejs.client.message.inbound.widget.container.ClearWidgetItemsInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ClearWidgetItemsMessageDecoder implements MessageDecoder<ClearWidgetItemsInboundMessage> {
    @Override
    public ClearWidgetItemsInboundMessage decode(PacketBuffer buffer) {
        final int interfaceData = buffer.getIntME1();
        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new ClearWidgetItemsInboundMessage(widgetId, childId);
    }
}
