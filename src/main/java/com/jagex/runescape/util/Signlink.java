package com.jagex.runescape.util;

import com.jagex.runescape.SizedAccessFile;
import com.jagex.runescape.Interface2;
import com.jagex.runescape.GameShell;
import com.jagex.runescape.Runnable_Impl1;
import tech.henning.fourthreefive.Configuration;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable {
    public static Method aMethod724;
    private static String homeDirectory;
    public static Method aMethod729;
    public static String javaVendor;
    public static int anInt737 = 3;
    public static String javaVersion;
    public boolean aBoolean721;
    public int uid = 0;
    public SizedAccessFile[] dataIndexAccessFiles;
    public SignlinkNode current = null;
    public Runnable_Impl1 aRunnable_Impl1_727;
    public SizedAccessFile metaIndexAccessFile;
    public InetAddress netAddress;
    public SignlinkNode next = null;
    public Interface2 anInterface2_732;
    public Thread aThread733;
    public String aString734 = null;
    public SizedAccessFile cacheDataAccessFile;
    public GameShell anApplet740;

    public Signlink(boolean arg0, GameShell arg1, InetAddress netAddress, int fileStoreId, String cacheFolder, int cacheIndexes) throws IOException {
        metaIndexAccessFile = null;
        cacheDataAccessFile = null;
        anApplet740 = null;
        anApplet740 = arg1;
        this.netAddress = netAddress;
        javaVersion = "1.1";
        javaVendor = "Unknown";
        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
            homeDirectory = System.getProperty("user.home");
            if(homeDirectory != null)
                homeDirectory += "/";
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(arg1 == null)
                aMethod729 = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            else
                aMethod729 = arg1.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(arg1 != null)
                aMethod724 = arg1.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            else
                aMethod724 = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        if(arg0) {
            method397(-3849);
            cacheDataAccessFile = new SizedAccessFile(new File(aString734 + "main_file_cache.dat2"), "rw", 52428800L);
            dataIndexAccessFiles = new SizedAccessFile[cacheIndexes];
            for(int i = 0; i < cacheIndexes; i++)
                dataIndexAccessFiles[i] = new SizedAccessFile(new File(aString734 + "main_file_cache.idx" + i), "rw", 1048576L);
            metaIndexAccessFile = new SizedAccessFile(new File(aString734 + "main_file_cache.idx255"), "rw", 1048576L);
            method390(6);
        }
        aBoolean721 = false;
        aThread733 = new Thread(this);
        aThread733.setPriority(10);
        aThread733.setDaemon(true);
        aThread733.start();

    }

    public void method385(int arg0) {
        synchronized(this) {
            aBoolean721 = true;
            this.notifyAll();
        }
        try {
            aThread733.join();
            if(arg0 != 0)
                method396(-55);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
        if(aRunnable_Impl1_727 != null)
            aRunnable_Impl1_727.method1((byte) -102);
        if(cacheDataAccessFile != null) {
            try {
                cacheDataAccessFile.close();
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(metaIndexAccessFile != null) {
            try {
                metaIndexAccessFile.close();
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(dataIndexAccessFiles != null) {
            for(int i = 0; i < dataIndexAccessFiles.length; i++) {
                if(dataIndexAccessFiles[i] != null) {
                    try {
                        dataIndexAccessFiles[i].close();
                    } catch(IOException ioexception) {
                        /* empty */
                    }
                }
            }
        }
    }

    public SignlinkNode method386(Class[] argumentTypes, String functionName, Class functionType) {
        return putNode(0, 9, new Object[]{functionType, functionName, argumentTypes});

    }

    public Interface2 method387(int arg0) {

        if(arg0 != -25100)
            return null;
        return anInterface2_732;

    }

    public SignlinkNode method388(boolean arg0, URL arg1) {
        if(arg0)
            method397(-42);
        return putNode(0, 4, arg1);
    }

    public SignlinkNode putNode(int integerData, int type, Object objectData) {
        SignlinkNode signlinkNode = new SignlinkNode();
        signlinkNode.objectData = objectData;
        signlinkNode.integerData = integerData;
        signlinkNode.type = type;
        synchronized(this) {
            if(next == null)
                next = current = signlinkNode;
            else {
                next.prev = signlinkNode;
                next = signlinkNode;
            }
            this.notify();
        }
        return signlinkNode;
    }

    public void method390(int arg0) {

        try {
            File file = new File(aString734 + "uid.dat");
            if(!file.exists() || file.length() < 4) {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(aString734 + "uid.dat"));
                dataoutputstream.writeInt((int) (9.9999999E7 * Math.random()));
                dataoutputstream.close();
            }
        } catch(Exception exception) {
            /* empty */
        }
        if(arg0 != 6)
            uid = 116;
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(aString734 + "uid.dat"));
            uid = 1 + datainputstream.readInt();
            datainputstream.close();
        } catch(Exception exception) {
            /* empty */
        }

    }

    public Runnable_Impl1 method391() {
        return aRunnable_Impl1_727;
    }

    public void run() {
        for(; ; ) {
            SignlinkNode currentNode;
            synchronized(this) {
                for(; ; ) {
                    if(aBoolean721)
                        return;
                    if(current != null) {
                        currentNode = current;
                        current = current.prev;
                        if(current == null)
                            next = null;
                        break;
                    }
                    try {
                        this.wait();
                    } catch(InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
            }
            try {
                int type = currentNode.type;
                if (type == 1) {
                    // Create connection
                    currentNode.value = new Socket(netAddress, currentNode.integerData);
                } else if(type == 2) {
                    // Start thread
                    Thread thread = new Thread((Runnable) currentNode.objectData);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(currentNode.integerData);
                    currentNode.value = thread;
                } else if(type == 4)
                    currentNode.value = new DataInputStream(((URL) currentNode.objectData).openStream());
                else if(type == 9) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredMethod((String) objects[1], (Class[]) objects[2]);
                } else if(type == 10) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredField((String) objects[1]);
                } else
                    throw new Exception();
                currentNode.anInt434 = 1;
            } catch(Exception exception) {
                currentNode.anInt434 = 2;
            }
        }

    }

    public SignlinkNode method392(Class variableType, String variableName) {
        return putNode(0, 10, new Object[]{variableType, variableName});
    }

    public SignlinkNode method393(int arg1) {
        return putNode(arg1, 3, null);

    }

    public SignlinkNode createCanvasNode(int nodeId, Runnable gameCanvas) {
        method392(null, null);
        return putNode(nodeId, 2, gameCanvas);
    }

    public SignlinkNode method395(int arg0, int arg1) {
        if(arg0 != 3)
            method397(-29);
        return putNode(arg1, 1, null);
    }

    public SignlinkNode method396(int arg0) {

        if(arg0 < 81)
            return null;
        return null;

    }

    public void method397(int arg0) {

        if(homeDirectory == null)
            homeDirectory = "~/";
        String[] cacheLocations = {"c:/rsrcache/", "/rsrcache/", "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", homeDirectory, "/tmp/", ""};
        if(arg0 != -3849)
            method392(null, null); // TODO: Does this even ever run?
        for(String cacheLocation : cacheLocations) {
            try {
                if(cacheLocation.length() > 0) {
                    File file = new File(cacheLocation);
                    if(!file.exists())
                        continue;
                }
                File file = new File(cacheLocation + Configuration.CACHE_NAME);
                if(file.exists() || file.mkdir()) {
                    aString734 = file.getPath() + "/";
                    return;
                }
            } catch(Exception exception) {
            }
        }
        throw new RuntimeException();

    }
}
