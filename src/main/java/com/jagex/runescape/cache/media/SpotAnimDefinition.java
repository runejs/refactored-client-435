package com.jagex.runescape.cache.media;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

import java.io.IOException;
import java.net.Socket;

public class SpotAnimDefinition extends SubNode {
    public static ImageRGB minimapEdge;
    public static RSString str_prefix_level = RSString.CreateString("level)2");
    public static RSString cmd_noclip = RSString.CreateString("::noclip");
    public static RSString aClass1_2294 = RSString.CreateString("Loading textures )2 ");
    public static RSString aClass1_2297 = RSString.CreateString("Loaded input handler");
    public static Class67 aClass67_2298;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array2301;
    public static int mouseButtonPressed = 0;
    public static RSString aClass1_2306 = RSString.CreateString(" )2> @yel@");
    public static int baseX;

    public int animationId;
    public int modelId;
    public int contrast = 0;
    public int ambient = 0;
    public int resizeX = 128;
    public int rotaton;
    public int[] recolorToFind;
    public int id;
    public int[] recolorToReplace;
    public int resizeY;

    public SpotAnimDefinition() {
        animationId = -1;
        recolorToFind = new int[6];
        rotaton = 0;
        resizeY = 128;
        recolorToReplace = new int[6];
    }

    public static void method548() {
        aClass67_2298 = null;
        aClass1_2297 = null;
        aClass40_Sub5_Sub14_Sub2Array2301 = null;
        minimapEdge = null;
        aClass1_2306 = null;
        aClass1_2294 = null;
        cmd_noclip = null;
        str_prefix_level = null;
    }

