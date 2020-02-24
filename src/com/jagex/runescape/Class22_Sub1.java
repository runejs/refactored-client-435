package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.util.Signlink;

import java.awt.*;

public class Class22_Sub1 extends Class22 {
    public static int anInt1837;
    public static RSString aClass1_1838;
    public static int anInt1839;
    public static int anInt1840;
    public static long aLong1841;
    public static int anInt1842;
    public static int anInt1843;
    public static RSString[] aClass1Array1844 = new RSString[100];
    public static RSString aClass1_1845;
    public static int[] anIntArray1846;
    public static int[] anIntArray1847;
    public static RSString aClass1_1848 = RSString.CreateString("This computers address has been blocked");
    public static RSString aClass1_1849;
    public static int anInt1850;
    public static RSString aClass1_1851 = aClass1_1848;
    public static int anInt1853;
    public static int anInt1854;
    public static CacheIndex aCacheIndex_1855;
    public static int anInt1856;
    public static RSString aClass1_1857;
    public static RSString aClass1_1858;
    public static int anInt1859;
    public static RSString aClass1_1861;
    public static int anInt1862;
    public static RSString aClass1_1863;
    public static RSString aClass1_1864;
    public static RSString aClass1_1865;
    public static RSString aClass1_1867;
    public static RSString aClass1_1868;
    public static int anInt1869;
    public static RSString aClass1_1870;
    public static RSString aClass1_1871;
    public static RSString aClass1_1873;

    static {
        aClass1_1845 = RSString.CreateString("Enter your username (V password)3");
        aClass1_1849 = RSString.CreateString("welle:");
        aClass1_1857 = aClass1_1845;
        aClass1_1867 = RSString.CreateString("Loaded interfaces");
        aClass1_1838 = RSString.CreateString("T");
        aClass1_1863 = RSString.CreateString("Please wait 5 minutes before trying again)3");
        aClass1_1861 = RSString.CreateString("headicons_prayer");
        anIntArray1846 = new int[5];
        aClass1_1868 = RSString.CreateString("Report abuse");
        aClass1_1858 = aClass1_1867;
        aClass1_1870 = aClass1_1863;
        aClass1_1865 = aClass1_1868;
        aClass1_1873 = RSString.CreateString("Password: ");
        aClass1_1864 = aClass1_1873;
        aClass1_1871 = RSString.CreateString("Verbindung abgebrochen)3");
        anIntArray1847 = new int[2000];
    }

    public boolean aBoolean1835;
    public Class15 aClass15_1836;
    public boolean aBoolean1852;
    public int anInt1860;
    public byte[] aByteArray1866;
    public Signlink aClass31_1872;

    public Class22_Sub1(Signlink arg0) {

        aClass31_1872 = arg0;

    }

    public static void method310(int arg0) {
        aClass1_1858 = null;
        aClass1_1861 = null;
        aClass1_1848 = null;
        anIntArray1846 = null;
        aClass1_1868 = null;
        aClass1_1863 = null;
        anIntArray1847 = null;
        aClass1_1851 = null;
        aClass1_1870 = null;
        aClass1_1864 = null;
        aClass1_1871 = null;
        aClass1_1867 = null;
        aClass1_1873 = null;
        aClass1_1838 = null;
        aClass1_1857 = null;
        aClass1_1865 = null;
        aClass1_1845 = null;
        aClass1Array1844 = null;
        aClass1_1849 = null;
        aCacheIndex_1855 = null;
        if(arg0 <= 56)
            anInt1856 = 74;
    }

    public static void method311(byte arg0, Component arg1) {

        anInt1854++;
        arg1.removeKeyListener(Class59.aClass54_1392);
        arg1.removeFocusListener(Class59.aClass54_1392);
        int i = -46 % ((75 - arg0) / 35);

    }

    public static void method312(int arg0, int arg1, int arg2, int arg3) {

        anInt1859++;
        if((arg2 ^ 0xffffffff) > -129 || (arg1 ^ 0xffffffff) > -129 || arg2 > 13056 || arg1 > 13056) {
            Class44.anInt1048 = -1;
            ISAAC.anInt522 = -1;
        } else {
            int i = Class37.method430((byte) -122, Player.anInt3267, arg2, arg1) + -arg0;
            arg1 -= Class40_Sub5_Sub6.cameraY;
            i -= Class32.cameraZ;
            int i_1_ = Model.COSINE[Class26.anInt627];
            int i_2_ = Model.SINE[Class26.anInt627];
            arg2 -= Class12.cameraX;
            int i_3_ = (Model.SINE[Class68_Sub1.anInt2210]);
            int i_4_ = (Model.COSINE[Class68_Sub1.anInt2210]);
            int i_5_ = arg1 * i_3_ + arg2 * i_4_ >> -1348635568;
            arg1 = i_4_ * arg1 - arg2 * i_3_ >> 1869723344;
            if(arg3 != 4976905)
                aClass1_1864 = null;
            arg2 = i_5_;
            i_5_ = i * i_1_ - arg1 * i_2_ >> -205760432;
            arg1 = arg1 * i_1_ + i * i_2_ >> 782060560;
            i = i_5_;
            if((arg1 ^ 0xffffffff) > -51) {
                Class44.anInt1048 = -1;
                ISAAC.anInt522 = -1;
            } else {
                ISAAC.anInt522 = 256 + (arg2 << -1849635095) / arg1;
                Class44.anInt1048 = (i << 4976905) / arg1 + 167;
            }
        }

    }

