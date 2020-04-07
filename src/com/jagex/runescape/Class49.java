package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.scene.SceneCluster;

public class Class49 {
    public static Cache aClass9_1145 = new Cache(30);
    public static volatile int anInt1147 = 0;
    public static RSString aClass1_1148;
    public static CacheIndex aCacheIndex_1150;
    public static int anInt1151 = 0;
    public static Class40_Sub9_Sub1 aClass40_Sub9_Sub1_1152;
    public static int anInt1154;
    public static RSString aClass1_1156 = RSString.CreateString("Loading ignore list");

    static {
        aClass1_1148 = aClass1_1156;
    }

    public static void setCameraPosition(int pitch, int x, int z, int yaw, int y, int ___pitch, int arg6) {
        int xOffset = 0;
        int yawDifference = 0x7ff & -yaw + 2048;
        int zOffset = 0;
        int pitchDifference = 2048 - pitch & 0x7ff;
        int yOffset = MouseHandler.cameraZoom + pitch * 3;
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
        SceneCluster.cameraZ = -zOffset + z;
        Class12.cameraX = -xOffset + x;
        Class26.anInt627 = pitch;
        Class40_Sub5_Sub6.cameraY = y + -yOffset;
    }

    public static void method930() {
        aClass9_1145 = null;
        aClass40_Sub9_Sub1_1152 = null;
        aClass1_1148 = null;
        aClass1_1156 = null;
        aCacheIndex_1150 = null;
    }
}
