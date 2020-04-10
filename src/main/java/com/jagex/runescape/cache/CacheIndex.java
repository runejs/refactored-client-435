package com.jagex.runescape.cache;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.io.DataInputStream;
import java.net.URL;

public abstract class CacheIndex {
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array215;
    public static long aLong219 = 0L;
    public static Cache modelCache = new Cache(260);
    public static int anInt255;
    public static RSString aClass1_256 = RSString.CreateString("backbase2");
    public static RSString aClass1_257 = RSString.CreateString("Please try again)3");
    public static RSString aClass1_258 = aClass1_257;
    public static boolean aBoolean260 = false;
    public static int[][][] anIntArrayArrayArray262;

    public byte[][] aByteArrayArray212;
    public int anInt216;
    public Class42[] aClass42Array217;
    public boolean aBoolean220;
    public int anInt221;
    public int anInt1807;
    public int[] anIntArray224;
    public int[] anIntArray227;
    public boolean aBoolean233;
    public int[][] anIntArrayArray236;
    public int[] anIntArray239;
    public int[][] anIntArrayArray243;
    public byte[][][] aByteArrayArrayArray249;
    public int[] anIntArray252;
    public Class42 aClass42_254;
    public int[] anIntArray261;

    public CacheIndex(boolean arg0, boolean arg1) {
        aBoolean220 = arg1;
        aBoolean233 = arg0;
    }

    public static void method169(String arg0, byte arg1, Throwable arg2) {
        do {
            try {
                String string = "";
                if(arg2 != null)
                    string = Class55.method959(0, arg2);
                if(arg0 != null) {
                    if(arg2 != null)
                        string += " | ";
                    string += arg0;
                }
                System.out.println("Error: " + string);
                string = string.replace(':', '.');
                string = string.replace('@', '_');
                if(arg1 > -119)
                    method189(true);
                string = string.replace('&', '_');
                string = string.replace('#', '_');
                SignlinkNode signlinkNode = (Actor.aClass31_3152.method388(false, new URL(Actor.aClass31_3152.anApplet740.getCodeBase(), ("clienterror.ws?c=" + Class39.anInt901 + "&u=" + Class34.aLong853 + "&v1=" + Signlink.aString735 + "&v2=" + Signlink.aString739 + "&e=" + string))));
                while(signlinkNode.anInt434 == 0)
                    Class43.method890(1L, -74);
                if(signlinkNode.anInt434 != 1)
                    break;
                DataInputStream datainputstream = (DataInputStream) signlinkNode.value;
                datainputstream.read();
                datainputstream.close();
            } catch(Exception exception) {
                break;
            }
            break;
        } while(false);
    }

    public static void method180() {
        aClass40_Sub5_Sub14_Sub2Array215 = null;
        aClass1_256 = null;
        modelCache = null;
        aClass1_257 = null;
        Player.deregisterActorIndices = null;
        anIntArrayArrayArray262 = null;
        aClass1_258 = null;
    }

    public static void method184(byte[] arg0, int arg1) {
        Buffer class40_sub1 = new Buffer(arg0);
        class40_sub1.currentPosition = -2 + arg0.length;
        UnderlayDefinition.anInt2581 = class40_sub1.getUnsignedShortBE();
        Actor.anIntArray3111 = new int[UnderlayDefinition.anInt2581];
        GroundItemTile.aByteArrayArray1370 = new byte[UnderlayDefinition.anInt2581][];
        Class17.anIntArray456 = new int[UnderlayDefinition.anInt2581];
        Npc.anIntArray3312 = new int[UnderlayDefinition.anInt2581];
        Class57.anIntArray1347 = new int[UnderlayDefinition.anInt2581];
        class40_sub1.currentPosition = arg0.length + -7 + -(UnderlayDefinition.anInt2581 * 8);
        ItemDefinition.anInt2846 = class40_sub1.getUnsignedShortBE();
        GameShell.anInt31 = class40_sub1.getUnsignedShortBE();
        int i = 1 + (class40_sub1.getUnsignedByte() & 0xff);
        for(int i_34_ = 0; ((i_34_ < UnderlayDefinition.anInt2581)); i_34_++)
            Class57.anIntArray1347[i_34_] = class40_sub1.getUnsignedShortBE();
        for(int i_35_ = arg1; i_35_ < UnderlayDefinition.anInt2581; i_35_++)
            Actor.anIntArray3111[i_35_] = class40_sub1.getUnsignedShortBE();
        for(int i_36_ = 0; i_36_ < UnderlayDefinition.anInt2581; i_36_++)
            Class17.anIntArray456[i_36_] = class40_sub1.getUnsignedShortBE();
        for(int i_37_ = 0; UnderlayDefinition.anInt2581 > i_37_; i_37_++)
            Npc.anIntArray3312[i_37_] = class40_sub1.getUnsignedShortBE();
        class40_sub1.currentPosition = arg0.length - (7 + (UnderlayDefinition.anInt2581 * 8 + (-3 + i * 3)));
        Buffer.anIntArray1972 = new int[i];
        for(int i_38_ = 1; (i > i_38_); i_38_++) {
            Buffer.anIntArray1972[i_38_] = class40_sub1.getMediumBE();
            if(Buffer.anIntArray1972[i_38_] == 0)
                Buffer.anIntArray1972[i_38_] = 1;
        }
        class40_sub1.currentPosition = 0;
        for(int i_39_ = 0; UnderlayDefinition.anInt2581 > i_39_; i_39_++) {
            int i_40_ = Npc.anIntArray3312[i_39_];
            int i_41_ = Class17.anIntArray456[i_39_];
            int i_42_ = i_40_ * i_41_;
            byte[] is = new byte[i_42_];
            GroundItemTile.aByteArrayArray1370[i_39_] = is;
            int i_43_ = class40_sub1.getUnsignedByte();
            if(i_43_ == 0) {
                for(int i_46_ = 0; (i_42_ > i_46_); i_46_++)
                    is[i_46_] = class40_sub1.getByte();
            } else if(i_43_ == 1) {
                for(int i_44_ = 0; (i_41_ > i_44_); i_44_++) {
                    for(int i_45_ = 0; i_40_ > i_45_; i_45_++)
                        is[i_41_ * i_45_ + i_44_] = class40_sub1.getByte();
                }
            }
        }
    }

