package org.runejs.client.message.handler.rs435;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.SetFriendsListStatusInboundMessage;

/**
 * A {@link MessageHandler} that handles {@link SetFriendsListStatusInboundMessage}s.
 */
public class SetFriendsListStatusMessageHandler implements MessageHandler<SetFriendsListStatusInboundMessage> {
    @Override
    public void handle(SetFriendsListStatusInboundMessage message) {
        Player.friendListStatus = message.friendListStatus;
        GameInterface.redrawTabArea = true;
    }
}
