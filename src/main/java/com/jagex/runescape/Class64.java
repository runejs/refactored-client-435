package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;
import tech.henning.fourthreefive.Configuration;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.MessageFormat;

public class Class64 implements Runnable {
    public static int anInt1511 = -1;
    public static CacheArchive gameDefinitionsCacheArchive;
    public static int lowestPlane = 99;

    public InputStream anInputStream1503;
    public byte[] aByteArray1504;
    public Socket aSocket1508;
    public int anInt1509 = 0;
    public boolean aBoolean1510;
    public SignlinkNode aSignlinkNode_1512;
    public boolean aBoolean1513;
    public Signlink aClass31_1515;
    public int anInt1520 = 0;
    public OutputStream anOutputStream1528;

    public Class64(Socket arg0, Signlink arg1) throws IOException {
        aBoolean1513 = false;
        aBoolean1510 = false;
        aClass31_1515 = arg1;
        aSocket1508 = arg0;
        aSocket1508.setSoTimeout(30000);
        aSocket1508.setTcpNoDelay(true);
        anInputStream1503 = aSocket1508.getInputStream();
        anOutputStream1528 = aSocket1508.getOutputStream();
    }


    public static void method1013() {
        int lasthash = -1;
        if (Class8.itemSelected == 0 && Main.widgetSelected == 0) {
            String tileCoords = "";
            if (Configuration.DEBUG_CONTEXT) {
                tileCoords = MessageFormat.format("<col=8F8FFF>({0}, {1})</col>", Integer.toString(Scene.hoveredTileX + SpotAnimDefinition.baseX), Integer.toString(Scene.hoveredTileY + Class26.baseY));
            }

            OverlayDefinition.addActionRow(English.walkHere, 0, Class13.mouseX, Landscape.mouseY, 7, tileCoords);
        }

        for (int idx = 0; Model.resourceCount > idx; idx++) {
            int hash = Model.hoveredHash[idx];
            int x = 0x7f & hash;
            int y = hash >> 7 & 0x7f;
            int type = hash >> 29 & 0x3;
            int index = (hash & 0x1fffcccc) >> 14;
            if (lasthash != hash) {
                lasthash = hash;
                if (type == 2 && Npc.currentScene.getArrangement(Player.worldLevel, x, y, hash) >= 0) {
                    GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(index);
                    if (gameObjectDefinition.childIds != null)
                        gameObjectDefinition = gameObjectDefinition.getChildDefinition();
                    if (gameObjectDefinition == null)
                        continue;
                    if (Class8.itemSelected == 1) {
                        OverlayDefinition.addActionRow(English.use, hash, x, y, 5, Native.aClass1_3295 + Native.toCyan + gameObjectDefinition.name);
                    } else if (Main.widgetSelected != 1) {
                        String[] options = gameObjectDefinition.actions;
                        if (Class60.aBoolean1402)
                            options = MovedStatics.method968(options);
                        if (options != null) {
                            for (int i_7_ = 4; i_7_ >= 0; i_7_--) {
                                if (options[i_7_] != null) {
                                    int actionType = 0;
                                    if (i_7_ == 0)
                                        actionType = 16;
                                    if (i_7_ == 1)
                                        actionType = 29;
                                    if (i_7_ == 2)
                                        actionType = 17;
                                    if (i_7_ == 3)
                                        actionType = 27;
                                    if (i_7_ == 4)
                                        actionType = 1002;
                                    OverlayDefinition.addActionRow(options[i_7_], hash, x, y, actionType, Native.cyan + gameObjectDefinition.name);
                                }
                            }
                        }
                        StringBuilder examineText = new StringBuilder();
                        examineText.append(MessageFormat.format("<col=00ffff>{0}</col>", gameObjectDefinition.name));
                        if (Configuration.DEBUG_CONTEXT) {
                            examineText.append(" <col=00ff00>(</col>");
                            examineText.append(
                                    MessageFormat.format("<col=ffffff>{0}</col>",
                                            Integer.toString(gameObjectDefinition.id)
                                    )
                            );
                            examineText.append("<col=00ff00>) (</col>");
                            examineText.append(
                                    MessageFormat.format("<col=ffffff>{0}, {1}</col>",
                                            Integer.toString(x + SpotAnimDefinition.baseX),
                                            Integer.toString(y + Class26.baseY)
                                    )
                            );
                            examineText.append("<col=00ff00>)</col>");


                        }
                        OverlayDefinition.addActionRow(English.examine, gameObjectDefinition.id << 14, x, y, 1004, examineText.toString());
                    } else if ((ItemDefinition.selectedMask & 0x4) == 4) {
                        OverlayDefinition.addActionRow(Native.aClass1_1918, hash, x, y, 32, Native.aClass1_611 + Native.toCyan + gameObjectDefinition.name);
                    }
                }
                if (type == 1) {
                    Npc npc = Player.npcs[index];
                    if (npc.actorDefinition.boundaryDimension == 1 && (npc.worldX & 0x7f) == 64 && (0x7f & npc.worldY) == 64) {
                        for (int i_9_ = 0; Player.npcCount > i_9_; i_9_++) {
                            Npc npc1 = Player.npcs[Player.npcIds[i_9_]];
                            if (npc1 != null && npc1 != npc && npc1.actorDefinition.boundaryDimension == 1 && npc1.worldX == npc.worldX && npc1.worldY == npc.worldY)
                                HuffmanEncoding.processNpcMenuOptions(npc1.actorDefinition, x, y, Player.npcIds[i_9_]);
                        }
                        for (int i_11_ = 0; i_11_ < Player.localPlayerCount; i_11_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_11_]];
                            if (player != null && npc.worldX == player.worldX && player.worldY == npc.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_11_]);
                        }
                    }
                    HuffmanEncoding.processNpcMenuOptions(npc.actorDefinition, x, y, index);
                }
                if (type == 0) {
                    Player player1 = Player.trackedPlayers[index];
                    if ((0x7f & player1.worldX) == 64 && (0x7f & player1.worldY) == 64) {
                        for (int i_12_ = 0; i_12_ < Player.npcCount; i_12_++) {
                            Npc npc = Player.npcs[Player.npcIds[i_12_]];
                            if (npc != null && npc.actorDefinition.boundaryDimension == 1 && npc.worldX == player1.worldX && npc.worldY == player1.worldY)
                                HuffmanEncoding.processNpcMenuOptions(npc.actorDefinition, x, y, Player.npcIds[i_12_]);
                        }
                        for (int i_13_ = 0; i_13_ < Player.localPlayerCount; i_13_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_13_]];
                            if (player != null && player != player1 && player1.worldX == player.worldX && player1.worldY == player.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_13_]);
                        }
                    }
                    Player.processPlayerMenuOptions(player1, x, y, index);
                }
                if (type == 3) {
                    LinkedList itemList = Wall.groundItems[Player.worldLevel][x][y];
                    if (itemList != null) {
                        for (Item item = (Item) itemList.last((byte) -95); item != null; item = (Item) itemList.previous(4)) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(item.itemId, 10);
                            if (Class8.itemSelected == 1) {
                                OverlayDefinition.addActionRow(English.use, item.itemId, x, y, 47, Native.aClass1_3295 + Native.toLightRed + itemDefinition.name);
                            } else if (Main.widgetSelected != 1) {
                                String[] class1s = itemDefinition.groundOptions;
                                if (Class60.aBoolean1402)
                                    class1s = MovedStatics.method968(class1s);
                                for (int i_15_ = 4; i_15_ >= 0; i_15_--) {
                                    if (class1s == null || class1s[i_15_] == null) {
                                        if (i_15_ == 2) {
                                            OverlayDefinition.addActionRow(English.take, item.itemId, x, y, 3, Native.lightRed + itemDefinition.name);
                                        }
                                    } else {
                                        int i_16_ = 0;
                                        if (i_15_ == 0)
                                            i_16_ = 2;
                                        if (i_15_ == 1)
                                            i_16_ = 38;
                                        if (i_15_ == 2)
                                            i_16_ = 3;
                                        if (i_15_ == 3)
                                            i_16_ = 8;
                                        if (i_15_ == 4)
                                            i_16_ = 36;
                                        OverlayDefinition.addActionRow(class1s[i_15_], item.itemId, x, y, i_16_, Native.lightRed +  itemDefinition.name);
                                    }
                                }
                                OverlayDefinition.addActionRow(English.examine, item.itemId, x, y, 1003, Native.lightRed + itemDefinition.name);
                            } else if ((0x1 & ItemDefinition.selectedMask) == 1) {
                                OverlayDefinition.addActionRow(Native.aClass1_1918, item.itemId, x, y, 15, Native.aClass1_611 + Native.toLightRed + itemDefinition.name);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void method1015() {
        synchronized (GameObject.frame) {
            SpotAnimDefinition.mouseButtonPressed = MovedStatics.mouseButtonPressed;
            Class13.mouseX = Class12.eventMouseX;
            Landscape.mouseY = MovedStatics.eventMouseY;
            MouseHandler.clickType = Actor.eventMouseButtonPressed;
            Class57.clickX = Class55.eventClickX;
            RSString.clickY = MovedStatics.eventClickY;
            GameObjectDefinition.aLong2561 = OverlayDefinition.lastClick;
            Actor.eventMouseButtonPressed = 0;
        }
    }

    public void method1008(int arg0, int arg1, int arg2, byte[] arg3) throws IOException {
        if (!aBoolean1513 && arg2 < -126) {
            while (arg1 > 0) {
                int i = anInputStream1503.read(arg3, arg0, arg1);
                if (i <= 0)
                    throw new EOFException();
                arg1 -= i;
                arg0 += i;
            }
        }
    }

    public void method1009() {
        if (!aBoolean1513) {
            synchronized (this) {
                aBoolean1513 = true;
                this.notifyAll();
            }
            if (aSignlinkNode_1512 != null) {
                while (aSignlinkNode_1512.anInt434 == 0)
                    Class43.sleep(1L);
                if (aSignlinkNode_1512.anInt434 == 1) {
                    try {
                        ((Thread) aSignlinkNode_1512.value).join();
                    } catch (InterruptedException interruptedexception) {
                        interruptedexception.printStackTrace();
                        /* empty */
                    }
                }
            }
            aSignlinkNode_1512 = null;
        }
    }

    public void method1010(int arg0, byte arg1, int arg2, byte[] arg3) throws IOException {
        if (!aBoolean1513) {
            if (aBoolean1510) {
                aBoolean1510 = false;
                throw new IOException();
            }
            if (aByteArray1504 == null)
                aByteArray1504 = new byte[5000];
            synchronized (this) {
                for (int i = 0; i < arg0; i++) {
                    aByteArray1504[anInt1509] = arg3[arg2 + i];
                    anInt1509 = (1 + anInt1509) % 5000;
                    if (anInt1509 == (4900 + anInt1520) % 5000)
                        throw new IOException();
                }
                if (aSignlinkNode_1512 == null)
                    aSignlinkNode_1512 = aClass31_1515.method394(3, 0, this);
                this.notifyAll();
                if (arg1 != -19)
                    run();
            }
        }
    }

    public void finalize() {
        method1009();
    }

    public void run() {
        try {
            for (; ; ) {
                int i;
                int i_0_;
                synchronized (this) {
                    if (anInt1509 == anInt1520) {
                        if (aBoolean1513) {
                            break;
                        }
                        try {
                            this.wait();
                        } catch (InterruptedException interruptedexception) {
                            /* empty */
                            interruptedexception.printStackTrace();
                        }
                    }
                    if (anInt1509 >= anInt1520)
                        i = anInt1509 - anInt1520;
                    else
                        i = -anInt1520 + 5000;
                    i_0_ = anInt1520;
                }
                if (i > 0) {
                    try {
                        anOutputStream1528.write(aByteArray1504, i_0_, i);
                    } catch (IOException ioexception) {
                        aBoolean1510 = true;
                    }
                    anInt1520 = (i + anInt1520) % 5000;
                    try {
                        if (anInt1520 == anInt1509)
                            anOutputStream1528.flush();
                    } catch (IOException ioexception) {
                        ioexception.printStackTrace();
                        aBoolean1510 = true;
                    }
                }
            }
            try {
                if (anInputStream1503 != null)
                    anInputStream1503.close();
                if (anOutputStream1528 != null)
                    anOutputStream1528.close();
                if (aSocket1508 != null)
                    aSocket1508.close();
            } catch (IOException ioexception) {
                /* empty */
                ioexception.printStackTrace();
            }
            aByteArray1504 = null;
        } catch (Exception exception) {
            MovedStatics.method169(null, (byte) -122, exception);
        }
    }

    public int method1014(int arg0) throws IOException {
        if (arg0 >= -120)
            aClass31_1515 = null;
        if (aBoolean1513)
            return 0;
        return anInputStream1503.available();
    }

    public int read() throws IOException {
        if (aBoolean1513)
            return 0;
        return anInputStream1503.read();
    }
}