    public static void method188() {
        Class40_Sub5_Sub6.aClass9_2439.method235((byte) 95);
        Class42.aClass9_998.method235((byte) -90);
    }

    public static void method189(boolean arg0) {
        if(arg0)
            Player.deregisterActorIndices = null;
        WallDecoration.aClass9_1247.method235((byte) 59);
    }

    public byte[] method170(RSString arg0, RSString arg1, int arg2) {
        if(arg2 != 1)
            method186(-26, 53);
        arg1 = arg1.toLowerCase();
        arg0 = arg0.toLowerCase();
        int i = aClass42_254.method882(arg1.method76());
        int i_0_ = aClass42Array217[i].method882(arg0.method76());

        return getFile(i_0_, i);
    }

    public void method171(int arg0, int arg1) {
        int i = 0;
        if(arg0 == 1) {
            for(/**/; ((i < aByteArrayArrayArray249[arg1].length)); i++)
                aByteArrayArrayArray249[arg1][i] = null;
        }
    }

    public byte[] getFile(int arg0, int arg2) {
        //if(this instanceof CacheIndex_Sub1)
        //    System.out.printf("Request cache arch: %d index: %d, file: %d\n", this.anInt1807, arg0, arg2);
        return method176(arg2, arg0, null);
    }

    public boolean loaded(int arg0, int arg2) {
        if(arg0 < 0 || (arg0 >= aByteArrayArrayArray249.length) || aByteArrayArrayArray249[arg0] == null || arg2 < 0 || arg2 >= aByteArrayArrayArray249[arg0].length)
            return false;
        if(aByteArrayArrayArray249[arg0][arg2] != null)
            return true;
        if(aByteArrayArray212[arg0] != null)
            return true;
        method177(122, arg0);
        return aByteArrayArray212[arg0] != null;
    }

    public void method174(int arg0, byte arg1) {
    }

    public int method175(int arg0) {
        if(arg0 > -7)
            aBoolean260 = true;
        return aByteArrayArrayArray249.length;
    }

    public byte[] method176(int arg0, int arg1, int[] arg2) {
        if(arg0 < 0 || (arg0 >= aByteArrayArrayArray249.length) || aByteArrayArrayArray249[arg0] == null || arg1 < 0 || arg1 >= aByteArrayArrayArray249[arg0].length)
            return null;
        if(aByteArrayArrayArray249[arg0][arg1] == null) {
            boolean bool = method181(arg0, arg2);
            if(!bool) {
                method177(33, arg0);
                bool = method181(arg0, arg2);
                if(!bool)
                    return null;
            }
        }
        byte[] is = aByteArrayArrayArray249[arg0][arg1];
        if(aBoolean220)
            aByteArrayArrayArray249[arg0][arg1] = null;
        return is;
    }

    public void method177(int arg0, int arg1) {
        if(arg0 < 1)
            method181(22, null);
    }

