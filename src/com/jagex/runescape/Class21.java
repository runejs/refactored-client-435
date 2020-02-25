package com.jagex.runescape;

import com.jagex.runescape.cache.def.OverlayDefinition;

public class Class21 {
    public static Class34 aClass34_530 = new Class34();

    public static void method289() {
        aClass34_530 = null;
    }

    public static void method290(Class34 arg0) {
        arg0.anInt843 = 0;
        for(int i = 0; i < 256; i++) {
            if(arg0.aBooleanArray828[i]) {
                arg0.aByteArray814[arg0.anInt843] = (byte) i;
                arg0.anInt843++;
            }
        }
    }

    public static void method291(Class34 arg0) {
        byte i = arg0.aByte819;
        int i_0_ = arg0.anInt812;
        int i_1_ = arg0.anInt802;
        int i_2_ = arg0.anInt811;
        int[] is = OverlayDefinition.anIntArray2324;
        int i_3_ = arg0.anInt820;
        byte[] is_4_ = arg0.aByteArray837;
        int i_5_ = arg0.anInt825;
        int i_6_ = arg0.anInt823;
        int i_7_ = i_6_;
        int i_8_ = arg0.anInt809 + 1;
        while_10_:
        for(; ; ) {
            if(i_0_ > 0) {
                for(; ; ) {
                    if(i_6_ == 0)
                        break while_10_;
                    if(i_0_ == 1)
                        break;
                    is_4_[i_5_] = i;
                    i_0_--;
                    i_5_++;
                    i_6_--;
                }
                if(i_6_ == 0) {
                    i_0_ = 1;
                    break;
                }
                is_4_[i_5_] = i;
                i_5_++;
                i_6_--;
            }
            boolean bool = true;
            while(bool) {
                bool = false;
                if(i_1_ == i_8_) {
                    i_0_ = 0;
                    break while_10_;
                }
                i = (byte) i_2_;
                i_3_ = is[i_3_];
                int i_9_ = (byte) (i_3_ & 0xff);
                i_3_ >>= 8;
                i_1_++;
                if(i_9_ != i_2_) {
                    i_2_ = i_9_;
                    if(i_6_ == 0) {
                        i_0_ = 1;
                        break while_10_;
                    }
                    is_4_[i_5_] = i;
                    i_5_++;
                    i_6_--;
                    bool = true;
                } else if(i_1_ == i_8_) {
                    if(i_6_ == 0) {
                        i_0_ = 1;
                        break while_10_;
                    }
                    is_4_[i_5_] = i;
                    i_5_++;
                    i_6_--;
                    bool = true;
                }
            }
            i_0_ = 2;
            i_3_ = is[i_3_];
            int i_10_ = (byte) (i_3_ & 0xff);
            i_3_ >>= 8;
            if(++i_1_ != i_8_) {
                if(i_10_ == i_2_) {
                    i_0_ = 3;
                    i_3_ = is[i_3_];
                    i_10_ = (byte) (i_3_ & 0xff);
                    i_3_ >>= 8;
                    if(++i_1_ != i_8_) {
                        if(i_10_ == i_2_) {
                            i_3_ = is[i_3_];
                            i_10_ = (byte) (i_3_ & 0xff);
                            i_3_ >>= 8;
                            i_1_++;
                            i_0_ = (i_10_ & 0xff) + 4;
                            i_3_ = is[i_3_];
                            i_2_ = (byte) (i_3_ & 0xff);
                            i_3_ >>= 8;
                            i_1_++;
                        } else
                            i_2_ = i_10_;
                    }
                } else
                    i_2_ = i_10_;
            }
        }
        int i_11_ = arg0.anInt846;
        arg0.anInt846 += i_7_ - i_6_;
        arg0.aByte819 = i;
        arg0.anInt812 = i_0_;
        arg0.anInt802 = i_1_;
        arg0.anInt811 = i_2_;
        OverlayDefinition.anIntArray2324 = is;
        arg0.anInt820 = i_3_;
        arg0.aByteArray837 = is_4_;
        arg0.anInt825 = i_5_;
        arg0.anInt823 = i_6_;
    }

