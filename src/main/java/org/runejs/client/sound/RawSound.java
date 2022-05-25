package org.runejs.client.sound;

public class RawSound extends AbstractSound {
    public byte[] samples;
    public int start;
    public int end;
    public int sampleRate;

    public RawSound(int sampleRate, byte[] samples, int start, int end) {
        this.sampleRate = sampleRate;
        this.samples = samples;
        this.start = start;
        this.end = end;
    }

}
