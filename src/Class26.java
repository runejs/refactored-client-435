/* Class26 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class Class26 {
    public static int anInt616;
    public static int anInt617;
    public static boolean aBoolean618;
    public static RSString aClass1_619;
    public static RSString aClass1_620;
    public static RSString aClass1_621;
    public static int anInt622 = 0;
    public static RSString aClass1_623;
    public static Image anImage624;
    public static int anInt625;
    public static int anInt626;
    public static int anInt627;
    public static int anInt628;
    public static RSString aClass1_629;
    public static RSString aClass1_630;
    public static RSString aClass1_631;
    public static Class6 aClass6_632;
    public static RSString aClass1_633;
    public static RSString aClass1_634;
    public static int anInt635;

    static {
        aBoolean618 = false;
        aClass1_621 = Class58.method978("World");
        aClass1_623 = Class58.method978("skill)2");
        aClass1_620 = Class58.method978("@whi@");
        aClass1_631 = Class58.method978("gelb:");
        anInt617 = 0;
        aClass1_619 = aClass1_623;
        aClass1_630 = Class58.method978("Untersuchen");
        aClass1_633 = (Class58.method978("Moderator)2Option: Spieler f-Ur 48 Stunden stumm schalten: <OFF>"));
        aClass1_634 = aClass1_621;
        aClass1_629 = Class58.method978("Weiter");
    }

    public static Class method349(byte arg0, String arg1) throws ClassNotFoundException {
        try {
            anInt626++;
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
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ie.B(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method350(int arg0) {
        aClass1_631 = null;
        aClass1_630 = null;
        aClass1_629 = null;
        anImage624 = null;
        aClass1_634 = null;
        aClass1_621 = null;
        aClass1_620 = null;
        aClass1_633 = null;
        aClass6_632 = null;
        aClass1_619 = null;
        aClass1_623 = null;
        if(arg0 != 0)
            method350(15);
    }
}
