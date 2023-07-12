package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.SetReportAbuseWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetReportAbuseWidgetMessageDecoder implements MessageDecoder<SetReportAbuseWidgetInboundMessage> {
    @Override
    public SetReportAbuseWidgetInboundMessage decode(PacketBuffer buffer) {
        int widgetId = buffer.getUnsignedShortLE();

        return new SetReportAbuseWidgetInboundMessage(widgetId);
    }
}
