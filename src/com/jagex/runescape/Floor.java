package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;

public class Floor extends SubNode {
    public static RSString aClass1_2314;
    public static RSString aClass1_2315;
    public static int anInt2316;
    public static int anInt2317;
    public static int anInt2318;
    public static int anInt2319 = 0;
    public static int anInt2321;
    public static byte[][][] tile_flags;
    public static int[] anIntArray2324;
    public static RSString aClass1_2325;
    public static int anInt2326;
    public static RSString aClass1_2327;
    public static int anInt2328;
    public static int anInt2329;
    public static int anInt2331;
    public static int[][][] anIntArrayArrayArray2333;
    public static byte[][][] aByteArrayArrayArray2335;
    public static int anInt2339;
    public static int anInt2340;
    public static int anInt2341;
    public static int anInt2342;
    public static int anInt2343;
    public static volatile long aLong2344;
    public static int anInt2347;
    public static int anInt2348;

    static {
        aClass1_2315 = (Class58.method978("Zu viele Anmelde)2Versuche von Ihrer Adresse"));
        aClass1_2314 = Class58.method978("Malformed login packet)3");
        aClass1_2327 = Class58.method978("-5berpr-Ufen Sie Ihr Mitteilungsfach)3");
        anInt2321 = 0;
        aClass1_2325 = aClass1_2314;
        tile_flags = new byte[4][104][104];
        anInt2328 = -1;
        anIntArrayArrayArray2333 = new int[4][13][13];
        aLong2344 = 0L;
    }

    public int anInt2320;
    public int anInt2322;
    public int anInt2330;
    public int anInt2332;
    public int anInt2334;
    public int anInt2336;
    public int anInt2337;
    public boolean aBoolean2338 = true;
    public int anInt2345;
    public int anInt2346;

    public Floor() {
        anInt2322 = -1;
        anInt2336 = -1;
        anInt2345 = 0;
    }

    public static void method554(byte arg0) {

        aByteArrayArrayArray2335 = null;
        tile_flags = null;
        anIntArrayArrayArray2333 = null;
        aClass1_2315 = null;
        aClass1_2314 = null;
        aClass1_2327 = null;
        aClass1_2325 = null;
        anIntArray2324 = null;
        int i = -25 % ((arg0 - 68) / 49);

    }

    public static void method557(int arg0, int arg1) {

        Class42.method886(0, 0, false, null, arg0);
        if(arg1 != 17098)
            method557(-14, 72);
        anInt2329++;

    }

    public static void method558(int arg0, RSString arg1, int arg2, int arg3, int arg4, int arg5, RSString arg6) {

        if((NpcDefinition.anInt2394 ^ 0xffffffff) > arg3) {
            if((arg6.method59(-3136) ^ 0xffffffff) >= -1)
                Landscape.aClass1Array1184[NpcDefinition.anInt2394] = arg1;
            else
                Landscape.aClass1Array1184[NpcDefinition.anInt2394] = Class40_Sub5_Sub17_Sub6.method832(-77, (new RSString[]{arg1, (VertexNormal.aClass1_1117), arg6}));
            Class38.anIntArray884[NpcDefinition.anInt2394] = arg5;
            Class33.anIntArray791[NpcDefinition.anInt2394] = arg0;
            Class19.anIntArray483[NpcDefinition.anInt2394] = arg4;
            Class59.anIntArray1393[NpcDefinition.anInt2394] = arg2;
            NpcDefinition.anInt2394++;
        }
        anInt2339++;

    }

    public static void method559(int arg0, int arg1) {

        int i = -26 % (-arg1 / 44);
        anInt2316++;
        if(arg0 != Class51.anInt1197) {
            if((Class51.anInt1197 ^ 0xffffffff) == -1)
                CollisionMap.method144(12433);
            if(arg0 == 20 || arg0 == 40) {
                Main.anInt1756 = 0;
                anInt2321 = 0;
                Class40_Sub3.anInt2032 = 0;
            }
            if((arg0 ^ 0xffffffff) != -21 && (arg0 ^ 0xffffffff) != -41 && Class30.aClass64_717 != null) {
                Class30.aClass64_717.method1009(-106);
                Class30.aClass64_717 = null;
            }
            if(Class51.anInt1197 == 25 || Class51.anInt1197 == 40) {
                Class65.method1018((byte) 123);
                Rasterizer.method663();
            }
            if(Class51.anInt1197 == 25) {
                Class37.anInt874 = 0;
                PacketBuffer.anInt2231 = 1;
                Class40_Sub5_Sub10.anInt2591 = 0;
                GameObject.anInt3048 = 1;
                Class68.anInt1634 = 0;
            }
            if((arg0 ^ 0xffffffff) == -1 || arg0 == 35) {
                FloorDecoration.method344(-40);
                Class38.method440((byte) -73);
                if(Class68_Sub1.aClass68_2213 == null)
                    Class68_Sub1.aClass68_2213 = Class40_Sub5_Sub13.method649(503, 765, Class62.aCanvas1469, -4875);
            }
            if((arg0 ^ 0xffffffff) == -6 || arg0 == 10 || arg0 == 20) {
                Class68_Sub1.aClass68_2213 = null;
                FloorDecoration.method344(-69);
                Class40_Sub5_Sub17_Sub3.method779(Class62.aCanvas1469, true, (RSCanvas.aClass6_Sub1_48), (NpcDefinition.aClass6_Sub1_2377));
            }
            if(arg0 == 25 || arg0 == 30 || (arg0 ^ 0xffffffff) == -41) {
                Class68_Sub1.aClass68_2213 = null;
                Class38.method440((byte) -98);
                Class40_Sub5_Sub17_Sub1.method763(Class62.aCanvas1469, (byte) -128, (NpcDefinition.aClass6_Sub1_2377));
            }
            Class51.anInt1197 = arg0;
            Class40_Sub5_Sub11.aBoolean2631 = true;
        }

    }

