package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;

import java.awt.*;

public class Class40_Sub5_Sub17_Sub3 extends Renderable {
    public static RSString aClass1_3049 = RSString.CreateString("Could not complete login)3");
    public static RSString aClass1_3050;
    public static int[] anIntArray3051 = new int[25];
    public static int anInt3052;
    public static int anInt3053;
    public static RSString aClass1_3054;
    public static RSString aClass1_3055 = (RSString.CreateString("Ung-Ultige Verbindung mit einem Anmelde)2Server)3"));
    public static boolean[] obfuscatedKeyStatus = new boolean[112];
    public static int anInt3057;
    public static RSString aClass1_3059;
    public static int friendsCount;
    public static int anInt3061;
    public static RSString aClass1_3062;
    public static int anInt3063;
    public static int anInt3064;
    public static int anInt3065;
    public static RSString aClass1_3066;
    public static RSString aClass1_3068;
    public static RSString aClass1_3069;
    public static int anInt3070;
    public static RSString aClass1_3071;

    static {
        aClass1_3054 = RSString.CreateString("Members object");
        aClass1_3059 = RSString.CreateString("Too many connections from your address)3");
        friendsCount = 0;
        aClass1_3050 = aClass1_3059;
        anInt3065 = -1;
        aClass1_3062 = RSString.CreateString("Lade Eingabe)2Steuerungsprogramm)3)3)3");
        aClass1_3068 = RSString.CreateString(" )2> @whi@");
        aClass1_3066 = aClass1_3049;
        aClass1_3069 = aClass1_3054;
        aClass1_3071 = RSString.CreateString("Wen m-Ochten Sie hinzuf-Ugen?");
    }

    public int anInt3058;
    public int anInt3067;

    public static void method775(boolean arg0) {

        anInt3064++;
        int i = ((Player.localPlayer.anInt3089) + Class48.anInt1126);
        if(arg0)
            method778(true, null);
        int i_0_ = (Buffer.anInt1976 + (Player.localPlayer.anInt3098));
        if(Class40_Sub5_Sub6.anInt2437 - i_0_ < -500 || -i_0_ + Class40_Sub5_Sub6.anInt2437 > 500 || Class34.anInt849 + -i < -500 || -i + Class34.anInt849 > 500) {
            Class34.anInt849 = i;
            Class40_Sub5_Sub6.anInt2437 = i_0_;
        }
        if(Class40_Sub5_Sub6.anInt2437 != i_0_)
            Class40_Sub5_Sub6.anInt2437 += (-Class40_Sub5_Sub6.anInt2437 + i_0_) / 16;
        if(Class34.anInt849 != i)
            Class34.anInt849 += (-Class34.anInt849 + i) / 16;
        if(obfuscatedKeyStatus[96])
            Wall.cameraVelocityHorizontal += (-24 - Wall.cameraVelocityHorizontal) / 2;
        else if(obfuscatedKeyStatus[97])
            Wall.cameraVelocityHorizontal += (24 - Wall.cameraVelocityHorizontal) / 2;
        else
            Wall.cameraVelocityHorizontal /= 2;
        if(obfuscatedKeyStatus[98])
            Class60.cameraVelocityVertical += (12 + -Class60.cameraVelocityVertical) / 2;
        else if(obfuscatedKeyStatus[99])
            Class60.cameraVelocityVertical += (-12 - Class60.cameraVelocityVertical) / 2;
        else
            Class60.cameraVelocityVertical /= 2;
        int i_1_ = Class34.anInt849 >> 7;
        GroundItemTile.cameraHorizontal = Wall.cameraVelocityHorizontal / 2 + GroundItemTile.cameraHorizontal & 0x7ff;
        int i_2_ = Class40_Sub5_Sub6.anInt2437 >> 7;
        Class65.anInt1537 += Class60.cameraVelocityVertical / 2;
        int i_3_ = 0;
        if(Class65.anInt1537 < 128)
            Class65.anInt1537 = 128;
        if(Class65.anInt1537 > 383)
            Class65.anInt1537 = 383;
        int i_4_ = Class37.method430((byte) -124, Player.anInt3267, Class40_Sub5_Sub6.anInt2437, Class34.anInt849);
        if(i_2_ > 3 && i_1_ > 3 && i_2_ < 100 && i_1_ < 100) {
            for(int i_5_ = -4 + i_2_; (i_5_ <= 4 + i_2_); i_5_++) {
                for(int i_6_ = -4 + i_1_; 4 + i_1_ >= i_6_; i_6_++) {
                    int i_7_ = Player.anInt3267;
                    if(i_7_ < 3 && (0x2 & (OverlayDefinition.tile_flags[1][i_5_][i_6_])) == 2)
                        i_7_++;
                    int i_8_ = i_4_ + -(Class40_Sub6.tile_height[i_7_][i_5_][i_6_]);
                    if((i_8_ > i_3_))
                        i_3_ = i_8_;
                }
            }
        }
        int i_9_ = i_3_ * 192;
        if(i_9_ > 98048)
            i_9_ = 98048;
        if(i_9_ < 32768)
            i_9_ = 32768;
        if((Class40_Sub6.anInt2107 >= i_9_)) {
            if(Class40_Sub6.anInt2107 > i_9_)
                Class40_Sub6.anInt2107 += (-Class40_Sub6.anInt2107 + i_9_) / 80;
        } else
            Class40_Sub6.anInt2107 += (-Class40_Sub6.anInt2107 + i_9_) / 24;

    }

