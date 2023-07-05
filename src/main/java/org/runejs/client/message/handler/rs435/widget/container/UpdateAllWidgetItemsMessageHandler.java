package org.runejs.client.message.handler.rs435.widget.container;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.container.UpdateAllWidgetItemsInboundMessage;
import org.runejs.client.message.inbound.widget.container.WidgetItem;

public class UpdateAllWidgetItemsMessageHandler implements MessageHandler<UpdateAllWidgetItemsInboundMessage> {
    @Override
    public void handle(UpdateAllWidgetItemsInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        if(gameInterface.isNewInterfaceFormat) {
            final GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[message.widgetId];
            for(GameInterface child : gameInterfaces) {
                if((0xffff & gameInterface.id) == (0xffff & child.parentId) && child.anInt2736 > 0) {
                    child.itemAmount = 0;
                    child.itemId = -1;
                }
            }
        } else {
            for(int index = 0; index < gameInterface.items.length; index++) {
                gameInterface.items[index] = 0;
                gameInterface.itemAmounts[index] = 0;
            }
        }

        for(WidgetItem item : message.items) {
            if(gameInterface.isNewInterfaceFormat) {
                GameInterface gameInterfaces[] = GameInterface.cachedInterfaces[message.widgetId];
                for(GameInterface child : gameInterfaces) {
                    if((gameInterface.id & 0xffff) == (child.parentId & 0xffff) && 1 + item.index == child.anInt2736) {
                        child.itemAmount = item.amount;
                        child.itemId = -1 + item.id;
                    }
                }
            } else if(item.index < gameInterface.items.length) {
                gameInterface.items[item.index] = item.id;
                gameInterface.itemAmounts[item.index] = item.amount;
            }
        }
    }
}
