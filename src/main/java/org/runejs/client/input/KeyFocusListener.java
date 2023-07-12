package org.runejs.client.input;

import org.runejs.client.frame.console.Console;
import org.runejs.client.*;
import org.runejs.client.util.Signlink;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Method;

public class KeyFocusListener implements KeyListener, FocusListener {
    public static volatile int framesSinceKeyboardInput = 0;
    public static int[] anIntArray1564 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static int anInt2543 = 0;

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
            MovedStatics.crc8LookupTable[divident] = currentByte;
        }
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
        arg0.addKeyListener(Game.keyFocusListener);
        arg0.addFocusListener(Game.keyFocusListener);
    }

    public static void removeListeners(Component arg1) {
	    arg1.removeKeyListener(Game.keyFocusListener);
	    arg1.removeFocusListener(Game.keyFocusListener);
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

    public static void method997() {
        // (Jameskmonger) I think this is something to do with keycode remapping, though Im not sure
        if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") == -1) {
            anIntArray1564[44] = 71;
            anIntArray1564[45] = 26;
            anIntArray1564[46] = 72;
            anIntArray1564[47] = 73;
            anIntArray1564[59] = 57;
            anIntArray1564[61] = 27;
            anIntArray1564[91] = 42;
            anIntArray1564[92] = 74;
            anIntArray1564[93] = 43;
            if (Signlink.aMethod729 == null) {
                anIntArray1564[192] = 58;
                anIntArray1564[222] = 59;
            } else {
                anIntArray1564[192] = 28;
                anIntArray1564[222] = 58;
                anIntArray1564[520] = 59;
            }
        } else {
            anIntArray1564[186] = 57;
            anIntArray1564[187] = 27;
            anIntArray1564[188] = 71;
            anIntArray1564[189] = 26;
            anIntArray1564[190] = 72;
            anIntArray1564[191] = 73;
            anIntArray1564[192] = 58;
            anIntArray1564[219] = 42;
            anIntArray1564[220] = 74;
            anIntArray1564[221] = 43;
            anIntArray1564[222] = 59;
            anIntArray1564[223] = 28;
        }

    }

    public void keyTyped(KeyEvent arg0) {
        arg0.consume();
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if (Game.keyFocusListener != null) {
            anInt2543 = -1;
        }
    }

    public synchronized void keyPressed(KeyEvent keyEvent) {
        if (Game.keyFocusListener != null) {
            framesSinceKeyboardInput = 0;
            int obfuscatedKeyCode = keyEvent.getKeyCode();
            int eventKeyCode = keyEvent.getKeyCode();
            if (obfuscatedKeyCode >= 0 && anIntArray1564.length > obfuscatedKeyCode) {
                obfuscatedKeyCode = anIntArray1564[obfuscatedKeyCode];
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
            if (anInt2543 >= 0 && obfuscatedKeyCode >= 0) {
                MovedStatics.keyCodes[anInt2543] = obfuscatedKeyCode;
                anInt2543 = 0x7f & anInt2543 + 1;
                if (anInt2543 == MovedStatics.anInt2183) {
                    anInt2543 = -1;
                }
            }
            if (obfuscatedKeyCode >= 0 || keyChar >= 0) {
                int i_5_ = 0x7f & 1 + MovedStatics.anInt2598;
                if (MovedStatics.anInt1389 != i_5_) {
                    MovedStatics.anIntArray2113[MovedStatics.anInt2598] = obfuscatedKeyCode;
                    MovedStatics.anIntArray2764[MovedStatics.anInt2598] = keyChar;
                    MovedStatics.anInt2598 = i_5_;
                }
            }
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent arg0) {
        if (Game.keyFocusListener != null) {
            framesSinceKeyboardInput = 0;
            int i = arg0.getKeyCode();

            if (i < 0 || anIntArray1564.length <= i) {
                i = -1;
            } else {
                i = ~0x80 & anIntArray1564[i];
            }
            if (anInt2543 >= 0 && i >= 0) {
                MovedStatics.keyCodes[anInt2543] = i ^ 0xffffffff;
                anInt2543 = 0x7f & 1 + anInt2543;
                if (MovedStatics.anInt2183 == anInt2543) {
                    anInt2543 = -1;
                }
            }
        }
        arg0.consume();
    }
}