    public static void method313(int arg0) {

        anInt1842++;
        for(int i = -1; Class60.anInt1407 > i; i++) {
            int i_6_;
            if((i ^ 0xffffffff) == 0)
                i_6_ = 2047;
            else
                i_6_ = Class57.anIntArray1334[i];
            Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_6_]);
            if(class40_sub5_sub17_sub4_sub1 != null && ((class40_sub5_sub17_sub4_sub1.anInt3078 ^ 0xffffffff) < -1)) {
                class40_sub5_sub17_sub4_sub1.anInt3078--;
                if((class40_sub5_sub17_sub4_sub1.anInt3078 ^ 0xffffffff) == -1)
                    class40_sub5_sub17_sub4_sub1.forcedChatMessage = null;
            }
        }
        int i = 18 % ((-46 - arg0) / 58);
        for(int i_7_ = 0; i_7_ < GameObjectDefinition.anInt2558; i_7_++) {
            int i_8_ = Class40_Sub3.anIntArray2016[i_7_];
            Npc class40_sub5_sub17_sub4_sub2 = CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_8_];
            if(class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.anInt3078 > 0) {
                class40_sub5_sub17_sub4_sub2.anInt3078--;
                if((class40_sub5_sub17_sub4_sub2.anInt3078 ^ 0xffffffff) == -1)
                    class40_sub5_sub17_sub4_sub2.forcedChatMessage = null;
            }
        }

    }

    public void method301(int arg0, int arg1) {

        if(arg1 != 0)
            aClass1_1848 = null;
        anInt1862++;

    }

    public void method303(byte arg0) {

        anInt1839++;
        if(aBoolean1835) {
            try {
                Class28.method369(aClass31_1872.anApplet740, "midibox.src=\"c:/silence.mid\";", arg0 ^ 0x6f0f);
            } catch(Throwable throwable) {
                /* empty */
            }
            aBoolean1835 = false;
        }
        if(arg0 == -96)
            aClass15_1836 = null;

    }

    public void method302(int arg0) {
        anInt1853++;
        if(aClass15_1836 != null && (aClass15_1836.anInt434 ^ 0xffffffff) != -1) {
            if((aClass15_1836.anInt434 ^ 0xffffffff) == -2) {
                Class47 class47 = (Class47) aClass15_1836.anObject437;
                try {
                    class47.method918(aByteArray1866, 0, aByteArray1866.length, false);
                    class47.method917(1);
                    try {
                        Class28.method369(aClass31_1872.anApplet740, ("midibox.loop=" + (!aBoolean1852 ? "0" : "\"infinite\"") + "; midibox.src=\"" + class47.method915(false).getPath().replace('\\', '/') + "\"; midibox.volume=" + anInt1860 + ";"), -28497);
                        aBoolean1835 = true;
                    } catch(Throwable throwable) {
                        /* empty */
                    }
                } catch(Exception exception) {
                    try {
                        class47.method917(1);
                    } catch(Exception exception_0_) {
                        /* empty */
                    }
                }
            }
            aClass15_1836 = null;
            if(arg0 != 0)
                aCacheIndex_1855 = null;
        }
    }

    public void method306(byte arg0) {
        anInt1837++;
        if(arg0 < 100)
            aClass1_1861 = null;
    }

    public void method304(byte arg0, int arg1, int arg2) {
        if(arg1 == 0)
            arg1 = 1;
        if(arg0 > -82)
            method306((byte) 27);
        anInt1840++;
        int i = Class29.method372(120, arg1) + -arg2;
        if(aClass15_1836 != null)
            anInt1860 = i;
        else {
            do {
                if(aBoolean1835) {
                    try {
                        Class28.method369(aClass31_1872.anApplet740, "midibox.volume=" + i + ";", -28497);
                    } catch(Throwable throwable) {
                        break;
                    }
                    break;
                }
            } while(false);
        }
    }

    public void method300(byte[] arg0, boolean arg1, int arg2, int arg3) {

        aClass15_1836 = aClass31_1872.method396(86);
        anInt1843++;
        if(arg2 == -15910 && aClass15_1836 != null) {
            if((arg3 ^ 0xffffffff) == -1)
                arg3 = 1;
            anInt1860 = Class29.method372(arg2 ^ ~0x3e59, arg3);
            aByteArray1866 = arg0;
            aBoolean1852 = arg1;
        }

    }
}
