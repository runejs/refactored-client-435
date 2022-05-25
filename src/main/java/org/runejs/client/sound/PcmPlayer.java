package org.runejs.client.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import org.runejs.client.Class43;
import org.runejs.client.util.Signlink;

public class PcmPlayer implements Runnable {
	    
    private static int[] samples = new int[256];
    private boolean aBoolean1820;
    private long aLong1821;
    private int anInt1822;
    private int anInt1823;
    private int anInt1824;
    private int anInt1825 = 0;
    private long aLong1826;
    private int anInt1827;
    private int anInt1828;
    private int anInt1830;
    private int anInt1831;
    private long aLong1832;
    private int[] anIntArray1833;
    private SourceDataLine line;
    
    private AudioFormat audioFormat;
    private byte[] byteSamples = new byte[512];
    
    public PcmPlayer() throws Exception {
        SoundSystem.timeMs = System.currentTimeMillis();
        aLong1821 = 0L;
        anInt1827 = 256;
        aBoolean1820 = false;
        anInt1828 = 0;
        anInt1822 = 0;
        anInt1824 = 0;
        anIntArray1833 = new int[512];
        audioFormat = new AudioFormat(22050.0F, 16, 1, true, false);

    }

    private void method219(long arg0) throws Exception {
        open(anInt1831);
        for(; ; ) {
            int i = avail();
            if(i < anInt1827)
                break;
            write();
        }
        anInt1823 = 0;
        anInt1830 = 0;
        aLong1832 = arg0;
        aLong1826 = arg0;
    }

    private void method221(long arg0) {
        if(aLong1821 != 0L) {
            for(/**/; aLong1832 < arg0; aLong1832 += (long) (256000 / SoundSystem.SAMPLE_RATE))
                method217(256);
            if(arg0 < aLong1821)
                return;
            try {
                method219(arg0);
            } catch(Exception exception) {
                close();
                aLong1821 += 5000L;
                return;
            }
            aLong1821 = 0L;
        }
        while(aLong1832 < arg0) {
            aLong1832 += (long) (250880 / SoundSystem.SAMPLE_RATE);
            int i;
            try {
                i = avail();
            } catch(Exception exception) {
                close();
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
                        close();
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
            method215(samples, 256);
            try {
                write();
            } catch(Exception exception) {
                close();
                aLong1821 = arg0;
                return;
            }
            aLong1826 = arg0;
            anInt1830 -= 256;
        }
        if(arg0 >= aLong1826 + 5000L) {
            close();
            aLong1821 = arg0;
            for(int i = 0; i < 512; i++)
                anIntArray1833[i] = 0;
            anInt1822 = anInt1824 = anInt1828 = 0;
        }
    }

    public void method222(Signlink arg0, int arg1) throws Exception {
        anInt1831 = arg1;
        method219(System.currentTimeMillis());
        arg0.createThreadNode(10, this);
    }

    public void stop() {
        synchronized(this) {
            aBoolean1820 = true;
        }
        for(; ; ) {
            synchronized(this) {
                if(!aBoolean1820)
                    break;
            }
            Class43.threadSleep(50L);
        }
    }

    private void write() {
        for(int i = 0; i < 256; i++) {
            int ampl = PcmPlayer.samples[i];
            if((ampl + 8388608 & ~0xffffff) != 0)
                ampl = 0x7fffff ^ ampl >> 31;
            byteSamples[i * 2] = (byte) (ampl >> 8);
            byteSamples[i * 2 + 1] = (byte) (ampl >> 16);
        }
        line.write(byteSamples, 0, 512);
    }
    
    public void run() {

        for(; ; ) {
            synchronized(this) {
                if(aBoolean1820) {
                    if(aLong1821 == 0L)
                        close();
                    aBoolean1820 = false;
                    break;
                }
                method212(System.currentTimeMillis());
            }
            Class43.threadSleep(5L);
        }
    }

    private int avail() {
        int i;
        try {
            i = line.available() >> 1;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
        return i;
    }

    private void close() {
        if(line != null) {
            line.close();
            line = null;
        }
    }
    
    private void open(int arg0) throws LineUnavailableException {
        try {
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat, arg0 * 2);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open();
            line.start();
        } catch(LineUnavailableException lineunavailableexception) {
            line = null;
            throw lineunavailableexception;
        }
    }

    public synchronized void method212(long arg0) {
        method221(arg0);
        if(aLong1832 < arg0)
            aLong1832 = arg0;
    }

    private void method227(int arg0) {
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
    
    private static synchronized void method215(int[] arg0, int arg1) {
        int i = 0;
        arg1 -= 7;
        while(i < arg1) {
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
        }
        arg1 += 7;
        while(i < arg1)
            arg0[i++] = 0;
        if(PcmPlayer.pcmStream != null)
            PcmPlayer.pcmStream.fill(arg0, 0, arg1);
        method748(arg1);
    }


    private static synchronized void method217(int arg0) {
        if(PcmPlayer.pcmStream != null)
            PcmPlayer.pcmStream.skip(arg0);
        method748(arg0);
    }

	private static void method748(int arg1) {
		for (PcmPlayer.anInt2866 += arg1; PcmPlayer.anInt2866 >= SoundSystem.SAMPLE_RATE; PcmPlayer.anInt2866 -= SoundSystem.SAMPLE_RATE) {
			PcmPlayer.anInt2081 -= PcmPlayer.anInt2081 >> 2;
		}
		PcmPlayer.anInt2081 -= 1000 * arg1;
		if (PcmPlayer.anInt2081 < 0) {
			PcmPlayer.anInt2081 = 0;
		}
	}
	
	private static int anInt2866;
	private static int anInt2081;

	public static void handle(int i) {
		PcmPlayer.anInt2081 += SoundSystem.SAMPLE_RATE * i;
		int i_0_ = (-(2000 * SoundSystem.SAMPLE_RATE) + PcmPlayer.anInt2081) / 1000;
		if (i_0_ > 0) {
			if (PcmPlayer.pcmStream != null)
				PcmPlayer.pcmStream.skip(i_0_);
			PcmPlayer.anInt2081 -= i_0_ * 1000;
		}
	}

	static synchronized void setMixer(PcmStream arg0) {
		PcmPlayer.pcmStream = arg0;
	}
	
	private static PcmStream pcmStream;

}
