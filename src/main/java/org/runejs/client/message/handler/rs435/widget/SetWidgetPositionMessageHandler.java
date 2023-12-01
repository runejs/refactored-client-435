package org.runejs.client.message.handler.rs435.widget;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.SetWidgetPositionInboundMessage;

public class SetWidgetPositionMessageHandler implements MessageHandler<SetWidgetPositionInboundMessage> {
    @Override
    public void handle(SetWidgetPositionInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        gameInterface.x = gameInterface.baseX + message.x;
        gameInterface.y = gameInterface.baseY + message.y;
    }
}
