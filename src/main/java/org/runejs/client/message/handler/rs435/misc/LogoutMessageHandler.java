package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.LogoutMessage;

/**
 * A {@link MessageHandler} that handles {@link LogoutMessage}s.
 */
public class LogoutMessageHandler implements MessageHandler<LogoutMessage> {
    @Override
    public void handle(LogoutMessage message) {
        MovedStatics.logout();
    }
}
