package com.jagex.runescape.scene.tile;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.util.SignlinkNode;

import java.io.IOException;
import java.util.zip.CRC32;

public class FloorDecoration {
    public static RSString STRING_CONNECTING_UPDATE_SERVER = RSString.CreateString("Connecting to update server");
    public static CRC32 aCRC32_590 = new CRC32();
    public static RSString aClass1_591;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_593;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array603;
    public static CacheIndex_Sub1 aClass6_Sub1_605;
    public static RSString aClass1_606 = RSString.CreateString("Add friend");
    public static SignlinkNode aSignlinkNode_607;
    public static Class40_Sub9 aClass40_Sub9_608;
    public static RSString aClass1_610 = RSString.CreateString("@red@");
    public static RSString aClass1_611 = null;
    public static int[] anIntArray612;
    public static int anInt614 = -1;
    public static RSString aClass1_615 = RSString.CreateString("huffman");

    static {
        aClass1_591 = aClass1_606;
    }

    public int config;
    public int hash;
    public int x;
    public Renderable renderable;
    public int y;
    public int z;

    public static void method342(int arg1, Actor arg2) {
        Class22_Sub1.method312(arg1, arg2.worldY, arg2.worldX, 4976905);
    }

    public static void method343(boolean arg0, int arg1) {
        GroundItemTile.loadGeneratedMap = arg0;
        if(GroundItemTile.loadGeneratedMap) {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_0_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int i_1_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_2_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_3_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            IncomingPackets.incomingPacketBuffer.initBitAccess();
            for(int i_4_ = 0; i_4_ < 4; i_4_++) {
                for(int i_5_ = 0; i_5_ < 13; i_5_++) {
                    for(int i_6_ = 0; i_6_ < 13; i_6_++) {
                        int i_7_ = IncomingPackets.incomingPacketBuffer.getBits(1);
                        if(i_7_ != 1)
                            OverlayDefinition.constructMapTiles[i_4_][i_5_][i_6_] = -1;
                        else
                            OverlayDefinition.constructMapTiles[i_4_][i_5_][i_6_] = IncomingPackets.incomingPacketBuffer.getBits(26);
                    }
                }
            }
            IncomingPackets.incomingPacketBuffer.finishBitAccess();
            int i_8_ = ((-IncomingPackets.incomingPacketBuffer.currentPosition + IncomingPackets.incomingPacketSize) / 16);
            Class44.anIntArrayArray1030 = new int[i_8_][4];
            for(int i_9_ = 0; i_8_ > i_9_; i_9_++) {
                for(int i_10_ = 0; i_10_ < 4; i_10_++)
                    Class44.anIntArrayArray1030[i_9_][i_10_] = IncomingPackets.incomingPacketBuffer.getIntBE();
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
                        int i_14_ = (OverlayDefinition.constructMapTiles[i_11_][i_12_][i_13_]);
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
                                LinkedList.anIntArray1071[i_8_] = (Renderable.aClass6_Sub1_2857.getHash((RSString.linkRSStrings((new RSString[]{LinkedList.aClass1_1085, (HashTable.method334(i_20_)), Class8.aClass1_303, HashTable.method334(i_19_)})))));
                                Class13.anIntArray421[i_8_] = (Renderable.aClass6_Sub1_2857.getHash((RSString.linkRSStrings((new RSString[]{HashTable.aClass1_553, HashTable.method334(i_20_), Class8.aClass1_303, HashTable.method334(i_19_)})))));
                                i_8_++;
                            }
                        }
                    }
                }
            }
            Actor.method789(i_0_, arg1 + -6688, i_3_, i_1_, i, i_2_);
        } else {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_21_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int i_22_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_23_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int i_24_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_25_ = ((IncomingPackets.incomingPacketSize - IncomingPackets.incomingPacketBuffer.currentPosition) / 16);
            Class44.anIntArrayArray1030 = new int[i_25_][4];
            for(int i_26_ = 0; (i_25_ > i_26_); i_26_++) {
                for(int i_27_ = 0; i_27_ < 4; i_27_++)
                    Class44.anIntArrayArray1030[i_26_][i_27_] = IncomingPackets.incomingPacketBuffer.getIntBE();
            }
            ISAAC.mapCoordinates = new int[i_25_];
            RSString.terrainData = new byte[i_25_][];
            boolean bool = false;
            GenericTile.objectData = new byte[i_25_][];
            if((i_21_ / 8 == 48 || i_21_ / 8 == 49) && i_23_ / 8 == 48)
                bool = true;
            LinkedList.anIntArray1071 = new int[i_25_];
            if(i_21_ / 8 == 48 && i_23_ / 8 == 148)
                bool = true;
            Class13.anIntArray421 = new int[i_25_];
            i_25_ = 0;
            for(int i_28_ = (-6 + i_21_) / 8; i_28_ <= (6 + i_21_) / 8; i_28_++) {
                for(int i_29_ = (-6 + i_23_) / 8; (6 + i_23_) / 8 >= i_29_; i_29_++) {
                    int i_30_ = i_29_ + (i_28_ << 8);
                    if(!bool || (i_29_ != 49 && i_29_ != 149 && i_29_ != 147 && i_28_ != 50 && (i_28_ != 49 || i_29_ != 47))) {
                        ISAAC.mapCoordinates[i_25_] = i_30_;
                        LinkedList.anIntArray1071[i_25_] = (Renderable.aClass6_Sub1_2857.getHash((RSString.linkRSStrings(new RSString[]{LinkedList.aClass1_1085, HashTable.method334(i_28_), Class8.aClass1_303, HashTable.method334(i_29_)}))));
                        Class13.anIntArray421[i_25_] = (Renderable.aClass6_Sub1_2857.getHash((RSString.linkRSStrings((new RSString[]{HashTable.aClass1_553, HashTable.method334(i_28_), Class8.aClass1_303, HashTable.method334(i_29_)})))));
                        i_25_++;
                    }
                }
            }
            Actor.method789(i_22_, -1000, i_23_, i_21_, i, i_24_);
        }
        if(arg1 != 5688)
            aClass40_Sub5_Sub14_Sub4Array603 = null;
    }

    public static void method344(int arg0) {
        if(SubNode.aBoolean2083) {
            Class5.anIntArray198 = null;
            SubNode.aBoolean2083 = false;
            RSCanvas.anIntArray66 = null;
            Class34.mapBack = null;
            Landscape.anIntArray1186 = null;
            Class17.aClass68_462 = null;
            RSCanvas.aClass68_59 = null;
            GameObject.aClass68_3045 = null;
            Class57.aClass40_Sub5_Sub14_Sub2_1346 = null;
            aClass40_Sub5_Sub14_Sub2_593 = null;
            WallDecoration.aClass40_Sub5_Sub14_Sub2_1270 = null;
            Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776 = null;
            Class13.aClass40_Sub5_Sub14_Sub2_418 = null;
            RSString.aClass68_1665 = null;
            RSCanvas.anIntArray62 = null;
            ActorDefinition.anIntArray2386 = null;
            Class39.aClass68_908 = null;
            Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919 = null;
            Class56.aClass40_Sub5_Sub14_Sub2_1329 = null;
            Landscape.aClass68_1185 = null;
            GameShell.aClass40_Sub5_Sub14_Sub2_1 = null;
            Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105 = null;
            Class34.anIntArray852 = null;
            HuffmanEncoding.aClass68_1541 = null;
            Buffer.aClass40_Sub5_Sub14_Sub2_1959 = null;
            SubNode.aClass68_2091 = null;
            Class56.aClass40_Sub5_Sub14_Sub2_1315 = null;
            VarbitDefinition.aClass68_2350 = null;
            ISAAC.aClass40_Sub5_Sub14_Sub2_524 = null;
            RSCanvas.aClass68_64 = null;
            Class40_Sub7.aClass68_2123 = null;
            InteractiveObject.aClass68_482 = null;
            if(arg0 < -28) {
                Class40_Sub5_Sub1.aClass68_2275 = null;
                Class61.aClass68_1441 = null;
                Class35.aClass40_Sub5_Sub14_Sub2_1744 = null;
                HashTable.aClass40_Sub5_Sub14_Sub2_549 = null;
                Renderable.aClass40_Sub5_Sub14_Sub2_2860 = null;
                Class24.anIntArray577 = null;
                Class30.aClass68_714 = null;
                Class40_Sub5_Sub17_Sub6.aClass68_3243 = null;
                Class44.aClass40_Sub5_Sub14_Sub2_1047 = null;
            }
        }
    }

    public static Object[] method345(byte arg0, Buffer arg1) {
        int i = arg1.getUnsignedByte();
        if(i == 0)
            return null;
        Object[] objects = new Object[i];
        for(int i_31_ = 0; i_31_ < i; i_31_++) {
            int i_32_ = arg1.getUnsignedByte();
            if(i_32_ == 0)
                objects[i_31_] = new Integer(arg1.getIntBE());
            else if(i_32_ == 1)
                objects[i_31_] = arg1.getRSString();
        }
        if(arg0 != 89)
            aClass40_Sub9_608 = null;
        return objects;
    }

    public static boolean method346(byte arg0) {
        long l = System.currentTimeMillis();
        int i = (int) (l - LinkedList.aLong1051);
        LinkedList.aLong1051 = l;
        if(i > 200)
            i = 200;
        if(arg0 != 48)
            return false;
        Class22.anInt547 += i;
        if(Class42.anInt1006 == 0 && Class17.anInt464 == 0 && HashTable.anInt554 == 0 && Class68.anInt1618 == 0)
            return true;
        if(Class57.aClass64_1345 == null)
            return false;
        try {
            if(Class22.anInt547 > 30000)
                throw new IOException();
            for(/**/; Class17.anInt464 < 20; Class17.anInt464++) {
                if(Class68.anInt1618 <= 0)
                    break;
                Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class51.aClass23_1194.method329(false));
                Buffer class40_sub1 = new Buffer(4);
                class40_sub1.putByte(1);
                class40_sub1.putMediumBE((int) class40_sub5_sub13.key);
                Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.buffer));
                Class37.aClass23_869.put(class40_sub5_sub13, (byte) -115, (class40_sub5_sub13.key));
                Class68.anInt1618--;
            }
            for(/**/; Class42.anInt1006 < 20 && HashTable.anInt554 > 0; HashTable.anInt554--) {
                Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) InteractiveObject.aClass27_485.method362(-113));
                Buffer class40_sub1 = new Buffer(4);
                class40_sub1.putByte(0);
                class40_sub1.putMediumBE((int) class40_sub5_sub13.key);
                Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.buffer));
                class40_sub5_sub13.method539();
                Class34.aClass23_841.put(class40_sub5_sub13, (byte) -122, (class40_sub5_sub13.key));
                Class42.anInt1006++;
            }
            for(int i_33_ = 0; i_33_ < 100; i_33_++) {
                int i_34_ = Class57.aClass64_1345.method1014(-122);
                if(i_34_ < 0)
                    throw new IOException();
                if(i_34_ == 0)
                    break;
                Class22.anInt547 = 0;
                int i_35_ = 0;
                if(PacketBuffer.aClass40_Sub5_Sub13_2250 == null)
                    i_35_ = 8;
                else if(Landscape.anInt1157 == 0)
                    i_35_ = 1;
                if(i_35_ <= 0) {
                    int i_36_ = ((Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer).length + -(PacketBuffer.aClass40_Sub5_Sub13_2250.aByte2758));
                    int i_37_ = -Landscape.anInt1157 + 512;
                    if(((-Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition + i_36_) < i_37_))
                        i_37_ = i_36_ - (Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition);
                    if(i_37_ > i_34_)
                        i_37_ = i_34_;
                    Class57.aClass64_1345.method1008((Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition), i_37_, -127, (Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer));
                    if(Class8.aByte302 != 0) {
                        for(int i_38_ = 0; (i_37_ > i_38_); i_38_++)
                            Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer[(Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition) + i_38_] = (byte) (GameShell.method27((Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer[(Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition) + i_38_]), Class8.aByte302));
                    }
                    Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition += i_37_;
                    Landscape.anInt1157 += i_37_;
                    if(i_36_ == Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition) {
                        if((PacketBuffer.aClass40_Sub5_Sub13_2250.key) == 16711935) {
                            Class48.aClass40_Sub1_1132 = Class40_Sub5_Sub13.aClass40_Sub1_2752;
                            for(int i_40_ = 0; i_40_ < 256; i_40_++) {
                                CacheIndex_Sub1 class6_sub1 = Class24.aClass6_Sub1Array580[i_40_];
                                if(class6_sub1 != null) {
                                    Class48.aClass40_Sub1_1132.currentPosition = 4 * i_40_ + 5;
                                    int i_41_ = Class48.aClass40_Sub1_1132.getIntBE();
                                    class6_sub1.method200(i_41_, 99);
                                }
                            }
                        } else {
                            aCRC32_590.reset();
                            aCRC32_590.update((com.jagex.runescape.Class40_Sub5_Sub13
                                            .aClass40_Sub1_2752
                                            .buffer),
                                    0, i_36_);
                            int i_39_ = (int) aCRC32_590.getValue();
                            if((~(PacketBuffer
                                    .aClass40_Sub5_Sub13_2250.anInt2763))
                                    != (~i_39_)) {
                                try {
                                    com.jagex.runescape.Class57.aClass64_1345.method1009();
                                } catch(Exception exception) {
                                }
                                com.jagex.runescape.Class8.aByte302
                                        = (byte) (int) (Math.random() * 255.0
                                        + 1.0);
                                com.jagex.runescape.Class57.aClass64_1345 = null;
                                com.jagex.runescape.Class34.anInt813++;
                                return false;
                            }
                            Class40_Sub5_Sub1.anInt2278 = 0;
                            Class34.anInt813 = 0;
                            PacketBuffer.aClass40_Sub5_Sub13_2250.aClass6_Sub1_2754.method196(((PacketBuffer.aClass40_Sub5_Sub13_2250.key) & 0xff0000L) == 16711680L, (int) ((PacketBuffer.aClass40_Sub5_Sub13_2250.key) & 0xffffL), Npc.aBoolean3298, (Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer));
                        }
                        PacketBuffer.aClass40_Sub5_Sub13_2250.method457(-1);
                        PacketBuffer.aClass40_Sub5_Sub13_2250 = null;
                        Class40_Sub5_Sub13.aClass40_Sub1_2752 = null;
                        Landscape.anInt1157 = 0;
                        if(!Npc.aBoolean3298)
                            Class42.anInt1006--;
                        else
                            Class17.anInt464--;
                    } else {
                        if(Landscape.anInt1157 != 512)
                            break;
                        Landscape.anInt1157 = 0;
                    }
                } else {
                    int i_42_ = -LinkedList.aClass40_Sub1_1081.currentPosition + i_35_;
                    if(i_42_ > i_34_)
                        i_42_ = i_34_;
                    Class57.aClass64_1345.method1008(LinkedList.aClass40_Sub1_1081.currentPosition, i_42_, -128, LinkedList.aClass40_Sub1_1081.buffer);
                    if(Class8.aByte302 != 0) {
                        for(int i_43_ = 0; i_42_ > i_43_; i_43_++)
                            LinkedList.aClass40_Sub1_1081.buffer[(LinkedList.aClass40_Sub1_1081.currentPosition + i_43_)] = (byte) (GameShell.method27((LinkedList.aClass40_Sub1_1081.buffer[(LinkedList.aClass40_Sub1_1081.currentPosition) + i_43_]), Class8.aByte302));
                    }
                    LinkedList.aClass40_Sub1_1081.currentPosition += i_42_;
                    if((i_35_ > LinkedList.aClass40_Sub1_1081.currentPosition))
                        break;
                    if(PacketBuffer.aClass40_Sub5_Sub13_2250 == null) {
                        LinkedList.aClass40_Sub1_1081.currentPosition = 0;
                        int i_44_ = LinkedList.aClass40_Sub1_1081.getUnsignedByte();
                        int i_45_ = LinkedList.aClass40_Sub1_1081.getUnsignedShortBE();
                        int i_46_ = LinkedList.aClass40_Sub1_1081.getUnsignedByte();
                        int i_47_ = LinkedList.aClass40_Sub1_1081.getIntBE();
                        long l_48_ = (long) ((i_44_ << 16) + i_45_);
                        Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class37.aClass23_869.method331(l_48_, 6120));
                        Npc.aBoolean3298 = true;
                        if(class40_sub5_sub13 == null) {
                            class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class34.aClass23_841.method331(l_48_, 6120));
                            Npc.aBoolean3298 = false;
                        }
                        if(class40_sub5_sub13 == null)
                            throw new IOException();
                        PacketBuffer.aClass40_Sub5_Sub13_2250 = class40_sub5_sub13;
                        int i_49_ = i_46_ == 0 ? 5 : 9;
                        Class40_Sub5_Sub13.aClass40_Sub1_2752 = new Buffer((PacketBuffer.aClass40_Sub5_Sub13_2250.aByte2758) + i_49_ + i_47_);
                        Class40_Sub5_Sub13.aClass40_Sub1_2752.putByte(i_46_);
                        Class40_Sub5_Sub13.aClass40_Sub1_2752.putIntBE(i_47_);
                        Landscape.anInt1157 = 8;
                        LinkedList.aClass40_Sub1_1081.currentPosition = 0;
                    } else if(Landscape.anInt1157 == 0) {
                        if(LinkedList.aClass40_Sub1_1081.buffer[0] == -1) {
                            LinkedList.aClass40_Sub1_1081.currentPosition = 0;
                            Landscape.anInt1157 = 1;
                        } else
                            PacketBuffer.aClass40_Sub5_Sub13_2250 = null;
                    }
                }
            }
            return true;
        } catch(IOException ioexception) {
            ioexception.printStackTrace();
            try {
                Class57.aClass64_1345.method1009();
            } catch(Exception exception) {
                exception.printStackTrace();
                /* empty */
            }
            Class40_Sub5_Sub1.anInt2278++;
            Class57.aClass64_1345 = null;
            return false;
        }
    }

    public static void method348() {
        aClass40_Sub5_Sub14_Sub2_593 = null;
        aCRC32_590 = null;
        aClass1_610 = null;
        aClass1_611 = null;
        aClass1_606 = null;
        anIntArray612 = null;
        aClass1_591 = null;
        aClass40_Sub5_Sub14_Sub4Array603 = null;
        aClass6_Sub1_605 = null;
        STRING_CONNECTING_UPDATE_SERVER = null;
        aClass1_615 = null;
        aSignlinkNode_607 = null;
        aClass40_Sub9_608 = null;
    }
}
