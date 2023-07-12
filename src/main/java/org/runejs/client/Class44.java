package org.runejs.client;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.node.Class40_Sub6;
import org.runejs.client.scene.util.CollisionMap;

public class Class44 implements Runnable {
    public static byte[][] aByteArrayArray1039 = new byte[250][];
    public static IndexedImage chatboxBackgroundImage;
    public static int anInt1049 = 0;


    public static void processWalkingStep(int arg0, Actor actor) {
        actor.anInt3077 = actor.idleAnimation;
        if(actor.anInt3109 == 0)
            actor.anInt3074 = 0;
        else {
            if(actor.playingAnimation != -1 && actor.playingAnimationDelay == 0) {
                AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(actor.playingAnimation);
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

    public void run() {
        try {
            for(; ; ) {
                Class40_Sub6 class40_sub6;
                synchronized(RSCanvas.aLinkedList_53) {
                    class40_sub6 = (Class40_Sub6) RSCanvas.aLinkedList_53.peekFirst();
                }
                if(class40_sub6 == null) {
                    MovedStatics.threadSleep(100L);
                    synchronized(CollisionMap.anObject162) {
                        if(Buffer.anInt1987 <= 1) {
                            Buffer.anInt1987 = 0;
                            CollisionMap.anObject162.notifyAll();
                            break;
                        }
                        Buffer.anInt1987--;
                    }
                } else {
                    if(class40_sub6.anInt2112 == 0) {
                        class40_sub6.cacheIndex.put(class40_sub6.aByteArray2102, class40_sub6.aByteArray2102.length, (int) class40_sub6.key);
                        synchronized(RSCanvas.aLinkedList_53) {
                            class40_sub6.unlink();
                        }
                    } else if(class40_sub6.anInt2112 == 1) {
                        class40_sub6.aByteArray2102 = class40_sub6.cacheIndex.get((int) class40_sub6.key);
                        synchronized(RSCanvas.aLinkedList_53) {
                            MovedStatics.aLinkedList_2604.addLast(class40_sub6);
                        }
                    }
                    synchronized(CollisionMap.anObject162) {
                        if(Buffer.anInt1987 <= 1) {
                            Buffer.anInt1987 = 0;
                            CollisionMap.anObject162.notifyAll();
                            break;
                        }
                        Buffer.anInt1987 = 600;
                    }
                }
            }
        } catch(Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }
}
