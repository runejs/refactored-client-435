package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ReplaceTabWidgetInboundMessage;

/**
 * Sets the widget to be displayed when a user opens a given tab.
 *
 * Note that this doesn't replace the entire tab area but rather it permanently sets
 * the contents of a given tab.
 */
public class ReplaceTabWidgetMessageHandler implements MessageHandler<ReplaceTabWidgetInboundMessage> {
    @Override
    public void handle(ReplaceTabWidgetInboundMessage message) {
        int interfaceId = message.widgetId;
        int tabIndex = message.tabIndex;

        if(interfaceId != Player.tabWidgetIds[tabIndex]) {
            GameInterface.resetInterface(Player.tabWidgetIds[tabIndex]);
            Player.tabWidgetIds[tabIndex] = interfaceId;
        }
        GameInterface.drawTabIcons = true;
        GameInterface.redrawTabArea = true;
    }
}
