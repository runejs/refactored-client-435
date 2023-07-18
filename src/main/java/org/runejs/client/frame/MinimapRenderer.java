package org.runejs.client.frame;

import org.runejs.client.Game;
import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.media.RasterizerInstanced;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;

/**
 * A {@link FramePieceRenderer} that renders the minimap.
 * 
 * TODO (jkm) this currently renders the "resizable" mode (square) minimap only
 */
public class MinimapRenderer extends FramePieceRenderer {
    public static int[] resizableMinimapOffsets1;
    public static int[] resizableMinimapOffsets2;
    public int[] resizableCompasOffsets1;
    public int[] resizableCompasOffsets2;
    public static int[] resizableMinimapLineOffsets;

    /**
     * To avoid flickering, we draw to a temporary rasterizer first,
     * then flush this to the output rasterizer at once, in its entirety.
     */
    private RasterizerInstanced tempRasterizer;

    public MinimapRenderer() {
        super(
            new FramePieceAnchor(
                FramePieceAnchor.Anchor.TOP | FramePieceAnchor.Anchor.RIGHT,
                0,
                0
            ),
            210,
            210
        );

        resizableMinimapOffsets1 = new int[200];
        resizableMinimapOffsets2 = new int[200];
        for(int i = 0; i < resizableMinimapOffsets2.length; i++) {
            resizableMinimapOffsets1[i] = 200;
            resizableMinimapOffsets2[i] = 0;
        }

        tempRasterizer = new RasterizerInstanced(
            MovedStatics.createGraphicsBuffer(this.width, this.height, Game.gameCanvas)
        );
    }

