package org.runejs.client.scene;

import org.runejs.client.ProducingGraphicsBuffer;
import org.runejs.client.RSString;
import org.runejs.client.media.renderable.Renderable;

public class InteractiveObject {
    public static int menuOffsetX;
    public static ProducingGraphicsBuffer tabTop;
    public static int[] firstMenuOperand = new int[500];
    public static int anInt487 = 0;
    public static byte[][][] tileShadowIntensity;
    public static int playerRights = 0;
    public static boolean showFps = false;

    public int z;
    public int hash;
    public int config = 0;
    public int worldY;
    public int tileLeft;
    public Renderable renderable;
    public int worldX;
    public int tileBottom;
    public int worldZ;
    public int rotation;
    public int tileTop;
    public int tileRight;
    public int cycle;
    public int anInt491;

    public InteractiveObject() {
        hash = 0;
    }

    public static RSString method279(byte[] arg0, int arg2, int arg3) {
        RSString class1 = new RSString();
        class1.length = 0;
        class1.chars = new byte[arg3];
        for(int i = arg2; arg3 + arg2 > i; i++) {
            if(arg0[i] != 0)
                class1.chars[class1.length++] = arg0[i];
        }
        return class1;
    }


}
