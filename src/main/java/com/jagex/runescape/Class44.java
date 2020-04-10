package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class44 implements Runnable {
    public static int[][] anIntArrayArray1030;
    public static RSString aClass1_1032;
    public static RSString aClass1_1033 = RSString.CreateString("Please remove ");
    public static int modewhat = 0;
    public static RSString aClass1_1038;
    public static byte[][] aByteArrayArray1039 = new byte[250][];
    public static int anInt1040 = 256;
    public static RSString aClass1_1041 = RSString.CreateString("(U");
    public static int modewhere = 0;
    public static RSString aClass1_1043 = RSString.CreateString("null");
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1047;
    public static int anInt1048 = -1;
    public static int anInt1049 = 0;

    static {
        aClass1_1032 = aClass1_1033;
        aClass1_1038 = aClass1_1033;
    }

    public static void addChatMessage(RSString name, RSString message, int type) {
        if(ChatBox.openChatboxWidgetId == -1)
            ChatBox.redrawChatbox = true;
        if(type == 0 && ChatBox.dialogueId != -1) {
            MouseHandler.clickType = 0;
            GameShell.clickToContinueString = message;
        }
        for(int i = 99; i > 0; i--) {
            ChatBox.chatTypes[i] = ChatBox.chatTypes[i + -1];
            ChatBox.chatPlayerNames[i] = ChatBox.chatPlayerNames[-1 + i];
            ChatBox.chatMessages[i] = ChatBox.chatMessages[-1 + i];
        }
        ChatBox.chatTypes[0] = type;
        ChatBox.chatPlayerNames[0] = name;
        ChatBox.chatMessages[0] = message;
    }

    public static void method896() {
        aClass40_Sub5_Sub14_Sub2_1047 = null;
        aClass1_1033 = null;
        aByteArrayArray1039 = null;
        aClass1_1041 = null;
        aClass1_1032 = null;
        aClass1_1038 = null;
        anIntArrayArray1030 = null;
        aClass1_1043 = null;
    }

    public static void method898(int arg0, Actor arg1) {
        arg1.anInt3077 = arg1.idleAnimation;
        if(arg1.anInt3109 == 0)
            arg1.anInt3074 = 0;
        else {
            if(arg1.playingAnimation != -1 && arg1.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = Class68_Sub1.method1050(arg1.playingAnimation, 2);
                if(arg1.anInt3094 > 0 && animationSequence.anInt2470 == 0) {
                    arg1.anInt3074++;
                    return;
                }
                if(arg1.anInt3094 <= 0 && animationSequence.anInt2476 == 0) {
                    arg1.anInt3074++;
                    return;
                }
            }
            int i = arg1.worldX;
            int i_0_ = (arg1.pathY[-1 + arg1.anInt3109] * 128 + (64 * arg1.anInt3096));
            int i_1_ = arg1.worldY;
            int i_2_ = (64 * arg1.anInt3096 + arg1.pathX[arg1.anInt3109 + -1] * 128);
            if(-i + i_0_ > 256 || -i + i_0_ < -256 || -i_1_ + i_2_ > 256 || i_2_ + -i_1_ < -256) {
                arg1.worldX = i_0_;
                arg1.worldY = i_2_;
            } else {
                if((i < i_0_)) {
                    if((i_1_ < i_2_))
                        arg1.anInt3080 = 1280;
                    else if(i_2_ < i_1_)
                        arg1.anInt3080 = 1792;
                    else
                        arg1.anInt3080 = 1536;
                } else if((i <= i_0_)) {
                    if((i_2_ <= i_1_)) {
                        if(i_2_ < i_1_)
                            arg1.anInt3080 = 0;
                    } else
                        arg1.anInt3080 = 1024;
                } else if((i_1_ < i_2_))
                    arg1.anInt3080 = 768;
                else if((i_2_ < i_1_))
                    arg1.anInt3080 = 256;
                else
                    arg1.anInt3080 = 512;
                int i_3_ = arg1.turnAroundAnimationId;
                int i_4_ = 4;
                if(arg1.anInt3080 != arg1.anInt3118 && arg1.facingActorIndex == -1 && arg1.anInt3113 != 0)
                    i_4_ = 2;
                if(arg1.anInt3109 > 2)
                    i_4_ = 6;
                if(arg1.anInt3109 > 3)
                    i_4_ = 8;
                int i_5_ = 0x7ff & -arg1.anInt3118 + arg1.anInt3080;
                if(i_5_ > 1024)
                    i_5_ -= 2048;
                if((i_5_ ^ 0xffffffff) > arg0 || i_5_ > 256) {
                    if(i_5_ < 256 || i_5_ >= 768) {
                        if(i_5_ >= -768 && i_5_ <= -256)
                            i_3_ = arg1.turnRightAnimationId;
                    } else
                        i_3_ = arg1.turnLeftAnimationId;
                } else
                    i_3_ = arg1.walkAnimationId;
                if(i_3_ == -1)
                    i_3_ = arg1.walkAnimationId;
                arg1.anInt3077 = i_3_;
                if(arg1.anInt3074 > 0 && arg1.anInt3109 > 1) {
                    arg1.anInt3074--;
                    i_4_ = 8;
                }
                if(arg1.aBooleanArray3072[-1 + arg1.anInt3109])
                    i_4_ <<= 1;
                if((i_1_ < i_2_)) {
                    arg1.worldY += i_4_;
                    if(arg1.worldY > i_2_)
                        arg1.worldY = i_2_;
                } else if(i_1_ > i_2_) {
                    arg1.worldY -= i_4_;
                    if((arg1.worldY < i_2_))
                        arg1.worldY = i_2_;
                }
                if(i_4_ >= 8 && arg1.anInt3077 == arg1.walkAnimationId && arg1.runAnimationId != -1)
                    arg1.anInt3077 = arg1.runAnimationId;
                if(i < i_0_) {
                    arg1.worldX += i_4_;
                    if((i_0_ < arg1.worldX))
                        arg1.worldX = i_0_;
                } else if(i_0_ < i) {
                    arg1.worldX -= i_4_;
                    if(i_0_ > arg1.worldX)
                        arg1.worldX = i_0_;
                }
                if(arg1.worldX == i_0_ && i_2_ == arg1.worldY) {
                    if(arg1.anInt3094 > 0)
                        arg1.anInt3094--;
                    arg1.anInt3109--;
                }
            }
        }
    }

    public void run() {
        try {
            for(; ; ) {
                Class40_Sub6 class40_sub6;
                synchronized(RSCanvas.aLinkedList_53) {
                    class40_sub6 = ((Class40_Sub6) RSCanvas.aLinkedList_53.method902((byte) -90));
                }
                if(class40_sub6 == null) {
                    Class43.method890(100L, 113);
                    synchronized(CollisionMap.anObject162) {
                        if(Buffer.anInt1987 <= 1) {
                            Buffer.anInt1987 = 0;
                            CollisionMap.anObject162.notifyAll();
                            break;
                        }
                        Buffer.anInt1987--;
                    }
                } else {
                    if(class40_sub6.anInt2112 == 0) {
                        class40_sub6.aClass56_2117.method971(class40_sub6.aByteArray2102, 1862596560, class40_sub6.aByteArray2102.length, (int) class40_sub6.key);
                        synchronized(RSCanvas.aLinkedList_53) {
                            class40_sub6.method457(-1);
                        }
                    } else if(class40_sub6.anInt2112 == 1) {
                        class40_sub6.aByteArray2102 = (class40_sub6.aClass56_2117.method969((int) class40_sub6.key));
                        synchronized(RSCanvas.aLinkedList_53) {
                            IdentityKit.aLinkedList_2604.pushBack(class40_sub6, 115);
                        }
                    }
                    synchronized(CollisionMap.anObject162) {
                        if(Buffer.anInt1987 <= 1) {
                            Buffer.anInt1987 = 0;
                            CollisionMap.anObject162.notifyAll();
                            break;
                        }
                        Buffer.anInt1987 = 600;
                    }
                }
            }
        } catch(Exception exception) {
            CacheIndex.method169(null, (byte) -127, exception);
        }
    }
}
