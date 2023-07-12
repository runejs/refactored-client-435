package org.runejs.client;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;

public class Projectile extends Renderable {
    public int startHeight;
    public int startX;
    public int endHeight;
    public int entityIndex;
    public int graphicsId;
    public boolean moving;
    public int endCycle;
    public double speedVectorZ;
    public int duration = 0;
    public int delay;
    public int anInt2976;
    public double currentX;
    public int anInt2981;
    public int animationFrame;
    public int startY;
    public int startDistanceFromTarget;
    public double currentHeight;
    public double currentY;
    public double speedVectorScalar;
    public double heightOffset;
    public int startSlope;
    public double speedVectorY;
    public AnimationSequence animationSequences;
    public double speedVectorX;
    public int anInt3013;

    public Projectile(int graphicsId, int arg1, int startX, int startY, int height, int delay, int speed, int startSlope, int startDistanceFromTarget, int entityIndex, int endHeight) {
        moving = false;
        animationFrame = 0;
        this.startX = startX;
        startHeight = height;
        moving = false;
        this.endHeight = endHeight;
        this.startDistanceFromTarget = startDistanceFromTarget;
        this.graphicsId = graphicsId;
        anInt2981 = arg1;
        endCycle = speed;
        this.delay = delay;
        this.entityIndex = entityIndex;
        this.startY = startY;
        this.startSlope = startSlope;
        int i = SpotAnimDefinition.forId(this.graphicsId).animationId;
        if(i != -1)
            animationSequences = AnimationSequence.getAnimationSequence(i);
        else
            animationSequences = null;

    }


    public Model getRotatedModel() {
        SpotAnimDefinition spotAnimDefinition = SpotAnimDefinition.forId(graphicsId);
        Model class40_sub5_sub17_sub5 = spotAnimDefinition.getModel(animationFrame);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        class40_sub5_sub17_sub5.method804(anInt2976);
        return class40_sub5_sub17_sub5;
    }

    public void move(int time) {
        moving = true;
        currentY += (double) time * speedVectorY;
        currentX += speedVectorX * (double) time;
        currentHeight += heightOffset * 0.5 * (double) time * (double) time + (double) time * speedVectorZ;
        speedVectorZ += (double) time * heightOffset;
        anInt3013 = 0x7ff & (int) (Math.atan2(speedVectorX, speedVectorY) * 325.949) + 1024;
        anInt2976 = 0x7ff & (int) (325.949 * Math.atan2(speedVectorZ, speedVectorScalar));
        if(animationSequences != null) {
            duration += time;
            while(animationSequences.frameLengths[animationFrame] < duration) {
                duration -= animationSequences.frameLengths[animationFrame];
                animationFrame++;
                if(animationSequences.frameIds.length <= animationFrame)
                    animationFrame = 0;
            }
        }
    }

    public void trackTarget(int loopCycle, int arg1, int targetY, int k, int targetX) {
        if(!moving) {
            double distanceX = (double) (-startX + targetX);
            double distanceY = (double) (-startY + targetY);
            double distanceScalar = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
            currentX = (double) startX + distanceX * (double) startDistanceFromTarget / distanceScalar;
            currentY = (double) startY + (double) startDistanceFromTarget * distanceY / distanceScalar;
            currentHeight = (double) startHeight;
        }
        double cyclesRemaining = (double) (-loopCycle + 1 + endCycle);
        speedVectorY = ((double) targetY - currentY) / cyclesRemaining;
        speedVectorX = ((double) targetX - currentX) / cyclesRemaining;
        speedVectorScalar = Math.sqrt(speedVectorY * speedVectorY + speedVectorX * speedVectorX);
        if(!moving)
            speedVectorZ = -speedVectorScalar * Math.tan((double) startSlope * 0.02454369);
        heightOffset = (-currentHeight + (double) k - speedVectorZ * cyclesRemaining) * 2.0 / (cyclesRemaining * cyclesRemaining);
    }
}
