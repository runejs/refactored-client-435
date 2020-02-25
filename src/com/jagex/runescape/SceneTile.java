package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Npc;

import java.nio.charset.StandardCharsets;

public class SceneTile extends Node {
    public static int anInt2040;
    public static int anInt2041;
    public static RSString aClass1_2042;
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2043;
    public static RSString aClass1_2044;
    public static int anInt2045;
    public static RSString aClass1_2046 = RSString.CreateString("Verbindung mit Freunde)2Server)3)3)3");
    public static RSString aClass1_2047;
    public static int[] anIntArray2048;
    public static int activeInterfaceType;
    public static RSString aClass1_2050;
    public static RSString aClass1_2051;
    public static int anInt2052;
    public static RSString aClass1_2053;
    public static RSString aClass1_2054;
    public static RSString aClass1_2055;
    public static int anInt2056;
    public static RSString aClass1_2057;

    static {
        aClass1_2044 = RSString.CreateString("Schrifts-=tze geladen)3");
        aClass1_2051 = RSString.CreateString("m-Ochte sich mit Ihnen duellieren)3");
        aClass1_2055 = RSString.CreateString("Please try using a different world)3");
        aClass1_2050 = aClass1_2055;
        aClass1_2047 = aClass1_2055;
        aClass1_2053 = aClass1_2055;
        aClass1_2057 = aClass1_2055;
        aClass1_2042 = aClass1_2055;
        activeInterfaceType = 0;
        aClass1_2054 = aClass1_2055;
    }

    public SceneTile aSceneTile_2058;
    public int anInt2059;
    public Class58 aClass58_2060;
    public int anInt2061;
    public boolean aBoolean2062;
    public int anInt2063;
    public int anInt2064;
    public Class19[] aClass19Array2065 = new Class19[5];
    public int anInt2066;
    public int anInt2067;
    public Class11 aClass11_2068;
    public int anInt2069;
    public Class52 aClass52_2070;
    public boolean aBoolean2071;
    public Class10 aClass10_2072;
    public int anInt2073;
    public int[] anIntArray2074 = new int[5];
    public FloorDecoration floorDecoration;
    public int anInt2076;
    public boolean aBoolean2077;
    public int anInt2078;
    public Class53 aClass53_2079;
    public int anInt2080;

    public SceneTile(int arg0, int arg1, int arg2) {
        anInt2073 = 0;
        anInt2061 = arg1;
        anInt2069 = anInt2066 = arg0;
        anInt2078 = arg2;

    }

