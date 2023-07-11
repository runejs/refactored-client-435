package org.runejs.client.frame;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.RasterizerInstanced;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.*;

public class Minimap extends FramePieceRenderer {
    public static ImageRGB minimapCompass;
    public static int minimapState = 0;
    public static IndexedImage minimapBackgroundImage;
    public static ProducingGraphicsBuffer mapbackProducingGraphicsBuffer;
    public static ImageRGB minimapImage;
    public static int minimapHintCount = 0;
    public static int[] minimapHintX = new int[1000];
    public static int[] minimapHintY = new int[1000];
    public static ImageRGB[] minimapHint = new ImageRGB[1000];
    public static ImageRGB[] mapDots;
    public static ImageRGB[] minimapMarkers;
    private static int[] resizableMinimapOffsets1;
    private static int[] resizableMinimapOffsets2;
    private static ProducingGraphicsBuffer resizableMiniMapimage;
    private int[] resizableCompasOffsets1;
    private int[] resizableCompasOffsets2;
    private ProducingGraphicsBuffer tempResizableMiniMapimage;
    private static int[] resizableMinimapLineOffsets;

    public Minimap() {
        this.tempResizableMiniMapimage = MovedStatics.createGraphicsBuffer(210, 210, MouseHandler.gameCanvas);
        resizableMinimapOffsets1 = new int[200];
        resizableMinimapOffsets2 = new int[200];
        for(int i = 0; i < resizableMinimapOffsets2.length; i++) {
            resizableMinimapOffsets1[i] = 200;
            resizableMinimapOffsets2[i] = 0;
        }

        resizableMiniMapimage = MovedStatics.createGraphicsBuffer(210, 210, MouseHandler.gameCanvas);
        rasterizerInstanced = new RasterizerInstanced(this.tempResizableMiniMapimage);

    }

    public static void drawOnMinimap(int x, int y, ImageRGB sprite) {
        if (sprite == null) {
            return;
        }
        int angle = 0x7ff & Main.getMinimapRotation();
        int l = x * x + y * y;
        if (l > 6400) {
            return;
        }
        int sine = Model.SINE[angle];
        int cosine = Model.COSINE[angle];
        int zoom = 0;

        sine = sine * 256 / (zoom + 256);
        cosine = cosine * 256 / (zoom + 256);
        int i_3_ = cosine * y + x * sine >> 16;
        int i_4_ = -(y * sine) + cosine * x >> 16;
        if (l > 2500)
            sprite.drawTo(minimapBackgroundImage, 98 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + -i_4_ + 79);
        else
            sprite.drawImage(4 + -(sprite.maxWidth / 2) + i_3_ + 94, -4 + -i_4_ + 83 + -(sprite.maxHeight / 2));
    }

