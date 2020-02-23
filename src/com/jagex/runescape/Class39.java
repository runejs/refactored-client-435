package com.jagex.runescape;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.util.Signlink;

public class Class39 implements Runnable {
    public static RSString aClass1_898 = Class58.method978(" steht bereits auf Ihrer Freunde)2Liste(Q");
    public static RSString aClass1_899 = Class58.method978("Benutzen Sie bitte eine andere Welt)3");
    public static RSString aClass1_900 = Class58.method978("Ok");
    public static int anInt901;
    public static int anInt902;
    public static int anInt903;
    public static RSString aClass1_904;
    public static boolean aBoolean906;
    public static Class68 aClass68_907;
    public static Class68 aClass68_908;
    public static int anInt909;
    public static RSString aClass1_910;
    public static RSString aClass1_911 = Class58.method978("Spiel)2Fenster geladen)3");
    public static int anInt912;
    public static RSString aClass1_914;
    public static RSString aClass1_915;
    public static int anInt916;
    public static RSString aClass1_917;
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_918;
    public static RSString aClass1_919;

    static {
        aClass1_910 = Class58.method978(" from your ignore list first");
        anInt909 = 0;
        aClass1_914 = Class58.method978("Stufe)2");
        aBoolean906 = false;
        aClass1_917 = aClass1_910;
        anInt912 = 20;
        aClass1_919 = aClass1_900;
        aClass1_915 = Class58.method978(" more options");
        aClass1_904 = aClass1_915;
    }

    public Object anObject905;
    public boolean aBoolean913 = true;
    public int[] anIntArray920;
    public int anInt921;
    public int[] anIntArray922;

    public Class39() {
        anObject905 = new Object();
        anInt921 = 0;
        anIntArray920 = new int[500];
        anIntArray922 = new int[500];
    }

    public static void method451(Class40_Sub3 arg0, int arg1) {

        int i = 0;
        anInt902++;
        int i_0_ = -1;
        int i_1_ = 0;
        if(arg0.anInt2027 == 0)
            i = (Npc.aScene_3301.method122(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        int i_2_ = 0;
        if((arg0.anInt2027 ^ 0xffffffff) == -2)
            i = (Npc.aScene_3301.method91(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        if(arg0.anInt2027 == 2)
            i = (Npc.aScene_3301.method110(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        if(arg0.anInt2027 == 3)
            i = (Npc.aScene_3301.method93(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        if(arg1 == 19813) {
            if((i ^ 0xffffffff) != -1) {
                int i_3_ = (Npc.aScene_3301.method141(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038, i));
                i_0_ = (0x1fffe692 & i) >> 1746750286;
                i_2_ = (i_3_ & 0xde) >> 114415910;
                i_1_ = i_3_ & 0x1f;
            }
            arg0.anInt2025 = i_2_;
            arg0.anInt2028 = i_0_;
            arg0.anInt2036 = i_1_;
        }

    }

    public static boolean method452(Signlink arg0, byte arg1, boolean arg2) {

        RSCanvas.anInt54 = 20;
        anInt916++;
        try {
            Class5.aClass22_189 = ((Class22) Class.forName("com.jagex.runescape.Class22_Sub2_Sub1").newInstance()); // Java Midi Based
            return true;
        } catch(Throwable throwable) {
            Runnable_Impl1 runnable_impl1 = arg0.method391(1048576);
            if(runnable_impl1 != null) {
                Class5.aClass22_189 = new Class22_Sub2_Sub2(arg0, runnable_impl1); // ???
                return true;
            }
            if(arg1 < 6)
                aClass1_911 = null;
            if(arg2) {
                Class5.aClass22_189 = new Class22_Sub1(arg0); // JS based
                return true;
            }
            return false;
        }

    }

    public static void method453(byte arg0) {

        aClass1_900 = null;
        aClass68_907 = null;
        aClass1_899 = null;
        aClass1_917 = null;
        aClass1_911 = null;
        if(arg0 > -69)
            method451(null, 36);
        aClass40_Sub5_Sub14_Sub4_918 = null;
        aClass1_904 = null;
        aClass1_919 = null;
        aClass1_914 = null;
        aClass1_898 = null;
        aClass68_908 = null;
        aClass1_910 = null;
        aClass1_915 = null;

    }

    public void run() {

        anInt903++;
        while(aBoolean913) {
            synchronized(anObject905) {
                if(anInt921 < 500) {
                    anIntArray922[anInt921] = Class13.mouseX;
                    anIntArray920[anInt921] = Landscape.mouseY;
                    anInt921++;
                }
            }
            Class43.method890(50L, 44);
        }

    }
}
