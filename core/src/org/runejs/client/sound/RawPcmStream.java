package org.runejs.client.sound;

public class RawPcmStream extends PcmStream {
    private int anInt2878;
    private int anInt2879;
    private int start;
    private int anInt2881;
    private int anInt2882;
    private int anInt2883;
    private int numLoops;
    private int anInt2885;
    private int end;
    private boolean aBoolean2887;
    private int anInt2888;

    private RawPcmStream(RawSound rawSound, int rate, int volume) {
        this.sound = rawSound;
        this.start = rawSound.start;
        this.end = rawSound.end;
        this.anInt2882 = rate;
        this.anInt2885 = volume;
        this.anInt2888 = 0;
    }

    private static int method855(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, RawPcmStream arg12, int arg13, int arg14) {
        if(arg13 == 0 || (arg9 = arg5 + (arg11 - arg4 + arg13 - 257) / arg13) > arg10)
            arg9 = arg10;
        while(arg5 < arg9) {
            arg1 = arg4 >> 8;
            arg0 = arg2[arg1];
            arg3[arg5++] += ((arg0 << 8) + (arg2[arg1 + 1] - arg0) * (arg4 & 0xff)) * arg6 >> arg7;
            arg6 += arg8;
            arg4 += arg13;
        }
        if(arg13 == 0 || (arg9 = arg5 + (arg11 - arg4 + arg13 - 1) / arg13) > arg10)
            arg9 = arg10;
        arg1 = arg14;
        while(arg5 < arg9) {
            arg0 = arg2[arg4 >> 8];
            arg3[arg5++] += ((arg0 << 8) + (arg1 - arg0) * (arg4 & 0xff)) * arg6 >> arg7;
            arg6 += arg8;
            arg4 += arg13;
        }
        arg12.anInt2885 = arg6;
        arg12.anInt2888 = arg4;
        return arg5;
    }

    private static int method856(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, RawPcmStream arg12, int arg13, int arg14) {
        if(arg13 == 0 || (arg9 = arg5 + (arg11 + 256 - arg4 + arg13) / arg13) > arg10)
            arg9 = arg10;
        while(arg5 < arg9) {
            arg1 = arg4 >> 8;
            arg0 = arg2[arg1 - 1];
            arg3[arg5++] += ((arg0 << 8) + (arg2[arg1] - arg0) * (arg4 & 0xff)) * arg6 >> arg7;
            arg6 += arg8;
            arg4 += arg13;
        }
        if(arg13 == 0 || (arg9 = arg5 + (arg11 - arg4 + arg13) / arg13) > arg10)
            arg9 = arg10;
        arg0 = arg14;
        arg1 = arg13;
        while(arg5 < arg9) {
            arg3[arg5++] += ((arg0 << 8) + (arg2[arg4 >> 8] - arg0) * (arg4 & 0xff)) * arg6 >> arg7;
            arg6 += arg8;
            arg4 += arg1;
        }
        arg12.anInt2885 = arg6;
        arg12.anInt2888 = arg4;
        return arg5;
    }

    private static int method858(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, RawPcmStream arg10, int arg11, int arg12) {
        if(arg11 == 0 || (arg7 = arg5 + (arg9 + 256 - arg4 + arg11) / arg11) > arg8)
            arg7 = arg8;
        while(arg5 < arg7) {
            arg1 = arg4 >> 8;
            arg0 = arg2[arg1 - 1];
            arg3[arg5++] += ((arg0 << 8) + (arg2[arg1] - arg0) * (arg4 & 0xff)) * arg6;
            arg4 += arg11;
        }
        if(arg11 == 0 || (arg7 = arg5 + (arg9 - arg4 + arg11) / arg11) > arg8)
            arg7 = arg8;
        arg0 = arg12;
        arg1 = arg11;
        while(arg5 < arg7) {
            arg3[arg5++] += ((arg0 << 8) + (arg2[arg4 >> 8] - arg0) * (arg4 & 0xff)) * arg6;
            arg4 += arg1;
        }
        arg10.anInt2888 = arg4;
        return arg5;
    }

