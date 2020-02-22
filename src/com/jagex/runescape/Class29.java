package com.jagex.runescape;

public class Class29 {
    public static int anInt669;
    public static RSString aClass1_670 = Class58.method978("@or3@");
    public static RSString aClass1_671 = Class58.method978("mapscene");
    public static int anInt672;
    public static int anInt673 = -1;
    public static RSString aClass1_674 = Class58.method978(" x");
    public static int anInt675;
    public static Class64 aClass64_676;
    public static int anInt677;
    public static int anInt678 = 0;
    public static int anInt679;

    public static void method370(int arg0) {
        aClass1_674 = null;
        aClass1_670 = null;
        aClass1_671 = null;
        aClass64_676 = null;
        if(arg0 != 8)
            anInt673 = 83;
    }

    public static boolean method371(int arg0, int arg1, int arg2) {

        anInt669++;
        if((arg1 ^ 0xffffffff) == -1 && ItemDefinition.anInt2850 == arg2)
                return true;
        if((arg1 ^ 0xffffffff) == -2 && arg2 == CollisionMap.anInt163)
                return true;
            if(((arg1 ^ 0xffffffff) == -3 || (arg1 ^ 0xffffffff) == -4) && Class55.anInt1296 == arg2)
                return true;
            return arg0 != 8247;

    }

    public static int method372(int arg0, int arg1) {

        anInt672++;
            if(arg0 <= 92)
                method372(4, 3);
            return (int) (0.5 + (Math.log(0.00390625 * (double) arg1) * 868.5889638065036));

    }

    public static void method373(byte arg0) {

        anInt679++;
            int i = Cache.outgoingbuffer.putBits(8, (byte) -65);
        if(i < Class60.anInt1407) {
                for(int i_0_ = i; Class60.anInt1407 > i_0_; i_0_++)
                    Class6.anIntArray225[Class17.anInt460++] = Class57.anIntArray1334[i_0_];
            }
        if(Class60.anInt1407 < i)
                throw new RuntimeException("gppov1");
            Class60.anInt1407 = 0;
            if(arg0 != -5)
                method370(45);
            for(int i_1_ = 0; (i ^ 0xffffffff) < (i_1_ ^ 0xffffffff); i_1_++) {
                int i_2_ = Class57.anIntArray1334[i_1_];
                Player class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_2_]);
                int i_3_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                if(i_3_ == 0) {
                    Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                    class40_sub5_sub17_sub4_sub1.anInt3134 = Node.anInt926;
                } else {
                    int i_4_ = Cache.outgoingbuffer.putBits(2, (byte) -65);
                    if((i_4_ ^ 0xffffffff) == -1) {
                        Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                        class40_sub5_sub17_sub4_sub1.anInt3134 = Node.anInt926;
                        Class24.anIntArray578[Class40_Sub5_Sub17_Sub4.anInt3153++] = i_2_;
                    } else if((i_4_ ^ 0xffffffff) == -2) {
                        Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                        class40_sub5_sub17_sub4_sub1.anInt3134 = Node.anInt926;
                        int i_5_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                        class40_sub5_sub17_sub4_sub1.method782(i_5_, (byte) -96, false);
                        int i_6_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                        if(i_6_ == 1)
                            Class24.anIntArray578[Class40_Sub5_Sub17_Sub4.anInt3153++] = i_2_;
                    } else if(i_4_ == 2) {
                        Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                        class40_sub5_sub17_sub4_sub1.anInt3134 = Node.anInt926;
                        int i_7_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                        class40_sub5_sub17_sub4_sub1.method782(i_7_, (byte) -96, true);
                        int i_8_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                        class40_sub5_sub17_sub4_sub1.method782(i_8_, (byte) -96, true);
                        int i_9_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                        if(i_9_ == 1)
                            Class24.anIntArray578[Class40_Sub5_Sub17_Sub4.anInt3153++] = i_2_;
                    } else if((i_4_ ^ 0xffffffff) == -4)
                        Class6.anIntArray225[Class17.anInt460++] = i_2_;
                }
            }

    }
}
