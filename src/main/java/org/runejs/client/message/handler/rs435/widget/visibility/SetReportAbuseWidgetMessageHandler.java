package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.SetReportAbuseWidgetInboundMessage;

public class SetReportAbuseWidgetMessageHandler implements MessageHandler<SetReportAbuseWidgetInboundMessage> {
    @Override
    public void handle(SetReportAbuseWidgetInboundMessage message) {
        MovedStatics.anInt854 = message.widgetId;
    }
}
