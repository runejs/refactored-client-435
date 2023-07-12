package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.FlashTabIconInboundMessage;

public class FlashTabIconMessageHandler implements MessageHandler<FlashTabIconInboundMessage> {
    @Override
    public void handle(FlashTabIconInboundMessage message) {
        Player.flashingTabId = message.tabId;
        if(Player.currentTabId == Player.flashingTabId) {
            if(Player.flashingTabId != 3)
                Player.currentTabId = 3;
            else
                Player.currentTabId = 1;
            GameInterface.redrawTabArea = true;
        }
    }
}
