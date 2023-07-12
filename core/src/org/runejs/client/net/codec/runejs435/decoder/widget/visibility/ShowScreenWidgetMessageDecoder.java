package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ShowScreenWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShowScreenWidgetMessageDecoder implements MessageDecoder<ShowScreenWidgetInboundMessage> {
    @Override
    public ShowScreenWidgetInboundMessage decode(PacketBuffer buffer) {
        int widgetId = buffer.getUnsignedShortBE();

        return new ShowScreenWidgetInboundMessage(widgetId);
    }
}
