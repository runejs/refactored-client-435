package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.Game;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetCurrentTabInboundMessage;

public class SetCurrentTabMessageHandler implements MessageHandler<SetCurrentTabInboundMessage> {
    @Override
    public void handle(SetCurrentTabInboundMessage message) {
        Game.currentTabId = message.tabId;
        GameInterface.drawTabIcons = true;
        GameInterface.redrawTabArea = true;
    }
}
