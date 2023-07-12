package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ShowPermanentChatboxWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShowPermanentChatboxWidgetMessageDecoder implements MessageDecoder<ShowPermanentChatboxWidgetInboundMessage> {
    @Override
    public ShowPermanentChatboxWidgetInboundMessage decode(PacketBuffer buffer) {
        int chatboxInterfaceId = buffer.getShortBE();

        return new ShowPermanentChatboxWidgetInboundMessage(chatboxInterfaceId);
    }
}
