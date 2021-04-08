package com.jagex.runescape.scene;

import com.jagex.runescape.ProducingGraphicsBuffer;
import com.jagex.runescape.RSString;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.node.NodeQueue;

public class InteractiveObject {
    public static int menuOffsetX;
    public static ProducingGraphicsBuffer tabTop;
    public static int[] firstMenuOperand = new int[500];
    public static NodeQueue aNodeQueue_485 = new NodeQueue();
    public static int anInt487 = 0;
    public static CacheArchive aCacheArchive_488;
    public static byte[][][] aByteArrayArrayArray492;
    public static int playerRights = 0;
    public static boolean showFps = false;

    public int z;
    public int hash;
    public int config = 0;
    public Renderable renderable;
    public int worldX;
    public int worldY;
    public int worldZ;
    public int rotation;
    public int tileBottom;
    public int tileLeft;
    public int tileTop;
    public int tileRight;
    public int cycle;
    public int anInt491;

    public InteractiveObject() {
        hash = 0;
    }

    public static RSString readBytesToRSString(byte[] stream, int offset, int length) {
        RSString rsString = new RSString();
        rsString.length = 0;
        rsString.chars = new byte[length];
        for(int i = offset; length + offset > i; i++) {
            if(stream[i] != 0) {
                rsString.chars[rsString.length++] = stream[i];
            }
        }
        return rsString;
    }


}
