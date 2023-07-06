package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Sets an individual widget or child widget to hidden.
 *
 * TODO please add some use cases for this
 */
public class SetWidgetHiddenInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;
    public final boolean isHidden;

    public SetWidgetHiddenInboundMessage(int widgetId, int childId, boolean isHidden) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.isHidden = isHidden;
    }
}
