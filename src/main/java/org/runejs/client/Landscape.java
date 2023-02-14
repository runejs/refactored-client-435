package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.FileOperations;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.client.cache.def.FramemapDefinition;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.IdentityKit;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.OldEngine.MapDecompressor;

import java.io.IOException;

public class Landscape {
    public static int mouseY = 0;
    public static CollisionMap[] currentCollisionMap = new CollisionMap[4];
    public static int[] anIntArray1168;
    public static int anInt1170 = 0;
    public static int anInt1171 = 0;
    public static int[][] distanceValues = new int[104][104];
    public static String[] menuActionTexts = new String[500];
    public static ProducingGraphicsBuffer framePieceRight;
    public static int[] anIntArray1186;

    public static void loadRegion() {
        Main.method364(false);
        Class37.anInt874 = 0;
        boolean bool = true;
        for(int i = 0; i < RSString.terrainData.length; i++) {
            if(LinkedList.terrainDataIds[i] != -1 && RSString.terrainData[i] == null) {
                RSString.terrainData[i] = CacheArchive.gameWorldMapCacheArchive.getFile(LinkedList.terrainDataIds[i], 0);
                if(RSString.terrainData[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
            if(Class13.objectDataIds[i] != -1 && GenericTile.objectData[i] == null) {
                GenericTile.objectData[i] = CacheArchive.gameWorldMapCacheArchive.method176(Class13.objectDataIds[i], 0, Class44.xteaKeys[i]);
                if(GenericTile.objectData[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
        }
        if(bool) {
            bool = true;
            IdentityKit.anInt2591 = 0;
            for(int i = 0; RSString.terrainData.length > i; i++) {
                byte[] is = GenericTile.objectData[i];
                if(is != null) {
                    int i_2_ = (ISAAC.mapCoordinates[i] & 0xff) * 64 - Class26.baseY;
                    int i_3_ = (ISAAC.mapCoordinates[i] >> 8) * 64 - MovedStatics.baseX;
                    if(GroundItemTile.loadGeneratedMap) {
                        i_3_ = 10;
                        i_2_ = 10;
                    }
                    bool &= Class40_Sub7.method840(is, i_3_, i_2_);
                }
            }
            if(bool) {
                if(ProducingGraphicsBuffer.anInt1634 != 0)
                    Class51.method940(English.loadingPleaseWait, true, Native.percent100Parentheses);
                RSCanvas.clearCaches();
                Npc.currentScene.initToNull();
                System.gc();
                for(int z = 0; z < 4; z++)
                    currentCollisionMap[z].reset();
                for(int z = 0; z < 4; z++) {
                    for(int x = 0; x < 104; x++) {
                        for(int y = 0; y < 104; y++)
                            OverlayDefinition.tile_flags[z][x][y] = (byte) 0;
                    }
                }
                Class65.method1020();
                int dataLength = RSString.terrainData.length;
                SoundSystem.clearObjectSounds();
                Main.method364(true);
                if(!GroundItemTile.loadGeneratedMap) {
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetY = -Class26.baseY + (0xff & ISAAC.mapCoordinates[pointer]) * 64;
                        int offsetX = -MovedStatics.baseX + 64 * (ISAAC.mapCoordinates[pointer] >> 8);
                        byte[] is = RSString.terrainData[pointer];
                        if(FileOperations.FileExists("./data/maps/" + LinkedList.terrainDataIds[pointer] + ".dat")) {
                            System.out.println("reading file: " + "./data/maps/" + LinkedList.terrainDataIds[pointer] + ".dat");
                            is = FileOperations.ReadFile("./data/maps/" + LinkedList.terrainDataIds[pointer] + ".dat");
                        }
                        if(is != null)
                            AnimationSequence.loadTerrainBlock(currentCollisionMap, (Class51.regionX - 6) * 8, is, offsetX, offsetY, 8 * (-6 + Class17.regionY));
                    }
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetX = -MovedStatics.baseX + (ISAAC.mapCoordinates[pointer] >> 8) * 64;
                        int offsetY = -Class26.baseY + 64 * (ISAAC.mapCoordinates[pointer] & 0xff);
                        byte[] data = RSString.terrainData[pointer];
                        if(data == null && Class17.regionY < 800)
                            MovedStatics.initiateVertexHeights(offsetY, 64, 64, offsetX);
                    }
                    Main.method364(true);
                    for(int region = 0; dataLength > region; region++) {
                        //                        System.out.println("Requesting map: "+Class13.anIntArray421[i_12_]);
                        // load maps in here
                        byte[] data = GenericTile.objectData[region];
                        if(FileOperations.FileExists("./data/maps/" + Class13.objectDataIds[region] + ".cmap")) {
                            MapDecompressor.objectLoader("./data/maps/" + Class13.objectDataIds[region] + ".cmap");
                        } else if(FileOperations.FileExists("./data/maps/" + Class13.objectDataIds[region] + ".dat")) {
                            System.out.println("reading file: " + "./data/maps/" + Class13.objectDataIds[region] + ".dat");
                            data = FileOperations.ReadFile("./data/maps/" + Class13.objectDataIds[region] + ".dat");
                        } else {
                            try {
                                data = MapDecompressor.grabMap(Class13.objectDataIds[region]);
                            } catch(IOException e) {
                            }
                        }
                        if(data != null) {
                            int offsetX = -MovedStatics.baseX + (ISAAC.mapCoordinates[region] >> 8) * 64;
                            int offsetY = 64 * (0xff & ISAAC.mapCoordinates[region]) - Class26.baseY;
                            GameObject.loadObjectBlock(offsetX, Npc.currentScene, currentCollisionMap, data, offsetY);
                        } else {
                            System.out.println("Missing map: " + Class13.objectDataIds[region]);
                        }
                    }
                }
                if(GroundItemTile.loadGeneratedMap) {
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int data = OverlayDefinition.constructMapTiles[z][x][y];
                                boolean bool_19_ = false;
                                if(data != -1) {
                                    int tileRotation = (0x6 & data) >> 1;
                                    int tileX = (data & 0xffd2c2) >> 14;
                                    int tileZ = data >> 24 & 0x3;
                                    int tileY = (data & 0x3ffb) >> 3;
                                    int tileCoordinates = (tileX / 8 << 8) + tileY / 8;
                                    for(int pointer = 0; pointer < ISAAC.mapCoordinates.length; pointer++) {
                                        if(ISAAC.mapCoordinates[pointer] == tileCoordinates && RSString.terrainData[pointer] != null) {
                                            loadTerrainSubblock(y * 8, 8 * (tileX & 0x7), tileZ, z, x * 8, (0x7 & tileY) * 8, tileRotation, RSString.terrainData[pointer], currentCollisionMap);
                                            bool_19_ = true;
                                            break;
                                        }
                                    }
                                }
                                if(!bool_19_)
                                    MovedStatics.method455(8 * y, z, x * 8);
                            }
                        }
                    }
                    for(int x = 0; x < 13; x++) {
                        for(int y = 0; y < 13; y++) {
                            int displayMap = OverlayDefinition.constructMapTiles[0][x][y];
                            if(displayMap == -1)
                                MovedStatics.initiateVertexHeights(y * 8, 8, 8, 8 * x);
                        }
                    }
                    Main.method364(true);
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int bits = OverlayDefinition.constructMapTiles[z][x][y];
                                if(bits != -1) {
                                    int tileZ = (bits & 0x3ba82fb) >> 24;
                                    int tileX = 0x3ff & bits >> 14;
                                    int tileRotation = bits >> 1 & 0x3;
                                    int tileY = bits >> 3 & 0x7ff;
                                    int tileCoordinates = (tileX / 8 << 8) + tileY / 8;
                                    for(int i_38_ = 0; i_38_ < ISAAC.mapCoordinates.length; i_38_++) {
                                        if(tileCoordinates == ISAAC.mapCoordinates[i_38_] && GenericTile.objectData[i_38_] != null) {
                                            Class24.constructMapRegionObjects(8 * (tileX & 0x7), 8 * (tileY & 0x7), tileZ, tileRotation, x * 8, 8 * y, z, Npc.currentScene, GenericTile.objectData[i_38_], currentCollisionMap);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Main.method364(true);
                RSCanvas.clearCaches();
                ISAAC.createRegion(Npc.currentScene, currentCollisionMap);
                Main.method364(true);
                int z = MovedStatics.lowestPlane;
                if(Player.worldLevel < z)
                    z = Player.worldLevel;
                if(z < -1 + Player.worldLevel)
                    z = -1 + Player.worldLevel;
                if(!VertexNormal.lowMemory)
                    Npc.currentScene.setHeightLevel(0);
                else
                    Npc.currentScene.setHeightLevel(MovedStatics.lowestPlane);
                for(int x = 0; x < 104; x++) {
                    for(int y = 0; y < 104; y++)
                        FramemapDefinition.spawnGroundItem(y, x);
                }
                ISAAC.method285((byte) 118);
                GameObjectDefinition.objectModelCache.clear();
                if(GameShell.clientFrame != null) {
                    SceneCluster.packetBuffer.putPacket(121);
                    SceneCluster.packetBuffer.putIntBE(1057001181);
                }
                if(!GroundItemTile.loadGeneratedMap) {
                    int i_42_ = (-6 + Class51.regionX) / 8;
                    int i_43_ = (Class17.regionY - 6) / 8;
                    int i_44_ = (6 + Class17.regionY) / 8;
                    int i_45_ = (Class51.regionX + 6) / 8;
                    for(int i_46_ = -1 + i_42_; i_46_ <= 1 + i_45_; i_46_++) {
                        for(int i_47_ = -1 + i_43_; i_47_ <= i_44_ + 1; i_47_++) {
                            if(i_42_ > i_46_ || i_46_ > i_45_ || i_47_ < i_43_ || i_47_ > i_44_) {
                                CacheArchive.gameWorldMapCacheArchive.method195(0, Native.MAP_NAME_PREFIX_M +i_46_+ Native.MAP_NAME_UNDERSCORE +i_47_);
                                CacheArchive.gameWorldMapCacheArchive.method195(0, Native.MAP_NAME_PREFIX_L +i_46_+ Native.MAP_NAME_UNDERSCORE +i_47_);
                            }
                        }
                    }
                }
                if(GameInterface.fullscreenInterfaceId != -1)
                    MovedStatics.processGameStatus(35);
                else
                    MovedStatics.processGameStatus(30);
                MovedStatics.method973();
                SceneCluster.packetBuffer.putPacket(178);
                RSRuntimeException.method1057(126);
            } else
                ProducingGraphicsBuffer.anInt1634 = 2;
        } else
            ProducingGraphicsBuffer.anInt1634 = 1;

    }

    public static void loadTerrainSubblock(int y, int drawX, int drawingPlane, int currentPlane, int x, int drawY, int rotation, byte[] terrainData, CollisionMap[] collisionMaps) {
        for(int i = 0; i < 8; i++) {
            for(int yIdx = 0; yIdx < 8; yIdx++) {
                if(x + i > 0 && i + x < 103 && y + yIdx > 0 && yIdx + y < 103)
                    collisionMaps[currentPlane].clippingData[x + i][yIdx + y] = BitUtils.bitWiseAND(collisionMaps[currentPlane].clippingData[x + i][yIdx + y], -16777217);
            }
        }
        Buffer class40_sub1 = new Buffer(terrainData);
        for(int plane = 0; plane < 4; plane++) {
            for(int tileX = 0; tileX < 64; tileX++) {
                for(int tileY = 0; tileY < 64; tileY++) {
                    if(plane == drawingPlane && tileX >= drawX && 8 + drawX > tileX && tileY >= drawY && 8 + drawY > tileY)
                        MovedStatics.method922(x + Class24.getRotatedTileX(rotation, tileX & 0x7, tileY & 0x7), rotation, class40_sub1, y + Class33.getRotatedTileY(tileX & 0x7, 0x7 & tileY, rotation), 0, 0, currentPlane);
                    else
                        MovedStatics.method922(-1, 0, class40_sub1, -1, 0, 0, 0);
                }
            }
        }
    }
}
