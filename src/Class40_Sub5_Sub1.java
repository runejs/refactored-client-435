/* Class40_Sub5_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class40_Sub5_Sub1 extends SubNode {
    public static int anInt2261;
    public static int anInt2264;
    public static int anInt2265;
    public static Class45 aClass45_2268 = new Class45();
    public static int anInt2269;
    public static RSString aClass1_2273;
    public static RSString aClass1_2274;
    public static Class68 aClass68_2275;
    public static int anInt2276 = 0;
    public static RSString aClass1_2277;
    public static int anInt2278;
    public static RSString aClass1_2279 = Class58.method978("Lade Ignorieren)2Liste)3)3)3");
    public static int anInt2280;
    public static int anInt2281;

    static {
        aClass1_2277 = Class58.method978(" )2> @cya@");
        aClass1_2273 = Class58.method978("To");
        aClass1_2274 = aClass1_2273;
        anInt2280 = 0;
        anInt2278 = 0;
    }

    public int[] anIntArray2262;
    public int anInt2263;
    public int anInt2266;
    public int anInt2267;
    public RSString[] aClass1Array2270;
    public int anInt2271;
    public int[] anIntArray2272;

    public static void method542(int arg0) {
        try {
            aClass1_2279 = null;
            aClass1_2277 = null;
            aClass1_2273 = null;
            if(arg0 == -27934) {
                aClass1_2274 = null;
                aClass68_2275 = null;
                aClass45_2268 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "cc.A(" + arg0 + ')');
        }
    }

    public static void method543(Class3 arg0, int arg1, int arg2, int arg3, int arg4, Class2 arg5, int arg6, int arg7, int arg8, int arg9) {
        try {
            anInt2261++;
            int i = Class40_Sub6.anIntArrayArrayArray2099[arg2][arg9][arg8];
            int i_0_ = Class40_Sub6.anIntArrayArrayArray2099[arg2][1 + arg9][arg8];
            int i_1_ = Class40_Sub6.anIntArrayArrayArray2099[arg2][arg9][1 + arg8];
            int i_2_ = (Class40_Sub6.anIntArrayArrayArray2099[arg2][arg9 + 1][arg8 - -1]);
            Class40_Sub5_Sub8 class40_sub5_sub8 = Class40_Sub4.method535(arg1, (byte) 125);
            int i_3_ = i_2_ + i_0_ + (i + i_1_) >> 466559714;
            int i_4_ = (arg7 << 195627366) + arg4;
            int i_5_ = arg9 - (-(arg8 << -1503664185) - (arg1 << -1015388722) - 1073741824);
            if(class40_sub5_sub8.anInt2546 == 0)
                i_5_ += -2147483648;
            if((class40_sub5_sub8.anInt2533 ^ 0xffffffff) == -2)
                i_4_ += 256;
            if((arg4 ^ 0xffffffff) == -23) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 22, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                else
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, 22, (byte) 124, i_0_);
                arg5.method132(arg3, arg9, arg8, i_3_, class40_sub5_sub17, i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501 && class40_sub5_sub8.anInt2546 == 1)
                    arg0.method151((byte) -28, arg8, arg9);
            } else if((arg4 ^ 0xffffffff) == -11 || (arg4 ^ 0xffffffff) == -12) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 10, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                else
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, 10, (byte) 124, i_0_);
                if(class40_sub5_sub17 != null) {
                    int i_6_;
                    int i_7_;
                    if(arg7 != 1 && arg7 != 3) {
                        i_7_ = class40_sub5_sub8.anInt2503;
                        i_6_ = class40_sub5_sub8.anInt2515;
                    } else {
                        i_6_ = class40_sub5_sub8.anInt2503;
                        i_7_ = class40_sub5_sub8.anInt2515;
                    }
                    int i_8_ = 0;
                    if((arg4 ^ 0xffffffff) == -12)
                        i_8_ += 256;
                    arg5.method137(arg3, arg9, arg8, i_3_, i_7_, i_6_, class40_sub5_sub17, i_8_, i_5_, i_4_);
                }
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method154(arg9, class40_sub5_sub8.aBoolean2528, arg6 ^ ~0x5644, class40_sub5_sub8.anInt2515, arg7, arg8, class40_sub5_sub8.anInt2503);
            } else if((arg4 ^ 0xffffffff) <= -13) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, arg4, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                else
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, arg4, (byte) 124, i_0_);
                arg5.method137(arg3, arg9, arg8, i_3_, 1, 1, class40_sub5_sub17, 0, i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method154(arg9, class40_sub5_sub8.aBoolean2528, arg6 ^ ~0x5648, class40_sub5_sub8.anInt2515, arg7, arg8, class40_sub5_sub8.anInt2503);
            } else if(arg4 == 0) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if(class40_sub5_sub8.anInt2506 != -1 || class40_sub5_sub8.anIntArray2534 != null)
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 0, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                else
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, 0, (byte) 124, i_0_);
                arg5.method94(arg3, arg9, arg8, i_3_, class40_sub5_sub17, null, Class32.anIntArray761[arg7], 0, i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method150(arg8, arg4, arg7, arg9, class40_sub5_sub8.aBoolean2528, (byte) 95);
            } else if((arg4 ^ 0xffffffff) == -2) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if(class40_sub5_sub8.anInt2506 == -1 && class40_sub5_sub8.anIntArray2534 == null)
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, 1, (byte) 124, i_0_);
                else
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 1, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                arg5.method94(arg3, arg9, arg8, i_3_, class40_sub5_sub17, null, Class40_Sub5_Sub15.anIntArray2788[arg7], 0, i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method150(arg8, arg4, arg7, arg9, class40_sub5_sub8.aBoolean2528, (byte) 95);
            } else if(arg4 == 2) {
                int i_9_ = arg7 - -1 & 0x3;
                Class40_Sub5_Sub17 class40_sub5_sub17;
                Class40_Sub5_Sub17 class40_sub5_sub17_10_;
                if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null) {
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 2, 4 + arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                    class40_sub5_sub17_10_ = new Class40_Sub5_Sub17_Sub2(arg1, 2, i_9_, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                } else {
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7 + 4, i, 2, (byte) 124, i_0_);
                    class40_sub5_sub17_10_ = class40_sub5_sub8.method600(i_2_, i_1_, i_9_, i, 2, (byte) 124, i_0_);
                }
                arg5.method94(arg3, arg9, arg8, i_3_, class40_sub5_sub17, class40_sub5_sub17_10_, Class32.anIntArray761[arg7], Class32.anIntArray761[i_9_], i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method150(arg8, arg4, arg7, arg9, class40_sub5_sub8.aBoolean2528, (byte) 95);
            } else if(arg4 == 3) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 3, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                else
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, 3, (byte) 124, i_0_);
                arg5.method94(arg3, arg9, arg8, i_3_, class40_sub5_sub17, null, Class40_Sub5_Sub15.anIntArray2788[arg7], 0, i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method150(arg8, arg4, arg7, arg9, class40_sub5_sub8.aBoolean2528, (byte) 95);
            } else if((arg4 ^ 0xffffffff) == -10) {
                Class40_Sub5_Sub17 class40_sub5_sub17;
                if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                    class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, arg4, arg7, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                else
                    class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, arg7, i, arg4, (byte) 124, i_0_);
                arg5.method137(arg3, arg9, arg8, i_3_, 1, 1, class40_sub5_sub17, 0, i_5_, i_4_);
                if(class40_sub5_sub8.aBoolean2501)
                    arg0.method154(arg9, class40_sub5_sub8.aBoolean2528, -117, class40_sub5_sub8.anInt2515, arg7, arg8, class40_sub5_sub8.anInt2503);
            } else {
                if(class40_sub5_sub8.aBoolean2530) {
                    if((arg7 ^ 0xffffffff) != -2) {
                        if((arg7 ^ 0xffffffff) != -3) {
                            if((arg7 ^ 0xffffffff) == -4) {
                                int i_11_ = i_1_;
                                i_1_ = i;
                                i = i_0_;
                                i_0_ = i_2_;
                                i_2_ = i_11_;
                            }
                        } else {
                            int i_12_ = i_1_;
                            i_1_ = i_0_;
                            i_0_ = i_12_;
                            i_12_ = i_2_;
                            i_2_ = i;
                            i = i_12_;
                        }
                    } else {
                        int i_13_ = i_1_;
                        i_1_ = i_2_;
                        i_2_ = i_0_;
                        i_0_ = i;
                        i = i_13_;
                    }
                }
                if(arg4 == 4) {
                    Class40_Sub5_Sub17 class40_sub5_sub17;
                    if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                        class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 4, 0, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                    else
                        class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                    arg5.method109(arg3, arg9, arg8, i_3_, class40_sub5_sub17, Class32.anIntArray761[arg7], 512 * arg7, 0, 0, i_5_, i_4_);
                } else if(arg4 == 5) {
                    int i_14_ = 16;
                    int i_15_ = arg5.method122(arg3, arg9, arg8);
                    if(i_15_ > 0)
                        i_14_ = (Class40_Sub4.method535(i_15_ >> -1535148562 & 0x7fff, (byte) 127).anInt2505);
                    Class40_Sub5_Sub17 class40_sub5_sub17;
                    if(class40_sub5_sub8.anInt2506 == -1 && class40_sub5_sub8.anIntArray2534 == null)
                        class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                    else
                        class40_sub5_sub17 = new Class40_Sub5_Sub17_Sub2(arg1, 4, 0, i, i_0_, i_2_, i_1_, (class40_sub5_sub8.anInt2506), true);
                    arg5.method109(arg3, arg9, arg8, i_3_, class40_sub5_sub17, Class32.anIntArray761[arg7], 512 * arg7, Class27.anIntArray666[arg7] * i_14_, Class68_Sub1.anIntArray2207[arg7] * i_14_, i_5_, i_4_);
                } else if(arg6 == -22078) {
                    if(arg4 == 6) {
                        Class40_Sub5_Sub17 class40_sub5_sub17;
                        if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) != 0 || class40_sub5_sub8.anIntArray2534 != null)
                            class40_sub5_sub17 = (new Class40_Sub5_Sub17_Sub2(arg1, 4, 0, i, i_0_, i_2_, i_1_, class40_sub5_sub8.anInt2506, true));
                        else
                            class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                        arg5.method109(arg3, arg9, arg8, i_3_, class40_sub5_sub17, 256, arg7, 0, 0, i_5_, i_4_);
                    } else if((arg4 ^ 0xffffffff) == -8) {
                        Class40_Sub5_Sub17 class40_sub5_sub17;
                        if((class40_sub5_sub8.anInt2506 ^ 0xffffffff) == 0 && class40_sub5_sub8.anIntArray2534 == null)
                            class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                        else
                            class40_sub5_sub17 = (new Class40_Sub5_Sub17_Sub2(arg1, 4, 0, i, i_0_, i_2_, i_1_, class40_sub5_sub8.anInt2506, true));
                        arg5.method109(arg3, arg9, arg8, i_3_, class40_sub5_sub17, 512, arg7, 0, 0, i_5_, i_4_);
                    } else if((arg4 ^ 0xffffffff) == -9) {
                        Class40_Sub5_Sub17 class40_sub5_sub17;
                        if(class40_sub5_sub8.anInt2506 != -1 || class40_sub5_sub8.anIntArray2534 != null)
                            class40_sub5_sub17 = (new Class40_Sub5_Sub17_Sub2(arg1, 4, 0, i, i_0_, i_2_, i_1_, class40_sub5_sub8.anInt2506, true));
                        else
                            class40_sub5_sub17 = class40_sub5_sub8.method600(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                        arg5.method109(arg3, arg9, arg8, i_3_, class40_sub5_sub17, 768, arg7, 0, 0, i_5_, i_4_);
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("cc.C(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + (arg5 != null ? "{...}" : "null") + ',' + arg6 + ',' + arg7 + ',' + arg8 + ',' + arg9 + ')'));
        }
    }

    public static void method544(byte arg0) {
        anInt2281++;
        if(arg0 != -54)
            aClass1_2273 = null;
        if((Class62.anInt1470 ^ 0xffffffff) == -2) {
            if(Class57.anInt1338 >= 6 && Class57.anInt1338 <= 106 && RSString.anInt1668 >= 467 && (RSString.anInt1668 ^ 0xffffffff) >= -500) {
                Cache.aBoolean330 = true;
                Class35.anInt1737 = (1 + Class35.anInt1737) % 4;
                Class52.aBoolean1221 = true;
                Class32.packetBuffer.putPacket(11453, 32);
                Class34.anInt821++;
                Class32.packetBuffer.put(Class35.anInt1737, (byte) -128);
                Class32.packetBuffer.put(Class4.anInt185, (byte) -128);
                Class32.packetBuffer.put(ItemDefinition.anInt2797, (byte) -128);
            }
            if(Class57.anInt1338 >= 135 && (Class57.anInt1338 ^ 0xffffffff) >= -236 && (RSString.anInt1668 ^ 0xffffffff) <= -468 && (RSString.anInt1668 ^ 0xffffffff) >= -500) {
                Class52.aBoolean1221 = true;
                Class4.anInt185 = (Class4.anInt185 - -1) % 3;
                Cache.aBoolean330 = true;
                Class34.anInt821++;
                Class32.packetBuffer.putPacket(arg0 ^ ~0x2c88, 32);
                Class32.packetBuffer.put(Class35.anInt1737, (byte) -128);
                Class32.packetBuffer.put(Class4.anInt185, (byte) -128);
                Class32.packetBuffer.put(ItemDefinition.anInt2797, (byte) -128);
            }
            if((Class57.anInt1338 ^ 0xffffffff) <= -274 && Class57.anInt1338 <= 373 && RSString.anInt1668 >= 467 && RSString.anInt1668 <= 499) {
                ItemDefinition.anInt2797 = (ItemDefinition.anInt2797 - -1) % 3;
                Cache.aBoolean330 = true;
                Class52.aBoolean1221 = true;
                Class32.packetBuffer.putPacket(11453, 32);
                Class34.anInt821++;
                Class32.packetBuffer.put(Class35.anInt1737, (byte) -128);
                Class32.packetBuffer.put(Class4.anInt185, (byte) -128);
                Class32.packetBuffer.put(ItemDefinition.anInt2797, (byte) -128);
            }
            if(Class57.anInt1338 >= 412 && Class57.anInt1338 <= 512 && (RSString.anInt1668 ^ 0xffffffff) <= -468 && (RSString.anInt1668 ^ 0xffffffff) >= -500) {
                if(Class66.anInt1560 == -1) {
                    PacketBuffer.method516(127);
                    if((Class34.anInt854 ^ 0xffffffff) != 0) {
                        Class67.aBoolean1601 = false;
                        Class66.anInt1548 = Class66.anInt1560 = Class34.anInt854;
                        Class66.aClass1_1550 = Class66.aClass1_1567;
                    }
                } else
                    Class44.method895(arg0 ^ ~0x65, 0, Class37.aClass1_873, Class66.aClass1_1567);
            }
        }
    }

    public static void method545(int arg0, boolean arg1, int arg2, Player arg3, int arg4) {
        try {
            anInt2265++;
            if(Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760 != arg3 && NpcDefinition.anInt2394 < 400) {
                RSString class1;
                if(arg3.anInt3257 == 0)
                    class1 = (Class40_Sub5_Sub17_Sub6.method832(82, (new RSString[]{arg3.aClass1_3278, (Class40_Sub4.method536((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3260), arg3.anInt3260, -122)), HashTable.aClass1_569, Class40_Sub5_Sub2.aClass1_2286, HashTable.method334(arg3.anInt3260, -1), Class51.aClass1_1199})));
                else
                    class1 = (Class40_Sub5_Sub17_Sub6.method832(-60, (new RSString[]{arg3.aClass1_3278, HashTable.aClass1_569, Class26.aClass1_619, HashTable.method334(arg3.anInt3257, -1), Class51.aClass1_1199})));
                if((Class8.anInt301 ^ 0xffffffff) == -2) {
                    Node.anInt928++;
                    Floor.method558(arg4, Main.aClass1_1763, arg0, -501, arg2, 22, (Class40_Sub5_Sub17_Sub6.method832(55, (new RSString[]{NPC.aClass1_3295, Class40_Sub5_Sub17_Sub3.aClass1_3068, class1}))));
                } else if(Main.anInt1773 == 1) {
                    if((ItemDefinition.anInt2815 & 0x8) == 8) {
                        Floor.method558(arg4, Class38_Sub1.aClass1_1918, arg0, -501, arg2, 1, (Class40_Sub5_Sub17_Sub6.method832(124, (new RSString[]{Class25.aClass1_611, Class40_Sub5_Sub17_Sub3.aClass1_3068, class1}))));
                        Class22_Sub1.anInt1850++;
                    }
                } else {
                    for(int i = 4; (i ^ 0xffffffff) <= -1; i--) {
                        if(Main.aClass1Array1778[i] != null) {
                            Class3.anInt156++;
                            int i_16_ = 0;
                            int i_17_ = 0;
                            if(Main.aClass1Array1778[i].method63(Class38_Sub1.aClass1_1917, true)) {
                                if((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3260) < arg3.anInt3260)
                                    i_17_ = 2000;
                                if(((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3266) ^ 0xffffffff) != -1 && arg3.anInt3266 != 0) {
                                    if((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3266) != arg3.anInt3266)
                                        i_17_ = 0;
                                    else
                                        i_17_ = 2000;
                                }
                            } else if(Class13.aBooleanArray414[i])
                                i_17_ = 2000;
                            if((i ^ 0xffffffff) == -1)
                                i_16_ = 10 + i_17_;
                            if(i == 1)
                                i_16_ = 39 + i_17_;
                            if(i == 2)
                                i_16_ = i_17_ + 44;
                            if((i ^ 0xffffffff) == -4)
                                i_16_ = i_17_ + 14;
                            if(i == 4)
                                i_16_ = 41 + i_17_;
                            Floor.method558(arg4, Main.aClass1Array1778[i], arg0, -501, arg2, i_16_, (Class40_Sub5_Sub17_Sub6.method832(79, new RSString[]{Class26.aClass1_620, class1})));
                        }
                    }
                }
                if(arg1 == false) {
                    for(int i = 0; i < NpcDefinition.anInt2394; i++) {
                        if((Class38.anIntArray884[i] ^ 0xffffffff) == -8) {
                            Landscape.aClass1Array1184[i] = (Class40_Sub5_Sub17_Sub6.method832(-78, new RSString[]{Class22_Sub2.aClass1_1876, Class46.aClass1_1117, Class26.aClass1_620, class1}));
                            break;
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("cc.D(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + (arg3 != null ? "{...}" : "null") + ',' + arg4 + ')'));
        }
    }

    public static int method546(int arg0) {
        try {
            anInt2264++;
            if(arg0 != 256)
                anInt2280 = 44;
            int i = Class37.method430((byte) -120, Player.anInt3267, Class12.anInt388, Class40_Sub5_Sub6.anInt2443);
            if(i + -Class32.anInt769 < 800 && ((Floor.aByteArrayArrayArray2323[Player.anInt3267][Class12.anInt388 >> -1116963737][Class40_Sub5_Sub6.anInt2443 >> -161392185]) & 0x4) != 0)
                return Player.anInt3267;
            return 3;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "cc.B(" + arg0 + ')');
        }
    }
}
