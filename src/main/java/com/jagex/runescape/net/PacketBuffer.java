package com.jagex.runescape.net;

import com.jagex.runescape.*;
import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.scene.SceneCluster;

import java.math.BigInteger;

public class PacketBuffer extends Buffer {
    public static int anInt2231 = 1;
    public static boolean hiddenButtonTest = false;
    public static Effect[] effects = new Effect[50];
    public static RSString str_Please_Wait = RSString.CreateString("Please wait)3)3)3");
    public static long aLong2241 = 0L;
    public static int currentSound = 0;
    public static Class40_Sub5_Sub13 aClass40_Sub5_Sub13_2250;
    public static boolean aBoolean2255 = false;
    public static int lastClickX = 0;
    public static int anInt2257;
    public static int anInt2258;

    public ISAAC inCipher;
    public ISAAC outCipher;
    public int bitoffset;

    public PacketBuffer(int arg0) {
        super(arg0);
    }

    public static void method513(int arg0, CacheIndex_Sub1 arg1, Class56 arg2, byte arg3) {
        Class40_Sub6 class40_sub6 = new Class40_Sub6();
        class40_sub6.anInt2112 = 1;
        class40_sub6.key = (long) arg0;
        class40_sub6.aClass56_2117 = arg2;
        class40_sub6.aClass6_Sub1_2104 = arg1;
        synchronized(RSCanvas.aLinkedList_53) {
            if(arg3 != -28)
                method521(false, -84, -120);
            RSCanvas.aLinkedList_53.pushBack(class40_sub6, -72);
        }
        HashTable.method332(600);
    }

    public static void method514() {
        aClass40_Sub5_Sub13_2250 = null;
        effects = null;
        str_Please_Wait = null;
    }

    public static void method516() {
        SceneCluster.packetBuffer.putPacket(176);
        if(Class29.tabAreaOverlayWidgetId != -1) {
            Class55.method958(Class29.tabAreaOverlayWidgetId);
            CacheIndex_Sub1.anInt1819 = -1;
            IdentityKit.drawTabIcons = true;
            ISAAC.redrawTabArea = true;
            Class29.tabAreaOverlayWidgetId = -1;
        }
        if(ChatBox.openChatboxWidgetId != -1) {
            Class55.method958(ChatBox.openChatboxWidgetId);
            CacheIndex_Sub1.anInt1819 = -1;
            ChatBox.redrawChatbox = true;
            ChatBox.openChatboxWidgetId = -1;
        }
        if(ActorDefinition.openFullScreenWidgetId != -1) {
            Class55.method958(ActorDefinition.openFullScreenWidgetId);
            ActorDefinition.openFullScreenWidgetId = -1;
            OverlayDefinition.method559(30);
        }
        if(UnderlayDefinition.openSecondaryWidgetId != -1) {
            Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
            UnderlayDefinition.openSecondaryWidgetId = -1;
        }
        if(HuffmanEncoding.openScreenWidgetId != -1) {
            Class55.method958(HuffmanEncoding.openScreenWidgetId);
            HuffmanEncoding.openScreenWidgetId = -1;
            CacheIndex_Sub1.anInt1819 = -1;
        }
    }

    public static void method517(int arg0, int arg1) {
        SceneCluster.packetBuffer.putPacket(132);
        SceneCluster.packetBuffer.putIntME2(arg1);
        SceneCluster.packetBuffer.putShortLE(arg0);
    }

    public static RSString method521(boolean arg0, int arg2, int arg3) {
        if(arg2 < 1 || arg2 > 36)
            arg2 = 10;
        int i = 1;
        int i_2_ = arg3 / arg2;
        while(i_2_ != 0) {
            i_2_ /= arg2;
            i++;
        }
        int i_3_ = i;
        if(arg3 < 0 || arg0)
            i_3_++;
        byte[] is = new byte[i_3_];
        if(arg3 < 0)
            is[0] = (byte) 45;
        else if(arg0)
            is[0] = (byte) 43;
        for(int i_4_ = 0; i > i_4_; i_4_++) {
            int i_5_ = arg3 % arg2;
            arg3 /= arg2;
            if(i_5_ < 0)
                i_5_ = -i_5_;
            if(i_5_ > 9)
                i_5_ += 39;
            is[-1 + (i_3_ - i_4_)] = (byte) (48 + i_5_);
        }
        RSString class1 = new RSString();
        class1.chars = is;
        class1.length = i_3_;
        return class1;
    }

    public int method510(int arg1) {
        return 8 * arg1 - bitoffset;
    }

    public void finishBitAccess() {
        currentPosition = (7 + bitoffset) / 8;
    }

    public int getPacket() {
        return 0xff & (buffer[currentPosition++] - inCipher.nextInt());
    }

    public int getBits(int arg0) {
        int i = bitoffset >> 3;
        int i_0_ = 0;
        int i_1_ = 8 - (0x7 & bitoffset);
        bitoffset += arg0;
        for(/**/; i_1_ < arg0; i_1_ = 8) {
            i_0_ += (VarbitDefinition.anIntArray2361[i_1_] & buffer[i++]) << -i_1_ + arg0;
            arg0 -= i_1_;
        }
        if(arg0 != i_1_)
            i_0_ += (VarbitDefinition.anIntArray2361[arg0] & buffer[i] >> -arg0 + i_1_);
        else
            i_0_ += (buffer[i] & VarbitDefinition.anIntArray2361[i_1_]);
        return i_0_;
    }

    public void putPacket(int packetId) {
        buffer[currentPosition++] = (byte) ((packetId + outCipher.nextInt()) & 0xff);
    }

    public void initInCipher(int[] seed) {
        inCipher = new ISAAC(seed);
    }

    public void initOutCipher(int[] seed) {
        outCipher = new ISAAC(seed);
    }

    public void initBitAccess() {
        bitoffset = currentPosition * 8;
    }
}
