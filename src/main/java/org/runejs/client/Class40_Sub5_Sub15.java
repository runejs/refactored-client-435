package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.FrameDefinition;
import org.runejs.client.cache.def.FramemapDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.FrameDefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.FramemapDefinitionLoader;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.node.CachedNode;

/**
 * anim skeleton?
 */
public class Class40_Sub5_Sub15 extends CachedNode {
    public static DefinitionLoader<FramemapDefinition> framemapDefinitionLoader = new FramemapDefinitionLoader();
    public static DefinitionLoader<FrameDefinition> frameDefinitionLoader = new FrameDefinitionLoader();

    public FrameDefinition[] aFrameDefinitionArray2794;

    public Class40_Sub5_Sub15(CacheArchive skeletonArchive, CacheArchive skinArchive, int groupId, boolean arg3) {
        LinkedList linkedList = new LinkedList();
        int i = skeletonArchive.fileLength(groupId);
        aFrameDefinitionArray2794 = new FrameDefinition[i];
        int[] skeletonFileIds = skeletonArchive.getFileIds(groupId, true);
        for(int i_0_ = 0; skeletonFileIds.length > i_0_; i_0_++) {
            byte[] skeleton = skeletonArchive.getFile(groupId, skeletonFileIds[i_0_]);
            FramemapDefinition framemapDefinition = null;
            int i_2_ = skeleton[1] & 0xff | skeleton[0] << 8 & 0xff00;
            for(FramemapDefinition framemapDefinition_3_ = (FramemapDefinition) linkedList.peekFirst(); framemapDefinition_3_ != null; framemapDefinition_3_ = (FramemapDefinition) linkedList.pollFirst()) {
                if(i_2_ == framemapDefinition_3_.id) {
                    framemapDefinition = framemapDefinition_3_;
                    break;
                }
            }
            if(framemapDefinition == null) {
                byte[] framemapData;
                if(!arg3)
                    framemapData = skinArchive.method182(i_2_, 0);
                else
                    framemapData = skinArchive.method182(0, i_2_);
                framemapDefinition = new FramemapDefinition(i_2_, framemapDefinitionLoader, framemapData);
                linkedList.addLast(framemapDefinition);
            }

            int frameDefinitionId = skeletonFileIds[i_0_];

            aFrameDefinitionArray2794[skeletonFileIds[i_0_]] = new FrameDefinition(frameDefinitionId, frameDefinitionLoader, skeleton, framemapDefinition);
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
