package org.runejs.client.cache.def;

import org.runejs.client.ClientScriptRunner;
import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer_Sub1;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.node.CachedNode;

public class AnimationFrameGroup extends CachedNode {
    public static IndexedImage loginScreenBox;
    public static IndexedImage[] tabIcons;
    public static int arbitraryDestination = 0;
    public static int systemUpdateTime = 0;
    public static boolean lastItemDragged = false;
    public static int[] anIntArray2788 = new int[]{16, 32, 64, 128};

    public AnimationFrameDefinition[] frames;

    public AnimationFrameGroup(CacheArchive animsArchive, CacheArchive basesArchive,
                               int animGroupIndex) {
        LinkedList definitions = new LinkedList();
        int i = animsArchive.fileLength(animGroupIndex);
        frames = new AnimationFrameDefinition[i];
        int[] groupedFileIndexes = animsArchive.getGroupedFileIndexes(animGroupIndex);

        for(int fileIndex = 0; groupedFileIndexes.length > fileIndex; fileIndex++) {
            // anims grouped file reading
            byte[] fileData = animsArchive.getFile(animGroupIndex, groupedFileIndexes[fileIndex]);
            AnimationBaseDefinition animationBaseDefinition = null;
            int id = fileData[1] & 0xff | fileData[0] << 8 & 0xff00;
            for(AnimationBaseDefinition def = (AnimationBaseDefinition) definitions.next();
                def != null;
                def = (AnimationBaseDefinition) definitions.method909()) {
                if(id == def.id) {
                    animationBaseDefinition = def;
                    break;
                }
            }

            if(animationBaseDefinition == null) {
                byte[] animBaseData = basesArchive.method182(0, id);
                // bases file reading
                animationBaseDefinition = new AnimationBaseDefinition(id, animBaseData);
                definitions.pushBack(animationBaseDefinition);
            }

            frames[groupedFileIndexes[fileIndex]] = new AnimationFrameDefinition(fileData, animationBaseDefinition);
        }
    }

    public static boolean method735(int arg1) {
        if(arg1 >= 97 && arg1 <= 122)
            return true;
        if(arg1 >= 65 && arg1 <= 90)
            return true;
        if(arg1 >= 48 && arg1 <= 57)
            return true;
        return false;
    }

    public static void method736(boolean arg0, Actor arg1) {
        arg1.aBoolean3105 = false;
        if(arg1.anInt3077 != -1) {
            AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(arg1.anInt3077);
            if(animationSequence == null || animationSequence.frameIds == null)
                arg1.anInt3077 = -1;
            else {
                arg1.anInt3120++;
                if(arg1.anInt3116 < animationSequence.frameIds.length && animationSequence.frameLengths[arg1.anInt3116] < arg1.anInt3120) {
                    arg1.anInt3116++;
                    arg1.anInt3120 = 1;
                }
                if(animationSequence.frameIds.length <= arg1.anInt3116) {
                    arg1.anInt3116 = 0;
                    arg1.anInt3120 = 0;
                }
            }
        }
        if(arg1.graphicId != -1 && MovedStatics.pulseCycle >= arg1.graphicDelay) {
            if(arg1.anInt3140 < 0)
                arg1.anInt3140 = 0;
            int i = SpotAnimDefinition.forId(arg1.graphicId).animationId;
            if(i == -1)
                arg1.graphicId = -1;
            else {
                AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(i);
                if(animationSequence == null || animationSequence.frameIds == null)
                    arg1.graphicId = -1;
                else {
                    arg1.anInt3129++;
                    if(animationSequence.frameIds.length > arg1.anInt3140 && arg1.anInt3129 > animationSequence.frameLengths[arg1.anInt3140]) {
                        arg1.anInt3129 = 1;
                        arg1.anInt3140++;
                    }
                    if(animationSequence.frameIds.length <= arg1.anInt3140 && (arg1.anInt3140 < 0 || animationSequence.frameIds.length <= arg1.anInt3140))
                        arg1.graphicId = -1;
                }
            }
        }
        if(arg0) {
            if(arg1.playingAnimation != -1 && arg1.playingAnimationDelay <= 1) {
                AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(arg1.playingAnimation);
                if(animationSequence.precedenceAnimating == 1 && arg1.anInt3094 > 0 && arg1.anInt3112 <= MovedStatics.pulseCycle && MovedStatics.pulseCycle > arg1.anInt3107) {
                    arg1.playingAnimationDelay = 1;
                    return;
                }
            }
            if(arg1.playingAnimation != -1 && arg1.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(arg1.playingAnimation);
                if(animationSequence != null && animationSequence.frameIds != null) {
                    arg1.anInt3115++;
                    if(animationSequence.frameIds.length > arg1.anInt3104 && animationSequence.frameLengths[arg1.anInt3104] < arg1.anInt3115) {
                        arg1.anInt3104++;
                        arg1.anInt3115 = 1;
                    }
                    if(animationSequence.frameIds.length <= arg1.anInt3104) {
                        arg1.anInt3104 -= animationSequence.frameStep;
                        arg1.anInt3095++;
                        if(animationSequence.maxLoops <= arg1.anInt3095)
                            arg1.playingAnimation = -1;
                        if(arg1.anInt3104 < 0 || arg1.anInt3104 >= animationSequence.frameIds.length)
                            arg1.playingAnimation = -1;
                    }
                    arg1.aBoolean3105 = animationSequence.stretches;
                } else
                    arg1.playingAnimation = -1;
            }
            if(arg1.playingAnimationDelay > 0)
                arg1.playingAnimationDelay--;
        }
    }

    public static AnimationFrameGroup loadAnimation(CacheArchive animsArchive, CacheArchive basesArchive, int animGroupIndex) {
        boolean isLoaded = true;
        int[] fileIndexes = animsArchive.getGroupedFileIndexes(animGroupIndex);

        for(int i = 0; fileIndexes.length > i; i++) {
            byte[] groupedFileData = animsArchive.method182(fileIndexes[i], animGroupIndex);
            if(groupedFileData == null)
                isLoaded = false;
            else {
                int animBaseFileIndex = 0xff & groupedFileData[1] | (0xff & groupedFileData[0]) << 8;
                byte[] animBaseFileData = basesArchive.method182(0, animBaseFileIndex);
                if(animBaseFileData == null)
                    isLoaded = false;
            }
        }

        if(!isLoaded)
            return null;

        try {
            return new AnimationFrameGroup(animsArchive, basesArchive, animGroupIndex);
        } catch(Exception exception) {
            return null;
        }
    }

    public static AnimationFrameGroup method960(int arg1) {
        AnimationFrameGroup animationBuilder = (AnimationFrameGroup) MovedStatics.aClass9_998.get((long) arg1);
        if(animationBuilder != null)
            return animationBuilder;
        animationBuilder = loadAnimation(MovedStatics.aCacheArchive_2364, ClientScriptRunner.aCacheArchive_2162, arg1);
        if(animationBuilder != null)
            MovedStatics.aClass9_998.put((long) arg1, animationBuilder);
        return animationBuilder;
    }

    public boolean method737(int arg0) {
        return frames[arg0].showing;
    }
}
