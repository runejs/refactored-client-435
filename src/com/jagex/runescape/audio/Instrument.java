package com.jagex.runescape.audio;

import com.jagex.runescape.io.Buffer;

import java.util.Random;

public class Instrument {
    public static int[] sine;
    public static int[] output;
    public static int[] noise = new int[32768];
    public static int[] vol_step = new int[5];
    public static int[] pitch_step = new int[5];
    public static int[] delays = new int[5];
    public static int[] pitch_base_step = new int[5];
    public static int[] phases = new int[5];

    static {
        Random random = new Random(0L);
        for(int i = 0; i < 32768; i++)
            noise[i] = (random.nextInt() & 0x2) - 1;
        sine = new int[32768];
        for(int i = 0; i < 32768; i++)
            sine[i] = (int) (Math.sin(i / 5215.1903) * 16384.0);
        output = new int[220500];
    }

    public Filter filter;
    public int begin;
    public int delay_time = 0;
    public int[] oscill_pitch_delta;
    public Envelope gating_attack_env;
    public Envelope vol_mod_amp_env;
    public int[] oscill_delay;
    public Envelope pitch_mod_env;
    public int[] oscill_vol;
    public int delay_feedback;
    public Envelope filter_env;
    public Envelope pitch_env;
    public Envelope vol_mod_env;
    public Envelope vol_env;
    public int duration;
    public Envelope gating_release_env;
    public Envelope pitch_mod_amp_env;

    public Instrument() {
        oscill_vol = new int[5];
        duration = 500;
        oscill_delay = new int[5];
        oscill_pitch_delta = new int[5];
        begin = 0;
        delay_feedback = 100;
    }

    public static void initialize() {
        output = null;
        noise = null;
        sine = null;
        phases = null;
        delays = null;
        vol_step = null;
        pitch_step = null;
        pitch_base_step = null;
    }

    public void decode(Buffer buffer) {
        pitch_env = new Envelope();
        pitch_env.decode(buffer);
        vol_env = new Envelope();
        vol_env.decode(buffer);
        int option = buffer.getUnsignedByte();
        if(option != 0) {
            buffer.currentPosition--;
            pitch_mod_env = new Envelope();
            pitch_mod_env.decode(buffer);
            pitch_mod_amp_env = new Envelope();
            pitch_mod_amp_env.decode(buffer);
        }
        option = buffer.getUnsignedByte();
        if(option != 0) {
            buffer.currentPosition--;
            vol_mod_env = new Envelope();
            vol_mod_env.decode(buffer);
            vol_mod_amp_env = new Envelope();
            vol_mod_amp_env.decode(buffer);
        }
        option = buffer.getUnsignedByte();
        if(option != 0) {
            buffer.currentPosition--;
            gating_release_env = new Envelope();
            gating_release_env.decode(buffer);
            gating_attack_env = new Envelope();
            gating_attack_env.decode(buffer);
        }
        for(int i_0_ = 0; i_0_ < 10; i_0_++) {
            int i_1_ = buffer.getSmart();
            if(i_1_ == 0) {
                break;
            }
            oscill_vol[i_0_] = i_1_;
            oscill_pitch_delta[i_0_] = buffer.getUnsignedSmart();
            oscill_delay[i_0_] = buffer.getSmart();
        }
        delay_time = buffer.getSmart();
        delay_feedback = buffer.getSmart();
        duration = buffer.getUnsignedShortBE();
        begin = buffer.getUnsignedShortBE();
        filter = new Filter();
        filter_env = new Envelope();
        filter.decode(buffer, filter_env);
    }

    public int evaluateWave(int phase, int amplitude, int table) {
        if(table == 1) {
            if((phase & 0x7fff) < 16384) {
                return amplitude;
            }
            return -amplitude;
        }
        if(table == 2) {
            return sine[phase & 0x7fff] * amplitude >> 14;
        }
        if(table == 3) {
            return ((phase & 0x7fff) * amplitude >> 14) - amplitude;
        }
        if(table == 4) {
            return noise[phase / 2607 & 0x7fff] * amplitude;
        }
        return 0;
    }

