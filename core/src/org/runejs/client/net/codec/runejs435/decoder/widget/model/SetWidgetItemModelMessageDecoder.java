package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.SetWidgetItemModelInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetItemModelMessageDecoder implements MessageDecoder<SetWidgetItemModelInboundMessage> {
    @Override
    public SetWidgetItemModelInboundMessage decode(PacketBuffer buffer) {
        int zoom = buffer.getUnsignedShortBE();
        int itemId = buffer.getUnsignedShortLE();
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        if(itemId == 65535) {
            itemId = -1;
        }

        return new SetWidgetItemModelInboundMessage(widgetId, childId, itemId, zoom);
    }
}
