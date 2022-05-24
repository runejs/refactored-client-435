package org.runejs.client.scene.tile;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.UpdateServerNode;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.util.SignlinkNode;
import org.runejs.client.*;

import java.io.IOException;
import java.util.zip.CRC32;

public class FloorDecoration {
    public static IndexedImage inventoryBackgroundImage;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array603;
    public static SignlinkNode gameServerSignlinkNode;
    public static int[] anIntArray612;
    public static int anInt614 = -1;

    public int config;
    public int hash;
    public int x;
    public Renderable renderable;
    public int y;
    public int z;

    public static void method342(int arg1, Actor arg2) {
        MovedStatics.method312(arg1, arg2.worldY, arg2.worldX, 4976905);
    }

    public static void constructMapRegion(boolean arg0, int arg1) {

        GroundItemTile.loadGeneratedMap = arg0;
        if(GroundItemTile.loadGeneratedMap) {
            int chunkY = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_0_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int chunkX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_2_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int currentPlane = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            IncomingPackets.incomingPacketBuffer.initBitAccess();
            for(int i_4_ = 0; i_4_ < 4; i_4_++) {
                for(int i_5_ = 0; i_5_ < 13; i_5_++) {
                    for(int i_6_ = 0; i_6_ < 13; i_6_++) {
                        int i_7_ = IncomingPackets.incomingPacketBuffer.getBits(1);
                        if(i_7_ != 1) {
                            OverlayDefinition.constructMapTiles[i_4_][i_5_][i_6_] = -1;
                        } else {
                            OverlayDefinition.constructMapTiles[i_4_][i_5_][i_6_] = IncomingPackets.incomingPacketBuffer.getBits(26);
                        }
                    }
                }
            }
            IncomingPackets.incomingPacketBuffer.finishBitAccess();
            int i_8_ = (-IncomingPackets.incomingPacketBuffer.currentPosition + IncomingPackets.incomingPacketSize) / 16;
            Class44.anIntArrayArray1030 = new int[i_8_][4];
            for(int i_9_ = 0; i_8_ > i_9_; i_9_++) {
                for(int i_10_ = 0; i_10_ < 4; i_10_++) {
                    Class44.anIntArrayArray1030[i_9_][i_10_] = IncomingPackets.incomingPacketBuffer.getIntBE();

                }

            }
            LinkedList.anIntArray1071 = new int[i_8_];
            RSString.terrainData = new byte[i_8_][];
            Class13.anIntArray421 = new int[i_8_];
            GenericTile.objectData = new byte[i_8_][];
            ISAAC.mapCoordinates = new int[i_8_];
            i_8_ = 0;
            for(int i_11_ = 0; i_11_ < 4; i_11_++) {
                for(int i_12_ = 0; i_12_ < 13; i_12_++) {
                    for(int i_13_ = 0; i_13_ < 13; i_13_++) {
                        int i_14_ = OverlayDefinition.constructMapTiles[i_11_][i_12_][i_13_];
                        if(i_14_ != -1) {
                            int i_15_ = i_14_ >> 14 & 0x3ff;
                            int i_16_ = i_14_ >> 3 & 0x7ff;
                            int i_17_ = i_16_ / 8 + (i_15_ / 8 << 8);
                            for(int i_18_ = 0; i_8_ > i_18_; i_18_++) {
                                if(ISAAC.mapCoordinates[i_18_] == i_17_) {
                                    i_17_ = -1;
                                    break;
                                }
                            }
                            if(i_17_ != -1) {
                                ISAAC.mapCoordinates[i_8_] = i_17_;
                                int i_19_ = i_17_ & 0xff;
                                int i_20_ = (0xffbe & i_17_) >> 8;
                                LinkedList.anIntArray1071[i_8_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.aClass1_1085+i_20_+ Native.aClass1_303+i_19_);
                                Class13.anIntArray421[i_8_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.aClass1_553+i_20_+ Native.aClass1_303+i_19_);
                                i_8_++;
                            }
                        }
                    }
                }
            }
            Actor.method789(i_0_, arg1 + -6688, currentPlane, chunkX, chunkY, i_2_);
        } else {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkX = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int i_22_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkY = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int i_24_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_25_ = (IncomingPackets.incomingPacketSize - IncomingPackets.incomingPacketBuffer.currentPosition) / 16;
            Class44.anIntArrayArray1030 = new int[i_25_][4];
            for(int i_26_ = 0; i_25_ > i_26_; i_26_++) {
                for(int i_27_ = 0; i_27_ < 4; i_27_++) {
                    Class44.anIntArrayArray1030[i_26_][i_27_] = IncomingPackets.incomingPacketBuffer.getIntBE();
                }
            }
            ISAAC.mapCoordinates = new int[i_25_];
            RSString.terrainData = new byte[i_25_][];
            boolean bool = false;
            GenericTile.objectData = new byte[i_25_][];
            if((chunkX / 8 == 48 || chunkX / 8 == 49) && chunkY / 8 == 48) {
                bool = true;
            }
            LinkedList.anIntArray1071 = new int[i_25_];
            if(chunkX / 8 == 48 && chunkY / 8 == 148) {
                bool = true;
            }
            Class13.anIntArray421 = new int[i_25_];
            i_25_ = 0;
            for(int i_28_ = (-6 + chunkX) / 8; i_28_ <= (6 + chunkX) / 8; i_28_++) {
                for(int i_29_ = (-6 + chunkY) / 8; (6 + chunkY) / 8 >= i_29_; i_29_++) {
                    int i_30_ = i_29_ + (i_28_ << 8);
                    if(!bool || i_29_ != 49 && i_29_ != 149 && i_29_ != 147 && i_28_ != 50 && (i_28_ != 49 || i_29_ != 47)) {
                        ISAAC.mapCoordinates[i_25_] = i_30_;
                        LinkedList.anIntArray1071[i_25_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.aClass1_1085 + i_28_ + Native.aClass1_303 + i_29_);
                        Class13.anIntArray421[i_25_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.aClass1_553 + i_28_ + Native.aClass1_303 + i_29_);
                        i_25_++;
                    }
                }
            }
            Actor.method789(i_22_, -1000, chunkY, chunkX, i, i_24_);
        }
        if(arg1 != 5688) {
            aClass40_Sub5_Sub14_Sub4Array603 = null;
        }
    }

