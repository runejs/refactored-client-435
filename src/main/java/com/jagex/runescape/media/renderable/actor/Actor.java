package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.util.Signlink;

import java.math.BigInteger;

public abstract class Actor extends Renderable {
    public static RSString aClass1_3092 = RSString.CreateString("Loaded textures");
    public static int[] anIntArray3111;
    public static RSString aClass1_3114 = RSString.CreateString("Login limit exceeded)3");
    public static RSString aClass1_3124 = aClass1_3092;
    public static RSString aClass1_3138 = aClass1_3114;
    public static volatile int eventMouseButtonPressed = 0;
    public static CacheIndex aCacheIndex_3144;
    public static int[] anIntArray3149 = new int[1000];
    public static CacheIndex aCacheIndex_3150;
    public static int anInt3151 = -16 + (int) (Math.random() * 33.0);
    public static Signlink aClass31_3152;
    public static int actorUpdatingIndex = 0;
    public static RSString aClass1_3155 = RSString.CreateString("Please wait )2 attempting to reestablish");
    public static CacheIndex_Sub1 aClass6_Sub1_3157;
    public static RSString aClass1_3159 = aClass1_3155;

    public boolean[] aBooleanArray3072;
    public int anInt3073;
    public int anInt3074;
    public int turnRightAnimationId;
    public int anInt3077;
    public int anInt3078;
    public int turnAroundAnimationId;
    public int anInt3080;
    public int anInt3081;
    public int runAnimationId;
    public int anInt3083;
    public int[] anIntArray3086;
    public int[] anIntArray3087;
    public int[] pathY;
    public int worldY;
    public RSString forcedChatMessage;
    public int anInt3091;
    public int anInt3093;
    public int anInt3094;
    public int anInt3095 = 0;
    public int anInt3096;
    public int anInt3097;
    public int worldX;
    public int anInt3099;
    public int facePositionY;
    public int anInt3101;
    public int chatcolor;
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
    public int chatEffects;
    public int anInt3125;
    public int idleAnimation;
    public int anInt3127;
    public int anInt3129;
    public int anInt3130;
    public int walkAnimationId;
    public int turnLeftAnimationId;
    public int anInt3134;
    public int[] pathX;
    public int[] anIntArray3136;
    public int facingActorIndex;
    public int anInt3139;
    public int anInt3140;
    public int playingAnimation;
    public int standTurnAnimationId;
    public int facePositionX;

    public Actor() {
        anInt3083 = -1;
        facePositionY = 0;
        runAnimationId = -1;
        turnAroundAnimationId = -1;
        aBoolean3105 = false;
        anInt3096 = 1;
        forcedChatMessage = null;
        turnRightAnimationId = -1;
        anIntArray3086 = new int[4];
        aBooleanArray3072 = new boolean[10];
        anInt3113 = 32;
        anInt3094 = 0;
        chatcolor = 0;
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
        chatEffects = 0;
        idleAnimation = -1;
        anInt3074 = 0;
        anInt3097 = 0;
        anIntArray3136 = new int[4];
        anInt3129 = 0;
        facingActorIndex = -1;
        pathX = new int[10];
        anInt3139 = -1000;
        walkAnimationId = -1;
        anInt3115 = 0;
        anInt3134 = 0;
        anInt3140 = 0;
        pathY = new int[10];
        turnLeftAnimationId = -1;
        standTurnAnimationId = -1;
        facePositionX = 0;
        playingAnimation = -1;
    }

