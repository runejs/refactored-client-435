package org.runejs.client.net;

import org.runejs.client.GameSocket;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeQueue;

import java.io.IOException;
import java.util.zip.CRC32;

/**
 * The UpdateServer class handles the connection to the game's update server and manages file requests and responses.
 */
public class UpdateServer {
    // Error counters
    public static int ioExceptionsCount = 0;
    public static int crcMismatchesCount = 0;

    // Network and data buffers
    private static GameSocket updateServerSocket;
    private static Buffer fileDataBuffer = new Buffer(8);
    private static Buffer inboundFile;
    private static Buffer crcTableBuffer;

    // Request queues
    private static HashTable immediateWriteQueue = new HashTable(4096);
    private static HashTable activeRequestTable = new HashTable(32);
    private static HashTable queuedRequestTable = new HashTable(4096);
    private static HashTable writeRequestTable = new HashTable(4096);

    // Response and update handling
    private static UpdateServerNode currentResponse;
    private static CRC32 crc32 = new CRC32();
    private static byte encryptionKey = (byte) 0;

    // Counters for various request/response types
    private static int immediateResponseCount = 0;
    private static int pendingWriteCount = 0;
    private static int immediateWriteCount = 0;
    private static int pendingResponseCount = 0;

    // Priority handling
    private static boolean isPriorityRequest;

    // Queues for write operations
    private static NodeQueue pendingWriteQueue = new NodeQueue();

    // Data transfer handling
    private static int blockOffset = 0;
    private static int msSinceLastUpdate = 0;
    private static long lastUpdateTimestamp;

    // Cache archives
    private static CacheArchive[] cacheArchiveLoaders = new CacheArchive[256];

    /**
     * Establishes and initializes the connection with the update server.
     * If an existing connection is present, it is terminated before establishing the new one.
     * This method also resets the update server requests and prepares the environment for receiving data.
     *
     * @param socket      The new game socket to be used for the update server connection.
     * @param resetQueues Indicates whether to reset the update server requests upon establishing the new connection.
     */
    public static void handleUpdateServerConnection(GameSocket socket, boolean resetQueues) {
        // Close the existing update server socket if it's already open.
        if (updateServerSocket != null) {
            try {
                updateServerSocket.kill();
            } catch (Exception exception) {
                exception.printStackTrace(); // Ideally replace with proper logging.
            }
            updateServerSocket = null; // Explicitly set to null to avoid memory leaks.
        }

        // Assign the new socket to the update server socket.
        updateServerSocket = socket;
        // Reset the update server requests if necessary.
        sendResetSignalToUpdateServer(resetQueues);
        // Reset the file data buffer position to start receiving new data.
        fileDataBuffer.currentPosition = 0;
        // Reset the inbound file buffer as we are starting a new session.
        inboundFile = null;
        // Reset the block offset to zero as no data has been received yet.
        blockOffset = 0;
        // Clear the current response node as we are starting a new session.
        currentResponse = null;

        // Move all active requests to the immediate write queue.
        while (true) {
            UpdateServerNode updateServerNode = (UpdateServerNode) activeRequestTable.getNextNode();
            if (updateServerNode == null) {
                break; // Exit the loop if there are no more nodes to process.
            }

            immediateWriteQueue.put(updateServerNode.key, updateServerNode);
            immediateResponseCount--;
            immediateWriteCount++;
        }

        // Move all queued requests to the write request table.
        while (true) {
            UpdateServerNode updateServerNode = (UpdateServerNode) queuedRequestTable.getNextNode();
            if (updateServerNode == null) {
                break; // Exit the loop if there are no more nodes to process.
            }

            pendingWriteQueue.unshift(updateServerNode);
            writeRequestTable.put(updateServerNode.key, updateServerNode);
            pendingResponseCount--;
            pendingWriteCount++;
        }

        // If encryption is enabled, send an encryption request to the update server.
        if (encryptionKey != 0) {
            try {
                Buffer fileRequestBuffer = new Buffer(4);
                fileRequestBuffer.putByte(4); // Command for setting encryption.
                fileRequestBuffer.putByte(encryptionKey); // The encryption key.
                fileRequestBuffer.putShortBE(0); // Additional data for the encryption request.
                updateServerSocket.sendDataFromBuffer(4, 0, fileRequestBuffer.buffer);
            } catch (IOException ioException) {
                ioException.printStackTrace(); // Ideally replace with proper logging.
                // Attempt to kill the socket on IO exceptions.
                try {
                    updateServerSocket.kill();
                } catch (Exception exception) {
                    exception.printStackTrace(); // Ideally replace with proper logging.
                }
                // Cleanup and increment the IO exceptions counter.
                updateServerSocket = null;
                ioExceptionsCount++;
            }
        }

        // Reset the milliseconds since the last update as we are starting fresh.
        msSinceLastUpdate = 0;
        // Record the current time as the last update timestamp.
        lastUpdateTimestamp = System.currentTimeMillis();
    }

