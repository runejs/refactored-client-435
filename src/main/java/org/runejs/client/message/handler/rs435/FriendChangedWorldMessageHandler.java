package org.runejs.client.message.handler.rs435;

import org.runejs.client.Class59;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.English;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.ForcedPrivateMessageInboundMessage;
import org.runejs.client.message.inbound.FriendChangedWorldInboundMessage;

/**
 * A {@link MessageHandler} that handles {@link FriendChangedWorldMessageHandler}s.
 */
public class FriendChangedWorldMessageHandler implements MessageHandler<FriendChangedWorldInboundMessage> {
    @Override
    public void handle(FriendChangedWorldInboundMessage message) {
        String string = Player.longToUsername(message.username).method85().toString();
        for(int i_2_ = 0; i_2_ < Player.friendsCount; i_2_++) {
            if(message.username == Class59.friends[i_2_]) {
                if(message.worldId != Player.friendWorlds[i_2_]) {
                    Player.friendWorlds[i_2_] = message.worldId;
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
        boolean bool = false;
        if(string != null && Player.friendsCount < 200) {
            Class59.friends[Player.friendsCount] = message.username;
            Player.friendUsernames[Player.friendsCount] = string;
            Player.friendWorlds[Player.friendsCount] = message.worldId;
            Player.friendsCount++;
            GameInterface.redrawTabArea = true;
        }
        while(!bool) {
            bool = true;
            for(int i_3_ = 0; Player.friendsCount - 1 > i_3_; i_3_++) {
                if(Player.worldId != Player.friendWorlds[i_3_] && Player.friendWorlds[1 + i_3_] == Player.worldId || Player.friendWorlds[i_3_] == 0 && Player.friendWorlds[i_3_ + 1] != 0) {
                    bool = false;
                    int i_4_ = Player.friendWorlds[i_3_];
                    Player.friendWorlds[i_3_] = Player.friendWorlds[i_3_ + 1];
                    Player.friendWorlds[1 + i_3_] = i_4_;
                    String class1_5_ = Player.friendUsernames[i_3_];
                    Player.friendUsernames[i_3_] = Player.friendUsernames[1 + i_3_];
                    Player.friendUsernames[1 + i_3_] = class1_5_;
                    long l_6_ = Class59.friends[i_3_];
                    Class59.friends[i_3_] = Class59.friends[i_3_ + 1];
                    Class59.friends[1 + i_3_] = l_6_;
                    GameInterface.redrawTabArea = true;
                }
            }
        }
    }
}
