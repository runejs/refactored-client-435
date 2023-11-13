package org.runejs.client.login;

import org.runejs.Configuration;
import org.runejs.client.Class60;
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

    @Override
    public void process() {
        try {
            if (stage == Stage.DESTROY) { // Destroy
                if (MovedStatics.gameServerSocket != null) {
                    MovedStatics.gameServerSocket.kill();
                    MovedStatics.gameServerSocket = null;
                }
                Game.aBoolean871 = false;
                stage = Stage.CONNECT;
                Game.anInt1756 = 0;
                MovedStatics.gameServerSignlinkNode = null;
            }
            if (stage == Stage.CONNECT) { // Connect
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
            if (stage == Stage.HANDSHAKE) { // Handshake
                MovedStatics.aLong853 = MovedStatics.nameToLong(Native.username.toString());

                long l = MovedStatics.aLong853 = MovedStatics.nameToLong(Native.username.toString());
                OutgoingPackets.buffer.currentPosition = 0;
                OutgoingPackets.buffer.putByte(14);
                int i = (int) (0x1fL & l >> 16);
                OutgoingPackets.buffer.putByte(i);
                MovedStatics.gameServerSocket.sendDataFromBuffer(2, 0, OutgoingPackets.buffer.buffer);
                stage = Stage.HANDSHAKE_RESPONSE;
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
            }
            if (stage == Stage.HANDSHAKE_RESPONSE) { // Handshake Response
                int i = MovedStatics.gameServerSocket.read();
                if (i != 0) {
                    Game.displayMessageForResponseCode(i);
                    return;
                }
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                stage = Stage.SERVER_KEYS;
            }
            if (stage == Stage.SERVER_KEYS) { // Server keys

                if (IncomingPackets.incomingPacketBuffer.currentPosition < 8) {
                    int i = MovedStatics.gameServerSocket.inputStreamAvailable();
                    if (i > -IncomingPackets.incomingPacketBuffer.currentPosition + 8) {
                        i = -IncomingPackets.incomingPacketBuffer.currentPosition + 8;
                    }
                    if (i > 0) {
                        MovedStatics.gameServerSocket.readDataToBuffer(IncomingPackets.incomingPacketBuffer.currentPosition, i, IncomingPackets.incomingPacketBuffer.buffer);
                        IncomingPackets.incomingPacketBuffer.currentPosition += i;
                    }
                }
                if (IncomingPackets.incomingPacketBuffer.currentPosition == 8) {
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    MovedStatics.aLong2858 = IncomingPackets.incomingPacketBuffer.getLongBE();
                    stage = Stage.LOGIN_REQUEST;
                }
            }
            if (stage == Stage.LOGIN_REQUEST) { // Login request
                int[] seeds = new int[4];
                seeds[0] = (int) (Math.random() * 9.9999999E7);
                seeds[1] = (int) (Math.random() * 9.9999999E7);
                seeds[2] = (int) (MovedStatics.aLong2858 >> 32);
                seeds[3] = (int) MovedStatics.aLong2858;

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

                // TODO (Jameskmonger) this allows the OutgoingPackets to access the ISAAC cipher. This is a hack and should be fixed.
                OutgoingPackets.init(OutgoingPackets.buffer.outCipher);

                for (int i = 0; i < 4; i++) {
                    seeds[i] += 50;
                }
                IncomingPackets.incomingPacketBuffer.initInCipher(seeds);
                stage = Stage.LOGIN_RESPONSE;
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
                        if (responseCode == 23 && MovedStatics.anInt2321 < 1) {
                            MovedStatics.anInt2321++;
                            stage = Stage.DESTROY;
                        } else {
                            Game.displayMessageForResponseCode(responseCode);
                            return;
                        }
                    }
                } else {
                    stage = Stage.PROFILE_BEING_TRANSFERRED;
                }
            }
            if (stage == Stage.PROFILE_BEING_TRANSFERRED && MovedStatics.gameServerSocket.inputStreamAvailable() > 0) { // Transferring profile
                Game.anInt784 = 180 + MovedStatics.gameServerSocket.read() * 60;
                stage = Stage.WAIT_FOR_PROFILE_TRANSFER;

            }
            if (stage == Stage.WAIT_FOR_PROFILE_TRANSFER) { // Wait for transfer
                Game.anInt1756 = 0;
                Class60.setLoginScreenMessage(English.youHaveJustLeftAnotherWorld, English.yourProfileWillBeTransferredIn, (Game.anInt784 / 60) + English.suffixSeconds);
                if (--Game.anInt784 <= 0) {
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
                    MovedStatics.anInt1049 = MovedStatics.gameServerSocket.read();
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
                    Game.anInt1756++;
                    if (Game.anInt1756 > 2000) {
                        if (MovedStatics.anInt2321 < 1) {
                            MovedStatics.anInt2321++;
                            if (Game.gameServerPort == Game.currentPort) {
                                Game.currentPort = Game.someOtherPort;
                            } else {
                                Game.currentPort = Game.gameServerPort;
                            }
                            stage = Stage.DESTROY;
                        } else {
                            Game.displayMessageForResponseCode(-3);
                        }
                    }
                }
            }
        } catch (IOException ioexception) {
            if (MovedStatics.anInt2321 < 1) {
                if (Game.currentPort == Game.gameServerPort) {
                    Game.currentPort = Game.someOtherPort;
                } else {
                    Game.currentPort = Game.gameServerPort;
                }
                MovedStatics.anInt2321++;
                stage = Stage.DESTROY;
            } else {
                Game.displayMessageForResponseCode(-2);
            }
        }
    }

    @Override
    public void reset() {
        stage = Stage.DESTROY;
    }

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

    private void initializeStage() {

    }
}
