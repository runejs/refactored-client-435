package com.jagex.runescape.cache.media;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

import java.io.IOException;
import java.net.Socket;

public class SpotAnimDefinition extends CachedNode {
    public static ImageRGB minimapEdge;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array2301;
    public static int mouseButtonPressed = 0;
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


    public static void method552(boolean arg0) {
        try {
            if(Class40_Sub3.anInt2032 == 0) {
                if(MovedStatics.gameConnection != null) {
                    MovedStatics.gameConnection.method1009();
                    MovedStatics.gameConnection = null;
                }
                Class37.aBoolean871 = false;
                Class40_Sub3.anInt2032 = 1;
                Main.anInt1756 = 0;
                FloorDecoration.aSignlinkNode_607 = null;
            }
            if(Class40_Sub3.anInt2032 == 1) {
                if(FloorDecoration.aSignlinkNode_607 == null) {
                    FloorDecoration.aSignlinkNode_607 = Main.signlink.method395(3, Wall.anInt350);
                }
                if(FloorDecoration.aSignlinkNode_607.anInt434 == 2) {
                    throw new IOException();
                }
                if(FloorDecoration.aSignlinkNode_607.anInt434 == 1) {
                    MovedStatics.gameConnection = new Class64(
                            (Socket) FloorDecoration.aSignlinkNode_607.value, Main.signlink);
                    Class40_Sub3.anInt2032 = 2;
                    FloorDecoration.aSignlinkNode_607 = null;
                }
            }
            if(!arg0) {
                English.loadedInputHandler = null;
            }
            if(Class40_Sub3.anInt2032 == 2) {

                long l = MovedStatics.aLong853 = RSString.nameToLong(Native.username.toString());
                SceneCluster.packetBuffer.currentPosition = 0;
                SceneCluster.packetBuffer.putByte(14);
                int i = (int) (0x1fL & l >> 16);
                SceneCluster.packetBuffer.putByte(i);
                MovedStatics.gameConnection.method1010(2, (byte) -19, 0, SceneCluster.packetBuffer.buffer);
                Class40_Sub3.anInt2032 = 3;
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
            }
            if(Class40_Sub3.anInt2032 == 3) {
                int i = MovedStatics.gameConnection.read();
                if(i != 0) {
                    Main.displayMessageForResponseCode(i);
                    return;
                }
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                Class40_Sub3.anInt2032 = 4;
            }
            if(Class40_Sub3.anInt2032 == 4) {

                if(IncomingPackets.incomingPacketBuffer.currentPosition < 8) {
                    int i = MovedStatics.gameConnection.method1014(-127);
                    if(i > -IncomingPackets.incomingPacketBuffer.currentPosition + 8) {
                        i = -IncomingPackets.incomingPacketBuffer.currentPosition + 8;
                    }
                    if(i > 0) {
                        MovedStatics.gameConnection.method1008(
                                IncomingPackets.incomingPacketBuffer.currentPosition, i, -128,
                                IncomingPackets.incomingPacketBuffer.buffer
                        );
                        IncomingPackets.incomingPacketBuffer.currentPosition += i;
                    }
                }
                if(IncomingPackets.incomingPacketBuffer.currentPosition == 8) {
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    Renderable.aLong2858 = IncomingPackets.incomingPacketBuffer.getLongBE();
                    Class40_Sub3.anInt2032 = 5;
                }
            }
            if(Class40_Sub3.anInt2032 == 5) {
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
                SceneCluster.packetBuffer.putIntBE(Main.signlink.uid);
                SceneCluster.packetBuffer.putLongBE(RSString.nameToLong(Native.username.toString()));
                SceneCluster.packetBuffer.method505(Native.password);
                if(Configuration.RSA_ENABLED) {
                    SceneCluster.packetBuffer.applyRSA(Configuration.RSA_MODULUS, Configuration.RSA_PUBLIC_KEY);
                }
                MovedStatics.packetBuffer.currentPosition = 0;
                if(Class51.currentAction == 40) {
                    MovedStatics.packetBuffer.putByte(18);
                } else {
                    MovedStatics.packetBuffer.putByte(16);
                }
                MovedStatics.packetBuffer.putByte(57 + SceneCluster.packetBuffer.currentPosition);
                MovedStatics.packetBuffer.putIntBE(435);
                MovedStatics.packetBuffer.putByte(VertexNormal.lowMemory ? 1 : 0);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.skeletonCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.skinDefinitionCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameDefinitionsCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameInterfaceCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.soundEffectCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameWorldMapCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.musicCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.modelCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameImageCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameTextureCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.huffmanCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.jingleCacheArchive.anInt216);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.clientScriptCacheArchive.anInt216);
                MovedStatics.packetBuffer.putBytes(
                        0, SceneCluster.packetBuffer.currentPosition, SceneCluster.packetBuffer.buffer);
                MovedStatics.gameConnection.method1010(
                        MovedStatics.packetBuffer.currentPosition, (byte) -19, 0, MovedStatics.packetBuffer.buffer);
                SceneCluster.packetBuffer.initOutCipher(seeds);
                for(int i = 0; i < 4; i++) {
                    seeds[i] += 50;
                }
                IncomingPackets.incomingPacketBuffer.initInCipher(seeds);
                Class40_Sub3.anInt2032 = 6;
            }


