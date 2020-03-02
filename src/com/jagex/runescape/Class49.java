package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.media.renderable.Model;

public class Class49 {
    public static int anInt1142;
    public static RSString aClass1_1143;
    public static Cache aClass9_1145;
    public static RSString aClass1_1146 = RSString.CreateString("An");
    public static volatile int anInt1147 = 0;
    public static RSString aClass1_1148;
    public static RSString aClass1_1149;
    public static CacheIndex aCacheIndex_1150;
    public static int anInt1151;
    public static Class40_Sub9_Sub1 aClass40_Sub9_Sub1_1152;
    public static RSString aClass1_1153;
    public static int anInt1154;
    public static RSString aClass1_1155;
    public static RSString aClass1_1156;

    static {
        aClass1_1143 = (RSString.CreateString("sind fehlgeschlagen)3 Bitte warten Sie 5 Minuten)1"));
        aClass9_1145 = new Cache(30);
        aClass1_1149 = RSString.CreateString("Empf-=nger:");
        anInt1151 = 0;
        aClass1_1153 = RSString.CreateString("Bitte warten Sie)3)3)3");
        aClass1_1155 = (RSString.CreateString("Wir vermuten)1 dass jemand Ihr Passwort kennt)3"));
        aClass1_1156 = RSString.CreateString("Loading ignore list");
        aClass1_1148 = aClass1_1156;
    }

    public static void setCameraPosition(int pitch, int x, int z, int yaw, int y, int ___pitch, int arg6) {
        int xOffset = 0;
        int yawDifference = 0x7ff & -yaw + 2048;
        int zOffset = 0;
        int pitchDifference = 2048 - pitch & 0x7ff;
        int yOffset = GameFrame.cameraZoom + pitch * 3;
        if(pitchDifference != 0) {
            int cosine = Model.COSINE[pitchDifference];
            int sine = Model.SINE[pitchDifference];
            int temp = zOffset * cosine + -(sine * yOffset) >> 16;
            yOffset = cosine * yOffset + sine * zOffset >> 16;
            zOffset = temp;
        }
        if(yawDifference != 0) {
            int cosine = Model.COSINE[yawDifference];
            int sine = Model.SINE[yawDifference];
            int temp = cosine * xOffset + yOffset * sine >> 16;
            yOffset = -(xOffset * sine) + yOffset * cosine >> 16;
            xOffset = temp;
        }
        Class68_Sub1.anInt2210 = yaw;
        Class32.cameraZ = -zOffset + z;
        Class12.cameraX = -xOffset + x;
        Class26.anInt627 = pitch;
        Class40_Sub5_Sub6.cameraY = y + -yOffset;
    }

    public static void method930(int arg0) {

        aClass1_1153 = null;
        aClass9_1145 = null;
        aClass40_Sub9_Sub1_1152 = null;
        aClass1_1155 = null;
        aClass1_1149 = null;
        if(arg0 > 11) {
            aClass1_1148 = null;
            aClass1_1146 = null;
            aClass1_1143 = null;
            aClass1_1156 = null;
            aCacheIndex_1150 = null;
        }

    }
}
