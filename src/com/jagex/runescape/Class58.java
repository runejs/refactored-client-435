package com.jagex.runescape;

import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class58 {
    public static boolean aBoolean1349;
    public static int anInt1350;
    public static int anInt1351;
    public static int anInt1352 = 0;
    public static RSString aClass1_1354;
    public static int anInt1356;
    public static int anInt1357;
    public static int[] anIntArray1358;
    public static RSString aClass1_1359;
    public static int anInt1360;
    public static Cache aClass9_1364;
    public static int anInt1367;
    public static RSString aClass1_1365 = method978("Message");
    public static int anInt1368;
    public static int anInt1369;
    public static byte[][] aByteArrayArray1370;
    public static int cameraHorizontal;
    public static RSString aClass1_1374;
    public static Class6 aClass6_1375;
    public static int anInt1376;
    public static byte[][] aByteArrayArray1377;
    public static RSString aClass1_1378;
    public static int[] varbitmasks;

    static {
        aBoolean1349 = false;
        aClass1_1354 = aClass1_1365;
        anIntArray1358 = new int[5];
        aClass1_1359 = method978("::clientdrop");
        aClass9_1364 = new Cache(64);
        aClass1_1374 = method978("backvmid1");
        cameraHorizontal = 0;
        anInt1376 = -1;
        aClass1_1378 = method978("Chat panel redrawn");
        aByteArrayArray1377 = new byte[1000][];
        varbitmasks = new int[2000];
    }

    public Renderable aRenderable_1353;
    public int anInt1355;
    public int anInt1361;
    public Renderable aRenderable_1362;
    public Renderable aRenderable_1363;
    public int anInt1366;
    public int anInt1371;
    public int anInt1372;

    public static void method976(byte arg0, Class40_Sub5_Sub12 arg1) {
        anInt1350++;
        int i = arg1.anInt2639;
        if(i >= 1 && i <= 100 || (i ^ 0xffffffff) <= -702 && (i ^ 0xffffffff) >= -801) {
            if((i ^ 0xffffffff) == -2 && (Class12.anInt380 ^ 0xffffffff) == -1) {
                arg1.aClass1_2668 = Class13.aClass1_405;
                arg1.anInt2714 = 0;
            } else if(i == 1 && (Class12.anInt380 ^ 0xffffffff) == -2) {
                arg1.aClass1_2668 = Class66.aClass1_1552;
                arg1.anInt2714 = 0;
            } else if(i == 2 && (Class12.anInt380 ^ 0xffffffff) != -3) {
                arg1.anInt2714 = 0;
                arg1.aClass1_2668 = PacketBuffer.aClass1_2240;
            } else {
                int i_0_ = Class40_Sub5_Sub17_Sub3.anInt3060;
                if((i ^ 0xffffffff) < -701)
                    i -= 601;
                else
                    i--;
                if((Class12.anInt380 ^ 0xffffffff) != -3)
                    i_0_ = 0;
                if((i_0_ ^ 0xffffffff) >= (i ^ 0xffffffff)) {
                    arg1.aClass1_2668 = Class66.aClass1_1567;
                    arg1.anInt2714 = 0;
                } else {
                    arg1.aClass1_2668 = Class40_Sub11.aClass1Array2147[i];
                    arg1.anInt2714 = 1;
                }
            }
        } else if(i >= 101 && (i ^ 0xffffffff) >= -201 || (i ^ 0xffffffff) <= -802 && (i ^ 0xffffffff) >= -901) {
            if(i <= 800)
                i -= 101;
            else
                i -= 701;
            int i_1_ = Class40_Sub5_Sub17_Sub3.anInt3060;
            if(Class12.anInt380 != 2)
                i_1_ = 0;
            if(i >= i_1_) {
                arg1.aClass1_2668 = Class66.aClass1_1567;
                arg1.anInt2714 = 0;
            } else {
                if((Class40_Sub7.anIntArray2131[i] ^ 0xffffffff) != -1) {
                    if((Class40_Sub7.anIntArray2131[i] ^ 0xffffffff) > -5001) {
                        if((Class13.worldid ^ 0xffffffff) != (Class40_Sub7.anIntArray2131[i] ^ 0xffffffff))
                            arg1.aClass1_2668 = (Class40_Sub5_Sub17_Sub6.method832(86, (new RSString[]{Class54.aClass1_1283, Class26.aClass1_634, HashTable.method334((Class40_Sub7.anIntArray2131[i]), -1)})));
                        else
                            arg1.aClass1_2668 = (Class40_Sub5_Sub17_Sub6.method832(86, (new RSString[]{Landscape.aClass1_1162, Class26.aClass1_634, HashTable.method334((Class40_Sub7.anIntArray2131[i]), -1)})));
                    } else if((Class40_Sub7.anIntArray2131[i] ^ 0xffffffff) != (Class13.worldid ^ 0xffffffff))
                        arg1.aClass1_2668 = (Class40_Sub5_Sub17_Sub6.method832(53, (new RSString[]{Class54.aClass1_1283, Cache.aClass1_333, HashTable.method334(((Class40_Sub7.anIntArray2131[i]) + -5000), -1)})));
                    else
                        arg1.aClass1_2668 = (Class40_Sub5_Sub17_Sub6.method832(-111, (new RSString[]{Landscape.aClass1_1162, Cache.aClass1_333, HashTable.method334(-5000 + (Class40_Sub7.anIntArray2131[i]), -1)})));
                } else
                    arg1.aClass1_2668 = (Class40_Sub5_Sub17_Sub6.method832(104, new RSString[]{FloorDecoration.aClass1_610, Class27.aClass1_664}));
                arg1.anInt2714 = 1;
            }
        } else {
            int i_2_ = 88 / ((arg0 - 13) / 53);
            if((i ^ 0xffffffff) == -204) {
                int i_3_ = Class40_Sub5_Sub17_Sub3.anInt3060;
                if(Class12.anInt380 != 2)
                    i_3_ = 0;
                arg1.anInt2720 = 20 + 15 * i_3_;
                if(arg1.anInt2643 >= arg1.anInt2720)
                    arg1.anInt2720 = 1 + arg1.anInt2643;
            } else if((i ^ 0xffffffff) <= -402 && i <= 500) {
                i -= 401;
                if((i ^ 0xffffffff) == -1 && (Class12.anInt380 ^ 0xffffffff) == -1) {
                    arg1.aClass1_2668 = Class49.aClass1_1148;
                    arg1.anInt2714 = 0;
                } else if((i ^ 0xffffffff) == -2 && (Class12.anInt380 ^ 0xffffffff) == -1) {
                    arg1.aClass1_2668 = PacketBuffer.aClass1_2240;
                    arg1.anInt2714 = 0;
                } else {
                    int i_4_ = Class42.anInt1008;
                    if((Class12.anInt380 ^ 0xffffffff) == -1)
                        i_4_ = 0;
                    if((i_4_ ^ 0xffffffff) >= (i ^ 0xffffffff)) {
                        arg1.anInt2714 = 0;
                        arg1.aClass1_2668 = Class66.aClass1_1567;
                    } else {
                        arg1.aClass1_2668 = Class60.method991(-111, Class53.aLongArray1267[i]).method85(-4305);
                        arg1.anInt2714 = 1;
                    }
                }
            } else if((i ^ 0xffffffff) == -504) {
                arg1.anInt2720 = 15 * Class42.anInt1008 + 20;
                if(arg1.anInt2720 <= arg1.anInt2643)
                    arg1.anInt2720 = arg1.anInt2643 + 1;
            } else if(i == 324) {
                if((Class64.anInt1511 ^ 0xffffffff) == 0) {
                    Class64.anInt1511 = arg1.anInt2744;
                    Main.anInt1769 = arg1.anInt2670;
                }
                if(!Class45.aClass30_1082.aBoolean683)
                    arg1.anInt2744 = Main.anInt1769;
                else
                    arg1.anInt2744 = Class64.anInt1511;
            } else if((i ^ 0xffffffff) == -326) {
                if((Class64.anInt1511 ^ 0xffffffff) == 0) {
                    Main.anInt1769 = arg1.anInt2670;
                    Class64.anInt1511 = arg1.anInt2744;
                }
                if(Class45.aClass30_1082.aBoolean683)
                    arg1.anInt2744 = Main.anInt1769;
                else
                    arg1.anInt2744 = Class64.anInt1511;
            } else if((i ^ 0xffffffff) == -328) {
                arg1.anInt2690 = 150;
                arg1.anInt2657 = 0x7ff & (int) (256.0 * Math.sin((double) Node.anInt926 / 40.0));
                arg1.anInt2673 = 0;
                arg1.anInt2687 = 5;
            } else if(i == 328) {
                arg1.anInt2690 = 150;
                arg1.anInt2657 = 0x7ff & (int) (256.0 * Math.sin((double) Node.anInt926 / 40.0));
                arg1.anInt2673 = 1;
                arg1.anInt2687 = 5;
            } else if((i ^ 0xffffffff) == -601)
                arg1.aClass1_2668 = (Class40_Sub5_Sub17_Sub6.method832(-128, new RSString[]{Class66.aClass1_1550, Class22_Sub2.aClass1_1878}));
            else if(i == 620) {
                if((Class19.anInt493 ^ 0xffffffff) <= -2) {
                    if(!Class67.aBoolean1601) {
                        arg1.anInt2647 = 16777215;
                        arg1.aClass1_2668 = VertexNormal.aClass1_1088;
                    } else {
                        arg1.anInt2647 = 16711680;
                        arg1.aClass1_2668 = NpcDefinition.aClass1_2384;
                    }
                } else
                    arg1.aClass1_2668 = Class66.aClass1_1567;
            }
        }
    }

    public static void method977(int arg0, Class6 arg1, Class6 arg2) {

        Class27.aClass6_654 = arg2;
            if(arg0 == 3) {
                anInt1360++;
                Class49.aClass6_1150 = arg1;
                PacketBuffer.anInt2257 = Class49.aClass6_1150.method190(3, (byte) 8);
            }

    }

    public static RSString method978(String arg1) { // TODO: CreateString?
        anInt1367++;
        byte[] is = arg1.getBytes();
        int i = is.length;
        RSString class1 = new RSString();
        class1.str = arg1;
        int i_5_ = 0;
        class1.aByteArray1692 = new byte[i];
        while(i > i_5_) {
            int i_6_ = 0xff & is[i_5_++];
            if(i_6_ > 45 || i_6_ < 40) {
                if(i_6_ != 0)
                    class1.aByteArray1692[class1.anInt1680++] = (byte) i_6_;
            } else {
                if((i_5_ ^ 0xffffffff) <= (i ^ 0xffffffff))
                    break;
                int i_7_ = 0xff & is[i_5_++];
                class1.aByteArray1692[class1.anInt1680++] = (byte) (i_7_ + -48 + 43 * (-40 + i_6_));
            }
        }
        class1.method77((byte) -73);
        return class1.method66();
    }

    public static void method979(boolean arg0) {

        Class6.aBoolean260 = arg0;
            Class22.method305((byte) 124);
            if(!Class19.aBoolean490) {
                if((Class40_Sub5_Sub15.anInt2780 ^ 0xffffffff) != -2) {
                    if((Class40_Sub5_Sub15.anInt2780 ^ 0xffffffff) == -3) {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub5_Sub6.aClass1_2446, 239, 40, 0);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686((Class40_Sub5_Sub17_Sub6.method832(-50, new RSString[]{Class66.aClass1_1543, Class19.aClass1_478})), 239, 60, 128);
                    } else if(Class40_Sub5_Sub15.anInt2780 != 3) {
                        if(RSApplet.aClass1_8 == null) {
                            if(Class43.anInt1028 == -1) {
                                if((Class48.anInt1138 ^ 0xffffffff) != 0) {
                                    boolean bool = (Class40_Sub5_Sub6.method583(0, Class48.anInt1138, 96, (byte) -5, 0, 3, 479));
                                    if(!bool)
                                        Class52.aBoolean1221 = true;
                                } else {
                                    int line = 0;
                                    RSFont class40_sub5_sub14_sub1 = (Class53.aClass40_Sub5_Sub14_Sub1_1268);
                                    Rasterizer.method655(0, 0, 463, 77);
                                    for(int i_8_ = 0; (i_8_ ^ 0xffffffff) > -101; i_8_++) {
                                        if((Actor.aClass1Array3160[i_8_]) != null) {
                                            int i_9_ = Class66.anIntArray1569[i_8_];
                                            RSString class1 = (Renderable.aClass1Array2856[i_8_]);
                                            int i_10_ = (GameObjectDefinition.anInt2557 + 70 + -(line * 14));
                                            int i_11_ = 0;
                                            if(class1 != null && (class1.method75((byte) 116, Class51.aClass1_1210))) {
                                                class1 = (class1.method50((byte) 95, 5));
                                                i_11_ = 1;
                                            }
                                            if(class1 != null && (class1.method75((byte) 116, (Class40_Sub5_Sub12.aClass1_2729)))) {
                                                class1 = (class1.method50((byte) 95, 5));
                                                i_11_ = 2;
                                            }
                                            if(i_9_ == 0) {
                                                line++;
                                                if(i_10_ > 0 && ((i_10_ ^ 0xffffffff) > -111))
                                                    class40_sub5_sub14_sub1.method690((Actor.aClass1Array3160[i_8_]), 4, i_10_, 0);
                                            }
                                            if(((i_9_ ^ 0xffffffff) == -2 || i_9_ == 2) && (i_9_ == 1 || Class35.anInt1737 == 0 || ((Class35.anInt1737 ^ 0xffffffff) == -2 && (Class40_Sub2.method523(class1, -32624))))) {
                                                if((i_10_ ^ 0xffffffff) < -1 && ((i_10_ ^ 0xffffffff) > -111)) {
                                                    int i_12_ = 4;
                                                    if(i_11_ == 1) {
                                                        Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub2Array2753[0].method692(i_12_, i_10_ + -12);
                                                        i_12_ += 14;
                                                    }
                                                    if(i_11_ == 2) {
                                                        Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub2Array2753[1].method692(i_12_, i_10_ - 12);
                                                        i_12_ += 14;
                                                    }
                                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(53, (new RSString[]{class1, (Class43.aClass1_1027)}))), i_12_, i_10_, 0);
                                                    i_12_ += (8 + (class40_sub5_sub14_sub1.method685(class1)));
                                                    class40_sub5_sub14_sub1.method690((Actor.aClass1Array3160[i_8_]), i_12_, i_10_, 255);
                                                }
                                                line++;
                                            }
                                            if(((i_9_ ^ 0xffffffff) == -4 || i_9_ == 7) && CollisionMap.anInt165 == 0 && ((i_9_ ^ 0xffffffff) == -8 || Class4.anInt185 == 0 || ((Class4.anInt185 ^ 0xffffffff) == -2 && (Class40_Sub2.method523(class1, -32624))))) {
                                                line++;
                                                if((i_10_ ^ 0xffffffff) < -1 && i_10_ < 110) {
                                                    int i_13_ = 4;
                                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub6.aClass1_2458), i_13_, i_10_, 0);
                                                    i_13_ += (class40_sub5_sub14_sub1.method685(Class40_Sub5_Sub6.aClass1_2458));
                                                    i_13_ += class40_sub5_sub14_sub1.method689(32);
                                                    if(i_11_ == 1) {
                                                        Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub2Array2753[0].method692(i_13_, i_10_ + -12);
                                                        i_13_ += 14;
                                                    }
                                                    if((i_11_ ^ 0xffffffff) == -3) {
                                                        Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub2Array2753[1].method692(i_13_, i_10_ - 12);
                                                        i_13_ += 14;
                                                    }
                                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(103, (new RSString[]{class1, (Class43.aClass1_1027)}))), i_13_, i_10_, 0);
                                                    i_13_ += (8 + (class40_sub5_sub14_sub1.method685(class1)));
                                                    class40_sub5_sub14_sub1.method690((Actor.aClass1Array3160[i_8_]), i_13_, i_10_, 8388608);
                                                }
                                            }
                                            if(i_9_ == 4 && ((ItemDefinition.anInt2797) == 0 || (((ItemDefinition.anInt2797) ^ 0xffffffff) == -2 && (Class40_Sub2.method523(class1, -32624))))) {
                                                line++;
                                                if(i_10_ > 0 && i_10_ < 110)
                                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(-65, (new RSString[]{class1, (Class48.aClass1_1123), (Actor.aClass1Array3160[i_8_])}))), 4, i_10_, 8388736);
                                            }
                                            if(i_9_ == 5 && (CollisionMap.anInt165 ^ 0xffffffff) == -1 && Class4.anInt185 < 2) {
                                                if(i_10_ > 0 && i_10_ < 110)
                                                    class40_sub5_sub14_sub1.method690((Actor.aClass1Array3160[i_8_]), 4, i_10_, 8388608);
                                                line++;
                                            }
                                            if(i_9_ == 6 && (CollisionMap.anInt165 ^ 0xffffffff) == -1 && Class4.anInt185 < 2) {
                                                if(i_10_ > 0 && ((i_10_ ^ 0xffffffff) > -111)) {
                                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(-108, (new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), class1, (Class43.aClass1_1027)}))), 4, i_10_, 0);
                                                    class40_sub5_sub14_sub1.method690((Actor.aClass1Array3160[i_8_]), (class40_sub5_sub14_sub1.method685(Class40_Sub5_Sub17_Sub6.method832(-98, (new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), class1})))) + 12, i_10_, 8388608);
                                                }
                                                line++;
                                            }
                                            if(i_9_ == 8 && ((ItemDefinition.anInt2797) == 0 || (((ItemDefinition.anInt2797) ^ 0xffffffff) == -2 && (Class40_Sub2.method523(class1, -32624))))) {
                                                line++;
                                                if(i_10_ > 0 && ((i_10_ ^ 0xffffffff) > -111))
                                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(-105, (new RSString[]{class1, (Class48.aClass1_1123), (Actor.aClass1Array3160[i_8_])}))), 4, i_10_, 8270336);
                                            }
                                        }
                                    }
                                    Rasterizer.method662();
                                    Class62.chatboxScrollMax = line * 14 + 7;
                                    if(Class62.chatboxScrollMax < 78)
                                        Class62.chatboxScrollMax = 78;
                                    Class27.method355(0, (-(GameObjectDefinition.anInt2557) + Class62.chatboxScrollMax - 77), Class62.chatboxScrollMax, 463, 77, 0);
                                    RSString class1;
                                    if(((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760) != null) && (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.aClass1_3278) != null)
                                        class1 = (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.aClass1_3278);
                                    else
                                        class1 = Class22_Sub2.username;
                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(-62, (new RSString[]{class1, Class43.aClass1_1027}))), 4, 90, 0);
                                    class40_sub5_sub14_sub1.method690((Class40_Sub5_Sub17_Sub6.method832(71, (new RSString[]{Class66.aClass1_1556, Class19.aClass1_478}))), ((class40_sub5_sub14_sub1.method685(Class40_Sub5_Sub17_Sub6.method832(-99, (new RSString[]{class1, ISAAC.aClass1_515})))) + 6), 90, 255);
                                    Rasterizer.method659(0, 77, 479, 0);
                                }
                            } else {
                                boolean bool = Class40_Sub5_Sub6.method583(0, (Class43.anInt1028), 96, (byte) -5, 0, 2, 479);
                                if(!bool)
                                    Class52.aBoolean1221 = true;
                            }
                        } else {
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(RSApplet.aClass1_8, 239, 40, 0);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class34.aClass1_829, 239, 60, 128);
                        }
                    } else {
                        if(Class66.aClass1_1543 != Class66.aClass1_1542) {
                            GameObject.method773((byte) -96, Class66.aClass1_1543);
                            Class66.aClass1_1542 = Class66.aClass1_1543;
                        }
                        RSFont class40_sub5_sub14_sub1 = Class53.aClass40_Sub5_Sub14_Sub1_1268;
                        Rasterizer.method655(0, 0, 463, 77);
                        for(int i = 0; (i < VertexNormal.anInt1110); i++) {
                            int i_14_ = i * 14 + (18 - Class26.anInt617);
                            if((i_14_ ^ 0xffffffff) < -1 && (i_14_ ^ 0xffffffff) > -111)
                                class40_sub5_sub14_sub1.method686(Class22_Sub1.aClass1Array1844[i], 239, i_14_, 0);
                        }
                        Rasterizer.method662();
                        if((VertexNormal.anInt1110 ^ 0xffffffff) < -6)
                            Class27.method355(0, Class26.anInt617, 7 + 14 * VertexNormal.anInt1110, 463, 77, 0);
                        if(Class66.aClass1_1543.method59(-3136) != 0) {
                            if((VertexNormal.anInt1110 ^ 0xffffffff) == -1)
                                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub6.aClass1_2097, 239, 40, 0);
                        } else
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class35.aClass1_1747, 239, 40, 255);
                        class40_sub5_sub14_sub1.method686((Class40_Sub5_Sub17_Sub6.method832(-122, new RSString[]{Class66.aClass1_1543, Class19.aClass1_478})), 239, 90, 0);
                        Rasterizer.method659(0, 77, 479, 0);
                    }
                } else {
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Landscape.aClass1_1174, 239, 40, 0);
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686((Class40_Sub5_Sub17_Sub6.method832(73, new RSString[]{Class66.aClass1_1543, Class19.aClass1_478})), 239, 60, 128);
                }
            } else {
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class66.aClass1_1563, 239, 40, 0);
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub5_Sub17_Sub6.method832(-117, (new RSString[]{Class66.aClass1_1565, (Class19.aClass1_478)})), 239, 60, 128);
            }
            anInt1357++;
            if(Class4.aBoolean173 && (Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -3)
                Class40_Sub5_Sub6.method588(-1);
            Class45.method908((byte) 122);

    }

    public static void method980(int arg0, Class6 arg1, boolean arg2, Class6 arg3) {

        Class40_Sub3.aClass6_2037 = arg3;
            Class35.aBoolean1734 = arg2;
            anInt1351++;
            if(arg0 == 28987)
                RSString.aClass6_1705 = arg1;

    }

    public static void method981(byte arg0) {

        aClass1_1354 = null;
            varbitmasks = null;
            aByteArrayArray1377 = null;
            aClass1_1365 = null;
            aClass1_1374 = null;
            aClass9_1364 = null;
            anIntArray1358 = null;
            if(arg0 == -120) {
                aByteArrayArray1370 = null;
                aClass1_1378 = null;
                aClass1_1359 = null;
                aClass6_1375 = null;
            }

    }
}
