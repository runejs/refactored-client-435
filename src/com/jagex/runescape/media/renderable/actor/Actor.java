package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.util.Signlink;

import java.math.BigInteger;

public abstract class Actor extends Renderable {
    public static int anInt3076;
    public static int anInt3084;
    public static int anInt3085;
    public static RSString aClass1_3092 = RSString.CreateString("Loaded textures");
    public static int anInt3103;
    public static int anInt3106;
    public static int anInt3108;
    public static int[] anIntArray3111;
    public static RSString aClass1_3114 = RSString.CreateString("Login limit exceeded)3");
    public static BigInteger rsaModulus;
    public static int anInt3121;
    public static RSString aClass1_3124 = aClass1_3092;
    public static int anInt3128;
    public static int anInt3133;
    public static RSString aClass1_3138 = aClass1_3114;
    public static int anInt3142;
    public static volatile int eventMouseButtonPressed = 0;
    public static CacheIndex aCacheIndex_3144;
    public static int anInt3146;
    public static int anInt3147;
    public static int[] anIntArray3149;
    public static CacheIndex aCacheIndex_3150;
    public static int anInt3151;
    public static Signlink aClass31_3152;
    public static int anInt3153;
    public static RSString aClass1_3154;
    public static RSString aClass1_3155;
    public static Player[] aClass40_Sub5_Sub17_Sub4_Sub1Array3156;
    public static CacheIndex_Sub1 aClass6_Sub1_3157;
    public static RSString aClass1_3158;
    public static RSString aClass1_3159;
    public static RSString[] chatMessages;

    static {
        rsaModulus = (new BigInteger("119568088839203297999728368933573315070738693395974011872885408638642676871679245723887367232256427712869170521351089799352546294030059890127723509653145359924771433131004387212857375068629466435244653901851504845054452735390701003613803443469723435116497545687393297329052988014281948392136928774011011998343"));
        anInt3151 = -16 + (int) (Math.random() * 33.0);
        aClass40_Sub5_Sub17_Sub4_Sub1Array3156 = new Player[2048];
        anInt3153 = 0;
        aClass1_3154 = RSString.CreateString("Lade Schrifts-=tze )2 ");
        aClass1_3155 = RSString.CreateString("Please wait )2 attempting to reestablish");
        aClass1_3159 = aClass1_3155;
        anIntArray3149 = new int[1000];
        aClass1_3158 = RSString.CreateString("Registrierter Benutzer");
        chatMessages = new RSString[100];
    }

    public boolean[] aBooleanArray3072;
    public int anInt3073;
    public int anInt3074;
    public int anInt3075;
    public int anInt3077;
    public int anInt3078;
    public int anInt3079;
    public int anInt3080;
    public int anInt3081;
    public int anInt3082;
    public int anInt3083;
    public int[] anIntArray3086;
    public int[] anIntArray3087;
    public int[] anIntArray3088;
    public int anInt3089;
    public RSString forcedChatMessage;
    public int anInt3091;
    public int anInt3093;
    public int anInt3094;
    public int anInt3095 = 0;
    public int anInt3096;
    public int anInt3097;
    public int anInt3098;
    public int anInt3099;
    public int facePositionY;
    public int anInt3101;
    public int anInt3102;
    public int anInt3104;
    public boolean aBoolean3105;
    public int anInt3107;
    public int anInt3109;
    public int anInt3110;
    public int anInt3112;
    public int anInt3113;
    public int anInt3115;
    public int anInt3116;
    public int anInt3117;
    public int anInt3118;
    public int anInt3120;
    public int playingAnimationDelay;
    public int anInt3123;
    public int anInt3125;
    public int anInt3126;
    public int anInt3127;
    public int anInt3129;
    public int anInt3130;
    public int anInt3131;
    public int anInt3132;
    public int anInt3134;
    public int[] anIntArray3135;
    public int[] anIntArray3136;
    public int facingActorIndex;
    public int anInt3139;
    public int anInt3140;
    public int playingAnimation;
    public int anInt3145;
    public int facePositionX;

