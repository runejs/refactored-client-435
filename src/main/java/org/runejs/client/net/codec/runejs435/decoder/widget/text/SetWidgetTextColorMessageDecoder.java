package org.runejs.client.net.codec.runejs435.decoder.widget.text;

import org.runejs.client.message.inbound.widget.text.SetWidgetTextColorInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetTextColorMessageDecoder implements MessageDecoder<SetWidgetTextColorInboundMessage> {
    @Override
    public SetWidgetTextColorInboundMessage decode(PacketBuffer buffer) {
        int color = buffer.getUnsignedShortBE();
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetTextColorInboundMessage(widgetId, childId, color);
    }
}