    public void method178(byte[] arg1) {
        anInt216 = Class40_Sub2.method525(arg1, arg1.length, (byte) -68);
        Buffer class40_sub1 = new Buffer(Landscape.method931(arg1));
        int i = class40_sub1.getUnsignedByte();
        if(i == 5) {
            int i_1_ = 0;
            int i_2_ = class40_sub1.getUnsignedByte();
            anInt221 = class40_sub1.getUnsignedShortBE();
            anIntArray227 = new int[anInt221];
            int i_3_ = -1;
            for(int i_4_ = 0; anInt221 > i_4_; i_4_++) {
                anIntArray227[i_4_] = i_1_ += class40_sub1.getUnsignedShortBE();
                if((anIntArray227[i_4_] > i_3_))
                    i_3_ = anIntArray227[i_4_];
            }
            anIntArrayArray243 = new int[i_3_ + 1][];
            anIntArray224 = new int[1 + i_3_];
            anIntArray252 = new int[i_3_ + 1];
            aByteArrayArrayArray249 = new byte[1 + i_3_][][];
            anIntArray261 = new int[1 + i_3_];
            aByteArrayArray212 = new byte[i_3_ + 1][];
            if(i_2_ != 0) {
                anIntArray239 = new int[i_3_ + 1];
                for(int i_5_ = 0; (anInt221 > i_5_); i_5_++)
                    anIntArray239[anIntArray227[i_5_]] = class40_sub1.getIntBE();
                aClass42_254 = new Class42(anIntArray239);
            }
            for(int i_6_ = 0; i_6_ < anInt221; i_6_++)
                anIntArray252[anIntArray227[i_6_]] = class40_sub1.getIntBE();
            for(int i_7_ = 0; i_7_ < anInt221; i_7_++)
                anIntArray224[anIntArray227[i_7_]] = class40_sub1.getIntBE();
            for(int i_8_ = 0; (anInt221 > i_8_); i_8_++)
                anIntArray261[anIntArray227[i_8_]] = class40_sub1.getUnsignedShortBE();
            for(int i_9_ = 0; (i_9_ < anInt221); i_9_++) {
                i_1_ = 0;
                int i_10_ = anIntArray227[i_9_];
                int i_11_ = -1;
                int i_12_ = anIntArray261[i_10_];
                anIntArrayArray243[i_10_] = new int[i_12_];
                for(int i_13_ = 0; i_12_ > i_13_; i_13_++) {
                    int i_14_ = (anIntArrayArray243[i_10_][i_13_] = i_1_ += (class40_sub1.getUnsignedShortBE()));
                    if(i_14_ > i_11_)
                        i_11_ = i_14_;
                }
                aByteArrayArrayArray249[i_10_] = new byte[i_11_ + 1][];
            }
            if(i_2_ != 0) {
                aClass42Array217 = new Class42[i_3_ + 1];
                anIntArrayArray236 = new int[1 + i_3_][];
                for(int i_15_ = 0; (anInt221 > i_15_); i_15_++) {
                    int i_16_ = anIntArray227[i_15_];
                    int i_17_ = anIntArray261[i_16_];
                    anIntArrayArray236[i_16_] = new int[aByteArrayArrayArray249[i_16_].length];
                    for(int i_18_ = 0; i_17_ > i_18_; i_18_++)
                        anIntArrayArray236[i_16_][(anIntArrayArray243[i_16_][i_18_])] = class40_sub1.getIntBE();
                    aClass42Array217[i_16_] = new Class42(anIntArrayArray236[i_16_]);
                }
            }
        }
    }

    public int method179(int arg1, RSString arg2) {
        arg2 = arg2.toLowerCase();
        return aClass42Array217[arg1].method882(arg2.method76());
    }

    public boolean method181(int arg0, int[] arg2) {
        if(aByteArrayArray212[arg0] == null)
            return false;
        int i = anIntArray261[arg0];
        byte[][] is = aByteArrayArrayArray249[arg0];
        int[] is_19_ = anIntArrayArray243[arg0];
        boolean bool = true;
        for(int i_20_ = 0; i_20_ < i; i_20_++) {
            if(is[is_19_[i_20_]] == null) {
                bool = false;
                break;
            }
        }
        if(bool)
            return true;
        byte[] is_21_;
        if(arg2 == null || (arg2[0] == 0 && arg2[1] == 0 && arg2[2] == 0 && arg2[3] == 0))
            is_21_ = aByteArrayArray212[arg0];
        else {
            is_21_ = new byte[aByteArrayArray212[arg0].length];
            Class18.method278(aByteArrayArray212[arg0], 0, is_21_, 0, is_21_.length);
            Buffer class40_sub1 = new Buffer(is_21_);
            class40_sub1.method483(arg2, class40_sub1.buffer.length, 5);
        }
        byte[] is_22_;
        is_22_ = Landscape.method931(is_21_);
        if(aBoolean233)
            aByteArrayArray212[arg0] = null;
        if(i > 1) {
            int i_23_ = is_22_.length;
            int i_24_ = is_22_[--i_23_] & 0xff;
            Buffer class40_sub1 = new Buffer(is_22_);
            i_23_ -= 4 * (i_24_ * i);
            class40_sub1.currentPosition = i_23_;
            int[] is_25_ = new int[i];
            for(int i_26_ = 0; (i_24_ > i_26_); i_26_++) {
                int i_27_ = 0;
                for(int i_28_ = 0; (i_28_ < i); i_28_++) {
                    i_27_ += class40_sub1.getIntBE();
                    is_25_[i_28_] += i_27_;
                }
            }
            for(int i_29_ = 0; (i_29_ < i); i_29_++) {
                if(is[is_19_[i_29_]] == null)
                    is[is_19_[i_29_]] = new byte[is_25_[i_29_]];
                is_25_[i_29_] = 0;
            }
            class40_sub1.currentPosition = i_23_;
            int i_30_ = 0;
            for(int i_31_ = 0; (i_24_ > i_31_); i_31_++) {
                int i_32_ = 0;
                for(int i_33_ = 0; i_33_ < i; i_33_++) {
                    i_32_ += class40_sub1.getIntBE();
                    Class18.method278(is_22_, i_30_, is[is_19_[i_33_]], is_25_[i_33_], i_32_);
                    is_25_[i_33_] += i_32_;
                    i_30_ += i_32_;
                }
            }
        } else
            is[is_19_[0]] = is_22_;
        return true;
    }

