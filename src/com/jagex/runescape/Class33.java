package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.tile.FloorDecoration;

public class Class33 {
    public static RSString aClass1_777 = RSString.CreateString("Cabbage");
    public static Cache aClass9_778 = new Cache(64);
    public static RSString aClass1_779 = (RSString.CreateString("Bitte schlie-8en Sie die momentan ge-Offnete Benutzeroberfl-=che)1 bevor Sie die (WRegelversto-8 melden(W Option benutzen"));
    public static RSString aClass1_783 = RSString.CreateString("Loading config )2 ");
    public static int anInt784 = 0;
    public static RSString cmd_prefix = RSString.CreateString("::");
    public static int[] anIntArray791 = new int[500];
    public static RSString aClass1_795 = RSString.CreateString(")1");
    public static RSString aClass1_797 = RSString.CreateString("Spiel)2Engine wird gestartet)3)3)3");
    public static RSString aClass1_798 = RSString.CreateString("No response from server)3");
    public static RSString aClass1_799 = aClass1_798;


    public static synchronized void method402(boolean arg0) {
        if(Class24.method340(-122)) {
            Class22.method308(-110);
            Class26.aBoolean618 = arg0;
            Class22_Sub1.aCacheIndex_1855 = null;
        }

    }

    public static synchronized void method403(int arg0, boolean arg1, int arg2, int arg3, CacheIndex arg4, int arg5, int arg6, boolean arg7) {
        if(Class24.method340(5)) {
            Main.aBoolean1790 = arg7;
            CacheIndex.anInt255 = arg2;
            Class40_Sub5_Sub17_Sub1.anInt3004 = arg5;
            Class26.aBoolean618 = arg1;
            Class22_Sub1.aCacheIndex_1855 = arg4;
            CacheIndex_Sub1.anInt1806 = -1;
            OverlayDefinition.anInt2342 = arg0;
            Class40_Sub6.anInt2110 = arg6;
            Class8.anInt289 = arg3;
        }

    }

