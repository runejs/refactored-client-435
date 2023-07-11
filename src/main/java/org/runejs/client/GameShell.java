package org.runejs.client;

import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.Timer;

import org.runejs.Configuration;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;

public abstract class GameShell extends Canvas implements Runnable, FocusListener, WindowListener {
    public static long[] tickSamples = new long[32];

    public static long exitTimeInMillis = 0L;
    public static Frame clientFrame;
    public static GameShell currentGameShell = null;
    public static int fps = 0;
    private static volatile boolean clientFocused = true;
    private final int millisPerTick = 20;
    public boolean gameShellError = false;


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
        if (Game.signlink.gameShell != null) {
            Method method = Signlink.aMethod724;
            if (method != null) {
                try {
                    method.invoke(Game.signlink.gameShell, Boolean.TRUE);
                } catch (Throwable throwable) {
                }
            }
        }
        setCanvas();
        ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = MovedStatics.createGraphicsBuffer(Class12.width, MovedStatics.height, MouseHandler.gameCanvas);
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
                    MovedStatics.aBoolean571 = clientFocused;
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
                close();
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
            if (Game.signlink != null) {
                try {
                    Game.signlink.killSignlinkThread();
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
        clientFocused = false;
    }

    public abstract void close();

    public synchronized void paint(Graphics arg0) {
        if (this == currentGameShell && !PacketBuffer.closedClient) {
            MovedStatics.clearScreen = true;
            if (Signlink.javaVersion == null || !Signlink.javaVersion.startsWith("1.5") || -MovedStatics.aLong174 + System.currentTimeMillis() <= 1000L)
                return;
            Rectangle rectangle = arg0.getClipBounds();
            if (rectangle == null || rectangle.width >= Class12.width && rectangle.height >= MovedStatics.height)
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
        clientFocused = true;
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
        MovedStatics.height = width;
        currentGameShell = this;
        if (Game.signlink == null) {
            try {
                Actor.signlink = Game.signlink = new Signlink(false, this, InetAddress.getByName(getCodeBase().getHost()), fileStoreId, null, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Game.signlink.createThreadNode(1, this);
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
            fps = ((i >> 1) + (maxSamples * 1000)) / i;
        }

        // Increases the current tick identifier by 1, looping at 31 back to 0 (including 31)
        // This means the client stores the last 32 tick times to do some other calculations
        PlayerAppearance.currentTickSample = PlayerAppearance.currentTickSample + 1 & 0x1f;

        if (MovedStatics.anInt938++ > 50) {
            MovedStatics.anInt938 -= 50;
            MovedStatics.clearScreen = true;
            MouseHandler.gameCanvas.setSize(Class12.width, MovedStatics.height);
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
            MovedStatics.height = height;
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
            Actor.signlink = Game.signlink = new Signlink(true, null, inetAddress, fileStoreId, cacheFolder, cacheIndexes);
            Game.signlink.createThreadNode(1, this);
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
        MouseHandler.gameCanvas.setSize(Class12.width, MovedStatics.height);
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
