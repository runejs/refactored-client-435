package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

import java.awt.*;
import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener, MouseWheelListener {
    public static int anInt1450;
    public static Cache modelCache;
    public static int anInt1457 = -1;
    public static RSString aClass1_1463;
    public static RSString aClass1_1464;
    public static RSString aClass1_1465;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array1466;
    public static int anInt1468;
    public static Canvas aCanvas1469;
    public static int clickType;
    public static RSString aClass1_1471;
    public static int chatboxScrollMax;
    public static byte[][][] tile_overlayids;
    public static RSString aClass1_1474;
    public static int cameraZoom = 600;
    public boolean mouseWheelDown;
    public int mouseWheelX;
    public int mouseWheelY;

    static {
        anInt1450 = -1;
        modelCache = new Cache(50);
        aClass1_1464 = RSString.CreateString(" is already on your friend list");
        aClass1_1465 = aClass1_1464;
        aClass40_Sub5_Sub14_Sub4Array1466 = new ImageRGB[1000];
        aClass1_1463 = RSString.CreateString("wave2:");
        clickType = 0;
        chatboxScrollMax = 78;
        aClass1_1471 = RSString.CreateString("Lade Titelbild )2 ");
        aClass1_1474 = aClass1_1463;
    }

    public static void method1001() {
        aClass1_1471 = null;
        aClass40_Sub5_Sub14_Sub4Array1466 = null;
        aClass1_1465 = null;
        aClass1_1463 = null;
        modelCache = null;
        aCanvas1469 = null;
        aClass1_1464 = null;
        aClass1_1474 = null;
        tile_overlayids = null;
    }

    public static void method1002(int arg0) {
        if(SceneTile.activeInterfaceType == 0) {
            if(arg0 > -60)
                clickType = -90;
            int i = clickType;
            if(Main.widgetSelected == 1 && Class57.anInt1338 >= 516 && RSString.anInt1668 >= 160 && Class57.anInt1338 <= 765 && RSString.anInt1668 <= 205)
                i = 0;
            if(Class4.menuOpen) {
                if(i != 1) {
                    int i_3_ = Class13.mouseX;
                    int i_4_ = Landscape.mouseY;
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                        i_3_ -= 4;
                        i_4_ -= 4;
                    }
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                        i_4_ -= 205;
                        i_3_ -= 553;
                    }
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                        i_4_ -= 357;
                        i_3_ -= 17;
                    }
                    if((-10 + InteractiveObject.anInt475 > i_3_) || 10 + VertexNormal.anInt1086 + InteractiveObject.anInt475 < i_3_ || (i_4_ < Main.anInt1758 + -10) || ((i_4_ > Main.anInt1758 + CollisionMap.anInt168 + 10))) {
                        if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1)
                            ISAAC.redrawTabArea = true;
                        Class4.menuOpen = false;
                        if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
                            GenericTile.redrawChatbox = true;
                    }
                }
                if(i == 1) {
                    int i_5_ = InteractiveObject.anInt475;
                    int i_6_ = Main.anInt1758;
                    int i_7_ = VertexNormal.anInt1086;
                    int i_8_ = Class57.anInt1338;
                    int i_9_ = -1;
                    int i_10_ = RSString.anInt1668;
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                        i_8_ -= 4;
                        i_10_ -= 4;
                    }
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                        i_8_ -= 553;
                        i_10_ -= 205;
                    }
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                        i_8_ -= 17;
                        i_10_ -= 357;
                    }
                    for(int i_11_ = 0; ((i_11_ < ActorDefinition.menuActionRow)); i_11_++) {
                        int i_12_ = 31 + i_6_ + 15 * (ActorDefinition.menuActionRow + -1 - i_11_);
                        if(i_8_ > i_5_ && i_8_ < i_7_ + i_5_ && i_10_ > -13 + i_12_ && i_10_ < 3 + i_12_)
                            i_9_ = i_11_;
                    }
                    if(i_9_ != -1)
                        Class27.doAction(109, i_9_);
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1)
                        ISAAC.redrawTabArea = true;
                    Class4.menuOpen = false;
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
                        GenericTile.redrawChatbox = true;
                }
            } else {
                if(i == 1 && ActorDefinition.menuActionRow > 0) {
                    int i_0_ = (Class38.menuActionTypes[ActorDefinition.menuActionRow - 1]);
                    if(i_0_ == 53 || i_0_ == 25 || i_0_ == 55 || i_0_ == 48 || i_0_ == 24 || i_0_ == 52 || i_0_ == 6 || i_0_ == 31 || i_0_ == 43 || i_0_ == 11 || i_0_ == 19 || i_0_ == 1006) {
                        int i_1_ = (InteractiveObject.firstMenuOperand[ActorDefinition.menuActionRow - 1]);
                        int i_2_ = (Class59.secondMenuOperand[-1 + ActorDefinition.menuActionRow]);
                        Widget widget = Widget.forId(i_2_);
                        if(widget.itemSwapable || widget.itemDeletesDraged) {
                            Renderable.anInt2869 = Class57.anInt1338;
                            Class40_Sub5_Sub15.aBoolean2784 = false;
                            SceneTile.activeInterfaceType = 2;
                            Class48.modifiedWidgetId = i_2_;
                            ItemDefinition.anInt2798 = RSString.anInt1668;
                            GroundItemTile.selectedInventorySlot = i_1_;
                            if(i_2_ >> 16 == HuffmanEncoding.openScreenWidgetId)
                                SceneTile.activeInterfaceType = 1;
                            if(Class43.openChatboxWidgetId == i_2_ >> 16)
                                SceneTile.activeInterfaceType = 3;
                            Buffer.anInt1978 = 0;
                            return;
                        }
                    }
                }
                if(i == 1 && (Class68.anInt1630 == 1 || Class33.method409((byte) 46, -1 + ActorDefinition.menuActionRow)) && ActorDefinition.menuActionRow > 2)
                    i = 2;
                if(i == 1 && ActorDefinition.menuActionRow > 0)
                    Class27.doAction(59, ActorDefinition.menuActionRow + -1);
                if(i == 2 && ActorDefinition.menuActionRow > 0)
                    Class60.method990(11451);
            }
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
        if(mouseX > 0 && mouseY > 346 && mouseX < 516 && mouseY < 505 && Class43.openChatboxWidgetId == -1) {
            if(rotation < 0) {
                if(Class12.chatboxInterface.scrollPosition >= 1) {

                    if(Class40_Sub5_Sub15.inputType == 3) {
                        Class26.itemSearchScroll = Class26.itemSearchScroll - 30;
                        GenericTile.redrawChatbox = true;
                    } else {
                        GameObjectDefinition.chatboxScroll = GameObjectDefinition.chatboxScroll + 30;
                        GenericTile.redrawChatbox = true;
                    }
                }
            } else if(Class40_Sub5_Sub15.inputType == 3) {
                Class26.itemSearchScroll = Class26.itemSearchScroll + 30;
                GenericTile.redrawChatbox = true;
            } else if(GameObjectDefinition.chatboxScroll < 1) {
                Class26.itemSearchScroll = 0;
                GenericTile.redrawChatbox = true;
            } else {
                GameObjectDefinition.chatboxScroll = GameObjectDefinition.chatboxScroll - 30;
                GenericTile.redrawChatbox = true;
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
