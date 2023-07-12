package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.ShowTabAndScreenWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShowTabAndScreenWidgetMessageDecoder implements MessageDecoder<ShowTabAndScreenWidgetInboundMessage> {
    @Override
    public ShowTabAndScreenWidgetInboundMessage decode(PacketBuffer buffer) {
        int tabWidgetId = buffer.getUnsignedShortBE();
        int screenWidgetId = buffer.getUnsignedShortLE();

        return new ShowTabAndScreenWidgetInboundMessage(screenWidgetId, tabWidgetId);
    }
}