    public void RenderResizableMiniMapArea(int x, int y) {
        if(resizableCompasOffsets1 == null) {
            resizableCompasOffsets1 = new int[33];
            resizableCompasOffsets2 = new int[33];
            for(int y1 = 0; y1 < 33; y1++) {
                int i_15_ = 0;
                int i_16_ = 999;
                for(int x1 = 0; x1 < 34; x1++) {
                    if(Minimap.minimapBackgroundImage.imgPixels[Minimap.minimapBackgroundImage.imgWidth * y1 + x1] == 0) {
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

        // TODO handle black minimap for Minimap.minimapState == 2

        int i = 48 + Player.localPlayer.worldX / 32;
        int i_8_ = 464 + -(Player.localPlayer.worldY / 32);
        int i_9_ = Game.getMinimapRotation() & 0x7ff;
        int minimapZoom = 0;

        shapeImageToPixels(Minimap.minimapImage,5, 5, 200, 200, i, i_8_, i_9_, minimapZoom + 256, resizableMinimapOffsets2, resizableMinimapOffsets1);
        drawResizableMinimapDots();
        tempRasterizer.drawFilledRectangle(105, 105, 3, 3, 16777215);
        tempRasterizer.drawFilledRectangle(0, 0, 210, 5, 0x242017);
        tempRasterizer.drawFilledRectangle(0, 205, 210, 5, 0x242017);
        tempRasterizer.drawFilledRectangle(0, 0, 5, 210, 0x242017);
        tempRasterizer.drawFilledRectangle(205, 0, 5, 210, 0x242017);

        //        Rasterizer.drawFilledRectangle(x-43,y, 43, 43, 0x242017);
        tempRasterizer.drawFilledRectangle(0, 0, 20, 42, 0x242017);
        tempRasterizer.drawFilledRectangle(0, 0, 42, 20, 0x242017);

        tempRasterizer.drawCircle(21, 21, 20, 0x242017);
        shapeImageToPixels(Minimap.minimapCompass, 5, 5, 33, 33, 25, 25, Game.getMinimapRotation(), 256, resizableCompasOffsets2, resizableCompasOffsets1);

        System.arraycopy(tempRasterizer.destinationPixels, 0, rasterizerInstanced.destinationPixels,0, rasterizerInstanced.destinationPixels.length);
//        Class65.method1018();

        //        ScreenController.drawFramePiece(resizableMiniMapimage, x, y);

    }



    private void shapeImageToPixels(ImageRGB image, int x, int y, int width, int height, int arg4, int arg5, int k1, int zoom, int[] arg8, int[] arg9) {
        try {
            int centerX = -width / 2;
            int centerY = -height / 2;
            int sine = (int) (Math.sin((double) k1 / 326.11) * 65536.0);
            int cosine = (int) (Math.cos((double) k1 / 326.11) * 65536.0);
            sine = sine * zoom >> 8;
            cosine = cosine * zoom >> 8;
            int i_125_ = (arg4 << 16) + centerY * sine + centerX * cosine;
            int i_126_ = (arg5 << 16) + centerY * cosine - centerX * sine;
            int destinationOffset = x + y * tempRasterizer.destinationWidth;

            for(y = 0; y < height; y++) {
                int i_128_ = arg8[y];
                int i_129_ = destinationOffset + i_128_;
                int i_130_ = i_125_ + cosine * i_128_;
                int i_131_ = i_126_ - sine * i_128_;
                for(x = -arg9[y]; x < 0; x++) {
                    int pixelToGet = (i_130_ >> 16) + (i_131_ >> 16) * image.imageWidth;
                    int colour = 0;
                    if(!(image.pixels.length < pixelToGet || pixelToGet < 0)){
                        colour = image.pixels[pixelToGet];
                    }
                    tempRasterizer.destinationPixels[i_129_++] = colour;
                    i_130_ += cosine;
                    i_131_ -= sine;
                }
                i_125_ += sine;
                i_126_ += cosine;
                destinationOffset += tempRasterizer.destinationWidth;
            }
        } catch(Exception exception) {
            /* empty */
            exception.printStackTrace();
        }
    }

    private void drawResizableMinimapDots() {
        for(int i = 0; Minimap.minimapHintCount > i; i++) {
            int hintX = 2 + 4 * Minimap.minimapHintX[i] + -(Player.localPlayer.worldX / 32);
            int hintY = 2 + 4 * Minimap.minimapHintY[i] - Player.localPlayer.worldY / 32;
            drawOnResizableMinimap(hintX, hintY, Minimap.minimapHint[i]);
        }
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                LinkedList linkedList = MovedStatics.groundItems[Player.worldLevel][x][y];
                if(linkedList != null) {
                    int itemY = -(Player.localPlayer.worldY / 32) + 2 + y * 4;
                    int itemX = -(Player.localPlayer.worldX / 32) + 2 + x * 4;
                    drawOnResizableMinimap(itemX, itemY, Minimap.mapDots[0]);
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
                    drawOnResizableMinimap(npcX, npcY, Minimap.mapDots[1]);
                }
            }
        }
        for(int i = 0; Player.localPlayerCount > i; i++) {
            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            if(player != null && player.isInitialized()) {
                int playerX = player.worldX / 32 + -(Player.localPlayer.worldX / 32);
                int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                boolean isFriend = Game.friendList.containsPlayerUsername(player.playerName);
                boolean isTeammate = false;
                if(Player.localPlayer.teamId != 0 && player.teamId != 0 && player.teamId == Player.localPlayer.teamId)
                    isTeammate = true;
                if(isFriend)
                    drawOnResizableMinimap(playerX, playerY, Minimap.mapDots[3]);
                else if(isTeammate)
                    drawOnResizableMinimap(playerX, playerY, Minimap.mapDots[4]);
                else
                    drawOnResizableMinimap(playerX, playerY, Minimap.mapDots[2]);
            }
        }
        if(Player.headIconDrawType != 0 && MovedStatics.pulseCycle % 20 < 10) {
            if(Player.headIconDrawType == 1 && MovedStatics.hintIconNpcTarget >= 0 && Player.npcs.length > MovedStatics.hintIconNpcTarget) {
                Npc npc = Player.npcs[MovedStatics.hintIconNpcTarget];
                if(npc != null) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 - Player.localPlayer.worldY / 32;
                    drawMinimapMark(Minimap.minimapMarkers[1], npcX, npcY);
                }
            }
            if(Player.headIconDrawType == 2) {
                int hintY = -(Player.localPlayer.worldY / 32) + 2 + 4 * (-MovedStatics.baseY + MovedStatics.hintIconPosY);
                int hintX = 4 * (MovedStatics.hintIconPosX - MovedStatics.baseX) - (-2 + Player.localPlayer.worldX / 32);
                drawMinimapMark(Minimap.minimapMarkers[1], hintX, hintY);
            }
            if(Player.headIconDrawType == 10 && MovedStatics.hintIconPlayerTarget >= 0 && Player.trackedPlayers.length > MovedStatics.hintIconPlayerTarget) {
                Player player = Player.trackedPlayers[MovedStatics.hintIconPlayerTarget];
                if(player != null) {
                    int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                    int playerX = player.worldX / 32 - Player.localPlayer.worldX / 32;
                    drawMinimapMark(Minimap.minimapMarkers[1], playerX, playerY);
                }
            }
        }
        if(MovedStatics.destinationX != 0) {
            int flagX = 2 + MovedStatics.destinationX * 4 + -(Player.localPlayer.worldX / 32);
            int flagY = 2 + 4 * Game.destinationY + -(Player.localPlayer.worldY / 32);
            drawOnResizableMinimap(flagX, flagY, Minimap.minimapMarkers[0]);
        }
    }

    public void drawOnResizableMinimap(int x, int y, ImageRGB sprite) {
        if(sprite == null) {
            return;
        }
        int angle = 0x7ff & Game.getMinimapRotation();
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
        tempRasterizer.drawImage(sprite, 106 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + -i_4_ + 106);
    }

    public void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + mapY * mapY;
        if (len > 4225 && len < 90000) {
            int theta = 0x7ff & Game.getMinimapRotation();
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

    private void drawRotated(ImageRGB image, int x, int y, int pivotX, int pivotY, int width, int height, int zoom, double angle) {
        try {
            int centerX = -width / 2;
            int centerY = -height / 2;
            int sine = (int) (Math.sin(angle) * 65536.0);
            int cosine = (int) (Math.cos(angle) * 65536.0);
            sine = sine * zoom >> 8;
            cosine = cosine * zoom >> 8;
            int sourceOffsetX = (pivotX << 16) + centerY * sine + centerX * cosine;
            int sourceoffsetY = (pivotY << 16) + centerY * cosine - centerX * sine;
            int destinationOffset = x + y * tempRasterizer.destinationWidth;
            for(y = 0; y < height; y++) {
                int i = destinationOffset;
                int offsetX = sourceOffsetX;
                int offsetY = sourceoffsetY;
                for(x = -width; x < 0; x++) {
                    int i_166_ = image.pixels[(offsetX >> 16) + (offsetY >> 16) * image.imageWidth];
                    if(i_166_ != 0)
                        tempRasterizer.destinationPixels[i++] = i_166_;
                    else
                        i++;
                    offsetX += cosine;
                    offsetY -= sine;
                }
                sourceOffsetX += sine;
                sourceoffsetY += cosine;
                destinationOffset += tempRasterizer.destinationWidth;
            }
        } catch(Exception exception) {
            /* empty */
            exception.printStackTrace();
        }
    }
}
