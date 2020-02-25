package com.jagex.runescape;

import com.jagex.runescape.cache.def.*;

import static com.jagex.runescape.net.IncomingPackets.*;

public class CollisionMap {
    public static int anInt141;
    public static int anInt158;
    public static Object anObject162 = new Object();
    public static int anInt163 = -1;
    public static RSString aClass1_164 = RSString.CreateString("Konfig geladen)3");
    public static int anInt165 = 0;
    public static Class8 aClass8_166;
    public static RSString str_continue = RSString.CreateString("Continue");
    public static int anInt168;
    public static byte[] aByteArray169 = new byte[]{95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    public static RSString aClass1_170 = RSString.CreateString("(X");
    public static int anInt172;


    public int anInt140;
    public int anInt145;
    public int[][] anIntArrayArray150;
    public int anInt151;
    public int anInt153;

    public CollisionMap(int arg0, int arg1) {

        anInt145 = arg1;
        anInt151 = 0;
        anInt140 = 0;
        anInt153 = arg0;
        anIntArrayArray150 = new int[anInt153][anInt145];
        method146(16777216);

    }

    public static void method144(int arg0) {

        Class8.fontMetrics = null;
        Class17.helveticaBold = null;
        if(arg0 == 12433)
            Class26.anImage624 = null;

    }

    public static void method152(int arg0) {

        aByteArray169 = null;
        anObject162 = null;
        str_continue = null;
        if(arg0 == -19156) {
            aClass1_170 = null;
            aClass1_164 = null;
            aClass8_166 = null;
        }

    }

    public static int method157(int arg0, int arg1, int arg2) {
        int i = (Class42.method884(-1 + arg1, -1 + arg2, 37821) + Class42.method884(1 + arg1, arg2 - 1, 37821) + Class42.method884(-1 + arg1, 1 + arg2, 37821) + Class42.method884(1 + arg1, arg2 + 1, 37821));
        if(arg0 != 0)
            return 56;
        int i_126_ = (Class42.method884(arg1 - 1, arg2, 37821) + Class42.method884(arg1 + 1, arg2, 37821) - (-Class42.method884(arg1, arg2 - 1, 37821) + -Class42.method884(arg1, 1 + arg2, 37821)));
        int i_127_ = Class42.method884(arg1, arg2, 37821);
        return i / 16 - (-(i_126_ / 8) - i_127_ / 4);
    }

    public void method143(boolean arg0, int arg1, int arg2, int arg3) {
        if(arg0 != true)
            anIntArrayArray150 = null;
        anIntArrayArray150[arg1][arg2] = UnderlayDefinition.bitWiseOR(anIntArrayArray150[arg1][arg2], arg3);
    }

    public void method145(int arg0, int arg1, int arg2) {
        arg0 -= anInt151;
        if(arg1 == 28227) {
            arg2 -= anInt140;
            anIntArrayArray150[arg2][arg0] = HuffmanEncoding.method1021(anIntArrayArray150[arg2][arg0], 14680063);
        }
    }

    public void method146(int arg0) {
        if(arg0 == 16777216) {
            for(int i = 0; anInt153 > i; i++) {
                for(int i_0_ = 0; (anInt145 > i_0_); i_0_++) {
                    if(i != 0 && i_0_ != 0 && i != anInt153 - 1 && i_0_ != -1 + anInt145)
                        anIntArrayArray150[i][i_0_] = 16777216;
                    else
                        anIntArrayArray150[i][i_0_] = 16777215;
                }
            }
        }
    }

    public void method148(int arg0, int arg1, int arg2, boolean arg3, int arg4, int arg5) {
        arg4 -= anInt151;
        if(arg0 != -4)
            anInt165 = 110;
        arg1 -= anInt140;
        if(arg5 == 0) {
            if(arg2 == 0) {
                method156(arg4, 128, arg1, (byte) 124);
                method156(arg4, 8, -1 + arg1, (byte) 124);
            }
            if(arg2 == 1) {
                method156(arg4, 2, arg1, (byte) 124);
                method156(arg4 + 1, 32, arg1, (byte) 124);
            }
            if(arg2 == 2) {
                method156(arg4, 8, arg1, (byte) 124);
                method156(arg4, 128, 1 + arg1, (byte) 124);
            }
            if(arg2 == 3) {
                method156(arg4, 32, arg1, (byte) 124);
                method156(-1 + arg4, 2, arg1, (byte) 124);
            }
        }
        if(arg5 == 1 || arg5 == 3) {
            if(arg2 == 0) {
                method156(arg4, 1, arg1, (byte) 124);
                method156(arg4 + 1, 16, -1 + arg1, (byte) 124);
            }
            if(arg2 == 1) {
                method156(arg4, 4, arg1, (byte) 124);
                method156(1 + arg4, 64, 1 + arg1, (byte) 124);
            }
            if(arg2 == 2) {
                method156(arg4, 16, arg1, (byte) 124);
                method156(-1 + arg4, 1, arg1 + 1, (byte) 124);
            }
            if(arg2 == 3) {
                method156(arg4, 64, arg1, (byte) 124);
                method156(arg4 - 1, 4, -1 + arg1, (byte) 124);
            }
        }
        if(arg5 == 2) {
            if(arg2 == 0) {
                method156(arg4, 130, arg1, (byte) 124);
                method156(arg4, 8, -1 + arg1, (byte) 124);
                method156(arg4 + 1, 32, arg1, (byte) 124);
            }
            if(arg2 == 1) {
                method156(arg4, 10, arg1, (byte) 124);
                method156(1 + arg4, 32, arg1, (byte) 124);
                method156(arg4, 128, 1 + arg1, (byte) 124);
            }
            if(arg2 == 2) {
                method156(arg4, 40, arg1, (byte) 124);
                method156(arg4, 128, arg1 + 1, (byte) 124);
                method156(-1 + arg4, 2, arg1, (byte) 124);
            }
            if(arg2 == 3) {
                method156(arg4, 160, arg1, (byte) 124);
                method156(-1 + arg4, 2, arg1, (byte) 124);
                method156(arg4, 8, arg1 + -1, (byte) 124);
            }
        }
        if(arg3) {
            if(arg5 == 0) {
                if(arg2 == 0) {
                    method156(arg4, 65536, arg1, (byte) 124);
                    method156(arg4, 4096, arg1 + -1, (byte) 124);
                }
                if(arg2 == 1) {
                    method156(arg4, 1024, arg1, (byte) 124);
                    method156(1 + arg4, 16384, arg1, (byte) 124);
                }
                if(arg2 == 2) {
                    method156(arg4, 4096, arg1, (byte) 124);
                    method156(arg4, 65536, 1 + arg1, (byte) 124);
                }
                if(arg2 == 3) {
                    method156(arg4, 16384, arg1, (byte) 124);
                    method156(-1 + arg4, 1024, arg1, (byte) 124);
                }
            }
            if(arg5 == 1 || arg5 == 3) {
                if(arg2 == 0) {
                    method156(arg4, 512, arg1, (byte) 124);
                    method156(arg4 + 1, 8192, arg1 + -1, (byte) 124);
                }
                if(arg2 == 1) {
                    method156(arg4, 2048, arg1, (byte) 124);
                    method156(1 + arg4, 32768, 1 + arg1, (byte) 124);
                }
                if(arg2 == 2) {
                    method156(arg4, 8192, arg1, (byte) 124);
                    method156(arg4 - 1, 512, 1 + arg1, (byte) 124);
                }
                if(arg2 == 3) {
                    method156(arg4, 32768, arg1, (byte) 124);
                    method156(arg4 - 1, 2048, arg1 + -1, (byte) 124);
                }
            }
            if(arg5 == 2) {
                if(arg2 == 0) {
                    method156(arg4, 66560, arg1, (byte) 124);
                    method156(arg4, 4096, arg1 + -1, (byte) 124);
                    method156(arg4 + 1, 16384, arg1, (byte) 124);
                }
                if(arg2 == 1) {
                    method156(arg4, 5120, arg1, (byte) 124);
                    method156(arg4 + 1, 16384, arg1, (byte) 124);
                    method156(arg4, 65536, 1 + arg1, (byte) 124);
                }
                if(arg2 == 2) {
                    method156(arg4, 20480, arg1, (byte) 124);
                    method156(arg4, 65536, 1 + arg1, (byte) 124);
                    method156(arg4 - 1, 1024, arg1, (byte) 124);
                }
                if(arg2 == 3) {
                    method156(arg4, 81920, arg1, (byte) 124);
                    method156(-1 + arg4, 1024, arg1, (byte) 124);
                    method156(arg4, 4096, -1 + arg1, (byte) 124);
                }
            }
        }
    }

    public void method149(boolean arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6) {
        arg1 -= anInt151;
        if(arg3 == 1 || arg3 == 3) {
            int i = arg4;
            arg4 = arg6;
            arg6 = i;
        }
        int i = 256;
        if(arg0)
            i += 131072;
        arg2 -= anInt140;
        for(int i_119_ = arg2; (arg4 + arg2 > i_119_); i_119_++) {
            if(i_119_ >= 0 && (i_119_ < anInt153)) {
                for(int i_120_ = arg1; (arg6 + arg1 > i_120_); i_120_++) {
                    if(i_120_ >= 0 && anInt145 > i_120_)
                        method156(i_120_, i, i_119_, (byte) 124);
                }
            }
        }
        if(arg5 != -55)
            anInt168 = 102;
    }

    public void method150(int arg0, int arg1, int arg2, int arg3, boolean arg4, byte arg5) {
        arg0 -= anInt151;
        arg3 -= anInt140;
        if(arg5 != 95)
            anInt163 = 47;
        if(arg1 == 0) {
            if(arg2 == 0) {
                method143(true, arg3, arg0, 128);
                method143(true, arg3 - 1, arg0, 8);
            }
            if(arg2 == 1) {
                method143(true, arg3, arg0, 2);
                method143(true, arg3, 1 + arg0, 32);
            }
            if(arg2 == 2) {
                method143(true, arg3, arg0, 8);
                method143(true, 1 + arg3, arg0, 128);
            }
            if(arg2 == 3) {
                method143(true, arg3, arg0, 32);
                method143(true, arg3, arg0 + -1, 2);
            }
        }
        if(arg1 == 1 || arg1 == 3) {
            if(arg2 == 0) {
                method143(true, arg3, arg0, 1);
                method143(true, -1 + arg3, arg0 + 1, 16);
            }
            if(arg2 == 1) {
                method143(true, arg3, arg0, 4);
                method143(true, 1 + arg3, 1 + arg0, 64);
            }
            if(arg2 == 2) {
                method143(true, arg3, arg0, 16);
                method143(true, 1 + arg3, -1 + arg0, 1);
            }
            if(arg2 == 3) {
                method143(true, arg3, arg0, 64);
                method143(true, -1 + arg3, arg0 + -1, 4);
            }
        }
        if(arg1 == 2) {
            if(arg2 == 0) {
                method143(true, arg3, arg0, 130);
                method143(true, -1 + arg3, arg0, 8);
                method143(true, arg3, 1 + arg0, 32);
            }
            if(arg2 == 1) {
                method143(true, arg3, arg0, 10);
                method143(true, arg3, 1 + arg0, 32);
                method143(true, 1 + arg3, arg0, 128);
            }
            if(arg2 == 2) {
                method143(true, arg3, arg0, 40);
                method143(true, arg3 + 1, arg0, 128);
                method143(true, arg3, -1 + arg0, 2);
            }
            if(arg2 == 3) {
                method143(true, arg3, arg0, 160);
                method143(true, arg3, arg0 - 1, 2);
                method143(true, arg3 + -1, arg0, 8);
            }
        }
        if(arg4) {
            if(arg1 == 0) {
                if(arg2 == 0) {
                    method143(true, arg3, arg0, 65536);
                    method143(true, -1 + arg3, arg0, 4096);
                }
                if(arg2 == 1) {
                    method143(true, arg3, arg0, 1024);
                    method143(true, arg3, 1 + arg0, 16384);
                }
                if(arg2 == 2) {
                    method143(true, arg3, arg0, 4096);
                    method143(true, 1 + arg3, arg0, 65536);
                }
                if(arg2 == 3) {
                    method143(true, arg3, arg0, 16384);
                    method143(true, arg3, -1 + arg0, 1024);
                }
            }
            if(arg1 == 1 || arg1 == 3) {
                if(arg2 == 0) {
                    method143(true, arg3, arg0, 512);
                    method143(true, -1 + arg3, 1 + arg0, 8192);
                }
                if(arg2 == 1) {
                    method143(true, arg3, arg0, 2048);
                    method143(true, arg3 + 1, arg0 + 1, 32768);
                }
                if(arg2 == 2) {
                    method143(true, arg3, arg0, 8192);
                    method143(true, 1 + arg3, arg0 - 1, 512);
                }
                if(arg2 == 3) {
                    method143(true, arg3, arg0, 32768);
                    method143(true, arg3 - 1, -1 + arg0, 2048);
                }
            }
            if(arg1 == 2) {
                if(arg2 == 0) {
                    method143(true, arg3, arg0, 66560);
                    method143(true, -1 + arg3, arg0, 4096);
                    method143(true, arg3, 1 + arg0, 16384);
                }
                if(arg2 == 1) {
                    method143(true, arg3, arg0, 5120);
                    method143(true, arg3, arg0 + 1, 16384);
                    method143(true, 1 + arg3, arg0, 65536);
                }
                if(arg2 == 2) {
                    method143(true, arg3, arg0, 20480);
                    method143(true, 1 + arg3, arg0, 65536);
                    method143(true, arg3, -1 + arg0, 1024);
                }
                if(arg2 == 3) {
                    method143(true, arg3, arg0, 81920);
                    method143(true, arg3, arg0 + -1, 1024);
                    method143(true, arg3 - 1, arg0, 4096);
                }
            }
        }
    }

    public void markBlocked(byte arg0, int arg1, int arg2) {
        arg1 -= anInt151;
        arg2 -= anInt140;
        if(arg0 != -28)
            anInt153 = -24;
        anIntArrayArray150[arg2][arg1] = UnderlayDefinition.bitWiseOR(anIntArrayArray150[arg2][arg1], 2097152);
    }

    public boolean method153(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg0 > -3)
            method153(67, -89, 45, -123, -39, -109, -38, -78);
        int i = arg2 + arg3 + -1;
        int i_121_ = -1 + arg4 + arg1;
        if(arg2 <= arg7 && i >= arg7 && arg4 <= arg6 && i_121_ >= arg6)
            return true;
        if(arg2 + -1 == arg7 && arg4 <= arg6 && (i_121_ >= arg6) && (anIntArrayArray150[-anInt140 + arg7][-anInt151 + arg6] & 0x8) == 0 && (arg5 & 0x8) == 0)
            return true;
        if(arg7 == i + 1 && arg4 <= arg6 && arg6 <= i_121_ && (anIntArrayArray150[arg7 - anInt140][arg6 + -anInt151] & 0x80) == 0 && (0x2 & arg5) == 0)
            return true;
        if(arg4 - 1 == arg6 && arg2 <= arg7 && i >= arg7 && (anIntArrayArray150[arg7 - anInt140][arg6 - anInt151] & 0x2) == 0 && (arg5 & 0x4) == 0)
            return true;
        return arg6 == 1 + i_121_ && arg7 >= arg2 && arg7 <= i && (anIntArrayArray150[-anInt140 + arg7][arg6 - anInt151] & 0x20) == 0 && (0x1 & arg5) == 0;
    }

