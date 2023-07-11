package org.runejs.client;

import java.awt.event.KeyEvent;

public class Class51 {
    public static int anInt1195 = 0;
    public static int gameStatusCode = 0;
    public static int[] anIntArray1198;
    public static int regionX;
    public static int anInt1205 = -1;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1206;

    public static int getKeyChar(KeyEvent arg1) {
        int keyChar = arg1.getKeyChar();
        if(keyChar <= 0 || keyChar >= 256)
            keyChar = -1;
        return keyChar;
    }


    public static void clearModelCache() {
        MovedStatics.modelCache.clear();
    }
}
