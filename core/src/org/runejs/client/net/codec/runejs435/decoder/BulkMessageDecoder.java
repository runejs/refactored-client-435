package org.runejs.client.net.codec.runejs435.decoder;

import org.runejs.client.Game;
import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.inbound.BulkInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.PacketType;
import org.runejs.client.net.codec.MessageDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Decodes a bulk message.
 *
 * Some of this code is similar to the reading/decoding step in IncomingPackets. We could probably reuse some of it.
 */
public class BulkMessageDecoder implements MessageDecoder<BulkInboundMessage> {
    @Override
    public BulkInboundMessage decode(PacketBuffer buffer) {
        int x = buffer.getUnsignedByte();
        int y = buffer.getUnsignedByte();

        List<InboundMessage> messages = new ArrayList<>();

        while(buffer.currentPosition < buffer.getSize()) {
            int opcode = buffer.getUnsignedByte();

            if (!this.isBulkableOpcode(opcode)) {
                throw new RuntimeException("Attempted to bulk non-bulkable opcode: " + opcode);
            }

            int length = Game.packetCodec.getPacketLength(opcode);

            PacketBuffer childBuffer = new PacketBuffer(length);

            buffer.getBytes(length, 0, childBuffer.buffer);

            MessageDecoder decoder = Game.packetCodec.getMessageDecoder(opcode);

            if (decoder == null) {
                throw new RuntimeException("Could not find decoder for bulk opcode: " + opcode);
            }

            InboundMessage message = decoder.decode(childBuffer);

            messages.add(message);
        }
        
        return new BulkInboundMessage(x, y, messages.toArray(new InboundMessage[messages.size()]));
    }

    /**
     * Only some packets can be bulked. This method checks if the given opcode is bulkable.
     * @param opcode The opcode to check
     * @return True if the opcode is bulkable, false otherwise
     */
    private boolean isBulkableOpcode(int opcode) {
        return (
            opcode == PacketType.ROTATE_ANIMATE_OBJECT.getOpcode()
            || opcode == PacketType.SPAWN_OBJECT.getOpcode()
            || opcode == PacketType.PLAY_SOUND_AT_POSITION.getOpcode()
            || opcode == PacketType.CREATE_STATIONARY_GFX.getOpcode()
            || opcode == PacketType.UPDATE_GROUND_ITEM_AMOUNT.getOpcode()
            || opcode == PacketType.REMOVE_OBJECT.getOpcode()
            || opcode == PacketType.TRANSFORM_PLAYER_TO_OBJECT.getOpcode()
            || opcode == PacketType.REMOVE_GROUND_ITEM.getOpcode()
            || opcode == PacketType.CREATE_PROJECTILE.getOpcode()
            || opcode == PacketType.ADD_GROUND_ITEM_EXCLUDE_SOME_PLAYER.getOpcode()
            || opcode == PacketType.ADD_GROUND_ITEM.getOpcode()
        );
    }
}
