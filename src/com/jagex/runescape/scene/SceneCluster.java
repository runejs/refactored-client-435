package com.jagex.runescape.scene;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.net.PacketBuffer;

public class SceneCluster {
    public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static int[] anIntArray761 = {1, 2, 4, 8};
    public static int anInt767;
    public static Class38 aClass38_768;
    public static int cameraZ;
    public static int anInt770 = 0;
    public static int anInt771 = 0;
    public static RSString aClass1_772 = RSString.CreateString("title)3jpg");
    public static CacheIndex_Sub1 aClass6_Sub1_773;

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

    public static void method401() {
        aClass38_768 = null;
        aClass1_772 = null;
        anIntArray761 = null;
        packetBuffer = null;
        aClass6_Sub1_773 = null;
    }
}
