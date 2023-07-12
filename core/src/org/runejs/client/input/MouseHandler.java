package org.runejs.client.input;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.console.Console;
import org.runejs.client.scene.SceneCamera;
import org.runejs.client.*;

import java.awt.*;
import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener, MouseWheelListener {
    public static int clickType = 0;
    public static int currentMouseButtonPressed = 0;
    public static volatile int mouseButtonPressed = 0;
    public static volatile int eventMouseButtonPressed = 0;
    public static volatile int eventMouseX = -1;
    public static volatile int eventMouseY = -1;
    public static int mouseX = 0;
    public static int mouseY = 0;
    public static int clickX = 0;
    public static int clickY = 0;
    public static long clickTime = 0L;
    public static int cursorY = 0;
    public static int cursorX = 0;
    public static boolean gameScreenClickable = false;
    public static volatile int framesSinceMouseInput = 0;
    private static volatile int eventClickX = 0;
    private static volatile long lastClick = 0L;
    public boolean mouseWheelDown;
    public int mouseWheelX;
    public int mouseWheelY;

    public static void method1015() {
        synchronized (Game.mouseHandler) {
            currentMouseButtonPressed = mouseButtonPressed;
            mouseX = eventMouseX;
            mouseY = eventMouseY;
            clickType = eventMouseButtonPressed;
            clickX = eventClickX;
            clickY = MovedStatics.eventClickY;
            clickTime = lastClick;
            eventMouseButtonPressed = 0;
        }
    }

    public static void removeListeners(Component arg1) {
        arg1.removeMouseListener(Game.mouseHandler);
        arg1.removeMouseMotionListener(Game.mouseHandler);
        arg1.removeFocusListener(Game.mouseHandler);
    }

    public static void addListeners(Component arg0) {
        arg0.addMouseListener(Game.mouseHandler);
        arg0.addMouseMotionListener(Game.mouseHandler);
        arg0.addFocusListener(Game.mouseHandler);
        arg0.addMouseWheelListener(Game.mouseHandler);
    }

    public static int resetFramesSinceMouseInput() {
        return framesSinceMouseInput++;
    }

    public static void setFramesSinceMouseInput(int arg1) {
        framesSinceMouseInput = arg1;
    }

    public synchronized void mouseEntered(MouseEvent arg0) {
        if(Game.mouseHandler != null) {
            framesSinceMouseInput = 0;
            eventMouseX = arg0.getX();
            eventMouseY = arg0.getY();
        }
    }

    public synchronized void mouseExited(MouseEvent arg0) {
        if(Game.mouseHandler != null) {
            framesSinceMouseInput = 0;
            eventMouseX = -1;
            eventMouseY = -1;
        }
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if(Game.mouseHandler != null)
            mouseButtonPressed = 0;
    }

    public synchronized void mouseDragged(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();
        if(Game.mouseHandler != null) {
            framesSinceMouseInput = 0;
        }
        if(mouseWheelDown) {
            mouseY = mouseWheelX - mouseEvent.getX();
            int k = mouseWheelY - mouseEvent.getY();
            mouseWheelDragged(mouseY, -k);
            mouseWheelX = mouseEvent.getX();
            mouseWheelY = mouseEvent.getY();
            return;
        }
        eventMouseX = mouseX;
        eventMouseY = mouseY;
    }

    private void mouseWheelDragged(int i, int j) {
        framesSinceMouseInput = 0;

        if(!mouseWheelDown)
            return;
        SceneCamera.cameraVelocityYaw += i * 3;
        SceneCamera.cameraVelocityPitch += j << 1;
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void mousePressed(MouseEvent event) {
        if(Game.mouseHandler != null) {
            int mouseX = event.getX();
            int mouseY = event.getY();
            framesSinceMouseInput = 0;
            eventClickX = mouseX;
            MovedStatics.eventClickY = mouseY;
            lastClick = System.currentTimeMillis();
            if(event.getButton() == MouseEvent.BUTTON2) {
                mouseWheelDown = true;
                mouseWheelX = mouseX;
                mouseWheelY = mouseY;
                return;
            }
            if(event.isMetaDown() || event.getButton() == MouseEvent.BUTTON3) {
                eventMouseButtonPressed = 2;
                mouseButtonPressed = 2;
            } else {
                eventMouseButtonPressed = 1;
                mouseButtonPressed = 1;
            }
        }
        if(event.isPopupTrigger())
            event.consume();
    }

    public void mouseWheelMoved(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        framesSinceMouseInput = 0;

        if(!handleInterfaceScrolling(event)) {
            int currentZoom = Game.playerCamera.getZoom();
            if(currentZoom <= 150 && rotation <= 0 || currentZoom >= 1600 && rotation >= 0) {
                return;
            }
            int diff = rotation * 64;
            SceneCamera.cameraVelocityZoom += diff;
        }
    }

    public void mouseClicked(MouseEvent arg0) {
        if(arg0.isPopupTrigger())
            arg0.consume();
    }

    public boolean handleInterfaceScrolling(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        int mouseX = eventMouseX;
        int mouseY = eventMouseY;
        if(ScreenController.isCoordinatesInExtendedChatArea(mouseX, mouseY) && GameInterface.chatboxInterfaceId == -1) {
            if(rotation < 0) {
                if(Game.chatboxInterface.scrollPosition >= 1) {

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
            int tabInterfaceID = Game.tabWidgetIds[Game.currentTabId];
            if(tabInterfaceID != -1) {
                if(ScreenController.frameMode == ScreenMode.FIXED) {
                    offsetX = 765 - 218;
                    offsetY = 503 - 298;
                } else {
                    offsetX= ScreenController.drawWidth - 218;
                    offsetY = ScreenController.drawHeight - 298;
                }
                for(int index = 0; index < GameInterface.cachedInterfaces[tabInterfaceID].length; index++) {
                    if(GameInterface.cachedInterfaces[tabInterfaceID][index].scrollHeight > 0) {
                        childID = index;
                        positionX = GameInterface.cachedInterfaces[tabInterfaceID][index].currentX;
                        positionY = GameInterface.cachedInterfaces[tabInterfaceID][index].currentY;
                        width = GameInterface.cachedInterfaces[tabInterfaceID][index].originalWidth;
                        height = GameInterface.cachedInterfaces[tabInterfaceID][index].originalHeight;
                        break;
                    }
                }
                if(mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
                    GameInterface.cachedInterfaces[tabInterfaceID][childID].scrollPosition += rotation * 30;
                    //				client.tabAreaAltered = true;
                    GameInterface.redrawTabArea = true;
                    return true;
                }
            }
            /* Main interface scrolling */
            if(GameInterface.gameScreenInterfaceId != -1) {
                offsetX = 4;
                offsetY = 4;
                int widgetid = GameInterface.gameScreenInterfaceId;
                for(int index = 0; index < GameInterface.cachedInterfaces[widgetid].length; index++) {
                    if(GameInterface.cachedInterfaces[widgetid][index].scrollHeight > 0) {
                        childID = index;
                        positionX = GameInterface.cachedInterfaces[widgetid][index].currentX;
                        positionY = GameInterface.cachedInterfaces[widgetid][index].currentY;
                        width = GameInterface.cachedInterfaces[widgetid][index].originalWidth;
                        height = GameInterface.cachedInterfaces[widgetid][index].originalHeight;
                        break;
                    }
                }
                if(ScreenController.frameMode != ScreenMode.FIXED) {
                    int yScreenOffset = (ScreenController.drawHeight /2) - (334/2) - (184/2);
                    int xScreenOffset = (ScreenController.drawWidth /2) - (512/2) - (234/3);
                    positionX += xScreenOffset;
                    positionY += yScreenOffset;
                    width+= xScreenOffset;
                    height+= yScreenOffset;
                }
                if(mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
                    GameInterface.cachedInterfaces[widgetid][childID].scrollPosition += rotation * 30;
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
        if(Game.mouseHandler != null) {
            framesSinceMouseInput = 0;
            eventMouseX = arg0.getX();
            eventMouseY = arg0.getY();
        }
    }

    public synchronized void mouseReleased(MouseEvent arg0) {
        if(Game.mouseHandler != null) {
            framesSinceMouseInput = 0;
            mouseButtonPressed = 0;
            mouseWheelDown = false;
        }
        if(arg0.isPopupTrigger())
            arg0.consume();
    }
}
