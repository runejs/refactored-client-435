package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ReplaceTabWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ReplaceTabWidgetMessageDecoder implements MessageDecoder<ReplaceTabWidgetInboundMessage> {
    @Override
    public ReplaceTabWidgetInboundMessage decode(PacketBuffer buffer) {
        int interfaceId = buffer.getUnsignedShortBE();
        int tabIndex = buffer.getUnsignedByte();
        if(interfaceId == 65535)
            interfaceId = -1;

        return new ReplaceTabWidgetInboundMessage(interfaceId, tabIndex);
    }
}
