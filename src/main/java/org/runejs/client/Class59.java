package org.runejs.client;

import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
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
    public static int[] blendedSaturation;

    static {
        secondMenuOperand = new int[500];
        friends = new long[200];
        keyFocusListener = new KeyFocusListener();
    }

    public static void dropClient() {
        if(SceneCluster.idleLogout > 0) {
            // Instant logout
            MovedStatics.logout();
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

    public static int getVisibilityPlaneFor(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 != 0)
            getVisibilityPlaneFor(-73, 123, 115, 98);
        if((OverlayDefinition.tile_flags[arg0][arg3][arg1] & 0x8) != 0)
            return 0;
        if(arg0 > 0 && (OverlayDefinition.tile_flags[1][arg3][arg1] & 0x2) != 0)
            return -1 + arg0;
        return arg0;
    }
}
