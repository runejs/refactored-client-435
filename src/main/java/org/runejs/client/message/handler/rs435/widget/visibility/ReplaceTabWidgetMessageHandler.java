package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.Game;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ReplaceTabWidgetInboundMessage;
import org.runejs.client.message.inbound.widget.visibility.ShowTabWidgetInboundMessage;

/**
 * Sets the widget to be displayed when a user opens a given tab.
 *
 * Note that this doesn't replace the entire tab area but rather it permanently sets
 * the contents of a given tab.
 *
 * If you want to overlay the tabarea with a widget, see {@link ShowTabWidgetInboundMessage}
 */
public class ReplaceTabWidgetMessageHandler implements MessageHandler<ReplaceTabWidgetInboundMessage> {
    @Override
    public void handle(ReplaceTabWidgetInboundMessage message) {
        int interfaceId = message.widgetId;
        int tabIndex = message.tabIndex;

        if(interfaceId != Game.tabWidgetIds[tabIndex]) {
            GameInterface.resetInterface(Game.tabWidgetIds[tabIndex]);
            Game.tabWidgetIds[tabIndex] = interfaceId;
        }
        GameInterface.drawTabIcons = true;
        GameInterface.redrawTabArea = true;
    }
}
