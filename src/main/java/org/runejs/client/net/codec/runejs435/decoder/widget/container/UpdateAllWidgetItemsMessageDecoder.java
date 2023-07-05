package org.runejs.client.net.codec.runejs435.decoder.widget.container;

import org.runejs.client.message.inbound.widget.container.UpdateAllWidgetItemsInboundMessage;
import org.runejs.client.message.inbound.widget.container.WidgetItem;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

import java.util.ArrayList;
import java.util.List;

public class UpdateAllWidgetItemsMessageDecoder implements MessageDecoder<UpdateAllWidgetItemsInboundMessage> {
    @Override
    public UpdateAllWidgetItemsInboundMessage decode(PacketBuffer buffer) {
        final int interfaceData = buffer.getIntBE();
        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        final int size = buffer.getUnsignedShortBE();

        List<WidgetItem> items = new ArrayList<>();

        for (int index = 0; index < size; index += 8) {
            final int bitset = buffer.getByte();

            for (int offset = 0; offset < 8; offset++) {
                final boolean empty = (bitset & 1 << offset) == 0;
                final int id, amount;

                if (empty) {
                    id = amount = 0;
                } else {
                    final int peek = buffer.getUnsignedByte();
                    amount = peek == 255 ? buffer.getIntBE() : peek;
                    id = buffer.getUnsignedShortBE();
                }

                final int idx = index + offset;

                items.add(new WidgetItem(idx, id, amount));
            }
        }

        return new UpdateAllWidgetItemsInboundMessage(
            widgetId,
            childId,
            items.toArray(new WidgetItem[items.size()])
        );
    }
}
