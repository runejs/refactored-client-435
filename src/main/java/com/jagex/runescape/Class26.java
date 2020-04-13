package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;

import java.awt.*;

public class Class26 {
    public static boolean aBoolean618 = false;
    public static int loginScreenState = 0;
    public static Image anImage624;
    public static int anInt627;
    public static CacheIndex aCacheIndex_632;
    public static int baseY;

    public static Class method349(String arg1) throws ClassNotFoundException {
        if(arg1.equals("B"))
            return Byte.TYPE;
        if(arg1.equals("I"))
            return Integer.TYPE;
        if(arg1.equals("S"))
            return Short.TYPE;
        if(arg1.equals("J"))
            return Long.TYPE;
        if(arg1.equals("Z"))
            return Boolean.TYPE;
        if(arg1.equals("F"))
            return Float.TYPE;
        if(arg1.equals("D"))
            return Double.TYPE;
        if(arg1.equals("C"))
            return Character.TYPE;
        return Class.forName(arg1);
    }

}
