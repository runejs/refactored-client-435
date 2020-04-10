package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.GameObject;

public class EntryTable extends Node {
    public static int[] anIntArray2141;
    public int anInt2136;
    public int anInt2137;
    public int[] anIntArray2138;
    public int[] anIntArray2139;
    public int[] anIntArray2140;
    public int anInt2142;
    public boolean aBoolean2143;
    public int[] anIntArray2144;
    public int[] anIntArray2145;
    public boolean aBoolean2146 = false;

    public EntryTable(Buffer arg0) {
        anInt2137 = arg0.getUnsignedShortBE();
        aBoolean2143 = arg0.getUnsignedByte() == 1;
        int i = arg0.getUnsignedByte();
        if(i < 1 || i > 4)
            throw new RuntimeException();
        anIntArray2144 = new int[i];
        for(int i_30_ = 0; i_30_ < i; i_30_++)
            anIntArray2144[i_30_] = arg0.getUnsignedShortBE();
        if(i > 1) {
            anIntArray2140 = new int[i - 1];
            for(int i_31_ = 0; i_31_ < i - 1; i_31_++)
                anIntArray2140[i_31_] = arg0.getUnsignedByte();
        }
        if(i > 1) {
            anIntArray2138 = new int[i - 1];
            for(int i_32_ = 0; i_32_ < i - 1; i_32_++)
                anIntArray2138[i_32_] = arg0.getUnsignedByte();
        }
        anIntArray2145 = new int[i];
        for(int i_33_ = 0; i_33_ < i; i_33_++)
            anIntArray2145[i_33_] = arg0.getIntBE();
        anInt2136 = arg0.getUnsignedByte();
        anInt2142 = arg0.getUnsignedByte();
        anIntArray2139 = null;
    }

    public static void method871() {
        anIntArray2141 = null;
    }

    public void method868(int arg0) {
        if(anIntArray2139 != null) {
            if(anInt2136 == 1 || anInt2136 == 3) {
                if(anIntArray2141 == null || anIntArray2141.length < anIntArray2139.length)
                    anIntArray2141 = new int[anIntArray2139.length];
                int i;
                if(anIntArray2139.length == 16384)
                    i = 64;
                else
                    i = 128;
                int i_0_ = anIntArray2139.length / 4;
                int i_1_ = i * arg0 * anInt2142;
                int i_2_ = i_0_ - 1;
                if(anInt2136 == 1)
                    i_1_ = -i_1_;
                for(int i_3_ = 0; i_3_ < i_0_; i_3_++) {
                    int i_4_ = i_3_ + i_1_ & i_2_;
                    anIntArray2141[i_3_] = anIntArray2139[i_4_];
                    anIntArray2141[i_3_ + i_0_] = anIntArray2139[i_4_ + i_0_];
                    anIntArray2141[i_3_ + i_0_ + i_0_] = anIntArray2139[i_4_ + i_0_ + i_0_];
                    anIntArray2141[i_3_ + i_0_ + i_0_ + i_0_] = anIntArray2139[i_4_ + i_0_ + i_0_ + i_0_];
                }
                int[] is = anIntArray2139;
                anIntArray2139 = anIntArray2141;
                anIntArray2141 = is;
            }
            if(anInt2136 == 2 || anInt2136 == 4) {
                if(anIntArray2141 == null || anIntArray2141.length < anIntArray2139.length)
                    anIntArray2141 = new int[anIntArray2139.length];
                int i;
                if(anIntArray2139.length == 16384)
                    i = 64;
                else
                    i = 128;
                int i_5_ = anIntArray2139.length / 4;
                int i_6_ = arg0 * anInt2142;
                int i_7_ = i - 1;
                if(anInt2136 == 2)
                    i_6_ = -i_6_;
                for(int i_8_ = 0; i_8_ < i_5_; i_8_ += i) {
                    for(int i_9_ = 0; i_9_ < i; i_9_++) {
                        int i_10_ = i_8_ + i_9_;
                        int i_11_ = i_8_ + (i_9_ + i_6_ & i_7_);
                        anIntArray2141[i_10_] = anIntArray2139[i_11_];
                        anIntArray2141[i_10_ + i_5_] = anIntArray2139[i_11_ + i_5_];
                        anIntArray2141[i_10_ + i_5_ + i_5_] = anIntArray2139[i_11_ + i_5_ + i_5_];
                        anIntArray2141[i_10_ + i_5_ + i_5_ + i_5_] = anIntArray2139[i_11_ + i_5_ + i_5_ + i_5_];
                    }
                }
                int[] is = anIntArray2139;
                anIntArray2139 = anIntArray2141;
                anIntArray2141 = is;
            }
        }
    }

