package com.jagex.runescape.input;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

import java.awt.*;
import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener, MouseWheelListener {
    public static int anInt1450 = -1;
    public static Cache modelCache = new Cache(50);
    public static int anInt1457 = -1;
    public static RSString aClass1_1463 = RSString.CreateString("wave2:");
    public static RSString aClass1_1464 = RSString.CreateString(" is already on your friend list");
    public static RSString aClass1_1465;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array1466 = new ImageRGB[1000];
    public static int anInt1468;
    public static Canvas aCanvas1469;
    public static int clickType = 0;
    public static byte[][][] tile_overlayids;
    public static RSString aClass1_1474;
    public static int cameraZoom = 600;
    public boolean mouseWheelDown;
    public int mouseWheelX;
    public int mouseWheelY;

    static {
        aClass1_1465 = aClass1_1464;
        aClass1_1474 = aClass1_1463;
    }

    public static void method1001() {
        aClass40_Sub5_Sub14_Sub4Array1466 = null;
        aClass1_1465 = null;
        aClass1_1463 = null;
        modelCache = null;
        aCanvas1469 = null;
        aClass1_1464 = null;
        aClass1_1474 = null;
        tile_overlayids = null;
    }

    public static void processMenuClick() {
        if(SceneTile.activeInterfaceType != 0) {
            return;
        }
        int meta = clickType;
        if(Main.widgetSelected == 1 && Class57.clickX >= 516 && RSString.clickY >= 160 && Class57.clickX <= 765 && RSString.clickY <= 205)
            meta = 0;
        if(Class4.menuOpen) {
            if(meta != 1) {
                int x = Class13.mouseX;
                int y = Landscape.mouseY;
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                    x -= 4;
                    y -= 4;
                }
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                    y -= 205;
                    x -= 553;
                }
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                    y -= 357;
                    x -= 17;
                }
                if((-10 + InteractiveObject.menuOffsetX > x) || 10 + VertexNormal.menuWidth + InteractiveObject.menuOffsetX < x || (y < Main.menuOffsetY + -10) || ((y > Main.menuOffsetY + CollisionMap.menuHeight + 10))) {
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1)
                        ISAAC.redrawTabArea = true;
                    Class4.menuOpen = false;
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
                        ChatBox.redrawChatbox = true;
                }
            }
            if(meta == 1) {
                int menuX = InteractiveObject.menuOffsetX;
                int menuY = Main.menuOffsetY;
                int dx = VertexNormal.menuWidth;
                int x = Class57.clickX;
                int y = RSString.clickY;
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                    x -= 4;
                    y -= 4;
                }
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                    x -= 553;
                    y -= 205;
                }
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                    x -= 17;
                    y -= 357;
                }
                int id = -1;
                for(int row = 0; ((row < ActorDefinition.menuActionRow)); row++) {
                    int k3 = 31 + menuY + 15 * (ActorDefinition.menuActionRow + -1 - row);
                    if(x > menuX && x < dx + menuX && y > -13 + k3 && y < 3 + k3)
                        id = row;
                }
                if(id != -1)
                    Class27.processMenuActions(109, id);
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1)
                    ISAAC.redrawTabArea = true;
                Class4.menuOpen = false;
                if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
                    ChatBox.redrawChatbox = true;
            }
        } else {
            if(meta == 1 && ActorDefinition.menuActionRow > 0) {
                int action = (Class38.menuActionTypes[ActorDefinition.menuActionRow - 1]);
                if(action == 53 || action == 25 || action == 55 || action == 48 || action == 24 || action == 52 || action == 6 || action == 31 || action == 43 || action == 11 || action == 19 || action == 1006) {
                    int item = (InteractiveObject.firstMenuOperand[ActorDefinition.menuActionRow - 1]);
                    int id = (Class59.secondMenuOperand[-1 + ActorDefinition.menuActionRow]);
                    Widget widget = Widget.forId(id);
                    if(widget.itemSwapable || widget.itemDeletesDraged) {
                        Renderable.anInt2869 = Class57.clickX;
                        Class40_Sub5_Sub15.lastItemDragged = false;
                        SceneTile.activeInterfaceType = 2;
                        Class48.modifiedWidgetId = id;
                        ItemDefinition.anInt2798 = RSString.clickY;
                        GroundItemTile.selectedInventorySlot = item;
                        if(id >> 16 == HuffmanEncoding.openScreenWidgetId)
                            SceneTile.activeInterfaceType = 1;
                        if(ChatBox.openChatboxWidgetId == id >> 16)
                            SceneTile.activeInterfaceType = 3;
                        Buffer.lastItemDragTime = 0;
                        return;
                    }
                }
            }
            if(meta == 1 && (Class68.oneMouseButton == 1 || Class33.menuHasAddFriend((byte) 46, -1 + ActorDefinition.menuActionRow)) && ActorDefinition.menuActionRow > 2)
                meta = 2;
            if(meta == 1 && ActorDefinition.menuActionRow > 0)
                Class27.processMenuActions(59, ActorDefinition.menuActionRow + -1);
            if(meta == 2 && ActorDefinition.menuActionRow > 0)
                Class60.determineMenuSize();
        }
    }

    public static Class40_Sub9_Sub1 method1003(Signlink arg0, Component arg1, int arg2) {

        if(arg2 != 29914)
            tile_overlayids = null;
        Class68.method1040(arg1, 0, arg0);
        Class40_Sub9_Sub1 class40_sub9_sub1 = new Class40_Sub9_Sub1();
        Class8.method218(class40_sub9_sub1);
        return class40_sub9_sub1;

    }

    public synchronized void mouseEntered(MouseEvent arg0) {
        if(GameObject.frame != null) {
            LinkedList.anInt1073 = 0;
            Class12.eventMouseX = arg0.getX();
            Cache.eventMouseY = arg0.getY();
        }
    }

    public synchronized void mouseExited(MouseEvent arg0) {
        if(GameObject.frame != null) {
            LinkedList.anInt1073 = 0;
            Class12.eventMouseX = -1;
            Cache.eventMouseY = -1;
        }
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if(GameObject.frame != null)
            Cache.mouseButtonPressed = 0;
    }

    public synchronized void mouseDragged(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();
        if(GameObject.frame != null) {
            LinkedList.anInt1073 = 0;
        }
        if(mouseWheelDown) {
            mouseY = mouseWheelX - mouseEvent.getX();
            int k = mouseWheelY - mouseEvent.getY();
            mouseWheelDragged(mouseY, -k);
            mouseWheelX = mouseEvent.getX();
            mouseWheelY = mouseEvent.getY();
            return;
        }
        Class12.eventMouseX = mouseX;
        Cache.eventMouseY = mouseY;
    }

    private void mouseWheelDragged(int i, int j) {
        LinkedList.anInt1073 = 0;

        if(!mouseWheelDown)
            return;
        Wall.cameraVelocityHorizontal += i * 3;
        Class60.cameraVelocityVertical += (j << 1);
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void mousePressed(MouseEvent event) {
        if(GameObject.frame != null) {

            int mouseX = event.getX();
            int mouseY = event.getY();
            LinkedList.anInt1073 = 0;
            Class55.eventClickX = event.getX();
            Class40_Sub5_Sub11.eventClickY = event.getY();
            OverlayDefinition.lastClick = System.currentTimeMillis();
            if(event.getButton() == MouseEvent.BUTTON2) {
                mouseWheelDown = true;
                mouseWheelX = mouseX;
                mouseWheelY = mouseY;
                return;
            }
            if(event.isMetaDown() || event.getButton() == MouseEvent.BUTTON3) {
                Actor.eventMouseButtonPressed = 2;
                Cache.mouseButtonPressed = 2;
            } else {
                Actor.eventMouseButtonPressed = 1;
                Cache.mouseButtonPressed = 1;
            }
        }
        if(event.isPopupTrigger())
            event.consume();
    }

    public void mouseWheelMoved(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        LinkedList.anInt1073 = 0;

        if(!handleInterfaceScrolling(event)) {
            if((cameraZoom <= 150 && rotation <= 0) || (cameraZoom >= 1600 && rotation >= 0)) {
                return;
            }
            int diff = rotation * 8;
            cameraZoom = cameraZoom + diff;
        }
    }

    public void mouseClicked(MouseEvent arg0) {
        if(arg0.isPopupTrigger())
            arg0.consume();
    }

    public boolean handleInterfaceScrolling(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        int mouseX = Class12.eventMouseX;
        int mouseY = Cache.eventMouseY;
        if(mouseX > 0 && mouseY > 346 && mouseX < 516 && mouseY < 505 && ChatBox.openChatboxWidgetId == -1) {
            if(rotation < 0) {
                if(Class12.chatboxInterface.scrollPosition >= 1) {

                    if(ChatBox.inputType == 3) {
                        ChatBox.itemSearchScroll = ChatBox.itemSearchScroll - 30;
                        ChatBox.redrawChatbox = true;
                    } else {
                        ChatBox.chatboxScroll = ChatBox.chatboxScroll + 30;
                        ChatBox.redrawChatbox = true;
                    }
                }
            } else if(ChatBox.inputType == 3) {
                ChatBox.itemSearchScroll = ChatBox.itemSearchScroll + 30;
                ChatBox.redrawChatbox = true;
            } else if(ChatBox.chatboxScroll < 1) {
                ChatBox.itemSearchScroll = 0;
                ChatBox.redrawChatbox = true;
            } else {
                ChatBox.chatboxScroll = ChatBox.chatboxScroll - 30;
                ChatBox.redrawChatbox = true;
            }
            return true;
        } else {
            int positionX = 0;
            int positionY = 0;
            int width = 0;
            int height = 0;
            int offsetX = 0;
            int offsetY = 0;
            int childID = 0;
            /* Tab interface scrolling */
            int tabInterfaceID = Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId];
            if(tabInterfaceID != -1) {
                offsetX = 765 - 218;
                offsetY = 503 - 298;
                for(int index = 0; index < Widget.interfaces[tabInterfaceID].length; index++) {
                    if(Widget.interfaces[tabInterfaceID][index].scrollHeight > 0) {
                        childID = index;
                        positionX = Widget.interfaces[tabInterfaceID][index].currentX;
                        positionY = Widget.interfaces[tabInterfaceID][index].currentY;
                        width = Widget.interfaces[tabInterfaceID][index].originalWidth;
                        height = Widget.interfaces[tabInterfaceID][index].originalHeight;
                        break;
                    }
                }
                if(mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
                    Widget.interfaces[tabInterfaceID][childID].scrollPosition += rotation * 30;
                    //				client.tabAreaAltered = true;
                    ISAAC.redrawTabArea = true;
                    return true;
                }
            }
            /* Main interface scrolling */
            if(HuffmanEncoding.openScreenWidgetId != -1) {
                offsetX = 4;
                offsetY = 4;
                int widgetid = HuffmanEncoding.openScreenWidgetId;
                for(int index = 0; index < Widget.interfaces[widgetid].length; index++) {
                    if(Widget.interfaces[widgetid][index].scrollHeight > 0) {
                        childID = index;
                        positionX = Widget.interfaces[widgetid][index].currentX;
                        positionY = Widget.interfaces[widgetid][index].currentY;
                        width = Widget.interfaces[widgetid][index].originalWidth;
                        height = Widget.interfaces[widgetid][index].originalHeight;
                        break;
                    }
                }
                if(mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
                    Widget.interfaces[widgetid][childID].scrollPosition += rotation * 30;
                    return true;
                }

            } else if(Console.console.consoleOpen) {
                Console.console.currentScroll -= rotation * 18;
                if(Console.console.currentScroll < 0) {
                    Console.console.currentScroll = 0;
                }
                if(Console.console.currentScroll > Console.console.getMaxScroll() - 308) {
                    Console.console.currentScroll = Console.console.getMaxScroll() - 308;
                }
                return true;
            }
        }
        return false;


    }


    public synchronized void mouseMoved(MouseEvent arg0) {
        if(GameObject.frame != null) {
            LinkedList.anInt1073 = 0;
            Class12.eventMouseX = arg0.getX();
            Cache.eventMouseY = arg0.getY();
        }
    }

    public synchronized void mouseReleased(MouseEvent arg0) {
        if(GameObject.frame != null) {
            LinkedList.anInt1073 = 0;
            Cache.mouseButtonPressed = 0;
            mouseWheelDown = false;
        }
        if(arg0.isPopupTrigger())
            arg0.consume();
    }
}
