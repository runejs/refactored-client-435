package org.runejs.client;

import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCluster;

public class Class59 {
    public static int anInt1386;
    public static IndexedImage imgLoginScreenButton;
    public static int anInt1388;
    public static int anInt1389 = 0;
    public static KeyFocusListener keyFocusListener;
    public static int[] secondMenuOperand;
    public static long[] friends;

    static {
        secondMenuOperand = new int[500];
        friends = new long[200];
        keyFocusListener = new KeyFocusListener();
    }

    public static void dropClient() {
        if(SceneCluster.idleLogout > 0) {
            // Instant logout
            Class48.logout();
        } else {
            // Connection lost
            MovedStatics.processGameStatus(40);
            PlayerAppearance.lostConnectionSocket = MovedStatics.gameServerSocket;
            MovedStatics.gameServerSocket = null;
        }
    }

    public static void setLowMemory() {
        Scene.lowMemory = true;
        VertexNormal.lowMemory = true;
    }

    public static void method984(int arg0) {
        if(arg0 == 0) {
            if(MovedStatics.aClass22_189 != null) {
                if(MouseHandler.anInt1450 >= 0) {
                    if(RSCanvas.anInt54 > 0) {
                        Class39.anInt909 += Buffer.anInt1982;
                        MovedStatics.aClass22_189.method304((byte) -97, MouseHandler.anInt1450, Class39.anInt909);
                        RSCanvas.anInt54--;
                        if(RSCanvas.anInt54 == 0) {
                            MovedStatics.aClass22_189.method303((byte) -96);
                            MouseHandler.anInt1450 = -1;
                            RSCanvas.anInt54 = 20;
                        }
                    }
                } else if(RSCanvas.anInt54 > 0) {
                    RSCanvas.anInt54--;
                    if(RSCanvas.anInt54 == 0) {
                        if(Player.aByteArray3270 == null)
                            MovedStatics.aClass22_189.method301(256, 0);
                        else {
                            MovedStatics.aClass22_189.method301(PacketBuffer.anInt2258, arg0);
                            MouseHandler.anInt1450 = PacketBuffer.anInt2258;
                            MovedStatics.aClass22_189.method300(Player.aByteArray3270, PlayerAppearance.aBoolean687, -15910, PacketBuffer.anInt2258);
                            Player.aByteArray3270 = null;
                        }
                        Class39.anInt909 = 0;
                    }
                }
                MovedStatics.aClass22_189.method302(0);
            }
        }
    }


    public static int getVisibilityPlaneFor(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 != 0)
            getVisibilityPlaneFor(-73, 123, 115, 98);
        if((Scene.tileFlags[arg0][arg3][arg1] & 0x8) != 0)
            return 0;
        if(arg0 > 0 && (Scene.tileFlags[1][arg3][arg1] & 0x2) != 0)
            return -1 + arg0;
        return arg0;
    }
}
