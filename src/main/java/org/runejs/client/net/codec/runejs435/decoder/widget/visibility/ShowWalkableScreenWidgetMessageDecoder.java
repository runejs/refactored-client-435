package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ShowWalkableScreenWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShowWalkableScreenWidgetMessageDecoder implements MessageDecoder<ShowWalkableScreenWidgetInboundMessage> {
    @Override
    public ShowWalkableScreenWidgetInboundMessage decode(PacketBuffer buffer) {
        int widgetId = buffer.getShortBE();

        return new ShowWalkableScreenWidgetInboundMessage(widgetId);
    }
}
