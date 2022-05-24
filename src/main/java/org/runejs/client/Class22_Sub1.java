package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;

import java.awt.*;

public class Class22_Sub1 extends Class22 {
    public static long aLong1841;
    public static int[] anIntArray1846 = new int[5];
    public static int[] anIntArray1847 = new int[2000];
    public static CacheArchive musicCacheArchive;
    public static int anInt1856;

    public boolean aBoolean1835;
    public SignlinkNode aSignlinkNode_1836;
    public boolean aBoolean1852;
    public int anInt1860;
    public byte[] aByteArray1866;
    public Signlink aClass31_1872;

    public Class22_Sub1(Signlink arg0) {
        aClass31_1872 = arg0;
    }

    public static void method311(Component arg1) {
        arg1.removeKeyListener(Class59.keyFocusListener);
        arg1.removeFocusListener(Class59.keyFocusListener);
    }

    public static void method312(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 < 128 || arg1 < 128 || arg2 > 13056 || arg1 > 13056) {
            Class44.anInt1048 = -1;
            ISAAC.anInt522 = -1;
        } else {
            int i = Class37.getFloorDrawHeight(Player.worldLevel, arg2, arg1) + -arg0;
            arg1 -= MovedStatics.cameraY;
            i -= SceneCluster.cameraZ;
            int i_1_ = Model.COSINE[Class26.anInt627];
            int i_2_ = Model.SINE[Class26.anInt627];
            arg2 -= Class12.cameraX;
            int i_3_ = Model.SINE[ProducingGraphicsBuffer_Sub1.anInt2210];
            int i_4_ = Model.COSINE[ProducingGraphicsBuffer_Sub1.anInt2210];
            int i_5_ = arg1 * i_3_ + arg2 * i_4_ >> 16;
            arg1 = i_4_ * arg1 - arg2 * i_3_ >> 16;
            if(arg3 != 4976905)
                English.password = null;
            arg2 = i_5_;
            i_5_ = i * i_1_ - arg1 * i_2_ >> 16;
            arg1 = arg1 * i_1_ + i * i_2_ >> 16;
            i = i_5_;
            if(arg1 < 50) {
                Class44.anInt1048 = -1;
                ISAAC.anInt522 = -1;
            } else {
                if(ScreenController.frameMode == ScreenMode.FIXED){
                    ISAAC.anInt522 = 256 + (arg2 << 9) / arg1;
                    Class44.anInt1048 = (i << 9) / arg1 + 167;
                } else {
                    ISAAC.anInt522 = ScreenController.drawWidth/2 + (arg2 << 9) / arg1;
                    Class44.anInt1048 = (i << 9) / arg1 +  ScreenController.drawHeight/2;
                }

            }
        }
    }

    public static void method313() {
        for(int i = -1; Player.localPlayerCount > i; i++) {
            int i_6_;
            if(i == -1)
                i_6_ = 2047;
            else
                i_6_ = Player.trackedPlayerIndices[i];
            Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_6_];
            if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.anInt3078 > 0) {
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
    }

    public void method303(byte arg0) {
        if(aBoolean1835) {
            try {
//                Class28.method369(aClass31_1872.anApplet740, "midibox.src=\"c:/silence.mid\";", arg0 ^ 0x6f0f);
            } catch(Throwable throwable) {
                /* empty */
            }
            aBoolean1835 = false;
        }
        if(arg0 == -96)
            aSignlinkNode_1836 = null;
    }

    public void method302(int arg0) {
        if(aSignlinkNode_1836 != null && aSignlinkNode_1836.status != 0) {
            if(aSignlinkNode_1836.status == 1) {
                SizedAccessFile sizedAccessFile = (SizedAccessFile) aSignlinkNode_1836.value;
                try {
                    sizedAccessFile.write(aByteArray1866, 0, aByteArray1866.length);
                    sizedAccessFile.close();
                    try {
//                        Class28.method369(aClass31_1872.anApplet740, ("midibox.loop=" + (!aBoolean1852 ? "0" : "\"infinite\"") + "; midibox.src=\"" + class47.method915().getPath().replace('\\', '/') + "\"; midibox.volume=" + anInt1860 + ";"), -28497);
                        aBoolean1835 = true;
                    } catch(Throwable throwable) {
                        /* empty */
                    }
                } catch(Exception exception) {
                    try {
                        sizedAccessFile.close();
                    } catch(Exception exception_0_) {
                        /* empty */
                    }
                }
            }
            aSignlinkNode_1836 = null;
            if(arg0 != 0)
                musicCacheArchive = null;
        }
    }

    public void method306(byte arg0) {
        if(arg0 < 100)
            Native.headiconsPrayer = null;
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
//                        Class28.method369(aClass31_1872.anApplet740, "midibox.volume=" + i + ";", -28497);
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
