package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;

public class OverlayDefinition extends SubNode {
    public static RSString aClass1_2314;
    public static RSString aClass1_2315;
    public static int placementY;
    public static int anInt2319 = 0;
    public static int anInt2321;
    public static byte[][][] tile_flags;
    public static int[] anIntArray2324;
    public static RSString aClass1_2325;
    public static RSString aClass1_2327;
    public static int anInt2328;
    public static int[][][] anIntArrayArrayArray2333;
    public static byte[][][] tile_underlay_path;
    public static int anInt2340;
    public static int anInt2342;
    public static volatile long lastClick;

    static {
        aClass1_2315 = (RSString.CreateString("Zu viele Anmelde)2Versuche von Ihrer Adresse"));
        aClass1_2314 = RSString.CreateString("Malformed login packet)3");
        aClass1_2327 = RSString.CreateString("-5berpr-Ufen Sie Ihr Mitteilungsfach)3");
        anInt2321 = 0;
        aClass1_2325 = aClass1_2314;
        tile_flags = new byte[4][104][104];
        anInt2328 = -1;
        anIntArrayArrayArray2333 = new int[4][13][13];
        lastClick = 0L;
    }

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

    public static void method554() {
        tile_underlay_path = null;
        tile_flags = null;
        anIntArrayArrayArray2333 = null;
        aClass1_2315 = null;
        aClass1_2314 = null;
        aClass1_2327 = null;
        aClass1_2325 = null;
        anIntArray2324 = null;
    }

    public static void method557(int arg0, int arg1) {
        Class42.method886(0, 0, false, null, arg0);
        if(arg1 != 17098)
            method557(-14, 72);
    }

    public static void method558(int arg0, RSString arg1, int arg2, int arg3, int arg4, int arg5, RSString arg6) {
        if((ActorDefinition.anInt2394 ^ 0xffffffff) > arg3) {
            if(arg6.length() <= 0)
                Landscape.aClass1Array1184[ActorDefinition.anInt2394] = arg1;
            else
                Landscape.aClass1Array1184[ActorDefinition.anInt2394] = Class40_Sub5_Sub17_Sub6.method832((new RSString[]{arg1, (VertexNormal.aClass1_1117), arg6}));
            Class38.anIntArray884[ActorDefinition.anInt2394] = arg5;
            Class33.anIntArray791[ActorDefinition.anInt2394] = arg0;
            InteractiveObject.anIntArray483[ActorDefinition.anInt2394] = arg4;
            Class59.anIntArray1393[ActorDefinition.anInt2394] = arg2;
            ActorDefinition.anInt2394++;
        }
    }

    public static void method559(int arg0) {
        if(arg0 != Class51.anInt1197) {
            if(Class51.anInt1197 == 0)
                CollisionMap.method144(12433);
            if(arg0 == 20 || arg0 == 40) {
                Main.anInt1756 = 0;
                anInt2321 = 0;
                Class40_Sub3.anInt2032 = 0;
            }
            if(arg0 != 20 && arg0 != 40 && Class30.aClass64_717 != null) {
                Class30.aClass64_717.method1009(-106);
                Class30.aClass64_717 = null;
            }
            if(Class51.anInt1197 == 25 || Class51.anInt1197 == 40) {
                Class65.method1018((byte) 123);
                Rasterizer.resetPixels();
            }
            if(Class51.anInt1197 == 25) {
                Class37.anInt874 = 0;
                PacketBuffer.anInt2231 = 1;
                IdentityKit.anInt2591 = 0;
                GameObject.anInt3048 = 1;
                Class68.anInt1634 = 0;
            }
            if(arg0 == 0 || arg0 == 35) {
                FloorDecoration.method344(-40);
                Class38.method440((byte) -73);
                if(Class68_Sub1.aClass68_2213 == null)
                    Class68_Sub1.aClass68_2213 = Class40_Sub5_Sub13.method649(503, 765, GameFrame.aCanvas1469, -4875);
            }
            if(arg0 == 5 || arg0 == 10 || arg0 == 20) {
                Class68_Sub1.aClass68_2213 = null;
                FloorDecoration.method344(-69);
                Class40_Sub5_Sub17_Sub3.method779(GameFrame.aCanvas1469, true, (RSCanvas.aClass6_Sub1_48), (ActorDefinition.aClass6_Sub1_2377));
            }
            if(arg0 == 25 || arg0 == 30 || arg0 == 40) {
                Class68_Sub1.aClass68_2213 = null;
                Class38.method440((byte) -98);
                Class40_Sub5_Sub17_Sub1.method763(GameFrame.aCanvas1469, (byte) -128, (ActorDefinition.aClass6_Sub1_2377));
            }
            Class51.anInt1197 = arg0;
            Class40_Sub5_Sub11.clearScreen = true;
        }
    }

