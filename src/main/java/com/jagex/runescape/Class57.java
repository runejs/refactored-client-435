package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.node.NodeCache;

public class Class57 {
    public static NodeCache aClass9_1331 = new NodeCache(64);
    public static LinkedList aLinkedList_1332 = new LinkedList();
    public static int[][] wayPoints = new int[104][104];
    public static int clickX = 0;
    public static int anInt1342 = 0;
    public static Class64 aClass64_1345;
    public static IndexedImage bottomChatBack;
    public static int[] anIntArray1347;

    public static void method975(int songTimeout, int songId) {
        if(RSCanvas.anInt60 != 0 && songId != -1) {
            Class33.method414(false, 1, songId, RSCanvas.anInt60, 0, CacheArchive.jingleCacheArchive);
            Class35.songTimeout = songTimeout;
        }
    }
}
