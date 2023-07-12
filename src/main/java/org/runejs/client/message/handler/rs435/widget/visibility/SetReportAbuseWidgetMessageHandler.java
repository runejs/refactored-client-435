package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.SetReportAbuseWidgetInboundMessage;

public class SetReportAbuseWidgetMessageHandler implements MessageHandler<SetReportAbuseWidgetInboundMessage> {
    @Override
    public void handle(SetReportAbuseWidgetInboundMessage message) {
        GameInterface.reportAbuseWidgetId = message.widgetId;
    }
}
