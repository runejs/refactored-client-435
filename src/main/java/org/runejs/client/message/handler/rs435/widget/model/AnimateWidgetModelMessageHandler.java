package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.AnimateWidgetModelInboundMessage;

public class AnimateWidgetModelMessageHandler implements MessageHandler<AnimateWidgetModelInboundMessage> {
    @Override
    public void handle(AnimateWidgetModelInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        int animationId = message.animationId;

        if(animationId != gameInterface.modelSeqId || animationId == -1) {
            gameInterface.remainingAnimationTime = 0;
            gameInterface.animationFrame = 0;
            gameInterface.modelSeqId = animationId;
        }
    }
}
