package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class34 {
    public static int anInt800;
    public static int anInt803;
    public static HashTable aClass23_805;
    public static RSString aClass1_804 = Class58.method978("m-Ochte mit Ihnen handeln)3");
    public static int anInt806;
    public static int anInt807;
    public static int anInt813;
    public static int anInt815;
    public static RSString aClass1_817;
    public static int anInt821;
    public static RSString aClass1_826 = Class58.method978("Click to continue");
    public static RSString aClass1_829 = aClass1_826;
    public static int anInt836;
    public static int anInt838;
    public static HashTable aClass23_841;
    public static RSString aClass1_844;
    public static int anInt848;
    public static int anInt849;
    public static RSString aClass1_850;
    public static Cache aClass9_851;
    public static int[] anIntArray852;
    public static long aLong853;
    public static int anInt854;
    public static IndexedImage mapBack;

    static {
        anInt813 = 0;
        aClass1_844 = (Class58.method978("Press (Wrecover a locked account(W on front page)3"));
        aClass1_817 = aClass1_844;
        aClass23_841 = new HashTable(4096);
        aClass1_850 = Class58.method978("Suche nach Updates )2 ");
        anInt848 = 0;
        aClass9_851 = new Cache(30);
        anInt854 = -1;
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

        anInt815++;
            long l = (long) ((arg1 << 1451454800) + arg2);
            if(PacketBuffer.aClass40_Sub5_Sub13_2250 == null || PacketBuffer.aClass40_Sub5_Sub13_2250.key != l)
                return 0;
            int i = 34 % ((arg0 + 46) / 45);
            return 1 + (Class40_Sub5_Sub13.aClass40_Sub1_2752.currentPosition * 99 / ((Class40_Sub5_Sub13.aClass40_Sub1_2752.buffer).length + -(PacketBuffer.aClass40_Sub5_Sub13_2250.aByte2758)));

    }

    public static boolean method416(byte arg0) {

        anInt836++;
            synchronized(Class59.aClass54_1392) {
                if(Class59.anInt1389 == Class52.anInt1214)
                    return false;
                ItemDefinition.anInt2854 = Class40_Sub6.anIntArray2113[Class59.anInt1389];
                Class59.anInt1388 = Class40_Sub5_Sub13.anIntArray2764[Class59.anInt1389];
                if(arg0 > -21)
                    aClass1_829 = null;
                Class59.anInt1389 = Class59.anInt1389 + 1 & 0x7f;
                return true;
            }

    }

    public static Class40_Sub5_Sub4 method417(int arg0, int arg1) {

        anInt800++;
            if(arg0 != 0)
                return null;
            Class40_Sub5_Sub4 class40_sub5_sub4 = ((Class40_Sub5_Sub4) Class57.aClass9_1331.method231((long) arg1, (byte) 111));
            if(class40_sub5_sub4 != null)
                return class40_sub5_sub4;
            byte[] is = RSCanvas.aClass6_61.method172(arg1, 115, 14);
            class40_sub5_sub4 = new Class40_Sub5_Sub4();
            if(is != null)
                class40_sub5_sub4.method562(0, new Buffer(is));
            Class57.aClass9_1331.method230(-7208, (long) arg1, class40_sub5_sub4);
            return class40_sub5_sub4;

    }

    public static void method418(int arg0) {

        aClass1_826 = null;
            if(arg0 != 7679)
                method420(-90, 8, false);
            aClass1_817 = null;
            aClass1_804 = null;
            aClass1_844 = null;
            aClass9_851 = null;
            aClass23_841 = null;
            aClass1_829 = null;
            anIntArray852 = null;
            aClass23_805 = null;
            aClass1_850 = null;
        mapBack = null;

    }

    public static void method419(byte arg0) {

        int i = -2 / ((-31 - arg0) / 57);
            anInt807++;
            while((Cache.outgoingbuffer.method510(125, Class40_Sub5_Sub12.packetsize) ^ 0xffffffff) <= -12) {
                int i_0_ = Cache.outgoingbuffer.putBits(11, (byte) -65);
                if((i_0_ ^ 0xffffffff) == -2048)
                    break;
                boolean bool = false;
                if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_0_]) == null) {
                    Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_0_] = new Player();
                    if(Class22.aClass40_Sub1Array534[i_0_] != null)
                        Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_0_].method791((byte) -114, Class22.aClass40_Sub1Array534[i_0_]);
                    bool = true;
                }
                Class57.anIntArray1334[Class60.anInt1407++] = i_0_;
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_0_]);
                class40_sub5_sub17_sub4_sub1.anInt3134 = Node.anInt926;
                int i_1_ = Cache.outgoingbuffer.putBits(5, (byte) -65);
                int i_2_ = Cache.outgoingbuffer.putBits(5, (byte) -65);
                if((i_1_ ^ 0xffffffff) < -16)
                    i_1_ -= 32;
                if((i_2_ ^ 0xffffffff) < -16)
                    i_2_ -= 32;
                int i_3_ = (Class40_Sub5_Sub17_Sub1.anIntArray2987[Cache.outgoingbuffer.putBits(3, (byte) -65)]);
                if(bool)
                    class40_sub5_sub17_sub4_sub1.anInt3118 = i_3_;
                int i_4_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                int i_5_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                if((i_5_ ^ 0xffffffff) == -2)
                    Class24.anIntArray578[Actor.anInt3153++] = i_0_;
                class40_sub5_sub17_sub4_sub1.method787(i_2_ + (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anIntArray3135[0]), -7717, (i_4_ ^ 0xffffffff) == -2, (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anIntArray3088[0]) + i_1_);
            }
            Cache.outgoingbuffer.finishBitAccess((byte) -110);

    }

    public static int method420(int arg0, int arg1, boolean arg2) {

        anInt806++;
            if(arg0 == -2)
                return 12345678;
            if(arg0 == -1) {
                if((arg1 ^ 0xffffffff) > -1)
                    arg1 = 0;
                else if(arg1 > 127)
                    arg1 = 127;
                arg1 = -arg1 + 127;
                return arg1;
            }
            if(arg2 != true)
                method415((byte) -125, -124, -88);
            arg1 = arg1 * (arg0 & 0x7f) / 128;
            if(arg1 < 2)
                arg1 = 2;
            else if(arg1 > 126)
                arg1 = 126;
            return (0xff80 & arg0) + arg1;

    }
}
