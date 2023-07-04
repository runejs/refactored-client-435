package org.runejs.client.message.handler.rs435.widget.text;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.text.SetWidgetTextInboundMessage;

public class SetWidgetTextMessageHandler implements MessageHandler<SetWidgetTextInboundMessage> {
    @Override
    public void handle(SetWidgetTextInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);
        gameInterface.disabledText = message.text;
        if(Player.tabWidgetIds[Player.currentTabId] == message.widgetId) {
            GameInterface.redrawTabArea = true;
        }
    }
}