            if(Class40_Sub3.anInt2032 == 6 && MovedStatics.gameConnection.method1014(-126) > 0) {
                int i = MovedStatics.gameConnection.read();
                if(i != 21 || Class51.currentAction != 20) {
                    if(i == 2) {
                        Class40_Sub3.anInt2032 = 9;
                    } else {
                        if(i == 15 && Class51.currentAction == 40) {
                            Class37.method434(0);
                            return;
                        }
                        if(i == 23 && OverlayDefinition.anInt2321 < 1) {
                            OverlayDefinition.anInt2321++;
                            Class40_Sub3.anInt2032 = 0;
                        } else {
                            Main.displayMessageForResponseCode(i);
                            return;
                        }
                    }
                } else {
                    Class40_Sub3.anInt2032 = 7;
                }
            }
            if(Class40_Sub3.anInt2032 == 7 && MovedStatics.gameConnection.method1014(-128) > 0) {
                Class33.anInt784 = 180 + MovedStatics.gameConnection.read() * 60;
                Class40_Sub3.anInt2032 = 8;

            }
            if(Class40_Sub3.anInt2032 == 8) {
                Main.anInt1756 = 0;
                Class33.setLoginScreenMessage(
                        English.youHaveJustLeftAnotherWorld, English.yourProfileWillBeTransferredIn,
                        (Class33.anInt784 / 60) + English.suffixSeconds
                );
                if(--Class33.anInt784 <= 0) {
                    Class40_Sub3.anInt2032 = 0;
                }
            } else {

                if(Class40_Sub3.anInt2032 == 9 && MovedStatics.gameConnection.method1014(-121) >= 8) {
                    Configuration.USERNAME = Native.username.toString();
                    Configuration.PASSWORD = Native.password.toString();
                    InteractiveObject.playerRights = MovedStatics.gameConnection.read();
                    Class22.accountFlagged = MovedStatics.gameConnection.read() == 1;
                    PlayerAppearance.anInt708 = MovedStatics.gameConnection.read();
                    PlayerAppearance.anInt708 <<= 8;
                    PlayerAppearance.anInt708 += MovedStatics.gameConnection.read();
                    Class44.anInt1049 = MovedStatics.gameConnection.read();
                    MovedStatics.gameConnection.method1008(0, 1, -127, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacket = IncomingPackets.incomingPacketBuffer.getPacket();
                    MovedStatics.gameConnection.method1008(0, 2, -127, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacketSize = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    Class40_Sub3.anInt2032 = 10;
                }
                if(Class40_Sub3.anInt2032 == 10) {
                    if(MovedStatics.gameConnection.method1014(-124) >= IncomingPackets.incomingPacketSize) {
                        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                        MovedStatics.gameConnection.method1008(
                                0, IncomingPackets.incomingPacketSize, -128,
                                IncomingPackets.incomingPacketBuffer.buffer
                        );
                        Main.method44();
                        Class51.regionX = -1;
                        FloorDecoration.method343(false, 5688);
                        IncomingPackets.incomingPacket = -1;
                    }
                } else {
                    Main.anInt1756++;
                    if(Main.anInt1756 > 2000) {
                        if(OverlayDefinition.anInt2321 < 1) {
                            OverlayDefinition.anInt2321++;
                            if(OverlayDefinition.anInt2340 == Wall.anInt350) {
                                Wall.anInt350 = CollisionMap.anInt172;
                            } else {
                                Wall.anInt350 = OverlayDefinition.anInt2340;
                            }
                            Class40_Sub3.anInt2032 = 0;
                        } else {
                            Main.displayMessageForResponseCode(-3);
                        }
                    }
                }
            }
        } catch(IOException ioexception) {
            if(OverlayDefinition.anInt2321 < 1) {
                if(Wall.anInt350 == OverlayDefinition.anInt2340) {
                    Wall.anInt350 = CollisionMap.anInt172;
                } else {
                    Wall.anInt350 = OverlayDefinition.anInt2340;
                }
                OverlayDefinition.anInt2321++;
                Class40_Sub3.anInt2032 = 0;
            } else {
                Main.displayMessageForResponseCode(-2);
            }
        }
    }

