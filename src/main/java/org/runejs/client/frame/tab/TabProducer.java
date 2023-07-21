package org.runejs.client.frame.tab;

import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.FramePieceAnchor;
import org.runejs.client.frame.FramePieceRenderer;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.media.RasterizerInstanced;

// TODO: DONT RUN NORMAL TAB RENDERER WHEN THIS IS RUNNING
public class TabProducer extends FramePieceRenderer {
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

    /**
     * To avoid flickering, we draw to a temporary rasterizer first,
     * then flush this to the output rasterizer at once, in its entirety.
     */
    private RasterizerInstanced rasterizerTemp;


    public TabProducer() {
        super(
            new FramePieceAnchor(
                FramePieceAnchor.Anchor.BOTTOM | FramePieceAnchor.Anchor.RIGHT,
                0,
                0
            ),
            241,
            334
        );

        rasterizerTemp = new RasterizerInstanced(
            MovedStatics.createGraphicsBuffer(this.width, this.height, Game.gameCanvas)
        );
        rasterizerTemp.drawFilledRectangle(0, 0, 241, 334, Integer.MAX_VALUE);
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
        rasterizerTemp.drawImage(part, x,currentY);
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
        if(MovedStatics.tabImageProducer == null) {
            return;
        }
        rasterizerTemp.copyPixels(
                MovedStatics.tabImageProducer.pixels,
                MovedStatics.tabImageProducer.width,
                MovedStatics.tabImageProducer.height,
                baseX + width / 2 - MovedStatics.tabImageProducer.width / 2,
                baseY + height / 2 - MovedStatics.tabImageProducer.height / 2);
        rasterizerTemp.drawImage(edgeLeft, baseX, baseY + height / 2 - edgeLeft.imageHeight / 2);
        rasterizerTemp.drawImage(edgeRight, baseX + width - edgeRight.imageWidth, baseY + height / 2 - edgeRight.imageHeight / 2);
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


        rasterizerTemp.drawImage(background, x + 24, y + 20);
        rasterizerTemp.drawImage(background, x + 24 + background.imageWidth, y + 20);
        rasterizerTemp.drawImage(background, x + 24 + background.imageWidth + 20, y + 20);

        rasterizerTemp.drawImage(background, x + 24, y + workingHeight - background.imageHeight - 20);
        rasterizerTemp.drawImage(background, x + 24 + background.imageWidth, y + workingHeight - background.imageHeight - 20);
        rasterizerTemp.drawImage(background, x + 24 + background.imageWidth + 20, y + workingHeight - background.imageHeight - 20);

        drawMiddlePiece(x, y, workingWidth, workingHeight);
        drawTopRow(x, y, workingWidth, workingHeight);
        drawBottomRow(x, y, workingWidth, workingHeight);

        System.arraycopy(rasterizerTemp.destinationPixels, 0, rasterizerInstanced.destinationPixels,0, rasterizerInstanced.destinationPixels.length);
    }

    private void drawBottomRow(int x, int y, int workingWidth, int workingHeight) {
        rasterizerTemp.drawImage(bottomRow, x - 4, y + workingHeight - bottomRow.imageHeight);
        int currentX = x;
        int currentY = y + workingHeight - bottomRow.imageHeight;
        if (6 < Game.currentTabId) {
            this.drawActiveTab(Game.currentTabId, currentY);

        }
        currentX += combat.imageWidth;
        rasterizerTemp.drawImage(friends, currentX, currentY);
        currentX += combat.imageWidth;
        rasterizerTemp.drawImage(ignores, currentX, currentY);
        currentX += combat.imageWidth;
        rasterizerTemp.drawImage(logout, currentX, currentY);
        currentX += combat.imageWidth;
        rasterizerTemp.drawImage(options, currentX, currentY);
        currentX += combat.imageWidth;
        rasterizerTemp.drawImage(emotes, currentX, currentY);
        currentX += combat.imageWidth;
        rasterizerTemp.drawImage(music, currentX, currentY);
    }



    private void drawTopRow(int x, int y, int workingWidth, int workingHeight) {
        rasterizerTemp.drawImage(topRow, x - 4, y);
        if (Game.currentTabId < 7) {
            this.drawActiveTab(Game.currentTabId, y);
        }
        int currentX = x;
        rasterizerTemp.drawImage(combat, currentX, y);
        currentX += stats.imageWidth;
        rasterizerTemp.drawImage(stats, currentX, y);
        currentX += stats.imageWidth;
        rasterizerTemp.drawImage(quests, currentX, y);
        currentX += stats.imageWidth;
        rasterizerTemp.drawImage(inventory, currentX, y);
        currentX += stats.imageWidth;
        rasterizerTemp.drawImage(equipment, currentX, y);
        currentX += stats.imageWidth;
        rasterizerTemp.drawImage(prayer, currentX, y);
        currentX += stats.imageWidth;
        rasterizerTemp.drawImage(magic, currentX, y);
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
                Game.currentTabId = i;


                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                return;
            }
        }

    }
}