    public static void method776(int[] arg0, int arg1, int arg2) {
        arg2 = arg1 + arg2 - 7;
        while(arg1 < arg2) {
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
            arg0[arg1++] = 0;
        }
        arg2 += 7;
        while(arg1 < arg2)
            arg0[arg1++] = 0;
    }

    public int[] synthesize(int n_s, int dt) {
        method776(output, 0, n_s);
        if(dt < 10) {
            return output;
        }
        double f_s = n_s / (dt + 0.0);
        pitch_env.reset();
        vol_env.reset();
        int pitch_mod_step = 0;
        int pitch_mod_base_step = 0;
        int pitch_mod_phase = 0;
        if(pitch_mod_env != null) {
            pitch_mod_env.reset();
            pitch_mod_amp_env.reset();
            pitch_mod_step = (int) ((pitch_mod_env.end - pitch_mod_env.start) * 32.768 / f_s);
            pitch_mod_base_step = (int) (pitch_mod_env.start * 32.768 / f_s);
        }
        int vol_mod_step = 0;
        int vol_mod_base_step = 0;
        int vol_mod_phase = 0;
        if(vol_mod_env != null) {
            vol_mod_env.reset();
            vol_mod_amp_env.reset();
            vol_mod_step = (int) ((vol_mod_env.end - vol_mod_env.start) * 32.768 / f_s);
            vol_mod_base_step = (int) (vol_mod_env.start * 32.768 / f_s);
        }
        for(int j2 = 0; j2 < 5; j2++) {
            if(oscill_vol[j2] != 0) {
                phases[j2] = 0;
                delays[j2] = (int) (oscill_delay[j2] * f_s);
                vol_step[j2] = (oscill_vol[j2] << 14) / 100;
                pitch_step[j2] = (int) ((pitch_env.end - pitch_env.start) * 32.768 * Math.pow(1.0057929410678534, oscill_pitch_delta[j2]) / f_s);
                pitch_base_step[j2] = (int) (pitch_env.start * 32.768 / f_s);
            }
        }
        for(int i_8_ = 0; i_8_ < n_s; i_8_++) {
            int pitch_change = pitch_env.step(n_s);
            int vol_change = vol_env.step(n_s);
            if(pitch_mod_env != null) {
                int mod = pitch_mod_env.step(n_s);
                int mod_amp = pitch_mod_amp_env.step(n_s);
                pitch_change += evaluateWave(pitch_mod_phase, mod_amp, pitch_mod_env.form) >> 1;
                pitch_mod_phase += (mod * pitch_mod_step >> 16) + pitch_mod_base_step;
            }
            if(vol_mod_env != null) {
                int mod = vol_mod_env.step(n_s);
                int mod_amp = vol_mod_amp_env.step(n_s);
                vol_change = vol_change * ((evaluateWave(vol_mod_phase, mod_amp, vol_mod_env.form) >> 1) + 32768) >> 15;
                vol_mod_phase += (mod * vol_mod_step >> 16) + vol_mod_base_step;
            }
            for(int l5 = 0; l5 < 5; l5++) {
                if(oscill_vol[l5] != 0) {
                    int l6 = i_8_ + delays[l5];
                    if(l6 < n_s) {
                        output[l6] += evaluateWave(phases[l5], vol_change * vol_step[l5] >> 15, pitch_env.form);
                        phases[l5] += ((pitch_change * pitch_step[l5] >> 16) + pitch_base_step[l5]);
                    }
                }
            }
        }
        /* gating effect */
        if(gating_release_env != null) {
            gating_release_env.reset();
            gating_attack_env.reset();
            int counter = 0;
            boolean muted = true;
            for(int i7 = 0; i7 < n_s; i7++) {
                int on_step = gating_release_env.step(n_s);
                int off_step = gating_attack_env.step(n_s);
                int threshold;
                if(muted) {
                    threshold = gating_release_env.start + (((gating_release_env.end - gating_release_env.start) * on_step) >> 8);
                } else {
                    threshold = gating_release_env.start + (((gating_release_env.end - gating_release_env.start) * off_step) >> 8);
                }
                counter += 256;
                if(counter >= threshold) {
                    counter = 0;
                    muted = !muted;
                }
                if(muted) {
                    output[i7] = 0;
                }
            }
        }
        /* delay effect */
        if(delay_time > 0 && delay_feedback > 0) {
            int delay = (int) (delay_time * f_s);
            for(int i_24_ = delay; i_24_ < n_s; i_24_++) {
                output[i_24_] += output[i_24_ - delay] * delay_feedback / 100;
            }
        }
        /* filter */
        if(filter.num_pairs[0] > 0 || filter.num_pairs[1] > 0) {
            filter_env.reset();
            int t = filter_env.step(n_s + 1);
            int M = filter.compute(0, t / 65536.0F);
            int N = filter.compute(1, t / 65536.0F);
            if(n_s >= M + N) {
                int n = 0;
                int delay = N;
                if(delay > n_s - M) {
                    delay = n_s - M;
                }
                for(/**/; n < delay; n++) {
                    int i_30_ = (int) (((long) output[n + M] * (long) Filter.inv_unity) >> 16);
                    for(int i_31_ = 0; i_31_ < M; i_31_++) {
                        i_30_ += (int) (((long) (output[n + M - 1 - i_31_]) * (long) (Filter.coef[0][i_31_])) >> 16);
                    }
                    for(int i_32_ = 0; i_32_ < n; i_32_++) {
                        i_30_ -= (int) (((long) output[n - 1 - i_32_] * (long) (Filter.coef[1][i_32_])) >> 16);
                    }
                    output[n] = i_30_;
                    t = filter_env.step(n_s + 1);
                }
                delay = 128;
                for(; ; ) {
                    if(delay > n_s - M) {
                        delay = n_s - M;
                    }
                    for(/**/; n < delay; n++) {
                        int i_33_ = (int) (((long) output[n + M] * (long) Filter.inv_unity) >> 16);
                        for(int i_34_ = 0; i_34_ < M; i_34_++) {
                            i_33_ += (int) (((long) (output[n + M - 1 - i_34_]) * (long) (Filter.coef[0][i_34_])) >> 16);
                        }
                        for(int i_35_ = 0; i_35_ < N; i_35_++) {
                            i_33_ -= (int) (((long) (output[n - 1 - i_35_]) * (long) (Filter.coef[1][i_35_])) >> 16);
                        }
                        output[n] = i_33_;
                        t = filter_env.step(n_s + 1);
                    }
                    if(n >= n_s - M) {
                        break;
                    }
                    M = filter.compute(0, t / 65536.0F);
                    N = filter.compute(1, t / 65536.0F);
                    delay += 128;
                }
                for(/**/; n < n_s; n++) {
                    int y = 0;
                    for(int i_37_ = n + M - n_s; i_37_ < M; i_37_++) {
                        y += (int) (((long) (output[n + M - 1 - i_37_]) * (long) (Filter.coef[0][i_37_])) >> 16);
                    }
                    for(int i_38_ = 0; i_38_ < N; i_38_++) {
                        y -= (int) (((long) output[n - 1 - i_38_] * (long) (Filter.coef[1][i_38_])) >> 16);
                    }
                    output[n] = y;
                    t = filter_env.step(n_s + 1);
                }
            }
        }
        /* clamp */
        for(int i_39_ = 0; i_39_ < n_s; i_39_++) {
            if(output[i_39_] < -32768) {
                output[i_39_] = -32768;
            }
            if(output[i_39_] > 32767) {
                output[i_39_] = 32767;
            }
        }
        return output;
    }
}