    public static void method292(Class34 arg0) {
        boolean bool = false;
        boolean bool_12_ = false;
        boolean bool_13_ = false;
        boolean bool_14_ = false;
        boolean bool_15_ = false;
        boolean bool_16_ = false;
        boolean bool_17_ = false;
        boolean bool_18_ = false;
        boolean bool_19_ = false;
        boolean bool_20_ = false;
        boolean bool_21_ = false;
        boolean bool_22_ = false;
        boolean bool_23_ = false;
        boolean bool_24_ = false;
        boolean bool_25_ = false;
        boolean bool_26_ = false;
        boolean bool_27_ = false;
        boolean bool_28_ = false;
        int i = 0;
        int[] is = null;
        int[] is_29_ = null;
        int[] is_30_ = null;
        arg0.anInt810 = 1;
        if(OverlayDefinition.anIntArray2324 == null)
            OverlayDefinition.anIntArray2324 = new int[arg0.anInt810 * 100000];
        boolean bool_31_ = true;
        while(bool_31_) {
            byte i_32_ = method293(arg0);
            if(i_32_ == 23)
                break;
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method293(arg0);
            i_32_ = method296(arg0);
            arg0.anInt801 = 0;
            int i_33_ = method293(arg0);
            arg0.anInt801 = arg0.anInt801 << 8 | i_33_ & 0xff;
            i_33_ = method293(arg0);
            arg0.anInt801 = arg0.anInt801 << 8 | i_33_ & 0xff;
            i_33_ = method293(arg0);
            arg0.anInt801 = arg0.anInt801 << 8 | i_33_ & 0xff;
            for(int i_34_ = 0; i_34_ < 16; i_34_++) {
                i_32_ = method296(arg0);
                arg0.aBooleanArray824[i_34_] = i_32_ == 1;
            }
            for(int i_35_ = 0; i_35_ < 256; i_35_++)
                arg0.aBooleanArray828[i_35_] = false;
            for(int i_36_ = 0; i_36_ < 16; i_36_++) {
                if(arg0.aBooleanArray824[i_36_]) {
                    for(int i_37_ = 0; i_37_ < 16; i_37_++) {
                        i_32_ = method296(arg0);
                        if(i_32_ == 1)
                            arg0.aBooleanArray828[i_36_ * 16 + i_37_] = true;
                    }
                }
            }
            method290(arg0);
            int i_38_ = arg0.anInt843 + 2;
            int i_39_ = method295(3, arg0);
            int i_40_ = method295(15, arg0);
            for(int i_41_ = 0; i_41_ < i_40_; i_41_++) {
                int i_42_ = 0;
                for(; ; ) {
                    i_32_ = method296(arg0);
                    if(i_32_ == 0)
                        break;
                    i_42_++;
                }
                arg0.aByteArray839[i_41_] = (byte) i_42_;
            }
            byte[] is_43_ = new byte[6];
            for(byte i_44_ = 0; i_44_ < i_39_; i_44_++)
                is_43_[i_44_] = i_44_;
            for(int i_45_ = 0; i_45_ < i_40_; i_45_++) {
                byte i_46_ = arg0.aByteArray839[i_45_];
                byte i_47_ = is_43_[i_46_];
                for(/**/; i_46_ > 0; i_46_--)
                    is_43_[i_46_] = is_43_[i_46_ - 1];
                is_43_[0] = i_47_;
                arg0.aByteArray808[i_45_] = i_47_;
            }
            for(int i_48_ = 0; i_48_ < i_39_; i_48_++) {
                int i_49_ = method295(5, arg0);
                for(int i_50_ = 0; i_50_ < i_38_; i_50_++) {
                    for(; ; ) {
                        i_32_ = method296(arg0);
                        if(i_32_ == 0)
                            break;
                        i_32_ = method296(arg0);
                        if(i_32_ == 0)
                            i_49_++;
                        else
                            i_49_--;
                    }
                    arg0.aByteArrayArray822[i_48_][i_50_] = (byte) i_49_;
                }
            }
            for(int i_51_ = 0; i_51_ < i_39_; i_51_++) {
                int i_52_ = 32;
                byte i_53_ = 0;
                for(int i_54_ = 0; i_54_ < i_38_; i_54_++) {
                    if(arg0.aByteArrayArray822[i_51_][i_54_] > i_53_)
                        i_53_ = arg0.aByteArrayArray822[i_51_][i_54_];
                    if(arg0.aByteArrayArray822[i_51_][i_54_] < i_52_)
                        i_52_ = arg0.aByteArrayArray822[i_51_][i_54_];
                }
                method294(arg0.anIntArrayArray835[i_51_], arg0.anIntArrayArray842[i_51_], arg0.anIntArrayArray833[i_51_], arg0.aByteArrayArray822[i_51_], i_52_, i_53_, i_38_);
                arg0.anIntArray827[i_51_] = i_52_;
            }
            int i_55_ = arg0.anInt843 + 1;
            int i_56_ = -1;
            int i_57_ = 0;
            for(int i_58_ = 0; i_58_ <= 255; i_58_++)
                arg0.anIntArray845[i_58_] = 0;
            int i_59_ = 4095;
            for(int i_60_ = 15; i_60_ >= 0; i_60_--) {
                for(int i_61_ = 15; i_61_ >= 0; i_61_--) {
                    arg0.aByteArray840[i_59_] = (byte) (i_60_ * 16 + i_61_);
                    i_59_--;
                }
                arg0.anIntArray818[i_60_] = i_59_ + 1;
            }
            int i_62_ = 0;
            if(i_57_ == 0) {
                i_56_++;
                i_57_ = 50;
                byte i_63_ = arg0.aByteArray808[i_56_];
                i = arg0.anIntArray827[i_63_];
                is = arg0.anIntArrayArray835[i_63_];
                is_30_ = arg0.anIntArrayArray833[i_63_];
                is_29_ = arg0.anIntArrayArray842[i_63_];
            }
            i_57_--;
            int i_64_ = i;
            int i_65_;
            int i_66_;
            for(i_66_ = method295(i_64_, arg0); i_66_ > is[i_64_]; i_66_ = i_66_ << 1 | i_65_) {
                i_64_++;
                i_65_ = method296(arg0);
            }
            int i_67_ = is_30_[i_66_ - is_29_[i_64_]];
            while(i_67_ != i_55_) {
                if(i_67_ == 0 || i_67_ == 1) {
                    int i_68_ = -1;
                    int i_69_ = 1;
                    do {
                        if(i_67_ == 0)
                            i_68_ += i_69_;
                        else if(i_67_ == 1)
                            i_68_ += 2 * i_69_;
                        i_69_ *= 2;
                        if(i_57_ == 0) {
                            i_56_++;
                            i_57_ = 50;
                            byte i_70_ = arg0.aByteArray808[i_56_];
                            i = arg0.anIntArray827[i_70_];
                            is = arg0.anIntArrayArray835[i_70_];
                            is_30_ = arg0.anIntArrayArray833[i_70_];
                            is_29_ = arg0.anIntArrayArray842[i_70_];
                        }
                        i_57_--;
                        i_64_ = i;
                        for(i_66_ = method295(i_64_, arg0); i_66_ > is[i_64_]; i_66_ = i_66_ << 1 | i_65_) {
                            i_64_++;
                            i_65_ = method296(arg0);
                        }
                        i_67_ = is_30_[i_66_ - is_29_[i_64_]];
                    } while(i_67_ == 0 || i_67_ == 1);
                    i_68_++;
                    i_33_ = (arg0.aByteArray814[arg0.aByteArray840[arg0.anIntArray818[0]] & 0xff]);
                    arg0.anIntArray845[i_33_ & 0xff] += i_68_;
                    for(/**/; i_68_ > 0; i_68_--) {
                        OverlayDefinition.anIntArray2324[i_62_] = i_33_ & 0xff;
                        i_62_++;
                    }
                } else {
                    int i_71_ = i_67_ - 1;
                    if(i_71_ < 16) {
                        int i_72_ = arg0.anIntArray818[0];
                        i_32_ = arg0.aByteArray840[i_72_ + i_71_];
                        for(/**/; i_71_ > 3; i_71_ -= 4) {
                            int i_73_ = i_72_ + i_71_;
                            arg0.aByteArray840[i_73_] = arg0.aByteArray840[i_73_ - 1];
                            arg0.aByteArray840[i_73_ - 1] = arg0.aByteArray840[i_73_ - 2];
                            arg0.aByteArray840[i_73_ - 2] = arg0.aByteArray840[i_73_ - 3];
                            arg0.aByteArray840[i_73_ - 3] = arg0.aByteArray840[i_73_ - 4];
                        }
                        for(/**/; i_71_ > 0; i_71_--)
                            arg0.aByteArray840[i_72_ + i_71_] = arg0.aByteArray840[i_72_ + i_71_ - 1];
                        arg0.aByteArray840[i_72_] = i_32_;
                    } else {
                        int i_74_ = i_71_ / 16;
                        int i_75_ = i_71_ % 16;
                        int i_76_ = arg0.anIntArray818[i_74_] + i_75_;
                        i_32_ = arg0.aByteArray840[i_76_];
                        for(/**/; i_76_ > arg0.anIntArray818[i_74_]; i_76_--)
                            arg0.aByteArray840[i_76_] = arg0.aByteArray840[i_76_ - 1];
                        arg0.anIntArray818[i_74_]++;
                        for(/**/; i_74_ > 0; i_74_--) {
                            arg0.anIntArray818[i_74_]--;
                            arg0.aByteArray840[arg0.anIntArray818[i_74_]] = (arg0.aByteArray840[arg0.anIntArray818[i_74_ - 1] + 16 - 1]);
                        }
                        arg0.anIntArray818[0]--;
                        arg0.aByteArray840[arg0.anIntArray818[0]] = i_32_;
                        if(arg0.anIntArray818[0] == 0) {
                            int i_77_ = 4095;
                            for(int i_78_ = 15; i_78_ >= 0; i_78_--) {
                                for(int i_79_ = 15; i_79_ >= 0; i_79_--) {
                                    arg0.aByteArray840[i_77_] = (arg0.aByteArray840[(arg0.anIntArray818[i_78_] + i_79_)]);
                                    i_77_--;
                                }
                                arg0.anIntArray818[i_78_] = i_77_ + 1;
                            }
                        }
                    }
                    arg0.anIntArray845[(arg0.aByteArray814[i_32_ & 0xff] & 0xff)]++;
                    OverlayDefinition.anIntArray2324[i_62_] = arg0.aByteArray814[i_32_ & 0xff] & 0xff;
                    i_62_++;
                    if(i_57_ == 0) {
                        i_56_++;
                        i_57_ = 50;
                        byte i_80_ = arg0.aByteArray808[i_56_];
                        i = arg0.anIntArray827[i_80_];
                        is = arg0.anIntArrayArray835[i_80_];
                        is_30_ = arg0.anIntArrayArray833[i_80_];
                        is_29_ = arg0.anIntArrayArray842[i_80_];
                    }
                    i_57_--;
                    i_64_ = i;
                    for(i_66_ = method295(i_64_, arg0); i_66_ > is[i_64_]; i_66_ = i_66_ << 1 | i_65_) {
                        i_64_++;
                        i_65_ = method296(arg0);
                    }
                    i_67_ = is_30_[i_66_ - is_29_[i_64_]];
                }
            }
            arg0.anInt812 = 0;
            arg0.aByte819 = (byte) 0;
            arg0.anIntArray816[0] = 0;
            for(int i_81_ = 1; i_81_ <= 256; i_81_++)
                arg0.anIntArray816[i_81_] = arg0.anIntArray845[i_81_ - 1];
            for(int i_82_ = 1; i_82_ <= 256; i_82_++)
                arg0.anIntArray816[i_82_] += arg0.anIntArray816[i_82_ - 1];
            for(int i_83_ = 0; i_83_ < i_62_; i_83_++) {
                i_33_ = (byte) (OverlayDefinition.anIntArray2324[i_83_] & 0xff);
                OverlayDefinition.anIntArray2324[(arg0.anIntArray816[i_33_ & 0xff])] |= i_83_ << 8;
                arg0.anIntArray816[i_33_ & 0xff]++;
            }
            arg0.anInt820 = OverlayDefinition.anIntArray2324[arg0.anInt801] >> 8;
            arg0.anInt802 = 0;
            arg0.anInt820 = OverlayDefinition.anIntArray2324[arg0.anInt820];
            arg0.anInt811 = (byte) (arg0.anInt820 & 0xff);
            arg0.anInt820 >>= 8;
            arg0.anInt802++;
            arg0.anInt809 = i_62_;
            method291(arg0);
            bool_31_ = arg0.anInt802 == arg0.anInt809 + 1 && arg0.anInt812 == 0;
        }
    }

