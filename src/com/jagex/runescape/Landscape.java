package com.jagex.runescape;

import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import tech.henning.fourthreefive.OldEngine.MapDecompressor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Landscape {
    public static int anInt1157 = 0;
    public static RSString aClass1_1158;
    public static int anInt1159;
    public static RSString aClass1_1160;
    public static RSString aClass1_1161;
    public static RSString aClass1_1162;
    public static RSString aClass1_1163;
    public static int anInt1164;
    public static int anInt1165;
    public static int mouseY = 0;
    public static CollisionMap[] aCollisionMapArray1167;
    public static int[] anIntArray1168;
    public static RSString aClass1_1169;
    public static int anInt1170;
    public static int anInt1171;
    public static RSString aClass1_1172;
    public static RSString aClass1_1173;
    public static RSString aClass1_1174;
    public static int[][] anIntArrayArray1175;
    public static RSString aClass1_1176;
    public static int anInt1177;
    public static RSString aClass1_1178;
    public static int anInt1179;
    public static RSString aClass1_1180;
    public static RSString aClass1_1181;
    public static int anInt1182;
    public static RSString aClass1_1183;
    public static RSString[] aClass1Array1184;
    public static Class68 aClass68_1185;
    public static int[] anIntArray1186;

    static {
        aClass1_1163 = RSString.CreateString("glow1:");
        aClass1_1158 = RSString.CreateString("Enter amount:");
        aClass1_1160 = RSString.CreateString("Passwort: ");
        aClass1_1174 = aClass1_1158;
        aClass1_1162 = RSString.CreateString("@gre@");
        aClass1_1176 = RSString.CreateString("Loaded wordpack");
        aCollisionMapArray1167 = new CollisionMap[4];
        aClass1_1173 = aClass1_1176;
        anIntArrayArray1175 = new int[104][104];
        anInt1170 = 0;
        aClass1_1172 = RSString.CreateString("You are standing in a members)2only area)3");
        aClass1_1178 = aClass1_1172;
        aClass1_1161 = RSString.CreateString("Bitte wenden Sie sich an den Kundendienst)3");
        aClass1_1183 = RSString.CreateString("");
        anInt1171 = 0;
        aClass1_1169 = RSString.CreateString("Your ignore list is full)3 Max of 100 hit");
        aClass1_1181 = aClass1_1163;
        aClass1_1180 = aClass1_1169;
        aClass1Array1184 = new RSString[500];
    }

    public static byte[] method931(byte[] arg0) {

        Buffer class40_sub1 = new Buffer(arg0);
        anInt1159++;
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

    public static void method933(int arg0) {

        anInt1179++;
        Class27.method364((byte) -34, false);
        Class37.anInt874 = 0;
        boolean bool = true;
        for(int i = 0; (i < RSString.aByteArrayArray1715.length); i++) {
            if(Class45.anIntArray1071[i] != -1 && RSString.aByteArrayArray1715[i] == null) {
                RSString.aByteArrayArray1715[i] = Renderable.aClass6_Sub1_2857.getFile(0, Class45.anIntArray1071[i]);
                if(RSString.aByteArrayArray1715[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
            if(Class13.anIntArray421[i] != -1 && Class52.aByteArrayArray1217[i] == null) {
                Class52.aByteArrayArray1217[i] = (Renderable.aClass6_Sub1_2857.method176(Class13.anIntArray421[i], 0, Class44.anIntArrayArray1030[i], 20582));
                if(Class52.aByteArrayArray1217[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
        }
        if(bool) {
            bool = true;
            IdentityKit.anInt2591 = 0;
            for(int i = 0; RSString.aByteArrayArray1715.length > i; i++) {
                byte[] is = Class52.aByteArrayArray1217[i];
                if(is != null) {
                    int i_2_ = ((ISAAC.anIntArray528[i] & 0xff) * 64 - Class26.anInt635);
                    int i_3_ = ((ISAAC.anIntArray528[i] >> 8) * 64 - SpotAnimDefinition.anInt2307);
                    if(Class58.aBoolean1349) {
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
                Npc.aScene_3301.method98();
                System.gc();
                for(int i = 0; i < 4; i++)
                    aCollisionMapArray1167[i].method146(16777216);
                for(int i = 0; i < 4; i++) {
                    for(int i_4_ = 0; i_4_ < 104; i_4_++) {
                        for(int i_5_ = 0; i_5_ < 104; i_5_++)
                            OverlayDefinition.tile_flags[i][i_4_][i_5_] = (byte) 0;
                    }
                }
                Class65.method1020(true);
                int i = RSString.aByteArrayArray1715.length;
                Class37.method436(118);
                Class27.method364((byte) -34, true);
                if(!Class58.aBoolean1349) {
                    for(int i_6_ = 0; i > i_6_; i_6_++) {
                        int i_7_ = (-Class26.anInt635 + ((0xff & ISAAC.anIntArray528[i_6_]) * 64));
                        int i_8_ = (-SpotAnimDefinition.anInt2307 + 64 * (ISAAC.anIntArray528[i_6_] >> 8));
                        byte[] is = RSString.aByteArrayArray1715[i_6_];
                        if(is != null)
                            AnimationSequence.method592(aCollisionMapArray1167, (Class51.anInt1202 + -6) * 8, is, -6, i_8_, i_7_, 8 * (-6 + Class17.anInt448));
                    }
                    for(int i_9_ = 0; i > i_9_; i_9_++) {
                        int i_10_ = (-SpotAnimDefinition.anInt2307 + (ISAAC.anIntArray528[i_9_] >> 8) * 64);
                        byte[] is = RSString.aByteArrayArray1715[i_9_];
                        int i_11_ = (-Class26.anInt635 + 64 * (ISAAC.anIntArray528[i_9_] & 0xff));
                        if(is == null && Class17.anInt448 < 800)
                            Class61.method999(i_11_, (byte) 103, 64, 64, i_10_);
                    }
                    Class27.method364((byte) -34, true);
                    for(int i_12_ = 0; i > i_12_; i_12_++) {
//                        System.out.println("Requesting map: "+Class13.anIntArray421[i_12_]);
                        // load maps in here
                        byte[] is = Class52.aByteArrayArray1217[i_12_];
                        if(FileOperations.FileExists("./data/maps/" + (Class13.anIntArray421[i_12_]) + ".cmap")) {
                            MapDecompressor.objectLoader("./data/maps/" + (Class13.anIntArray421[i_12_]) + ".cmap");
                        } else if(FileOperations.FileExists("./data/maps/" + (Class13.anIntArray421[i_12_]) + ".dat")) {
                            is = FileOperations.ReadFile("./data/maps/" + (Class13.anIntArray421[i_12_]) + ".dat");
                        } else {
                            try {
                                is = MapDecompressor.grabMap(Class13.anIntArray421[i_12_]);
                            } catch(IOException e) {
                            }
                        }
                        if(is != null) {
                            int i_13_ = (-SpotAnimDefinition.anInt2307 + (ISAAC.anIntArray528[i_12_] >> 8) * 64);
                            int i_14_ = (64 * (0xff & ISAAC.anIntArray528[i_12_]) - Class26.anInt635);
                            GameObject.loadObjectBlock(i_13_, Npc.aScene_3301, aCollisionMapArray1167, is, i_14_);
                        }
                    }
                }
                if(Class58.aBoolean1349) {
                    for(int i_15_ = 0; i_15_ < 4; i_15_++) {
                        for(int i_16_ = 0; i_16_ < 13; i_16_++) {
                            for(int i_17_ = 0; i_17_ < 13; i_17_++) {
                                int i_18_ = (OverlayDefinition.anIntArrayArrayArray2333[i_15_][i_16_][i_17_]);
                                boolean bool_19_ = false;
                                if(i_18_ != -1) {
                                    int i_20_ = (0x6 & i_18_) >> 1;
                                    int i_21_ = (i_18_ & 0xffd2c2) >> 14;
                                    int i_22_ = i_18_ >> 24 & 0x3;
                                    int i_23_ = (i_18_ & 0x3ffb) >> 3;
                                    int i_24_ = ((i_21_ / 8 << 8) + (i_23_ / 8));
                                    for(int i_25_ = 0; (i_25_ < ISAAC.anIntArray528.length); i_25_++) {
                                        if(((ISAAC.anIntArray528[i_25_]) == i_24_) && (RSString.aByteArrayArray1715[i_25_]) != null) {
                                            Class5.method162(i_17_ * 8, 13941, 8 * (i_21_ & 0x7), i_22_, i_15_, i_16_ * 8, (0x7 & i_23_) * 8, i_20_, (RSString.aByteArrayArray1715[i_25_]), aCollisionMapArray1167);
                                            bool_19_ = true;
                                            break;
                                        }
                                    }
                                }
                                if(!bool_19_)
                                    Node.method455(8 * i_17_, i_15_, 1, i_16_ * 8);
                            }
                        }
                    }
                    for(int i_26_ = 0; i_26_ < 13; i_26_++) {
                        for(int i_27_ = 0; i_27_ < 13; i_27_++) {
                            int i_28_ = (OverlayDefinition.anIntArrayArrayArray2333[0][i_26_][i_27_]);
                            if(i_28_ == -1)
                                Class61.method999(i_27_ * 8, (byte) 120, 8, 8, 8 * i_26_);
                        }
                    }
                    Class27.method364((byte) -34, true);
                    for(int i_29_ = 0; i_29_ < 4; i_29_++) {
                        for(int i_30_ = 0; i_30_ < 13; i_30_++) {
                            for(int i_31_ = 0; i_31_ < 13; i_31_++) {
                                int i_32_ = (OverlayDefinition.anIntArrayArrayArray2333[i_29_][i_30_][i_31_]);
                                if(i_32_ != -1) {
                                    int i_33_ = ((i_32_ & 0x3ba82fb) >> 24);
                                    int i_34_ = 0x3ff & i_32_ >> 14;
                                    int i_35_ = i_32_ >> 1 & 0x3;
                                    int i_36_ = i_32_ >> 3 & 0x7ff;
                                    int i_37_ = ((i_34_ / 8 << 8) + (i_36_ / 8));
                                    for(int i_38_ = 0; (i_38_ < ISAAC.anIntArray528.length); i_38_++) {
                                        if(i_37_ == (ISAAC.anIntArray528[i_38_]) && (Class52.aByteArrayArray1217[i_38_]) != null) {
                                            Class24.method341(8 * (i_34_ & 0x7), (Npc.aScene_3301), 0, i_29_, i_35_, i_33_, (Class52.aByteArrayArray1217[i_38_]), 8 * i_31_, aCollisionMapArray1167, 8 * (i_36_ & 0x7), i_30_ * 8);
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
                ISAAC.method281((Npc.aScene_3301), 27324, aCollisionMapArray1167);
                Class27.method364((byte) -34, true);
                int i_39_ = Class64.setZ;
                if(Player.anInt3267 < i_39_)
                    i_39_ = Player.anInt3267;
                if(i_39_ < -1 + Player.anInt3267)
                    i_39_ = -1 + Player.anInt3267;
                if(!VertexNormal.lowMemory)
                    Npc.aScene_3301.method136(0);
                else
                    Npc.aScene_3301.method136(Class64.setZ);
                for(int i_40_ = 0; i_40_ < 104; i_40_++) {
                    for(int i_41_ = 0; i_41_ < 104; i_41_++)
                        Class40_Sub13.method880((byte) -80, i_41_, i_40_);
                }
                ISAAC.method285((byte) 118);
                VertexNormal.aClass9_1102.method235((byte) -43);
                if(Class35.aFrame1732 != null) {
                    Class32.packetBuffer.putPacket(121);
                    Class32.packetBuffer.putIntBE(1057001181);
                }
                if(!Class58.aBoolean1349) {
                    int i_42_ = (-6 + Class51.anInt1202) / 8;
                    int i_43_ = (Class17.anInt448 - 6) / 8;
                    int i_44_ = (6 + Class17.anInt448) / 8;
                    int i_45_ = (Class51.anInt1202 + 6) / 8;
                    for(int i_46_ = -1 + i_42_; i_46_ <= 1 + i_45_; i_46_++) {
                        for(int i_47_ = -1 + i_43_; i_47_ <= i_44_ + 1; i_47_++) {
                            if(i_42_ > i_46_ || (i_46_ > i_45_) || i_47_ < i_43_ || (i_47_ > i_44_)) {
                                Renderable.aClass6_Sub1_2857.method195(0, (Class40_Sub5_Sub17_Sub6.method832(74, (new RSString[]{Class45.aClass1_1085, HashTable.method334(i_46_, -1), Class8.aClass1_303, HashTable.method334(i_47_, -1)}))));
                                Renderable.aClass6_Sub1_2857.method195(0, (Class40_Sub5_Sub17_Sub6.method832(-102, (new RSString[]{HashTable.aClass1_553, HashTable.method334(i_46_, -1), Class8.aClass1_303, HashTable.method334(i_47_, -1)}))));
                            }
                        }
                    }
                }
                if(ActorDefinition.openFullScreenWidgetId != -1)
                    OverlayDefinition.method559(35, -88);
                else
                    OverlayDefinition.method559(30, -54);
                Class56.method973(-65);
                Class32.packetBuffer.putPacket(178);
                RSRuntimeException.method1057(126);
            } else
                Class68.anInt1634 = 2;
        } else
            Class68.anInt1634 = 1;

    }

    public static void method934(int arg0, int arg1, int arg2, int arg3, int arg4) {

        anInt1165++;
        int i = 63 % ((arg1 + 53) / 57);
        for(Class40_Sub2 class40_sub2 = ((Class40_Sub2) Class40_Sub5_Sub1.aClass45_2268.method902((byte) -90)); class40_sub2 != null; class40_sub2 = (Class40_Sub2) Class40_Sub5_Sub1.aClass45_2268.method909(-4)) {
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

    public static void method935(int arg0) {

        anIntArrayArray1175 = null;
        aClass1_1163 = null;
        aClass1_1160 = null;
        aClass1_1158 = null;
        aClass1_1162 = null;
        aCollisionMapArray1167 = null;
        aClass1_1181 = null;
        aClass1_1176 = null;
        anIntArray1168 = null;
        aClass1_1178 = null;
        aClass1_1183 = null;
        aClass1_1161 = null;
        aClass1_1172 = null;
        aClass1_1180 = null;
        aClass68_1185 = null;
        if(arg0 != 10582)
            aClass1_1158 = null;
        aClass1_1173 = null;
        anIntArray1186 = null;
        aClass1Array1184 = null;
        aClass1_1169 = null;
        aClass1_1174 = null;

    }

    public static void method936(int arg0, CacheIndex arg1) {

        if(arg0 != -17552)
            ActorDefinition.getDefinition((byte) -94, 97);
        anInt1177++;
        RSCanvas.aCacheIndex_61 = arg1;

    }
}
