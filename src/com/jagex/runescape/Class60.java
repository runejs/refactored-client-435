package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.NpcDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;

public class Class60 {
    public static int anInt1400;
    public static RSString aClass1_1401;
    public static boolean aBoolean1402 = false;
    public static int anInt1403;
    public static int anInt1404;
    public static int anInt1405;
    public static int anInt1406;
    public static int anInt1407;
    public static RSString aClass1_1408 = Class58.method978("auf der Hautpseite)3");
    public static RSString aClass1_1409;
    public static int anInt1410;
    public static RSString aClass1_1411;
    public static int anInt1412;
    public static int anInt1413;
    public static int anInt1414;
    public static int anInt1415;
    public static RSString aClass1_1416;
    public static int anInt1417;
    public static int anInt1418;

    static {
        aClass1_1401 = Class58.method978(",Zffentlicher Chat");
        aClass1_1411 = Class58.method978("Error loading your profile)3");
        aClass1_1409 = Class58.method978("Wen m-Ochten Sie von der Liste entfernen?");
        anInt1407 = 0;
        aClass1_1416 = aClass1_1411;
        anInt1415 = 0;
    }

    public static TypeFace method987(int arg0) {

        anInt1414++;
        TypeFace class40_sub5_sub14_sub1 = new TypeFace((Actor.anIntArray3111), Class17.anIntArray456, (Npc.anIntArray3312), Buffer.anIntArray1972, Class58.aByteArrayArray1370);
        NpcDefinition.method569();
        if(arg0 < 4)
            return null;
        return class40_sub5_sub14_sub1;

    }

    public static int method988(Class6 arg0, Class6 arg1, int arg2) {

        anInt1412++;
        int i = 0;
        if(arg0.method194(Class32.aClass1_772, Class22_Sub2.string_blank, -1234))
            i++;
        if(arg1.method194(Main.aClass1_1762, Class22_Sub2.string_blank, -1234))
            i++;
        if(arg1.method194(Class40_Sub5_Sub7.aClass1_2488, Class22_Sub2.string_blank, -1234))
            i++;
        if(arg1.method194(ISAAC.aClass1_506, Class22_Sub2.string_blank, -1234))
            i++;
        if(arg1.method194(Class8.aClass1_299, Class22_Sub2.string_blank, -1234))
            i++;
        int i_0_ = 84 % ((11 - arg2) / 47);
        return i;

    }

    public static void method989(boolean arg0) {
        if(CollisionMap.aClass8_166 != null) {
            CollisionMap.aClass8_166.method213();
            CollisionMap.aClass8_166 = null;
        }
        anInt1410++;
        if(arg0 != true)
            method987(-89);
    }

    public static void method990(int arg0) {
        anInt1405++;
        int i = Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.getStringWidth(Class40_Sub5_Sub12.aClass1_2684);
        for(int i_1_ = 0; i_1_ < NpcDefinition.anInt2394; i_1_++) {
            int i_2_ = Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method681(Landscape.aClass1Array1184[i_1_]);
            if((i ^ 0xffffffff) > (i_2_ ^ 0xffffffff))
                i = i_2_;
        }
        i += 8;
        int i_3_ = NpcDefinition.anInt2394 * 15 + 21;
        if((Class57.anInt1338 ^ 0xffffffff) < -5 && (RSString.anInt1668 ^ 0xffffffff) < -5 && (Class57.anInt1338 ^ 0xffffffff) > -517 && (RSString.anInt1668 ^ 0xffffffff) > -339) {
            Class40_Sub5_Sub17_Sub1.menuScreenArea = 0;
            CollisionMap.anInt168 = NpcDefinition.anInt2394 * 15 + 22;
            Class4.menuOpen = true;
            int i_4_ = -(i / 2) + -4 + Class57.anInt1338;
            VertexNormal.anInt1086 = i;
            if((i + i_4_ ^ 0xffffffff) < -513)
                i_4_ = -i + 512;
            if((i_4_ ^ 0xffffffff) > -1)
                i_4_ = 0;
            Class19.anInt475 = i_4_;
            int i_5_ = RSString.anInt1668 + -4;
            if(i_5_ + i_3_ > 334)
                i_5_ = -i_3_ + 334;
            if(i_5_ < 0)
                i_5_ = 0;
            Main.anInt1758 = i_5_;
        }
        if(arg0 == 11451) {
            if((Class57.anInt1338 ^ 0xffffffff) < -554 && (RSString.anInt1668 ^ 0xffffffff) < -206 && (Class57.anInt1338 ^ 0xffffffff) > -744 && RSString.anInt1668 < 466) {
                CollisionMap.anInt168 = 22 + 15 * NpcDefinition.anInt2394;
                Class40_Sub5_Sub17_Sub1.menuScreenArea = 1;
                int i_6_ = -205 + RSString.anInt1668;
                int i_7_ = -(i / 2) + (-553 + Class57.anInt1338);
                if(i_7_ < 0)
                    i_7_ = 0;
                else if(i + i_7_ > 190)
                    i_7_ = 190 - i;
                Class4.menuOpen = true;
                Class19.anInt475 = i_7_;
                if((i_6_ ^ 0xffffffff) <= -1) {
                    if(i_3_ + i_6_ > 261)
                        i_6_ = -i_3_ + 261;
                } else
                    i_6_ = 0;
                VertexNormal.anInt1086 = i;
                Main.anInt1758 = i_6_;
            }
            if((Class57.anInt1338 ^ 0xffffffff) < -18 && RSString.anInt1668 > 357 && Class57.anInt1338 < 496 && RSString.anInt1668 < 453) {
                VertexNormal.anInt1086 = i;
                Class40_Sub5_Sub17_Sub1.menuScreenArea = 2;
                CollisionMap.anInt168 = NpcDefinition.anInt2394 * 15 + 22;
                int i_8_ = RSString.anInt1668 + -357;
                if((i_8_ ^ 0xffffffff) <= -1) {
                    if((i_3_ + i_8_ ^ 0xffffffff) < -97)
                        i_8_ = -i_3_ + 96;
                } else
                    i_8_ = 0;
                int i_9_ = -(i / 2) + -17 + Class57.anInt1338;
                Class4.menuOpen = true;
                Main.anInt1758 = i_8_;
                if((i_9_ ^ 0xffffffff) > -1)
                    i_9_ = 0;
                else if(i_9_ + i > 479)
                    i_9_ = -i + 479;
                Class19.anInt475 = i_9_;
            }
        }
    }

