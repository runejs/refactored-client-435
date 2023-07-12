package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.SetWidgetModelInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetModelMessageDecoder implements MessageDecoder<SetWidgetModelInboundMessage> {
    @Override
    public SetWidgetModelInboundMessage decode(PacketBuffer buffer) {
        int modelId = buffer.getUnsignedShortLE();
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetModelInboundMessage(widgetId, childId, modelId);
    }
}
