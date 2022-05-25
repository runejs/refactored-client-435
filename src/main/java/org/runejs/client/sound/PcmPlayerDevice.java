package org.runejs.client.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class PcmPlayerDevice extends PcmPlayer {
    public SourceDataLine line;
    public AudioFormat audioFormat;
    public byte[] byteSamples = new byte[512];

    public PcmPlayerDevice() throws Exception {
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
            int ampl = PcmPlayer.samples[i];
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