    public static void method776(byte arg0) {
        anInt3053++;
        if(arg0 > -79)
            method779(null, false, null, null);
        if(Class27.anInt658 == 0) {
            if(GameFrame.clickType == 1) {
                int i = -575 + Class57.anInt1338;
                int i_10_ = -5 + (RSString.anInt1668 - 4);
                if(i >= 0 && i_10_ >= 0 && i < 146 && i_10_ < 151) {
                    i_10_ -= 75;
                    i -= 73;
                    int i_11_ = 0x7ff & Class43.cameraYawOffset + GroundItemTile.cameraHorizontal;
                    int i_12_ = Rasterizer3D.sinetable[i_11_];
                    int i_13_ = Rasterizer3D.cosinetable[i_11_];
                    i_13_ = (Class51.mapZoomOffset + 256) * i_13_ >> 8;
                    i_12_ = (Class51.mapZoomOffset + 256) * i_12_ >> 8;
                    int i_14_ = i_10_ * i_12_ + (i * i_13_) >> 11;
                    int i_15_ = i_13_ * i_10_ - i * i_12_ >> 11;
                    int i_16_ = ((Player.localPlayer.anInt3098) + i_14_ >> 7);
                    int i_17_ = (-i_15_ + (Player.localPlayer.anInt3089) >> 7);
                    boolean bool = (Class38_Sub1.method448(0, 0, (Player.localPlayer.pathY[0]), i_16_, (byte) 125, 0, true, 0, 0, (Player.localPlayer.pathX[0]), i_17_, 1));
                    if(bool) {
                        Class32.packetBuffer.putByte(i);
                        Class32.packetBuffer.putByte(i_10_);
                        Class32.packetBuffer.putShortBE(GroundItemTile.cameraHorizontal);
                        Class32.packetBuffer.putByte(57);
                        Class32.packetBuffer.putByte(Class43.cameraYawOffset);
                        Class32.packetBuffer.putByte(Class51.mapZoomOffset);
                        Class32.packetBuffer.putByte(89);
                        Class32.packetBuffer.putShortBE((Player.localPlayer.anInt3098));
                        Class32.packetBuffer.putShortBE((Player.localPlayer.anInt3089));
                        Class32.packetBuffer.putByte(Class40_Sub5_Sub15.anInt2778);
                        Class32.packetBuffer.putByte(63);
                    }
                }
            }
        }
    }

