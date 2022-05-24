package org.runejs.client.sound;

public class Class8 {
    public Class8(int arg0) {
        StaticAudio.sampleRate = arg0;
        StaticAudio.aLong288 = System.currentTimeMillis();
    }

    public static synchronized void method215(int[] arg0, int arg1) {
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
        if(StaticAudio.aPcmStream_608 != null)
            StaticAudio.aPcmStream_608.fill(arg0, 0, arg1);
        StaticAudio.method748(arg1);
    }


    public static synchronized void method217(int arg0) {
        if(StaticAudio.aPcmStream_608 != null)
            StaticAudio.aPcmStream_608.skip(arg0);
        StaticAudio.method748(arg0);
    }

    public static synchronized void method218(PcmStream arg0) {
        StaticAudio.aPcmStream_608 = arg0;
    }

    public void method212(long arg0) {
    }

    public void method213() {
    }
}