    public static void method344(int arg0) {
        if(MovedStatics.aBoolean2083) {
            MovedStatics.chatboxLineOffsets = null;
            MovedStatics.aBoolean2083 = false;
            RSCanvas.anIntArray66 = null;
            MovedStatics.minimapBackgroundImage = null;
            Landscape.anIntArray1186 = null;
            Class17.chatboxTop = null;
            RSCanvas.tabBottom = null;
            GameObject.tabPieceLeft = null;
            Class57.bottomChatBack = null;
            inventoryBackgroundImage = null;
            WallDecoration.aClass40_Sub5_Sub14_Sub2_1270 = null;
            Class40_Sub5_Sub15.tabIcons = null;
            Class13.aClass40_Sub5_Sub14_Sub2_418 = null;
            RSString.mapbackProducingGraphicsBuffer = null;
            RSCanvas.anIntArray62 = null;
            ActorDefinition.sidebarOffsets = null;
            Class39.mapbackLeft = null;
            MovedStatics.aClass40_Sub5_Sub14_Sub2_1919 = null;
            MovedStatics.tabBottomBack = null;
            Landscape.framePieceRight = null;
            GameShell.aClass40_Sub5_Sub14_Sub2_1 = null;
            MovedStatics.aClass40_Sub5_Sub14_Sub2_2105 = null;
            MovedStatics.anIntArray852 = null;
            HuffmanEncoding.chatModes = null;
            Buffer.tabTopBack = null;
            MovedStatics.tabImageProducer = null;
            MovedStatics.aClass40_Sub5_Sub14_Sub2_1315 = null;
            MovedStatics.gameScreenImageProducer = null;
            ISAAC.aClass40_Sub5_Sub14_Sub2_524 = null;
            RSCanvas.chatBoxImageProducer = null;
            Class40_Sub7.mapBackRight = null;
            InteractiveObject.tabTop = null;
            if(arg0 < -28) {
                MovedStatics.chatboxRight = null;
                MovedStatics.tabPieceUpperRight = null;
                Class35.aClass40_Sub5_Sub14_Sub2_1744 = null;
                MovedStatics.aClass40_Sub5_Sub14_Sub2_549 = null;
                Renderable.aClass40_Sub5_Sub14_Sub2_2860 = null;
                Class24.fullScreenTextureArray = null;
                PlayerAppearance.tabPieveLowerRight = null;
                Class40_Sub5_Sub17_Sub6.framePieceTop = null;
                Class44.chatboxBackgroundImage = null;
            }
        }
    }


}
