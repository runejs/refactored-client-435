package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;

import java.awt.*;

public class RSCanvas extends Canvas {
    public static byte[][] aByteArrayArray47 = new byte[50][];
    public static Class6_Sub1 aClass6_Sub1_48;
    public static int anInt50;
    public static RSString aClass1_51;
    public static int anInt52;
    public static Class45 aClass45_53;
    public static int anInt54;
    public static RSString aClass1_55 = RSString.CreateString("shake:");
    public static int anInt56;
    public static int anInt57;
    public static int anInt58;
    public static Class68 aClass68_59;
    public static int anInt60;
    public static Class6 aClass6_61;
    public static int[] anIntArray62;
    public static RSString aClass1_63;
    public static Class68 aClass68_64;
    public static int anInt65;
    public static int[] anIntArray66;
    public static RSString aClass1_67;
    public static RSString aClass1_68;
    public static RSString aClass1_69;
    public static RSString aClass1_70;

    static {
        aClass1_51 = aClass1_55;
        anInt54 = 0;
        aClass45_53 = new Class45();
        anInt60 = 255;
        anInt65 = 127;
        aClass1_69 = RSString.CreateString("Your profile will be transferred in:");
        aClass1_67 = aClass1_69;
        aClass1_70 = RSString.CreateString("Prepared visibility map");
        aClass1_68 = RSString.CreateString("k");
        aClass1_63 = aClass1_70;
    }

    public Component aComponent49;

    public RSCanvas(Component arg0) {

        aComponent49 = arg0;

    }

    public static void method45(byte arg0) {
        RSString.aClass68_1665.method1046((byte) 90);
        anInt50++;
        if(arg0 > -12)
            method47((byte) 69);
    }

    public static void method46(int arg0) {

        Cache.method233(true);
        Class6.method189(false);
        anInt58++;
        Widget.method640((byte) -90);
        Widget.method645((byte) -37);
        Class40_Sub5_Sub6.method586(64);
        Class8.method211((byte) 60);
        Class6.method188(true);
        Class22_Sub2.method316(-11965);
        Class45.method907(-99);
        Class5.method167(1023);
        Class51.method941((byte) -93);
        Actor.method783(109);
        ((Class35) R3D.anInterface3_2939).method422(arg0);
        Class17.aClass9_449.method235((byte) 96);
        FloorDecoration.aClass6_Sub1_605.method191(1120);
        Class40_Sub5_Sub17_Sub1.aClass6_Sub1_3000.method191(1120);
        Class65.aClass6_Sub1_1533.method191(arg0 + 1120);
        Actor.aClass6_Sub1_3157.method191(1120);
        Renderable.aClass6_Sub1_2857.method191(1120);
        Class55.aClass6_Sub1_1286.method191(1120);
        Class40_Sub5_Sub9.aClass6_Sub1_2571.method191(1120);
        ActorDefinition.aClass6_Sub1_2377.method191(arg0 ^ 0x460);
        Class32.aClass6_Sub1_773.method191(1120);
        aClass6_Sub1_48.method191(arg0 + 1120);
        VertexNormal.aClass6_Sub1_1104.method191(1120);
        Class56.aClass6_Sub1_1323.method191(1120);

    }

    public static void method47(byte arg0) {

        aClass1_68 = null;
        if(arg0 != -46)
            method45((byte) -3);
        aClass1_70 = null;
        aByteArrayArray47 = null;
        aClass6_Sub1_48 = null;
        aClass1_63 = null;
        aClass1_55 = null;
        anIntArray62 = null;
        aClass45_53 = null;
        aClass1_51 = null;
        aClass1_69 = null;
        aClass6_61 = null;
        aClass68_64 = null;
        anIntArray66 = null;
        aClass1_67 = null;
        aClass68_59 = null;

    }

    public void paint(Graphics arg0) {

        anInt56++;
        aComponent49.paint(arg0);

    }

    public void update(Graphics arg0) {

        anInt52++;
        aComponent49.update(arg0);

    }
}