    public static void method552(boolean arg0) {
        try {
            if (Class40_Sub3.anInt2032 == 0) {
                if (Class40_Sub6.aClass64_2098 != null) {
                    Class40_Sub6.aClass64_2098.method1009();
                    Class40_Sub6.aClass64_2098 = null;
                }
                Class37.aBoolean871 = false;
                Class40_Sub3.anInt2032 = 1;
                Main.anInt1756 = 0;
                FloorDecoration.aSignlinkNode_607 = null;
            }
            if (Class40_Sub3.anInt2032 == 1) {
                if (FloorDecoration.aSignlinkNode_607 == null) {
                    FloorDecoration.aSignlinkNode_607 = ISAAC.aClass31_521.method395(3, Wall.anInt350);
                }
                if (FloorDecoration.aSignlinkNode_607.anInt434 == 2) {
                    throw new IOException();
                }
                if (FloorDecoration.aSignlinkNode_607.anInt434 == 1) {
                    Class40_Sub6.aClass64_2098 = new Class64(((Socket) FloorDecoration.aSignlinkNode_607.value), ISAAC.aClass31_521);
                    Class40_Sub3.anInt2032 = 2;
                    FloorDecoration.aSignlinkNode_607 = null;
                }
            }
            if (!arg0) {
                aClass1_2297 = null;
            }
            if (Class40_Sub3.anInt2032 == 2) {
                long l = (Class34.aLong853 = Native.username.method58((byte) 93));
                SceneCluster.packetBuffer.currentPosition = 0;
                SceneCluster.packetBuffer.putByte(14);
                int i = (int) (0x1fL & l >> 16);
                SceneCluster.packetBuffer.putByte(i);
                Class40_Sub6.aClass64_2098.method1010(2, (byte) -19, 0, (SceneCluster.packetBuffer.buffer));
                Class40_Sub3.anInt2032 = 3;
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
            }
            if (Class40_Sub3.anInt2032 == 3) {
                int i = Class40_Sub6.aClass64_2098.method1016();
                if (i != 0) {
                    Class27.method366(i);
                    return;
                }
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                Class40_Sub3.anInt2032 = 4;
            }
            if (Class40_Sub3.anInt2032 == 4) {
                if (IncomingPackets.incomingPacketBuffer.currentPosition < 8) {
                    int i = Class40_Sub6.aClass64_2098.method1014(-127);
                    if ((i > -IncomingPackets.incomingPacketBuffer.currentPosition + 8)) {
                        i = -IncomingPackets.incomingPacketBuffer.currentPosition + 8;
                    }
                    if (i > 0) {
                        Class40_Sub6.aClass64_2098.method1008(IncomingPackets.incomingPacketBuffer.currentPosition, i, -128, IncomingPackets.incomingPacketBuffer.buffer);
                        IncomingPackets.incomingPacketBuffer.currentPosition += i;
                    }
                }
                if (IncomingPackets.incomingPacketBuffer.currentPosition == 8) {
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    Renderable.aLong2858 = IncomingPackets.incomingPacketBuffer.getLongBE();
                    Class40_Sub3.anInt2032 = 5;
                }
            }
            if (Class40_Sub3.anInt2032 == 5) {
                int[] seeds = new int[4];
                seeds[0] = (int) (Math.random() * 9.9999999E7);
                seeds[1] = (int) (Math.random() * 9.9999999E7);
                seeds[2] = (int) (Renderable.aLong2858 >> 32);
                seeds[3] = (int) Renderable.aLong2858;
                SceneCluster.packetBuffer.currentPosition = 0;
                SceneCluster.packetBuffer.putByte(10);
                SceneCluster.packetBuffer.putIntBE(seeds[0]);
                SceneCluster.packetBuffer.putIntBE(seeds[1]);
                SceneCluster.packetBuffer.putIntBE(seeds[2]);
                SceneCluster.packetBuffer.putIntBE(seeds[3]);
                SceneCluster.packetBuffer.putIntBE(ISAAC.aClass31_521.uid);
                SceneCluster.packetBuffer.putLongBE(Native.username.method58((byte) 97));
                SceneCluster.packetBuffer.method505(Native.password);
                if (Configuration.RSA_ENABLED) {
                    SceneCluster.packetBuffer.applyRSA(Configuration.RSA_MODULUS, Configuration.RSA_PUBLIC_KEY);
                }
                Class61.packetBuffer.currentPosition = 0;
                if (Class51.anInt1197 == 40) {
                    Class61.packetBuffer.putByte(18);
                } else {
                    Class61.packetBuffer.putByte(16);
                }
                Class61.packetBuffer.putByte(57 + SceneCluster.packetBuffer.currentPosition);
                Class61.packetBuffer.putIntBE(435);
                Class61.packetBuffer.putByte(VertexNormal.lowMemory ? 1 : 0);
                Class61.packetBuffer.putIntBE(FloorDecoration.aClass6_Sub1_605.anInt216);
                Class61.packetBuffer.putIntBE(Class40_Sub5_Sub17_Sub1.aClass6_Sub1_3000.anInt216);
                Class61.packetBuffer.putIntBE((IdentityKit.aClass6_Sub1_2609.anInt216));
                Class61.packetBuffer.putIntBE(Class65.aClass6_Sub1_1533.anInt216);
                Class61.packetBuffer.putIntBE(Actor.aClass6_Sub1_3157.anInt216);
                Class61.packetBuffer.putIntBE((Renderable.aClass6_Sub1_2857.anInt216));
                Class61.packetBuffer.putIntBE(Class55.aClass6_Sub1_1286.anInt216);
                Class61.packetBuffer.putIntBE((UnderlayDefinition.aClass6_Sub1_2571.anInt216));
                Class61.packetBuffer.putIntBE((ActorDefinition.aClass6_Sub1_2377.anInt216));
                Class61.packetBuffer.putIntBE(SceneCluster.aClass6_Sub1_773.anInt216);
                Class61.packetBuffer.putIntBE(RSCanvas.aClass6_Sub1_48.anInt216);
                Class61.packetBuffer.putIntBE(VertexNormal.aClass6_Sub1_1104.anInt216);
                Class61.packetBuffer.putIntBE(Class56.aClass6_Sub1_1323.anInt216);
                Class61.packetBuffer.putBytes(0, SceneCluster.packetBuffer.currentPosition, SceneCluster.packetBuffer.buffer);
                Class40_Sub6.aClass64_2098.method1010(Class61.packetBuffer.currentPosition, (byte) -19, 0, Class61.packetBuffer.buffer);
                SceneCluster.packetBuffer.initOutCipher(seeds);
                for (int i = 0; i < 4; i++) {
                    seeds[i] += 50;
                }
                IncomingPackets.incomingPacketBuffer.initInCipher(seeds);
                Class40_Sub3.anInt2032 = 6;
            }
            if (Class40_Sub3.anInt2032 == 6 && Class40_Sub6.aClass64_2098.method1014(-126) > 0) {
                int i = Class40_Sub6.aClass64_2098.method1016();
                if (i != 21 || Class51.anInt1197 != 20) {
                    if (i == 2) {
                        Class40_Sub3.anInt2032 = 9;
                    } else {
                        if (i == 15 && Class51.anInt1197 == 40) {
                            Class37.method434(0);
                            return;
                        }
                        if (i == 23 && OverlayDefinition.anInt2321 < 1) {
                            OverlayDefinition.anInt2321++;
                            Class40_Sub3.anInt2032 = 0;
                        } else {
                            Class27.method366(i);
                            return;
                        }
                    }
                } else {
                    Class40_Sub3.anInt2032 = 7;
                }
            }
            if (Class40_Sub3.anInt2032 == 7 && (Class40_Sub6.aClass64_2098.method1014(-128) > 0)) {
                Class33.anInt784 = 180 + Class40_Sub6.aClass64_2098.method1016() * 60;
                Class40_Sub3.anInt2032 = 8;
            }
            if (Class40_Sub3.anInt2032 == 8) {
                Main.anInt1756 = 0;
                Class33.method411((RSString.linkRSStrings((new RSString[]{HashTable.method334(Class33.anInt784 / 60), Class38.aClass1_883}))), Class8.aClass1_294, RSCanvas.aClass1_67, (byte) -82);
                if (--Class33.anInt784 <= 0) {
                    Class40_Sub3.anInt2032 = 0;
                }
            } else {
                if (Class40_Sub3.anInt2032 == 9 && Class40_Sub6.aClass64_2098.method1014(-121) >= 8) {
                    InteractiveObject.playerRights = Class40_Sub6.aClass64_2098.method1016();
                    Class22.accountFlagged = Class40_Sub6.aClass64_2098.method1016() == 1;
                    Class30.anInt708 = Class40_Sub6.aClass64_2098.method1016();
                    Class30.anInt708 <<= 8;
                    Class30.anInt708 += Class40_Sub6.aClass64_2098.method1016();
                    Class44.anInt1049 = Class40_Sub6.aClass64_2098.method1016();
                    Class40_Sub6.aClass64_2098.method1008(0, 1, -127, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacket = IncomingPackets.incomingPacketBuffer.getPacket();
                    Class40_Sub6.aClass64_2098.method1008(0, 2, -127, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacketSize = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    Class40_Sub3.anInt2032 = 10;
                }
                if (Class40_Sub3.anInt2032 == 10) {
                    if ((Class40_Sub6.aClass64_2098.method1014(-124) >= IncomingPackets.incomingPacketSize)) {
                        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                        Class40_Sub6.aClass64_2098.method1008(0, IncomingPackets.incomingPacketSize, -128, IncomingPackets.incomingPacketBuffer.buffer);
                        Main.method44();
                        Class51.regionX = -1;
                        FloorDecoration.method343(false, 5688);
                        IncomingPackets.incomingPacket = -1;
                    }
                } else {
                    Main.anInt1756++;
                    if (Main.anInt1756 > 2000) {
                        if (OverlayDefinition.anInt2321 < 1) {
                            OverlayDefinition.anInt2321++;
                            if (OverlayDefinition.anInt2340 == Wall.anInt350) {
                                Wall.anInt350 = CollisionMap.anInt172;
                            } else {
                                Wall.anInt350 = OverlayDefinition.anInt2340;
                            }
                            Class40_Sub3.anInt2032 = 0;
                        } else {
                            Class27.method366(-3);
                        }
                    }
                }
            }
        } catch (IOException ioexception) {
            if (OverlayDefinition.anInt2321 < 1) {
                if (Wall.anInt350 == OverlayDefinition.anInt2340) {
                    Wall.anInt350 = CollisionMap.anInt172;
                } else {
                    Wall.anInt350 = OverlayDefinition.anInt2340;
                }
                OverlayDefinition.anInt2321++;
                Class40_Sub3.anInt2032 = 0;
            } else {
                Class27.method366(-2);
            }
        }
    }

    public static SpotAnimDefinition forId(int arg0, int arg1) {
        if (arg1 != 13)
            Class37.method436(-34);
        SpotAnimDefinition spotAnimDefinition = ((SpotAnimDefinition) Class43.aClass9_1014.get((long) arg0, (byte) 59));
        if (spotAnimDefinition != null)
            return spotAnimDefinition;
        byte[] is = InteractiveObject.aCacheIndex_488.getFile(arg0, 13);
        spotAnimDefinition = new SpotAnimDefinition();
        spotAnimDefinition.id = arg0;
        if (is != null)
            spotAnimDefinition.readValues(new Buffer(is));
        Class43.aClass9_1014.put((long) arg0, spotAnimDefinition);
        return spotAnimDefinition;
    }

    public void readValue(int opcode, byte arg1, Buffer buffer) {
        if (arg1 > -100) {
            rotaton = -55;
        }
        if (opcode == 1) {
            modelId = buffer.getUnsignedShortBE();
        } else if (opcode == 2) {
            animationId = buffer.getUnsignedShortBE();
        } else if (opcode == 4) {
            resizeX = buffer.getUnsignedShortBE();
        } else if (opcode == 5) {
            resizeY = buffer.getUnsignedShortBE();
        } else if (opcode == 6) {
            rotaton = buffer.getUnsignedShortBE();
        } else if (opcode == 7) {
            ambient = buffer.getUnsignedByte();
        } else if (opcode == 8) {
            contrast = buffer.getUnsignedByte();
        } else if (opcode >= 40 && opcode < 50) {
            recolorToFind[-40 + opcode] = buffer.getUnsignedShortBE();
        } else if (opcode >= 50 && opcode < 60) {
            recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        }
    }

    public Model method549(int arg0, int arg1) {
        Model class40_sub5_sub17_sub5 = ((Model) Class34.aClass9_851.get((long) id, (byte) 50));
        if (class40_sub5_sub17_sub5 == null) {
            class40_sub5_sub17_sub5 = Model.getModel((UnderlayDefinition.aCacheIndex_2582), modelId, 0);
            if (class40_sub5_sub17_sub5 == null) {
                return null;
            }
            for (int i = 0; i < 6; i++) {
                if (recolorToFind[0] != 0) {
                    class40_sub5_sub17_sub5.replaceColor(recolorToFind[i], recolorToReplace[i]);
                }
            }
            class40_sub5_sub17_sub5.createBones();
            class40_sub5_sub17_sub5.applyLighting(64 + ambient, contrast + 850, -30, -50, -30, true);
            Class34.aClass9_851.put((long) id, class40_sub5_sub17_sub5);
        }
        Model class40_sub5_sub17_sub5_0_;
        if (animationId == -1 || arg0 == -1) {
            class40_sub5_sub17_sub5_0_ = class40_sub5_sub17_sub5.method806(true);
        } else {
            class40_sub5_sub17_sub5_0_ = (Class68_Sub1.method1050(animationId, 2).method597((byte) -87, class40_sub5_sub17_sub5, arg0));
        }
        if (arg1 != 2) {
            return null;
        }
        if (resizeX != 128 || resizeY != 128) {
            class40_sub5_sub17_sub5_0_.scaleT(resizeX, resizeY, resizeX);
        }
        if (rotaton != 0) {
            if (rotaton == 90) {
                class40_sub5_sub17_sub5_0_.method813();
            }
            if (rotaton == 180) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
            if (rotaton == 270) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
        }
        return class40_sub5_sub17_sub5_0_;

    }

    public void readValues(Buffer buffer) {
        for (; ; ) {
            int i = buffer.getUnsignedByte();
            if (i == 0) {
                break;
            }
            readValue(i, (byte) -107, buffer);
        }
    }
}
