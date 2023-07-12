package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Sets the widget which should be opened after clicking the "Report Abuse" button.
 */
public class SetReportAbuseWidgetInboundMessage implements InboundMessage {
    public final int widgetId;

    public SetReportAbuseWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
