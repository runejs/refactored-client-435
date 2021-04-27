package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.media.IndexedImage;

public class Class57 {
    public static LinkedList aLinkedList_1332 = new LinkedList();
    public static int[][] wayPoints = new int[104][104];
    public static int clickX = 0;
    public static int anInt1342 = 0;
    public static GameSocket gameSocket;
    public static IndexedImage bottomChatBack;
    public static int[] anIntArray1347;

    public static void method975(int songTimeout, int songId) {
        if(RSCanvas.musicVolume != 0 && songId != -1) {
            Class33.method414(false, 1, songId, RSCanvas.musicVolume, 0, CacheArchive.jingleCacheArchive);
            Class35.songTimeout = songTimeout;
        }
    }
}