    public Actor() {
        anInt3083 = -1;
        facePositionY = 0;
        anInt3082 = -1;
        anInt3079 = -1;
        aBoolean3105 = false;
        anInt3096 = 1;
        forcedChatMessage = null;
        anInt3075 = -1;
        anIntArray3086 = new int[4];
        aBooleanArray3072 = new boolean[10];
        anInt3113 = 32;
        anInt3094 = 0;
        anInt3102 = 0;
        anInt3104 = 0;
        anInt3091 = -1;
        anInt3117 = 200;
        anInt3078 = 100;
        anInt3120 = 0;
        playingAnimationDelay = 0;
        anInt3077 = -1;
        anIntArray3087 = new int[4];
        anInt3116 = 0;
        anInt3109 = 0;
        anInt3123 = 0;
        anInt3126 = -1;
        anInt3074 = 0;
        anInt3097 = 0;
        anIntArray3136 = new int[4];
        anInt3129 = 0;
        facingActorIndex = -1;
        anIntArray3135 = new int[10];
        anInt3139 = -1000;
        anInt3131 = -1;
        anInt3115 = 0;
        anInt3134 = 0;
        anInt3140 = 0;
        anIntArray3088 = new int[10];
        anInt3132 = -1;
        anInt3145 = -1;
        facePositionX = 0;
        playingAnimation = -1;
    }

