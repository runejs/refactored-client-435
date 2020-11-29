package com.jagex.runescape.input;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyFocusListener implements KeyListener, FocusListener {
    public static LinkedList aLinkedList_1278 = new LinkedList();
    public static int[] anIntArray1282 = new int[256];
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1285;

    static {
        for (int i = 0; i < 256; i++) {
            int i_6_ = i;
            for (int i_7_ = 0; i_7_ < 8; i_7_++) {
                if ((i_6_ & 0x1) != 1) {
                    i_6_ >>>= 1;
                } else {
                    i_6_ = ~0x12477cdf ^ i_6_ >>> 1;
                }
            }
            anIntArray1282[i] = i_6_;
        }
    }

    public static void draw3dScreen() {
        Wall.renderSplitPrivateMessages();
        if (LinkedList.crossType == 1) {
            Class37.cursorCross[OverlayDefinition.crossIndex / 100].drawImage(Class40_Sub11.crossX - 8 - 4, ClientScript.crossY - 8 - 4);
        }
        if (LinkedList.crossType == 2) {
            Class37.cursorCross[4 + OverlayDefinition.crossIndex / 100].drawImage(Class40_Sub11.crossX - 8 - 4, ClientScript.crossY - 8 - 4);
        }
        if (GroundItemTile.walkableWidgetId != -1) {
            Renderable.handleSequences(GroundItemTile.walkableWidgetId);
            Class40_Sub5_Sub6.drawInterface(0, GroundItemTile.walkableWidgetId, 334, (byte) -5, 0, 4, 512);
        }
        if (GameInterface.gameScreenInterfaceId != -1) {
            Renderable.handleSequences(GameInterface.gameScreenInterfaceId);
            Class40_Sub5_Sub6.drawInterface(0, GameInterface.gameScreenInterfaceId, 334, (byte) -5, 0, 0, 512);
        }
        Class65.method1018();
        Player.setTutorialIslandFlag();
        if (!Class4.menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else  {
            if(ScreenController.frameMode == ScreenMode.FIXED && Class40_Sub5_Sub17_Sub1.menuScreenArea == 0){
                Class40_Sub5_Sub6.drawMenu(4,4);
            }
        }
        if (Class40_Sub6.anInt2118 == 1) {
            LinkedList.aClass40_Sub5_Sub14_Sub4_1057.drawImage(472, 296);
        }
        if (InteractiveObject.showFps) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.frameWidth - 220;
            }

                int colour = 0xffff00;
            if (GenericTile.fps < 30 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (GenericTile.fps < 20 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            WallDecoration.fontNormal.drawStringRight("Fps: " + GenericTile.fps, x, y, colour);
            colour = 0xffff00;
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int memoryUsed = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            if (memoryUsed > 32768 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (memoryUsed < 65536 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            WallDecoration.fontNormal.drawStringRight("Mem: " + memoryUsed + "k", x, y, colour);
            y += 15;
            if (MovedStatics.aBoolean893) {
                WallDecoration.fontNormal.drawStringRight(English.sidePanelRedrawn, x, y, 16711680);
                y += 15;
                MovedStatics.aBoolean893 = false;
            }
            if (CacheIndex.aBoolean260) {
                WallDecoration.fontNormal.drawStringRight(English.chatPanelRedrawn, x, y, 16711680);
                y += 15;
                CacheIndex.aBoolean260 = false;
            }
            if (Class40_Sub3.aBoolean2026) {
                WallDecoration.fontNormal.drawStringRight(English.iconsRedrawn, x, y, 16711680);
                Class40_Sub3.aBoolean2026 = false;
                y += 15;
            }
        }
        if (Class40_Sub5_Sub15.systemUpdateTime != 0) {
            int seconds = Class40_Sub5_Sub15.systemUpdateTime / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if (seconds < 10) {
                WallDecoration.fontNormal.drawString(English.systemUpdateIn + minutes + Native.prefixColonZero + seconds, 4, 329, 16776960);
            } else {
                WallDecoration.fontNormal.drawString(English.systemUpdateIn + minutes + Native.char_colon + seconds, 4, 329, 16776960);
            }
        }
    }

    public static int method955(CacheIndex arg0) {
        int i = 0;
        if (arg0.method194(Native.aClass1_638, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.chatback, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1113, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1395, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_256, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_338, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackleft1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1024, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_281, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1266, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1788, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1374, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_2588, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_196, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_304, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_2093, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_3254, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1517, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_2787, Native.aClass1_305)) {
            i++;
        }
        return i;

    }

    public static String method956(int arg0, Buffer arg1) {
        if (arg0 < 62) {
            aLinkedList_1278 = null;
        }
        return Class22.method307(arg1, -1, 32767);
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
            Class49.anInt1147 = 0;
            int obfuscatedKeyCode = keyEvent.getKeyCode();
            int eventKeyCode = keyEvent.getKeyCode();
            if (obfuscatedKeyCode >= 0 && HuffmanEncoding.anIntArray1564.length > obfuscatedKeyCode) {
                obfuscatedKeyCode = HuffmanEncoding.anIntArray1564[obfuscatedKeyCode];
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
                keyChar = Class51.getKeyChar(keyEvent);
            }
            if (eventKeyCode == 192 || eventKeyCode == 129) {
                Console.console.consoleOpen = !Console.console.consoleOpen;
            }
            if (GameObjectDefinition.anInt2543 >= 0 && obfuscatedKeyCode >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = obfuscatedKeyCode;
                GameObjectDefinition.anInt2543 = 0x7f & GameObjectDefinition.anInt2543 + 1;
                if (GameObjectDefinition.anInt2543 == FramemapDefinition.anInt2183) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
            if (obfuscatedKeyCode >= 0 || keyChar >= 0) {
                int i_5_ = 0x7f & 1 + IdentityKit.anInt2598;
                if (Class59.anInt1389 != i_5_) {
                    Class40_Sub6.anIntArray2113[IdentityKit.anInt2598] = obfuscatedKeyCode;
                    Class40_Sub5_Sub13.anIntArray2764[IdentityKit.anInt2598] = keyChar;
                    IdentityKit.anInt2598 = i_5_;
                }
            }
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent arg0) {
        if (Class59.keyFocusListener != null) {
            Class49.anInt1147 = 0;
            int i = arg0.getKeyCode();

            if (i < 0 || HuffmanEncoding.anIntArray1564.length <= i) {
                i = -1;
            } else {
                i = ~0x80 & HuffmanEncoding.anIntArray1564[i];
            }
            if (GameObjectDefinition.anInt2543 >= 0 && i >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = i ^ 0xffffffff;
                GameObjectDefinition.anInt2543 = 0x7f & 1 + GameObjectDefinition.anInt2543;
                if (FramemapDefinition.anInt2183 == GameObjectDefinition.anInt2543) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
        }
        arg0.consume();
    }
}
