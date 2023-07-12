package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.SetWidgetHiddenInboundMessage;

public class SetWidgetHiddenMessageHandler implements MessageHandler<SetWidgetHiddenInboundMessage> {
    @Override
    public void handle(SetWidgetHiddenInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        gameInterface.isHidden = message.isHidden;
    }
}
