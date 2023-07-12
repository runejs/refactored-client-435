package org.runejs.client.net.codec.runejs435.decoder.widget.model;

import org.runejs.client.message.inbound.widget.model.AnimateWidgetModelInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class AnimateWidgetModelMessageDecoder implements MessageDecoder<AnimateWidgetModelInboundMessage> {
    @Override
    public AnimateWidgetModelInboundMessage decode(PacketBuffer buffer) {
        int animationId = buffer.getShortBE();
        int interfaceData = buffer.getIntBE();

        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        return new AnimateWidgetModelInboundMessage(widgetId, childId, animationId);
    }
}
