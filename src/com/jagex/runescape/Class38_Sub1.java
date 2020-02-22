package com.jagex.runescape;

import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.util.Signlink;

public class Class38_Sub1 extends Class38 {
    public static int anInt1899;
    public static int anInt1901;
    public static int anInt1902;
    public static int anInt1904;
    public static RSString aClass1_1905;
    public static RSString aClass1_1906 = Class58.method978(" has logged out)3");
    public static int anInt1907;
    public static int anInt1908;
    public static int[] anIntArray1909 = new int[99];
    public static int anInt1911;
    public static int anInt1913;
    public static int[] anIntArray1916;
    public static RSString aClass1_1917;
    public static RSString aClass1_1918;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1919;
    public static RSString aClass1_1920;
    public static RSString aClass1_1921;
    public static RSString aClass1_1922;
    public static int anInt1923;
    public static RSString aClass1_1924;

    static {
        aClass1_1905 = aClass1_1906;
        int i = 0;
        for(int i_27_ = 0; (i_27_ ^ 0xffffffff) > -100; i_27_++) {
            int i_28_ = i_27_ + 1;
            int i_29_ = (int) ((double) i_28_ + 300.0 * Math.pow(2.0, (double) i_28_ / 7.0));
            i += i_29_;
            anIntArray1909[i_27_] = i / 4;
        }
        anIntArray1916 = new int[50];
        aClass1_1918 = null;
        aClass1_1924 = Class58.method978("Attack");
        aClass1_1920 = Class58.method978("Loaded sprites");
        aClass1_1917 = aClass1_1924;
        aClass1_1921 = Class58.method978("b12_full");
        anInt1923 = 0;
        aClass1_1922 = aClass1_1920;
    }

    public int anInt1900;
    public int anInt1903;
    public long[] aLongArray1910 = new long[10];
    public int anInt1912;
    public long aLong1914;
    public int anInt1915;

    public Class38_Sub1() {

        method443(-10115);

    }

    public static void method445(int arg0) {
        anInt1908++;
        if((CollisionMap.anInt165 ^ 0xffffffff) != -1) {
            int i = 0;
            if(Class40_Sub5_Sub15.anInt2782 != 0)
                i = 1;
            for(int i_1_ = 0; i_1_ < 100; i_1_++) {
                if(Actor.chatMessages[i_1_] != null) {
                    int i_2_ = Class66.chatTypes[i_1_];
                    RSString class1 = Renderable.chatPlayerNames[i_1_];
                    if(class1 != null && class1.startsWith((byte) 116, Class51.whiteCrown))
                        class1 = class1.substring(5);
                    if(class1 != null && class1.startsWith((byte) 116, Class40_Sub5_Sub12.goldCrown))
                        class1 = class1.substring(5);
                    if((i_2_ == 3 || (i_2_ ^ 0xffffffff) == -8) && ((i_2_ ^ 0xffffffff) == -8 || (Class4.anInt185 ^ 0xffffffff) == -1 || ((Class4.anInt185 ^ 0xffffffff) == -2 && Class40_Sub2.hasFriend(class1, arg0 + -42391)))) {
                        int i_3_ = 329 + -(13 * i);
                        i++;
                        if((Class13.anInt420 ^ 0xffffffff) < -5 && ((i_3_ + -10 ^ 0xffffffff) > (Landscape.anInt1166 + -4 ^ 0xffffffff)) && ((-4 + Landscape.anInt1166 ^ 0xffffffff) >= (i_3_ + 3 ^ 0xffffffff))) {
                            int i_4_ = 25 + (Class53.aClass40_Sub5_Sub14_Sub1_1268.method685(Class40_Sub5_Sub17_Sub6.method832(arg0 + -9666, (new RSString[]{Class40_Sub5_Sub6.aClass1_2458, Class12.aClass1_392, class1, (Actor.chatMessages[i_1_])}))));
                            if(i_4_ > 450)
                                i_4_ = 450;
                            if(Class13.anInt420 < 4 + i_4_) {
                                Class60.anInt1400++;
                                if((Class19.anInt493 ^ 0xffffffff) <= -2) {
                                    Floor.method558(0, Class22_Sub1.aClass1_1865, 0, -501, 0, 2028, (Class40_Sub5_Sub17_Sub6.method832(-97, new RSString[]{Class26.aClass1_620, class1})));
                                    CollisionMap.anInt158++;
                                }
                                Floor.method558(0, Class38.aClass1_885, 0, -501, 0, 2051, (Class40_Sub5_Sub17_Sub6.method832(arg0 ^ 0x2613, new RSString[]{Class26.aClass1_620, class1})));
                                Floor.method558(0, FloorDecoration.aClass1_591, 0, arg0 ^ ~0x27d3, 0, 2045, (Class40_Sub5_Sub17_Sub6.method832(arg0 ^ ~0x2660, new RSString[]{Class26.aClass1_620, class1})));
                                Class40_Sub5_Sub6.anInt2453++;
                            }
                        }
                        if((i ^ 0xffffffff) <= -6)
                            return;
                    }
                    if((i_2_ == 5 || i_2_ == 6) && (Class4.anInt185 ^ 0xffffffff) > -3 && (++i ^ 0xffffffff) <= -6)
                        return;
                }
            }
            if(arg0 != 9767)
                anInt1923 = 48;
        }
    }

