package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.FileOperations;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.OldEngine.MapDecompressor;

import java.io.IOException;

public class Landscape {
    public static CollisionMap[] currentCollisionMap = new CollisionMap[4];
    public static int[] anIntArray1168;
    /**
     * Position of the hint icon within the specific tile.
     */
    public static int hintIconInnerPosX = 0;
    public static int anInt1171 = 0;
    public static ProducingGraphicsBuffer framePieceRight;
    public static int[] anIntArray1186;
    public static int[] mapCoordinates;
    public static int[] blendedHue;
    public static int[] blendedSaturation;
    public static int[] blendedLightness;
    public static int[] blendedHueMultiplier;
    public static int[] blendDirectionTracker;
    public static int[][][] tileCullingBitsets;
    public static int[][] tileLightIntensity;
    public static byte[][][] tile_overlay_rotation;
    public static byte[][][] tileShadowIntensity;
    public static byte[][][] tile_underlay_path;
    public static byte[][][] tile_overlayids;
    public static byte[][][] tile_underlayids;
    public static byte[][] objectData;
    public static int[][][] constructMapTiles = new int[4][13][13];

    public static void loadRegion() {
        Game.method364(false);
        Game.anInt874 = 0;
        boolean bool = true;
        for(int i = 0; i < RSString.terrainData.length; i++) {
            if(LinkedList.terrainDataIds[i] != -1 && RSString.terrainData[i] == null) {
                RSString.terrainData[i] = CacheArchive.gameWorldMapCacheArchive.getFile(LinkedList.terrainDataIds[i], 0);
                if(RSString.terrainData[i] == null) {
                    Game.anInt874++;
                    bool = false;
                }
            }
            if(Class13.objectDataIds[i] != -1 && objectData[i] == null) {
                objectData[i] = CacheArchive.gameWorldMapCacheArchive.method176(Class13.objectDataIds[i], 0, Class44.xteaKeys[i]);
                if(objectData[i] == null) {
                    Game.anInt874++;
                    bool = false;
                }
            }
        }
        if(bool) {
            bool = true;
            Game.anInt2591 = 0;
            for(int i = 0; RSString.terrainData.length > i; i++) {
                byte[] is = objectData[i];
                if(is != null) {
                    int i_2_ = (mapCoordinates[i] & 0xff) * 64 - Class26.baseY;
                    int i_3_ = (mapCoordinates[i] >> 8) * 64 - MovedStatics.baseX;
                    if(GroundItemTile.loadGeneratedMap) {
                        i_3_ = 10;
                        i_2_ = 10;
                    }
                    bool &= Class40_Sub7.method840(is, i_3_, i_2_);
                }
            }
            if(bool) {
                if(ProducingGraphicsBuffer.anInt1634 != 0)
                    MovedStatics.method940(English.loadingPleaseWait, true, Native.percent100Parentheses);
                RSCanvas.clearCaches();
                Npc.currentScene.initToNull();
                System.gc();
                for(int z = 0; z < 4; z++)
                    currentCollisionMap[z].reset();
                for(int z = 0; z < 4; z++) {
                    for(int x = 0; x < 104; x++) {
                        for(int y = 0; y < 104; y++)
                            MovedStatics.tile_flags[z][x][y] = (byte) 0;
                    }
                }
                method1020();
                int dataLength = RSString.terrainData.length;
                SoundSystem.clearObjectSounds();
                Game.method364(true);
                if(!GroundItemTile.loadGeneratedMap) {
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetY = -Class26.baseY + (0xff & mapCoordinates[pointer]) * 64;
                        int offsetX = -MovedStatics.baseX + 64 * (mapCoordinates[pointer] >> 8);
                        byte[] is = RSString.terrainData[pointer];
                        if(FileOperations.FileExists("./data/maps/" + LinkedList.terrainDataIds[pointer] + ".dat")) {
                            System.out.println("reading file: " + "./data/maps/" + LinkedList.terrainDataIds[pointer] + ".dat");
                            is = FileOperations.ReadFile("./data/maps/" + LinkedList.terrainDataIds[pointer] + ".dat");
                        }
                        if(is != null)
                            loadTerrainBlock(currentCollisionMap, (Class51.regionX - 6) * 8, is, offsetX, offsetY, 8 * (-6 + Class17.regionY));
                    }
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetX = -MovedStatics.baseX + (mapCoordinates[pointer] >> 8) * 64;
                        int offsetY = -Class26.baseY + 64 * (mapCoordinates[pointer] & 0xff);
                        byte[] data = RSString.terrainData[pointer];
                        if(data == null && Class17.regionY < 800)
                            MovedStatics.initiateVertexHeights(offsetY, 64, 64, offsetX);
                    }
                    Game.method364(true);
                    for(int region = 0; dataLength > region; region++) {
                        //                        System.out.println("Requesting map: "+Class13.anIntArray421[i_12_]);
                        // load maps in here
                        byte[] data = objectData[region];
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
                            int offsetX = -MovedStatics.baseX + (mapCoordinates[region] >> 8) * 64;
                            int offsetY = 64 * (0xff & mapCoordinates[region]) - Class26.baseY;
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
                                int data = constructMapTiles[z][x][y];
                                boolean bool_19_ = false;
                                if(data != -1) {
                                    int tileRotation = (0x6 & data) >> 1;
                                    int tileX = (data & 0xffd2c2) >> 14;
                                    int tileZ = data >> 24 & 0x3;
                                    int tileY = (data & 0x3ffb) >> 3;
                                    int tileCoordinates = (tileX / 8 << 8) + tileY / 8;
                                    for(int pointer = 0; pointer < mapCoordinates.length; pointer++) {
                                        if(mapCoordinates[pointer] == tileCoordinates && RSString.terrainData[pointer] != null) {
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
                            int displayMap = constructMapTiles[0][x][y];
                            if(displayMap == -1)
                                MovedStatics.initiateVertexHeights(y * 8, 8, 8, 8 * x);
                        }
                    }
                    Game.method364(true);
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int bits = constructMapTiles[z][x][y];
                                if(bits != -1) {
                                    int tileZ = (bits & 0x3ba82fb) >> 24;
                                    int tileX = 0x3ff & bits >> 14;
                                    int tileRotation = bits >> 1 & 0x3;
                                    int tileY = bits >> 3 & 0x7ff;
                                    int tileCoordinates = (tileX / 8 << 8) + tileY / 8;
                                    for(int i_38_ = 0; i_38_ < mapCoordinates.length; i_38_++) {
                                        if(tileCoordinates == mapCoordinates[i_38_] && objectData[i_38_] != null) {
                                            constructMapRegionObjects(8 * (tileX & 0x7), 8 * (tileY & 0x7), tileZ, tileRotation, x * 8, 8 * y, z, Npc.currentScene, objectData[i_38_], currentCollisionMap);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Game.method364(true);
                RSCanvas.clearCaches();
                createRegion(Npc.currentScene, currentCollisionMap);
                Game.method364(true);
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
                        MovedStatics.spawnGroundItem(y, x);
                }
                method285((byte) 118);
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
                method973();
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
                        method922(x + getRotatedTileX(rotation, tileX & 0x7, tileY & 0x7), rotation, class40_sub1, y + getRotatedTileY(tileX & 0x7, 0x7 & tileY, rotation), 0, 0, currentPlane);
                    else
                        method922(-1, 0, class40_sub1, -1, 0, 0, 0);
                }
            }
        }
    }

    private static int getRotatedTileX(int rotation, int x, int y) {
        rotation &= 0x3;
        if(rotation == 0)
            return x;
        if(rotation == 1)
            return y;
        if(rotation == 2)
            return -x + 7;
        return 7 + -y;
    }

    private static int getRotatedTileY(int x, int y, int rotation) {
        rotation &= 0x3;
        if(rotation == 0)
            return y;
        if(rotation == 1)
            return 7 + -x;
        if(rotation == 2)
            return -y + 7;
        return x;

    }

    public static void constructMapRegionObjects(int drawX, int drawY, int drawingPlane, int orientation, int x, int y, int plane, Scene scene, byte[] objectData, CollisionMap[] collisionMaps) {
        Buffer objectBuffer = new Buffer(objectData);
        int i = -1;
        for(; ; ) {
            int idOffset = objectBuffer.getSmart();
            if(idOffset == 0)
                break;
            int objectPositionInfo = 0;
            i += idOffset;
            for(; ; ) {
                int objectInfoOffset = objectBuffer.getSmart();
                if(objectInfoOffset == 0)
                    break;
                objectPositionInfo += -1 + objectInfoOffset;
                int objectPlane = objectPositionInfo >> 12;
                int objectX = 0x3f & objectPositionInfo >> 6;
                int objectMetadata = objectBuffer.getUnsignedByte();
                int objectType = objectMetadata >> 2;
                int objectY = objectPositionInfo & 0x3f;
                int originalOrientation = objectMetadata & 0x3;
                if(objectPlane == drawingPlane && drawX <= objectX && objectX < 8 + drawX && drawY <= objectY && drawY + 8 > objectY) {
                    GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                    int tileX = getRotatedObjectX(objectX & 0x7, 0x7 & objectY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, orientation, originalOrientation) + x;
                    int tileY = getRotatedObjectY(objectX & 0x7, objectY & 0x7, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, orientation, originalOrientation) + y;
                    if(tileX > 0 && tileY > 0 && tileX < 103 && tileY < 103) {
                        CollisionMap collisionMap = null;
                        int collisionMapPlane = plane;
                        if((MovedStatics.tile_flags[1][tileX][tileY] & 0x2) == 2) // bridge tile, go down 1 level
                            collisionMapPlane--;
                        if(collisionMapPlane >= 0)
                            collisionMap = collisionMaps[collisionMapPlane];
                        MovedStatics.addObject(i, tileX, tileY, plane, originalOrientation + orientation & 0x3, objectType, scene, collisionMap);
                    }
                }
            }
        }
    }

    private static int getRotatedObjectX(int x, int y, int sizeX, int sizeY, int orientation, int originalOrientation) {
        orientation &= 0x3;
        if ((originalOrientation & 0x1) == 1) {
            int i = sizeX;
            sizeX = sizeY;
            sizeY = i;
        }
        if (orientation == 0)
            return x;
        if (orientation == 1)
            return y;
        if (orientation == 2)
            return 7 - (x + sizeX) + 1;
        return 7 + -y + 1 + -sizeY;
    }

    private static int getRotatedObjectY(int x, int y, int sizeX, int sizeY, int orientation, int originalOrientation) {
        orientation &= 0x3;
        if((originalOrientation & 0x1) == 1) {
            int i = sizeX;
            sizeX = sizeY;
            sizeY = i;
        }
        if(orientation == 0)
            return y;
        if(orientation == 1)
            return 1 + -sizeX + 7 - x;
        if(orientation == 2)
            return -sizeY + 1 + -y + 7;
        return x;
    }

    private static void createRegion(Scene scene, CollisionMap[] collisionMaps) {
        for(int plane = 0; plane < 4; plane++) {
            for(int x = 0; x < 104; x++) {
                for(int y = 0; y < 104; y++) {
                    if((0x1 & MovedStatics.tile_flags[plane][x][y]) == 1) {
                        int markingPlane = plane;
                        if((0x2 & MovedStatics.tile_flags[1][x][y]) == 2)
                            markingPlane--;
                        if(markingPlane >= 0)
                            collisionMaps[markingPlane].markBlocked(y, x);
                    }
                }
            }
        }
        Class40_Sub5_Sub15.randomiserHue += (int) (5.0 * Math.random()) + -2;
        Actor.randomiserLightness += -2 + (int) (5.0 * Math.random());
        if(Class40_Sub5_Sub15.randomiserHue < -8)
            Class40_Sub5_Sub15.randomiserHue = -8;
        if(Class40_Sub5_Sub15.randomiserHue > 8)
            Class40_Sub5_Sub15.randomiserHue = 8;
        if(Actor.randomiserLightness < -16)
            Actor.randomiserLightness = -16;
        if(Actor.randomiserLightness > 16)
            Actor.randomiserLightness = 16;
        for(int _plane = 0; _plane < 4; _plane++) {
            byte[][] shadowIntensity = tileShadowIntensity[_plane];
            int directionalLightLength = (int) Math.sqrt(5100.0);
            int specularDistribution = directionalLightLength * 768 >> 8;
            for(int y = 1; y < 103; y++) {
                for(int x = 1; x < 103; x++) {
                    int heightDifferenceX = -MovedStatics.tile_height[_plane][x - 1][y] + MovedStatics.tile_height[_plane][1 + x][y];
                    int heightDifferenceY = MovedStatics.tile_height[_plane][x][y + 1] + -MovedStatics.tile_height[_plane][x][y + -1];
                    int normalisedLength = (int) Math.sqrt(heightDifferenceY * heightDifferenceY + heightDifferenceX * heightDifferenceX + 65536);
                    int normalisedZ = 65536 / normalisedLength;
                    int weightedShadowIntensity = (shadowIntensity[x][y] >> 1) + (shadowIntensity[x][-1 + y] >> 2) + (shadowIntensity[1 + x][y] >> 3) + (shadowIntensity[x - 1][y] >> 2) + (shadowIntensity[x][1 + y] >> 3);
                    int normalisedX = (heightDifferenceX << 8) / normalisedLength;
                    int normalisedY = (heightDifferenceY << 8) / normalisedLength;
                    int directionalLightIntensity = 96 + (normalisedX * -50 + -10 * normalisedZ + normalisedY * -50) / specularDistribution;
                    tileLightIntensity[x][y] = directionalLightIntensity + -weightedShadowIntensity;
                }
            }
            for(int i_15_ = 0; i_15_ < 104; i_15_++) {
                blendedHue[i_15_] = 0;
                blendedSaturation[i_15_] = 0;
                blendedLightness[i_15_] = 0;
                blendedHueMultiplier[i_15_] = 0;
                blendDirectionTracker[i_15_] = 0;
            }
            for(int x = -5; x < 109; x++) {
                for(int y = 0; y < 104; y++) {
                    int positiveX = 5 + x;
                    if(positiveX >= 0 && positiveX < 104) {
                        int underlayId = 0xff & tile_underlayids[_plane][positiveX][y];
                        if(underlayId > 0) {
                            UnderlayDefinition underlayDefinition = UnderlayDefinition.getDefinition(underlayId - 1);
                            blendedHue[y] += underlayDefinition.hue;
                            blendedSaturation[y] += underlayDefinition.saturation;
                            blendedLightness[y] += underlayDefinition.lightness;
                            blendedHueMultiplier[y] += underlayDefinition.hueMultiplier;
                            blendDirectionTracker[y]++;
                        }
                    }
                    int negativeX = x - 5;
                    if(negativeX >= 0 && negativeX < 104) {
                        int underlayId = 0xff & tile_underlayids[_plane][negativeX][y];
                        if(underlayId > 0) {
                            UnderlayDefinition underlayDefinition = UnderlayDefinition.getDefinition(underlayId - 1);
                            blendedHue[y] -= underlayDefinition.hue;
                            blendedSaturation[y] -= underlayDefinition.saturation;
                            blendedLightness[y] -= underlayDefinition.lightness;
                            blendedHueMultiplier[y] -= underlayDefinition.hueMultiplier;
                            blendDirectionTracker[y]--;
                        }
                    }
                }
                if(x >= 1 && x < 103) {
                    int hue = 0;
                    int saturation = 0;
                    int lightness = 0;
                    int direction = 0;
                    int hueMultiplier = 0;
                    for(int y = -5; y < 109; y++) {
                        int positiveY = y + 5;
                        int negativeY = y - 5;
                        if(positiveY >= 0 && positiveY < 104) {
                            hueMultiplier += blendedHueMultiplier[positiveY];
                            saturation += blendedSaturation[positiveY];
                            direction += blendDirectionTracker[positiveY];
                            lightness += blendedLightness[positiveY];
                            hue += blendedHue[positiveY];
                        }

                        if(negativeY >= 0 && negativeY < 104) {
                            saturation -= blendedSaturation[negativeY];
                            direction -= blendDirectionTracker[negativeY];
                            lightness -= blendedLightness[negativeY];
                            hueMultiplier -= blendedHueMultiplier[negativeY];
                            hue -= blendedHue[negativeY];
                        }
                        if(y >= 1 && y < 103 && (!VertexNormal.lowMemory || (0x2 & MovedStatics.tile_flags[0][x][y]) != 0 || (0x10 & MovedStatics.tile_flags[_plane][x][y]) == 0 && MovedStatics.onBuildTimePlane == Class59.getVisibilityPlaneFor(_plane, y, 0, x))) {
                            if(MovedStatics.lowestPlane > _plane)
                                MovedStatics.lowestPlane = _plane;
                            int underlayId = tile_underlayids[_plane][x][y] & 0xff;
                            int overlayId = tile_overlayids[_plane][x][y] & 0xff;
                            if(underlayId > 0 || overlayId > 0) {
                                int vertexHeightSW = MovedStatics.tile_height[_plane][x][y];
                                int vertexHeightSE = MovedStatics.tile_height[_plane][x + 1][y];
                                int vertexHeightNE = MovedStatics.tile_height[_plane][x + 1][1 + y];
                                int vertexHeightNW = MovedStatics.tile_height[_plane][x][y + 1];
                                int lightIntensitySW = tileLightIntensity[x][y];
                                int lightIntensitySE = tileLightIntensity[x + 1][y];
                                int lightIntensityNE = tileLightIntensity[x + 1][y + 1];
                                int hslBitsetOriginal = -1;
                                int lightIntensityNW = tileLightIntensity[x][y + 1];
                                int hslBitsetRandomised = -1;
                                if(underlayId > 0) {
                                    int h = 256 * hue / hueMultiplier;
                                    int s = saturation / direction;
                                    int l = lightness / direction;
                                    hslBitsetOriginal = Class13.generateHslBitset(s, l, h);
                                    l += Actor.randomiserLightness;
                                    h = h + Class40_Sub5_Sub15.randomiserHue & 0xff;
                                    if(l >= 0) {
                                        if(l > 255)
                                            l = 255;
                                    } else
                                        l = 0;
                                    hslBitsetRandomised = Class13.generateHslBitset(s, l, h);
                                }
                                if(_plane > 0) {
                                    boolean hideUnderlay = true;
                                    if(underlayId == 0 && tile_underlay_path[_plane][x][y] != 0)
                                        hideUnderlay = false;
                                    if(overlayId > 0 && !OverlayDefinition.getDefinition(-1 + overlayId, 4).hideOverlay)
                                        hideUnderlay = false;
                                    if(hideUnderlay && vertexHeightSW == vertexHeightSE && vertexHeightNE == vertexHeightSW && vertexHeightSW == vertexHeightNW)
                                        tileCullingBitsets[_plane][x][y] = BitUtils.bitWiseOR(tileCullingBitsets[_plane][x][y], 0x924);
                                }
                                int underlayMinimapColour = 0;
                                if(hslBitsetRandomised != -1)
                                    underlayMinimapColour = Rasterizer3D.hsl2rgb[mixLightness(hslBitsetRandomised, 96)];
                                if(overlayId != 0) {
                                    int shape = 1 + tile_underlay_path[_plane][x][y];
                                    byte rotation = tile_overlay_rotation[_plane][x][y];
                                    OverlayDefinition overlayDefinition = OverlayDefinition.getDefinition(-1 + overlayId, 4);
                                    int textureId = overlayDefinition.texture;
                                    int hslBitset;
                                    int overlayMinimapColour;
                                    if(textureId >= 0) {
                                        hslBitset = -1;
                                        overlayMinimapColour = Rasterizer3D.interface3.getAverageTextureColour(textureId);
                                    } else if(overlayDefinition.color == 16711935) {
                                        hslBitset = -2;
                                        textureId = -1;
                                        overlayMinimapColour = -2;
                                    } else {
                                        hslBitset = Class13.generateHslBitset(overlayDefinition.lightness, overlayDefinition.saturation, overlayDefinition.hue);
                                        int h = Class40_Sub5_Sub15.randomiserHue + overlayDefinition.hue & 0xff;
                                        int s = Actor.randomiserLightness + overlayDefinition.saturation;
                                        if(s < 0)
                                            s = 0;
                                        else if(s > 255)
                                            s = 255;
                                        overlayMinimapColour = Class13.generateHslBitset(overlayDefinition.lightness, s, h);
                                    }
                                    int rgb = 0;
                                    if(overlayMinimapColour != -2)
                                        rgb = Rasterizer3D.hsl2rgb[MovedStatics.mixLightnessSigned(overlayMinimapColour, 96)];
                                    if(overlayDefinition.secondaryColor != -1) {
                                        int i_54_ = 0xff & Class40_Sub5_Sub15.randomiserHue + overlayDefinition.otherHue;
                                        int i_55_ = overlayDefinition.otherSaturation + Actor.randomiserLightness;
                                        if(i_55_ >= 0) {
                                            if(i_55_ > 255)
                                                i_55_ = 255;
                                        } else
                                            i_55_ = 0;
                                        overlayMinimapColour = Class13.generateHslBitset(overlayDefinition.otherLightness, i_55_, i_54_);
                                        rgb = Rasterizer3D.hsl2rgb[MovedStatics.mixLightnessSigned(overlayMinimapColour, 96)];
                                    }
                                    scene.addTile(_plane, x, y, shape, rotation, textureId, vertexHeightSW, vertexHeightSE, vertexHeightNE, vertexHeightNW, mixLightness(hslBitsetOriginal, lightIntensitySW), mixLightness(hslBitsetOriginal, lightIntensitySE), mixLightness(hslBitsetOriginal, lightIntensityNE), mixLightness(hslBitsetOriginal, lightIntensityNW), MovedStatics.mixLightnessSigned(hslBitset, lightIntensitySW), MovedStatics.mixLightnessSigned(hslBitset, lightIntensitySE), MovedStatics.mixLightnessSigned(hslBitset, lightIntensityNE), MovedStatics.mixLightnessSigned(hslBitset, lightIntensityNW), underlayMinimapColour, rgb);
                                } else
                                    scene.addTile(_plane, x, y, 0, 0, -1, vertexHeightSW, vertexHeightSE, vertexHeightNE, vertexHeightNW, mixLightness(hslBitsetOriginal, lightIntensitySW), mixLightness(hslBitsetOriginal, lightIntensitySE), mixLightness(hslBitsetOriginal, lightIntensityNE), mixLightness(hslBitsetOriginal, lightIntensityNW), 0, 0, 0, 0, underlayMinimapColour, 0);
                            }
                        }
                    }
                }
            }
            for(int i_56_ = 1; i_56_ < 103; i_56_++) {
                for(int i_57_ = 1; i_57_ < 103; i_57_++)
                    scene.method130(_plane, i_57_, i_56_, Class59.getVisibilityPlaneFor(_plane, i_56_, 0, i_57_));
            }
            tile_underlayids[_plane] = null;
            tile_overlayids[_plane] = null;
            tile_underlay_path[_plane] = null;
            tile_overlay_rotation[_plane] = null;
            tileShadowIntensity[_plane] = null;
        }
        scene.method118(-50, -10, -50);
        for(int i = 0; i < 104; i++) {
            for(int i_58_ = 0; i_58_ < 104; i_58_++) {
                if((MovedStatics.tile_flags[1][i][i_58_] & 0x2) == 2)
                    scene.setTileBridge(i, i_58_);
            }
        }
        int renderRule1 = 1;
        int i_59_ = 2;
        int i_60_ = 4;
        for(int plane = 0; plane < 4; plane++) {
            if(plane > 0) {
                renderRule1 <<= 3;
                i_60_ <<= 3;
                i_59_ <<= 3;
            }
            for(int _plane = 0; _plane <= plane; _plane++) {
                for(int y = 0; y <= 104; y++) {
                    for(int x = 0; x <= 104; x++) {
                        if((tileCullingBitsets[_plane][x][y] & renderRule1) != 0) {
                            int i_65_;
                            for(i_65_ = y; i_65_ > 0 && (renderRule1 & tileCullingBitsets[_plane][x][-1 + i_65_]) != 0; i_65_--) {
                                /* empty */
                            }
                            int i_66_;
                            for(i_66_ = y; i_66_ < 104 && (tileCullingBitsets[_plane][x][i_66_ + 1] & renderRule1) != 0; i_66_++) {
                                /* empty */
                            }
                            int i_67_ = _plane;
                            int i_68_ = _plane;
                            while_4_:
                            for(/**/; i_67_ > 0; i_67_--) {
                                for(int i_69_ = i_65_; i_69_ <= i_66_; i_69_++) {
                                    if((tileCullingBitsets[-1 + i_67_][x][i_69_] & renderRule1) == 0)
                                        break while_4_;
                                }
                            }
                            while_5_:
                            for(/**/; i_68_ < plane; i_68_++) {
                                for(int i_70_ = i_65_; i_70_ <= i_66_; i_70_++) {
                                    if((renderRule1 & tileCullingBitsets[i_68_ + 1][x][i_70_]) == 0)
                                        break while_5_;
                                }
                            }
                            int i_71_ = (-i_65_ + i_66_ + 1) * (-i_67_ + i_68_ + 1);
                            if(i_71_ >= 8) {
                                int i_72_ = 240;
                                int i_73_ = -i_72_ + MovedStatics.tile_height[i_68_][x][i_65_];
                                int i_74_ = MovedStatics.tile_height[i_67_][x][i_65_];
                                Scene.createOccluder(plane, 1, 128 * x, 128 * x, 128 * i_65_, 128 + 128 * i_66_, i_73_, i_74_);
                                for(int i_75_ = i_67_; i_75_ <= i_68_; i_75_++) {
                                    for(int i_76_ = i_65_; i_76_ <= i_66_; i_76_++)
                                        tileCullingBitsets[i_75_][x][i_76_] = BitUtils.bitWiseAND(tileCullingBitsets[i_75_][x][i_76_], renderRule1 ^ 0xffffffff);
                                }
                            }
                        }
                        if((i_59_ & tileCullingBitsets[_plane][x][y]) != 0) {
                            int lowestOcclusionX;
                            for(lowestOcclusionX = x; lowestOcclusionX > 0 && (i_59_ & tileCullingBitsets[_plane][lowestOcclusionX - 1][y]) != 0; lowestOcclusionX--) {
                                /* empty */
                            }
                            int highestOcclusionPlane = _plane;
                            int highestOcclusionX = x;
                            int lowestOcclusionPlane = _plane;
                            for(/**/; highestOcclusionX < 104; highestOcclusionX++) {
                                if((i_59_ & tileCullingBitsets[_plane][1 + highestOcclusionX][y]) == 0)
                                    break;
                            }
                            while_6_:
                            for(/**/; lowestOcclusionPlane > 0; lowestOcclusionPlane--) {
                                for(int i_81_ = lowestOcclusionX; i_81_ <= highestOcclusionX; i_81_++) {
                                    if((tileCullingBitsets[lowestOcclusionPlane + -1][i_81_][y] & i_59_) == 0)
                                        break while_6_;
                                }
                            }
                            while_7_:
                            for(/**/; highestOcclusionPlane < plane; highestOcclusionPlane++) {
                                for(int i_82_ = lowestOcclusionX; i_82_ <= highestOcclusionX; i_82_++) {
                                    if((i_59_ & tileCullingBitsets[1 + highestOcclusionPlane][i_82_][y]) == 0)
                                        break while_7_;
                                }
                            }

                            int occlusionSurface = (highestOcclusionX - lowestOcclusionX + 1) * (-lowestOcclusionPlane + 1 + highestOcclusionPlane);
                            if(occlusionSurface >= 8) {
                                int lowestOcclusionVertexHeight = MovedStatics.tile_height[lowestOcclusionPlane][lowestOcclusionX][y];
                                int highestOcclusionVertexHeightOffset = 240;
                                int highestOcclusionVertexHeight = MovedStatics.tile_height[highestOcclusionPlane][lowestOcclusionX][y] - highestOcclusionVertexHeightOffset;
                                Scene.createOccluder(plane, 2, 128 * lowestOcclusionX, 128 * highestOcclusionX + 128, 128 * y, y * 128, highestOcclusionVertexHeight, lowestOcclusionVertexHeight);
                                for(int occludedPlane = lowestOcclusionPlane; highestOcclusionPlane >= occludedPlane; occludedPlane++) {
                                    for(int occludedX = lowestOcclusionX; occludedX <= highestOcclusionX; occludedX++)
                                        tileCullingBitsets[occludedPlane][occludedX][y] = BitUtils.bitWiseAND(tileCullingBitsets[occludedPlane][occludedX][y], i_59_ ^ 0xffffffff);
                                }
                            }
                        }
                        if((tileCullingBitsets[_plane][x][y] & i_60_) != 0) {
                            int i_89_ = x;
                            int i_90_ = x;
                            int i_91_ = y;
                            int i_92_ = y;
                            for(/**/; i_91_ > 0; i_91_--) {
                                if((tileCullingBitsets[_plane][x][-1 + i_91_] & i_60_) == 0)
                                    break;
                            }
                            for(/**/; i_92_ < 104; i_92_++) {
                                if((i_60_ & tileCullingBitsets[_plane][x][i_92_ + 1]) == 0)
                                    break;
                            }
                            while_8_:
                            for(/**/; i_89_ > 0; i_89_--) {
                                for(int i_93_ = i_91_; i_93_ <= i_92_; i_93_++) {
                                    if((i_60_ & tileCullingBitsets[_plane][i_89_ + -1][i_93_]) == 0)
                                        break while_8_;
                                }
                            }
                            while_9_:
                            for(/**/; i_90_ < 104; i_90_++) {
                                for(int i_94_ = i_91_; i_92_ >= i_94_; i_94_++) {
                                    if((i_60_ & tileCullingBitsets[_plane][1 + i_90_][i_94_]) == 0)
                                        break while_9_;
                                }
                            }
                            if((-i_89_ + i_90_ + 1) * (1 + i_92_ - i_91_) >= 4) {
                                int i_95_ = MovedStatics.tile_height[_plane][i_89_][i_91_];
                                Scene.createOccluder(plane, 4, i_89_ * 128, i_90_ * 128 + 128, 128 * i_91_, i_92_ * 128 + 128, i_95_, i_95_);
                                for(int i_96_ = i_89_; i_96_ <= i_90_; i_96_++) {
                                    for(int i_97_ = i_91_; i_92_ >= i_97_; i_97_++)
                                        tileCullingBitsets[_plane][i_96_][i_97_] = BitUtils.bitWiseAND(tileCullingBitsets[_plane][i_96_][i_97_], i_60_ ^ 0xffffffff);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private static void method285(byte arg0) {
        if(arg0 != 118)
            Game.aBoolean519 = true;
        for(Class40_Sub3 class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.peekFirst(); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.pollFirst()) {
            if(class40_sub3.anInt2031 == -1) {
                class40_sub3.anInt2033 = 0;
                Class39.method451(class40_sub3);
            } else
                class40_sub3.unlink();
        }
    }

    public static void method973() {
        blendedHueMultiplier = null;
        blendedLightness = null;
        blendDirectionTracker = null;
        tileCullingBitsets = null;
        tileLightIntensity = null;
        tile_overlay_rotation = null;
        blendedSaturation = null;
        tileShadowIntensity = null;
        tile_underlay_path = null;
        tile_overlayids = null;
        tile_underlayids = null;
        blendedHue = null;
    }

    public static void method1020() {
        blendedSaturation = new int[104];
        tile_underlay_path = new byte[4][104][104];
        tileCullingBitsets = new int[4][105][105];
        MovedStatics.lowestPlane = 99;
        tileShadowIntensity = new byte[4][105][105];
        blendDirectionTracker = new int[104];
        blendedHueMultiplier = new int[104];
        blendedLightness = new int[104];
        tileLightIntensity = new int[105][105];
        tile_overlayids = new byte[4][104][104];
        blendedHue = new int[104];
        tile_overlay_rotation = new byte[4][104][104];
        tile_underlayids = new byte[4][104][104];
    }

    public static void loadTerrainBlock(CollisionMap[] collisions, int regionX_maybe, byte[] blockData, int offsetX, int offsetY, int regionY_maybe) {
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; i_1_ < 64; i_1_++) {
                for(int i_2_ = 0; i_2_ < 64; i_2_++) {
                    if(offsetX + i_1_ > 0 && i_1_ + offsetX < 103 && offsetY + i_2_ > 0 && i_2_ + offsetY < 103)
                        collisions[i].clippingData[i_1_ + offsetX][i_2_ + offsetY] = BitUtils.bitWiseAND(collisions[i].clippingData[i_1_ + offsetX][i_2_ + offsetY], -16777217);
                }
            }
        }
        Buffer class40_sub1 = new Buffer(blockData);
        if(true) {
            for(int plane = 0; plane < 4; plane++) {
                for(int tileX = 0; tileX < 64; tileX++) {
                    for(int tileY = 0; tileY < 64; tileY++)
                        method922(tileX + offsetX, 0, class40_sub1, tileY + offsetY, regionY_maybe, regionX_maybe, plane);
                }
            }
        }
    }

    public static void method922(int x, int arg1, Buffer fileData, int y, int regionY, int regionX, int level) {
        if(x >= 0 && x < 104 && y >= 0 && y < 104) {
            MovedStatics.tile_flags[level][x][y] = (byte) 0;
            for(; ; ) {
                int opcode = fileData.getUnsignedByte();
                if(opcode == 0) {
                    if(level == 0) {
MovedStatics.tile_height[0][x][y] = -MovedStatics.method888(regionX + x + 932731, regionY + 556238 + y) * 8;
} else {
MovedStatics.tile_height[level][x][y] = -240 + MovedStatics.tile_height[level + -1][x][y];
}

                    break;
                }
                if(opcode == 1) {
                    int tileHeight = fileData.getUnsignedByte();
                    if(tileHeight == 1)
                        tileHeight = 0;
                    if(level != 0)
                        MovedStatics.tile_height[level][x][y] = MovedStatics.tile_height[-1 + level][x][y] + -(8 * tileHeight);
                    else
                        MovedStatics.tile_height[0][x][y] = 8 * -tileHeight;
                    break;
                }
                if(opcode <= 49) {
                    tile_overlayids[level][x][y] = fileData.getByte();
                    tile_underlay_path[level][x][y] = (byte) ((opcode + -2) / 4);
                    tile_overlay_rotation[level][x][y] = (byte) BitUtils.bitWiseAND(arg1 + -2 + opcode, 3);
                } else if(opcode <= 81)
                    MovedStatics.tile_flags[level][x][y] = (byte) (-49 + opcode);
                else
                    tile_underlayids[level][x][y] = (byte) (-81 + opcode);
            }
        } else {
            for(; ; ) {
                int i = fileData.getUnsignedByte();
                if(i == 0)
                    break;
                if(i == 1) {
                    fileData.getUnsignedByte();
                    break;
                }
                if(i <= 49)
                    fileData.getUnsignedByte();
            }
        }
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
                            constructMapTiles[_level][_x][_y] = -1;
                        } else {
                            constructMapTiles[_level][_x][_y] = IncomingPackets.incomingPacketBuffer.getBits(26);
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
            objectData = new byte[i_8_][];
            mapCoordinates = new int[i_8_];
            i_8_ = 0;
            for(int i_11_ = 0; i_11_ < 4; i_11_++) {
                for(int i_12_ = 0; i_12_ < 13; i_12_++) {
                    for(int i_13_ = 0; i_13_ < 13; i_13_++) {
                        int i_14_ = constructMapTiles[i_11_][i_12_][i_13_];
                        if(i_14_ != -1) {
                            int i_15_ = i_14_ >> 14 & 0x3ff;
                            int i_16_ = i_14_ >> 3 & 0x7ff;
                            int i_17_ = i_16_ / 8 + (i_15_ / 8 << 8);
                            for(int i_18_ = 0; i_8_ > i_18_; i_18_++) {
                                if(mapCoordinates[i_18_] == i_17_) {
                                    i_17_ = -1;
                                    break;
                                }
                            }
                            if(i_17_ != -1) {
                                mapCoordinates[i_8_] = i_17_;
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
            mapCoordinates = new int[regionCount];
            RSString.terrainData = new byte[regionCount][];
            boolean inTutorialIsland_maybe = false;
            objectData = new byte[regionCount][];
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
                        mapCoordinates[regionCount] = coords;

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

    private static int mixLightness(int hsl, int lightness) {
        if(hsl == -1)
            return 12345678;

        lightness = (0x7f & hsl) * lightness / 128;
        if(lightness < 2)
            lightness = 2;
        else if(lightness > 126)
            lightness = 126;

        return lightness + (hsl & 0xff80);
    }
}
