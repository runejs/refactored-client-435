package com.jagex.runescape;

import java.awt.*;

public class Class26 {
    public static int itemSearchScroll = 0;
    public static boolean aBoolean618 = false;
    public static RSString aClass1_619 = Class58.method978("skill)2");
    public static RSString aClass1_620 = Class58.method978("@whi@");
    public static int anInt622 = 0;
    public static Image anImage624;
    public static int anInt627;
    public static RSString aClass1_629 = Class58.method978("Weiter");
    public static RSString aClass1_630 = Class58.method978("Untersuchen");
    public static RSString aClass1_631 = Class58.method978("gelb:");
    public static Class6 aClass6_632;
    public static RSString aClass1_633 = (Class58.method978("Moderator)2Option: Spieler f-Ur 48 Stunden stumm schalten: <OFF>"));
    public static RSString aClass1_634 = Class58.method978("World");
    public static int anInt635;

    public static Class method349(byte arg0, String arg1) throws ClassNotFoundException {
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
        if(arg0 != 91)
            method350(-66);
        if(arg1.equals("C"))
            return Character.TYPE;
        return Class.forName(arg1);
    }

    public static void method350(int arg0) {
        aClass1_631 = null;
        aClass1_630 = null;
        aClass1_629 = null;
        anImage624 = null;
        aClass1_634 = null;
        aClass1_620 = null;
        aClass1_633 = null;
        aClass6_632 = null;
        aClass1_619 = null;
        if(arg0 != 0)
            method350(15);
    }
}
