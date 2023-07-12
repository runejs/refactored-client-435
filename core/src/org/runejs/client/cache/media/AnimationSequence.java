package org.runejs.client.cache.media;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class AnimationSequence extends CachedNode {
    private static CacheArchive definitionArchive;
    private static NodeCache animationSequenceCache = new NodeCache(64);
    private static NodeCache skeletonCache = new NodeCache(100);
    private static CacheArchive skinArchive;
    private static CacheArchive skeletonArchive;

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

    private static Class40_Sub5_Sub15 method960(int arg1) {
        Class40_Sub5_Sub15 skeleton = (Class40_Sub5_Sub15) skeletonCache.get((long) arg1);
        if(skeleton != null)
            return skeleton;
        skeleton = method421(skeletonArchive, arg1, skinArchive, false);
        if(skeleton != null)
            skeletonCache.put((long) arg1, skeleton);
        return skeleton;
    }

    private static Class40_Sub5_Sub15 method421(CacheArchive skeletonArchive, int arg2, CacheArchive skinArchive, boolean arg4) {
        boolean bool = true;
        int[] is = skeletonArchive.method192(arg2, true);
        for(int i = 0; is.length > i; i++) {
            byte[] is_0_ = skeletonArchive.method182(is[i], arg2);
            if(is_0_ == null)
                bool = false;
            else {
                int i_1_ = 0xff & is_0_[1] | (0xff & is_0_[0]) << 8;
                byte[] is_2_;
                if(arg4)
                    is_2_ = skinArchive.method182(i_1_, 0);
                else
                    is_2_ = skinArchive.method182(0, i_1_);
                if(is_2_ == null)
                    bool = false;
            }
        }
        if(!bool)
            return null;
        try {
            return new Class40_Sub5_Sub15(skeletonArchive, skinArchive, arg2, arg4);
        } catch(Exception exception) {
            return null;
        }
    }

    public static AnimationSequence getAnimationSequence(int animationId) {
        AnimationSequence animationSequence = (AnimationSequence) animationSequenceCache.get((long) animationId);

        if(animationSequence != null)
            return animationSequence;
        byte[] is = definitionArchive.getFile(12, animationId);
        animationSequence = new AnimationSequence();
        if(is != null)
            animationSequence.decodeAllAnimationSequences(new Buffer(is));
        animationSequence.method591();
        animationSequenceCache.put((long) animationId, animationSequence);
        return animationSequence;
    }

    public static void clearAnimationCache() {
        animationSequenceCache.clear();
        skeletonCache.clear();
    }

    public static void initializeAnimationCaches(CacheArchive skinArchive, CacheArchive definitionArchive, CacheArchive skeletonArchive) {
        AnimationSequence.skinArchive = skinArchive;
        AnimationSequence.skeletonArchive = skeletonArchive;
        AnimationSequence.definitionArchive = definitionArchive;
    }

    public Model method590(Model arg0, AnimationSequence animationSequence, int arg2, int arg3, byte arg4) {
        arg2 = frameIds[arg2];
        Class40_Sub5_Sub15 class40_sub5_sub15 = method960(arg2 >> 16);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return animationSequence.method599(arg3, arg0, false);
        arg3 = animationSequence.frameIds[arg3];
        Class40_Sub5_Sub15 class40_sub5_sub15_0_ = method960(arg3 >> 16);
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
        Class40_Sub5_Sub15 class40_sub5_sub15 = method960(arg0 >> 16);
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
        Class40_Sub5_Sub15 class40_sub5_sub15 = method960(arg2 >> 16);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method806(true);
        if(arg0 != -87)
            return null;
        Model class40_sub5_sub17_sub5 = arg1.method806(!class40_sub5_sub15.method737(arg2));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg2);
        return class40_sub5_sub17_sub5;
    }

    public Model method598(int arg0, Model arg1) {
        int i = frameIds[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = method960(i >> 16);
        i &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        Class40_Sub5_Sub15 class40_sub5_sub15_20_ = null;
        int i_21_ = 0;
        if(unknownArray1 != null && arg0 < unknownArray1.length) {
            i_21_ = unknownArray1[arg0];
            class40_sub5_sub15_20_ = method960(i_21_ >> 16);
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
        Class40_Sub5_Sub15 class40_sub5_sub15 = method960(arg0 >> 16);
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(arg0));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg0);
        return class40_sub5_sub17_sub5;
    }
}
