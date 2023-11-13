package org.runejs.client.login;

import org.runejs.Configuration;
import org.runejs.client.LoginScreen;
import org.runejs.client.Game;
import org.runejs.client.GameSocket;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.util.RSAConfiguration;
import org.runejs.client.util.SignlinkNode;

import java.io.IOException;
import java.net.Socket;

public class RS435LoginProtocol implements LoginProtocol {

    enum Stage {
        DESTROY,
        CONNECT,
        HANDSHAKE,
        HANDSHAKE_RESPONSE,
        SERVER_KEYS,
        LOGIN_REQUEST,
        LOGIN_RESPONSE,
        PROFILE_BEING_TRANSFERRED,
        WAIT_FOR_PROFILE_TRANSFER,
        LOGIN_ACCEPTED,
        LOGIN_ACCEPTED_BODY
    }

    private Stage stage = Stage.DESTROY;

    /**
     * How many times the `process` method was called without resolution
     *
     * TODO (jkm) these aren't necessarily unsuccessful, give a better name
     */
    private int unsuccessfulAttemptCount = 0;

    /**
     * The encryption keys send from the server, used to seed ISAAC.
     */
    private long serverISAACKeys = 0L;

    /**
     * How long (in client ticks) until the player's profile will be transferred
     * from its previous world.
     */
    private int timeUntilProfileTransfer = 0;

    /**
     * How many times the client has attempted switching ports due to
     * login failures
     */
    private int portChangeAttemptCount = 0;