    public static RSString method991(int arg0, long arg1) {

        anInt1403++;
        if(arg1 <= 0L || (arg1 ^ 0xffffffffffffffffL) <= -6582952005840035282L)
            return null;
        if((arg1 % 37L ^ 0xffffffffffffffffL) == -1L)
            return null;
        long l = arg1;
        int i = 0;
        while((l ^ 0xffffffffffffffffL) != -1L) {
            l /= 37L;
            i++;
        }
        if(arg0 >= -3)
            aClass1_1416 = null;
        byte[] is = new byte[i];
        while((arg1 ^ 0xffffffffffffffffL) != -1L) {
            long l_10_ = arg1;
            arg1 /= 37L;
            is[--i] = CollisionMap.aByteArray169[(int) (-(arg1 * 37L) + l_10_)];
        }
        RSString class1 = new RSString();
        class1.chars = is;
        class1.length = is.length;
        return class1;

    }

    public static void method992(int arg0) {
        anInt1418++;
        Class32.aClass38_768.method443(-10115);
        for(int i = 0; i < 32; i++)
            RSApplet.aLongArray4[i] = 0L;
        for(int i = 0; i < 32; i++)
            Class67.aLongArray1614[i] = 0L;
        Class40_Sub3.anInt2020 = 0;
        if(arg0 != 75)
            method994(false);
    }

