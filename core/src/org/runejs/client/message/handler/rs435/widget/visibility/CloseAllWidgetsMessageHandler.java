package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.CloseAllWidgetsInboundMessage;

public class CloseAllWidgetsMessageHandler implements MessageHandler<CloseAllWidgetsInboundMessage> {
    @Override
    public void handle(CloseAllWidgetsInboundMessage message) {
        if(GameInterface.tabAreaInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
            GameInterface.redrawTabArea = true;
            GameInterface.drawTabIcons = true;
            GameInterface.tabAreaInterfaceId = -1;
        }
        if(GameInterface.chatboxInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            ChatBox.redrawChatbox = true;
            GameInterface.chatboxInterfaceId = -1;
        }
        if(GameInterface.fullscreenInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
            GameInterface.fullscreenInterfaceId = -1;
            MovedStatics.processGameStatus(30);
        }
        if(GameInterface.fullscreenSiblingInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
            GameInterface.fullscreenSiblingInterfaceId = -1;
        }
        if(GameInterface.gameScreenInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
            GameInterface.gameScreenInterfaceId = -1;
        }
        MovedStatics.lastContinueTextWidgetId = -1;
        if(ChatBox.inputType != 0) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
        }
    }
}