    public byte[] method182(int arg0, int arg2) {
        if(arg2 < 0 || (arg2 >= aByteArrayArrayArray249.length) || aByteArrayArrayArray249[arg2] == null || arg0 < 0 || aByteArrayArrayArray249[arg2].length <= arg0)
            return null;
        if(aByteArrayArrayArray249[arg2][arg0] == null) {
            boolean bool = method181(arg2, null);
            if(!bool) {
                method177(45, arg2);
                bool = method181(arg2, null);
                if(!bool)
                    return null;
            }
        }
        byte[] is = aByteArrayArrayArray249[arg2][arg0];
        return is;
    }

    public int getHash(RSString arg1) {
        arg1 = arg1.toLowerCase();
        return aClass42_254.method882(arg1.method76());
    }

    public boolean method185(byte arg0) {
        boolean bool = true;
        if(arg0 < 11)
            return true;
        for(int i = 0; i < anIntArray227.length; i++) {
            int i_47_ = anIntArray227[i];
            if(aByteArrayArray212[i_47_] == null) {
                method177(59, i_47_);
                if(aByteArrayArray212[i_47_] == null)
                    bool = false;
            }
        }
        return bool;
    }

    public boolean method186(int arg0, int arg1) {
        if(aByteArrayArray212[arg1] != null)
            return true;
        method177(74, arg1);
        if(aByteArrayArray212[arg1] != null)
            return true;
        if(arg0 < 102)
            aLong219 = 119L;
        return false;
    }

    public byte[] method187(int arg0) {
        if(aByteArrayArrayArray249.length == 1)
            return getFile(arg0, 0);
        if(aByteArrayArrayArray249[arg0].length == 1)
            return getFile(0, arg0);
        throw new RuntimeException();
    }

    public int method190(int arg0) {
        return aByteArrayArrayArray249[arg0].length;
    }

    public void method191(int arg0) {
        for(int i = 0; i < aByteArrayArrayArray249.length; i++) {
            if(aByteArrayArrayArray249[i] != null) {
                for(int i_48_ = 0; ((i_48_ < aByteArrayArrayArray249[i].length)); i_48_++)
                    aByteArrayArrayArray249[i][i_48_] = null;
            }
        }
        if(arg0 != 1120)
            method186(-112, 82);
    }

    public int[] method192(int arg0, boolean arg1) {
        if(!arg1)
            return null;
        return anIntArrayArray243[arg0];
    }

    public byte[] method193(byte arg0, int arg1) {
        if(aByteArrayArrayArray249.length == 1)
            return method182(arg1, 0);
        if(aByteArrayArrayArray249[arg1].length == 1)
            return method182(0, arg1);
        if(arg0 < 17)
            aClass1_257 = null;
        throw new RuntimeException();
    }

    public boolean method194(RSString arg0, RSString arg1, int arg2) {
        if(arg2 != -1234)
            anIntArray261 = null;
        arg0 = arg0.toLowerCase();
        arg1 = arg1.toLowerCase();
        int i = aClass42_254.method882(arg0.method76());
        int i_49_ = aClass42Array217[i].method882(arg1.method76());
        return loaded(i, i_49_);
    }

    public void method195(int arg0, RSString arg1) {
        arg1 = arg1.toLowerCase();
        int i = aClass42_254.method882(arg1.method76());
        if(arg0 == 0 && i >= 0)
            method174(i, (byte) 2);
    }
}
