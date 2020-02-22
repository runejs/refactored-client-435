/* Class64 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Class64 implements Runnable {
    public static RSString aClass1_1500 = Class58.method978("Your account has been disabled)3");
    public static int anInt1501;
    public static RSString aClass1_1502 = Class58.method978("Wordpack geladen)3");
    public static RSString aClass1_1505 = Class58.method978("Handel akzeptieren");
    public static int anInt1506;
    public static int anInt1507;
    public static int anInt1511 = -1;
    public static int anInt1514;
    public static int anInt1516;
    public static RSString aClass1_1517;
    public static int anInt1518;
    public static int anInt1519;
    public static Class6 aClass6_1521;
    public static int anInt1522;
    public static RSString aClass1_1523;
    public static RSString aClass1_1524;
    public static int anInt1525;
    public static RSString aClass1_1526 = aClass1_1500;
    public static int anInt1527;
    public static int setZ;

    static {
        aClass1_1523 = Class58.method978("");
        aClass1_1524 = Class58.method978("Menge eingeben:");
        aClass1_1517 = Class58.method978("redstone3");
        setZ = 99;
    }

    public InputStream anInputStream1503;
    public byte[] aByteArray1504;
    public Socket aSocket1508;
    public int anInt1509 = 0;
    public boolean aBoolean1510;
    public Class15 aClass15_1512;
    public boolean aBoolean1513;
    public Signlink aClass31_1515;
    public int anInt1520 = 0;
    public OutputStream anOutputStream1528;

    public Class64(Socket arg0, Signlink arg1) throws IOException {
        aBoolean1513 = false;
        aBoolean1510 = false;
        try {
            aClass31_1515 = arg1;
            aSocket1508 = arg0;
            aSocket1508.setSoTimeout(30000);
            aSocket1508.setTcpNoDelay(true);
            anInputStream1503 = aSocket1508.getInputStream();
            anOutputStream1528 = aSocket1508.getOutputStream();
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("vc.<init>(" + (arg0 != null ? "{...}" : "null") + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method1011(boolean arg0) {
        try {
            aClass1_1505 = null;
            aClass1_1526 = null;
            if(arg0 != true)
                aClass1_1502 = null;
            aClass1_1523 = null;
            aClass1_1502 = null;
            aClass6_1521 = null;
            aClass1_1524 = null;
            aClass1_1500 = null;
            aClass1_1517 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.H(" + arg0 + ')');
        }
    }

    public static void method1012(int arg0, int arg1) {
        try {
            anInt1518++;
            if(Class68.method1043(arg0, 126)) {
                Class40_Sub5_Sub12[] class40_sub5_sub12s = Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0];
                if(arg1 != 2)
                    method1013(true);
                for(int i = 0; class40_sub5_sub12s.length > i; i++) {
                    Class40_Sub5_Sub12 class40_sub5_sub12 = class40_sub5_sub12s[i];
                    if(class40_sub5_sub12.anObjectArray2677 != null)
                        Class43.method891(class40_sub5_sub12.anObjectArray2677, 0, 0, class40_sub5_sub12, 0, false);
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.D(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method1013(boolean arg0) {
        try {
            anInt1514++;
            int i = -1;
            if(arg0 != false)
                method1013(false);
            if((Class8.anInt301 ^ 0xffffffff) == -1 && Main.anInt1773 == 0) {
                VertexNormal.anInt1091++;
                Floor.method558(0, Class22_Sub2.aClass1_1876, Landscape.anInt1166, -501, Class13.anInt420, 7, Class66.aClass1_1567);
            }
            int i_1_ = 0;
            for(/**/; ((Model.anInt3220 ^ 0xffffffff) < (i_1_ ^ 0xffffffff)); i_1_++) {
                int i_2_ = Model.anIntArray3211[i_1_];
                int i_3_ = 0x7f & i_2_;
                int i_4_ = i_2_ >> -701905497 & 0x7f;
                int i_5_ = i_2_ >> -375610243 & 0x3;
                int i_6_ = (i_2_ & 0x1fffcccc) >> 2127666126;
                if(i != i_2_) {
                    i = i_2_;
                    if(i_5_ == 2 && (NPC.aScene_3301.method141(Player.anInt3267, i_3_, i_4_, i_2_)) >= 0) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_6_);
                        if(gameObjectDefinition.childrenIds != null)
                            gameObjectDefinition = gameObjectDefinition.method611(-20);
                        if(gameObjectDefinition == null)
                            continue;
                        if((Class8.anInt301 ^ 0xffffffff) == -2) {
                            Floor.method558(i_2_, Main.aClass1_1763, i_4_, -501, i_3_, 5, (Class40_Sub5_Sub17_Sub6.method832(106, (new RSString[]{(NPC.aClass1_3295), Class40_Sub5_Sub1.aClass1_2277, gameObjectDefinition.aClass1_2549}))));
                            Class44.anInt1045++;
                        } else if(Main.anInt1773 != 1) {
                            RSString[] class1s = gameObjectDefinition.aClass1Array2508;
                            if(Class60.aBoolean1402)
                                class1s = Class56.method968(class1s, arg0);
                            Class29.anInt675++;
                            if(class1s != null) {
                                for(int i_7_ = 4; (i_7_ ^ 0xffffffff) <= -1; i_7_--) {
                                    if(class1s[i_7_] != null) {
                                        int i_8_ = 0;
                                        Class35.anInt1741++;
                                        if(i_7_ == 0)
                                            i_8_ = 16;
                                        if(i_7_ == 1)
                                            i_8_ = 29;
                                        if((i_7_ ^ 0xffffffff) == -3)
                                            i_8_ = 17;
                                        if(i_7_ == 3)
                                            i_8_ = 27;
                                        if((i_7_ ^ 0xffffffff) == -5)
                                            i_8_ = 1002;
                                        Floor.method558(i_2_, class1s[i_7_], i_4_, -501, i_3_, i_8_, (Class40_Sub5_Sub17_Sub6.method832(-91, (new RSString[]{(Renderable.aClass1_2862), (gameObjectDefinition.aClass1_2549)}))));
                                    }
                                }
                            }
                            Floor.method558(gameObjectDefinition.anInt2538 << 2045308238, Class40_Sub5_Sub15.aClass1_2774, i_4_, -501, i_3_, 1004, (Class40_Sub5_Sub17_Sub6.method832(113, (new RSString[]{Renderable.aClass1_2862, gameObjectDefinition.aClass1_2549}))));
                        } else if((ItemDefinition.anInt2815 & 0x4) == 4) {
                            Renderable.anInt2863++;
                            Floor.method558(i_2_, Class38_Sub1.aClass1_1918, i_4_, -501, i_3_, 32, (Class40_Sub5_Sub17_Sub6.method832(111, (new RSString[]{FloorDecoration.aClass1_611, Class40_Sub5_Sub1.aClass1_2277, gameObjectDefinition.aClass1_2549}))));
                        }
                    }
                    if(i_5_ == 1) {
                        NPC class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_6_]);
                        if(((class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.anInt2374) ^ 0xffffffff) == -2 && ((class40_sub5_sub17_sub4_sub2.anInt3098 & 0x7f) == 64) && ((0x7f & class40_sub5_sub17_sub4_sub2.anInt3089) == 64)) {
                            for(int i_9_ = 0; ((GameObjectDefinition.anInt2558 ^ 0xffffffff) < (i_9_ ^ 0xffffffff)); i_9_++) {
                                NPC class40_sub5_sub17_sub4_sub2_10_ = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i_9_]]);
                                if(class40_sub5_sub17_sub4_sub2_10_ != null && (class40_sub5_sub17_sub4_sub2_10_ != class40_sub5_sub17_sub4_sub2) && ((class40_sub5_sub17_sub4_sub2_10_.aClass40_Sub5_Sub5_3300.anInt2374) ^ 0xffffffff) == -2 && ((class40_sub5_sub17_sub4_sub2.anInt3098 ^ 0xffffffff) == ((class40_sub5_sub17_sub4_sub2_10_.anInt3098) ^ 0xffffffff)) && ((class40_sub5_sub17_sub4_sub2_10_.anInt3089) == (class40_sub5_sub17_sub4_sub2.anInt3089)))
                                    Class66.method1025(0, i_3_, i_4_, Class40_Sub3.anIntArray2016[i_9_], (class40_sub5_sub17_sub4_sub2_10_.aClass40_Sub5_Sub5_3300));
                            }
                            for(int i_11_ = 0; i_11_ < Class60.anInt1407; i_11_++) {
                                Player class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_11_]]);
                                if(class40_sub5_sub17_sub4_sub1 != null && (class40_sub5_sub17_sub4_sub2.anInt3098 == (class40_sub5_sub17_sub4_sub1.anInt3098)) && ((class40_sub5_sub17_sub4_sub2.anInt3089 ^ 0xffffffff) == ((class40_sub5_sub17_sub4_sub1.anInt3089) ^ 0xffffffff)))
                                    Class40_Sub5_Sub1.method545(i_4_, false, i_3_, class40_sub5_sub17_sub4_sub1, Class57.anIntArray1334[i_11_]);
                            }
                        }
                        Class66.method1025(0, i_3_, i_4_, i_6_, (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300));
                    }
                    if(i_5_ == 0) {
                        Player class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_6_]);
                        if((0x7f & class40_sub5_sub17_sub4_sub1.anInt3098 ^ 0xffffffff) == -65 && (0x7f & class40_sub5_sub17_sub4_sub1.anInt3089 ^ 0xffffffff) == -65) {
                            for(int i_12_ = 0; ((i_12_ ^ 0xffffffff) > (GameObjectDefinition.anInt2558 ^ 0xffffffff)); i_12_++) {
                                NPC class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i_12_]]);
                                if(class40_sub5_sub17_sub4_sub2 != null && ((class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.anInt2374) == 1) && ((class40_sub5_sub17_sub4_sub1.anInt3098 ^ 0xffffffff) == ((class40_sub5_sub17_sub4_sub2.anInt3098) ^ 0xffffffff)) && (class40_sub5_sub17_sub4_sub2.anInt3089 == (class40_sub5_sub17_sub4_sub1.anInt3089)))
                                    Class66.method1025(0, i_3_, i_4_, Class40_Sub3.anIntArray2016[i_12_], (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300));
                            }
                            for(int i_13_ = 0; ((i_13_ ^ 0xffffffff) > (Class60.anInt1407 ^ 0xffffffff)); i_13_++) {
                                Player class40_sub5_sub17_sub4_sub1_14_ = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_13_]]);
                                if(class40_sub5_sub17_sub4_sub1_14_ != null && (class40_sub5_sub17_sub4_sub1_14_ != class40_sub5_sub17_sub4_sub1) && (((class40_sub5_sub17_sub4_sub1_14_.anInt3098) ^ 0xffffffff) == ((class40_sub5_sub17_sub4_sub1.anInt3098) ^ 0xffffffff)) && (((class40_sub5_sub17_sub4_sub1_14_.anInt3089) ^ 0xffffffff) == ((class40_sub5_sub17_sub4_sub1.anInt3089) ^ 0xffffffff)))
                                    Class40_Sub5_Sub1.method545(i_4_, arg0, i_3_, class40_sub5_sub17_sub4_sub1_14_, Class57.anIntArray1334[i_13_]);
                            }
                        }
                        Class40_Sub5_Sub1.method545(i_4_, false, i_3_, class40_sub5_sub17_sub4_sub1, i_6_);
                    }
                    if((i_5_ ^ 0xffffffff) == -4) {
                        Class45 class45 = (Class10.aClass45ArrayArrayArray357[Player.anInt3267][i_3_][i_4_]);
                        if(class45 != null) {
                            for(Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3 = ((Class40_Sub5_Sub17_Sub3) class45.method901((byte) -95)); class40_sub5_sub17_sub3 != null; class40_sub5_sub17_sub3 = ((Class40_Sub5_Sub17_Sub3) class45.method912(4))) {
                                ItemDefinition class40_sub5_sub16 = (Class44.method897(class40_sub5_sub17_sub3.anInt3067, 10));
                                if(Class8.anInt301 == 1) {
                                    Class44.anInt1036++;
                                    Floor.method558(class40_sub5_sub17_sub3.anInt3067, Main.aClass1_1763, i_4_, -501, i_3_, 47, (Class40_Sub5_Sub17_Sub6.method832(115, (new RSString[]{(NPC.aClass1_3295), Class5.aClass1_206, (class40_sub5_sub16.aClass1_2796)}))));
                                } else if((Main.anInt1773 ^ 0xffffffff) != -2) {
                                    RSString[] class1s = class40_sub5_sub16.groundOptions;
                                    Class56.anInt1319++;
                                    if(Class60.aBoolean1402)
                                        class1s = Class56.method968(class1s, arg0);
                                    for(int i_15_ = 4; (i_15_ ^ 0xffffffff) <= -1; i_15_--) {
                                        if(class1s == null || class1s[i_15_] == null) {
                                            if(i_15_ == 2) {
                                                Class10.anInt339++;
                                                Floor.method558((class40_sub5_sub17_sub3.anInt3067), Class27.takeStringInstance, i_4_, -501, i_3_, 3, (Class40_Sub5_Sub17_Sub6.method832(123, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                            }
                                        } else {
                                            Floor.anInt2331++;
                                            int i_16_ = 0;
                                            if(i_15_ == 0)
                                                i_16_ = 2;
                                            if(i_15_ == 1)
                                                i_16_ = 38;
                                            if((i_15_ ^ 0xffffffff) == -3)
                                                i_16_ = 3;
                                            if(i_15_ == 3)
                                                i_16_ = 8;
                                            if(i_15_ == 4)
                                                i_16_ = 36;
                                            Floor.method558((class40_sub5_sub17_sub3.anInt3067), class1s[i_15_], i_4_, -501, i_3_, i_16_, (Class40_Sub5_Sub17_Sub6.method832(-97, (new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)}))));
                                        }
                                    }
                                    Floor.method558(class40_sub5_sub17_sub3.anInt3067, Class40_Sub5_Sub15.aClass1_2774, i_4_, -501, i_3_, 1003, (Class40_Sub5_Sub17_Sub6.method832(89, new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.aClass1_2796)})));
                                } else if((0x1 & ItemDefinition.anInt2815) == 1) {
                                    Floor.method558(class40_sub5_sub17_sub3.anInt3067, Class38_Sub1.aClass1_1918, i_4_, -501, i_3_, 15, (Class40_Sub5_Sub17_Sub6.method832(-67, new RSString[]{FloorDecoration.aClass1_611, Class5.aClass1_206, (class40_sub5_sub16.aClass1_2796)})));
                                    Class58.anInt1368++;
                                }
                            }
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.G(" + arg0 + ')');
        }
    }

    public static void method1015(int arg0) {
        try {
            synchronized(GameObject.aClass62_3019) {
                Class40_Sub5_Sub2.anInt2302 = Cache.anInt320;
                Class13.anInt420 = Class12.anInt389;
                if(arg0 != -656)
                    aClass1_1524 = null;
                Landscape.anInt1166 = Cache.anInt322;
                Class62.anInt1470 = Class40_Sub5_Sub17_Sub4.anInt3143;
                Class57.anInt1338 = Class55.anInt1295;
                RSString.anInt1668 = Class40_Sub5_Sub11.anInt2625;
                GameObjectDefinition.aLong2561 = Floor.aLong2344;
                Class40_Sub5_Sub17_Sub4.anInt3143 = 0;
            }
            anInt1527++;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.F(" + arg0 + ')');
        }
    }

    public void method1008(int arg0, int arg1, int arg2, byte[] arg3) throws IOException {
        try {
            anInt1522++;
            if(!aBoolean1513 && arg2 < -126) {
                while((arg1 ^ 0xffffffff) < -1) {
                    int i = anInputStream1503.read(arg3, arg0, arg1);
                    if((i ^ 0xffffffff) >= -1)
                        throw new EOFException();
                    arg1 -= i;
                    arg0 += i;
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("vc.C(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + (arg3 != null ? "{...}" : "null") + ')'));
        }
    }

    public void method1009(int arg0) {
        try {
            int i = 27 / ((-54 - arg0) / 32);
            anInt1516++;
            if(!aBoolean1513) {
                synchronized(this) {
                    aBoolean1513 = true;
                    this.notifyAll();
                }
                if(aClass15_1512 != null) {
                    while(aClass15_1512.anInt434 == 0)
                        Class43.method890(1L, 115);
                    if((aClass15_1512.anInt434 ^ 0xffffffff) == -2) {
                        try {
                            ((Thread) aClass15_1512.anObject437).join();
                        } catch(InterruptedException interruptedexception) {
                            /* empty */
                        }
                    }
                }
                aClass15_1512 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.B(" + arg0 + ')');
        }
    }

    public void method1010(int arg0, byte arg1, int arg2, byte[] arg3) throws IOException {
        try {
            anInt1525++;
            if(!aBoolean1513) {
                if(aBoolean1510) {
                    aBoolean1510 = false;
                    throw new IOException();
                }
                if(aByteArray1504 == null)
                    aByteArray1504 = new byte[5000];
                synchronized(this) {
                    for(int i = 0; (arg0 ^ 0xffffffff) < (i ^ 0xffffffff); i++) {
                        aByteArray1504[anInt1509] = arg3[arg2 + i];
                        anInt1509 = (1 + anInt1509) % 5000;
                        if(anInt1509 == (4900 + anInt1520) % 5000)
                            throw new IOException();
                    }
                    if(aClass15_1512 == null)
                        aClass15_1512 = aClass31_1515.method394(3, 0, this);
                    this.notifyAll();
                    if(arg1 != -19)
                        run();
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("vc.I(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + (arg3 != null ? "{...}" : "null") + ')'));
        }
    }

    public void finalize() {
        try {
            method1009(-4);
            anInt1501++;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.finalize(" + ')');
        }
    }

    public void run() {
        try {
            anInt1519++;
            try {
                for(; ; ) {
                    int i;
                    int i_0_;
                    synchronized(this) {
                        if(anInt1509 == anInt1520) {
                            if(aBoolean1513)
                                break;
                            try {
                                this.wait();
                            } catch(InterruptedException interruptedexception) {
                                /* empty */
                            }
                        }
                        if((anInt1520 ^ 0xffffffff) >= (anInt1509 ^ 0xffffffff))
                            i = anInt1509 - anInt1520;
                        else
                            i = -anInt1520 + 5000;
                        i_0_ = anInt1520;
                    }
                    if(i > 0) {
                        try {
                            anOutputStream1528.write(aByteArray1504, i_0_, i);
                        } catch(IOException ioexception) {
                            aBoolean1510 = true;
                        }
                        anInt1520 = (i + anInt1520) % 5000;
                        try {
                            if((anInt1509 ^ 0xffffffff) == (anInt1520 ^ 0xffffffff))
                                anOutputStream1528.flush();
                        } catch(IOException ioexception) {
                            aBoolean1510 = true;
                        }
                    }
                }
                try {
                    if(anInputStream1503 != null)
                        anInputStream1503.close();
                    if(anOutputStream1528 != null)
                        anOutputStream1528.close();
                    if(aSocket1508 != null)
                        aSocket1508.close();
                } catch(IOException ioexception) {
                    /* empty */
                }
                aByteArray1504 = null;
            } catch(Exception exception) {
                Class6.method169(null, (byte) -122, exception);
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.run(" + ')');
        }
    }

    public int method1014(int arg0) throws IOException {
        try {
            anInt1507++;
            if(arg0 >= -120)
                aClass31_1515 = null;
            if(aBoolean1513)
                return 0;
            return anInputStream1503.available();
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.E(" + arg0 + ')');
        }
    }

    public int method1016(int arg0) throws IOException {
        try {
            if(arg0 < 14)
                aClass1_1524 = null;
            anInt1506++;
            if(aBoolean1513)
                return 0;
            return anInputStream1503.read();
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vc.A(" + arg0 + ')');
        }
    }
}
