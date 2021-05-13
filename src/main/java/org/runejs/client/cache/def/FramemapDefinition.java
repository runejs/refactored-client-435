package org.runejs.client.cache.def;

import org.runejs.client.Landscape;
import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.Class37;

public class FramemapDefinition extends Node {
    public static boolean aBoolean2177 = false;
    public static int anInt2183 = 0;


    public int[][] frameMaps;
    public int length;
    public int id;
    public int[] types;

    public FramemapDefinition(int id, byte[] data) {
        this.id = id;
        Buffer buffer = new Buffer(data);
        length = buffer.getUnsignedByte();
        types = new int[length];
        frameMaps = new int[length][];
        for(int i = 0; i < length; i++)
            types[i] = buffer.getUnsignedByte();
        for(int i = 0; length > i; i++)
            frameMaps[i] = new int[buffer.getUnsignedByte()];
        for(int i = 0; i < length; i++) {
            for(int i_38_ = 0; frameMaps[i].length > i_38_; i_38_++)
                frameMaps[i][i_38_] = buffer.getUnsignedByte();
        }

    }

    public static GameInterface method878(GameInterface arg1) {
        int i;
        if(arg1.id < 0)
            i = arg1.parentId >> 16;
        else
            i = arg1.id >> 16;
        if(!GameInterface.decodeGameInterface(i))
            return null;
        if(arg1.anInt2738 >= 0)
            return GameInterface.cachedInterfaces[i][0xffff & arg1.anInt2738];
        GameInterface gameInterface = GameInterface.cachedInterfaces[i][(0x7fff99d9 & arg1.anInt2738) >> 15];
        return gameInterface.children[arg1.anInt2738 & 0x7fff];
    }

    public static void method879(IndexedImage arg1) {
        int i = 0;
        for(/**/; i < Landscape.anIntArray1168.length; i++)
            Landscape.anIntArray1168[i] = 0;
        int i_19_ = 256;
        for(int i_20_ = 0; i_20_ < 5000; i_20_++) {
            int i_21_ = (int) ((double) i_19_ * (128.0 * Math.random()));
            Landscape.anIntArray1168[i_21_] = (int) (256.0 * Math.random());
        }
        for(int i_22_ = 0; i_22_ < 20; i_22_++) {
            for(int i_23_ = 1; -1 + i_19_ > i_23_; i_23_++) {
                for(int i_24_ = 1; i_24_ < 127; i_24_++) {
                    int i_25_ = (i_23_ << 7) + i_24_;
                    MovedStatics.anIntArray1445[i_25_] = (Landscape.anIntArray1168[i_25_ - 128] + Landscape.anIntArray1168[i_25_ + -1] + Landscape.anIntArray1168[i_25_ + 1] + Landscape.anIntArray1168[128 + i_25_]) / 4;
                }
            }
            int[] is = Landscape.anIntArray1168;
            Landscape.anIntArray1168 = MovedStatics.anIntArray1445;
            MovedStatics.anIntArray1445 = is;
        }
        if(arg1 != null) {
            int i_26_ = 0;
            for(int i_27_ = 0; arg1.imgHeight > i_27_; i_27_++) {
                for(int i_28_ = 0; i_28_ < arg1.imgWidth; i_28_++) {
                    if(arg1.imgPixels[i_26_++] != 0) {
                        int i_29_ = arg1.yDrawOffset + i_27_ + 16;
                        int i_30_ = arg1.xDrawOffset + i_28_ + 16;
                        int i_31_ = i_30_ + (i_29_ << 7);
                        Landscape.anIntArray1168[i_31_] = 0;
                    }
                }
            }
        }
    }

    public static void spawnGroundItem(int arg1, int arg2) {
        LinkedList linkedList = Wall.groundItems[Player.worldLevel][arg2][arg1];
        if(linkedList == null)
            Npc.currentScene.method125(Player.worldLevel, arg2, arg1);
        else {
            int i = -99999999;
            Item item = null;
            for(Item item_32_ = (Item) linkedList.method902((byte) -90); item_32_ != null; item_32_ = (Item) linkedList.method909(-4)) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(item_32_.itemId, 10);
                int i_33_ = class40_sub5_sub16.cost;
                if(class40_sub5_sub16.stackable == 1)
                    i_33_ *= item_32_.itemCount + 1;
                if(i_33_ > i) {
                    i = i_33_;
                    item = item_32_;
                }
            }
            if(item == null)
                Npc.currentScene.method125(Player.worldLevel, arg2, arg1);
            else {
                Item item_34_ = null;
                Item item_35_ = null;
                linkedList.method905(0, item);
                for(Item item_36_ = (Item) linkedList.method902((byte) -90); item_36_ != null; item_36_ = (Item) linkedList.method909(-4)) {
                    if(item.itemId != item_36_.itemId) {
                        if(item_35_ == null)
                            item_35_ = item_36_;
                        if(item_35_.itemId != item_36_.itemId && item_34_ == null)
                            item_34_ = item_36_;
                    }
                }
                int i_37_ = 1610612736 + (arg1 << 7) + arg2;
                Npc.currentScene.addGroundItemTile(arg2, arg1, Player.worldLevel, Class37.getFloorDrawHeight(Player.worldLevel, 64 + 128 * arg2, 64 + 128 * arg1), i_37_, item, item_35_, item_34_);
            }
        }

    }
}
