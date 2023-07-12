package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

public class ShowTabAndScreenWidgetInboundMessage implements InboundMessage {
    public final int screenWidgetId;

    public final int tabWidgetId;

    public ShowTabAndScreenWidgetInboundMessage(int screenWidgetId, int tabWidgetId) {
        this.screenWidgetId = screenWidgetId;
        this.tabWidgetId = tabWidgetId;
    }
}
