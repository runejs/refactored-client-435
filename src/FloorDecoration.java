/* FloorDecoration - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.io.IOException;
import java.util.zip.CRC32;

public class FloorDecoration {
    public static RSString STRING_CONNECTING_UPDATE_SERVER = Class58.method978("Connecting to update server");
    public static CRC32 aCRC32_590;
    public static RSString aClass1_591;
    public static int anInt592;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_593;
    public static int anInt596;
    public static int anInt597;
    public static int anInt598;
    public static int anInt599;
    public static DirectColorSprite[] aClass40_Sub5_Sub14_Sub4Array603;
    public static int anInt604;
    public static Class6_Sub1 aClass6_Sub1_605;
    public static RSString aClass1_606;
    public static Class15 aClass15_607;
    public static Class40_Sub9 aClass40_Sub9_608;
    public static RSString aClass1_609;
    public static RSString aClass1_610;
    public static RSString aClass1_611;
    public static int[] anIntArray612;
    public static RSString aClass1_613;
    public static int anInt614;
    public static RSString aClass1_615;

    static {
        aClass1_606 = Class58.method978("Add friend");
        aClass1_591 = aClass1_606;
        aCRC32_590 = new CRC32();
        aClass1_609 = Class58.method978("blinken2:");
        aClass1_610 = Class58.method978("@red@");
        aClass1_611 = null;
        aClass1_613 = Class58.method978("Verbindung mit Update)2Server)3)3)3");
        anInt614 = -1;
        aClass1_615 = Class58.method978("huffman");
    }

    public int config;
    public int hash;
    public int x;
    public Renderable renderable;
    public int y;
    public int z;

    public static void method342(int arg0, int arg1, Class40_Sub5_Sub17_Sub4 arg2) {
        try {
            Class22_Sub1.method312(arg1, arg2.anInt3089, arg2.anInt3098, 4976905);
            int i = -63 % ((41 - arg0) / 41);
            anInt598++;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("id.B(" + arg0 + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method343(boolean arg0, int arg1) {
        Class58.aBoolean1349 = arg0;
        if(Class58.aBoolean1349) {
            int i = Cache.outgoingbuffer.method469(arg1 + 59592);
            int i_0_ = Cache.outgoingbuffer.method504(false);
            int i_1_ = Cache.outgoingbuffer.method469(65280);
            int i_2_ = Cache.outgoingbuffer.method480((byte) -70);
            int i_3_ = Cache.outgoingbuffer.method469(arg1 + 59592);
            Cache.outgoingbuffer.initBitAccess(arg1 ^ 0x1625);
            for(int i_4_ = 0; (i_4_ ^ 0xffffffff) > -5; i_4_++) {
                for(int i_5_ = 0; i_5_ < 13; i_5_++) {
                    for(int i_6_ = 0; i_6_ < 13; i_6_++) {
                        int i_7_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                        if(i_7_ != 1)
                            Floor.anIntArrayArrayArray2333[i_4_][i_5_][i_6_] = -1;
                        else
                            Floor.anIntArrayArrayArray2333[i_4_][i_5_][i_6_] = Cache.outgoingbuffer.putBits(26, (byte) -65);
                    }
                }
            }
            Cache.outgoingbuffer.finishBitAccess((byte) -110);
            int i_8_ = ((-Cache.outgoingbuffer.offset + Class40_Sub5_Sub12.packetsize) / 16);
            Class44.anIntArrayArray1030 = new int[i_8_][4];
            for(int i_9_ = 0; i_8_ > i_9_; i_9_++) {
                for(int i_10_ = 0; i_10_ < 4; i_10_++)
                    Class44.anIntArrayArray1030[i_9_][i_10_] = Cache.outgoingbuffer.method507(-64);
            }
            Class45.anIntArray1071 = new int[i_8_];
            RSString.aByteArrayArray1715 = new byte[i_8_][];
            Class13.anIntArray421 = new int[i_8_];
            Class52.aByteArrayArray1217 = new byte[i_8_][];
            ISAAC.anIntArray528 = new int[i_8_];
            i_8_ = 0;
            for(int i_11_ = 0; (i_11_ ^ 0xffffffff) > -5; i_11_++) {
                for(int i_12_ = 0; i_12_ < 13; i_12_++) {
                    for(int i_13_ = 0; (i_13_ ^ 0xffffffff) > -14; i_13_++) {
                        int i_14_ = (Floor.anIntArrayArrayArray2333[i_11_][i_12_][i_13_]);
                        if((i_14_ ^ 0xffffffff) != 0) {
                            int i_15_ = i_14_ >> -1674306002 & 0x3ff;
                            int i_16_ = i_14_ >> 66731331 & 0x7ff;
                            int i_17_ = i_16_ / 8 + (i_15_ / 8 << 999577032);
                            for(int i_18_ = 0; i_8_ > i_18_; i_18_++) {
                                if((i_17_ ^ 0xffffffff) == (ISAAC.anIntArray528[i_18_] ^ 0xffffffff)) {
                                    i_17_ = -1;
                                    break;
                                }
                            }
                            if((i_17_ ^ 0xffffffff) != 0) {
                                ISAAC.anIntArray528[i_8_] = i_17_;
                                int i_19_ = i_17_ & 0xff;
                                int i_20_ = (0xffbe & i_17_) >> 1856827112;
                                Class45.anIntArray1071[i_8_] = (Renderable.aClass6_Sub1_2857.method183(RSApplet.method27(arg1, 5688), (Class40_Sub5_Sub17_Sub6.method832(85, (new RSString[]{Class45.aClass1_1085, (HashTable.method334(i_20_, RSApplet.method27(arg1, -5689))), Class8.aClass1_303, HashTable.method334(i_19_, -1)})))));
                                Class13.anIntArray421[i_8_] = (Renderable.aClass6_Sub1_2857.method183(0, (Class40_Sub5_Sub17_Sub6.method832(118, (new RSString[]{HashTable.aClass1_553, HashTable.method334(i_20_, -1), Class8.aClass1_303, HashTable.method334(i_19_, -1)})))));
                                i_8_++;
                            }
                        }
                    }
                }
            }
            Class40_Sub5_Sub17_Sub4.method789(i_0_, arg1 + -6688, i_3_, i_1_, i, i_2_);
        } else {
            int i = Cache.outgoingbuffer.method469(65280);
            int i_21_ = Cache.outgoingbuffer.method490((byte) -70);
            int i_22_ = Cache.outgoingbuffer.method461((byte) 110);
            int i_23_ = Cache.outgoingbuffer.method504(false);
            int i_24_ = Cache.outgoingbuffer.method471((byte) -69);
            int i_25_ = ((Class40_Sub5_Sub12.packetsize - Cache.outgoingbuffer.offset) / 16);
            Class44.anIntArrayArray1030 = new int[i_25_][4];
            for(int i_26_ = 0; (i_25_ ^ 0xffffffff) < (i_26_ ^ 0xffffffff); i_26_++) {
                for(int i_27_ = 0; i_27_ < 4; i_27_++)
                    Class44.anIntArrayArray1030[i_26_][i_27_] = Cache.outgoingbuffer.method470(-128);
            }
            ISAAC.anIntArray528 = new int[i_25_];
            RSString.aByteArrayArray1715 = new byte[i_25_][];
            boolean bool = false;
            Class52.aByteArrayArray1217 = new byte[i_25_][];
            if(((i_21_ / 8 ^ 0xffffffff) == -49 || i_21_ / 8 == 49) && i_23_ / 8 == 48)
                bool = true;
            Class45.anIntArray1071 = new int[i_25_];
            if((i_21_ / 8 ^ 0xffffffff) == -49 && (i_23_ / 8 ^ 0xffffffff) == -149)
                bool = true;
            Class13.anIntArray421 = new int[i_25_];
            i_25_ = 0;
            for(int i_28_ = (-6 + i_21_) / 8; i_28_ <= (6 + i_21_) / 8; i_28_++) {
                for(int i_29_ = (-6 + i_23_) / 8; (6 + i_23_) / 8 >= i_29_; i_29_++) {
                    int i_30_ = i_29_ + (i_28_ << 13360776);
                    if(!bool || (i_29_ != 49 && (i_29_ ^ 0xffffffff) != -150 && (i_29_ ^ 0xffffffff) != -148 && (i_28_ ^ 0xffffffff) != -51 && (i_28_ != 49 || (i_29_ ^ 0xffffffff) != -48))) {
                        ISAAC.anIntArray528[i_25_] = i_30_;
                        Class45.anIntArray1071[i_25_] = (Renderable.aClass6_Sub1_2857.method183(0, (Class40_Sub5_Sub17_Sub6.method832(RSApplet.method27(arg1, -5655), new RSString[]{Class45.aClass1_1085, HashTable.method334(i_28_, -1), Class8.aClass1_303, HashTable.method334(i_29_, -1)}))));
                        Class13.anIntArray421[i_25_] = (Renderable.aClass6_Sub1_2857.method183(0, (Class40_Sub5_Sub17_Sub6.method832(-84, (new RSString[]{HashTable.aClass1_553, HashTable.method334(i_28_, -1), Class8.aClass1_303, HashTable.method334(i_29_, (RSApplet.method27(arg1, -5689)))})))));
                        i_25_++;
                    }
                }
            }
            Class40_Sub5_Sub17_Sub4.method789(i_22_, -1000, i_23_, i_21_, i, i_24_);
        }
        anInt596++;
        if(arg1 != 5688)
            aClass40_Sub5_Sub14_Sub4Array603 = null;
    }

    public static void method344(int arg0) {
        try {
            anInt592++;
            if(SubNode.aBoolean2083) {
                Class5.anIntArray198 = null;
                SubNode.aBoolean2083 = false;
                RSCanvas.anIntArray66 = null;
                Class34.aClass40_Sub5_Sub14_Sub2_855 = null;
                Landscape.anIntArray1186 = null;
                Class17.aClass68_462 = null;
                RSCanvas.aClass68_59 = null;
                GameObject.aClass68_3045 = null;
                Class57.aClass40_Sub5_Sub14_Sub2_1346 = null;
                aClass40_Sub5_Sub14_Sub2_593 = null;
                Class53.aClass40_Sub5_Sub14_Sub2_1270 = null;
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776 = null;
                Class13.aClass40_Sub5_Sub14_Sub2_418 = null;
                RSString.aClass68_1665 = null;
                RSCanvas.anIntArray62 = null;
                NpcDefinition.anIntArray2386 = null;
                Class39.aClass68_908 = null;
                Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919 = null;
                Class56.aClass40_Sub5_Sub14_Sub2_1329 = null;
                Landscape.aClass68_1185 = null;
                RSApplet.aClass40_Sub5_Sub14_Sub2_1 = null;
                Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105 = null;
                Class34.anIntArray852 = null;
                Class66.aClass68_1541 = null;
                Buffer.aClass40_Sub5_Sub14_Sub2_1959 = null;
                SubNode.aClass68_2091 = null;
                Class56.aClass40_Sub5_Sub14_Sub2_1315 = null;
                Class40_Sub5_Sub4.aClass68_2350 = null;
                ISAAC.aClass40_Sub5_Sub14_Sub2_524 = null;
                RSCanvas.aClass68_64 = null;
                Class40_Sub7.aClass68_2123 = null;
                Class19.aClass68_482 = null;
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
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "id.C(" + arg0 + ')');
        }
    }

    public static Object[] method345(byte arg0, Buffer arg1) {
        try {
            int i = arg1.method468(false);
            anInt604++;
            if((i ^ 0xffffffff) == -1)
                return null;
            Object[] objects = new Object[i];
            for(int i_31_ = 0; i_31_ < i; i_31_++) {
                int i_32_ = arg1.method468(false);
                if(i_32_ == 0)
                    objects[i_31_] = new Integer(arg1.method491(RSApplet.method27(arg0, -4821)));
                else if(i_32_ == 1)
                    objects[i_31_] = arg1.getRSString(-10721);
            }
            if(arg0 != 89)
                aClass40_Sub9_608 = null;
            return objects;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("id.E(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static boolean method346(byte arg0) {
        try {
            anInt597++;
            long l = Class51.method937(1);
            int i = (int) (l - Class45.aLong1051);
            Class45.aLong1051 = l;
            if((i ^ 0xffffffff) < -201)
                i = 200;
            if(arg0 != 48)
                return false;
            Class22.anInt547 += i;
            if(Class42.anInt1006 == 0 && Class17.anInt464 == 0 && HashTable.anInt554 == 0 && Class68.anInt1618 == 0)
                return true;
            if(Class57.aClass64_1345 == null)
                return false;
            try {
                if((Class22.anInt547 ^ 0xffffffff) < -30001)
                    throw new IOException();
                for(/**/; (Class17.anInt464 ^ 0xffffffff) > -21; Class17.anInt464++) {
                    if((Class68.anInt1618 ^ 0xffffffff) >= -1)
                        break;
                    Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class51.aClass23_1194.method329(false));
                    Buffer class40_sub1 = new Buffer(4);
                    class40_sub1.put(1, (byte) -128);
                    class40_sub1.putTri((int) class40_sub5_sub13.key, 13723);
                    Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.payload));
                    Class37.aClass23_869.put(class40_sub5_sub13, (byte) -115, (class40_sub5_sub13.key));
                    Class68.anInt1618--;
                }
                for(/**/; Class42.anInt1006 < 20 && HashTable.anInt554 > 0; HashTable.anInt554--) {
                    Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class19.aClass27_485.method362(-113));
                    Buffer class40_sub1 = new Buffer(4);
                    class40_sub1.put(0, (byte) -128);
                    class40_sub1.putTri((int) class40_sub5_sub13.key, arg0 + 13675);
                    Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.payload));
                    class40_sub5_sub13.method539(0);
                    Class34.aClass23_841.put(class40_sub5_sub13, (byte) -122, (class40_sub5_sub13.key));
                    Class42.anInt1006++;
                }
                for(int i_33_ = 0; i_33_ < 100; i_33_++) {
                    int i_34_ = Class57.aClass64_1345.method1014(-122);
                    if(i_34_ < 0)
                        throw new IOException();
                    if((i_34_ ^ 0xffffffff) == -1)
                        break;
                    Class22.anInt547 = 0;
                    int i_35_ = 0;
                    if(PacketBuffer.aClass40_Sub5_Sub13_2250 == null)
                        i_35_ = 8;
                    else if((Landscape.anInt1157 ^ 0xffffffff) == -1)
                        i_35_ = 1;
                    if(i_35_ <= 0) {
                        int i_36_ = ((Class40_Sub5_Sub13.aClass40_Sub1_2752.payload).length + -(PacketBuffer.aClass40_Sub5_Sub13_2250.aByte2758));
                        int i_37_ = -Landscape.anInt1157 + 512;
                        if(((-Class40_Sub5_Sub13.aClass40_Sub1_2752.offset + i_36_) ^ 0xffffffff) > (i_37_ ^ 0xffffffff))
                            i_37_ = i_36_ - (Class40_Sub5_Sub13.aClass40_Sub1_2752.offset);
                        if(i_37_ > i_34_)
                            i_37_ = i_34_;
                        Class57.aClass64_1345.method1008((Class40_Sub5_Sub13.aClass40_Sub1_2752.offset), i_37_, -127, (Class40_Sub5_Sub13.aClass40_Sub1_2752.payload));
                        if((Class8.aByte302 ^ 0xffffffff) != -1) {
                            for(int i_38_ = 0; (i_37_ ^ 0xffffffff) < (i_38_ ^ 0xffffffff); i_38_++)
                                Class40_Sub5_Sub13.aClass40_Sub1_2752.payload[(Class40_Sub5_Sub13.aClass40_Sub1_2752.offset) + i_38_] = (byte) (RSApplet.method27((Class40_Sub5_Sub13.aClass40_Sub1_2752.payload[(Class40_Sub5_Sub13.aClass40_Sub1_2752.offset) + i_38_]), Class8.aByte302));
                        }
                        Class40_Sub5_Sub13.aClass40_Sub1_2752.offset += i_37_;
                        Landscape.anInt1157 += i_37_;
                        if((Class40_Sub5_Sub13.aClass40_Sub1_2752.offset ^ 0xffffffff) == (i_36_ ^ 0xffffffff)) {
                            if(((PacketBuffer.aClass40_Sub5_Sub13_2250.key) ^ 0xffffffffffffffffL) != -16711936L) {
				/*aCRC32_590.reset();
				aCRC32_590.update((Class40_Sub5_Sub13
						   .aClass40_Sub1_2752
						   .payload),
						  0, i_36_);*/
				/*int i_39_ = (int) aCRC32_590.getValue();
				if (((PacketBuffer
				      .aClass40_Sub5_Sub13_2250.anInt2763)
				     ^ 0xffffffff)
				    != (i_39_ ^ 0xffffffff)) {
				    try {
					Class57.aClass64_1345.method1009(54);
				    } catch (Exception exception) {
				    }
				    Class8.aByte302
					= (byte) (int) (Math.random() * 255.0
							+ 1.0);
				    Class57.aClass64_1345 = null;
				    Class34.anInt813++;
				    return false;
				}*/
                                Class40_Sub5_Sub1.anInt2278 = 0;
                                Class34.anInt813 = 0;
                                PacketBuffer.aClass40_Sub5_Sub13_2250.aClass6_Sub1_2754.method196(((PacketBuffer.aClass40_Sub5_Sub13_2250.key) & 0xff0000L) == 16711680L, false, (int) ((PacketBuffer.aClass40_Sub5_Sub13_2250.key) & 0xffffL), NPC.aBoolean3298, (Class40_Sub5_Sub13.aClass40_Sub1_2752.payload));
                            } else {
                                Class48.aClass40_Sub1_1132 = Class40_Sub5_Sub13.aClass40_Sub1_2752;
                                for(int i_40_ = 0; i_40_ < 256; i_40_++) {
                                    Class6_Sub1 class6_sub1 = Class24.aClass6_Sub1Array580[i_40_];
                                    if(class6_sub1 != null) {
                                        Class48.aClass40_Sub1_1132.offset = 4 * i_40_ + 5;
                                        int i_41_ = Class48.aClass40_Sub1_1132.method491(-4750);
                                        class6_sub1.method200(i_41_, 99);
                                    }
                                }
                            }
                            PacketBuffer.aClass40_Sub5_Sub13_2250.method457(-1);
                            PacketBuffer.aClass40_Sub5_Sub13_2250 = null;
                            Class40_Sub5_Sub13.aClass40_Sub1_2752 = null;
                            Landscape.anInt1157 = 0;
                            if(!NPC.aBoolean3298)
                                Class42.anInt1006--;
                            else
                                Class17.anInt464--;
                        } else {
                            if(Landscape.anInt1157 != 512)
                                break;
                            Landscape.anInt1157 = 0;
                        }
                    } else {
                        int i_42_ = -Class45.aClass40_Sub1_1081.offset + i_35_;
                        if(i_42_ > i_34_)
                            i_42_ = i_34_;
                        Class57.aClass64_1345.method1008(Class45.aClass40_Sub1_1081.offset, i_42_, -128, Class45.aClass40_Sub1_1081.payload);
                        if((Class8.aByte302 ^ 0xffffffff) != -1) {
                            for(int i_43_ = 0; i_42_ > i_43_; i_43_++)
                                Class45.aClass40_Sub1_1081.payload[(Class45.aClass40_Sub1_1081.offset + i_43_)] = (byte) (RSApplet.method27((Class45.aClass40_Sub1_1081.payload[(Class45.aClass40_Sub1_1081.offset) + i_43_]), Class8.aByte302));
                        }
                        Class45.aClass40_Sub1_1081.offset += i_42_;
                        if((i_35_ ^ 0xffffffff) < (Class45.aClass40_Sub1_1081.offset ^ 0xffffffff))
                            break;
                        if(PacketBuffer.aClass40_Sub5_Sub13_2250 == null) {
                            Class45.aClass40_Sub1_1081.offset = 0;
                            int i_44_ = Class45.aClass40_Sub1_1081.method468(false);
                            int i_45_ = Class45.aClass40_Sub1_1081.method469(65280);
                            int i_46_ = Class45.aClass40_Sub1_1081.method468(false);
                            int i_47_ = Class45.aClass40_Sub1_1081.method491(arg0 ^ ~0x12bd);
                            long l_48_ = (long) ((i_44_ << 58201072) + i_45_);
                            Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class37.aClass23_869.method331(l_48_, 6120));
                            NPC.aBoolean3298 = true;
                            if(class40_sub5_sub13 == null) {
                                class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class34.aClass23_841.method331(l_48_, 6120));
                                NPC.aBoolean3298 = false;
                            }
                            if(class40_sub5_sub13 == null)
                                throw new IOException();
                            PacketBuffer.aClass40_Sub5_Sub13_2250 = class40_sub5_sub13;
                            int i_49_ = i_46_ == 0 ? 5 : 9;
                            Class40_Sub5_Sub13.aClass40_Sub1_2752 = new Buffer((PacketBuffer.aClass40_Sub5_Sub13_2250.aByte2758) + i_49_ + i_47_);
                            Class40_Sub5_Sub13.aClass40_Sub1_2752.put(i_46_, (byte) -128);
                            Class40_Sub5_Sub13.aClass40_Sub1_2752.putInt(77, i_47_);
                            Landscape.anInt1157 = 8;
                            Class45.aClass40_Sub1_1081.offset = 0;
                        } else if(Landscape.anInt1157 == 0) {
                            if((Class45.aClass40_Sub1_1081.payload[0] ^ 0xffffffff) != 0)
                                PacketBuffer.aClass40_Sub5_Sub13_2250 = null;
                            else {
                                Class45.aClass40_Sub1_1081.offset = 0;
                                Landscape.anInt1157 = 1;
                            }
                        }
                    }
                }
                return true;
            } catch(IOException ioexception) {
                try {
                    Class57.aClass64_1345.method1009(-104);
                } catch(Exception exception) {
                    /* empty */
                }
                Class40_Sub5_Sub1.anInt2278++;
                Class57.aClass64_1345 = null;
                return false;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "id.D(" + arg0 + ')');
        }
    }

    public static RSFont method347(Class6 arg0, int arg1, RSString arg2, RSString arg3) {
        try {
            anInt599++;
            int i = arg0.method183(0, arg3);
            if(arg1 != 255)
                aClass1_591 = null;
            int i_50_ = arg0.method179(arg1 ^ 0xe3, i, arg2);
            return Class40_Sub5_Sub17_Sub1.method760(i_50_, (byte) -124, arg0, i);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("id.G(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ',' + (arg3 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method348(int arg0) {
        try {
            aClass40_Sub5_Sub14_Sub2_593 = null;
            aCRC32_590 = null;
            aClass1_610 = null;
            aClass1_611 = null;
            aClass1_613 = null;
            aClass1_606 = null;
            anIntArray612 = null;
            aClass1_591 = null;
            aClass40_Sub5_Sub14_Sub4Array603 = null;
            aClass6_Sub1_605 = null;
            STRING_CONNECTING_UPDATE_SERVER = null;
            if(arg0 != -6580)
                STRING_CONNECTING_UPDATE_SERVER = null;
            aClass1_615 = null;
            aClass1_609 = null;
            aClass15_607 = null;
            aClass40_Sub9_608 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "id.F(" + arg0 + ')');
        }
    }
}
