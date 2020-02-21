/* Class40_Sub5_Sub17_Sub4_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class NPC extends Class40_Sub5_Sub17_Sub4 {
    public static int anInt3294;
    public static RSString aClass1_3295;
    public static int anInt3296;
    public static RSString aClass1_3297;
    public static boolean aBoolean3298;
    public static int anInt3299;
    public static Class2 aClass2_3301;
    public static RSString aClass1_3302
            = Class58.method978(-11538, "Sichtbare Karte vorbereitet)3");
    public static int anInt3303;
    public static int[] anIntArray3304;
    public static RSString aClass1_3305;
    public static int anInt3306;
    public static RSString aClass1_3307;
    public static RSString aClass1_3308;
    public static RSString aClass1_3309;
    public static int anInt3310;
    public static RSString aClass1_3311;
    public static int[] anIntArray3312;
    public static int anInt3313;
    public static RSString aClass1_3314;

    static {
        aClass1_3295 = null;
        anInt3294 = 0;
        aClass1_3308 = Class58.method978(-11538, "gr-Un:");
        aClass1_3309 = Class58.method978(-11538, "Hierhin gehen");
        anIntArray3304 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 3};
        aClass1_3307 = Class58.method978(-11538, "Keine Antwort vom Server)3");
        aClass1_3297 = Class58.method978(-11538, "On");
        aClass1_3311 = aClass1_3297;
        aClass1_3314 = Class58.method978(-11538, "Connection lost");
        aClass1_3305 = aClass1_3314;
    }

    public NpcDefinition aClass40_Sub5_Sub5_3300;

    public static Class40_Sub5_Sub11 method795(byte arg0, int arg1) {
        try {
            anInt3303++;
            Class40_Sub5_Sub11 class40_sub5_sub11 = ((Class40_Sub5_Sub11) Class13.aClass9_406.method231((long) arg1, (byte) 98));
            if (arg0 >= -66)
                aClass1_3295 = null;
            if (class40_sub5_sub11 != null)
                return class40_sub5_sub11;
            byte[] is = Class64.aClass6_1521.method172(arg1, 120, 16);
            class40_sub5_sub11 = new Class40_Sub5_Sub11();
            if (is != null)
                class40_sub5_sub11.method634(new Buffer(is), 0);
            Class13.aClass9_406.method230(-7208, (long) arg1, class40_sub5_sub11);
            return class40_sub5_sub11;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "vd.AB(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method796(byte arg0) {
        anInt3306++;
        if ((Class40_Sub5_Sub15.anInt2782 ^ 0xffffffff) < -2)
            Class40_Sub5_Sub15.anInt2782--;
        if ((Class32.anInt771 ^ 0xffffffff) < -1)
            Class32.anInt771--;
        if (Class37.aBoolean871) {
            Class37.aBoolean871 = false;
            Class59.method982(2578);
        } else {
            for (int i = 0; (i ^ 0xffffffff) > -101; i++) {
                if (!Class3.parsePackets(false))
                    break;
            }
            if ((Class51.anInt1197 ^ 0xffffffff) == -31
                    || (Class51.anInt1197 ^ 0xffffffff) == -36) {
                if (ISAAC.aBoolean519
                        && (Class51.anInt1197 ^ 0xffffffff) == -31) {
                    Class40_Sub5_Sub2.anInt2302 = 0;
                    Class62.anInt1470 = 0;
                    while (Class34.method416((byte) -104)) {
                        /* empty */
                    }
                    for (int i = 0;
                         i < Class40_Sub5_Sub17_Sub3.aBooleanArray3056.length;
                         i++)
                        Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i] = false;
                }
                Class40_Sub5_Sub6.putHackCheckPacket(-12, 205,
                        Class32.packetBuffer);
                synchronized (Class12.aClass39_387.anObject905) {
                    if (!Class22.aBoolean544)
                        Class12.aClass39_387.anInt921 = 0;
                    else if ((Class62.anInt1470 ^ 0xffffffff) != -1
                            || Class12.aClass39_387.anInt921 >= 40) {
                        Class26.anInt616++;
                        int i = 0;
                        Class32.packetBuffer.putPacket(11453, 210);
                        Class32.packetBuffer.put(0,
                                (byte) -128);
                        int i_2_ = Class32.packetBuffer.offset;
                        for (int i_3_ = 0;
                             i_3_ < Class12.aClass39_387.anInt921; i_3_++) {
                            if ((-i_2_
                                    + Class32.packetBuffer.offset)
                                    >= 240)
                                break;
                            i++;
                            int i_4_
                                    = Class12.aClass39_387.anIntArray920[i_3_];
                            if (i_4_ >= 0) {
                                if ((i_4_ ^ 0xffffffff) < -503)
                                    i_4_ = 502;
                            } else
                                i_4_ = 0;
                            int i_5_
                                    = Class12.aClass39_387.anIntArray922[i_3_];
                            if (i_5_ < 0)
                                i_5_ = 0;
                            else if ((i_5_ ^ 0xffffffff) < -765)
                                i_5_ = 764;
                            int i_6_ = i_4_ * 765 + i_5_;
                            if ((Class12.aClass39_387.anIntArray920[i_3_]
                                    ^ 0xffffffff) == 0
                                    && (Class12.aClass39_387.anIntArray922[i_3_]
                                    ^ 0xffffffff) == 0) {
                                i_5_ = -1;
                                i_6_ = 524287;
                                i_4_ = -1;
                            }
                            if (((i_5_ ^ 0xffffffff)
                                    == (PacketBuffer.anInt2256 ^ 0xffffffff))
                                    && i_4_ == Class40_Sub5_Sub8.anInt2559) {
                                if (Class22_Sub2.anInt1888 < 2047)
                                    Class22_Sub2.anInt1888++;
                            } else {
                                int i_7_ = i_5_ - PacketBuffer.anInt2256;
                                PacketBuffer.anInt2256 = i_5_;
                                int i_8_ = i_4_ - Class40_Sub5_Sub8.anInt2559;
                                Class40_Sub5_Sub8.anInt2559 = i_4_;
                                if (Class22_Sub2.anInt1888 < 8 && i_7_ >= -32
                                        && (i_7_ ^ 0xffffffff) >= -32
                                        && (i_8_ ^ 0xffffffff) <= 31
                                        && i_8_ <= 31) {
                                    i_7_ += 32;
                                    i_8_ += 32;
                                    Class32.packetBuffer.method474
                                            ((i_8_ + (i_7_ << -1041963898)
                                                            + (Class22_Sub2.anInt1888
                                                            << 164403180)),
                                                    -126);
                                    Class22_Sub2.anInt1888 = 0;
                                } else if (Class22_Sub2.anInt1888 < 8) {
                                    Class32.packetBuffer.putTri
                                            ((i_6_ + 8388608
                                                            - -(Class22_Sub2.anInt1888
                                                            << 1170876883)),
                                                    13723);
                                    Class22_Sub2.anInt1888 = 0;
                                } else {
                                    Class32.packetBuffer.putInt
                                            (40,
                                                    ((Class22_Sub2.anInt1888 << 811733811)
                                                            + -1073741824 + i_6_));
                                    Class22_Sub2.anInt1888 = 0;
                                }
                            }
                        }
                        Class32.packetBuffer.finishVarByte
                                (Class32.packetBuffer.offset + -i_2_,
                                        (byte) 16);
                        if (i < Class12.aClass39_387.anInt921) {
                            Class12.aClass39_387.anInt921 -= i;
                            for (int i_9_ = 0;
                                 ((Class12.aClass39_387.anInt921 ^ 0xffffffff)
                                         < (i_9_ ^ 0xffffffff));
                                 i_9_++) {
                                Class12.aClass39_387.anIntArray922[i_9_]
                                        = (Class12.aClass39_387.anIntArray922
                                        [i + i_9_]);
                                Class12.aClass39_387.anIntArray920[i_9_]
                                        = (Class12.aClass39_387.anIntArray920
                                        [i_9_ + i]);
                            }
                        } else
                            Class12.aClass39_387.anInt921 = 0;
                    }
                }
                if (Class62.anInt1470 != 0) {
                    Class40_Sub5_Sub4.anInt2363++;
                    long l = ((Class40_Sub5_Sub8.aLong2561 - Class51.aLong1203)
                            / 50L);
                    int i = Class57.anInt1338;
                    int i_10_ = RSString.anInt1668;
                    Class51.aLong1203 = Class40_Sub5_Sub8.aLong2561;
                    if (i >= 0) {
                        if (i > 764)
                            i = 764;
                    } else
                        i = 0;
                    if ((i_10_ ^ 0xffffffff) <= -1) {
                        if ((i_10_ ^ 0xffffffff) < -503)
                            i_10_ = 502;
                    } else
                        i_10_ = 0;
                    int i_11_ = 0;
                    if ((Class62.anInt1470 ^ 0xffffffff) == -3)
                        i_11_ = 1;
                    if ((l ^ 0xffffffffffffffffL) < -4096L)
                        l = 4095L;
                    int i_12_ = (int) l;
                    Class32.packetBuffer.putPacket(11453, 234);
                    int i_13_ = i_10_ * 765 - -i;
                    Class32.packetBuffer.method494(((i_11_
                                    << -1245872941)
                                    + ((i_12_
                                    << 651937044)
                                    - -i_13_)),
                            93);
                }
                if (Class19.anInt487 > 0)
                    Class19.anInt487--;
                if (Class40_Sub5_Sub17_Sub3.aBooleanArray3056[96]
                        || Class40_Sub5_Sub17_Sub3.aBooleanArray3056[97]
                        || Class40_Sub5_Sub17_Sub3.aBooleanArray3056[98]
                        || Class40_Sub5_Sub17_Sub3.aBooleanArray3056[99])
                    HashTable.aBoolean565 = true;
                if (HashTable.aBoolean565 && Class19.anInt487 <= 0) {
                    Class13.anInt415++;
                    Class19.anInt487 = 20;
                    HashTable.aBoolean565 = false;
                    Class32.packetBuffer.putPacket(11453, 58);
                    Class32.packetBuffer.method474(Class58.anInt1373,
                            -126);
                    Class32.packetBuffer.method474(Class65.anInt1537,
                            -121);
                }
                if (HashTable.aBoolean571 != false
                        && !Class35.aBoolean1735 == true) {
                    Class60.anInt1406++;
                    Class35.aBoolean1735 = true;
                    Class32.packetBuffer.putPacket(11453, 160);
                    Class32.packetBuffer.put(1, (byte) -128);
                }
                if (!HashTable.aBoolean571 != false
                        && Class35.aBoolean1735 == true) {
                    Class35.aBoolean1735 = false;
                    Class60.anInt1406++;
                    Class32.packetBuffer.putPacket(11453, 160);
                    Class32.packetBuffer.put(0, (byte) -128);
                }
                Class45.method910(-32322);
                if (Class51.anInt1197 == 30
                        || (Class51.anInt1197 ^ 0xffffffff) == -36) {
                    Class40_Sub5_Sub13.method652((byte) 0);
                    Class4.method161(128);
                    Class35.anInt1728++;
                    if (Class35.anInt1728 > 750)
                        Class59.method982(2578);
                    else {
                        Class17.method276(-1);
                        Class8.method209(69);
                        Class22_Sub1.method313(54);
                        if ((Class45.anInt1075 ^ 0xffffffff) != -1) {
                            Floor.anInt2319 += 20;
                            if ((Floor.anInt2319 ^ 0xffffffff)
                                    <= -401)
                                Class45.anInt1075 = 0;
                        }
                        if (Class40_Sub5_Sub17_Sub1.anInt2999 != 0) {
                            RSRuntimeException.anInt1651++;
                            if ((RSRuntimeException.anInt1651 ^ 0xffffffff)
                                    <= -16) {
                                if (Class40_Sub5_Sub17_Sub1.anInt2999 == 2)
                                    ISAAC.aBoolean505 = true;
                                if (Class40_Sub5_Sub17_Sub1.anInt2999 == 3)
                                    Class52.aBoolean1221 = true;
                                Class40_Sub5_Sub17_Sub1.anInt2999 = 0;
                            }
                        }
                        Class5.anInt199++;
                        if ((Class40_Sub4.anInt2049 ^ 0xffffffff) != -1) {
                            Buffer.anInt1978++;
                            if (((Class13.anInt420 ^ 0xffffffff)
                                    < (Class40_Sub5_Sub17.anInt2869 - -5
                                    ^ 0xffffffff))
                                    || ((Class40_Sub5_Sub17.anInt2869 + -5
                                    ^ 0xffffffff)
                                    < (Class13.anInt420 ^ 0xffffffff))
                                    || ((ItemDefinition.anInt2798 - -5
                                    ^ 0xffffffff)
                                    > (Landscape.anInt1166 ^ 0xffffffff))
                                    || (ItemDefinition.anInt2798 - 5
                                    > Landscape.anInt1166))
                                Class40_Sub5_Sub15.aBoolean2784 = true;
                            if ((Class40_Sub5_Sub2.anInt2302 ^ 0xffffffff)
                                    == -1) {
                                if ((Class40_Sub4.anInt2049 ^ 0xffffffff)
                                        == -4)
                                    Class52.aBoolean1221 = true;
                                if ((Class40_Sub4.anInt2049 ^ 0xffffffff)
                                        == -3)
                                    ISAAC.aBoolean505 = true;
                                Class40_Sub4.anInt2049 = 0;
                                if (!Class40_Sub5_Sub15.aBoolean2784
                                        || Buffer.anInt1978 < 5) {
                                    if (((Class68.anInt1630 ^ 0xffffffff) == -2
                                            || (Class33.method409
                                            ((byte) 63,
                                                    (NpcDefinition.anInt2394
                                                            - 1))))
                                            && NpcDefinition.anInt2394 > 2)
                                        Class60.method990(11451);
                                    else if ((NpcDefinition.anInt2394
                                            ^ 0xffffffff)
                                            < -1)
                                        Class27.method358(123,
                                                (-1
                                                        + (NpcDefinition
                                                        .anInt2394)));
                                } else {
                                    RSRuntimeException.anInt1642 = -1;
                                    Class43.method894(false);
                                    if (((Class48.anInt1127 ^ 0xffffffff)
                                            == (RSRuntimeException.anInt1642
                                            ^ 0xffffffff))
                                            && (Class55.anInt1288
                                            != Class58.anInt1352)) {
                                        Class66.anInt1562++;
                                        Class40_Sub5_Sub12 class40_sub5_sub12
                                                = Class68.method1045((Class48
                                                        .anInt1127),
                                                (byte) -95);
                                        int i = 0;
                                        if (((Class43.anInt1025 ^ 0xffffffff)
                                                == -2)
                                                && (class40_sub5_sub12.anInt2639
                                                == 206))
                                            i = 1;
                                        if (((class40_sub5_sub12.anIntArray2685
                                                [Class55.anInt1288])
                                                ^ 0xffffffff)
                                                >= -1)
                                            i = 0;
                                        if (!class40_sub5_sub12.aBoolean2723) {
                                            if ((i ^ 0xffffffff) != -2)
                                                class40_sub5_sub12.method636
                                                        (Class55.anInt1288, false,
                                                                Class58.anInt1352);
                                            else {
                                                int i_14_ = Class58.anInt1352;
                                                int i_15_ = Class55.anInt1288;
                                                while (i_15_ != i_14_) {
                                                    if (i_14_ <= i_15_) {
                                                        if ((i_14_
                                                                ^ 0xffffffff)
                                                                > (i_15_
                                                                ^ 0xffffffff)) {
                                                            class40_sub5_sub12
                                                                    .method636
                                                                            (1 + i_14_,
                                                                                    false, i_14_);
                                                            i_14_++;
                                                        }
                                                    } else {
                                                        class40_sub5_sub12
                                                                .method636
                                                                        (-1 + i_14_, false,
                                                                                i_14_);
                                                        i_14_--;
                                                    }
                                                }
                                            }
                                        } else {
                                            int i_16_ = Class55.anInt1288;
                                            int i_17_ = Class58.anInt1352;
                                            class40_sub5_sub12
                                                    .anIntArray2685[i_16_]
                                                    = (class40_sub5_sub12
                                                    .anIntArray2685[i_17_]);
                                            class40_sub5_sub12
                                                    .anIntArray2710[i_16_]
                                                    = (class40_sub5_sub12
                                                    .anIntArray2710[i_17_]);
                                            class40_sub5_sub12
                                                    .anIntArray2685[i_17_]
                                                    = -1;
                                            class40_sub5_sub12
                                                    .anIntArray2710[i_17_]
                                                    = 0;
                                        }
                                        Class32.packetBuffer
                                                .putPacket(11453, 83);
                                        Class32.packetBuffer
                                                .method489(128, i);
                                        Class32.packetBuffer
                                                .method493
                                                        (Class58.anInt1352, -128);
                                        Class32.packetBuffer
                                                .method478(Class55.anInt1288, -20);
                                        Class32.packetBuffer
                                                .method503
                                                        (-2030879560, Class48.anInt1127);
                                    }
                                }
                                RSRuntimeException.anInt1651 = 10;
                                Class62.anInt1470 = 0;
                            }
                        }
                        if ((Class2.anInt78 ^ 0xffffffff) != 0) {
                            int i = Class2.anInt78;
                            int i_18_ = Class2.anInt81;
                            boolean bool
                                    = (Class38_Sub1.method448
                                    (0, 0,
                                            (Class40_Sub5_Sub13
                                                    .aClass40_Sub5_Sub17_Sub4_Sub1_2760
                                                    .anIntArray3088[0]),
                                            i, (byte) 119, 0, true, 0, 0,
                                            (Class40_Sub5_Sub13
                                                    .aClass40_Sub5_Sub17_Sub4_Sub1_2760
                                                    .anIntArray3135[0]),
                                            i_18_, 0));
                            if (bool) {
                                Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                                Floor.anInt2319 = 0;
                                Class40_Sub11.anInt2163 = Class57.anInt1338;
                                Class45.anInt1075 = 1;
                            }
                            Class2.anInt78 = -1;
                        }
                        if ((Class62.anInt1470 ^ 0xffffffff) == -2
                                && RSApplet.aClass1_8 != null) {
                            Class62.anInt1470 = 0;
                            Class52.aBoolean1221 = true;
                            RSApplet.aClass1_8 = null;
                        }
                        Class62.method1002(-77);
                        if ((NpcDefinition.anInt2433 ^ 0xffffffff) == 0) {
                            Class40_Sub5_Sub17_Sub3.method776((byte) -125);
                            Class38_Sub1.method447((byte) 29);
                            Class40_Sub5_Sub1.method544((byte) -54);
                        }
                        if ((Class40_Sub5_Sub2.anInt2302 ^ 0xffffffff) == -2
                                || (Class62.anInt1470 ^ 0xffffffff) == -2)
                            anInt3294++;
                        int i = 34;
                        if (Class66.anInt1560 != -1)
                            Class27.method360((byte) 125, 516, i, 338,
                                    Class66.anInt1560, 4, 4);
                        if (Class29.anInt673 == -1) {
                            if (((Class40_Sub5_Sub11.anIntArray2626
                                    [Class5.anInt208])
                                    ^ 0xffffffff)
                                    != 0)
                                Class27.method360((byte) 125, 743, i, 466,
                                        (Class40_Sub5_Sub11
                                                .anIntArray2626
                                                [Class5.anInt208]),
                                        205, 553);
                        } else
                            Class27.method360((byte) 125, 743, i, 466,
                                    Class29.anInt673, 205, 553);
                        if ((Class43.anInt1028 ^ 0xffffffff) != 0)
                            Class27.method360((byte) 125, 496, i, 453,
                                    Class43.anInt1028, 357, 17);
                        else if ((Class48.anInt1138 ^ 0xffffffff) != 0)
                            Class27.method360((byte) 125, 496, i, 453,
                                    Class48.anInt1138, 357, 17);
                        if ((Class66.anInt1560 ^ 0xffffffff) != 0)
                            Class27.method360((byte) 125, 516, i ^ 0xffffffff,
                                    338, Class66.anInt1560, 4, 4);
                        if (Class29.anInt673 != -1)
                            Class27.method360((byte) 125, 743, i ^ 0xffffffff,
                                    466, Class29.anInt673, 205, 553);
                        else if ((Class40_Sub5_Sub11.anIntArray2626
                                [Class5.anInt208])
                                != -1)
                            Class27.method360((byte) 125, 743, i ^ 0xffffffff,
                                    466,
                                    (Class40_Sub5_Sub11
                                            .anIntArray2626
                                            [Class5.anInt208]),
                                    205, 553);
                        if (Class43.anInt1028 != -1)
                            Class27.method360((byte) 125, 496, i ^ 0xffffffff,
                                    453, Class43.anInt1028, 357, 17);
                        else if (Class48.anInt1138 != -1)
                            Class27.method360((byte) 125, 496, i ^ 0xffffffff,
                                    453, Class48.anInt1138, 357, 17);
                        if ((Class67.anInt1586 ^ 0xffffffff) != 0
                                || (Class25.anInt614 ^ 0xffffffff) != 0
                                || HashTable.anInt573 != -1) {
                            if (RSString.anInt1711 > Class53.anInt1257) {
                                Class53.anInt1257++;
                                if ((Class53.anInt1257 ^ 0xffffffff)
                                        == (RSString.anInt1711 ^ 0xffffffff)) {
                                    if (Class67.anInt1586 != -1)
                                        Class52.aBoolean1221 = true;
                                    if (Class25.anInt614 != -1)
                                        ISAAC.aBoolean505 = true;
                                }
                            }
                        } else if ((Class53.anInt1257 ^ 0xffffffff) < -1)
                            Class53.anInt1257--;
                        Class40_Sub5_Sub17_Sub3.method775(false);
                        if (Class39.aBoolean906)
                            Class5.method165(35);
                        for (int i_19_ = 0; (i_19_ ^ 0xffffffff) > -6; i_19_++)
                            Class22_Sub1.anIntArray1846[i_19_]++;
                        Class40_Sub5_Sub6.method587(2);
                        int i_20_ = Class32.method400(-1);
                        int i_21_ = Class17.method274(true);
                        if (i_20_ > 4500 && i_21_ > 4500) {
                            RSString.anInt1673++;
                            Class32.anInt771 = 250;
                            Class40_Sub5_Sub13.method650(true, 4000);
                            Class32.packetBuffer.putPacket(11453,
                                    216);
                        }
                        Player.anInt3264++;
                        Class38_Sub1.anInt1923++;
                        if (arg0 <= 6)
                            loadFloor(-34, 97);
                        if (Class38_Sub1.anInt1923 > 500) {
                            int i_22_ = (int) (8.0 * Math.random());
                            if ((0x2 & i_22_ ^ 0xffffffff) == -3)
                                Class48.anInt1126 += Class68_Sub1.anInt2211;
                            if ((i_22_ & 0x1 ^ 0xffffffff) == -2)
                                Buffer.anInt1976 += Class42.anInt1010;
                            Class38_Sub1.anInt1923 = 0;
                            if ((0x4 & i_22_) == 4)
                                Class57.anInt1342 += Class5.anInt195;
                        }
                        if ((Class48.anInt1126 ^ 0xffffffff) > 54)
                            Class68_Sub1.anInt2211 = 2;
                        if (Player.anInt3264 > 500) {
                            int i_23_ = (int) (Math.random() * 8.0);
                            if ((0x1 & i_23_ ^ 0xffffffff) == -2)
                                Class43.anInt1020 += Class13.anInt419;
                            if ((0x2 & i_23_ ^ 0xffffffff) == -3)
                                Class51.anInt1187 += Main.anInt1766;
                            Player.anInt3264 = 0;
                        }
                        if (Class48.anInt1126 > 55)
                            Class68_Sub1.anInt2211 = -2;
                        if ((Buffer.anInt1976 ^ 0xffffffff) > 49)
                            Class42.anInt1010 = 2;
                        if ((Class43.anInt1020 ^ 0xffffffff) > 59)
                            Class13.anInt419 = 2;
                        Class22.anInt537++;
                        if ((Buffer.anInt1976 ^ 0xffffffff) < -51)
                            Class42.anInt1010 = -2;
                        if ((Class43.anInt1020 ^ 0xffffffff) < -61)
                            Class13.anInt419 = -2;
                        if (Class57.anInt1342 < -40)
                            Class5.anInt195 = 1;
                        if ((Class57.anInt1342 ^ 0xffffffff) < -41)
                            Class5.anInt195 = -1;
                        if (Class51.anInt1187 < -20)
                            Main.anInt1766 = 1;
                        if (Class51.anInt1187 > 10)
                            Main.anInt1766 = -1;
                        if ((Class22.anInt537 ^ 0xffffffff) < -51) {
                            Class32.packetBuffer.putPacket(11453,
                                    13);
                            Class49.anInt1142++;
                        }
                        do {
                            try {
                                if (Class40_Sub6.aClass64_2098 == null
                                        || (Class32.packetBuffer
                                        .offset) <= 0)
                                    break;
                                Class40_Sub6.aClass64_2098.method1010
                                        (Class32.packetBuffer.offset,
                                                (byte) -19, 0,
                                                (Class32.packetBuffer
                                                        .payload));
                                Class22.anInt537 = 0;
                                Class32.packetBuffer.offset = 0;
                            } catch (java.io.IOException ioexception) {
                                Class59.method982(2578);
                                break;
                            }
                            break;
                        } while (false);
                    }
                }
            }
        }
    }

    public static void method797(int arg0) {
        aClass1_3307 = null;
        anIntArray3304 = null;
        aClass1_3314 = null;
        aClass1_3305 = null;
        aClass1_3297 = null;
        aClass1_3295 = null;
        aClass1_3311 = null;
        aClass1_3308 = null;
        anIntArray3312 = null;
        aClass1_3302 = null;
        aClass2_3301 = null;
        aClass1_3309 = null;
        if (arg0 != 210)
            aClass1_3307 = null;
    }

    public static Floor loadFloor(int arg0, int arg1) {
        try {
            anInt3296++;
            Floor floor = ((Floor) Class33.aClass9_778.method231((long) arg0, (byte) 63));
            if (floor != null)
                return floor;
            byte[] is = Class40_Sub5_Sub17_Sub4.aClass6_3144.method172(arg0, 118, arg1);
            floor = new Floor();
            if (is != null)
                floor.method553((byte) 65, arg0, new Buffer(is));
            floor.method555((byte) 64);
            Class33.aClass9_778.method230(-7208, (long) arg0, floor);
            return floor;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vd.WA(" + arg0 + ',' + arg1 + ')');
        }
    }

    public Model method756(int arg0) {
        try {
            anInt3313++;
            if (aClass40_Sub5_Sub5_3300 == null)
                return null;
            int i = 25 % ((41 - arg0) / 47);
            Class40_Sub5_Sub7 class40_sub5_sub7
                    = ((anInt3141 ^ 0xffffffff) == 0 || anInt3122 != 0 ? null
                    : Class68_Sub1.method1050(anInt3141, 2));
            Class40_Sub5_Sub7 class40_sub5_sub7_0_
                    = (anInt3077 != -1 && (anInt3077 != anInt3126
                    || class40_sub5_sub7 == null)
                    ? Class68_Sub1.method1050(anInt3077, 2) : null);
            Model class40_sub5_sub17_sub5
                    = aClass40_Sub5_Sub5_3300.method568((byte) -50,
                    class40_sub5_sub7,
                    class40_sub5_sub7_0_,
                    anInt3116, anInt3104);
            if (class40_sub5_sub17_sub5 == null)
                return null;
            class40_sub5_sub17_sub5.method799();
            anInt3117 = class40_sub5_sub17_sub5.anInt2861;
            if ((anInt3091 ^ 0xffffffff) != 0 && anInt3140 != -1) {
                Model class40_sub5_sub17_sub5_1_
                        = Class37.method431(anInt3091, 13).method549(anInt3140, 2);
                if (class40_sub5_sub17_sub5_1_ != null) {
                    class40_sub5_sub17_sub5_1_.method828(0, -anInt3110, 0);
                    Model[] class40_sub5_sub17_sub5s
                            = {class40_sub5_sub17_sub5,
                            class40_sub5_sub17_sub5_1_};
                    class40_sub5_sub17_sub5
                            = new Model(class40_sub5_sub17_sub5s,
                            2, true);
                }
            }
            if ((aClass40_Sub5_Sub5_3300.anInt2374 ^ 0xffffffff) == -2)
                class40_sub5_sub17_sub5.aBoolean3164 = true;
            return class40_sub5_sub17_sub5;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vd.UA(" + arg0 + ')');
        }
    }

    public boolean method784(int arg0) {
        try {
            anInt3299++;
            if (aClass40_Sub5_Sub5_3300 == null)
                return false;
            return arg0 == 1;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vd.CB(" + arg0 + ')');
        }
    }
}
