package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.awt.*;

public class Class22_Sub1 extends Class22 {
    public static RSString aClass1_1838;
    public static long aLong1841;
    public static RSString[] itemSearchResultNames = new RSString[100];
    public static RSString aClass1_1845;
    public static int[] anIntArray1846;
    public static int[] anIntArray1847;
    public static RSString aClass1_1848 = RSString.CreateString("This computers address has been blocked");
    public static RSString aClass1_1849;
    public static RSString aClass1_1851 = aClass1_1848;
    public static CacheIndex aCacheIndex_1855;
    public static int anInt1856;
    public static RSString aClass1_1857;
    public static RSString aClass1_1858;
    public static RSString aClass1_1861;
    public static RSString aClass1_1863;
    public static RSString aClass1_1864;
    public static RSString aClass1_1865;
    public static RSString aClass1_1867;
    public static RSString aClass1_1868;
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
    public SignlinkNode aSignlinkNode_1836;
    public boolean aBoolean1852;
    public int anInt1860;
    public byte[] aByteArray1866;
    public Signlink aClass31_1872;

    public Class22_Sub1(Signlink arg0) {

        aClass31_1872 = arg0;

    }

    public static void method310() {
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
        itemSearchResultNames = null;
        aClass1_1849 = null;
        aCacheIndex_1855 = null;
    }

    public static void method311(byte arg0, Component arg1) {
        arg1.removeKeyListener(Class59.keyFocusListener);
        arg1.removeFocusListener(Class59.keyFocusListener);
    }

    public static void method312(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 < 128 || arg1 < 128 || arg2 > 13056 || arg1 > 13056) {
            Class44.anInt1048 = -1;
            ISAAC.anInt522 = -1;
        } else {
            int i = Class37.getFloorDrawHeight(Player.worldLevel, arg2, arg1) + -arg0;
            arg1 -= Class40_Sub5_Sub6.cameraY;
            i -= SceneCluster.cameraZ;
            int i_1_ = Model.COSINE[Class26.anInt627];
            int i_2_ = Model.SINE[Class26.anInt627];
            arg2 -= Class12.cameraX;
            int i_3_ = (Model.SINE[Class68_Sub1.anInt2210]);
            int i_4_ = (Model.COSINE[Class68_Sub1.anInt2210]);
            int i_5_ = arg1 * i_3_ + arg2 * i_4_ >> 16;
            arg1 = i_4_ * arg1 - arg2 * i_3_ >> 16;
            if(arg3 != 4976905)
                aClass1_1864 = null;
            arg2 = i_5_;
            i_5_ = i * i_1_ - arg1 * i_2_ >> 16;
            arg1 = arg1 * i_1_ + i * i_2_ >> 16;
            i = i_5_;
            if(arg1 < 50) {
                Class44.anInt1048 = -1;
                ISAAC.anInt522 = -1;
            } else {
                ISAAC.anInt522 = 256 + (arg2 << 9) / arg1;
                Class44.anInt1048 = (i << 9) / arg1 + 167;
            }
        }
    }

    public static void method313(int arg0) {
        for(int i = -1; Player.localPlayerCount > i; i++) {
            int i_6_;
            if(i == -1)
                i_6_ = 2047;
            else
                i_6_ = Player.trackedPlayerIndices[i];
            Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_6_]);
            if(class40_sub5_sub17_sub4_sub1 != null && (class40_sub5_sub17_sub4_sub1.anInt3078 > 0)) {
                class40_sub5_sub17_sub4_sub1.anInt3078--;
                if(class40_sub5_sub17_sub4_sub1.anInt3078 == 0)
                    class40_sub5_sub17_sub4_sub1.forcedChatMessage = null;
            }
        }
        for(int i_7_ = 0; i_7_ < Player.npcCount; i_7_++) {
            int i_8_ = Player.npcIds[i_7_];
            Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_8_];
            if(class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.anInt3078 > 0) {
                class40_sub5_sub17_sub4_sub2.anInt3078--;
                if(class40_sub5_sub17_sub4_sub2.anInt3078 == 0)
                    class40_sub5_sub17_sub4_sub2.forcedChatMessage = null;
            }
        }
    }

    public void method301(int arg0, int arg1) {
        if(arg1 != 0)
            aClass1_1848 = null;
    }

    public void method303(byte arg0) {
        if(aBoolean1835) {
            try {
                Class28.method369(aClass31_1872.anApplet740, "midibox.src=\"c:/silence.mid\";", arg0 ^ 0x6f0f);
            } catch(Throwable throwable) {
                /* empty */
            }
            aBoolean1835 = false;
        }
        if(arg0 == -96)
            aSignlinkNode_1836 = null;
    }

    public void method302(int arg0) {
        if(aSignlinkNode_1836 != null && aSignlinkNode_1836.anInt434 != 0) {
            if(aSignlinkNode_1836.anInt434 == 1) {
                Class47 class47 = (Class47) aSignlinkNode_1836.value;
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
            aSignlinkNode_1836 = null;
            if(arg0 != 0)
                aCacheIndex_1855 = null;
        }
    }

    public void method306(byte arg0) {
        if(arg0 < 100)
            aClass1_1861 = null;
    }

    public void method304(byte arg0, int arg1, int arg2) {
        if(arg1 == 0)
            arg1 = 1;
        if(arg0 > -82)
            method306((byte) 27);
        int i = Class29.method372(120, arg1) + -arg2;
        if(aSignlinkNode_1836 == null) {
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
        } else
            anInt1860 = i;
    }

    public void method300(byte[] arg0, boolean arg1, int arg2, int arg3) {
        aSignlinkNode_1836 = aClass31_1872.method396(86);
        if(arg2 == -15910 && aSignlinkNode_1836 != null) {
            if(arg3 == 0)
                arg3 = 1;
            anInt1860 = Class29.method372(arg2 ^ ~0x3e59, arg3);
            aByteArray1866 = arg0;
            aBoolean1852 = arg1;
        }
    }
}
