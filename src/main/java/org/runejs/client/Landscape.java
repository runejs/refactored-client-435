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
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.scene.InteractiveObjectTemporary;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.OldEngine.MapDecompressor;

import java.io.IOException;

public class Landscape {
    public static CollisionMap[] currentCollisionMap = new CollisionMap[4];
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
    public static int[] objectDataIds;
    public static int[][] xteaKeys;
    public static byte[][] terrainData;
    public static boolean loadGeneratedMap = false;
    public static int[] terrainDataIds;
    public static int[][][] tile_height = new int[4][105][105];
    public static int randomiserLightness = -16 + (int) (Math.random() * 33.0);
    public static int randomiserHue = -8 + (int) (17.0 * Math.random());
    private static int lowestPlane = 99;

    public static void loadRegion() {
        method364(false);
        Game.anInt874 = 0;
        boolean bool = true;
        for(int i = 0; i < terrainData.length; i++) {
            if(terrainDataIds[i] != -1 && terrainData[i] == null) {
                terrainData[i] = CacheArchive.gameWorldMapCacheArchive.getFile(terrainDataIds[i], 0);
                if(terrainData[i] == null) {
                    Game.anInt874++;
                    bool = false;
                }
            }
            if(objectDataIds[i] != -1 && objectData[i] == null) {
                objectData[i] = CacheArchive.gameWorldMapCacheArchive.method176(objectDataIds[i], 0, xteaKeys[i]);
                if(objectData[i] == null) {
                    Game.anInt874++;
                    bool = false;
                }
            }
        }
        if(bool) {
            bool = true;
            Game.anInt2591 = 0;
            for(int i = 0; terrainData.length > i; i++) {
                byte[] is = objectData[i];
                if(is != null) {
                    int i_2_ = (mapCoordinates[i] & 0xff) * 64 - MovedStatics.baseY;
                    int i_3_ = (mapCoordinates[i] >> 8) * 64 - MovedStatics.baseX;
                    if(loadGeneratedMap) {
                        i_3_ = 10;
                        i_2_ = 10;
                    }
                    bool &= method840(is, i_3_, i_2_);
                }
            }
            if(bool) {
                if(MovedStatics.anInt1634 != 0)
                    MovedStatics.method940(English.loadingPleaseWait, true, Native.percent100Parentheses);
                Game.clearCaches();
                Game.currentScene.initToNull();
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
                int dataLength = terrainData.length;
                SoundSystem.clearObjectSounds();
                method364(true);
                if(!loadGeneratedMap) {
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetY = -MovedStatics.baseY + (0xff & mapCoordinates[pointer]) * 64;
                        int offsetX = -MovedStatics.baseX + 64 * (mapCoordinates[pointer] >> 8);
                        byte[] is = terrainData[pointer];
                        if(FileOperations.FileExists("./data/maps/" + terrainDataIds[pointer] + ".dat")) {
                            System.out.println("reading file: " + "./data/maps/" + terrainDataIds[pointer] + ".dat");
                            is = FileOperations.ReadFile("./data/maps/" + terrainDataIds[pointer] + ".dat");
                        }
                        if(is != null)
                            loadTerrainBlock(currentCollisionMap, (MovedStatics.regionX - 6) * 8, is, offsetX, offsetY, 8 * (-6 + MovedStatics.regionY));
                    }
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetX = -MovedStatics.baseX + (mapCoordinates[pointer] >> 8) * 64;
                        int offsetY = -MovedStatics.baseY + 64 * (mapCoordinates[pointer] & 0xff);
                        byte[] data = terrainData[pointer];
                        if(data == null && MovedStatics.regionY < 800)
                            initiateVertexHeights(offsetY, 64, 64, offsetX);
                    }
                    method364(true);
                    for(int region = 0; dataLength > region; region++) {
                        //                        System.out.println("Requesting map: "+Class13.anIntArray421[i_12_]);
                        // load maps in here
                        byte[] data = objectData[region];
                        if(FileOperations.FileExists("./data/maps/" + objectDataIds[region] + ".cmap")) {
                            MapDecompressor.objectLoader("./data/maps/" + objectDataIds[region] + ".cmap");
                        } else if(FileOperations.FileExists("./data/maps/" + objectDataIds[region] + ".dat")) {
                            System.out.println("reading file: " + "./data/maps/" + objectDataIds[region] + ".dat");
                            data = FileOperations.ReadFile("./data/maps/" + objectDataIds[region] + ".dat");
                        } else {
                            try {
                                data = MapDecompressor.grabMap(objectDataIds[region]);
                            } catch(IOException e) {
                            }
                        }
                        if(data != null) {
                            int offsetX = -MovedStatics.baseX + (mapCoordinates[region] >> 8) * 64;
                            int offsetY = 64 * (0xff & mapCoordinates[region]) - MovedStatics.baseY;
                            loadObjectBlock(offsetX, Game.currentScene, currentCollisionMap, data, offsetY);
                        } else {
                            System.out.println("Missing map: " + objectDataIds[region]);
                        }
                    }
                }
                if(loadGeneratedMap) {
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
                                        if(mapCoordinates[pointer] == tileCoordinates && terrainData[pointer] != null) {
                                            loadTerrainSubblock(y * 8, 8 * (tileX & 0x7), tileZ, z, x * 8, (0x7 & tileY) * 8, tileRotation, terrainData[pointer], currentCollisionMap);
                                            bool_19_ = true;
                                            break;
                                        }
                                    }
                                }
                                if(!bool_19_)
                                    method455(8 * y, z, x * 8);
                            }
                        }
                    }
                    for(int x = 0; x < 13; x++) {
                        for(int y = 0; y < 13; y++) {
                            int displayMap = constructMapTiles[0][x][y];
                            if(displayMap == -1)
                                initiateVertexHeights(y * 8, 8, 8, 8 * x);
                        }
                    }
                    method364(true);
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
                                            constructMapRegionObjects(8 * (tileX & 0x7), 8 * (tileY & 0x7), tileZ, tileRotation, x * 8, 8 * y, z, Game.currentScene, objectData[i_38_], currentCollisionMap);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                method364(true);
                Game.clearCaches();
                createRegion(Game.currentScene, currentCollisionMap);
                method364(true);
                int z = lowestPlane;
                if(Player.worldLevel < z)
                    z = Player.worldLevel;
                if(z < -1 + Player.worldLevel)
                    z = -1 + Player.worldLevel;
                if(!VertexNormal.lowMemory)
                    Game.currentScene.setHeightLevel(0);
                else
                    Game.currentScene.setHeightLevel(lowestPlane);
                for(int x = 0; x < 104; x++) {
                    for(int y = 0; y < 104; y++)
                        MovedStatics.spawnGroundItem(y, x);
                }
                clearTemporaryObjects();
                GameObjectDefinition.objectModelCache.clear();
                if(GameShell.clientFrame != null) {
                    OutgoingPackets.buffer.putPacket(121);
                    OutgoingPackets.buffer.putIntBE(1057001181);
                }
                if(!loadGeneratedMap) {
                    int i_42_ = (-6 + MovedStatics.regionX) / 8;
                    int i_43_ = (MovedStatics.regionY - 6) / 8;
                    int i_44_ = (6 + MovedStatics.regionY) / 8;
                    int i_45_ = (MovedStatics.regionX + 6) / 8;
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
                OutgoingPackets.buffer.putPacket(178);
                MovedStatics.method1057();
            } else
                MovedStatics.anInt1634 = 2;
        } else
            MovedStatics.anInt1634 = 1;

    }

    private static void loadTerrainSubblock(int y, int drawX, int drawingPlane, int currentPlane, int x, int drawY, int rotation, byte[] terrainData, CollisionMap[] collisionMaps) {
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

    private static void constructMapRegionObjects(int drawX, int drawY, int drawingPlane, int orientation, int x, int y, int plane, Scene scene, byte[] objectData, CollisionMap[] collisionMaps) {
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
                        addObject(i, tileX, tileY, plane, originalOrientation + orientation & 0x3, objectType, scene, collisionMap);
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
        randomiserHue += (int) (5.0 * Math.random()) + -2;
        randomiserLightness += -2 + (int) (5.0 * Math.random());
        if(randomiserHue < -8)
            randomiserHue = -8;
        if(randomiserHue > 8)
            randomiserHue = 8;
        if(randomiserLightness < -16)
            randomiserLightness = -16;
        if(randomiserLightness > 16)
            randomiserLightness = 16;
        for(int _plane = 0; _plane < 4; _plane++) {
            byte[][] shadowIntensity = tileShadowIntensity[_plane];
            int directionalLightLength = (int) Math.sqrt(5100.0);
            int specularDistribution = directionalLightLength * 768 >> 8;
            for(int y = 1; y < 103; y++) {
                for(int x = 1; x < 103; x++) {
                    int heightDifferenceX = -tile_height[_plane][x - 1][y] + tile_height[_plane][1 + x][y];
                    int heightDifferenceY = tile_height[_plane][x][y + 1] + -tile_height[_plane][x][y + -1];
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
                        if(y >= 1 && y < 103 && (!VertexNormal.lowMemory || (0x2 & MovedStatics.tile_flags[0][x][y]) != 0 || (0x10 & MovedStatics.tile_flags[_plane][x][y]) == 0 && MovedStatics.onBuildTimePlane == MovedStatics.getVisibilityPlaneFor(_plane, y, 0, x))) {
                            if(lowestPlane > _plane)
                                lowestPlane = _plane;
                            int underlayId = tile_underlayids[_plane][x][y] & 0xff;
                            int overlayId = tile_overlayids[_plane][x][y] & 0xff;
                            if(underlayId > 0 || overlayId > 0) {
                                int vertexHeightSW = tile_height[_plane][x][y];
                                int vertexHeightSE = tile_height[_plane][x + 1][y];
                                int vertexHeightNE = tile_height[_plane][x + 1][1 + y];
                                int vertexHeightNW = tile_height[_plane][x][y + 1];
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
                                    hslBitsetOriginal = generateHslBitset(s, l, h);
                                    l += randomiserLightness;
                                    h = h + randomiserHue & 0xff;
                                    if(l >= 0) {
                                        if(l > 255)
                                            l = 255;
                                    } else
                                        l = 0;
                                    hslBitsetRandomised = generateHslBitset(s, l, h);
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
                                        hslBitset = generateHslBitset(overlayDefinition.lightness, overlayDefinition.saturation, overlayDefinition.hue);
                                        int h = randomiserHue + overlayDefinition.hue & 0xff;
                                        int s = randomiserLightness + overlayDefinition.saturation;
                                        if(s < 0)
                                            s = 0;
                                        else if(s > 255)
                                            s = 255;
                                        overlayMinimapColour = generateHslBitset(overlayDefinition.lightness, s, h);
                                    }
                                    int rgb = 0;
                                    if(overlayMinimapColour != -2)
                                        rgb = Rasterizer3D.hsl2rgb[MovedStatics.mixLightnessSigned(overlayMinimapColour, 96)];
                                    if(overlayDefinition.secondaryColor != -1) {
                                        int i_54_ = 0xff & randomiserHue + overlayDefinition.otherHue;
                                        int i_55_ = overlayDefinition.otherSaturation + randomiserLightness;
                                        if(i_55_ >= 0) {
                                            if(i_55_ > 255)
                                                i_55_ = 255;
                                        } else
                                            i_55_ = 0;
                                        overlayMinimapColour = generateHslBitset(overlayDefinition.otherLightness, i_55_, i_54_);
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
                    scene.setDrawLevel(_plane, i_57_, i_56_, MovedStatics.getVisibilityPlaneFor(_plane, i_56_, 0, i_57_));
            }
            tile_underlayids[_plane] = null;
            tile_overlayids[_plane] = null;
            tile_underlay_path[_plane] = null;
            tile_overlay_rotation[_plane] = null;
            tileShadowIntensity[_plane] = null;
        }
        scene.buildModels(-50, -10, -50);
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
                                int i_73_ = -i_72_ + tile_height[i_68_][x][i_65_];
                                int i_74_ = tile_height[i_67_][x][i_65_];
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
                                int lowestOcclusionVertexHeight = tile_height[lowestOcclusionPlane][lowestOcclusionX][y];
                                int highestOcclusionVertexHeightOffset = 240;
                                int highestOcclusionVertexHeight = tile_height[highestOcclusionPlane][lowestOcclusionX][y] - highestOcclusionVertexHeightOffset;
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
                                int i_95_ = tile_height[_plane][i_89_][i_91_];
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

    private static void clearTemporaryObjects() {
        for(InteractiveObjectTemporary interactiveObjectTemporary = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.peekFirst(); interactiveObjectTemporary != null; interactiveObjectTemporary = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.pollFirst()) {
            if(interactiveObjectTemporary.duration == -1) {
                interactiveObjectTemporary.delay = 0;
                MovedStatics.storeTemporaryObject(interactiveObjectTemporary);
            } else
                interactiveObjectTemporary.unlink();
        }
    }

    private static void method973() {
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

    private static void method1020() {
        blendedSaturation = new int[104];
        tile_underlay_path = new byte[4][104][104];
        tileCullingBitsets = new int[4][105][105];
        lowestPlane = 99;
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

    private static void loadTerrainBlock(CollisionMap[] collisions, int regionX_maybe, byte[] blockData, int offsetX, int offsetY, int regionY_maybe) {
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

    private static void method922(int x, int arg1, Buffer fileData, int y, int regionY, int regionX, int level) {
        if(x >= 0 && x < 104 && y >= 0 && y < 104) {
            MovedStatics.tile_flags[level][x][y] = (byte) 0;
            for(; ; ) {
                int opcode = fileData.getUnsignedByte();
                if(opcode == 0) {
                    if(level == 0) {
                        tile_height[0][x][y] = -method888(regionX + x + 932731, regionY + 556238 + y) * 8;
                    } else {
                        tile_height[level][x][y] = -240 + tile_height[level + -1][x][y];
                    }

                    break;
                }
                if(opcode == 1) {
                    int tileHeight = fileData.getUnsignedByte();
                    if(tileHeight == 1)
                        tileHeight = 0;
                    if(level != 0)
                        tile_height[level][x][y] = tile_height[-1 + level][x][y] + -(8 * tileHeight);
                    else
                        tile_height[0][x][y] = 8 * -tileHeight;
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

        loadGeneratedMap = generatedMap;
        if(loadGeneratedMap) {
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
            xteaKeys = new int[i_8_][4];
            for(int i_9_ = 0; i_8_ > i_9_; i_9_++) {
                for(int i_10_ = 0; i_10_ < 4; i_10_++) {
                    xteaKeys[i_9_][i_10_] = IncomingPackets.incomingPacketBuffer.getIntBE();
                }

            }

            terrainDataIds = new int[i_8_];
            terrainData = new byte[i_8_][];
            objectDataIds = new int[i_8_];
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
                                terrainDataIds[i_8_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.MAP_NAME_PREFIX_M +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                                objectDataIds[i_8_] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.MAP_NAME_PREFIX_L +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                                i_8_++;
                            }
                        }
                    }
                }
            }
            method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
        } else {
            int chunkLocalY = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkX = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int chunkLocalX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int chunkY = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int level = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int regionCount = (IncomingPackets.incomingPacketSize - IncomingPackets.incomingPacketBuffer.currentPosition) / 16;
            xteaKeys = new int[regionCount][4];
            for(int r = 0; regionCount > r; r++) {
                for(int seed = 0; seed < 4; seed++) {
                    xteaKeys[r][seed] = IncomingPackets.incomingPacketBuffer.getIntBE();
                }
            }
            mapCoordinates = new int[regionCount];
            terrainData = new byte[regionCount][];
            boolean inTutorialIsland_maybe = false;
            objectData = new byte[regionCount][];
            if((chunkX / 8 == 48 || chunkX / 8 == 49) && chunkY / 8 == 48) {
                inTutorialIsland_maybe = true;
            }
            terrainDataIds = new int[regionCount];
            if(chunkX / 8 == 48 && chunkY / 8 == 148) {
                inTutorialIsland_maybe = true;
            }
            objectDataIds = new int[regionCount];
            regionCount = 0;
            for(int x = (-6 + chunkX) / 8; x <= (6 + chunkX) / 8; x++) {
                for(int y = (-6 + chunkY) / 8; (6 + chunkY) / 8 >= y; y++) {
                    int coords = y + (x << 8);
                    if(!inTutorialIsland_maybe || y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47)) {
                        mapCoordinates[regionCount] = coords;

                        String mapKey = x + Native.MAP_NAME_UNDERSCORE + y;
                        String mapKeyM = Native.MAP_NAME_PREFIX_M + mapKey;
                        String mapKeyL = Native.MAP_NAME_PREFIX_L + mapKey;

                        terrainDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyM);
                        objectDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyL);
                        regionCount++;
                    }
                }
            }

            method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
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

    private static void loadObjectBlock(int block_x, Scene scene, CollisionMap[] collisionMaps, byte[] block_data, int block_z) {
        Buffer buffer = new Buffer(block_data);
        int object_id = -1;
        for(; ; ) {
            int delta_id = buffer.getSmart();
            if(delta_id == 0)
                break;
            int pos = 0;
            object_id += delta_id;
            for(; ; ) {
                int delta_pos = buffer.getSmart();
                if(delta_pos == 0)
                    break;
                pos += -1 + delta_pos;
                int tile_z = pos & 0x3f;
                int tile_x = pos >> 6 & 0x3f;
                int tile_y = pos >> 12;
                int object_info = buffer.getUnsignedByte();
                int object_type = object_info >> 2;
                int object_orientation = 0x3 & object_info;
                int object_x = tile_x + block_x;
                int object_z = tile_z + block_z;
                if(object_x > 0 && object_z > 0 && object_x < 103 && object_z < 103) {
                    CollisionMap collisionMap = null;
                    int logic_y = tile_y;
                    if((MovedStatics.tile_flags[1][object_x][object_z] & 2) == 2)
                        logic_y--;
                    if(logic_y >= 0)
                        collisionMap = collisionMaps[logic_y];
                    addObject(object_id, object_x, object_z, tile_y, object_orientation, object_type, scene, collisionMap);
                }
            }
        }
    }

    public static void addObject(int objectId, int localX, int localY, int plane, int face, int type, Scene scene, CollisionMap collisionMap) {
        if(!VertexNormal.lowMemory || (0x2 & MovedStatics.tile_flags[0][localX][localY]) != 0 || (0x10 & MovedStatics.tile_flags[plane][localX][localY]) == 0 && MovedStatics.onBuildTimePlane == MovedStatics.getVisibilityPlaneFor(plane, localY, 0, localX)) {
            if(lowestPlane > plane)
                lowestPlane = plane;
            int vertexHeight = tile_height[plane][localX][localY];
            int vertexHeightRight = tile_height[plane][localX + 1][localY];
            int vertexHeightTopRight = tile_height[plane][localX + 1][localY + 1];
            int vertexHeightTop = tile_height[plane][localX][localY + 1];
            int vertexMix = vertexHeight + vertexHeightRight + vertexHeightTopRight + vertexHeightTop >> 2;
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(objectId);
            int hash = localX + (localY << 7) + (objectId << 14) + 1073741824;
            int objectConfig = (byte) ((face << 6) + type);
            if(gameObjectDefinition.supportsItems == 1)
                objectConfig += 256;
            if(gameObjectDefinition.hasActions == 0)
                hash += -2147483648;
            if(gameObjectDefinition.hasSounds())
                SoundSystem.addObjectSounds(localY, plane, face, localX, gameObjectDefinition);
            if(type == 22) {
                if(!VertexNormal.lowMemory || gameObjectDefinition.hasActions != 0 || gameObjectDefinition.obstructsGround) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 22, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 22, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addGroundDecoration(localX, localY, plane, vertexMix, hash, renderable, objectConfig);
                    if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1 && collisionMap != null)
                        collisionMap.markBlocked(localY, localX);
                }
            } else if(type == 10 || type == 11) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 10, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                if(renderable != null) {
                    int i_40_;
                    int i_41_;
                    if(face == 1 || face == 3) {
                        i_40_ = gameObjectDefinition.sizeX;
                        i_41_ = gameObjectDefinition.sizeY;
                    } else {
                        i_41_ = gameObjectDefinition.sizeX;
                        i_40_ = gameObjectDefinition.sizeY;
                    }
                    int i_42_ = 0;
                    if(type == 11)
                        i_42_ += 256;
                    if(scene.addEntityB(localX, localY, plane, vertexMix, i_42_, i_40_, i_41_, hash, renderable, objectConfig) && gameObjectDefinition.castsShadow) {
                        Model class40_sub5_sub17_sub5;
                        if(renderable instanceof Model)
                            class40_sub5_sub17_sub5 = (Model) renderable;
                        else
                            class40_sub5_sub17_sub5 = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, vertexHeightRight);
                        if(class40_sub5_sub17_sub5 != null) {
                            for(int i_43_ = 0; i_43_ <= i_41_; i_43_++) {
                                for(int i_44_ = 0; i_40_ >= i_44_; i_44_++) {
                                    int i_45_ = class40_sub5_sub17_sub5.method805() / 4;
                                    if(i_45_ > 30)
                                        i_45_ = 30;
                                    if(i_45_ > tileShadowIntensity[plane][localX + i_43_][localY + i_44_])
                                        tileShadowIntensity[plane][i_43_ + localX][localY + i_44_] = (byte) i_45_;
                                }
                            }
                        }
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else if(type >= 12) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.childIds != null)
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                else
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, vertexHeightRight);
                scene.addEntityB(localX, localY, plane, vertexMix, 0, 1, 1, hash, renderable, objectConfig);
                if(type >= 12 && type <= 17 && type != 13 && plane > 0)
                    tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 2340);
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else if(type == 0) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 0, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 0, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                scene.addWall(localX, localY, plane, vertexMix, Scene.ROTATION_WALL_TYPE[face], 0, hash, renderable, null, objectConfig);
                if(face == 0) {
                    if(gameObjectDefinition.castsShadow) {
                        tileShadowIntensity[plane][localX][localY] = (byte) 50;
                        tileShadowIntensity[plane][localX][localY + 1] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 585);
                } else if(face == 1) {
                    if(gameObjectDefinition.castsShadow) {
                        tileShadowIntensity[plane][localX][localY + 1] = (byte) 50;
                        tileShadowIntensity[plane][localX + 1][1 + localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        tileCullingBitsets[plane][localX][localY + 1] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY + 1], 1170);
                } else if(face == 2) {
                    if(gameObjectDefinition.castsShadow) {
                        tileShadowIntensity[plane][1 + localX][localY] = (byte) 50;
                        tileShadowIntensity[plane][localX + 1][1 + localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        tileCullingBitsets[plane][localX + 1][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX + 1][localY], 585);
                } else if(face == 3) {
                    if(gameObjectDefinition.castsShadow) {
                        tileShadowIntensity[plane][localX][localY] = (byte) 50;
                        tileShadowIntensity[plane][localX + 1][localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 1170);
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
                if(gameObjectDefinition.setDecorDisplacement != 16)
                    scene.setWallDecorationOffset(plane, localX, localY, gameObjectDefinition.setDecorDisplacement);
            } else if(type == 1) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 1, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 1, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                scene.addWall(localX, localY, plane, vertexMix, Scene.ROTATION_WALL_CORNER_TYPE[face], 0, hash, renderable, null, objectConfig);
                if(gameObjectDefinition.castsShadow) {
                    if(face == 0)
                        tileShadowIntensity[plane][localX][localY + 1] = (byte) 50;
                    else if(face == 1)
                        tileShadowIntensity[plane][localX + 1][1 + localY] = (byte) 50;
                    else if(face == 2)
                        tileShadowIntensity[plane][localX + 1][localY] = (byte) 50;
                    else if(face == 3)
                        tileShadowIntensity[plane][localX][localY] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
            } else if(type == 2) {
                int i_46_ = 0x3 & face + 1;
                Renderable renderable;
                Renderable renderable_47_;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null) {
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face + 4, vertexHeight, 2, vertexHeightRight);
                    renderable_47_ = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, i_46_, vertexHeight, 2, vertexHeightRight);
                } else {
                    renderable = new GameObject(objectId, 2, 4 + face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    renderable_47_ = new GameObject(objectId, 2, i_46_, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                }
                scene.addWall(localX, localY, plane, vertexMix, Scene.ROTATION_WALL_TYPE[face], Scene.ROTATION_WALL_TYPE[i_46_], hash, renderable, renderable_47_, objectConfig);
                if(gameObjectDefinition.wall) {
                    if(face == 0) {
                        tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 585);
                        tileCullingBitsets[plane][localX][localY + 1] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY + 1], 1170);
                    } else if(face == 1) {
                        tileCullingBitsets[plane][localX][1 + localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][1 + localY], 1170);
                        tileCullingBitsets[plane][1 + localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][1 + localX][localY], 585);
                    } else if(face == 2) {
                        tileCullingBitsets[plane][localX + 1][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX + 1][localY], 585);
                        tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 1170);
                    } else if(face == 3) {
                        tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 1170);
                        tileCullingBitsets[plane][localX][localY] = BitUtils.bitWiseOR(tileCullingBitsets[plane][localX][localY], 585);
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
                if(gameObjectDefinition.setDecorDisplacement != 16)
                    scene.setWallDecorationOffset(plane, localX, localY, gameObjectDefinition.setDecorDisplacement);
            } else if(type == 3) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.childIds != null)
                    renderable = new GameObject(objectId, 3, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                else
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 3, vertexHeightRight);
                scene.addWall(localX, localY, plane, vertexMix, Scene.ROTATION_WALL_CORNER_TYPE[face], 0, hash, renderable, null, objectConfig);
                if(gameObjectDefinition.castsShadow) {
                    if(face != 0) {
                        if(face == 1)
                            tileShadowIntensity[plane][1 + localX][localY + 1] = (byte) 50;
                        else if(face == 2)
                            tileShadowIntensity[plane][localX + 1][localY] = (byte) 50;
                        else if(face == 3)
                            tileShadowIntensity[plane][localX][localY] = (byte) 50;
                    } else
                        tileShadowIntensity[plane][localX][localY + 1] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
            } else if(type == 9) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                scene.addEntityB(localX, localY, plane, vertexMix, 0, 1, 1, hash, renderable, objectConfig);
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else {
                if(gameObjectDefinition.adjustToTerrain) {
                    if(face == 1) {
                        int i_48_ = vertexHeightTop;
                        vertexHeightTop = vertexHeightTopRight;
                        vertexHeightTopRight = vertexHeightRight;
                        vertexHeightRight = vertexHeight;
                        vertexHeight = i_48_;
                    } else if(face == 2) {
                        int i_49_ = vertexHeightTop;
                        vertexHeightTop = vertexHeightRight;
                        vertexHeightRight = i_49_;
                        i_49_ = vertexHeightTopRight;
                        vertexHeightTopRight = vertexHeight;
                        vertexHeight = i_49_;
                    } else if(face == 3) {
                        int i_50_ = vertexHeightTop;
                        vertexHeightTop = vertexHeight;
                        vertexHeight = vertexHeightRight;
                        vertexHeightRight = vertexHeightTopRight;
                        vertexHeightTopRight = i_50_;
                    }
                }
                if(type == 4) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, 512 * face, hash, renderable, objectConfig, Scene.ROTATION_WALL_TYPE[face]);
                } else if(type == 5) {
                    int i_51_ = scene.getWallHash(plane, localX, localY);
                    int i_52_ = 16;
                    if(i_51_ > 0)
                        i_52_ = GameObjectDefinition.getDefinition((0x1fffedf2 & i_51_) >> 14).setDecorDisplacement;
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, i_52_ * MovedStatics.anIntArray666[face], MovedStatics.anIntArray2207[face] * i_52_, face * 512, hash, renderable, objectConfig, Scene.ROTATION_WALL_TYPE[face]);
                } else if(type == 6) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 256);
                } else if(type == 7) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 512);
                } else if(type == 8) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childIds == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 768);
                }
            }
        }

    }

    public static boolean method840(byte[] arg1, int arg2, int arg3) {
        boolean bool = true;
        Buffer class40_sub1 = new Buffer(arg1);
        int i = -1;
        for(; ; ) {
            int i_0_ = class40_sub1.getSmart();
            if(i_0_ == 0)
                break;
            i += i_0_;
            int i_1_ = 0;
            boolean bool_2_ = false;
            for(; ; ) {
                if(bool_2_) {
                    int i_3_ = class40_sub1.getSmart();
                    if(i_3_ == 0)
                        break;
                    class40_sub1.getUnsignedByte();
                } else {
                    int i_4_ = class40_sub1.getSmart();
                    if(i_4_ == 0)
                        break;
                    i_1_ += i_4_ + -1;
                    int i_5_ = i_1_ & 0x3f;
                    int i_6_ = class40_sub1.getUnsignedByte() >> 2;
                    int i_7_ = 0x3f & i_1_ >> 6;
                    int i_8_ = i_7_ + arg2;
                    int i_9_ = i_5_ + arg3;
                    if(i_8_ > 0 && i_9_ > 0 && i_8_ < 103 && i_9_ < 103) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(i_6_ != 22 || !VertexNormal.lowMemory || gameObjectDefinition.hasActions != 0 || gameObjectDefinition.obstructsGround) {
                            bool_2_ = true;
                            if(!gameObjectDefinition.method612()) {
                                bool = false;
                                Game.anInt2591++;
                            }
                        }
                    }
                }
            }
        }
        return bool;
    }

    private static void method364(boolean arg1) {
        MovedStatics.anInt537++;
        if(MovedStatics.anInt537 >= 50 || arg1) {
            MovedStatics.anInt537 = 0;
            if(!Game.aBoolean871 && MovedStatics.gameServerSocket != null) {
                OutgoingPackets.buffer.putPacket(13);
                try {
                    MovedStatics.gameServerSocket.sendDataFromBuffer(OutgoingPackets.buffer.currentPosition, 0, OutgoingPackets.buffer.buffer);
                    OutgoingPackets.buffer.currentPosition = 0;
                } catch(IOException ioexception) {
                    Game.aBoolean871 = true;
                }
            }
        }
    }

    private static void initiateVertexHeights(int offsetY, int sizeY, int sizeX, int offsetX) {
        for (int y = offsetY; y <= offsetY + sizeY; y++) {
            for (int x = offsetX; sizeX + offsetX >= x; x++) {
                if (x >= 0 && x < 104 && y >= 0 && y < 104) {
                    tileShadowIntensity[0][x][y] = (byte) 127;
                    if (offsetX == x && x > 0)
                        tile_height[0][x][y] = tile_height[0][-1 + x][y];
                    if (offsetX + sizeX == x && x < 103)
                        tile_height[0][x][y] = tile_height[0][x + 1][y];
                    if (y == offsetY && y > 0)
                        tile_height[0][x][y] = tile_height[0][x][y + -1];
                    if (y == offsetY + sizeY && y < 103)
                        tile_height[0][x][y] = tile_height[0][x][1 + y];
                }
            }
        }
    }

    private static void method455(int arg0, int arg1, int arg3) {
        for (int i = 0; i < 8; i++) {
            for (int i_0_ = 0; i_0_ < 8; i_0_++)
                tile_height[arg1][arg3 + i][arg0 + i_0_] = 0;
        }
        if (arg3 > 0) {
            for (int i = 1; i < 8; i++)
                tile_height[arg1][arg3][arg0 + i] = tile_height[arg1][-1 + arg3][i + arg0];
        }
        if (arg0 > 0) {
            for (int i = 1; i < 8; i++)
                tile_height[arg1][i + arg3][arg0] = tile_height[arg1][i + arg3][-1 + arg0];
        }
        if (arg3 > 0 && tile_height[arg1][-1 + arg3][arg0] != 0)
            tile_height[arg1][arg3][arg0] = tile_height[arg1][arg3 - 1][arg0];
        else if (arg0 > 0 && tile_height[arg1][arg3][arg0 - 1] != 0)
            tile_height[arg1][arg3][arg0] = tile_height[arg1][arg3][-1 + arg0];
        else if (arg3 > 0 && arg0 > 0 && tile_height[arg1][arg3 + -1][-1 + arg0] != 0)
            tile_height[arg1][arg3][arg0] = tile_height[arg1][-1 + arg3][arg0 - 1];
    }

    private static int generateHslBitset(int s, int l, int h) {
        if(l > 179)
            s /= 2;
        if(l > 192)
            s /= 2;
        if(l > 217)
            s /= 2;
        if(l > 243)
            s /= 2;
        return l / 2 + (s / 32 << 7) + (h / 4 << 10);
    }

    public static void method789(int chunkLocalX, int chunkY, int chunkX, int chunkLocalY, int level) {
        if(chunkX != MovedStatics.regionX || chunkY != MovedStatics.regionY || MovedStatics.onBuildTimePlane != level && VertexNormal.lowMemory) {
            MovedStatics.onBuildTimePlane = level;
            MovedStatics.regionX = chunkX;
            if(!VertexNormal.lowMemory)
                MovedStatics.onBuildTimePlane = 0;
            MovedStatics.regionY = chunkY;
            MovedStatics.processGameStatus(25);
            MovedStatics.method940(English.loadingPleaseWait, false, null);
            int i = MovedStatics.baseY;
            int i_33_ = MovedStatics.baseX;
            MovedStatics.baseX = (chunkX - 6) * 8;
            int i_34_ = MovedStatics.baseX + -i_33_;
            i_33_ = MovedStatics.baseX;
            MovedStatics.baseY = (-6 + chunkY) * 8;
            int i_35_ = MovedStatics.baseY + -i;
            i = MovedStatics.baseY;
            for(int i_36_ = 0; i_36_ < 32768; i_36_++) {
                Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_36_];
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    for(int i_37_ = 0; i_37_ < 10; i_37_++) {
                        class40_sub5_sub17_sub4_sub2.pathY[i_37_] -= i_34_;
                        class40_sub5_sub17_sub4_sub2.pathX[i_37_] -= i_35_;
                    }
                    class40_sub5_sub17_sub4_sub2.worldX -= 128 * i_34_;
                    class40_sub5_sub17_sub4_sub2.worldY -= i_35_ * 128;
                }
            }
            for(int i_38_ = 0; i_38_ < 2048; i_38_++) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_38_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    for(int i_39_ = 0; i_39_ < 10; i_39_++) {
                        class40_sub5_sub17_sub4_sub1.pathY[i_39_] -= i_34_;
                        class40_sub5_sub17_sub4_sub1.pathX[i_39_] -= i_35_;
                    }
                    class40_sub5_sub17_sub4_sub1.worldY -= 128 * i_35_;
                    class40_sub5_sub17_sub4_sub1.worldX -= 128 * i_34_;
                }
            }
            Player.worldLevel = level;
            int i_40_ = 0;
            Player.localPlayer.method787(chunkLocalY, false, chunkLocalX);
            int i_41_ = 104;
            int i_42_ = 1;
            if(i_34_ < 0) {
                i_41_ = -1;
                i_40_ = 103;
                i_42_ = -1;
            }
            int i_43_ = 104;
            int i_44_ = 0;
            int i_45_ = 1;
            if(i_35_ < 0) {
                i_44_ = 103;
                i_43_ = -1;
                i_45_ = -1;
            }
            for(int i_46_ = i_40_; i_41_ != i_46_; i_46_ += i_42_) {
                for(int i_47_ = i_44_; i_43_ != i_47_; i_47_ += i_45_) {
                    int i_48_ = i_34_ + i_46_;
                    int i_49_ = i_35_ + i_47_;
                    for(int i_50_ = 0; i_50_ < 4; i_50_++) {
                        if(i_48_ < 0 || i_49_ < 0 || i_48_ >= 104 || i_49_ >= 104)
                            MovedStatics.groundItems[i_50_][i_46_][i_47_] = null;
                        else
                            MovedStatics.groundItems[i_50_][i_46_][i_47_] = MovedStatics.groundItems[i_50_][i_48_][i_49_];
                    }
                }
            }
            for(InteractiveObjectTemporary obj = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.peekFirst(); obj != null; obj = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.pollFirst()) {
                obj.y -= i_35_;
                obj.x -= i_34_;
                if(obj.x < 0 || obj.y < 0 || obj.x >= 104 || obj.y >= 104)
                    obj.unlink();
            }
            Buffer.anInt1985 = -1;
            if(MovedStatics.destinationX != 0) {
                MovedStatics.destinationX -= i_34_;
                Game.destinationY -= i_35_;
            }
            Player.cutsceneActive = false;
            SoundSystem.reset();
            MovedStatics.spotAnimQueue.clear();
            MovedStatics.projectileQueue.clear();
        }
    }

    public static int method888(int x, int y) {
        int vertexHeight = -128 + perlinNoise(x + 45365, 91923 + y, 4) - (-(perlinNoise(x + 10294, 37821 + y, 2) - 128 >> 1) + -(-128 + perlinNoise(x, y, 1) >> 2));
        vertexHeight = 35 + (int) (0.3 * (double) vertexHeight);

        if(vertexHeight >= 10) {
            if(vertexHeight > 60)
                vertexHeight = 60;
        } else
            vertexHeight = 10;

        return vertexHeight;
    }

    public static int interpolateForPerlin(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if (!arg3)
            return -109;
        int i = 65536 + -Rasterizer3D.cosinetable[1024 * arg4 / arg1] >> 1;
        return ((65536 + -i) * arg0 >> 16) + (arg2 * i >> 16);
    }

    public static int randomNoiseWeightedSum(int arg1, int arg2) {
        int i = randomNoise(-1 + arg1, -1 + arg2) + randomNoise(1 + arg1, arg2 - 1) + randomNoise(-1 + arg1, 1 + arg2) + randomNoise(1 + arg1, arg2 + 1);
        int i_126_ = randomNoise(arg1 - 1, arg2) + randomNoise(arg1 + 1, arg2) - (-randomNoise(arg1, arg2 - 1) + -randomNoise(arg1, 1 + arg2));
        int i_127_ = randomNoise(arg1, arg2);
        return i / 16 - (-(i_126_ / 8) - i_127_ / 4);
    }

    public static int perlinNoise(int x, int y, int scale) {
        int muX = x & -1 + scale;
        int scaledY = y / scale;
        int muY = scale - 1 & y;
        int scaledX = x / scale;
        int a = randomNoiseWeightedSum(scaledX, scaledY);
        int b = randomNoiseWeightedSum(1 + scaledX, scaledY);
        int c = randomNoiseWeightedSum(scaledX, 1 + scaledY);
        int d = randomNoiseWeightedSum(1 + scaledX, 1 + scaledY);
        int i1 = interpolateForPerlin(a, scale, b, true, muX);
        int i2 = interpolateForPerlin(c, scale, d, true, muX);
        return interpolateForPerlin(i1, scale, i2, true, muY);
    }

    public static int randomNoise(int x, int y) {
        int i = 57 * y + x;
        i ^= i << 13;
        int i_2_ = 1376312589 + (i * i * 15731 + 789221) * i & 0x7fffffff;
        return i_2_ >> 19 & 0xff;
    }
}
