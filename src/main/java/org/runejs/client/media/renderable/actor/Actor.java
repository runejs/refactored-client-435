package org.runejs.client.media.renderable.actor;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.scene.tile.WallDecoration;
import org.runejs.client.*;

public abstract class Actor extends Renderable {
    public static int actorUpdatingIndex = 0;

    public boolean[] aBooleanArray3072;
    public int forceMoveFaceDirection;
    public int anInt3074;
    public int turnRightAnimationId;
    public int anInt3077;
    public int anInt3078;
    public int turnAroundAnimationId;
    public int initialFaceDirection;
    public int forceMoveStartY;
    public int runAnimationId;
    public int anInt3083;
    public int[] anIntArray3086;
    public int[] anIntArray3087;
    public int[] pathY;
    /**
     * TODO rename this, maybe to `sceneY`
     */
    public int worldY;
    public String forcedChatMessage;
    public int graphicId;
    public int graphicDelay;
    public int anInt3094;
    public int anInt3095 = 0;
    public int size;
    public int anInt3097;

    /**
     * TODO rename this, maybe to `sceneX`
     */
    public int worldX;
    public int forceMoveEndX;
    public int facePositionY;
    public int maximumHitpoints;
    public int chatcolor;
    public int anInt3104;
    public boolean aBoolean3105;
    public int forceMoveStartCycle;
    public int anInt3109;
    public int graphicHeight;
    public int forceMoveEndCycle;
    public int anInt3113;
    public int anInt3115;
    public int anInt3116;
    public int anInt3117;
    public int anInt3118;
    public int anInt3120;
    public int playingAnimationDelay;
    public int chatEffects;
    public int forceMoveStartX;
    public int idleAnimation;
    public int forceMoveEndY;
    public int anInt3129;
    public int remainingHitpoints;
    public int walkAnimationId;
    public int turnLeftAnimationId;
    public int anInt3134;
    public int[] pathX;
    public int[] anIntArray3136;
    public int facingActorIndex;
    public int anInt3139;
    public int anInt3140;
    public int playingAnimation;
    public int standTurnAnimationId;
    public int facePositionX;

    public Actor() {
        anInt3083 = -1;
        facePositionY = 0;
        runAnimationId = -1;
        turnAroundAnimationId = -1;
        aBoolean3105 = false;
        size = 1;
        forcedChatMessage = null;
        turnRightAnimationId = -1;
        anIntArray3086 = new int[4];
        aBooleanArray3072 = new boolean[10];
        anInt3113 = 32;
        anInt3094 = 0;
        chatcolor = 0;
        anInt3104 = 0;
        graphicId = -1;
        anInt3117 = 200;
        anInt3078 = 100;
        anInt3120 = 0;
        playingAnimationDelay = 0;
        anInt3077 = -1;
        anIntArray3087 = new int[4];
        anInt3116 = 0;
        anInt3109 = 0;
        chatEffects = 0;
        idleAnimation = -1;
        anInt3074 = 0;
        anInt3097 = 0;
        anIntArray3136 = new int[4];
        anInt3129 = 0;
        facingActorIndex = -1;
        pathX = new int[10];
        anInt3139 = -1000;
        walkAnimationId = -1;
        anInt3115 = 0;
        anInt3134 = 0;
        anInt3140 = 0;
        pathY = new int[10];
        turnLeftAnimationId = -1;
        standTurnAnimationId = -1;
        facePositionX = 0;
        playingAnimation = -1;
    }

    public static void clearCaches() {
        ImageRGB.imageRgbCache.clear();
        WallDecoration.modelCache.clear();
        TypeFace.typeFaceCache.clear();
    }


    public static void handleActorAnimation(Actor actor) {
        if(actor.worldX < 128 || actor.worldY < 128 || actor.worldX >= 13184 || actor.worldY >= 13184) {
            actor.playingAnimation = -1;
            actor.forceMoveEndCycle = 0;
            actor.forceMoveStartCycle = 0;
            actor.graphicId = -1;
            actor.worldX = actor.size * 64 + 128 * actor.pathY[0];
            actor.worldY = actor.pathX[0] * 128 + 64 * actor.size;
            actor.method790(0);
        }
        if(actor == Player.localPlayer && (actor.worldX < 1536 || actor.worldY < 1536 || actor.worldX >= 11776 || actor.worldY >= 11776)) {
            actor.graphicId = -1;
            actor.forceMoveStartCycle = 0;
            actor.forceMoveEndCycle = 0;
            actor.playingAnimation = -1;
            actor.worldX = actor.pathY[0] * 128 + actor.size * 64;
            actor.worldY = 64 * actor.size + actor.pathX[0] * 128;
            actor.method790(0);
        }
        if(actor.forceMoveEndCycle > MovedStatics.pulseCycle)
            updateForcedMovement(actor);
        else if(actor.forceMoveStartCycle < MovedStatics.pulseCycle)
            processWalkingStep(255, actor);
        else
            PlayerAppearance.startForcedMovement(actor);
        updateFacingDirection(actor);
        Class40_Sub5_Sub15.updateAnimation(actor);
    }

