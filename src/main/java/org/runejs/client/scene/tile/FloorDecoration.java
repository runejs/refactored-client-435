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
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.util.SignlinkNode;
import org.runejs.client.*;

public class FloorDecoration {
    public static IndexedImage inventoryBackgroundImage;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array603;
    public static SignlinkNode gameServerSignlinkNode;
    public static int[] blendDirectionTracker;
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

    public static void constructMapRegion(boolean generatedMap) {

        GroundItemTile.loadGeneratedMap = generatedMap;
        if(GroundItemTile.loadGeneratedMap) {
            int chunkLocalY = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkLocalX = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int chunkX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int level = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int chunkY = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            IncomingPackets.incomingPacketBuffer.initBitAccess();
            for(int _level = 0; _level < 4; _level++) {
                for(int _x = 0; _x < 13; _x++) {
                    for(int _y = 0; _y < 13; _y++) {
                        int isConstructedChunk = IncomingPackets.incomingPacketBuffer.getBits(1);
                        if(isConstructedChunk != 1) {
                            OverlayDefinition.constructMapTiles[_level][_x][_y] = -1;
                        } else {
                            OverlayDefinition.constructMapTiles[_level][_x][_y] = IncomingPackets.incomingPacketBuffer.getBits(26);
                        }
                    }
                }
            }
            IncomingPackets.incomingPacketBuffer.finishBitAccess();
            int i_8_ = (-IncomingPackets.incomingPacketBuffer.currentPosition + IncomingPackets.incomingPacketSize) / 16;
            Class44.xteaKeys = new int[i_8_][4];
            for(int i_9_ = 0; i_8_ > i_9_; i_9_++) {
                for(int i_10_ = 0; i_10_ < 4; i_10_++) {
                    Class44.xteaKeys[i_9_][i_10_] = IncomingPackets.incomingPacketBuffer.getIntBE();
                }

            }

            LinkedList.terrainDataIds = new int[i_8_];
            RSString.terrainData = new byte[i_8_][];
            Class13.objectDataIds = new int[i_8_];
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
                                LinkedList.terrainDataIds[i_8_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.MAP_NAME_PREFIX_M +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                                Class13.objectDataIds[i_8_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.MAP_NAME_PREFIX_L +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                                i_8_++;
                            }
                        }
                    }
                }
            }
            Actor.method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
        } else {
            int chunkLocalY = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkX = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int chunkLocalX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkY = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int level = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int regionCount = (IncomingPackets.incomingPacketSize - IncomingPackets.incomingPacketBuffer.currentPosition) / 16;
            Class44.xteaKeys = new int[regionCount][4];
            for(int r = 0; regionCount > r; r++) {
                for(int seed = 0; seed < 4; seed++) {
                    Class44.xteaKeys[r][seed] = IncomingPackets.incomingPacketBuffer.getIntBE();
                }
            }
            ISAAC.mapCoordinates = new int[regionCount];
            RSString.terrainData = new byte[regionCount][];
            boolean inTutorialIsland_maybe = false;
            GenericTile.objectData = new byte[regionCount][];
            if((chunkX / 8 == 48 || chunkX / 8 == 49) && chunkY / 8 == 48) {
                inTutorialIsland_maybe = true;
            }
            LinkedList.terrainDataIds = new int[regionCount];
            if(chunkX / 8 == 48 && chunkY / 8 == 148) {
                inTutorialIsland_maybe = true;
            }
            Class13.objectDataIds = new int[regionCount];
            regionCount = 0;
            for(int x = (-6 + chunkX) / 8; x <= (6 + chunkX) / 8; x++) {
                for(int y = (-6 + chunkY) / 8; (6 + chunkY) / 8 >= y; y++) {
                    int coords = y + (x << 8);
                    if(!inTutorialIsland_maybe || y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47)) {
                        ISAAC.mapCoordinates[regionCount] = coords;

                        String mapKey = x + Native.MAP_NAME_UNDERSCORE + y;
                        String mapKeyM = Native.MAP_NAME_PREFIX_M + mapKey;
                        String mapKeyL = Native.MAP_NAME_PREFIX_L + mapKey;

                        LinkedList.terrainDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyM);
                        Class13.objectDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyL);
                        regionCount++;
                    }
                }
            }

            Actor.method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
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
            WallDecoration.tabHighlightImageTopRight = null;
            Class40_Sub5_Sub15.tabIcons = null;
            Class13.tabHighlightImageBottomRight = null;
            RSString.mapbackProducingGraphicsBuffer = null;
            RSCanvas.anIntArray62 = null;
            ActorDefinition.sidebarOffsets = null;
            Class39.mapbackLeft = null;
            MovedStatics.tabHighlightImageBottomMiddle = null;
            MovedStatics.tabBottomBack = null;
            Landscape.framePieceRight = null;
            GameShell.tabHighlightImageTopLeft = null;
            MovedStatics.tabHighlightImageTopRightEdge = null;
            MovedStatics.anIntArray852 = null;
            HuffmanEncoding.chatModes = null;
            Buffer.tabTopBack = null;
            MovedStatics.tabImageProducer = null;
            MovedStatics.tabHighlightImageTopLeftEdge = null;
            MovedStatics.gameScreenImageProducer = null;
            ISAAC.tabHighlightImageBottomRightEdge = null;
            RSCanvas.chatBoxImageProducer = null;
            Class40_Sub7.mapBackRight = null;
            InteractiveObject.tabTop = null;
            if(arg0 < -28) {
                MovedStatics.chatboxRight = null;
                MovedStatics.tabPieceUpperRight = null;
                Class35.tabHighlightImageTopMiddle = null;
                MovedStatics.tabHighlightImageBottomLeft = null;
                Renderable.tabHighlightImageBottomLeftEdge = null;
                Class24.fullScreenTextureArray = null;
                PlayerAppearance.tabPieveLowerRight = null;
                SpotAnim.framePieceTop = null;
                Class44.chatboxBackgroundImage = null;
            }
        }
    }


}
