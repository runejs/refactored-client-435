package org.runejs.client.media.renderable;

import org.runejs.client.*;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.media.AnimationSequence;

public class GameObject extends Renderable {
    public int vertexHeightTopRight;
    public int orientation;
    public int objectType;
    public int animationCycleDelay;
    public int animationFrame;
    public int vertexHeightTop;
    public int vertexHeight;
    public int vertexHeightRight;
    public AnimationSequence animationSequence;
    public int id;

    public GameObject(int objectId, int objectType, int orientation, int arg3, int arg4, int arg5, int arg6, int animationId, boolean arg8) {
        vertexHeight = arg3;
        id = objectId;
        vertexHeightTop = arg6;
        this.orientation = orientation;
        vertexHeightRight = arg4;
        vertexHeightTopRight = arg5;
        this.objectType = objectType;
        if(animationId != -1) {
            animationSequence = AnimationSequence.getAnimationSequence(animationId);
            animationFrame = 0;
            animationCycleDelay = -1 + MovedStatics.pulseCycle;
            if(arg8 && animationSequence.frameStep != -1) {
                animationFrame = (int) ((double) animationSequence.frameIds.length * Math.random());
                animationCycleDelay -= (int) (Math.random() * (double) animationSequence.frameLengths[animationFrame]);
            }
        }
    }


    public Model getRotatedModel() {
        if(animationSequence != null) {
            int step = -animationCycleDelay + MovedStatics.pulseCycle;
            if(step > 100 && animationSequence.frameStep > 0)
                step = 100;
            while(animationSequence.frameLengths[animationFrame] < step) {
                step -= animationSequence.frameLengths[animationFrame];
                animationFrame++;
                if(animationSequence.frameIds.length <= animationFrame) {
                    animationFrame -= animationSequence.frameStep;
                    if(animationFrame < 0 || animationSequence.frameIds.length <= animationFrame) {
                        animationSequence = null;
                        break;
                    }
                }
            }
            animationCycleDelay = MovedStatics.pulseCycle - step;
        }
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(id);
        if(gameObjectDefinition.childIds != null)
            gameObjectDefinition = gameObjectDefinition.getChildDefinition();
        if(gameObjectDefinition == null)
            return null;
        return gameObjectDefinition.createAnimatedObjectModel(vertexHeight, vertexHeightRight, animationFrame, objectType, orientation, animationSequence, vertexHeightTop, vertexHeightTopRight);
    }
}