    /**
     * Processes the update server's responses by managing data requests and incoming data streams.
     * It keeps track of the time since the last update to manage timeouts and ensures data integrity through CRC checks.
     *
     * @return {@code true} if all pending and immediate requests are processed and no new data is expected,
     * or if the processing is still ongoing. {@code false} if an error occurred or the socket is null.
     */
    public static boolean processUpdateServerResponse() {
        long currentTime = System.currentTimeMillis();
        int timeSinceLastUpdate = (int) (currentTime - lastUpdateTimestamp);
        lastUpdateTimestamp = currentTime;
        // Ensure the time since the last update does not exceed 200ms.
        timeSinceLastUpdate = Math.min(timeSinceLastUpdate, 200);
        msSinceLastUpdate += timeSinceLastUpdate;

        // If there are no pending or immediate responses or writes, return true as we are done processing.
        if (pendingResponseCount == 0 && immediateResponseCount == 0 && pendingWriteCount == 0 && immediateWriteCount == 0) {
            return true;
        }

        // If the update server socket is null, no further processing can be done.
        if (updateServerSocket == null) {
            return false;
        }

        try {
            // If it's been more than 30 seconds since the last update, throw an exception to handle the timeout.
            if (msSinceLastUpdate > 30000) {
                throw new IOException("Update server timeout.");
            }

            // Process immediate file requests.
            while (immediateResponseCount < 20 && immediateWriteCount > 0) {
                UpdateServerNode updateServerNode = (UpdateServerNode) immediateWriteQueue.getNextNode();
                if (updateServerNode == null) break;
                sendFileRequest(updateServerNode, true);
                immediateWriteCount--;
            }

            // Process queued file requests.
            while (pendingResponseCount < 20 && pendingWriteCount > 0) {
                UpdateServerNode updateServerNode = (UpdateServerNode) pendingWriteQueue.next();
                if (updateServerNode == null) break;
                sendFileRequest(updateServerNode, false);
                pendingWriteCount--;
            }

            // Process incoming data for a set number of iterations or until there's no data available.
            for (int i = 0; i < 100; i++) {
                int dataAvailable = updateServerSocket.inputStreamAvailable();
                if (dataAvailable < 0) {
                    throw new IOException("Negative data available from update server socket.");
                }
                if (dataAvailable == 0) break; // No data available, break the loop.

                msSinceLastUpdate = 0; // Reset the time since last update as we are actively receiving data.

                int bytesRead = processIncomingData(dataAvailable);
                if (bytesRead < 0) break; // Break if we did not read any data or if there's an error.
            }

            return true;
        } catch (IOException ioException) {
            ioException.printStackTrace(); // Proper logging should replace this printStackTrace call.

            // Attempt to kill the socket on IO exceptions.
            try {
                updateServerSocket.kill();
            } catch (Exception exception) {
                exception.printStackTrace(); // Proper logging should replace this printStackTrace call.
            }

            // Cleanup and increment the IO exceptions count.
            ioExceptionsCount++;
            updateServerSocket = null;

            return false;
        }
    }

