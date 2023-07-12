package org.runejs.client.net.codec.runejs435.decoder.widget;

import org.runejs.client.message.inbound.widget.SetWidgetPositionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetPositionMessageDecoder implements MessageDecoder<SetWidgetPositionInboundMessage> {
    @Override
    public SetWidgetPositionInboundMessage decode(PacketBuffer buffer) {
        int interfaceData = buffer.getIntBE();
        int x = buffer.getShortLE();
        int y = buffer.getShortLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetPositionInboundMessage(widgetId, childId, x, y);
    }
}
