package com.jagex.runescape;

import java.awt.*;
import java.awt.event.*;

public class Class62 implements MouseListener, MouseMotionListener, FocusListener {
    public static int anInt1447;
    public static int anInt1448;
    public static int anInt1449;
    public static int anInt1450;
    public static int anInt1451;
    public static int anInt1452;
    public static int anInt1453;
    public static int anInt1454;
    public static Cache aClass9_1455;
    public static long aLong1456;
    public static int anInt1457 = -1;
    public static int anInt1458;
    public static int anInt1459;
    public static int anInt1460;
    public static int anInt1461;
    public static int anInt1462;
    public static RSString aClass1_1463;
    public static RSString aClass1_1464;
    public static RSString aClass1_1465;
    public static DirectColorSprite[] aClass40_Sub5_Sub14_Sub4Array1466;
    public static long aLong1467;
    public static int anInt1468;
    public static Canvas aCanvas1469;
    public static int anInt1470;
    public static RSString aClass1_1471;
    public static int anInt1472;
    public static byte[][][] aByteArrayArrayArray1473;
    public static RSString aClass1_1474;

    static {
        anInt1450 = -1;
        aClass9_1455 = new Cache(50);
        aClass1_1464 = Class58.method978(" is already on your friend list");
        aClass1_1465 = aClass1_1464;
        aClass40_Sub5_Sub14_Sub4Array1466 = new DirectColorSprite[1000];
        aClass1_1463 = Class58.method978("wave2:");
        anInt1470 = 0;
        anInt1472 = 78;
        aClass1_1471 = Class58.method978("Lade Titelbild )2 ");
        aClass1_1474 = aClass1_1463;
    }

    public static void method1001(boolean arg0) {

        aClass1_1471 = null;
            aClass40_Sub5_Sub14_Sub4Array1466 = null;
            aClass1_1465 = null;
            if(arg0 != true)
                method1003(null, null, 31);
            aClass1_1463 = null;
            aClass9_1455 = null;
            aCanvas1469 = null;
            aClass1_1464 = null;
            aClass1_1474 = null;
            aByteArrayArrayArray1473 = null;

    }

