/* Class33 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class33 {
    public static int anInt775;
    public static int anInt776;
    public static RSString aClass1_777 = Class58.method978("Cabbage");
    public static Cache aClass9_778;
    public static RSString aClass1_779;
    public static int anInt780;
    public static int anInt781;
    public static int anInt782;
    public static RSString aClass1_783;
    public static int anInt784;
    public static int anInt785;
    public static RSString aClass1_786;
    public static int anInt787;
    public static int anInt788;
    public static int anInt789;
    public static int anInt790;
    public static int[] anIntArray791 = new int[500];
    public static int anInt792;
    public static int anInt793;
    public static int anInt794;
    public static RSString aClass1_795;
    public static RSString aClass1_796;
    public static RSString aClass1_797;
    public static RSString aClass1_798;
    public static RSString aClass1_799;

    static {
        aClass1_786 = Class58.method978("::");
        aClass1_779 = (Class58.method978("Bitte schlie-8en Sie die momentan ge-Offnete Benutzeroberfl-=che)1 bevor Sie die (WRegelversto-8 melden(W Option benutzen"));
        anInt784 = 0;
        aClass1_796 = Class58.method978("Loading config )2 ");
        aClass1_797 = Class58.method978("Spiel)2Engine wird gestartet)3)3)3");
        aClass1_795 = Class58.method978(")1");
        aClass1_783 = aClass1_796;
        aClass9_778 = new Cache(64);
        aClass1_798 = Class58.method978("No response from server)3");
        aClass1_799 = aClass1_798;
    }

    public static synchronized void method402(boolean arg0) {
        try {
            anInt775++;
            if(Class24.method340(-122)) {
                Class22.method308(-110);
                Class26.aBoolean618 = arg0;
                Class22_Sub1.aClass6_1855 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "m.C(" + arg0 + ')');
        }
    }

    public static synchronized void method403(int arg0, boolean arg1, int arg2, int arg3, Class6 arg4, int arg5, int arg6, boolean arg7) {
        try {
            anInt788++;
            if(Class24.method340(5)) {
                Main.aBoolean1790 = arg7;
                Class6.anInt255 = arg2;
                Class40_Sub5_Sub17_Sub1.anInt3004 = arg5;
                Class26.aBoolean618 = arg1;
                Class22_Sub1.aClass6_1855 = arg4;
                Class6_Sub1.anInt1806 = -1;
                Floor.anInt2342 = arg0;
                Class40_Sub6.anInt2110 = arg6;
                Class8.anInt289 = arg3;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("m.E(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + (arg4 != null ? "{...}" : "null") + ',' + arg5 + ',' + arg6 + ',' + arg7 + ')'));
        }
    }

    public static void method404(byte arg0) {
        try {
            anInt782++;
            Class32.anInt770 = 0;
            if(arg0 == -28) {
                for(int i = -1; Class60.anInt1407 - -GameObjectDefinition.anInt2558 > i; i++) {
                    Class40_Sub5_Sub17_Sub4 class40_sub5_sub17_sub4;
                    if((i ^ 0xffffffff) == 0)
                        class40_sub5_sub17_sub4 = (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760);
                    else if((Class60.anInt1407 ^ 0xffffffff) < (i ^ 0xffffffff))
                        class40_sub5_sub17_sub4 = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i]]);
                    else
                        class40_sub5_sub17_sub4 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[(Class40_Sub3.anIntArray2016[i + -Class60.anInt1407])]);
                    if(class40_sub5_sub17_sub4 != null && class40_sub5_sub17_sub4.method784(1)) {
                        if(class40_sub5_sub17_sub4 instanceof NPC) {
                            NpcDefinition class40_sub5_sub5 = (((NPC) class40_sub5_sub17_sub4).aClass40_Sub5_Sub5_3300);
                            if(class40_sub5_sub5.anIntArray2426 != null)
                                class40_sub5_sub5 = class40_sub5_sub5.method577(arg0 + 27);
                            if(class40_sub5_sub5 == null)
                                continue;
                        }
                        if((i ^ 0xffffffff) <= (Class60.anInt1407 ^ 0xffffffff)) {
                            NpcDefinition class40_sub5_sub5 = (((NPC) class40_sub5_sub17_sub4).aClass40_Sub5_Sub5_3300);
                            if(((class40_sub5_sub5.anInt2381 ^ 0xffffffff) <= -1) && (class40_sub5_sub5.anInt2381 < (Class68_Sub1.aClass40_Sub5_Sub14_Sub4Array2204).length)) {
                                Class25.method342(-127, (class40_sub5_sub17_sub4.anInt3117) + 15, class40_sub5_sub17_sub4);
                                if(ISAAC.anInt522 > -1)
                                    Class68_Sub1.aClass40_Sub5_Sub14_Sub4Array2204[class40_sub5_sub5.anInt2381].method721(-12 + ISAAC.anInt522, Class44.anInt1048 + -30);
                            }
                            if((Player.anInt3288 ^ 0xffffffff) == -2 && (((Class40_Sub3.anIntArray2016[-Class60.anInt1407 + i]) ^ 0xffffffff) == (Class66.anInt1545 ^ 0xffffffff)) && Node.anInt926 % 20 < 10) {
                                Class25.method342(107, 15 + (class40_sub5_sub17_sub4.anInt3117), class40_sub5_sub17_sub4);
                                if(ISAAC.anInt522 > -1)
                                    Class40_Sub5_Sub9.aClass40_Sub5_Sub14_Sub4Array2567[0].method721(ISAAC.anInt522 + -12, Class44.anInt1048 + -28);
                            }
                        } else {
                            Player class40_sub5_sub17_sub4_sub1 = ((Player) class40_sub5_sub17_sub4);
                            int i_0_ = 30;
                            if((class40_sub5_sub17_sub4_sub1.anInt3268 ^ 0xffffffff) != 0 || (class40_sub5_sub17_sub4_sub1.anInt3273 != -1)) {
                                Class25.method342(-44, 15 + (class40_sub5_sub17_sub4.anInt3117), class40_sub5_sub17_sub4);
                                if(ISAAC.anInt522 > -1) {
                                    if(class40_sub5_sub17_sub4_sub1.anInt3268 != -1) {
                                        Class25.aClass40_Sub5_Sub14_Sub4Array603[(class40_sub5_sub17_sub4_sub1.anInt3268)].method721(ISAAC.anInt522 - 12, Class44.anInt1048 - i_0_);
                                        i_0_ += 25;
                                    }
                                    if(class40_sub5_sub17_sub4_sub1.anInt3273 != -1) {
                                        Class68_Sub1.aClass40_Sub5_Sub14_Sub4Array2204[(class40_sub5_sub17_sub4_sub1.anInt3273)].method721(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                                        i_0_ += 25;
                                    }
                                }
                            }
                            if(i >= 0 && (Player.anInt3288 ^ 0xffffffff) == -11 && (Class68.anInt1623 == Class57.anIntArray1334[i])) {
                                Class25.method342(87, (class40_sub5_sub17_sub4.anInt3117) - -15, class40_sub5_sub17_sub4);
                                if(ISAAC.anInt522 > -1)
                                    Class40_Sub5_Sub9.aClass40_Sub5_Sub14_Sub4Array2567[1].method721(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                            }
                        }
                        if(class40_sub5_sub17_sub4.aClass1_3090 != null && (i >= Class60.anInt1407 || (Class35.anInt1737 ^ 0xffffffff) == -1 || Class35.anInt1737 == 3 || ((Class35.anInt1737 ^ 0xffffffff) == -2 && (Class40_Sub2.method523((((Player) class40_sub5_sub17_sub4).aClass1_3278), arg0 ^ 0x7f74))))) {
                            Class25.method342(88, (class40_sub5_sub17_sub4.anInt3117), class40_sub5_sub17_sub4);
                            if((ISAAC.anInt522 ^ 0xffffffff) < 0 && Class30.anInt709 > Class32.anInt770) {
                                Class30.anIntArray680[Class32.anInt770] = ((Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method685(class40_sub5_sub17_sub4.aClass1_3090)) / 2);
                                Class30.anIntArray688[Class32.anInt770] = (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.anInt2910);
                                Class30.anIntArray715[Class32.anInt770] = ISAAC.anInt522;
                                Class30.anIntArray685[Class32.anInt770] = Class44.anInt1048;
                                Class30.anIntArray712[Class32.anInt770] = class40_sub5_sub17_sub4.anInt3102;
                                Class30.anIntArray695[Class32.anInt770] = class40_sub5_sub17_sub4.anInt3123;
                                Class30.anIntArray684[Class32.anInt770] = class40_sub5_sub17_sub4.anInt3078;
                                Class30.aClass1Array697[Class32.anInt770] = class40_sub5_sub17_sub4.aClass1_3090;
                                Class32.anInt770++;
                            }
                        }
                        if((Node.anInt926 ^ 0xffffffff) > (class40_sub5_sub17_sub4.anInt3139 ^ 0xffffffff)) {
                            Class25.method342(109, (class40_sub5_sub17_sub4.anInt3117) + 15, class40_sub5_sub17_sub4);
                            if((ISAAC.anInt522 ^ 0xffffffff) < 0) {
                                int i_1_ = (30 * class40_sub5_sub17_sub4.anInt3130 / class40_sub5_sub17_sub4.anInt3101);
                                if(i_1_ > 30)
                                    i_1_ = 30;
                                Rasterizer.method656(-15 + (ISAAC.anInt522), (Class44.anInt1048 + -3), i_1_, 5, 65280);
                                Rasterizer.method656(-15 + ISAAC.anInt522 - -i_1_, Class44.anInt1048 + -3, 30 + -i_1_, 5, 16711680);
                            }
                        }
                        for(int i_2_ = 0; (i_2_ ^ 0xffffffff) > -5; i_2_++) {
                            if(Node.anInt926 < (class40_sub5_sub17_sub4.anIntArray3136[i_2_])) {
                                Class25.method342(99, (class40_sub5_sub17_sub4.anInt3117) / 2, class40_sub5_sub17_sub4);
                                if((ISAAC.anInt522 ^ 0xffffffff) < 0) {
                                    if((i_2_ ^ 0xffffffff) == -2)
                                        Class44.anInt1048 -= 20;
                                    if((i_2_ ^ 0xffffffff) == -3) {
                                        ISAAC.anInt522 -= 15;
                                        Class44.anInt1048 -= 10;
                                    }
                                    if((i_2_ ^ 0xffffffff) == -4) {
                                        ISAAC.anInt522 += 15;
                                        Class44.anInt1048 -= 10;
                                    }
                                    Class40_Sub5_Sub7.aClass40_Sub5_Sub14_Sub4Array2474[(class40_sub5_sub17_sub4.anIntArray3086[i_2_])].method721(ISAAC.anInt522 + -12, -12 + Class44.anInt1048);
                                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.method686((HashTable.method334((class40_sub5_sub17_sub4.anIntArray3087[i_2_]), -1)), ISAAC.anInt522, 4 + Class44.anInt1048, 0);
                                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.method686((HashTable.method334((class40_sub5_sub17_sub4.anIntArray3087[i_2_]), -1)), ISAAC.anInt522 - 1, Class44.anInt1048 + 3, 16777215);
                                }
                            }
                        }
                    }
                }
                for(int i = 0; Class32.anInt770 > i; i++) {
                    int i_3_ = Class30.anIntArray715[i];
                    int i_4_ = Class30.anIntArray685[i];
                    int i_5_ = Class30.anIntArray680[i];
                    int i_6_ = Class30.anIntArray688[i];
                    boolean bool = true;
                    while(bool) {
                        bool = false;
                        for(int i_7_ = 0; (i ^ 0xffffffff) < (i_7_ ^ 0xffffffff); i_7_++) {
                            if(((-Class30.anIntArray688[i_7_] + Class30.anIntArray685[i_7_]) ^ 0xffffffff) > (i_4_ + 2 ^ 0xffffffff) && ((-i_6_ + i_4_ ^ 0xffffffff) > (2 + Class30.anIntArray685[i_7_] ^ 0xffffffff)) && ((-i_5_ + i_3_ ^ 0xffffffff) > ((Class30.anIntArray715[i_7_] + Class30.anIntArray680[i_7_]) ^ 0xffffffff)) && (i_5_ + i_3_ > (-Class30.anIntArray680[i_7_] + Class30.anIntArray715[i_7_])) && ((i_4_ ^ 0xffffffff) < ((-Class30.anIntArray688[i_7_] + Class30.anIntArray685[i_7_]) ^ 0xffffffff))) {
                                bool = true;
                                i_4_ = (-Class30.anIntArray688[i_7_] + Class30.anIntArray685[i_7_]);
                            }
                        }
                    }
                    ISAAC.anInt522 = Class30.anIntArray715[i];
                    Class44.anInt1048 = Class30.anIntArray685[i] = i_4_;
                    RSString class1 = Class30.aClass1Array697[i];
                    if(Class40_Sub5_Sub1.anInt2280 != 0) {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048, 16776960);
                    } else {
                        int i_8_ = 16776960;
                        if((Class30.anIntArray712[i] ^ 0xffffffff) > -7)
                            i_8_ = (Class40_Sub6.anIntArray2106[Class30.anIntArray712[i]]);
                        if(Class30.anIntArray712[i] == 6)
                            i_8_ = (Class40_Sub5_Sub11.anInt2628 % 20 ^ 0xffffffff) <= -11 ? 16776960 : 16711680;
                        if(Class30.anIntArray712[i] == 7)
                            i_8_ = (Class40_Sub5_Sub11.anInt2628 % 20 ^ 0xffffffff) > -11 ? 255 : 65535;
                        if((Class30.anIntArray712[i] ^ 0xffffffff) == -9)
                            i_8_ = (Class40_Sub5_Sub11.anInt2628 % 20 >= 10 ? 8454016 : 45056);
                        if((Class30.anIntArray712[i] ^ 0xffffffff) == -10) {
                            int i_9_ = 150 - Class30.anIntArray684[i];
                            if(i_9_ >= 50) {
                                if(i_9_ < 100)
                                    i_8_ = -((-50 + i_9_) * 327680) + 16776960;
                                else if((i_9_ ^ 0xffffffff) > -151)
                                    i_8_ = 65280 - -(5 * (i_9_ + -100));
                            } else
                                i_8_ = 16711680 + 1280 * i_9_;
                        }
                        if((Class30.anIntArray712[i] ^ 0xffffffff) == -11) {
                            int i_10_ = 150 + -Class30.anIntArray684[i];
                            if((i_10_ ^ 0xffffffff) <= -51) {
                                if((i_10_ ^ 0xffffffff) <= -101) {
                                    if(i_10_ < 150)
                                        i_8_ = 255 - (-(327680 * (i_10_ - 100)) - 500) + -(5 * i_10_);
                                } else
                                    i_8_ = 16711935 - (327680 * i_10_ - 16384000);
                            } else
                                i_8_ = 5 * i_10_ + 16711680;
                        }
                        if((Class30.anIntArray712[i] ^ 0xffffffff) == -12) {
                            int i_11_ = -Class30.anIntArray684[i] + 150;
                            if(i_11_ >= 50) {
                                if(i_11_ < 100)
                                    i_8_ = 327685 * (i_11_ - 50) + 65280;
                                else if(i_11_ < 150)
                                    i_8_ = (-((-100 + i_11_) * 327680) + 16777215);
                            } else
                                i_8_ = -(327685 * i_11_) + 16777215;
                        }
                        if((Class30.anIntArray695[i] ^ 0xffffffff) == -1) {
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, Class44.anInt1048, i_8_);
                        }
                        if(Class30.anIntArray695[i] == 1) {
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method673(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0, Class40_Sub5_Sub11.anInt2628);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method673(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, Class40_Sub5_Sub11.anInt2628);
                        }
                        if((Class30.anIntArray695[i] ^ 0xffffffff) == -3) {
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method675(class1, ISAAC.anInt522, 1 + Class44.anInt1048, 0, Class40_Sub5_Sub11.anInt2628);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method675(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, Class40_Sub5_Sub11.anInt2628);
                        }
                        if((Class30.anIntArray695[i] ^ 0xffffffff) == -4) {
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method678(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0, Class40_Sub5_Sub11.anInt2628, -Class30.anIntArray684[i] + 150);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method678(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, Class40_Sub5_Sub11.anInt2628, -Class30.anIntArray684[i] + 150);
                        }
                        if(Class30.anIntArray695[i] == 4) {
                            int i_12_ = Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method685(class1);
                            int i_13_ = ((i_12_ + 100) * (150 + -Class30.anIntArray684[i]) / 150);
                            Rasterizer.method655((ISAAC.anInt522 + -50), 0, 50 + ISAAC.anInt522, 334);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method690(class1, -i_13_ + ISAAC.anInt522 + 50, Class44.anInt1048 + 1, 0);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method690(class1, 50 + ISAAC.anInt522 + -i_13_, Class44.anInt1048, i_8_);
                            Rasterizer.method662();
                        }
                        if((Class30.anIntArray695[i] ^ 0xffffffff) == -6) {
                            int i_14_ = 0;
                            int i_15_ = 150 + -Class30.anIntArray684[i];
                            Rasterizer.method655(0, -1 + (-(Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.anInt2910) + Class44.anInt1048), 512, 5 + Class44.anInt1048);
                            if((i_15_ ^ 0xffffffff) <= -26) {
                                if((i_15_ ^ 0xffffffff) < -126)
                                    i_14_ = i_15_ + -125;
                            } else
                                i_14_ = i_15_ + -25;
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, i_14_ + (Class44.anInt1048 + 1), 0);
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(class1, ISAAC.anInt522, i_14_ + Class44.anInt1048, i_8_);
                            Rasterizer.method662();
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "m.G(" + arg0 + ')');
        }
    }

    public static synchronized void method405(int arg0, int arg1) {
        anInt785++;
        if(Class24.method340(arg0 + -16923)) {
            Floor.method557(arg1, 17098);
            Class22_Sub1.aClass6_1855 = null;
            Class26.aBoolean618 = false;
            if(arg0 != 16969)
                method414(false, -11, -36, -55, 122, null, 102);
        }
    }

    public static void method406(int arg0, int arg1, int arg2, int arg3) {
        if((arg1 ^ 0xffffffff) == -2) {
            Class67.anInt1594++;
            Class32.packetBuffer.putPacket(11453, 111);
            Class32.packetBuffer.putInt(75, arg2);
            Class32.packetBuffer.method474(arg0, -128);
        }
        anInt793++;
        if((arg1 ^ 0xffffffff) == -3) {
            Class32.packetBuffer.putPacket(11453, 9);
            Class32.packetBuffer.putInt(84, arg2);
            Class32.packetBuffer.method474(arg0, -127);
            Class56.anInt1327++;
        }
        if((arg1 ^ 0xffffffff) == -4) {
            Class6.anInt245++;
            Class32.packetBuffer.putPacket(11453, 193);
            Class32.packetBuffer.putInt(36, arg2);
            Class32.packetBuffer.method474(arg0, 76);
        }
        if((arg1 ^ 0xffffffff) == -5) {
            Class32.packetBuffer.putPacket(11453, 53);
            Class58.anInt1369++;
            Class32.packetBuffer.putInt(111, arg2);
            Class32.packetBuffer.method474(arg0, -121);
        }
        if((arg1 ^ 0xffffffff) == -6) {
            Class46.anInt1103++;
            Class32.packetBuffer.putPacket(11453, 94);
            Class32.packetBuffer.putInt(117, arg2);
            Class32.packetBuffer.method474(arg0, 46);
        }
        if(arg1 == 6) {
            Class5.anInt201++;
            Class32.packetBuffer.putPacket(11453, 213);
            Class32.packetBuffer.putInt(67, arg2);
            Class32.packetBuffer.method474(arg0, -128);
        }
        if(arg1 == 7) {
            PacketBuffer.anInt2242++;
            Class32.packetBuffer.putPacket(11453, 46);
            Class32.packetBuffer.putInt(73, arg2);
            Class32.packetBuffer.method474(arg0, 86);
        }
        if((arg1 ^ 0xffffffff) == -9) {
            Class32.packetBuffer.putPacket(11453, 130);
            Class32.packetBuffer.putInt(71, arg2);
            Class32.packetBuffer.method474(arg0, 8);
            Class40_Sub5_Sub17_Sub1.anInt2979++;
        }
        if((arg1 ^ 0xffffffff) == -10) {
            Class40_Sub5_Sub12.anInt2700++;
            Class32.packetBuffer.putPacket(11453, 157);
            Class32.packetBuffer.putInt(40, arg2);
            Class32.packetBuffer.method474(arg0, 48);
        }
        if(arg1 == 10) {
            Class40_Sub5_Sub12.anInt2635++;
            Class32.packetBuffer.putPacket(11453, 84);
            Class32.packetBuffer.putInt(116, arg2);
            Class32.packetBuffer.method474(arg0, 110);
        }
        if(arg3 > -112)
            aClass9_778 = null;
    }

    public static synchronized void method407(boolean arg0) {
        try {
            if(arg0 != false)
                aClass1_795 = null;
            Class65.method1019(104);
            anInt789++;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "m.B(" + arg0 + ')');
        }
    }

    public static void method408(int arg0) {
        try {
            aClass1_779 = null;
            aClass1_799 = null;
            aClass1_786 = null;
            anIntArray791 = null;
            aClass1_796 = null;
            aClass1_795 = null;
            if(arg0 == 22019) {
                aClass1_777 = null;
                aClass1_797 = null;
                aClass9_778 = null;
                aClass1_783 = null;
                aClass1_798 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "m.M(" + arg0 + ')');
        }
    }

    public static boolean method409(byte arg0, int arg1) {
        try {
            anInt776++;
            if(arg0 <= 23)
                method402(true);
            if((arg1 ^ 0xffffffff) > -1)
                return false;
            int i = Class38.anIntArray884[arg1];
            if(i >= 2000)
                i -= 2000;
            return i == 45;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "m.J(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static int method410(int arg0, int arg1, int arg2, boolean arg3) {
        try {
            arg2 &= 0x3;
            if(arg3 != false)
                return -80;
            anInt780++;
            if(arg2 == 0)
                return arg1;
            if(arg2 == 1)
                return 7 + -arg0;
            if(arg2 == 2)
                return -arg1 + 7;
            return arg0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("m.D(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public static void method411(RSString arg0, RSString arg1, RSString arg2, byte arg3) {
        try {
            anInt787++;
            int i = -74 / ((29 - arg3) / 57);
            Class22_Sub2.aClass1_1881 = arg0;
            Class22_Sub2.aClass1_1896 = arg2;
            Class22_Sub2.aClass1_1879 = arg1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("m.A(" + (arg0 != null ? "{...}" : "null") + ',' + (arg1 != null ? "{...}" : "null") + ',' + (arg2 != null ? "{...}" : "null") + ',' + arg3 + ')'));
        }
    }

    public static synchronized void method412(boolean arg0, Class6 arg1, int arg2, byte arg3, RSString arg4, int arg5, RSString arg6, int arg7) {
        try {
            anInt781++;
            if(Class24.method340(70)) {
                if(arg3 != 66)
                    method412(false, null, 120, (byte) -44, null, 71, null, -13);
                int i = arg1.method183(0, arg4);
                int i_16_ = arg1.method179(arg3 + -176, i, arg6);
                method403(arg7, true, arg5, i, arg1, i_16_, arg2, arg0);
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("m.K(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ',' + (arg4 != null ? "{...}" : "null") + ',' + arg5 + ',' + (arg6 != null ? "{...}" : "null") + ',' + arg7 + ')'));
        }
    }

    public static synchronized void method413(byte arg0) {
        anInt790++;
        if(Class24.method340(-124)) {
            if(Class26.aBoolean618) {
                byte[] is = RSString.method74(Class40_Sub5_Sub17_Sub1.anInt3004, Class22_Sub1.aClass6_1855, Class8.anInt289, -118, Class40_Sub6.anInt2110);
                if(is != null) {
                    if((Class6.anInt255 ^ 0xffffffff) > -1) {
                        if(Class6_Sub1.anInt1806 < 0)
                            RSString.method56(2037, Main.aBoolean1790, is, Floor.anInt2342);
                        else
                            Class40_Sub5_Sub4.method566((Floor.anInt2342), Main.aBoolean1790, Class6_Sub1.anInt1806, is, -27520);
                    } else
                        Class42.method886(0, Floor.anInt2342, Main.aBoolean1790, is, Class6.anInt255);
                    Class26.aBoolean618 = false;
                    Class22_Sub1.aClass6_1855 = null;
                }
            }
            Class59.method984(0);
            if(arg0 >= -109)
                method406(-59, -67, 107, 108);
        }
    }

    public static synchronized void method414(boolean arg0, int arg1, int arg2, int arg3, int arg4, Class6 arg5, int arg6) {
        try {
            anInt792++;
            if(Class24.method340(arg6 ^ ~0xf)) {
                Class26.aBoolean618 = true;
                Class6_Sub1.anInt1806 = arg6;
                Class6.anInt255 = -1;
                Floor.anInt2342 = arg3;
                Class40_Sub5_Sub17_Sub1.anInt3004 = arg4;
                Main.aBoolean1790 = arg0;
                Class40_Sub6.anInt2110 = arg1;
                Class22_Sub1.aClass6_1855 = arg5;
                Class8.anInt289 = arg2;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("m.L(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + (arg5 != null ? "{...}" : "null") + ',' + arg6 + ')'));
        }
    }
}
