package com.jagex.runescape.audio;

import com.jagex.runescape.io.Buffer;

public class Envelope {
    public int num_phases = 2;
    public int[] phase_dur;
    public int start;
    public int form;
    public int end;
    public int[] phase_peak;
    public int ticks;
    public int step;
    public int critical;
    public int phase_idx;
    public int amp;

    public Envelope() {
        phase_dur = new int[2];
        phase_peak = new int[2];
        phase_dur[0] = 0;
        phase_dur[1] = 65535;
        phase_peak[0] = 0;
        phase_peak[1] = 65535;
    }

    public void reset() {
        critical = 0;
        phase_idx = 0;
        step = 0;
        amp = 0;
        ticks = 0;
    }

    public void decode(Buffer buffer) {
        form = buffer.getUnsignedByte();
        start = buffer.getIntBE();
        end = buffer.getIntBE();
        decode_shape(buffer);
    }

    public void decode_shape(Buffer buffer) {
        num_phases = buffer.getUnsignedByte();
        phase_dur = new int[num_phases];
        phase_peak = new int[num_phases];
        for(int i = 0; i < num_phases; i++) {
            phase_dur[i] = buffer.getUnsignedShortBE();
            phase_peak[i] = buffer.getUnsignedShortBE();
        }
    }

    public int step(int period) {
        if(ticks >= critical) {
            amp = phase_peak[phase_idx++] << 15;
            if(phase_idx >= num_phases)
                phase_idx = num_phases - 1;
            critical = (int) (phase_dur[phase_idx] / 65536.0 * period);
            if(critical > ticks)
                step = (((phase_peak[phase_idx] << 15) - amp) / (critical - ticks));
        }
        amp += step;
        ticks++;
        return amp - step >> 15;
    }
}
