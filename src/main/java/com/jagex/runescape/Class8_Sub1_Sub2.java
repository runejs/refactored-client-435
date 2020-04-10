package com.jagex.runescape;

import javax.sound.sampled.*;

public class Class8_Sub1_Sub2 extends Class8_Sub1 {
    public static Class aClass2219;
    public SourceDataLine sound;
    public AudioFormat audioFormat;
    public byte[] aByteArray2218 = new byte[512];

    public Class8_Sub1_Sub2() throws Exception {
        super(22050);
        audioFormat = new AudioFormat(22050.0F, 16, 1, true, false);
    }

    public static Class method229(String arg0) {
        Class var_class;
        try {
            var_class = Class.forName(arg0);
        } catch(ClassNotFoundException classnotfoundexception) {
            return null;
        }
        return var_class;
    }

    public void method226(int arg0) throws LineUnavailableException {
        try {
            DataLine.Info info = (new DataLine.Info((aClass2219 == null ? (aClass2219 = method229("javax.sound.sampled.SourceDataLine")) : aClass2219), audioFormat, arg0 * 2));
            sound = (SourceDataLine) AudioSystem.getLine(info);
            sound.open();
            sound.start();
        } catch(LineUnavailableException lineunavailableexception) {
            sound = null;
            throw lineunavailableexception;
        }
    }

    public int method224() {
        int i;
        try {
            i = sound.available() >> 1;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
        return i;
    }

    public void method223() {
        for(int i = 0; i < 256; i++) {
            int i_0_ = anIntArray1829[i];
            if((i_0_ + 8388608 & ~0xffffff) != 0)
                i_0_ = 0x7fffff ^ i_0_ >> 31;
            aByteArray2218[i * 2] = (byte) (i_0_ >> 8);
            aByteArray2218[i * 2 + 1] = (byte) (i_0_ >> 16);
        }
        sound.write(aByteArray2218, 0, 512);
    }

    public void method225() {
        if(sound != null) {
            sound.close();
            sound = null;
        }
    }
}
