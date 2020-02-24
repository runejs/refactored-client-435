package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class37 {
    public static int anInt859;
    public static RSString aClass1_860 = RSString.CreateString("Bitte benutzen Sie eine andere Welt)3");
    public static int anInt861;
    public static int anInt862;
    public static int anInt863;
    public static int anInt864;
    public static int anInt865;
    public static int anInt866;
    public static RSString aClass1_867 = RSString.CreateString("Ein kostenloses Spielkonto erstellen)3");
    public static int anInt868;
    public static HashTable aClass23_869 = new HashTable(32);
    public static int anInt870;
    public static boolean aBoolean871 = false;
    public static RSString aClass1_872 = RSString.CreateString("Ihre Nachricht an: ");
    public static RSString aClass1_873;
    public static int anInt874;
    public static RSString aClass1_875;
    public static int anInt876 = 0;
    public static RSString aClass1_877 = RSString.CreateString("@gr1@");
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array878;
    public static RSString aClass1_879 = RSString.CreateString("weiss:");
    public static RSString aClass1_880 = RSString.CreateString("Wir vermuten ihr Spielkonto wurde gestohlen");

    static {
        aClass1_875 = (RSString.CreateString("Please close the interface you have open before using (Wreport abuse(W"));
        aClass1_873 = aClass1_875;
        anInt874 = 0;
    }

    public static int method430(byte arg0, int arg1, int arg2, int arg3) {

        anInt865++;
        int i = arg3 >> 430067431;
        int i_0_ = arg2 >> -141886201;
        if((i_0_ ^ 0xffffffff) > -1 || (i ^ 0xffffffff) > -1 || (i_0_ ^ 0xffffffff) < -104 || i > 103)
            return 0;
        int i_1_ = 0x7f & arg2;
        int i_2_ = arg1;
        if(i_2_ < 3 && (Floor.tile_flags[1][i_0_][i] & 0x2) == 2)
            i_2_++;
        int i_3_ = (((-i_1_ + 128) * (Class40_Sub6.tile_height[i_2_][i_0_][i]) + (i_1_ * (Class40_Sub6.tile_height[i_2_][i_0_ + 1][i]))) >> -1503923001);
        int i_4_ = arg3 & 0x7f;
        if(arg0 > -116)
            method432((byte) -86);
        int i_5_ = ((i_1_ * (Class40_Sub6.tile_height[i_2_][1 + i_0_][1 + i]) + (Class40_Sub6.tile_height[i_2_][i_0_][1 + i] * (128 + -i_1_))) >> -820366297);
        return (128 + -i_4_) * i_3_ + (i_5_ * i_4_) >> 2117999111;

    }

    public static Class40_Sub5_Sub2 method431(int arg0, int arg1) {

        if(arg1 != 13)
            method436(-34);
        anInt861++;
        Class40_Sub5_Sub2 class40_sub5_sub2 = ((Class40_Sub5_Sub2) Class43.aClass9_1014.method231((long) arg0, (byte) 59));
        if(class40_sub5_sub2 != null)
            return class40_sub5_sub2;
        byte[] is = Class19.aCacheIndex_488.getFile(arg0, 13);
        class40_sub5_sub2 = new Class40_Sub5_Sub2();
        class40_sub5_sub2.anInt2310 = arg0;
        if(is != null)
            class40_sub5_sub2.method551(new Buffer(is), (byte) 61);
        Class43.aClass9_1014.method230(-7208, (long) arg0, class40_sub5_sub2);
        return class40_sub5_sub2;

    }

    public static void method432(byte arg0) {

        System.out.println("Usage: worldid, [live/office/local], [live/rc/wip], [lowmem/highmem], [free/members], [english/german]");
        System.exit(1);
        if(arg0 > 0)
            anInt870++;

    }

    public static void method433(int arg0) {

        aClass1_872 = null;
        aClass23_869 = null;
        aClass1_875 = null;
        aClass1_860 = null;
        aClass40_Sub5_Sub14_Sub4Array878 = null;
        aClass1_879 = null;
        aClass1_880 = null;
        aClass1_873 = null;
        if(arg0 == -29013) {
            aClass1_867 = null;
            aClass1_877 = null;
        }

    }

    public static void method434(int arg0) {

        Class4.menuOpen = false;
        Class57.incomingPacket = -1;
        ActorDefinition.anInt2394 = 0;
        Widget.packetsize = 0;
        Class32.packetBuffer.currentPosition = 0;
        RSString.anInt1690 = -1;
        Cache.anInt324 = -1;
        Class35.anInt1728 = 0;
        Class49.anInt1151 = -1;
        Class40_Sub5_Sub4.anInt2366 = 0;
        anInt868++;
        Class27.anInt658 = 0;
        Class40_Sub5_Sub15.anInt2782 = 0;
        Cache.outgoingbuffer.currentPosition = arg0;
        for(int i = 0; ((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156).length > i); i++) {
            if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i]) != null)
                Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i].facingActorIndex = -1;
        }
        for(int i = 0; ((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813.length > i)); i++) {
            if(CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i] != null)
                CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i].facingActorIndex = -1;
        }
        Floor.method559(30, -88);

    }

    public static void method435(boolean arg0) {

        RSCanvas.method45((byte) -106);
        anInt864++;
        if(Class27.anInt658 == 2) {
            int[] is = Rasterizer.pixels;
            byte[] is_6_ = Class34.mapBack.imgPixels;
            int i = is_6_.length;
            for(int i_7_ = 0; i > i_7_; i_7_++) {
                if((is_6_[i_7_] ^ 0xffffffff) == -1)
                    is[i_7_] = 0;
            }
            Class40_Sub5_Sub7.aClass40_Sub5_Sub14_Sub4_2482.method724(0, 0, 33, 33, 25, 25, Class58.cameraHorizontal, 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
            ActorDefinition.method574(4);
        } else {
            int i = 48 + ((Player.localPlayer.anInt3098) / 32);
            int i_8_ = 464 + -((Player.localPlayer.anInt3089) / 32);
            int i_9_ = Class58.cameraHorizontal + Class43.cameraYawOffset & 0x7ff;
            Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.method724(25, 5, 146, 151, i, i_8_, i_9_, Class51.mapZoomOffset + 256, Landscape.anIntArray1186, Class34.anIntArray852);
            for(int i_10_ = 0; GameObject.anInt3040 > i_10_; i_10_++) {
                i = 2 + (4 * Actor.anIntArray3149[i_10_] + -((Player.localPlayer.anInt3098) / 32));
                i_8_ = (2 + 4 * Class45.anIntArray1083[i_10_] - ((Player.localPlayer.anInt3089) / 32));
                SceneTile.drawOnMinimap(i_8_, i, (GameFrame.aClass40_Sub5_Sub14_Sub4Array1466[i_10_]));
            }
            for(int i_11_ = 0; (i_11_ ^ 0xffffffff) > -105; i_11_++) {
                for(int i_12_ = 0; i_12_ < 104; i_12_++) {
                    Class45 class45 = (Class10.aClass45ArrayArrayArray357[Player.anInt3267][i_11_][i_12_]);
                    if(class45 != null) {
                        i_8_ = -((Player.localPlayer.anInt3089) / 32) + 2 + i_12_ * 4;
                        i = -((Player.localPlayer.anInt3098) / 32) + 2 + i_11_ * 4;
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[0]);
                    }
                }
            }
            for(int i_13_ = 0; GameObjectDefinition.anInt2558 > i_13_; i_13_++) {
                Npc class40_sub5_sub17_sub4_sub2 = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i_13_]]);
                if(class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.isVisible(1)) {
                    ActorDefinition class40_sub5_sub5 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300);
                    if(class40_sub5_sub5.childrenIds != null)
                        class40_sub5_sub5 = class40_sub5_sub5.getChildDefinition(-1);
                    if(class40_sub5_sub5 != null && class40_sub5_sub5.renderOnMinimap && class40_sub5_sub5.isClickable) {
                        i = (-((Player.localPlayer.anInt3098) / 32) + (class40_sub5_sub17_sub4_sub2.anInt3098 / 32));
                        i_8_ = (class40_sub5_sub17_sub4_sub2.anInt3089 / 32 + -((Player.localPlayer.anInt3089) / 32));
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[1]);
                    }
                }
            }
            for(int i_14_ = 0; (Class60.anInt1407 > i_14_); i_14_++) {
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_14_]]);
                if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.isVisible(1)) {
                    i = (class40_sub5_sub17_sub4_sub1.anInt3098 / 32 + -((Player.localPlayer.anInt3098) / 32));
                    i_8_ = (-((Player.localPlayer.anInt3089) / 32) + class40_sub5_sub17_sub4_sub1.anInt3089 / 32);
                    boolean bool = false;
                    long l = class40_sub5_sub17_sub4_sub1.playerName.method58((byte) 122);
                    for(int i_15_ = 0; Class40_Sub5_Sub17_Sub3.anInt3060 > i_15_; i_15_++) {
                        if(l == Class59.aLongArray1397[i_15_] && (Class40_Sub7.anIntArray2131[i_15_] ^ 0xffffffff) != -1) {
                            bool = true;
                            break;
                        }
                    }
                    boolean bool_16_ = false;
                    if(((Player.localPlayer.anInt3266) != 0) && (class40_sub5_sub17_sub4_sub1.anInt3266 ^ 0xffffffff) != -1 && (((Player.localPlayer.anInt3266) ^ 0xffffffff) == (class40_sub5_sub17_sub4_sub1.anInt3266 ^ 0xffffffff)))
                        bool_16_ = true;
                    if(bool)
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[3]);
                    else if(bool_16_)
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[4]);
                    else
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[2]);
                }
            }
            if((Player.anInt3288 ^ 0xffffffff) != -1 && (Node.anInt926 % 20 ^ 0xffffffff) > -11) {
                if(Player.anInt3288 == 1 && (Class66.anInt1545 ^ 0xffffffff) <= -1 && ((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813).length > Class66.anInt1545)) {
                    Npc class40_sub5_sub17_sub4_sub2 = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class66.anInt1545]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        i = (-((Player.localPlayer.anInt3098) / 32) + (class40_sub5_sub17_sub4_sub2.anInt3098 / 32));
                        i_8_ = (class40_sub5_sub17_sub4_sub2.anInt3089 / 32 - (Player.localPlayer.anInt3089) / 32);
                        Floor.drawMinimapMark((Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1]), i, i_8_);
                    }
                }
                if((Player.anInt3288 ^ 0xffffffff) == -3) {
                    i_8_ = (-((Player.localPlayer.anInt3089) / 32) + 2 + 4 * (-Class26.anInt635 + Class4.anInt175));
                    i = (4 * (Class68.anInt1637 - Class40_Sub5_Sub2.anInt2307) - (-2 + ((Player.localPlayer.anInt3098) / 32)));
                    Floor.drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], i, i_8_);
                }
                if(Player.anInt3288 == 10 && (Class68.anInt1623 ^ 0xffffffff) <= -1 && ((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156).length > Class68.anInt1623)) {
                    Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class68.anInt1623]);
                    if(class40_sub5_sub17_sub4_sub1 != null) {
                        i_8_ = (-((Player.localPlayer.anInt3089) / 32) + (class40_sub5_sub17_sub4_sub1.anInt3089 / 32));
                        i = (class40_sub5_sub17_sub4_sub1.anInt3098 / 32 - (Player.localPlayer.anInt3098) / 32);
                        Floor.drawMinimapMark((Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1]), i, i_8_);
                    }
                }
            }
            if((Class40_Sub5_Sub4.anInt2366 ^ 0xffffffff) != -1) {
                i = (2 + Class40_Sub5_Sub4.anInt2366 * 4 + -((Player.localPlayer.anInt3098) / 32));
                i_8_ = 2 + (4 * Class55.anInt1304 + -((Player.localPlayer.anInt3089) / 32));
                SceneTile.drawOnMinimap(i_8_, i, (Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[0]));
            }
            Rasterizer.method656(97, 78, 3, 3, 16777215);
            Class40_Sub5_Sub7.aClass40_Sub5_Sub14_Sub4_2482.method724(0, 0, 33, 33, 25, 25, Class58.cameraHorizontal, 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
            if(arg0 == true)
                ActorDefinition.method574(4);
        }

    }

    public static void method436(int arg0) {

        anInt862++;
        if(arg0 < 95)
            method436(25);
        for(Class40_Sub2 class40_sub2 = ((Class40_Sub2) Class40_Sub5_Sub1.aClass45_2268.method902((byte) -90)); class40_sub2 != null; class40_sub2 = (Class40_Sub2) Class40_Sub5_Sub1.aClass45_2268.method909(-4)) {
            if(class40_sub2.aClass40_Sub9_Sub2_2001 != null) {
                Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2001);
                class40_sub2.aClass40_Sub9_Sub2_2001 = null;
            }
            if(class40_sub2.aClass40_Sub9_Sub2_2010 != null) {
                Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2010);
                class40_sub2.aClass40_Sub9_Sub2_2010 = null;
            }
        }
        Class40_Sub5_Sub1.aClass45_2268.method906(0);

    }

    public static void method437(int arg0, boolean arg1, int arg2, int arg3, int arg4, GameObjectDefinition arg5) {
        anInt866++;
        Class40_Sub2 class40_sub2 = new Class40_Sub2();
        class40_sub2.anInt2000 = 128 * arg5.anInt2502;
        if(arg1 != true)
            method438(119, -54, (byte) 96);
        class40_sub2.anInt2002 = arg5.anInt2542;
        class40_sub2.anIntArray2005 = arg5.anIntArray2523;
        class40_sub2.anInt2012 = arg5.anInt2499;
        int i = arg5.sizeX;
        int i_17_ = arg5.sizeY;
        class40_sub2.anInt1993 = arg2;
        class40_sub2.anInt1994 = arg4 * 128;
        if(arg3 == 1 || arg3 == 3) {
            i = arg5.sizeY;
            i_17_ = arg5.sizeX;
        }
        class40_sub2.anInt2003 = 128 * arg0;
        class40_sub2.anInt2007 = (i_17_ + arg0) * 128;
        class40_sub2.anInt2013 = (arg4 + i) * 128;
        class40_sub2.anInt1997 = arg5.anInt2513;
        if(arg5.configChangeDest != null) {
            class40_sub2.aGameObjectDefinition_2011 = arg5;
            class40_sub2.method528(57);
        }
        Class40_Sub5_Sub1.aClass45_2268.method904(class40_sub2, -126);
        if(class40_sub2.anIntArray2005 != null)
            class40_sub2.anInt2014 = (int) ((double) (class40_sub2.anInt2002 - class40_sub2.anInt2012) * Math.random()) + class40_sub2.anInt2012;
    }

    public static boolean method438(int arg0, int arg1, byte arg2) {

        anInt859++;
        if((arg0 ^ 0xffffffff) == -1 && arg1 == HashTable.anInt573)
            return true;
        if(arg0 == 1 && FloorDecoration.anInt614 == arg1)
            return true;
        if(((arg0 ^ 0xffffffff) == -3 || (arg0 ^ 0xffffffff) == -4) && Class67.anInt1586 == arg1)
            return true;
        if(arg2 != 52)
            aClass1_860 = null;
        return false;

    }
}