    public static byte method293(Class34 arg0) {
        return (byte) method295(8, arg0);
    }

    public static void method294(int[] arg0, int[] arg1, int[] arg2, byte[] arg3, int arg4, int arg5, int arg6) {
        int i = 0;
        for(int i_84_ = arg4; i_84_ <= arg5; i_84_++) {
            for(int i_85_ = 0; i_85_ < arg6; i_85_++) {
                if(arg3[i_85_] == i_84_) {
                    arg2[i] = i_85_;
                    i++;
                }
            }
        }
        for(int i_86_ = 0; i_86_ < 23; i_86_++)
            arg1[i_86_] = 0;
        for(int i_87_ = 0; i_87_ < arg6; i_87_++)
            arg1[arg3[i_87_] + 1]++;
        for(int i_88_ = 1; i_88_ < 23; i_88_++)
            arg1[i_88_] += arg1[i_88_ - 1];
        for(int i_89_ = 0; i_89_ < 23; i_89_++)
            arg0[i_89_] = 0;
        int i_90_ = 0;
        for(int i_91_ = arg4; i_91_ <= arg5; i_91_++) {
            i_90_ += arg1[i_91_ + 1] - arg1[i_91_];
            arg0[i_91_] = i_90_ - 1;
            i_90_ <<= 1;
        }
        for(int i_92_ = arg4 + 1; i_92_ <= arg5; i_92_++)
            arg1[i_92_] = (arg0[i_92_ - 1] + 1 << 1) - arg1[i_92_];
    }

