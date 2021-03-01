package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.util.TextUtils;

import java.awt.*;

public class Class17 {
    public static int regionY;
    public static int[] anIntArray456;
    public static int deregisterActorCount = 0;
    public static Font helveticaBold;
    public static ProducingGraphicsBuffer chatboxTop;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_463;
    public static int anInt464 = 0;
    public static int[] anIntArray466 = new int[256];

    public static void method273(Class64 arg0, int arg1, boolean arg2) {
        if(Class57.aClass64_1345 != null) {
            try {
                Class57.aClass64_1345.method1009();
            } catch(Exception exception) {
                exception.printStackTrace();
                /* empty */
            }
            Class57.aClass64_1345 = null;
        }
        Class57.aClass64_1345 = arg0;
        GameShell.method19(arg2, 24041);
        LinkedList.aClass40_Sub1_1081.currentPosition = 0;
        Class40_Sub5_Sub13.aClass40_Sub1_2752 = null;
        Landscape.anInt1157 = 0;
        PacketBuffer.aClass40_Sub5_Sub13_2250 = null;
        for(; ; ) {
            Class40_Sub5_Sub13 class40_sub5_sub13 = (Class40_Sub5_Sub13) Class37.aClass23_869.method329();
            if(class40_sub5_sub13 == null)
                break;
            Class51.aClass23_1194.put(class40_sub5_sub13.key, class40_sub5_sub13);
            anInt464--;
            ProducingGraphicsBuffer.anInt1618++;
        }
        for(; ; ) {
            Class40_Sub5_Sub13 class40_sub5_sub13 = (Class40_Sub5_Sub13) MovedStatics.aClass23_841.method329();
            if(class40_sub5_sub13 == null)
                break;
            InteractiveObject.aNodeQueue_485.unshift(class40_sub5_sub13);
            GameObjectDefinition.aClass23_2545.put(class40_sub5_sub13.key, class40_sub5_sub13);
            Class42.anInt1006--;
            MovedStatics.anInt554++;
        }
        if(Class8.aByte302 != 0) {
            try {
                Buffer class40_sub1 = new Buffer(4);
                class40_sub1.putByte(4);
                class40_sub1.putByte(Class8.aByte302);
                class40_sub1.putShortBE(0);
                Class57.aClass64_1345.method1010(4, (byte) -19, 0, class40_sub1.buffer);
            } catch(java.io.IOException ioexception) {
                ioexception.printStackTrace();
                try {
                    Class57.aClass64_1345.method1009();
                } catch(Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                Class57.aClass64_1345 = null;
                MovedStatics.anInt2278++;
            }
        }
        if(arg1 < 102)
            method273(null, 92, true);
        Class22.anInt547 = 0;
        LinkedList.aLong1051 = System.currentTimeMillis();
    }

    public static int method274(boolean arg0) {
        if(!arg0)
            aProducingGraphicsBuffer_463 = null;
        return Class49.anInt1147++;
    }

    public static void method275(long arg1) {
        if(arg1 != 0L) {
            if(Class42.anInt1008 >= 100)
                ChatBox.addChatMessage("", English.yourIgnoreListIsFull.toString(), 0);
            else {
                String class1 = TextUtils.formatName(TextUtils.longToName(arg1));
                for(int i = 0; i < Class42.anInt1008; i++) {
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
                    Player.ignores[Class42.anInt1008++] = arg1;
                    GameInterface.redrawTabArea = true;
                    SceneCluster.packetBuffer.putPacket(251);
                    SceneCluster.packetBuffer.putLongBE(arg1);
                }
            }
        }
    }

    public static void method276(int arg0) {
        for(int i = arg0; Player.localPlayerCount > i; i++) {
            int i_0_;
            if(i == -1)
                i_0_ = 2047;
            else
                i_0_ = Player.trackedPlayerIndices[i];
            Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_0_];
            if(class40_sub5_sub17_sub4_sub1 != null)
                Class13.method241(class40_sub5_sub17_sub4_sub1, (byte) 107);
        }
    }

}