    public static RSString method777(int arg0, int arg1) {

        anInt3070++;
        RSString class1 = new RSString();
        class1.chars = new byte[arg1];
        if(arg0 != -18596)
            anInt3065 = 36;
        class1.length = 0;
        return class1;

    }

    public static void method778(boolean arg0, HuffmanEncoding arg1) {
        IdentityKit.aHuffmanEncoding_2590 = arg1;
        anInt3063++;
        if(!arg0)
            method775(true);
    }

    public static void method779(Component arg0, boolean arg1, CacheIndex arg2, CacheIndex arg3) {

        anInt3057++;
        if(!ISAAC.aBoolean512) {
            Class8.aClass68_298 = Class40_Sub5_Sub13.method649(265, 128, arg0, -4875);
            Rasterizer.resetPixels();
            GameObject.aClass68_3042 = Class40_Sub5_Sub13.method649(265, 128, arg0, -4875);
            Rasterizer.resetPixels();
            Class39.aClass68_907 = Class40_Sub5_Sub13.method649(171, 509, arg0, -4875);
            Rasterizer.resetPixels();
            Class51.aClass68_1206 = Class40_Sub5_Sub13.method649(132, 360, arg0, -4875);
            Rasterizer.resetPixels();
            Class38.aClass68_887 = Class40_Sub5_Sub13.method649(200, 360, arg0, -4875);
            Rasterizer.resetPixels();
            Class17.aClass68_463 = Class40_Sub5_Sub13.method649(238, 202, arg0, -4875);
            Rasterizer.resetPixels();
            KeyFocusListener.aClass68_1285 = Class40_Sub5_Sub13.method649(238, 203, arg0, -4875);
            Rasterizer.resetPixels();
            GameObjectDefinition.aClass68_2524 = Class40_Sub5_Sub13.method649(94, 74, arg0, -4875);
            Rasterizer.resetPixels();
            Class68.aClass68_1631 = Class40_Sub5_Sub13.method649(94, 75, arg0, -4875);
            Rasterizer.resetPixels();
            byte[] is = arg2.method170(Class22_Sub2.string_blank, Class32.aClass1_772, 1);
            ImageRGB class40_sub5_sub14_sub4 = new ImageRGB(is, arg0);
            Class8.aClass68_298.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(0, 0);
            GameObject.aClass68_3042.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-637, 0);
            Class39.aClass68_907.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-128, 0);
            Class51.aClass68_1206.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-202, -371);
            Class38.aClass68_887.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-202, -171);
            Class17.aClass68_463.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(0, -265);
            KeyFocusListener.aClass68_1285.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-562, -265);
            GameObjectDefinition.aClass68_2524.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-128, -171);
            Class68.aClass68_1631.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-562, -171);
            int[] is_18_ = new int[class40_sub5_sub14_sub4.image_width];
            for(int i = 0; i < class40_sub5_sub14_sub4.image_height; i++) {
                for(int i_19_ = 0; ((i_19_ < class40_sub5_sub14_sub4.image_width)); i_19_++)
                    is_18_[i_19_] = (class40_sub5_sub14_sub4.pixels[(i * class40_sub5_sub14_sub4.image_width + class40_sub5_sub14_sub4.image_width + -i_19_ - 1)]);
                for(int i_20_ = 0; ((i_20_ < class40_sub5_sub14_sub4.image_width)); i_20_++)
                    class40_sub5_sub14_sub4.pixels[i_20_ + class40_sub5_sub14_sub4.image_width * i] = is_18_[i_20_];
            }
            Class8.aClass68_298.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(382, 0);
            GameObject.aClass68_3042.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-255, 0);
            Class39.aClass68_907.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(254, 0);
            Class51.aClass68_1206.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(180, -371);
            Class38.aClass68_887.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(180, -171);
            Class17.aClass68_463.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(382, -265);
            KeyFocusListener.aClass68_1285.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-180, -265);
            GameObjectDefinition.aClass68_2524.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(254, -171);
            Class68.aClass68_1631.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-180, -171);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg3, Main.aClass1_1762, (byte) 21, Class22_Sub2.string_blank);
            Class39.aClass68_907.method1046((byte) 90);
            class40_sub5_sub14_sub4.drawImage(-128 + (382 + -(class40_sub5_sub14_sub4.image_width / 2)), 18);
            Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2_2775 = Class27.method359(AnimationSequence.aClass1_2488, Class22_Sub2.string_blank, arg3, (byte) -64);
            Class59.aClass40_Sub5_Sub14_Sub2_1387 = Class27.method359(ISAAC.aClass1_506, Class22_Sub2.string_blank, arg3, (byte) -64);
            Class22.aClass40_Sub5_Sub14_Sub2Array535 = SpotAnimDefinition.method550(arg3, (byte) -114, Class8.aClass1_299, Class22_Sub2.string_blank);
            Class39.aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for(int i = 0; i < 33920; i++)
                Class39.aClass40_Sub5_Sub14_Sub4_918.pixels[i] = Class8.aClass68_298.anIntArray1621[i];
            for(int i = 0; i < 33920; i++)
                SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = (GameObject.aClass68_3042.anIntArray1621[i]);
            Class51.anIntArray1198 = new int[256];
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[i] = i * 262144;
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[64 + i] = 1024 * i + 16711680;
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[128 + i] = 16776960 + (i * 4);
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[i + 192] = 16777215;
            Renderable.anIntArray2865 = new int[256];
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i] = i * 1024;
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 64] = 4 * i + 65280;
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[128 + i] = i * 262144 + 65535;
            if(!arg1)
                method779(null, false, null, null);
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 192] = 16777215;
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = new int[256];
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[i] = i * 4;
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[64 + i] = 255 + (i * 262144);
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[128 + i] = i * 1024 + 16711935;
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[192 + i] = 16777215;
            Class42.anIntArray1013 = new int[256];
            Class61.anIntArray1445 = new int[32768];
            Landscape.anIntArray1168 = new int[32768];
            Class40_Sub13.method879(-4487, null);
            Class40_Sub5_Sub17_Sub6.anIntArray3255 = new int[32768];
            Class22_Sub2.password = Class22_Sub2.string_blank;
            Class22_Sub2.username = Class22_Sub2.string_blank;
            Class4.anIntArray178 = new int[32768];
            Class26.anInt622 = 0;
            if(RSCanvas.anInt60 != 0 && !VertexNormal.lowMemory)
                Class33.method412(false, Class55.aClass6_Sub1_1286, 0, (byte) 66, Class30.aClass1_716, 10, Class22_Sub2.string_blank, RSCanvas.anInt60);
            else
                Class33.method405(16969, 10);
            RSApplet.method19(false, 24041);
            Class40_Sub5_Sub11.clearScreen = true;
            ISAAC.aBoolean512 = true;
        }

    }

    public static void method780(int arg0) {

        if(arg0 != 24399)
            method779(null, false, null, null);
        obfuscatedKeyStatus = null;
        aClass1_3054 = null;
        aClass1_3050 = null;
        aClass1_3059 = null;
        aClass1_3069 = null;
        aClass1_3062 = null;
        aClass1_3066 = null;
        aClass1_3068 = null;
        anIntArray3051 = null;
        aClass1_3055 = null;
        aClass1_3049 = null;
        aClass1_3071 = null;

    }

    public Model getRotatedModel(int arg0) {

        anInt3052++;
        int i = 58 % ((41 - arg0) / 47);
        return ItemDefinition.forId(anInt3067, 10).asGroundStack(true, anInt3058);

    }
}
