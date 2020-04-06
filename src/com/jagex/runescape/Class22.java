package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.util.CollisionMap;

public abstract class Class22 {
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array535;
    public static int anInt537 = 0;
    public static boolean membersWorld = false;
    public static boolean accountFlagged = false;
    public static int anInt545;
    public static int anInt547 = 0;
    public static boolean[] aBooleanArray548 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, false};

    public static void method298() {
        English.yourAccountIsAlreadyLoggedIn = null;
        aClass40_Sub5_Sub14_Sub2Array535 = null;
        Player.trackedPlayerAppearanceCache = null;
        Native.suffixM = null;
        aBooleanArray548 = null;
    }

    public static void method299(byte arg0, int arg1) {
        int[] is = (Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.pixels);
        int i = is.length;
        for(int i_0_ = 0; i > i_0_; i_0_++)
            is[i_0_] = 0;
        for(int i_1_ = 1; i_1_ < 103; i_1_++) {
            int i_2_ = 24628 + ((-(512 * i_1_) + 52736) * 4);
            for(int i_3_ = 1; i_3_ < 103; i_3_++) {
                if((0x18 & (OverlayDefinition.tile_flags[arg1][i_3_][i_1_])) == 0)
                    Npc.currentScene.method96(is, i_2_, 512, arg1, i_3_, i_1_);
                if(arg1 < 3 && ((OverlayDefinition.tile_flags[1 + arg1][i_3_][i_1_]) & 0x8) != 0)
                    Npc.currentScene.method96(is, i_2_, 512, 1 + arg1, i_3_, i_1_);
                i_2_ += 4;
            }
        }
        Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.method723();
        int i_4_ = ((-10 + (int) (Math.random() * 20.0) + 238 << 8) + (228 + (int) (Math.random() * 20.0) << 16) + (238 + (int) (20.0 * Math.random())) + -10);
        int i_5_ = -10 + ((int) (20.0 * Math.random()) + 238) << 16;
        for(int i_6_ = 1; i_6_ < 103; i_6_++) {
            for(int i_7_ = 1; i_7_ < 103; i_7_++) {
                if(((OverlayDefinition.tile_flags[arg1][i_7_][i_6_]) & 0x18) == 0)
                    Actor.method781(1850, arg1, i_7_, i_4_, i_5_, i_6_);
                if(arg1 < 3 && (0x8 & (OverlayDefinition.tile_flags[1 + arg1][i_7_][i_6_])) != 0)
                    Actor.method781(1850, 1 + arg1, i_7_, i_4_, i_5_, i_6_);
            }
        }
        GameObject.anInt3040 = 0;
        if(arg0 < 24)
            Player.trackedPlayerAppearanceCache = null;
        for(int i_8_ = 0; i_8_ < 104; i_8_++) {
            for(int i_9_ = 0; i_9_ < 104; i_9_++) {
                int i_10_ = (Npc.currentScene.getFloorDecorationHash(Player.worldLevel, i_8_, i_9_));
                if(i_10_ != 0) {
                    i_10_ = 0x7fff & i_10_ >> 14;
                    int i_11_ = (GameObjectDefinition.getDefinition(i_10_).icon);
                    if(i_11_ >= 0) {
                        int i_12_ = i_9_;
                        int i_13_ = i_8_;
                        if(i_11_ != 22 && i_11_ != 29 && i_11_ != 34 && i_11_ != 36 && i_11_ != 46 && i_11_ != 47 && i_11_ != 48) {
                            int[][] is_14_ = (Landscape.currentCollisionMap[Player.worldLevel].clippingData);
                            for(int i_15_ = 0; i_15_ < 10; i_15_++) {
                                int i_16_ = (int) (Math.random() * 4.0);
                                if(i_16_ == 0 && i_13_ > 0 && i_13_ > -3 + i_8_ && (is_14_[-1 + i_13_][i_12_] & 0x1280108) == 0)
                                    i_13_--;
                                if(i_16_ == 1 && i_13_ < 103 && i_13_ < i_8_ + 3 && (is_14_[i_13_ + 1][i_12_] & 0x1280180) == 0)
                                    i_13_++;
                                if(i_16_ == 2 && i_12_ > 0 && i_12_ > -3 + i_9_ && (is_14_[i_13_][i_12_ - 1] & 0x1280102) == 0)
                                    i_12_--;
                                if(i_16_ == 3 && i_12_ < 103 && 3 + i_9_ > i_12_ && (0x1280120 & is_14_[i_13_][1 + i_12_]) == 0)
                                    i_12_++;
                            }
                        }
                        MouseHandler.aClass40_Sub5_Sub14_Sub4Array1466[GameObject.anInt3040] = (Class8.aClass40_Sub5_Sub14_Sub4Array296[i_11_]);
                        Actor.anIntArray3149[GameObject.anInt3040] = i_13_;
                        LinkedList.anIntArray1083[(GameObject.anInt3040)] = i_12_;
                        GameObject.anInt3040++;
                    }
                }
            }
        }
    }

    public static void method305(byte arg0) {
        RSCanvas.aClass68_64.method1046((byte) 90);
        Class44.aClass40_Sub5_Sub14_Sub2_1047.drawImage(0, 0);
        Class5.anIntArray198 = Rasterizer3D.method708(Class5.anIntArray198);
    }

    public static RSString method307(Buffer arg0, int arg1, int arg2) {
        try {
            if(arg1 != -1)
                aBooleanArray548 = null;
            RSString class1 = new RSString();
            class1.length = arg0.getSmart();
            if(class1.length > arg2)
                class1.length = arg2;
            class1.chars = new byte[class1.length];
            arg0.currentPosition += (IdentityKit.aHuffmanEncoding_2590.method1023(arg0.buffer, class1.length, 0, class1.chars, arg0.currentPosition, -1));
            return class1;
        } catch(Exception exception) {
            return Class33.aClass1_777;
        }
    }

    public static void method308() {
        RSString.method56(false, null, 0);
    }

    public static void method309(int arg0, int arg1) {
        do {
            AnimationSequence.anInt2480 = Node.pulseCycle;
            HuffmanEncoding.method1030((byte) 127);
            int i = (Npc.method795((byte) -70, arg1).anInt2633);
            if(i != 0) {
                int i_21_ = GroundItemTile.varbitmasks[arg1];
                if(i == 1) {
                    if(i_21_ == 1) {
                        Rasterizer3D.method711(0.9);
                        ((Class35) Rasterizer3D.anInterface3_2939).method424(0.9);
                    }
                    if(i_21_ == 2) {
                        Rasterizer3D.method711(0.8);
                        ((Class35) Rasterizer3D.anInterface3_2939).method424(0.8);
                    }
                    if(i_21_ == 3) {
                        Rasterizer3D.method711(0.7);
                        ((Class35) Rasterizer3D.anInterface3_2939).method424(0.7);
                    }
                    if(i_21_ == 4) {
                        Rasterizer3D.method711(0.6);
                        ((Class35) Rasterizer3D.anInterface3_2939).method424(0.6);
                    }
                    GameObject.method774((byte) -96);
                    Class40_Sub5_Sub11.clearScreen = true;
                }
                if(i == 3) {
                    int i_22_ = 0;
                    if(i_21_ == 0)
                        i_22_ = 255;
                    if(i_21_ == 1)
                        i_22_ = 192;
                    if(i_21_ == 2)
                        i_22_ = 128;
                    if(i_21_ == 3)
                        i_22_ = 64;
                    if(i_21_ == 4)
                        i_22_ = 0;
                    if(i_22_ != RSCanvas.anInt60) {
                        if(RSCanvas.anInt60 != 0 || MouseHandler.anInt1457 == -1) {
                            if(i_22_ == 0) {
                                Class33.method402(false);
                                Class35.songTimeout = 0;
                            } else
                                Node.method456(i_22_);
                        } else {
                            Class33.method414(false, 0, MouseHandler.anInt1457, i_22_, 0, Class55.aClass6_Sub1_1286);
                            Class35.songTimeout = 0;
                        }
                        RSCanvas.anInt60 = i_22_;
                    }
                }
                if(i == 9)
                    Class43.bankInsertMode = i_21_;
                if(i == 10) {
                    if(i_21_ == 0)
                        RSCanvas.anInt65 = 127;
                    if(i_21_ == 1)
                        RSCanvas.anInt65 = 96;
                    if(i_21_ == 2)
                        RSCanvas.anInt65 = 64;
                    if(i_21_ == 3)
                        RSCanvas.anInt65 = 32;
                    if(i_21_ == 4)
                        RSCanvas.anInt65 = 0;
                }
                if(i == 8) {
                    ChatBox.redrawChatbox = true;
                    CollisionMap.anInt165 = i_21_;
                }
                if(i == 4) {
                    if(i_21_ == 0)
                        Class5.anInt200 = 127;
                    if(i_21_ == 1)
                        Class5.anInt200 = 96;
                    if(i_21_ == 2)
                        Class5.anInt200 = 64;
                    if(i_21_ == 3)
                        Class5.anInt200 = 32;
                    if(i_21_ == 4)
                        Class5.anInt200 = 0;
                }
                if(i == 6)
                    Class40_Sub5_Sub1.anInt2280 = i_21_;
                if(arg0 != -1)
                    method309(74, -85);
                if(i != 5)
                    break;
                Class68.oneMouseButton = i_21_;
            }

            break;
        } while(false);
    }

    public abstract void method300(byte[] is, boolean bool, int i, int i_17_);

    public abstract void method301(int i, int i_18_);

    public abstract void method302(int i);

    public abstract void method303(byte i);

    public abstract void method304(byte i, int i_19_, int i_20_);

    public abstract void method306(byte i);
}
