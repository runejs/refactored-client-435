package org.runejs.client;

import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.util.TextUtils;

import java.awt.*;

public class Class17 {
    public static int regionY;
    public static int[] anIntArray456;
    public static int deregisterActorCount = 0;
    public static Font helveticaBold;
    public static ProducingGraphicsBuffer chatboxTop;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_463;
    public static int[] anIntArray466 = new int[256];

    public static int method274(boolean arg0) {
        if(!arg0)
            aProducingGraphicsBuffer_463 = null;
        return Class49.anInt1147++;
    }

    public static void method275(long arg1) {
        if(arg1 != 0L) {
            if(MovedStatics.anInt1008 >= 100)
                ChatBox.addChatMessage("", English.yourIgnoreListIsFull.toString(), 0);
            else {
                String class1 = TextUtils.formatName(TextUtils.longToName(arg1));
                for(int i = 0; i < MovedStatics.anInt1008; i++) {
                    if(arg1 == Player.ignores[i]) {
                        ChatBox.addChatMessage("", class1 + English.suffixIsAlreadyOnYourIgnoreList, 0);
                        return;
                    }
                }
                for(int i = 0; Player.friendsCount > i; i++) {
                    if(Class59.friends[i] == arg1) {
                        ChatBox.addChatMessage("", English.pleaseRemove + class1 + English.fromYourFriendListFirst, 0);
                        return;
                    }
                }
                if(!class1.equals(Player.localPlayer.playerName)) {
                    Player.ignores[MovedStatics.anInt1008++] = arg1;
                    GameInterface.redrawTabArea = true;
                    SceneCluster.packetBuffer.putPacket(251);
                    SceneCluster.packetBuffer.putLongBE(arg1);
                }
            }
        }
    }

    public static void animatePlayers(int playerIndex) {
        for(int currentPlayerIndex = playerIndex; Player.localPlayerCount > currentPlayerIndex; currentPlayerIndex++) {
            int actualIndex;
            if(currentPlayerIndex == -1)
                actualIndex = 2047;
            else
                actualIndex = Player.trackedPlayerIndices[currentPlayerIndex];
            Player player = Player.trackedPlayers[actualIndex];
            if(player != null)
                Class13.handleActorAnimation(player);
        }
    }

}
