package org.runejs.client;

import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.tile.WallDecoration;

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



    public static void method940(String arg1, boolean arg2, String arg3) {
        if(MovedStatics.clearScreen) {
            MovedStatics.clearScreen = false;
            ItemDefinition.drawWelcomeScreenGraphics();
            LinkedList.drawChatBoxGraphics();
            Class55.drawTabGraphics();
            ActorDefinition.drawMapBack();
            GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            MovedStatics.method527(Player.currentTabId, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, -1);
            MovedStatics.showSidePanelRedrawnText = true;
            Class40_Sub3.showIconsRedrawnText = true;
            MovedStatics.showChatPanelRedrawnText = true;
        }
        int i = 151;
        Class65.method1018();
        i -= 3;
        WallDecoration.fontNormal.drawStringLeft(arg1, 257, i, 0);
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
        Player.drawGameScreenGraphics();
    }

    public static void clearModelCache() {
        MovedStatics.modelCache.clear();
    }
}