    public static void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {

        int len = mapX * mapX + (mapY * mapY);
        if(len > 4225 && len < 90000) {
            int theta = 0x7ff & Class58.cameraHorizontal + Class43.cameraYawOffset;
            int sine = Model.SINE[theta];
            int cosine = Model.COSINE[theta];
            sine = (sine * 256) / (Class51.mapZoomOffset + 256);
            cosine = (cosine * 256) / (Class51.mapZoomOffset + 256);
            int y = cosine * mapY - sine * mapX >> 16;
            int x = mapX * cosine + mapY * sine >> 16;
            double angle = Math.atan2((double) x, (double) y);
            int drawX = (int) (Math.sin(angle) * 63.0);
            int drawY = (int) (57.0 * Math.cos(angle));
            Class40_Sub5_Sub2.minimapEdge.drawRotated(-10 + (94 + (drawX + 4)), 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            SceneTile.drawOnMinimap(mapY, mapX, sprite);
        }

    }

    public void method553(byte arg0, int arg1, Buffer arg2) {

        for(; ; ) {
            int i = arg2.getUnsignedByte();
            if((i ^ 0xffffffff) == -1)
                break;
            method556(arg1, arg2, i, (byte) -117);
        }
        if(arg0 < 1)
            aClass1_2325 = null;
        anInt2348++;

    }

    public void method555(byte arg0) {
        if((anInt2336 ^ 0xffffffff) != 0) {
            method561(anInt2336, 121);
            anInt2330 = anInt2320;
            anInt2346 = anInt2337;
            anInt2334 = anInt2332;
        }
        method561(anInt2345, 126);
        anInt2317++;
        if(arg0 != 64)
            method559(39, 9);
    }

    public void method556(int arg0, Buffer arg1, int arg2, byte arg3) {

        if(arg3 != -117)
            method556(-71, null, 83, (byte) -117);
        anInt2341++;
        if((arg2 ^ 0xffffffff) == -2)
            anInt2345 = arg1.getTri(true);
        else if(arg2 != 2) {
            if((arg2 ^ 0xffffffff) != -6) {
                if((arg2 ^ 0xffffffff) == -8)
                    anInt2336 = arg1.getTri(true);
            } else
                aBoolean2338 = false;
        } else
            anInt2322 = arg1.getUnsignedByte();

    }

    public void method561(int arg0, int arg1) {
        anInt2343++;
        int i = 71 % ((64 - arg1) / 53);
        double d = (double) (0xff & arg0 >> 58914928) / 256.0;
        double d_8_ = (double) ((0xff2d & arg0) >> -42632536) / 256.0;
        double d_9_ = (double) (0xff & arg0) / 256.0;
        double d_10_ = d;
        if(d_8_ < d_10_)
            d_10_ = d_8_;
        if(d_10_ > d_9_)
            d_10_ = d_9_;
        double d_11_ = d;
        if(d_8_ > d_11_)
            d_11_ = d_8_;
        double d_12_ = 0.0;
        double d_13_ = 0.0;
        if(d_9_ > d_11_)
            d_11_ = d_9_;
        double d_14_ = (d_11_ + d_10_) / 2.0;
        if(d_10_ != d_11_) {
            if(d_14_ < 0.5)
                d_13_ = (d_11_ - d_10_) / (d_11_ + d_10_);
            if(d_14_ >= 0.5)
                d_13_ = (-d_10_ + d_11_) / (-d_10_ + (2.0 - d_11_));
            if(d_11_ != d) {
                if(d_8_ == d_11_)
                    d_12_ = 2.0 + (d_9_ - d) / (d_11_ - d_10_);
                else if(d_11_ == d_9_)
                    d_12_ = (-d_8_ + d) / (-d_10_ + d_11_) + 4.0;
            } else
                d_12_ = (d_8_ - d_9_) / (d_11_ - d_10_);
        }
        d_12_ /= 6.0;
        anInt2332 = (int) (d_12_ * 256.0);
        anInt2320 = (int) (256.0 * d_14_);
        anInt2337 = (int) (d_13_ * 256.0);
        if((anInt2337 ^ 0xffffffff) > -1)
            anInt2337 = 0;
        else if((anInt2337 ^ 0xffffffff) < -256)
            anInt2337 = 255;
        if((anInt2320 ^ 0xffffffff) > -1)
            anInt2320 = 0;
        else if(anInt2320 > 255)
            anInt2320 = 255;
    }
}
