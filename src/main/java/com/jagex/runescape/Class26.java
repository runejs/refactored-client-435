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

    public static Class stringToType(String typeCode) throws ClassNotFoundException {
        if(typeCode.equals("B"))
            return Byte.TYPE;
        if(typeCode.equals("I"))
            return Integer.TYPE;
        if(typeCode.equals("S"))
            return Short.TYPE;
        if(typeCode.equals("J"))
            return Long.TYPE;
        if(typeCode.equals("Z"))
            return Boolean.TYPE;
        if(typeCode.equals("F"))
            return Float.TYPE;
        if(typeCode.equals("D"))
            return Double.TYPE;
        if(typeCode.equals("C"))
            return Character.TYPE;
        return Class.forName(typeCode);
    }

}