    public void method154(int arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        arg5 -= anInt151;
        int i = 62 % ((arg2 - 5) / 40);
        if(arg4 == 1 || arg4 == 3) {
            int i_122_ = arg6;
            arg6 = arg3;
            arg3 = i_122_;
        }
        arg0 -= anInt140;
        int i_123_ = 256;
        if(arg1)
            i_123_ += 131072;
        for(int i_124_ = arg0; i_124_ < arg0 + arg6; i_124_++) {
            if(i_124_ >= 0 && i_124_ < anInt153) {
                for(int i_125_ = arg5; (i_125_ < arg3 + arg5); i_125_++) {
                    if(i_125_ >= 0 && i_125_ < anInt145)
                        method143(true, i_124_, i_125_, i_123_);
                }
            }
        }
    }

    public boolean method155(int arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        if(arg6 == arg0 && arg3 == arg4)
            return true;
        if(arg1 != false)
            parseIncomingPackets(true);
        arg4 -= anInt151;
        arg6 -= anInt140;
        arg0 -= anInt140;
        arg3 -= anInt151;
        if(arg2 == 0) {
            if(arg5 != 0) {
                if(arg5 == 1) {
                    if(arg6 == arg0 && 1 + arg3 == arg4)
                        return true;
                    if(arg0 == -1 + arg6 && arg4 == arg3 && ((anIntArrayArray150[arg0][arg4] & 0x1280108) == 0))
                        return true;
                    if(1 + arg6 == arg0 && arg4 == arg3 && (anIntArrayArray150[arg0][arg4] & 0x1280180) == 0)
                        return true;
                } else if(arg5 == 2) {
                    if(arg0 == arg6 + 1 && arg3 == arg4)
                        return true;
                    if(arg0 == arg6 && arg4 == arg3 + 1 && ((anIntArrayArray150[arg0][arg4] & 0x1280120) == 0))
                        return true;
                    if(arg6 == arg0 && arg4 == arg3 + -1 && ((anIntArrayArray150[arg0][arg4] & 0x1280102) == 0))
                        return true;
                } else if(arg5 == 3) {
                    if(arg6 == arg0 && arg3 - 1 == arg4)
                        return true;
                    if(-1 + arg6 == arg0 && arg3 == arg4 && ((anIntArrayArray150[arg0][arg4] & 0x1280108) == 0))
                        return true;
                    if(arg0 == 1 + arg6 && arg4 == arg3 && (0x1280180 & anIntArrayArray150[arg0][arg4]) == 0)
                        return true;
                }
            } else {
                if(arg6 + -1 == arg0 && arg4 == arg3)
                    return true;
                if(arg6 == arg0 && arg4 == arg3 + 1 && (anIntArrayArray150[arg0][arg4] & 0x1280120) == 0)
                    return true;
                if(arg6 == arg0 && -1 + arg3 == arg4 && (0x1280102 & anIntArrayArray150[arg0][arg4]) == 0)
                    return true;
            }
        }
        if(arg2 == 2) {
            if(arg5 != 0) {
                if(arg5 != 1) {
                    if(arg5 != 2) {
                        if(arg5 == 3) {
                            if(arg0 == -1 + arg6 && arg4 == arg3)
                                return true;
                            if(arg0 == arg6 && (arg4 == arg3 + 1) && (0x1280120 & anIntArrayArray150[arg0][arg4]) == 0)
                                return true;
                            if(arg0 == arg6 + 1 && arg3 == arg4 && (0x1280180 & anIntArrayArray150[arg0][arg4]) == 0)
                                return true;
                            if(arg6 == arg0 && arg3 + -1 == arg4)
                                return true;
                        }
                    } else {
                        if(arg6 + -1 == arg0 && arg4 == arg3 && (anIntArrayArray150[arg0][arg4] & 0x1280108) == 0)
                            return true;
                        if(arg6 == arg0 && arg3 + 1 == arg4 && (0x1280120 & anIntArrayArray150[arg0][arg4]) == 0)
                            return true;
                        if(1 + arg6 == arg0 && arg3 == arg4)
                            return true;
                        if(arg0 == arg6 && arg3 + -1 == arg4)
                            return true;
                    }
                } else {
                    if(arg0 == -1 + arg6 && arg4 == arg3 && ((anIntArrayArray150[arg0][arg4] & 0x1280108) == 0))
                        return true;
                    if(arg0 == arg6 && arg4 == arg3 + 1)
                        return true;
                    if(arg0 == arg6 + 1 && arg3 == arg4)
                        return true;
                    if(arg0 == arg6 && arg4 == arg3 + -1 && (anIntArrayArray150[arg0][arg4] & 0x1280102) == 0)
                        return true;
                }
            } else {
                if(arg0 == -1 + arg6 && arg4 == arg3)
                    return true;
                if(arg0 == arg6 && arg4 == arg3 + 1)
                    return true;
                if(arg0 == arg6 + 1 && arg3 == arg4 && (anIntArrayArray150[arg0][arg4] & 0x1280180) == 0)
                    return true;
                if(arg6 == arg0 && arg4 == arg3 - 1 && (0x1280102 & anIntArrayArray150[arg0][arg4]) == 0)
                    return true;
            }
        }
        if(arg2 == 9) {
            if(arg6 == arg0 && arg4 == 1 + arg3 && ((0x20 & anIntArrayArray150[arg0][arg4]) == 0))
                return true;
            if(arg0 == arg6 && arg4 == -1 + arg3 && (0x2 & anIntArrayArray150[arg0][arg4]) == 0)
                return true;
            if(arg0 == -1 + arg6 && arg4 == arg3 && ((0x8 & anIntArrayArray150[arg0][arg4]) == 0))
                return true;
            return 1 + arg6 == arg0 && arg3 == arg4 && ((anIntArrayArray150[arg0][arg4] & 0x80) == 0);
        }
        return false;
    }

