package org.runejs.client.message.handler.rs435.chat;

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
        for(int i = 0; i < Player.friendsCount; i++) {
            if(message.username == Player.friends[i]) {
                if(message.worldId != Player.friendWorlds[i]) {
                    Player.friendWorlds[i] = message.worldId;
                    GameInterface.redrawTabArea = true;
                    if(message.worldId > 0)
                        ChatBox.addChatMessage("", string + English.suffixHasLoggedIn, 5);
                    if(message.worldId == 0)
                        ChatBox.addChatMessage("", string + English.suffixHasLoggedOut, 5);
                }
                string = null;
                break;
            }
        }

        if(string != null && Player.friendsCount < 200) {
            Player.friends[Player.friendsCount] = message.username;
            Player.friendUsernames[Player.friendsCount] = string;
            Player.friendWorlds[Player.friendsCount] = message.worldId;
            Player.friendsCount++;
            GameInterface.redrawTabArea = true;
        }

        boolean bool = false;
        while(!bool) {
            bool = true;
            for(int i = 0; Player.friendsCount - 1 > i; i++) {
                if(Player.worldId != Player.friendWorlds[i] && Player.friendWorlds[1 + i] == Player.worldId || Player.friendWorlds[i] == 0 && Player.friendWorlds[i + 1] != 0) {
                    bool = false;
                    int world = Player.friendWorlds[i];
                    Player.friendWorlds[i] = Player.friendWorlds[i + 1];
                    Player.friendWorlds[1 + i] = world;
                    String name = Player.friendUsernames[i];
                    Player.friendUsernames[i] = Player.friendUsernames[1 + i];
                    Player.friendUsernames[1 + i] = name;
                    long hash = Player.friends[i];
                    Player.friends[i] = Player.friends[i + 1];
                    Player.friends[1 + i] = hash;
                    GameInterface.redrawTabArea = true;
                }
            }
        }
    }
}
