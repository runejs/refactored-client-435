package org.runejs.client.net.codec.runejs435.decoder.widget.container;

import org.runejs.client.message.inbound.widget.container.UpdateSpecificWidgetItemsInboundMessage;
import org.runejs.client.message.inbound.widget.container.WidgetItem;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

import java.util.ArrayList;
import java.util.List;

public class UpdateSpecificWidgetItemsMessageDecoder implements MessageDecoder<UpdateSpecificWidgetItemsInboundMessage> {
    @Override
    public UpdateSpecificWidgetItemsInboundMessage decode(PacketBuffer buffer) {
        final int interfaceData = buffer.getIntBE();
        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        List<WidgetItem> items = new ArrayList<>();

        while(buffer.getSize() > buffer.currentPosition) {
            int itemSlot = buffer.getSmart();
            int itemId = buffer.getUnsignedShortBE();
            int amount = 0;
            if(itemId != 0) {
                amount = buffer.getUnsignedByte();
                if(amount == 255)
                    amount = buffer.getIntBE();
            }

            items.add(new WidgetItem(itemSlot, itemId, amount));
        }

        return new UpdateSpecificWidgetItemsInboundMessage(
            widgetId,
            childId,
            items.toArray(new WidgetItem[items.size()])
        );
    }
}
