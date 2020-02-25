package com.jagex.runescape;

public class Class38_Sub2 extends Class38 {
    public long aLong1925;

    public Class38_Sub2() {
        method443(-10115);
    }

    public void method444(int arg0) {
        method443(-10115);
        int i = 20 % ((arg0 + 76) / 48);
    }

    public void method443(int arg0) {
        if(arg0 == -10115)
            aLong1925 = System.nanoTime();
    }

    public int method442(int arg0, int arg1, int arg2) {
        int i;
        try {
            long l = (long) arg1 * 1000000L;
            long l_0_ = aLong1925 - System.nanoTime();
            if(arg2 != 9799)
                method444(32);
            if(l > l_0_)
                l_0_ = l;
            Class43.method890(l_0_ / 1000000L, -86);
            long l_1_ = System.nanoTime();
            int i_2_;
            for(i_2_ = 0; (i_2_ < 10 && (i_2_ < 1 || aLong1925 < l_1_)); i_2_++)
                aLong1925 += (long) arg0 * 1000000L;
            if(l_1_ > aLong1925)
                aLong1925 = l_1_;
            i = i_2_;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
        return i;
    }
}