    public static int method295(int arg0, Class34 arg1) {
        int i;
        for(; ; ) {
            if(arg1.anInt847 >= arg0) {
                int i_93_ = arg1.anInt834 >> arg1.anInt847 - arg0 & (1 << arg0) - 1;
                arg1.anInt847 -= arg0;
                i = i_93_;
                break;
            }
            arg1.anInt834 = (arg1.anInt834 << 8 | arg1.aByteArray830[arg1.anInt832] & 0xff);
            arg1.anInt847 += 8;
            arg1.anInt832++;
            arg1.anInt831++;
        }
        return i;
    }

    public static byte method296(Class34 arg0) {
        return (byte) method295(1, arg0);
    }

    public static int method297(byte[] arg0, int arg1, byte[] arg2, int arg3, int arg4) {
        synchronized(aClass34_530) {
            aClass34_530.aByteArray830 = arg2;
            aClass34_530.anInt832 = arg4;
            aClass34_530.aByteArray837 = arg0;
            aClass34_530.anInt825 = 0;
            aClass34_530.anInt823 = arg1;
            aClass34_530.anInt847 = 0;
            aClass34_530.anInt834 = 0;
            aClass34_530.anInt831 = 0;
            aClass34_530.anInt846 = 0;
            method292(aClass34_530);
            arg1 -= aClass34_530.anInt823;
            aClass34_530.aByteArray830 = null;
            aClass34_530.aByteArray837 = null;
            return arg1;
        }
    }
}
