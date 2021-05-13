package org.runejs.client.util;

import org.runejs.client.SizedAccessFile;
import org.runejs.client.Interface2;
import org.runejs.client.GameShell;
import org.runejs.client.Runnable_Impl1;
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
    public boolean killed;
    public int uid = 0;
    public SizedAccessFile[] dataIndexAccessFiles;
    public SignlinkNode current = null;
    public Runnable_Impl1 aRunnable_Impl1_727;
    public SizedAccessFile metaIndexAccessFile;
    public InetAddress netAddress;
    public SignlinkNode next = null;
    public Interface2 anInterface2_732;
    public Thread signLinkThread;
    public String cachePath = null;
    public SizedAccessFile cacheDataAccessFile;
    public GameShell gameShell;

    public Signlink(boolean loadCache, GameShell gameShell, InetAddress netAddress, int fileStoreId, String cacheFolder, int cacheIndexes) throws IOException {
        metaIndexAccessFile = null;
        cacheDataAccessFile = null;
        this.gameShell = gameShell;
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
            if(gameShell == null)
                aMethod729 = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            else
                aMethod729 = gameShell.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(gameShell != null)
                aMethod724 = gameShell.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            else
                aMethod724 = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        if(loadCache) {
            findCachePath();
            cacheDataAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.dat2"), "rw", 52428800L);
            dataIndexAccessFiles = new SizedAccessFile[cacheIndexes];
            for(int currentIndex = 0; currentIndex < cacheIndexes; currentIndex++)
                dataIndexAccessFiles[currentIndex] = new SizedAccessFile(new File(cachePath + "main_file_cache.idx" + currentIndex), "rw", 1048576L);
            metaIndexAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.idx255"), "rw", 1048576L);
            initializeUniqueIdentifier();
        }
        killed = false;
        signLinkThread = new Thread(this);
        signLinkThread.setPriority(10);
        signLinkThread.setDaemon(true);
        signLinkThread.start();

    }

    public void killSignlinkThread() {
        synchronized(this) {
            killed = true;
            this.notifyAll();
        }
        try {
            signLinkThread.join();
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

    public SignlinkNode addType4Node(URL url) {
        return putNode(0, 4, url);
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

    public void initializeUniqueIdentifier() {
        try {
            File file = new File(cachePath + "uid.dat");
            if(!file.exists() || file.length() < 4) {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(cachePath + "uid.dat"));
                dataoutputstream.writeInt((int) (9.9999999E7 * Math.random()));
                dataoutputstream.close();
            }
        } catch(Exception exception) {
            /* empty */
        }
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(cachePath + "uid.dat"));
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
                    if(killed)
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
                } else {
                    throw new Exception();
                }

                currentNode.status = 1;
            } catch(Exception exception) {
                currentNode.status = 2;
            }
        }

    }

    public SignlinkNode createType10Node(Class variableType, String variableName) {
        return putNode(0, 10, new Object[]{ variableType, variableName });
    }

    // TODO this will just throw an exception, since type 3 isn't handled
    public SignlinkNode createExceptionNode(int arg1) {
        return putNode(arg1, 3, null);
    }

    public SignlinkNode createThreadNode(int nodeId, Runnable runnableClass) {
        return putNode(nodeId, 2, runnableClass);
    }

    public SignlinkNode createSocketNode(int port) {
        return putNode(port, 1, null);
    }

    public SignlinkNode method396(int arg0) {

        if(arg0 < 81)
            return null;
        return null;

    }

    public void findCachePath() {
        if (homeDirectory == null) {
            homeDirectory = "~/";
        }

        String[] cacheLocations = {
                "c:/rsrcache/",
                "/rsrcache/",
                "c:/windows/",
                "c:/winnt/",
                "d:/windows/",
                "d:/winnt/",
                "e:/windows/",
                "e:/winnt/",
                "f:/windows/",
                "f:/winnt/",
                "c:/",
                homeDirectory,
                "/tmp/",
                ""
        };

        for (String cacheLocation : cacheLocations) {
            try {
                if (cacheLocation.length() > 0) {
                    File file = new File(cacheLocation);
                    if (!file.exists()) {
                        continue;
                    }
                }
                File file = new File(cacheLocation + Configuration.CACHE_NAME);
                if (file.exists() || file.mkdir()) {
                    cachePath = file.getPath() + "/";
                    return;
                }
            } catch (Exception exception) { }
        }
        throw new RuntimeException();

    }
}
