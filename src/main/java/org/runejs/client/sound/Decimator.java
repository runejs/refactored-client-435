package org.runejs.client.sound;

/**
 * Audio class. Used for Downsampling audio for the PCM stream. from what I can tell it uses a Hamming Window algorithm for a FIR filter and Linear Interpolation for the Resampling.
 *
 */
public class Decimator {
	private int[][] table;
    private int inputRate;
    private int outputRate;

    public Decimator(int inputRate, int outputRate) {

        int scale = scale(outputRate, inputRate);
        inputRate /= scale;
        this.inputRate = inputRate;
        outputRate /= scale;
        this.outputRate = outputRate;
        if(outputRate != inputRate) {
            this.table = new int[inputRate][14];
            for(int i_25_ = 0; i_25_ < inputRate; i_25_++) {
                int[] is = this.table[i_25_];
                double d = (double) i_25_ / (double) inputRate + 6.0;
                double d_26_ = (double) outputRate / (double) inputRate;
                int i_27_ = (int) Math.floor(-7.0 + d + 1.0);
                int i_28_ = (int) Math.ceil(7.0 + d);
                if(i_27_ < 0)
                    i_27_ = 0;
                if(i_28_ > 14)
                    i_28_ = 14;
                for(/**/; i_28_ > i_27_; i_27_++) {
                    double d_29_ = d_26_;
                    double d_30_ = 3.141592653589793 * (-d + i_27_);
                    if(d_30_ < -1.0E-4 || d_30_ > 1.0E-4)
                        d_29_ *= Math.sin(d_30_) / d_30_;
                    d_29_ *= 0.54 + 0.46 * Math.cos(0.2243994752564138 * (-d + i_27_));
                    is[i_27_] = (int) Math.floor(0.5 + d_29_ * 65536.0);
                }
            }
        }

    }

    public int scalePosition(int scale) {
        if(this.table != null)
            scale = 7 + this.outputRate * scale / this.inputRate;
        return scale;
    }

    public int scaleRate(int scale) {
        if(this.table != null)
            scale = this.outputRate * scale / this.inputRate;
        return scale;
    }

    public byte[] resample(byte[] samples) {
        if(this.table != null) {
            int newLength = 14 + samples.length * this.outputRate / this.inputRate;
            int o = 0;
            int[] dst = new int[newLength];
            int p = 0;
            for(int i = 0; i < samples.length; i++) {
                int sample = samples[i];
                int[] t = this.table[p];
                for(int v = 0; v < 14; v++)
                    dst[v + o] += t[v] * sample;
                p += this.outputRate;
                int r = p / this.inputRate;
                p -= r * this.inputRate;
                o += r;
            }
		    //Convert the interpolated downsampled code to a byte array for the PCM stream.
            samples = new byte[newLength];
            for(int i = 0; newLength > i; i++) {
                int v = 32768 + dst[i] >> 16;
                if(v >= -128) {
                    if(v > 127)
                        samples[i] = (byte) 127;
                    else
                        samples[i] = (byte) v;
                } else
                    samples[i] = (byte) -128;
            }
        }
        return samples;
    }

	private static int scale(int output, int input) {
	    if(output > input) {
	        int i = input;
	        input = output;
	        output = i;
	    }
	    ;
	    for(int i; output != 0; output = i) {
	        i = input % output;
	        input = output;
	    }
	    return input;
	}
}
