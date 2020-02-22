package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.util.Signlink;

import java.awt.*;

public abstract class Class68 {
    public static Cache aClass9_1615;
    public static int anInt1616;
    public static int anInt1618 = 0;
    public static int anInt1620;
    public static int anInt1622;
    public static int anInt1623 = 0;
    public static int anInt1624;
    public static int anInt1626;
    public static int anInt1627;
    public static RSString aClass1_1628;
    public static boolean[] aBooleanArray1629;
    public static int anInt1630;
    public static Class68 aClass68_1631;
    public static Class15 aClass15_1632;
    public static RSString aClass1_1633;
    public static int anInt1634;
    public static RSString aClass1_1635;
    public static RSString aClass1_1636;
    public static int anInt1637;
    public static RSString aClass1_1638;
    public static RSString aClass1_1639;
    public static RSString aClass1_1640;

    static {
        aClass9_1615 = new Cache(64);
        anInt1630 = 0;
        aClass1_1633 = Class58.method978(" is already on your ignore list");
        anInt1634 = 0;
        anInt1637 = 0;
        aClass1_1636 = Class58.method978("Loaded title screen");
        aClass1_1638 = aClass1_1636;
        aClass1_1628 = aClass1_1633;
        aClass1_1639 = Class58.method978("@or2@");
        aClass1_1640 = Class58.method978("Cancel");
        aClass1_1635 = aClass1_1640;
    }

    public int anInt1617;
    public int anInt1619;
    public int[] anIntArray1621;
    public Image anImage1625;

    public static void method1040(Component arg0, int arg1, Signlink arg2) {

        anInt1620++;
            try {
                Class8_Sub1 class8_sub1 = ((Class8_Sub1) Class.forName("com.jagex.runescape.Class8_Sub1_Sub2").newInstance());
                class8_sub1.method222(arg2, 2048);
                CollisionMap.aClass8_166 = class8_sub1;
            } catch(Throwable throwable) {
                try {
                    CollisionMap.aClass8_166 = new Class8_Sub1_Sub1(arg2, arg0);
                } catch(Throwable throwable_0_) {
                    if(arg1 <= Signlink.aString735.toLowerCase().indexOf("microsoft")) {
                        try {
                            CollisionMap.aClass8_166 = new Class8_Sub2();
                            return;
                        } catch(Throwable throwable_1_) {
                            /* empty */
                        }
                    }
                    CollisionMap.aClass8_166 = new Class8(8000);
                }
            }

    }

    public static void method1042(int arg0) {

        int i = -77 % ((arg0 - 74) / 46);
            aClass1_1638 = null;
            aClass1_1639 = null;
            aBooleanArray1629 = null;
            aClass68_1631 = null;
            aClass15_1632 = null;
            aClass1_1636 = null;
            aClass9_1615 = null;
            aClass1_1640 = null;
            aClass1_1635 = null;
            aClass1_1628 = null;
            aClass1_1633 = null;

    }

    public static boolean method1043(int arg0, int arg1) {

        anInt1627++;
            if(aBooleanArray1629[arg0])
                return true;
            if(!Class40_Sub5_Sub4.aClass6_2349.method186(123, arg0))
                return false;
            int i = 51 / ((63 - arg1) / 63);
            int i_4_ = Class40_Sub5_Sub4.aClass6_2349.method190(arg0, (byte) 71);
            if(i_4_ == 0) {
                aBooleanArray1629[arg0] = true;
                return true;
            }
            if(Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0] == null)
                Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0] = new Class40_Sub5_Sub12[i_4_];
            for(int i_5_ = 0; (i_5_ ^ 0xffffffff) > (i_4_ ^ 0xffffffff); i_5_++) {
                if(Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0][i_5_] == null) {
                    byte[] is = Class40_Sub5_Sub4.aClass6_2349.method172(i_5_, 119, arg0);
                    if(is != null) {
                        Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0][i_5_] = new Class40_Sub5_Sub12();
                        Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0][i_5_].anInt2689 = (arg0 << 692667152) + i_5_;
                        if((is[0] ^ 0xffffffff) == 0)
                            Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0][i_5_].method644((byte) 73, new Buffer(is));
                        else
                            Class59.aClass40_Sub5_Sub12ArrayArray1390[arg0][i_5_].method637(new Buffer(is), -73);
                    }
                }
            }
            aBooleanArray1629[arg0] = true;
            return true;

    }

    public static Class40_Sub5_Sub12 method1045(int arg0, byte arg1) {

        anInt1626++;
            int i = arg0 >> 144471440;
            int i_8_ = 0xffff & arg0;
            if(Class59.aClass40_Sub5_Sub12ArrayArray1390[i] == null || (Class59.aClass40_Sub5_Sub12ArrayArray1390[i][i_8_] == null)) {
                boolean bool = method1043(i, 127);
                if(!bool)
                    return null;
            }
            if(arg1 >= -54)
                method1042(-90);
            return Class59.aClass40_Sub5_Sub12ArrayArray1390[i][i_8_];

    }

    public abstract void method1041(int i, int i_2_, Component component, int i_3_);

    public abstract void method1044(int i, int i_6_, Graphics graphics, int i_7_);

    public void method1046(byte arg0) {
        do {
                Rasterizer.method669(anIntArray1621, anInt1619, anInt1617);
                anInt1624++;
                if(arg0 == 90)
                    break;
                method1046((byte) 12);

            break;
        } while(false);
    }
}
