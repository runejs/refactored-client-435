package com.jagex.runescape;

import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GameSocket implements Runnable {
    public InputStream socketInputStream;
    public OutputStream socketOutputStream;
    public Socket socket;
    public SignlinkNode signLinkNode;
    public Signlink signLink;
    public boolean socketError;

    public int queuedDataPosition = 0;
    public int anInt1520 = 0;
    public boolean socketDisconnected;
    public byte[] queuedData;

    public GameSocket(Socket socket, Signlink signLink) throws IOException {
        socketDisconnected = false;
        socketError = false;
        this.signLink = signLink;
        this.socket = socket;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        socketInputStream = this.socket.getInputStream();
        socketOutputStream = this.socket.getOutputStream();
    }


    public void readPacketToBuffer(int currentPosition, int packetSize, byte[] buffer) throws IOException {
        if (!socketDisconnected) {
            while (packetSize > 0) {
                int i = socketInputStream.read(buffer, currentPosition, packetSize);
                if (i <= 0)
                    throw new EOFException();
                packetSize -= i;
                currentPosition += i;
            }
        }
    }

    public void method1009() {
        if (!socketDisconnected) {
            synchronized (this) {
                socketDisconnected = true;
                this.notifyAll();
            }
            if (signLinkNode != null) {
                while (signLinkNode.anInt434 == 0)
                    Class43.sleep(1L);
                if (signLinkNode.anInt434 == 1) {
                    try {
                        ((Thread) signLinkNode.value).join();
                    } catch (InterruptedException interruptedexception) {
                        interruptedexception.printStackTrace();
                        /* empty */
                    }
                }
            }
            signLinkNode = null;
        }
    }

    public void sendDataFromBuffer(int size, int startPos, byte[] data) throws IOException {
        if (!socketDisconnected) {
            if (socketError) {
                socketError = false;
                throw new IOException();
            }
            if (queuedData == null)
                queuedData = new byte[5000];
            synchronized (this) {
                for (int currentByte = 0; currentByte < size; currentByte++) {
                    queuedData[queuedDataPosition] = data[startPos + currentByte];
                    queuedDataPosition = (1 + queuedDataPosition) % 5000;
                    if (queuedDataPosition == (4900 + anInt1520) % 5000)
                        throw new IOException();
                }
                if (signLinkNode == null)
                    signLinkNode = signLink.createCanvasNode(3, this);
                this.notifyAll();
            }
        }
    }

    public void finalize() {
        method1009();
    }

    public void run() {
        try {
            for (; ; ) {
                int i;
                int i_0_;
                synchronized (this) {
                    if (queuedDataPosition == anInt1520) {
                        if (socketDisconnected) {
                            break;
                        }
                        try {
                            this.wait();
                        } catch (InterruptedException interruptedexception) {
                            /* empty */
                            interruptedexception.printStackTrace();
                        }
                    }
                    if (queuedDataPosition >= anInt1520)
                        i = queuedDataPosition - anInt1520;
                    else
                        i = -anInt1520 + 5000;
                    i_0_ = anInt1520;
                }
                if (i > 0) {
                    try {
                        socketOutputStream.write(queuedData, i_0_, i);
                    } catch (IOException ioexception) {
                        socketError = true;
                    }
                    anInt1520 = (i + anInt1520) % 5000;
                    try {
                        if (anInt1520 == queuedDataPosition)
                            socketOutputStream.flush();
                    } catch (IOException ioexception) {
                        ioexception.printStackTrace();
                        socketError = true;
                    }
                }
            }
            try {
                if (socketInputStream != null)
                    socketInputStream.close();
                if (socketOutputStream != null)
                    socketOutputStream.close();
                if (socket != null)
                    socket.close();
            } catch (IOException ioexception) {
                /* empty */
                ioexception.printStackTrace();
            }
            queuedData = null;
        } catch (Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }

    public int inputStreamAvailable() throws IOException {
        if (socketDisconnected)
            return 0;
        return socketInputStream.available();
    }

    public int read() throws IOException {
        if (socketDisconnected)
            return 0;
        return socketInputStream.read();
    }
}
