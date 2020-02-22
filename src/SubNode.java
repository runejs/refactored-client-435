/* Class40_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class SubNode extends Node {
    public static int anInt2081;
    public static boolean aBoolean2083;
    public static RSString aClass1_2084;
    public static int anInt2085;
    public static int[] anIntArray2086;
    public static int anInt2088;
    public static int anInt2089;
    public static RSString aClass1_2090 = Class58.method978("(U5");
    public static Class68 aClass68_2091;
    public static int anInt2092;
    public static RSString aClass1_2093;
    public static int anInt2094;
    public static RSString aClass1_2095;
    public static int anInt2096;

    static {
        aBoolean2083 = false;
        aClass1_2084 = Class58.method978(")1");
        aClass1_2093 = Class58.method978("redstone1");
        aClass1_2095 = Class58.method978("Fallen lassen");
    }

    public SubNode aClass40_Sub5_2082;
    public SubNode aClass40_Sub5_2087;

    public static IndexedColorSprite method538(int arg0) {
        anInt2088++;
        IndexedColorSprite class40_sub5_sub14_sub2 = new IndexedColorSprite();
        class40_sub5_sub14_sub2.anInt2923 = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub2.anInt2924 = RSApplet.anInt31;
        class40_sub5_sub14_sub2.anInt2928 = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub2.anInt2927 = Class40_Sub5_Sub17_Sub4.anIntArray3111[0];
        class40_sub5_sub14_sub2.anInt2921 = Class17.anIntArray456[0];
        class40_sub5_sub14_sub2.anInt2926 = NPC.anIntArray3312[0];
        class40_sub5_sub14_sub2.anIntArray2922 = Buffer.anIntArray1972;
        class40_sub5_sub14_sub2.aByteArray2925 = Class58.aByteArrayArray1370[arg0];
        NpcDefinition.method569(true);
        return class40_sub5_sub14_sub2;
    }

    public static void method540(int arg0) {
        anInt2094++;
        if(arg0 != 23721)
            aClass1_2095 = null;
        Class54.aClass45_1278 = new Class45();
    }

    public static void method541(int arg0) {
        aClass1_2090 = null;
        aClass1_2095 = null;
        aClass1_2084 = null;
        aClass1_2093 = null;
        if(arg0 < 35)
            method541(109);
        aClass68_2091 = null;
        anIntArray2086 = null;
    }

    public void method539(int arg0) {
        if(arg0 != 0)
            method538(16);
        anInt2092++;
        if(aClass40_Sub5_2087 != null) {
            aClass40_Sub5_2087.aClass40_Sub5_2082 = aClass40_Sub5_2082;
            aClass40_Sub5_2082.aClass40_Sub5_2087 = aClass40_Sub5_2087;
            aClass40_Sub5_2087 = null;
            aClass40_Sub5_2082 = null;
        }
    }
}
