package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class57 {
    public static Cache aClass9_1331 = new Cache(64);
    public static LinkedList aLinkedList_1332 = new LinkedList();
    public static int[][] wayPoints = new int[104][104];
    public static int clickX = 0;
    public static RSString aClass1_1339 = RSString.CreateString("This world is full)3");
    public static int anInt1342 = 0;
    public static RSString aClass1_1343 = RSString.CreateString("flash3:");
    public static Class64 aClass64_1345;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1346;
    public static int[] anIntArray1347;
    public static RSString aClass1_1348 = RSString.CreateString("0(U");

    public static void method974() {
        aLinkedList_1332 = null;
        aClass1_1348 = null;
        aClass40_Sub5_Sub14_Sub2_1346 = null;
        wayPoints = null;
        aClass9_1331 = null;
        aClass64_1345 = null;
        aClass1_1339 = null;
        aClass1_1343 = null;
        anIntArray1347 = null;
        Player.trackedPlayerIndices = null;
        English.toCreateANewAccountYouNeedTo = null;
    }

    public static void method975(int songTimeout, int songId) {
        if(RSCanvas.anInt60 != 0 && songId != -1) {
            Class33.method414(false, 1, songId, RSCanvas.anInt60, 0, VertexNormal.aClass6_Sub1_1104);
            Class35.songTimeout = songTimeout;
        }
    }
}
