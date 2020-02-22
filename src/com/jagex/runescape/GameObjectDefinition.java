package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;

public class GameObjectDefinition extends SubNode {
    public static Class68 aClass68_2524;
    public static RSString aClass1_2526 = Class58.method978("(Udns");
    public static int anInt2543 = 0;
    public static HashTable aClass23_2545 = new HashTable(4096);
    public static RSString aClass1_2556 = Class58.method978("blaugr-Un:");
    public static int chatboxScroll = 0;
    public static int anInt2558 = 0;
    public static int anInt2559 = 0;
    public static RSString aClass1_2560 = Class58.method978(": ");
    public static long aLong2561 = 0L;

    public int anInt2499;
    public int anInt2500;
    public boolean solid;
    public int anInt2502;
    public int anInt2503;
    public int anInt2504;
    public int anInt2505;
    public int animationId;
    public int anInt2507;
    public RSString[] aClass1Array2508;
    public int[] anIntArray2510;
    public int anInt2511 = -1;
    public int anInt2512;
    public int anInt2513;
    public int anInt2515;
    public int[] anIntArray2516;
    public int anInt2517;
    public boolean aBoolean2518;
    public int anInt2519;
    public boolean nonFlatShading;
    public boolean aBoolean2521;
    public int[] anIntArray2522;
    public int[] anIntArray2523;
    public int[] anIntArray2525;
    public int anInt2527;
    public boolean aBoolean2528;
    public boolean adjustToTerrain;
    public int anInt2533;
    public int[] childrenIds;
    public int anInt2536;
    public int anInt2537;
    public int anInt2538;
    public int anInt2540;
    public boolean aBoolean2541;
    public int anInt2542;
    public int anInt2544;
    public int hasActions;
    public boolean unknown;
    public int anInt2548;
    public RSString aClass1_2549;
    public boolean aBoolean2553;

    public GameObjectDefinition() {
        anInt2502 = 0;
        anInt2512 = 0;
        anInt2513 = -1;
        anInt2499 = 0;
        anInt2500 = 0;
        anInt2507 = 128;
        aBoolean2518 = false;
        aBoolean2521 = false;
        adjustToTerrain = false;
        anInt2533 = -1;
        animationId = -1;
        anInt2505 = 16;
        aClass1Array2508 = new RSString[5];
        anInt2519 = 0;
        solid = true;
        anInt2515 = 1;
        anInt2542 = 0;
        anInt2504 = 0;
        nonFlatShading = false;
        anInt2537 = -1;
        aBoolean2528 = true;
        anInt2503 = 1;
        unknown = false;
        anInt2540 = 128;
        aClass1_2549 = Class44.aClass1_1043;
        aBoolean2541 = true;
        anInt2544 = 0;
        anInt2536 = -1;
        aBoolean2553 = false;
        anInt2548 = -1;
        hasActions = -1;
        anInt2527 = 0;
        anInt2517 = 128;
    }

    public static void method602(Class6_Sub1 arg0, int arg1, Class56 arg2, byte arg3) {

        byte[] is = null;
        synchronized(RSCanvas.aClass45_53) {
            for(Class40_Sub6 class40_sub6 = ((Class40_Sub6) RSCanvas.aClass45_53.method902((byte) -90)); class40_sub6 != null; class40_sub6 = ((Class40_Sub6) RSCanvas.aClass45_53.method909(-4))) {
                if(((class40_sub6.key ^ 0xffffffffffffffffL) == ((long) arg1 ^ 0xffffffffffffffffL)) && arg2 == class40_sub6.aClass56_2117 && (class40_sub6.anInt2112 ^ 0xffffffff) == -1) {
                    is = class40_sub6.aByteArray2102;
                    break;
                }
            }
        }
        if(is != null)
            arg0.method198((byte) -115, true, is, arg1, arg2);
        else {
            if(arg3 > -91)
                chatboxScroll = -20;
            byte[] is_6_ = arg2.method969(arg1, (byte) 103);
            arg0.method198((byte) -115, true, is_6_, arg1, arg2);
        }

    }

