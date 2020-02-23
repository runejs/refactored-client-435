package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;

import java.io.IOException;
import java.net.Socket;

public class Class40_Sub5_Sub2 extends SubNode {
    public static ImageRGB minimapEdge;
    public static RSString str_prefix_level = RSString.CreateString("level)2");
    public static RSString cmd_noclip = RSString.CreateString("::noclip");
    public static RSString aClass1_2291 = RSString.CreateString("W-=hlen Sie eine Option");
    public static RSString aClass1_2292 = (RSString.CreateString("Verbindung konnte nicht hergestellt werden)3"));
    public static RSString aClass1_2294 = RSString.CreateString("Loading textures )2 ");
    public static RSString aClass1_2296 = RSString.CreateString("Nehmen");
    public static RSString aClass1_2297 = RSString.CreateString("Loaded input handler");
    public static Class67 aClass67_2298;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array2301;
    public static int anInt2302 = 0;
    public static RSString aClass1_2306 = RSString.CreateString(" )2> @yel@");
    public static int anInt2307;
    public static RSString aClass1_2311 = RSString.CreateString("leuchten3:");

    public int anInt2287;
    public int anInt2293;
    public int anInt2295 = 0;
    public int anInt2300 = 0;
    public int anInt2305 = 128;
    public int anInt2308;
    public int[] anIntArray2309;
    public int anInt2310;
    public int[] anIntArray2312;
    public int anInt2313;

    public Class40_Sub5_Sub2() {
        anInt2287 = -1;
        anIntArray2309 = new int[6];
        anInt2308 = 0;
        anInt2313 = 128;
        anIntArray2312 = new int[6];
    }

    public static void method548(int arg0) {

        if(arg0 != -3254) {
            method548(-111);
        }
        aClass1_2291 = null;
        aClass67_2298 = null;
        aClass1_2297 = null;
        aClass40_Sub5_Sub14_Sub2Array2301 = null;
        minimapEdge = null;
        aClass1_2306 = null;
        aClass1_2294 = null;
        aClass1_2311 = null;
        cmd_noclip = null;
        str_prefix_level = null;
        aClass1_2296 = null;
        aClass1_2292 = null;

    }

    public static IndexedImage[] method550(Class6 arg0, byte arg1, RSString arg2, RSString arg3) {
        int i = arg0.method183(0, arg2);
        int i_1_ = arg0.method179(-118, i, arg3);
        return Class24.method337(7729, arg0, i_1_, i);
    }

