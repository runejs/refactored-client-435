package org.runejs.client;

import org.runejs.client.cache.def.IdentityKit;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.outbound.chat.ModifySocialListOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.Timer;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.Configuration;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;

public abstract class GameShell extends Canvas implements Runnable, FocusListener, WindowListener {
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the left-hand side of the top,
     * but not the furthest-left (see `tabHighlightImageTopLeftEdge` for that).
     */
    public static IndexedImage tabHighlightImageTopLeft;
    public static int[] anIntArray2 = new int[5];
    public static long[] tickSamples = new long[32];
    public static int anInt31;

    public static long exitTimeInMillis = 0L;
    public static Frame clientFrame;
    public static GameShell currentGameShell = null;
    public static int millisPerTick = 20;
    public boolean gameShellError = false;


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
                    if (MouseHandler.currentMouseButtonPressed == 1 && bool)
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

                    OutgoingPackets.sendMessage(
                        new ModifySocialListOutboundMessage(arg0, ModifySocialListOutboundMessage.SocialList.FRIEND, ModifySocialListOutboundMessage.SocialListAction.REMOVE));
                    break;
                }
            }
        }
    }

    public static int interpolate(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
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
        ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = MovedStatics.createGraphicsBuffer(Class12.width, IdentityKit.height, MouseHandler.gameCanvas);
        startup();
        SceneCluster.gameTimer = Timer.create();
        SceneCluster.gameTimer.start();

        // Initialize client loop
        while (exitTimeInMillis == 0L || System.currentTimeMillis() < exitTimeInMillis) {
            Class40_Sub3.ticksPerLoop = SceneCluster.gameTimer.getTicks(millisPerTick, Class40_Sub3.anInt2024);
            for (int currentTick = 0; currentTick < Class40_Sub3.ticksPerLoop; currentTick++) {
                long currentTimeMillis = System.currentTimeMillis();

                // Saves the time this particular tick is being processed on
                MovedStatics.tickSamples[MouseHandler.currentTickSample] = currentTimeMillis;

                // Increases the current tick identifier by 1, looping at 31 back to 0 (including 31)
                // This means the client stores the last 32 tick times to do some other calculations
                MouseHandler.currentTickSample = 0x1f & MouseHandler.currentTickSample + 1;

                synchronized (this) {
                    MovedStatics.aBoolean571 = GenericTile.clientFocused;
                }

                processGameLoop();
            }

            runAfterGameLoop();
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
        GenericTile.clientFocused = false;
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
            Class43.threadSleep(5000L);
            Actor.signlink = null;
            closeGameShell();
        }
    }

    public void focusGained(FocusEvent arg0) {
        GenericTile.clientFocused = true;
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

    public void runAfterGameLoop() {
        long currentTimeMillis = System.currentTimeMillis();
        long lastTickInMillis = tickSamples[PlayerAppearance.currentTickSample];

        // Saves the time this particular tick is being processed on
        tickSamples[PlayerAppearance.currentTickSample] = currentTimeMillis;

        if (lastTickInMillis != 0 && currentTimeMillis > lastTickInMillis) {
            int i = (int) (currentTimeMillis - lastTickInMillis);
            int maxSamples = tickSamples.length;
            GenericTile.fps = ((i >> 1) + (maxSamples * 1000)) / i;
        }

        // Increases the current tick identifier by 1, looping at 31 back to 0 (including 31)
        // This means the client stores the last 32 tick times to do some other calculations
        PlayerAppearance.currentTickSample = PlayerAppearance.currentTickSample + 1 & 0x1f;

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
        updateStatusText();
    }

//    public AppletContext getAppletContext() {
//        if(Class35.aFrame1732 != null)
//            return null;
//        if(ISAAC.aClass31_521 != null && ISAAC.aClass31_521.anApplet740 != this)
//            return ISAAC.aClass31_521.anApplet740.getAppletContext();
//        return super.getAppletContext();
//    }

    public void openClientApplet(String cacheFolder, int cacheIndexes, int fileStoreId, InetAddress inetAddress, int clientVersion) {
        try {
            int height = 503;
            int width = 765;
            Class39.anInt901 = clientVersion;
            Class12.width = width;
            IdentityKit.height = height;
            currentGameShell = this;
            clientFrame = new Frame();
            clientFrame.setTitle(Configuration.SERVER_DISPLAY_NAME);
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

    public abstract void startup();

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

    public abstract void updateStatusText();

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }
}