    public void method156(int arg0, int arg1, int arg2, byte arg3) {
        if(arg3 == 124) {
            anIntArrayArray150[arg2][arg0] = HuffmanEncoding.method1021(anIntArrayArray150[arg2][arg0], -arg1 + 16777215);
        }
    }

    public boolean method158(int arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6) {
        if(arg3 == arg4 && arg2 == arg0)
            return true;
        arg2 -= anInt151;
        arg3 -= anInt140;
        int i = -23 / ((37 - arg5) / 56);
        arg4 -= anInt140;
        arg0 -= anInt151;
        if(arg6 == 6 || arg6 == 7) {
            if(arg6 == 7)
                arg1 = arg1 + 2 & 0x3;
            if(arg1 == 0) {
                if(1 + arg3 == arg4 && arg2 == arg0 && (anIntArrayArray150[arg4][arg2] & 0x80) == 0)
                    return true;
                if(arg3 == arg4 && -1 + arg0 == arg2 && (0x2 & anIntArrayArray150[arg4][arg2]) == 0)
                    return true;
            } else if(arg1 != 1) {
                if(arg1 == 2) {
                    if(arg4 == arg3 + -1 && arg0 == arg2 && (anIntArrayArray150[arg4][arg2] & 0x8) == 0)
                        return true;
                    if(arg4 == arg3 && arg2 == 1 + arg0 && (0x20 & anIntArrayArray150[arg4][arg2]) == 0)
                        return true;
                } else if(arg1 == 3) {
                    if(arg3 + 1 == arg4 && arg0 == arg2 && (anIntArrayArray150[arg4][arg2] & 0x80) == 0)
                        return true;
                    if(arg4 == arg3 && arg2 == arg0 + 1 && (0x20 & anIntArrayArray150[arg4][arg2]) == 0)
                        return true;
                }
            } else {
                if(arg4 == arg3 + -1 && arg0 == arg2 && ((anIntArrayArray150[arg4][arg2] & 0x8) == 0))
                    return true;
                if(arg4 == arg3 && arg2 == arg0 + -1 && (anIntArrayArray150[arg4][arg2] & 0x2) == 0)
                    return true;
            }
        }
        if(arg6 == 8) {
            if(arg4 == arg3 && arg2 == arg0 + 1 && (anIntArrayArray150[arg4][arg2] & 0x20) == 0)
                return true;
            if(arg3 == arg4 && arg2 == arg0 + -1 && (anIntArrayArray150[arg4][arg2] & 0x2) == 0)
                return true;
            if(arg4 == arg3 - 1 && arg0 == arg2 && (anIntArrayArray150[arg4][arg2] & 0x8) == 0)
                return true;
            return 1 + arg3 == arg4 && arg2 == arg0 && ((0x80 & anIntArrayArray150[arg4][arg2]) == 0);
        }
        return false;
    }
}