    public static void method993(int arg0) {
        anInt1404++;
        Class40_Sub6.method836(1);
        if((Class51.anInt1197 ^ 0xffffffff) == -11) {
            int i = Class57.anInt1338 + -202;
            int i_11_ = Class62.anInt1470;
            int i_12_ = -171 + RSString.anInt1668;
            int i_13_ = -58 % ((-38 - arg0) / 59);
            if(Class26.anInt622 == 0) {
                int i_14_ = 100;
                int i_15_ = 120;
                if((i_11_ ^ 0xffffffff) == -2 && i >= i_14_ - 75 && i_14_ + 75 >= i && i_12_ >= -20 + i_15_ && i_15_ + 20 >= i_12_) {
                    Node.anInt947 = 0;
                    Class26.anInt622 = 3;
                }
                i_14_ = 260;
                if((i_11_ ^ 0xffffffff) == -2 && (i ^ 0xffffffff) <= (-75 + i_14_ ^ 0xffffffff) && i <= 75 + i_14_ && (i_12_ ^ 0xffffffff) <= (-20 + i_15_ ^ 0xffffffff) && (20 + i_15_ ^ 0xffffffff) <= (i_12_ ^ 0xffffffff)) {
                    Class26.anInt622 = 2;
                    Node.anInt947 = 0;
                    Class22_Sub2.aClass1_1879 = Node.aClass1_967;
                    Class22_Sub2.aClass1_1896 = Class22_Sub1.aClass1_1857;
                    Class22_Sub2.aClass1_1881 = Node.aClass1_951;
                }
            } else if((Class26.anInt622 ^ 0xffffffff) == -3) {
                int i_16_ = 60;
                int i_17_ = 100;
                i_16_ += 30;
                if(i_11_ == 1 && (-15 + i_16_ ^ 0xffffffff) >= (i_12_ ^ 0xffffffff) && (i_12_ ^ 0xffffffff) > (i_16_ ^ 0xffffffff))
                    Node.anInt947 = 0;
                int i_18_ = 150;
                i_16_ += 15;
                if(i_11_ == 1 && (-15 + i_16_ ^ 0xffffffff) >= (i_12_ ^ 0xffffffff) && i_16_ > i_12_)
                    Node.anInt947 = 1;
                i_16_ += 15;
                if(i_11_ == 1 && i_17_ + -75 <= i && i <= i_17_ + 75 && (i_12_ ^ 0xffffffff) <= (i_18_ + -20 ^ 0xffffffff) && (i_12_ ^ 0xffffffff) >= (i_18_ + 20 ^ 0xffffffff)) {
                    Class22_Sub2.username = Class22_Sub2.username.method62(57).method85(-4305);
                    Class33.method411(Node.aClass1_964, Node.aClass1_958, Class40_Sub5_Sub17_Sub1.aClass1_3009, (byte) 106);
                    Floor.method559(20, 70);
                } else {
                    i_17_ = 260;
                    if(i_11_ == 1 && i >= -75 + i_17_ && (i_17_ + 75 ^ 0xffffffff) <= (i ^ 0xffffffff) && (i_12_ ^ 0xffffffff) <= (-20 + i_18_ ^ 0xffffffff) && (i_12_ ^ 0xffffffff) >= (i_18_ + 20 ^ 0xffffffff)) {
                        Class22_Sub2.username = Class22_Sub2.string_blank;
                        Class22_Sub2.password = Class22_Sub2.string_blank;
                        Class26.anInt622 = 0;
                    }
                    while(Class34.method416((byte) -104)) {
                        boolean bool = false;
                        for(int i_19_ = 0; ((i_19_ ^ 0xffffffff) > (Class22_Sub2.aClass1_1893.length() ^ 0xffffffff)); i_19_++) {
                            if((Class59.anInt1388 ^ 0xffffffff) == (Class22_Sub2.aClass1_1893.method55(i_19_, false) ^ 0xffffffff)) {
                                bool = true;
                                break;
                            }
                        }
                        if((Node.anInt947 ^ 0xffffffff) != -1) {
                            if(Node.anInt947 == 1) {
                                if(ItemDefinition.anInt2854 == 85 && (Class22_Sub2.password.length() ^ 0xffffffff) < -1)
                                    Class22_Sub2.password = (Class22_Sub2.password.substring(0, Class22_Sub2.password.length() + -1));
                                if((ItemDefinition.anInt2854 ^ 0xffffffff) == -85 || ItemDefinition.anInt2854 == 80)
                                    Node.anInt947 = 0;
                                if(bool && (Class22_Sub2.password.length() ^ 0xffffffff) > -21)
                                    Class22_Sub2.password = Class22_Sub2.password.method70(Class59.anInt1388, 0);
                            }
                        } else {
                            if(((ItemDefinition.anInt2854 ^ 0xffffffff) == -86) && (Class22_Sub2.username.length() > 0))
                                Class22_Sub2.username = (Class22_Sub2.username.substring(0, -1 + Class22_Sub2.username.length()));
                            if(ItemDefinition.anInt2854 == 84 || ((ItemDefinition.anInt2854 ^ 0xffffffff) == -81))
                                Node.anInt947 = 1;
                            if(bool && (Class22_Sub2.username.length() ^ 0xffffffff) > -13)
                                Class22_Sub2.username = Class22_Sub2.username.method70(Class59.anInt1388, 0);
                        }
                    }
                }
            } else if(Class26.anInt622 == 3) {
                int i_20_ = 150;
                int i_21_ = 180;
                if(i_11_ == 1 && (i ^ 0xffffffff) <= (-75 + i_21_ ^ 0xffffffff) && 75 + i_21_ >= i && -20 + i_20_ <= i_12_ && (20 + i_20_ ^ 0xffffffff) <= (i_12_ ^ 0xffffffff))
                    Class26.anInt622 = 0;
            }
        }
    }

    public static void method994(boolean arg0) {

        aClass1_1401 = null;
        aClass1_1408 = null;
        aClass1_1409 = null;
        if(arg0 != false)
            aClass1_1408 = null;
        aClass1_1411 = null;
        aClass1_1416 = null;

    }
}
