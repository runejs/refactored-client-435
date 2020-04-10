package com.jagex.runescape.input;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Renderable;
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
    public static RSString aClass1_1283 = RSString.CreateString("@yel@");
    public static RSString aClass1_1284 = RSString.CreateString("compass");
    public static Class68 aClass68_1285;

    static {
        for(int i = 0; i < 256; i++) {
            int i_6_ = i;
            for(int i_7_ = 0; i_7_ < 8; i_7_++) {
                if((i_6_ & 0x1) != 1) {
                    i_6_ >>>= 1;
                } else {
                    i_6_ = ~0x12477cdf ^ i_6_ >>> 1;
                }
            }
            anIntArray1282[i] = i_6_;
        }
    }

    public static void method953() {
        aClass1_1283 = null;
        aClass68_1285 = null;
        aLinkedList_1278 = null;
        anIntArray1282 = null;
        aClass1_1284 = null;
    }

    public static void draw3dScreen() {
        Wall.renderSplitPrivateMessages();
        if(LinkedList.crossType == 1) {
            Class37.cursorCross[OverlayDefinition.crossIndex / 100].drawImage(Class40_Sub11.crossX - 8 - 4, Class40_Sub5_Sub1.crossY - 8 - 4);
        }
        if(LinkedList.crossType == 2) {
            Class37.cursorCross[4 + OverlayDefinition.crossIndex / 100].drawImage(Class40_Sub11.crossX - 8 - 4, Class40_Sub5_Sub1.crossY - 8 - 4);
        }
        if(GroundItemTile.walkableWidgetId != -1) {
            Renderable.handleSequences(GroundItemTile.walkableWidgetId);
            Class40_Sub5_Sub6.drawInterface(0, GroundItemTile.walkableWidgetId, 334, (byte) -5, 0, 4, 512);
        }
        if(HuffmanEncoding.openScreenWidgetId != -1) {
            Renderable.handleSequences(HuffmanEncoding.openScreenWidgetId);
            Class40_Sub5_Sub6.drawInterface(0, HuffmanEncoding.openScreenWidgetId, 334, (byte) -5, 0, 0, 512);
        }
        RSString.setTutorialIslandFlag();
        if(!Class4.menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
            Class40_Sub5_Sub6.drawMenu();
        }
        if(Class40_Sub6.anInt2118 == 1) {
            LinkedList.aClass40_Sub5_Sub14_Sub4_1057.drawImage(472, 296);
        }
        if(InteractiveObject.showFps) {
            int y = 20;
            int x = 507;
            int colour = 0xffff00;
            if(GenericTile.fps < 30 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if(GenericTile.fps < 20 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            //                Class53.fontNormal.method687((Class40_Sub5_Sub17_Sub6.method832(-88, new RSString[]{Class61.aClass1_1446, HashTable.method334(Class52.fps, -1)})), x, y, colour);
            WallDecoration.fontNormal.drawStringRight("Fps: " + GenericTile.fps, x, y, colour);
            colour = 0xffff00;
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int memoryUsed = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            if(memoryUsed > 32768 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if(memoryUsed < 65536 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            //                Class53.fontNormal.method687((Class40_Sub5_Sub17_Sub6.method832(81, new RSString[]{Class40_Sub7.aClass1_2129, HashTable.method334(memoryUsed, arg0 ^ 0x3c5d), RSCanvas.aClass1_68})), x, y, colour);
            WallDecoration.fontNormal.drawStringRight("Mem: " + memoryUsed + "k", x, y, colour);
            y += 15;
            if(Class38.aBoolean893) {
                WallDecoration.fontNormal.method687(HuffmanEncoding.aClass1_1544, x, y, 16711680);
                y += 15;
                Class38.aBoolean893 = false;
            }
            if(CacheIndex.aBoolean260) {
                WallDecoration.fontNormal.method687(GroundItemTile.aClass1_1378, x, y, 16711680);
                y += 15;
                CacheIndex.aBoolean260 = false;
            }
            if(Class40_Sub3.aBoolean2026) {
                WallDecoration.fontNormal.method687(HuffmanEncoding.aClass1_1546, x, y, 16711680);
                Class40_Sub3.aBoolean2026 = false;
                y += 15;
            }
        }
        if(Class40_Sub5_Sub15.systemUpdateTime != 0) {
            int seconds = Class40_Sub5_Sub15.systemUpdateTime / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if(seconds < 10) {
                WallDecoration.fontNormal.drawString((RSString.linkRSStrings(new RSString[]{Class61.aClass1_1432, HashTable.method334(minutes), Native.prefixColonZero, HashTable.method334(seconds)})), 4, 329, 16776960);
            } else {
                WallDecoration.fontNormal.drawString((RSString.linkRSStrings(new RSString[]{Class61.aClass1_1432, HashTable.method334(minutes), Class43.char_colon, HashTable.method334(seconds)})), 4, 329, 16776960);
            }
        }
    }

    public static int method955(CacheIndex arg0, byte arg1) {
        int i = 0;
        if(arg0.method194(Class27.aClass1_638, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Native.chatback, Class8.aClass1_305, arg1 + -1175)) {
            i++;
        }
        if(arg0.method194(VertexNormal.aClass1_1113, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class59.aClass1_1395, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(CacheIndex.aClass1_256, Class8.aClass1_305, arg1 ^ 0x4eb)) {
            i++;
        }
        if(arg0.method194(Wall.aClass1_338, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class61.aClass1_1440, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class43.aClass1_1024, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class8.aClass1_281, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(WallDecoration.aClass1_1266, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Main.aClass1_1788, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(GroundItemTile.aClass1_1374, Class8.aClass1_305, arg1 ^ 0x4eb)) {
            i++;
        }
        if(arg0.method194(IdentityKit.aClass1_2588, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class5.aClass1_196, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class8.aClass1_304, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(SubNode.aClass1_2093, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class40_Sub5_Sub17_Sub6.aClass1_3254, Class8.aClass1_305, arg1 + -1175)) {
            i++;
        }
        if(arg0.method194(Class64.aClass1_1517, Class8.aClass1_305, -1234)) {
            i++;
        }
        if(arg0.method194(Class40_Sub5_Sub15.aClass1_2787, Class8.aClass1_305, -1234)) {
            i++;
        }
        return i;

    }

    public static RSString method956(int arg0, Buffer arg1) {
        if(arg0 < 62) {
            aLinkedList_1278 = null;
        }
        return Class22.method307(arg1, -1, 32767);
    }

    public static CacheIndex_Sub1 method957(int arg0, boolean arg1, boolean arg2, byte arg3, boolean arg4) {
        Class56 class56 = null;
        if(SpotAnimDefinition.aClass67_2298 != null) {
            class56 = new Class56(arg0, SpotAnimDefinition.aClass67_2298, Class40_Sub5_Sub6.aClass67Array2436[arg0], 1000000);
        }
        if(arg3 < 116) {
            method955(null, (byte) -86);
        }
        return new CacheIndex_Sub1(class56, VarbitDefinition.aClass56_2356, arg0, arg2, arg4, arg1);
    }

    public void keyTyped(KeyEvent arg0) {
        arg0.consume();
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if(Class59.keyFocusListener != null) {
            GameObjectDefinition.anInt2543 = -1;
        }
    }

    public synchronized void keyPressed(KeyEvent keyEvent) {
        if(Class59.keyFocusListener != null) {
            Class49.anInt1147 = 0;
            int obfuscatedKeyCode = keyEvent.getKeyCode();
            int eventKeyCode = keyEvent.getKeyCode();
            if(obfuscatedKeyCode >= 0 && HuffmanEncoding.anIntArray1564.length > obfuscatedKeyCode) {
                obfuscatedKeyCode = HuffmanEncoding.anIntArray1564[obfuscatedKeyCode];
                if((0x80 & obfuscatedKeyCode) != 0) {
                    obfuscatedKeyCode = -1;
                }
            } else {
                obfuscatedKeyCode = -1;
            }
            int keyChar;
//                                    for(int i = 0; i < HuffmanEncoding.anIntArray1564.length; i++) {
//                                        System.out.println("In: " + i +", out: " + HuffmanEncoding.anIntArray1564[i]);
//                                    }

            if(eventKeyCode == KeyEvent.VK_BACK_SPACE || eventKeyCode == KeyEvent.VK_TAB || eventKeyCode == 0xA /* Unused key */ || eventKeyCode == KeyEvent.VK_ESCAPE || eventKeyCode == KeyEvent.VK_DELETE) {
                keyChar = -1;
            } else {
                keyChar = Class51.getKeyChar(keyEvent);
            }
            if(eventKeyCode == 192) {
                Console.console.consoleOpen = !Console.console.consoleOpen;
            }
            if(GameObjectDefinition.anInt2543 >= 0 && obfuscatedKeyCode >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = obfuscatedKeyCode;
                GameObjectDefinition.anInt2543 = 0x7f & GameObjectDefinition.anInt2543 + 1;
                if(GameObjectDefinition.anInt2543 == FramemapDefinition.anInt2183) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
            if(obfuscatedKeyCode >= 0 || keyChar >= 0) {
                int i_5_ = 0x7f & 1 + IdentityKit.anInt2598;
                if(Class59.anInt1389 != i_5_) {
                    Class40_Sub6.anIntArray2113[(IdentityKit.anInt2598)] = obfuscatedKeyCode;
                    Class40_Sub5_Sub13.anIntArray2764[(IdentityKit.anInt2598)] = keyChar;
                    IdentityKit.anInt2598 = i_5_;
                }
            }
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent arg0) {
        if(Class59.keyFocusListener != null) {
            Class49.anInt1147 = 0;
            int i = arg0.getKeyCode();

            if(i < 0 || HuffmanEncoding.anIntArray1564.length <= i) {
                i = -1;
            } else {
                i = ~0x80 & HuffmanEncoding.anIntArray1564[i];
            }
            if(GameObjectDefinition.anInt2543 >= 0 && i >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = i ^ 0xffffffff;
                GameObjectDefinition.anInt2543 = 0x7f & 1 + GameObjectDefinition.anInt2543;
                if(FramemapDefinition.anInt2183 == GameObjectDefinition.anInt2543) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
        }
        arg0.consume();
    }
}