    public static boolean method446(Signlink arg0, int arg1, boolean arg2, byte arg3) {

        anInt1913++;
            if(arg3 != 30)
                method448(47, -7, 96, -97, (byte) -6, -111, true, -110, 57, -36, -84, -42);
            if(!Class39.method452(arg0, (byte) 121, arg2))
                return false;
            if((arg1 ^ 0xffffffff) < -1)
                RSString.aClass9_1684 = new Cache(arg1);
            return true;

    }

    public static void method447(byte arg0) {
        if(arg0 != 29)
            method448(79, 61, 50, -68, (byte) 53, -121, false, 1, 18, -15, 29, 27);
        anInt1899++;
        if(Class62.anInt1470 == 1) {
            if(Class57.anInt1338 >= 539 && (Class57.anInt1338 ^ 0xffffffff) >= -574 && RSString.anInt1668 >= 169 && RSString.anInt1668 < 205 && (Class40_Sub5_Sub11.anIntArray2626[0] ^ 0xffffffff) != 0) {
                Class40_Sub5_Sub10.aBoolean2597 = true;
                ISAAC.aBoolean505 = true;
                Class5.anInt208 = 0;
            }
            if(Class57.anInt1338 >= 569 && (Class57.anInt1338 ^ 0xffffffff) >= -600 && (RSString.anInt1668 ^ 0xffffffff) <= -169 && (RSString.anInt1668 ^ 0xffffffff) > -206 && (Class40_Sub5_Sub11.anIntArray2626[1] ^ 0xffffffff) != 0) {
                Class5.anInt208 = 1;
                ISAAC.aBoolean505 = true;
                Class40_Sub5_Sub10.aBoolean2597 = true;
            }
            if(Class57.anInt1338 >= 597 && Class57.anInt1338 <= 627 && RSString.anInt1668 >= 168 && (RSString.anInt1668 ^ 0xffffffff) > -206 && Class40_Sub5_Sub11.anIntArray2626[2] != -1) {
                Class40_Sub5_Sub10.aBoolean2597 = true;
                Class5.anInt208 = 2;
                ISAAC.aBoolean505 = true;
            }
            if(Class57.anInt1338 >= 625 && (Class57.anInt1338 ^ 0xffffffff) >= -670 && (RSString.anInt1668 ^ 0xffffffff) <= -169 && (RSString.anInt1668 ^ 0xffffffff) > -204 && (Class40_Sub5_Sub11.anIntArray2626[3] ^ 0xffffffff) != 0) {
                Class40_Sub5_Sub10.aBoolean2597 = true;
                ISAAC.aBoolean505 = true;
                Class5.anInt208 = 3;
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -667 && Class57.anInt1338 <= 696 && RSString.anInt1668 >= 168 && (RSString.anInt1668 ^ 0xffffffff) > -206 && Class40_Sub5_Sub11.anIntArray2626[4] != -1) {
                Class5.anInt208 = 4;
                ISAAC.aBoolean505 = true;
                Class40_Sub5_Sub10.aBoolean2597 = true;
            }
            if(Class57.anInt1338 >= 694 && Class57.anInt1338 <= 724 && (RSString.anInt1668 ^ 0xffffffff) <= -169 && RSString.anInt1668 < 205 && (Class40_Sub5_Sub11.anIntArray2626[5] ^ 0xffffffff) != 0) {
                Class40_Sub5_Sub10.aBoolean2597 = true;
                ISAAC.aBoolean505 = true;
                Class5.anInt208 = 5;
            }
            if(Class57.anInt1338 >= 722 && (Class57.anInt1338 ^ 0xffffffff) >= -757 && (RSString.anInt1668 ^ 0xffffffff) <= -170 && (RSString.anInt1668 ^ 0xffffffff) > -206 && Class40_Sub5_Sub11.anIntArray2626[6] != -1) {
                ISAAC.aBoolean505 = true;
                Class5.anInt208 = 6;
                Class40_Sub5_Sub10.aBoolean2597 = true;
            }
            if(Class57.anInt1338 >= 540 && (Class57.anInt1338 ^ 0xffffffff) >= -575 && RSString.anInt1668 >= 466 && RSString.anInt1668 < 502 && (Class40_Sub5_Sub11.anIntArray2626[7] ^ 0xffffffff) != 0) {
                Class5.anInt208 = 7;
                Class40_Sub5_Sub10.aBoolean2597 = true;
                ISAAC.aBoolean505 = true;
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -573 && Class57.anInt1338 <= 602 && (RSString.anInt1668 ^ 0xffffffff) <= -467 && RSString.anInt1668 < 503 && (Class40_Sub5_Sub11.anIntArray2626[8] ^ 0xffffffff) != 0) {
                ISAAC.aBoolean505 = true;
                Class40_Sub5_Sub10.aBoolean2597 = true;
                Class5.anInt208 = 8;
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -600 && Class57.anInt1338 <= 629 && (RSString.anInt1668 ^ 0xffffffff) <= -467 && RSString.anInt1668 < 503 && (Class40_Sub5_Sub11.anIntArray2626[9] ^ 0xffffffff) != 0) {
                Class40_Sub5_Sub10.aBoolean2597 = true;
                Class5.anInt208 = 9;
                ISAAC.aBoolean505 = true;
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -628 && (Class57.anInt1338 ^ 0xffffffff) >= -672 && (RSString.anInt1668 ^ 0xffffffff) <= -468 && (RSString.anInt1668 ^ 0xffffffff) > -503 && Class40_Sub5_Sub11.anIntArray2626[10] != -1) {
                Class5.anInt208 = 10;
                Class40_Sub5_Sub10.aBoolean2597 = true;
                ISAAC.aBoolean505 = true;
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -670 && Class57.anInt1338 <= 699 && (RSString.anInt1668 ^ 0xffffffff) <= -467 && RSString.anInt1668 < 503 && Class40_Sub5_Sub11.anIntArray2626[11] != -1) {
                Class5.anInt208 = 11;
                ISAAC.aBoolean505 = true;
                Class40_Sub5_Sub10.aBoolean2597 = true;
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -697 && (Class57.anInt1338 ^ 0xffffffff) >= -727 && (RSString.anInt1668 ^ 0xffffffff) <= -467 && (RSString.anInt1668 ^ 0xffffffff) > -504 && Class40_Sub5_Sub11.anIntArray2626[12] != -1) {
                ISAAC.aBoolean505 = true;
                Class40_Sub5_Sub10.aBoolean2597 = true;
                Class5.anInt208 = 12;
            }
            if(Class57.anInt1338 >= 724 && Class57.anInt1338 <= 758 && (RSString.anInt1668 ^ 0xffffffff) <= -467 && RSString.anInt1668 < 502 && Class40_Sub5_Sub11.anIntArray2626[13] != -1) {
                Class5.anInt208 = 13;
                ISAAC.aBoolean505 = true;
                Class40_Sub5_Sub10.aBoolean2597 = true;
            }
        }
    }