    @Override
    public void process() {
        try {
            if (stage == Stage.DESTROY) {
                if (MovedStatics.gameServerSocket != null) {
                    MovedStatics.gameServerSocket.kill();
                    MovedStatics.gameServerSocket = null;
                }

                Game.aBoolean871 = false;
                stage = Stage.CONNECT;
                unsuccessfulAttemptCount = 0;
                MovedStatics.gameServerSignlinkNode = null;
            }

            if (stage == Stage.CONNECT) {
                if (MovedStatics.gameServerSignlinkNode == null) {
                    MovedStatics.gameServerSignlinkNode = Game.signlink.putSocketNode(Game.currentPort);
                }

                if (MovedStatics.gameServerSignlinkNode.status == SignlinkNode.Status.ERRORED) {
                    throw new IOException();
                }

                if (MovedStatics.gameServerSignlinkNode.status == SignlinkNode.Status.INITIALIZED) {
                    MovedStatics.gameServerSocket = new GameSocket((Socket) MovedStatics.gameServerSignlinkNode.value, Game.signlink);
                    stage = Stage.HANDSHAKE;
                    MovedStatics.gameServerSignlinkNode = null;
                }
            }

            if (stage == Stage.HANDSHAKE) {
                sendLoginHandshake();
            }

            if (stage == Stage.HANDSHAKE_RESPONSE) {
                int responseCode = MovedStatics.gameServerSocket.read();
                if (responseCode != 0) {
                    LoginScreen.displayMessageForResponseCode(responseCode);
                    return;
                }
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                stage = Stage.SERVER_KEYS;
            }

            if (stage == Stage.SERVER_KEYS) {
                receiveServerISAACKeys();
            }

            if (stage == Stage.LOGIN_REQUEST) {
                sendLoginRequest();
            }

            if (stage == Stage.LOGIN_RESPONSE && MovedStatics.gameServerSocket.inputStreamAvailable() > 0) { // Login response
                int responseCode = MovedStatics.gameServerSocket.read();

                if (responseCode != 21 || Game.gameStatusCode != 20) {
                    if (responseCode == 2) {
                        stage = Stage.LOGIN_ACCEPTED;
                    } else {
                        if (responseCode == 15 && Game.gameStatusCode == 40) {
                            MovedStatics.method434();
                            return;
                        }

                        if (responseCode == 23 && portChangeAttemptCount < 1) {
                            portChangeAttemptCount++;
                            stage = Stage.DESTROY;
                        } else {
                            LoginScreen.displayMessageForResponseCode(responseCode);
                            return;
                        }
                    }
                } else {
                    stage = Stage.PROFILE_BEING_TRANSFERRED;
                }
            }

            if (stage == Stage.PROFILE_BEING_TRANSFERRED && MovedStatics.gameServerSocket.inputStreamAvailable() > 0) { // Transferring profile
                timeUntilProfileTransfer = 180 + MovedStatics.gameServerSocket.read() * 60;
                stage = Stage.WAIT_FOR_PROFILE_TRANSFER;
            }

            if (stage == Stage.WAIT_FOR_PROFILE_TRANSFER) { // Wait for transfer
                unsuccessfulAttemptCount = 0;
                LoginScreen.setLoginScreenMessage(English.youHaveJustLeftAnotherWorld, English.yourProfileWillBeTransferredIn, (timeUntilProfileTransfer / 60) + English.suffixSeconds);

                if (--timeUntilProfileTransfer <= 0) {
                    stage = Stage.DESTROY;
                }
            } else {
                if (stage == Stage.LOGIN_ACCEPTED && MovedStatics.gameServerSocket.inputStreamAvailable() >= 8) { // Login response
                    Configuration.USERNAME = Native.username.toString();
                    Configuration.PASSWORD = Native.password.toString();
                    Game.playerRights = MovedStatics.gameServerSocket.read();
                    Game.accountFlagged = MovedStatics.gameServerSocket.read() == 1;
                    Player.localPlayerId = MovedStatics.gameServerSocket.read();
                    Player.localPlayerId <<= 8;
                    Player.localPlayerId += MovedStatics.gameServerSocket.read();
                    MovedStatics.isLocalPlayerMember = MovedStatics.gameServerSocket.read();
                    MovedStatics.gameServerSocket.readDataToBuffer(0, 1, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.opcode = IncomingPackets.incomingPacketBuffer.getPacket();
                    MovedStatics.gameServerSocket.readDataToBuffer(0, 2, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacketSize = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    stage = Stage.LOGIN_ACCEPTED_BODY;
                }

                if (stage == Stage.LOGIN_ACCEPTED_BODY) {
                    if (MovedStatics.gameServerSocket.inputStreamAvailable() >= IncomingPackets.incomingPacketSize) { // Login response packets
                        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                        MovedStatics.gameServerSocket.readDataToBuffer(0, IncomingPackets.incomingPacketSize, IncomingPackets.incomingPacketBuffer.buffer);
                        Game.setConfigToDefaults();
                        MovedStatics.regionX = -1;
                        Game.currentScene.landscape.constructMapRegion(false);
                        IncomingPackets.opcode = -1;
                    }
                } else {
                    unsuccessfulAttemptCount++;

                    if (unsuccessfulAttemptCount > 2000) {
                        if (portChangeAttemptCount < 1) {
                            portChangeAttemptCount++;

                            if (Game.gameServerPort == Game.currentPort) {
                                Game.currentPort = Game.someOtherPort;
                            } else {
                                Game.currentPort = Game.gameServerPort;
                            }

                            stage = Stage.DESTROY;
                        } else {
                            LoginScreen.displayMessageForResponseCode(-3);
                        }
                    }
                }
            }
        } catch (IOException ioexception) {
            if (portChangeAttemptCount < 1) {
                if (Game.currentPort == Game.gameServerPort) {
                    Game.currentPort = Game.someOtherPort;
                } else {
                    Game.currentPort = Game.gameServerPort;
                }

                portChangeAttemptCount++;
                stage = Stage.DESTROY;
            } else {
                LoginScreen.displayMessageForResponseCode(-2);
            }
        }
    }

    /**
     * Send the main login request.
     *
     * @throws IOException
     */
    private void sendLoginRequest() throws IOException {
        int[] seeds = new int[4];
        seeds[0] = (int) (Math.random() * 9.9999999E7);
        seeds[1] = (int) (Math.random() * 9.9999999E7);
        seeds[2] = (int) (serverISAACKeys >> 32);
        seeds[3] = (int) serverISAACKeys;

        LoginType connectionType =
                (Game.gameStatusCode == 40)
                        ? LoginType.RECONNECTION
                        : LoginType.NEW_CONNECTION;

        RSAConfiguration rsa =
                (Configuration.RSA_ENABLED)
                        ? new RSAConfiguration(Configuration.RSA_MODULUS, Configuration.RSA_PUBLIC_KEY)
                        : null;

        int[] crcs = new int[13];
        int crcIndex = 0;

        crcs[crcIndex++] = CacheArchive.skeletonCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.skinDefinitionCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.gameDefinitionsCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.gameInterfaceCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.soundEffectCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.gameWorldMapCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.musicCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.modelCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.gameImageCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.gameTextureCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.huffmanCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.jingleCacheArchive.crc8;
        crcs[crcIndex++] = CacheArchive.clientScriptCacheArchive.crc8;

        Buffer loginPacket = encodeRequest(
                        new LoginRequest(
                                connectionType,
                                seeds,
                                Game.signlink.uid,
                                Native.username,
                                Native.password,
                                rsa,
                                435,
                                VertexNormal.lowMemory,
                                crcs
                        )
                );

        MovedStatics.gameServerSocket.sendDataFromBuffer(loginPacket.currentPosition, 0, loginPacket.buffer);

        OutgoingPackets.buffer.initOutCipher(seeds);

        // TODO (Jameskmonger) this is a hack to allow the packet logic to access the ISAAC generator. This should be reworked.
        OutgoingPackets.init(OutgoingPackets.buffer.outCipher);

        for (int i = 0; i < 4; i++) {
            seeds[i] += 50;
        }

        IncomingPackets.incomingPacketBuffer.initInCipher(seeds);
        stage = Stage.LOGIN_RESPONSE;
    }

    /**
     * Send the handshake request to the server.
     *
     * This is believed to route the player to the correct login server based on
     * some discriminator from their username.
     *
     * @throws IOException
     */
    private void sendLoginHandshake() throws IOException {
        long l = MovedStatics.localUsernameId = MovedStatics.nameToLong(Native.username.toString());
        OutgoingPackets.buffer.currentPosition = 0;
        OutgoingPackets.buffer.putByte(14);
        int i = (int) (0x1fL & l >> 16);
        OutgoingPackets.buffer.putByte(i);
        MovedStatics.gameServerSocket.sendDataFromBuffer(2, 0, OutgoingPackets.buffer.buffer);
        stage = Stage.HANDSHAKE_RESPONSE;
        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
    }

    /**
     * Receive the ISAAC keys from the server.
     *
     * @throws IOException
     */
    private void receiveServerISAACKeys() throws IOException {
        if (IncomingPackets.incomingPacketBuffer.currentPosition < 8) {
            int i = MovedStatics.gameServerSocket.inputStreamAvailable();

            if (i > 8 - IncomingPackets.incomingPacketBuffer.currentPosition) {
                i = 8 - IncomingPackets.incomingPacketBuffer.currentPosition;
            }

            if (i > 0) {
                MovedStatics.gameServerSocket.readDataToBuffer(IncomingPackets.incomingPacketBuffer.currentPosition, i, IncomingPackets.incomingPacketBuffer.buffer);
                IncomingPackets.incomingPacketBuffer.currentPosition += i;
            }
        }
        if (IncomingPackets.incomingPacketBuffer.currentPosition == 8) {
            IncomingPackets.incomingPacketBuffer.currentPosition = 0;
            serverISAACKeys = IncomingPackets.incomingPacketBuffer.getLongBE();
            stage = Stage.LOGIN_REQUEST;
        }
    }

    @Override
    public void reset() {
        stage = Stage.DESTROY;
        unsuccessfulAttemptCount = 0;
        portChangeAttemptCount = 0;
    }

    /**
     * Encode the overall login request into a buffer, including the
     * RSA-encrypted secret block.
     *
     * @param message The login request
     * @return a Buffer containing the entire encoded request
     */
    private Buffer encodeRequest(LoginRequest request) {
        // TODO (jkm) maybe size can be lessened
        Buffer buffer = new Buffer(200);

        /**
         * TODO (jkm) we could probably use `putPacket` here and treat 16/18 as opcodes
         *            but first we would need to make ISAAC optional
         */
        if (request.type == LoginType.RECONNECTION) {
            buffer.putByte(18);
        } else if (request.type == LoginType.NEW_CONNECTION) {
            buffer.putByte(16);
        } else {
            throw new RuntimeException("Unrecognised connection type");
        }

        // the encrypted part of the buffer must be prepared in advance so we can write the length
        Buffer encryptedLoginBuffer = getEncryptedLoginBuffer(request);
        buffer.putByte(57 + encryptedLoginBuffer.currentPosition);

        buffer.putIntBE(request.clientVersion);
        buffer.putByte(request.lowMemory ? 1 : 0);

        if (request.crcs.length != 13) {
            throw new RuntimeException("Unexpected CRC collection length of " + request.crcs.length + ", expected 13");
        }

        for (int i = 0; i < request.crcs.length; i++) {
            buffer.putIntBE(request.crcs[i]);
        }

        buffer.putBytes(0, encryptedLoginBuffer.currentPosition, encryptedLoginBuffer.buffer);

        return buffer;
    }

    /**
     * Prepare the secret part of the login request and apply RSA to it.
     *
     * @param message The login request
     * @return the RSA-encrypted buffer for the secret part of the request
     */
    private Buffer getEncryptedLoginBuffer(LoginRequest message) {
        // TODO (jkm) maybe size can be lessened
        Buffer buffer = new Buffer(140);
        buffer.putByte(10);
        buffer.putIntBE(message.seeds[0]);
        buffer.putIntBE(message.seeds[1]);
        buffer.putIntBE(message.seeds[2]);
        buffer.putIntBE(message.seeds[3]);
        buffer.putIntBE(message.uid);
        buffer.putLongBE(MovedStatics.nameToLong(message.username.toString()));
        buffer.method505(message.password);

        if (message.rsa != null) {
            buffer.applyRSA(message.rsa.modulus, message.rsa.publicKey);
        }

        return buffer;
    }
}
