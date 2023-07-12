package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.SetWidgetHiddenInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetHiddenMessageDecoder implements MessageDecoder<SetWidgetHiddenInboundMessage> {
    @Override
    public SetWidgetHiddenInboundMessage decode(PacketBuffer buffer) {
        boolean isHidden = buffer.getUnsignedByte() == 1;
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetHiddenInboundMessage(widgetId, childId, isHidden);
    }
}
