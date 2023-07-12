package org.runejs.client.media.renderable;

import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer_Sub1;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.node.CachedNode;

public abstract class Renderable extends CachedNode {
    public static long aLong2858 = 0L;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-left tab on the bottom.
     */
    public static IndexedImage tabHighlightImageBottomLeftEdge;
    public static int[] anIntArray2865;
    public static int anInt2869 = 0;

    public int modelHeight = 1000;

    public static boolean handleSequences(int arg1) {
        if(!GameInterface.decodeGameInterface(arg1))
            return false;
        GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[arg1];
        boolean bool = false;
        for(int i = 0; gameInterfaces.length > i; i++) {
            GameInterface gameInterface = gameInterfaces[i];
            if(gameInterface != null && gameInterface.type == GameInterfaceType.MODEL) {
                if(gameInterface.animation != -1 || gameInterface.alternateAnimation != -1) {
                    boolean bool_0_ = GameInterface.checkForAlternateAction(gameInterface);
                    int i_1_;
                    if(bool_0_)
                        i_1_ = gameInterface.alternateAnimation;
                    else
                        i_1_ = gameInterface.animation;
                    if(i_1_ != -1) {
                        AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(i_1_);
                        gameInterface.remainingAnimationTime += MovedStatics.anInt199;
                        while(animationSequence.frameLengths[gameInterface.animationFrame] < gameInterface.remainingAnimationTime) {
                            bool = true;
                            gameInterface.remainingAnimationTime -= animationSequence.frameLengths[gameInterface.animationFrame];
                            gameInterface.animationFrame++;
                            if(gameInterface.animationFrame >= animationSequence.frameIds.length) {
                                gameInterface.animationFrame -= animationSequence.frameStep;
                                if(gameInterface.animationFrame < 0 || animationSequence.frameIds.length <= gameInterface.animationFrame)
                                    gameInterface.animationFrame = 0;
                            }
                        }
                    }
                }
                if(gameInterface.rotationSpeed != 0) {
                    bool = true;
                    int i_2_ = gameInterface.rotationSpeed >> 16;
                    int i_3_ = gameInterface.rotationSpeed << 16 >> 16;
                    i_2_ *= MovedStatics.anInt199;
                    gameInterface.rotationX = 0x7ff & i_2_ + gameInterface.rotationX;
                    i_3_ *= MovedStatics.anInt199;
                    gameInterface.rotationZ = 0x7ff & gameInterface.rotationZ + i_3_;
                }
            }
        }
        return bool;
    }

    public void renderAtPoint(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        Model class40_sub5_sub17_sub5 = getRotatedModel();
        if(class40_sub5_sub17_sub5 != null) {
            modelHeight = class40_sub5_sub17_sub5.modelHeight;
            class40_sub5_sub17_sub5.renderAtPoint(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }
    }

    public Model getRotatedModel() {
        return null;
    }
}
