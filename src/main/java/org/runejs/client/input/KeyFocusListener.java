package org.runejs.client.input;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.frame.console.Console;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.Native;
import org.runejs.client.*;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.util.Signlink;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Method;

public class KeyFocusListener implements KeyListener, FocusListener {
    public static LinkedList aLinkedList_1278 = new LinkedList();
    public static int[] crc8LookupTable = new int[256];
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1285;
    public static volatile int framesSinceKeyboardInput = 0;

    static {
        for (int divident = 0; divident < 256; divident++) {
            int currentByte = divident;
            for (int bit = 0; bit < 8; bit++) {
                if ((currentByte & 0x1) != 1) {
                    currentByte >>>= 1;
                } else {
                    currentByte = -306674912 ^ currentByte >>> 1;
                }
            }
            crc8LookupTable[divident] = currentByte;
        }
    }

    public static int method955(CacheArchive arg0) {
        int i = 0;
        if (arg0.method194(Native.invback, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.chatback, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.mapBack, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackbase1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackbase2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackhmid1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackleft1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackleft2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackright1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackright2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBacktop1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackvmid1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackvmid2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackvmid3, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackhmid2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.redstone1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.redstone2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.redstone3, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.sideIcons, Native.aClass1_305)) {
            i++;
        }
        return i;

    }

    public static String method956(Buffer arg1) {
        return MovedStatics.method307(arg1, -1, 32767);
    }

    public static void addListeners(Component arg0) {
        Method method = Signlink.aMethod729;
        if(method != null) {
            try {
                method.invoke(arg0, Boolean.FALSE);
            } catch(Throwable throwable) {
                /* empty */
            }
        }
        arg0.addKeyListener(Class59.keyFocusListener);
        arg0.addFocusListener(Class59.keyFocusListener);
    }

    public static void removeListeners(Component arg1) {
	    arg1.removeKeyListener(Class59.keyFocusListener);
	    arg1.removeFocusListener(Class59.keyFocusListener);
	}

    public static int resetFramesSinceKeyboardInput() {
        return framesSinceKeyboardInput++;
    }

    public static int getKeyChar(KeyEvent arg1) {
        int keyChar = arg1.getKeyChar();
        if(keyChar <= 0 || keyChar >= 256)
            keyChar = -1;
        return keyChar;
    }

    public void keyTyped(KeyEvent arg0) {
        arg0.consume();
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if (Class59.keyFocusListener != null) {
            GameObjectDefinition.anInt2543 = -1;
        }
    }

    public synchronized void keyPressed(KeyEvent keyEvent) {
        if (Class59.keyFocusListener != null) {
            framesSinceKeyboardInput = 0;
            int obfuscatedKeyCode = keyEvent.getKeyCode();
            int eventKeyCode = keyEvent.getKeyCode();
            if (obfuscatedKeyCode >= 0 && MovedStatics.anIntArray1564.length > obfuscatedKeyCode) {
                obfuscatedKeyCode = MovedStatics.anIntArray1564[obfuscatedKeyCode];
                if ((0x80 & obfuscatedKeyCode) != 0) {
                    obfuscatedKeyCode = -1;
                }
            } else {
                obfuscatedKeyCode = -1;
            }
            int keyChar;
//            for (int i = 0; i < HuffmanEncoding.anIntArray1564.length; i++) {
//                System.out.println("In: " + i + ", out: " + HuffmanEncoding.anIntArray1564[i]);
//            }

            if (eventKeyCode == KeyEvent.VK_BACK_SPACE || eventKeyCode == KeyEvent.VK_TAB || eventKeyCode == 0xA /* Unused key */ || eventKeyCode == KeyEvent.VK_ESCAPE || eventKeyCode == KeyEvent.VK_DELETE) {
                keyChar = -1;
            } else {
                keyChar = getKeyChar(keyEvent);
            }
            if (eventKeyCode == 192 || eventKeyCode == 129) {
                Console.console.consoleOpen = !Console.console.consoleOpen;
            }
            if (GameObjectDefinition.anInt2543 >= 0 && obfuscatedKeyCode >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = obfuscatedKeyCode;
                GameObjectDefinition.anInt2543 = 0x7f & GameObjectDefinition.anInt2543 + 1;
                if (GameObjectDefinition.anInt2543 == MovedStatics.anInt2183) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
            if (obfuscatedKeyCode >= 0 || keyChar >= 0) {
                int i_5_ = 0x7f & 1 + MovedStatics.anInt2598;
                if (Class59.anInt1389 != i_5_) {
                    MovedStatics.anIntArray2113[MovedStatics.anInt2598] = obfuscatedKeyCode;
                    MovedStatics.anIntArray2764[MovedStatics.anInt2598] = keyChar;
                    MovedStatics.anInt2598 = i_5_;
                }
            }
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent arg0) {
        if (Class59.keyFocusListener != null) {
            framesSinceKeyboardInput = 0;
            int i = arg0.getKeyCode();

            if (i < 0 || MovedStatics.anIntArray1564.length <= i) {
                i = -1;
            } else {
                i = ~0x80 & MovedStatics.anIntArray1564[i];
            }
            if (GameObjectDefinition.anInt2543 >= 0 && i >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = i ^ 0xffffffff;
                GameObjectDefinition.anInt2543 = 0x7f & 1 + GameObjectDefinition.anInt2543;
                if (MovedStatics.anInt2183 == GameObjectDefinition.anInt2543) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
        }
        arg0.consume();
    }
}
