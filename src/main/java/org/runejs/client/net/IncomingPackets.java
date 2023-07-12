package org.runejs.client.net;

import org.runejs.client.*;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.net.codec.MessageDecoder;

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
                incomingPacketSize = Game.packetCodec.getPacketLength(opcode);
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
            MessageDecoder decoder = Game.packetCodec.getMessageDecoder(opcode);

            if (decoder != null) {
                // create a new packet buffer with the correct size, and read the data into it
                PacketBuffer packetBuffer = new PacketBuffer(incomingPacketSize);
                MovedStatics.gameServerSocket.readDataToBuffer(0, incomingPacketSize, packetBuffer.buffer);

                // decode the packet and handle it
                InboundMessage message = decoder.decode(packetBuffer);
                MessageHandler handler = Game.handlerRegistry.getMessageHandler(message.getClass());

                if (handler == null)
                    throw new RuntimeException("No handler for message: " + message.getClass().getName());

                handler.handle(message);

                opcode = -1;
                return true;
            }

            // if we get here, we have no decoder for this packet
            // and it is left to be handled by the old system

            MovedStatics.gameServerSocket.readDataToBuffer(0, incomingPacketSize, incomingPacketBuffer.buffer);

            if(opcode == 240) {
                ClientScriptRunner.parseClientScriptPacket(Game.signlink, incomingPacketBuffer);
                opcode = -1;
                return true;
            }
            if(opcode == 58) {
                int i_106_ = incomingPacketBuffer.getIntME2();
                MovedStatics.aSignlinkNode_394 = Game.signlink.createExceptionNode(i_106_); // TODO this just ends up throwing an exception? wot
                opcode = -1;
                return true;
            }
            MovedStatics.printException("T1 - " + opcode + "," + secondLastOpcode + "," + thirdLastOpcode + " - " + incomingPacketSize, null);
            Game.logout();
        } catch(java.io.IOException ioexception) {
            Class59.dropClient();
        } catch(Exception exception) {
            String string = "T2 - " + opcode + "," + secondLastOpcode + "," + thirdLastOpcode + " - " + incomingPacketSize + "," + (MovedStatics.baseX + Player.localPlayer.pathY[0]) + "," + (Player.localPlayer.pathX[0] + MovedStatics.baseY) + " - ";
            for(int i = 0; incomingPacketSize > i && i < 50; i++)
                string += incomingPacketBuffer.buffer[i] + ",";
            MovedStatics.printException(string, exception);
            Game.logout();
            exception.printStackTrace();
        }
        return true;

    }
}
