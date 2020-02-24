package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;
import java.awt.image.*;

public class Class68_Sub1 extends Class68 implements ImageProducer, ImageObserver {
    public static RSString aClass1_2198 = RSString.CreateString("Name eingeben:");
    public static int[] anIntArray2199 = new int[32];
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2204;
    public static int[] anIntArray2207 = {0, -1, 0, 1};
    public static RSString aClass1_2209 = RSString.CreateString("Login server offline)3");
    public static int anInt2210;
    public static int anInt2211 = 2;
    public static Class68 aClass68_2213;

    static {
        int i = 2;
        for(int i_7_ = 0; i_7_ < 32; i_7_++) {
            anIntArray2199[i_7_] = -1 + i;
            i += i;
        }
    }

    public ColorModel colorModel;
    public ImageConsumer anImageConsumer2197;

    public static void method1047() {
        aClass68_2213 = null;
        aClass40_Sub5_Sub14_Sub4Array2204 = null;
        aClass1_2209 = null;
        aClass1_2198 = null;
        anIntArray2199 = null;
        anIntArray2207 = null;
    }

    public static void parsePlayerUpdateMasks(Player player, int mask, int arg3) {
        if((0x100 & mask) != 0) {
            int i = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            int i_0_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.method785(i_0_, Node.anInt926, i, -122);
            player.anInt3139 = 300 + Node.anInt926;
            player.anInt3130 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            player.anInt3101 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
        }
        if((mask & 0x10 ^ 0xffffffff) != -1) {
            player.facePositionX = Cache.outgoingbuffer.getUnsignedShortBE();
            player.facePositionY = Cache.outgoingbuffer.getUnsignedShortLE();
        }
        if((mask & 0x1 ^ 0xffffffff) != -1) {
            int i = Cache.outgoingbuffer.getUnsignedShortLE();
            if(i == 65535)
                i = -1;
            int i_1_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
            ActorDefinition.method570(i, i_1_, player, -1);
        }
        if((mask & 0x4) != 0) {
            player.facingActorIndex = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
            if((player.facingActorIndex ^ 0xffffffff) == -65536)
                player.facingActorIndex = -1;
        }
        if((0x40 & mask) != 0) {
            int i = Cache.outgoingbuffer.getUnsignedByte();
            int i_2_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.method785(i_2_, Node.anInt926, i, -123);
            player.anInt3139 = 300 + Node.anInt926;
            player.anInt3130 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.anInt3101 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
        }
        if((mask & 0x400) != 0) {
            player.anInt3125 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            player.anInt3081 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            player.anInt3099 = Cache.outgoingbuffer.getUnsignedByte();
            player.anInt3127 = Cache.outgoingbuffer.getUnsignedByte();
            player.anInt3112 = (Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE() + Node.anInt926);
            player.anInt3107 = (Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE() + Node.anInt926);
            player.anInt3073 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.method790(0);
        }
        if((0x8 & mask ^ 0xffffffff) != -1) { // chat?...
            int i = Cache.outgoingbuffer.getUnsignedShortBE();
            int i_3_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            int i_4_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
            int i_5_ = Cache.outgoingbuffer.currentPosition;
            if(player.playerName != null && player.aClass30_3282 != null) {
                long l = player.playerName.method58((byte) 101);
                boolean bool = false;
                if(i_3_ <= 1) {
                    for(int i_6_ = 0; i_6_ < Class42.anInt1008; i_6_++) {
                        if((Class53.aLongArray1267[i_6_] ^ 0xffffffffffffffffL) == (l ^ 0xffffffffffffffffL)) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && Class4.anInt182 == 0) {
                    Class59.aClass40_Sub1_1385.currentPosition = 0;
                    Cache.outgoingbuffer.putNegativeOffsetBytes(0, Class59.aClass40_Sub1_1385.buffer, i_4_);
                    Class59.aClass40_Sub1_1385.currentPosition = 0;
                    RSString class1 = Class54.method956(124, Class59.aClass40_Sub1_1385).method53(-16315);
                    player.forcedChatMessage = class1.trim();
                    player.anInt3078 = 150;
                    player.anInt3123 = i & 0xff;
                    player.anInt3102 = i >> 8;
                    if((i_3_ ^ 0xffffffff) == -3 || (i_3_ ^ 0xffffffff) == -4)
                        Class44.method895(68, 1, class1, (Class40_Sub5_Sub17_Sub6.method832(75, (new RSString[]{Widget.goldCrown, player.playerName}))));
                    else if((i_3_ ^ 0xffffffff) == -2)
                        Class44.method895(123, 1, class1, (Class40_Sub5_Sub17_Sub6.method832(-79, (new RSString[]{Class51.whiteCrown, player.playerName}))));
                    else
                        Class44.method895(127, 2, class1, player.playerName);
                }
            }
            Cache.outgoingbuffer.currentPosition = i_4_ + i_5_;
        }
        if((0x20 & mask) != 0) { // appearance
            int appearanceUpdateLength = Cache.outgoingbuffer.getUnsignedByte();
            byte[] is = new byte[appearanceUpdateLength];
            Buffer buffer = new Buffer(is);
            Cache.outgoingbuffer.getBytes(appearanceUpdateLength, 0, is);
            Class22.aClass40_Sub1Array534[arg3] = buffer;
            player.parsePlayerAppearanceData((byte) -85, buffer);
        }
        if((mask & 0x200) != 0) { // graphics?
            player.anInt3091 = Cache.outgoingbuffer.getUnsignedShortLE();
            int i = Cache.outgoingbuffer.getIntME1();
            player.anInt3129 = 0;
            player.anInt3093 = Node.anInt926 + (i & 0xffff);
            if((player.anInt3091 ^ 0xffffffff) == -65536)
                player.anInt3091 = -1;
            player.anInt3140 = 0;
            player.anInt3110 = i >> -1354160784;
            if(player.anInt3093 > Node.anInt926)
                player.anInt3140 = -1;
        }
        if((0x80 & mask ^ 0xffffffff) != -1) { // forced chat
            player.forcedChatMessage = Cache.outgoingbuffer.getRSString();
            if(player.forcedChatMessage.method55(0, false) != 126) {
                if(player == Player.localPlayer)
                    Class44.method895(99, 2, player.forcedChatMessage, player.playerName);
            } else {
                player.forcedChatMessage = player.forcedChatMessage.substring(1);
                Class44.method895(120, 2, player.forcedChatMessage, player.playerName);
            }
            player.anInt3078 = 150;
            player.anInt3102 = 0;
            player.anInt3123 = 0;
        }
    }

    public static Class40_Sub5_Sub7 method1050(int arg0, int arg1) {
        Class40_Sub5_Sub7 class40_sub5_sub7 = ((Class40_Sub5_Sub7) Class40_Sub5_Sub6.aClass9_2439.method231((long) arg0, (byte) 47));
        if(arg1 != 2)
            anInt2211 = -106;
        if(class40_sub5_sub7 != null)
            return class40_sub5_sub7;
        byte[] is = Class40_Sub5_Sub7.aCacheIndex_2484.getFile(arg0, 12);
        class40_sub5_sub7 = new Class40_Sub5_Sub7();
        if(is != null)
            class40_sub5_sub7.method594(-1, new Buffer(is));
        class40_sub5_sub7.method591((byte) 37);
        Class40_Sub5_Sub6.aClass9_2439.method230(arg1 + -7210, (long) arg0, class40_sub5_sub7);
        return class40_sub5_sub7;
    }

    public static boolean method1051(int arg0, Widget arg1) {
        if(arg0 != 300)
            return false;
        int i = arg1.anInt2639;
        if(i >= 1 && i <= 200 || i >= 701 && i <= 900) {
            if(i >= 801)
                i -= 701;
            else if(i >= 701)
                i -= 601;
            else if(i < 101)
                i--;
            else
                i -= 101;
            Class40_Sub7.anInt2122++;
            OverlayDefinition.method558(0, Class66.aClass1_1572, 0, arg0 + -801, 0, 13, Class40_Sub5_Sub17_Sub6.method832(arg0 ^ ~0x103, (new RSString[]{Class26.aClass1_620, (Class40_Sub11.aClass1Array2147[i])})));
            OverlayDefinition.method558(0, Class58.aClass1_1354, 0, -501, 0, 18, Class40_Sub5_Sub17_Sub6.method832(arg0 + -192, (new RSString[]{Class26.aClass1_620, (Class40_Sub11.aClass1Array2147[i])})));
            return true;
        }
        if(i >= 401 && (i ^ 0xffffffff) >= -501) {
            CacheIndex_Sub1.anInt1793++;
            OverlayDefinition.method558(0, Class66.aClass1_1572, 0, -501, 0, 35, (Class40_Sub5_Sub17_Sub6.method832(115, (new RSString[]{Class26.aClass1_620, arg1.aClass1_2668}))));
            return true;
        }
        return false;
    }

    public static int method1052(int arg0, RSString arg1, Buffer arg2) {
        if(arg0 < 24)
            aClass1_2209 = null;
        int i = arg2.currentPosition;
        arg2.putSmart(arg1.length);
        arg2.currentPosition += (IdentityKit.aClass66_2590.method1026(-18678, 0, arg2.currentPosition, arg1.length, arg1.chars, arg2.buffer));
        return -i + arg2.currentPosition;

    }

    public synchronized boolean isConsumer(ImageConsumer arg0) {
        return anImageConsumer2197 == arg0;
    }

    public synchronized void method1048(byte arg0) {
        if(anImageConsumer2197 != null) {
            int i = -99 / ((7 - arg0) / 62);
            anImageConsumer2197.setPixels(0, 0, anInt1619, anInt1617, colorModel, anIntArray1621, 0, anInt1619);
            anImageConsumer2197.imageComplete(2);
        }
    }

    public void method1044(int arg0, int arg1, Graphics arg2, int arg3) {
        if(arg0 != 0)
            anIntArray2199 = null;
        method1048((byte) -65);
        arg2.drawImage(anImage1625, arg1, arg3, this);
    }

    public synchronized void removeConsumer(ImageConsumer arg0) {
        if(arg0 == anImageConsumer2197)
            anImageConsumer2197 = null;
    }


    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        return true;
    }

    public synchronized void addConsumer(ImageConsumer arg0) {
        anImageConsumer2197 = arg0;
        arg0.setDimensions(anInt1619, anInt1617);
        arg0.setProperties(null);
        arg0.setColorModel(colorModel);
        arg0.setHints(14);
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
        anIntArray1621 = new int[1 + arg1 * arg3];
        anInt1619 = arg1;
        anInt1617 = arg3;
        colorModel = new DirectColorModel(32, 16711680, 65280, 255);
        anImage1625 = arg2.createImage(this);
        method1048((byte) -100);
        arg2.prepareImage(anImage1625, this);
        if(arg0 < 4)
            method1048((byte) -7);
        method1048((byte) -95);
        arg2.prepareImage(anImage1625, this);
        method1048((byte) -81);
        arg2.prepareImage(anImage1625, this);
        this.method1046((byte) 90);
    }

    public void startProduction(ImageConsumer arg0) {
        addConsumer(arg0);
    }

    public void requestTopDownLeftRightResend(ImageConsumer ic) {

    }
}
