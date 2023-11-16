package org.runejs.client.ondemand.js5;

import org.runejs.client.GameSocket;
import org.runejs.client.io.Buffer;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.ondemand.js5.exceptions.*;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;

import java.net.Socket;

/**
 * This class is responsible for establishing, and maintaining, the connection
 * to the update server.
 */
public class JS5UpdateServerConnectionManager {
    /**
     * TODO use interface
     */
    public final UpdateServer updateServer = new UpdateServer();

    private int cyclesToConnectionAttempt;

    private int connectionStage;

    private SignlinkNode socketRequest;

    private GameSocket socket;

    private long handshakeSentAtMs;

    private int failureCount;

    private int port = -1;
    private int primaryPort = -1;
    private int secondaryPort = -1;

    private Signlink signlink;

    public JS5UpdateServerConnectionManager(Signlink signlink, int primaryPort, int secondaryPort) {
        this.signlink = signlink;

        this.primaryPort = primaryPort;
        this.secondaryPort = secondaryPort;

        this.port = primaryPort;
    }

    public void process(int gameStatus) throws JS5Exception {
        boolean connected = updateServer.poll();

        if (!connected) {
            connectUpdateServer(gameStatus);
        }
    }

    public void close() {
        updateServer.close();
    }

    private void connectUpdateServer(int gameStatus) throws JS5Exception {
        if (updateServer.crcMismatchesCount >= 4) {
            throw new JS5CRCException();
        }

        if (updateServer.ioExceptionsCount >= 4) {
            if (gameStatus > 5) {
                updateServer.ioExceptionsCount = 3;
                cyclesToConnectionAttempt = 3000;

                return;
            }

            throw new JS5IOException();
        }

        cyclesToConnectionAttempt--;

        if (cyclesToConnectionAttempt > 0) {
            return;
        }

        try {
            if (connectionStage == 0) {
                socketRequest = signlink.putSocketNode(port);
                connectionStage++;
            }
            if (connectionStage == 1) {
                if (socketRequest.status == SignlinkNode.Status.ERRORED) {
                    handleConnectionError(gameStatus, -1);
                    return;
                }
                if (socketRequest.status == SignlinkNode.Status.INITIALIZED)
                    connectionStage++;
            }
            if (connectionStage == 2) {
                socket = new GameSocket((Socket) socketRequest.value, signlink);
                Buffer buffer = new Buffer(5);
                buffer.putByte(15);
                buffer.putIntBE(435); // Cache revision
                socket.sendDataFromBuffer(5, 0, buffer.buffer);
                connectionStage++;
                handshakeSentAtMs = System.currentTimeMillis();
            }
            if (connectionStage == 3) {
                if (gameStatus > 5 && socket.inputStreamAvailable() <= 0) {
                    if (System.currentTimeMillis() - handshakeSentAtMs > 30000L) {
                        handleConnectionError(gameStatus, -2);
                        return;
                    }
                } else {
                    int i = socket.read();
                    if (i != 0) {
                        handleConnectionError(gameStatus, i);
                        return;
                    }
                    connectionStage++;
                }
            }
            if (connectionStage != 4) {
                return;
            }

            updateServer.receiveConnection(socket, gameStatus > 20);

            socketRequest = null;
            connectionStage = 0;
            socket = null;
            failureCount = 0;
        } catch (java.io.IOException ioexception) {
            ioexception.printStackTrace();
            handleConnectionError(gameStatus, -3);
            return;
        }
    }

    private void switchPorts() {
        if (port != primaryPort) {
            port = primaryPort;
        } else {
            port = secondaryPort;
        }
    }

    /**
     * -1 = signlink unable to create socket
     * -2 = no handshake response received
     * -3 = io exception
     *
     * other error codes come from the server
     *
     * @param errorCode
     */
    private void handleConnectionError(int gameStatus, int errorCode) throws JS5Exception {
        switchPorts();

        socket = null;
        socketRequest = null;
        connectionStage = 0;
        failureCount++;

        if (failureCount >= 2 && (errorCode == 7 || errorCode == 9)) {
            if (gameStatus > 5) {
                cyclesToConnectionAttempt = 3000;
                return;
            }

            throw new JS5ConnectFullException();
        }

        if (failureCount >= 2 && errorCode == 6) {
            throw new JS5ConnectOutOfDateException();
        }

        if (failureCount < 4) {
            return;
        }

        cyclesToConnectionAttempt = 3000;

        if (gameStatus <= 5) {
            throw new JS5ConnectException();
        }
    }
}
