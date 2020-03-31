package com.jagex.runescape;

import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.util.SignlinkNode;

public class Class12 {
    public static int friendListStatus = 0;
    public static Widget chatboxInterface;
    public static Class39 mouseCapturer;
    public static int cameraX;
    public static volatile int eventMouseX = -1;
    public static int width;
    public static SignlinkNode aSignlinkNode_394;
    public static RSString aClass1_397 = RSString.CreateString("Unable to find ");
    public static RSString aClass1_399 = RSString.CreateString("Enter name of player to delete from list");

    public static void method240() {
        aSignlinkNode_394 = null;
        chatboxInterface = null;
        aClass1_399 = null;
        mouseCapturer = null;
        Native.prefixColon = null;
        aClass1_397 = null;
    }
}
