package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.tile.GenericTile;

public class Class34 {
    public static HashTable aClass23_805;
    public static int anInt813 = 0;
    public static RSString aClass1_817;
    public static RSString aClass1_826 = RSString.CreateString("Click to continue");
    public static RSString aClass1_829 = aClass1_826;
    public static HashTable aClass23_841 = new HashTable(4096);
    public static RSString aClass1_844 = (RSString.CreateString("Press (Wrecover a locked account(W on front page)3"));
    public static int anInt848 = 0;
    public static int currentCameraPositionV;
    public static Cache aClass9_851 = new Cache(30);
    public static int[] anIntArray852;
    public static long aLong853;
    public static int anInt854 = -1;
    public static IndexedImage mapBack;

    static {
        aClass1_817 = aClass1_844;
    }

    public int anInt801;
    public int anInt802;
    public byte[] aByteArray808 = new byte[18002];
    public int anInt809;
    public int anInt810;
    public int anInt811;
    public int anInt812;
    public byte[] aByteArray814;
    public int[] anIntArray816;
    public int[] anIntArray818 = new int[16];
    public byte aByte819;
    public int anInt820;
    public byte[][] aByteArrayArray822;
    public int anInt823;
    public boolean[] aBooleanArray824;
    public int anInt825;
    public int[] anIntArray827;
    public boolean[] aBooleanArray828;
    public byte[] aByteArray830;
    public int anInt831;
    public int anInt832;
    public int[][] anIntArrayArray833;
    public int anInt834;
    public int[][] anIntArrayArray835;
    public byte[] aByteArray837;
    public byte[] aByteArray839;
    public byte[] aByteArray840;
    public int[][] anIntArrayArray842;
    public int anInt843;
    public int[] anIntArray845;
    public int anInt846;
    public int anInt847;

    public Class34() {
        aByteArray814 = new byte[256];
        anInt825 = 0;
        aBooleanArray824 = new boolean[16];
        anIntArray816 = new int[257];
        aByteArrayArray822 = new byte[6][258];
        anInt832 = 0;
        anIntArray827 = new int[6];
        anIntArrayArray833 = new int[6][258];
        anIntArray845 = new int[256];
        aBooleanArray828 = new boolean[256];
        anIntArrayArray842 = new int[6][258];
        anIntArrayArray835 = new int[6][258];
        aByteArray840 = new byte[4096];
        aByteArray839 = new byte[18002];
    }

    public static int method415(byte arg0, int arg1, int arg2) {
        long l = (long) ((arg1 << 16) + arg2);
        if(PacketBuffer.aClass40_Sub5_Sub13_2250 == null || PacketBuffer.aClass40_Sub5_Sub13_2250.key != l)
            return 0;
        return 1 + (Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition * 99 / ((Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer).length + -(PacketBuffer.aClass40_Sub5_Sub13_2250.aByte2758)));
    }

    public static boolean method416(byte arg0) {
        synchronized(Class59.keyFocusListener) {
            if(Class59.anInt1389 == GenericTile.anInt1214)
                return false;
            ItemDefinition.anInt2854 = Class40_Sub6.anIntArray2113[Class59.anInt1389];
            Class59.anInt1388 = Class40_Sub5_Sub13.anIntArray2764[Class59.anInt1389];
            if(arg0 > -21)
                aClass1_829 = null;
            Class59.anInt1389 = Class59.anInt1389 + 1 & 0x7f;
            return true;
        }
    }

    public static VarbitDefinition method417(int arg0, int arg1) {
        if(arg0 != 0)
            return null;
        VarbitDefinition varbitDefinition = ((VarbitDefinition) Class57.aClass9_1331.get((long) arg1, (byte) 111));
        if(varbitDefinition != null)
            return varbitDefinition;
        byte[] is = RSCanvas.aCacheIndex_61.getFile(arg1, 14);
        varbitDefinition = new VarbitDefinition();
        if(is != null)
            varbitDefinition.method562(new Buffer(is));
        Class57.aClass9_1331.put((long) arg1, varbitDefinition);
        return varbitDefinition;
    }

    public static void method418() {
        aClass1_826 = null;
        aClass1_817 = null;
        aClass1_844 = null;
        aClass9_851 = null;
        aClass23_841 = null;
        aClass1_829 = null;
        anIntArray852 = null;
        aClass23_805 = null;
        mapBack = null;
    }

    public static int method420(int arg0, int arg1, boolean arg2) {
        if(arg0 == -2)
            return 12345678;
        if(arg0 == -1) {
            if(arg1 < 0)
                arg1 = 0;
            else if(arg1 > 127)
                arg1 = 127;
            arg1 = -arg1 + 127;
            return arg1;
        }
        if(!arg2)
            method415((byte) -125, -124, -88);
        arg1 = arg1 * (arg0 & 0x7f) / 128;
        if(arg1 < 2)
            arg1 = 2;
        else if(arg1 > 126)
            arg1 = 126;
        return (0xff80 & arg0) + arg1;
    }
}