    public static void method404(byte arg0) {
        Class32.anInt770 = 0;
        if(arg0 == -28) {
            for(int i = -1; Class60.anInt1407 + GameObjectDefinition.anInt2558 > i; i++) {
                Actor actor;
                if(i == -1)
                    actor = (Player.localPlayer);
                else if(i < Class60.anInt1407)
                    actor = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i]]);
                else
                    actor = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[(Class40_Sub3.anIntArray2016[i + -Class60.anInt1407])]);
                if(actor != null && actor.isVisible(1)) {
                    if(actor instanceof Npc) {
                        ActorDefinition class40_sub5_sub5 = (((Npc) actor).actorDefinition);
                        if(class40_sub5_sub5.childrenIds != null)
                            class40_sub5_sub5 = class40_sub5_sub5.getChildDefinition(arg0 + 27);
                        if(class40_sub5_sub5 == null)
                            continue;
                    }
                    if(Class60.anInt1407 <= i) {
                        ActorDefinition class40_sub5_sub5 = (((Npc) actor).actorDefinition);
                        if((class40_sub5_sub5.headIcon >= 0) && (class40_sub5_sub5.headIcon < (Class68_Sub1.aClass40_Sub5_Sub14_Sub4Array2204).length)) {
                            FloorDecoration.method342(-127, (actor.anInt3117) + 15, actor);
                            if(ISAAC.anInt522 > -1)
                                Class68_Sub1.aClass40_Sub5_Sub14_Sub4Array2204[class40_sub5_sub5.headIcon].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -30);
                        }
                        if(Player.anInt3288 == 1 && (HuffmanEncoding.anInt1545 == (Class40_Sub3.anIntArray2016[-Class60.anInt1407 + i])) && Node.pulseCycle % 20 < 10) {
                            FloorDecoration.method342(107, 15 + (actor.anInt3117), actor);
                            if(ISAAC.anInt522 > -1)
                                UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, Class44.anInt1048 + -28);
                        }
                    } else {
                        Player class40_sub5_sub17_sub4_sub1 = ((Player) actor);
                        int i_0_ = 30;
                        if(class40_sub5_sub17_sub4_sub1.isSkulled != -1 || (class40_sub5_sub17_sub4_sub1.headIcon != -1)) {
                            FloorDecoration.method342(-44, 15 + (actor.anInt3117), actor);
                            if(ISAAC.anInt522 > -1) {
                                if(class40_sub5_sub17_sub4_sub1.isSkulled != -1) {
                                    FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603[(class40_sub5_sub17_sub4_sub1.isSkulled)].drawImage(ISAAC.anInt522 - 12, Class44.anInt1048 - i_0_);
                                    i_0_ += 25;
                                }
                                if(class40_sub5_sub17_sub4_sub1.headIcon != -1) {
                                    Class68_Sub1.aClass40_Sub5_Sub14_Sub4Array2204[(class40_sub5_sub17_sub4_sub1.headIcon)].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                                    i_0_ += 25;
                                }
                            }
                        }
                        if(i >= 0 && Player.anInt3288 == 10 && (Class68.anInt1623 == Class57.anIntArray1334[i])) {
                            FloorDecoration.method342(87, (actor.anInt3117) + 15, actor);
                            if(ISAAC.anInt522 > -1)
                                UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567[1].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                        }
                    }
                    if(actor.forcedChatMessage != null && (i >= Class60.anInt1407 || Class35.publicChatMode == 0 || Class35.publicChatMode == 3 || (Class35.publicChatMode == 1 && (Class40_Sub2.hasFriend((((Player) actor).playerName), arg0 ^ 0x7f74))))) {
                        FloorDecoration.method342(88, (actor.anInt3117), actor);
                        if(ISAAC.anInt522 > -1 && 50 > Class32.anInt770) {
                            Class30.anIntArray680[Class32.anInt770] = ((Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.getStringWidth(actor.forcedChatMessage)) / 2);
                            Class30.anIntArray688[Class32.anInt770] = (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.characterDefaultHeight);
                            Class30.anIntArray715[Class32.anInt770] = ISAAC.anInt522;
                            Class30.anIntArray685[Class32.anInt770] = Class44.anInt1048;
                            Class30.anIntArray712[Class32.anInt770] = actor.anInt3102;
                            Class30.anIntArray695[Class32.anInt770] = actor.anInt3123;
                            Class30.anIntArray684[Class32.anInt770] = actor.anInt3078;
                            Class30.aClass1Array697[Class32.anInt770] = actor.forcedChatMessage;
                            Class32.anInt770++;
                        }
                    }
                    if((Node.pulseCycle < actor.anInt3139)) {
                        FloorDecoration.method342(109, (actor.anInt3117) + 15, actor);
                        if(ISAAC.anInt522 > -1) {
                            int i_1_ = (30 * actor.anInt3130 / actor.anInt3101);
                            if(i_1_ > 30)
                                i_1_ = 30;
                            Rasterizer.drawFilledRectangle(-15 + (ISAAC.anInt522), (Class44.anInt1048 + -3), i_1_, 5, 65280);
                            Rasterizer.drawFilledRectangle(-15 + ISAAC.anInt522 + i_1_, Class44.anInt1048 + -3, 30 + -i_1_, 5, 16711680);
                        }
                    }
                    for(int i_2_ = 0; i_2_ < 4; i_2_++) {
                        if(Node.pulseCycle < (actor.anIntArray3136[i_2_])) {
                            FloorDecoration.method342(99, (actor.anInt3117) / 2, actor);
                            if(ISAAC.anInt522 > -1) {
                                if(i_2_ == 1)
                                    Class44.anInt1048 -= 20;
                                if(i_2_ == 2) {
                                    ISAAC.anInt522 -= 15;
                                    Class44.anInt1048 -= 10;
                                }
                                if(i_2_ == 3) {
                                    ISAAC.anInt522 += 15;
                                    Class44.anInt1048 -= 10;
                                }
                                AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474[(actor.anIntArray3086[i_2_])].drawImage(ISAAC.anInt522 + -12, -12 + Class44.anInt1048);
                                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.method686((HashTable.method334((actor.anIntArray3087[i_2_]), -1)), ISAAC.anInt522, 4 + Class44.anInt1048, 0);
                                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.method686((HashTable.method334((actor.anIntArray3087[i_2_]), -1)), ISAAC.anInt522 - 1, Class44.anInt1048 + 3, 16777215);
                            }
                        }
                    }
                }
            }
            for(int i = 0; Class32.anInt770 > i; i++) {
                int i_3_ = Class30.anIntArray715[i];
                int i_4_ = Class30.anIntArray685[i];
                int i_5_ = Class30.anIntArray680[i];
                int i_6_ = Class30.anIntArray688[i];
                boolean bool = true;
                while(bool) {
                    bool = false;
                    for(int i_7_ = 0; (i > i_7_); i_7_++) {
                        if(((-Class30.anIntArray688[i_7_] + Class30.anIntArray685[i_7_]) < i_4_ + 2) && ((-i_6_ + i_4_ < 2 + Class30.anIntArray685[i_7_])) && ((Class30.anIntArray715[i_7_] + Class30.anIntArray680[i_7_]) > -i_5_ + i_3_) && (i_5_ + i_3_ > (-Class30.anIntArray680[i_7_] + Class30.anIntArray715[i_7_])) && ((-Class30.anIntArray688[i_7_] + Class30.anIntArray685[i_7_]) < i_4_)) {
                            bool = true;
                            i_4_ = (-Class30.anIntArray688[i_7_] + Class30.anIntArray685[i_7_]);
                        }
                    }
                }
                ISAAC.anInt522 = Class30.anIntArray715[i];
                Class44.anInt1048 = Class30.anIntArray685[i] = i_4_;
                RSString class1 = Class30.aClass1Array697[i];
                if(Class40_Sub5_Sub1.anInt2280 == 0) {
                    int i_8_ = 16776960;
                    if(Class30.anIntArray712[i] < 6)
                        i_8_ = (Class40_Sub6.anIntArray2106[Class30.anIntArray712[i]]);
                    if(Class30.anIntArray712[i] == 6)
                        i_8_ = Class40_Sub5_Sub11.anInt2628 % 20 >= 10 ? 16776960 : 16711680;
                    if(Class30.anIntArray712[i] == 7)
                        i_8_ = Class40_Sub5_Sub11.anInt2628 % 20 < 10 ? 255 : 65535;
                    if(Class30.anIntArray712[i] == 8)
                        i_8_ = (Class40_Sub5_Sub11.anInt2628 % 20 >= 10 ? 8454016 : 45056);
                    if(Class30.anIntArray712[i] == 9) {
                        int i_9_ = 150 - Class30.anIntArray684[i];
                        if(i_9_ >= 50) {
                            if(i_9_ < 100)
                                i_8_ = -((-50 + i_9_) * 327680) + 16776960;
                            else if(i_9_ < 150)
                                i_8_ = 65280 + (5 * (i_9_ + -100));
                        } else
                            i_8_ = 16711680 + 1280 * i_9_;
                    }
                    if(Class30.anIntArray712[i] == 10) {
                        int i_10_ = 150 + -Class30.anIntArray684[i];
                        if(i_10_ >= 50) {
                            if(i_10_ >= 100) {
                                if(i_10_ < 150)
                                    i_8_ = 255 - (-(327680 * (i_10_ - 100)) - 500) + -(5 * i_10_);
                            } else
                                i_8_ = 16711935 - (327680 * i_10_ - 16384000);
                        } else
                            i_8_ = 5 * i_10_ + 16711680;
                    }
                    if(Class30.anIntArray712[i] == 11) {
                        int i_11_ = -Class30.anIntArray684[i] + 150;
                        if(i_11_ >= 50) {
                            if(i_11_ < 100)
                                i_8_ = 327685 * (i_11_ - 50) + 65280;
                            else if(i_11_ < 150)
                                i_8_ = (-((-100 + i_11_) * 327680) + 16777215);
                        } else
                            i_8_ = -(327685 * i_11_) + 16777215;
                    }
                    if(Class30.anIntArray695[i] == 0) {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048, i_8_);
                    }
                    if(Class30.anIntArray695[i] == 1) {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawCenteredStringWaveY(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0, Class40_Sub5_Sub11.anInt2628);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawCenteredStringWaveY(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, Class40_Sub5_Sub11.anInt2628);
                    }
                    if(Class30.anIntArray695[i] == 2) {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawCenteredStringWaveXY(class1, ISAAC.anInt522, 1 + Class44.anInt1048, 0, Class40_Sub5_Sub11.anInt2628);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawCenteredStringWaveXY(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, Class40_Sub5_Sub11.anInt2628);
                    }
                    if(Class30.anIntArray695[i] == 3) {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawCenteredStringWaveXYMove(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0, Class40_Sub5_Sub11.anInt2628, -Class30.anIntArray684[i] + 150);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawCenteredStringWaveXYMove(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, Class40_Sub5_Sub11.anInt2628, -Class30.anIntArray684[i] + 150);
                    }
                    if(Class30.anIntArray695[i] == 4) {
                        int i_12_ = Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.getStringWidth(class1);
                        int i_13_ = ((i_12_ + 100) * (150 + -Class30.anIntArray684[i]) / 150);
                        Rasterizer.setCoordinates((ISAAC.anInt522 + -50), 0, 334, 50 + ISAAC.anInt522);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawString(class1, -i_13_ + ISAAC.anInt522 + 50, Class44.anInt1048 + 1, 0);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawString(class1, 50 + ISAAC.anInt522 + -i_13_, Class44.anInt1048, i_8_);
                        Rasterizer.resetCoordinates();
                    }
                    if(Class30.anIntArray695[i] == 5) {
                        int i_14_ = 0;
                        int i_15_ = 150 + -Class30.anIntArray684[i];
                        Rasterizer.setCoordinates(0, -1 + (-(Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.characterDefaultHeight) + Class44.anInt1048), 5 + Class44.anInt1048, 512);
                        if(i_15_ >= 25) {
                            if(i_15_ > 125)
                                i_14_ = i_15_ + -125;
                        } else
                            i_14_ = i_15_ + -25;
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, i_14_ + (Class44.anInt1048 + 1), 0);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, i_14_ + Class44.anInt1048, i_8_);
                        Rasterizer.resetCoordinates();
                    }
                } else {
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048, 16776960);
                }
            }
        }

    }

    public static synchronized void method405(int arg0, int arg1) {
        if(Class24.method340(arg0 + -16923)) {
            OverlayDefinition.method557(arg1, 17098);
            Class22_Sub1.aCacheIndex_1855 = null;
            Class26.aBoolean618 = false;
            if(arg0 != 16969)
                method414(false, -11, -36, -55, 122, null, 102);
        }
    }

    public static void method406(int arg0, int arg1, int arg2, int arg3) {
        if(arg1 == 1) {
            Class67.anInt1594++;
            Class32.packetBuffer.putPacket(111);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 2) {
            Class32.packetBuffer.putPacket(9);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
            Class56.anInt1327++;
        }
        if(arg1 == 3) {
            Class32.packetBuffer.putPacket(193);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 4) {
            Class32.packetBuffer.putPacket(53);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 5) {
            Class32.packetBuffer.putPacket(94);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 6) {
            Class32.packetBuffer.putPacket(213);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 7) {
            Class32.packetBuffer.putPacket(46);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 8) {
            Class32.packetBuffer.putPacket(130);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
            Class40_Sub5_Sub17_Sub1.anInt2979++;
        }
        if(arg1 == 9) {
            Class32.packetBuffer.putPacket(157);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 10) {
            Class32.packetBuffer.putPacket(84);
            Class32.packetBuffer.putIntBE(arg2);
            Class32.packetBuffer.putShortBE(arg0);
        }
        if(arg3 > -112)
            aClass9_778 = null;
    }

    public static synchronized void method407(boolean arg0) {
        if(arg0)
            aClass1_795 = null;
        Class65.method1019(104);
    }

    public static void method408(int arg0) {

        aClass1_779 = null;
        aClass1_799 = null;
        cmd_prefix = null;
        anIntArray791 = null;
        aClass1_795 = null;
        if(arg0 == 22019) {
            aClass1_777 = null;
            aClass1_797 = null;
            aClass9_778 = null;
            aClass1_783 = null;
            aClass1_798 = null;
        }

    }

    public static boolean method409(byte arg0, int arg1) {
        if(arg0 <= 23)
            method402(true);
        if(arg1 < 0)
            return false;
        int i = Class38.anIntArray884[arg1];
        if(i >= 2000)
            i -= 2000;
        return i == 45;
    }

    public static int method410(int arg0, int arg1, int arg2, boolean arg3) {
        arg2 &= 0x3;
        if(arg3)
            return -80;
        if(arg2 == 0)
            return arg1;
        if(arg2 == 1)
            return 7 + -arg0;
        if(arg2 == 2)
            return -arg1 + 7;
        return arg0;

    }

    public static void method411(RSString arg0, RSString arg1, RSString arg2, byte arg3) {
        int i = -74 / ((29 - arg3) / 57);
        Class22_Sub2.aClass1_1881 = arg0;
        Class22_Sub2.aClass1_1896 = arg2;
        Class22_Sub2.aClass1_1879 = arg1;
    }

    public static synchronized void method412(boolean arg0, CacheIndex arg1, int arg2, byte arg3, RSString arg4, int arg5, RSString arg6, int arg7) {
        if(Class24.method340(70)) {
            if(arg3 != 66)
                method412(false, null, 120, (byte) -44, null, 71, null, -13);
            int i = arg1.method183(0, arg4);
            int i_16_ = arg1.method179(arg3 + -176, i, arg6);
            method403(arg7, true, arg5, i, arg1, i_16_, arg2, arg0);
        }
    }

    public static synchronized void method413(byte arg0) {
        if(Class24.method340(-124)) {
            if(Class26.aBoolean618) {
                byte[] is = RSString.method74(Class40_Sub5_Sub17_Sub1.anInt3004, Class22_Sub1.aCacheIndex_1855, Class8.anInt289, -118, Class40_Sub6.anInt2110);
                if(is != null) {
                    if(CacheIndex.anInt255 < 0) {
                        if(CacheIndex_Sub1.anInt1806 < 0)
                            RSString.method56(2037, Main.aBoolean1790, is, OverlayDefinition.anInt2342);
                        else
                            VarbitDefinition.method566((OverlayDefinition.anInt2342), Main.aBoolean1790, CacheIndex_Sub1.anInt1806, is, -27520);
                    } else
                        Class42.method886(0, OverlayDefinition.anInt2342, Main.aBoolean1790, is, CacheIndex.anInt255);
                    Class26.aBoolean618 = false;
                    Class22_Sub1.aCacheIndex_1855 = null;
                }
            }
            Class59.method984(0);
            if(arg0 >= -109)
                method406(-59, -67, 107, 108);
        }
    }

    public static synchronized void method414(boolean arg0, int arg1, int arg2, int arg3, int arg4, CacheIndex arg5, int arg6) {
        if(Class24.method340(arg6 ^ ~0xf)) {
            Class26.aBoolean618 = true;
            CacheIndex_Sub1.anInt1806 = arg6;
            CacheIndex.anInt255 = -1;
            OverlayDefinition.anInt2342 = arg3;
            Class40_Sub5_Sub17_Sub1.anInt3004 = arg4;
            Main.aBoolean1790 = arg0;
            Class40_Sub6.anInt2110 = arg1;
            Class22_Sub1.aCacheIndex_1855 = arg5;
            Class8.anInt289 = arg2;
        }
    }
}
