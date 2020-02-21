/* Class36 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class36 {
    public Class63[] aClass63Array856;
    public int anInt857;
    public int anInt858;

    public Class36(Buffer arg0) {
        aClass63Array856 = new Class63[10];
        for(int i = 0; i < 10; i++) {
            int i_10_ = arg0.method468(false);
            if(i_10_ != 0) {
                arg0.offset--;
                aClass63Array856[i] = new Class63();
                aClass63Array856[i].method1004(arg0);
            }
        }
        anInt857 = arg0.method469(65280);
        anInt858 = arg0.method469(65280);
    }

    public Class36() {
        aClass63Array856 = new Class63[10];
    }

    public static Class36 method429(Class6 arg0, int arg1, int arg2) {
        byte[] is = arg0.method172(arg2, 123, arg1);
        if(is == null)
            return null;
        return new Class36(new Buffer(is));
    }

    public byte[] method426() {
        int i = 0;
        for(int i_0_ = 0; i_0_ < 10; i_0_++) {
            if(aClass63Array856[i_0_] != null && (aClass63Array856[i_0_].anInt1494 + aClass63Array856[i_0_].anInt1476) > i)
                i = (aClass63Array856[i_0_].anInt1494 + aClass63Array856[i_0_].anInt1476);
        }
        if(i == 0)
            return new byte[0];
        int i_1_ = 22050 * i / 1000;
        byte[] is = new byte[i_1_];
        for(int i_2_ = 0; i_2_ < 10; i_2_++) {
            if(aClass63Array856[i_2_] != null) {
                int i_3_ = aClass63Array856[i_2_].anInt1494 * 22050 / 1000;
                int i_4_ = aClass63Array856[i_2_].anInt1476 * 22050 / 1000;
                int[] is_5_ = aClass63Array856[i_2_].method1007(i_3_, aClass63Array856[i_2_].anInt1494);
                for(int i_6_ = 0; i_6_ < i_3_; i_6_++) {
                    int i_7_ = is[i_6_ + i_4_] + (is_5_[i_6_] >> 8);
                    if((i_7_ + 128 & ~0xff) != 0)
                        i_7_ = i_7_ >> 31 ^ 0x7f;
                    is[i_6_ + i_4_] = (byte) i_7_;
                }
            }
        }
        return is;
    }

    public int method427() {
        int i = 9999999;
        for(int i_8_ = 0; i_8_ < 10; i_8_++) {
            if(aClass63Array856[i_8_] != null && aClass63Array856[i_8_].anInt1476 / 20 < i)
                i = aClass63Array856[i_8_].anInt1476 / 20;
        }
        if(anInt857 < anInt858 && anInt857 / 20 < i)
            i = anInt857 / 20;
        if(i == 9999999 || i == 0)
            return 0;
        for(int i_9_ = 0; i_9_ < 10; i_9_++) {
            if(aClass63Array856[i_9_] != null)
                aClass63Array856[i_9_].anInt1476 -= i * 20;
        }
        if(anInt857 < anInt858) {
            anInt857 -= i * 20;
            anInt858 -= i * 20;
        }
        return i;
    }

    public Class40_Sub12_Sub1 method428() {
        byte[] is = method426();
        return new Class40_Sub12_Sub1(22050, is, 22050 * anInt857 / 1000, 22050 * anInt858 / 1000);
    }
}
