package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ReplaceTabWidgetInboundMessage;
import org.runejs.client.message.inbound.widget.visibility.ShowTabWidgetInboundMessage;

/**
 * Displays a widget over the tabarea.
 *
 * Note that this is used for temporary overlays, not for replacing the contents of a specific
 * tab.
 *
 * If you want to control a tab's contents, see {@link ReplaceTabWidgetInboundMessage}
 */
public class ShowTabWidgetMessageHandler implements MessageHandler<ShowTabWidgetInboundMessage> {
    @Override
    public void handle(ShowTabWidgetInboundMessage message) {
        int interfaceId = message.widgetId;

        GameInterface.resetInterfaceAnimations(interfaceId);
        if(GameInterface.chatboxInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            GameInterface.chatboxInterfaceId = -1;
            ChatBox.redrawChatbox = true;
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
        if(GameInterface.tabAreaInterfaceId != interfaceId) {
            GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
            GameInterface.tabAreaInterfaceId = interfaceId;
        }
        GameInterface.drawTabIcons = true;
        if(ChatBox.inputType != 0) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
        }
        MovedStatics.lastContinueTextWidgetId = -1;
        GameInterface.redrawTabArea = true;
    }
}
