package com.jagex.runescape.media;

import com.jagex.runescape.RSString;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.language.English;

public class VertexNormal {
    public static int menuWidth;
    public static RSString aClass1_1090 = RSString.CreateString("Close");
    public static RSString aClass1_1093 = RSString.CreateString("Prepared sound engine");
    public static RSString aClass1_1097 = RSString.CreateString("wave:");
    public static RSString aClass1_1099 = RSString.CreateString("Loading fonts )2 ");
    public static Cache aClass9_1102 = new Cache(500);
    public static CacheIndex_Sub1 aClass6_Sub1_1104;
    public static RSString aClass1_1105 = aClass1_1093;
    public static boolean lowMemory = false;
    public static RSString aClass1_1113 = RSString.CreateString("mapback");
    public static RSString aClass1_1114 = RSString.CreateString("@lre@");
    public static RSString aClass1_1117 = RSString.CreateString(" ");

    public int y;
    public int x;
    public int z;
    public int magnitude;

    public static void method914() {
        aClass1_1114 = null;
        aClass1_1117 = null;
        aClass1_1090 = null;
        aClass1_1093 = null;
        English.moderatorOptionMutePlayerFor48HoursOFF = null;
        aClass1_1099 = null;
        aClass1_1105 = null;
        aClass9_1102 = null;
        aClass1_1113 = null;
        aClass1_1097 = null;
        aClass6_Sub1_1104 = null;
    }
}
