package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ShowChatboxWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShowChatboxWidgetMessageDecoder implements MessageDecoder<ShowChatboxWidgetInboundMessage> {
    @Override
    public ShowChatboxWidgetInboundMessage decode(PacketBuffer buffer) {
        int widgetId = buffer.getUnsignedShortBE();

        return new ShowChatboxWidgetInboundMessage(widgetId);
    }
}
