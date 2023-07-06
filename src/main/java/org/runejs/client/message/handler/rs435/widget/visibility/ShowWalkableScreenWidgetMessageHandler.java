package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowWalkableScreenWidgetInboundMessage;
import org.runejs.client.scene.GroundItemTile;

public class ShowWalkableScreenWidgetMessageHandler implements MessageHandler<ShowWalkableScreenWidgetInboundMessage> {
    @Override
    public void handle(ShowWalkableScreenWidgetInboundMessage message) {
        int widgetId = message.widgetId;

        if(widgetId >= 0)
            GameInterface.resetInterfaceAnimations(widgetId);
        if(widgetId != GroundItemTile.walkableWidgetId) {
            GameInterface.resetInterface(GroundItemTile.walkableWidgetId);
            GroundItemTile.walkableWidgetId = widgetId;
        }
    }
}
