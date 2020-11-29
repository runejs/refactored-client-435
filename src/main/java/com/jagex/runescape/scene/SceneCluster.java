package com.jagex.runescape.scene;

import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.util.Timer;

public class SceneCluster {
    public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static int[] anIntArray761 = {1, 2, 4, 8};
    public static int anInt767;
    public static Timer aTimer_768;
    public static int cameraZ;
    public static int anInt770 = 0;
    public static int idleLogout = 0;

    public int worldDistanceFromCameraStartX;
    public int worldDistanceFromCameraEndY;
    public int tileStartY;
    public int tileEndY;
    public int worldEndX;
    public int tileDistanceEnum;
    public int worldDistanceFromCameraStartZ;
    public int worldStartY;
    public int worldDistanceFromCameraStartY;
    public int worldStartX;
    public int searchMask;
    public int tileStartX;
    public int worldEndY;
    public int worldStartZ;
    public int worldDistanceFromCameraEndZ;
    public int tileEndX;
    public int worldEndZ;
    public int worldDistanceFromCameraEndX;


}
