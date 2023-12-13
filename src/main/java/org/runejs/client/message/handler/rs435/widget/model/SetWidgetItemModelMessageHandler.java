package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.SetWidgetItemModelInboundMessage;

public class SetWidgetItemModelMessageHandler implements MessageHandler<SetWidgetItemModelInboundMessage> {
    @Override
    public void handle(SetWidgetItemModelInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        if(gameInterface.if3) {
            gameInterface.itemAmount = 1;
            gameInterface.itemId = message.itemId;
        } else {
            if(message.itemId == -1) {
                gameInterface.modelType = InterfaceModelType.NULL;
                return;
            }
            ItemDefinition itemDefinition = ItemDefinition.forId(message.itemId, 10);
            gameInterface.modelXAngle = itemDefinition.xan2d;
            gameInterface.modelId = message.itemId;
            gameInterface.modelType = InterfaceModelType.ITEM;
            gameInterface.modelZoom = 100 * itemDefinition.zoom2d / message.itemZoom;
            gameInterface.modelYAngle = itemDefinition.yan2d;
        }
    }
}
