package org.runejs.client.frame;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.*;

import java.awt.*;

/**
 * Class to store the minimap state
 * 
 * TODO (jkm) Work is in-progress to remove all rendering capability from this class
 */
public class Minimap {
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
    /**
     * Images for function icons on the minimap (e.g. quests, instructors)
     */
	public static ImageRGB[] mapFunctionIcons;
    /**
     * Minimap tile rotations (move to Minimap class)
     */
    public static int[][] anIntArrayArray121 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
    /**
     * Minimap tile masks (move to Minimap class)
     */
    public static int[][] anIntArrayArray129 = new int[][]{new int[16], {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
    public static int minimapLevel = -1;

    public static void drawOnMinimap(int x, int y, ImageRGB sprite) {
        if (sprite == null) {
            return;
        }
        int angle = 0x7ff & Game.getMinimapRotation();
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
            minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, Game.getMinimapRotation(), 256, MovedStatics.anIntArray62, MovedStatics.anIntArray66);
            drawMapBack();
            return;
        }

        int centerX = 48 + Player.localPlayer.worldX / 32;
        int centerY = 464 + -(Player.localPlayer.worldY / 32);
        int angle = Game.getMinimapRotation() & 0x7ff;
        int minimapZoom = 0;

        minimapImage.shapeImageToPixels(25, 5, 146, 151, centerX, centerY, angle, minimapZoom + 256, MovedStatics.anIntArray1186, MovedStatics.anIntArray852);
        for(int i = 0; minimapHintCount > i; i++) {
            int hintX = 2 + 4 * minimapHintX[i] + -(Player.localPlayer.worldX / 32);
            int hintY = 2 + 4 * minimapHintY[i] - Player.localPlayer.worldY / 32;
            drawOnMinimap(hintY, hintX, minimapHint[i]);
        }
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                LinkedList linkedList = MovedStatics.groundItems[Player.worldLevel][x][y];
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
                boolean isFriend = Game.friendList.containsPlayerUsername(player.playerName);
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
            if(Player.headIconDrawType == 1 && MovedStatics.hintIconNpcTarget >= 0 && Player.npcs.length > MovedStatics.hintIconNpcTarget) {
                Npc npc = Player.npcs[MovedStatics.hintIconNpcTarget];
                if(npc != null) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 - Player.localPlayer.worldY / 32;
                    drawMinimapIcon(minimapMarkers[1], npcX, npcY);
                }
            }
            if(Player.headIconDrawType == 2) {
                int hintX = -(Player.localPlayer.worldY / 32) + 2 + 4 * (-MovedStatics.baseY + MovedStatics.hintIconPosY);
                int hintY = 4 * (MovedStatics.hintIconPosX - MovedStatics.baseX) - (-2 + Player.localPlayer.worldX / 32);
                drawMinimapIcon(minimapMarkers[1], hintY, hintX);
            }
            if(Player.headIconDrawType == 10 && MovedStatics.hintIconPlayerTarget >= 0 && Player.trackedPlayers.length > MovedStatics.hintIconPlayerTarget) {
                Player player = Player.trackedPlayers[MovedStatics.hintIconPlayerTarget];
                if(player != null) {
                    int playerX = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                    int playerY = player.worldX / 32 - Player.localPlayer.worldX / 32;
                    drawMinimapIcon(minimapMarkers[1], playerY, playerX);
                }
            }
        }
        if(MovedStatics.destinationX != 0) {
            int flagX = 2 + MovedStatics.destinationX * 4 + -(Player.localPlayer.worldX / 32);
            int flagY = 2 + 4 * Game.destinationY + -(Player.localPlayer.worldY / 32);
            drawOnMinimap(flagY, flagX, minimapMarkers[0]);
        }
        Rasterizer.drawFilledRectangle(97, 78, 3, 3, 16777215);
        minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, Game.getMinimapRotation(), 256, MovedStatics.anIntArray62, MovedStatics.anIntArray66);
        minimapBackgroundImage.drawImage(0, 0);

        if(MovedStatics.menuOpen && ScreenController.frameMode == ScreenMode.FIXED && MovedStatics.menuScreenArea == 1) {
            MovedStatics.drawMenu(550, 4);
        }
        drawMapBack();

    }

    public static void createMinimapRaster() {
        mapbackProducingGraphicsBuffer.prepareRasterizer();
    }

    private static void drawMinimapIcon(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + mapY * mapY;
        if (len > 4225 && len < 90000) {
            int theta = 0x7ff & Game.playerCamera.getYaw();
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
            MovedStatics.minimapEdge.drawRotated(-10 + 94 + drawX + 4, 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            drawOnMinimap(mapY, mapX, sprite);
        }
    }

    private static void drawObject(int plane, int tileX, int wallRGB, int doorRGB, int tileY) {
        if(true) {
            int hash = Game.currentScene.getWallHash(plane, tileX, tileY);
            if(hash != 0) {
                int info = Game.currentScene.getArrangement(plane, tileX, tileY, hash);
                int type = 0x1f & info;
                int orientation = 0x3 & info >> 6;
                int rgb = wallRGB;
                if(hash > 0)
                    rgb = doorRGB;
                int offset = 4 * (-tileY + 103) * 512 + 24624 + 4 * tileX;
                int id = hash >> 14 & 0x7fff;
                int[] dest = minimapImage.pixels;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(id);
                if(gameObjectDefinition.mapSceneID == -1) {
                    if(type == 0 || type == 2) {
                        if(orientation == 0) {
                            dest[offset] = rgb;
                            dest[512 + offset] = rgb;
                            dest[1024 + offset] = rgb;
                            dest[1536 + offset] = rgb;
                        } else if(orientation == 1) {
                            dest[offset] = rgb;
                            dest[offset + 1] = rgb;
                            dest[2 + offset] = rgb;
                            dest[offset + 3] = rgb;
                        } else if(orientation == 2) {
                            dest[3 + offset] = rgb;
                            dest[3 + offset + 512] = rgb;
                            dest[1024 + offset + 3] = rgb;
                            dest[offset + 1539] = rgb;
                        } else if(orientation == 3) {
                            dest[offset + 1536] = rgb;
                            dest[1536 + offset + 1] = rgb;
                            dest[1536 + offset + 2] = rgb;
                            dest[3 + offset + 1536] = rgb;
                        }
                    }
                    if(type == 3) {
                        if(orientation != 0) {
                            if(orientation != 1) {
                                if(orientation != 2) {
                                    if(orientation == 3)
                                        dest[offset + 1536] = rgb;
                                } else
                                    dest[3 + offset + 1536] = rgb;
                            } else
                                dest[offset + 3] = rgb;
                        } else
                            dest[offset] = rgb;
                    }
                    if(type == 2) {
                        if(orientation == 3) {
                            dest[offset] = rgb;
                            dest[512 + offset] = rgb;
                            dest[offset + 1024] = rgb;
                            dest[1536 + offset] = rgb;
                        } else if(orientation == 0) {
                            dest[offset] = rgb;
                            dest[1 + offset] = rgb;
                            dest[offset + 2] = rgb;
                            dest[3 + offset] = rgb;
                        } else if(orientation == 1) {
                            dest[offset + 3] = rgb;
                            dest[512 + 3 + offset] = rgb;
                            dest[offset + 1027] = rgb;
                            dest[1536 + 3 + offset] = rgb;
                        } else if(orientation == 2) {
                            dest[1536 + offset] = rgb;
                            dest[1537 + offset] = rgb;
                            dest[offset + 1538] = rgb;
                            dest[1536 + offset + 3] = rgb;
                        }
                    }
                } else {
                    IndexedImage iconSprite = MovedStatics.mapSceneIcons[gameObjectDefinition.mapSceneID];
                    if(iconSprite != null) {
                        int offsetX = (-iconSprite.imgWidth + gameObjectDefinition.sizeX * 4) / 2;
                        int offsetY = (gameObjectDefinition.sizeY * 4 + -iconSprite.imgHeight) / 2;
                        iconSprite.drawImage(48 + 4 * tileX + offsetX, offsetY + 48 + (104 + -tileY - gameObjectDefinition.sizeY) * 4);
                    }
                }
            }
            hash = Game.currentScene.getLocationHash(plane, tileX, tileY);
            if(hash != 0) {
                int objectInfo = Game.currentScene.getArrangement(plane, tileX, tileY, hash);
                int id = 0x7fff & hash >> 14;
                int orientation = (objectInfo & 0xf4) >> 6;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(id);
                int type = objectInfo & 0x1f;
                if(gameObjectDefinition.mapSceneID != -1) {
                    IndexedImage iconSprite = MovedStatics.mapSceneIcons[gameObjectDefinition.mapSceneID];
                    if(iconSprite != null) {
                        int offsetY = (-iconSprite.imgHeight + gameObjectDefinition.sizeY * 4) / 2;
                        int offsetX = (gameObjectDefinition.sizeX * 4 + -iconSprite.imgWidth) / 2;
                        iconSprite.drawImage(offsetX + tileX * 4 + 48, 48 - (-(4 * (-tileY + 104 + -gameObjectDefinition.sizeY)) + -offsetY));
                    }
                } else if(type == 9) {
                    int[] dest = minimapImage.pixels;
                    int color = 15658734; // wall
                    if(hash > 0)
                        color = 15597568; // door
                    int offset = (-(tileY * 512) + 52736) * 4 + tileX * 4 + 24624;
                    if(orientation == 0 || orientation == 2) {
                        dest[1536 + offset] = color;
                        dest[1024 + offset + 1] = color;
                        dest[514 + offset] = color;
                        dest[3 + offset] = color;
                    } else {
                        dest[offset] = color;
                        dest[513 + offset] = color;
                        dest[2 + offset + 1024] = color;
                        dest[1536 + offset + 3] = color;
                    }
                }
            }
            hash = Game.currentScene.getFloorDecorationHash(plane, tileX, tileY);
            if(hash != 0) {
                int id = (hash & 0x1fffd9fb) >> 14;
                GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(id);
                if(gameObjectDefinition.mapSceneID != -1) {
                    IndexedImage iconSprite = MovedStatics.mapSceneIcons[gameObjectDefinition.mapSceneID];
                    if(iconSprite != null) {
                        int i_17_ = (-iconSprite.imgWidth + gameObjectDefinition.sizeX * 4) / 2;
                        int i_18_ = (-iconSprite.imgHeight + 4 * gameObjectDefinition.sizeY) / 2;
                        iconSprite.drawImage(4 * tileX + 48 + i_17_, i_18_ + (104 - (tileY + gameObjectDefinition.sizeY)) * 4 + 48);
                    }
                }
            }
        }
    }

    public static void createMinimap(int plane) {
	    int[] pixels = minimapImage.pixels;
	    for(int i = 0; pixels.length > i; i++)
	        pixels[i] = 0;
	    for(int y = 1; y < 103; y++) {
	        int offset = 24628 + (-(512 * y) + 52736) * 4;
	        for(int x = 1; x < 103; x++) {
	            if((0x18 & MovedStatics.tile_flags[plane][x][y]) == 0)
	                Game.currentScene.drawMinimapTile(pixels, offset, 512, plane, x, y);
	            if(plane < 3 && (MovedStatics.tile_flags[1 + plane][x][y] & 0x8) != 0)
	                Game.currentScene.drawMinimapTile(pixels, offset, 512, 1 + plane, x, y);
	            offset += 4;
	        }
	    }
	    minimapImage.prepareRasterizer();

        // generate slightly random offset door and wall colors
        // door: (228, 228, 228) to (248, 248, 248)
	    int doorRGB = (-10 + (int) (Math.random() * 20.0) + 238 << 8) + (228 + (int) (Math.random() * 20.0) << 16) + 238 + (int) (20.0 * Math.random()) + -10;
	    // wall: (228, 0, 0) to (248, 0, 0)
        int wallRGB = -10 + (int) (20.0 * Math.random()) + 238 << 16;

	    for(int tileY = 1; tileY < 103; tileY++) {
	        for(int tileX = 1; tileX < 103; tileX++) {
	            if((MovedStatics.tile_flags[plane][tileX][tileY] & 0x18) == 0)
	                drawObject(plane, tileX, doorRGB, wallRGB, tileY);
	            if(plane < 3 && (0x8 & MovedStatics.tile_flags[1 + plane][tileX][tileY]) != 0)
	                drawObject(1 + plane, tileX, doorRGB, wallRGB, tileY);
	        }
	    }
	    minimapHintCount = 0;
	    for(int tileX = 0; tileX < 104; tileX++) {
	        for(int tileY = 0; tileY < 104; tileY++) {
	            int hash = Game.currentScene.getFloorDecorationHash(Player.worldLevel, tileX, tileY);
	            if(hash != 0) {
	                int objectId = 0x7fff & hash >> 14;
	                int icon = GameObjectDefinition.getDefinition(objectId).icon;
	                if(icon >= 0) {
	                    int y = tileY;
	                    int x = tileX;
	                    if(icon != 22 && icon != 29 && icon != 34 && icon != 36 && icon != 46 && icon != 47 && icon != 48) {
	                        int[][] clipping = Landscape.currentCollisionMap[Player.worldLevel].clippingData;
	                        for(int pass = 0; pass < 10; pass++) {
	                            int rand = (int) (Math.random() * 4.0);
	                            if(rand == 0 && x > 0 && x > -3 + tileX && (clipping[-1 + x][y] & 0x1280108) == 0)
	                                x--;
	                            if(rand == 1 && x < 103 && x < tileX + 3 && (clipping[x + 1][y] & 0x1280180) == 0)
	                                x++;
	                            if(rand == 2 && y > 0 && y > -3 + tileY && (clipping[x][y - 1] & 0x1280102) == 0)
	                                y--;
	                            if(rand == 3 && y < 103 && 3 + tileY > y && (0x1280120 & clipping[x][1 + y]) == 0)
	                                y++;
	                        }
	                    }
	                    minimapHint[minimapHintCount] = mapFunctionIcons[icon];
	                    minimapHintX[minimapHintCount] = x;
	                    minimapHintY[minimapHintCount] = y;
	                    minimapHintCount++;
	                }
	            }
	        }
	    }
	}

    public static void drawMapBack() {
        try {
            if(ScreenController.frameMode == ScreenMode.FIXED) {
                Graphics graphics = Game.gameCanvas.getGraphics();
                mapbackProducingGraphicsBuffer.drawGraphics(550, 4, graphics);
            }
        } catch(Exception exception) {
            Game.gameCanvas.repaint();
        }
    }
}
