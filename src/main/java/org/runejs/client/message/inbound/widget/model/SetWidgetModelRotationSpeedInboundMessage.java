package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

/**
 * An {@link InboundMessage} sent to apply a constant rotational speed to a widget model.
 */
public class SetWidgetModelRotationSpeedInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int speed;

    public SetWidgetModelRotationSpeedInboundMessage(int widgetId, int childId, int speed) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.speed = speed;
    }
}