    public static void updateForcedMovement(Actor actor) {
        int deltaTime = actor.forceMoveEndCycle - MovedStatics.pulseCycle;
        int destX = actor.forceMoveStartX * 128 + 64 * actor.size;
        if(actor.forceMoveFaceDirection == 0)
            actor.initialFaceDirection = 1024;
        if(actor.forceMoveFaceDirection == 1)
            actor.initialFaceDirection = 1536;
        if(actor.forceMoveFaceDirection == 2)
            actor.initialFaceDirection = 0;
        int destY = actor.size * 64 + 128 * actor.forceMoveStartY;
        actor.worldX += (destX - actor.worldX) / deltaTime;
        if(actor.forceMoveFaceDirection == 3)
            actor.initialFaceDirection = 512;
        actor.anInt3074 = 0;
        actor.worldY += (-actor.worldY + destY) / deltaTime;
    }

    public static void processWalkingStep(int arg0, Actor actor) {
        actor.anInt3077 = actor.idleAnimation;
        if(actor.anInt3109 == 0)
            actor.anInt3074 = 0;
        else {
            if(actor.playingAnimation != -1 && actor.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(actor.playingAnimation);
                if(actor.anInt3094 > 0 && animationSequence.precedenceAnimating == 0) {
                    actor.anInt3074++;
                    return;
                }
                if(actor.anInt3094 <= 0 && animationSequence.priority == 0) {
                    actor.anInt3074++;
                    return;
                }
            }
            int i = actor.worldX;
            int i_0_ = actor.pathY[-1 + actor.anInt3109] * 128 + 64 * actor.size;
            int i_1_ = actor.worldY;
            int i_2_ = 64 * actor.size + actor.pathX[actor.anInt3109 + -1] * 128;
            if(-i + i_0_ > 256 || -i + i_0_ < -256 || -i_1_ + i_2_ > 256 || i_2_ + -i_1_ < -256) {
                actor.worldX = i_0_;
                actor.worldY = i_2_;
            } else {
                if(i < i_0_) {
                    if(i_1_ < i_2_)
                        actor.initialFaceDirection = 1280;
                    else if(i_2_ < i_1_)
                        actor.initialFaceDirection = 1792;
                    else
                        actor.initialFaceDirection = 1536;
                } else if(i <= i_0_) {
                    if(i_2_ <= i_1_) {
                        if(i_2_ < i_1_)
                            actor.initialFaceDirection = 0;
                    } else
                        actor.initialFaceDirection = 1024;
                } else if(i_1_ < i_2_)
                    actor.initialFaceDirection = 768;
                else if(i_2_ < i_1_)
                    actor.initialFaceDirection = 256;
                else
                    actor.initialFaceDirection = 512;
                int i_3_ = actor.turnAroundAnimationId;
                int i_4_ = 4;
                if(actor.initialFaceDirection != actor.anInt3118 && actor.facingActorIndex == -1 && actor.anInt3113 != 0)
                    i_4_ = 2;
                if(actor.anInt3109 > 2)
                    i_4_ = 6;
                if(actor.anInt3109 > 3)
                    i_4_ = 8;
                int i_5_ = 0x7ff & -actor.anInt3118 + actor.initialFaceDirection;
                if(i_5_ > 1024)
                    i_5_ -= 2048;
                if((i_5_ ^ 0xffffffff) > arg0 || i_5_ > 256) {
                    if(i_5_ < 256 || i_5_ >= 768) {
                        if(i_5_ >= -768 && i_5_ <= -256)
                            i_3_ = actor.turnRightAnimationId;
                    } else
                        i_3_ = actor.turnLeftAnimationId;
                } else
                    i_3_ = actor.walkAnimationId;
                if(i_3_ == -1)
                    i_3_ = actor.walkAnimationId;
                actor.anInt3077 = i_3_;
                if(actor.anInt3074 > 0 && actor.anInt3109 > 1) {
                    actor.anInt3074--;
                    i_4_ = 8;
                }
                if(actor.aBooleanArray3072[-1 + actor.anInt3109])
                    i_4_ <<= 1;
                if(i_1_ < i_2_) {
                    actor.worldY += i_4_;
                    if(actor.worldY > i_2_)
                        actor.worldY = i_2_;
                } else if(i_1_ > i_2_) {
                    actor.worldY -= i_4_;
                    if(actor.worldY < i_2_)
                        actor.worldY = i_2_;
                }
                if(i_4_ >= 8 && actor.anInt3077 == actor.walkAnimationId && actor.runAnimationId != -1)
                    actor.anInt3077 = actor.runAnimationId;
                if(i < i_0_) {
                    actor.worldX += i_4_;
                    if(i_0_ < actor.worldX)
                        actor.worldX = i_0_;
                } else if(i_0_ < i) {
                    actor.worldX -= i_4_;
                    if(i_0_ > actor.worldX)
                        actor.worldX = i_0_;
                }
                if(actor.worldX == i_0_ && i_2_ == actor.worldY) {
                    if(actor.anInt3094 > 0)
                        actor.anInt3094--;
                    actor.anInt3109--;
                }
            }
        }
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
                int deltaY = actor.worldY - 64 * (actor.facePositionY - MovedStatics.baseY - MovedStatics.baseY);
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

    public void move(int moveDirection, boolean isRunning) {
        int i = pathY[0];
        int i_19_ = pathX[0];

        if(playingAnimation != -1 && AnimationSequence.getAnimationSequence(playingAnimation).priority == 1)
            playingAnimation = -1;
        if(anInt3109 < 9)
            anInt3109++;
        for(int i_20_ = anInt3109; i_20_ > 0; i_20_--) {
            pathY[i_20_] = pathY[i_20_ + -1];
            pathX[i_20_] = pathX[i_20_ - 1];
            aBooleanArray3072[i_20_] = aBooleanArray3072[-1 + i_20_];
        }

        // North-west
        if(moveDirection == 0) {
            i_19_++;
            i--;
        }

        // North
        if(moveDirection == 1)
            i_19_++;

        // North-east
        if(moveDirection == 2) {
            i_19_++;
            i++;
        }

        // East
        if(moveDirection == 4)
            i++;

        // West
        if(moveDirection == 3)
            i--;

        // South-west
        if(moveDirection == 5) {
            i--;
            i_19_--;
        }

        // South
        if(moveDirection == 6)
            i_19_--;

        // South-east
        if(moveDirection == 7) {
            i++;
            i_19_--;
        }

        pathY[0] = i;
        pathX[0] = i_19_;
        aBooleanArray3072[0] = isRunning;
    }

    public boolean isInitialized() {
        return false;
    }

    public void method785(int arg0, int arg1, int arg2) {
        for(int i = 0; i < 4; i++) {
            if(arg1 >= anIntArray3136[i]) {
                anIntArray3087[i] = arg2;
                anIntArray3086[i] = arg0;
                anIntArray3136[i] = 70 + arg1;
                return;
            }
        }
    }

    public void method787(int arg0, boolean arg2, int arg3) {
        if(playingAnimation != -1 && AnimationSequence.getAnimationSequence(playingAnimation).priority == 1)
            playingAnimation = -1;
        if(!arg2) {
            int i = -pathY[0] + arg3;
            int i_31_ = -pathX[0] + arg0;
            if(i >= -8 && i <= 8 && i_31_ >= -8 && i_31_ <= 8) {
                if(anInt3109 < 9)
                    anInt3109++;
                for(int i_32_ = anInt3109; i_32_ > 0; i_32_--) {
                    pathY[i_32_] = pathY[-1 + i_32_];
                    pathX[i_32_] = pathX[-1 + i_32_];
                    aBooleanArray3072[i_32_] = aBooleanArray3072[i_32_ + -1];
                }
                pathY[0] = arg3;
                pathX[0] = arg0;
                aBooleanArray3072[0] = false;
                return;
            }
        }
        anInt3109 = 0;
        anInt3074 = 0;
        anInt3094 = 0;
        pathY[0] = arg3;
        pathX[0] = arg0;
        worldX = size * 64 + pathY[0] * 128;
        worldY = size * 64 + pathX[0] * 128;
    }

    public void method790(int arg0) {
        anInt3094 = arg0;
        anInt3109 = 0;
    }
}
