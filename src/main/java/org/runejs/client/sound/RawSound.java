package org.runejs.client.sound;

public class RawSound extends AbstractSound {
    public byte[] samples;
    public int start;
    public int end;
    public int sampleRate;

    public RawSound(int arg0, byte[] arg1, int arg2, int arg3) {
        sampleRate = arg0;
        samples = arg1;
        start = arg2;
        end = arg3;
    }

}
