package com.jagex.runescape.frame;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.Scene;

import java.awt.*;

public class ScreenController {


    public static ScreenMode frameMode = ScreenMode.FIXED;
    public static int frameWidth = 765;
    public static int frameHeight = 503;

    public static void frameMode(ScreenMode screenMode) {
        if(frameMode != screenMode) {
            frameMode = screenMode;
            if(screenMode == ScreenMode.FIXED) {
                frameWidth = 765;
                frameHeight = 503;
                Class35.aFrame1732.setResizable(false);
                Class35.aFrame1732.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                Class35.aFrame1732.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
            } else if(screenMode == ScreenMode.RESIZABLE) {
                frameWidth = 900;
                frameHeight = 600;
                Class35.aFrame1732.setResizable(true);
                Class35.aFrame1732.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                Class35.aFrame1732.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));


            } else if(screenMode == ScreenMode.FULLSCREEN) {
                frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            }
            Insets insets = Class35.aFrame1732.getInsets();
            Class35.aFrame1732.setSize(insets.right + ScreenController.frameWidth + insets.left, insets.bottom + insets.top + ScreenController.frameHeight);
        }
        //        Class12.width = frameWidth;
        //        IdentityKit.height = frameHeight;


    }

    public static void refreshFrameSize() {
        Class12.width = frameWidth;
        IdentityKit.height = frameHeight;
        if(frameMode != ScreenMode.FIXED) {
            if(frameWidth != Class35.aFrame1732.getWidth()) {
                frameWidth = Class35.aFrame1732.getWidth();
                setBounds();
            }
            if(frameHeight != Class35.aFrame1732.getHeight()) {
                frameHeight = Class35.aFrame1732.getHeight();
                setBounds();
            }
        }

    }

    public static void setBounds() {
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 765 : frameWidth, frameMode == ScreenMode.FIXED ? 503 : frameHeight);
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 479 : frameWidth, frameMode == ScreenMode.FIXED ? 96 : frameHeight);
        Class5.chatboxLineOffsets = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 190 : frameWidth, frameMode == ScreenMode.FIXED ? 261 : frameHeight);
        ActorDefinition.sidebarOffsets = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 512 : frameWidth, frameMode == ScreenMode.FIXED ? 334 : frameHeight);
        Player.viewportOffsets = Rasterizer3D.setLineOffsets(null);

        int[] is = new int[9];
        for(int i = 0; i < 9; i++) {
            int i_0_ = 15 + 32 * i + 128;
            int i_1_ = 3 * i_0_ + 600;
            int i_2_ = Rasterizer3D.sinetable[i_0_];
            is[i] = i_2_ * i_1_ >> 16;
        }
        Scene.method95(500, 800, frameMode == ScreenMode.FIXED ? 512 : frameWidth, frameMode == ScreenMode.FIXED ? 334 : frameHeight, is);
        if(Class51.anInt1197 <= 35 && Class51.anInt1197 >= 30) {
            VarbitDefinition.gameScreenImageProducer = Class40_Sub5_Sub13.createGraphicsBuffer(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.frameWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.frameHeight, Class35.aFrame1732);
        } else {
            Class38.aProducingGraphicsBuffer_887 = Class40_Sub5_Sub13.createGraphicsBuffer(frameWidth, frameHeight, Class35.aFrame1732);
        }
    }

    public static void RenderResizableUI() {
        RenderMiniMapArea(frameWidth-229,0);
        RenderTabArea(frameWidth-234,frameHeight-359);
        RenderChatArea(0,frameHeight-184);
//        RenderStaticUI();
//        RenderInteractableUI();

    }

    public static void RenderInteractableUI() {
        drawFramePieceCutout(RSCanvas.tabBottom, 496+20, 466, RSCanvas.tabBottom.width-20, RSCanvas.tabBottom.height, 20, 0);
        drawFramePiece(InteractiveObject.tabTop, 516, 160);
        drawFramePiece(RSCanvas.chatboxProducingGraphicsBuffer, 17, 357);
        drawFramePiece(SubNode.tabImageProducer, 553, 205);
        drawFramePiece(RSString.mapbackProducingGraphicsBuffer, 550, 4);
        if(Class4.menuOpen/* && Class40_Sub5_Sub17_Sub1.menuScreenArea == 1*/) {
            Class40_Sub5_Sub6.drawMenu(0, 0);
        }
    }

    public static void RenderStaticUI() {
        drawFramePiece(Landscape.framePieceRight, 0, 4);
        drawFramePiece(Class40_Sub5_Sub17_Sub6.framePieceTop, 0, 0);
        drawFramePiece(Class40_Sub5_Sub1.chatboxRight, 0, 357);
        drawFramePiece(Class39.mapbackLeft, 722, 4);
        drawFramePiece(GameObject.tabPieceLeft, 743, 205);
        drawFramePiece(Class40_Sub7.mapBackRight, 516, 4);
        drawFramePiece(Class61.tabPieceUpperRight, 516, 205);
        drawFramePiece(Class30.tabPieveLowerRight, 496, 357);
        drawFramePiece(Class17.chatboxTop, 0, 338);

    }

    public static void RenderMiniMapArea(int x, int y) {
        // height 168
        // width 229
        drawFramePiece(Class39.mapbackLeft, x+ 206-20, y+4);
        drawFramePieceCutout(Class40_Sub7.mapBackRight, x, y+4, Class40_Sub7.mapBackRight.width- 20, Class40_Sub7.mapBackRight.height, 20,0);
        drawFramePieceCutout(Class40_Sub5_Sub17_Sub6.framePieceTop, x, y,229, 4, 536,0 );
        drawFramePieceCutout(InteractiveObject.tabTop, x, y+160,229, 8, 20,0 );
        drawFramePiece(RSString.mapbackProducingGraphicsBuffer, x+34-20, y+4);

    }
    public static void RenderTabArea(int x, int y) {
        // height 337
        // width 234
        drawFramePiece(GameObject.tabPieceLeft, x+212, y+39);
        drawFramePieceCutout(Class61.tabPieceUpperRight, x, y+39,Class61.tabPieceUpperRight.width-15, Class61.tabPieceUpperRight.height, 15, 0 );
        drawFramePieceCutout(Class30.tabPieveLowerRight, x, y+191, Class30.tabPieveLowerRight.width-35, Class30.tabPieveLowerRight.height, 35, 0);
        drawFramePieceCutout(Class17.chatboxTop, x, y+172, Class17.chatboxTop.width-531, Class17.chatboxTop.height, 531, 0);
        drawFramePieceCutout(RSCanvas.tabBottom, x, y+300, RSCanvas.tabBottom.width-35, RSCanvas.tabBottom.height, 35, 0);
        drawFramePieceCutout(InteractiveObject.tabTop, x, y,InteractiveObject.tabTop.width-15, InteractiveObject.tabTop.height-6, 15,6 );
        drawFramePiece(SubNode.tabImageProducer, x+22, y+39);


    }
    public static void RenderChatArea(int x, int y) {
        //width 516
        //height 184
        drawFramePiece(RSCanvas.chatboxProducingGraphicsBuffer, x+17, y+16);
        drawFramePiece(HuffmanEncoding.aProducingGraphicsBuffer_1541, x, y+112);
        drawFramePieceCutout(RSCanvas.tabBottom, x+496, y+125, 20, RSCanvas.tabBottom.height, 0, 0);
        drawFramePiece(Class40_Sub5_Sub1.chatboxRight, x, y+16);
        drawFramePieceCutout(Class17.chatboxTop, x, y, Class17.chatboxTop.width-37, Class17.chatboxTop.height-3, 0, 3);
//        System.out.println(Class40_Sub5_Sub1.chatboxRight.height + (Class17.chatboxTop.height-3) + HuffmanEncoding.aProducingGraphicsBuffer_1541.height);

        drawFramePieceCutout(Class30.tabPieveLowerRight, x+496, y+16, 20, Class30.tabPieveLowerRight.height, 0, 0);


    }

    public static void drawFramePiece(ProducingGraphicsBuffer framePiece, int x, int y) {
        Rasterizer.copyPixels(framePiece.pixels, framePiece.width, framePiece.height, x, y);
    }

    public static void drawFramePieceCutout(ProducingGraphicsBuffer framePiece, int x, int y, int width, int height, int offsetX, int offsetY) {
        Rasterizer.copyPixelsCutOff(framePiece.pixels, framePiece.width, framePiece.height, x, y, width, height, offsetX, offsetY);
    }


}
