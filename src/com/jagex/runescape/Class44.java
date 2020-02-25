package com.jagex.runescape;

import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class44 implements Runnable {
    public static int anInt1029;
    public static int[][] anIntArrayArray1030;
    public static int anInt1031;
    public static RSString aClass1_1032;
    public static RSString aClass1_1033;
    public static RSString aClass1_1034;
    public static int modewhat;
    public static int anInt1036;
    public static int anInt1037;
    public static RSString aClass1_1038;
    public static byte[][] aByteArrayArray1039 = new byte[250][];
    public static int anInt1040;
    public static RSString aClass1_1041;
    public static int modewhere = 0;
    public static RSString aClass1_1043;
    public static int anInt1044;
    public static int anInt1045;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1047;
    public static int anInt1048;
    public static int anInt1049;
    public static int anInt1050;

    static {
        anInt1040 = 256;
        aClass1_1034 = RSString.CreateString("System)2Update in: ");
        aClass1_1041 = RSString.CreateString("(U");
        modewhat = 0;
        anInt1049 = 0;
        aClass1_1043 = RSString.CreateString("null");
        aClass1_1033 = RSString.CreateString("Please remove ");
        aClass1_1032 = aClass1_1033;
        aClass1_1038 = aClass1_1033;
        anInt1048 = -1;
    }

    public static void method895(int arg0, int arg1, RSString arg2, RSString arg3) {

        anInt1029++;
        if(Class43.openChatboxWidgetId == -1)
            Class52.redrawChatbox = true;
        if(arg1 == 0 && (Class48.anInt1138 ^ 0xffffffff) != 0) {
            GameFrame.clickType = 0;
            RSApplet.aClass1_8 = arg2;
        }
        for(int i = 99; (i ^ 0xffffffff) < -1; i--) {
            HuffmanEncoding.chatTypes[i] = HuffmanEncoding.chatTypes[i + -1];
            Renderable.chatPlayerNames[i] = Renderable.chatPlayerNames[-1 + i];
            Actor.chatMessages[i] = Actor.chatMessages[-1 + i];
        }
        HuffmanEncoding.chatTypes[0] = arg1;
        Renderable.chatPlayerNames[0] = arg3;
        if(arg0 >= 60)
            Actor.chatMessages[0] = arg2;

    }

    public static void method896(int arg0) {

        aClass1_1034 = null;
        aClass40_Sub5_Sub14_Sub2_1047 = null;
        aClass1_1033 = null;
        aByteArrayArray1039 = null;
        if(arg0 == -1) {
            aClass1_1041 = null;
            aClass1_1032 = null;
            aClass1_1038 = null;
            anIntArrayArray1030 = null;
            aClass1_1043 = null;
        }

    }

    public static void method898(int arg0, Actor arg1) {
        anInt1037++;
        arg1.anInt3077 = arg1.anInt3126;
        if((arg1.anInt3109 ^ 0xffffffff) == -1)
            arg1.anInt3074 = 0;
        else {
            if((arg1.playingAnimation ^ 0xffffffff) != 0 && arg1.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = Class68_Sub1.method1050(arg1.playingAnimation, 2);
                if((arg1.anInt3094 ^ 0xffffffff) < -1 && animationSequence.anInt2470 == 0) {
                    arg1.anInt3074++;
                    return;
                }
                if(arg1.anInt3094 <= 0 && (animationSequence.anInt2476 ^ 0xffffffff) == -1) {
                    arg1.anInt3074++;
                    return;
                }
            }
            int i = arg1.anInt3098;
            int i_0_ = (arg1.anIntArray3088[-1 + arg1.anInt3109] * 128 + (64 * arg1.anInt3096));
            int i_1_ = arg1.anInt3089;
            int i_2_ = (64 * arg1.anInt3096 + arg1.anIntArray3135[arg1.anInt3109 + -1] * 128);
            if(-i + i_0_ > 256 || (-i + i_0_ ^ 0xffffffff) > 255 || -i_1_ + i_2_ > 256 || i_2_ + -i_1_ < -256) {
                arg1.anInt3098 = i_0_;
                arg1.anInt3089 = i_2_;
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
                int i_3_ = arg1.anInt3079;
                int i_4_ = 4;
                if(arg1.anInt3080 != arg1.anInt3118 && (arg1.facingActorIndex ^ 0xffffffff) == 0 && arg1.anInt3113 != 0)
                    i_4_ = 2;
                if(arg1.anInt3109 > 2)
                    i_4_ = 6;
                if(arg1.anInt3109 > 3)
                    i_4_ = 8;
                int i_5_ = 0x7ff & -arg1.anInt3118 + arg1.anInt3080;
                if(i_5_ > 1024)
                    i_5_ -= 2048;
                if((i_5_ ^ 0xffffffff) > arg0 || (i_5_ ^ 0xffffffff) < -257) {
                    if(i_5_ < 256 || i_5_ >= 768) {
                        if((i_5_ ^ 0xffffffff) <= 767 && (i_5_ ^ 0xffffffff) >= 255)
                            i_3_ = arg1.anInt3075;
                    } else
                        i_3_ = arg1.anInt3132;
                } else
                    i_3_ = arg1.anInt3131;
                if(i_3_ == -1)
                    i_3_ = arg1.anInt3131;
                arg1.anInt3077 = i_3_;
                if((arg1.anInt3074 ^ 0xffffffff) < -1 && (arg1.anInt3109 ^ 0xffffffff) < -2) {
                    arg1.anInt3074--;
                    i_4_ = 8;
                }
                if(arg1.aBooleanArray3072[-1 + arg1.anInt3109])
                    i_4_ <<= 1;
                if((i_1_ < i_2_)) {
                    arg1.anInt3089 += i_4_;
                    if(arg1.anInt3089 > i_2_)
                        arg1.anInt3089 = i_2_;
                } else if(i_1_ > i_2_) {
                    arg1.anInt3089 -= i_4_;
                    if((arg1.anInt3089 < i_2_))
                        arg1.anInt3089 = i_2_;
                }
                if((i_4_ ^ 0xffffffff) <= -9 && arg1.anInt3077 == arg1.anInt3131 && arg1.anInt3082 != -1)
                    arg1.anInt3077 = arg1.anInt3082;
                if(i < i_0_) {
                    arg1.anInt3098 += i_4_;
                    if((i_0_ < arg1.anInt3098))
                        arg1.anInt3098 = i_0_;
                } else if(i_0_ < i) {
                    arg1.anInt3098 -= i_4_;
                    if(i_0_ > arg1.anInt3098)
                        arg1.anInt3098 = i_0_;
                }
                if(arg1.anInt3098 == i_0_ && i_2_ == arg1.anInt3089) {
                    if((arg1.anInt3094 ^ 0xffffffff) < -1)
                        arg1.anInt3094--;
                    arg1.anInt3109--;
                }
            }
        }
    }

    public void run() {

        anInt1031++;
        try {
            for(; ; ) {
                Class40_Sub6 class40_sub6;
                synchronized(RSCanvas.aClass45_53) {
                    class40_sub6 = ((Class40_Sub6) RSCanvas.aClass45_53.method902((byte) -90));
                }
                if(class40_sub6 == null) {
                    Class43.method890(100L, 113);
                    synchronized(CollisionMap.anObject162) {
                        if((Buffer.anInt1987 ^ 0xffffffff) >= -2) {
                            Buffer.anInt1987 = 0;
                            CollisionMap.anObject162.notifyAll();
                            break;
                        }
                        Buffer.anInt1987--;
                    }
                } else {
                    if((class40_sub6.anInt2112 ^ 0xffffffff) != -1) {
                        if(class40_sub6.anInt2112 == 1) {
                            class40_sub6.aByteArray2102 = (class40_sub6.aClass56_2117.method969((int) class40_sub6.key, (byte) -111));
                            synchronized(RSCanvas.aClass45_53) {
                                IdentityKit.aClass45_2604.method904(class40_sub6, 115);
                            }
                        }
                    } else {
                        class40_sub6.aClass56_2117.method971(class40_sub6.aByteArray2102, 1862596560, class40_sub6.aByteArray2102.length, (int) class40_sub6.key);
                        synchronized(RSCanvas.aClass45_53) {
                            class40_sub6.method457(-1);
                        }
                    }
                    synchronized(CollisionMap.anObject162) {
                        if((Buffer.anInt1987 ^ 0xffffffff) >= -2) {
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
