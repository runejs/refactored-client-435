package com.jagex.runescape;

import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.FileOperations;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.FramemapDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.OldEngine.MapDecompressor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Landscape {
    public static int anInt1157 = 0;
    public static RSString aClass1_1158 = RSString.CreateString("Enter amount:");
    public static RSString aClass1_1162 = RSString.CreateString("@gre@");
    public static RSString aClass1_1163 = RSString.CreateString("glow1:");
    public static int mouseY = 0;
    public static CollisionMap[] currentCollisionMap = new CollisionMap[4];
    public static int[] anIntArray1168;
    public static RSString aClass1_1169 = RSString.CreateString("Your ignore list is full)3 Max of 100 hit");
    public static int anInt1170 = 0;
    public static int anInt1171 = 0;
    public static RSString aClass1_1172 = RSString.CreateString("You are standing in a members)2only area)3");
    public static RSString aClass1_1173;
    public static RSString aClass1_1174;
    public static int[][] distanceValues = new int[104][104];
    public static RSString aClass1_1176 = RSString.CreateString("Loaded wordpack");
    public static RSString aClass1_1178;
    public static RSString aClass1_1180;
    public static RSString aClass1_1181;
    public static RSString aClass1_1183 = RSString.CreateString("");
    public static RSString[] menuActionTexts = new RSString[500];
    public static Class68 aClass68_1185;
    public static int[] anIntArray1186;

    static {
        aClass1_1174 = aClass1_1158;
        aClass1_1173 = aClass1_1176;
        aClass1_1178 = aClass1_1172;
        aClass1_1181 = aClass1_1163;
        aClass1_1180 = aClass1_1169;
    }

    public static byte[] method931(byte[] arg0) {
        Buffer class40_sub1 = new Buffer(arg0);
        int i = class40_sub1.getUnsignedByte();
        int i_0_ = class40_sub1.getIntBE();
        if(i_0_ < 0 || (Class51.anInt1195 != 0 && (Class51.anInt1195 < i_0_)))
            throw new RuntimeException();
        if(i != 0) {
            int i_1_ = class40_sub1.getIntBE();
            if(i_1_ < 0 || (Class51.anInt1195 != 0 && (i_1_ > Class51.anInt1195))) {
                return new byte[100];
                //throw new RuntimeException();
            }
            if(i_1_ >= 2000000) {
                return new byte[100];
            }
            byte[] is = new byte[i_1_];
            if(i != 1) {
                try {
                    DataInputStream datainputstream = (new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(arg0, 9, i_0_))));
                    datainputstream.readFully(is);
                    datainputstream.close();
                } catch(java.io.IOException ioexception) {
                    /* empty */
                }
            } else
                Class21.method297(is, i_1_, arg0, i_0_, 9);
            return is;
        }
        byte[] is = new byte[i_0_];
        class40_sub1.getBytes(i_0_, 0, is);
        return is;
    }

    public static void loadRegion() {
        Class27.method364((byte) -34, false);
        Class37.anInt874 = 0;
        boolean bool = true;
        for(int i = 0; (i < RSString.terrainData.length); i++) {
            if(LinkedList.anIntArray1071[i] != -1 && RSString.terrainData[i] == null) {
                RSString.terrainData[i] = Renderable.aClass6_Sub1_2857.getFile(0, LinkedList.anIntArray1071[i]);
                if(RSString.terrainData[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
            if(Class13.anIntArray421[i] != -1 && GenericTile.objectData[i] == null) {
                GenericTile.objectData[i] = (Renderable.aClass6_Sub1_2857.method176(Class13.anIntArray421[i], 0, Class44.anIntArrayArray1030[i]));
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
                    int i_2_ = ((ISAAC.mapCoordinates[i] & 0xff) * 64 - Class26.baseY);
                    int i_3_ = ((ISAAC.mapCoordinates[i] >> 8) * 64 - SpotAnimDefinition.baseX);
                    if(GroundItemTile.loadGeneratedMap) {
                        i_3_ = 10;
                        i_2_ = 10;
                    }
                    bool &= Class40_Sub7.method840((byte) -67, is, i_3_, i_2_);
                }
            }
            if(bool) {
                if(Class68.anInt1634 != 0)
                    Class51.method940(0, Class67.aClass1_1585, true, ActorDefinition.aClass1_2423);
                RSCanvas.method46(0);
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
                Class37.method436(118);
                Class27.method364((byte) -34, true);
                if(!GroundItemTile.loadGeneratedMap) {
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetY = (-Class26.baseY + ((0xff & ISAAC.mapCoordinates[pointer]) * 64));
                        int offsetX = (-SpotAnimDefinition.baseX + 64 * (ISAAC.mapCoordinates[pointer] >> 8));
                        byte[] is = RSString.terrainData[pointer];
                        if(is != null)
                            AnimationSequence.loadTerrainBlock(currentCollisionMap, (Class51.regionX - 6) * 8, is, -6, offsetX, offsetY, 8 * (-6 + Class17.regionY));
                    }
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetX = (-SpotAnimDefinition.baseX + (ISAAC.mapCoordinates[pointer] >> 8) * 64);
                        int offsetY = (-Class26.baseY + 64 * (ISAAC.mapCoordinates[pointer] & 0xff));
                        byte[] data = RSString.terrainData[pointer];
                        if(data == null && Class17.regionY < 800)
                            Class61.initiateVertexHeights(offsetY, (byte) 103, 64, 64, offsetX);
                    }
                    Class27.method364((byte) -34, true);
                    for(int region = 0; dataLength > region; region++) {
                        //                        System.out.println("Requesting map: "+Class13.anIntArray421[i_12_]);
                        // load maps in here
                        byte[] data = GenericTile.objectData[region];
                        if(FileOperations.FileExists("./data/maps/" + (Class13.anIntArray421[region]) + ".cmap")) {
                            MapDecompressor.objectLoader("./data/maps/" + (Class13.anIntArray421[region]) + ".cmap");
                        } else if(FileOperations.FileExists("./data/maps/" + (Class13.anIntArray421[region]) + ".dat")) {
                            System.out.println("reading file: " + "./data/maps/" + (Class13.anIntArray421[region]) + ".dat");
                            data = FileOperations.ReadFile("./data/maps/" + (Class13.anIntArray421[region]) + ".dat");
                        } else {
                            try {
                                data = MapDecompressor.grabMap(Class13.anIntArray421[region]);
                            } catch(IOException e) {
                            }
                        }
                        if(data != null) {
                            int offsetX = (-SpotAnimDefinition.baseX + (ISAAC.mapCoordinates[region] >> 8) * 64);
                            int offsetY = (64 * (0xff & ISAAC.mapCoordinates[region]) - Class26.baseY);
                            GameObject.loadObjectBlock(offsetX, Npc.currentScene, currentCollisionMap, data, offsetY);
                        } else {
                            System.out.println("Missing map: " + Class13.anIntArray421[region]);
                        }
                    }
                }
                if(GroundItemTile.loadGeneratedMap) {
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int data = (OverlayDefinition.constructMapTiles[z][x][y]);
                                boolean bool_19_ = false;
                                if(data != -1) {
                                    int tileRotation = (0x6 & data) >> 1;
                                    int tileX = (data & 0xffd2c2) >> 14;
                                    int tileZ = data >> 24 & 0x3;
                                    int tileY = (data & 0x3ffb) >> 3;
                                    int tileCoordinates = ((tileX / 8 << 8) + (tileY / 8));
                                    for(int pointer = 0; (pointer < ISAAC.mapCoordinates.length); pointer++) {
                                        if(((ISAAC.mapCoordinates[pointer]) == tileCoordinates) && (RSString.terrainData[pointer]) != null) {
                                            Class5.loadTerrainSubblock(y * 8, 8 * (tileX & 0x7), tileZ, z, x * 8, (0x7 & tileY) * 8, tileRotation, (RSString.terrainData[pointer]), currentCollisionMap);
                                            bool_19_ = true;
                                            break;
                                        }
                                    }
                                }
                                if(!bool_19_)
                                    Node.method455(8 * y, z, 1, x * 8);
                            }
                        }
                    }
                    for(int x = 0; x < 13; x++) {
                        for(int y = 0; y < 13; y++) {
                            int displayMap = (OverlayDefinition.constructMapTiles[0][x][y]);
                            if(displayMap == -1)
                                Class61.initiateVertexHeights(y * 8, (byte) 120, 8, 8, 8 * x);
                        }
                    }
                    Class27.method364((byte) -34, true);
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int bits = (OverlayDefinition.constructMapTiles[z][x][y]);
                                if(bits != -1) {
                                    int tileZ = ((bits & 0x3ba82fb) >> 24);
                                    int tileX = 0x3ff & bits >> 14;
                                    int tileRotation = bits >> 1 & 0x3;
                                    int tileY = bits >> 3 & 0x7ff;
                                    int tileCoordinates = ((tileX / 8 << 8) + (tileY / 8));
                                    for(int i_38_ = 0; (i_38_ < ISAAC.mapCoordinates.length); i_38_++) {
                                        if(tileCoordinates == (ISAAC.mapCoordinates[i_38_]) && (GenericTile.objectData[i_38_]) != null) {
                                            Class24.method341(8 * (tileX & 0x7), (Npc.currentScene), 0, z, tileRotation, tileZ, (GenericTile.objectData[i_38_]), 8 * y, currentCollisionMap, 8 * (tileY & 0x7), x * 8);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Class27.method364((byte) -34, true);
                RSCanvas.method46(0);
                ISAAC.method281((Npc.currentScene), 27324, currentCollisionMap);
                Class27.method364((byte) -34, true);
                int z = Class64.lowestPlane;
                if(Player.worldLevel < z)
                    z = Player.worldLevel;
                if(z < -1 + Player.worldLevel)
                    z = -1 + Player.worldLevel;
                if(!VertexNormal.lowMemory)
                    Npc.currentScene.setHeightLevel(0);
                else
                    Npc.currentScene.setHeightLevel(Class64.lowestPlane);
                for(int x = 0; x < 104; x++) {
                    for(int y = 0; y < 104; y++)
                        FramemapDefinition.spawnGroundItem(y, x);
                }
                ISAAC.method285((byte) 118);
                VertexNormal.aClass9_1102.method235((byte) -43);
                if(Class35.aFrame1732 != null) {
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
                            if(i_42_ > i_46_ || (i_46_ > i_45_) || i_47_ < i_43_ || (i_47_ > i_44_)) {
                                Renderable.aClass6_Sub1_2857.method195(0, (RSString.linkRSStrings((new RSString[]{LinkedList.aClass1_1085, HashTable.method334(i_46_), Class8.aClass1_303, HashTable.method334(i_47_)}))));
                                Renderable.aClass6_Sub1_2857.method195(0, (RSString.linkRSStrings((new RSString[]{HashTable.aClass1_553, HashTable.method334(i_46_), Class8.aClass1_303, HashTable.method334(i_47_)}))));
                            }
                        }
                    }
                }
                if(ActorDefinition.openFullScreenWidgetId != -1)
                    OverlayDefinition.method559(35);
                else
                    OverlayDefinition.method559(30);
                Class56.method973();
                SceneCluster.packetBuffer.putPacket(178);
                RSRuntimeException.method1057(126);
            } else
                Class68.anInt1634 = 2;
        } else
            Class68.anInt1634 = 1;

    }

    public static void method934(int arg0, int arg2, int arg3, int arg4) {
        for(Class40_Sub2 class40_sub2 = ((Class40_Sub2) Class40_Sub5_Sub1.aLinkedList_2268.method902((byte) -90)); class40_sub2 != null; class40_sub2 = (Class40_Sub2) Class40_Sub5_Sub1.aLinkedList_2268.method909(-4)) {
            if(class40_sub2.anInt1997 != -1 || class40_sub2.anIntArray2005 != null) {
                int i_48_ = 0;
                if(arg0 <= class40_sub2.anInt2013) {
                    if((arg0 < class40_sub2.anInt1994))
                        i_48_ += class40_sub2.anInt1994 - arg0;
                } else
                    i_48_ += -class40_sub2.anInt2013 + arg0;
                if(arg4 > class40_sub2.anInt2007)
                    i_48_ += -class40_sub2.anInt2007 + arg4;
                else if((arg4 < class40_sub2.anInt2003))
                    i_48_ += -arg4 + class40_sub2.anInt2003;
                if(class40_sub2.anInt2000 < -64 + i_48_ || RSCanvas.anInt65 == 0 || (arg2 != class40_sub2.anInt1993)) {
                    if(class40_sub2.aClass40_Sub9_Sub2_2001 != null) {
                        Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2001);
                        class40_sub2.aClass40_Sub9_Sub2_2001 = null;
                    }
                    if(class40_sub2.aClass40_Sub9_Sub2_2010 != null) {
                        Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2010);
                        class40_sub2.aClass40_Sub9_Sub2_2010 = null;
                    }
                } else {
                    i_48_ -= 64;
                    if(i_48_ < 0)
                        i_48_ = 0;
                    int i_49_ = ((-i_48_ + class40_sub2.anInt2000) * RSCanvas.anInt65 / class40_sub2.anInt2000);
                    if(class40_sub2.aClass40_Sub9_Sub2_2001 == null) {
                        if(class40_sub2.anInt1997 >= 0) {
                            Effect effect = (Effect.method429((Actor.aClass6_Sub1_3157), class40_sub2.anInt1997, 0));
                            if(effect != null) {
                                Class40_Sub12_Sub1 class40_sub12_sub1 = (effect.method428().method875(Class55.aClass48_1289));
                                Class40_Sub9_Sub2 class40_sub9_sub2 = (Class40_Sub9_Sub2.method864(class40_sub12_sub1, 100, i_49_));
                                class40_sub9_sub2.method860(-1);
                                Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                                class40_sub2.aClass40_Sub9_Sub2_2001 = class40_sub9_sub2;
                            }
                        }
                    } else
                        class40_sub2.aClass40_Sub9_Sub2_2001.method857(i_49_);
                    if(class40_sub2.aClass40_Sub9_Sub2_2010 == null) {
                        if(class40_sub2.anIntArray2005 != null && (class40_sub2.anInt2014 -= arg3) <= 0) {
                            int i_50_ = (int) ((double) (class40_sub2.anIntArray2005).length * Math.random());
                            Effect effect = (Effect.method429((Actor.aClass6_Sub1_3157), class40_sub2.anIntArray2005[i_50_], 0));
                            if(effect != null) {
                                Class40_Sub12_Sub1 class40_sub12_sub1 = (effect.method428().method875(Class55.aClass48_1289));
                                Class40_Sub9_Sub2 class40_sub9_sub2 = (Class40_Sub9_Sub2.method864(class40_sub12_sub1, 100, i_49_));
                                class40_sub9_sub2.method860(0);
                                Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                                class40_sub2.anInt2014 = (class40_sub2.anInt2012 + (int) ((double) (-(class40_sub2.anInt2012) + (class40_sub2.anInt2002)) * Math.random()));
                                class40_sub2.aClass40_Sub9_Sub2_2010 = class40_sub9_sub2;
                            }
                        }
                    } else {
                        class40_sub2.aClass40_Sub9_Sub2_2010.method857(i_49_);
                        if(!class40_sub2.aClass40_Sub9_Sub2_2010.method863())
                            class40_sub2.aClass40_Sub9_Sub2_2010 = null;
                    }
                }
            }
        }
    }

    public static void method935() {
        distanceValues = null;
        aClass1_1163 = null;
        aClass1_1158 = null;
        aClass1_1162 = null;
        currentCollisionMap = null;
        aClass1_1181 = null;
        aClass1_1176 = null;
        anIntArray1168 = null;
        aClass1_1178 = null;
        aClass1_1183 = null;
        aClass1_1172 = null;
        aClass1_1180 = null;
        aClass68_1185 = null;
        aClass1_1173 = null;
        anIntArray1186 = null;
        menuActionTexts = null;
        aClass1_1169 = null;
        aClass1_1174 = null;
    }

    public static void method936(CacheIndex arg1) {
        RSCanvas.aCacheIndex_61 = arg1;

    }
}