    /**
     * Sends a file request to the update server.
     *
     * @param updateServerNode The node containing the file request information.
     * @param immediate        Whether this is an immediate or queued file request.
     * @throws IOException If there's an error sending the file request data.
     */
    private static void sendFileRequest(UpdateServerNode updateServerNode, boolean immediate) throws IOException {
        Buffer buffer = new Buffer(4);
        buffer.putByte(immediate ? 1 : 0); // Byte value representing the request type.
        buffer.putMediumBE((int) updateServerNode.key); // The file index and ID.
        updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
        if (immediate) {
            activeRequestTable.put(updateServerNode.key, updateServerNode);
        } else {
            updateServerNode.clear();
            queuedRequestTable.put(updateServerNode.key, updateServerNode);
        }
    }

    /**
     * Processes incoming data from the update server.
     *
     * @param dataAvailable The amount of data available for reading from the socket.
     * @return The number of bytes read or -1 if no data was read or there was an error.
     * @throws IOException If there's an error reading the data or processing the response.
     */
    private static int processIncomingData(int dataAvailable) throws IOException {
        int bytesRead = 0;
        if (currentResponse == null) {
            // If we don't have a current response node, we are expecting a header.
            bytesRead = readHeader(dataAvailable);
        } else {
            // If we have a current response node, we are expecting file data.
            bytesRead = readFileData(dataAvailable);
        }
        return bytesRead;
    }


    /**
     * Reads the header of the incoming data which contains information about the file.
     *
     * @param dataAvailable The amount of data available for reading from the socket.
     * @return The number of bytes read for the header.
     * @throws IOException If there's an error reading the header or the header data is invalid.
     */
    private static int readHeader(int dataAvailable) throws IOException {
        // The header is 8 bytes long for a new response node, 1 byte for the block offset.
        int headerLength = (currentResponse == null) ? 8 : 1;
        int bytesRead = readFromSocket(fileDataBuffer, headerLength, dataAvailable);
        if (headerLength == 8 && fileDataBuffer.currentPosition == 8) {
            // Complete header has been read, process it.
            return processHeader();
        }
        return bytesRead;
    }


    /**
     * Processes the header data to setup the response node.
     *
     * @return The number of bytes read for the header.
     * @throws IOException If the header data is invalid.
     */
    private static int processHeader() throws IOException {
        fileDataBuffer.currentPosition = 0;
        int fileIndexId = fileDataBuffer.getUnsignedByte();
        int fileId = fileDataBuffer.getUnsignedShortBE();
        int fileCompression = fileDataBuffer.getUnsignedByte();
        int fileSize = fileDataBuffer.getIntBE();
        long fileKey = ((long) fileIndexId << 16) + fileId;

        UpdateServerNode foundNode = (UpdateServerNode) activeRequestTable.getNode(fileKey);
        isPriorityRequest = true;

        if (foundNode == null) {
            foundNode = (UpdateServerNode) queuedRequestTable.getNode(fileKey);
            isPriorityRequest = false;
        }

        if (foundNode == null) {
            throw new IOException("Header data is invalid: Response Node not found.");
        }

        currentResponse = foundNode;
        int compressionHeaderSize = (fileCompression == 0) ? 5 : 9;
        inboundFile = new Buffer(currentResponse.padding + compressionHeaderSize + fileSize);
        inboundFile.putByte(fileCompression);
        inboundFile.putIntBE(fileSize);
        blockOffset = 8;
        fileDataBuffer.currentPosition = 0;
        return 8; // Header size
    }



