package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;

public class OverlayDefinition extends CachedNode {
    public static int placementY;
    public static int crossIndex = 0;
    public static int anInt2321 = 0;
    public static byte[][][] tile_flags = new byte[4][104][104];
    public static int anInt2328 = -1;
    public static int[][][] constructMapTiles = new int[4][13][13];
    public static byte[][][] tile_underlay_path;
    public static int anInt2340;
    public static int anInt2342;
    public static volatile long lastClick = 0L;

    public int saturation;
    public int anInt2322;
    public int anInt2330;
    public int hue;
    public int anInt2334;
    public int anInt2336;
    public int lightness;
    public boolean aBoolean2338 = true;
    public int anInt2345;
    public int anInt2346;

    public OverlayDefinition() {
        anInt2322 = -1;
        anInt2336 = -1;
        anInt2345 = 0;
    }

    public static void method557(int arg0) {
        Class42.method886(0, 0, false, null, arg0);
    }

    public static void addActionRow(String string, int menuAction, int firstMenuOperand, int secondMenuOperand, int actionType, String arg6) {
        if (ActorDefinition.menuActionRow < 500) {
            if (arg6.length() <= 0)
                Landscape.menuActionTexts[ActorDefinition.menuActionRow] = string;
            else
                Landscape.menuActionTexts[ActorDefinition.menuActionRow] = string + Native.whitespace + arg6;
            MovedStatics.menuActionTypes[ActorDefinition.menuActionRow] = actionType;
            Class33.selectedMenuActions[ActorDefinition.menuActionRow] = menuAction;
            InteractiveObject.firstMenuOperand[ActorDefinition.menuActionRow] = firstMenuOperand;
            Class59.secondMenuOperand[ActorDefinition.menuActionRow] = secondMenuOperand;
            ActorDefinition.menuActionRow++;
        }
    }

    /**
     * Updates the overlay depending on the provided actionId
     * @param actionId Can be one of these values:
     *                 5 = Render login background
     *                 10 = Render login box
     *                 20 = Render empty login box
     *                 25 = Render game overlay
     *                 30 = Render 3D game area
     *                 40 = Render connection lost, attempting to re-establish
     *                 1000 = Render client fatal error
     */
    public static void updateOverlay(int actionId) {
        if (actionId != Class51.currentAction) {
            if (Class51.currentAction == 0)
                CollisionMap.method144(12433);
            if (actionId == 20 || actionId == 40) {
                Main.anInt1756 = 0;
                anInt2321 = 0;
                Class40_Sub3.anInt2032 = 0;
            }
            if (actionId != 20 && actionId != 40 && PlayerAppearance.gameSocket != null) {
                PlayerAppearance.gameSocket.method1009();
                PlayerAppearance.gameSocket = null;
            }
            if (Class51.currentAction == 25 || Class51.currentAction == 40) {
                Class65.method1018();
                Rasterizer.resetPixels();
            }
            if (Class51.currentAction == 25) {
                Class37.anInt874 = 0;
                PacketBuffer.anInt2231 = 1;
                IdentityKit.anInt2591 = 0;
                GameObject.anInt3048 = 1;
                ProducingGraphicsBuffer.anInt1634 = 0;
            }
            if (actionId == 0 || actionId == 35) {
                FloorDecoration.method344(-40);
                MovedStatics.method440((byte) -73);
                if (ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 == null)
                    ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = Class40_Sub5_Sub13.createGraphicsBuffer(765, 503, MouseHandler.gameCanvas);
            }
            if (actionId == 5 || actionId == 10 || actionId == 20) {
                ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = null;
                FloorDecoration.method344(-69);
                Item.method779(MouseHandler.gameCanvas, true, CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
            }
            if (actionId == 25 || actionId == 30 || actionId == 40) {
                ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = null;
                MovedStatics.method440((byte) -98);
                Class40_Sub5_Sub17_Sub1.method763(MouseHandler.gameCanvas, CacheArchive.gameImageCacheArchive);
            }
            Class51.currentAction = actionId;
            MovedStatics.clearScreen = true;
        }
    }

    public static void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + mapY * mapY;
        if (len > 4225 && len < 90000) {
            int theta = 0x7ff & GroundItemTile.cameraHorizontal + Class43.cameraYawOffset;
            int sine = Model.SINE[theta];
            int cosine = Model.COSINE[theta];
            sine = sine * 256 / (Class51.mapZoomOffset + 256);
            cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
            int y = cosine * mapY - sine * mapX >> 16;
            int x = mapX * cosine + mapY * sine >> 16;
            double angle = Math.atan2(x, y);
            int drawX = (int) (Math.sin(angle) * 63.0);
            int drawY = (int) (57.0 * Math.cos(angle));
            SpotAnimDefinition.minimapEdge.drawRotated(-10 + 94 + drawX + 4, 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            SceneTile.drawOnMinimap(mapY, mapX, sprite);
        }
    }

    public void method553(Buffer arg2) {
        while (true) {
            int i = arg2.getUnsignedByte();
            if (i == 0)
                break;
            method556(arg2, i);
        }
    }

    public void method555() {
        if (anInt2336 != -1) {
            calculateHsl(anInt2336);
            anInt2330 = saturation;
            anInt2346 = lightness;
            anInt2334 = hue;
        }
        calculateHsl(anInt2345);
    }

    public void method556(Buffer arg1, int arg2) {
        if (arg2 == 1)
            anInt2345 = arg1.getMediumBE();
        else if (arg2 != 2) {
            if (arg2 != 5) {
                if (arg2 == 7)
                    anInt2336 = arg1.getMediumBE();
            } else
                aBoolean2338 = false;
        } else
            anInt2322 = arg1.getUnsignedByte();
    }

    public void calculateHsl(int color) {
        double r = (double) (0xff & color >> 16) / 256.0;
        double g = (double) ((0xff2d & color) >> 8) / 256.0;
        double b = (double) (0xff & color) / 256.0;
        double var10 = r;
        if (g < var10)
            var10 = g;
        if (var10 > b)
            var10 = b;
        double var11 = r;
        if (g > var11)
            var11 = g;
        double var12 = 0.0;
        double var16 = 0.0;
        if (b > var11)
            var11 = b;
        double var14 = (var11 + var10) / 2.0;
        if (var10 != var11) {
            if (var14 < 0.5)
                var16 = (var11 - var10) / (var11 + var10);
            if (var14 >= 0.5)
                var16 = (-var10 + var11) / (-var10 + (2.0 - var11));
            if (var11 != r) {
                if (g == var11)
                    var12 = 2.0 + (b - r) / (var11 - var10);
                else if (var11 == b)
                    var12 = (-g + r) / (-var10 + var11) + 4.0;
            } else
                var12 = (g - b) / (var11 - var10);
        }
        var12 /= 6.0;
        hue = (int) (var12 * 256.0);
        saturation = (int) (256.0 * var14);
        lightness = (int) (var16 * 256.0);
        if (lightness < 0)
            lightness = 0;
        else if (lightness > 255)
            lightness = 255;
        if (saturation < 0)
            saturation = 0;
        else if (saturation > 255)
            saturation = 255;
    }
}
