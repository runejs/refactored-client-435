package org.runejs.client.cache.media;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.node.CachedNode;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.util.BitUtils;

public class AnimationSequence extends CachedNode {
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2474;
    public static int anInt2480 = 0;
    public static ImageRGB minimapCompass;
    public static CacheArchive aCacheArchive_2484;
    public static int[][] tileLightIntensity;

    public int[] frameLengths;
    public int precedenceAnimating = -1;
    public int[] interleaveLeave;
    public int priority = -1;
    public int offHandModel;
    public int[] unknownArray1;
    public int replyMode = 2;
    public int[] frameIds;
    public int mainHandModel;
    public int forcedPriority;
    public int maxLoops;
    public boolean stretches;
    public int frameStep;

    public AnimationSequence() {
        offHandModel = -1;
        mainHandModel = -1;
        forcedPriority = 5;
        maxLoops = 99;
        frameStep = -1;
        stretches = false;
    }

    public static void loadTerrainBlock(CollisionMap[] collisions, int regionX_maybe, byte[] blockData, int offsetX, int offsetY, int regionY_maybe) {
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; i_1_ < 64; i_1_++) {
                for(int i_2_ = 0; i_2_ < 64; i_2_++) {
                    if(offsetX + i_1_ > 0 && i_1_ + offsetX < 103 && offsetY + i_2_ > 0 && i_2_ + offsetY < 103)
                        collisions[i].clippingData[i_1_ + offsetX][i_2_ + offsetY] = BitUtils.bitWiseAND(collisions[i].clippingData[i_1_ + offsetX][i_2_ + offsetY], -16777217);
                }
            }
        }
        Buffer class40_sub1 = new Buffer(blockData);
        if(true) {
            for(int plane = 0; plane < 4; plane++) {
                for(int tileX = 0; tileX < 64; tileX++) {
                    for(int tileY = 0; tileY < 64; tileY++)
                        MovedStatics.method922(tileX + offsetX, 0, class40_sub1, tileY + offsetY, regionY_maybe, regionX_maybe, plane);
                }
            }
        }
    }

    public static boolean method596(int arg0, int arg1, byte junk, int arg3) {
        int i = 0x7fff & arg1 >> 14;
        int i_14_ = Npc.currentScene.getArrangement(Player.worldLevel, arg0, arg3, arg1);
        if(i_14_ == -1)
            return false;
        int i_15_ = 0x3 & i_14_ >> 6;
        int i_16_ = 0x1f & i_14_;
        if(i_16_ != 10 && i_16_ != 11 && i_16_ != 22)
            Pathfinding.doWalkTo(2, Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], arg0, arg3, 0, 0, 0, 1 + i_16_, true, i_15_);
        else {
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
            int i_17_ = gameObjectDefinition.blockingMask;
            if(i_15_ != 0)
                i_17_ = (i_17_ >> 4 + -i_15_) + (0xf & i_17_ << i_15_);
            int i_18_;
            int i_19_;
            if(i_15_ == 0 || i_15_ == 2) {
                i_19_ = gameObjectDefinition.sizeY;
                i_18_ = gameObjectDefinition.sizeX;
            } else {
                i_18_ = gameObjectDefinition.sizeY;
                i_19_ = gameObjectDefinition.sizeX;
            }
            Pathfinding.doWalkTo(2, Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], arg0, arg3, i_18_, i_19_, i_17_, 0, true, 0);
        }
        ClientScriptRunner.crossX = Class57.clickX;
        LinkedList.crossType = 2;
        MovedStatics.crossY = RSString.clickY;
        OverlayDefinition.crossIndex = 0;
        return true;
    }

    public Model method590(Model arg0, AnimationSequence animationSequence, int arg2, int arg3, byte arg4) {
        arg2 = frameIds[arg2];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960(arg2 >> 16);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return animationSequence.method599(arg3, arg0, false);
        arg3 = animationSequence.frameIds[arg3];
        Class40_Sub5_Sub15 class40_sub5_sub15_0_ = Class55.method960(arg3 >> 16);
        arg3 &= 0xffff;
        if(class40_sub5_sub15_0_ == null) {
            Model model = arg0.method817(!class40_sub5_sub15.method737(arg2));
            model.method825(class40_sub5_sub15, arg2);
            return model;
        }
        if(arg4 != 63)
            return null;
        Model model = arg0.method817(!class40_sub5_sub15.method737(arg2) & !class40_sub5_sub15_0_.method737(arg3));
        model.method809(class40_sub5_sub15, arg2, class40_sub5_sub15_0_, arg3, interleaveLeave);
        return model;
    }

    public void method591() {
        if(priority == -1) {
            if(interleaveLeave == null)
                priority = 0;
            else
                priority = 2;
        }
        if(precedenceAnimating == -1) {
            if(interleaveLeave == null)
                precedenceAnimating = 0;
            else
                precedenceAnimating = 2;
        }
    }

    public Model method593(int arg0, boolean arg1, Model model, int arg3) {
        arg0 = frameIds[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960(arg0 >> 16);
        if(arg1)
            unknownArray1 = null;
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return model.method817(true);
        arg3 &= 0x3;
        Model newModel = model.method817(!class40_sub5_sub15.method737(arg0));
        if(arg3 == 1)
            newModel.method824();
        else if(arg3 == 2)
            newModel.method819();
        else if(arg3 == 3)
            newModel.method813();
        newModel.method825(class40_sub5_sub15, arg0);
        if(arg3 != 1) {
            if(arg3 != 2) {
                if(arg3 == 3)
                    newModel.method824();
            } else
                newModel.method819();
        } else
            newModel.method813();
        return newModel;
    }

    public void decodeAllAnimationSequences(Buffer buffer) {
        for(; ; ) {
            int i = buffer.getUnsignedByte();
            if(i == 0) {
                break;
            }
            decodeAnimationSequence(i, buffer);
        }
    }

    public void decodeAnimationSequence(int opcode, Buffer buffer) {
        if(opcode == 1) {
            int frameCount = buffer.getUnsignedByte();
            frameLengths = new int[frameCount];
            for(int i = 0; frameCount > i; i++) {
                frameLengths[i] = buffer.getUnsignedShortBE();
            }

            frameIds = new int[frameCount];
            for(int i = 0; frameCount > i; i++) {
                frameIds[i] = buffer.getUnsignedShortBE();
            }
            for(int i = 0; i < frameCount; i++) {
                frameIds[i] = (buffer.getUnsignedShortBE() << 16) + frameIds[i];
            }
        } else if(opcode == 2) {
            frameStep = buffer.getUnsignedShortBE();
        } else if(opcode == 3) {
            int interleaveCount = buffer.getUnsignedByte();
            interleaveLeave = new int[1 + interleaveCount];
            for(int i = 0; interleaveCount > i; i++) {
                interleaveLeave[i] = buffer.getUnsignedByte();
            }
            interleaveLeave[interleaveCount] = 9999999;
        } else if(opcode == 4) {
            stretches = true;
        } else if(opcode == 5) {
            forcedPriority = buffer.getUnsignedByte();
        } else if(opcode == 6) {
            offHandModel = buffer.getUnsignedShortBE();
        } else if(opcode == 7) {
            mainHandModel = buffer.getUnsignedShortBE();
        } else if(opcode == 8) {
            maxLoops = buffer.getUnsignedByte();
        } else if(opcode == 9) {
            precedenceAnimating = buffer.getUnsignedByte();
        } else if(opcode == 10) {
            priority = buffer.getUnsignedByte();
        } else if(opcode == 11) {
            replyMode = buffer.getUnsignedByte();
        } else if(opcode == 12) {
            int unknownArray1Count = buffer.getUnsignedByte();
            unknownArray1 = new int[unknownArray1Count];
            for(int i = 0; i < unknownArray1Count; i++) {
                unknownArray1[i] = buffer.getUnsignedShortBE();
            }
            for(int i = 0; unknownArray1Count > i; i++) {
                unknownArray1[i] = (buffer.getUnsignedShortBE() << 16) + unknownArray1[i];
            }
        }
    }

    public Model method597(byte arg0, Model arg1, int arg2) {
        arg2 = frameIds[arg2];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960(arg2 >> 16);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method806(true);
        if(arg0 != -87)
            return null;
        Model class40_sub5_sub17_sub5 = arg1.method806(!class40_sub5_sub15.method737(arg2));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg2);
        return class40_sub5_sub17_sub5;
    }

    public Model method598(int arg0, Model arg1, boolean arg2) {
        int i = frameIds[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960(i >> 16);
        i &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        if(!arg2)
            decodeAllAnimationSequences(null);
        Class40_Sub5_Sub15 class40_sub5_sub15_20_ = null;
        int i_21_ = 0;
        if(unknownArray1 != null && arg0 < unknownArray1.length) {
            i_21_ = unknownArray1[arg0];
            class40_sub5_sub15_20_ = Class55.method960(i_21_ >> 16);
            i_21_ &= 0xffff;
        }
        if(class40_sub5_sub15_20_ == null || i_21_ == 65535) {
            Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(i));
            class40_sub5_sub17_sub5.method825(class40_sub5_sub15, i);
            return class40_sub5_sub17_sub5;
        }
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(i) & !class40_sub5_sub15_20_.method737(i_21_));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, i);
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15_20_, i_21_);
        return class40_sub5_sub17_sub5;
    }

    public Model method599(int arg0, Model arg1, boolean arg2) {
        if(arg2)
            method591();
        arg0 = frameIds[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960(arg0 >> 16);
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(arg0));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg0);
        return class40_sub5_sub17_sub5;
    }
}