    public static void renderMinimap() {
        createMinimapRaster();

        if(minimapState == 2) {
            byte[] mmBackgroundPixels = minimapBackgroundImage.imgPixels;
            int[] rasterPixels = Rasterizer.destinationPixels;
            int pixelCount = mmBackgroundPixels.length;
            for(int i = 0; i < pixelCount; i++) {
                if(mmBackgroundPixels[i] == 0)
                    rasterPixels[i] = 0;
            }
            minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, Main.getMinimapRotation(), 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
            ActorDefinition.drawMapBack();
            return;
        }

        int centerX = 48 + Player.localPlayer.worldX / 32;
        int centerY = 464 + -(Player.localPlayer.worldY / 32);
        int angle = Main.getMinimapRotation() & 0x7ff;
        int minimapZoom = 0;

        minimapImage.shapeImageToPixels(25, 5, 146, 151, centerX, centerY, angle, minimapZoom + 256, Landscape.anIntArray1186, MovedStatics.anIntArray852);
        for(int i = 0; minimapHintCount > i; i++) {
            int hintX = 2 + 4 * minimapHintX[i] + -(Player.localPlayer.worldX / 32);
            int hintY = 2 + 4 * minimapHintY[i] - Player.localPlayer.worldY / 32;
            drawOnMinimap(hintY, hintX, minimapHint[i]);
        }
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                LinkedList linkedList = Wall.groundItems[Player.worldLevel][x][y];
                if(linkedList != null) {
                    int itemX = -(Player.localPlayer.worldY / 32) + 2 + y * 4;
                    int itemY = -(Player.localPlayer.worldX / 32) + 2 + x * 4;
                    drawOnMinimap(itemX, itemY, mapDots[0]);
                }
            }
        }
        for(int i = 0; Player.npcCount > i; i++) {
            Npc npc = Player.npcs[Player.npcIds[i]];
            if(npc != null && npc.isInitialized()) {
                ActorDefinition definition = npc.actorDefinition;
                if(definition.childIds != null)
                    definition = definition.getChildDefinition();
                if(definition != null && definition.renderOnMinimap && definition.isClickable) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 + -(Player.localPlayer.worldY / 32);
                    drawOnMinimap(npcY, npcX, mapDots[1]);
                }
            }
        }
        for(int i = 0; Player.localPlayerCount > i; i++) {
            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            if(player != null && player.isInitialized()) {
                int playerX = player.worldX / 32 + -(Player.localPlayer.worldX / 32);
                int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                boolean isFriend = false;
                long name = RSString.nameToLong(player.playerName);
                for(int friend = 0; Player.friendsCount > friend; friend++) {
                    if(name == Class59.friends[friend] && Player.friendWorlds[friend] != 0) {
                        isFriend = true;
                        break;
                    }
                }
                boolean isTeammate = false;
                if(Player.localPlayer.teamId != 0 && player.teamId != 0 && player.teamId == Player.localPlayer.teamId)
                    isTeammate = true;
                if(isFriend)
                    drawOnMinimap(playerY, playerX, mapDots[3]);
                else if(isTeammate)
                    drawOnMinimap(playerY, playerX, mapDots[4]);
                else
                    drawOnMinimap(playerY, playerX, mapDots[2]);
            }
        }
        if(Player.headIconDrawType != 0 && MovedStatics.pulseCycle % 20 < 10) {
            if(Player.headIconDrawType == 1 && HuffmanEncoding.anInt1545 >= 0 && Player.npcs.length > HuffmanEncoding.anInt1545) {
                Npc npc = Player.npcs[HuffmanEncoding.anInt1545];
                if(npc != null) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 - Player.localPlayer.worldY / 32;
                    MovedStatics.drawMinimapMark(minimapMarkers[1], npcX, npcY);
                }
            }
            if(Player.headIconDrawType == 2) {
                int hintX = -(Player.localPlayer.worldY / 32) + 2 + 4 * (-Class26.baseY + MovedStatics.hintIconPosY);
                int hintY = 4 * (ProducingGraphicsBuffer.hintIconPosX - MovedStatics.baseX) - (-2 + Player.localPlayer.worldX / 32);
                MovedStatics.drawMinimapMark(minimapMarkers[1], hintY, hintX);
            }
            if(Player.headIconDrawType == 10 && ProducingGraphicsBuffer.anInt1623 >= 0 && Player.trackedPlayers.length > ProducingGraphicsBuffer.anInt1623) {
                Player player = Player.trackedPlayers[ProducingGraphicsBuffer.anInt1623];
                if(player != null) {
                    int playerX = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                    int playerY = player.worldX / 32 - Player.localPlayer.worldX / 32;
                    MovedStatics.drawMinimapMark(minimapMarkers[1], playerY, playerX);
                }
            }
        }
        if(MovedStatics.destinationX != 0) {
            int flagX = 2 + MovedStatics.destinationX * 4 + -(Player.localPlayer.worldX / 32);
            int flagY = 2 + 4 * Class55.destinationY + -(Player.localPlayer.worldY / 32);
            drawOnMinimap(flagY, flagX, minimapMarkers[0]);
        }
        Rasterizer.drawFilledRectangle(97, 78, 3, 3, 16777215);
        minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, Main.getMinimapRotation(), 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
        minimapBackgroundImage.drawImage(0, 0);

        if(MovedStatics.menuOpen && ScreenController.frameMode == ScreenMode.FIXED && Projectile.menuScreenArea == 1) {
            MovedStatics.drawMenu(550, 4);
        }
        ActorDefinition.drawMapBack();

    }

    public static void createMinimapRaster() {
        mapbackProducingGraphicsBuffer.prepareRasterizer();
    }

    public void drawResizableMiniMapArea(int x, int y) {
        ScreenController.drawFramePiece(resizableMiniMapimage, x, y);
    }

    public void RenderResizableMiniMapArea(int x, int y) {
        if(this.resizableCompasOffsets1 == null) {
            resizableCompasOffsets1 = new int[33];
            resizableCompasOffsets2 = new int[33];
            for(int y1 = 0; y1 < 33; y1++) {
                int i_15_ = 0;
                int i_16_ = 999;
                for(int x1 = 0; x1 < 34; x1++) {
                    if(minimapBackgroundImage.imgPixels[minimapBackgroundImage.imgWidth * y1 + x1] == 0) {
                        if(i_16_ == 999)
                            i_16_ = x1;
                    } else if(i_16_ != 999) {
                        i_15_ = x1;
                        break;
                    }
                }
                resizableCompasOffsets2[y1] = i_16_;
                resizableCompasOffsets1[y1] = -i_16_ + i_15_;
            }
        }
        if(minimapState == 2) {
            resizableMiniMapimage.prepareRasterizer();
            resizableMinimapLineOffsets = Rasterizer3D.setLineOffsets(resizableMinimapLineOffsets);
            byte[] mmBackgroundPixels = minimapBackgroundImage.imgPixels;
            int[] rasterPixels = Rasterizer.destinationPixels;
            int pixelCount = mmBackgroundPixels.length;
            for(int i = 0; i < pixelCount; i++) {
                if(mmBackgroundPixels[i] == 0)
                    rasterPixels[i] = 0;
            }
            Rasterizer.drawFilledRectangle(0, 0, 210, 210, 0x242017);
            Rasterizer.drawFilledRectangle(5, 5, 200, 200, 0x000000);

            //        Rasterizer.drawFilledRectangle(x-43,y, 43, 43, 0x242017);
            Rasterizer.drawFilledRectangle(0, 0, 20, 42, 0x242017);
            Rasterizer.drawFilledRectangle(0, 0, 42, 20, 0x242017);

            Rasterizer.drawCircle(21, 21, 20, 0x242017);
            minimapCompass.shapeImageToPixels(5, 5, 33, 33, 25, 25, Main.getMinimapRotation(), 256, resizableCompasOffsets2, resizableCompasOffsets1);


            Class65.method1018();

            ScreenController.drawFramePiece(resizableMiniMapimage, x, y);
            return;
        }

        int i = 48 + Player.localPlayer.worldX / 32;
        int i_8_ = 464 + -(Player.localPlayer.worldY / 32);
        int i_9_ = Main.getMinimapRotation() & 0x7ff;
        int minimapZoom = 0;

        shapeImageToPixels(minimapImage,5, 5, 200, 200, i, i_8_, i_9_, minimapZoom + 256, resizableMinimapOffsets2, resizableMinimapOffsets1);
        drawResizableMinimapDots();
        rasterizerInstanced.drawFilledRectangle(105, 105, 3, 3, 16777215);
        rasterizerInstanced.drawFilledRectangle(0, 0, 210, 5, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 205, 210, 5, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 0, 5, 210, 0x242017);
        rasterizerInstanced.drawFilledRectangle(205, 0, 5, 210, 0x242017);

        //        Rasterizer.drawFilledRectangle(x-43,y, 43, 43, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 0, 20, 42, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 0, 42, 20, 0x242017);

        rasterizerInstanced.drawCircle(21, 21, 20, 0x242017);
        shapeImageToPixels(minimapCompass, 5, 5, 33, 33, 25, 25, Main.getMinimapRotation(), 256, resizableCompasOffsets2, resizableCompasOffsets1);

        System.arraycopy(tempResizableMiniMapimage.pixels, 0, resizableMiniMapimage.pixels,0, resizableMiniMapimage.pixels.length);
//        Class65.method1018();

        //        ScreenController.drawFramePiece(resizableMiniMapimage, x, y);

    }

    private void drawResizableMinimapDots() {
        for(int i = 0; minimapHintCount > i; i++) {
            int hintX = 2 + 4 * minimapHintX[i] + -(Player.localPlayer.worldX / 32);
            int hintY = 2 + 4 * minimapHintY[i] - Player.localPlayer.worldY / 32;
            drawOnResizableMinimap(hintX, hintY, minimapHint[i]);
        }
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                LinkedList linkedList = Wall.groundItems[Player.worldLevel][x][y];
                if(linkedList != null) {
                    int itemY = -(Player.localPlayer.worldY / 32) + 2 + y * 4;
                    int itemX = -(Player.localPlayer.worldX / 32) + 2 + x * 4;
                    drawOnResizableMinimap(itemX, itemY, mapDots[0]);
                }
            }
        }
        for(int i = 0; Player.npcCount > i; i++) {
            Npc npc = Player.npcs[Player.npcIds[i]];
            if(npc != null && npc.isInitialized()) {
                ActorDefinition definition = npc.actorDefinition;
                if(definition.childIds != null)
                    definition = definition.getChildDefinition();
                if(definition != null && definition.renderOnMinimap && definition.isClickable) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 + -(Player.localPlayer.worldY / 32);
                    drawOnResizableMinimap(npcX, npcY, mapDots[1]);
                }
            }
        }
        for(int i = 0; Player.localPlayerCount > i; i++) {
            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            if(player != null && player.isInitialized()) {
                int playerX = player.worldX / 32 + -(Player.localPlayer.worldX / 32);
                int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                boolean isFriend = false;
                long name = RSString.nameToLong(player.playerName);
                for(int friend = 0; Player.friendsCount > friend; friend++) {
                    if(name == Class59.friends[friend] && Player.friendWorlds[friend] != 0) {
                        isFriend = true;
                        break;
                    }
                }
                boolean isTeammate = false;
                if(Player.localPlayer.teamId != 0 && player.teamId != 0 && player.teamId == Player.localPlayer.teamId)
                    isTeammate = true;
                if(isFriend)
                    drawOnResizableMinimap(playerX, playerY, mapDots[3]);
                else if(isTeammate)
                    drawOnResizableMinimap(playerX, playerY, mapDots[4]);
                else
                    drawOnResizableMinimap(playerX, playerY, mapDots[2]);
            }
        }
        if(Player.headIconDrawType != 0 && MovedStatics.pulseCycle % 20 < 10) {
            if(Player.headIconDrawType == 1 && HuffmanEncoding.anInt1545 >= 0 && Player.npcs.length > HuffmanEncoding.anInt1545) {
                Npc npc = Player.npcs[HuffmanEncoding.anInt1545];
                if(npc != null) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 - Player.localPlayer.worldY / 32;
                    drawMinimapMark(minimapMarkers[1], npcX, npcY);
                }
            }
            if(Player.headIconDrawType == 2) {
                int hintY = -(Player.localPlayer.worldY / 32) + 2 + 4 * (-Class26.baseY + MovedStatics.hintIconPosY);
                int hintX = 4 * (ProducingGraphicsBuffer.hintIconPosX - MovedStatics.baseX) - (-2 + Player.localPlayer.worldX / 32);
                drawMinimapMark(minimapMarkers[1], hintX, hintY);
            }
            if(Player.headIconDrawType == 10 && ProducingGraphicsBuffer.anInt1623 >= 0 && Player.trackedPlayers.length > ProducingGraphicsBuffer.anInt1623) {
                Player player = Player.trackedPlayers[ProducingGraphicsBuffer.anInt1623];
                if(player != null) {
                    int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                    int playerX = player.worldX / 32 - Player.localPlayer.worldX / 32;
                    drawMinimapMark(minimapMarkers[1], playerX, playerY);
                }
            }
        }
        if(MovedStatics.destinationX != 0) {
            int flagX = 2 + MovedStatics.destinationX * 4 + -(Player.localPlayer.worldX / 32);
            int flagY = 2 + 4 * Class55.destinationY + -(Player.localPlayer.worldY / 32);
            drawOnResizableMinimap(flagX, flagY, minimapMarkers[0]);
        }
    }

    public void drawOnResizableMinimap(int x, int y, ImageRGB sprite) {
        if(sprite == null) {
            return;
        }
        int angle = 0x7ff & Main.getMinimapRotation();
        int l = y * y + x * x;
        if(l > 17000) {
            return;
        }
        int sine = Model.SINE[angle];
        int cosine = Model.COSINE[angle];
        int zoom = 0;

        sine = sine * 256 / (zoom + 256);
        cosine = cosine * 256 / (zoom + 256);
        int i_3_ = cosine * x + y * sine >> 16;
        int i_4_ = -(x * sine) + cosine * y >> 16;
        drawImage(sprite, 106 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + -i_4_ + 106);
    }

    public void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + mapY * mapY;
        if (len > 4225 && len < 90000) {
            int theta = 0x7ff & Main.getMinimapRotation();
            int sine = Model.SINE[theta];
            int cosine = Model.COSINE[theta];
            int zoom = 0;

            sine = sine * 256 / (zoom + 256);
            cosine = cosine * 256 / (zoom + 256);
            int y = cosine * mapY - sine * mapX >> 16;
            int x = mapX * cosine + mapY * sine >> 16;
            double angle = Math.atan2(x, y);
            int drawX = (int) (Math.sin(angle) * 63.0);
            int drawY = (int) (57.0 * Math.cos(angle));
            drawRotated(sprite, -10 + 94 + drawX + 4, 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            drawOnResizableMinimap(mapY, mapX, sprite);
        }
    }

}