    public static void method781(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 == 1850) {
            int i = Npc.currentScene.method122(arg1, arg2, arg5);
            if(i != 0) {
                int i_0_ = Npc.currentScene.getArrangement(arg1, arg2, arg5, i);
                int i_1_ = 0x1f & i_0_;
                int i_2_ = 0x3 & i_0_ >> 6;
                int i_3_ = arg3;
                if(i > 0)
                    i_3_ = arg4;
                int i_4_ = 4 * (-arg5 + 103) * 512 + (24624 + (4 * arg2));
                int i_5_ = i >> 14 & 0x7fff;
                int[] is = (Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.pixels);
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_5_);
                if(gameObjectDefinition.mapSceneID == -1) {
                    if(i_1_ == 0 || i_1_ == 2) {
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
                        } else if(i_2_ == 2) {
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
                            if(i_2_ != 1) {
                                if(i_2_ != 2) {
                                    if(i_2_ == 3)
                                        is[i_4_ + 1536] = i_3_;
                                } else
                                    is[3 + i_4_ + 1536] = i_3_;
                            } else
                                is[i_4_ + 3] = i_3_;
                        } else
                            is[i_4_] = i_3_;
                    }
                    if(i_1_ == 2) {
                        if(i_2_ == 3) {
                            is[i_4_] = i_3_;
                            is[512 + i_4_] = i_3_;
                            is[i_4_ + 1024] = i_3_;
                            is[1536 + i_4_] = i_3_;
                        } else if(i_2_ == 0) {
                            is[i_4_] = i_3_;
                            is[1 + i_4_] = i_3_;
                            is[i_4_ + 2] = i_3_;
                            is[3 + i_4_] = i_3_;
                        } else if(i_2_ == 1) {
                            is[i_4_ + 3] = i_3_;
                            is[512 + (3 + i_4_)] = i_3_;
                            is[i_4_ + 1027] = i_3_;
                            is[1536 + (3 + i_4_)] = i_3_;
                        } else if(i_2_ == 2) {
                            is[1536 + i_4_] = i_3_;
                            is[1537 + i_4_] = i_3_;
                            is[i_4_ + 1538] = i_3_;
                            is[1536 + i_4_ + 3] = i_3_;
                        }
                    }
                } else {
                    IndexedImage class40_sub5_sub14_sub2 = (SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[gameObjectDefinition.mapSceneID]);
                    if(class40_sub5_sub14_sub2 != null) {
                        int i_6_ = ((-class40_sub5_sub14_sub2.imgWidth + gameObjectDefinition.sizeX * 4) / 2);
                        int i_7_ = ((gameObjectDefinition.sizeY * 4 + -class40_sub5_sub14_sub2.imgHeight) / 2);
                        class40_sub5_sub14_sub2.drawImage(48 + (4 * arg2) + i_6_, i_7_ + (48 + ((104 + -arg5 - gameObjectDefinition.sizeY) * 4)));
                    }
                }
            }
            i = Npc.currentScene.getLocationHash(arg1, arg2, arg5);
            if(i != 0) {
                int i_8_ = Npc.currentScene.getArrangement(arg1, arg2, arg5, i);
                int i_9_ = 0x7fff & i >> 14;
                int i_10_ = (i_8_ & 0xf4) >> 6;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_9_);
                int i_11_ = i_8_ & 0x1f;
                if(gameObjectDefinition.mapSceneID != -1) {
                    IndexedImage class40_sub5_sub14_sub2 = (SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[gameObjectDefinition.mapSceneID]);
                    if(class40_sub5_sub14_sub2 != null) {
                        int i_12_ = ((-class40_sub5_sub14_sub2.imgHeight + gameObjectDefinition.sizeY * 4) / 2);
                        int i_13_ = ((gameObjectDefinition.sizeX * 4 + -class40_sub5_sub14_sub2.imgWidth) / 2);
                        class40_sub5_sub14_sub2.drawImage(i_13_ + arg2 * 4 + 48, 48 - (-(4 * (-arg5 + (104 + -gameObjectDefinition.sizeY))) + -i_12_));
                    }
                } else if(i_11_ == 9) {
                    int[] is = (Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.pixels);
                    int i_14_ = 15658734;
                    if(i > 0)
                        i_14_ = 15597568;
                    int i_15_ = (-(arg5 * 512) + 52736) * 4 + arg2 * 4 + 24624;
                    if(i_10_ == 0 || i_10_ == 2) {
                        is[1536 + i_15_] = i_14_;
                        is[1024 + (i_15_ + 1)] = i_14_;
                        is[514 + i_15_] = i_14_;
                        is[3 + i_15_] = i_14_;
                    } else {
                        is[i_15_] = i_14_;
                        is[513 + i_15_] = i_14_;
                        is[2 + (i_15_ + 1024)] = i_14_;
                        is[1536 + i_15_ + 3] = i_14_;
                    }
                }
            }
            i = Npc.currentScene.getFloorDecorationHash(arg1, arg2, arg5);
            if(i != 0) {
                int i_16_ = (i & 0x1fffd9fb) >> 14;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_16_);
                if(gameObjectDefinition.mapSceneID != -1) {
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

    public static void method783() {
        Cache.aClass9_326.method235((byte) -126);
        WallDecoration.aClass9_1264.method235((byte) -96);
        Class67.aClass9_1582.method235((byte) 34);
    }

    public static void method788() {
        aClass6_Sub1_3157 = null;
        aClass1_3092 = null;
        aClass1_3138 = null;
        aClass1_3114 = null;
        ChatBox.chatMessages = null;
        Player.trackedPlayers = null;
        aCacheIndex_3150 = null;
        aClass1_3155 = null;
        aCacheIndex_3144 = null;
        aClass31_3152 = null;
        anIntArray3111 = null;
        aClass1_3124 = null;
        anIntArray3149 = null;
        aClass1_3159 = null;
    }

    public static void method789(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg3 != Class51.regionX || arg2 != Class17.regionY || (Class40_Sub6.onBuildTimePlane != arg5 && VertexNormal.lowMemory)) {
            Class40_Sub6.onBuildTimePlane = arg5;
            Class51.regionX = arg3;
            if(!VertexNormal.lowMemory)
                Class40_Sub6.onBuildTimePlane = 0;
            Class17.regionY = arg2;
            OverlayDefinition.method559(25);
            Class51.method940(0, Class67.aClass1_1585, false, null);
            int i = Class26.baseY;
            int i_33_ = SpotAnimDefinition.baseX;
            SpotAnimDefinition.baseX = (arg3 - 6) * 8;
            int i_34_ = SpotAnimDefinition.baseX + -i_33_;
            if(arg1 != -1000)
                method781(14, 98, 96, -85, -118, 89);
            i_33_ = SpotAnimDefinition.baseX;
            Class26.baseY = (-6 + arg2) * 8;
            int i_35_ = Class26.baseY + -i;
            i = Class26.baseY;
            for(int i_36_ = 0; i_36_ < 32768; i_36_++) {
                Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_36_]);
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
            Player.worldLevel = arg5;
            int i_40_ = 0;
            Player.localPlayer.method787(arg4, -7717, false, arg0);
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
                            Wall.groundItems[i_50_][i_46_][i_47_] = null;
                        else
                            Wall.groundItems[i_50_][i_46_][i_47_] = (Wall.groundItems[i_50_][i_48_][i_49_]);
                    }
                }
            }
            for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) LinkedList.aLinkedList_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = ((Class40_Sub3) LinkedList.aLinkedList_1064.method909(-4))) {
                class40_sub3.anInt2038 -= i_35_;
                class40_sub3.anInt2039 -= i_34_;
                if(class40_sub3.anInt2039 < 0 || class40_sub3.anInt2038 < 0 || class40_sub3.anInt2039 >= 104 || class40_sub3.anInt2038 >= 104)
                    class40_sub3.method457(-1);
            }
            Buffer.anInt1985 = -1;
            if(VarbitDefinition.destinationX != 0) {
                VarbitDefinition.destinationX -= i_34_;
                Class55.destinationY -= i_35_;
            }
            Class39.aBoolean906 = false;
            PacketBuffer.currentSound = 0;
            Class57.aLinkedList_1332.method906(0);
            Class43.aLinkedList_1022.method906(0);
        }
    }

    public void method782(int arg0, byte arg1, boolean arg2) {
        int i = pathY[0];
        int i_19_ = pathX[0];
        if(arg0 == 0) {
            i_19_++;
            i--;
        }
        if(playingAnimation != -1 && (Class68_Sub1.method1050(playingAnimation, arg1 ^ -94).anInt2476 == 1))
            playingAnimation = -1;
        if(anInt3109 < 9)
            anInt3109++;
        for(int i_20_ = anInt3109; i_20_ > 0; i_20_--) {
            pathY[i_20_] = pathY[i_20_ + -1];
            pathX[i_20_] = pathX[i_20_ - 1];
            aBooleanArray3072[i_20_] = aBooleanArray3072[-1 + i_20_];
        }
        if(arg0 == 1)
            i_19_++;
        if(arg1 != -96)
            method783();
        if(arg0 == 2) {
            i_19_++;
            i++;
        }
        if(arg0 == 3)
            i--;
        if(arg0 == 4)
            i++;
        if(arg0 == 5) {
            i--;
            i_19_--;
        }
        if(arg0 == 6)
            i_19_--;
        if(arg0 == 7) {
            i++;
            i_19_--;
        }
        pathY[0] = i;
        pathX[0] = i_19_;
        aBooleanArray3072[0] = arg2;
    }

    public boolean isVisible(int arg0) {
        return false;
    }

    public void method785(int arg0, int arg1, int arg2, int arg3) {
        for(int i = 0; i < 4; i++) {
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
        if(playingAnimation != -1 && Class68_Sub1.method1050(playingAnimation, 2).anInt2476 == 1)
            playingAnimation = -1;
        if(!arg2) {
            int i = -pathY[0] + arg3;
            int i_31_ = -pathX[0] + arg0;
            if(i >= -8 && i <= 8 && i_31_ >= -8 && i_31_ <= 8) {
                if(anInt3109 < 9)
                    anInt3109++;
                for(int i_32_ = anInt3109; i_32_ > 0; i_32_--) {
                    pathY[i_32_] = pathY[-1 + i_32_];
                    pathX[i_32_] = pathX[-1 + i_32_];
                    aBooleanArray3072[i_32_] = aBooleanArray3072[i_32_ + -1];
                }
                pathY[0] = arg3;
                pathX[0] = arg0;
                aBooleanArray3072[0] = false;
                return;
            }
        }
        anInt3109 = 0;
        anInt3074 = 0;
        if(arg1 != -7717)
            method785(-19, 10, -70, -9);
        anInt3094 = 0;
        pathY[0] = arg3;
        pathX[0] = arg0;
        worldX = anInt3096 * 64 + pathY[0] * 128;
        worldY = anInt3096 * 64 + pathX[0] * 128;
    }

    public void method790(int arg0) {
        anInt3094 = arg0;
        anInt3109 = 0;
    }
}
