package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.RotateWidgetModelInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class RotateWidgetModelMessageDecoder implements MessageDecoder<RotateWidgetModelInboundMessage> {
    @Override
    public RotateWidgetModelInboundMessage decode(PacketBuffer buffer) {
        int rotationZ = buffer.getUnsignedShortBE();
        int modelZoom = buffer.getUnsignedShortLE();
        int rotationX = buffer.getUnsignedShortBE();
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new RotateWidgetModelInboundMessage(widgetId, childId, rotationX, rotationZ, modelZoom);
    }
}
