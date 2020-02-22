/* Class40_Sub5_Sub14_Sub4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.awt.image.PixelGrabber;

public class DirectColorSprite extends Rasterizer {
    public int anInt2949;
    public int anInt2950;
    public int anInt2951;
    public int anInt2952;
    public int anInt2953;
    public int anInt2954;
    public int[] anIntArray2955;

    public DirectColorSprite() {
        /* empty */
    }

    public DirectColorSprite(int arg0, int arg1) {
        anIntArray2955 = new int[arg0 * arg1];
        anInt2951 = anInt2954 = arg0;
        anInt2950 = anInt2952 = arg1;
        anInt2953 = anInt2949 = 0;
    }

    public DirectColorSprite(byte[] arg0, Component arg1) {
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(arg0);
            MediaTracker mediatracker = new MediaTracker(arg1);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            anInt2951 = image.getWidth(arg1);
            anInt2950 = image.getHeight(arg1);
            anInt2954 = anInt2951;
            anInt2952 = anInt2950;
            anInt2953 = 0;
            anInt2949 = 0;
            anIntArray2955 = new int[anInt2951 * anInt2950];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, anInt2951, anInt2950, anIntArray2955, 0, anInt2951);
            pixelgrabber.grabPixels();
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
    }

    public static void method715(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        int i = arg3;
        for(int i_0_ = -arg8; i_0_ < 0; i_0_++) {
            int i_1_ = (arg4 >> 16) * arg11;
            for(int i_2_ = -arg7; i_2_ < 0; i_2_++) {
                arg2 = arg1[(arg3 >> 16) + i_1_];
                if(arg2 != 0)
                    arg0[arg5++] = arg2;
                else
                    arg5++;
                arg3 += arg9;
            }
            arg4 += arg10;
            arg3 = i;
            arg5 += arg6;
        }
    }

    public static void method718(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, byte[] arg9) {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 0x3);
        for(int i_21_ = -arg6; i_21_ < 0; i_21_++) {
            for(int i_22_ = i; i_22_ < 0; i_22_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            for(int i_23_ = arg5; i_23_ < 0; i_23_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0 && arg9[arg4] == 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public static void method719(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 0x3);
        for(int i_24_ = -arg6; i_24_ < 0; i_24_++) {
            for(int i_25_ = i; i_25_ < 0; i_25_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            for(int i_26_ = arg5; i_26_ < 0; i_26_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public static void method730(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        int i = 256 - arg9;
        for(int i_167_ = -arg6; i_167_ < 0; i_167_++) {
            for(int i_168_ = -arg5; i_168_ < 0; i_168_++) {
                arg2 = arg1[arg3++];
                if(arg2 != 0) {
                    int i_169_ = arg0[arg4];
                    arg0[arg4++] = (((arg2 & 0xff00ff) * arg9 + (i_169_ & 0xff00ff) * i & ~0xff00ff) + ((arg2 & 0xff00) * arg9 + (i_169_ & 0xff00) * i & 0xff0000)) >> 8;
                } else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public static void method731(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        for(int i = -arg5; i < 0; i++) {
            int i_170_ = arg3 + arg4 - 3;
            while(arg3 < i_170_) {
                arg0[arg3++] = arg1[arg2++];
                arg0[arg3++] = arg1[arg2++];
                arg0[arg3++] = arg1[arg2++];
                arg0[arg3++] = arg1[arg2++];
            }
            i_170_ += 3;
            while(arg3 < i_170_)
                arg0[arg3++] = arg1[arg2++];
            arg3 += arg6;
            arg2 += arg7;
        }
    }

    public static void method733(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        int i = 256 - arg12;
        int i_185_ = arg3;
        for(int i_186_ = -arg8; i_186_ < 0; i_186_++) {
            int i_187_ = (arg4 >> 16) * arg11;
            for(int i_188_ = -arg7; i_188_ < 0; i_188_++) {
                arg2 = arg1[(arg3 >> 16) + i_187_];
                if(arg2 != 0) {
                    int i_189_ = arg0[arg5];
                    arg0[arg5++] = (((arg2 & 0xff00ff) * arg12 + (i_189_ & 0xff00ff) * i & ~0xff00ff) + ((arg2 & 0xff00) * arg12 + (i_189_ & 0xff00) * i & 0xff0000)) >> 8;
                } else
                    arg5++;
                arg3 += arg9;
            }
            arg4 += arg10;
            arg3 = i_185_;
            arg5 += arg6;
        }
    }

    public void method716(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg2 > 0 && arg3 > 0) {
            int i = anInt2951;
            int i_3_ = anInt2950;
            int i_4_ = 0;
            int i_5_ = 0;
            int i_6_ = anInt2954;
            int i_7_ = anInt2952;
            int i_8_ = (i_6_ << 16) / arg2;
            int i_9_ = (i_7_ << 16) / arg3;
            if(anInt2953 > 0) {
                int i_10_ = ((anInt2953 << 16) + i_8_ - 1) / i_8_;
                arg0 += i_10_;
                i_4_ += i_10_ * i_8_ - (anInt2953 << 16);
            }
            if(anInt2949 > 0) {
                int i_11_ = ((anInt2949 << 16) + i_9_ - 1) / i_9_;
                arg1 += i_11_;
                i_5_ += i_11_ * i_9_ - (anInt2949 << 16);
            }
            if(i < i_6_)
                arg2 = ((i << 16) - i_4_ + i_8_ - 1) / i_8_;
            if(i_3_ < i_7_)
                arg3 = ((i_3_ << 16) - i_5_ + i_9_ - 1) / i_9_;
            int i_12_ = arg0 + arg1 * Rasterizer.anInt2768;
            int i_13_ = Rasterizer.anInt2768 - arg2;
            if(arg1 + arg3 > Rasterizer.anInt2770)
                arg3 -= arg1 + arg3 - Rasterizer.anInt2770;
            if(arg1 < Rasterizer.anInt2767) {
                int i_14_ = Rasterizer.anInt2767 - arg1;
                arg3 -= i_14_;
                i_12_ += i_14_ * Rasterizer.anInt2768;
                i_5_ += i_9_ * i_14_;
            }
            if(arg0 + arg2 > Rasterizer.anInt2772) {
                int i_15_ = arg0 + arg2 - Rasterizer.anInt2772;
                arg2 -= i_15_;
                i_13_ += i_15_;
            }
            if(arg0 < Rasterizer.anInt2771) {
                int i_16_ = Rasterizer.anInt2771 - arg0;
                arg2 -= i_16_;
                i_12_ += i_16_;
                i_4_ += i_8_ * i_16_;
                i_13_ += i_16_;
            }
            method733(Rasterizer.anIntArray2766, anIntArray2955, 0, i_4_, i_5_, i_12_, i_13_, arg2, arg3, i_8_, i_9_, i, arg4);
        }
    }

    public void method717(int arg0, int arg1, int arg2) {
        for(int i = 0; i < anIntArray2955.length; i++) {
            int i_17_ = anIntArray2955[i];
            if(i_17_ != 0) {
                int i_18_ = i_17_ >> 16 & 0xff;
                i_18_ += arg0;
                if(i_18_ < 1)
                    i_18_ = 1;
                else if(i_18_ > 255)
                    i_18_ = 255;
                int i_19_ = i_17_ >> 8 & 0xff;
                i_19_ += arg1;
                if(i_19_ < 1)
                    i_19_ = 1;
                else if(i_19_ > 255)
                    i_19_ = 255;
                int i_20_ = i_17_ & 0xff;
                i_20_ += arg2;
                if(i_20_ < 1)
                    i_20_ = 1;
                else if(i_20_ > 255)
                    i_20_ = 255;
                anIntArray2955[i] = (i_18_ << 16) + (i_19_ << 8) + i_20_;
            }
        }
    }

    public void method720(int arg0, int arg1, int arg2, int arg3) {
        method722(anInt2954 << 3, anInt2952 << 3, arg0 << 4, arg1 << 4, arg2, arg3);
    }

    public void method721(int arg0, int arg1) {
        arg0 += anInt2953;
        arg1 += anInt2949;
        int i = arg0 + arg1 * Rasterizer.anInt2768;
        int i_27_ = 0;
        int i_28_ = anInt2950;
        int i_29_ = anInt2951;
        int i_30_ = Rasterizer.anInt2768 - i_29_;
        int i_31_ = 0;
        if(arg1 < Rasterizer.anInt2767) {
            int i_32_ = Rasterizer.anInt2767 - arg1;
            i_28_ -= i_32_;
            arg1 = Rasterizer.anInt2767;
            i_27_ += i_32_ * i_29_;
            i += i_32_ * Rasterizer.anInt2768;
        }
        if(arg1 + i_28_ > Rasterizer.anInt2770)
            i_28_ -= arg1 + i_28_ - Rasterizer.anInt2770;
        if(arg0 < Rasterizer.anInt2771) {
            int i_33_ = Rasterizer.anInt2771 - arg0;
            i_29_ -= i_33_;
            arg0 = Rasterizer.anInt2771;
            i_27_ += i_33_;
            i += i_33_;
            i_31_ += i_33_;
            i_30_ += i_33_;
        }
        if(arg0 + i_29_ > Rasterizer.anInt2772) {
            int i_34_ = arg0 + i_29_ - Rasterizer.anInt2772;
            i_29_ -= i_34_;
            i_31_ += i_34_;
            i_30_ += i_34_;
        }
        if(i_29_ > 0 && i_28_ > 0)
            method719(Rasterizer.anIntArray2766, anIntArray2955, 0, i_27_, i, i_29_, i_28_, i_30_, i_31_);
    }

    public void method722(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg5 != 0) {
            arg0 -= anInt2953 << 4;
            arg1 -= anInt2949 << 4;
            double d = (double) (arg4 & 0xffff) * 9.587379924285257E-5;
            int i = (int) Math.floor(Math.sin(d) * (double) arg5 + 0.5);
            int i_35_ = (int) Math.floor(Math.cos(d) * (double) arg5 + 0.5);
            int i_36_ = -arg0 * i_35_ + -arg1 * i;
            int i_37_ = arg0 * i + -arg1 * i_35_;
            int i_38_ = ((anInt2951 << 4) - arg0) * i_35_ + -arg1 * i;
            int i_39_ = -((anInt2951 << 4) - arg0) * i + -arg1 * i_35_;
            int i_40_ = -arg0 * i_35_ + ((anInt2950 << 4) - arg1) * i;
            int i_41_ = arg0 * i + ((anInt2950 << 4) - arg1) * i_35_;
            int i_42_ = (((anInt2951 << 4) - arg0) * i_35_ + ((anInt2950 << 4) - arg1) * i);
            int i_43_ = (-((anInt2951 << 4) - arg0) * i + ((anInt2950 << 4) - arg1) * i_35_);
            int i_44_;
            int i_45_;
            if(i_36_ < i_38_) {
                i_44_ = i_36_;
                i_45_ = i_38_;
            } else {
                i_44_ = i_38_;
                i_45_ = i_36_;
            }
            if(i_40_ < i_44_)
                i_44_ = i_40_;
            if(i_42_ < i_44_)
                i_44_ = i_42_;
            if(i_40_ > i_45_)
                i_45_ = i_40_;
            if(i_42_ > i_45_)
                i_45_ = i_42_;
            int i_46_;
            int i_47_;
            if(i_37_ < i_39_) {
                i_46_ = i_37_;
                i_47_ = i_39_;
            } else {
                i_46_ = i_39_;
                i_47_ = i_37_;
            }
            if(i_41_ < i_46_)
                i_46_ = i_41_;
            if(i_43_ < i_46_)
                i_46_ = i_43_;
            if(i_41_ > i_47_)
                i_47_ = i_41_;
            if(i_43_ > i_47_)
                i_47_ = i_43_;
            i_44_ >>= 12;
            i_45_ = i_45_ + 4095 >> 12;
            i_46_ >>= 12;
            i_47_ = i_47_ + 4095 >> 12;
            i_44_ += arg2;
            i_45_ += arg2;
            i_46_ += arg3;
            i_47_ += arg3;
            i_44_ >>= 4;
            i_45_ = i_45_ + 15 >> 4;
            i_46_ >>= 4;
            i_47_ = i_47_ + 15 >> 4;
            if(i_44_ < Rasterizer.anInt2771)
                i_44_ = Rasterizer.anInt2771;
            if(i_45_ > Rasterizer.anInt2772)
                i_45_ = Rasterizer.anInt2772;
            if(i_46_ < Rasterizer.anInt2767)
                i_46_ = Rasterizer.anInt2767;
            if(i_47_ > Rasterizer.anInt2770)
                i_47_ = Rasterizer.anInt2770;
            i_45_ = i_44_ - i_45_;
            if(i_45_ < 0) {
                i_47_ = i_46_ - i_47_;
                if(i_47_ < 0) {
                    int i_48_ = i_46_ * Rasterizer.anInt2768 + i_44_;
                    double d_49_ = 1.6777216E7 / (double) arg5;
                    int i_50_ = (int) Math.floor(Math.sin(d) * d_49_ + 0.5);
                    int i_51_ = (int) Math.floor(Math.cos(d) * d_49_ + 0.5);
                    int i_52_ = (i_44_ << 4) + 8 - arg2;
                    int i_53_ = (i_46_ << 4) + 8 - arg3;
                    int i_54_ = (arg0 << 8) - (i_53_ * i_50_ >> 4);
                    int i_55_ = (arg1 << 8) + (i_53_ * i_51_ >> 4);
                    if(i_51_ == 0) {
                        if(i_50_ == 0) {
                            int i_56_ = i_47_;
                            while(i_56_ < 0) {
                                int i_57_ = i_48_;
                                int i_58_ = i_54_;
                                int i_59_ = i_55_;
                                int i_60_ = i_45_;
                                if(i_58_ >= 0 && i_59_ >= 0 && i_58_ - (anInt2951 << 12) < 0 && i_59_ - (anInt2950 << 12) < 0) {
                                    for(/**/; i_60_ < 0; i_60_++) {
                                        int i_61_ = (anIntArray2955[((i_59_ >> 12) * anInt2951 + (i_58_ >> 12))]);
                                        if(i_61_ != 0)
                                            Rasterizer.anIntArray2766[i_57_++] = i_61_;
                                        else
                                            i_57_++;
                                    }
                                }
                                i_56_++;
                                i_48_ += Rasterizer.anInt2768;
                            }
                        } else if(i_50_ < 0) {
                            int i_62_ = i_47_;
                            while(i_62_ < 0) {
                                int i_63_ = i_48_;
                                int i_64_ = i_54_;
                                int i_65_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_66_ = i_45_;
                                if(i_64_ >= 0 && i_64_ - (anInt2951 << 12) < 0) {
                                    int i_67_;
                                    if((i_67_ = i_65_ - (anInt2950 << 12)) >= 0) {
                                        i_67_ = (i_50_ - i_67_) / i_50_;
                                        i_66_ += i_67_;
                                        i_65_ += i_50_ * i_67_;
                                        i_63_ += i_67_;
                                    }
                                    if((i_67_ = (i_65_ - i_50_) / i_50_) > i_66_)
                                        i_66_ = i_67_;
                                    for(/**/; i_66_ < 0; i_66_++) {
                                        int i_68_ = (anIntArray2955[((i_65_ >> 12) * anInt2951 + (i_64_ >> 12))]);
                                        if(i_68_ != 0)
                                            Rasterizer.anIntArray2766[i_63_++] = i_68_;
                                        else
                                            i_63_++;
                                        i_65_ += i_50_;
                                    }
                                }
                                i_62_++;
                                i_54_ -= i_50_;
                                i_48_ += Rasterizer.anInt2768;
                            }
                        } else {
                            int i_69_ = i_47_;
                            while(i_69_ < 0) {
                                int i_70_ = i_48_;
                                int i_71_ = i_54_;
                                int i_72_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_73_ = i_45_;
                                if(i_71_ >= 0 && i_71_ - (anInt2951 << 12) < 0) {
                                    if(i_72_ < 0) {
                                        int i_74_ = (i_50_ - 1 - i_72_) / i_50_;
                                        i_73_ += i_74_;
                                        i_72_ += i_50_ * i_74_;
                                        i_70_ += i_74_;
                                    }
                                    int i_75_;
                                    if((i_75_ = (1 + i_72_ - (anInt2950 << 12) - i_50_) / i_50_) > i_73_)
                                        i_73_ = i_75_;
                                    for(/**/; i_73_ < 0; i_73_++) {
                                        int i_76_ = (anIntArray2955[((i_72_ >> 12) * anInt2951 + (i_71_ >> 12))]);
                                        if(i_76_ != 0)
                                            Rasterizer.anIntArray2766[i_70_++] = i_76_;
                                        else
                                            i_70_++;
                                        i_72_ += i_50_;
                                    }
                                }
                                i_69_++;
                                i_54_ -= i_50_;
                                i_48_ += Rasterizer.anInt2768;
                            }
                        }
                    } else if(i_51_ < 0) {
                        if(i_50_ == 0) {
                            int i_77_ = i_47_;
                            while(i_77_ < 0) {
                                int i_78_ = i_48_;
                                int i_79_ = i_54_ + (i_52_ * i_51_ >> 4);
                                int i_80_ = i_55_;
                                int i_81_ = i_45_;
                                if(i_80_ >= 0 && i_80_ - (anInt2950 << 12) < 0) {
                                    int i_82_;
                                    if((i_82_ = i_79_ - (anInt2951 << 12)) >= 0) {
                                        i_82_ = (i_51_ - i_82_) / i_51_;
                                        i_81_ += i_82_;
                                        i_79_ += i_51_ * i_82_;
                                        i_78_ += i_82_;
                                    }
                                    if((i_82_ = (i_79_ - i_51_) / i_51_) > i_81_)
                                        i_81_ = i_82_;
                                    for(/**/; i_81_ < 0; i_81_++) {
                                        int i_83_ = (anIntArray2955[((i_80_ >> 12) * anInt2951 + (i_79_ >> 12))]);
                                        if(i_83_ != 0)
                                            Rasterizer.anIntArray2766[i_78_++] = i_83_;
                                        else
                                            i_78_++;
                                        i_79_ += i_51_;
                                    }
                                }
                                i_77_++;
                                i_55_ += i_51_;
                                i_48_ += Rasterizer.anInt2768;
                            }
                        } else if(i_50_ < 0) {
                            int i_84_ = i_47_;
                            while(i_84_ < 0) {
                                int i_85_ = i_48_;
                                int i_86_ = i_54_ + (i_52_ * i_51_ >> 4);
                                int i_87_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_88_ = i_45_;
                                int i_89_;
                                if((i_89_ = i_86_ - (anInt2951 << 12)) >= 0) {
                                    i_89_ = (i_51_ - i_89_) / i_51_;
                                    i_88_ += i_89_;
                                    i_86_ += i_51_ * i_89_;
                                    i_87_ += i_50_ * i_89_;
                                    i_85_ += i_89_;
                                }
                                if((i_89_ = (i_86_ - i_51_) / i_51_) > i_88_)
                                    i_88_ = i_89_;
                                if((i_89_ = i_87_ - (anInt2950 << 12)) >= 0) {
                                    i_89_ = (i_50_ - i_89_) / i_50_;
                                    i_88_ += i_89_;
                                    i_86_ += i_51_ * i_89_;
                                    i_87_ += i_50_ * i_89_;
                                    i_85_ += i_89_;
                                }
                                if((i_89_ = (i_87_ - i_50_) / i_50_) > i_88_)
                                    i_88_ = i_89_;
                                for(/**/; i_88_ < 0; i_88_++) {
                                    int i_90_ = (anIntArray2955[((i_87_ >> 12) * anInt2951 + (i_86_ >> 12))]);
                                    if(i_90_ != 0)
                                        Rasterizer.anIntArray2766[i_85_++] = i_90_;
                                    else
                                        i_85_++;
                                    i_86_ += i_51_;
                                    i_87_ += i_50_;
                                }
                                i_84_++;
                                i_54_ -= i_50_;
                                i_55_ += i_51_;
                                i_48_ += Rasterizer.anInt2768;
                            }
                        } else {
                            int i_91_ = i_47_;
                            while(i_91_ < 0) {
                                int i_92_ = i_48_;
                                int i_93_ = i_54_ + (i_52_ * i_51_ >> 4);
                                int i_94_ = i_55_ + (i_52_ * i_50_ >> 4);
                                int i_95_ = i_45_;
                                int i_96_;
                                if((i_96_ = i_93_ - (anInt2951 << 12)) >= 0) {
                                    i_96_ = (i_51_ - i_96_) / i_51_;
                                    i_95_ += i_96_;
                                    i_93_ += i_51_ * i_96_;
                                    i_94_ += i_50_ * i_96_;
                                    i_92_ += i_96_;
                                }
                                if((i_96_ = (i_93_ - i_51_) / i_51_) > i_95_)
                                    i_95_ = i_96_;
                                if(i_94_ < 0) {
                                    i_96_ = (i_50_ - 1 - i_94_) / i_50_;
                                    i_95_ += i_96_;
                                    i_93_ += i_51_ * i_96_;
                                    i_94_ += i_50_ * i_96_;
                                    i_92_ += i_96_;
                                }
                                if((i_96_ = (1 + i_94_ - (anInt2950 << 12) - i_50_) / i_50_) > i_95_)
                                    i_95_ = i_96_;
                                for(/**/; i_95_ < 0; i_95_++) {
                                    int i_97_ = (anIntArray2955[((i_94_ >> 12) * anInt2951 + (i_93_ >> 12))]);
                                    if(i_97_ != 0)
                                        Rasterizer.anIntArray2766[i_92_++] = i_97_;
                                    else
                                        i_92_++;
                                    i_93_ += i_51_;
                                    i_94_ += i_50_;
                                }
                                i_91_++;
                                i_54_ -= i_50_;
                                i_55_ += i_51_;
                                i_48_ += Rasterizer.anInt2768;
                            }
                        }
                    } else if(i_50_ == 0) {
                        int i_98_ = i_47_;
                        while(i_98_ < 0) {
                            int i_99_ = i_48_;
                            int i_100_ = i_54_ + (i_52_ * i_51_ >> 4);
                            int i_101_ = i_55_;
                            int i_102_ = i_45_;
                            if(i_101_ >= 0 && i_101_ - (anInt2950 << 12) < 0) {
                                if(i_100_ < 0) {
                                    int i_103_ = (i_51_ - 1 - i_100_) / i_51_;
                                    i_102_ += i_103_;
                                    i_100_ += i_51_ * i_103_;
                                    i_99_ += i_103_;
                                }
                                int i_104_;
                                if((i_104_ = (1 + i_100_ - (anInt2951 << 12) - i_51_) / i_51_) > i_102_)
                                    i_102_ = i_104_;
                                for(/**/; i_102_ < 0; i_102_++) {
                                    int i_105_ = (anIntArray2955[((i_101_ >> 12) * anInt2951 + (i_100_ >> 12))]);
                                    if(i_105_ != 0)
                                        Rasterizer.anIntArray2766[i_99_++] = i_105_;
                                    else
                                        i_99_++;
                                    i_100_ += i_51_;
                                }
                            }
                            i_98_++;
                            i_55_ += i_51_;
                            i_48_ += Rasterizer.anInt2768;
                        }
                    } else if(i_50_ < 0) {
                        int i_106_ = i_47_;
                        while(i_106_ < 0) {
                            int i_107_ = i_48_;
                            int i_108_ = i_54_ + (i_52_ * i_51_ >> 4);
                            int i_109_ = i_55_ + (i_52_ * i_50_ >> 4);
                            int i_110_ = i_45_;
                            if(i_108_ < 0) {
                                int i_111_ = (i_51_ - 1 - i_108_) / i_51_;
                                i_110_ += i_111_;
                                i_108_ += i_51_ * i_111_;
                                i_109_ += i_50_ * i_111_;
                                i_107_ += i_111_;
                            }
                            int i_112_;
                            if((i_112_ = (1 + i_108_ - (anInt2951 << 12) - i_51_) / i_51_) > i_110_)
                                i_110_ = i_112_;
                            if((i_112_ = i_109_ - (anInt2950 << 12)) >= 0) {
                                i_112_ = (i_50_ - i_112_) / i_50_;
                                i_110_ += i_112_;
                                i_108_ += i_51_ * i_112_;
                                i_109_ += i_50_ * i_112_;
                                i_107_ += i_112_;
                            }
                            if((i_112_ = (i_109_ - i_50_) / i_50_) > i_110_)
                                i_110_ = i_112_;
                            for(/**/; i_110_ < 0; i_110_++) {
                                int i_113_ = (anIntArray2955[(i_109_ >> 12) * anInt2951 + (i_108_ >> 12)]);
                                if(i_113_ != 0)
                                    Rasterizer.anIntArray2766[i_107_++] = i_113_;
                                else
                                    i_107_++;
                                i_108_ += i_51_;
                                i_109_ += i_50_;
                            }
                            i_106_++;
                            i_54_ -= i_50_;
                            i_55_ += i_51_;
                            i_48_ += Rasterizer.anInt2768;
                        }
                    } else {
                        int i_114_ = i_47_;
                        while(i_114_ < 0) {
                            int i_115_ = i_48_;
                            int i_116_ = i_54_ + (i_52_ * i_51_ >> 4);
                            int i_117_ = i_55_ + (i_52_ * i_50_ >> 4);
                            int i_118_ = i_45_;
                            if(i_116_ < 0) {
                                int i_119_ = (i_51_ - 1 - i_116_) / i_51_;
                                i_118_ += i_119_;
                                i_116_ += i_51_ * i_119_;
                                i_117_ += i_50_ * i_119_;
                                i_115_ += i_119_;
                            }
                            int i_120_;
                            if((i_120_ = (1 + i_116_ - (anInt2951 << 12) - i_51_) / i_51_) > i_118_)
                                i_118_ = i_120_;
                            if(i_117_ < 0) {
                                i_120_ = (i_50_ - 1 - i_117_) / i_50_;
                                i_118_ += i_120_;
                                i_116_ += i_51_ * i_120_;
                                i_117_ += i_50_ * i_120_;
                                i_115_ += i_120_;
                            }
                            if((i_120_ = (1 + i_117_ - (anInt2950 << 12) - i_50_) / i_50_) > i_118_)
                                i_118_ = i_120_;
                            for(/**/; i_118_ < 0; i_118_++) {
                                int i_121_ = (anIntArray2955[(i_117_ >> 12) * anInt2951 + (i_116_ >> 12)]);
                                if(i_121_ != 0)
                                    Rasterizer.anIntArray2766[i_115_++] = i_121_;
                                else
                                    i_115_++;
                                i_116_ += i_51_;
                                i_117_ += i_50_;
                            }
                            i_114_++;
                            i_54_ -= i_50_;
                            i_55_ += i_51_;
                            i_48_ += Rasterizer.anInt2768;
                        }
                    }
                }
            }
        }
    }

    public void method723() {
        Rasterizer.method669(anIntArray2955, anInt2951, anInt2950);
    }

    public void method724(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int[] arg8, int[] arg9) {
        try {
            int i = -arg2 / 2;
            int i_122_ = -arg3 / 2;
            int i_123_ = (int) (Math.sin((double) arg6 / 326.11) * 65536.0);
            int i_124_ = (int) (Math.cos((double) arg6 / 326.11) * 65536.0);
            i_123_ = i_123_ * arg7 >> 8;
            i_124_ = i_124_ * arg7 >> 8;
            int i_125_ = (arg4 << 16) + (i_122_ * i_123_ + i * i_124_);
            int i_126_ = (arg5 << 16) + (i_122_ * i_124_ - i * i_123_);
            int i_127_ = arg0 + arg1 * Rasterizer.anInt2768;
            for(arg1 = 0; arg1 < arg3; arg1++) {
                int i_128_ = arg8[arg1];
                int i_129_ = i_127_ + i_128_;
                int i_130_ = i_125_ + i_124_ * i_128_;
                int i_131_ = i_126_ - i_123_ * i_128_;
                for(arg0 = -arg9[arg1]; arg0 < 0; arg0++) {
                    Rasterizer.anIntArray2766[i_129_++] = (anIntArray2955[(i_130_ >> 16) + (i_131_ >> 16) * anInt2951]);
                    i_130_ += i_124_;
                    i_131_ -= i_123_;
                }
                i_125_ += i_123_;
                i_126_ += i_124_;
                i_127_ += Rasterizer.anInt2768;
            }
        } catch(Exception exception) {
            /* empty */
        }
    }

    public void method725(IndexedColorSprite arg0, int arg1, int arg2) {
        arg1 += anInt2953;
        arg2 += anInt2949;
        int i = arg1 + arg2 * Rasterizer.anInt2768;
        int i_132_ = 0;
        int i_133_ = anInt2950;
        int i_134_ = anInt2951;
        int i_135_ = Rasterizer.anInt2768 - i_134_;
        int i_136_ = 0;
        if(arg2 < Rasterizer.anInt2767) {
            int i_137_ = Rasterizer.anInt2767 - arg2;
            i_133_ -= i_137_;
            arg2 = Rasterizer.anInt2767;
            i_132_ += i_137_ * i_134_;
            i += i_137_ * Rasterizer.anInt2768;
        }
        if(arg2 + i_133_ > Rasterizer.anInt2770)
            i_133_ -= arg2 + i_133_ - Rasterizer.anInt2770;
        if(arg1 < Rasterizer.anInt2771) {
            int i_138_ = Rasterizer.anInt2771 - arg1;
            i_134_ -= i_138_;
            arg1 = Rasterizer.anInt2771;
            i_132_ += i_138_;
            i += i_138_;
            i_136_ += i_138_;
            i_135_ += i_138_;
        }
        if(arg1 + i_134_ > Rasterizer.anInt2772) {
            int i_139_ = arg1 + i_134_ - Rasterizer.anInt2772;
            i_134_ -= i_139_;
            i_136_ += i_139_;
            i_135_ += i_139_;
        }
        if(i_134_ > 0 && i_133_ > 0)
            method718(Rasterizer.anIntArray2766, anIntArray2955, 0, i_132_, i, i_134_, i_133_, i_135_, i_136_, arg0.aByteArray2925);
    }

    public void method726() {
        if(anInt2951 != anInt2954 || anInt2950 != anInt2952) {
            int[] is = new int[anInt2954 * anInt2952];
            for(int i = 0; i < anInt2950; i++) {
                for(int i_140_ = 0; i_140_ < anInt2951; i_140_++)
                    is[(i + anInt2949) * anInt2954 + (i_140_ + anInt2953)] = anIntArray2955[i * anInt2951 + i_140_];
            }
            anIntArray2955 = is;
            anInt2951 = anInt2954;
            anInt2950 = anInt2952;
            anInt2953 = 0;
            anInt2949 = 0;
        }
    }

    public void method727(int arg0, int arg1) {
        arg0 += anInt2953;
        arg1 += anInt2949;
        int i = arg0 + arg1 * Rasterizer.anInt2768;
        int i_141_ = 0;
        int i_142_ = anInt2950;
        int i_143_ = anInt2951;
        int i_144_ = Rasterizer.anInt2768 - i_143_;
        int i_145_ = 0;
        if(arg1 < Rasterizer.anInt2767) {
            int i_146_ = Rasterizer.anInt2767 - arg1;
            i_142_ -= i_146_;
            arg1 = Rasterizer.anInt2767;
            i_141_ += i_146_ * i_143_;
            i += i_146_ * Rasterizer.anInt2768;
        }
        if(arg1 + i_142_ > Rasterizer.anInt2770)
            i_142_ -= arg1 + i_142_ - Rasterizer.anInt2770;
        if(arg0 < Rasterizer.anInt2771) {
            int i_147_ = Rasterizer.anInt2771 - arg0;
            i_143_ -= i_147_;
            arg0 = Rasterizer.anInt2771;
            i_141_ += i_147_;
            i += i_147_;
            i_145_ += i_147_;
            i_144_ += i_147_;
        }
        if(arg0 + i_143_ > Rasterizer.anInt2772) {
            int i_148_ = arg0 + i_143_ - Rasterizer.anInt2772;
            i_143_ -= i_148_;
            i_145_ += i_148_;
            i_144_ += i_148_;
        }
        if(i_143_ > 0 && i_142_ > 0)
            method731(Rasterizer.anIntArray2766, anIntArray2955, i_141_, i, i_143_, i_142_, i_144_, i_145_);
    }

    public void method728(int arg0, int arg1, int arg2) {
        arg0 += anInt2953;
        arg1 += anInt2949;
        int i = arg0 + arg1 * Rasterizer.anInt2768;
        int i_149_ = 0;
        int i_150_ = anInt2950;
        int i_151_ = anInt2951;
        int i_152_ = Rasterizer.anInt2768 - i_151_;
        int i_153_ = 0;
        if(arg1 < Rasterizer.anInt2767) {
            int i_154_ = Rasterizer.anInt2767 - arg1;
            i_150_ -= i_154_;
            arg1 = Rasterizer.anInt2767;
            i_149_ += i_154_ * i_151_;
            i += i_154_ * Rasterizer.anInt2768;
        }
        if(arg1 + i_150_ > Rasterizer.anInt2770)
            i_150_ -= arg1 + i_150_ - Rasterizer.anInt2770;
        if(arg0 < Rasterizer.anInt2771) {
            int i_155_ = Rasterizer.anInt2771 - arg0;
            i_151_ -= i_155_;
            arg0 = Rasterizer.anInt2771;
            i_149_ += i_155_;
            i += i_155_;
            i_153_ += i_155_;
            i_152_ += i_155_;
        }
        if(arg0 + i_151_ > Rasterizer.anInt2772) {
            int i_156_ = arg0 + i_151_ - Rasterizer.anInt2772;
            i_151_ -= i_156_;
            i_153_ += i_156_;
            i_152_ += i_156_;
        }
        if(i_151_ > 0 && i_150_ > 0)
            method730(Rasterizer.anIntArray2766, anIntArray2955, 0, i_149_, i, i_151_, i_150_, i_152_, i_153_, arg2);
    }

    public void method729(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, double arg6, int arg7) {
        try {
            int i = -arg2 / 2;
            int i_157_ = -arg3 / 2;
            int i_158_ = (int) (Math.sin(arg6) * 65536.0);
            int i_159_ = (int) (Math.cos(arg6) * 65536.0);
            i_158_ = i_158_ * arg7 >> 8;
            i_159_ = i_159_ * arg7 >> 8;
            int i_160_ = (arg4 << 16) + (i_157_ * i_158_ + i * i_159_);
            int i_161_ = (arg5 << 16) + (i_157_ * i_159_ - i * i_158_);
            int i_162_ = arg0 + arg1 * Rasterizer.anInt2768;
            for(arg1 = 0; arg1 < arg3; arg1++) {
                int i_163_ = i_162_;
                int i_164_ = i_160_;
                int i_165_ = i_161_;
                for(arg0 = -arg2; arg0 < 0; arg0++) {
                    int i_166_ = (anIntArray2955[(i_164_ >> 16) + (i_165_ >> 16) * anInt2951]);
                    if(i_166_ != 0)
                        Rasterizer.anIntArray2766[i_163_++] = i_166_;
                    else
                        i_163_++;
                    i_164_ += i_159_;
                    i_165_ -= i_158_;
                }
                i_160_ += i_158_;
                i_161_ += i_159_;
                i_162_ += Rasterizer.anInt2768;
            }
        } catch(Exception exception) {
            /* empty */
        }

    }

    public void method732(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 > 0 && arg3 > 0) {
            int i = anInt2951;
            int i_171_ = anInt2950;
            int i_172_ = 0;
            int i_173_ = 0;
            int i_174_ = anInt2954;
            int i_175_ = anInt2952;
            int i_176_ = (i_174_ << 16) / arg2;
            int i_177_ = (i_175_ << 16) / arg3;
            if(anInt2953 > 0) {
                int i_178_ = ((anInt2953 << 16) + i_176_ - 1) / i_176_;
                arg0 += i_178_;
                i_172_ += i_178_ * i_176_ - (anInt2953 << 16);
            }
            if(anInt2949 > 0) {
                int i_179_ = ((anInt2949 << 16) + i_177_ - 1) / i_177_;
                arg1 += i_179_;
                i_173_ += i_179_ * i_177_ - (anInt2949 << 16);
            }
            if(i < i_174_)
                arg2 = ((i << 16) - i_172_ + i_176_ - 1) / i_176_;
            if(i_171_ < i_175_)
                arg3 = ((i_171_ << 16) - i_173_ + i_177_ - 1) / i_177_;
            int i_180_ = arg0 + arg1 * Rasterizer.anInt2768;
            int i_181_ = Rasterizer.anInt2768 - arg2;
            if(arg1 + arg3 > Rasterizer.anInt2770)
                arg3 -= arg1 + arg3 - Rasterizer.anInt2770;
            if(arg1 < Rasterizer.anInt2767) {
                int i_182_ = Rasterizer.anInt2767 - arg1;
                arg3 -= i_182_;
                i_180_ += i_182_ * Rasterizer.anInt2768;
                i_173_ += i_177_ * i_182_;
            }
            if(arg0 + arg2 > Rasterizer.anInt2772) {
                int i_183_ = arg0 + arg2 - Rasterizer.anInt2772;
                arg2 -= i_183_;
                i_181_ += i_183_;
            }
            if(arg0 < Rasterizer.anInt2771) {
                int i_184_ = Rasterizer.anInt2771 - arg0;
                arg2 -= i_184_;
                i_180_ += i_184_;
                i_172_ += i_176_ * i_184_;
                i_181_ += i_184_;
            }
            method715(Rasterizer.anIntArray2766, anIntArray2955, 0, i_172_, i_173_, i_180_, i_181_, arg2, arg3, i_176_, i_177_, i);
        }
    }
}
