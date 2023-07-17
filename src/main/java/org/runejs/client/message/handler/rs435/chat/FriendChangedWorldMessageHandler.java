package org.runejs.client.message.handler.rs435.chat;

import org.runejs.client.Game;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.English;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.chat.FriendChangedWorldInboundMessage;

/**
 * A {@link MessageHandler} that handles {@link FriendChangedWorldMessageHandler}s.
 */
public class FriendChangedWorldMessageHandler implements MessageHandler<FriendChangedWorldInboundMessage> {
    @Override
    public void handle(FriendChangedWorldInboundMessage message) {
        String string = Player.longToUsername(message.username).method85().toString();

        int index = Game.friendList.getPlayerIndex(message.username);

        if (index != -1) {
            int existingWorld = Game.friendList.getPlayerWorld(index);

            if (existingWorld != message.worldId) {
                Game.friendList.setPlayerWorld(index, message.worldId);

                GameInterface.redrawTabArea = true;
                if(message.worldId > 0)
                    ChatBox.addChatMessage("", string + English.suffixHasLoggedIn, 5);
                if(message.worldId == 0)
                    ChatBox.addChatMessage("", string + English.suffixHasLoggedOut, 5);
            }

            string = null;
        }

        if(string != null && Game.friendList.getCount() < Game.friendList.getSize()) {
            Game.friendList.addPlayer(message.username, string, message.worldId);
            GameInterface.redrawTabArea = true;
        }

        Game.friendList.sort();
    }
}
