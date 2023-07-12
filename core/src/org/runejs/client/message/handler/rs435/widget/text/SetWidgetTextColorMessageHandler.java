package org.runejs.client.message.handler.rs435.widget.text;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.text.SetWidgetTextColorInboundMessage;

public class SetWidgetTextColorMessageHandler implements MessageHandler<SetWidgetTextColorInboundMessage> {
    @Override
    public void handle(SetWidgetTextColorInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        int i_115_ = message.color >> 10 & 0x1f;
        int i_116_ = 0x1f & message.color >> 5;
        int i_117_ = message.color & 0x1f;
        gameInterface.textColor = (i_116_ << 11) + (i_115_ << 19) + (i_117_ << 3);
    }
}
