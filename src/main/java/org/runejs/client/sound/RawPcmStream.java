package org.runejs.client.sound;

public class RawPcmStream extends PcmStream {
    public int anInt2878;
    public int anInt2879;
    public int anInt2880;
    public int anInt2881;
    public int anInt2882;
    public int anInt2883;
    public int anInt2884;
    public int anInt2885;
    public int anInt2886;
    public boolean aBoolean2887;
    public int anInt2888;

    public RawPcmStream(RawSound arg0, int arg1, int arg2) {
        sound = arg0;
        anInt2880 = arg0.start;
        anInt2886 = arg0.end;
        anInt2882 = arg1;
        anInt2885 = arg2;
        anInt2888 = 0;
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

    public static RawPcmStream create(RawSound arg0, int arg1, int arg2) {
        if(arg0.samples == null || arg0.samples.length == 0)
            return null;
        return new RawPcmStream(arg0, (int) ((long) arg0.sampleRate * 256L * (long) arg1 / (long) (100 * SoundSystem.SAMPLE_RATE)), arg2);
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

    public int method854(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
        if(anInt2881 > 0) {
            int i = arg1 + anInt2881;
            if(i > arg3)
                i = arg3;
            anInt2881 += arg1;
            if(anInt2882 == -256 && (anInt2888 & 0xff) == 0)
                arg1 = method859(((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, anInt2878, anInt2879, 0, i, arg2, this);
            else
                arg1 = method856(0, 0, ((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, anInt2878, anInt2879, 0, i, arg2, this, anInt2882, arg4);
            anInt2881 -= arg1;
            if(anInt2881 != 0)
                return arg1;
            if(anInt2883 == -2147483648) {
                this.remove();
                return arg3;
            }
            anInt2885 = anInt2883;
        }
        if(anInt2882 == -256 && (anInt2888 & 0xff) == 0)
            return method861(((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, 0, arg3, arg2, this);
        return method858(0, 0, ((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, 0, arg3, arg2, this, anInt2882, arg4);
    }

    public synchronized int fill(int[] arg0, int arg1, int arg2) {
        if(anInt2885 == 0 && (anInt2881 == 0 || anInt2883 == 0 || anInt2883 == -2147483648)) {
            skip(arg2);
            return 0;
        }
        RawSound class40_sub12_sub1 = (RawSound) sound;
        int i = anInt2880 << 8;
        int i_0_ = anInt2886 << 8;
        int i_1_ = class40_sub12_sub1.samples.length << 8;
        int i_2_ = i_0_ - i;
        if(i_2_ <= 0)
            anInt2884 = 0;
        int i_3_ = arg1;
        arg2 += arg1;
        if(anInt2884 < 0) {
            if(aBoolean2887) {
                if(anInt2882 < 0) {
                    i_3_ = method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[anInt2880]);
                    if(anInt2888 >= i)
                        return 1;
                    anInt2888 = i + i - 1 - anInt2888;
                    anInt2882 = -anInt2882;
                }
                for(; ; ) {
                    i_3_ = method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[anInt2886 - 1]);
                    if(anInt2888 < i_0_)
                        return 1;
                    anInt2888 = i_0_ + i_0_ - 1 - anInt2888;
                    anInt2882 = -anInt2882;
                    i_3_ = method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[anInt2880]);
                    if(anInt2888 >= i)
                        return 1;
                    anInt2888 = i + i - 1 - anInt2888;
                    anInt2882 = -anInt2882;
                }
            }
            if(anInt2882 < 0) {
                for(; ; ) {
                    i_3_ = method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[anInt2886 - 1]);
                    if(anInt2888 >= i)
                        return 1;
                    anInt2888 = i_0_ - 1 - (i_0_ - 1 - anInt2888) % i_2_;
                }
            }
            for(; ; ) {
                i_3_ = method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[anInt2880]);
                if(anInt2888 < i_0_)
                    return 1;
                anInt2888 = i + (anInt2888 - i) % i_2_;
            }
        }
        do {
            if(anInt2884 > 0) {
                if(aBoolean2887) {
                    if(anInt2882 < 0) {
                        i_3_ = method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[anInt2880]);
                        if(anInt2888 >= i)
                            return 1;
                        anInt2888 = i + i - 1 - anInt2888;
                        anInt2882 = -anInt2882;
                        if(--anInt2884 == 0)
                            break;
                    }
                    do {
                        i_3_ = method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[anInt2886 - 1]);
                        if(anInt2888 < i_0_)
                            return 1;
                        anInt2888 = i_0_ + i_0_ - 1 - anInt2888;
                        anInt2882 = -anInt2882;
                        if(--anInt2884 == 0)
                            break;
                        i_3_ = method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[anInt2880]);
                        if(anInt2888 >= i)
                            return 1;
                        anInt2888 = i + i - 1 - anInt2888;
                        anInt2882 = -anInt2882;
                    } while(--anInt2884 != 0);
                } else if(anInt2882 < 0) {
                    for(; ; ) {
                        i_3_ = method854(arg0, i_3_, i, arg2, class40_sub12_sub1.samples[anInt2886 - 1]);
                        if(anInt2888 >= i)
                            return 1;
                        int i_4_ = (i_0_ - 1 - anInt2888) / i_2_;
                        if(i_4_ >= anInt2884) {
                            anInt2888 += i_2_ * anInt2884;
                            anInt2884 = 0;
                            break;
                        }
                        anInt2888 += i_2_ * i_4_;
                        anInt2884 -= i_4_;
                    }
                } else {
                    for(; ; ) {
                        i_3_ = method866(arg0, i_3_, i_0_, arg2, class40_sub12_sub1.samples[anInt2880]);
                        if(anInt2888 < i_0_)
                            return 1;
                        int i_5_ = (anInt2888 - i) / i_2_;
                        if(i_5_ >= anInt2884) {
                            anInt2888 -= i_2_ * anInt2884;
                            anInt2884 = 0;
                            break;
                        }
                        anInt2888 -= i_2_ * i_5_;
                        anInt2884 -= i_5_;
                    }
                }
            }
        } while(false);
        if(anInt2882 < 0) {
            method854(arg0, i_3_, 0, arg2, 0);
            if(anInt2888 < 0) {
                anInt2888 = 0;
                this.remove();
            }
        } else {
            method866(arg0, i_3_, i_1_, arg2, 0);
            if(anInt2888 >= i_1_) {
                anInt2888 = i_1_ - 1;
                this.remove();
            }
        }
        return 1;
    }

    public synchronized void method857(int arg0) {
        anInt2885 = arg0;
        anInt2881 = 0;
    }

    public synchronized void setNumLoops(int arg0) {
        anInt2884 = arg0;
    }

    public int method845() {
        int i = anInt2885 * 3;
        i = (i ^ i >> 31) + (i >>> 31);
        if(anInt2884 == 0)
            i -= i * anInt2888 / (((RawSound) sound).samples.length << 8);
        else if(anInt2884 >= 0)
            i -= i * anInt2880 / ((RawSound) sound).samples.length;
        if(i > 255)
            return 255;
        return i;
    }

    public boolean hasNext() {
        return this.hasPrevious();
    }

    public synchronized void skip(int arg0) {
        if(anInt2881 > 0) {
            if(arg0 >= anInt2881) {
                if(anInt2883 == -2147483648) {
                    this.remove();
                    arg0 = anInt2881;
                } else
                    anInt2885 = anInt2883;
                anInt2881 = 0;
            } else {
                anInt2885 += anInt2879 * arg0;
                anInt2881 -= arg0;
            }
        }
        anInt2888 += anInt2882 * arg0;
        RawSound class40_sub12_sub1 = (RawSound) sound;
        int i = anInt2880 << 8;
        int i_6_ = anInt2886 << 8;
        int i_7_ = class40_sub12_sub1.samples.length << 8;
        int i_8_ = i_6_ - i;
        if(i_8_ <= 0)
            anInt2884 = 0;
        if(anInt2884 < 0) {
            if(aBoolean2887) {
                if(anInt2882 < 0) {
                    if(anInt2888 >= i)
                        return;
                    anInt2888 = i + i - 1 - anInt2888;
                    anInt2882 = -anInt2882;
                }
                while(anInt2888 >= i_6_) {
                    anInt2888 = i_6_ + i_6_ - 1 - anInt2888;
                    anInt2882 = -anInt2882;
                    if(anInt2888 >= i)
                        break;
                    anInt2888 = i + i - 1 - anInt2888;
                    anInt2882 = -anInt2882;
                }
            } else if(anInt2882 < 0) {
                if(anInt2888 < i)
                    anInt2888 = i_6_ - 1 - (i_6_ - 1 - anInt2888) % i_8_;
            } else if(anInt2888 >= i_6_)
                anInt2888 = i + (anInt2888 - i) % i_8_;
        } else {
            do {
                if(anInt2884 > 0) {
                    if(aBoolean2887) {
                        if(anInt2882 < 0) {
                            if(anInt2888 >= i)
                                return;
                            anInt2888 = i + i - 1 - anInt2888;
                            anInt2882 = -anInt2882;
                            if(--anInt2884 == 0)
                                break;
                        }
                        do {
                            if(anInt2888 < i_6_)
                                return;
                            anInt2888 = i_6_ + i_6_ - 1 - anInt2888;
                            anInt2882 = -anInt2882;
                            if(--anInt2884 == 0)
                                break;
                            if(anInt2888 >= i)
                                return;
                            anInt2888 = i + i - 1 - anInt2888;
                            anInt2882 = -anInt2882;
                        } while(--anInt2884 != 0);
                    } else if(anInt2882 < 0) {
                        if(anInt2888 >= i)
                            return;
                        int i_9_ = (i_6_ - 1 - anInt2888) / i_8_;
                        if(i_9_ >= anInt2884) {
                            anInt2888 += i_8_ * anInt2884;
                            anInt2884 = 0;
                        } else {
                            anInt2888 += i_8_ * i_9_;
                            anInt2884 -= i_9_;
                            return;
                        }
                    } else {
                        if(anInt2888 < i_6_)
                            return;
                        int i_10_ = (anInt2888 - i) / i_8_;
                        if(i_10_ >= anInt2884) {
                            anInt2888 -= i_8_ * anInt2884;
                            anInt2884 = 0;
                        } else {
                            anInt2888 -= i_8_ * i_10_;
                            anInt2884 -= i_10_;
                            return;
                        }
                    }
                }
            } while(false);
            if(anInt2882 < 0) {
                if(anInt2888 < 0) {
                    anInt2888 = 0;
                    this.remove();
                }
            } else if(anInt2888 >= i_7_) {
                anInt2888 = i_7_ - 1;
                this.remove();
            }
        }
    }

    public int method866(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
        if(anInt2881 > 0) {
            int i = arg1 + anInt2881;
            if(i > arg3)
                i = arg3;
            anInt2881 += arg1;
            if(anInt2882 == 256 && (anInt2888 & 0xff) == 0)
                arg1 = method862(((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, anInt2878, anInt2879, 0, i, arg2, this);
            else
                arg1 = method855(0, 0, ((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, anInt2878, anInt2879, 0, i, arg2, this, anInt2882, arg4);
            anInt2881 -= arg1;
            if(anInt2881 != 0)
                return arg1;
            if(anInt2883 == -2147483648) {
                this.remove();
                return arg3;
            }
            anInt2885 = anInt2883;
        }
        if(anInt2882 == 256 && (anInt2888 & 0xff) == 0)
            return method867(((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, 0, arg3, arg2, this);
        return method865(0, 0, ((RawSound) sound).samples, arg0, anInt2888, arg1, anInt2885, 0, arg3, arg2, this, anInt2882, arg4);
    }
}
