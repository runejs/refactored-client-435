package com.jagex.runescape;

import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.cache.media.gameInterface.GameInterfaceType;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;

public abstract class GameShell extends Canvas implements Runnable, FocusListener, WindowListener {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1;
    public static int[] anIntArray2 = new int[5];
    public static long[] aLongArray4 = new long[32];
    public static int anInt31;
    public boolean gameErrorOccured = false;


    public static void method19(boolean arg0) {
        if(Class57.aClass64_1345 != null) {
            try {
                Buffer class40_sub1 = new Buffer(4);
                class40_sub1.putByte(arg0 ? 2 : 3);
                class40_sub1.putMediumBE(0);
                Class57.aClass64_1345.method1010(4, 0, class40_sub1.buffer);
            } catch(java.io.IOException ioexception) {
                ioexception.printStackTrace();
                try {
                    Class57.aClass64_1345.method1009();
                } catch(Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                Class57.aClass64_1345 = null;
                MovedStatics.anInt2278++;
            }
        }

    }

    public static void method20(
            int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, GameInterface[] arg7, int arg8,
            int arg9
    ) {

        if(arg6 != 1) {
            providesignlink(null);
        }
        for(int i = 0; i < arg7.length; i++) {
            GameInterface gameInterface = arg7[i];
            if(gameInterface != null && (gameInterface.type == GameInterfaceType.LAYER || gameInterface.hasListeners) &&
                    arg5 == gameInterface.parentId && (!gameInterface.isHidden || PacketBuffer.hiddenButtonTest)) {


                int i_1_ = arg4 + gameInterface.currentX;
                int i_2_ = arg0 + gameInterface.currentY;
                if(!gameInterface.lockScroll) {
                    i_2_ -= arg9;
                }
                int i_3_ = i_2_ + gameInterface.originalHeight;
                int i_4_ = Math.max(arg0, i_2_);
                if(!gameInterface.lockScroll) {
                    i_1_ -= arg2;
                }
                int i_5_ = i_1_ + gameInterface.originalWidth;
                int i_6_ = Math.max(arg4, i_1_);
                int i_7_ = Math.min(arg1, i_3_);
                int i_8_ = Math.min(arg8, i_5_);
                if(gameInterface.type == GameInterfaceType.LAYER) {
                    method20(i_4_, i_7_, gameInterface.scrollWidth, arg3, i_6_, i, 1, arg7, i_8_,
                            gameInterface.scrollPosition
                    );
                    if(gameInterface.children != null) {
                        method20(i_4_, i_7_, gameInterface.scrollWidth, arg3, i_6_, gameInterface.id, 1,
                                gameInterface.children, i_8_, gameInterface.scrollPosition
                        );
                    }
                }
                if(gameInterface.hasListeners) {
                    boolean bool;
                    bool = Class13.mouseX >= i_6_ && i_4_ <= Landscape.mouseY && i_8_ > Class13.mouseX &&
                            i_7_ > Landscape.mouseY;
                    boolean bool_9_ = false;
                    if(SpotAnimDefinition.mouseButtonPressed == 1 && bool) {
                        bool_9_ = true;
                    }
                    boolean bool_10_ = false;
                    if(gameInterface.anInt2738 != -1 && bool_9_ && Wall.aGameInterface_353 == null) {
                        MovedStatics.anInt1996 = Class13.mouseX;
                        Wall.aGameInterface_353 = gameInterface;
                        Class40_Sub5_Sub11.anInt2621 = Landscape.mouseY;
                    }
                    if(MouseHandler.clickType == 1 && i_6_ <= Class57.clickX && RSString.clickY >= i_4_ &&
                            Class57.clickX < i_8_ && RSString.clickY < i_7_) {
                        bool_10_ = true;
                    }
                    if(Wall.aGameInterface_353 != null) {
                        bool_9_ = false;
                        bool = false;
                        bool_10_ = false;
                    }
                    if(!gameInterface.aBoolean2730 && bool_10_ && (0x1 & arg3) != 0) {
                        gameInterface.aBoolean2730 = true;
                        if(gameInterface.anObjectArray2681 != null) {
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2681, 0,
                                    RSString.clickY + -i_2_, gameInterface, Class57.clickX - i_1_
                            );
                        }
                    }
                    if(gameInterface.aBoolean2730 && bool_9_ && (arg3 & 0x4) != 0 &&
                            gameInterface.anObjectArray2747 != null) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2747, 0,
                                -i_2_ + Landscape.mouseY, gameInterface, -i_1_ + Class13.mouseX
                        );
                    }
                    if(gameInterface.aBoolean2730 && !bool_9_ && (0x2 & arg3) != 0) {
                        gameInterface.aBoolean2730 = false;
                        if(gameInterface.anObjectArray2707 != null) {
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2707, 0,
                                    Landscape.mouseY - i_2_, gameInterface, Class13.mouseX - i_1_
                            );
                        }
                    }
                    if(bool_9_ && (arg3 & 0x8) != 0 && gameInterface.anObjectArray2644 != null) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2644, 0,
                                -i_2_ + Landscape.mouseY, gameInterface, -i_1_ + Class13.mouseX
                        );
                    }
                    if(!gameInterface.aBoolean2682 && bool && (0x10 & arg3) != 0) {
                        gameInterface.aBoolean2682 = true;
                        if(gameInterface.anObjectArray2658 != null) {
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2658, 0,
                                    Landscape.mouseY - i_2_, gameInterface, Class13.mouseX - i_1_
                            );
                        }
                    }
                    if(gameInterface.aBoolean2682 && bool && (0x40 & arg3) != 0 &&
                            gameInterface.anObjectArray2680 != null) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2680, 0,
                                -i_2_ + Landscape.mouseY, gameInterface, -i_1_ + Class13.mouseX
                        );
                    }
                    if(gameInterface.aBoolean2682 && !bool && (arg3 & 0x20) != 0) {
                        gameInterface.aBoolean2682 = false;
                        if(gameInterface.anObjectArray2672 != null) {
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2672, 0,
                                    -i_2_ + Landscape.mouseY, gameInterface, -i_1_ + Class13.mouseX
                            );
                        }
                    }
                    if(gameInterface.anObjectArray2712 != null && (arg3 & 0x80) != 0) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2712, 0, 0, gameInterface, 0);
                    }
                    if(AnimationSequence.anInt2480 == MovedStatics.pulseCycle &&
                            gameInterface.anObjectArray2650 != null && (arg3 & 0x100) != 0) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2650, 0, 0, gameInterface, 0);
                    }
                }
            }
        }

    }

    public static void providesignlink(Signlink arg0) {
        Actor.signlink = Main.signlink = arg0;
    }

    public static int method27(int arg0, int arg1) {
        return arg0 ^ arg1;
    }

    public static void method28(long arg0) {
        if(arg0 != 0) {
            int i = 0;
            for(/**/; Player.friendsCount > i; i++) {
                if(Class59.friends[i] == arg0) {
                    Player.friendsCount--;
                    GameInterface.redrawTabArea = true;
                    for(int i_13_ = i; i_13_ < Player.friendsCount; i_13_++) {
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
        if(!arg3) {
            return -109;
        }
        int i = 65536 + -Rasterizer3D.cosinetable[1024 * arg4 / arg1] >> 1;
        return ((65536 + -i) * arg0 >> 16) + (arg2 * i >> 16);
    }

    public void run() {
        if(Signlink.javaVendor != null) {
            String string = Signlink.javaVendor.toLowerCase();
            if(!string.contains("sun") && !string.contains("apple")) {
                if(string.contains("ibm") && (Signlink.javaVersion == null || Signlink.javaVersion.equals("1.4.2"))) {
                    printGameError("wrongjava");
                    return;
                }
            } else {
                String version = Signlink.javaVersion;
                if(version.equals("1.1") || version.startsWith("1.1.") || version.equals("1.2") || version.startsWith(
                        "1.2.")) {
                    printGameError("wrongjava");
                    return;
                }
                Class40_Sub3.anInt2024 = 5;
            }
        }
        if(Main.signlink.anApplet740 != null) {
            Method method = Signlink.aMethod724;
            if(method != null) {
                try {
                    method.invoke(Main.signlink.anApplet740, Boolean.TRUE);
                } catch(Throwable throwable) {
                }
            }
        }
        setCanvas((byte) 121);
        ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = Class40_Sub5_Sub13.createGraphicsBuffer(
                Class12.width, IdentityKit.height, MouseHandler.gameCanvas);
        startup(true);
        SceneCluster.aTimer_768 = Timer.create();
        SceneCluster.aTimer_768.start();
        while(MovedStatics.gameOpenedFor == 0L || System.currentTimeMillis() < MovedStatics.gameOpenedFor) {
            Class40_Sub3.anInt2020 = SceneCluster.aTimer_768.sleep(Class39.anInt912, Class40_Sub3.anInt2024);
            for(int i = 0; i < Class40_Sub3.anInt2020; i++) {
                method29();
            }
            method26();
        }
        cleanup();
    }


    public synchronized void cleanup() {
        if(!PacketBuffer.aBoolean2255) {
            PacketBuffer.aBoolean2255 = true;
            try {
                MouseHandler.gameCanvas.removeFocusListener(this);
            } catch(Exception exception) {
                /* empty */
            }
            try {
                method24();
            } catch(Exception exception) {
                /* empty */
            }
            if(Class35.gameFrame != null) {
                System.exit(0);
                // CLEANUP_REFACTOR
                // try {
                //} catch(Throwable throwable) {
                //    /* empty */
                //}
            }
            if(Main.signlink != null) {
                Main.signlink.method385(0);
                // CLEANUP_REFACTOR
                //try {
                //} catch(Exception exception) {
                //    /* empty */
                //}
            }
        }
    }

    public void stop() {
        if(this == MovedStatics.mainGameShellInstance && !PacketBuffer.aBoolean2255) {
            MovedStatics.gameOpenedFor = System.currentTimeMillis() + 4000L;
        }
    }

    public void windowOpened(WindowEvent event) {
        // pass
    }

    public void printGameError(String gameError) {
        if(!gameErrorOccured) {
            gameErrorOccured = true;
            System.out.println("error_game_" + gameError);
        }

    }

    public void start() {
        if(this == MovedStatics.mainGameShellInstance && !PacketBuffer.aBoolean2255) {
            MovedStatics.gameOpenedFor = 0L;
        }
    }

    public abstract void processGameLoop();

    public void focusLost(FocusEvent event) {
        GenericTile.aBoolean1215 = false;
    }

    public abstract void method24();

    public synchronized void paint(Graphics arg0) {
        if(this == MovedStatics.mainGameShellInstance && !PacketBuffer.aBoolean2255) {
            Class40_Sub5_Sub11.clearScreen = true;
            if(Signlink.javaVersion == null || !Signlink.javaVersion.startsWith("1.5") ||
                    -MovedStatics.aLong174 + System.currentTimeMillis() <= 1000L) {
                return;
            }
            Rectangle rectangle = arg0.getClipBounds();
            if(rectangle == null || rectangle.width >= Class12.width && rectangle.height >= IdentityKit.height) {
                MovedStatics.aBoolean1575 = true;
            }
        }
    }

    public void destroy() {
        if(MovedStatics.mainGameShellInstance == this && !PacketBuffer.aBoolean2255) {
            MovedStatics.gameOpenedFor = System.currentTimeMillis();
            Class43.sleep(5000L);
            Actor.signlink = null;
            cleanup();
        }
    }

    public void focusGained(FocusEvent event) {
        GenericTile.aBoolean1215 = true;
        Class40_Sub5_Sub11.clearScreen = true;
    }

    public URL getDocumentBase() {
        try {
            return new URL("http://" + Configuration.SERVER_ADDRESS + ":" + Configuration.HTTP_PORT);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayClientFrame(int clientVersion, int width, int height, int fileStoreId) {
        if(MovedStatics.mainGameShellInstance != null) {
            printGameError("alreadyloaded");
            return;
        }
        Class12.width = height;
        Class39.clientVersion = clientVersion;
        IdentityKit.height = width;
        MovedStatics.mainGameShellInstance = this;
        if(Main.signlink == null) {
            try {
                Actor.signlink = Main.signlink = new Signlink(
                        false, this, InetAddress.getByName(getCodeBase().getHost()), fileStoreId, null, 0);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        Main.signlink.method394(1, this);
        windowActivated(null);
    }

    public void windowIconified(WindowEvent event) {
    }

    public void method26() {
        long l = System.currentTimeMillis();
        long l_11_ = aLongArray4[PlayerAppearance.anInt681];
        aLongArray4[PlayerAppearance.anInt681] = l;
        if(l_11_ != 0 && l > l_11_) {
            int i = (int) (-l_11_ + l);
            GenericTile.fps = ((i >> 1) + 32000) / i;
        }
        PlayerAppearance.anInt681 = PlayerAppearance.anInt681 + 1 & 0x1f;
        if(MovedStatics.anInt938++ > 50) {
            MovedStatics.anInt938 -= 50;
            Class40_Sub5_Sub11.clearScreen = true;
            MouseHandler.gameCanvas.setSize(Class12.width, IdentityKit.height);
            MouseHandler.gameCanvas.setVisible(true);
            MouseHandler.gameCanvas.setBackground(Color.BLACK);
            if(Class35.gameFrame == null) {
                MouseHandler.gameCanvas.setLocation(0, 0);
            } else {
                Insets insets = Class35.gameFrame.getInsets();
                MouseHandler.gameCanvas.setLocation(insets.left, insets.top);
            }
        }
        method34();
    }

    //    public AppletContext getAppletContext() {
    //        if(Class35.aFrame1732 != null)
    //            return null;
    //        if(ISAAC.aClass31_521 != null && ISAAC.aClass31_521.anApplet740 != this)
    //            return ISAAC.aClass31_521.anApplet740.getAppletContext();
    //        return super.getAppletContext();
    //    }

    public void method29() {
        long l = System.currentTimeMillis();
        long l_14_ = MovedStatics.aLongArray1614[MouseHandler.anInt1468];
        if(l_14_ != 0L && l > l_14_) {
            /* empty */
        }
        MovedStatics.aLongArray1614[MouseHandler.anInt1468] = l;
        MouseHandler.anInt1468 = 0x1f & MouseHandler.anInt1468 + 1;
        synchronized(this) {
            MovedStatics.aBoolean571 = GenericTile.aBoolean1215;
        }
        processGameLoop();
    }

    public void openClientApplet(
            String cacheFolder, int cacheIndexes, int fileStoreId, InetAddress inetAddress, int clientVersion
    ) {
        try {
            int height = 503;
            int width = 765;
            Class39.clientVersion = clientVersion;
            Class12.width = width;
            IdentityKit.height = height;
            MovedStatics.mainGameShellInstance = this;
            Class35.gameFrame = new Frame();
            Class35.gameFrame.setTitle("Jagex");
            Class35.gameFrame.setPreferredSize(new Dimension(width, height));
            ScreenController.frameMode(ScreenMode.FIXED);
            Class35.gameFrame.setResizable(ScreenController.frameMode == ScreenMode.RESIZABLE);
            Class35.gameFrame.addWindowListener(this);
            Class35.gameFrame.setVisible(true);
            Class35.gameFrame.toFront();
            Insets insets = Class35.gameFrame.getInsets();
            Class35.gameFrame.setSize(insets.right + width + insets.left, insets.bottom + insets.top + height);
            //            Class35.aFrame1732.setLocationRelativeTo(null);
            Actor.signlink = Main.signlink = new Signlink(
                    true, null, inetAddress, fileStoreId, cacheFolder, cacheIndexes);
            Main.signlink.method394(1, this);
        } catch(Exception exception) {
            MovedStatics.method169(null, (byte) -127, exception);
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

    public synchronized void setCanvas(byte arg0) {
        Container container = Class35.gameFrame;
        //        else
        //            container = ISAAC.aClass31_521.anApplet740;
        if(MouseHandler.gameCanvas != null) {
            MouseHandler.gameCanvas.removeFocusListener(this);
            container.remove(MouseHandler.gameCanvas);
        }
        MouseHandler.gameCanvas = new RSCanvas(this);
        container.add(MouseHandler.gameCanvas);
        MouseHandler.gameCanvas.setSize(Class12.width, IdentityKit.height);
        MouseHandler.gameCanvas.setVisible(true);
        if(Class35.gameFrame != null) {
            Insets insets = Class35.gameFrame.getInsets();
            MouseHandler.gameCanvas.setLocation(insets.left, insets.top);
        } else {
            MouseHandler.gameCanvas.setLocation(0, 0);
        }
        MouseHandler.gameCanvas.addFocusListener(this);
        if(arg0 < 85) {
            run();
        }
        MouseHandler.gameCanvas.requestFocus();
        Class40_Sub5_Sub11.clearScreen = true;
        MovedStatics.aBoolean1575 = false;
        MovedStatics.aLong174 = System.currentTimeMillis();
    }

    public abstract void method34();

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }
}