    public static void method604(boolean arg0) {

        aClass23_2545 = null;
        aClass1_2556 = null;
        aClass1_2560 = null;
        aClass1_2526 = null;
        if(arg0 != true)
            aClass1_2560 = null;
        aClass68_2524 = null;

    }

    public static void method609(int arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {

        Class40_Sub3 class40_sub3 = null;
        for(Class40_Sub3 class40_sub3_24_ = ((Class40_Sub3) Class45.aClass45_1064.method902((byte) -90)); class40_sub3_24_ != null; class40_sub3_24_ = (Class40_Sub3) Class45.aClass45_1064.method909(-4)) {
            if(class40_sub3_24_.anInt2018 == arg5 && arg2 == class40_sub3_24_.anInt2039 && (arg6 ^ 0xffffffff) == (class40_sub3_24_.anInt2038 ^ 0xffffffff) && (arg7 ^ 0xffffffff) == (class40_sub3_24_.anInt2027 ^ 0xffffffff)) {
                class40_sub3 = class40_sub3_24_;
                break;
            }
        }
        if(class40_sub3 == null) {
            class40_sub3 = new Class40_Sub3();
            class40_sub3.anInt2039 = arg2;
            class40_sub3.anInt2027 = arg7;
            class40_sub3.anInt2018 = arg5;
            class40_sub3.anInt2038 = arg6;
            Class39.method451(class40_sub3, 19813);
            Class45.aClass45_1064.method904(class40_sub3, 97);
        }
        class40_sub3.anInt2017 = arg0;
        class40_sub3.anInt2031 = arg4;
        class40_sub3.anInt2033 = arg9;
        if(arg1 != true)
            method602(null, 77, null, (byte) -89);
        class40_sub3.anInt2035 = arg3;
        class40_sub3.anInt2030 = arg8;

    }

    public static GameObjectDefinition getDefinition(int arg0) {
        GameObjectDefinition gameObjectDefinition = ((GameObjectDefinition) Class58.aClass9_1364.method231((long) arg0, (byte) 61));
        SceneTile.anInt2040++;
        if(gameObjectDefinition != null)
            return gameObjectDefinition;
        byte[] is = Class40_Sub3.aClass6_2037.method172(arg0, 113, 6);
        gameObjectDefinition = new GameObjectDefinition();
        gameObjectDefinition.anInt2538 = arg0;
        if(is != null)
            gameObjectDefinition.method603(new Buffer(is), -122);
        gameObjectDefinition.method605(true);
        if(gameObjectDefinition.aBoolean2518) {
            gameObjectDefinition.solid = false;
            gameObjectDefinition.aBoolean2528 = false;
        }
        Class58.aClass9_1364.method230(-7208, (long) arg0, gameObjectDefinition);
        return gameObjectDefinition;

    }

    public Model getGameObjectModel(int arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6) {
        long l;
        if(anIntArray2522 == null)
            l = (long) ((anInt2538 << 1723242090) + arg2);
        else
            l = (long) (arg2 + ((anInt2538 << -855239862) + (arg4 << 399635491)));
        if(arg5 != 124)
            aClass1Array2508 = null;
        Model model = ((Model) Class19.aClass9_470.method231(l, (byte) 87));
        if(model == null) {
            model = method606(!nonFlatShading, (byte) -61, false, arg2, arg4);
            if(model == null)
                return null;
            Class19.aClass9_470.method230(-7208, l, model);
        }
        if(adjustToTerrain || nonFlatShading)
            model = new Model(adjustToTerrain, nonFlatShading, model);
        if(adjustToTerrain) {
            int i = (arg0 + arg6 + (arg3 + arg1)) / 4;
            for(int i_0_ = 0; model.vertexCount > i_0_; i_0_++) {
                int i_1_ = model.verticesX[i_0_];
                int i_2_ = model.verticesZ[i_0_];
                int i_3_ = arg3 + ((64 + i_1_) * (arg6 + -arg3) / 128);
                int i_4_ = arg1 + ((64 + i_1_) * (-arg1 + arg0) / 128);
                int i_5_ = i_3_ + (i_2_ + 64) * (-i_3_ + i_4_) / 128;
                model.verticesY[i_0_] += i_5_ + -i;
            }
        }
        return model;

    }

    public boolean method601(byte arg0) {

        if(childrenIds == null) {
            return (anInt2513 ^ 0xffffffff) != 0 || anIntArray2523 != null;
        }
        if(arg0 != 125)
            anInt2548 = -89;
        for(int i = 0; i < childrenIds.length; i++) {
            if((childrenIds[i] ^ 0xffffffff) != 0) {
                GameObjectDefinition gameObjectDefinition = getDefinition(childrenIds[i]);
                if((gameObjectDefinition.anInt2513 ^ 0xffffffff) != 0 || gameObjectDefinition.anIntArray2523 != null)
                    return true;
            }
        }
        return false;

    }

    public void method603(Buffer arg0, int arg1) {
        for(; ; ) {
            int i = arg0.getUnsignedByte();
            if((i ^ 0xffffffff) == -1)
                break;
            method608(arg0, -1663, i);
        }
        if(arg1 > -46)
            anInt2505 = -102;
    }

    public void method605(boolean arg0) {
        if((hasActions ^ 0xffffffff) == 0) {
            hasActions = 0;
            if(anIntArray2525 != null && (anIntArray2522 == null || (anIntArray2522[0] ^ 0xffffffff) == -11))
                hasActions = 1;
            for(int i = 0; (i ^ 0xffffffff) > -6; i++) {
                if(aClass1Array2508[i] != null)
                    hasActions = 1;
            }
        }
        if((anInt2533 ^ 0xffffffff) == 0)
            anInt2533 = solid ? 1 : 0;
        if(arg0 != true)
            method603(null, -36);
    }

    public Model method606(boolean arg0, byte arg1, boolean arg2, int arg3, int arg4) {

        Model class40_sub5_sub17_sub5 = null;
        if(anIntArray2522 == null) {
            if(arg4 != 10)
                return null;
            if(anIntArray2525 == null)
                return null;
            boolean bool = arg3 > 3 ^ aBoolean2553;
            int i = anIntArray2525.length;
            for(int i_7_ = 0; i > i_7_; i_7_++) {
                int i_8_ = anIntArray2525[i_7_];
                if(bool)
                    i_8_ += 65536;
                class40_sub5_sub17_sub5 = ((Model) VertexNormal.aClass9_1102.method231((long) i_8_, (byte) 122));
                if(class40_sub5_sub17_sub5 == null) {
                    class40_sub5_sub17_sub5 = (Model.getModel(RSString.aClass6_1705, i_8_ & 0xffff, 0));
                    if(class40_sub5_sub17_sub5 == null)
                        return null;
                    if(bool)
                        class40_sub5_sub17_sub5.method818();
                    VertexNormal.aClass9_1102.method230(-7208, (long) i_8_, class40_sub5_sub17_sub5);
                }
                if(i > 1)
                    Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub5Array2762[i_7_] = class40_sub5_sub17_sub5;
            }
            if((i ^ 0xffffffff) < -2)
                class40_sub5_sub17_sub5 = (new Model((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub5Array2762), i));
        } else {
            int i = -1;
            for(int i_9_ = 0; ((anIntArray2522.length ^ 0xffffffff) < (i_9_ ^ 0xffffffff)); i_9_++) {
                if(arg4 == anIntArray2522[i_9_]) {
                    i = i_9_;
                    break;
                }
            }
            if(i == -1)
                return null;
            int i_10_ = anIntArray2525[i];
            boolean bool = aBoolean2553 ^ arg3 > 3;
            if(bool)
                i_10_ += 65536;
            class40_sub5_sub17_sub5 = ((Model) VertexNormal.aClass9_1102.method231((long) i_10_, (byte) 48));
            if(class40_sub5_sub17_sub5 == null) {
                class40_sub5_sub17_sub5 = Model.getModel((RSString.aClass6_1705), 0xffff & i_10_, 0);
                if(class40_sub5_sub17_sub5 == null)
                    return null;
                if(bool)
                    class40_sub5_sub17_sub5.method818();
                VertexNormal.aClass9_1102.method230(-7208, (long) i_10_, class40_sub5_sub17_sub5);
            }
        }
        boolean bool;
        bool = anInt2507 != 128 || anInt2540 != 128 || anInt2517 != 128;
        boolean bool_11_;
        bool_11_ = (anInt2500 ^ 0xffffffff) != -1 || anInt2519 != 0 || anInt2504 != 0;
        Model class40_sub5_sub17_sub5_12_ = new Model(class40_sub5_sub17_sub5, arg3 == 0 && !bool && !bool_11_, anIntArray2516 == null, true);
        arg3 &= 0x3;
        if((arg3 ^ 0xffffffff) != -2) {
            if((arg3 ^ 0xffffffff) != -3) {
                if(arg3 == 3)
                    class40_sub5_sub17_sub5_12_.method824();
            } else
                class40_sub5_sub17_sub5_12_.method819();
        } else
            class40_sub5_sub17_sub5_12_.method813();
        if(anIntArray2516 != null) {
            for(int i = 0; i < anIntArray2516.length; i++)
                class40_sub5_sub17_sub5_12_.method803(anIntArray2516[i], anIntArray2510[i]);
        }
        int i = -128 % ((53 - arg1) / 35);
        if(bool)
            class40_sub5_sub17_sub5_12_.method821(anInt2507, anInt2540, anInt2517);
        if(bool_11_)
            class40_sub5_sub17_sub5_12_.method828(anInt2500, anInt2519, anInt2504);
        if(arg2)
            class40_sub5_sub17_sub5_12_.method810();
        class40_sub5_sub17_sub5_12_.method802(anInt2527 + 64, 768 + (anInt2544 * 5), -50, -10, -50, arg0);
        return class40_sub5_sub17_sub5_12_;

    }

    public Model method607(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Class40_Sub5_Sub7 arg6, int arg7, int arg8) {

        long l;
        if(anIntArray2522 == null)
            l = (long) (arg5 + (anInt2538 << 554173066));
        else
            l = (long) (arg5 + ((anInt2538 << 1528233034) + (arg4 << 272341539)));
        Model class40_sub5_sub17_sub5 = ((Model) Class49.aClass9_1145.method231(l, (byte) 70));
        if(class40_sub5_sub17_sub5 == null) {
            class40_sub5_sub17_sub5 = method606(true, (byte) -25, true, arg5, arg4);
            if(class40_sub5_sub17_sub5 == null)
                return null;
            Class49.aClass9_1145.method230(-7208, l, class40_sub5_sub17_sub5);
        }
        if(arg6 == null && !adjustToTerrain)
            return class40_sub5_sub17_sub5;
        if(arg6 != null)
            class40_sub5_sub17_sub5 = arg6.method593(arg3, false, class40_sub5_sub17_sub5, arg5);
        else
            class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5.method817(true);
        if(arg1 < 54)
            return null;
        if(adjustToTerrain) {
            int i = (arg2 + arg0 - (-arg8 + -arg7)) / 4;
            for(int i_13_ = 0; ((i_13_ ^ 0xffffffff) > (class40_sub5_sub17_sub5.vertexCount ^ 0xffffffff)); i_13_++) {
                int i_14_ = class40_sub5_sub17_sub5.verticesZ[i_13_];
                int i_15_ = class40_sub5_sub17_sub5.verticesX[i_13_];
                int i_16_ = arg0 + (64 + i_15_) * (arg2 - arg0) / 128;
                int i_17_ = arg7 + (64 + i_15_) * (arg8 + -arg7) / 128;
                int i_18_ = i_16_ + (i_14_ + 64) * (-i_16_ + i_17_) / 128;
                class40_sub5_sub17_sub5.verticesY[i_13_] += -i + i_18_;
            }
        }
        return class40_sub5_sub17_sub5;

    }

    public void method608(Buffer arg0, int arg1, int arg2) {
        if((arg2 ^ 0xffffffff) != -2) {
            if(arg2 == 2)
                aClass1_2549 = arg0.getRSString();
            else if(arg2 != 5) {
                if((arg2 ^ 0xffffffff) == -15)
                    anInt2503 = arg0.getUnsignedByte();
                else if((arg2 ^ 0xffffffff) != -16) {
                    if(arg2 != 17) {
                        if(arg2 != 18) {
                            if((arg2 ^ 0xffffffff) != -20) {
                                if(arg2 == 21)
                                    adjustToTerrain = true;
                                else if(arg2 != 22) {
                                    if((arg2 ^ 0xffffffff) != -24) {
                                        if(arg2 != 24) {
                                            if((arg2 ^ 0xffffffff) == -29)
                                                anInt2505 = arg0.getUnsignedByte();
                                            else if((arg2 ^ 0xffffffff) == -30)
                                                anInt2527 = arg0.get();
                                            else if((arg2 ^ 0xffffffff) == -40)
                                                anInt2544 = 5 * arg0.get();
                                            else if((arg2 ^ 0xffffffff) <= -31 && arg2 < 35) {
                                                aClass1Array2508[arg2 - 30] = arg0.getRSString();
                                                if(aClass1Array2508[arg2 + -30].method63(Class59.aClass1_1396, true))
                                                    aClass1Array2508[(arg2 + -30)] = null;
                                            } else if(arg2 != 40) {
                                                if((arg2 ^ 0xffffffff) == -61)
                                                    anInt2511 = (arg0.getUnsignedShortBE());
                                                else if((arg2 ^ 0xffffffff) == -63)
                                                    aBoolean2553 = true;
                                                else if(arg2 != 64) {
                                                    if((arg2 ^ 0xffffffff) == -66)
                                                        anInt2507 = (arg0.getUnsignedShortBE());
                                                    else if((arg2 ^ 0xffffffff) == -67)
                                                        anInt2540 = (arg0.getUnsignedShortBE());
                                                    else if(arg2 != 67) {
                                                        if(arg2 != 68) {
                                                            if((arg2 ^ 0xffffffff) != -70) {
                                                                if(arg2 == 70)
                                                                    anInt2500 = (arg0.getShortBE());
                                                                else if((arg2 ^ 0xffffffff) == -72)
                                                                    anInt2519 = (arg0.getShortBE());
                                                                else if(arg2 == 72)
                                                                    anInt2504 = (arg0.getShortBE());
                                                                else if(arg2 != 73) {
                                                                    if((arg2 ^ 0xffffffff) != -75) {
                                                                        if(arg2 == 75)
                                                                            anInt2533 = arg0.getUnsignedByte();
                                                                        else if(arg2 != 77) {
                                                                            if(arg2 == 78) {
                                                                                anInt2513 = arg0.getUnsignedShortBE();
                                                                                anInt2502 = arg0.getUnsignedByte();
                                                                            } else if((arg2 ^ 0xffffffff) == -80) {
                                                                                anInt2499 = arg0.getUnsignedShortBE();
                                                                                anInt2542 = arg0.getUnsignedShortBE();
                                                                                anInt2502 = arg0.getUnsignedByte();
                                                                                int i = arg0.getUnsignedByte();
                                                                                anIntArray2523 = new int[i];
                                                                                for(int i_19_ = 0; i > i_19_; i_19_++)
                                                                                    anIntArray2523[i_19_] = arg0.getUnsignedShortBE();
                                                                            }
                                                                        } else {
                                                                            anInt2548 = arg0.getUnsignedShortBE();
                                                                            if(anInt2548 == 65535)
                                                                                anInt2548 = -1;
                                                                            anInt2536 = arg0.getUnsignedShortBE();
                                                                            if((anInt2536 ^ 0xffffffff) == -65536)
                                                                                anInt2536 = -1;
                                                                            int i = arg0.getUnsignedByte();
                                                                            childrenIds = new int[1 + i];
                                                                            for(int i_20_ = 0; (i ^ 0xffffffff) <= (i_20_ ^ 0xffffffff); i_20_++) {
                                                                                childrenIds[i_20_] = arg0.getUnsignedShortBE();
                                                                                if((childrenIds[i_20_] ^ 0xffffffff) == -65536)
                                                                                    childrenIds[i_20_] = -1;
                                                                            }
                                                                        }
                                                                    } else
                                                                        aBoolean2518 = true;
                                                                } else
                                                                    unknown = true;
                                                            } else
                                                                anInt2512 = (arg0.getUnsignedByte());
                                                        } else
                                                            anInt2537 = (arg0.getUnsignedShortBE());
                                                    } else
                                                        anInt2517 = (arg0.getUnsignedShortBE());
                                                } else
                                                    aBoolean2541 = false;
                                            } else {
                                                int i = arg0.getUnsignedByte();
                                                anIntArray2516 = new int[i];
                                                anIntArray2510 = new int[i];
                                                for(int i_21_ = 0; i_21_ < i; i_21_++) {
                                                    anIntArray2516[i_21_] = (arg0.getUnsignedShortBE());
                                                    anIntArray2510[i_21_] = (arg0.getUnsignedShortBE());
                                                }
                                            }
                                        } else {
                                            animationId = arg0.getUnsignedShortBE();
                                            if((animationId ^ 0xffffffff) == -65536)
                                                animationId = -1;
                                        }
                                    } else
                                        aBoolean2521 = true;
                                } else
                                    nonFlatShading = true;
                            } else
                                hasActions = arg0.getUnsignedByte();
                        } else
                            aBoolean2528 = false;
                    } else
                        solid = false;
                } else
                    anInt2515 = arg0.getUnsignedByte();
            } else {
                int i = arg0.getUnsignedByte();
                if(i > 0) {
                    if(anIntArray2525 != null && !Class35.aBoolean1734)
                        arg0.currentPosition += 2 * i;
                    else {
                        anIntArray2522 = null;
                        anIntArray2525 = new int[i];
                        for(int i_22_ = 0; (i ^ 0xffffffff) < (i_22_ ^ 0xffffffff); i_22_++)
                            anIntArray2525[i_22_] = arg0.getUnsignedShortBE();
                    }
                }
            }
        } else {
            int i = arg0.getUnsignedByte();
            if(i > 0) {
                if(anIntArray2525 != null && !Class35.aBoolean1734)
                    arg0.currentPosition += i * 3;
                else {
                    anIntArray2522 = new int[i];
                    anIntArray2525 = new int[i];
                    for(int i_23_ = 0; i > i_23_; i_23_++) {
                        anIntArray2525[i_23_] = arg0.getUnsignedShortBE();
                        anIntArray2522[i_23_] = arg0.getUnsignedByte();
                    }
                }
            }
        }
        if(arg1 != -1663)
            method601((byte) -112);
    }

    public boolean method610(int arg0, int arg1) {

        if(arg1 != 7533)
            anInt2543 = -28;
        if(anIntArray2522 != null) {
            for(int i = 0; anIntArray2522.length > i; i++) {
                if((arg0 ^ 0xffffffff) == (anIntArray2522[i] ^ 0xffffffff))
                    return RSString.aClass6_1705.method173((anIntArray2525[i] & 0xffff), (byte) -10, 0);
            }
            return true;
        }
        if(anIntArray2525 == null)
            return true;
        if((arg0 ^ 0xffffffff) != -11)
            return true;
        boolean bool = true;
        for(int i = 0; anIntArray2525.length > i; i++)
            bool &= RSString.aClass6_1705.method173((0xffff & anIntArray2525[i]), (byte) -10, 0);
        return bool;

    }

    public GameObjectDefinition method611(int arg0) {

        int i = -1;
        if(arg0 != -20)
            method606(true, (byte) -93, false, 40, -55);
        if(anInt2548 == -1) {
            if(anInt2536 != -1)
                i = Class58.varbitmasks[anInt2536];
        } else
            i = Class40_Sub5_Sub6.method585(anInt2548, 1369);
        if(i < 0 || childrenIds.length <= i || childrenIds[i] == -1)
            return null;
        return getDefinition(childrenIds[i]);

    }

    public boolean method612(byte arg0) {

        if(anIntArray2525 == null)
            return true;
        boolean bool = true;
        for(int i = 0; anIntArray2525.length > i; i++)
            bool &= RSString.aClass6_1705.method173((0xffff & anIntArray2525[i]), (byte) -10, 0);
        int i = -67 % ((-65 - arg0) / 50);
        return bool;

    }
}
