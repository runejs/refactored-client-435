package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.NpcDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.media.renderable.actor.Npc;

public class Class66 {
    public static Class68 aClass68_1541;
    public static RSString aClass1_1542;
    public static RSString aClass1_1543;
    public static RSString aClass1_1544;
    public static int anInt1545 = 0;
    public static RSString aClass1_1546;
    public static int anInt1547;
    public static int anInt1548;
    public static RSString aClass1_1549;
    public static RSString aClass1_1550;
    public static RSString aClass1_1552;
    public static int anInt1553;
    public static RSString aClass1_1554;
    public static RSString aClass1_1555;
    public static RSString aClass1_1556;
    public static RSString aClass1_1558;
    public static int anInt1559;
    public static int anInt1560;
    public static int anInt1561;
    public static int anInt1562;
    public static RSString aClass1_1563;
    public static int[] anIntArray1564;
    public static RSString aClass1_1565;
    public static int anInt1566;
    public static RSString aClass1_1567;
    public static int anInt1568;
    public static int[] chatTypes;
    public static int anInt1570;
    public static int anInt1571;
    public static RSString aClass1_1572;
    public static int anInt1573;

    static {
        aClass1_1544 = Class58.method978("Side panel redrawn");
        aClass1_1549 = Class58.method978("leuchten1:");
        anInt1548 = -1;
        anInt1559 = 7759444;
        aClass1_1554 = Class58.method978("Connecting to friendserver");
        aClass1_1555 = Class58.method978("Remove");
        anInt1560 = -1;
        anIntArray1564 = (new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
        aClass1_1558 = Class58.method978("leuchten2:");
        aClass1_1572 = aClass1_1555;
        chatTypes = new int[100];
        aClass1_1567 = Class58.method978("");
        aClass1_1556 = aClass1_1567;
        aClass1_1546 = Class58.method978("Icons redrawn");
        aClass1_1563 = aClass1_1567;
        aClass1_1550 = aClass1_1567;
        aClass1_1543 = aClass1_1567;
        aClass1_1542 = aClass1_1567;
        aClass1_1565 = aClass1_1567;
        aClass1_1552 = aClass1_1554;
    }

    public int[] anIntArray1540;
    public int[] anIntArray1551;
    public byte[] aByteArray1557;

    public Class66(byte[] arg0) {

        int i = arg0.length;
            aByteArray1557 = arg0;
            anIntArray1551 = new int[i];
            int[] is = new int[33];
            anIntArray1540 = new int[8];
            int i_29_ = 0;
            for(int i_30_ = 0; i_30_ < i; i_30_++) {
                int i_31_ = arg0[i_30_];
                if((i_31_ ^ 0xffffffff) != -1) {
                    int i_32_ = 1 << -i_31_ + 32;
                    int i_33_ = is[i_31_];
                    anIntArray1551[i_30_] = i_33_;
                    int i_34_;
                    if((i_32_ & i_33_) == 0) {
                        for(int i_35_ = -1 + i_31_; (i_35_ ^ 0xffffffff) <= -2; i_35_--) {
                            int i_36_ = is[i_35_];
                            if((i_33_ ^ 0xffffffff) != (i_36_ ^ 0xffffffff))
                                break;
                            int i_37_ = 1 << -i_35_ + 32;
                            if((i_36_ & i_37_) == 0)
                                is[i_35_] = Class40_Sub5_Sub9.method619(i_36_, i_37_);
                            else {
                                is[i_35_] = is[-1 + i_35_];
                                break;
                            }
                        }
                        i_34_ = i_33_ | i_32_;
                    } else
                        i_34_ = is[-1 + i_31_];
                    is[i_31_] = i_34_;
                    for(int i_38_ = i_31_ + 1; i_38_ <= 32; i_38_++) {
                        if(i_33_ == is[i_38_])
                            is[i_38_] = i_34_;
                    }
                    int i_39_ = 0;
                    for(int i_40_ = 0; (i_40_ ^ 0xffffffff) > (i_31_ ^ 0xffffffff); i_40_++) {
                        int i_41_ = -2147483648 >>> i_40_;
                        if((i_41_ & i_33_) != 0) {
                            if(anIntArray1540[i_39_] == 0)
                                anIntArray1540[i_39_] = i_29_;
                            i_39_ = anIntArray1540[i_39_];
                        } else
                            i_39_++;
                        if(anIntArray1540.length <= i_39_) {
                            int[] is_42_ = new int[anIntArray1540.length * 2];
                            for(int i_43_ = 0; anIntArray1540.length > i_43_; i_43_++)
                                is_42_[i_43_] = anIntArray1540[i_43_];
                            anIntArray1540 = is_42_;
                        }
                        i_41_ >>>= 1;
                    }
                    if((i_39_ ^ 0xffffffff) <= (i_29_ ^ 0xffffffff))
                        i_29_ = i_39_ + 1;
                    anIntArray1540[i_39_] = i_30_ ^ 0xffffffff;
                }
            }

    }

    public static int method1021(int arg0, int arg1) {

        return arg0 & arg1;

    }

    public static void method1022(int arg0) {

        aClass1_1565 = null;
            aClass68_1541 = null;
            aClass1_1558 = null;
            aClass1_1555 = null;
            aClass1_1563 = null;
            aClass1_1544 = null;
            aClass1_1542 = null;
            aClass1_1543 = null;
        chatTypes = null;
            aClass1_1546 = null;
            aClass1_1554 = null;
            aClass1_1550 = null;
            aClass1_1552 = null;
            aClass1_1549 = null;
            aClass1_1572 = null;
            anIntArray1564 = null;
            int i = -11 / ((-68 - arg0) / 55);
            aClass1_1567 = null;
            aClass1_1556 = null;

    }

    public static RSString method1024(boolean arg0, byte arg1, int arg2) {

        if(arg1 > -30)
                aClass1_1552 = null;
            anInt1570++;
            return PacketBuffer.method521(arg0, (byte) 8, 10, arg2);

    }

    public static void method1025(int arg0, int arg1, int arg2, int arg3, NpcDefinition arg4) {

        anInt1571++;
            if((NpcDefinition.anInt2394 ^ 0xffffffff) > -401) {
                if(arg4.childrenIds != null)
                    arg4 = arg4.method577(-1);
                if(arg4 != null && arg4.isClickable) {
                    RSString class1 = arg4.name;
                    if(arg4.combatLevel != arg0)
                        class1 = (Class40_Sub5_Sub17_Sub6.method832(-47, (new RSString[]{class1, (SceneTile.method536((Class40_Sub5_Sub13.localPlayer.anInt3260), arg4.combatLevel, arg0 + -99)), HashTable.aClass1_569, Class40_Sub5_Sub2.aClass1_2286, HashTable.method334(arg4.combatLevel, -1), Class51.aClass1_1199})));
                    if((Class8.anInt301 ^ 0xffffffff) == -2) {
                        Node.anInt927++;
                        Floor.method558(arg3, Main.aClass1_1763, arg2, -501, arg1, 49, (Class40_Sub5_Sub17_Sub6.method832(-124, (new RSString[]{Npc.aClass1_3295, Class40_Sub5_Sub2.aClass1_2306, class1}))));
                    } else if(Main.anInt1773 == 1) {
                        if((0x2 & ItemDefinition.anInt2815 ^ 0xffffffff) == -3) {
                            Floor.method558(arg3, Class38_Sub1.aClass1_1918, arg2, arg0 + -501, arg1, 21, (Class40_Sub5_Sub17_Sub6.method832(arg0 + 73, (new RSString[]{FloorDecoration.aClass1_611, Class40_Sub5_Sub2.aClass1_2306, class1}))));
                            Class58.anInt1356++;
                        }
                    } else {
                        RSString[] class1s = arg4.options;
                        Class52.anInt1240++;
                        if(Class60.aBoolean1402)
                            class1s = Class56.method968(class1s, false);
                        if(class1s != null) {
                            for(int i = 4; (i ^ 0xffffffff) <= -1; i--) {
                                if(class1s[i] != null && !class1s[i].equalsIgnoreCase((Class38_Sub1.aClass1_1917), true)) {
                                    Class17.anInt453++;
                                    int i_3_ = 0;
                                    if((i ^ 0xffffffff) == -1)
                                        i_3_ = 12;
                                    if((i ^ 0xffffffff) == -2)
                                        i_3_ = 30;
                                    if((i ^ 0xffffffff) == -3)
                                        i_3_ = 4;
                                    if((i ^ 0xffffffff) == -4)
                                        i_3_ = 34;
                                    if(i == 4)
                                        i_3_ = 20;
                                    Floor.method558(arg3, class1s[i], arg2, arg0 + -501, arg1, i_3_, (Class40_Sub5_Sub17_Sub6.method832(arg0 + 93, new RSString[]{Class54.aClass1_1283, class1})));
                                }
                            }
                        }
                        if(class1s != null) {
                            for(int i = 4; i >= 0; i--) {
                                if(class1s[i] != null && class1s[i].equalsIgnoreCase((Class38_Sub1.aClass1_1917), true)) {
                                    Class55.anInt1297++;
                                    int i_4_ = 0;
                                    if(((Class40_Sub5_Sub13.localPlayer.anInt3260) ^ 0xffffffff) > (arg4.combatLevel ^ 0xffffffff))
                                        i_4_ = 2000;
                                    int i_5_ = 0;
                                    if((i ^ 0xffffffff) == -1)
                                        i_5_ = 12 + i_4_;
                                    if(i == 1)
                                        i_5_ = i_4_ + 30;
                                    if((i ^ 0xffffffff) == -3)
                                        i_5_ = i_4_ + 4;
                                    if((i ^ 0xffffffff) == -4)
                                        i_5_ = i_4_ + 34;
                                    if((i ^ 0xffffffff) == -5)
                                        i_5_ = 20 + i_4_;
                                    Floor.method558(arg3, class1s[i], arg2, arg0 ^ ~0x1f4, arg1, i_5_, (Class40_Sub5_Sub17_Sub6.method832(-64, new RSString[]{Class54.aClass1_1283, class1})));
                                }
                            }
                        }
                        Floor.method558(arg3, Class40_Sub5_Sub15.aClass1_2774, arg2, -501, arg1, 1001, (Class40_Sub5_Sub17_Sub6.method832(-116, new RSString[]{Class54.aClass1_1283, class1})));
                    }
                }
            }

    }

    public static boolean method1027(int arg0, int arg1) {

        anInt1566++;
            if(arg1 != -58)
                method1022(68);
            return (arg0 ^ 0xffffffff) <= -49 && (arg0 ^ 0xffffffff) >= -58;

    }

    public static ImageRGB method1028(Class6 arg0, RSString arg1, byte arg2, RSString arg3) {

        anInt1553++;
            int i = arg0.method183(0, arg1);
            int i_13_ = arg0.method179(arg2 ^ ~0x6f, i, arg3);
            if(arg2 != 21)
                chatTypes = null;
            return Class48.method927(i_13_, arg0, true, i);

    }

    public static int method1029(int arg0, boolean arg1, Class40_Sub5_Sub12 arg2) {

        anInt1547++;
        if(arg2.anIntArrayArray2748 == null || (arg0 >= arg2.anIntArrayArray2748.length))
                return -2;
            try {
                int[] is = arg2.anIntArrayArray2748[arg0];
                int i = 0;
                int i_14_ = 0;
                if(arg1 != false)
                    anInt1559 = -63;
                int i_15_ = 0;
                for(; ; ) {
                    int i_16_ = 0;
                    int i_17_ = 0;
                    int i_18_ = is[i_14_++];
                    if((i_18_ ^ 0xffffffff) == -1)
                        return i;
                    if((i_18_ ^ 0xffffffff) == -16)
                        i_17_ = 1;
                    if((i_18_ ^ 0xffffffff) == -17)
                        i_17_ = 2;
                    if((i_18_ ^ 0xffffffff) == -2)
                        i_16_ = Class13.anIntArray403[is[i_14_++]];
                    if((i_18_ ^ 0xffffffff) == -3)
                        i_16_ = Class10.anIntArray354[is[i_14_++]];
                    if(i_18_ == 3)
                        i_16_ = (Class40_Sub5_Sub17_Sub3.anIntArray3051[is[i_14_++]]);
                    if((i_18_ ^ 0xffffffff) == -18)
                        i_17_ = 3;
                    if((i_18_ ^ 0xffffffff) == -5) {
                        int i_19_ = is[i_14_++] << 1814235088;
                        i_19_ += is[i_14_++];
                        Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_19_, (byte) -70);
                        int i_20_ = is[i_14_++];
                        if(i_20_ != -1 && (!ItemDefinition.forId(i_20_, 10).members || Class22.aBoolean541)) {
                            for(int i_21_ = 0; ((i_21_ ^ 0xffffffff) > (class40_sub5_sub12.anIntArray2685.length ^ 0xffffffff)); i_21_++) {
                                if(1 + i_20_ == (class40_sub5_sub12.anIntArray2685[i_21_]))
                                    i_16_ += (class40_sub5_sub12.anIntArray2710[i_21_]);
                            }
                        }
                    }
                    if(i_18_ == 5)
                        i_16_ = Class58.varbitmasks[is[i_14_++]];
                    if((i_18_ ^ 0xffffffff) == -7)
                        i_16_ = (Class38_Sub1.anIntArray1909[-1 + Class10.anIntArray354[is[i_14_++]]]);
                    if((i_18_ ^ 0xffffffff) == -8)
                        i_16_ = (100 * Class58.varbitmasks[is[i_14_++]] / 46875);
                    if((i_18_ ^ 0xffffffff) == -9)
                        i_16_ = (Class40_Sub5_Sub13.localPlayer.anInt3260);
                    if(i_18_ == 9) {
                        for(int i_22_ = 0; i_22_ < 25; i_22_++) {
                            if(Class22.aBooleanArray548[i_22_])
                                i_16_ += Class10.anIntArray354[i_22_];
                        }
                    }
                    if(i_18_ == 10) {
                        int i_23_ = is[i_14_++] << -1588807344;
                        i_23_ += is[i_14_++];
                        Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_23_, (byte) -118);
                        int i_24_ = is[i_14_++];
                        if((i_24_ ^ 0xffffffff) != 0 && (!ItemDefinition.forId(i_24_, 10).members || Class22.aBoolean541)) {
                            for(int i_25_ = 0; (class40_sub5_sub12.anIntArray2685.length > i_25_); i_25_++) {
                                if(i_24_ + 1 == (class40_sub5_sub12.anIntArray2685[i_25_])) {
                                    i_16_ = 999999999;
                                    break;
                                }
                            }
                        }
                    }
                    if((i_18_ ^ 0xffffffff) == -12)
                        i_16_ = Class40_Sub11.anInt2158;
                    if((i_18_ ^ 0xffffffff) == -13)
                        i_16_ = Class52.anInt1222;
                    if(i_18_ == 13) {
                        int i_26_ = Class58.varbitmasks[is[i_14_++]];
                        int i_27_ = is[i_14_++];
                        i_16_ = (1 << i_27_ & i_26_ ^ 0xffffffff) != -1 ? 1 : 0;
                    }
                    if((i_18_ ^ 0xffffffff) == -15) {
                        int i_28_ = is[i_14_++];
                        i_16_ = Class40_Sub5_Sub6.method585(i_28_, 1369);
                    }
                    if((i_18_ ^ 0xffffffff) == -19)
                        i_16_ = ((Class40_Sub5_Sub13.localPlayer.anInt3098) >> -949277977) + Class40_Sub5_Sub2.anInt2307;
                    if(i_18_ == 19)
                        i_16_ = ((Class40_Sub5_Sub13.localPlayer.anInt3089) >> 745230119) + Class26.anInt635;
                    if((i_18_ ^ 0xffffffff) == -21)
                        i_16_ = is[i_14_++];
                    if((i_17_ ^ 0xffffffff) != -1)
                        i_15_ = i_17_;
                    else {
                        if((i_15_ ^ 0xffffffff) == -1)
                            i += i_16_;
                        if((i_15_ ^ 0xffffffff) == -2)
                            i -= i_16_;
                        if((i_15_ ^ 0xffffffff) == -3 && (i_16_ ^ 0xffffffff) != -1)
                            i /= i_16_;
                        if(i_15_ == 3)
                            i *= i_16_;
                        i_15_ = 0;
                    }
                }
            } catch(Exception exception) {
                return -1;
            }

    }

    public static void method1030(byte arg0) {

        anInt1573++;
            if(arg0 < 123)
                method1030((byte) -24);
            for(Class40_Sub2 class40_sub2 = ((Class40_Sub2) Class40_Sub5_Sub1.aClass45_2268.method902((byte) -90)); class40_sub2 != null; class40_sub2 = (Class40_Sub2) Class40_Sub5_Sub1.aClass45_2268.method909(-4)) {
                if(class40_sub2.aGameObjectDefinition_2011 != null)
                    class40_sub2.method528(48);
            }

    }

    public int method1023(byte[] arg0, int arg1, int arg2, byte[] arg3, int arg4, int arg5) {

        anInt1568++;
            if(arg1 == 0)
                return 0;
            arg1 += arg2;
            int i = 0;
            int i_0_ = arg4;
            for(; ; ) {
                byte i_1_ = arg0[i_0_];
                if(i_1_ >= 0)
                    i++;
                else
                    i = anIntArray1540[i];
                int i_2_;
                if((i_2_ = anIntArray1540[i]) < 0) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg1 <= arg2)
                        break;
                    i = 0;
                }
                if((0x40 & i_1_ ^ 0xffffffff) != -1)
                    i = anIntArray1540[i];
                else
                    i++;
                if(((i_2_ = anIntArray1540[i]) ^ 0xffffffff) > -1) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg2 >= arg1)
                        break;
                    i = 0;
                }
                if((0x20 & i_1_) == 0)
                    i++;
                else
                    i = anIntArray1540[i];
                if(((i_2_ = anIntArray1540[i]) ^ 0xffffffff) > -1) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg1 <= arg2)
                        break;
                    i = 0;
                }
                if((0x10 & i_1_ ^ 0xffffffff) != -1)
                    i = anIntArray1540[i];
                else
                    i++;
                if((i_2_ = anIntArray1540[i]) < 0) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg1 <= arg2)
                        break;
                    i = 0;
                }
                if((i_1_ & 0x8 ^ 0xffffffff) != -1)
                    i = anIntArray1540[i];
                else
                    i++;
                if((i_2_ = anIntArray1540[i]) < 0) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg2 >= arg1)
                        break;
                    i = 0;
                }
                if((0x4 & i_1_ ^ 0xffffffff) != -1)
                    i = anIntArray1540[i];
                else
                    i++;
                if(((i_2_ = anIntArray1540[i]) ^ 0xffffffff) > -1) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg1 <= arg2)
                        break;
                    i = 0;
                }
                if((0x2 & i_1_) == 0)
                    i++;
                else
                    i = anIntArray1540[i];
                if((i_2_ = anIntArray1540[i]) < 0) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg2 >= arg1)
                        break;
                    i = 0;
                }
                if((i_1_ & 0x1) == 0)
                    i++;
                else
                    i = anIntArray1540[i];
                if(((i_2_ = anIntArray1540[i]) ^ 0xffffffff) > -1) {
                    arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                    if(arg2 >= arg1)
                        break;
                    i = 0;
                }
                i_0_++;
            }
            if(arg5 != -1)
                aClass1_1542 = null;
            return -arg4 + (i_0_ + 1);

    }

    public int method1026(int arg0, int arg1, int arg2, int arg3, byte[] arg4, byte[] arg5) {

        anInt1561++;
            arg3 += arg1;
            int i = 0;
            int i_6_ = arg2 << -2048728797;
            for(/**/; arg1 < arg3; arg1++) {
                int i_7_ = 0xff & arg4[arg1];
                int i_8_ = anIntArray1551[i_7_];
                int i_9_ = aByteArray1557[i_7_];
                if((i_9_ ^ 0xffffffff) == -1)
                    throw new RuntimeException("No codeword for data value " + i_7_);
                int i_10_ = i_6_ >> 1442246755;
                int i_11_ = 0x7 & i_6_;
                i_6_ += i_9_;
                i &= -i_11_ >> -1953839681;
                int i_12_ = i_10_ + (i_9_ + (i_11_ - 1) >> -559081565);
                i_11_ += 24;
                arg5[i_10_] = (byte) (i = Class40_Sub5_Sub9.method619(i, i_8_ >>> i_11_));
                if(i_10_ < i_12_) {
                    i_10_++;
                    i_11_ -= 8;
                    arg5[i_10_] = (byte) (i = i_8_ >>> i_11_);
                    if(i_12_ > i_10_) {
                        i_11_ -= 8;
                        i_10_++;
                        arg5[i_10_] = (byte) (i = i_8_ >>> i_11_);
                        if(i_10_ < i_12_) {
                            i_10_++;
                            i_11_ -= 8;
                            arg5[i_10_] = (byte) (i = i_8_ >>> i_11_);
                            if((i_10_ ^ 0xffffffff) > (i_12_ ^ 0xffffffff)) {
                                i_11_ -= 8;
                                i_10_++;
                                arg5[i_10_] = (byte) (i = i_8_ << -i_11_);
                            }
                        }
                    }
                }
            }
            if(arg0 != -18678)
                method1027(-98, -28);
            return (7 + i_6_ >> -262344669) - arg2;

    }
}