    private static int method859(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, RawPcmStream arg10) {
        arg2 >>= 8;
        arg9 >>= 8;
        arg4 <<= 8;
        arg6 <<= 8;
        if((arg7 = arg3 + arg2 - (arg9 - 1)) > arg8)
            arg7 = arg8;
        arg7 -= 3;
        while(arg3 < arg7) {
            arg1[arg3++] += arg0[arg2--] * arg4 >> arg5;
            arg4 += arg6;
            arg1[arg3++] += arg0[arg2--] * arg4 >> arg5;
            arg4 += arg6;
            arg1[arg3++] += arg0[arg2--] * arg4 >> arg5;
            arg4 += arg6;
            arg1[arg3++] += arg0[arg2--] * arg4 >> arg5;
            arg4 += arg6;
        }
        arg7 += 3;
        while(arg3 < arg7) {
            arg1[arg3++] += arg0[arg2--] * arg4 >> arg5;
            arg4 += arg6;
        }
        arg10.anInt2885 = arg4 >> 8;
        arg10.anInt2888 = arg2 << 8;
        return arg3;
    }

    private static int method861(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, RawPcmStream arg8) {
        arg2 >>= 8;
        arg7 >>= 8;
        arg4 <<= 8;
        if((arg5 = arg3 + arg2 - (arg7 - 1)) > arg6)
            arg5 = arg6;
        arg5 -= 3;
        while(arg3 < arg5) {
            arg1[arg3++] += arg0[arg2--] * arg4;
            arg1[arg3++] += arg0[arg2--] * arg4;
            arg1[arg3++] += arg0[arg2--] * arg4;
            arg1[arg3++] += arg0[arg2--] * arg4;
        }
        arg5 += 3;
        while(arg3 < arg5)
            arg1[arg3++] += arg0[arg2--] * arg4;
        arg8.anInt2888 = arg2 << 8;
        return arg3;
    }

    private static int method862(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, RawPcmStream arg10) {
        arg2 >>= 8;
        arg9 >>= 8;
        arg4 <<= 8;
        arg6 <<= 8;
        if((arg7 = arg3 + arg9 - arg2) > arg8)
            arg7 = arg8;
        arg7 -= 3;
        while(arg3 < arg7) {
            arg1[arg3++] += arg0[arg2++] * arg4 >> arg5;
            arg4 += arg6;
            arg1[arg3++] += arg0[arg2++] * arg4 >> arg5;
            arg4 += arg6;
            arg1[arg3++] += arg0[arg2++] * arg4 >> arg5;
            arg4 += arg6;
            arg1[arg3++] += arg0[arg2++] * arg4 >> arg5;
            arg4 += arg6;
        }
        arg7 += 3;
        while(arg3 < arg7) {
            arg1[arg3++] += arg0[arg2++] * arg4 >> arg5;
            arg4 += arg6;
        }
        arg10.anInt2885 = arg4 >> 8;
        arg10.anInt2888 = arg2 << 8;
        return arg3;
    }

    public static RawPcmStream create(RawSound sound, int factor, int volume) {
        if(sound.samples == null || sound.samples.length == 0)
            return null;
        return new RawPcmStream(sound, (int) (sound.sampleRate * 256L * factor / (100 * SoundSystem.SAMPLE_RATE)), volume);
    }

    private static int method865(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, RawPcmStream arg10, int arg11, int arg12) {
        if(arg11 == 0 || (arg7 = arg5 + (arg9 - arg4 + arg11 - 257) / arg11) > arg8)
            arg7 = arg8;
        while(arg5 < arg7) {
            arg1 = arg4 >> 8;
            arg0 = arg2[arg1];
            arg3[arg5++] += ((arg0 << 8) + (arg2[arg1 + 1] - arg0) * (arg4 & 0xff)) * arg6;
            arg4 += arg11;
        }
        if(arg11 == 0 || (arg7 = arg5 + (arg9 - arg4 + arg11 - 1) / arg11) > arg8)
            arg7 = arg8;
        arg1 = arg12;
        while(arg5 < arg7) {
            arg0 = arg2[arg4 >> 8];
            arg3[arg5++] += ((arg0 << 8) + (arg1 - arg0) * (arg4 & 0xff)) * arg6;
            arg4 += arg11;
        }
        arg10.anInt2888 = arg4;
        return arg5;
    }

