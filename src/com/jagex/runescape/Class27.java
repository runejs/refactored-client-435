package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.NpcDefinition;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class27 {
    public static RSString aClass1_638 = Class58.method978("invback");
    public static RSString aClass1_643 = Class58.method978(")2");
    public static RSString aClass1_647 = Class58.method978("sich mit einer anderen Welt zu verbinden)3");
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array649;
    public static RSString aClass1_652 = Class58.method978("und loggen sich dann erneut ein)3");
    public static Class6 aClass6_654;
    public static int anInt658 = 0;
    public static int anInt661;
    public static RSString takeString = Class58.method978("Take");
    public static RSString aClass1_664 = Class58.method978("Offline");
    public static RSString takeStringInstance = takeString;
    public static int[] anIntArray666 = new int[]{1, 0, -1, 0};
    public static RSString aClass1_668 = Class58.method978("Loading game screen )2 ");
    public SubNode aClass40_Sub5_660 = new SubNode();

    public Class27() {
        aClass40_Sub5_660.aClass40_Sub5_2087 = aClass40_Sub5_660;
        aClass40_Sub5_660.aClass40_Sub5_2082 = aClass40_Sub5_660;
    }

    public static void method353(byte arg0) {
        Class40_Sub5_Sub11.anInt2628++;
        Class40_Sub5_Sub17_Sub6.method833(0, true);
        ItemDefinition.method749(true);
        Class40_Sub5_Sub17_Sub6.method833(0, false);
        ItemDefinition.method749(false);
        HashTable.method335((byte) 61);
        Class61.method1000(true);
        if(!Class39.aBoolean906) {
            int i = Class65.anInt1537;
            if(Class40_Sub6.anInt2107 / 256 > i)
                i = Class40_Sub6.anInt2107 / 256;
            int i_0_ = 0x7ff & Class58.cameraHorizontal + Class57.anInt1342;
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[4] && 128 + RSApplet.anIntArray2[4] > i)
                i = 128 + RSApplet.anIntArray2[4];
            Class49.method929(i, Class40_Sub5_Sub6.anInt2437, -50 + (Class37.method430((byte) -123, Player.anInt3267, (Class40_Sub5_Sub13.localPlayer.anInt3098), (Class40_Sub5_Sub13.localPlayer.anInt3089))), i_0_, Class34.anInt849, -1, 3 * i + 600);
        }
        int i;
        if(!Class39.aBoolean906)
            i = Class40_Sub5_Sub17_Sub1.method764((byte) -107);
        else
            i = Class40_Sub5_Sub1.method546(256);
        int i_1_ = Class12.anInt388;
        int i_2_ = Class68_Sub1.anInt2210;
        int i_3_ = Class32.anInt769;
        int i_4_ = Class26.anInt627;
        int i_5_ = Class40_Sub5_Sub6.anInt2443;
        for(int i_6_ = 0; i_6_ < 5; i_6_++) {
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_6_]) {
                int i_7_ = (int) (((double) (Class8.anIntArray297[i_6_] * 2 + 1) * Math.random()) - (double) Class8.anIntArray297[i_6_] + (Math.sin((double) (Class22_Sub1.anIntArray1846[i_6_]) * ((double) (Class58.anIntArray1358[i_6_]) / 100.0)) * (double) RSApplet.anIntArray2[i_6_]));
                if(i_6_ == 1)
                    Class32.anInt769 += i_7_;
                if((i_6_ ^ 0xffffffff) == -1) {
                    Class12.anInt388 += i_7_;
                }
                if((i_6_ ^ 0xffffffff) == -3)
                    Class40_Sub5_Sub6.anInt2443 += i_7_;
                if((i_6_ ^ 0xffffffff) == -5) {
                    Class26.anInt627 += i_7_;
                    if((Class26.anInt627 ^ 0xffffffff) > -129)
                        Class26.anInt627 = 128;
                    if((Class26.anInt627 ^ 0xffffffff) < -384)
                        Class26.anInt627 = 383;
                }
                if((i_6_ ^ 0xffffffff) == -4)
                    Class68_Sub1.anInt2210 = 0x7ff & i_7_ + Class68_Sub1.anInt2210;
            }
        }
        Class65.method1018((byte) 74);
        Model.anInt3198 = Landscape.mouseY - 4;
        Model.aBoolean3207 = true;
        Model.anInt3229 = Class13.mouseX + -4;
        Model.anInt3220 = 0;
        Rasterizer.method663();
        Npc.aScene_3301.method97(Class12.anInt388, Class32.anInt769, Class40_Sub5_Sub6.anInt2443, Class26.anInt627, Class68_Sub1.anInt2210, i);
        Npc.aScene_3301.method104();
        Class33.method404((byte) -28);
        Class38_Sub1.method450((byte) -67);
        ((Class35) R3D.anInterface3_2939).method425((byte) 6, Class5.anInt199);
        Class54.method954(-15454);
        if(ISAAC.aBoolean519 && (method368((byte) -41, false, true) ^ 0xffffffff) == -1)
            ISAAC.aBoolean519 = false;
        if(ISAAC.aBoolean519) {
            Class65.method1018((byte) -125);
            Rasterizer.method663();
            Class51.method940(0, Class67.aClass1_1585, false, null);
        }
        Player.method792(110);
        Class12.anInt388 = i_1_;
        Class40_Sub5_Sub6.anInt2443 = i_5_;
        Class68_Sub1.anInt2210 = i_2_;
        Class26.anInt627 = i_4_;
        Class32.anInt769 = i_3_;
        if(arg0 >= -98)
            drawScrollBar(-36, 10, 23, 0, 3, -27);
    }

    public static void method354(byte arg0) {
        Actor.anInt3153 = 0;
        Class17.anInt460 = 0;
        Actor.method786(true);
        Class29.method373((byte) -5);
        Class34.method419((byte) 108);
        Class40_Sub5_Sub11.method633(-1);
        for(int i = 0; Class17.anInt460 > i; i++) {
            int i_8_ = Class6.anIntArray225[i];
            if(((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_8_].anInt3134) ^ 0xffffffff) != (Node.anInt926 ^ 0xffffffff))
                Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_8_] = null;
        }
        if((Cache.outgoingbuffer.currentPosition ^ 0xffffffff) != (Class40_Sub5_Sub12.packetsize ^ 0xffffffff))
            throw new RuntimeException("gpp1 pos:" + (Cache.outgoingbuffer.currentPosition) + " psize:" + Class40_Sub5_Sub12.packetsize);
        int i = 0;
        if(arg0 < 50)
            aClass6_654 = null;
        for(/**/; Class60.anInt1407 > i; i++) {
            if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i]]) == null)
                throw new RuntimeException("gpp2 pos:" + i + " size:" + Class60.anInt1407);
        }
    }

    public static void drawScrollBar(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        int i = (-32 + arg4) * arg4 / arg2;
        Class6.aClass40_Sub5_Sub14_Sub2Array215[arg0].drawImage(arg3, arg5);
        Class6.aClass40_Sub5_Sub14_Sub2Array215[1].drawImage(arg3, arg5 - (-arg4 + 16));
        Rasterizer.method656(arg3, arg5 + 16, 16, arg4 + -32, Class55.anInt1299);
        if((i ^ 0xffffffff) > -9)
            i = 8;
        int i_9_ = (-32 + arg4 - i) * arg1 / (-arg4 + arg2);
        Rasterizer.method656(arg3, 16 + arg5 + i_9_, 16, i, Cache.anInt321);
        Rasterizer.method668(arg3, 16 + arg5 + i_9_, i, Class66.anInt1559);
        Rasterizer.method668(1 + arg3, i_9_ + arg5 + 16, i, Class66.anInt1559);
        Rasterizer.method659(arg3, i_9_ + arg5 + 16, 16, Class66.anInt1559);
        Rasterizer.method659(arg3, 17 + (arg5 + i_9_), 16, Class66.anInt1559);
        Rasterizer.method668(arg3 + 15, arg5 + 16 + i_9_, i, Class56.anInt1318);
        Rasterizer.method668(arg3 + 14, i_9_ + 17 + arg5, i - 1, Class56.anInt1318);
        Rasterizer.method659(arg3, i + (i_9_ + (15 + arg5)), 16, Class56.anInt1318);
        Rasterizer.method659(arg3 + 1, 14 + (arg5 + i_9_ + i), 15, Class56.anInt1318);
    }

    public static void method356(int arg0) {
        aClass1_647 = null;
        if(arg0 == -333) {
            aClass40_Sub5_Sub14_Sub4Array649 = null;
            takeString = null;
            aClass6_654 = null;
            aClass1_638 = null;
            aClass1_652 = null;
            aClass1_668 = null;
            takeStringInstance = null;
            anIntArray666 = null;
            aClass1_664 = null;
            aClass1_643 = null;
        }
    }

    public static void method357(Class6 arg0, int arg1, Class6 arg2) {
        Class58.aClass6_1375 = arg2;
        Class67.aClass6_1577 = arg0;
        if(arg1 == -10978)
            return;
        method365(-3);

    }

    public static void method358(int arg0, int arg1) {
        if(arg1 >= 0) {
            int i = Class19.anIntArray483[arg1];
            int i_10_ = Class59.anIntArray1393[arg1];
            int action = Class38.anIntArray884[arg1];
            if(action >= 2000)
                action -= 2000;
            int i_12_ = Class33.anIntArray791[arg1];
            if((Class40_Sub5_Sub15.inputType ^ 0xffffffff) != -1 && (action ^ 0xffffffff) != -1006) {
                Class40_Sub5_Sub15.inputType = 0;
                Class52.redrawChatbox = true;
            }
            if(action == 37) {
                Class32.packetBuffer.putPacket(21);
                Class32.packetBuffer.putIntLE(Class60.anInt1417);
                Class32.packetBuffer.putIntME2(i_10_);
                Class32.packetBuffer.putShortBE(i_12_);
                Class32.packetBuffer.putShortBE(i);
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                Class52.anInt1233 = i;
                RSRuntimeException.anInt1651 = 0;
                if(Class66.anInt1560 == i_10_ >> 16)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                Class30.anInt704 = i_10_;
                if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 38) {
                boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 105, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                Class68.anInt1622++;
                if(!bool)
                    bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 92, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                Floor.anInt2319 = 0;
                Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                Class40_Sub11.anInt2163 = Class57.anInt1338;
                Class45.anInt1075 = 2;
                Class32.packetBuffer.putPacket(190);
                Class32.packetBuffer.putOffsetShortLE(i + Class40_Sub5_Sub2.anInt2307);
                Class32.packetBuffer.putShortBE(i_12_);
                Class32.packetBuffer.putShortBE(i_10_ + Class26.anInt635);
            }
            if(action == 1004) {
                Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                Class30.anInt707++;
                Class40_Sub11.anInt2163 = Class57.anInt1338;
                Class45.anInt1075 = 2;
                Floor.anInt2319 = 0;
                Class32.packetBuffer.putPacket(148);
                Class32.packetBuffer.putShortLE(i_12_ >> 14 & 0x7fff);
            }
            if((action ^ 0xffffffff) == -28) {
                Class40_Sub5_Sub7.method596(i, i_12_, (byte) -79, i_10_);
                Class32.packetBuffer.putPacket(229);
                Class40_Sub6.anInt2115++;
                Class32.packetBuffer.putShortLE(Class40_Sub5_Sub2.anInt2307 + i);
                Class32.packetBuffer.putShortLE((0x1ffffd20 & i_12_) >> 14);
                Class32.packetBuffer.putShortLE(Class26.anInt635 + i_10_);
            }
            if(action == 1) {
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class40_Sub5_Sub4.anInt2355++;
                    Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub1.anIntArray3088[0], (byte) 112, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub1.anIntArray3135[0], 2);
                    Class40_Sub11.anInt2163 = Class57.anInt1338;
                    Floor.anInt2319 = 0;
                    Class45.anInt1075 = 2;
                    Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                    Class32.packetBuffer.putPacket(221);
                    Class32.packetBuffer.putIntME1(Class60.anInt1417);
                    Class32.packetBuffer.putShortLE(i_12_);
                }
            }
            if((action ^ 0xffffffff) == -27 || (action ^ 0xffffffff) == -47) {
                RSString class1 = Landscape.aClass1Array1184[arg1];
                int i_13_ = class1.method60(Class26.aClass1_620);
                if((i_13_ ^ 0xffffffff) != 0) {
                    class1 = class1.substring(i_13_ + 5).method89(false);
                    RSString class1_14_ = class1.method62(57).method85(-4305);
                    boolean bool = false;
                    for(int i_15_ = 0; i_15_ < Class60.anInt1407; i_15_++) {
                        Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_15_]]);
                        if(class40_sub5_sub17_sub4_sub1 != null && (class40_sub5_sub17_sub4_sub1.playerName != null) && class40_sub5_sub17_sub4_sub1.playerName.equalsIgnoreCase(class1_14_, true)) {
                            bool = true;
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3088[0]), (byte) 114, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3135[0]), 2);
                            if(action == 26) {
                                Class32.packetBuffer.putPacket(96);
                                Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class57.anIntArray1334[i_15_], -128);
                                Class29.anInt677++;
                            }
                            if((action ^ 0xffffffff) == -47) {
                                Class32.packetBuffer.putPacket(68);
                                Class32.packetBuffer.putShortLE(Class57.anIntArray1334[i_15_]);
                                Class52.anInt1227++;
                            }
                            break;
                        }
                    }
                    if(!bool)
                        Class44.method895(90, 0, (Class40_Sub5_Sub17_Sub6.method832(-46, new RSString[]{Class12.aClass1_397, class1_14_})), Class66.blank_string);
                }
            }
            if(action == 55) {
                Class32.packetBuffer.putPacket(26);
                Class32.packetBuffer.putCustomNegativeOffsetShortBE(i, -128);
                Class32.packetBuffer.putIntLE(i_10_);
                Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                Class30.anInt704 = i_10_;
                RSRuntimeException.anInt1651 = 0;
                Class52.anInt1233 = i;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == Class66.anInt1560)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 53) {
                Class32.packetBuffer.putPacket(38);
                Class40_Sub5_Sub12.anInt2634++;
                Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                Class32.packetBuffer.putShortLE(i);
                Class32.packetBuffer.putIntME1(i_10_);
                Class52.anInt1233 = i;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                RSRuntimeException.anInt1651 = 0;
                Class30.anInt704 = i_10_;
                if((Class66.anInt1560 ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if((action ^ 0xffffffff) == -58) {
                Class32.packetBuffer.putPacket(64);
                Class32.packetBuffer.putIntBE(i_10_);
                Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -93);
                if(class40_sub5_sub12.anIntArrayArray2748 != null && (class40_sub5_sub12.anIntArrayArray2748[0][0] ^ 0xffffffff) == -6) {
                    int i_16_ = class40_sub5_sub12.anIntArrayArray2748[0][1];
                    if(class40_sub5_sub12.anIntArray2693[0] != Class58.varbitmasks[i_16_]) {
                        Class58.varbitmasks[i_16_] = class40_sub5_sub12.anIntArray2693[0];
                        Class22.method309(-1, i_16_);
                        ISAAC.redrawTabArea = true;
                    }
                }
            }
            if(action == 52) {
                Class32.packetBuffer.putPacket(240);
                Class32.packetBuffer.putOffsetShortLE(i);
                Class32.packetBuffer.putShortLE(i_12_);
                Class32.packetBuffer.putIntME2(i_10_);
                Class52.anInt1233 = i;
                Class30.anInt704 = i_10_;
                RSRuntimeException.anInt1651 = 0;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                if((Class66.anInt1560 ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 10) {
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub1.anIntArray3088[0], (byte) 109, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub1.anIntArray3135[0], 2);
                    Class40_Sub11.anInt2163 = Class57.anInt1338;
                    Class52.anInt1227++;
                    Class45.anInt1075 = 2;
                    Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                    Floor.anInt2319 = 0;
                    Class32.packetBuffer.putPacket(68);
                    Class32.packetBuffer.putShortLE(i_12_);
                }
            }
            if((action ^ 0xffffffff) == -15) {
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class29.anInt677++;
                    Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub1.anIntArray3088[0], (byte) 92, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub1.anIntArray3135[0], 2);
                    Floor.anInt2319 = 0;
                    Class45.anInt1075 = 2;
                    Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                    Class40_Sub11.anInt2163 = Class57.anInt1338;
                    Class32.packetBuffer.putPacket(96);
                    Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                }
            }
            if(action == 1001) {
                Class40_Sub11.anInt2163 = Class57.anInt1338;
                Class45.anInt1075 = 2;
                Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                Floor.anInt2319 = 0;
                Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    NpcDefinition class40_sub5_sub5 = class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300;
                    if(class40_sub5_sub5.childrenIds != null)
                        class40_sub5_sub5 = class40_sub5_sub5.method577(-1);
                    if(class40_sub5_sub5 != null) {
                        Class32.packetBuffer.putPacket(247);
                        Class32.packetBuffer.putOffsetShortLE(class40_sub5_sub5.anInt2427);
                    }
                }
            }
            if(action == 22) {
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub1.anIntArray3088[0], (byte) 94, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub1.anIntArray3135[0], 2);
                    Class40_Sub11.anInt2163 = Class57.anInt1338;
                    Class45.anInt1075 = 2;
                    Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                    Floor.anInt2319 = 0;
                    Class32.packetBuffer.putPacket(110);
                    Class32.packetBuffer.putOffsetShortLE(i_12_);
                    Class32.packetBuffer.putIntME1(ISAAC.anInt525);
                    Class32.packetBuffer.putShortBE(Class49.anInt1154);
                    Class32.packetBuffer.putShortBE(Class45.anInt1061);
                }
            }
            if(action == 19) {
                Class49.anInt1154 = i_12_;
                Class45.anInt1061 = i;
                ISAAC.anInt525 = i_10_;
                Class8.anInt301 = 1;
                Npc.aClass1_3295 = (Class40_Sub5_Sub17_Sub6.method832(78, (new RSString[]{VertexNormal.aClass1_1114, ItemDefinition.forId(i_12_, 10).name, Class26.aClass1_620})));
                Main.anInt1773 = 0;
                if(Npc.aClass1_3295 == null)
                    Npc.aClass1_3295 = RSApplet.aClass1_34;
                ISAAC.redrawTabArea = true;
            } else {
                if((action ^ 0xffffffff) == -16) {
                    GameObject.anInt3020++;
                    boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 102, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                    if(!bool)
                        bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 117, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                    Floor.anInt2319 = 0;
                    Class45.anInt1075 = 2;
                    Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                    Class40_Sub11.anInt2163 = Class57.anInt1338;
                    Class32.packetBuffer.putPacket(168);
                    Class32.packetBuffer.putShortLE(i_12_);
                    Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class40_Sub5_Sub2.anInt2307 + i, -128);
                    Class32.packetBuffer.putIntME1(Class60.anInt1417);
                    Class32.packetBuffer.putShortBE(Class26.anInt635 + i_10_);
                }
                if(action == 23) {
                    Class32.packetBuffer.putPacket(64);
                    Class32.packetBuffer.putIntBE(i_10_);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -68);
                    if(class40_sub5_sub12.anIntArrayArray2748 != null && class40_sub5_sub12.anIntArrayArray2748[0][0] == 5) {
                        int i_17_ = class40_sub5_sub12.anIntArrayArray2748[0][1];
                        Class58.varbitmasks[i_17_] = -Class58.varbitmasks[i_17_] + 1;
                        Class22.method309(-1, i_17_);
                        ISAAC.redrawTabArea = true;
                    }
                }
                if(action == 48) {
                    Class32.packetBuffer.putPacket(147);
                    Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                    Class32.packetBuffer.putShortLE(i);
                    Class32.packetBuffer.putIntLE(i_10_);
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                    Class52.anInt1233 = i;
                    Class30.anInt704 = i_10_;
                    if(Class66.anInt1560 == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                    if(Class43.openChatboxWidgetId == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    RSRuntimeException.anInt1651 = 0;
                }
                if(action == 18) {
                    RSString class1 = Landscape.aClass1Array1184[arg1];
                    int i_18_ = class1.method60(Class26.aClass1_620);
                    if((i_18_ ^ 0xffffffff) != 0) {
                        long l = class1.substring(5 + i_18_).method89(false).method58((byte) 107);
                        int i_19_ = -1;
                        for(int i_20_ = 0; i_20_ < Class40_Sub5_Sub17_Sub3.anInt3060; i_20_++) {
                            if((l ^ 0xffffffffffffffffL) == (Class59.aLongArray1397[i_20_] ^ 0xffffffffffffffffL)) {
                                i_19_ = i_20_;
                                break;
                            }
                        }
                        if(i_19_ != -1 && Class40_Sub7.anIntArray2131[i_19_] > 0) {
                            Class37.anInt876 = 3;
                            Class52.redrawChatbox = true;
                            Class40_Sub5_Sub15.inputType = 0;
                            Class66.aClass1_1565 = Class66.blank_string;
                            Class19.aBoolean490 = true;
                            PacketBuffer.aLong2241 = Class59.aLongArray1397[i_19_];
                            Class66.aClass1_1563 = (Class40_Sub5_Sub17_Sub6.method832(58, new RSString[]{Class35.aClass1_1746, (Class40_Sub11.aClass1Array2147[i_19_])}));
                        }
                    }
                }
                if(action == 1003) {
                    Floor.anInt2319 = 0;
                    Class45.anInt1075 = 2;
                    Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                    Class40_Sub11.anInt2163 = Class57.anInt1338;
                    Class32.packetBuffer.putPacket(151);
                    Class32.packetBuffer.putOffsetShortLE(i_12_);
                }
                if((action ^ 0xffffffff) == -1003) {
                    Class40_Sub5_Sub7.method596(i, i_12_, (byte) -11, i_10_);
                    SubNode.anInt2089++;
                    Class32.packetBuffer.putPacket(62);
                    Class32.packetBuffer.putShortBE((0x1fffd05d & i_12_) >> 14);
                    Class32.packetBuffer.putShortLE(i_10_ + Class26.anInt635);
                    Class32.packetBuffer.putOffsetShortLE(i + Class40_Sub5_Sub2.anInt2307);
                }
                if((action ^ 0xffffffff) == -31) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Class40_Sub13.anInt2180++;
                        Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub2.anIntArray3088[0], (byte) 107, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub2.anIntArray3135[0], 2);
                        Floor.anInt2319 = 0;
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Class45.anInt1075 = 2;
                        Class32.packetBuffer.putPacket(57);
                        Class32.packetBuffer.putShortBE(i_12_);
                    }
                }
                if((action ^ 0xffffffff) == -50) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub2.anIntArray3088[0], (byte) 112, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub2.anIntArray3135[0], 2);
                        Class35.anInt1719++;
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Floor.anInt2319 = 0;
                        Class45.anInt1075 = 2;
                        Class32.packetBuffer.putPacket(208);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class49.anInt1154, -128);
                        Class32.packetBuffer.putOffsetShortLE(Class45.anInt1061);
                        Class32.packetBuffer.putIntBE(ISAAC.anInt525);
                    }
                }
                if(action == 29) {
                    Class40_Sub5_Sub7.method596(i, i_12_, (byte) -77, i_10_);
                    Class32.packetBuffer.putPacket(164);
                    Class32.packetBuffer.putOffsetShortLE(Class40_Sub5_Sub2.anInt2307 + i);
                    Class32.packetBuffer.putOffsetShortLE(Class26.anInt635 + i_10_);
                    Class32.packetBuffer.putOffsetShortLE(i_12_ >> 14 & 0x7fff);
                }
                if((action ^ 0xffffffff) == -6 && Class40_Sub5_Sub7.method596(i, i_12_, (byte) -104, i_10_)) {
                    SubNode.anInt2085++;
                    Class32.packetBuffer.putPacket(24);
                    Class32.packetBuffer.putOffsetShortLE(i_10_ + Class26.anInt635);
                    Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class49.anInt1154, -128);
                    Class32.packetBuffer.putShortLE((i_12_ & 0x1fffccf7) >> 14);
                    Class32.packetBuffer.putOffsetShortLE(Class45.anInt1061);
                    Class32.packetBuffer.putIntME1(ISAAC.anInt525);
                    Class32.packetBuffer.putOffsetShortLE(i + Class40_Sub5_Sub2.anInt2307);
                }
                if(action == 34) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), class40_sub5_sub17_sub4_sub2.anIntArray3088[0], (byte) 126, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), class40_sub5_sub17_sub4_sub2.anIntArray3135[0], 2);
                        Floor.anInt2319 = 0;
                        Class45.anInt1075 = 2;
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Class32.packetBuffer.putPacket(0);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                    }
                }
                if(action == 56) {
                    Class32.packetBuffer.putPacket(40);
                    Class32.packetBuffer.putOffsetShortLE(i_12_);
                    Class34.anInt803++;
                    Class32.packetBuffer.putOffsetShortLE(i);
                    Class32.packetBuffer.putIntLE(i_10_);
                    Class32.packetBuffer.putIntLE(ISAAC.anInt525);
                    Class32.packetBuffer.putShortLE(Class49.anInt1154);
                    Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class45.anInt1061, -128);
                    Class30.anInt704 = i_10_;
                    RSRuntimeException.anInt1651 = 0;
                    Class52.anInt1233 = i;
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                    if((i_10_ >> 16 ^ 0xffffffff) == (Class66.anInt1560 ^ 0xffffffff))
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                    if(Class43.openChatboxWidgetId == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                }
                if((action ^ 0xffffffff) == -34) {
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -105);
                    ISAAC.redrawTabArea = true;
                    Main.anInt1773 = 1;
                    Class38_Sub1.aClass1_1918 = class40_sub5_sub12.aClass1_2664;
                    ItemDefinition.anInt2815 = class40_sub5_sub12.anInt2702;
                    Class8.anInt301 = 0;
                    Class60.anInt1417 = i_10_;
                    FloorDecoration.aClass1_611 = (Class40_Sub5_Sub17_Sub6.method832(-80, new RSString[]{Landscape.aClass1_1162, class40_sub5_sub12.aClass1_2709, Class26.aClass1_620}));
                    if((ItemDefinition.anInt2815 ^ 0xffffffff) == -17) {
                        IdentityKit.aBoolean2597 = true;
                        Class5.currentTabId = 3;
                        ISAAC.redrawTabArea = true;
                    }
                } else {
                    if((action ^ 0xffffffff) == -1008) {
                        Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -59);
                        if(class40_sub5_sub12 != null && (class40_sub5_sub12.aClass40_Sub5_Sub12Array2713 != null) && (i ^ 0xffffffff) != 0)
                            class40_sub5_sub12 = (class40_sub5_sub12.aClass40_Sub5_Sub12Array2713[i]);
                        if(class40_sub5_sub12 == null || class40_sub5_sub12.anInt2734 < 100000) {
                            Class32.packetBuffer.putPacket(151);
                            Class32.packetBuffer.putOffsetShortLE(i_12_);
                        } else
                            Class44.method895(83, 0, (Class40_Sub5_Sub17_Sub6.method832(127, (new RSString[]{HashTable.method334((class40_sub5_sub12.anInt2734), -1), Class65.aClass1_1536, (ItemDefinition.forId(i_12_, 10).name)}))), Class66.blank_string);
                    }
                    if((action ^ 0xffffffff) == -43) {
                        Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -62);
                        boolean bool = true;
                        if(class40_sub5_sub12.anInt2639 > 0)
                            bool = Class5.method166((byte) 88, class40_sub5_sub12);
                        if(bool) {
                            Class32.packetBuffer.putPacket(64);
                            Class32.packetBuffer.putIntBE(i_10_);
                        }
                    }
                    if(action == 31) {
                        Class32.packetBuffer.putPacket(163);
                        Class52.anInt1236++;
                        Class32.packetBuffer.putOffsetShortLE(i);
                        Class32.packetBuffer.putOffsetShortLE(i_12_);
                        Class32.packetBuffer.putIntBE(i_10_);
                        Class52.anInt1233 = i;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        Class30.anInt704 = i_10_;
                        RSRuntimeException.anInt1651 = 0;
                        if((i_10_ >> 16 ^ 0xffffffff) == (Class66.anInt1560 ^ 0xffffffff))
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 12) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3088[0]), (byte) 113, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3135[0]), 2);
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Class40_Sub5_Sub4.anInt2369++;
                            Floor.anInt2319 = 0;
                            Class45.anInt1075 = 2;
                            Class32.packetBuffer.putPacket(63);
                            Class32.packetBuffer.putOffsetShortLE(i_12_);
                        }
                    }
                    if(action == 2) {
                        Class40_Sub5_Sub17_Sub3.anInt3061++;
                        boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 108, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 114, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        Class45.anInt1075 = 2;
                        Floor.anInt2319 = 0;
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Class32.packetBuffer.putPacket(244);
                        Class32.packetBuffer.putShortLE(i + Class40_Sub5_Sub2.anInt2307);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class26.anInt635 + i_10_, -128);
                        Class32.packetBuffer.putShortBE(i_12_);
                    }
                    if((action ^ 0xffffffff) == -4) {
                        boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 117, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 100, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        Floor.anInt2319 = 0;
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class6_Sub1.anInt1792++;
                        Class45.anInt1075 = 2;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Class32.packetBuffer.putPacket(85);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class26.anInt635 + i_10_, -128);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                        Class32.packetBuffer.putShortLE(i + Class40_Sub5_Sub2.anInt2307);
                    }
                    if((action ^ 0xffffffff) == -22) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3088[0]), (byte) 112, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3135[0]), 2);
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Floor.anInt2319 = 0;
                            Class45.anInt1075 = 2;
                            Class32.packetBuffer.putPacket(253);
                            Class32.packetBuffer.putShortBE(i_12_);
                            Class32.packetBuffer.putIntME1(Class60.anInt1417);
                        }
                    }
                    if(action == 45 || action == 51 || (action ^ 0xffffffff) == -14 || (action ^ 0xffffffff) == -36) {
                        RSString class1 = Landscape.aClass1Array1184[arg1];
                        int i_21_ = class1.method60(Class26.aClass1_620);
                        if(i_21_ != -1) {
                            long l = class1.substring(i_21_ + 5).method89(false).method58((byte) 96);
                            if(action == 45)
                                Class40_Sub5_Sub9.method617(l, (byte) -104);
                            if((action ^ 0xffffffff) == -52)
                                Class17.method275(24686, l);
                            if(action == 13)
                                RSApplet.method28(l, 121);
                            if(action == 35)
                                Class40_Sub6.method838(0, l);
                        }
                    }
                    if((action ^ 0xffffffff) == -45) {
                        Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Class51.anInt1189++;
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3088[0]), (byte) 94, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3135[0]), 2);
                            Class45.anInt1075 = 2;
                            Floor.anInt2319 = 0;
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Class32.packetBuffer.putPacket(220);
                            Class32.packetBuffer.putShortBE(i_12_);
                        }
                    }
                    if(arg0 < 51)
                        aClass40_Sub5_Sub14_Sub4Array649 = null;
                    if((action ^ 0xffffffff) == -8) {
                        if(Class4.menuOpen)
                            Npc.aScene_3301.method120(-4 + i, -4 + i_10_);
                        else
                            Npc.aScene_3301.method120(Class57.anInt1338 - 4, -4 + RSString.anInt1668);
                    }
                    if(action == 1006) {
                        Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -111);
                        if(class40_sub5_sub12 == null || (class40_sub5_sub12.anIntArray2710[i] ^ 0xffffffff) > -100001) {
                            Class32.packetBuffer.putPacket(151);
                            Class32.packetBuffer.putOffsetShortLE(i_12_);
                        } else
                            Class44.method895(103, 0, (Class40_Sub5_Sub17_Sub6.method832(-49, (new RSString[]{HashTable.method334((class40_sub5_sub12.anIntArray2710[i]), -1), Class65.aClass1_1536, (ItemDefinition.forId(i_12_, 10).name)}))), Class66.blank_string);
                        Class52.anInt1233 = i;
                        RSRuntimeException.anInt1651 = 0;
                        Class30.anInt704 = i_10_;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(i_10_ >> 16 == Class66.anInt1560)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == Class43.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if((action ^ 0xffffffff) == -18) {
                        Class40_Sub5_Sub7.method596(i, i_12_, (byte) -104, i_10_);
                        Class32.packetBuffer.putPacket(183);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_10_ + Class26.anInt635, -128);
                        Class32.packetBuffer.putShortBE(i_12_ >> 14 & 0x7fff);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i + Class40_Sub5_Sub2.anInt2307, -128);
                    }
                    if(action == 50)
                        Class33.method406(i, i_12_, i_10_, -121);
                    if(action == 40) {
                        Class55.method958(Class48.anInt1138, -14222);
                        Class48.anInt1138 = -1;
                        Class52.redrawChatbox = true;
                    }
                    if(action == 32 && Class40_Sub5_Sub7.method596(i, i_12_, (byte) -27, i_10_)) {
                        Class32.packetBuffer.putPacket(225);
                        Class32.packetBuffer.putShortBE(i_12_ >> 14 & 0x7fff);
                        Class32.packetBuffer.putOffsetShortLE(i_10_ + Class26.anInt635);
                        Class32.packetBuffer.putIntME1(Class60.anInt1417);
                        Class32.packetBuffer.putShortLE(i + Class40_Sub5_Sub2.anInt2307);
                    }
                    if(action == 25) {
                        Class32.packetBuffer.putPacket(228);
                        Class32.packetBuffer.putShortLE(i_12_);
                        Class32.packetBuffer.putIntLE(i_10_);
                        Class32.packetBuffer.putShortLE(i);
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if((i_10_ >> 16 ^ 0xffffffff) == (Class66.anInt1560 ^ 0xffffffff))
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        Class30.anInt704 = i_10_;
                        Class52.anInt1233 = i;
                    }
                    if((action ^ 0xffffffff) == -12) {
                        Class32.packetBuffer.putPacket(29);
                        Class32.packetBuffer.putIntME1(i_10_);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i, -128);
                        Class32.packetBuffer.putShortLE(i_12_);
                        Class52.anInt1233 = i;
                        Class30.anInt704 = i_10_;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if((i_10_ >> 16 ^ 0xffffffff) == (Class66.anInt1560 ^ 0xffffffff))
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if((Class43.openChatboxWidgetId ^ 0xffffffff) == (i_10_ >> 16 ^ 0xffffffff))
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        RSRuntimeException.anInt1651 = 0;
                    }
                    if(action == 41) {
                        Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3088[0]), (byte) 117, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3135[0]), 2);
                            Class45.anInt1075 = 2;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Floor.anInt2319 = 0;
                            Class32.packetBuffer.putPacket(187);
                            Class32.packetBuffer.putOffsetShortLE(i_12_);
                            Class43.anInt1016++;
                        }
                    }
                    if((action ^ 0xffffffff) == -29) {
                        RSString class1 = Landscape.aClass1Array1184[arg1];
                        int i_22_ = class1.method60(Class26.aClass1_620);
                        if((i_22_ ^ 0xffffffff) != 0) {
                            if((Class66.anInt1560 ^ 0xffffffff) != 0)
                                Class44.method895(72, 0, Class37.aClass1_873, Class66.blank_string);
                            else {
                                PacketBuffer.method516(95);
                                if((Class34.anInt854 ^ 0xffffffff) != 0) {
                                    Class66.aClass1_1550 = class1.substring(i_22_ + 5).method89(false);
                                    Class66.anInt1548 = Class66.anInt1560 = Class34.anInt854;
                                    Class67.aBoolean1601 = false;
                                }
                            }
                        }
                    }
                    if(action == 8) {
                        boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 119, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 118, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Floor.anInt2319 = 0;
                        Class45.anInt1075 = 2;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Class32.packetBuffer.putPacket(65);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_10_ + Class26.anInt635, -128);
                        Class32.packetBuffer.putShortLE(Class40_Sub5_Sub2.anInt2307 + i);
                    }
                    if(action == 9)
                        PacketBuffer.method516(106);
                    if((action ^ 0xffffffff) == -55 && Class6_Sub1.anInt1819 == -1) {
                        PacketBuffer.method517(0, i_10_, -9225);
                        Class6_Sub1.anInt1819 = i_10_;
                    }
                    if((action ^ 0xffffffff) == -44) {
                        Class32.packetBuffer.putPacket(98);
                        Class24.anInt576++;
                        Class32.packetBuffer.putShortBE(i);
                        Class32.packetBuffer.putIntME1(i_10_);
                        Class32.packetBuffer.putShortBE(i_12_);
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(Class66.anInt1560 == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        Class52.anInt1233 = i;
                        Class30.anInt704 = i_10_;
                        if(i_10_ >> 16 == Class43.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if((action ^ 0xffffffff) == -37) {
                        boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 126, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 105, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Class45.anInt1075 = 2;
                        Floor.anInt2319 = 0;
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class32.packetBuffer.putPacket(27);
                        Class32.packetBuffer.putShortBE(Class40_Sub5_Sub2.anInt2307 + i);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_10_ + Class26.anInt635, -128);
                    }
                    if(action == 39) {
                        Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_12_]);
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Landscape.anInt1164++;
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3088[0]), (byte) 97, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub1.anIntArray3135[0]), 2);
                            Floor.anInt2319 = 0;
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Class45.anInt1075 = 2;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Class32.packetBuffer.putPacket(211);
                            Class32.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if((action ^ 0xffffffff) == -25) {
                        Class53.anInt1250++;
                        Class32.packetBuffer.putPacket(124);
                        Class32.packetBuffer.putShortBE(i);
                        Class32.packetBuffer.putIntLE(i_10_);
                        Class32.packetBuffer.putShortBE(i_12_);
                        Class30.anInt704 = i_10_;
                        RSRuntimeException.anInt1651 = 0;
                        Class52.anInt1233 = i;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(Class66.anInt1560 == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(Class43.openChatboxWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 16) {
                        Class40_Sub5_Sub7.method596(i, i_12_, (byte) -47, i_10_);
                        Class32.packetBuffer.putPacket(30);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(0x7fff & i_12_ >> 14, -128);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(Class26.anInt635 + i_10_, -128);
                        Class32.packetBuffer.putOffsetShortLE(i + Class40_Sub5_Sub2.anInt2307);
                    }
                    if(action == 20) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3088[0]), (byte) 122, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3135[0]), 2);
                            Class45.anInt1075 = 2;
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Floor.anInt2319 = 0;
                            Class32.packetBuffer.putPacket(153);
                            Class24.anInt586++;
                            Class32.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if((action ^ 0xffffffff) == -48) {
                        Class40_Sub5_Sub7.anInt2478++;
                        boolean bool = (Class38_Sub1.method448(0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 120, 0, false, 0, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), i, (byte) 103, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), i_10_, 2));
                        Class40_Sub11.anInt2163 = Class57.anInt1338;
                        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                        Floor.anInt2319 = 0;
                        Class45.anInt1075 = 2;
                        Class32.packetBuffer.putPacket(172);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i + Class40_Sub5_Sub2.anInt2307, -128);
                        Class32.packetBuffer.putShortBE(Class45.anInt1061);
                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(i_12_, -128);
                        Class32.packetBuffer.putIntME2(ISAAC.anInt525);
                        Class32.packetBuffer.putShortLE(Class26.anInt635 + i_10_);
                        Class32.packetBuffer.putShortLE(Class49.anInt1154);
                    }
                    if(action == 6) {
                        Class32.packetBuffer.putPacket(102);
                        Class32.packetBuffer.putIntLE(i_10_);
                        Class32.packetBuffer.putOffsetShortLE(i);
                        Class32.packetBuffer.putShortBE(i_12_);
                        Class40_Sub3.anInt2034++;
                        Class52.anInt1233 = i;
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        Class30.anInt704 = i_10_;
                        if(i_10_ >> 16 == Class66.anInt1560)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == Class43.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 4) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.method448(1, 0, (Class40_Sub5_Sub13.localPlayer.anIntArray3088[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3088[0]), (byte) 98, 0, false, 0, 1, (Class40_Sub5_Sub13.localPlayer.anIntArray3135[0]), (class40_sub5_sub17_sub4_sub2.anIntArray3135[0]), 2);
                            Class45.anInt1075 = 2;
                            Class40_Sub11.anInt2163 = Class57.anInt1338;
                            Floor.anInt2319 = 0;
                            Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                            Class32.packetBuffer.putPacket(116);
                            Class32.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(Class8.anInt301 != 0) {
                        Class8.anInt301 = 0;
                        ISAAC.redrawTabArea = true;
                    }
                    if(Main.anInt1773 != 0) {
                        ISAAC.redrawTabArea = true;
                        Main.anInt1773 = 0;
                    }
                }
            }
        }
    }

    public static IndexedImage method359(RSString arg0, RSString arg1, Class6 arg2, byte arg3) {
        if(arg3 != -64)
            aClass1_652 = null;
        int i = arg2.method183(0, arg0);
        int i_23_ = arg2.method179(arg3 ^ ~0x7e, i, arg1);
        return method363(arg2, (byte) -42, i_23_, i);
    }

    public static void method360(byte arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        if(Class68.method1043(arg4)) {
            if(arg0 != 125)
                drawScrollBar(-24, -60, 59, -118, 65, 12);
            RSApplet.method20(arg5, arg3, 0, arg2, arg6, -1, 1, (Class59.aClass40_Sub5_Sub12ArrayArray1390[arg4]), arg1, 0);
            if(Class10.aClass40_Sub5_Sub12_353 != null) {
                Class40_Sub5_Sub12 class40_sub5_sub12 = Class10.aClass40_Sub5_Sub12_353;
                Class40_Sub5_Sub12 class40_sub5_sub12_24_ = Class40_Sub13.method878(-1598852880, class40_sub5_sub12);
                if(class40_sub5_sub12_24_ != null) {
                    int[] is = Class13.method247(class40_sub5_sub12_24_, (byte) 97);
                    int[] is_25_ = Class13.method247(class40_sub5_sub12, (byte) 110);
                    int i = (is_25_[1] - is[1] + -Class40_Sub5_Sub11.anInt2621 + Landscape.mouseY);
                    int i_26_ = (-is[0] + is_25_[0] + (Class13.mouseX + -Class40_Sub2.anInt1996));
                    if(i < 0)
                        i = 0;
                    if(class40_sub5_sub12_24_.anInt2643 < i + class40_sub5_sub12.anInt2643)
                        i = (-class40_sub5_sub12.anInt2643 + class40_sub5_sub12_24_.anInt2643);
                    if(i_26_ < 0)
                        i_26_ = 0;
                    if((class40_sub5_sub12_24_.anInt2692 ^ 0xffffffff) > (class40_sub5_sub12.anInt2692 + i_26_ ^ 0xffffffff))
                        i_26_ = (class40_sub5_sub12_24_.anInt2692 - class40_sub5_sub12.anInt2692);
                    if((Class10.aClass40_Sub5_Sub12_353.anObjectArray2669 != null) && (arg2 & 0x200) != 0)
                        Class43.method891(class40_sub5_sub12.anObjectArray2669, 0, i, class40_sub5_sub12, i_26_, false);
                    if(Class40_Sub5_Sub2.anInt2302 == 0 && (arg2 & 0x400 ^ 0xffffffff) != -1) {
                        if(Class10.aClass40_Sub5_Sub12_353.anObjectArray2695 != null)
                            Class43.method891((class40_sub5_sub12.anObjectArray2695), 0, i, class40_sub5_sub12, i_26_, false);
                        Class10.aClass40_Sub5_Sub12_353 = null;
                    }
                }
            }
        }
    }

    public static Class40_Sub5_Sub12 method361(Class40_Sub5_Sub12[] arg0, int arg1, boolean arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg0 == null)
            return null;
        Class40_Sub5_Sub12 class40_sub5_sub12 = null;
        for(int i = 0; arg0.length > i; i++) {
            Class40_Sub5_Sub12 class40_sub5_sub12_27_ = arg0[i];
            if(class40_sub5_sub12_27_ != null && (arg4 ^ 0xffffffff) == (class40_sub5_sub12_27_.anInt2648 ^ 0xffffffff)) {
                int i_28_ = arg3 + class40_sub5_sub12_27_.anInt2696;
                int i_29_ = arg5 + class40_sub5_sub12_27_.anInt2656;
                if(i_29_ <= arg6 && i_28_ <= arg1 && (i_29_ + class40_sub5_sub12_27_.anInt2692 ^ 0xffffffff) < (arg6 ^ 0xffffffff) && ((arg1 ^ 0xffffffff) > (i_28_ + class40_sub5_sub12_27_.anInt2643 ^ 0xffffffff)) && !class40_sub5_sub12_27_.aBoolean2750) {
                    if(class40_sub5_sub12_27_.anInt2689 < 0 && arg2 || class40_sub5_sub12_27_.anInt2689 >= 0 && !arg2)
                        class40_sub5_sub12 = class40_sub5_sub12_27_;
                    if((class40_sub5_sub12_27_.anInt2683 ^ 0xffffffff) == -1) {
                        Class40_Sub5_Sub12 class40_sub5_sub12_30_ = method361(arg0, arg1, arg2, (-class40_sub5_sub12_27_.scrollPosition + (class40_sub5_sub12_27_.anInt2696)), i, (class40_sub5_sub12_27_.anInt2656 - (class40_sub5_sub12_27_.anInt2746)), arg6, 398);
                        if(class40_sub5_sub12_30_ != null)
                            class40_sub5_sub12 = class40_sub5_sub12_30_;
                        if(arg2 && (class40_sub5_sub12_27_.aClass40_Sub5_Sub12Array2713) != null) {
                            Class40_Sub5_Sub12 class40_sub5_sub12_31_ = (method361((class40_sub5_sub12_27_.aClass40_Sub5_Sub12Array2713), arg1, arg2, (class40_sub5_sub12_27_.anInt2696 + -class40_sub5_sub12_27_.scrollPosition), class40_sub5_sub12_27_.anInt2689, (class40_sub5_sub12_27_.anInt2656 - class40_sub5_sub12_27_.anInt2746), arg6, 398));
                            if(class40_sub5_sub12_31_ != null)
                                class40_sub5_sub12 = class40_sub5_sub12_31_;
                        }
                    }
                }
            }
        }
        if(arg7 != 398)
            takeStringInstance = null;
        return class40_sub5_sub12;
    }

    public static IndexedImage method363(Class6 arg0, byte arg1, int arg2, int arg3) {
        int i = 106 % ((arg1 - 66) / 53);
        if(!Class52.method948(arg2, arg3, arg0, -3844))
            return null;
        return SubNode.method538(0);

    }

    public static void method364(byte arg0, boolean arg1) {
        if(arg0 != -34)
            method368((byte) 123, true, false);
        Class22.anInt537++;
        if(Class22.anInt537 >= 50 || arg1) {
            Class22.anInt537 = 0;
            if(!Class37.aBoolean871 && Class40_Sub6.aClass64_2098 != null) {
                Class32.packetBuffer.putPacket(13);
                try {
                    Class40_Sub6.aClass64_2098.method1010(Class32.packetBuffer.currentPosition, (byte) -19, 0, Class32.packetBuffer.buffer);
                    Class32.packetBuffer.currentPosition = 0;
                } catch(java.io.IOException ioexception) {
                    Class37.aBoolean871 = true;
                }
                Class49.anInt1142++;
            }
        }
    }

    public static void method365(int arg0) {
        if(Class40_Sub5_Sub11.aBoolean2631) {
            Class40_Sub5_Sub11.aBoolean2631 = false;
            ItemDefinition.method742(arg0 ^ ~0x4e29);
            IdentityKit.aBoolean2597 = true;
            Class52.redrawChatbox = true;
            ISAAC.redrawTabArea = true;
            Cache.aBoolean330 = true;
        }
        method353((byte) -114);
        if(Class4.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 1)
            ISAAC.redrawTabArea = true;
        if(Class29.anInt673 != -1) {
            boolean bool = Renderable.method754(29378, Class29.anInt673);
            if(bool)
                ISAAC.redrawTabArea = true;
        }
        if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == -3)
            ISAAC.redrawTabArea = true;
        if(SceneTile.activeInterfaceType == 2)
            ISAAC.redrawTabArea = true;
        if(ISAAC.redrawTabArea) {
            ISAAC.redrawTabArea = false;
            Class43.drawTabArea(-29);
        }
        if(Class43.openChatboxWidgetId == -1) {
            Class12.chatboxInterface.scrollPosition = -77 + (-GameObjectDefinition.chatboxScroll + Class62.chatboxScrollMax);
            if(Class13.mouseX > 448 && Class13.mouseX < 560 && Landscape.mouseY > 332)
                Class5.scrollInterface(77, Landscape.mouseY + -357, -17 + Class13.mouseX, Class62.chatboxScrollMax, (byte) 114, Class12.chatboxInterface, 463, -1, 0);
            int currentScroll = (Class62.chatboxScrollMax - 77 - Class12.chatboxInterface.scrollPosition);
            if(currentScroll < 0)
                currentScroll = 0;
            if(currentScroll > Class62.chatboxScrollMax + -77)
                currentScroll = -77 + Class62.chatboxScrollMax;
            if(currentScroll != GameObjectDefinition.chatboxScroll) {
                GameObjectDefinition.chatboxScroll = currentScroll;
                Class52.redrawChatbox = true;
            }
        }
        if(Class43.openChatboxWidgetId == -1 && Class40_Sub5_Sub15.inputType == 3) {
            Class12.chatboxInterface.scrollPosition = Class26.itemSearchScroll;
            int scrollMax = 14 * VertexNormal.itemSearchResultCount + 7;
            if(Class13.mouseX > 448 && Class13.mouseX < 560 && Landscape.mouseY > 332)
                Class5.scrollInterface(77, Landscape.mouseY - 357, -17 + Class13.mouseX, scrollMax, (byte) -128, Class12.chatboxInterface, 463, -1, 0);
            int currentScroll = Class12.chatboxInterface.scrollPosition;
            if(currentScroll < 0)
                currentScroll = 0;
            if(currentScroll > scrollMax - 77)
                currentScroll = scrollMax - 77;
            if(currentScroll != Class26.itemSearchScroll) {
                Class26.itemSearchScroll = currentScroll;
                Class52.redrawChatbox = true;
            }
        }
        if(arg0 == -20197) {
            if(Class43.openChatboxWidgetId != -1) {
                boolean bool = Renderable.method754(29378, Class43.openChatboxWidgetId);
                if(bool)
                    Class52.redrawChatbox = true;
            }
            if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == 3)
                Class52.redrawChatbox = true;
            if((SceneTile.activeInterfaceType ^ 0xffffffff) == -4)
                Class52.redrawChatbox = true;
            if(RSApplet.aClass1_8 != null)
                Class52.redrawChatbox = true;
            if(Class4.menuOpen && (Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -3)
                Class52.redrawChatbox = true;
            if(Class52.redrawChatbox) {
                Class52.redrawChatbox = false;
                Class58.method979(true);
            }
            Class37.method435(true);
            if(Class51.anInt1205 != -1)
                IdentityKit.aBoolean2597 = true;
            if(IdentityKit.aBoolean2597) {
                if(Class51.anInt1205 != -1 && Class51.anInt1205 == Class5.currentTabId) {
                    Class51.anInt1205 = -1;
                    Class32.packetBuffer.putPacket(44);
                    Class56.anInt1311++;
                    Class32.packetBuffer.putByte(Class5.currentTabId);
                }
                IdentityKit.aBoolean2597 = false;
                Class40_Sub3.aBoolean2026 = true;
                Class40_Sub2.method527(Class5.currentTabId, 4, Class40_Sub5_Sub11.tabWidgetIds, ((Class29.anInt673 ^ 0xffffffff) == 0), ((Node.anInt926 % 20 ^ 0xffffffff) <= -11 ? Class51.anInt1205 : -1));
            }
            if(Cache.aBoolean330) {
                Class40_Sub3.aBoolean2026 = true;
                Cache.aBoolean330 = false;
                Class52.method943(ItemDefinition.anInt2797, arg0 ^ 0x4e81, Class53.aClass40_Sub5_Sub14_Sub1_1268, Class4.anInt185, Class35.publicChatMode);
            }
            Landscape.method934((Class40_Sub5_Sub13.localPlayer.anInt3098), -118, Player.anInt3267, Class5.anInt199, (Class40_Sub5_Sub13.localPlayer.anInt3089));
            Class5.anInt199 = 0;
        }
    }

    public static void method366(int arg0, int arg1) {
        if(arg1 == -3)
            Class33.method411(Node.aClass1_956, Class52.aClass1_1218, SceneTile.aClass1_2057, (byte) -121);
        else if((arg1 ^ 0xffffffff) == 1)
            Class33.method411(Node.aClass1_934, Node.aClass1_969, Class40_Sub5_Sub6.aClass1_2462, (byte) 93);
        else if(arg1 == -1)
            Class33.method411(Node.aClass1_949, Class33.aClass1_799, SceneTile.aClass1_2053, (byte) 115);
        else if((arg1 ^ 0xffffffff) == -4)
            Class33.method411(Node.aClass1_941, Node.aClass1_974, ISAAC.aClass1_526, (byte) -65);
        else if(arg1 == 4)
            Class33.method411(Node.aClass1_976, Class64.aClass1_1526, Cache.aClass1_323, (byte) -33);
        else if(arg1 != 5) {
            if(arg1 == 6)
                Class33.method411(Node.aClass1_930, Class40_Sub5_Sub6.aClass1_2460, Class65.aClass1_1538, (byte) 112);
            else if((arg1 ^ 0xffffffff) == -8)
                Class33.method411(Node.aClass1_953, Class57.aClass1_1339, Class22_Sub2.aClass1_1891, (byte) 105);
            else if(arg1 != 8) {
                if((arg1 ^ 0xffffffff) == -10)
                    Class33.method411(Node.aClass1_942, Actor.aClass1_3138, Class40_Sub5_Sub17_Sub3.aClass1_3050, (byte) 104);
                else if(arg1 == 10)
                    Class33.method411(Node.aClass1_952, Class42.aClass1_1002, IdentityKit.aClass1_2615, (byte) 87);
                else if((arg1 ^ 0xffffffff) == -12)
                    Class33.method411(Node.aClass1_943, Class42.aClass1_1001, Class40_Sub6.aClass1_2111, (byte) 110);
                else if((arg1 ^ 0xffffffff) == -13)
                    Class33.method411(Node.aClass1_931, Class40_Sub13.aClass1_2188, Class40_Sub5_Sub4.aClass1_2357, (byte) 115);
                else if((arg1 ^ 0xffffffff) == -14)
                    Class33.method411(Node.aClass1_972, Class40_Sub5_Sub17_Sub3.aClass1_3066, SceneTile.aClass1_2042, (byte) -53);
                else if(arg1 != 14) {
                    if((arg1 ^ 0xffffffff) != -17) {
                        if((arg1 ^ 0xffffffff) != -18) {
                            if((arg1 ^ 0xffffffff) != -19) {
                                if((arg1 ^ 0xffffffff) == -21)
                                    Class33.method411(Node.aClass1_944, Class55.aClass1_1298, (SceneTile.aClass1_2047), (byte) 126);
                                else if((arg1 ^ 0xffffffff) == -23)
                                    Class33.method411(Node.aClass1_955, (Floor.aClass1_2325), Class6.aClass1_258, (byte) -123);
                                else if(arg1 == 23)
                                    Class33.method411(Node.aClass1_957, Class38.aClass1_882, (NpcDefinition.aClass1_2410), (byte) -128);
                                else if((arg1 ^ 0xffffffff) != -25) {
                                    if(arg1 == 25)
                                        Class33.method411(Node.aClass1_973, Class8.aClass1_278, SceneTile.aClass1_2050, (byte) -84);
                                    else if(arg1 == 26)
                                        Class33.method411(Node.aClass1_960, Class22_Sub1.aClass1_1851, Class17.aClass1_455, (byte) 103);
                                    else if(arg1 != 27)
                                        Class33.method411(Node.aClass1_946, (NpcDefinition.aClass1_2432), SceneTile.aClass1_2054, (byte) 123);
                                    else
                                        Class33.method411(Node.aClass1_945, Node.aClass1_925, Class40_Sub13.aClass1_2189, (byte) 103);
                                } else
                                    Class33.method411(Node.aClass1_954, Class60.aClass1_1416, Class5.aClass1_193, (byte) 117);
                            } else
                                Class33.method411(Node.aClass1_963, Main.aClass1_1781, Class34.aClass1_817, (byte) 96);
                        } else
                            Class33.method411(Node.aClass1_959, Landscape.aClass1_1178, Class61.aClass1_1421, (byte) -85);
                    } else
                        Class33.method411(Node.aClass1_924, Buffer.aClass1_1983, Class22_Sub1.aClass1_1870, (byte) -29);
                } else
                    Class33.method411(Node.aClass1_929, Class10.aClass1_344, NpcDefinition.aClass1_2401, (byte) -68);
            } else
                Class33.method411(Node.aClass1_937, Class42.aClass1_997, Class68_Sub1.aClass1_2209, (byte) -76);
        } else
            Class33.method411(Node.aClass1_966, Class22.aClass1_532, Player.aClass1_3286, (byte) -101);
        Floor.method559(10, -83);
    }

    public static int method368(byte arg0, boolean arg1, boolean arg2) {
        int i = 0;
        if(arg2)
            i += Class17.anInt464 + Class68.anInt1618;
        if(arg0 != -41)
            aClass40_Sub5_Sub14_Sub4Array649 = null;
        if(arg1)
            i += Class42.anInt1006 + HashTable.anInt554;
        return i;
    }

    public SubNode method351(int arg0) {
        SubNode class40_sub5 = aClass40_Sub5_660.aClass40_Sub5_2082;
        if(class40_sub5 == aClass40_Sub5_660)
            return null;
        class40_sub5.method539(arg0 ^ 0x1fffccf7);
        return class40_sub5;
    }

    public void method352(int arg0, SubNode arg1) {
        if(arg1.aClass40_Sub5_2087 != null)
            arg1.method539(0);
        arg1.aClass40_Sub5_2082 = aClass40_Sub5_660;
        arg1.aClass40_Sub5_2087 = aClass40_Sub5_660.aClass40_Sub5_2087;
        arg1.aClass40_Sub5_2087.aClass40_Sub5_2082 = arg1;
        arg1.aClass40_Sub5_2082.aClass40_Sub5_2087 = arg1;
        if(arg0 <= 97)
            method361(null, 14, false, 78, 114, 98, -51, -54);
    }

    public SubNode method362(int arg0) {
        if(arg0 >= -73)
            aClass1_638 = null;
        SubNode class40_sub5 = aClass40_Sub5_660.aClass40_Sub5_2082;
        if(class40_sub5 == aClass40_Sub5_660)
            return null;
        return class40_sub5;
    }

    public void method367(boolean arg0, SubNode arg1) {
        if(arg1.aClass40_Sub5_2087 != null)
            arg1.method539(0);
        arg1.aClass40_Sub5_2082 = aClass40_Sub5_660.aClass40_Sub5_2082;
        arg1.aClass40_Sub5_2087 = aClass40_Sub5_660;
        arg1.aClass40_Sub5_2087.aClass40_Sub5_2082 = arg1;
        if(arg0 != true)
            method360((byte) -126, -26, -36, -4, -38, 92, -45);
        arg1.aClass40_Sub5_2082.aClass40_Sub5_2087 = arg1;
    }
}
