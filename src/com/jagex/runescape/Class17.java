package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.*;

public class Class17 {
    public static int anInt448;
    public static Cache aClass9_449 = new Cache(128);
    public static RSString aClass1_452 = RSString.CreateString("Loading sprites )2 ");
    public static RSString aClass1_455 = RSString.CreateString("as it was used to break our rules)3");
    public static int[] anIntArray456;
    public static RSString aClass1_457 = RSString.CreateString("Willkommen auf RuneScape");
    public static int anInt460 = 0;
    public static Font helveticaBold;
    public static Class68 aClass68_462;
    public static Class68 aClass68_463;
    public static int anInt464 = 0;
    public static RSString aClass1_465 = RSString.CreateString(":0");
    public static int[] anIntArray466 = new int[256];

    public static void method273(Class64 arg0, int arg1, boolean arg2) {
        if(Class57.aClass64_1345 != null) {
            try {
                Class57.aClass64_1345.method1009(-127);
            } catch(Exception exception) {
                /* empty */
            }
            Class57.aClass64_1345 = null;
        }
        Class57.aClass64_1345 = arg0;
        RSApplet.method19(arg2, 24041);
        Class45.aClass40_Sub1_1081.currentPosition = 0;
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
                try {
                    Class57.aClass64_1345.method1009(-123);
                } catch(Exception exception) {
                    /* empty */
                }
                Class57.aClass64_1345 = null;
                Class40_Sub5_Sub1.anInt2278++;
            }
        }
        if(arg1 < 102)
            method273(null, 92, true);
        Class22.anInt547 = 0;
        Class45.aLong1051 = System.currentTimeMillis();
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
                RSString class1 = Class60.method991((2 ^ 0x606c) ^ ~0x6004, arg1).method85(-4305);
                for(int i = 0; i < Class42.anInt1008; i++) {
                    if(arg1 == WallDecoration.ignores[i]) {
                        Class44.addChatMessage(HuffmanEncoding.blank_string, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{class1, Class68.aClass1_1628}))), 0);
                        return;
                    }
                }
                for(int i = 0; Class40_Sub5_Sub17_Sub3.friendsCount > i; i++) {
                    if(Class59.aLongArray1397[i] == arg1) {
                        Class44.addChatMessage(HuffmanEncoding.blank_string, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{Class44.aClass1_1032, class1, (Renderable.aClass1_2864)}))), 0);
                        return;
                    }
                }
                if(!class1.equals((Player.localPlayer.playerName))) {
                    WallDecoration.ignores[Class42.anInt1008++] = arg1;
                    ISAAC.redrawTabArea = true;
                    Class32.packetBuffer.putPacket(251);
                    Class32.packetBuffer.putLongBE(arg1);
                }
            }
        }
    }

    public static void method276(int arg0) {
        for(int i = arg0; Class60.anInt1407 > i; i++) {
            int i_0_;
            if(i == -1)
                i_0_ = 2047;
            else
                i_0_ = Class57.anIntArray1334[i];
            Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_0_]);
            if(class40_sub5_sub17_sub4_sub1 != null)
                Class13.method241(class40_sub5_sub17_sub4_sub1, 1, (byte) 107);
        }
    }

    public static void method277(byte arg0) {
        aClass68_462 = null;
        aClass9_449 = null;
        if(arg0 >= 75) {
            aClass1_465 = null;
            aClass1_452 = null;
            aClass1_455 = null;
            aClass68_463 = null;
            aClass1_457 = null;
            anIntArray456 = null;
            helveticaBold = null;
            anIntArray466 = null;
        }
    }
}