    public static boolean method448(int arg0, int arg1, int arg2, int arg3, byte arg4, int arg5, boolean arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {

        anInt1902++;
            for(int i = 0; (i ^ 0xffffffff) > -105; i++) {
                for(int i_8_ = 0; i_8_ < 104; i_8_++) {
                    Class57.anIntArrayArray1335[i][i_8_] = 0;
                    Landscape.anIntArrayArray1175[i][i_8_] = 99999999;
                }
            }
            Class57.anIntArrayArray1335[arg2][arg9] = 99;
            int i = 0;
            int i_9_ = arg9;
            boolean bool = false;
            int i_10_ = 0;
            Landscape.anIntArrayArray1175[arg2][arg9] = 0;
            int i_11_ = arg2;
            Class24.anIntArray581[i] = arg2;
            if(arg4 < 91)
                return false;
            Class10.anIntArray351[i++] = arg9;
            int i_12_ = Class24.anIntArray581.length;
            int[][] is = (Landscape.aCollisionMapArray1167[Player.anInt3267].anIntArrayArray150);
            while((i ^ 0xffffffff) != (i_10_ ^ 0xffffffff)) {
                i_9_ = Class10.anIntArray351[i_10_];
                i_11_ = Class24.anIntArray581[i_10_];
                i_10_ = (i_10_ + 1) % i_12_;
                if((arg3 ^ 0xffffffff) == (i_11_ ^ 0xffffffff) && (arg10 ^ 0xffffffff) == (i_9_ ^ 0xffffffff)) {
                    bool = true;
                    break;
                }
                if(arg5 != 0) {
                    if(arg5 >= 5 && (arg5 ^ 0xffffffff) != -11 || !(Landscape.aCollisionMapArray1167[Player.anInt3267].method155(i_11_, false, arg5 + -1, arg10, i_9_, arg7, arg3))) {
                        if(arg5 < 10 && (Landscape.aCollisionMapArray1167[Player.anInt3267].method158(arg10, arg7, i_9_, arg3, i_11_, (byte) 122, -1 + arg5))) {
                            bool = true;
                            break;
                        }
                    } else {
                        bool = true;
                        break;
                    }
                }
                if(arg0 != 0 && (arg8 ^ 0xffffffff) != -1 && (Landscape.aCollisionMapArray1167[Player.anInt3267].method153(-24, arg8, arg3, arg0, arg10, arg1, i_9_, i_11_))) {
                    bool = true;
                    break;
                }
                int i_13_ = Landscape.anIntArrayArray1175[i_11_][i_9_] + 1;
                if(i_11_ > 0 && (Class57.anIntArrayArray1335[-1 + i_11_][i_9_] ^ 0xffffffff) == -1 && (0x1280108 & is[i_11_ - 1][i_9_] ^ 0xffffffff) == -1) {
                    Class24.anIntArray581[i] = i_11_ - 1;
                    Class10.anIntArray351[i] = i_9_;
                    i = (1 + i) % i_12_;
                    Class57.anIntArrayArray1335[-1 + i_11_][i_9_] = 2;
                    Landscape.anIntArrayArray1175[i_11_ - 1][i_9_] = i_13_;
                }
                if((i_11_ ^ 0xffffffff) > -104 && (Class57.anIntArrayArray1335[i_11_ + 1][i_9_] ^ 0xffffffff) == -1 && (is[1 + i_11_][i_9_] & 0x1280180) == 0) {
                    Class24.anIntArray581[i] = i_11_ + 1;
                    Class10.anIntArray351[i] = i_9_;
                    i = (i + 1) % i_12_;
                    Class57.anIntArrayArray1335[i_11_ + 1][i_9_] = 8;
                    Landscape.anIntArrayArray1175[i_11_ + 1][i_9_] = i_13_;
                }
                if(i_9_ > 0 && (Class57.anIntArrayArray1335[i_11_][i_9_ - 1] ^ 0xffffffff) == -1 && (is[i_11_][-1 + i_9_] & 0x1280102) == 0) {
                    Class24.anIntArray581[i] = i_11_;
                    Class10.anIntArray351[i] = -1 + i_9_;
                    Class57.anIntArrayArray1335[i_11_][-1 + i_9_] = 1;
                    i = (i + 1) % i_12_;
                    Landscape.anIntArrayArray1175[i_11_][i_9_ - 1] = i_13_;
                }
                if((i_9_ ^ 0xffffffff) > -104 && (Class57.anIntArrayArray1335[i_11_][i_9_ + 1] ^ 0xffffffff) == -1 && (is[i_11_][i_9_ + 1] & 0x1280120 ^ 0xffffffff) == -1) {
                    Class24.anIntArray581[i] = i_11_;
                    Class10.anIntArray351[i] = 1 + i_9_;
                    Class57.anIntArrayArray1335[i_11_][i_9_ + 1] = 4;
                    Landscape.anIntArrayArray1175[i_11_][1 + i_9_] = i_13_;
                    i = (i + 1) % i_12_;
                }
                if((i_11_ ^ 0xffffffff) < -1 && (i_9_ ^ 0xffffffff) < -1 && (Class57.anIntArrayArray1335[-1 + i_11_][i_9_ - 1] ^ 0xffffffff) == -1 && (is[i_11_ - 1][-1 + i_9_] & 0x128010e) == 0 && (0x1280108 & is[i_11_ + -1][i_9_] ^ 0xffffffff) == -1 && (is[i_11_][-1 + i_9_] & 0x1280102 ^ 0xffffffff) == -1) {
                    Class24.anIntArray581[i] = -1 + i_11_;
                    Class10.anIntArray351[i] = i_9_ - 1;
                    i = (i + 1) % i_12_;
                    Class57.anIntArrayArray1335[i_11_ + -1][-1 + i_9_] = 3;
                    Landscape.anIntArrayArray1175[-1 + i_11_][i_9_ + -1] = i_13_;
                }
                if((i_11_ ^ 0xffffffff) > -104 && i_9_ > 0 && Class57.anIntArrayArray1335[i_11_ + 1][-1 + i_9_] == 0 && ((is[1 + i_11_][-1 + i_9_] & 0x1280183 ^ 0xffffffff) == -1) && (is[i_11_ + 1][i_9_] & 0x1280180) == 0 && (0x1280102 & is[i_11_][-1 + i_9_] ^ 0xffffffff) == -1) {
                    Class24.anIntArray581[i] = 1 + i_11_;
                    Class10.anIntArray351[i] = i_9_ - 1;
                    i = (i + 1) % i_12_;
                    Class57.anIntArrayArray1335[1 + i_11_][-1 + i_9_] = 9;
                    Landscape.anIntArrayArray1175[i_11_ + 1][-1 + i_9_] = i_13_;
                }
                if(i_11_ > 0 && i_9_ < 103 && (Class57.anIntArrayArray1335[i_11_ + -1][i_9_ + 1] ^ 0xffffffff) == -1 && ((0x1280138 & is[-1 + i_11_][1 + i_9_] ^ 0xffffffff) == -1) && (0x1280108 & is[i_11_ - 1][i_9_] ^ 0xffffffff) == -1 && (is[i_11_][i_9_ + 1] & 0x1280120) == 0) {
                    Class24.anIntArray581[i] = -1 + i_11_;
                    Class10.anIntArray351[i] = 1 + i_9_;
                    Class57.anIntArrayArray1335[i_11_ - 1][1 + i_9_] = 6;
                    Landscape.anIntArrayArray1175[-1 + i_11_][i_9_ + 1] = i_13_;
                    i = (1 + i) % i_12_;
                }
                if(i_11_ < 103 && i_9_ < 103 && (Class57.anIntArrayArray1335[1 + i_11_][1 + i_9_] ^ 0xffffffff) == -1 && (0x12801e0 & is[i_11_ + 1][i_9_ + 1]) == 0 && (0x1280180 & is[1 + i_11_][i_9_]) == 0 && (is[i_11_][1 + i_9_] & 0x1280120 ^ 0xffffffff) == -1) {
                    Class24.anIntArray581[i] = 1 + i_11_;
                    Class10.anIntArray351[i] = i_9_ + 1;
                    i = (i + 1) % i_12_;
                    Class57.anIntArrayArray1335[1 + i_11_][1 + i_9_] = 12;
                    Landscape.anIntArrayArray1175[1 + i_11_][1 + i_9_] = i_13_;
                }
            }
            Class40_Sub5_Sub15.anInt2778 = 0;
            if(!bool) {
                if(!arg6)
                    return false;
                int i_14_ = 1000;
                int i_15_ = 10;
                int i_16_ = 100;
                for(int i_17_ = arg3 + -i_15_; arg3 + i_15_ >= i_17_; i_17_++) {
                    for(int i_18_ = -i_15_ + arg10; (arg10 + i_15_ ^ 0xffffffff) <= (i_18_ ^ 0xffffffff); i_18_++) {
                        if((i_17_ ^ 0xffffffff) <= -1 && (i_18_ ^ 0xffffffff) <= -1 && i_17_ < 104 && i_18_ < 104 && (Landscape.anIntArrayArray1175[i_17_][i_18_] < 100)) {
                            int i_19_ = 0;
                            int i_20_ = 0;
                            if(i_18_ < arg10)
                                i_19_ = arg10 - i_18_;
                            else if(i_18_ > arg10 - (-arg8 + 1))
                                i_19_ = i_18_ + -arg8 + -arg10 + 1;
                            if(i_17_ < arg3)
                                i_20_ = -i_17_ + arg3;
                            else if(-1 + arg0 + arg3 < i_17_)
                                i_20_ = i_17_ + (-arg0 + -arg3 + 1);
                            int i_21_ = i_19_ * i_19_ + i_20_ * i_20_;
                            if(i_14_ > i_21_ || ((i_14_ ^ 0xffffffff) == (i_21_ ^ 0xffffffff) && (((Landscape.anIntArrayArray1175[i_17_][i_18_]) ^ 0xffffffff) > (i_16_ ^ 0xffffffff)))) {
                                i_9_ = i_18_;
                                i_14_ = i_21_;
                                i_11_ = i_17_;
                                i_16_ = (Landscape.anIntArrayArray1175[i_17_][i_18_]);
                            }
                        }
                    }
                }
                if(i_14_ == 1000)
                    return false;
                if((i_11_ ^ 0xffffffff) == (arg2 ^ 0xffffffff) && (i_9_ ^ 0xffffffff) == (arg9 ^ 0xffffffff))
                    return false;
                Class40_Sub5_Sub15.anInt2778 = 1;
            }
            i_10_ = 0;
            Class24.anIntArray581[i_10_] = i_11_;
            Class10.anIntArray351[i_10_++] = i_9_;
            int i_23_;
            int i_22_ = i_23_ = Class57.anIntArrayArray1335[i_11_][i_9_];
            while(i_11_ != arg2 || arg9 != i_9_) {
                if(i_22_ != i_23_) {
                    i_23_ = i_22_;
                    Class24.anIntArray581[i_10_] = i_11_;
                    Class10.anIntArray351[i_10_++] = i_9_;
                }
                if((i_22_ & 0x1 ^ 0xffffffff) != -1)
                    i_9_++;
                else if((i_22_ & 0x4) != 0)
                    i_9_--;
                if((i_22_ & 0x2 ^ 0xffffffff) != -1)
                    i_11_++;
                else if((i_22_ & 0x8) != 0)
                    i_11_--;
                i_22_ = Class57.anIntArrayArray1335[i_11_][i_9_];
            }
            if((i_10_ ^ 0xffffffff) < -1) {
                i_12_ = i_10_;
                if((i_12_ ^ 0xffffffff) < -26)
                    i_12_ = 25;
                i_10_--;
                int i_24_ = Class10.anIntArray351[i_10_];
                int i_25_ = Class24.anIntArray581[i_10_];
                if((arg11 ^ 0xffffffff) == -1) {
                    Class34.anInt838++;
                    Class32.packetBuffer.putPacket(11453, 73);
                    Class32.packetBuffer.putByte(3 + (i_12_ + i_12_));
                }
                if(arg11 == 1) {
                    Class32.packetBuffer.putPacket(11453, 236);
                    SubNode.anInt2096++;
                    Class32.packetBuffer.putByte(14 + i_12_ + i_12_ + 3);
                }
                if(arg11 == 2) {
                    VertexNormal.anInt1106++;
                    Class32.packetBuffer.putPacket(11453, 89);
                    Class32.packetBuffer.putByte(3 + (i_12_ + i_12_));
                }
                Class32.packetBuffer.method486(14912, i_24_ + Class26.anInt635);
                Class32.packetBuffer.method496(255, Class40_Sub5_Sub17_Sub3.aBooleanArray3056[82] ? 1 : 0);
                Class32.packetBuffer.method486(14912, Class40_Sub5_Sub2.anInt2307 + i_25_);
                Class40_Sub5_Sub4.anInt2366 = Class24.anIntArray581[0];
                Class55.anInt1304 = Class10.anIntArray351[0];
                for(int i_26_ = 1; i_12_ > i_26_; i_26_++) {
                    i_10_--;
                    Class32.packetBuffer.method489(128, Class24.anIntArray581[i_10_] - i_25_);
                    Class32.packetBuffer.method496(255, -i_24_ + Class10.anIntArray351[i_10_]);
                }
                return true;
            }
            return (arg11 ^ 0xffffffff) != -2;

    }

    public static void method449(int arg0) {

        aClass1_1906 = null;
            anIntArray1916 = null;
            aClass1_1920 = null;
            aClass1_1918 = null;
            aClass1_1917 = null;
            anIntArray1909 = null;
            aClass40_Sub5_Sub14_Sub2_1919 = null;
            aClass1_1905 = null;
            aClass1_1922 = null;
            aClass1_1924 = null;
            if(arg0 == -22783)
                aClass1_1921 = null;

    }

    public static void method450(byte arg0) {
        anInt1904++;
        if(Player.anInt3288 == 2) {
            if(arg0 >= -28)
                method445(-128);
            Class22_Sub1.method312(2 * NpcDefinition.anInt2404, (Class35.anInt1730 + (-Class26.anInt635 + Class4.anInt175 << -977811321)), ((Class68.anInt1637 + -Class40_Sub5_Sub2.anInt2307) << 1068913575) + Landscape.anInt1170, 4976905);
            if(ISAAC.anInt522 > -1 && Node.anInt926 % 20 < 10)
                Class40_Sub5_Sub9.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
        }
    }

    public void method444(int arg0) {

        anInt1911++;
            int i = 36 / ((arg0 + 76) / 48);
            for(int i_0_ = 0; i_0_ < 10; i_0_++)
                aLongArray1910[i_0_] = 0L;

    }

    public void method443(int arg0) {
        anInt1915 = 256;
        anInt1903 = 0;
        anInt1907++;
        anInt1912 = 1;
        aLong1914 = Class51.method937(1);
        for(int i = 0; i < 10; i++)
            aLongArray1910[i] = aLong1914;
        if(arg0 != -10115)
            aClass1_1921 = null;
    }

    public int method442(int arg0, int arg1, int arg2) {

        anInt1901++;
            int i = anInt1912;
            anInt1912 = 1;
            int i_5_ = anInt1915;
            anInt1915 = 300;
            aLong1914 = Class51.method937(arg2 ^ 0x2646);
            if(aLongArray1910[anInt1900] != 0L) {
                if((aLongArray1910[anInt1900] ^ 0xffffffffffffffffL) > (aLong1914 ^ 0xffffffffffffffffL))
                    anInt1915 = (int) ((long) (arg0 * 2560) / (-aLongArray1910[anInt1900] + aLong1914));
            } else {
                anInt1915 = i_5_;
                anInt1912 = i;
            }
            if(anInt1915 < 25)
                anInt1915 = 25;
            if(anInt1915 > 256) {
                anInt1915 = 256;
                anInt1912 = (int) ((long) arg0 - (aLong1914 - aLongArray1910[anInt1900]) / 10L);
            }
        if(arg0 < anInt1912)
                anInt1912 = arg0;
            aLongArray1910[anInt1900] = aLong1914;
            anInt1900 = (anInt1900 + 1) % 10;
            if(anInt1912 > 1) {
                for(int i_6_ = 0; i_6_ < 10; i_6_++) {
                    if(aLongArray1910[i_6_] != 0L)
                        aLongArray1910[i_6_] = (long) anInt1912 + aLongArray1910[i_6_];
                }
            }
            if(anInt1912 < arg1)
                anInt1912 = arg1;
            Class43.method890((long) anInt1912, arg2 ^ ~0x2613);
            int i_7_ = 0;
            if(arg2 != 9799)
                aClass1_1920 = null;
            for(/**/; (anInt1903 ^ 0xffffffff) > -257; anInt1903 += anInt1915)
                i_7_++;
            anInt1903 &= 0xff;
            return i_7_;

    }
}
