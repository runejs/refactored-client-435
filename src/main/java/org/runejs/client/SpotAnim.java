package org.runejs.client;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.frame.DebugTools;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.Scene;

public class SpotAnim extends Renderable {
    public static ProducingGraphicsBuffer framePieceTop;
    public static int[] anIntArray3248;
    public static int[] blendedHue;
    public static int[] anIntArray3253;
    public static int[] anIntArray3255;

    public int startCycle;
    public int z;
    public int anInt3233;
    public int y;
    public boolean animationFinished;
    public int plane;
    public int frame = 0;
    public AnimationSequence animation;
    public int x;
    public int id;

    public SpotAnim(int id, int plane, int x, int y, int z, int delay, int cycle) {
        animationFinished = false;
        anInt3233 = 0;
        this.y = y;
        this.x = x;
        startCycle = delay + cycle;
        this.z = z;
        this.id = id;
        this.plane = plane;
        int animationId = SpotAnimDefinition.forId(this.id).animationId;
        if(animationId != -1) {
            animationFinished = false;
            animation = ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId);
        } else
            animationFinished = true;

    }

    public static int mixLightness(int hsl, int lightness) {
        if(hsl == -1)
            return 12345678;

        lightness = (0x7f & hsl) * lightness / 128;
        if(lightness < 2)
            lightness = 2;
        else if(lightness > 126)
            lightness = 126;

        return lightness + (hsl & 0xff80);
    }

    public static void renderPlayers(int arg0, boolean arg1) {
        if(Player.localPlayer.worldX >> 7 == MovedStatics.destinationX && Player.localPlayer.worldY >> 7 == Class55.destinationY) {
            MovedStatics.destinationX = 0;

            DebugTools.walkpathX = null;
            DebugTools.walkpathY = null;
        }
        int i = Player.localPlayerCount;
        if(arg1)
            i = 1;
        int i_0_ = arg0;
        for(/**/; i > i_0_; i_0_++) {
            int i_1_;
            Player player;
            if(arg1) {
                i_1_ = 33538048;
                player = Player.localPlayer;
            } else {
                i_1_ = Player.trackedPlayerIndices[i_0_] << 14;
                player = Player.trackedPlayers[Player.trackedPlayerIndices[i_0_]];
            }
            if(player != null && player.isInitialized()) {
                player.aBoolean3287 = false;
                int tileX = player.worldX >> 7;
                int tileY = player.worldY >> 7;
                if((VertexNormal.lowMemory && Player.localPlayerCount > 50 || Player.localPlayerCount > 200) && !arg1 && player.anInt3077 == player.idleAnimation)
                    player.aBoolean3287 = true;
                if(tileX >= 0 && tileX < 104 && tileY >= 0 && tileY < 104) {
                    if(player.playerModel != null && player.anInt3283 <= MovedStatics.pulseCycle && MovedStatics.pulseCycle < player.anInt3274) {
                        player.aBoolean3287 = false;
                        player.anInt3276 = Scene.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY);
                        Npc.currentScene.method112(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.anInt3258, player.anInt3281, player.anInt3262, player.anInt3289);
                    } else {
                        if((0x7f & player.worldX) == 64 && (player.worldY & 0x7f) == 64) {
                            if(MovedStatics.anInt2628 == MovedStatics.anIntArrayArray1435[tileX][tileY])
                                continue;
                            MovedStatics.anIntArrayArray1435[tileX][tileY] = MovedStatics.anInt2628;
                        }
                        player.anInt3276 = Scene.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY);
                        Npc.currentScene.method134(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.aBoolean3105);
                    }
                }
            }
        }

    }


    public Model getRotatedModel() {
        SpotAnimDefinition spotAnimDefinition = SpotAnimDefinition.forId(id);
        Model model;
        if(animationFinished)
            model = spotAnimDefinition.getModel(-1);
        else
            model = spotAnimDefinition.getModel(frame);
        if(model == null)
            return null;
        return model;
    }

    public void method834(int delta) {
        if(!animationFinished) {
            anInt3233 += delta;
            while(anInt3233 > animation.frameLengths[frame]) {
                anInt3233 -= animation.frameLengths[frame];
                frame++;
                if(animation.frameIds.length <= frame) {
                    animationFinished = true;
                    break;
                }
            }
        }
    }
}
