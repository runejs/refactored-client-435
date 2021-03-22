package com.jagex.runescape.frame.tab;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.FramePieceRenderer;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.tab.parts.TabParts;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.RasterizerInstanced;
import com.jagex.runescape.media.renderable.actor.Player;

// TODO: DONT RUN NORMAL TAB RENDERER WHEN THIS IS RUNNING
public class TabProducer extends FramePieceRenderer {
    private static ProducingGraphicsBuffer resizableSideBarImage;
    private ProducingGraphicsBuffer tempResizableSideBar;
    private ImageRGB edgeLeft;
    private ImageRGB edgeRight;
    private ImageRGB combat;
    private ImageRGB stats;
    private ImageRGB quests;
    private ImageRGB inventory;
    private ImageRGB equipment;
    private ImageRGB prayer;
    private ImageRGB magic;
    private ImageRGB topRow;
    private ImageRGB friends;
    private ImageRGB ignores;
    private ImageRGB logout;
    private ImageRGB options;
    private ImageRGB emotes;
    private ImageRGB music;
    private ImageRGB bottomRow;
    private ImageRGB background;
    private ImageRGB stone_bottom_left_selected;
    private ImageRGB stone_bottom_right_selected;
    private ImageRGB stone_middle_selected;
    private ImageRGB stone_top_left_selected;
    private ImageRGB stone_top_right_selected;
    private boolean loaded = false;

    private static int workingWidth = 232;
    private static int workingHeight = 334;


    public TabProducer() {
        this.tempResizableSideBar = Class40_Sub5_Sub13.createGraphicsBuffer(241, 334, MouseHandler.aCanvas1469);
        resizableSideBarImage = Class40_Sub5_Sub13.createGraphicsBuffer(241, 334, MouseHandler.aCanvas1469);
        rasterizerInstanced = new RasterizerInstanced(this.tempResizableSideBar);
        rasterizerInstanced.drawFilledRectangle(0, 0, 241, 334, Integer.MAX_VALUE);
    }

    private void drawActiveTab(int currentTabId, int currentY) {
        ImageRGB part;
        int x = 0;
        switch (currentTabId){
            case 0:
                part = stone_top_left_selected;
                break;
            case 6:
                part = stone_top_right_selected;
                break;
            case 7:
                part = stone_bottom_left_selected;
                break;
            case 13:
                part =stone_bottom_right_selected;
                break;
            default:
                part = stone_middle_selected;
        }
        switch (currentTabId) {
            case 0:
            case 7:
                x = 0;
                break;
            case 1:
            case 8:
                x = 38;
                break;
            case 2:
            case 9:
                x = 70;
                break;
            case 3:
            case 10:
                x = 104;
                break;
            case 4:
            case 11:
                x = 136;
                break;
            case 5:
            case 12:
                x = 170;
                break;
            case 6:
            case 13:
                x = 202;
                break;
        }
        drawImage(part, x,currentY);
    }

    public int[] getTabButtonStartCoords(int tabButtonIndex) {
        int x = 0;
        int y = 0;
        switch (tabButtonIndex) {
            case 0:
            case 7:
                x = 0;
                break;
            case 1:
            case 8:
                x = 38;
                break;
            case 2:
            case 9:
                x = 70;
                break;
            case 3:
            case 10:
                x = 104;
                break;
            case 4:
            case 11:
                x = 136;
                break;
            case 5:
            case 12:
                x = 170;
                break;
            case 6:
            case 13:
                x = 202;
                break;
        }
        if(tabButtonIndex > 6){
            y = workingHeight - bottomRow.imageHeight;
        }
        return new int[]{x, y};
    }
    public int[] getTabButtonBox(int tabButtonIndex) {
        int[] start = getTabButtonStartCoords(tabButtonIndex);
        int[] end;
        int[] topbar = getTopBarCoordSize(0,0);

        if(tabButtonIndex != 13 && tabButtonIndex != 6 ) {
            end = getTabButtonStartCoords(tabButtonIndex+1);
        } else {
            end = new int[]{topbar[2],start[1]};
        }
        return new int[] {start[0],start[1], end[0], start[1]+ topbar[3]};
    }



    public void drawResizableSideBarArea(int x, int y) {
        ScreenController.drawFramePiece(resizableSideBarImage, x, y);
    }

    public int[] getTabInterfaceCoordSize(int baseX, int baseY) {
        if(MovedStatics.tabImageProducer == null) {
            return new int[]{0,0,0,0};
        }
        baseX += 5;
        return new int[]{
                baseX + workingWidth / 2 - MovedStatics.tabImageProducer.width / 2,
                baseY + workingHeight / 2 - MovedStatics.tabImageProducer.height / 2,
                MovedStatics.tabImageProducer.width,
                MovedStatics.tabImageProducer.height
        };
    }

    public int[] getTopBarCoordSize(int baseX, int baseY) {
        if(topRow == null) {
            return new int[]{0,0,0,0};
        }
        return new int[]{
                baseX,
                baseY,
                topRow.imageWidth,
                topRow.imageHeight
        };
    }
    public int[] getBottomBarCoordSize(int baseX, int baseY) {
        if(bottomRow == null) {
            return new int[]{0,0,0,0};
        }
        return new int[]{
                baseX,
                baseY + workingHeight - bottomRow.imageHeight,
                bottomRow.imageWidth,
                bottomRow.imageHeight
        };
    }
    private void drawMiddlePiece(int baseX, int baseY, int width, int height) {
        rasterizerInstanced.copyPixels(
                MovedStatics.tabImageProducer.pixels,
                MovedStatics.tabImageProducer.width,
                MovedStatics.tabImageProducer.height,
                baseX + width / 2 - MovedStatics.tabImageProducer.width / 2,
                baseY + height / 2 - MovedStatics.tabImageProducer.height / 2);
        drawImage(edgeLeft, baseX, baseY + height / 2 - edgeLeft.imageHeight / 2);
        drawImage(edgeRight, baseX + width - edgeRight.imageWidth, baseY + height / 2 - edgeRight.imageHeight / 2);
    }