    public static void method1002(int arg0) {
        anInt1460++;
        if((SceneTile.anInt2049 ^ 0xffffffff) == -1) {
            if(arg0 > -60)
                anInt1470 = -90;
            int i = anInt1470;
            if((Main.anInt1773 ^ 0xffffffff) == -2 && (Class57.anInt1338 ^ 0xffffffff) <= -517 && (RSString.anInt1668 ^ 0xffffffff) <= -161 && (Class57.anInt1338 ^ 0xffffffff) >= -766 && RSString.anInt1668 <= 205)
                i = 0;
            if(!Class4.aBoolean173) {
                if(i == 1 && (NpcDefinition.anInt2394 ^ 0xffffffff) < -1) {
                    int i_0_ = (Class38.anIntArray884[NpcDefinition.anInt2394 - 1]);
                    if((i_0_ ^ 0xffffffff) == -54 || i_0_ == 25 || i_0_ == 55 || (i_0_ ^ 0xffffffff) == -49 || (i_0_ ^ 0xffffffff) == -25 || (i_0_ ^ 0xffffffff) == -53 || (i_0_ ^ 0xffffffff) == -7 || i_0_ == 31 || (i_0_ ^ 0xffffffff) == -44 || i_0_ == 11 || i_0_ == 19 || i_0_ == 1006) {
                        int i_1_ = (Class19.anIntArray483[NpcDefinition.anInt2394 - 1]);
                        int i_2_ = (Class59.anIntArray1393[-1 + NpcDefinition.anInt2394]);
                        Class40_Sub5_Sub12 class40_sub5_sub12 = Class68.method1045(i_2_, (byte) -58);
                        if(class40_sub5_sub12.aBoolean2703 || class40_sub5_sub12.aBoolean2723) {
                            Renderable.anInt2869 = Class57.anInt1338;
                            Class40_Sub5_Sub15.aBoolean2784 = false;
                            SceneTile.anInt2049 = 2;
                            Class48.anInt1127 = i_2_;
                            ItemDefinition.anInt2798 = RSString.anInt1668;
                            Class58.anInt1352 = i_1_;
                            if((Class66.anInt1560 ^ 0xffffffff) == (i_2_ >> 799918864 ^ 0xffffffff))
                                SceneTile.anInt2049 = 1;
                            if((i_2_ >> 1441108912 ^ 0xffffffff) == (Class43.anInt1028 ^ 0xffffffff))
                                SceneTile.anInt2049 = 3;
                            Buffer.anInt1978 = 0;
                            return;
                        }
                    }
                }
                if((i ^ 0xffffffff) == -2 && ((Class68.anInt1630 ^ 0xffffffff) == -2 || Class33.method409((byte) 46, -1 + NpcDefinition.anInt2394)) && (NpcDefinition.anInt2394 ^ 0xffffffff) < -3)
                    i = 2;
                if(i == 1 && NpcDefinition.anInt2394 > 0)
                    Class27.method358(59, NpcDefinition.anInt2394 + -1);
                if(i == 2 && NpcDefinition.anInt2394 > 0)
                    Class60.method990(11451);
            } else {
                if((i ^ 0xffffffff) != -2) {
                    int i_3_ = Class13.anInt420;
                    int i_4_ = Landscape.anInt1166;
                    if(Class40_Sub5_Sub17_Sub1.anInt2983 == 0) {
                        i_3_ -= 4;
                        i_4_ -= 4;
                    }
                    if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -2) {
                        i_4_ -= 205;
                        i_3_ -= 553;
                    }
                    if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -3) {
                        i_4_ -= 357;
                        i_3_ -= 17;
                    }
                    if((-10 + Class19.anInt475 ^ 0xffffffff) < (i_3_ ^ 0xffffffff) || 10 + VertexNormal.anInt1086 + Class19.anInt475 < i_3_ || (i_4_ ^ 0xffffffff) > (Main.anInt1758 + -10 ^ 0xffffffff) || ((i_4_ ^ 0xffffffff) < (Main.anInt1758 + CollisionMap.anInt168 + 10 ^ 0xffffffff))) {
                        if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -2)
                            ISAAC.aBoolean505 = true;
                        Class4.aBoolean173 = false;
                        if(Class40_Sub5_Sub17_Sub1.anInt2983 == 2)
                            Class52.aBoolean1221 = true;
                    }
                }
                if((i ^ 0xffffffff) == -2) {
                    int i_5_ = Class19.anInt475;
                    int i_6_ = Main.anInt1758;
                    int i_7_ = VertexNormal.anInt1086;
                    int i_8_ = Class57.anInt1338;
                    int i_9_ = -1;
                    int i_10_ = RSString.anInt1668;
                    if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -1) {
                        i_8_ -= 4;
                        i_10_ -= 4;
                    }
                    if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -2) {
                        i_8_ -= 553;
                        i_10_ -= 205;
                    }
                    if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -3) {
                        i_8_ -= 17;
                        i_10_ -= 357;
                    }
                    for(int i_11_ = 0; ((i_11_ ^ 0xffffffff) > (NpcDefinition.anInt2394 ^ 0xffffffff)); i_11_++) {
                        int i_12_ = 31 + i_6_ + 15 * (NpcDefinition.anInt2394 + -1 - i_11_);
                        if(i_8_ > i_5_ && i_8_ < i_7_ + i_5_ && i_10_ > -13 + i_12_ && i_10_ < 3 + i_12_)
                            i_9_ = i_11_;
                    }
                    if((i_9_ ^ 0xffffffff) != 0)
                        Class27.method358(109, i_9_);
                    if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -2)
                        ISAAC.aBoolean505 = true;
                    Class4.aBoolean173 = false;
                    if(Class40_Sub5_Sub17_Sub1.anInt2983 == 2)
                        Class52.aBoolean1221 = true;
                }
            }
        }
    }

    public static Class40_Sub9_Sub1 method1003(Signlink arg0, Component arg1, int arg2) {

        if(arg2 != 29914)
                aByteArrayArrayArray1473 = null;
            Class68.method1040(arg1, 0, arg0);
            Class40_Sub9_Sub1 class40_sub9_sub1 = new Class40_Sub9_Sub1();
            Class8.method218(class40_sub9_sub1, -125);
            anInt1447++;
            return class40_sub9_sub1;

    }

    public synchronized void mouseEntered(MouseEvent arg0) {
        anInt1461++;
        if(GameObject.aClass62_3019 != null) {
            Class45.anInt1073 = 0;
            Class12.anInt389 = arg0.getX();
            Cache.anInt322 = arg0.getY();
        }
    }

    public synchronized void mouseExited(MouseEvent arg0) {
        anInt1451++;
        if(GameObject.aClass62_3019 != null) {
            Class45.anInt1073 = 0;
            Class12.anInt389 = -1;
            Cache.anInt322 = -1;
        }
    }

    public synchronized void focusLost(FocusEvent arg0) {

        if(GameObject.aClass62_3019 != null)
                Cache.anInt320 = 0;
            anInt1459++;

    }

    public synchronized void mouseDragged(MouseEvent arg0) {

        if(GameObject.aClass62_3019 != null) {
                Class45.anInt1073 = 0;
                Class12.anInt389 = arg0.getX();
                Cache.anInt322 = arg0.getY();
            }
            anInt1454++;

    }

    public void focusGained(FocusEvent arg0) {

        anInt1458++;

    }

    public synchronized void mousePressed(MouseEvent arg0) {

        if(GameObject.aClass62_3019 != null) {
                Class45.anInt1073 = 0;
                Class55.anInt1295 = arg0.getX();
                Class40_Sub5_Sub11.anInt2625 = arg0.getY();
                Floor.aLong2344 = Class51.method937(1);
                if(!arg0.isMetaDown()) {
                    Class40_Sub5_Sub17_Sub4.anInt3143 = 1;
                    Cache.anInt320 = 1;
                } else {
                    Class40_Sub5_Sub17_Sub4.anInt3143 = 2;
                    Cache.anInt320 = 2;
                }
            }
            if(arg0.isPopupTrigger())
                arg0.consume();
            anInt1453++;

    }

    public void mouseClicked(MouseEvent arg0) {
        anInt1448++;
        if(arg0.isPopupTrigger())
            arg0.consume();
    }

    public synchronized void mouseMoved(MouseEvent arg0) {
        anInt1449++;
        if(GameObject.aClass62_3019 != null) {
            Class45.anInt1073 = 0;
            Class12.anInt389 = arg0.getX();
            Cache.anInt322 = arg0.getY();
        }
    }

    public synchronized void mouseReleased(MouseEvent arg0) {
        anInt1462++;
        if(GameObject.aClass62_3019 != null) {
            Class45.anInt1073 = 0;
            Cache.anInt320 = 0;
        }
        if(arg0.isPopupTrigger())
            arg0.consume();
    }
}