    public static void method552(boolean arg0) {
        try {
            if(Class40_Sub3.anInt2032 == 0) {
                if(Class40_Sub6.aClass64_2098 != null) {
                    Class40_Sub6.aClass64_2098.method1009(63);
                    Class40_Sub6.aClass64_2098 = null;
                }
                Class37.aBoolean871 = false;
                Class40_Sub3.anInt2032 = 1;
                Main.anInt1756 = 0;
                FloorDecoration.aClass15_607 = null;
            }
            if(Class40_Sub3.anInt2032 == 1) {
                if(FloorDecoration.aClass15_607 == null) {
                    FloorDecoration.aClass15_607 = ISAAC.aClass31_521.method395(3, Class10.anInt350);
                }
                if(FloorDecoration.aClass15_607.anInt434 == 2) {
                    throw new IOException();
                }
                if((FloorDecoration.aClass15_607.anInt434 ^ 0xffffffff) == -2) {
                    Class40_Sub6.aClass64_2098 = new Class64(((Socket) FloorDecoration.aClass15_607.anObject437), ISAAC.aClass31_521);
                    Class40_Sub3.anInt2032 = 2;
                    FloorDecoration.aClass15_607 = null;
                }
            }
            if(arg0 != true) {
                aClass1_2297 = null;
            }
            if((Class40_Sub3.anInt2032 ^ 0xffffffff) == -3) {
                long l = (Class34.aLong853 = Class22_Sub2.username.method58((byte) 93));
                Class32.packetBuffer.currentPosition = 0;
                Class32.packetBuffer.putByte(14);
                int i = (int) (0x1fL & l >> 383714384);
                Class32.packetBuffer.putByte(i);
                Class40_Sub6.aClass64_2098.method1010(2, (byte) -19, 0, (Class32.packetBuffer.buffer));
                Class40_Sub3.anInt2032 = 3;
                Cache.outgoingbuffer.currentPosition = 0;
            }
            if((Class40_Sub3.anInt2032 ^ 0xffffffff) == -4) {
                int i = Class40_Sub6.aClass64_2098.method1016(52);
                if((i ^ 0xffffffff) != -1) {
                    Class27.method366(5, i);
                    return;
                }
                Cache.outgoingbuffer.currentPosition = 0;
                Class40_Sub3.anInt2032 = 4;
            }
            if((Class40_Sub3.anInt2032 ^ 0xffffffff) == -5) {
                if(Cache.outgoingbuffer.currentPosition < 8) {
                    int i = Class40_Sub6.aClass64_2098.method1014(-127);
                    if((i ^ 0xffffffff) < (-Cache.outgoingbuffer.currentPosition + 8 ^ 0xffffffff)) {
                        i = -Cache.outgoingbuffer.currentPosition + 8;
                    }
                    if(i > 0) {
                        Class40_Sub6.aClass64_2098.method1008(Cache.outgoingbuffer.currentPosition, i, -128, Cache.outgoingbuffer.buffer);
                        Cache.outgoingbuffer.currentPosition += i;
                    }
                }
                if(Cache.outgoingbuffer.currentPosition == 8) {
                    Cache.outgoingbuffer.currentPosition = 0;
                    Renderable.aLong2858 = Cache.outgoingbuffer.getLongBE();
                    Class40_Sub3.anInt2032 = 5;
                }
            }
            if(Class40_Sub3.anInt2032 == 5) {
                int[] seeds = new int[4];
                seeds[0] = (int) (Math.random() * 9.9999999E7);
                seeds[1] = (int) (Math.random() * 9.9999999E7);
                seeds[2] = (int) (Renderable.aLong2858 >> 357599968);
                seeds[3] = (int) Renderable.aLong2858;
                Class32.packetBuffer.currentPosition = 0;
                Class32.packetBuffer.putByte(10);
                Class32.packetBuffer.putIntBE(seeds[0]);
                Class32.packetBuffer.putIntBE(seeds[1]);
                Class32.packetBuffer.putIntBE(seeds[2]);
                Class32.packetBuffer.putIntBE(seeds[3]);
                Class32.packetBuffer.putIntBE(ISAAC.aClass31_521.anInt722);
                Class32.packetBuffer.putLongBE(Class22_Sub2.username.method58((byte) 97));
                Class32.packetBuffer.method505(Class22_Sub2.password);
                Class32.packetBuffer.applyRSA(Actor.rsaModulus, PacketBuffer.rsaKey);
                Class61.packetBuffer.currentPosition = 0;
                if(Class51.anInt1197 == 40) {
                    Class61.packetBuffer.putByte(18);
                } else {
                    Class61.packetBuffer.putByte(16);
                }
                Class61.packetBuffer.putByte(57 + Class32.packetBuffer.currentPosition);
                Class61.packetBuffer.putIntBE(435);
                Class61.packetBuffer.putByte(VertexNormal.lowMemory ? 1 : 0);
                Class61.packetBuffer.putIntBE(FloorDecoration.aClass6_Sub1_605.anInt216);
                Class61.packetBuffer.putIntBE(Class40_Sub5_Sub17_Sub1.aClass6_Sub1_3000.anInt216);
                Class61.packetBuffer.putIntBE((IdentityKit.aClass6_Sub1_2609.anInt216));
                Class61.packetBuffer.putIntBE(Class65.aClass6_Sub1_1533.anInt216);
                Class61.packetBuffer.putIntBE(Actor.aClass6_Sub1_3157.anInt216);
                Class61.packetBuffer.putIntBE((Renderable.aClass6_Sub1_2857.anInt216));
                Class61.packetBuffer.putIntBE(Class55.aClass6_Sub1_1286.anInt216);
                Class61.packetBuffer.putIntBE((Class40_Sub5_Sub9.aClass6_Sub1_2571.anInt216));
                Class61.packetBuffer.putIntBE((ActorDefinition.aClass6_Sub1_2377.anInt216));
                Class61.packetBuffer.putIntBE(Class32.aClass6_Sub1_773.anInt216);
                Class61.packetBuffer.putIntBE(RSCanvas.aClass6_Sub1_48.anInt216);
                Class61.packetBuffer.putIntBE(VertexNormal.aClass6_Sub1_1104.anInt216);
                Class61.packetBuffer.putIntBE(Class56.aClass6_Sub1_1323.anInt216);
                Class61.packetBuffer.putBytes(0, Class32.packetBuffer.currentPosition, Class32.packetBuffer.buffer);
                Class40_Sub6.aClass64_2098.method1010(Class61.packetBuffer.currentPosition, (byte) -19, 0, Class61.packetBuffer.buffer);
                Class32.packetBuffer.initEncryption(-1, seeds);
                for(int i = 0; i < 4; i++) {
                    seeds[i] += 50;
                }
                Cache.outgoingbuffer.initEncryption(-1, seeds);
                Class40_Sub3.anInt2032 = 6;
            }
            if(Class40_Sub3.anInt2032 == 6 && Class40_Sub6.aClass64_2098.method1014(-126) > 0) {
                int i = Class40_Sub6.aClass64_2098.method1016(63);
                if(i != 21 || Class51.anInt1197 != 20) {
                    if(i != 2) {
                        if((i ^ 0xffffffff) == -16 && (Class51.anInt1197 ^ 0xffffffff) == -41) {
                            Class37.method434(0);
                            return;
                        }
                        if(i == 23 && (Floor.anInt2321 ^ 0xffffffff) > -2) {
                            Floor.anInt2321++;
                            Class40_Sub3.anInt2032 = 0;
                        } else {
                            Class27.method366(5, i);
                            return;
                        }
                    } else {
                        Class40_Sub3.anInt2032 = 9;
                    }
                } else {
                    Class40_Sub3.anInt2032 = 7;
                }
            }
            if(Class40_Sub3.anInt2032 == 7 && ((Class40_Sub6.aClass64_2098.method1014(-128) ^ 0xffffffff) < -1)) {
                Class33.anInt784 = 180 + Class40_Sub6.aClass64_2098.method1016(85) * 60;
                Class40_Sub3.anInt2032 = 8;
            }
            if(Class40_Sub3.anInt2032 == 8) {
                Main.anInt1756 = 0;
                Class33.method411((Class40_Sub5_Sub17_Sub6.method832(-83, (new RSString[]{HashTable.method334(Class33.anInt784 / 60, -1), Class38.aClass1_883}))), Class8.aClass1_294, RSCanvas.aClass1_67, (byte) -82);
                if((--Class33.anInt784 ^ 0xffffffff) >= -1) {
                    Class40_Sub3.anInt2032 = 0;
                }
            } else {
                if(Class40_Sub3.anInt2032 == 9 && Class40_Sub6.aClass64_2098.method1014(-121) >= 8) {
                    Class19.anInt493 = Class40_Sub6.aClass64_2098.method1016(99);
                    Class22.aBoolean544 = (Class40_Sub6.aClass64_2098.method1016(38) ^ 0xffffffff) == -2;
                    Class30.anInt708 = Class40_Sub6.aClass64_2098.method1016(86);
                    Class30.anInt708 <<= 8;
                    Class30.anInt708 += Class40_Sub6.aClass64_2098.method1016(16);
                    Class44.anInt1049 = Class40_Sub6.aClass64_2098.method1016(37);
                    Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                    Cache.outgoingbuffer.currentPosition = 0;
                    Class57.packetid = Cache.outgoingbuffer.getPacket((byte) 49);
                    Class40_Sub6.aClass64_2098.method1008(0, 2, -127, Cache.outgoingbuffer.buffer);
                    Cache.outgoingbuffer.currentPosition = 0;
                    Class40_Sub5_Sub12.packetsize = Cache.outgoingbuffer.getUnsignedShortBE();
                    Class40_Sub3.anInt2032 = 10;
                }
                if((Class40_Sub3.anInt2032 ^ 0xffffffff) == -11) {
                    if((Class40_Sub6.aClass64_2098.method1014(-124) ^ 0xffffffff) <= (Class40_Sub5_Sub12.packetsize ^ 0xffffffff)) {
                        Cache.outgoingbuffer.currentPosition = 0;
                        Class40_Sub6.aClass64_2098.method1008(0, Class40_Sub5_Sub12.packetsize, -128, Cache.outgoingbuffer.buffer);
                        Main.method44(0);
                        Class51.anInt1202 = -1;
                        FloorDecoration.method343(false, 5688);
                        Class57.packetid = -1;
                    }
                } else {
                    Main.anInt1756++;
                    if((Main.anInt1756 ^ 0xffffffff) < -2001) {
                        if(Floor.anInt2321 < 1) {
                            Floor.anInt2321++;
                            if(Floor.anInt2340 == Class10.anInt350) {
                                Class10.anInt350 = CollisionMap.anInt172;
                            } else {
                                Class10.anInt350 = Floor.anInt2340;
                            }
                            Class40_Sub3.anInt2032 = 0;
                        } else {
                            Class27.method366(5, -3);
                        }
                    }
                }
            }
        } catch(IOException ioexception) {
            if((Floor.anInt2321 ^ 0xffffffff) > -2) {
                if(Class10.anInt350 == Floor.anInt2340) {
                    Class10.anInt350 = CollisionMap.anInt172;
                } else {
                    Class10.anInt350 = Floor.anInt2340;
                }
                Floor.anInt2321++;
                Class40_Sub3.anInt2032 = 0;
            } else {
                Class27.method366(5, -2);
            }
        }
    }

