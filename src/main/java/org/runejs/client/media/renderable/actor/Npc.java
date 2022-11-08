package org.runejs.client.media.renderable.actor;

import org.runejs.client.*;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCluster;

public class Npc extends Actor {
    public static int anInt3294 = 0;
    public static Scene currentScene;
    public static int[] anIntArray3304 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    public static int[] anIntArray3312;
    public ActorDefinition actorDefinition;


    public static void parseNpcUpdateMasks() {
        for(int i = 0; i < actorUpdatingIndex; i++) {
            int npcIndex = Player.actorUpdatingIndices[i];
            Npc npc = Player.npcs[npcIndex];
            int mask = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            if((0x1 & mask) != 0) {
                int i_3_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_4_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                npc.method785(i_4_, MovedStatics.pulseCycle, i_3_);
                npc.anInt3139 = MovedStatics.pulseCycle + 300;
                npc.remainingHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                npc.maximumHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            }
            if((0x20 & mask) != 0) {
                npc.graphicId = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                int i_5_ = IncomingPackets.incomingPacketBuffer.getIntBE();
                npc.anInt3129 = 0;
                npc.graphicDelay = MovedStatics.pulseCycle + (0xffff & i_5_);
                npc.graphicHeight = i_5_ >> 16;
                npc.anInt3140 = 0;
                if(npc.graphicDelay > MovedStatics.pulseCycle)
                    npc.anInt3140 = -1;
                if(npc.graphicId == 65535)
                    npc.graphicId = -1;
            }
            if((mask & 0x4) != 0) {
                npc.facingActorIndex = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                if(npc.facingActorIndex == 65535)
                    npc.facingActorIndex = -1;
            }
            if((0x2 & mask) != 0) {
                int i_6_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_7_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                npc.method785(i_7_, MovedStatics.pulseCycle, i_6_);
                npc.anInt3139 = MovedStatics.pulseCycle + 300;
                npc.remainingHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                npc.maximumHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            }
            if((0x40 & mask) != 0) {
                npc.forcedChatMessage = IncomingPackets.incomingPacketBuffer.getString();
                npc.anInt3078 = 100;
            }
            if((mask & 0x80) != 0) {
                npc.actorDefinition = ActorDefinition.getDefinition(IncomingPackets.incomingPacketBuffer.getUnsignedShortBE());
                npc.anInt3083 = npc.actorDefinition.rotateRightAnimation;
                npc.anInt3113 = npc.actorDefinition.degreesToTurn;
                npc.turnRightAnimationId = npc.actorDefinition.rotate90RightAnimation;
                npc.idleAnimation = npc.actorDefinition.stanceAnimation;
                npc.walkAnimationId = npc.actorDefinition.walkAnimation;
                npc.standTurnAnimationId = npc.actorDefinition.rotateLeftAnimation;
                npc.anInt3096 = npc.actorDefinition.boundaryDimension;
                npc.turnLeftAnimationId = npc.actorDefinition.rotate90LeftAnimation;
                npc.turnAroundAnimationId = npc.actorDefinition.rotate180Animation;
            }
            if((mask & 0x8) != 0) {
                npc.facePositionX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                npc.facePositionY = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            }
            if((0x10 & mask) != 0) {
                int animationId = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                if(animationId == 65535)
                    animationId = -1;
                int animationDelay = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                if(animationId == npc.playingAnimation && animationId != -1) {
                    int i_10_ = ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId).replyMode;
                    if(i_10_ == 1) {
                        npc.anInt3115 = 0;
                        npc.anInt3095 = 0;
                        npc.anInt3104 = 0;
                        npc.playingAnimationDelay = animationDelay;
                    }
                    if(i_10_ == 2)
                        npc.anInt3095 = 0;
                } else if(animationId == -1 || npc.playingAnimation == -1 || ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId).forcedPriority >= ProducingGraphicsBuffer_Sub1.getAnimationSequence(npc.playingAnimation).forcedPriority) {
                    npc.playingAnimation = animationId;
                    npc.anInt3115 = 0;
                    npc.playingAnimationDelay = animationDelay;
                    npc.anInt3104 = 0;
                    npc.anInt3095 = 0;
                    npc.anInt3094 = npc.anInt3109;
                }
            }
        }
    }

    public static void parseTrackedNpcs() {
        IncomingPackets.incomingPacketBuffer.initBitAccess();
        int trackedNpcCount = IncomingPackets.incomingPacketBuffer.getBits(8);
        if(Player.npcCount > trackedNpcCount) {
            for(int i = trackedNpcCount; i < Player.npcCount; i++)
                Player.deregisterActorIndices[Class17.deregisterActorCount++] = Player.npcIds[i];
        }
        if(Player.npcCount < trackedNpcCount)
            throw new RuntimeException("gnpov1");
        Player.npcCount = 0;
        for(int i = 0; i < trackedNpcCount; i++) {
            int trackedNpcIndex = Player.npcIds[i];
            Npc npc = Player.npcs[trackedNpcIndex];
            int updateRequired = IncomingPackets.incomingPacketBuffer.getBits(1);
            if(updateRequired == 0) {
                Player.npcIds[Player.npcCount++] = trackedNpcIndex;
                npc.anInt3134 = MovedStatics.pulseCycle;
            } else {
                int movementType = IncomingPackets.incomingPacketBuffer.getBits(2);
                if(movementType == 0) { // No movement
                    Player.npcIds[Player.npcCount++] = trackedNpcIndex;
                    npc.anInt3134 = MovedStatics.pulseCycle;
                    Player.actorUpdatingIndices[actorUpdatingIndex++] = trackedNpcIndex;
                } else if(movementType == 1) { // Walking
                    Player.npcIds[Player.npcCount++] = trackedNpcIndex;
                    npc.anInt3134 = MovedStatics.pulseCycle;
                    int walkDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                    npc.move(walkDirection, false);
                    int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                    if(runUpdateBlock == 1)
                        Player.actorUpdatingIndices[actorUpdatingIndex++] = trackedNpcIndex;
                } else if(movementType == 2) { // Running
                    Player.npcIds[Player.npcCount++] = trackedNpcIndex;
                    npc.anInt3134 = MovedStatics.pulseCycle;
                    int walkDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                    npc.move(walkDirection, true);
                    int runDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                    npc.move(runDirection, true);
                    int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                    if(runUpdateBlock == 1)
                        Player.actorUpdatingIndices[actorUpdatingIndex++] = trackedNpcIndex;
                } else if(movementType == 3) // Yeet
                    Player.deregisterActorIndices[Class17.deregisterActorCount++] = trackedNpcIndex;
            }
        }
    }

    public static void registerNewNpcs() {
        while(IncomingPackets.incomingPacketBuffer.getRemainingBits(IncomingPackets.incomingPacketSize) >= 27) {
            int i = IncomingPackets.incomingPacketBuffer.getBits(15);
            if(i == 32767) {
                break;
            }

            boolean initializing = false;
            if(Player.npcs[i] == null) {
                Player.npcs[i] = new Npc();
                initializing = true;
            }

            Npc npc = Player.npcs[i];
            Player.npcIds[Player.npcCount++] = i;
            npc.anInt3134 = MovedStatics.pulseCycle;
            int initialFaceDirection = Projectile.directions[IncomingPackets.incomingPacketBuffer.getBits(3)];
            if(initializing) {
                npc.initialFaceDirection = initialFaceDirection;
            }

            int offsetX = IncomingPackets.incomingPacketBuffer.getBits(5);
            if(offsetX > 15)
                offsetX -= 32;
            int offsetY = IncomingPackets.incomingPacketBuffer.getBits(5);
            int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
            if(offsetY > 15)
                offsetY -= 32;
            if(runUpdateBlock == 1)
                Player.actorUpdatingIndices[actorUpdatingIndex++] = i;
            int discardWalkingQueue = IncomingPackets.incomingPacketBuffer.getBits(1);

            npc.actorDefinition = ActorDefinition.getDefinition(IncomingPackets.incomingPacketBuffer.getBits(13));
            npc.turnLeftAnimationId = npc.actorDefinition.rotate90LeftAnimation;
            npc.idleAnimation = npc.actorDefinition.stanceAnimation;
            npc.anInt3083 = npc.actorDefinition.rotateRightAnimation;
            npc.walkAnimationId = npc.actorDefinition.walkAnimation;
            npc.anInt3096 = npc.actorDefinition.boundaryDimension;
            npc.turnAroundAnimationId = npc.actorDefinition.rotate180Animation;
            npc.standTurnAnimationId = npc.actorDefinition.rotateLeftAnimation;
            npc.anInt3113 = npc.actorDefinition.degreesToTurn;
            if(npc.anInt3113 == 0)
                npc.anInt3118 = 0;
            npc.turnRightAnimationId = npc.actorDefinition.rotate90RightAnimation;
            npc.method787(Player.localPlayer.pathX[0] + offsetY, -7717, discardWalkingQueue == 1, Player.localPlayer.pathY[0] + offsetX);
        }
        IncomingPackets.incomingPacketBuffer.finishBitAccess();
    }

    public static int method400(int arg0) {
        if(arg0 != -1)
            SceneCluster.packetBuffer = null;
        return LinkedList.anInt1073++;

    }

    public Model getRotatedModel() {
        if(actorDefinition == null)
            return null;
        AnimationSequence animationSequence = playingAnimation == -1 || playingAnimationDelay != 0 ? null : ProducingGraphicsBuffer_Sub1.getAnimationSequence(playingAnimation);
        AnimationSequence animationSequence_0_ = anInt3077 != -1 && (anInt3077 != idleAnimation || animationSequence == null) ? ProducingGraphicsBuffer_Sub1.getAnimationSequence(anInt3077) : null;
        Model model = actorDefinition.getChildModel(animationSequence, animationSequence_0_, anInt3116, anInt3104);
        if(model == null)
            return null;
        model.method799();
        anInt3117 = model.modelHeight;
        if(graphicId != -1 && anInt3140 != -1) {
            Model model1 = SpotAnimDefinition.forId(graphicId).method549(anInt3140);
            if(model1 != null) {
                model1.translate(0, -graphicHeight, 0);
                Model[] models = {model, model1};
                model = new Model(models, 2, true);
            }
        }
        if(actorDefinition.boundaryDimension == 1)
            model.singleTile = true;
        return model;
    }

    public boolean isInitialized() {
        return actorDefinition != null;
    }
}
