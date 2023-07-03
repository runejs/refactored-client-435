package org.runejs.client.message.handler.rs435.chat;

import org.runejs.client.MovedStatics;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.chat.ReceivePrivateMessageInboundMessage;
import org.runejs.client.util.TextUtils;

/**
 * A {@link MessageHandler} that handles {@link ReceivePrivateMessageInboundMessage}s.
 * 
 * Responsible for displaying private messages.
 */
public class ReceivePrivateMessageHandler implements MessageHandler<ReceivePrivateMessageInboundMessage> {
    @Override
    public void handle(ReceivePrivateMessageInboundMessage message) {
        boolean hideMessage = false;
        long chatId = (message.chatIdModifier << 32) + message.privateMessageCounter;
        for (int msgIndex = 0; msgIndex < 100; msgIndex++) {
            if (chatId == Player.privateMessageIds[msgIndex]) {
                hideMessage = true;
                break;
            }
        }
        if (message.fromPlayerRights <= 1) {
            for (int ignoreIndex = 0; ignoreIndex < MovedStatics.anInt1008; ignoreIndex++) {
                if (message.fromPlayerIndex == Player.ignores[ignoreIndex]) {
                    hideMessage = true;
                    break;
                }
            }
        }

        if (hideMessage || Player.inTutorialIsland) {
            return;
        }

        String senderName = TextUtils.formatName(TextUtils.longToName(message.fromPlayerIndex));

        Player.privateMessageIds[Player.privateMessageIndex] = chatId;
        Player.privateMessageIndex = (1 + Player.privateMessageIndex) % 100;
        if (message.fromPlayerRights == 2 || message.fromPlayerRights == 3)
            ChatBox.addChatMessage(Native.goldCrown + senderName, message.privateMessage, 7);
        else if (message.fromPlayerRights == 1)
            ChatBox.addChatMessage(Native.whiteCrown + senderName, message.privateMessage, 7);
        else
            ChatBox.addChatMessage(senderName, message.privateMessage, 3);
    }
}