    /**
     * Reads file data for the current response node from the socket.
     *
     * @param dataAvailable The amount of data available for reading from the socket.
     * @return The number of bytes read for the file data.
     * @throws IOException If there's an error reading the file data or if the CRC check fails.
     */
    private static int readFileData(int dataAvailable) throws IOException {
        int remainingData = inboundFile.buffer.length - currentResponse.padding - blockOffset;
        int dataToRead = Math.min(Math.min(remainingData, 512), dataAvailable);

        // Read data from the socket into the buffer.
        int bytesRead = readFromSocket(inboundFile, blockOffset, dataToRead);

        // If we've read some bytes and encryption is on, decrypt the data.
        if (bytesRead > 0 && encryptionKey != 0) {
            decryptData(inboundFile.buffer, inboundFile.currentPosition, bytesRead, encryptionKey);
        }

        // Update the block offset.
        blockOffset += bytesRead;

        // Check if we have read all the data for this file.
        if (blockOffset == inboundFile.buffer.length - currentResponse.padding) {
            // Complete file has been read, verify CRC and update cache archive.
            return verifyAndHandleCompleteFile();
        }

        // If we've read 512 bytes and we're not at the end of the file, reset the block offset.
        if (blockOffset == 512) {
            blockOffset = 0;
        }

        return bytesRead;
    }

    /**
     * Decrypts the data read from the socket.
     *
     * @param data     The data array to decrypt.
     * @param position The position in the array to start decrypting.
     * @param length   The number of bytes to decrypt.
     * @param key      The encryption key.
     */
    private static void decryptData(byte[] data, int position, int length, byte key) {
        for (int i = 0; i < length; i++) {
            data[position + i] = xor(data[position + i], key);
        }
    }

    /**
     * Verifies the CRC of the complete file data and updates the cache archive.
     *
     * @return The number of bytes read for the file data.
     * @throws IOException If the CRC check fails.
     */
    private static int verifyAndHandleCompleteFile() throws IOException {
        crc32.reset();
        crc32.update(inboundFile.buffer, 0, inboundFile.currentPosition);
        int calculatedCrc = (int) crc32.getValue();

        if (currentResponse.crc != calculatedCrc) {
            // CRC mismatch, handle the error.
            throw new IOException("CRC mismatch: expected " + currentResponse.crc + ", got " + calculatedCrc);
        }

        // CRC check passed, now handle the complete file data.
        // This would likely involve updating a cache archive or similar.
        // Example:
        // currentResponseNode.cacheArchive.updateFile(currentResponseNode.fileId, inboundFileBuffer.buffer);

        currentResponse.unlink(); // Remove the node from any queues it may be in.
        currentResponse = null; // Clear the current response node for the next request.
        inboundFile = null; // Clear the buffer.
        blockOffset = 0; // Reset the block offset.

        return inboundFile.currentPosition; // Return the size of the file data read.
    }




    /**
     * Reads data from the update server socket into the provided buffer.
     *
     * @param buffer        The buffer to read data into.
     * @param offset        The offset to start reading data into the buffer.
     * @param bytesToRead   The number of bytes to read.
     * @return The number of bytes actually read.
     * @throws IOException If there's an error during reading.
     */
    private static int readFromSocket(Buffer buffer, int offset, int bytesToRead) throws IOException {
        if (bytesToRead > 0) {
            updateServerSocket.readDataToBuffer(offset, bytesToRead, buffer.buffer);
            buffer.currentPosition = offset + bytesToRead; // Update the buffer's current position after reading.
        }
        return bytesToRead;
    }