    public static SpotAnimDefinition forId(int arg0, int arg1) {
        if(arg1 != 13) {
            Class37.method436(-34);
        }
        SpotAnimDefinition spotAnimDefinition = (SpotAnimDefinition) Class43.aClass9_1014.get((long) arg0);
        if(spotAnimDefinition != null) {
            return spotAnimDefinition;
        }
        byte[] is = InteractiveObject.aCacheArchive_488.getFile(13, arg0);
        spotAnimDefinition = new SpotAnimDefinition();
        spotAnimDefinition.id = arg0;
        if(is != null) {
            spotAnimDefinition.readValues(new Buffer(is));
        }
        Class43.aClass9_1014.put((long) arg0, spotAnimDefinition);
        return spotAnimDefinition;
    }

    public void readValue(int opcode, byte arg1, Buffer buffer) {
        if(arg1 > -100) {
            rotaton = -55;
        }
        if(opcode == 1) {
            modelId = buffer.getUnsignedShortBE();
        } else if(opcode == 2) {
            animationId = buffer.getUnsignedShortBE();
        } else if(opcode == 4) {
            resizeX = buffer.getUnsignedShortBE();
        } else if(opcode == 5) {
            resizeY = buffer.getUnsignedShortBE();
        } else if(opcode == 6) {
            rotaton = buffer.getUnsignedShortBE();
        } else if(opcode == 7) {
            ambient = buffer.getUnsignedByte();
        } else if(opcode == 8) {
            contrast = buffer.getUnsignedByte();
        } else if(opcode >= 40 && opcode < 50) {
            recolorToFind[-40 + opcode] = buffer.getUnsignedShortBE();
        } else if(opcode >= 50 && opcode < 60) {
            recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        }
    }

    public Model method549(int arg0, int arg1) {
        Model class40_sub5_sub17_sub5 = (Model) MovedStatics.aClass9_851.get((long) id);
        if(class40_sub5_sub17_sub5 == null) {
            class40_sub5_sub17_sub5 = Model.getModel(UnderlayDefinition.aCacheArchive_2582, modelId);
            if(class40_sub5_sub17_sub5 == null) {
                return null;
            }
            for(int i = 0; i < 6; i++) {
                if(recolorToFind[0] != 0) {
                    class40_sub5_sub17_sub5.replaceColor(recolorToFind[i], recolorToReplace[i]);
                }
            }
            class40_sub5_sub17_sub5.createBones();
            class40_sub5_sub17_sub5.applyLighting(64 + ambient, contrast + 850, -30, -50, -30, true);
            MovedStatics.aClass9_851.put((long) id, class40_sub5_sub17_sub5);
        }
        Model class40_sub5_sub17_sub5_0_;
        if(animationId == -1 || arg0 == -1) {
            class40_sub5_sub17_sub5_0_ = class40_sub5_sub17_sub5.method806(true);
        } else {
            class40_sub5_sub17_sub5_0_ = ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId).method597(
                    (byte) -87, class40_sub5_sub17_sub5, arg0);
        }
        if(arg1 != 2) {
            return null;
        }
        if(resizeX != 128 || resizeY != 128) {
            class40_sub5_sub17_sub5_0_.scaleT(resizeX, resizeY, resizeX);
        }
        if(rotaton != 0) {
            if(rotaton == 90) {
                class40_sub5_sub17_sub5_0_.method813();
            }
            if(rotaton == 180) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
            if(rotaton == 270) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
        }
        return class40_sub5_sub17_sub5_0_;

    }

    public void readValues(Buffer buffer) {
        for(; ; ) {
            int i = buffer.getUnsignedByte();
            if(i == 0) {
                break;
            }
            readValue(i, (byte) -107, buffer);
        }
    }
}
