package org.runejs.client.net.codec.runejs435.decoder.widget.text;

import org.runejs.client.message.inbound.widget.text.SetWidgetTextInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetTextMessageDecoder implements MessageDecoder<SetWidgetTextInboundMessage> {
    @Override
    public SetWidgetTextInboundMessage decode(PacketBuffer buffer) {
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        String interfaceText = buffer.getString();

        return new SetWidgetTextInboundMessage(widgetId, childId, interfaceText);
    }
}
