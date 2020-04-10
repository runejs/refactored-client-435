package com.jagex.runescape;

public class Class40_Sub12_Sub1 extends Class40_Sub12 {
    public byte[] aByteArray2889;
    public int anInt2890;
    public int anInt2891;
    public int anInt2892;

    public Class40_Sub12_Sub1(int arg0, byte[] arg1, int arg2, int arg3) {
        anInt2892 = arg0;
        aByteArray2889 = arg1;
        anInt2890 = arg2;
        anInt2891 = arg3;
    }

    public Class40_Sub12_Sub1 method875(Class48 arg0) {
        aByteArray2889 = arg0.method926(aByteArray2889, false);
        anInt2892 = arg0.method923(anInt2892, 4);
        if(anInt2890 == anInt2891)
            anInt2890 = anInt2891 = arg0.method921(anInt2890, 54);
        else {
            anInt2890 = arg0.method921(anInt2890, 54);
            anInt2891 = arg0.method921(anInt2891, 54);
            if(anInt2890 == anInt2891)
                anInt2890--;
        }
        return this;
    }
}