    public boolean method869(double arg0, int arg1, CacheIndex arg2) {
        for(int i = 0; i < anIntArray2144.length; i++) {
            if(arg2.method193((byte) 93, anIntArray2144[i]) == null)
                return false;
        }
        int i = arg1 * arg1;
        anIntArray2139 = new int[i * 4];
        for(int i_12_ = 0; i_12_ < anIntArray2144.length; i_12_++) {
            IndexedImage class40_sub5_sub14_sub2 = GameObject.method769(2, arg2, anIntArray2144[i_12_]);
            class40_sub5_sub14_sub2.resizeToLibSize();
            byte[] is = class40_sub5_sub14_sub2.imgPixels;
            int[] is_13_ = class40_sub5_sub14_sub2.palette;
            int i_14_ = anIntArray2145[i_12_];
            if((i_14_ & ~0xffffff) == 50331648) {
                int i_15_ = i_14_ & 0xff00ff;
                int i_16_ = i_14_ >> 8 & 0xff;
                for(int i_17_ = 0; i_17_ < is_13_.length; i_17_++) {
                    int i_18_ = is_13_[i_17_];
                    if((i_18_ & 0xffff) == i_18_ >> 8) {
                        i_18_ &= 0xff;
                        is_13_[i_17_] = (i_15_ * i_18_ >> 8 & 0xff00ff | i_16_ * i_18_ & 0xff00);
                    }
                }
            }
            for(int i_19_ = 0; i_19_ < is_13_.length; i_19_++)
                is_13_[i_19_] = Rasterizer3D.method707(is_13_[i_19_], arg0);
            int i_20_;
            if(i_12_ == 0)
                i_20_ = 0;
            else
                i_20_ = anIntArray2140[i_12_ - 1];
            if(i_20_ == 0) {
                if(class40_sub5_sub14_sub2.imgWidth == arg1) {
                    for(int i_21_ = 0; i_21_ < i; i_21_++)
                        anIntArray2139[i_21_] = is_13_[is[i_21_] & 0xff];
                } else if(class40_sub5_sub14_sub2.imgWidth == 64 && arg1 == 128) {
                    int i_22_ = 0;
                    for(int i_23_ = 0; i_23_ < arg1; i_23_++) {
                        for(int i_24_ = 0; i_24_ < arg1; i_24_++)
                            anIntArray2139[i_22_++] = is_13_[(is[(i_24_ >> 1) + (i_23_ >> 1 << 6)] & 0xff)];
                    }
                } else if(class40_sub5_sub14_sub2.imgWidth == 128 && arg1 == 64) {
                    int i_25_ = 0;
                    for(int i_26_ = 0; i_26_ < arg1; i_26_++) {
                        for(int i_27_ = 0; i_27_ < arg1; i_27_++)
                            anIntArray2139[i_25_++] = is_13_[(is[(i_27_ << 1) + (i_26_ << 1 << 7)] & 0xff)];
                    }
                } else
                    throw new RuntimeException();
            }
        }
        for(int i_28_ = 0; i_28_ < i; i_28_++) {
            anIntArray2139[i_28_] &= 0xf8f8ff;
            int i_29_ = anIntArray2139[i_28_];
            anIntArray2139[i_28_ + i] = i_29_ - (i_29_ >>> 3) & 0xf8f8ff;
            anIntArray2139[i_28_ + i + i] = i_29_ - (i_29_ >>> 2) & 0xf8f8ff;
            anIntArray2139[i_28_ + i + i + i] = i_29_ - (i_29_ >>> 2) - (i_29_ >>> 3) & 0xf8f8ff;
        }
        return true;
    }

    public void method870() {
        anIntArray2139 = null;
    }
}
