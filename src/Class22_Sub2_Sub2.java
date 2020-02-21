/* Class22_Sub2_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class22_Sub2_Sub2 extends Class22_Sub2 implements Runnable {
    public static Runnable_Impl1 aRunnable_Impl1_2223;
    public static boolean aBoolean2224;
    public static Class14 aClass14_2225 = new Class14();
    public static int anInt2226;
    public static int[] anIntArray2227 = new int[256];
    public static boolean aBoolean2228;
    public static int anInt2229;

    public Class22_Sub2_Sub2(Signlink arg0, Runnable_Impl1 arg1) {
        try {
            aRunnable_Impl1_2223 = arg1;
            aRunnable_Impl1_2223.method3(25832);
            aRunnable_Impl1_2223.method6(116);
            this.method321((byte) 109, (long) anInt2226);
            aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
            anInt2229 = 0;
            arg0.method394(10, 0, this);
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public static void method325(byte arg0) {
        int i = 16 % ((arg0 - -32) / 60);
        if(anInt2229 > 0) {
            aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
            anInt2229 = 0;
        }
    }

    public static void method326(int arg0, byte arg1, int arg2, int arg3, int arg4) {
        try {
            if(arg1 > -44)
                method325((byte) 22);
            if(anIntArray2227.length <= anInt2229) {
                aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
                anInt2229 = 0;
            }
            anIntArray2227[anInt2229++] = -anInt2226 + arg3;
            anInt2226 = arg3;
            anIntArray2227[anInt2229++] = (Class40_Sub5_Sub9.method619(Class40_Sub5_Sub9.method619(arg4, arg0 << -777037144), arg2 << -1978505296));
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public synchronized void method302(int arg0) {
        try {
            if(aClass14_2225.method257()) {
                if(arg0 != 0)
                    aBoolean2224 = false;
                long l = ((long) (200 + anInt2226 + -aRunnable_Impl1_2223.method5(14942)) * (long) (aClass14_2225.anInt431 * 1000));
                for(; ; ) {
                    int i = aClass14_2225.method250();
                    int i_0_ = aClass14_2225.anIntArray427[i];
                    long l_1_ = aClass14_2225.method251(i_0_);
                    if((l_1_ ^ 0xffffffffffffffffL) < (l ^ 0xffffffffffffffffL))
                        break;
                    while(i_0_ == aClass14_2225.anIntArray427[i]) {
                        aClass14_2225.method265(i);
                        method324(l_1_, (byte) 103, i);
                        if(aClass14_2225.method258()) {
                            aClass14_2225.method260(i);
                            if(aClass14_2225.method263()) {
                                if(aBoolean2228)
                                    aClass14_2225.method259(l_1_);
                                else {
                                    this.method321((byte) 110, (long) (int) (l_1_ / (long) ((aClass14_2225.anInt431) * 1000)));
                                    aClass14_2225.method255();
                                    method325((byte) -118);
                                    return;
                                }
                            }
                            break;
                        }
                        aClass14_2225.method254(i);
                        aClass14_2225.method260(i);
                    }
                }
                method325((byte) 95);
            }
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public void method324(long arg0, byte arg1, int arg2) {
        int i = 31 % ((arg1 - 32) / 38);
        int i_2_ = aClass14_2225.method252(arg2);
        if(i_2_ == 1)
            aClass14_2225.method264();
        else if((i_2_ & 0x80 ^ 0xffffffff) != -1) {
            int i_3_ = (int) (arg0 / (long) (1000 * aClass14_2225.anInt431));
            int i_4_ = i_2_ & 0xff;
            int i_5_ = (0xffa8 & i_2_) >> 291798792;
            int i_6_ = (i_2_ & 0xffb86b) >> -830248528;
            if(!this.method322(i_4_, i_5_, i_6_, (long) i_3_))
                method326(i_5_, (byte) -72, i_6_, i_3_, i_4_);
        }
    }

    public void run() {
        try {
            try {
                for(; ; ) {
                    synchronized(this) {
                        if(aBoolean2224) {
                            aBoolean2224 = false;
                            break;
                        }
                        method302(0);
                    }
                    Class43.method890(100L, -75);
                }
            } catch(Exception exception) {
                Class6.method169(null, (byte) -127, exception);
            }
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public void method306(byte arg0) {
        try {
            synchronized(this) {
                aBoolean2224 = true;
            }
            for(; ; ) {
                synchronized(this) {
                    if(!aBoolean2224)
                        break;
                }
                Class43.method890(20L, 45);
            }
            if(arg0 >= 100)
                aRunnable_Impl1_2223.method4(26534);
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public synchronized void method300(byte[] arg0, boolean arg1, int arg2, int arg3) {
        try {
            if(arg2 != -15910)
                aClass14_2225 = null;
            boolean bool = true;
            aClass14_2225.method256(arg0);
            anInt2226 = 0;
            aBoolean2228 = arg1;
            aRunnable_Impl1_2223.method6(-26);
            this.method317(arg3, 0, (long) anInt2226, 0);
            int i = aClass14_2225.method253();
            for(int i_7_ = 0; (i_7_ ^ 0xffffffff) > (i ^ 0xffffffff); i_7_++) {
                aClass14_2225.method265(i_7_);
                while(!aClass14_2225.method258()) {
                    aClass14_2225.method254(i_7_);
                    if(aClass14_2225.anIntArray427[i_7_] != 0) {
                        bool = false;
                        break;
                    }
                    method324(0L, (byte) 74, i_7_);
                }
                aClass14_2225.method260(i_7_);
            }
            if(bool) {
                if(aBoolean2228)
                    throw new RuntimeException();
                this.method321((byte) 127, (long) anInt2226);
                aClass14_2225.method255();
            }
            method325((byte) 50);
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public synchronized void method301(int arg0, int arg1) {
        try {
            this.method318(-115, (long) anInt2226, arg0);
            aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
            anInt2229 = arg1;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public void method314(int arg0, int arg1, int arg2, long arg3) {
        try {
            method326(arg1, (byte) -102, arg2, (int) arg3, arg0);
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }

    public synchronized void method304(byte arg0, int arg1, int arg2) {
        this.method317(arg1, arg2, (long) anInt2226, 0);
        if(arg0 >= -82)
            method302(50);
    }

    public synchronized void method303(byte arg0) {
        try {
            aRunnable_Impl1_2223.method6(-21);
            this.method321((byte) 115, (long) anInt2226);
            aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
            anInt2229 = 0;
            if(arg0 != -96)
                aBoolean2228 = false;
            aClass14_2225.method255();
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
    }
}
