package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class43 {
    public static Cache aClass9_1014 = new Cache(64);
    public static RSString aClass1_1019 = RSString.CreateString("flash1:");
    public static int cameraYawOffset = 0;
    public static LinkedList aLinkedList_1022 = new LinkedList();
    public static RSString aClass1_1024 = RSString.CreateString("backleft2");
    public static int bankInsertMode = 0;
    public static RSString char_colon = RSString.CreateString(":");

    public static void method890(long arg0, int arg1) {
        if(arg0 > 0L) {
            int i = 81 / ((arg1 + 20) / 42);
            if(arg0 % 10L == 0L) {
                ISAAC.method283(-1L + arg0, -110);
                ISAAC.method283(1L, -110);
            } else
                ISAAC.method283(arg0, -103);
        }
    }

    public static void drawTabArea(int arg0) {
        Class38.aBoolean893 = true;
        Class61.method996(19655);
        if(Class29.tabAreaOverlayWidgetId != -1) {
            boolean bool = Class40_Sub5_Sub6.drawInterface(0, Class29.tabAreaOverlayWidgetId, 261, (byte) -5, 0, 1, 190);
            if(!bool)
                ISAAC.redrawTabArea = true;
        } else if(Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId] != -1) {
            boolean bool = Class40_Sub5_Sub6.drawInterface(0, (Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]), 261, (byte) -5, 0, 1, 190);
            if(!bool)
                ISAAC.redrawTabArea = true;
        }
        if(Class4.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
            if(Class34.anInt848 == 1)
                method398(-2);
            else
                Class40_Sub5_Sub6.drawMenu();
        }
        if(arg0 >= -22)
            cameraYawOffset = 80;
        Class55.method964(40);
    }

    public static void method893() {
        aClass9_1014 = null;
        aLinkedList_1022 = null;
        aClass1_1024 = null;
        aClass1_1019 = null;
        char_colon = null;
    }

    public static void processRightClick() {
        if(SceneTile.activeInterfaceType == 0) {
            Landscape.menuActionTexts[0] = Class68.str_Cancel;
            Class38.menuActionTypes[0] = 1005;
            ActorDefinition.menuActionRow = 1;
            if(ActorDefinition.openFullScreenWidgetId == -1) {
                Class38_Sub1.method445(9767);
                Item.anInt3065 = -1;
                OverlayDefinition.anInt2328 = -1;
                boolean bool = false;
                if(Class13.mouseX > 4 && Landscape.mouseY > 4 && Class13.mouseX < 516 && Landscape.mouseY < 338) {
                    if(HuffmanEncoding.openScreenWidgetId == -1)
                        Class64.method1013();
                    else
                        Class13.method243((byte) 89, 4, 516, 338, HuffmanEncoding.openScreenWidgetId, 4, Class13.mouseX, Landscape.mouseY, 0);
                }
                HashTable.anInt573 = Item.anInt3065;
                ItemDefinition.anInt2850 = OverlayDefinition.anInt2328;
                Item.anInt3065 = -1;
                OverlayDefinition.anInt2328 = -1;
                if(Class13.mouseX > 553 && Landscape.mouseY > 205 && Class13.mouseX < 743 && Landscape.mouseY < 466) {
                    if(Class29.tabAreaOverlayWidgetId != -1)
                        Class13.method243((byte) 89, 205, 743, 466, Class29.tabAreaOverlayWidgetId, 553, Class13.mouseX, Landscape.mouseY, 1);
                    else if((Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]) != -1)
                        Class13.method243((byte) 89, 205, 743, 466, (Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]), 553, Class13.mouseX, Landscape.mouseY, 1);
                }
                if(OverlayDefinition.anInt2328 != CollisionMap.anInt163) {
                    ISAAC.redrawTabArea = true;
                    CollisionMap.anInt163 = OverlayDefinition.anInt2328;
                }
                OverlayDefinition.anInt2328 = -1;
                if(Item.anInt3065 != FloorDecoration.anInt614) {
                    FloorDecoration.anInt614 = Item.anInt3065;
                    ISAAC.redrawTabArea = true;
                }
                Item.anInt3065 = -1;
                if(Class13.mouseX > 17 && Landscape.mouseY > 357 && Class13.mouseX < 496 && Landscape.mouseY < 453) {
                    if(ChatBox.openChatboxWidgetId == -1) {
                        if(ChatBox.dialogueId == -1) {
                            if(Landscape.mouseY < 434 && Class13.mouseX < 426)
                                Class40_Sub11.method873((Landscape.mouseY + -357), 45);
                        } else
                            Class13.method243((byte) 89, 357, 496, 453, ChatBox.dialogueId, 17, Class13.mouseX, Landscape.mouseY, 3);
                    } else
                        Class13.method243((byte) 89, 357, 496, 453, ChatBox.openChatboxWidgetId, 17, Class13.mouseX, Landscape.mouseY, 2);
                }
                if((ChatBox.openChatboxWidgetId != -1 || ChatBox.dialogueId != -1) && (Class55.anInt1296 != OverlayDefinition.anInt2328)) {
                    ChatBox.redrawChatbox = true;
                    Class55.anInt1296 = OverlayDefinition.anInt2328;
                }
                if((ChatBox.openChatboxWidgetId != -1 || ChatBox.dialogueId != -1) && (Item.anInt3065 != Class67.anInt1586)) {
                    ChatBox.redrawChatbox = true;
                    Class67.anInt1586 = Item.anInt3065;
                }
                while(!bool) {
                    bool = true;
                    for(int i = 0; -1 + ActorDefinition.menuActionRow > i; i++) {
                        if(Class38.menuActionTypes[i] < 1000 && (Class38.menuActionTypes[1 + i] > 1000)) {
                            bool = false;
                            RSString class1 = Landscape.menuActionTexts[i];
                            Landscape.menuActionTexts[i] = Landscape.menuActionTexts[i + 1];
                            Landscape.menuActionTexts[i + 1] = class1;
                            int i_90_ = Class38.menuActionTypes[i];
                            Class38.menuActionTypes[i] = Class38.menuActionTypes[i + 1];
                            Class38.menuActionTypes[i + 1] = i_90_;
                            i_90_ = InteractiveObject.firstMenuOperand[i];
                            InteractiveObject.firstMenuOperand[i] = InteractiveObject.firstMenuOperand[1 + i];
                            InteractiveObject.firstMenuOperand[1 + i] = i_90_;
                            i_90_ = Class59.secondMenuOperand[i];
                            Class59.secondMenuOperand[i] = Class59.secondMenuOperand[1 + i];
                            Class59.secondMenuOperand[i + 1] = i_90_;
                            i_90_ = Class33.selectedMenuActions[i];
                            Class33.selectedMenuActions[i] = Class33.selectedMenuActions[i + 1];
                            Class33.selectedMenuActions[1 + i] = i_90_;
                        }
                    }
                }
            } else {
                Item.anInt3065 = -1;
                OverlayDefinition.anInt2328 = -1;
                Class13.method243((byte) 89, 0, 765, 503, ActorDefinition.openFullScreenWidgetId, 0, Class13.mouseX, Landscape.mouseY, 0);
                ItemDefinition.anInt2850 = OverlayDefinition.anInt2328;
                HashTable.anInt573 = Item.anInt3065;
            }
        }
    }

    public static void method398(int arg0) {
        RSString class1 = null;
        for(int i = 0; ActorDefinition.menuActionRow > i; i++) {
            if(Landscape.menuActionTexts[i].contains(VertexNormal.aClass1_1114) != -1) {
                class1 = (Landscape.menuActionTexts[i].substring(Landscape.menuActionTexts[i].contains(VertexNormal.aClass1_1114)));
                break;
            }
        }
        if(class1 == null)
            Class40_Sub5_Sub6.drawMenu();
        else {
            int i = VertexNormal.menuWidth;
            int i_0_ = InteractiveObject.menuOffsetX;
            if(i > 190)
                i = 190;
            int i_1_ = CollisionMap.menuHeight;
            int i_2_ = Main.menuOffsetY;
            if(i_0_ < 0)
                i_0_ = 0;
            int i_3_ = 6116423;
            Rasterizer.drawFilledRectangle(i_0_, i_2_, i, i_1_, i_3_);
            Rasterizer.drawFilledRectangle(i_0_ + 1, i_2_ + 1, arg0 + i, 16, 0);
            Rasterizer.drawUnfilledRectangle(i_0_ + 1, 18 + i_2_, -2 + i, i_1_ + -19, 0);
            Class40_Sub5_Sub17_Sub6.fontBold.drawShadowedString(class1, 3 + i_0_, 14 + i_2_, i_3_, false);
            int i_4_ = Class13.mouseX;
            int i_5_ = Landscape.mouseY;
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                i_4_ -= 4;
                i_5_ -= 4;
            }
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                i_4_ -= 553;
                i_5_ -= 205;
            }
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                i_5_ -= 357;
                i_4_ -= 17;
            }
            for(int i_6_ = 0; ((i_6_ < ActorDefinition.menuActionRow)); i_6_++) {
                int i_7_ = 31 + i_2_ + (ActorDefinition.menuActionRow + (-1 + -i_6_)) * 15;
                RSString class1_8_ = Landscape.menuActionTexts[i_6_];
                int i_9_ = 16777215;
                if(class1_8_.method87(class1)) {
                    class1_8_ = class1_8_.substring(0, (class1_8_.length() - class1.length()));
                    if(class1_8_.method87(VertexNormal.aClass1_1117))
                        class1_8_ = (class1_8_.substring(0, (class1_8_.length() + -VertexNormal.aClass1_1117.length())));
                }
                if((i_0_ < i_4_) && (i_4_ < i_0_ + i) && -13 + i_7_ < i_5_ && 3 + i_7_ > i_5_)
                    i_9_ = 16776960;
                Class40_Sub5_Sub17_Sub6.fontBold.drawShadowedString(class1_8_, 3 + i_0_, i_7_, i_9_, true);
            }
        }
    }
}
