package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowWalkableScreenWidgetInboundMessage;

public class ShowWalkableScreenWidgetMessageHandler implements MessageHandler<ShowWalkableScreenWidgetInboundMessage> {
    @Override
    public void handle(ShowWalkableScreenWidgetInboundMessage message) {
        int widgetId = message.widgetId;

        if(widgetId >= 0)
            GameInterface.resetInterfaceAnimations(widgetId);
        if(widgetId != GameInterface.walkableWidgetId) {
            GameInterface.resetInterface(GameInterface.walkableWidgetId);
            GameInterface.walkableWidgetId = widgetId;
        }
    }
}
