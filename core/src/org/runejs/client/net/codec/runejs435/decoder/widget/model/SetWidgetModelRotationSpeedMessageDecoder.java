package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.SetWidgetModelRotationSpeedInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetModelRotationSpeedMessageDecoder implements MessageDecoder<SetWidgetModelRotationSpeedInboundMessage> {
    @Override
    public SetWidgetModelRotationSpeedInboundMessage decode(PacketBuffer buffer) {
        // not sure why this int is read as 2 shorts, can't say I've seen this before if it's obfuscation
        int speedHigh = buffer.getUnsignedShortBE();
        int speedLow = buffer.getUnsignedShortLE();
        int speed = (speedHigh << 16) + speedLow;

        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;


        return new SetWidgetModelRotationSpeedInboundMessage(widgetId, childId, speed);
    }
}