    public void method547(int opcode, byte arg1, Buffer arg2) {

        if(arg1 > -100) {
            anInt2308 = -55;
        }
        if(opcode == 1) {
            anInt2293 = arg2.getUnsignedShortBE();
        } else if(opcode == 2) {
            anInt2287 = arg2.getUnsignedShortBE();
        } else if(opcode == 4) {
            anInt2305 = arg2.getUnsignedShortBE();
        } else if(opcode == 5) {
            anInt2313 = arg2.getUnsignedShortBE();
        } else if(opcode == 6) {
            anInt2308 = arg2.getUnsignedShortBE();
        } else if(opcode == 7) {
            anInt2300 = arg2.getUnsignedByte();
        } else if(opcode == 8) {
            anInt2295 = arg2.getUnsignedByte();
        } else if(opcode >= 40 && opcode < 50) {
            anIntArray2309[-40 + opcode] = arg2.getUnsignedShortBE();
        } else if(opcode >= 50 && (opcode ^ 0xffffffff) > -61) {
            anIntArray2312[-50 + opcode] = arg2.getUnsignedShortBE();
        }

    }

    public Model method549(int arg0, int arg1) {
        Model class40_sub5_sub17_sub5 = ((Model) Class34.aClass9_851.method231((long) anInt2310, (byte) 50));
        if(class40_sub5_sub17_sub5 == null) {
            class40_sub5_sub17_sub5 = Model.getModel((Class40_Sub5_Sub9.aClass6_2582), anInt2293, 0);
            if(class40_sub5_sub17_sub5 == null) {
                return null;
            }
            for(int i = 0; (i ^ 0xffffffff) > -7; i++) {
                if((anIntArray2309[0] ^ 0xffffffff) != -1) {
                    class40_sub5_sub17_sub5.replaceColor(anIntArray2309[i], anIntArray2312[i]);
                }
            }
            class40_sub5_sub17_sub5.method810();
            class40_sub5_sub17_sub5.method802(64 + anInt2300, anInt2295 + 850, -30, -50, -30, true);
            Class34.aClass9_851.method230(-7208, (long) anInt2310, class40_sub5_sub17_sub5);
        }
        Model class40_sub5_sub17_sub5_0_;
        if(anInt2287 != -1 && (arg0 ^ 0xffffffff) != 0) {
            class40_sub5_sub17_sub5_0_ = (Class68_Sub1.method1050(anInt2287, 2).method597((byte) -87, class40_sub5_sub17_sub5, arg0));
        } else {
            class40_sub5_sub17_sub5_0_ = class40_sub5_sub17_sub5.method806(true);
        }
        if(arg1 != 2) {
            return null;
        }
        if(anInt2305 != 128 || anInt2313 != 128) {
            class40_sub5_sub17_sub5_0_.method821(anInt2305, anInt2313, anInt2305);
        }
        if(anInt2308 != 0) {
            if(anInt2308 == 90) {
                class40_sub5_sub17_sub5_0_.method813();
            }
            if(anInt2308 == 180) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
            if((anInt2308 ^ 0xffffffff) == -271) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
        }
        return class40_sub5_sub17_sub5_0_;

    }

    public void method551(Buffer arg0, byte arg1) {
        for(; ; ) {
            int i = arg0.getUnsignedByte();
            if(i == 0) {
                break;
            }
            method547(i, (byte) -107, arg0);
        }
        int i = -3 / ((-30 - arg1) / 53);

    }
}
