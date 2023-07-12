package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.SetWidgetLocalPlayerChatheadModelInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetLocalPlayerChatheadModelMessageDecoder implements MessageDecoder<SetWidgetLocalPlayerChatheadModelInboundMessage> {
    @Override
    public SetWidgetLocalPlayerChatheadModelInboundMessage decode(PacketBuffer buffer) {
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetLocalPlayerChatheadModelInboundMessage(widgetId, childId);
    }
}
