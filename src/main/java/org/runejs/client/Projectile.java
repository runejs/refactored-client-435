package org.runejs.client;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;

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
            animationSequences = ProducingGraphicsBuffer_Sub1.getAnimationSequence(i);
        else
            animationSequences = null;

    }


    public static void updateFacingDirection(Actor actor) {
        if(actor.anInt3113 != 0) {
            if(actor.facingActorIndex != -1 && actor.facingActorIndex < 32768) {
                Npc npc = Player.npcs[actor.facingActorIndex];
                if(npc != null) {
                    int deltaY = -npc.worldY + actor.worldY;
                    int deltaX = -npc.worldX + actor.worldX;
                    if(deltaX != 0 || deltaY != 0)
                        actor.initialFaceDirection = 0x7ff & (int) (325.949 * Math.atan2((double) deltaX, (double) deltaY));
                }
            }
            if(actor.facingActorIndex >= 32768) {
                int i = -32768 + actor.facingActorIndex;
                if(i == Player.localPlayerId)
                    i = 2047;
                Player player = Player.trackedPlayers[i];
                if(player != null) {
                    int deltaX = actor.worldX - player.worldX;
                    int deltaY = -player.worldY + actor.worldY;
                    if(deltaX != 0 || deltaY != 0)
                        actor.initialFaceDirection = (int) (Math.atan2((double) deltaX, (double) deltaY) * 325.949) & 0x7ff;
                }
            }
            if((actor.facePositionX != 0 || actor.facePositionY != 0) && (actor.anInt3109 == 0 || actor.anInt3074 > 0)) {
                int deltaY = actor.worldY - 64 * (actor.facePositionY - Class26.baseY - Class26.baseY);
                int deltaX = -((-MovedStatics.baseX + actor.facePositionX + -MovedStatics.baseX) * 64) + actor.worldX;
                if(deltaX != 0 || deltaY != 0)
                    actor.initialFaceDirection = 0x7ff & (int) (325.949 * Math.atan2((double) deltaX, (double) deltaY));
                actor.facePositionY = 0;
                actor.facePositionX = 0;
            }
            int i = 0x7ff & actor.initialFaceDirection + -actor.anInt3118;
            if(i != 0) {
                actor.anInt3097++;
                if(i > 1024) {
                    actor.anInt3118 -= actor.anInt3113;
                    boolean bool = true;
                    if(actor.anInt3113 > i || 2048 + -actor.anInt3113 < i) {
                        bool = false;
                        actor.anInt3118 = actor.initialFaceDirection;
                    }
                    if(actor.idleAnimation == actor.anInt3077 && (actor.anInt3097 > 25 || bool)) {
                        if(actor.standTurnAnimationId != -1)
                            actor.anInt3077 = actor.standTurnAnimationId;
                        else
                            actor.anInt3077 = actor.walkAnimationId;
                    }
                } else {
                    actor.anInt3118 += actor.anInt3113;
                    boolean bool = true;
                    if(i < actor.anInt3113 || i > -actor.anInt3113 + 2048) {
                        actor.anInt3118 = actor.initialFaceDirection;
                        bool = false;
                    }
                    if(actor.anInt3077 == actor.idleAnimation && (actor.anInt3097 > 25 || bool)) {
                        if(actor.anInt3083 != -1)
                            actor.anInt3077 = actor.anInt3083;
                        else
                            actor.anInt3077 = actor.walkAnimationId;
                    }
                }
                actor.anInt3118 &= 0x7ff;
            } else
                actor.anInt3097 = 0;
        }
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
