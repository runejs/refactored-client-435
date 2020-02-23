package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.event.KeyEvent;

public class Class51 {
    public static int mapZoomOffset = 0;
    public static int anInt1188;
    public static int anInt1189;
    public static int anInt1190;
    public static int anInt1191;
    public static int anInt1192;
    public static int anInt1193;
    public static HashTable aClass23_1194 = new HashTable(4096);
    public static int anInt1195;
    public static RSString aClass1_1196;
    public static int anInt1197;
    public static int[] anIntArray1198;
    public static RSString aClass1_1199 = RSString.CreateString("(Y");
    public static RSString aClass1_1200;
    public static RSString aClass1_1201;
    public static int anInt1202;
    public static long aLong1203;
    public static RSString[] aClass1Array1204;
    public static int anInt1205;
    public static Class68 aClass68_1206;
    public static RSString aClass1_1207;
    public static RSString aClass1_1208;
    public static RSString aClass1_1209;
    public static RSString whiteCrown;

    static {
        anInt1197 = 0;
        anInt1205 = -1;
        aClass1_1201 = RSString.CreateString("Enter name of player to add to list");
        aClass1_1200 = aClass1_1201;
        aClass1_1207 = RSString.CreateString("Accept trade");
        aClass1_1208 = aClass1_1207;
        anInt1195 = 0;
        aClass1_1209 = RSString.CreateString("glow3:");
        whiteCrown = RSString.CreateString("@cr1@");
        aLong1203 = 0L;
        aClass1_1196 = aClass1_1209;
    }

    public static synchronized long method937(int arg0) {

        anInt1192++;
        if(arg0 != 1)
            aClass68_1206 = null;
        long l = System.currentTimeMillis();
        if(Class62.aLong1456 > l)
            Class62.aLong1467 += Class62.aLong1456 + -l;
        Class62.aLong1456 = l;
        return l + Class62.aLong1467;

    }

    public static int method938(int arg0, KeyEvent arg1) {

        anInt1188++;
        if(arg0 <= 86)
            method940(-15, null, false, null);
        int i = arg1.getKeyChar();
        if(i <= 0 || (i ^ 0xffffffff) <= -257)
            i = -1;
        return i;

    }

    public static void method939(int arg0) {

        aClass1_1207 = null;
        aClass1_1200 = null;
        aClass1_1196 = null;
        whiteCrown = null;
        aClass1_1201 = null;
        aClass1_1208 = null;
        anIntArray1198 = null;
        aClass23_1194 = null;
        aClass1Array1204 = null;
        aClass68_1206 = null;
        aClass1_1199 = null;
        int i = -41 / ((arg0 - 53) / 57);
        aClass1_1209 = null;

    }

    public static void method940(int arg0, RSString arg1, boolean arg2, RSString arg3) {

        if(Class40_Sub5_Sub11.aBoolean2631) {
            Class40_Sub5_Sub11.aBoolean2631 = false;
            ItemDefinition.method742(205);
            Class45.method908((byte) 114);
            Class55.method964(40);
            ActorDefinition.method574(4);
            Class52.method943(ItemDefinition.anInt2797, -118, Class53.aClass40_Sub5_Sub14_Sub1_1268, Class4.anInt185, Class35.publicChatMode);
            Class40_Sub2.method527(Class5.currentTabId, arg0 + 4, Class40_Sub5_Sub11.tabWidgetIds, Class29.anInt673 == -1, -1);
            Class38.aBoolean893 = true;
            Class40_Sub3.aBoolean2026 = true;
            Class6.aBoolean260 = true;
        }
        int i = 151;
        Class65.method1018((byte) -83);
        i -= 3;
        Class53.aClass40_Sub5_Sub14_Sub1_1268.method686(arg1, 257, i, arg0);
        Class53.aClass40_Sub5_Sub14_Sub1_1268.method686(arg1, 256, i + -1, 16777215);
        if(arg3 != null) {
            i += 15;
            if(arg2) {
                int i_0_ = 4 + Class53.aClass40_Sub5_Sub14_Sub1_1268.getStringWidth(arg3);
                Rasterizer.method656(257 - i_0_ / 2, -11 + i, i_0_, 11, 0);
            }
            Class53.aClass40_Sub5_Sub14_Sub1_1268.method686(arg3, 257, i, 0);
            Class53.aClass40_Sub5_Sub14_Sub1_1268.method686(arg3, 256, i - 1, 16777215);
        }
        anInt1193++;
        Player.method792(arg0 + 107);

    }

    public static void method941(byte arg0) {

        Class6.aClass9_229.method235((byte) 50);
        if(arg0 == -93)
            anInt1191++;

    }

    public static void method942(int arg0, int arg1) {
        anInt1190++;
        if((arg1 ^ 0xffffffff) == 0 && Class35.anInt1733 == 0)
            Class33.method402(false);
        else if(arg1 != -1 && arg1 != Class62.anInt1457 && (RSCanvas.anInt60 ^ 0xffffffff) != -1 && Class35.anInt1733 == 0)
            Class33.method403(RSCanvas.anInt60, true, 10, arg1, Class55.aClass6_Sub1_1286, 0, 0, false);
        Class62.anInt1457 = arg1;
        if(arg0 != 257)
            aClass1_1199 = null;
    }
}
