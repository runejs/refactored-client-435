package com.jagex.runescape;

import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.cache.media.gameInterface.GameInterfaceType;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.Timer;

import tech.henning.fourthreefive.Configuration;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;

public abstract class GameShell extends Canvas implements Runnable, FocusListener, WindowListener {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1;
    public static int[] anIntArray2 = new int[5];
    public static long[] aLongArray4 = new long[32];
    public static int anInt31;

    public static long exitTimeInMillis = 0L;
    public static Frame clientFrame;
    public static GameShell currentGameShell = null;
    public boolean gameShellError = false;


    public static void method19(boolean arg0) {
        if (Class57.gameSocket != null) {
            try {
                Buffer buffer = new Buffer(4);
                buffer.putByte(arg0 ? 2 : 3);
                buffer.putMediumBE(0);
                Class57.gameSocket.sendDataFromBuffer(4, 0, buffer.buffer);
            } catch (java.io.IOException ioexception) {
                ioexception.printStackTrace();
                try {
                    Class57.gameSocket.kill();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                Class57.gameSocket = null;
                MovedStatics.anInt2278++;
            }
        }

    }

    public static void runClientScriptsForInterface(int minY, int arg1, int scrollWidth, int arg3, int minX, int parentId, GameInterface[] interfaceCollection, int arg8, int scrollHeight) {
        for (int i = 0; i < interfaceCollection.length; i++) {
            GameInterface gameInterface = interfaceCollection[i];
            if (gameInterface != null && (gameInterface.type == GameInterfaceType.LAYER || gameInterface.hasListeners) && parentId == gameInterface.parentId && (!gameInterface.isHidden || PacketBuffer.hiddenButtonTest)) {
                int absoluteX = minX + gameInterface.currentX;
                int absoluteY = minY + gameInterface.currentY;
                if (!gameInterface.lockScroll)
                    absoluteY -= scrollHeight;
                int bottomLeftY = absoluteY + gameInterface.originalHeight;
                int i_4_ = Math.max(minY, absoluteY);
                if (!gameInterface.lockScroll)
                    absoluteX -= scrollWidth;
                int topRightX = absoluteX + gameInterface.originalWidth;
                int i_6_ = Math.max(minX, absoluteX);
                int i_7_ = Math.min(arg1, bottomLeftY);
                int i_8_ = Math.min(topRightX, arg8);
                if (gameInterface.type == GameInterfaceType.LAYER) {
                    runClientScriptsForInterface(i_4_, i_7_, gameInterface.scrollWidth, arg3, i_6_, i, interfaceCollection, i_8_, gameInterface.scrollPosition);
                    if (gameInterface.children != null)
                        runClientScriptsForInterface(i_4_, i_7_, gameInterface.scrollWidth, arg3, i_6_, gameInterface.id, gameInterface.children, i_8_, gameInterface.scrollPosition);
                }
                if (gameInterface.hasListeners) {
                    boolean bool;
                    bool = Class13.mouseX >= i_6_ && i_4_ <= Landscape.mouseY && i_8_ > Class13.mouseX && i_7_ > Landscape.mouseY;
                    boolean bool_9_ = false;
                    if (SpotAnimDefinition.mouseButtonPressed == 1 && bool)
                        bool_9_ = true;
                    boolean bool_10_ = false;
                    if (gameInterface.anInt2738 != -1 && bool_9_ && Wall.aGameInterface_353 == null) {
                        MovedStatics.anInt1996 = Class13.mouseX;
                        Wall.aGameInterface_353 = gameInterface;
                        MovedStatics.anInt2621 = Landscape.mouseY;
                    }
                    if (MouseHandler.clickType == 1 && i_6_ <= Class57.clickX && RSString.clickY >= i_4_ && Class57.clickX < i_8_ && RSString.clickY < i_7_)
                        bool_10_ = true;
                    if (Wall.aGameInterface_353 != null) {
                        bool_9_ = false;
                        bool = false;
                        bool_10_ = false;
                    }
                    if (!gameInterface.aBoolean2730 && bool_10_ && (0x1 & arg3) != 0) {
                        gameInterface.aBoolean2730 = true;
                        if (gameInterface.anObjectArray2681 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2681, 0, RSString.clickY + -absoluteY, gameInterface, Class57.clickX - absoluteX);
                    }
                    if (gameInterface.aBoolean2730 && bool_9_ && (arg3 & 0x4) != 0 && gameInterface.anObjectArray2747 != null)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2747, 0, -absoluteY + Landscape.mouseY, gameInterface, -absoluteX + Class13.mouseX);
                    if (gameInterface.aBoolean2730 && !bool_9_ && (0x2 & arg3) != 0) {
                        gameInterface.aBoolean2730 = false;
                        if (gameInterface.anObjectArray2707 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2707, 0, Landscape.mouseY - absoluteY, gameInterface, Class13.mouseX - absoluteX);
                    }
                    if (bool_9_ && (arg3 & 0x8) != 0 && gameInterface.anObjectArray2644 != null)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2644, 0, -absoluteY + Landscape.mouseY, gameInterface, -absoluteX + Class13.mouseX);
                    if (!gameInterface.aBoolean2682 && bool && (0x10 & arg3) != 0) {
                        gameInterface.aBoolean2682 = true;
                        if (gameInterface.anObjectArray2658 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2658, 0, Landscape.mouseY - absoluteY, gameInterface, Class13.mouseX - absoluteX);
                    }
                    if (gameInterface.aBoolean2682 && bool && (0x40 & arg3) != 0 && gameInterface.anObjectArray2680 != null)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2680, 0, -absoluteY + Landscape.mouseY, gameInterface, -absoluteX + Class13.mouseX);
                    if (gameInterface.aBoolean2682 && !bool && (arg3 & 0x20) != 0) {
                        gameInterface.aBoolean2682 = false;
                        if (gameInterface.anObjectArray2672 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2672, 0, -absoluteY + Landscape.mouseY, gameInterface, -absoluteX + Class13.mouseX);
                    }
                    if (gameInterface.anObjectArray2712 != null && (arg3 & 0x80) != 0)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2712, 0, 0, gameInterface, 0);
                    if (AnimationSequence.anInt2480 == MovedStatics.pulseCycle && gameInterface.anObjectArray2650 != null && (arg3 & 0x100) != 0)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2650, 0, 0, gameInterface, 0);
                }
            }
        }

    }

    public static void providesignlink(Signlink signlink) {
        Actor.signlink = Main.signlink = signlink;
    }

    public static int method27(int arg0, int arg1) {
        return arg0 ^ arg1;
    }

    public static void method28(long arg0) {
        if (arg0 != 0) {
            int i = 0;
            for (/**/; Player.friendsCount > i; i++) {
                if (Class59.friends[i] == arg0) {
                    Player.friendsCount--;
                    GameInterface.redrawTabArea = true;
                    for (int i_13_ = i; i_13_ < Player.friendsCount; i_13_++) {
                        Player.friendUsernames[i_13_] = Player.friendUsernames[1 + i_13_];
                        Player.friendWorlds[i_13_] = Player.friendWorlds[i_13_ + 1];
                        Class59.friends[i_13_] = Class59.friends[1 + i_13_];
                    }
                    SceneCluster.packetBuffer.putPacket(255);
                    SceneCluster.packetBuffer.putLongBE(arg0);
                    break;
                }
            }
        }
    }

    public static int method32(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if (!arg3)
            return -109;
        int i = 65536 + -Rasterizer3D.cosinetable[1024 * arg4 / arg1] >> 1;
        return ((65536 + -i) * arg0 >> 16) + (arg2 * i >> 16);
    }

    public void run() {
        if (Signlink.javaVendor != null) {
            String string = Signlink.javaVendor.toLowerCase();
            if (!string.contains("sun") && !string.contains("apple")) {
                if (string.contains("ibm") && (Signlink.javaVersion == null || Signlink.javaVersion.equals("1.4.2"))) {
                    openErrorPage("wrongjava");
                    return;
                }
            } else {
                String string_0_ = Signlink.javaVersion;
                if (string_0_.equals("1.1") || string_0_.startsWith("1.1.") || string_0_.equals("1.2") || string_0_.startsWith("1.2.")) {
                    openErrorPage("wrongjava");
                    return;
                }
                Class40_Sub3.anInt2024 = 5;
            }
        }
        if (Main.signlink.gameShell != null) {
            Method method = Signlink.aMethod724;
            if (method != null) {
                try {
                    method.invoke(Main.signlink.gameShell, Boolean.TRUE);
                } catch (Throwable throwable) {
                }
            }
        }
        setCanvas();
        ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = Class40_Sub5_Sub13.createGraphicsBuffer(Class12.width, IdentityKit.height, MouseHandler.gameCanvas);
        startup(true);
        SceneCluster.aTimer_768 = Timer.create();
        SceneCluster.aTimer_768.start();

        // Initialize client loop
        while (exitTimeInMillis == 0L || System.currentTimeMillis() < exitTimeInMillis) {
            Class40_Sub3.anInt2020 = SceneCluster.aTimer_768.sleep(Class39.anInt912, Class40_Sub3.anInt2024);
            for (int i = 0; i < Class40_Sub3.anInt2020; i++)
                method29(true);
            method26((byte) 88);
        }

        // If we ever escape from the client loop, exit
        closeGameShell();
    }

    public synchronized void closeGameShell() {
        if (!PacketBuffer.closedClient) {
            PacketBuffer.closedClient = true;
            try {
                MouseHandler.gameCanvas.removeFocusListener(this);
            } catch (Exception exception) {
                /* empty */
            }
            try {
                method24();
            } catch (Exception exception) {
                /* empty */
            }
            if (clientFrame != null) {
                try {
                    System.exit(0);
                } catch (Throwable throwable) {
                    /* empty */
                }
            }
            if (Main.signlink != null) {
                try {
                    Main.signlink.killSignlinkThread();
                } catch (Exception exception) {
                    /* empty */
                }
            }
        }
    }

    public void stop() {
        if (this == currentGameShell && !PacketBuffer.closedClient)
            exitTimeInMillis = System.currentTimeMillis() + 4000L;
    }

    public boolean verifyHost(int arg0) {
        String string = getDocumentBase().getHost().toLowerCase();
        if (arg0 != 31)
            return false;
        if (string.endsWith("runescape.com"))
            return true;
        if (string.endsWith("127.0.0.1"))
            return true;
        for (/**/; string.length() > 0 && string.charAt(string.length() - 1) >= '0' && string.charAt(string.length() + -1) <= 57; string = string.substring(0, string.length() - 1)) {
            /* empty */
        }
        if (string.endsWith("192.168.1."))
            return true;
        openErrorPage("invalidhost");
        return false;
    }

    public void windowOpened(WindowEvent arg0) {
    }

    public void openErrorPage(String gameError) {
        if (!gameShellError) {
            gameShellError = true;
            System.out.println("error_game_" + gameError);
            try {
//                getAppletContext().showDocument(new URL(getCodeBase(), ("error_game_" + gameError + ".ws")));
            } catch (Exception exception) {
            }
        }

    }

    public void start() {
        if (this == currentGameShell && !PacketBuffer.closedClient)
            exitTimeInMillis = 0L;
    }

    public abstract void processGameLoop();

    public void focusLost(FocusEvent arg0) {
        GenericTile.aBoolean1215 = false;
    }

    public abstract void method24();

    public synchronized void paint(Graphics arg0) {
        if (this == currentGameShell && !PacketBuffer.closedClient) {
            MovedStatics.clearScreen = true;
            if (Signlink.javaVersion == null || !Signlink.javaVersion.startsWith("1.5") || -MovedStatics.aLong174 + System.currentTimeMillis() <= 1000L)
                return;
            Rectangle rectangle = arg0.getClipBounds();
            if (rectangle == null || rectangle.width >= Class12.width && rectangle.height >= IdentityKit.height)
                MovedStatics.aBoolean1575 = true;
        }
    }

    public void destroy() {
        if (currentGameShell == this && !PacketBuffer.closedClient) {
            exitTimeInMillis = System.currentTimeMillis();
            Class43.sleep(5000L);
            Actor.signlink = null;
            closeGameShell();
        }
    }

    public void focusGained(FocusEvent arg0) {
        GenericTile.aBoolean1215 = true;
        MovedStatics.clearScreen = true;
    }

    public URL getDocumentBase() {
        try {
            return new URL("http://" + Configuration.SERVER_ADDRESS + ":" + Configuration.HTTP_PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayClientFrame(int clientVersion, int width, int height, int fileStoreId) {
        if (currentGameShell != null) {
            openErrorPage("alreadyloaded");
            return;
        }
        Class12.width = height;
        Class39.anInt901 = clientVersion;
        IdentityKit.height = width;
        currentGameShell = this;
        if (Main.signlink == null) {
            try {
                Actor.signlink = Main.signlink = new Signlink(false, this, InetAddress.getByName(getCodeBase().getHost()), fileStoreId, null, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Main.signlink.createThreadNode(1, this);
        windowActivated(null);
    }

    public void windowIconified(WindowEvent arg0) {
    }

    public void method26(byte arg0) {
        if (arg0 == 88) {
            long l = System.currentTimeMillis();
            long l_11_ = aLongArray4[PlayerAppearance.anInt681];
            aLongArray4[PlayerAppearance.anInt681] = l;
            if (l_11_ != 0 && l > l_11_) {
                int i = (int) (-l_11_ + l);
                GenericTile.fps = ((i >> 1) + 32000) / i;
            }
            PlayerAppearance.anInt681 = PlayerAppearance.anInt681 + 1 & 0x1f;
            if (MovedStatics.anInt938++ > 50) {
                MovedStatics.anInt938 -= 50;
                MovedStatics.clearScreen = true;
                MouseHandler.gameCanvas.setSize(Class12.width, IdentityKit.height);
                MouseHandler.gameCanvas.setVisible(true);
                MouseHandler.gameCanvas.setBackground(Color.BLACK);
                if (clientFrame == null)
                    MouseHandler.gameCanvas.setLocation(0, 0);
                else {
                    Insets insets = clientFrame.getInsets();
                    MouseHandler.gameCanvas.setLocation(insets.left, insets.top);
                }
            }
            method34(arg0 + -210);
        }
    }

//    public AppletContext getAppletContext() {
//        if(Class35.aFrame1732 != null)
//            return null;
//        if(ISAAC.aClass31_521 != null && ISAAC.aClass31_521.anApplet740 != this)
//            return ISAAC.aClass31_521.anApplet740.getAppletContext();
//        return super.getAppletContext();
//    }

    public void method29(boolean arg0) {
        long l = System.currentTimeMillis();
        long l_14_ = MovedStatics.aLongArray1614[MouseHandler.anInt1468];
        if (l_14_ != 0L && l > l_14_) {
            /* empty */
        }
        MovedStatics.aLongArray1614[MouseHandler.anInt1468] = l;
        MouseHandler.anInt1468 = 0x1f & MouseHandler.anInt1468 + 1;
        synchronized (this) {
            MovedStatics.aBoolean571 = GenericTile.aBoolean1215;
        }
        processGameLoop();
        if (arg0)
            return;
        windowIconified(null);
    }

    public void openClientApplet(String cacheFolder, int cacheIndexes, int fileStoreId, InetAddress inetAddress, int clientVersion) {
        try {
            int height = 503;
            int width = 765;
            Class39.anInt901 = clientVersion;
            Class12.width = width;
            IdentityKit.height = height;
            currentGameShell = this;
            clientFrame = new Frame();
            clientFrame.setTitle("Jagex");
//            Class35.aFrame1732.setResizable(false);
            ScreenController.frameMode(ScreenMode.FIXED);
            clientFrame.setPreferredSize(new Dimension(width, height));
            clientFrame.setResizable(ScreenController.frameMode == ScreenMode.RESIZABLE);
            clientFrame.addWindowListener(this);
            clientFrame.setVisible(true);
            clientFrame.toFront();
            Insets insets = clientFrame.getInsets();
            clientFrame.setSize(insets.right + width + insets.left, insets.bottom + insets.top + height);
//            Class35.aFrame1732.setLocationRelativeTo(null);
            Actor.signlink = Main.signlink = new Signlink(true, null, inetAddress, fileStoreId, cacheFolder, cacheIndexes);
            Main.signlink.createThreadNode(1, this);
        } catch (Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }

    public URL getCodeBase() {
        return this.getDocumentBase();
    }

    public abstract void startup(boolean bool);

    public void update(Graphics graphics) {
        paint(graphics);
    }

    public void windowClosing(WindowEvent windowEvent) {
        destroy();
    }

//    public String getParameter(String parameter) {
//        if(Class35.aFrame1732 != null)
//            return null;
//        if(ISAAC.aClass31_521 != null && this != ISAAC.aClass31_521.anApplet740)
//            return ISAAC.aClass31_521.anApplet740.getParameter(parameter);
//        return super.getParameter(parameter);
//    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public synchronized void setCanvas() {
        Container container = clientFrame;
//        else
//            container = ISAAC.aClass31_521.anApplet740;
        if (MouseHandler.gameCanvas != null) {
            MouseHandler.gameCanvas.removeFocusListener(this);
            container.remove(MouseHandler.gameCanvas);
        }
        MouseHandler.gameCanvas = new RSCanvas(this);
        container.add(MouseHandler.gameCanvas);
        MouseHandler.gameCanvas.setSize(Class12.width, IdentityKit.height);
        MouseHandler.gameCanvas.setVisible(true);
        if (clientFrame != null) {
            Insets insets = clientFrame.getInsets();
            MouseHandler.gameCanvas.setLocation(insets.left, insets.top);
        } else
            MouseHandler.gameCanvas.setLocation(0, 0);
        MouseHandler.gameCanvas.addFocusListener(this);
        MouseHandler.gameCanvas.requestFocus();
        MovedStatics.clearScreen = true;
        MovedStatics.aBoolean1575 = false;
        MovedStatics.aLong174 = System.currentTimeMillis();
    }

    public abstract void method34(int i);

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }
}
