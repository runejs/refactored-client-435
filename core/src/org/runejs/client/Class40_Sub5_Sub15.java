package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.FrameDefinition;
import org.runejs.client.cache.def.FramemapDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.node.CachedNode;

/**
 * anim skeleton?
 */
public class Class40_Sub5_Sub15 extends CachedNode {
    public FrameDefinition[] aFrameDefinitionArray2794;

    public Class40_Sub5_Sub15(CacheArchive arg0, CacheArchive arg1, int arg2, boolean arg3) {
        LinkedList linkedList = new LinkedList();
        int i = arg0.fileLength(arg2);
        aFrameDefinitionArray2794 = new FrameDefinition[i];
        int[] is = arg0.method192(arg2, true);
        for(int i_0_ = 0; is.length > i_0_; i_0_++) {
            byte[] is_1_ = arg0.getFile(arg2, is[i_0_]);
            FramemapDefinition framemapDefinition = null;
            int i_2_ = is_1_[1] & 0xff | is_1_[0] << 8 & 0xff00;
            for(FramemapDefinition framemapDefinition_3_ = (FramemapDefinition) linkedList.peekFirst(); framemapDefinition_3_ != null; framemapDefinition_3_ = (FramemapDefinition) linkedList.pollFirst()) {
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
                linkedList.addLast(framemapDefinition);
            }
            aFrameDefinitionArray2794[is[i_0_]] = new FrameDefinition(is_1_, framemapDefinition);
        }
    }


    public static void updateAnimation(Actor actor) {
        actor.aBoolean3105 = false;
        if(actor.anInt3077 != -1) {
            AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(actor.anInt3077);
            if(animationSequence == null || animationSequence.frameIds == null)
                actor.anInt3077 = -1;
            else {
                actor.anInt3120++;
                if(actor.anInt3116 < animationSequence.frameIds.length && animationSequence.frameLengths[actor.anInt3116] < actor.anInt3120) {
                    actor.anInt3116++;
                    actor.anInt3120 = 1;
                }
                if(animationSequence.frameIds.length <= actor.anInt3116) {
                    actor.anInt3116 = 0;
                    actor.anInt3120 = 0;
                }
            }
        }
        if(actor.graphicId != -1 && MovedStatics.pulseCycle >= actor.graphicDelay) {
            if(actor.anInt3140 < 0)
                actor.anInt3140 = 0;
            int i = SpotAnimDefinition.forId(actor.graphicId).animationId;
            if(i == -1)
                actor.graphicId = -1;
            else {
                AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(i);
                if(animationSequence == null || animationSequence.frameIds == null)
                    actor.graphicId = -1;
                else {
                    actor.anInt3129++;
                    if(animationSequence.frameIds.length > actor.anInt3140 && actor.anInt3129 > animationSequence.frameLengths[actor.anInt3140]) {
                        actor.anInt3129 = 1;
                        actor.anInt3140++;
                    }
                    if(animationSequence.frameIds.length <= actor.anInt3140 && (actor.anInt3140 < 0 || animationSequence.frameIds.length <= actor.anInt3140))
                        actor.graphicId = -1;
                }
            }
        }
        if(true) {
            if(actor.playingAnimation != -1 && actor.playingAnimationDelay <= 1) {
                AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(actor.playingAnimation);
                if(animationSequence.precedenceAnimating == 1 && actor.anInt3094 > 0 && actor.forceMoveEndCycle <= MovedStatics.pulseCycle && MovedStatics.pulseCycle > actor.forceMoveStartCycle) {
                    actor.playingAnimationDelay = 1;
                    return;
                }
            }
            if(actor.playingAnimation != -1 && actor.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(actor.playingAnimation);
                if(animationSequence != null && animationSequence.frameIds != null) {
                    actor.anInt3115++;
                    if(animationSequence.frameIds.length > actor.anInt3104 && animationSequence.frameLengths[actor.anInt3104] < actor.anInt3115) {
                        actor.anInt3104++;
                        actor.anInt3115 = 1;
                    }
                    if(animationSequence.frameIds.length <= actor.anInt3104) {
                        actor.anInt3104 -= animationSequence.frameStep;
                        actor.anInt3095++;
                        if(animationSequence.maxLoops <= actor.anInt3095)
                            actor.playingAnimation = -1;
                        if(actor.anInt3104 < 0 || actor.anInt3104 >= animationSequence.frameIds.length)
                            actor.playingAnimation = -1;
                    }
                    actor.aBoolean3105 = animationSequence.stretches;
                } else
                    actor.playingAnimation = -1;
            }
            if(actor.playingAnimationDelay > 0)
                actor.playingAnimationDelay--;
        }
    }

    public boolean method737(int arg0) {
        return aFrameDefinitionArray2794[arg0].aBoolean985;
    }
}
