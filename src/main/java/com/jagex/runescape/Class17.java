package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.*;

public class Class17 {
    public static int regionY;
    public static Cache aClass9_449 = new Cache(128);
    public static int[] anIntArray456;
    public static int deregisterActorCount = 0;
    public static Font helveticaBold;
    public static Class68 aClass68_462;
    public static Class68 aClass68_463;
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
            Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class37.aClass23_869.method329(false));
            if(class40_sub5_sub13 == null)
                break;
            Class51.aClass23_1194.put(class40_sub5_sub13, (byte) 126, class40_sub5_sub13.key);
            anInt464--;
            Class68.anInt1618++;
        }
        for(; ; ) {
            Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class34.aClass23_841.method329(false));
            if(class40_sub5_sub13 == null)
                break;
            InteractiveObject.aClass27_485.method367(true, class40_sub5_sub13);
            GameObjectDefinition.aClass23_2545.put(class40_sub5_sub13, (byte) -121, (class40_sub5_sub13.key));
            Class42.anInt1006--;
            HashTable.anInt554++;
        }
        if(Class8.aByte302 != 0) {
            try {
                Buffer class40_sub1 = new Buffer(4);
                class40_sub1.putByte(4);
                class40_sub1.putByte(Class8.aByte302);
                class40_sub1.putShortBE(0);
                Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.buffer));
            } catch(java.io.IOException ioexception) {
                ioexception.printStackTrace();
                try {
                    Class57.aClass64_1345.method1009();
                } catch(Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                Class57.aClass64_1345 = null;
                Class40_Sub5_Sub1.anInt2278++;
            }
        }
        if(arg1 < 102)
            method273(null, 92, true);
        Class22.anInt547 = 0;
        LinkedList.aLong1051 = System.currentTimeMillis();
    }

    public static int method274(boolean arg0) {
        if(!arg0)
            aClass68_463 = null;
        return Class49.anInt1147++;
    }

    public static void method275(long arg1) {
        if(arg1 != 0L) {
            if(Class42.anInt1008 >= 100)
                Class44.addChatMessage(HuffmanEncoding.blank_string, Landscape.aClass1_1180, 0);
            else {
                RSString class1 = Class60.method991(-107, arg1).method85();
                for(int i = 0; i < Class42.anInt1008; i++) {
                    if(arg1 == WallDecoration.ignores[i]) {
                        Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings((new RSString[]{class1, Class68.aClass1_1628}))), 0);
                        return;
                    }
                }
                for(int i = 0; Item.friendsCount > i; i++) {
                    if(Class59.aLongArray1397[i] == arg1) {
                        Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings((new RSString[]{Class44.aClass1_1032, class1, (Renderable.aClass1_2864)}))), 0);
                        return;
                    }
                }
                if(!class1.equals((Player.localPlayer.playerName))) {
                    WallDecoration.ignores[Class42.anInt1008++] = arg1;
                    ISAAC.redrawTabArea = true;
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
            Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_0_]);
            if(class40_sub5_sub17_sub4_sub1 != null)
                Class13.method241(class40_sub5_sub17_sub4_sub1, 1, (byte) 107);
        }
    }

    public static void method277() {
        aClass68_462 = null;
        aClass9_449 = null;
        Native.prefixColonZero = null;
        English.loadingSprites = null;
        English.asItWasUsedToBreakOurRules = null;
        aClass68_463 = null;
        anIntArray456 = null;
        helveticaBold = null;
        anIntArray466 = null;
    }
}
