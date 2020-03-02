package com.jagex.runescape;

import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

public abstract class Class8_Sub1 extends Class8 implements Runnable {
    public static int[] anIntArray1829 = new int[256];
    public boolean aBoolean1820;
    public long aLong1821;
    public int anInt1822;
    public int anInt1823;
    public int anInt1824;
    public int anInt1825 = 0;
    public long aLong1826;
    public int anInt1827;
    public int anInt1828;
    public int anInt1830;
    public int anInt1831;
    public long aLong1832;
    public int[] anIntArray1833;

    public Class8_Sub1(int arg0) throws Exception {
        super(arg0);
        aLong1821 = 0L;
        anInt1827 = 256;
        aBoolean1820 = false;
        anInt1828 = 0;
        anInt1822 = 0;
        anInt1824 = 0;
        anIntArray1833 = new int[512];
    }

    public static void method220() {
        anIntArray1829 = null;
    }

    public void method219(long arg0) throws Exception {
        method226(anInt1831);
        for(; ; ) {
            int i = method224();
            if(i < anInt1827)
                break;
            method223();
        }
        anInt1823 = 0;
        anInt1830 = 0;
        aLong1832 = arg0;
        aLong1826 = arg0;
    }

    public void method221(long arg0) {
        if(aLong1821 != 0L) {
            for(/**/; aLong1832 < arg0; aLong1832 += (long) (256000 / CollisionMap.anInt141))
                Class8.method217(256);
            if(arg0 < aLong1821)
                return;
            try {
                method219(arg0);
            } catch(Exception exception) {
                method225();
                aLong1821 += 5000L;
                return;
            }
            aLong1821 = 0L;
        }
        while(aLong1832 < arg0) {
            aLong1832 += (long) (250880 / CollisionMap.anInt141);
            int i;
            try {
                i = method224();
            } catch(Exception exception) {
                method225();
                aLong1821 = arg0;
                return;
            }
            method227(i);
            int i_0_ = anInt1828 * 3 / 512 - anInt1822 * 2;
            if(i_0_ < 0)
                i_0_ = 0;
            else if(i_0_ > anInt1824)
                i_0_ = anInt1824;
            anInt1827 = anInt1831 - 256 - i_0_;
            if(anInt1827 < 256)
                anInt1827 = 256;
            if(anInt1831 < 16384) {
                if(i >= anInt1831) {
                    anInt1823 += 5;
                    if(anInt1823 >= 100) {
                        method225();
                        anInt1831 += 2048;
                        aLong1821 = arg0;
                        return;
                    }
                } else if(i != anInt1830 && anInt1823 > 0)
                    anInt1823--;
            }
            anInt1830 = i;
            if(i < anInt1827)
                break;
            Class8.method215(anIntArray1829, 256);
            try {
                method223();
            } catch(Exception exception) {
                method225();
                aLong1821 = arg0;
                return;
            }
            aLong1826 = arg0;
            anInt1830 -= 256;
        }
        if(arg0 >= aLong1826 + 5000L) {
            method225();
            aLong1821 = arg0;
            for(int i = 0; i < 512; i++)
                anIntArray1833[i] = 0;
            anInt1822 = anInt1824 = anInt1828 = 0;
        }
    }

    public void method222(Signlink arg0, int arg1) throws Exception {
        anInt1831 = arg1;
        method219(System.currentTimeMillis());
        arg0.method394(10, 0, this);
    }

    public void method213() {
        synchronized(this) {
            aBoolean1820 = true;
        }
        for(; ; ) {
            synchronized(this) {
                if(!aBoolean1820)
                    break;
            }
            Class43.method890(50L, 48);
        }
    }

    public abstract void method223() throws Exception;

    public void run() {

        for(; ; ) {
            synchronized(this) {
                if(aBoolean1820) {
                    if(aLong1821 == 0L)
                        method225();
                    aBoolean1820 = false;
                    break;
                }
                method212(System.currentTimeMillis());
            }
            Class43.method890(5L, -86);
        }
    }

    public abstract int method224() throws Exception;

    public abstract void method225();

    public abstract void method226(int i) throws Exception;

    public synchronized void method212(long arg0) {
        method221(arg0);
        if(aLong1832 < arg0)
            aLong1832 = arg0;
    }

    public void method227(int arg0) {
        int i = arg0 - anInt1827;
        int i_1_ = anIntArray1833[anInt1825];
        anIntArray1833[anInt1825] = i;
        anInt1828 += i - i_1_;
        int i_2_ = anInt1825 + 1 & 0x1ff;
        if(i > anInt1824)
            anInt1824 = i;
        if(i < anInt1822)
            anInt1822 = i;
        if(i_1_ == anInt1824) {
            int i_3_ = i;
            for(int i_4_ = i_2_; i_4_ != anInt1825 && i_3_ < anInt1824; i_4_ = i_4_ + 1 & 0x1ff) {
                int i_5_ = anIntArray1833[i_4_];
                if(i_5_ > i_3_)
                    i_3_ = i_5_;
            }
            anInt1824 = i_3_;
        }
        if(i_1_ == anInt1822) {
            int i_6_ = i;
            for(int i_7_ = i_2_; i_7_ != anInt1825 && i_6_ > anInt1822; i_7_ = i_7_ + 1 & 0x1ff) {
                int i_8_ = anIntArray1833[i_7_];
                if(i_8_ < i_6_)
                    i_6_ = i_8_;
            }
            anInt1822 = i_6_;
        }
        anInt1825 = i_2_;
    }
}
