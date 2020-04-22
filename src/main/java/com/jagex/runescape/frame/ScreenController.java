package com.jagex.runescape.frame;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.Scene;

import java.awt.*;

public class ScreenController {


    public static ScreenMode frameMode = ScreenMode.RESIZABLE;
    public static int frameWidth = 900;
    public static int frameHeight = 600;

    public static void frameMode(ScreenMode screenMode) {
        if (frameMode != screenMode) {
            frameMode = screenMode;
            if (screenMode == ScreenMode.FIXED) {
                frameWidth = 765;
                frameHeight = 503;
            } else if (screenMode == ScreenMode.RESIZABLE) {
                frameWidth = 900;
                frameHeight = 600;
            } else if (screenMode == ScreenMode.FULLSCREEN) {
                frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            }
        }
        Class12.width = frameWidth;
        IdentityKit.height = frameHeight;
    }

    public static void refreshFrameSize() {
        if (frameMode != ScreenMode.FIXED) {
            if (frameWidth != Class35.aFrame1732.getWidth()) {
                frameWidth = Class35.aFrame1732.getWidth();
                setBounds();
            }
            if (frameHeight != Class35.aFrame1732.getHeight()) {
                frameHeight =Class35.aFrame1732.getHeight();
                setBounds();
            }
        }
        Class12.width = frameWidth;
        IdentityKit.height = frameHeight;
    }

    public static void setBounds() {
//        Rasterizer3D.setBounds(frameMode == ScreenMode.FIXED ? 765 : frameWidth, frameMode == ScreenMode.FIXED ? 503 : frameHeight);
//        fullScreenTextureArray = Texture.anIntArray1472;
//        Texture.method365(frameMode == ScreenMode.FIXED ? 516 : frameWidth, frameMode == ScreenMode.FIXED ? 165 : frameHeight);
//        anIntArray1180 = Texture.anIntArray1472;
//        Texture.method365(frameMode == ScreenMode.FIXED ? 250 : frameWidth, frameMode == ScreenMode.FIXED ? 335 : frameHeight);
//        anIntArray1181 = Texture.anIntArray1472;
//        Texture.method365(frameMode == ScreenMode.FIXED ? 512 : frameWidth, frameMode == ScreenMode.FIXED ? 334 : frameHeight);
//        anIntArray1182 = Texture.anIntArray1472;

        Rasterizer3D.prepare(null,frameMode == ScreenMode.FIXED ? 765 : frameWidth, frameMode == ScreenMode.FIXED ? 503 : frameHeight);
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null,frameMode == ScreenMode.FIXED ? 190 : frameWidth, frameMode == ScreenMode.FIXED ? 261 : frameHeight);
        Player.anIntArray3284 = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 479 : frameWidth, frameMode == ScreenMode.FIXED ? 96 : frameHeight);
        Class5.chatboxLineOffsets = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null,frameMode == ScreenMode.FIXED ? 190 : frameWidth, frameMode == ScreenMode.FIXED ? 261 : frameHeight);
        ActorDefinition.sidebarOffsets = Rasterizer3D.setLineOffsets(null);

        int[] is = new int[9];
        for (int i = 0; i < 9; i++) {
            int i_0_ = 15 + 32 * i + 128;
            int i_1_ = 3 * i_0_ + 600;
            int i_2_ = Rasterizer3D.sinetable[i_0_];
            is[i] = i_2_ * i_1_ >> 16;
        }
        Scene.method95(500, 800, frameMode == ScreenMode.FIXED ? 512 : frameWidth, frameMode == ScreenMode.FIXED ? 334 : frameHeight, is);
        if (Class51.anInt1197 <= 35 && Class51.anInt1197 >= 30 ) {
            VarbitDefinition.gameScreenImageProducer = Class40_Sub5_Sub13.createGraphicsBuffer(frameWidth,frameHeight, Class35.aFrame1732);
        } else {
            Class38.aProducingGraphicsBuffer_887 = Class40_Sub5_Sub13.createGraphicsBuffer(frameWidth,frameHeight, Class35.aFrame1732);
        }
    }
}
