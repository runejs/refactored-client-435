package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.MemoryCache;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.event.KeyEvent;

public class Class51 {
    public static int mapZoomOffset = 0;
    public static HashTable aClass23_1194 = new HashTable(4096);
    public static int anInt1195 = 0;
    public static int anInt1197 = 0;
    public static int[] anIntArray1198;
    public static int regionX;
    public static long aLong1203 = 0L;
    public static int anInt1205 = -1;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1206;

    public static int getKeyChar(KeyEvent arg1) {
        int keyChar = arg1.getKeyChar();
        if(keyChar <= 0 || keyChar >= 256)
            keyChar = -1;
        return keyChar;
    }



    public static void method940(int arg0, String arg1, boolean arg2, String arg3) {
        if(Class40_Sub5_Sub11.clearScreen) {
            Class40_Sub5_Sub11.clearScreen = false;
            ItemDefinition.drawWelcomeScreenGraphics();
            LinkedList.drawChatBoxGraphics();
            Class55.drawTabGraphics();
            ActorDefinition.drawMapBack();
            GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            Class40_Sub2.method527(Class5.currentTabId, arg0 + 4, Class40_Sub5_Sub11.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, -1);
            MovedStatics.aBoolean893 = true;
            Class40_Sub3.aBoolean2026 = true;
            CacheIndex.aBoolean260 = true;
        }
        int i = 151;
        Class65.method1018();
        i -= 3;
        WallDecoration.fontNormal.drawStringLeft(arg1, 257, i, arg0);
        WallDecoration.fontNormal.drawStringLeft(arg1, 256, i + -1, 16777215);
        if(arg3 != null) {
            i += 15;
            if(arg2) {
                int i_0_ = 4 + WallDecoration.fontNormal.getStringWidth(arg3);
                Rasterizer.drawFilledRectangle(257 - i_0_ / 2, -11 + i, i_0_, 11, 0);
            }
            WallDecoration.fontNormal.drawStringLeft(arg3, 257, i, 0);
            WallDecoration.fontNormal.drawStringLeft(arg3, 256, i - 1, 16777215);
        }
        Player.drawGameScreenGraphics(arg0 + 107);
    }

    public static void method941() {
        CacheIndex.modelCache.method235();
    }

    public static void method942(int arg1) {
        if(arg1 == -1 && Class35.songTimeout == 0)
            Class33.method402(false);
        else if(arg1 != -1 && arg1 != MouseHandler.anInt1457 && RSCanvas.anInt60 != 0 && Class35.songTimeout == 0)
            Class33.method403(RSCanvas.anInt60, true, 10, arg1, MemoryCache.musicCacheIndex, 0, 0, false);
        MouseHandler.anInt1457 = arg1;
    }
}
