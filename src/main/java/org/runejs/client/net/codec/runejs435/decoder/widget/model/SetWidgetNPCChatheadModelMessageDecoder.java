package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.SetWidgetNPCChatheadModelInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetWidgetNPCChatheadModelMessageDecoder implements MessageDecoder<SetWidgetNPCChatheadModelInboundMessage> {
    @Override
    public SetWidgetNPCChatheadModelInboundMessage decode(PacketBuffer buffer) {
        int npcId = buffer.getUnsignedShortLE();
        int interfaceData = buffer.getIntLE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new SetWidgetNPCChatheadModelInboundMessage(widgetId, childId, npcId);
    }
}
