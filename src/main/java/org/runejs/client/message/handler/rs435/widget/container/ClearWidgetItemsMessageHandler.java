package org.runejs.client.message.handler.rs435.widget.container;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.container.ClearWidgetItemsInboundMessage;

public class ClearWidgetItemsMessageHandler implements MessageHandler<ClearWidgetItemsInboundMessage> {
    @Override
    public void handle(ClearWidgetItemsInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        if(gameInterface.isNewInterfaceFormat) {
            GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[message.widgetId];
            for(int i_37_ = 0; i_37_ < gameInterfaces.length; i_37_++) {
                GameInterface gameInterface_38_ = gameInterfaces[i_37_];
                if((0xffff & gameInterface.id) == (gameInterface_38_.parentId & 0xffff) && gameInterface_38_.anInt2736 > 0) {
                    gameInterface_38_.itemId = -1;
                    gameInterface_38_.itemAmount = 0;
                }
            }
        } else {
            for(int i_39_ = 0; gameInterface.items.length > i_39_; i_39_++) {
                gameInterface.items[i_39_] = -1;
                gameInterface.items[i_39_] = 0;
            }
        }
    }
}
