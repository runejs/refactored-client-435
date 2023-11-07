package org.runejs.client.net;

import org.runejs.client.GameSocket;

/**
 * TODO rename , remove I prefix
 */
public interface IUpdateServer {
    void receiveConnection(GameSocket socket, boolean isLoggedIn);

    boolean poll();

    void resetRequests(boolean isLoggedIn);

    void close();

    int calculateDataLoaded(int volume, int file);

    int getActiveCount(boolean pending, boolean immediate);
}
