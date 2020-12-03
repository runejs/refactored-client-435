package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.SceneCluster;

public class Class49 {
    public static volatile int anInt1147 = 0;
    public static CacheArchive aCacheArchive_1150;
    public static int anInt1151 = 0;
    public static Class40_Sub9_Sub1 aClass40_Sub9_Sub1_1152;
    public static int anInt1154;

    public static void setCameraPosition(int pitch, int x, int z, int yaw, int y, int ___pitch, int arg6) {
        int xOffset = 0;
        int yawDifference = 0x7ff & -yaw + 2048;
        int zOffset = 0;
        int pitchDifference = 2048 - pitch & 0x7ff;
        int yOffset = arg6;
        if(!Player.cutsceneActive) {
            yOffset = MouseHandler.cameraZoom + pitch * 3;
        }
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
        ProducingGraphicsBuffer_Sub1.anInt2210 = yaw;
        SceneCluster.cameraZ = -zOffset + z;
        Class12.cameraX = -xOffset + x;
        Class26.anInt627 = pitch;
        Class40_Sub5_Sub6.cameraY = y + -yOffset;
    }


}