    /**
     * Enqueues a file request to the update server with specified parameters.
     * If the file request is a priority, it is placed in the immediate write queue;
     * otherwise, it is added to the pending write queue.
     *
     * @param isPriorityRequest Indicates if the request is a priority.
     * @param cacheArchive      The cache archive to which the file belongs.
     * @param archiveIndexId    The index ID of the archive.
     * @param fileId            The ID of the file being requested.
     * @param filePadding       Additional padding or metadata for the file request.
     * @param expectedCrc       The expected CRC value for the file.
     */
    public static void enqueueFileRequest(boolean isPriorityRequest, CacheArchive cacheArchive,
                                          int archiveIndexId, int fileId, byte filePadding, int expectedCrc) {
        // Construct the unique file key from the archive index ID and the file ID.
        long fileKey = fileId + ((long) archiveIndexId << 16);
        // Attempt to retrieve an existing request from the various queues.
        UpdateServerNode updateServerNode = (UpdateServerNode) immediateWriteQueue.getNode(fileKey);
        if (updateServerNode == null) {
            updateServerNode = (UpdateServerNode) activeRequestTable.getNode(fileKey);
            if (updateServerNode == null) {
                updateServerNode = (UpdateServerNode) writeRequestTable.getNode(fileKey);
                if (updateServerNode == null) {
                    // If the file is not in any queue and not a queued request, create a new request.
                    if (!isPriorityRequest) {
                        updateServerNode = (UpdateServerNode) queuedRequestTable.getNode(fileKey);
                        if (updateServerNode != null) {
                            // The file is already in the queued requests table, so return early.
                            return;
                        }
                    }
                    // Create a new UpdateServerNode for the file request.
                    updateServerNode = new UpdateServerNode();
                    updateServerNode.crc = expectedCrc;
                    updateServerNode.padding = filePadding;
                    updateServerNode.cacheArchive = cacheArchive;
                    // Place the new request in the appropriate queue.
                    if (isPriorityRequest) {
                        immediateWriteQueue.put(fileKey, updateServerNode);
                        immediateWriteCount++;
                    } else {
                        pendingWriteQueue.push(updateServerNode);
                        writeRequestTable.put(fileKey, updateServerNode);
                        pendingWriteCount++;
                    }
                } else if (isPriorityRequest) {
                    // Move the existing request from the pending to the immediate queue.
                    updateServerNode.clear();
                    immediateWriteQueue.put(fileKey, updateServerNode);
                    pendingWriteCount--;
                    immediateWriteCount++;
                }
            }
        }
    }


    /**
     * Moves an update server node from the write request table to the pending write queue.
     *
     * @param archiveIndexId The index ID of the archive for the request.
     * @param fileId         The ID of the file in the request.
     */
    public static void moveRequestToPendingQueue(int archiveIndexId, int fileId) {
        // Calculate the unique key for the file request based on the archive index ID and the file ID.
        long fileKey = (archiveIndexId << 16) + fileId;

        // Retrieve the update server node associated with the given file key.
        UpdateServerNode updateServerNode = (UpdateServerNode) writeRequestTable.getNode(fileKey);

        // If the node exists in the write request table, move it to the pending write queue.
        if (updateServerNode != null) {
            pendingWriteQueue.unshift(updateServerNode);
        }
    }


    /**
     * Requests the checksum for a specific archive. If the CRC table buffer is not yet initialized,
     * it initiates the process to request it. Once the CRC table buffer is available, it updates
     * the specified cache archive with the latest version based on the checksum.
     *
     * @param cacheArchive The cache archive to update.
     * @param archiveIndex The index of the archive whose checksum is to be retrieved.
     */
    public static void requestArchiveChecksum(CacheArchive cacheArchive, int archiveIndex) {
        // Check if the CRC table buffer is not initialized.
        if (crcTableBuffer == null) {
            // If not initialized, queue a request for the CRC table buffer.
            enqueueFileRequest(true, null, 255, 255, (byte) 0, 0);
            // Store the cache archive in the loaders array for later processing.
            cacheArchiveLoaders[archiveIndex] = cacheArchive;
        } else {
            // If the CRC table buffer is initialized, calculate the position of the archive's CRC.
            crcTableBuffer.currentPosition = 5 + archiveIndex * 4;
            // Read the CRC value from the buffer.
            int checksum = crcTableBuffer.getIntBE();
            // Request the cache archive to update itself with the new version based on the checksum.
            cacheArchive.requestLatestVersion(checksum);
        }
    }


    private static int xor(int value, int key) {
        return value ^ key;
    }

    private static byte xor(byte value, byte key) {
        return (byte) (value ^ key);
    }