    public static void method781(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 == 1850) {
            anInt3084++;
            int i = Npc.aScene_3301.method122(arg1, arg2, arg5);
            if(i != 0) {
                int i_0_ = Npc.aScene_3301.method141(arg1, arg2, arg5, i);
                int i_1_ = 0x1f & i_0_;
                int i_2_ = 0x3 & i_0_ >> -1705964506;
                int i_3_ = arg3;
                if((i ^ 0xffffffff) < -1)
                    i_3_ = arg4;
                int i_4_ = 4 * (-arg5 + 103) * 512 + (24624 + (4 * arg2));
                int i_5_ = i >> -1766000082 & 0x7fff;
                int[] is = (Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.pixels);
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_5_);
                if(gameObjectDefinition.mapSceneID != -1) {
                    IndexedImage class40_sub5_sub14_sub2 = (SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[gameObjectDefinition.mapSceneID]);
                    if(class40_sub5_sub14_sub2 != null) {
                        int i_6_ = ((-class40_sub5_sub14_sub2.imgWidth + gameObjectDefinition.sizeX * 4) / 2);
                        int i_7_ = ((gameObjectDefinition.sizeY * 4 + -class40_sub5_sub14_sub2.imgHeight) / 2);
                        class40_sub5_sub14_sub2.drawImage(48 + (4 * arg2) + i_6_, i_7_ + (48 + ((104 + -arg5 - gameObjectDefinition.sizeY) * 4)));
                    }
                } else {
                    if(i_1_ == 0 || (i_1_ ^ 0xffffffff) == -3) {
                        if(i_2_ == 0) {
                            is[i_4_] = i_3_;
                            is[512 + i_4_] = i_3_;
                            is[1024 + i_4_] = i_3_;
                            is[1536 + i_4_] = i_3_;
                        } else if(i_2_ == 1) {
                            is[i_4_] = i_3_;
                            is[i_4_ + 1] = i_3_;
                            is[2 + i_4_] = i_3_;
                            is[i_4_ + 3] = i_3_;
                        } else if((i_2_ ^ 0xffffffff) == -3) {
                            is[3 + i_4_] = i_3_;
                            is[3 + (i_4_ + 512)] = i_3_;
                            is[1024 + i_4_ + 3] = i_3_;
                            is[i_4_ + 1539] = i_3_;
                        } else if(i_2_ == 3) {
                            is[i_4_ + 1536] = i_3_;
                            is[1536 + (i_4_ + 1)] = i_3_;
                            is[1536 + i_4_ + 2] = i_3_;
                            is[3 + i_4_ + 1536] = i_3_;
                        }
                    }
                    if(i_1_ == 3) {
                        if(i_2_ != 0) {
                            if((i_2_ ^ 0xffffffff) != -2) {
                                if((i_2_ ^ 0xffffffff) != -3) {
                                    if((i_2_ ^ 0xffffffff) == -4)
                                        is[i_4_ + 1536] = i_3_;
                                } else
                                    is[3 + i_4_ + 1536] = i_3_;
                            } else
                                is[i_4_ + 3] = i_3_;
                        } else
                            is[i_4_] = i_3_;
                    }
                    if((i_1_ ^ 0xffffffff) == -3) {
                        if(i_2_ != 3) {
                            if(i_2_ != 0) {
                                if(i_2_ == 1) {
                                    is[i_4_ + 3] = i_3_;
                                    is[512 + (3 + i_4_)] = i_3_;
                                    is[i_4_ + 1027] = i_3_;
                                    is[1536 + (3 + i_4_)] = i_3_;
                                } else if((i_2_ ^ 0xffffffff) == -3) {
                                    is[1536 + i_4_] = i_3_;
                                    is[1537 + i_4_] = i_3_;
                                    is[i_4_ + 1538] = i_3_;
                                    is[1536 + i_4_ + 3] = i_3_;
                                }
                            } else {
                                is[i_4_] = i_3_;
                                is[1 + i_4_] = i_3_;
                                is[i_4_ + 2] = i_3_;
                                is[3 + i_4_] = i_3_;
                            }
                        } else {
                            is[i_4_] = i_3_;
                            is[512 + i_4_] = i_3_;
                            is[i_4_ + 1024] = i_3_;
                            is[1536 + i_4_] = i_3_;
                        }
                    }
                }
            }
            i = Npc.aScene_3301.method110(arg1, arg2, arg5);
            if(i != 0) {
                int i_8_ = Npc.aScene_3301.method141(arg1, arg2, arg5, i);
                int i_9_ = 0x7fff & i >> 1891879118;
                int i_10_ = (i_8_ & 0xf4) >> -474347930;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_9_);
                int i_11_ = i_8_ & 0x1f;
                if(gameObjectDefinition.mapSceneID != -1) {
                    IndexedImage class40_sub5_sub14_sub2 = (SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[gameObjectDefinition.mapSceneID]);
                    if(class40_sub5_sub14_sub2 != null) {
                        int i_12_ = ((-class40_sub5_sub14_sub2.imgHeight + gameObjectDefinition.sizeY * 4) / 2);
                        int i_13_ = ((gameObjectDefinition.sizeX * 4 + -class40_sub5_sub14_sub2.imgWidth) / 2);
                        class40_sub5_sub14_sub2.drawImage(i_13_ + arg2 * 4 + 48, 48 - (-(4 * (-arg5 + (104 + -gameObjectDefinition.sizeY))) + -i_12_));
                    }
                } else if((i_11_ ^ 0xffffffff) == -10) {
                    int[] is = (Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.pixels);
                    int i_14_ = 15658734;
                    if((i ^ 0xffffffff) < -1)
                        i_14_ = 15597568;
                    int i_15_ = (-(arg5 * 512) + 52736) * 4 + arg2 * 4 + 24624;
                    if((i_10_ ^ 0xffffffff) != -1 && (i_10_ ^ 0xffffffff) != -3) {
                        is[i_15_] = i_14_;
                        is[513 + i_15_] = i_14_;
                        is[2 + (i_15_ + 1024)] = i_14_;
                        is[1536 + i_15_ + 3] = i_14_;
                    } else {
                        is[1536 + i_15_] = i_14_;
                        is[1024 + (i_15_ + 1)] = i_14_;
                        is[514 + i_15_] = i_14_;
                        is[3 + i_15_] = i_14_;
                    }
                }
            }
            i = Npc.aScene_3301.method93(arg1, arg2, arg5);
            if((i ^ 0xffffffff) != -1) {
                int i_16_ = (i & 0x1fffd9fb) >> 1370061614;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_16_);
                if((gameObjectDefinition.mapSceneID ^ 0xffffffff) != 0) {
                    IndexedImage class40_sub5_sub14_sub2 = (SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[gameObjectDefinition.mapSceneID]);
                    if(class40_sub5_sub14_sub2 != null) {
                        int i_17_ = ((-class40_sub5_sub14_sub2.imgWidth + gameObjectDefinition.sizeX * 4) / 2);
                        int i_18_ = ((-class40_sub5_sub14_sub2.imgHeight + 4 * gameObjectDefinition.sizeY) / 2);
                        class40_sub5_sub14_sub2.drawImage(4 * arg2 + 48 + i_17_, i_18_ + ((104 - (arg5 + gameObjectDefinition.sizeY)) * 4) + 48);
                    }
                }
            }
        }
    }

    public static void method783(int arg0) {

        anInt3085++;
        Cache.aClass9_326.method235((byte) -126);
        int i = 12 / ((-12 - arg0) / 50);
        Class53.aClass9_1264.method235((byte) -96);
        Class67.aClass9_1582.method235((byte) 34);

    }

    public static void method786(boolean arg0) {
        Cache.outgoingbuffer.initBitAccess(127);
        anInt3121++;
        int i = Cache.outgoingbuffer.putBits(1, (byte) -65);
        if((i ^ 0xffffffff) != -1) {
            int i_21_ = Cache.outgoingbuffer.putBits(2, (byte) -65);
            if(i_21_ == 0)
                Class24.anIntArray578[anInt3153++] = 2047;
            else if((i_21_ ^ 0xffffffff) == -2) {
                int i_22_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                Player.localPlayer.method782(i_22_, (byte) -96, false);
                int i_23_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                if((i_23_ ^ 0xffffffff) == -2)
                    Class24.anIntArray578[anInt3153++] = 2047;
            } else if(i_21_ == 2) {
                int i_24_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                Player.localPlayer.method782(i_24_, (byte) -96, true);
                int i_25_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                Player.localPlayer.method782(i_25_, (byte) -96, true);
                int i_26_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                if((i_26_ ^ 0xffffffff) == -2)
                    Class24.anIntArray578[anInt3153++] = 2047;
            } else if(i_21_ == 3) {
                int i_27_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                Player.anInt3267 = Cache.outgoingbuffer.putBits(2, (byte) -65);
                int i_28_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                if(i_28_ == 1)
                    Class24.anIntArray578[anInt3153++] = 2047;
                int i_29_ = Cache.outgoingbuffer.putBits(7, (byte) -65);
                int i_30_ = Cache.outgoingbuffer.putBits(7, (byte) -65);
                Player.localPlayer.method787(i_30_, -7717, (i_27_ ^ 0xffffffff) == -2, i_29_);
            } else if(arg0 != true)
                method781(-5, -11, -11, 113, 49, 123);
        }
    }

    public static void method788(int arg0) {

        aClass1_3158 = null;
        aClass6_Sub1_3157 = null;
        aClass1_3092 = null;
        aClass1_3154 = null;
        aClass1_3138 = null;
        aClass1_3114 = null;
        chatMessages = null;
        aClass40_Sub5_Sub17_Sub4_Sub1Array3156 = null;
        aCacheIndex_3150 = null;
        aClass1_3155 = null;
        aCacheIndex_3144 = null;
        aClass31_3152 = null;
        int i = -42 / ((arg0 - 20) / 50);
        anIntArray3111 = null;
        aClass1_3124 = null;
        anIntArray3149 = null;
        rsaModulus = null;
        aClass1_3159 = null;

    }

    public static void method789(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {

        anInt3147++;
        if(arg3 != Class51.anInt1202 || arg2 != Class17.anInt448 || ((arg5 ^ 0xffffffff) != (Class40_Sub6.onBuildTimePlane ^ 0xffffffff) && VertexNormal.lowMemory)) {
            Class40_Sub6.onBuildTimePlane = arg5;
            Class51.anInt1202 = arg3;
            if(!VertexNormal.lowMemory)
                Class40_Sub6.onBuildTimePlane = 0;
            Class17.anInt448 = arg2;
            OverlayDefinition.method559(25, 88);
            Class51.method940(0, Class67.aClass1_1585, false, null);
            int i = Class26.anInt635;
            int i_33_ = SpotAnimDefinition.anInt2307;
            SpotAnimDefinition.anInt2307 = (arg3 - 6) * 8;
            int i_34_ = SpotAnimDefinition.anInt2307 + -i_33_;
            if(arg1 != -1000)
                method781(14, 98, 96, -85, -118, 89);
            i_33_ = SpotAnimDefinition.anInt2307;
            Class26.anInt635 = (-6 + arg2) * 8;
            int i_35_ = Class26.anInt635 + -i;
            i = Class26.anInt635;
            for(int i_36_ = 0; (i_36_ ^ 0xffffffff) > -32769; i_36_++) {
                Npc class40_sub5_sub17_sub4_sub2 = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_36_]);
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    for(int i_37_ = 0; i_37_ < 10; i_37_++) {
                        class40_sub5_sub17_sub4_sub2.anIntArray3088[i_37_] -= i_34_;
                        class40_sub5_sub17_sub4_sub2.anIntArray3135[i_37_] -= i_35_;
                    }
                    class40_sub5_sub17_sub4_sub2.anInt3098 -= 128 * i_34_;
                    class40_sub5_sub17_sub4_sub2.anInt3089 -= i_35_ * 128;
                }
            }
            for(int i_38_ = 0; i_38_ < 2048; i_38_++) {
                Player class40_sub5_sub17_sub4_sub1 = aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_38_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    for(int i_39_ = 0; (i_39_ ^ 0xffffffff) > -11; i_39_++) {
                        class40_sub5_sub17_sub4_sub1.anIntArray3088[i_39_] -= i_34_;
                        class40_sub5_sub17_sub4_sub1.anIntArray3135[i_39_] -= i_35_;
                    }
                    class40_sub5_sub17_sub4_sub1.anInt3089 -= 128 * i_35_;
                    class40_sub5_sub17_sub4_sub1.anInt3098 -= 128 * i_34_;
                }
            }
            Player.anInt3267 = arg5;
            int i_40_ = 0;
            Player.localPlayer.method787(arg4, -7717, false, arg0);
            int i_41_ = 104;
            int i_42_ = 1;
            if((i_34_ ^ 0xffffffff) > -1) {
                i_41_ = -1;
                i_40_ = 103;
                i_42_ = -1;
            }
            int i_43_ = 104;
            int i_44_ = 0;
            int i_45_ = 1;
            if((i_35_ ^ 0xffffffff) > -1) {
                i_44_ = 103;
                i_43_ = -1;
                i_45_ = -1;
            }
            for(int i_46_ = i_40_; (i_46_ ^ 0xffffffff) != (i_41_ ^ 0xffffffff); i_46_ += i_42_) {
                for(int i_47_ = i_44_; (i_47_ ^ 0xffffffff) != (i_43_ ^ 0xffffffff); i_47_ += i_45_) {
                    int i_48_ = i_34_ + i_46_;
                    int i_49_ = i_35_ + i_47_;
                    for(int i_50_ = 0; (i_50_ ^ 0xffffffff) > -5; i_50_++) {
                        if((i_48_ ^ 0xffffffff) > -1 || i_49_ < 0 || i_48_ >= 104 || i_49_ >= 104)
                            Class10.aClass45ArrayArrayArray357[i_50_][i_46_][i_47_] = null;
                        else
                            Class10.aClass45ArrayArrayArray357[i_50_][i_46_][i_47_] = (Class10.aClass45ArrayArrayArray357[i_50_][i_48_][i_49_]);
                    }
                }
            }
            for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) Class45.aClass45_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = ((Class40_Sub3) Class45.aClass45_1064.method909(-4))) {
                class40_sub3.anInt2038 -= i_35_;
                class40_sub3.anInt2039 -= i_34_;
                if((class40_sub3.anInt2039 ^ 0xffffffff) > -1 || (class40_sub3.anInt2038 ^ 0xffffffff) > -1 || class40_sub3.anInt2039 >= 104 || (class40_sub3.anInt2038 ^ 0xffffffff) <= -105)
                    class40_sub3.method457(-1);
            }
            Buffer.anInt1985 = -1;
            if(VarbitDefinition.anInt2366 != 0) {
                VarbitDefinition.anInt2366 -= i_34_;
                Class55.anInt1304 -= i_35_;
            }
            Class39.aBoolean906 = false;
            PacketBuffer.anInt2248 = 0;
            Class57.aClass45_1332.method906(0);
            Class43.aClass45_1022.method906(0);
        }

    }

    public void method782(int arg0, byte arg1, boolean arg2) {

        anInt3103++;
        int i = anIntArray3088[0];
        int i_19_ = anIntArray3135[0];
        if(arg0 == 0) {
            i_19_++;
            i--;
        }
        if(playingAnimation != -1 && (Class68_Sub1.method1050(playingAnimation, arg1 ^ ~0x5d).anInt2476 == 1))
            playingAnimation = -1;
        if(anInt3109 < 9)
            anInt3109++;
        for(int i_20_ = anInt3109; (i_20_ ^ 0xffffffff) < -1; i_20_--) {
            anIntArray3088[i_20_] = anIntArray3088[i_20_ + -1];
            anIntArray3135[i_20_] = anIntArray3135[i_20_ - 1];
            aBooleanArray3072[i_20_] = aBooleanArray3072[-1 + i_20_];
        }
        if(arg0 == 1)
            i_19_++;
        if(arg1 != -96)
            method783(125);
        if(arg0 == 2) {
            i_19_++;
            i++;
        }
        if(arg0 == 3)
            i--;
        if((arg0 ^ 0xffffffff) == -5)
            i++;
        if((arg0 ^ 0xffffffff) == -6) {
            i--;
            i_19_--;
        }
        if((arg0 ^ 0xffffffff) == -7)
            i_19_--;
        if(arg0 == 7) {
            i++;
            i_19_--;
        }
        anIntArray3088[0] = i;
        anIntArray3135[0] = i_19_;
        aBooleanArray3072[0] = arg2;

    }

    public boolean isVisible(int arg0) {
        return false;
    }

    public void method785(int arg0, int arg1, int arg2, int arg3) {
        anInt3142++;
        for(int i = 0; (i ^ 0xffffffff) > -5; i++) {
            if((arg1 >= anIntArray3136[i])) {
                anIntArray3087[i] = arg2;
                anIntArray3086[i] = arg0;
                anIntArray3136[i] = 70 + arg1;
                return;
            }
        }
        if(arg3 >= -110)
            anInt3080 = -75;
    }

    public void method787(int arg0, int arg1, boolean arg2, int arg3) {

        if((playingAnimation ^ 0xffffffff) != 0 && Class68_Sub1.method1050(playingAnimation, 2).anInt2476 == 1)
            playingAnimation = -1;
        anInt3076++;
        if(!arg2) {
            int i = -anIntArray3088[0] + arg3;
            int i_31_ = -anIntArray3135[0] + arg0;
            if(i >= -8 && (i ^ 0xffffffff) >= -9 && i_31_ >= -8 && (i_31_ ^ 0xffffffff) >= -9) {
                if(anInt3109 < 9)
                    anInt3109++;
                for(int i_32_ = anInt3109; (i_32_ ^ 0xffffffff) < -1; i_32_--) {
                    anIntArray3088[i_32_] = anIntArray3088[-1 + i_32_];
                    anIntArray3135[i_32_] = anIntArray3135[-1 + i_32_];
                    aBooleanArray3072[i_32_] = aBooleanArray3072[i_32_ + -1];
                }
                anIntArray3088[0] = arg3;
                anIntArray3135[0] = arg0;
                aBooleanArray3072[0] = false;
                return;
            }
        }
        anInt3109 = 0;
        anInt3074 = 0;
        if(arg1 != -7717)
            method785(-19, 10, -70, -9);
        anInt3094 = 0;
        anIntArray3088[0] = arg3;
        anIntArray3135[0] = arg0;
        anInt3098 = anInt3096 * 64 + anIntArray3088[0] * 128;
        anInt3089 = anInt3096 * 64 + anIntArray3135[0] * 128;

    }

    public void method790(int arg0) {

        anInt3106++;
        anInt3094 = arg0;
        anInt3109 = 0;

    }
}
