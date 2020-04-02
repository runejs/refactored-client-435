package com.jagex.runescape;

import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class40_Sub5_Sub17_Sub6 extends Renderable {
    public static TypeFace fontSmall;
    public static int[][] playerColours = {{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193}, {8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239}, {25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
    public static Class68 aClass68_3243;
    public static TypeFace fontBold;
    public static int[] anIntArray3248;
    public static int[] anIntArray3250;
    public static int[] anIntArray3253;
    public static RSString aClass1_3254 = RSString.CreateString("redstone2");
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
        int i = SpotAnimDefinition.forId(anInt3249, 13).animationId;
        if(i != -1) {
            aBoolean3237 = false;
            aAnimationSequence_3242 = Class68_Sub1.method1050(i, 2);
        } else
            aBoolean3237 = true;

    }

    public static int method831(int arg0, int arg1, byte arg2) {
        if(arg0 == -1)
            return 12345678;
        if(arg2 != 73)
            playerColours = null;
        arg1 = (0x7f & arg0) * arg1 / 128;
        if(arg1 < 2)
            arg1 = 2;
        else if(arg1 > 126)
            arg1 = 126;
        return arg1 + (arg0 & 0xff80);
    }

    public static void method833(int arg0, boolean arg1) {
        if(((Player.localPlayer.worldX) >> 7 == VarbitDefinition.destinationX) && ((Player.localPlayer.worldY) >> 7 == Class55.destinationY))
            VarbitDefinition.destinationX = 0;
        int i = Player.localPlayerCount;
        if(arg1)
            i = 1;
        int i_0_ = arg0;
        for(/**/; i > i_0_; i_0_++) {
            int i_1_;
            Player player;
            if(arg1) {
                i_1_ = 33538048;
                player = (Player.localPlayer);
            } else {
                i_1_ = Player.trackedPlayerIndices[i_0_] << 14;
                player = (Player.trackedPlayers[Player.trackedPlayerIndices[i_0_]]);
            }
            if(player != null && player.isVisible(1)) {
                player.aBoolean3287 = false;
                int i_2_ = player.worldX >> 7;
                int i_3_ = player.worldY >> 7;
                if(((VertexNormal.lowMemory && Player.localPlayerCount > 50) || Player.localPlayerCount > 200) && !arg1 && (player.anInt3077 == player.idleAnimation))
                    player.aBoolean3287 = true;
                if(i_2_ >= 0 && i_2_ < 104 && i_3_ >= 0 && i_3_ < 104) {
                    if((player.aClass40_Sub5_Sub17_Sub5_3265) != null && ((player.anInt3283 <= Node.pulseCycle)) && (Node.pulseCycle < player.anInt3274)) {
                        player.aBoolean3287 = false;
                        player.anInt3276 = (Class37.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY));
                        Npc.currentScene.method112(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.anInt3258, player.anInt3281, player.anInt3262, player.anInt3289);
                    } else {
                        if((0x7f & player.worldX) == 64 && (player.worldY & 0x7f) == 64) {
                            if(Class40_Sub5_Sub11.anInt2628 == Class61.anIntArrayArray1435[i_2_][i_3_])
                                continue;
                            Class61.anIntArrayArray1435[i_2_][i_3_] = Class40_Sub5_Sub11.anInt2628;
                        }
                        player.anInt3276 = (Class37.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY));
                        Npc.currentScene.method134(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.aBoolean3105);
                    }
                }
            }
        }

    }

    public static void method835() {
        aClass68_3243 = null;
        anIntArray3250 = null;
        playerColours = null;
        fontBold = null;
        anIntArray3253 = null;
        aClass1_3254 = null;
        anIntArray3248 = null;
        anIntArray3255 = null;
        fontSmall = null;
    }

    public Model getRotatedModel(int arg0) {
        SpotAnimDefinition spotAnimDefinition = SpotAnimDefinition.forId(anInt3249, 13);
        int i = -110 / ((arg0 - 41) / 47);
        Model class40_sub5_sub17_sub5;
        if(aBoolean3237)
            class40_sub5_sub17_sub5 = spotAnimDefinition.method549(-1, 2);
        else
            class40_sub5_sub17_sub5 = spotAnimDefinition.method549(anInt3240, 2);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        return class40_sub5_sub17_sub5;
    }

    public void method834(int arg0, int arg1) {
        if(arg0 != 8076)
            method834(106, 6);
        if(!aBoolean3237) {
            anInt3233 += arg1;
            while((anInt3233 > aAnimationSequence_3242.animationLengths[anInt3240])) {
                anInt3233 -= aAnimationSequence_3242.animationLengths[anInt3240];
                anInt3240++;
                if(aAnimationSequence_3242.anIntArray2485.length <= anInt3240) {
                    aBoolean3237 = true;
                    break;
                }
            }
        }
    }
}
