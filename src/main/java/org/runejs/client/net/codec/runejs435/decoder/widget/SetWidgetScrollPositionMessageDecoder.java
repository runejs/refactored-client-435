package org.runejs.client.net.codec.runejs435.decoder.widget;

import org.runejs.client.message.inbound.widget.SetWidgetScrollPositionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetScrollPositionMessageDecoder implements MessageDecoder<SetWidgetScrollPositionInboundMessage> {
    @Override
    public SetWidgetScrollPositionInboundMessage decode(PacketBuffer buffer) {
        int scrollPosition = buffer.getUnsignedShortBE();
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetScrollPositionInboundMessage(widgetId, childId, scrollPosition);
    }
}