    private static int method867(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, RawPcmStream arg8) {
        arg2 >>= 8;
        arg7 >>= 8;
        arg4 <<= 8;
        if((arg5 = arg3 + arg7 - arg2) > arg6)
            arg5 = arg6;
        arg5 -= 3;
        while(arg3 < arg5) {
            arg1[arg3++] += arg0[arg2++] * arg4;
            arg1[arg3++] += arg0[arg2++] * arg4;
            arg1[arg3++] += arg0[arg2++] * arg4;
            arg1[arg3++] += arg0[arg2++] * arg4;
        }
        arg5 += 3;
        while(arg3 < arg5)
            arg1[arg3++] += arg0[arg2++] * arg4;
        arg8.anInt2888 = arg2 << 8;
        return arg3;
    }

    private int method854(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
        if(this.anInt2881 > 0) {
            int i = arg1 + this.anInt2881;
            if(i > arg3)
                i = arg3;
            this.anInt2881 += arg1;
            if(this.anInt2882 == -256 && (this.anInt2888 & 0xff) == 0)
                arg1 = method859(((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, this.anInt2878, this.anInt2879, 0, i, arg2, this);
            else
                arg1 = method856(0, 0, ((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, this.anInt2878, this.anInt2879, 0, i, arg2, this, this.anInt2882, arg4);
            this.anInt2881 -= arg1;
            if(this.anInt2881 != 0)
                return arg1;
            if(this.anInt2883 == -2147483648) {
                this.unlink();
                return arg3;
            }
            this.anInt2885 = this.anInt2883;
        }
        if(this.anInt2882 == -256 && (this.anInt2888 & 0xff) == 0)
            return method861(((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, 0, arg3, arg2, this);
        return method858(0, 0, ((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, 0, arg3, arg2, this, this.anInt2882, arg4);
    }

    @Override
    public synchronized int fill(int[] arg0, int arg1, int arg2) {
        if(this.anInt2885 == 0 && (this.anInt2881 == 0 || this.anInt2883 == 0 || this.anInt2883 == -2147483648)) {
            this.skip(arg2);
            return 0;
        }
        RawSound class40_sub12_sub1 = (RawSound) this.sound;
        int i = this.start << 8;
        int i_0_ = this.end << 8;
        int i_1_ = class40_sub12_sub1.samples.length << 8;
        int i_2_ = i_0_ - i;
        if(i_2_ <= 0)
            this.numLoops = 0;
        int i_3_ = arg1;
        arg2 += arg1;
        if(this.numLoops < 0) {
            if(this.aBoolean2887) {
                if(this.anInt2882 < 0) {
                    i_3_ = this.method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[this.start]);
                    if(this.anInt2888 >= i)
                        return 1;
                    this.anInt2888 = i + i - 1 - this.anInt2888;
                    this.anInt2882 = -this.anInt2882;
                }
                for(; ; ) {
                    i_3_ = this.method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[this.end - 1]);
                    if(this.anInt2888 < i_0_)
                        return 1;
                    this.anInt2888 = i_0_ + i_0_ - 1 - this.anInt2888;
                    this.anInt2882 = -this.anInt2882;
                    i_3_ = this.method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[this.start]);
                    if(this.anInt2888 >= i)
                        return 1;
                    this.anInt2888 = i + i - 1 - this.anInt2888;
                    this.anInt2882 = -this.anInt2882;
                }
            }
            if(this.anInt2882 < 0) {
                for(; ; ) {
                    i_3_ = this.method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[this.end - 1]);
                    if(this.anInt2888 >= i)
                        return 1;
                    this.anInt2888 = i_0_ - 1 - (i_0_ - 1 - this.anInt2888) % i_2_;
                }
            }
            for(; ; ) {
                i_3_ = this.method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[this.start]);
                if(this.anInt2888 < i_0_)
                    return 1;
                this.anInt2888 = i + (this.anInt2888 - i) % i_2_;
            }
        }
        do {
            if(this.numLoops > 0) {
                if(this.aBoolean2887) {
                    if(this.anInt2882 < 0) {
                        i_3_ = this.method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[this.start]);
                        if(this.anInt2888 >= i)
                            return 1;
                        this.anInt2888 = i + i - 1 - this.anInt2888;
                        this.anInt2882 = -this.anInt2882;
                        if(--this.numLoops == 0)
                            break;
                    }
                    do {
                        i_3_ = this.method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[this.end - 1]);
                        if(this.anInt2888 < i_0_)
                            return 1;
                        this.anInt2888 = i_0_ + i_0_ - 1 - this.anInt2888;
                        this.anInt2882 = -this.anInt2882;
                        if(--this.numLoops == 0)
                            break;
                        i_3_ = this.method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[this.start]);
                        if(this.anInt2888 >= i)
                            return 1;
                        this.anInt2888 = i + i - 1 - this.anInt2888;
                        this.anInt2882 = -this.anInt2882;
                    } while(--this.numLoops != 0);
                } else if(this.anInt2882 < 0) {
                    for(; ; ) {
                        i_3_ = this.method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[this.end - 1]);
                        if(this.anInt2888 >= i)
                            return 1;
                        int i_4_ = (i_0_ - 1 - this.anInt2888) / i_2_;
                        if(i_4_ >= this.numLoops) {
                            this.anInt2888 += i_2_ * this.numLoops;
                            this.numLoops = 0;
                            break;
                        }
                        this.anInt2888 += i_2_ * i_4_;
                        this.numLoops -= i_4_;
                    }
                } else {
                    for(; ; ) {
                        i_3_ = this.method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[this.start]);
                        if(this.anInt2888 < i_0_)
                            return 1;
                        int i_5_ = (this.anInt2888 - i) / i_2_;
                        if(i_5_ >= this.numLoops) {
                            this.anInt2888 -= i_2_ * this.numLoops;
                            this.numLoops = 0;
                            break;
                        }
                        this.anInt2888 -= i_2_ * i_5_;
                        this.numLoops -= i_5_;
                    }
                }
            }
        } while(false);
        if(this.anInt2882 < 0) {
            this.method854(arg0, i_3_, 0, arg2, 0);
            if(this.anInt2888 < 0) {
                this.anInt2888 = 0;
                this.unlink();
            }
        } else {
            this.method866(arg0, i_3_, i_1_, arg2, 0);
            if(this.anInt2888 >= i_1_) {
                this.anInt2888 = i_1_ - 1;
                this.unlink();
            }
        }
        return 1;
    }

    public synchronized void method857(int arg0) {
        this.anInt2885 = arg0;
        this.anInt2881 = 0;
    }

    public synchronized void setNumLoops(int arg0) {
        this.numLoops = arg0;
    }

    @Override
    public int method845() {
        int i = this.anInt2885 * 3;
        i = (i ^ i >> 31) + (i >>> 31);
        if(this.numLoops == 0)
            i -= i * this.anInt2888 / (((RawSound) this.sound).samples.length << 8);
        else if(this.numLoops >= 0)
            i -= i * this.start / ((RawSound) this.sound).samples.length;
        if(i > 255)
            return 255;
        return i;
    }

    public boolean hasNext() {
        return this.hasPrevious();
    }

    @Override
	public synchronized void skip(int arg0) {
        if(this.anInt2881 > 0) {
            if(arg0 >= this.anInt2881) {
                if(this.anInt2883 == -2147483648) {
                    this.unlink();
                    arg0 = this.anInt2881;
                } else
                    this.anInt2885 = this.anInt2883;
                this.anInt2881 = 0;
            } else {
                this.anInt2885 += this.anInt2879 * arg0;
                this.anInt2881 -= arg0;
            }
        }
        this.anInt2888 += this.anInt2882 * arg0;
        RawSound class40_sub12_sub1 = (RawSound) this.sound;
        int i = this.start << 8;
        int i_6_ = this.end << 8;
        int i_7_ = class40_sub12_sub1.samples.length << 8;
        int i_8_ = i_6_ - i;
        if(i_8_ <= 0)
            this.numLoops = 0;
        if(this.numLoops < 0) {
            if(this.aBoolean2887) {
                if(this.anInt2882 < 0) {
                    if(this.anInt2888 >= i)
                        return;
                    this.anInt2888 = i + i - 1 - this.anInt2888;
                    this.anInt2882 = -this.anInt2882;
                }
                while(this.anInt2888 >= i_6_) {
                    this.anInt2888 = i_6_ + i_6_ - 1 - this.anInt2888;
                    this.anInt2882 = -this.anInt2882;
                    if(this.anInt2888 >= i)
                        break;
                    this.anInt2888 = i + i - 1 - this.anInt2888;
                    this.anInt2882 = -this.anInt2882;
                }
            } else if(this.anInt2882 < 0) {
                if(this.anInt2888 < i)
                    this.anInt2888 = i_6_ - 1 - (i_6_ - 1 - this.anInt2888) % i_8_;
            } else if(this.anInt2888 >= i_6_)
                this.anInt2888 = i + (this.anInt2888 - i) % i_8_;
        } else {
            do {
                if(this.numLoops > 0) {
                    if(this.aBoolean2887) {
                        if(this.anInt2882 < 0) {
                            if(this.anInt2888 >= i)
                                return;
                            this.anInt2888 = i + i - 1 - this.anInt2888;
                            this.anInt2882 = -this.anInt2882;
                            if(--this.numLoops == 0)
                                break;
                        }
                        do {
                            if(this.anInt2888 < i_6_)
                                return;
                            this.anInt2888 = i_6_ + i_6_ - 1 - this.anInt2888;
                            this.anInt2882 = -this.anInt2882;
                            if(--this.numLoops == 0)
                                break;
                            if(this.anInt2888 >= i)
                                return;
                            this.anInt2888 = i + i - 1 - this.anInt2888;
                            this.anInt2882 = -this.anInt2882;
                        } while(--this.numLoops != 0);
                    } else if(this.anInt2882 < 0) {
                        if(this.anInt2888 >= i)
                            return;
                        int i_9_ = (i_6_ - 1 - this.anInt2888) / i_8_;
                        if(i_9_ >= this.numLoops) {
                            this.anInt2888 += i_8_ * this.numLoops;
                            this.numLoops = 0;
                        } else {
                            this.anInt2888 += i_8_ * i_9_;
                            this.numLoops -= i_9_;
                            return;
                        }
                    } else {
                        if(this.anInt2888 < i_6_)
                            return;
                        int i_10_ = (this.anInt2888 - i) / i_8_;
                        if(i_10_ >= this.numLoops) {
                            this.anInt2888 -= i_8_ * this.numLoops;
                            this.numLoops = 0;
                        } else {
                            this.anInt2888 -= i_8_ * i_10_;
                            this.numLoops -= i_10_;
                            return;
                        }
                    }
                }
            } while(false);
            if(this.anInt2882 < 0) {
                if(this.anInt2888 < 0) {
                    this.anInt2888 = 0;
                    this.unlink();
                }
            } else if(this.anInt2888 >= i_7_) {
                this.anInt2888 = i_7_ - 1;
                this.unlink();
            }
        }
    }

    private int method866(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
        if(this.anInt2881 > 0) {
            int i = arg1 + this.anInt2881;
            if(i > arg3)
                i = arg3;
            this.anInt2881 += arg1;
            if(this.anInt2882 == 256 && (this.anInt2888 & 0xff) == 0)
                arg1 = method862(((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, this.anInt2878, this.anInt2879, 0, i, arg2, this);
            else
                arg1 = method855(0, 0, ((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, this.anInt2878, this.anInt2879, 0, i, arg2, this, this.anInt2882, arg4);
            this.anInt2881 -= arg1;
            if(this.anInt2881 != 0)
                return arg1;
            if(this.anInt2883 == -2147483648) {
                this.unlink();
                return arg3;
            }
            this.anInt2885 = this.anInt2883;
        }
        if(this.anInt2882 == 256 && (this.anInt2888 & 0xff) == 0)
            return method867(((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, 0, arg3, arg2, this);
        return method865(0, 0, ((RawSound) this.sound).samples, arg0, this.anInt2888, arg1, this.anInt2885, 0, arg3, arg2, this, this.anInt2882, arg4);
    }
}