    public static void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + (mapY * mapY);
        if(len > 4225 && len < 90000) {
            int theta = 0x7ff & GroundItemTile.cameraHorizontal + Class43.cameraYawOffset;
            int sine = Model.SINE[theta];
            int cosine = Model.COSINE[theta];
            sine = (sine * 256) / (Class51.mapZoomOffset + 256);
            cosine = (cosine * 256) / (Class51.mapZoomOffset + 256);
            int y = cosine * mapY - sine * mapX >> 16;
            int x = mapX * cosine + mapY * sine >> 16;
            double angle = Math.atan2((double) x, (double) y);
            int drawX = (int) (Math.sin(angle) * 63.0);
            int drawY = (int) (57.0 * Math.cos(angle));
            SpotAnimDefinition.minimapEdge.drawRotated(-10 + (94 + (drawX + 4)), 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            SceneTile.drawOnMinimap(mapY, mapX, sprite);
        }
    }

    public void method553(byte arg0, Buffer arg2) {
        for(; ; ) {
            int i = arg2.getUnsignedByte();
            if(i == 0)
                break;
            method556(arg2, i, (byte) -117);
        }
        if(arg0 < 1)
            aClass1_2325 = null;
    }

    public void method555(byte arg0) {
        if(anInt2336 != -1) {
            calculateHsl(anInt2336);
            anInt2330 = saturation;
            anInt2346 = lightness;
            anInt2334 = hue;
        }
        calculateHsl(anInt2345);
        if(arg0 != 64)
            method559(39);
    }

    public void method556(Buffer arg1, int arg2, byte arg3) {
        if(arg3 != -117)
            method556(null, 83, (byte) -117);
        if(arg2 == 1)
            anInt2345 = arg1.getMediumBE();
        else if(arg2 != 2) {
            if(arg2 != 5) {
                if(arg2 == 7)
                    anInt2336 = arg1.getMediumBE();
            } else
                aBoolean2338 = false;
        } else
            anInt2322 = arg1.getUnsignedByte();
    }

    public void calculateHsl(int color) {
        double r = (double) (0xff & (color >> 16)) / 256.0;
        double g = (double) ((0xff2d & color) >> 8) / 256.0;
        double b = (double) (0xff & color) / 256.0;
        double var10 = r;
        if(g < var10)
            var10 = g;
        if(var10 > b)
            var10 = b;
        double var11 = r;
        if(g > var11)
            var11 = g;
        double var12 = 0.0;
        double var16 = 0.0;
        if(b > var11)
            var11 = b;
        double var14 = (var11 + var10) / 2.0;
        if(var10 != var11) {
            if(var14 < 0.5)
                var16 = (var11 - var10) / (var11 + var10);
            if(var14 >= 0.5)
                var16 = (-var10 + var11) / (-var10 + (2.0 - var11));
            if(var11 != r) {
                if(g == var11)
                    var12 = 2.0 + (b - r) / (var11 - var10);
                else if(var11 == b)
                    var12 = (-g + r) / (-var10 + var11) + 4.0;
            } else
                var12 = (g - b) / (var11 - var10);
        }
        var12 /= 6.0;
        hue = (int) (var12 * 256.0);
        saturation = (int) (256.0 * var14);
        lightness = (int) (var16 * 256.0);
        if(lightness < 0)
            lightness = 0;
        else if(lightness > 255)
            lightness = 255;
        if(saturation < 0)
            saturation = 0;
        else if(saturation > 255)
            saturation = 255;
    }
}
