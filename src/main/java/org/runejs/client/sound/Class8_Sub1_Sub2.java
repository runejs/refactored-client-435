package org.runejs.client.sound;

import javax.sound.sampled.*;

public class Class8_Sub1_Sub2 extends Class8_Sub1 {
    public SourceDataLine line;
    public AudioFormat audioFormat;
    public byte[] byteSamples = new byte[512];

    public Class8_Sub1_Sub2() throws Exception {
        super(22050);
        audioFormat = new AudioFormat(22050.0F, 16, 1, true, false);
    }

    public void open(int arg0) throws LineUnavailableException {
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

    public int avail() {
        int i;
        try {
            i = line.available() >> 1;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
        return i;
    }

    public void write() {
        for(int i = 0; i < 256; i++) {
            int ampl = Class8_Sub1.samples[i];
            if((ampl + 8388608 & ~0xffffff) != 0)
                ampl = 0x7fffff ^ ampl >> 31;
            byteSamples[i * 2] = (byte) (ampl >> 8);
            byteSamples[i * 2 + 1] = (byte) (ampl >> 16);
        }
        line.write(byteSamples, 0, 512);
    }

    public void close() {
        if(line != null) {
            line.close();
            line = null;
        }
    }
}