    private static long xor(long value, long key) {
        return value ^ key;
    }

    private static byte[] xor(byte[] data, byte key) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ key);
        }
        return result;
    }


    /**
     * Sends a reset request to the update server. This is typically done when starting a new
     * session or when an error necessitates resetting the server state.
     *
     * @param loggedIn Indicates whether the user is logged in or not, which affects the reset signal type.
     */
    public static void sendResetSignalToUpdateServer(boolean loggedIn) {
        // Check if the update server socket is already established.
        if (updateServerSocket != null) {
            try {
                // Prepare a buffer to send the reset signal.
                Buffer resetSignalBuffer = new Buffer(4);
                // The type of reset signal depends on the logged-in state.
                resetSignalBuffer.putByte(loggedIn ? 2 : 3);
                // The remaining three bytes are zeros.
                resetSignalBuffer.putMediumBE(0);
                // Send the reset signal through the update server socket.
                updateServerSocket.sendDataFromBuffer(4, 0, resetSignalBuffer.buffer);
            } catch (java.io.IOException ioexception) {
                // Print the stack trace if an I/O exception occurs.
                ioexception.printStackTrace();
                try {
                    // Attempt to kill the update server socket after an I/O exception.
                    updateServerSocket.kill();
                } catch (Exception exception) {
                    // Print the stack trace if killing the socket also results in an exception.
                    exception.printStackTrace();
                }
                // Set the server socket to null to indicate it's no longer in use.
                updateServerSocket = null;
                // Increment the I/O exceptions counter.
                ioExceptionsCount++;
            }
        }
    }


    /**
     * Safely terminates the connection to the update server socket.
     * This is typically called when the socket is no longer needed or if a shutdown is required.
     */
    public static void closeUpdateServerSocket() {
        // Check if the update server socket is already established.
        if (updateServerSocket != null) {
            try {
                // Attempt to close the update server socket.
                updateServerSocket.kill();
            } catch (Exception exception) {
                // Log the exception to standard error output. In a real-world scenario, it should be logged to a logging system.
                exception.printStackTrace();
            } finally {
                // Ensure the update server socket is set to null regardless of whether the termination was successful.
                updateServerSocket = null;
            }
        }
    }


    /**
     * Calculates the percentage of data loaded for the specified archive and file.
     * This method is used to determine how much of the current response has been loaded.
     *
     * @param archiveId The ID of the archive to check.
     * @param fileId    The ID of the file within the archive to check.
     * @return The percentage of data loaded, ranging from 0 to 99.
     */
    public static int calculatePercentageDataLoaded(int archiveId, int fileId) {
        // Create a unique key for the file using the archive ID and the file ID.
        long fileKey = ((long) archiveId << 16) + fileId;
        // If there is no current response or the key does not match, return 0 (no data loaded).
        if (currentResponse == null || currentResponse.key != fileKey) {
            return 0;
        }
        // Calculate the loaded data percentage based on the current position in the buffer.
        // The current position is compared to the total size, subtracting any padding.
        // This is scaled to a percentage (0 to 99).
        return (inboundFile.currentPosition * 99) / (inboundFile.buffer.length - currentResponse.padding);
    }


    /**
     * Retrieves the count of active tasks within the update server, separated into immediate and pending tasks.
     *
     * @param includePendingTasks Flag to include pending tasks in the count.
     * @param includeImmediateTasks Flag to include immediate tasks in the count.
     * @return The total count of active tasks based on the specified criteria.
     */
    public static int getActiveTaskCount(boolean includePendingTasks, boolean includeImmediateTasks) {
        int totalTaskCount = 0;

        // If immediate tasks are to be included, add their count to the total.
        if (includeImmediateTasks) {
            totalTaskCount += immediateResponseCount + immediateWriteCount;
        }

        // If pending tasks are to be included, add their count to the total.
        if (includePendingTasks) {
            totalTaskCount += pendingResponseCount + pendingWriteCount;
        }

        return totalTaskCount;
    }

}
