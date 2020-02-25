package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;

public class Class43 {
    public static Cache aClass9_1014 = new Cache(64);
    public static int anInt1015;
    public static int anInt1016;
    public static int anInt1018;
    public static RSString aClass1_1019;
    public static int cameraYawOffset = 0;
    public static RSString aClass1_1021 = RSString.CreateString("flash1:");
    public static Class45 aClass45_1022;
    public static int anInt1023;
    public static RSString aClass1_1024;
    public static int bankInsertMode;
    public static RSString aClass1_1026;
    public static RSString aClass1_1027;
    public static int openChatboxWidgetId;

    static {
        aClass1_1019 = aClass1_1021;
        aClass45_1022 = new Class45();
        aClass1_1024 = RSString.CreateString("backleft2");
        aClass1_1027 = RSString.CreateString(":");
        bankInsertMode = 0;
        openChatboxWidgetId = -1;
        aClass1_1026 = RSString.CreateString("Schlie-8en");
    }

    public static void method890(long arg0, int arg1) {

        anInt1023++;
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
                Class32.method398(-2);
            else
                Class40_Sub5_Sub6.method588(-1);
        }
        if(arg0 >= -22)
            cameraYawOffset = 80;
        Class55.method964(40);
    }

    public static void method893(byte arg0) {

        if(arg0 <= 104)
            aClass1_1024 = null;
        aClass9_1014 = null;
        aClass1_1026 = null;
        aClass1_1021 = null;
        aClass45_1022 = null;
        aClass1_1024 = null;
        aClass1_1019 = null;
        aClass1_1027 = null;

    }

    public static void method894(boolean arg0) {

        anInt1018++;
        if(SceneTile.activeInterfaceType == 0) {
            Landscape.aClass1Array1184[0] = Class68.aClass1_1635;
            Class38.anIntArray884[0] = 1005;
            ActorDefinition.anInt2394 = 1;
            if(ActorDefinition.openFullScreenWidgetId == -1) {
                Class38_Sub1.method445(9767);
                Class40_Sub5_Sub17_Sub3.anInt3065 = -1;
                OverlayDefinition.anInt2328 = -1;
                boolean bool = arg0;
                if(Class13.mouseX > 4 && Landscape.mouseY > 4 && Class13.mouseX < 516 && Landscape.mouseY < 338) {
                    if(HuffmanEncoding.openScreenWidgetId == -1)
                        Class64.method1013(arg0);
                    else
                        Class13.method243((byte) 89, 4, 516, 338, HuffmanEncoding.openScreenWidgetId, 4, Class13.mouseX, Landscape.mouseY, 0);
                }
                HashTable.anInt573 = Class40_Sub5_Sub17_Sub3.anInt3065;
                ItemDefinition.anInt2850 = OverlayDefinition.anInt2328;
                Class40_Sub5_Sub17_Sub3.anInt3065 = -1;
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
                if(Class40_Sub5_Sub17_Sub3.anInt3065 != FloorDecoration.anInt614) {
                    FloorDecoration.anInt614 = Class40_Sub5_Sub17_Sub3.anInt3065;
                    ISAAC.redrawTabArea = true;
                }
                Class40_Sub5_Sub17_Sub3.anInt3065 = -1;
                if(Class13.mouseX > 17 && Landscape.mouseY > 357 && Class13.mouseX < 496 && Landscape.mouseY < 453) {
                    if(openChatboxWidgetId == -1) {
                        if(Class48.anInt1138 == -1) {
                            if(Landscape.mouseY < 434 && Class13.mouseX < 426)
                                Class40_Sub11.method873((Landscape.mouseY + -357), 45);
                        } else
                            Class13.method243((byte) 89, 357, 496, 453, Class48.anInt1138, 17, Class13.mouseX, Landscape.mouseY, 3);
                    } else
                        Class13.method243((byte) 89, 357, 496, 453, openChatboxWidgetId, 17, Class13.mouseX, Landscape.mouseY, 2);
                }
                if((openChatboxWidgetId != -1 || Class48.anInt1138 != -1) && (Class55.anInt1296 != OverlayDefinition.anInt2328)) {
                    Class52.redrawChatbox = true;
                    Class55.anInt1296 = OverlayDefinition.anInt2328;
                }
                if((openChatboxWidgetId != -1 || Class48.anInt1138 != -1) && (Class40_Sub5_Sub17_Sub3.anInt3065 != Class67.anInt1586)) {
                    Class52.redrawChatbox = true;
                    Class67.anInt1586 = Class40_Sub5_Sub17_Sub3.anInt3065;
                }
                while(!bool) {
                    bool = true;
                    for(int i = 0; -1 + ActorDefinition.anInt2394 > i; i++) {
                        if(Class38.anIntArray884[i] < 1000 && (Class38.anIntArray884[1 + i] > 1000)) {
                            bool = false;
                            RSString class1 = Landscape.aClass1Array1184[i];
                            Landscape.aClass1Array1184[i] = Landscape.aClass1Array1184[i + 1];
                            Landscape.aClass1Array1184[i + 1] = class1;
                            int i_90_ = Class38.anIntArray884[i];
                            Class38.anIntArray884[i] = Class38.anIntArray884[i + 1];
                            Class38.anIntArray884[i + 1] = i_90_;
                            i_90_ = Class19.anIntArray483[i];
                            Class19.anIntArray483[i] = Class19.anIntArray483[1 + i];
                            Class19.anIntArray483[1 + i] = i_90_;
                            i_90_ = Class59.anIntArray1393[i];
                            Class59.anIntArray1393[i] = Class59.anIntArray1393[1 + i];
                            Class59.anIntArray1393[i + 1] = i_90_;
                            i_90_ = Class33.anIntArray791[i];
                            Class33.anIntArray791[i] = Class33.anIntArray791[i + 1];
                            Class33.anIntArray791[1 + i] = i_90_;
                        }
                    }
                }
            } else {
                Class40_Sub5_Sub17_Sub3.anInt3065 = -1;
                OverlayDefinition.anInt2328 = -1;
                Class13.method243((byte) 89, 0, 765, 503, ActorDefinition.openFullScreenWidgetId, 0, Class13.mouseX, Landscape.mouseY, 0);
                ItemDefinition.anInt2850 = OverlayDefinition.anInt2328;
                HashTable.anInt573 = Class40_Sub5_Sub17_Sub3.anInt3065;
            }
        }

    }
}
