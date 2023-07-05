package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.Class51;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.FlashTabIconInboundMessage;

public class FlashTabIconMessageHandler implements MessageHandler<FlashTabIconInboundMessage> {
    @Override
    public void handle(FlashTabIconInboundMessage message) {
        Class51.anInt1205 = message.tabId;
        if(Player.currentTabId == Class51.anInt1205) {
            if(Class51.anInt1205 != 3)
                Player.currentTabId = 3;
            else
                Player.currentTabId = 1;
            GameInterface.redrawTabArea = true;
        }
    }
}
