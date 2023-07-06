package org.runejs.client.net;

import org.runejs.client.*;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.net.codec.MessageDecoder;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.scene.tile.WallDecoration;
import org.runejs.client.sound.SoundSystem;

public class IncomingPackets {
    public static int incomingPacketSize = 0;
    public static PacketBuffer incomingPacketBuffer = new PacketBuffer(5000);
    public static int opcode = 0;
    public static int lastOpcode = 0;
    public static int secondLastOpcode = 0;
    public static int thirdLastOpcode = 0;
    public static int cyclesSinceLastPacket = 0;

    public static boolean parseIncomingPackets() {
        if(MovedStatics.gameServerSocket == null)
            return false;
        try {
            int availableBytes = MovedStatics.gameServerSocket.inputStreamAvailable();
            if(availableBytes == 0) {
                // Out of memory
                return false;
            }

            if(opcode == -1) {
                // This will always run first. It fetches the incoming packet ID which should have a size of 1
                MovedStatics.gameServerSocket.readDataToBuffer(0, 1, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                availableBytes--;
                opcode = incomingPacketBuffer.getPacket();
                incomingPacketSize = Main.packetCodec.getPacketLength(opcode);
            }

            if(incomingPacketSize == -1) {
                // Server-defined packet size between 0 and 255
                if(availableBytes > 0) {
                    MovedStatics.gameServerSocket.readDataToBuffer(0, 1, incomingPacketBuffer.buffer);
                    incomingPacketSize = incomingPacketBuffer.buffer[0] & 0xff;
                    availableBytes--;
                } else
                    return false;
            }

            if(incomingPacketSize == -2) {
                // Server-defined packet size between 0 and 65535
                if(availableBytes <= 1)
                    return false;
                availableBytes -= 2;
                MovedStatics.gameServerSocket.readDataToBuffer(0, 2, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                incomingPacketSize = incomingPacketBuffer.getUnsignedShortBE();
            }

            if(incomingPacketSize > availableBytes) {
                // Out of memory, would not be able to read this packet
                return false;
            }

            incomingPacketBuffer.currentPosition = 0;

            cyclesSinceLastPacket = 0;
            thirdLastOpcode = secondLastOpcode;
            secondLastOpcode = lastOpcode;
            lastOpcode = opcode;

            // find the correct decoder for this packet
            MessageDecoder decoder = Main.packetCodec.getMessageDecoder(opcode);

            if (decoder != null) {
                // create a new packet buffer with the correct size, and read the data into it
                PacketBuffer packetBuffer = new PacketBuffer(incomingPacketSize);
                MovedStatics.gameServerSocket.readDataToBuffer(0, incomingPacketSize, packetBuffer.buffer);

                // decode the packet and handle it
                InboundMessage message = decoder.decode(packetBuffer);
                MessageHandler handler = Main.handlerRegistry.getMessageHandler(message.getClass());

                if (handler == null)
                    throw new RuntimeException("No handler for message: " + message.getClass().getName());

                handler.handle(message);

                opcode = -1;
                return true;
            }

            // if we get here, we have no decoder for this packet
            // and it is left to be handled by the old system

            MovedStatics.gameServerSocket.readDataToBuffer(0, incomingPacketSize, incomingPacketBuffer.buffer);

            if(opcode == PacketType.BULK_WORLD_UPDATE.getOpcode()) { // mass object/ground item update packet
                MovedStatics.placementX = incomingPacketBuffer.getUnsignedByte();
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                while(incomingPacketBuffer.currentPosition < incomingPacketSize) {
                    opcode = incomingPacketBuffer.getUnsignedByte();
                    parseMapIncomingPacket();
                }
                opcode = -1;
                return true;
            }
            // object/ground item update packets?
            if(opcode == PacketType.CREATE_PROJECTILE.getOpcode() || opcode == PacketType.ROTATE_ANIMATE_OBJECT.getOpcode() || opcode == PacketType.REMOVE_OBJECT.getOpcode() || opcode == PacketType.SPAWN_OBJECT.getOpcode()) {
                parseMapIncomingPacket();
                opcode = -1;
                return true;
            }
            if(opcode == 240) {
                ClientScriptRunner.parseClientScriptPacket(Main.signlink, incomingPacketBuffer);
                opcode = -1;
                return true;
            }
            if(opcode == 58) {
                int i_106_ = incomingPacketBuffer.getIntME2();
                Class12.aSignlinkNode_394 = Main.signlink.createExceptionNode(i_106_); // TODO this just ends up throwing an exception? wot
                opcode = -1;
                return true;
            }
            MovedStatics.printException("T1 - " + opcode + "," + secondLastOpcode + "," + thirdLastOpcode + " - " + incomingPacketSize, null);
            MovedStatics.logout();
        } catch(java.io.IOException ioexception) {
            Class59.dropClient();
        } catch(Exception exception) {
            String string = "T2 - " + opcode + "," + secondLastOpcode + "," + thirdLastOpcode + " - " + incomingPacketSize + "," + (MovedStatics.baseX + Player.localPlayer.pathY[0]) + "," + (Player.localPlayer.pathX[0] + Class26.baseY) + " - ";
            for(int i = 0; incomingPacketSize > i && i < 50; i++)
                string += incomingPacketBuffer.buffer[i] + ",";
            MovedStatics.printException(string, exception);
            MovedStatics.logout();
            exception.printStackTrace();
        }
        return true;

    }

    public static void parseMapIncomingPacket() {
        if (opcode == PacketType.ROTATE_ANIMATE_OBJECT.getOpcode()) {
            int positionData = incomingPacketBuffer.getUnsignedByte();
            int y = OverlayDefinition.placementY + (positionData & 0x7);
            int x = ((0x7b & positionData) >> 4) + MovedStatics.placementX;
            int objectData = incomingPacketBuffer.getUnsignedByte();
            int objectTypeKey = objectData >> 2;
            int orientation = 0x3 & objectData;
            int objectType = Npc.anIntArray3304[objectTypeKey];
            int animationId = incomingPacketBuffer.getUnsignedShortLE();
            if (x >= 0 && y >= 0 && x < 103 && y < 103) {
                int tileHeightX0Y0 = MovedStatics.tile_height[Player.worldLevel][x][y];
                int tileHeightX1Y0 = MovedStatics.tile_height[Player.worldLevel][x + 1][y];
                int tileHeightX1Y1 = MovedStatics.tile_height[Player.worldLevel][1 + x][1 + y];
                int tileHeightX0Y1 = MovedStatics.tile_height[Player.worldLevel][x][y + 1];
                if (objectType == 0) {
                    Wall wall = Npc.currentScene.method126(Player.worldLevel, x, y);
                    if (wall != null) {
                        int i_11_ = 0x7fff & wall.hash >> 14;
                        if (objectTypeKey == 2) {
                            wall.primary = new GameObject(i_11_, 2, 4 + orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                            wall.secondary = new GameObject(i_11_, 2, 0x3 & orientation + 1, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                        } else
                            wall.primary = new GameObject(i_11_, objectTypeKey, orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                    }
                }
                if (objectType == 1) {
                    WallDecoration wallDecoration = Npc.currentScene.getWallDecoration(Player.worldLevel, x, y);
                    if (wallDecoration != null)
                        wallDecoration.renderable = new GameObject((0x1fffe268 & wallDecoration.hash) >> 14, 4, 0, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                }
                if (objectType == 2) {
                    InteractiveObject interactiveObject = Npc.currentScene.method107(Player.worldLevel, x, y);
                    if (objectTypeKey == 11)
                        objectTypeKey = 10;
                    if (interactiveObject != null)
                        interactiveObject.renderable = new GameObject(interactiveObject.hash >> 14 & 0x7fff, objectTypeKey, orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                }
                if (objectType == 3) {
                    FloorDecoration floorDecoration = Npc.currentScene.getFloorDecoration(Player.worldLevel, x, y);
                    if (floorDecoration != null)
                        floorDecoration.renderable = new GameObject(0x7fff & floorDecoration.hash >> 14, 22, orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                }
            }
        } else if (opcode == PacketType.SPAWN_OBJECT.getOpcode()) { // set landscape object
            int data = incomingPacketBuffer.getUnsignedByte();
            int orientation = data & 0x3;
            int objectTypeIndex = data >> 2;
            int objectType = Npc.anIntArray3304[objectTypeIndex];
            int objectId = incomingPacketBuffer.getUnsignedShortBE();
            int positionOffset = incomingPacketBuffer.getUnsignedByte();
            int x = (0x7 & positionOffset) + OverlayDefinition.placementY;
            int y = MovedStatics.placementX + ((positionOffset & 0x75) >> 4);
            if (y >= 0 && x >= 0 && y < 104 && x < 104)
                GameObjectDefinition.method609(objectId, y, orientation, -1, Player.worldLevel, x, objectType, objectTypeIndex, 0);
        } else {
            if (opcode == PacketType.PLAY_SOUND_AT_POSITION.getOpcode()) {
                int offset = incomingPacketBuffer.getUnsignedByte();
                int localX = (offset & 0x7) + OverlayDefinition.placementY;
                int localY = (0x7 & offset >> 4) + MovedStatics.placementX;
                int soundId = incomingPacketBuffer.getUnsignedShortBE();

                int soundData = incomingPacketBuffer.getUnsignedByte();
                int radius = soundData >> 4 & 0xf;
                int volume = 0x7 & soundData;
                int delay = incomingPacketBuffer.getUnsignedByte();
                if (localY >= 0 && localX >= 0 && localY < 104 && localX < 104) {
                    int i_26_ = 1 + radius;
                    if (Player.localPlayer.pathY[0] >= localY - i_26_ && Player.localPlayer.pathY[0] <= localY + i_26_ && localX - i_26_ <= Player.localPlayer.pathX[0] && localX + i_26_ >= Player.localPlayer.pathX[0]) {                        
                        SoundSystem.play(soundId, volume, delay, radius + (localX << 8) + (localY << 16));
                    }
                }
            }
            if (opcode == PacketType.CREATE_STATIONARY_GFX.getOpcode()) {
                int i = incomingPacketBuffer.getUnsignedByte();
                int x = ((0x78 & i) >> 4) + MovedStatics.placementX;
                int y = OverlayDefinition.placementY + (0x7 & i);
                int gfxId = incomingPacketBuffer.getUnsignedShortBE();
                int drawHeight = incomingPacketBuffer.getUnsignedByte();
                int delay = incomingPacketBuffer.getUnsignedShortBE();
                if (x >= 0 && y >= 0 && x < 104 && y < 104) {
                    y = 128 * y + 64;
                    x = x * 128 + 64;
                    Class40_Sub5_Sub17_Sub6 gfx = new Class40_Sub5_Sub17_Sub6(gfxId, Player.worldLevel, x, y, -drawHeight + Class37.getFloorDrawHeight(Player.worldLevel, x, y), delay, MovedStatics.pulseCycle);
                    Class57.aLinkedList_1332.addLast(gfx);
                }
            } else if (opcode == PacketType.UPDATE_GROUND_ITEM_AMOUNT.getOpcode()) {
                int i = incomingPacketBuffer.getUnsignedByte();
                int i_32_ = MovedStatics.placementX + ((0x75 & i) >> 4);
                int i_33_ = (i & 0x7) + OverlayDefinition.placementY;
                int i_34_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_36_ = incomingPacketBuffer.getUnsignedShortBE();
                if (i_32_ >= 0 && i_33_ >= 0 && i_32_ < 104 && i_33_ < 104) {
                    LinkedList linkedList = Wall.groundItems[Player.worldLevel][i_32_][i_33_];
                    if (linkedList != null) {
                        for (Item item = (Item) linkedList.peekFirst(); item != null; item = (Item) linkedList.pollFirst()) {
                            if (item.itemId == (i_34_ & 0x7fff) && i_35_ == item.itemCount) {
                                item.itemCount = i_36_;
                                break;
                            }
                        }
                        FramemapDefinition.spawnGroundItem(i_33_, i_32_);
                    }
                }
            } else if (opcode == PacketType.REMOVE_OBJECT.getOpcode()) { // remove landscape object
                int offset = incomingPacketBuffer.getUnsignedByte();
                int positionY = OverlayDefinition.placementY + (0x7 & offset);
                int positionX = MovedStatics.placementX + (offset >> 4 & 0x7);
                int objectInfo = incomingPacketBuffer.getUnsignedByte();
                int orientation = objectInfo & 0x3;
                int typeIndex = objectInfo >> 2;
                int objectType = Npc.anIntArray3304[typeIndex];
                if (positionX >= 0 && positionY >= 0 && positionX < 104 && positionY < 104)
                    GameObjectDefinition.method609(-1, positionX, orientation, -1, Player.worldLevel, positionY, objectType, typeIndex, 0);
            } else {
                if (opcode == PacketType.TRANSFORM_PLAYER_TO_OBJECT.getOpcode()) {
                    int unknownXMax = incomingPacketBuffer.getByte();
                    int playerId = incomingPacketBuffer.getUnsignedShortBE();
                    int unknownYMax = incomingPacketBuffer.getByte();
                    int unknownYMin = incomingPacketBuffer.getByte();
                    int objectData = incomingPacketBuffer.getUnsignedByte();
                    int orientation = objectData & 0x3;
                    int typeKey = objectData >> 2;
                    int type = Npc.anIntArray3304[typeKey];
                    int positionData = incomingPacketBuffer.getUnsignedByte();
                    int y = (positionData & 0x7) + OverlayDefinition.placementY;
                    int x = MovedStatics.placementX + (positionData >> 4 & 0x7);
                    int delay = incomingPacketBuffer.getUnsignedShortBE();
                    int unknownXMin = incomingPacketBuffer.getByte();
                    int objectId = incomingPacketBuffer.getUnsignedShortLE();
                    int duration = incomingPacketBuffer.getUnsignedShortLE();
                    Player player;
                    if (playerId != PlayerAppearance.anInt708)
                        player = Player.trackedPlayers[playerId];
                    else
                        player = Player.localPlayer;
                    if (player != null) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(objectId);
                        int tileHeightX0Y0 = MovedStatics.tile_height[Player.worldLevel][x][y];
                        int tileHeightX0Y1 = MovedStatics.tile_height[Player.worldLevel][x][1 + y];
                        int tileHeightX1Y1 = MovedStatics.tile_height[Player.worldLevel][1 + x][1 + y];
                        int tileHeightX1Y0 = MovedStatics.tile_height[Player.worldLevel][x + 1][y];
                        Model model = gameObjectDefinition.createTerrainObjectModel(tileHeightX1Y1, tileHeightX0Y1, orientation, tileHeightX0Y0, typeKey, tileHeightX1Y0);
                        if (model != null) {
                            if (unknownXMax < unknownXMin) {
                                int temp = unknownXMin;
                                unknownXMin = unknownXMax;
                                unknownXMax = temp;
                            }
                            if (unknownYMax < unknownYMin) {
                                int temp = unknownYMin;
                                unknownYMin = unknownYMax;
                                unknownYMax = temp;
                            }
                            GameObjectDefinition.method609(-1, x, 0, 1 + duration, Player.worldLevel, y, type, 0, 1 + delay);
                            player.anInt3274 = duration + MovedStatics.pulseCycle;
                            int sizeX = gameObjectDefinition.sizeX;
                            player.playerModel = model;
                            player.anInt3283 = delay + MovedStatics.pulseCycle;
                            int sizeY = gameObjectDefinition.sizeY;
                            if (orientation == 1 || orientation == 3) {
                                sizeY = gameObjectDefinition.sizeX;
                                sizeX = gameObjectDefinition.sizeY;
                            }
                            player.anInt3271 = x * 128 + 64 * sizeX;
                            player.anInt3291 = y * 128 + 64 * sizeY;
                            player.anInt3272 = Class37.getFloorDrawHeight(Player.worldLevel, player.anInt3271, player.anInt3291);
                            player.anInt3281 = unknownYMin + y;
                            player.anInt3258 = x + unknownXMin;
                            player.anInt3262 = x + unknownXMax;
                            player.anInt3289 = unknownYMax + y;
                        }
                    }
                }
                if (opcode == PacketType.REMOVE_GROUND_ITEM.getOpcode()) { // remove world item
                    int i = incomingPacketBuffer.getUnsignedByte();
                    int i_65_ = MovedStatics.placementX + (i >> 4 & 0x7);
                    int i_66_ = (i & 0x7) + OverlayDefinition.placementY;
                    int i_67_ = incomingPacketBuffer.getUnsignedShortBE();
                    if (i_65_ >= 0 && i_66_ >= 0 && i_65_ < 104 && i_66_ < 104) {
                        LinkedList linkedList = Wall.groundItems[Player.worldLevel][i_65_][i_66_];
                        if (linkedList != null) {
                            for (Item item = (Item) linkedList.peekFirst(); item != null; item = (Item) linkedList.pollFirst()) {
                                if ((0x7fff & i_67_) == item.itemId) {
                                    item.unlink();
                                    break;
                                }
                            }
                            if (linkedList.peekFirst() == null)
                                Wall.groundItems[Player.worldLevel][i_65_][i_66_] = null;
                            FramemapDefinition.spawnGroundItem(i_66_, i_65_);
                        }
                    }
                } else if (opcode == PacketType.CREATE_PROJECTILE.getOpcode()) {
                    int offset = incomingPacketBuffer.getUnsignedByte();
                    int startY = (offset & 0x7) + OverlayDefinition.placementY;
                    int startX = MovedStatics.placementX + (0x7 & offset >> 4);
                    int endX = startX + incomingPacketBuffer.getByte();
                    int endY = startY + incomingPacketBuffer.getByte();
                    int entityIndex = incomingPacketBuffer.getShortBE();
                    int graphicsId = incomingPacketBuffer.getUnsignedShortBE();
                    int startHeight = incomingPacketBuffer.getUnsignedByte() * 4;
                    int endHeight = 4 * incomingPacketBuffer.getUnsignedByte();
                    int delay = incomingPacketBuffer.getUnsignedShortBE();
                    int speed = incomingPacketBuffer.getUnsignedShortBE();
                    int startSlope = incomingPacketBuffer.getUnsignedByte();
                    int startDistance = incomingPacketBuffer.getUnsignedByte();
                    if (startX >= 0 && startY >= 0 && startX < 104 && startY < 104 && endX >= 0 && endY >= 0 && endX < 104 && endY < 104 && graphicsId != 65535) {
                        endX = 64 + 128 * endX;
                        startX = 64 + 128 * startX;
                        startY = startY * 128 + 64;
                        Projectile projectile = new Projectile(graphicsId, Player.worldLevel, startX, startY, Class37.getFloorDrawHeight(Player.worldLevel, startX, startY) + -startHeight, delay + MovedStatics.pulseCycle, speed + MovedStatics.pulseCycle, startSlope, startDistance, entityIndex, endHeight);
                        endY = 128 * endY + 64;
                        projectile.trackTarget(delay + MovedStatics.pulseCycle, 0, endY, -endHeight + Class37.getFloorDrawHeight(Player.worldLevel, endX, endY), endX);
                        Class43.projectileQueue.addLast(projectile);
                    }
                } else {
                    if (opcode == PacketType.ADD_GROUND_ITEM_EXCLUDE_SOME_PLAYER.getOpcode()) {
                        int amount = incomingPacketBuffer.getUnsignedShortLE();
                        int playerToExclude = incomingPacketBuffer.getUnsignedShortLE();
                        int itemId = incomingPacketBuffer.getUnsignedShortBE();
                        int positionInfo = incomingPacketBuffer.getUnsignedByte();
                        int x = ((0x71 & positionInfo) >> 4) + MovedStatics.placementX;
                        int y = (0x7 & positionInfo) + OverlayDefinition.placementY;
                        if (x >= 0 && y >= 0 && x < 104 && y < 104 && PlayerAppearance.anInt708 != playerToExclude) {
                            Item item = new Item();
                            item.itemId = itemId;
                            item.itemCount = amount;
                            if (Wall.groundItems[Player.worldLevel][x][y] == null)
                                Wall.groundItems[Player.worldLevel][x][y] = new LinkedList();
                            Wall.groundItems[Player.worldLevel][x][y].addLast(item);
                            FramemapDefinition.spawnGroundItem(y, x);
                        }
                    } else if (opcode == PacketType.ADD_GROUND_ITEM.getOpcode()) {
                        int itemId = incomingPacketBuffer.getUnsignedShortLE();
                        int amount = incomingPacketBuffer.getUnsignedShortBE();
                        int positionInfo = incomingPacketBuffer.getUnsignedByte();
                        int y = OverlayDefinition.placementY + (positionInfo & 0x7);
                        int x = MovedStatics.placementX + ((0x7a & positionInfo) >> 4);
                        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
                            Item item = new Item();
                            item.itemCount = amount;
                            item.itemId = itemId;
                            if (Wall.groundItems[Player.worldLevel][x][y] == null)
                                Wall.groundItems[Player.worldLevel][x][y] = new LinkedList();
                            Wall.groundItems[Player.worldLevel][x][y].addLast(item);
                            FramemapDefinition.spawnGroundItem(y, x);
                        }
                    }
                }
            }
        }
    }
}
