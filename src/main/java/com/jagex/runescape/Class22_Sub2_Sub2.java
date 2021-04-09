package com.jagex.runescape;

import com.jagex.runescape.audio.MidiFileReader;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.util.Signlink;

public class Class22_Sub2_Sub2 extends Class22_Sub2 implements Runnable {
    public static Runnable_Impl1 aRunnable_Impl1_2223;
    public static boolean aBoolean2224;
    public static MidiFileReader aMidiFileReader_2225 = new MidiFileReader();
    public static int anInt2226;
    public static int[] anIntArray2227 = new int[256];
    public static boolean aBoolean2228;
    public static int anInt2229;

    public Class22_Sub2_Sub2(Signlink arg0, Runnable_Impl1 arg1) {

        aRunnable_Impl1_2223 = arg1;
        aRunnable_Impl1_2223.method3(25832);
        aRunnable_Impl1_2223.method6(116);
        this.method321((byte) 109, (long) anInt2226);
        aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
        anInt2229 = 0;
        arg0.method394(10, 0, this);
    }

    public static void method325() {
        if(anInt2229 > 0) {
            aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
            anInt2229 = 0;
        }
    }

    public static void method326(int arg0, byte arg1, int arg2, int arg3, int arg4) {

        if(arg1 > -44) {
            method325();
        }
        if(anIntArray2227.length <= anInt2229) {
            aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
            anInt2229 = 0;
        }
        anIntArray2227[anInt2229++] = -anInt2226 + arg3;
        anInt2226 = arg3;
        anIntArray2227[anInt2229++] = UnderlayDefinition.bitWiseOR(
                UnderlayDefinition.bitWiseOR(arg4, arg0 << 8), arg2 << 16);

    }

    public synchronized void method302(int arg0) {

        if(aMidiFileReader_2225.isReady()) {
            if(arg0 != 0) {
                aBoolean2224 = false;
            }
            long l = (long) (200 + anInt2226 + -aRunnable_Impl1_2223.method5(14942)) *
                    (long) (aMidiFileReader_2225.division * 1000);
            for(; ; ) {
                int i = aMidiFileReader_2225.getPrioritizedTrack();
                int i_0_ = aMidiFileReader_2225.trackLengths[i];
                long l_1_ = aMidiFileReader_2225.method251(i_0_);
                if(l < l_1_) {
                    break;
                }
                while(i_0_ == aMidiFileReader_2225.trackLengths[i]) {
                    aMidiFileReader_2225.gotoTrack(i);
                    method324(l_1_, i);
                    if(aMidiFileReader_2225.method258()) {
                        aMidiFileReader_2225.markTrackPosition(i);
                        if(aMidiFileReader_2225.isDone()) {
                            if(aBoolean2228) {
                                aMidiFileReader_2225.reset(l_1_);
                            } else {
                                this.method321((byte) 110,
                                        (long) (int) (l_1_ / (long) (aMidiFileReader_2225.division * 1000))
                                );
                                aMidiFileReader_2225.clear();
                                method325();
                                return;
                            }
                        }
                        break;
                    }
                    aMidiFileReader_2225.readTrackLength(i);
                    aMidiFileReader_2225.markTrackPosition(i);
                }
            }
            method325();
        }

    }

    public void method324(long arg0, int arg2) {
        int i_2_ = aMidiFileReader_2225.readMessage(arg2);
        if(i_2_ == 1) {
            aMidiFileReader_2225.setTrackDone();
        } else if((i_2_ & 0x80) != 0) {
            int i_3_ = (int) (arg0 / (long) (1000 * aMidiFileReader_2225.division));
            int i_4_ = i_2_ & 0xff;
            int i_5_ = (0xffa8 & i_2_) >> 8;
            int i_6_ = (i_2_ & 0xffb86b) >> 16;
            if(!this.method322(i_4_, i_5_, i_6_, (long) i_3_)) {
                method326(i_5_, (byte) -72, i_6_, i_3_, i_4_);
            }
        }
    }

    public void run() {

        try {
            for(; ; ) {
                synchronized(this) {
                    if(aBoolean2224) {
                        aBoolean2224 = false;
                        break;
                    }
                    method302(0);
                }
                Class43.sleep(100L);
            }
        } catch(Exception exception) {
            MovedStatics.method169(null, (byte) -127, exception);
        }

    }

    public void method306(byte arg0) {

        synchronized(this) {
            aBoolean2224 = true;
        }
        for(; ; ) {
            synchronized(this) {
                if(!aBoolean2224) {
                    break;
                }
            }
            Class43.sleep(20L);
        }
        if(arg0 >= 100) {
            aRunnable_Impl1_2223.method4(26534);
        }

    }

    public synchronized void method300(byte[] arg0, boolean arg1, int arg2, int arg3) {

        if(arg2 != -15910) {
            aMidiFileReader_2225 = null;
        }
        boolean bool = true;
        aMidiFileReader_2225.parse(arg0);
        anInt2226 = 0;
        aBoolean2228 = arg1;
        aRunnable_Impl1_2223.method6(-26);
        this.method317(arg3, 0, (long) anInt2226, 0);
        int i = aMidiFileReader_2225.trackCount();
        for(int i_7_ = 0; i_7_ < i; i_7_++) {
            aMidiFileReader_2225.gotoTrack(i_7_);
            while(!aMidiFileReader_2225.method258()) {
                aMidiFileReader_2225.readTrackLength(i_7_);
                if(aMidiFileReader_2225.trackLengths[i_7_] != 0) {
                    bool = false;
                    break;
                }
                method324(0L, i_7_);
            }
            aMidiFileReader_2225.markTrackPosition(i_7_);
        }
        if(bool) {
            if(aBoolean2228) {
                throw new RuntimeException();
            }
            this.method321((byte) 127, (long) anInt2226);
            aMidiFileReader_2225.clear();
        }
        method325();

    }

    public synchronized void method301(int arg0, int arg1) {

        this.method318(-115, (long) anInt2226, arg0);
        aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
        anInt2229 = arg1;

    }

    public void method314(int arg0, int arg1, int arg2, long arg3) {

        method326(arg1, (byte) -102, arg2, (int) arg3, arg0);

    }

    public synchronized void method304(byte arg0, int arg1, int arg2) {
        this.method317(arg1, arg2, (long) anInt2226, 0);
        if(arg0 >= -82) {
            method302(50);
        }
    }

    public synchronized void method303(byte arg0) {

        aRunnable_Impl1_2223.method6(-21);
        this.method321((byte) 115, (long) anInt2226);
        aRunnable_Impl1_2223.method2(anIntArray2227, anInt2229);
        anInt2229 = 0;
        if(arg0 != -96) {
            aBoolean2228 = false;
        }
        aMidiFileReader_2225.clear();

    }
}