    public static RSString method532(byte arg0, Widget arg1, RSString arg2) {

        anInt2045++;
        if(arg0 != 20)
            aClass1_2047 = null;
        if(arg2.contains(Class44.aClass1_1041) != -1) {
            for(; ; ) {
                int i = arg2.contains(Class38.aClass1_890);
                if(i == -1)
                    break;
                arg2 = (Class40_Sub5_Sub17_Sub6.method832(-37, (new RSString[]{arg2.substring(0, i), (Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(0, false, arg1))), arg2.substring(2 + i)})));
            }
            for(; ; ) {
                int i = arg2.contains(Class45.aClass1_1077);
                if((i ^ 0xffffffff) == 0)
                    break;
                arg2 = (Class40_Sub5_Sub17_Sub6.method832(72, (new RSString[]{arg2.substring(0, i), (Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(1, false, arg1))), arg2.substring(i + 2)})));
            }
            for(; ; ) {
                int i = arg2.contains(Class67.aClass1_1610);
                if((i ^ 0xffffffff) == 0)
                    break;
                arg2 = (Class40_Sub5_Sub17_Sub6.method832(-121, (new RSString[]{arg2.substring(0, i), (Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(2, false, arg1))), arg2.substring(2 + i)})));
            }
            for(; ; ) {
                int i = arg2.contains(Class55.aClass1_1300);
                if(i == -1)
                    break;
                arg2 = (Class40_Sub5_Sub17_Sub6.method832(125, (new RSString[]{arg2.substring(0, i), (Class40_Sub11.method872(arg0 ^ 0x3b9ac9eb, HuffmanEncoding.method1029(3, false, arg1))), arg2.substring(i + 2)})));
            }
            for(; ; ) {
                int i = arg2.contains(SubNode.aClass1_2090);
                if(i == -1)
                    break;
                arg2 = (Class40_Sub5_Sub17_Sub6.method832(-43, (new RSString[]{arg2.substring(0, i), (Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(4, false, arg1))), arg2.substring(i + 2)})));
            }
            for(; ; ) {
                int i = arg2.contains(GameObjectDefinition.aClass1_2526);
                if((i ^ 0xffffffff) == 0)
                    break;
                RSString class1 = HuffmanEncoding.blank_string;
                if(Class12.aClass15_394 != null) {
                    class1 = CacheIndex_Sub1.method204((Class12.aClass15_394.anInt432), 255);
                    if(Class12.aClass15_394.anObject437 != null) {
                        byte[] is = ((String) Class12.aClass15_394.anObject437).getBytes(StandardCharsets.ISO_8859_1);
                        class1 = Class19.method279(is, true, 0, is.length);
                    }
                }
                arg2 = (Class40_Sub5_Sub17_Sub6.method832(124, new RSString[]{arg2.substring(0, i), class1, arg2.substring(i + 4)}));
            }
        }
        return arg2;

    }

    public static void drawOnMinimap(int arg0, int arg1, ImageRGB sprite) {
        if(sprite == null) {
            return;
        }
        int k = 0x7ff & Class43.cameraYawOffset + Class58.cameraHorizontal;
        int l = arg0 * arg0 + arg1 * arg1;
        if(l > 6400) {
            return;
        }
        int sine = Model.SINE[k];
        int cosine = Model.COSINE[k];
        sine = sine * 256 / (Class51.mapZoomOffset + 256);
        cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
        int i_3_ = cosine * arg1 + arg0 * sine >> 16;
        int i_4_ = -(arg1 * sine) + cosine * arg0 >> 16;
        if(l > 2500)
            sprite.drawTo(Class34.mapBack, 98 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + (-i_4_ + 79));
        else
            sprite.drawImage(4 + -(sprite.maxWidth / 2) + (i_3_ + 94), -4 + (-i_4_ + (83 + -(sprite.maxHeight / 2))));
    }

    public static void method534(int arg0) {

        aClass1_2042 = null;
        aClass1_2055 = null;
        aClass1_2050 = null;
        aClass1_2047 = null;
        aClass1_2044 = null;
        aClass1_2051 = null;
        aClass1_2057 = null;
        int i = -102 % ((arg0 - 14) / 51);
        aClass1_2053 = null;
        anIntArray2048 = null;
        aClass1_2054 = null;
        aClass1_2046 = null;
        aClass40_Sub5_Sub14_Sub4_2043 = null;

    }

    public static RSString method536(int arg0, int arg1, int arg2) {

        anInt2056++;
        if(arg2 >= -16)
            return null;
        int i = -arg1 + arg0;
        if((i ^ 0xffffffff) > 8)
            return FloorDecoration.aClass1_610;
        if((i ^ 0xffffffff) > 5)
            return Class29.aClass1_670;
        if(i < -3)
            return Class68.aClass1_1639;
        if((i ^ 0xffffffff) > -1)
            return Cache.aClass1_327;
        if((i ^ 0xffffffff) < -10)
            return Landscape.aClass1_1162;
        if(i > 6)
            return Class19.aClass1_494;
        if((i ^ 0xffffffff) < -4)
            return Node.aClass1_932;
        if((i ^ 0xffffffff) < -1)
            return Class37.aClass1_877;
        return Class54.aClass1_1283;

    }

    public static void method537(int arg0) {

        anInt2041++;
        if(ActorDefinition.anInt2394 >= 2 || (Class8.anInt301 ^ 0xffffffff) != -1 || (Main.anInt1773 ^ 0xffffffff) != -1) {
            RSString class1;
            if(Class8.anInt301 == 1 && (ActorDefinition.anInt2394 ^ 0xffffffff) > -3)
                class1 = (Class40_Sub5_Sub17_Sub6.method832(-74, (new RSString[]{Main.aClass1_1763, VertexNormal.aClass1_1117, Npc.aClass1_3295, Class38.aClass1_894})));
            else if(Main.anInt1773 != 1 || ActorDefinition.anInt2394 >= 2)
                class1 = (Landscape.aClass1Array1184[-1 + ActorDefinition.anInt2394]);
            else
                class1 = (Class40_Sub5_Sub17_Sub6.method832(-57, new RSString[]{Class38_Sub1.aClass1_1918, VertexNormal.aClass1_1117, FloorDecoration.aClass1_611, Class38.aClass1_894}));
            if((ActorDefinition.anInt2394 ^ 0xffffffff) < -3)
                class1 = (Class40_Sub5_Sub17_Sub6.method832(56, new RSString[]{class1, Class53.aClass1_1243, HashTable.method334((ActorDefinition.anInt2394) + -2, -1), Class39.aClass1_904}));
            if(arg0 == 4)
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawShadowedSeededAlphaString(class1, 4, 15, 16777215, true, Node.pulseCycle / 1000);
        }

    }
}
