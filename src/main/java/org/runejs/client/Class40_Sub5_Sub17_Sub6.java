package org.runejs.client;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.Scene;

public class Class40_Sub5_Sub17_Sub6 extends Renderable {
    public static ProducingGraphicsBuffer framePieceTop;
    public static int[] anIntArray3248;
    public static int[] blendedHue;
    public static int[] anIntArray3253;
    public static int[] anIntArray3255;

    public int anInt3230;
    public int anInt3231;
    public int anInt3233;
    public int anInt3235;
    public boolean aBoolean3237;
    public int anInt3239;
    public int anInt3240 = 0;
    public AnimationSequence aAnimationSequence_3242;
    public int anInt3244;
    public int anInt3249;

    public Class40_Sub5_Sub17_Sub6(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        aBoolean3237 = false;
        anInt3233 = 0;
        anInt3235 = arg3;
        anInt3244 = arg2;
        anInt3230 = arg5 + arg6;
        anInt3231 = arg4;
        anInt3249 = arg0;
        anInt3239 = arg1;
        int i = SpotAnimDefinition.forId(anInt3249).animationId;
        if(i != -1) {
            aBoolean3237 = false;
            aAnimationSequence_3242 = ProducingGraphicsBuffer_Sub1.getAnimationSequence(i);
        } else
            aBoolean3237 = true;

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

    public static void method833(int arg0, boolean arg1) {
        if(Player.localPlayer.worldX >> 7 == MovedStatics.destinationX && Player.localPlayer.worldY >> 7 == Class55.destinationY)
            MovedStatics.destinationX = 0;
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
                int i_2_ = player.worldX >> 7;
                int i_3_ = player.worldY >> 7;
                if((VertexNormal.lowMemory && Player.localPlayerCount > 50 || Player.localPlayerCount > 200) && !arg1 && player.anInt3077 == player.idleAnimation)
                    player.aBoolean3287 = true;
                if(i_2_ >= 0 && i_2_ < 104 && i_3_ >= 0 && i_3_ < 104) {
                    if(player.playerModel != null && player.anInt3283 <= MovedStatics.pulseCycle && MovedStatics.pulseCycle < player.anInt3274) {
                        player.aBoolean3287 = false;
                        player.anInt3276 = Scene.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY);
                        Npc.currentScene.method112(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.anInt3258, player.anInt3281, player.anInt3262, player.anInt3289);
                    } else {
                        if((0x7f & player.worldX) == 64 && (player.worldY & 0x7f) == 64) {
                            if(MovedStatics.anInt2628 == MovedStatics.anIntArrayArray1435[i_2_][i_3_])
                                continue;
                            MovedStatics.anIntArrayArray1435[i_2_][i_3_] = MovedStatics.anInt2628;
                        }
                        player.anInt3276 = Scene.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY);
                        Npc.currentScene.method134(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.aBoolean3105);
                    }
                }
            }
        }

    }


    public Model getRotatedModel() {
        SpotAnimDefinition spotAnimDefinition = SpotAnimDefinition.forId(anInt3249);
        Model class40_sub5_sub17_sub5;
        if(aBoolean3237)
            class40_sub5_sub17_sub5 = spotAnimDefinition.method549(-1);
        else
            class40_sub5_sub17_sub5 = spotAnimDefinition.method549(anInt3240);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        return class40_sub5_sub17_sub5;
    }

    public void method834(int arg1) {
        if(!aBoolean3237) {
            anInt3233 += arg1;
            while(anInt3233 > aAnimationSequence_3242.frameLengths[anInt3240]) {
                anInt3233 -= aAnimationSequence_3242.frameLengths[anInt3240];
                anInt3240++;
                if(aAnimationSequence_3242.frameIds.length <= anInt3240) {
                    aBoolean3237 = true;
                    break;
                }
            }
        }
    }
}
