package org.runejs.client.message.handler.rs435.widget;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.SetWidgetScrollPositionInboundMessage;

public class SetWidgetScrollPositionMessageHandler implements MessageHandler<SetWidgetScrollPositionInboundMessage> {
    @Override
    public void handle(SetWidgetScrollPositionInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        if(gameInterface != null && gameInterface.type == GameInterfaceType.LAYER) {
            int scrollPosition = message.scrollPosition;

            if(scrollPosition < 0)
                scrollPosition = 0;
            if(-gameInterface.originalHeight + gameInterface.scrollHeight < scrollPosition)
                scrollPosition = -gameInterface.originalHeight + gameInterface.scrollHeight;
            gameInterface.scrollDepth = scrollPosition;
        }
    }
}
