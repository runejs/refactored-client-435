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

    public RawSound resample(Decimator decimator) {
        samples = decimator.resample(samples);
        sampleRate = decimator.scaleRate(sampleRate);
        if(start == end)
            start = end = decimator.scalePosition(start);
        else {
            start = decimator.scalePosition(start);
            end = decimator.scalePosition(end);
            if(start == end)
                start--;
        }
        return this;
    }
}
