/* RuntimeException_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class RSRuntimeException extends RuntimeException {
    public static int anInt1641 = 0;
    public static int anInt1642 = 0;
    public static int anInt1643;
    public static RSString aClass1_1644;
    public static int anInt1645;
    public static int anInt1646;
    public static RSString aClass1_1647 = Class58.method978("Regelversto-8 melden");
    public static RSString aClass1_1648;
    public static RSString aClass1_1649;
    public static int anInt1650;
    public static int anInt1651;
    /*synthetic*/ public static Class aClass1654;

    static {
        aClass1_1644 = Class58.method978("Lade Sprites )2 ");
        anInt1651 = 0;
        aClass1_1648 = Class58.method978("Select");
        aClass1_1649 = aClass1_1648;
    }

    public Throwable aThrowable1652;
    public String aString1653;

    public RSRuntimeException(Throwable arg0, String arg1) {
        try {
            aString1653 = arg1;
            aThrowable1652 = arg0;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public static void method1053(int arg0) {
        try {
            aClass1_1648 = null;
            aClass1_1644 = null;
            aClass1_1647 = null;
            if(arg0 >= -39)
                anInt1642 = 95;
            aClass1_1649 = null;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public static void method1054(byte arg0) {
        try {
            anInt1643++;
            if(CollisionMap.aClass8_166 != null) {
                long l = Class51.method937(1);
                if((l ^ 0xffffffffffffffffL) < (Class8.aLong288 ^ 0xffffffffffffffffL)) {
                    CollisionMap.aClass8_166.method212(l);
                    int i = (int) (-Class8.aLong288 + l);
                    Class8.aLong288 = l;
                    synchronized(aClass1654 != null ? aClass1654 : (aClass1654 = method1058("Class8"))) {
                        if(arg0 <= 81)
                            method1054((byte) -96);
                        SubNode.anInt2081 += CollisionMap.anInt141 * i;
                        int i_0_ = ((-(2000 * CollisionMap.anInt141) + SubNode.anInt2081) / 1000);
                        if((i_0_ ^ 0xffffffff) < -1) {
                            if(Class25.aClass40_Sub9_608 != null)
                                Class25.aClass40_Sub9_608.method843(i_0_);
                            SubNode.anInt2081 -= i_0_ * 1000;
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ha.C(" + arg0 + ')');
        }
    }

    public static void method1055(byte[] arg0, byte arg1, Class56 arg2, int arg3) {
        try {
            int i = 0 / ((arg1 - 17) / 35);
            anInt1646++;
            Class40_Sub6 class40_sub6 = new Class40_Sub6();
            class40_sub6.key = (long) arg3;
            class40_sub6.aByteArray2102 = arg0;
            class40_sub6.anInt2112 = 0;
            class40_sub6.aClass56_2117 = arg2;
            synchronized(RSCanvas.aClass45_53) {
                RSCanvas.aClass45_53.method904(class40_sub6, -82);
            }
            HashTable.method332(600);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ha.A(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ',' + arg3 + ')'));
        }
    }

    public static void method1056(Component arg0, byte arg1) {
        try {
            arg0.addMouseListener(GameObject.aClass62_3019);
            int i = -23 / ((-32 - arg1) / 47);
            anInt1650++;
            arg0.addMouseMotionListener(GameObject.aClass62_3019);
            arg0.addFocusListener(GameObject.aClass62_3019);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ha.D(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public static void method1057(int arg0) {
        try {
            Class32.aClass38_768.method444(10);
            for(int i = 0; i < 32; i++)
                RSApplet.aLongArray4[i] = 0L;
            for(int i = 0; i < 32; i++)
                Class67.aLongArray1614[i] = 0L;
            if(arg0 <= 67)
                anInt1642 = -3;
            anInt1645++;
            Class40_Sub3.anInt2020 = 0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ha.B(" + arg0 + ')');
        }
    }

    /*synthetic*/
    public static Class method1058(String arg0) {
        try {
            return Class.forName(arg0);
        } catch(ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}