    public void RenderResizableSideBarArea() {
        if (!loaded) {
            edgeLeft = TabParts.GetPart("side_panel_edge_left");
            edgeRight = TabParts.GetPart("side_panel_edge_right");
            combat = TabParts.GetPart("combat");
            stats = TabParts.GetPart("stats");
            quests = TabParts.GetPart("quests");
            inventory = TabParts.GetPart("inventory");
            equipment = TabParts.GetPart("equipment");
            prayer = TabParts.GetPart("prayer");
            magic = TabParts.GetPart("magic");
            topRow = TabParts.GetPart("tabs_top_row");
            friends = TabParts.GetPart("friends");
            ignores = TabParts.GetPart("ignores");
            logout = TabParts.GetPart("logout");
            options = TabParts.GetPart("options");
            emotes = TabParts.GetPart("emotes");
            music = TabParts.GetPart("music");
            bottomRow = TabParts.GetPart("tabs_bottom_row");
            background = TabParts.GetPart("side_panel_background");
            stone_bottom_left_selected = TabParts.GetPart("stone_bottom_left_selected");
            stone_bottom_right_selected = TabParts.GetPart("stone_bottom_right_selected");
            stone_middle_selected = TabParts.GetPart("stone_middle_selected");
            stone_top_left_selected = TabParts.GetPart("stone_top_left_selected");
            stone_top_right_selected = TabParts.GetPart("stone_top_right_selected");
            loaded = true;
        }
        int x = 5;
        int y = 0;


        drawImage(background, x + 24, y + 20);
        drawImage(background, x + 24 + background.imageWidth, y + 20);
        drawImage(background, x + 24 + background.imageWidth + 20, y + 20);

        drawImage(background, x + 24, y + workingHeight - background.imageHeight - 20);
        drawImage(background, x + 24 + background.imageWidth, y + workingHeight - background.imageHeight - 20);
        drawImage(background, x + 24 + background.imageWidth + 20, y + workingHeight - background.imageHeight - 20);

        drawMiddlePiece(x, y, workingWidth, workingHeight);
        drawTopRow(x, y, workingWidth, workingHeight);
        drawBottomRow(x, y, workingWidth, workingHeight);

        System.arraycopy(tempResizableSideBar.pixels, 0, resizableSideBarImage.pixels, 0, resizableSideBarImage.pixels.length);

    }

    private void drawBottomRow(int x, int y, int workingWidth, int workingHeight) {
        drawImage(bottomRow, x - 4, y + workingHeight - bottomRow.imageHeight);
        int currentX = x;
        int currentY = y + workingHeight - bottomRow.imageHeight;
        if (6 < Player.currentTabId) {
            this.drawActiveTab(Player.currentTabId, currentY);

        }
        currentX += combat.imageWidth;
        drawImage(friends, currentX, currentY);
        currentX += combat.imageWidth;
        drawImage(ignores, currentX, currentY);
        currentX += combat.imageWidth;
        drawImage(logout, currentX, currentY);
        currentX += combat.imageWidth;
        drawImage(options, currentX, currentY);
        currentX += combat.imageWidth;
        drawImage(emotes, currentX, currentY);
        currentX += combat.imageWidth;
        drawImage(music, currentX, currentY);
    }



    private void drawTopRow(int x, int y, int workingWidth, int workingHeight) {
        drawImage(topRow, x - 4, y);
        if (Player.currentTabId < 7) {
            this.drawActiveTab(Player.currentTabId, y);
        }
        int currentX = x;
        drawImage(combat, currentX, y);
        currentX += stats.imageWidth;
        drawImage(stats, currentX, y);
        currentX += stats.imageWidth;
        drawImage(quests, currentX, y);
        currentX += stats.imageWidth;
        drawImage(inventory, currentX, y);
        currentX += stats.imageWidth;
        drawImage(equipment, currentX, y);
        currentX += stats.imageWidth;
        drawImage(prayer, currentX, y);
        currentX += stats.imageWidth;
        drawImage(magic, currentX, y);
    }

    private static void RenderCustomTabArea(int baseX, int baseY) {
        int colourBorder = 0x242017;
        int colourInnerBorder = 0x776c38;
        int colourInnerPrimary = 0x4d4427;
        int colourInnerSecondary = 0xa3984a;
        int width = 232;
        int height = 334;
        // height 337
        // width 234
//        Rasterizer.drawFilledRectangle(baseX, baseY, width, height, colourBorder);
//        Rasterizer.drawFilledRectangle(baseX + 2, baseY + 2, width - 4, height - 4, colourInnerBorder);
//        Rasterizer.drawFilledRectangle(baseX + 4, baseY + 4, width - 8, height - 8, colourInnerBorder);
//        Rasterizer.drawFilledRectangle(baseX + 5, baseY + 2, 3, 40, 0xa3984a);

    }

    public void clickTabButton(int x, int y, int baseX, int baseY) {
        for (int i = 0; i < 14; i++) {
            int[] bounds = getTabButtonBox(i);

            if(x > baseX + bounds[0] && x < baseX+bounds[2]&& y > baseY+bounds[1] && y < baseY + bounds[3] && i != 7) {
                Player.currentTabId = i;


                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                return;
            }
        }

    }
}
