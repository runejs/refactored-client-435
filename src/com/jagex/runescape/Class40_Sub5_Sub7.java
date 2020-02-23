package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class40_Sub5_Sub7 extends SubNode {
    public static int anInt2464;
    public static int anInt2465;
    public static int anInt2467;
    public static int anInt2468;
    public static int anInt2469;
    public static int anInt2471;
    public static RSString aClass1_2472 = RSString.CreateString(":tradereq:");
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2474;
    public static RSString aClass1_2475;
    public static int anInt2478;
    public static int anInt2480;
    public static RSString aClass1_2481 = (RSString.CreateString("Gegenstand konnte nicht gefunden werden)1 verk-Urzen Sie den Suchbegriff)3"));
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2482;
    public static CacheIndex aCacheIndex_2484;
    public static int anInt2486;
    public static RSString aClass1_2487;
    public static RSString aClass1_2488;
    public static int[][] anIntArrayArray2490;
    public static int anInt2491;
    public static int anInt2492;
    public static int anInt2493;

    static {
        anInt2480 = 0;
        aClass1_2488 = RSString.CreateString("titlebox");
        aClass1_2475 = RSString.CreateString("Bitte versuchen Sie es erneut)3");
        aClass1_2487 = RSString.CreateString("sch-Utteln:");
    }

    public int[] anIntArray2466;
    public int anInt2470 = -1;
    public int[] anIntArray2473;
    public int anInt2476 = -1;
    public int anInt2477;
    public int[] anIntArray2479;
    public int anInt2483 = 2;
    public int[] anIntArray2485;
    public int anInt2489;
    public int anInt2494;
    public int anInt2495;
    public boolean aBoolean2496;
    public int anInt2497;

    public Class40_Sub5_Sub7() {
        anInt2477 = -1;
        anInt2489 = -1;
        anInt2494 = 5;
        anInt2495 = 99;
        anInt2497 = -1;
        aBoolean2496 = false;
    }

    public static void method589(int arg0) {

        aClass1_2488 = null;
        aCacheIndex_2484 = null;
        aClass1_2475 = null;
        aClass40_Sub5_Sub14_Sub4_2482 = null;
        if(arg0 < 47)
            method592(null, 56, null, 0, -91, 58, -86);
        aClass1_2472 = null;
        aClass40_Sub5_Sub14_Sub4Array2474 = null;
        aClass1_2481 = null;
        aClass1_2487 = null;
        anIntArrayArray2490 = null;

    }

    public static void method592(CollisionMap[] arg0, int arg1, byte[] arg2, int arg3, int arg4, int arg5, int arg6) {

        anInt2492++;
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; (i_1_ ^ 0xffffffff) > -65; i_1_++) {
                for(int i_2_ = 0; (i_2_ ^ 0xffffffff) > -65; i_2_++) {
                    if((arg4 + i_1_ ^ 0xffffffff) < -1 && (i_1_ + arg4 ^ 0xffffffff) > -104 && arg5 + i_2_ > 0 && i_2_ + arg5 < 103)
                        arg0[i].anIntArrayArray150[i_1_ + arg4][(i_2_ + arg5)] = Class66.method1021((arg0[i].anIntArrayArray150[i_1_ + arg4][i_2_ + arg5]), -16777217);
                }
            }
        }
        Buffer class40_sub1 = new Buffer(arg2);
        if(arg3 == -6) {
            for(int i = 0; i < 4; i++) {
                for(int i_3_ = 0; i_3_ < 64; i_3_++) {
                    for(int i_4_ = 0; (i_4_ ^ 0xffffffff) > -65; i_4_++)
                        Class48.method922(i_3_ + arg4, 0, class40_sub1, -99, i_4_ + arg5, arg6, arg1, i);
                }
            }
        }

    }

    public static boolean method596(int arg0, int arg1, byte arg2, int arg3) {

        anInt2486++;
        int i = 0x7fff & arg1 >> 559212398;
        if(arg2 > -9)
            method596(-4, -74, (byte) -44, -62);
        int i_14_ = (Npc.aScene_3301.method141(Player.anInt3267, arg0, arg3, arg1));
        if(i_14_ == -1)
            return false;
        int i_15_ = 0x3 & i_14_ >> -1327198362;
        int i_16_ = 0x1f & i_14_;
        if(i_16_ != 10 && i_16_ != 11 && i_16_ != 22)
            Class38_Sub1.method448(0, 0, (Player.localPlayer.anIntArray3088[0]), arg0, (byte) 98, 1 + i_16_, true, i_15_, 0, (Player.localPlayer.anIntArray3135[0]), arg3, 2);
        else {
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
            int i_17_ = gameObjectDefinition.anInt2512;
            if(i_15_ != 0)
                i_17_ = (i_17_ >> 4 + -i_15_) + (0xf & i_17_ << i_15_);
            int i_18_;
            int i_19_;
            if(i_15_ == 0 || (i_15_ ^ 0xffffffff) == -3) {
                i_19_ = gameObjectDefinition.sizeY;
                i_18_ = gameObjectDefinition.sizeX;
            } else {
                i_18_ = gameObjectDefinition.sizeY;
                i_19_ = gameObjectDefinition.sizeX;
            }
            Class38_Sub1.method448(i_18_, i_17_, (Player.localPlayer.anIntArray3088[0]), arg0, (byte) 94, 0, true, 0, i_19_, (Player.localPlayer.anIntArray3135[0]), arg3, 2);
        }
        Class40_Sub11.anInt2163 = Class57.anInt1338;
        Class45.anInt1075 = 2;
        Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
        Floor.anInt2319 = 0;
        return true;

    }

    public Model method590(Model arg0, Class40_Sub5_Sub7 arg1, int arg2, int arg3, byte arg4) {

        arg2 = anIntArray2485[arg2];
        anInt2469++;
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg2 >> 1563712080);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method599(arg3, arg0, false);
        arg3 = arg1.anIntArray2485[arg3];
        Class40_Sub5_Sub15 class40_sub5_sub15_0_ = Class55.method960((byte) -99, arg3 >> -874318832);
        arg3 &= 0xffff;
        if(class40_sub5_sub15_0_ == null) {
            Model class40_sub5_sub17_sub5 = arg0.method817(!class40_sub5_sub15.method737(arg2, 124));
            class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg2);
            return class40_sub5_sub17_sub5;
        }
        if(arg4 != 63)
            return null;
        Model class40_sub5_sub17_sub5 = arg0.method817(!class40_sub5_sub15.method737(arg2, 122) & !class40_sub5_sub15_0_.method737(arg3, 123));
        class40_sub5_sub17_sub5.method809(class40_sub5_sub15, arg2, class40_sub5_sub15_0_, arg3, anIntArray2473);
        return class40_sub5_sub17_sub5;

    }

    public void method591(byte arg0) {

        if(anInt2476 == -1) {
            if(anIntArray2473 == null)
                anInt2476 = 0;
            else
                anInt2476 = 2;
        }
        int i = -117 / ((-76 - arg0) / 39);
        if(anInt2470 == -1) {
            if(anIntArray2473 == null)
                anInt2470 = 0;
            else
                anInt2470 = 2;
        }
        anInt2491++;

    }

    public Model method593(int arg0, boolean arg1, Model arg2, int arg3) {

        anInt2468++;
        arg0 = anIntArray2485[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg0 >> 1269230160);
        if(arg1 != false)
            anIntArray2479 = null;
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg2.method817(true);
        arg3 &= 0x3;
        Model class40_sub5_sub17_sub5 = arg2.method817(!class40_sub5_sub15.method737(arg0, 124));
        if((arg3 ^ 0xffffffff) == -2)
            class40_sub5_sub17_sub5.method824();
        else if(arg3 == 2)
            class40_sub5_sub17_sub5.method819();
        else if(arg3 == 3)
            class40_sub5_sub17_sub5.method813();
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg0);
        if((arg3 ^ 0xffffffff) != -2) {
            if((arg3 ^ 0xffffffff) != -3) {
                if(arg3 == 3)
                    class40_sub5_sub17_sub5.method824();
            } else
                class40_sub5_sub17_sub5.method819();
        } else
            class40_sub5_sub17_sub5.method813();
        return class40_sub5_sub17_sub5;

    }

    public void method594(int arg0, Buffer arg1) {
        anInt2464++;
        for(; ; ) {
            int i = arg1.getUnsignedByte();
            if((i ^ 0xffffffff) == -1)
                break;
            method595(-102, i, arg1);
        }
        if(arg0 != -1)
            anInt2470 = -80;
    }

    public void method595(int arg0, int arg1, Buffer arg2) {

        int i = 3 / ((arg0 + 12) / 51);
        anInt2465++;
        if(arg1 == 1) {
            int i_5_ = arg2.getUnsignedByte();
            anIntArray2466 = new int[i_5_];
            for(int i_6_ = 0; (i_5_ > i_6_); i_6_++)
                anIntArray2466[i_6_] = arg2.getUnsignedShortBE();
            anIntArray2485 = new int[i_5_];
            for(int i_7_ = 0; (i_5_ > i_7_); i_7_++)
                anIntArray2485[i_7_] = arg2.getUnsignedShortBE();
            for(int i_8_ = 0; (i_8_ < i_5_); i_8_++)
                anIntArray2485[i_8_] = ((arg2.getUnsignedShortBE() << -1678933328) + anIntArray2485[i_8_]);
        } else if((arg1 ^ 0xffffffff) == -3)
            anInt2497 = arg2.getUnsignedShortBE();
        else if(arg1 != 3) {
            if((arg1 ^ 0xffffffff) != -5) {
                if((arg1 ^ 0xffffffff) == -6)
                    anInt2494 = arg2.getUnsignedByte();
                else if(arg1 != 6) {
                    if(arg1 != 7) {
                        if((arg1 ^ 0xffffffff) == -9)
                            anInt2495 = arg2.getUnsignedByte();
                        else if(arg1 == 9)
                            anInt2470 = arg2.getUnsignedByte();
                        else if(arg1 != 10) {
                            if((arg1 ^ 0xffffffff) == -12)
                                anInt2483 = arg2.getUnsignedByte();
                            else if((arg1 ^ 0xffffffff) == -13) {
                                int i_9_ = arg2.getUnsignedByte();
                                anIntArray2479 = new int[i_9_];
                                for(int i_10_ = 0; ((i_10_ < i_9_)); i_10_++)
                                    anIntArray2479[i_10_] = arg2.getUnsignedShortBE();
                                for(int i_11_ = 0; ((i_9_ > i_11_)); i_11_++)
                                    anIntArray2479[i_11_] = ((arg2.getUnsignedShortBE() << -416587984) + anIntArray2479[i_11_]);
                            }
                        } else
                            anInt2476 = arg2.getUnsignedByte();
                    } else
                        anInt2489 = arg2.getUnsignedShortBE();
                } else
                    anInt2477 = arg2.getUnsignedShortBE();
            } else
                aBoolean2496 = true;
        } else {
            int i_12_ = arg2.getUnsignedByte();
            anIntArray2473 = new int[1 + i_12_];
            for(int i_13_ = 0; i_12_ > i_13_; i_13_++)
                anIntArray2473[i_13_] = arg2.getUnsignedByte();
            anIntArray2473[i_12_] = 9999999;
        }

    }

    public Model method597(byte arg0, Model arg1, int arg2) {

        arg2 = anIntArray2485[arg2];
        anInt2467++;
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg2 >> 1539434320);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method806(true);
        if(arg0 != -87)
            return null;
        Model class40_sub5_sub17_sub5 = arg1.method806(!class40_sub5_sub15.method737(arg2, 124));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg2);
        return class40_sub5_sub17_sub5;

    }

    public Model method598(int arg0, Model arg1, boolean arg2) {

        anInt2493++;
        int i = anIntArray2485[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, i >> 189349456);
        i &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        if(arg2 != true)
            method594(98, null);
        Class40_Sub5_Sub15 class40_sub5_sub15_20_ = null;
        int i_21_ = 0;
        if(anIntArray2479 != null && arg0 < anIntArray2479.length) {
            i_21_ = anIntArray2479[arg0];
            class40_sub5_sub15_20_ = Class55.method960((byte) -99, i_21_ >> -878340016);
            i_21_ &= 0xffff;
        }
        if(class40_sub5_sub15_20_ == null || (i_21_ ^ 0xffffffff) == -65536) {
            Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(i, 126));
            class40_sub5_sub17_sub5.method825(class40_sub5_sub15, i);
            return class40_sub5_sub17_sub5;
        }
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(i, 121) & !class40_sub5_sub15_20_.method737(i_21_, 123));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, i);
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15_20_, i_21_);
        return class40_sub5_sub17_sub5;

    }

    public Model method599(int arg0, Model arg1, boolean arg2) {

        if(arg2 != false)
            method591((byte) -78);
        arg0 = anIntArray2485[arg0];
        anInt2471++;
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg0 >> 1994825616);
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(arg0, 126));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg0);
        return class40_sub5_sub17_sub5;

    }
}
