package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ShowFullScreenWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShowFullScreenWidgetMessageDecoder implements MessageDecoder<ShowFullScreenWidgetInboundMessage> {
    @Override
    public ShowFullScreenWidgetInboundMessage decode(PacketBuffer buffer) {
        int siblingInterfaceId = buffer.getUnsignedShortBE();
        int interfaceId = buffer.getUnsignedShortBE();

        return new ShowFullScreenWidgetInboundMessage(interfaceId, siblingInterfaceId);
    }
}
