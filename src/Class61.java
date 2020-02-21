/* Class61 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class61 {
    public static RSString aClass1_1421;
    public static RSString aClass1_1422;
    public static PacketBuffer packetBuffer;
    public static int anInt1424;
    public static RSString aClass1_1425;
    public static RSString aClass1_1426;
    public static RSString aClass1_1427;
    public static RSString aClass1_1428;
    public static RSString aClass1_1429 = Class58.method978("wishes to duel with you)3");
    public static int anInt1431;
    public static RSString aClass1_1432;
    public static int anInt1434;
    public static int[][] anIntArrayArray1435;
    public static int anInt1436;
    public static RSString aClass1_1437;
    public static RSString aClass1_1438;
    public static RSString aClass1_1439;
    public static RSString aClass1_1440;
    public static Class68 aClass68_1441;
    public static int anInt1442;
    public static int anInt1443;
    public static boolean aBoolean1444;
    public static int[] anIntArray1445;
    public static RSString aClass1_1446;

    static {
        aClass1_1425 = Class58.method978("Username: ");
        aClass1_1427 = Class58.method978("mapedge");
        aClass1_1422 = aClass1_1425;
        anIntArrayArray1435 = new int[104][104];
        aClass1_1438 = Class58.method978("System update in: ");
        aClass1_1439 = (Class58.method978("To play on this world move to a free area first"));
        aClass1_1426 = Class58.method978("Ladevorgang )2 bitte warten Sie)3");
        aClass1_1440 = Class58.method978("backleft1");
        aClass1_1432 = aClass1_1438;
        aClass1_1428 = aClass1_1429;
        aClass1_1437 = Class58.method978("null");
        aBoolean1444 = false;
        aClass1_1421 = aClass1_1439;
        packetBuffer = new PacketBuffer(5000);
        aClass1_1446 = Class58.method978("Fps:");
    }

    public Class40_Sub5_Sub1 aClass40_Sub5_Sub1_1419;
    public int[] anIntArray1420;
    public RSString[] aClass1Array1430;
    public int anInt1433 = -1;

    public static void method995(byte arg0, int arg1) {
        try {
            anInt1436++;
            if(arg1 != -1 && Class68.aBooleanArray1629[arg1]) {
                Class40_Sub5_Sub4.aClass6_2349.method171(1, arg1);
                if(arg0 < 31)
                    aClass1_1428 = null;
                if(Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1] != null) {
                    boolean bool = true;
                    for(int i = 0; ((i ^ 0xffffffff) > ((Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1]).length ^ 0xffffffff)); i++) {
                        if(Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1][i] != null) {
                            if((Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1][i].anInt2683) != 2)
                                Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1][i] = null;
                            else
                                bool = false;
                        }
                    }
                    if(bool)
                        Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1] = null;
                    Class68.aBooleanArray1629[arg1] = false;
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ua.B(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method996(int arg0) {
        try {
            anInt1443++;
            if(arg0 != 19655)
                aClass1_1432 = null;
            SubNode.aClass68_2091.method1046((byte) 90);
            Class25.aClass40_Sub5_Sub14_Sub2_593.method692(0, 0);
            NpcDefinition.anIntArray2386 = R3D.method708(NpcDefinition.anIntArray2386);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ua.A(" + arg0 + ')');
        }
    }

    public static void method997(int arg0) {
        try {
            anInt1424++;
            if(arg0 != 47)
                method999(-42, (byte) 12, 92, 18, -72);
            if(Signlink.aString735.toLowerCase().indexOf("microsoft") != -1) {
                Class66.anIntArray1564[186] = 57;
                Class66.anIntArray1564[187] = 27;
                Class66.anIntArray1564[188] = 71;
                Class66.anIntArray1564[189] = 26;
                Class66.anIntArray1564[190] = 72;
                Class66.anIntArray1564[191] = 73;
                Class66.anIntArray1564[192] = 58;
                Class66.anIntArray1564[219] = 42;
                Class66.anIntArray1564[220] = 74;
                Class66.anIntArray1564[221] = 43;
                Class66.anIntArray1564[222] = 59;
                Class66.anIntArray1564[223] = 28;
            } else {
                Class66.anIntArray1564[44] = 71;
                Class66.anIntArray1564[45] = 26;
                Class66.anIntArray1564[46] = 72;
                Class66.anIntArray1564[47] = 73;
                Class66.anIntArray1564[59] = 57;
                Class66.anIntArray1564[61] = 27;
                Class66.anIntArray1564[91] = 42;
                Class66.anIntArray1564[92] = 74;
                Class66.anIntArray1564[93] = 43;
                if(Signlink.aMethod729 != null) {
                    Class66.anIntArray1564[192] = 28;
                    Class66.anIntArray1564[222] = 58;
                    Class66.anIntArray1564[520] = 59;
                } else {
                    Class66.anIntArray1564[192] = 58;
                    Class66.anIntArray1564[222] = 59;
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ua.C(" + arg0 + ')');
        }
    }

    public static void method998(int arg0) {
        try {
            anIntArrayArray1435 = null;
            aClass1_1446 = null;
            anIntArray1445 = null;
            aClass68_1441 = null;
            packetBuffer = null;
            aClass1_1422 = null;
            aClass1_1429 = null;
            aClass1_1426 = null;
            aClass1_1439 = null;
            aClass1_1437 = null;
            aClass1_1438 = null;
            aClass1_1425 = null;
            aClass1_1421 = null;
            if(arg0 > -8)
                packetBuffer = null;
            aClass1_1432 = null;
            aClass1_1428 = null;
            aClass1_1440 = null;
            aClass1_1427 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ua.F(" + arg0 + ')');
        }
    }

    public static void method999(int arg0, byte arg1, int arg2, int arg3, int arg4) {
        try {
            anInt1434++;
            int i = -112 / ((50 - arg1) / 53);
            for(int i_0_ = arg0; (i_0_ ^ 0xffffffff) >= (arg0 + arg2 ^ 0xffffffff); i_0_++) {
                for(int i_1_ = arg4; (arg3 + arg4 ^ 0xffffffff) <= (i_1_ ^ 0xffffffff); i_1_++) {
                    if(i_1_ >= 0 && (i_1_ ^ 0xffffffff) > -105 && i_0_ >= 0 && (i_0_ ^ 0xffffffff) > -105) {
                        Class19.aByteArrayArrayArray492[0][i_1_][i_0_] = (byte) 127;
                        if(arg4 == i_1_ && i_1_ > 0)
                            Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][-1 + i_1_][i_0_]);
                        if(arg4 + arg3 == i_1_ && (i_1_ ^ 0xffffffff) > -104)
                            Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][i_1_ - -1][i_0_]);
                        if((arg0 ^ 0xffffffff) == (i_0_ ^ 0xffffffff) && i_0_ > 0)
                            Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][i_1_][i_0_ + -1]);
                        if(i_0_ == arg0 + arg2 && (i_0_ ^ 0xffffffff) > -104)
                            Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][i_1_][1 + i_0_]);
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ua.E(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ')'));
        }
    }

    public static void method1000(boolean arg0) {
        try {
            if(arg0 == true) {
                anInt1431++;
                for(Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = ((Class40_Sub5_Sub17_Sub6) Class57.aClass45_1332.method902((byte) -90)); class40_sub5_sub17_sub6 != null; class40_sub5_sub17_sub6 = ((Class40_Sub5_Sub17_Sub6) Class57.aClass45_1332.method909(-4))) {
                    if(((class40_sub5_sub17_sub6.anInt3239 ^ 0xffffffff) == (Player.anInt3267 ^ 0xffffffff)) && !class40_sub5_sub17_sub6.aBoolean3237) {
                        if(Node.anInt926 >= class40_sub5_sub17_sub6.anInt3230) {
                            class40_sub5_sub17_sub6.method834(8076, Class5.anInt199);
                            if(class40_sub5_sub17_sub6.aBoolean3237)
                                class40_sub5_sub17_sub6.method457(-1);
                            else
                                NPC.aScene_3301.method134(class40_sub5_sub17_sub6.anInt3239, class40_sub5_sub17_sub6.anInt3244, class40_sub5_sub17_sub6.anInt3235, class40_sub5_sub17_sub6.anInt3231, 60, class40_sub5_sub17_sub6, 0, -1, false);
                        }
                    } else
                        class40_sub5_sub17_sub6.method457(-1);
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ua.D(" + arg0 + ')');
        }
    }
}
