package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.Game;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.FlashTabIconInboundMessage;

public class FlashTabIconMessageHandler implements MessageHandler<FlashTabIconInboundMessage> {
    @Override
    public void handle(FlashTabIconInboundMessage message) {
        Game.flashingTabId = message.tabId;
        if(Game.currentTabId == Game.flashingTabId) {
            if(Game.flashingTabId != 3)
                Game.currentTabId = 3;
            else
                Game.currentTabId = 1;
            GameInterface.redrawTabArea = true;
        }
    }
}
