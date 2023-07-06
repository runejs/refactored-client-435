package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.SceneCluster;

public class Class49 {
    public static volatile int anInt1147 = 0;
    public static CacheArchive definitionCache;
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
        ProducingGraphicsBuffer_Sub1.cameraHorizontalRotation = yaw;
        SceneCluster.cameraZ = -zOffset + z;
        Class12.cameraX = -xOffset + x;
        Class26.cameraVerticalRotation = pitch;
        MovedStatics.cameraY = y + -yOffset;
    }


}
