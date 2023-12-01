package org.runejs.client.message.handler.rs435.widget.container;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.container.UpdateSpecificWidgetItemsInboundMessage;
import org.runejs.client.message.inbound.widget.container.WidgetItem;

public class UpdateSpecificWidgetItemsMessageHandler implements MessageHandler<UpdateSpecificWidgetItemsInboundMessage> {
    @Override
    public void handle(UpdateSpecificWidgetItemsInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        for(WidgetItem item : message.items) {
            if(gameInterface.if3) {
                GameInterface[] gameInterfaces = GameInterface.components[message.widgetId];
                for(int i_111_ = 0; i_111_ < gameInterfaces.length; i_111_++) {
                    GameInterface gameInterface_112_ = gameInterfaces[i_111_];
                    if((gameInterface.id & 0xffff) == (gameInterface_112_.layer & 0xffff) && 1 + item.index == gameInterface_112_.anInt2736) {
                        gameInterface_112_.itemAmount = item.amount;
                        gameInterface_112_.itemId = item.id + -1;
                    }
                }
            } else if(item.index >= 0 && gameInterface.invSlotObjId.length > item.index) {
                gameInterface.invSlotObjId[item.index] = item.id;
                gameInterface.invSlotObjCount[item.index] = item.amount;
            }
        }
    }
}
