/* CollisionMap - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class CollisionMap {
    public static int anInt137;
    public static int anInt138;
    public static int anInt139;
    public static int anInt141;
    public static int anInt142;
    public static int anInt143;
    public static int anInt144;
    public static int anInt146;
    public static int anInt147;
    public static int anInt148;
    public static int anInt149;
    public static int anInt152;
    public static int anInt154;
    public static int anInt155;
    public static int anInt156;
    public static int anInt157;
    public static int anInt158;
    public static int anInt159;
    public static int anInt160;
    public static int anInt161;
    public static Object anObject162 = new Object();
    public static int anInt163;
    public static RSString aClass1_164 = Class58.method978("Konfig geladen)3");
    public static int anInt165 = 0;
    public static Class8 aClass8_166;
    public static RSString aClass1_167;
    public static int anInt168;
    public static byte[] aByteArray169;
    public static RSString aClass1_170;
    public static RSString aClass1_171;
    public static int anInt172;

    static {
        anInt163 = -1;
        aByteArray169 = new byte[]{95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
        aClass1_171 = Class58.method978("Continue");
        aClass1_167 = aClass1_171;
        aClass1_170 = Class58.method978("(X");
    }

    public int anInt140;
    public int anInt145;
    public int[][] anIntArrayArray150;
    public int anInt151;
    public int anInt153;

    public CollisionMap(int arg0, int arg1) {
        try {
            anInt145 = arg1;
            anInt151 = 0;
            anInt140 = 0;
            anInt153 = arg0;
            anIntArrayArray150 = new int[anInt153][anInt145];
            method146(16777216);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ad.<init>(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method144(int arg0) {
        try {
            Class8.aFontMetrics295 = null;
            anInt152++;
            Class17.aFont461 = null;
            if(arg0 == 12433)
                Class26.anImage624 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ad.P(" + arg0 + ')');
        }
    }

    public static boolean parsePackets(boolean arg0) {
        try {
            anInt159++;
            if(Class40_Sub6.aClass64_2098 == null)
                return false;
            try {
                int i = Class40_Sub6.aClass64_2098.method1014(-122);
                if((i ^ 0xffffffff) == -1)
                    return false;
                if(Class57.packetid == -1) {
                    Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                    Cache.outgoingbuffer.currentPosition = 0;
                    i--;
                    Class57.packetid = Cache.outgoingbuffer.getPacket((byte) 49);
                    Class40_Sub5_Sub12.packetsize = Class24.INCOMINGPACKETSIZES[Class57.packetid];
                }
                System.out.println("packet received: " + Class57.packetid);
                if((Class40_Sub5_Sub12.packetsize ^ 0xffffffff) == 0) {
                    if((i ^ 0xffffffff) < -1) {
                        Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                        Class40_Sub5_Sub12.packetsize = (Cache.outgoingbuffer.buffer[0] & 0xff);
                        i--;
                    } else
                        return false;
                }
                if(Class40_Sub5_Sub12.packetsize == -2) {
                    if(i <= 1)
                        return false;
                    i -= 2;
                    Class40_Sub6.aClass64_2098.method1008(0, 2, -127, Cache.outgoingbuffer.buffer);
                    Cache.outgoingbuffer.currentPosition = 0;
                    Class40_Sub5_Sub12.packetsize = Cache.outgoingbuffer.method469(65280);
                }
                if((Class40_Sub5_Sub12.packetsize ^ 0xffffffff) < (i ^ 0xffffffff))
                    return false;
                Cache.outgoingbuffer.currentPosition = 0;
                Class40_Sub6.aClass64_2098.method1008(0, Class40_Sub5_Sub12.packetsize, -128, Cache.outgoingbuffer.buffer);
                Class49.anInt1151 = Cache.anInt324;
                Class35.anInt1728 = 0;
                Cache.anInt324 = RSString.anInt1690;
                RSString.anInt1690 = Class57.packetid;
                if(Class57.packetid == 71) {
                    long l = Cache.outgoingbuffer.method498(1362367312);
                    RSString class1 = Class54.method956(82, Cache.outgoingbuffer).method53(-16315);
                    Class44.method895(70, 6, class1, Class60.method991(-42, l).method85(-4305));
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 156) {
                    long l = Cache.outgoingbuffer.method498(1362367312);
                    int i_1_ = Cache.outgoingbuffer.method469(65280);
                    RSString class1 = Class60.method991(-64, l).method85(-4305);
                    for(int i_2_ = 0; i_2_ < Class40_Sub5_Sub17_Sub3.anInt3060; i_2_++) {
                        if(l == Class59.aLongArray1397[i_2_]) {
                            if(i_1_ != Class40_Sub7.anIntArray2131[i_2_]) {
                                Class40_Sub7.anIntArray2131[i_2_] = i_1_;
                                ISAAC.aBoolean505 = true;
                                if((i_1_ ^ 0xffffffff) < -1)
                                    Class44.method895(127, 5, (Class40_Sub5_Sub17_Sub6.method832(124, (new RSString[]{class1, (Class42.aClass1_988)}))), Class66.aClass1_1567);
                                if((i_1_ ^ 0xffffffff) == -1)
                                    Class44.method895(101, 5, (Class40_Sub5_Sub17_Sub6.method832(85, (new RSString[]{class1, Class38_Sub1.aClass1_1905}))), Class66.aClass1_1567);
                            }
                            class1 = null;
                            break;
                        }
                    }
                    boolean bool = false;
                    if(class1 != null && (Class40_Sub5_Sub17_Sub3.anInt3060 ^ 0xffffffff) > -201) {
                        Class59.aLongArray1397[(Class40_Sub5_Sub17_Sub3.anInt3060)] = l;
                        Class40_Sub11.aClass1Array2147[(Class40_Sub5_Sub17_Sub3.anInt3060)] = class1;
                        Class40_Sub7.anIntArray2131[(Class40_Sub5_Sub17_Sub3.anInt3060)] = i_1_;
                        Class40_Sub5_Sub17_Sub3.anInt3060++;
                        ISAAC.aBoolean505 = true;
                    }
                    while(!bool) {
                        bool = true;
                        for(int i_3_ = 0; Class40_Sub5_Sub17_Sub3.anInt3060 - 1 > i_3_; i_3_++) {
                            if((((Class40_Sub7.anIntArray2131[i_3_] ^ 0xffffffff) != (Class13.worldid ^ 0xffffffff)) && ((Class13.worldid ^ 0xffffffff) == (Class40_Sub7.anIntArray2131[1 + i_3_] ^ 0xffffffff))) || ((Class40_Sub7.anIntArray2131[i_3_] ^ 0xffffffff) == -1 && (Class40_Sub7.anIntArray2131[i_3_ + 1] ^ 0xffffffff) != -1)) {
                                bool = false;
                                int i_4_ = Class40_Sub7.anIntArray2131[i_3_];
                                Class40_Sub7.anIntArray2131[i_3_] = Class40_Sub7.anIntArray2131[i_3_ + 1];
                                Class40_Sub7.anIntArray2131[1 + i_3_] = i_4_;
                                RSString class1_5_ = Class40_Sub11.aClass1Array2147[i_3_];
                                Class40_Sub11.aClass1Array2147[i_3_] = Class40_Sub11.aClass1Array2147[1 + i_3_];
                                Class40_Sub11.aClass1Array2147[1 + i_3_] = class1_5_;
                                long l_6_ = Class59.aLongArray1397[i_3_];
                                Class59.aLongArray1397[i_3_] = Class59.aLongArray1397[i_3_ + 1];
                                Class59.aLongArray1397[1 + i_3_] = l_6_;
                                ISAAC.aBoolean505 = true;
                            }
                        }
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -234) {
                    Class57.packetid = -1;
                    Class40_Sub5_Sub4.anInt2366 = 0;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -8) {
                    Class39.aBoolean906 = false;
                    for(int i_7_ = 0; i_7_ < 5; i_7_++)
                        Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_7_] = false;
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 23) {
                    FloorDecoration.method343(true, 5688);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -223) {
                    int i_8_ = Cache.outgoingbuffer.method492(128);
                    int i_9_ = Cache.outgoingbuffer.method461((byte) 119);
                    Buffer.anIntArray1984[i_9_] = i_8_;
                    if((i_8_ ^ 0xffffffff) != (Class58.varbitmasks[i_9_] ^ 0xffffffff)) {
                        Class58.varbitmasks[i_9_] = i_8_;
                        Class22.method309(-1, i_9_);
                        ISAAC.aBoolean505 = true;
                        if((Class48.anInt1138 ^ 0xffffffff) != 0)
                            Class52.aBoolean1221 = true;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -116) {
                    boolean bool = ((Cache.outgoingbuffer.method468(false) ^ 0xffffffff) == -2);
                    int i_10_ = Cache.outgoingbuffer.method470(-123);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_10_, (byte) -92);
                    class40_sub5_sub12.aBoolean2750 = bool;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -13) {
                    ISAAC.aBoolean505 = true;
                    int i_11_ = Cache.outgoingbuffer.method491(-4750);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_11_, (byte) -128);
                    if(!class40_sub5_sub12.aBoolean2636) {
                        for(int i_12_ = 0; class40_sub5_sub12.anIntArray2685.length > i_12_; i_12_++) {
                            class40_sub5_sub12.anIntArray2685[i_12_] = 0;
                            class40_sub5_sub12.anIntArray2710[i_12_] = 0;
                        }
                    } else {
                        Class40_Sub5_Sub12[] class40_sub5_sub12s = (Class59.aClass40_Sub5_Sub12ArrayArray1390[i_11_ >> -1887808688]);
                        for(int i_13_ = 0; i_13_ < class40_sub5_sub12s.length; i_13_++) {
                            Class40_Sub5_Sub12 class40_sub5_sub12_14_ = class40_sub5_sub12s[i_13_];
                            if(((0xffff & class40_sub5_sub12_14_.anInt2648 ^ 0xffffffff) == (0xffff & class40_sub5_sub12.anInt2689 ^ 0xffffffff)) && (class40_sub5_sub12_14_.anInt2736 ^ 0xffffffff) < -1) {
                                class40_sub5_sub12_14_.anInt2734 = 0;
                                class40_sub5_sub12_14_.anInt2718 = -1;
                            }
                        }
                    }
                    int i_15_ = Cache.outgoingbuffer.method469(65280);
                    for(int i_16_ = 0; (i_15_ ^ 0xffffffff) < (i_16_ ^ 0xffffffff); i_16_++) {
                        int i_17_ = Cache.outgoingbuffer.method476(255);
                        if((i_17_ ^ 0xffffffff) == -256)
                            i_17_ = Cache.outgoingbuffer.method491(-4750);
                        int i_18_ = Cache.outgoingbuffer.method461((byte) 58);
                        if(!class40_sub5_sub12.aBoolean2636) {
                            if(class40_sub5_sub12.anIntArray2685.length > i_16_) {
                                class40_sub5_sub12.anIntArray2685[i_16_] = i_18_;
                                class40_sub5_sub12.anIntArray2710[i_16_] = i_17_;
                            }
                        } else {
                            Class40_Sub5_Sub12[] class40_sub5_sub12s = (Class59.aClass40_Sub5_Sub12ArrayArray1390[i_11_ >> -424241648]);
                            for(int i_19_ = 0; ((i_19_ ^ 0xffffffff) > (class40_sub5_sub12s.length ^ 0xffffffff)); i_19_++) {
                                Class40_Sub5_Sub12 class40_sub5_sub12_20_ = class40_sub5_sub12s[i_19_];
                                if(((class40_sub5_sub12.anInt2689 & 0xffff) == (class40_sub5_sub12_20_.anInt2648 & 0xffff)) && ((class40_sub5_sub12_20_.anInt2736 ^ 0xffffffff) == (1 + i_16_ ^ 0xffffffff))) {
                                    class40_sub5_sub12_20_.anInt2734 = i_17_;
                                    class40_sub5_sub12_20_.anInt2718 = -1 + i_18_;
                                }
                            }
                        }
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -251) {
                    int i_21_ = Cache.outgoingbuffer.method490((byte) -70);
                    int i_22_ = Cache.outgoingbuffer.method470(-121);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_22_, (byte) -87);
                    class40_sub5_sub12.anInt2673 = i_21_;
                    class40_sub5_sub12.anInt2687 = 1;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -256) {
                    int i_23_ = Cache.outgoingbuffer.method468(arg0);
                    int i_24_ = Cache.outgoingbuffer.method468(false);
                    int i_25_ = Cache.outgoingbuffer.method468(false);
                    int i_26_ = Cache.outgoingbuffer.method468(false);
                    Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_23_] = true;
                    Class8.anIntArray297[i_23_] = i_24_;
                    RSApplet.anIntArray2[i_23_] = i_25_;
                    Class58.anIntArray1358[i_23_] = i_26_;
                    Class22_Sub1.anIntArray1846[i_23_] = 0;
                    Class57.packetid = -1;
                    return true;
                }
                if(arg0 != false)
                    anInt172 = -96;
                if(Class57.packetid == 235) {
                    Class27.anInt658 = Cache.outgoingbuffer.method468(false);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 48) {
                    Class40_Sub6.anInt2118 = Cache.outgoingbuffer.method468(false);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 82) {
                    RSString class1 = Cache.outgoingbuffer.getRSString(-10721);
                    if(!class1.method87(103, Class40_Sub5_Sub7.aClass1_2472)) {
                        if(!class1.method87(104, Class40_Sub5_Sub6.aClass1_2434)) {
                            if(!class1.method87(81, Node.aClass1_948))
                                Class44.method895(72, 0, class1, Class66.aClass1_1567);
                            else {
                                RSString class1_27_ = (class1.method68(0, 0, class1.method60(Class43.aClass1_1027, 32)));
                                long l = class1_27_.method58((byte) 121);
                                boolean bool = false;
                                for(int i_28_ = 0; i_28_ < Class42.anInt1008; i_28_++) {
                                    if(l == Class53.aLongArray1267[i_28_]) {
                                        bool = true;
                                        break;
                                    }
                                }
                                if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1) {
                                    RSString class1_29_ = (class1.method68(0, (1 + class1.method60((Class43.aClass1_1027), 32)), -9 + class1.method59(-3136)));
                                    Class44.method895(122, 8, class1_29_, class1_27_);
                                }
                            }
                        } else {
                            RSString class1_30_ = (class1.method68(0, 0, class1.method60(Class43.aClass1_1027, 32)));
                            long l = class1_30_.method58((byte) 120);
                            boolean bool = false;
                            for(int i_31_ = 0; ((Class42.anInt1008 ^ 0xffffffff) < (i_31_ ^ 0xffffffff)); i_31_++) {
                                if((Class53.aLongArray1267[i_31_] ^ 0xffffffffffffffffL) == (l ^ 0xffffffffffffffffL)) {
                                    bool = true;
                                    break;
                                }
                            }
                            if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1)
                                Class44.method895(120, 8, Class61.aClass1_1428, class1_30_);
                        }
                    } else {
                        RSString class1_32_ = class1.method68(0, 0, class1.method60((Class43.aClass1_1027), 32));
                        long l = class1_32_.method58((byte) 98);
                        boolean bool = false;
                        for(int i_33_ = 0; i_33_ < Class42.anInt1008; i_33_++) {
                            if((Class53.aLongArray1267[i_33_] ^ 0xffffffffffffffffL) == (l ^ 0xffffffffffffffffL)) {
                                bool = true;
                                break;
                            }
                        }
                        if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1)
                            Class44.method895(94, 4, Class4.aClass1_180, class1_32_);
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 182) {
                    int i_34_ = Cache.outgoingbuffer.method469(65280);
                    int i_35_ = Cache.outgoingbuffer.method485((byte) -48);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_35_, (byte) -61);
                    Class57.packetid = -1;
                    if(class40_sub5_sub12 != null && (class40_sub5_sub12.anInt2683 ^ 0xffffffff) == -1) {
                        if((i_34_ ^ 0xffffffff) > -1)
                            i_34_ = 0;
                        if((-class40_sub5_sub12.anInt2643 + class40_sub5_sub12.anInt2720) < i_34_)
                            i_34_ = (-class40_sub5_sub12.anInt2643 + class40_sub5_sub12.anInt2720);
                        class40_sub5_sub12.anInt2731 = i_34_;
                    }
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -175) {
                    int i_36_ = Cache.outgoingbuffer.method470(-128);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_36_, (byte) -115);
                    if(class40_sub5_sub12.aBoolean2636) {
                        Class40_Sub5_Sub12[] class40_sub5_sub12s = (Class59.aClass40_Sub5_Sub12ArrayArray1390[i_36_ >> -1339248816]);
                        for(int i_37_ = 0; i_37_ < class40_sub5_sub12s.length; i_37_++) {
                            Class40_Sub5_Sub12 class40_sub5_sub12_38_ = class40_sub5_sub12s[i_37_];
                            if(((class40_sub5_sub12_38_.anInt2648 & 0xffff ^ 0xffffffff) == (0xffff & class40_sub5_sub12.anInt2689 ^ 0xffffffff)) && class40_sub5_sub12_38_.anInt2736 > 0) {
                                class40_sub5_sub12_38_.anInt2718 = -1;
                                class40_sub5_sub12_38_.anInt2734 = 0;
                            }
                        }
                    } else {
                        for(int i_39_ = 0; class40_sub5_sub12.anIntArray2685.length > i_39_; i_39_++) {
                            class40_sub5_sub12.anIntArray2685[i_39_] = -1;
                            class40_sub5_sub12.anIntArray2685[i_39_] = 0;
                        }
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -131) {
                    Class34.anInt854 = Cache.outgoingbuffer.method490((byte) -70);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -130) {
                    int i_40_ = Cache.outgoingbuffer.method471((byte) 31);
                    int i_41_ = Cache.outgoingbuffer.method476(255);
                    int i_42_ = Cache.outgoingbuffer.method471((byte) 114);
                    Player.anInt3267 = i_40_ >> 2097688801;
                    Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.method787(i_42_, -7717, (i_40_ & 0x1) == 1, i_41_);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 181) {
                    Class48.method928(-7225);
                    Class57.packetid = -1;
                    return false;
                }
                if((Class57.packetid ^ 0xffffffff) == -25) {
                    int i_43_ = Cache.outgoingbuffer.method463((byte) -118);
                    int i_44_ = Cache.outgoingbuffer.method491(-4750);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_44_, (byte) -82);
                    if(((class40_sub5_sub12.anInt2659 ^ 0xffffffff) != (i_43_ ^ 0xffffffff)) || (i_43_ ^ 0xffffffff) == 0) {
                        class40_sub5_sub12.anInt2660 = 0;
                        class40_sub5_sub12.anInt2654 = 0;
                        class40_sub5_sub12.anInt2659 = i_43_;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -57) {
                    int i_45_ = Cache.outgoingbuffer.method460(-23843);
                    if((i_45_ ^ 0xffffffff) <= -1)
                        Class42.method883((byte) -121, i_45_);
                    if((Class58.anInt1376 ^ 0xffffffff) != (i_45_ ^ 0xffffffff)) {
                        Class55.method958(Class58.anInt1376, -14222);
                        Class58.anInt1376 = i_45_;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -118) {
                    int i_46_ = Cache.outgoingbuffer.method469(65280);
                    int i_47_ = Cache.outgoingbuffer.method504(false);
                    int i_48_ = Cache.outgoingbuffer.method485((byte) -48);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_48_, (byte) -100);
                    Class57.packetid = -1;
                    class40_sub5_sub12.anInt2722 = i_47_ + (i_46_ << -1109526864);
                    return true;
                }
                if(Class57.packetid == 84) {
                    int i_49_ = Cache.outgoingbuffer.method469(65280);
                    int i_50_ = Cache.outgoingbuffer.method504(arg0);
                    if(Class43.anInt1028 != -1) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class52.aBoolean1221 = true;
                        Class43.anInt1028 = -1;
                    }
                    if(NpcDefinition.anInt2433 != -1) {
                        Class55.method958(NpcDefinition.anInt2433, -14222);
                        NpcDefinition.anInt2433 = -1;
                        Floor.method559(30, 91);
                    }
                    if(Class40_Sub5_Sub9.anInt2562 != -1) {
                        Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
                        Class40_Sub5_Sub9.anInt2562 = -1;
                    }
                    if(Class66.anInt1560 != i_50_) {
                        Class55.method958(Class66.anInt1560, -14222);
                        Class66.anInt1560 = i_50_;
                    }
                    if((i_49_ ^ 0xffffffff) != (Class29.anInt673 ^ 0xffffffff)) {
                        Class55.method958(Class29.anInt673, -14222);
                        Class29.anInt673 = i_49_;
                    }
                    Class6_Sub1.anInt1819 = -1;
                    if(Class40_Sub5_Sub15.anInt2780 != 0) {
                        Class52.aBoolean1221 = true;
                        Class40_Sub5_Sub15.anInt2780 = 0;
                    }
                    ISAAC.aBoolean505 = true;
                    Class40_Sub5_Sub10.aBoolean2597 = true;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -65) {
                    Floor.anInt2318 = Cache.outgoingbuffer.method468(false);
                    Class40_Sub6.anInt2119 = Cache.outgoingbuffer.method476(255);
                    for(int i_51_ = Class40_Sub6.anInt2119; ((i_51_ ^ 0xffffffff) > (8 + Class40_Sub6.anInt2119 ^ 0xffffffff)); i_51_++) {
                        for(int i_52_ = Floor.anInt2318; ((8 + Floor.anInt2318 ^ 0xffffffff) < (i_52_ ^ 0xffffffff)); i_52_++) {
                            if((Class10.aClass45ArrayArrayArray357[Player.anInt3267][i_51_][i_52_]) != null) {
                                Class10.aClass45ArrayArrayArray357[Player.anInt3267][i_51_][i_52_] = null;
                                Class40_Sub13.method880((byte) -80, i_52_, i_51_);
                            }
                        }
                    }
                    for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) Class45.aClass45_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = (Class40_Sub3) Class45.aClass45_1064.method909(-4)) {
                        if(class40_sub3.anInt2039 >= Class40_Sub6.anInt2119 && (Class40_Sub6.anInt2119 + 8 > class40_sub3.anInt2039) && (class40_sub3.anInt2038 >= Floor.anInt2318) && (Floor.anInt2318 + 8 > class40_sub3.anInt2038) && (Player.anInt3267 == class40_sub3.anInt2018))
                            class40_sub3.anInt2031 = 0;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -224) {
                    RSString class1 = Cache.outgoingbuffer.getRSString(-10721);
                    int i_53_ = Cache.outgoingbuffer.method480((byte) -70);
                    int i_54_ = Cache.outgoingbuffer.method468(arg0);
                    if(i_54_ >= 1 && (i_54_ ^ 0xffffffff) >= -6) {
                        if(class1.method63(RSApplet.aClass1_34, !arg0))
                            class1 = null;
                        Main.aClass1Array1778[i_54_ + -1] = class1;
                        Class13.aBooleanArray414[i_54_ + -1] = (i_53_ ^ 0xffffffff) == -1;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 118) {
                    int i_55_ = Cache.outgoingbuffer.method469(65280);
                    Class42.method883((byte) -127, i_55_);
                    if(Class29.anInt673 != -1) {
                        Class55.method958(Class29.anInt673, -14222);
                        Class40_Sub5_Sub10.aBoolean2597 = true;
                        Class29.anInt673 = -1;
                        ISAAC.aBoolean505 = true;
                    }
                    if((Class43.anInt1028 ^ 0xffffffff) != 0) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class52.aBoolean1221 = true;
                        Class43.anInt1028 = -1;
                    }
                    if((NpcDefinition.anInt2433 ^ 0xffffffff) != 0) {
                        Class55.method958(NpcDefinition.anInt2433, -14222);
                        NpcDefinition.anInt2433 = -1;
                        Floor.method559(30, -117);
                    }
                    if((Class40_Sub5_Sub9.anInt2562 ^ 0xffffffff) != 0) {
                        Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
                        Class40_Sub5_Sub9.anInt2562 = -1;
                    }
                    if(i_55_ != Class66.anInt1560) {
                        Class55.method958(Class66.anInt1560, -14222);
                        Class66.anInt1560 = i_55_;
                    }
                    Class6_Sub1.anInt1819 = -1;
                    if(Class40_Sub5_Sub15.anInt2780 != 0) {
                        Class52.aBoolean1221 = true;
                        Class40_Sub5_Sub15.anInt2780 = 0;
                    }
                    Class64.method1012(Class66.anInt1560, 2);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 18) {
                    if((Class5.anInt208 ^ 0xffffffff) == -13)
                        ISAAC.aBoolean505 = true;
                    Class40_Sub11.anInt2158 = Cache.outgoingbuffer.method468(false);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 253) {
                    Class39.aBoolean906 = true;
                    Class22.anInt545 = Cache.outgoingbuffer.method468(false);
                    Class32.anInt767 = Cache.outgoingbuffer.method468(arg0);
                    Class5.anInt194 = Cache.outgoingbuffer.method469(65280);
                    Class4.anInt188 = Cache.outgoingbuffer.method468(false);
                    Class59.anInt1386 = Cache.outgoingbuffer.method468(false);
                    if((Class59.anInt1386 ^ 0xffffffff) <= -101) {
                        Class40_Sub5_Sub6.anInt2443 = 64 + Class32.anInt767 * 128;
                        Class12.anInt388 = Class22.anInt545 * 128 + 64;
                        Class32.anInt769 = (Class37.method430((byte) -125, (Player.anInt3267), Class12.anInt388, Class40_Sub5_Sub6.anInt2443) - Class5.anInt194);
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 185) {
                    int i_56_ = Cache.outgoingbuffer.method460(-23843);
                    if(Class48.anInt1138 != i_56_) {
                        Class55.method958(Class48.anInt1138, -14222);
                        Class48.anInt1138 = i_56_;
                    }
                    Class57.packetid = -1;
                    Class52.aBoolean1221 = true;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -196) {
                    int i_57_ = Cache.outgoingbuffer.method461((byte) 96);
                    int i_58_ = Cache.outgoingbuffer.method469(65280);
                    Class42.method883((byte) -120, i_58_);
                    if(i_57_ != -1)
                        Class42.method883((byte) -124, i_57_);
                    if(Class66.anInt1560 != -1) {
                        Class55.method958(Class66.anInt1560, -14222);
                        Class66.anInt1560 = -1;
                    }
                    if((Class29.anInt673 ^ 0xffffffff) != 0) {
                        Class55.method958(Class29.anInt673, -14222);
                        Class29.anInt673 = -1;
                    }
                    if(Class43.anInt1028 != -1) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class43.anInt1028 = -1;
                    }
                    if((NpcDefinition.anInt2433 ^ 0xffffffff) != (i_58_ ^ 0xffffffff)) {
                        Class55.method958(NpcDefinition.anInt2433, -14222);
                        NpcDefinition.anInt2433 = i_58_;
                        Floor.method559(35, -57);
                    }
                    if(i_58_ != Class40_Sub5_Sub9.anInt2562) {
                        Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
                        Class40_Sub5_Sub9.anInt2562 = i_57_;
                    }
                    Class6_Sub1.anInt1819 = -1;
                    Class40_Sub5_Sub15.anInt2780 = 0;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -181) {
                    if(Class29.anInt673 != -1) {
                        Class55.method958(Class29.anInt673, -14222);
                        ISAAC.aBoolean505 = true;
                        Class40_Sub5_Sub10.aBoolean2597 = true;
                        Class29.anInt673 = -1;
                    }
                    if((Class43.anInt1028 ^ 0xffffffff) != 0) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class52.aBoolean1221 = true;
                        Class43.anInt1028 = -1;
                    }
                    if((NpcDefinition.anInt2433 ^ 0xffffffff) != 0) {
                        Class55.method958(NpcDefinition.anInt2433, -14222);
                        NpcDefinition.anInt2433 = -1;
                        Floor.method559(30, -84);
                    }
                    if(Class40_Sub5_Sub9.anInt2562 != -1) {
                        Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
                        Class40_Sub5_Sub9.anInt2562 = -1;
                    }
                    if(Class66.anInt1560 != -1) {
                        Class55.method958(Class66.anInt1560, -14222);
                        Class66.anInt1560 = -1;
                    }
                    Class57.packetid = -1;
                    Class6_Sub1.anInt1819 = -1;
                    if(Class40_Sub5_Sub15.anInt2780 != 0) {
                        Class52.aBoolean1221 = true;
                        Class40_Sub5_Sub15.anInt2780 = 0;
                    }
                    return true;
                }
                if(Class57.packetid == 208) {
                    int i_59_ = Cache.outgoingbuffer.method461((byte) 94);
                    Class42.method883((byte) -119, i_59_);
                    if((Class29.anInt673 ^ 0xffffffff) != 0) {
                        Class55.method958(Class29.anInt673, -14222);
                        Class40_Sub5_Sub10.aBoolean2597 = true;
                        Class29.anInt673 = -1;
                        ISAAC.aBoolean505 = true;
                    }
                    if(NpcDefinition.anInt2433 != -1) {
                        Class55.method958(NpcDefinition.anInt2433, -14222);
                        NpcDefinition.anInt2433 = -1;
                        Floor.method559(30, -53);
                    }
                    if((Class40_Sub5_Sub9.anInt2562 ^ 0xffffffff) != 0) {
                        Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
                        Class40_Sub5_Sub9.anInt2562 = -1;
                    }
                    if(Class66.anInt1560 != -1) {
                        Class55.method958(Class66.anInt1560, -14222);
                        Class66.anInt1560 = -1;
                    }
                    if(Class43.anInt1028 != i_59_) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class43.anInt1028 = i_59_;
                    }
                    Class52.aBoolean1221 = true;
                    Class57.packetid = -1;
                    Class6_Sub1.anInt1819 = -1;
                    return true;
                }
                if(Class57.packetid == 217) {
                    int i_60_ = Cache.outgoingbuffer.method490((byte) -70);
                    if(i_60_ == 65535)
                        i_60_ = -1;
                    Class51.method942(257, i_60_);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -41) {
                    int i_61_ = Cache.outgoingbuffer.getTri(true);
                    int i_62_ = Cache.outgoingbuffer.method461((byte) 58);
                    if(i_62_ == 65535)
                        i_62_ = -1;
                    Class57.method975(i_61_, (byte) 110, i_62_);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 254) {
                    Floor.anInt2318 = Cache.outgoingbuffer.method480((byte) -70);
                    Class40_Sub6.anInt2119 = Cache.outgoingbuffer.method471((byte) -67);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 88) {
                    Class51.anInt1205 = Cache.outgoingbuffer.method476(255);
                    if(Class5.anInt208 == Class51.anInt1205) {
                        if(Class51.anInt1205 != 3)
                            Class5.anInt208 = 3;
                        else
                            Class5.anInt208 = 1;
                        ISAAC.aBoolean505 = true;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -64) {
                    Class40_Sub6.anInt2119 = Cache.outgoingbuffer.method471((byte) -87);
                    Floor.anInt2318 = Cache.outgoingbuffer.method480((byte) -70);
                    while(Cache.outgoingbuffer.currentPosition < Class40_Sub5_Sub12.packetsize) {
                        Class57.packetid = Cache.outgoingbuffer.method468(false);
                        Class53.method949((byte) -125);
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -197) {
                    Class35.anInt1737 = Cache.outgoingbuffer.method468(false);
                    Class4.anInt185 = Cache.outgoingbuffer.method468(false);
                    ItemDefinition.anInt2797 = Cache.outgoingbuffer.method468(arg0);
                    Class52.aBoolean1221 = true;
                    Cache.aBoolean330 = true;
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 116) {
                    Class40_Sub5_Sub15.anInt2782 = (Cache.outgoingbuffer.method490((byte) -70) * 30);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 92) {
                    Class27.method354((byte) 57);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -3) {
                    int i_63_ = Cache.outgoingbuffer.method470(-121);
                    int i_64_ = Cache.outgoingbuffer.method469(65280);
                    Buffer.anIntArray1984[i_64_] = i_63_;
                    if(i_63_ != Class58.varbitmasks[i_64_]) {
                        Class58.varbitmasks[i_64_] = i_63_;
                        Class22.method309(-1, i_64_);
                        if((Class48.anInt1138 ^ 0xffffffff) != 0)
                            Class52.aBoolean1221 = true;
                        ISAAC.aBoolean505 = true;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -129) {
                    GameObject.method768(89);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -132) {
                    int i_65_ = Cache.outgoingbuffer.method469(65280);
                    int i_66_ = Cache.outgoingbuffer.method468(false);
                    int i_67_ = Cache.outgoingbuffer.method469(65280);
                    Class53.method950(i_65_, (byte) 118, i_66_, i_67_);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -238) {
                    int i_68_ = Cache.outgoingbuffer.method469(65280);
                    Class42.method883((byte) 107, i_68_);
                    if(Class43.anInt1028 != -1) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class43.anInt1028 = -1;
                        Class52.aBoolean1221 = true;
                    }
                    if((NpcDefinition.anInt2433 ^ 0xffffffff) != 0) {
                        Class55.method958(NpcDefinition.anInt2433, -14222);
                        NpcDefinition.anInt2433 = -1;
                        Floor.method559(30, 81);
                    }
                    if((Class40_Sub5_Sub9.anInt2562 ^ 0xffffffff) != 0) {
                        Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
                        Class40_Sub5_Sub9.anInt2562 = -1;
                    }
                    if((Class66.anInt1560 ^ 0xffffffff) != 0) {
                        Class55.method958(Class66.anInt1560, -14222);
                        Class66.anInt1560 = -1;
                    }
                    if((i_68_ ^ 0xffffffff) != (Class29.anInt673 ^ 0xffffffff)) {
                        Class55.method958(Class29.anInt673, -14222);
                        Class29.anInt673 = i_68_;
                    }
                    Class40_Sub5_Sub10.aBoolean2597 = true;
                    if(Class40_Sub5_Sub15.anInt2780 != 0) {
                        Class52.aBoolean1221 = true;
                        Class40_Sub5_Sub15.anInt2780 = 0;
                    }
                    Class6_Sub1.anInt1819 = -1;
                    Class57.packetid = -1;
                    ISAAC.aBoolean505 = true;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -235) {
                    Class39.aBoolean906 = true;
                    HashTable.anInt564 = Cache.outgoingbuffer.method468(false);
                    Class40_Sub5_Sub9.anInt2576 = Cache.outgoingbuffer.method468(false);
                    Class38.anInt892 = Cache.outgoingbuffer.method469(65280);
                    Class60.anInt1413 = Cache.outgoingbuffer.method468(arg0);
                    Class22_Sub1.anInt1856 = Cache.outgoingbuffer.method468(false);
                    if((Class22_Sub1.anInt1856 ^ 0xffffffff) <= -101) {
                        int i_69_ = 128 * HashTable.anInt564 + 64;
                        int i_70_ = 128 * Class40_Sub5_Sub9.anInt2576 + 64;
                        int i_71_ = (Class37.method430((byte) -120, (Player.anInt3267), i_69_, i_70_) - Class38.anInt892);
                        int i_72_ = i_69_ + -Class12.anInt388;
                        int i_73_ = i_70_ + -Class40_Sub5_Sub6.anInt2443;
                        int i_74_ = -Class32.anInt769 + i_71_;
                        int i_75_ = (int) Math.sqrt((double) (i_73_ * i_73_ + i_72_ * i_72_));
                        Class26.anInt627 = ((int) (325.949 * Math.atan2((double) i_74_, (double) i_75_)) & 0x7ff);
                        Class68_Sub1.anInt2210 = (int) (Math.atan2((double) i_72_, (double) i_73_) * -325.949) & 0x7ff;
                        if((Class26.anInt627 ^ 0xffffffff) > -129)
                            Class26.anInt627 = 128;
                        if((Class26.anInt627 ^ 0xffffffff) < -384)
                            Class26.anInt627 = 383;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -143) {
                    int i_76_ = Cache.outgoingbuffer.method469(65280);
                    int i_77_ = Cache.outgoingbuffer.method490((byte) -70);
                    int i_78_ = Cache.outgoingbuffer.method469(65280);
                    int i_79_ = Cache.outgoingbuffer.method485((byte) -48);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_79_, (byte) -86);
                    Class57.packetid = -1;
                    class40_sub5_sub12.anInt2657 = i_76_;
                    class40_sub5_sub12.anInt2728 = i_77_;
                    class40_sub5_sub12.anInt2690 = i_78_;
                    return true;
                }
                if(Class57.packetid == 6) {
                    Class5.anInt208 = Cache.outgoingbuffer.method468(false);
                    Class40_Sub5_Sub10.aBoolean2597 = true;
                    ISAAC.aBoolean505 = true;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -172) {
                    if(Class5.anInt208 == 12)
                        ISAAC.aBoolean505 = true;
                    Class52.anInt1222 = Cache.outgoingbuffer.method463((byte) -108);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 9 || Class57.packetid == 99 || Class57.packetid == 229 || Class57.packetid == 19 || (Class57.packetid ^ 0xffffffff) == -203 || (Class57.packetid ^ 0xffffffff) == -2 || Class57.packetid == 74 || Class57.packetid == 175 || Class57.packetid == 49 || (Class57.packetid ^ 0xffffffff) == -144 || Class57.packetid == 241) {
                    Class53.method949((byte) -112);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -15) {
                    for(int i_80_ = 0; Class59.anInt1383 > i_80_; i_80_++) {
                        Class40_Sub5_Sub11 class40_sub5_sub11 = NPC.method795((byte) -114, i_80_);
                        if(class40_sub5_sub11 != null && class40_sub5_sub11.anInt2633 == 0) {
                            Buffer.anIntArray1984[i_80_] = 0;
                            Class58.varbitmasks[i_80_] = 0;
                        }
                    }
                    if(Class48.anInt1138 != -1)
                        Class52.aBoolean1221 = true;
                    ISAAC.aBoolean505 = true;
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 160) {
                    int i_81_ = Cache.outgoingbuffer.method490((byte) -70);
                    int i_82_ = Cache.outgoingbuffer.method485((byte) -48);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_82_, (byte) -67);
                    class40_sub5_sub12.anInt2687 = 2;
                    Class57.packetid = -1;
                    class40_sub5_sub12.anInt2673 = i_81_;
                    return true;
                }
                if(Class57.packetid == 132) {
                    if((Class43.anInt1028 ^ 0xffffffff) != 0) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class43.anInt1028 = -1;
                    }
                    Class57.packetid = -1;
                    Class66.aClass1_1543 = Class66.aClass1_1567;
                    Class40_Sub5_Sub15.anInt2780 = 1;
                    Class52.aBoolean1221 = true;
                    Class19.aBoolean490 = false;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -187) {
                    Player.anInt3288 = Cache.outgoingbuffer.method468(false);
                    if(Player.anInt3288 == 1)
                        Class66.anInt1545 = Cache.outgoingbuffer.method469(65280);
                    if(((Player.anInt3288 ^ 0xffffffff) <= -3) && (Player.anInt3288 ^ 0xffffffff) >= -7) {
                        if(Player.anInt3288 == 2) {
                            Class35.anInt1730 = 64;
                            Landscape.anInt1170 = 64;
                        }
                        if(Player.anInt3288 == 3) {
                            Class35.anInt1730 = 64;
                            Landscape.anInt1170 = 0;
                        }
                        if((Player.anInt3288 ^ 0xffffffff) == -5) {
                            Class35.anInt1730 = 64;
                            Landscape.anInt1170 = 128;
                        }
                        if(Player.anInt3288 == 5) {
                            Landscape.anInt1170 = 64;
                            Class35.anInt1730 = 0;
                        }
                        if((Player.anInt3288 ^ 0xffffffff) == -7) {
                            Landscape.anInt1170 = 64;
                            Class35.anInt1730 = 128;
                        }
                        Player.anInt3288 = 2;
                        Class68.anInt1637 = Cache.outgoingbuffer.method469(65280);
                        Class4.anInt175 = Cache.outgoingbuffer.method469(65280);
                        NpcDefinition.anInt2404 = Cache.outgoingbuffer.method468(false);
                    }
                    if((Player.anInt3288 ^ 0xffffffff) == -11)
                        Class68.anInt1623 = Cache.outgoingbuffer.method469(65280);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 210) {
                    int i_83_ = Cache.outgoingbuffer.method485((byte) -48);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_83_, (byte) -107);
                    class40_sub5_sub12.anInt2687 = 3;
                    class40_sub5_sub12.anInt2673 = Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.aClass30_3282.method374(-20874);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 110) {
                    int i_84_ = Cache.outgoingbuffer.method485((byte) -48);
                    RSString class1 = Cache.outgoingbuffer.getRSString(-10721);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_84_, (byte) -73);
                    class40_sub5_sub12.aClass1_2668 = class1;
                    if(Class40_Sub5_Sub11.anIntArray2626[Class5.anInt208] == i_84_ >> -1297036176)
                        ISAAC.aBoolean505 = true;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -71) {
                    Class12.anInt380 = Cache.outgoingbuffer.method468(false);
                    ISAAC.aBoolean505 = true;
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -121) {
                    int i_85_ = Cache.outgoingbuffer.method469(65280);
                    int i_86_ = Cache.outgoingbuffer.method490((byte) -70);
                    int i_87_ = Cache.outgoingbuffer.method485((byte) -48);
                    if((i_86_ ^ 0xffffffff) == -65536)
                        i_86_ = -1;
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_87_, (byte) -102);
                    if(!class40_sub5_sub12.aBoolean2636) {
                        if(i_86_ == -1) {
                            Class57.packetid = -1;
                            class40_sub5_sub12.anInt2687 = 0;
                            return true;
                        }
                        ItemDefinition class40_sub5_sub16 = Class44.method897(i_86_, 10);
                        class40_sub5_sub12.anInt2690 = class40_sub5_sub16.anInt2844;
                        class40_sub5_sub12.anInt2673 = i_86_;
                        class40_sub5_sub12.anInt2687 = 4;
                        class40_sub5_sub12.anInt2728 = 100 * class40_sub5_sub16.anInt2817 / i_85_;
                        class40_sub5_sub12.anInt2657 = class40_sub5_sub16.anInt2830;
                    } else {
                        class40_sub5_sub12.anInt2734 = 1;
                        class40_sub5_sub12.anInt2718 = i_86_;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 51) {
                    long l = Cache.outgoingbuffer.method498(1362367312);
                    long l_88_ = (long) Cache.outgoingbuffer.method469(65280);
                    long l_89_ = (long) Cache.outgoingbuffer.getTri(true);
                    int i_90_ = Cache.outgoingbuffer.method468(false);
                    boolean bool = false;
                    long l_91_ = (l_88_ << 2124835616) + l_89_;
                    for(int i_92_ = 0; i_92_ < 100; i_92_++) {
                        if(l_91_ == Class40_Sub5_Sub13.aLongArray2757[i_92_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(i_90_ <= 1) {
                        for(int i_93_ = 0; ((i_93_ ^ 0xffffffff) > (Class42.anInt1008 ^ 0xffffffff)); i_93_++) {
                            if(l == Class53.aLongArray1267[i_93_]) {
                                bool = true;
                                break;
                            }
                        }
                    }
                    if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1) {
                        Class40_Sub5_Sub13.aLongArray2757[(Class40_Sub3.anInt2021)] = l_91_;
                        Class40_Sub3.anInt2021 = (1 + Class40_Sub3.anInt2021) % 100;
                        RSString class1 = Class54.method956(67, Cache.outgoingbuffer).method53(-16315);
                        if((i_90_ ^ 0xffffffff) == -3 || (i_90_ ^ 0xffffffff) == -4)
                            Class44.method895(99, 7, class1, (Class40_Sub5_Sub17_Sub6.method832(88, (new RSString[]{(Class40_Sub5_Sub12.aClass1_2729), Class60.method991(-73, l).method85(-4305)}))));
                        else if(i_90_ == 1)
                            Class44.method895(97, 7, class1, (Class40_Sub5_Sub17_Sub6.method832(126, (new RSString[]{Class51.aClass1_1210, Class60.method991(-46, l).method85(-4305)}))));
                        else
                            Class44.method895(72, 3, class1, Class60.method991(-55, l).method85(-4305));
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -28) {
                    for(int i_94_ = 0; (i_94_ < (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156).length); i_94_++) {
                        if((Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_94_]) != null)
                            Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_94_].anInt3141 = -1;
                    }
                    for(int i_95_ = 0; (((Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813).length ^ 0xffffffff) < (i_95_ ^ 0xffffffff)); i_95_++) {
                        if((Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_95_]) != null)
                            Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_95_].anInt3141 = -1;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -141) {
                    int i_96_ = Cache.outgoingbuffer.method469(65280);
                    int i_97_ = Cache.outgoingbuffer.method468(false);
                    if(i_96_ == 65535)
                        i_96_ = -1;
                    if(i_96_ != Class40_Sub5_Sub11.anIntArray2626[i_97_]) {
                        Class55.method958((Class40_Sub5_Sub11.anIntArray2626[i_97_]), -14222);
                        Class40_Sub5_Sub11.anIntArray2626[i_97_] = i_96_;
                    }
                    Class40_Sub5_Sub10.aBoolean2597 = true;
                    Class57.packetid = -1;
                    ISAAC.aBoolean505 = true;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -35) {
                    ISAAC.aBoolean505 = true;
                    int i_98_ = Cache.outgoingbuffer.method476(255);
                    int i_99_ = Cache.outgoingbuffer.method468(false);
                    int i_100_ = Cache.outgoingbuffer.method470(-115);
                    Class40_Sub5_Sub17_Sub3.anIntArray3051[i_99_] = i_100_;
                    Class13.anIntArray403[i_99_] = i_98_;
                    Class10.anIntArray354[i_99_] = 1;
                    for(int i_101_ = 0; i_101_ < 98; i_101_++) {
                        if((Class38_Sub1.anIntArray1909[i_101_] ^ 0xffffffff) >= (i_100_ ^ 0xffffffff))
                            Class10.anIntArray354[i_99_] = i_101_ + 2;
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -4) {
                    int i_102_ = Cache.outgoingbuffer.method491(-4750);
                    int i_103_ = Cache.outgoingbuffer.method484((byte) 94);
                    int i_104_ = Cache.outgoingbuffer.method484((byte) 123);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_102_, (byte) -86);
                    class40_sub5_sub12.anInt2656 = class40_sub5_sub12.anInt2649 + i_104_;
                    Class57.packetid = -1;
                    class40_sub5_sub12.anInt2696 = class40_sub5_sub12.anInt2743 + i_103_;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -73) {
                    for(int i_105_ = 0; ((i_105_ ^ 0xffffffff) > (Class58.varbitmasks.length ^ 0xffffffff)); i_105_++) {
                        if(Buffer.anIntArray1984[i_105_] != Class58.varbitmasks[i_105_]) {
                            Class58.varbitmasks[i_105_] = Buffer.anIntArray1984[i_105_];
                            Class22.method309(-1, i_105_);
                            ISAAC.aBoolean505 = true;
                        }
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -241) {
                    NpcDefinition.method580(ISAAC.aClass31_521, (byte) -98, Cache.outgoingbuffer, Class40_Sub5_Sub12.packetsize);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 58) {
                    int i_106_ = Cache.outgoingbuffer.method507(-64);
                    Class12.aClass15_394 = ISAAC.aClass31_521.method393(11545, i_106_);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -215) {
                    ISAAC.aBoolean505 = true;
                    int i_107_ = Cache.outgoingbuffer.method491(-4750);
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_107_, (byte) -112);
                    while(Class40_Sub5_Sub12.packetsize > Cache.outgoingbuffer.currentPosition) {
                        int i_108_ = Cache.outgoingbuffer.method502((byte) -102);
                        int i_109_ = Cache.outgoingbuffer.method469(65280);
                        int i_110_ = 0;
                        if((i_109_ ^ 0xffffffff) != -1) {
                            i_110_ = Cache.outgoingbuffer.method468(false);
                            if((i_110_ ^ 0xffffffff) == -256)
                                i_110_ = Cache.outgoingbuffer.method491(-4750);
                        }
                        if(!class40_sub5_sub12.aBoolean2636) {
                            if((i_108_ ^ 0xffffffff) <= -1 && (class40_sub5_sub12.anIntArray2685.length > i_108_)) {
                                class40_sub5_sub12.anIntArray2685[i_108_] = i_109_;
                                class40_sub5_sub12.anIntArray2710[i_108_] = i_110_;
                            }
                        } else {
                            Class40_Sub5_Sub12[] class40_sub5_sub12s = (Class59.aClass40_Sub5_Sub12ArrayArray1390[i_107_ >> 886089392]);
                            for(int i_111_ = 0; ((i_111_ ^ 0xffffffff) > (class40_sub5_sub12s.length ^ 0xffffffff)); i_111_++) {
                                Class40_Sub5_Sub12 class40_sub5_sub12_112_ = class40_sub5_sub12s[i_111_];
                                if((((class40_sub5_sub12_112_.anInt2648 & 0xffff) ^ 0xffffffff) == (class40_sub5_sub12.anInt2689 & 0xffff ^ 0xffffffff)) && 1 + i_108_ == (class40_sub5_sub12_112_.anInt2736)) {
                                    class40_sub5_sub12_112_.anInt2734 = i_110_;
                                    class40_sub5_sub12_112_.anInt2718 = i_109_ + -1;
                                }
                            }
                        }
                    }
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 166) {
                    FloorDecoration.method343(false, 5688);
                    Class57.packetid = -1;
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -232) {
                    int i_113_ = Cache.outgoingbuffer.method461((byte) 108);
                    int i_114_ = Cache.outgoingbuffer.method485((byte) -48);
                    int i_115_ = i_113_ >> -1304618998 & 0x1f;
                    int i_116_ = 0x1f & i_113_ >> -1608786267;
                    Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_114_, (byte) -103);
                    Class57.packetid = -1;
                    int i_117_ = i_113_ & 0x1f;
                    class40_sub5_sub12.anInt2647 = ((i_116_ << -1232932181) + (i_115_ << -1927757997) + (i_117_ << 770125059));
                    return true;
                }
                if((Class57.packetid ^ 0xffffffff) == -212) {
                    Class42.anInt1008 = Class40_Sub5_Sub12.packetsize / 8;
                    for(int i_118_ = 0; ((Class42.anInt1008 ^ 0xffffffff) < (i_118_ ^ 0xffffffff)); i_118_++)
                        Class53.aLongArray1267[i_118_] = Cache.outgoingbuffer.method498(1362367312);
                    Class57.packetid = -1;
                    return true;
                }
                if(Class57.packetid == 124) {
                    if(Class43.anInt1028 != -1) {
                        Class55.method958(Class43.anInt1028, -14222);
                        Class43.anInt1028 = -1;
                    }
                    Class52.aBoolean1221 = true;
                    Class66.aClass1_1543 = Class66.aClass1_1567;
                    Class40_Sub5_Sub15.anInt2780 = 2;
                    Class57.packetid = -1;
                    Class19.aBoolean490 = false;
                    return true;
                }
                Class6.method169(("T1 - " + Class57.packetid + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + Class40_Sub5_Sub12.packetsize), (byte) -121, null);
                Class48.method928(-7225);
            } catch(java.io.IOException ioexception) {
                Class59.method982(2578);
            } catch(Exception exception) {
                String string = ("T2 - " + Class57.packetid + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + Class40_Sub5_Sub12.packetsize + "," + (Class40_Sub5_Sub2.anInt2307 + (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anIntArray3088[0])) + "," + ((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anIntArray3135[0]) + Class26.anInt635) + " - ");
                for(int i = 0; (((Class40_Sub5_Sub12.packetsize ^ 0xffffffff) < (i ^ 0xffffffff)) && (i ^ 0xffffffff) > -51); i++)
                    string += (Cache.outgoingbuffer.buffer[i] + ",");
                Class6.method169(string, (byte) -120, exception);
                Class48.method928(-7225);
            }
            return true;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ad.I(" + arg0 + ')');
        }
    }

    public static void method152(int arg0) {
        try {
            aByteArray169 = null;
            anObject162 = null;
            aClass1_167 = null;
            if(arg0 == -19156) {
                aClass1_170 = null;
                aClass1_164 = null;
                aClass1_171 = null;
                aClass8_166 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ad.B(" + arg0 + ')');
        }
    }

    public static int method157(int arg0, int arg1, int arg2) {
        try {
            anInt137++;
            int i = (Class42.method884(-1 + arg1, -1 + arg2, 37821) + Class42.method884(1 + arg1, arg2 - 1, 37821) + Class42.method884(-1 + arg1, 1 + arg2, 37821) + Class42.method884(1 + arg1, arg2 + 1, 37821));
            if(arg0 != 0)
                return 56;
            int i_126_ = (Class42.method884(arg1 - 1, arg2, 37821) + Class42.method884(arg1 + 1, arg2, 37821) - (-Class42.method884(arg1, arg2 - 1, 37821) + -Class42.method884(arg1, 1 + arg2, 37821)));
            int i_127_ = Class42.method884(arg1, arg2, 37821);
            return i / 16 - (-(i_126_ / 8) - i_127_ / 4);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.A(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public void method143(boolean arg0, int arg1, int arg2, int arg3) {
        try {
            anInt160++;
            if(arg0 != true)
                anIntArrayArray150 = null;
            anIntArrayArray150[arg1][arg2] = Class40_Sub5_Sub9.method619(anIntArrayArray150[arg1][arg2], arg3);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.L(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public void method145(int arg0, int arg1, int arg2) {
        try {
            arg0 -= anInt151;
            if(arg1 == 28227) {
                arg2 -= anInt140;
                anIntArrayArray150[arg2][arg0] = Class66.method1021(anIntArrayArray150[arg2][arg0], 14680063);
                anInt144++;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.E(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public void method146(int arg0) {
        try {
            anInt143++;
            if(arg0 == 16777216) {
                for(int i = 0; anInt153 > i; i++) {
                    for(int i_0_ = 0; (anInt145 ^ 0xffffffff) < (i_0_ ^ 0xffffffff); i_0_++) {
                        if((i ^ 0xffffffff) != -1 && i_0_ != 0 && (anInt153 - 1 ^ 0xffffffff) != (i ^ 0xffffffff) && (-1 + anInt145 ^ 0xffffffff) != (i_0_ ^ 0xffffffff))
                            anIntArrayArray150[i][i_0_] = 16777216;
                        else
                            anIntArrayArray150[i][i_0_] = 16777215;
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ad.C(" + arg0 + ')');
        }
    }

    public void method148(int arg0, int arg1, int arg2, boolean arg3, int arg4, int arg5) {
        anInt155++;
        arg4 -= anInt151;
        if(arg0 != -4)
            anInt165 = 110;
        arg1 -= anInt140;
        if((arg5 ^ 0xffffffff) == -1) {
            if((arg2 ^ 0xffffffff) == -1) {
                method156(arg4, 128, arg1, (byte) 124);
                method156(arg4, 8, -1 + arg1, (byte) 124);
            }
            if(arg2 == 1) {
                method156(arg4, 2, arg1, (byte) 124);
                method156(arg4 + 1, 32, arg1, (byte) 124);
            }
            if((arg2 ^ 0xffffffff) == -3) {
                method156(arg4, 8, arg1, (byte) 124);
                method156(arg4, 128, 1 + arg1, (byte) 124);
            }
            if((arg2 ^ 0xffffffff) == -4) {
                method156(arg4, 32, arg1, (byte) 124);
                method156(-1 + arg4, 2, arg1, (byte) 124);
            }
        }
        if(arg5 == 1 || (arg5 ^ 0xffffffff) == -4) {
            if(arg2 == 0) {
                method156(arg4, 1, arg1, (byte) 124);
                method156(arg4 + 1, 16, -1 + arg1, (byte) 124);
            }
            if((arg2 ^ 0xffffffff) == -2) {
                method156(arg4, 4, arg1, (byte) 124);
                method156(1 + arg4, 64, 1 + arg1, (byte) 124);
            }
            if((arg2 ^ 0xffffffff) == -3) {
                method156(arg4, 16, arg1, (byte) 124);
                method156(-1 + arg4, 1, arg1 + 1, (byte) 124);
            }
            if((arg2 ^ 0xffffffff) == -4) {
                method156(arg4, 64, arg1, (byte) 124);
                method156(arg4 - 1, 4, -1 + arg1, (byte) 124);
            }
        }
        if(arg5 == 2) {
            if((arg2 ^ 0xffffffff) == -1) {
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
            if((arg2 ^ 0xffffffff) == -4) {
                method156(arg4, 160, arg1, (byte) 124);
                method156(-1 + arg4, 2, arg1, (byte) 124);
                method156(arg4, 8, arg1 + -1, (byte) 124);
            }
        }
        if(arg3) {
            if((arg5 ^ 0xffffffff) == -1) {
                if(arg2 == 0) {
                    method156(arg4, 65536, arg1, (byte) 124);
                    method156(arg4, 4096, arg1 + -1, (byte) 124);
                }
                if(arg2 == 1) {
                    method156(arg4, 1024, arg1, (byte) 124);
                    method156(1 + arg4, 16384, arg1, (byte) 124);
                }
                if((arg2 ^ 0xffffffff) == -3) {
                    method156(arg4, 4096, arg1, (byte) 124);
                    method156(arg4, 65536, 1 + arg1, (byte) 124);
                }
                if(arg2 == 3) {
                    method156(arg4, 16384, arg1, (byte) 124);
                    method156(-1 + arg4, 1024, arg1, (byte) 124);
                }
            }
            if((arg5 ^ 0xffffffff) == -2 || arg5 == 3) {
                if((arg2 ^ 0xffffffff) == -1) {
                    method156(arg4, 512, arg1, (byte) 124);
                    method156(arg4 + 1, 8192, arg1 + -1, (byte) 124);
                }
                if((arg2 ^ 0xffffffff) == -2) {
                    method156(arg4, 2048, arg1, (byte) 124);
                    method156(1 + arg4, 32768, 1 + arg1, (byte) 124);
                }
                if((arg2 ^ 0xffffffff) == -3) {
                    method156(arg4, 8192, arg1, (byte) 124);
                    method156(arg4 - 1, 512, 1 + arg1, (byte) 124);
                }
                if((arg2 ^ 0xffffffff) == -4) {
                    method156(arg4, 32768, arg1, (byte) 124);
                    method156(arg4 - 1, 2048, arg1 + -1, (byte) 124);
                }
            }
            if((arg5 ^ 0xffffffff) == -3) {
                if(arg2 == 0) {
                    method156(arg4, 66560, arg1, (byte) 124);
                    method156(arg4, 4096, arg1 + -1, (byte) 124);
                    method156(arg4 + 1, 16384, arg1, (byte) 124);
                }
                if((arg2 ^ 0xffffffff) == -2) {
                    method156(arg4, 5120, arg1, (byte) 124);
                    method156(arg4 + 1, 16384, arg1, (byte) 124);
                    method156(arg4, 65536, 1 + arg1, (byte) 124);
                }
                if(arg2 == 2) {
                    method156(arg4, 20480, arg1, (byte) 124);
                    method156(arg4, 65536, 1 + arg1, (byte) 124);
                    method156(arg4 - 1, 1024, arg1, (byte) 124);
                }
                if((arg2 ^ 0xffffffff) == -4) {
                    method156(arg4, 81920, arg1, (byte) 124);
                    method156(-1 + arg4, 1024, arg1, (byte) 124);
                    method156(arg4, 4096, -1 + arg1, (byte) 124);
                }
            }
        }
    }

    public void method149(boolean arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6) {
        arg1 -= anInt151;
        anInt157++;
        if((arg3 ^ 0xffffffff) == -2 || arg3 == 3) {
            int i = arg4;
            arg4 = arg6;
            arg6 = i;
        }
        int i = 256;
        if(arg0)
            i += 131072;
        arg2 -= anInt140;
        for(int i_119_ = arg2; (arg4 + arg2 ^ 0xffffffff) < (i_119_ ^ 0xffffffff); i_119_++) {
            if(i_119_ >= 0 && (i_119_ ^ 0xffffffff) > (anInt153 ^ 0xffffffff)) {
                for(int i_120_ = arg1; (arg6 + arg1 ^ 0xffffffff) < (i_120_ ^ 0xffffffff); i_120_++) {
                    if((i_120_ ^ 0xffffffff) <= -1 && anInt145 > i_120_)
                        method156(i_120_, i, i_119_, (byte) 124);
                }
            }
        }
        if(arg5 != -55)
            anInt168 = 102;
    }

    public void method150(int arg0, int arg1, int arg2, int arg3, boolean arg4, byte arg5) {
        arg0 -= anInt151;
        anInt161++;
        arg3 -= anInt140;
        if(arg5 != 95)
            anInt163 = 47;
        if(arg1 == 0) {
            if((arg2 ^ 0xffffffff) == -1) {
                method143(true, arg3, arg0, 128);
                method143(true, arg3 - 1, arg0, 8);
            }
            if((arg2 ^ 0xffffffff) == -2) {
                method143(true, arg3, arg0, 2);
                method143(true, arg3, 1 + arg0, 32);
            }
            if(arg2 == 2) {
                method143(true, arg3, arg0, 8);
                method143(true, 1 + arg3, arg0, 128);
            }
            if((arg2 ^ 0xffffffff) == -4) {
                method143(true, arg3, arg0, 32);
                method143(true, arg3, arg0 + -1, 2);
            }
        }
        if((arg1 ^ 0xffffffff) == -2 || arg1 == 3) {
            if(arg2 == 0) {
                method143(true, arg3, arg0, 1);
                method143(true, -1 + arg3, arg0 + 1, 16);
            }
            if(arg2 == 1) {
                method143(true, arg3, arg0, 4);
                method143(true, 1 + arg3, 1 + arg0, 64);
            }
            if((arg2 ^ 0xffffffff) == -3) {
                method143(true, arg3, arg0, 16);
                method143(true, 1 + arg3, -1 + arg0, 1);
            }
            if((arg2 ^ 0xffffffff) == -4) {
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
                if((arg2 ^ 0xffffffff) == -3) {
                    method143(true, arg3, arg0, 4096);
                    method143(true, 1 + arg3, arg0, 65536);
                }
                if((arg2 ^ 0xffffffff) == -4) {
                    method143(true, arg3, arg0, 16384);
                    method143(true, arg3, -1 + arg0, 1024);
                }
            }
            if(arg1 == 1 || arg1 == 3) {
                if(arg2 == 0) {
                    method143(true, arg3, arg0, 512);
                    method143(true, -1 + arg3, 1 + arg0, 8192);
                }
                if((arg2 ^ 0xffffffff) == -2) {
                    method143(true, arg3, arg0, 2048);
                    method143(true, arg3 + 1, arg0 + 1, 32768);
                }
                if((arg2 ^ 0xffffffff) == -3) {
                    method143(true, arg3, arg0, 8192);
                    method143(true, 1 + arg3, arg0 - 1, 512);
                }
                if((arg2 ^ 0xffffffff) == -4) {
                    method143(true, arg3, arg0, 32768);
                    method143(true, arg3 - 1, -1 + arg0, 2048);
                }
            }
            if((arg1 ^ 0xffffffff) == -3) {
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
                if((arg2 ^ 0xffffffff) == -4) {
                    method143(true, arg3, arg0, 81920);
                    method143(true, arg3, arg0 + -1, 1024);
                    method143(true, arg3 - 1, arg0, 4096);
                }
            }
        }
    }

    public void markBlocked(byte arg0, int arg1, int arg2) {
        try {
            arg1 -= anInt151;
            anInt147++;
            arg2 -= anInt140;
            if(arg0 != -28)
                anInt153 = -24;
            anIntArrayArray150[arg2][arg1] = Class40_Sub5_Sub9.method619(anIntArrayArray150[arg2][arg1], 2097152);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.N(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public boolean method153(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        try {
            anInt154++;
            if(arg0 > -3)
                method153(67, -89, 45, -123, -39, -109, -38, -78);
            int i = arg2 + arg3 + -1;
            int i_121_ = -1 + arg4 + arg1;
            if((arg7 ^ 0xffffffff) <= (arg2 ^ 0xffffffff) && (arg7 ^ 0xffffffff) >= (i ^ 0xffffffff) && (arg6 ^ 0xffffffff) <= (arg4 ^ 0xffffffff) && i_121_ >= arg6)
                return true;
            if((arg7 ^ 0xffffffff) == (arg2 + -1 ^ 0xffffffff) && (arg6 ^ 0xffffffff) <= (arg4 ^ 0xffffffff) && (i_121_ ^ 0xffffffff) <= (arg6 ^ 0xffffffff) && (anIntArrayArray150[-anInt140 + arg7][-anInt151 + arg6] & 0x8) == 0 && (arg5 & 0x8 ^ 0xffffffff) == -1)
                return true;
            if((i + 1 ^ 0xffffffff) == (arg7 ^ 0xffffffff) && (arg6 ^ 0xffffffff) <= (arg4 ^ 0xffffffff) && arg6 <= i_121_ && (anIntArrayArray150[arg7 - anInt140][arg6 + -anInt151] & 0x80) == 0 && (0x2 & arg5 ^ 0xffffffff) == -1)
                return true;
            if((arg6 ^ 0xffffffff) == (arg4 - 1 ^ 0xffffffff) && (arg7 ^ 0xffffffff) <= (arg2 ^ 0xffffffff) && (arg7 ^ 0xffffffff) >= (i ^ 0xffffffff) && (anIntArrayArray150[arg7 - anInt140][arg6 - anInt151] & 0x2 ^ 0xffffffff) == -1 && (arg5 & 0x4) == 0)
                return true;
            return (1 + i_121_ ^ 0xffffffff) == (arg6 ^ 0xffffffff) && (arg2 ^ 0xffffffff) >= (arg7 ^ 0xffffffff) && (i ^ 0xffffffff) <= (arg7 ^ 0xffffffff) && (anIntArrayArray150[-anInt140 + arg7][arg6 - anInt151] & 0x20) == 0 && (0x1 & arg5 ^ 0xffffffff) == -1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.K(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ',' + arg7 + ')'));
        }
    }

    public void method154(int arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        try {
            arg5 -= anInt151;
            anInt148++;
            int i = 62 % ((arg2 - 5) / 40);
            if((arg4 ^ 0xffffffff) == -2 || arg4 == 3) {
                int i_122_ = arg6;
                arg6 = arg3;
                arg3 = i_122_;
            }
            arg0 -= anInt140;
            int i_123_ = 256;
            if(arg1)
                i_123_ += 131072;
            for(int i_124_ = arg0; i_124_ < arg0 + arg6; i_124_++) {
                if((i_124_ ^ 0xffffffff) <= -1 && i_124_ < anInt153) {
                    for(int i_125_ = arg5; (i_125_ ^ 0xffffffff) > (arg3 + arg5 ^ 0xffffffff); i_125_++) {
                        if((i_125_ ^ 0xffffffff) <= -1 && i_125_ < anInt145)
                            method143(true, i_124_, i_125_, i_123_);
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.O(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ')'));
        }
    }

    public boolean method155(int arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        try {
            anInt146++;
            if(arg6 == arg0 && (arg4 ^ 0xffffffff) == (arg3 ^ 0xffffffff))
                return true;
            if(arg1 != false)
                parsePackets(true);
            arg4 -= anInt151;
            arg6 -= anInt140;
            arg0 -= anInt140;
            arg3 -= anInt151;
            if((arg2 ^ 0xffffffff) == -1) {
                if((arg5 ^ 0xffffffff) != -1) {
                    if(arg5 == 1) {
                        if(arg6 == arg0 && 1 + arg3 == arg4)
                            return true;
                        if((-1 + arg6 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && arg4 == arg3 && ((anIntArrayArray150[arg0][arg4] & 0x1280108) == 0))
                            return true;
                        if((arg0 ^ 0xffffffff) == (1 + arg6 ^ 0xffffffff) && arg4 == arg3 && (anIntArrayArray150[arg0][arg4] & 0x1280180 ^ 0xffffffff) == -1)
                            return true;
                    } else if((arg5 ^ 0xffffffff) == -3) {
                        if(arg0 == arg6 + 1 && (arg4 ^ 0xffffffff) == (arg3 ^ 0xffffffff))
                            return true;
                        if(arg0 == arg6 && arg4 == arg3 + 1 && ((anIntArrayArray150[arg0][arg4] & 0x1280120) == 0))
                            return true;
                        if(arg6 == arg0 && (arg3 + -1 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && ((anIntArrayArray150[arg0][arg4] & 0x1280102) == 0))
                            return true;
                    } else if(arg5 == 3) {
                        if(arg6 == arg0 && arg3 - 1 == arg4)
                            return true;
                        if(-1 + arg6 == arg0 && arg3 == arg4 && ((anIntArrayArray150[arg0][arg4] & 0x1280108) == 0))
                            return true;
                        if(arg0 == 1 + arg6 && arg4 == arg3 && (0x1280180 & anIntArrayArray150[arg0][arg4] ^ 0xffffffff) == -1)
                            return true;
                    }
                } else {
                    if(arg6 + -1 == arg0 && (arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff))
                        return true;
                    if((arg0 ^ 0xffffffff) == (arg6 ^ 0xffffffff) && (arg3 + 1 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (anIntArrayArray150[arg0][arg4] & 0x1280120 ^ 0xffffffff) == -1)
                        return true;
                    if(arg6 == arg0 && (arg4 ^ 0xffffffff) == (-1 + arg3 ^ 0xffffffff) && (0x1280102 & anIntArrayArray150[arg0][arg4]) == 0)
                        return true;
                }
            }
            if((arg2 ^ 0xffffffff) == -3) {
                if(arg5 != 0) {
                    if((arg5 ^ 0xffffffff) != -2) {
                        if(arg5 != 2) {
                            if((arg5 ^ 0xffffffff) == -4) {
                                if(arg0 == -1 + arg6 && (arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff))
                                    return true;
                                if(arg0 == arg6 && ((arg3 + 1 ^ 0xffffffff) == (arg4 ^ 0xffffffff)) && (0x1280120 & anIntArrayArray150[arg0][arg4]) == 0)
                                    return true;
                                if((arg6 + 1 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && arg3 == arg4 && (0x1280180 & anIntArrayArray150[arg0][arg4]) == 0)
                                    return true;
                                if((arg0 ^ 0xffffffff) == (arg6 ^ 0xffffffff) && arg3 + -1 == arg4)
                                    return true;
                            }
                        } else {
                            if((arg0 ^ 0xffffffff) == (arg6 + -1 ^ 0xffffffff) && (arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (anIntArrayArray150[arg0][arg4] & 0x1280108) == 0)
                                return true;
                            if(arg6 == arg0 && arg3 + 1 == arg4 && (0x1280120 & anIntArrayArray150[arg0][arg4]) == 0)
                                return true;
                            if(1 + arg6 == arg0 && (arg4 ^ 0xffffffff) == (arg3 ^ 0xffffffff))
                                return true;
                            if(arg0 == arg6 && (arg4 ^ 0xffffffff) == (arg3 + -1 ^ 0xffffffff))
                                return true;
                        }
                    } else {
                        if(arg0 == -1 + arg6 && (arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && ((anIntArrayArray150[arg0][arg4] & 0x1280108) == 0))
                            return true;
                        if((arg6 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && (arg3 + 1 ^ 0xffffffff) == (arg4 ^ 0xffffffff))
                            return true;
                        if(arg0 == arg6 + 1 && (arg4 ^ 0xffffffff) == (arg3 ^ 0xffffffff))
                            return true;
                        if(arg0 == arg6 && arg4 == arg3 + -1 && (anIntArrayArray150[arg0][arg4] & 0x1280102 ^ 0xffffffff) == -1)
                            return true;
                    }
                } else {
                    if(arg0 == -1 + arg6 && (arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff))
                        return true;
                    if((arg6 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && arg4 == arg3 + 1)
                        return true;
                    if(arg0 == arg6 + 1 && arg3 == arg4 && (anIntArrayArray150[arg0][arg4] & 0x1280180 ^ 0xffffffff) == -1)
                        return true;
                    if(arg6 == arg0 && (arg3 - 1 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (0x1280102 & anIntArrayArray150[arg0][arg4]) == 0)
                        return true;
                }
            }
            if((arg2 ^ 0xffffffff) == -10) {
                if(arg6 == arg0 && arg4 == 1 + arg3 && ((0x20 & anIntArrayArray150[arg0][arg4] ^ 0xffffffff) == -1))
                    return true;
                if((arg6 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && (-1 + arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (0x2 & anIntArrayArray150[arg0][arg4]) == 0)
                    return true;
                if(arg0 == -1 + arg6 && arg4 == arg3 && ((0x8 & anIntArrayArray150[arg0][arg4] ^ 0xffffffff) == -1))
                    return true;
                return 1 + arg6 == arg0 && arg3 == arg4 && ((anIntArrayArray150[arg0][arg4] & 0x80 ^ 0xffffffff) == -1);
            }
            return false;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.D(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ')'));
        }
    }

    public void method156(int arg0, int arg1, int arg2, byte arg3) {
        try {
            if(arg3 == 124) {
                anIntArrayArray150[arg2][arg0] = Class66.method1021(anIntArrayArray150[arg2][arg0], -arg1 + 16777215);
                anInt138++;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.M(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public boolean method158(int arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6) {
        try {
            anInt142++;
            if(arg3 == arg4 && arg2 == arg0)
                return true;
            arg2 -= anInt151;
            arg3 -= anInt140;
            int i = -23 / ((37 - arg5) / 56);
            arg4 -= anInt140;
            arg0 -= anInt151;
            if((arg6 ^ 0xffffffff) == -7 || (arg6 ^ 0xffffffff) == -8) {
                if(arg6 == 7)
                    arg1 = arg1 + 2 & 0x3;
                if((arg1 ^ 0xffffffff) == -1) {
                    if((arg4 ^ 0xffffffff) == (1 + arg3 ^ 0xffffffff) && (arg0 ^ 0xffffffff) == (arg2 ^ 0xffffffff) && (anIntArrayArray150[arg4][arg2] & 0x80) == 0)
                        return true;
                    if((arg4 ^ 0xffffffff) == (arg3 ^ 0xffffffff) && (arg2 ^ 0xffffffff) == (-1 + arg0 ^ 0xffffffff) && (0x2 & anIntArrayArray150[arg4][arg2]) == 0)
                        return true;
                } else if((arg1 ^ 0xffffffff) != -2) {
                    if((arg1 ^ 0xffffffff) == -3) {
                        if((arg3 + -1 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (arg2 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && (anIntArrayArray150[arg4][arg2] & 0x8 ^ 0xffffffff) == -1)
                            return true;
                        if(arg4 == arg3 && arg2 == 1 + arg0 && (0x20 & anIntArrayArray150[arg4][arg2]) == 0)
                            return true;
                    } else if((arg1 ^ 0xffffffff) == -4) {
                        if(arg3 + 1 == arg4 && arg0 == arg2 && (anIntArrayArray150[arg4][arg2] & 0x80) == 0)
                            return true;
                        if((arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (arg0 + 1 ^ 0xffffffff) == (arg2 ^ 0xffffffff) && (0x20 & anIntArrayArray150[arg4][arg2] ^ 0xffffffff) == -1)
                            return true;
                    }
                } else {
                    if(arg4 == arg3 + -1 && (arg2 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && ((anIntArrayArray150[arg4][arg2] & 0x8 ^ 0xffffffff) == -1))
                        return true;
                    if((arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (arg0 + -1 ^ 0xffffffff) == (arg2 ^ 0xffffffff) && (anIntArrayArray150[arg4][arg2] & 0x2) == 0)
                        return true;
                }
            }
            if((arg6 ^ 0xffffffff) == -9) {
                if((arg3 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (arg0 + 1 ^ 0xffffffff) == (arg2 ^ 0xffffffff) && (anIntArrayArray150[arg4][arg2] & 0x20) == 0)
                    return true;
                if((arg4 ^ 0xffffffff) == (arg3 ^ 0xffffffff) && (arg0 + -1 ^ 0xffffffff) == (arg2 ^ 0xffffffff) && (anIntArrayArray150[arg4][arg2] & 0x2) == 0)
                    return true;
                if((arg3 - 1 ^ 0xffffffff) == (arg4 ^ 0xffffffff) && (arg2 ^ 0xffffffff) == (arg0 ^ 0xffffffff) && (anIntArrayArray150[arg4][arg2] & 0x8) == 0)
                    return true;
                return (arg4 ^ 0xffffffff) == (1 + arg3 ^ 0xffffffff) && (arg0 ^ 0xffffffff) == (arg2 ^ 0xffffffff) && ((0x80 & anIntArrayArray150[arg4][arg2] ^ 0xffffffff) == -1);
            }
            return false;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ad.H(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ')'));
        }
    }
}
