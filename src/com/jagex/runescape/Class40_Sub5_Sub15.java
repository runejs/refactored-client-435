package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.FrameDefinition;
import com.jagex.runescape.cache.def.FramemapDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class40_Sub5_Sub15 extends SubNode {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2775;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array2776;
    public static int[] anIntArray2777 = {8, 11, 4, 6, 9, 7, 10};
    public static int arbitraryDestination = 0;
    public static CacheIndex aCacheIndex_2779;
    public static int systemUpdateTime = 0;
    public static boolean lastItemDragged = false;
    public static RSString aClass1_2786;
    public static RSString aClass1_2787 = RSString.CreateString("sideicons");
    public static int[] anIntArray2788 = new int[]{16, 32, 64, 128};
    public static RSString aClass1_2790 = RSString.CreateString("Friends");
    public static int anInt2791 = -8 + (int) (17.0 * Math.random());

    static {
        aClass1_2786 = aClass1_2790;
    }

    public FrameDefinition[] aFrameDefinitionArray2794;

    public Class40_Sub5_Sub15(CacheIndex arg0, CacheIndex arg1, int arg2, boolean arg3) {
        LinkedList linkedList = new LinkedList();
        int i = arg0.method190(arg2);
        aFrameDefinitionArray2794 = new FrameDefinition[i];
        int[] is = arg0.method192(arg2, true);
        for(int i_0_ = 0; is.length > i_0_; i_0_++) {
            byte[] is_1_ = arg0.getFile(is[i_0_], arg2);
            FramemapDefinition framemapDefinition = null;
            int i_2_ = is_1_[1] & 0xff | is_1_[0] << 8 & 0xff00;
            for(FramemapDefinition framemapDefinition_3_ = (FramemapDefinition) linkedList.method902((byte) -90); framemapDefinition_3_ != null; framemapDefinition_3_ = (FramemapDefinition) linkedList.method909(-4)) {
                if(i_2_ == framemapDefinition_3_.id) {
                    framemapDefinition = framemapDefinition_3_;
                    break;
                }
            }
            if(framemapDefinition == null) {
                byte[] is_4_;
                if(!arg3)
                    is_4_ = arg1.method182(0, i_2_);
                else
                    is_4_ = arg1.method182(i_2_, 0);
                framemapDefinition = new FramemapDefinition(i_2_, is_4_);
                linkedList.pushBack(framemapDefinition, 60);
            }
            aFrameDefinitionArray2794[is[i_0_]] = new FrameDefinition(is_1_, framemapDefinition);
        }
    }

    public static void method734() {
        aClass40_Sub5_Sub14_Sub2_2775 = null;
        aClass1_2790 = null;
        aClass40_Sub5_Sub14_Sub2Array2776 = null;
        anIntArray2777 = null;
        aClass1_2787 = null;
        aCacheIndex_2779 = null;
        anIntArray2788 = null;
        aClass1_2786 = null;
        English.examine = null;
    }

    public static boolean method735(byte arg0, int arg1) {
        if(arg1 >= 97 && arg1 <= 122)
            return true;
        if(arg1 >= 65 && arg1 <= 90)
            return true;
        if(arg1 >= 48 && arg1 <= 57)
            return true;
        if(arg0 != -37)
            method734();
        return false;
    }

    public static void method736(boolean arg0, Actor arg1) {
        arg1.aBoolean3105 = false;
        if(arg1.anInt3077 != -1) {
            AnimationSequence animationSequence = Class68_Sub1.method1050(arg1.anInt3077, 2);
            if(animationSequence == null || animationSequence.anIntArray2485 == null)
                arg1.anInt3077 = -1;
            else {
                arg1.anInt3120++;
                if(((arg1.anInt3116 < animationSequence.anIntArray2485.length)) && (animationSequence.animationLengths[arg1.anInt3116] < arg1.anInt3120)) {
                    arg1.anInt3116++;
                    arg1.anInt3120 = 1;
                }
                if(animationSequence.anIntArray2485.length <= arg1.anInt3116) {
                    arg1.anInt3116 = 0;
                    arg1.anInt3120 = 0;
                }
            }
        }
        if(arg1.anInt3091 != -1 && Node.pulseCycle >= arg1.anInt3093) {
            if(arg1.anInt3140 < 0)
                arg1.anInt3140 = 0;
            int i = SpotAnimDefinition.forId(arg1.anInt3091, 13).animationId;
            if(i == -1)
                arg1.anInt3091 = -1;
            else {
                AnimationSequence animationSequence = Class68_Sub1.method1050(i, 2);
                if(animationSequence == null || animationSequence.anIntArray2485 == null)
                    arg1.anInt3091 = -1;
                else {
                    arg1.anInt3129++;
                    if(((animationSequence.anIntArray2485.length > arg1.anInt3140)) && ((arg1.anInt3129 > animationSequence.animationLengths[arg1.anInt3140]))) {
                        arg1.anInt3129 = 1;
                        arg1.anInt3140++;
                    }
                    if(((animationSequence.anIntArray2485.length <= arg1.anInt3140)) && (arg1.anInt3140 < 0 || ((animationSequence.anIntArray2485.length <= arg1.anInt3140))))
                        arg1.anInt3091 = -1;
                }
            }
        }
        if(arg0) {
            if(arg1.playingAnimation != -1 && arg1.playingAnimationDelay <= 1) {
                AnimationSequence animationSequence = Class68_Sub1.method1050(arg1.playingAnimation, 2);
                if(animationSequence.anInt2470 == 1 && arg1.anInt3094 > 0 && arg1.anInt3112 <= Node.pulseCycle && Node.pulseCycle > arg1.anInt3107) {
                    arg1.playingAnimationDelay = 1;
                    return;
                }
            }
            if(arg1.playingAnimation != -1 && arg1.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = Class68_Sub1.method1050(arg1.playingAnimation, 2);
                if(animationSequence != null && animationSequence.anIntArray2485 != null) {
                    arg1.anInt3115++;
                    if((animationSequence.anIntArray2485.length > arg1.anInt3104) && (animationSequence.animationLengths[arg1.anInt3104] < arg1.anInt3115)) {
                        arg1.anInt3104++;
                        arg1.anInt3115 = 1;
                    }
                    if((animationSequence.anIntArray2485.length <= arg1.anInt3104)) {
                        arg1.anInt3104 -= animationSequence.frameStep;
                        arg1.anInt3095++;
                        if((animationSequence.anInt2495 <= arg1.anInt3095))
                            arg1.playingAnimation = -1;
                        if(arg1.anInt3104 < 0 || (arg1.anInt3104 >= animationSequence.anIntArray2485.length))
                            arg1.playingAnimation = -1;
                    }
                    arg1.aBoolean3105 = animationSequence.aBoolean2496;
                } else
                    arg1.playingAnimation = -1;
            }
            if(arg1.playingAnimationDelay > 0)
                arg1.playingAnimationDelay--;
        }
    }

    public boolean method737(int arg0) {
        return aFrameDefinitionArray2794[arg0].aBoolean985;
    }
}
