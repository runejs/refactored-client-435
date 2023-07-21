package org.runejs.client.frame;

import org.runejs.client.MovedStatics;

/**
 * Renders the chat box.
 */
public class ChatBoxRenderer extends FramePieceRenderer {
    public ChatBoxRenderer() {
        super(
            new FramePieceAnchor(
                FramePieceAnchor.Anchor.BOTTOM | FramePieceAnchor.Anchor.LEFT,
                0,
                -22
            ),
            516,
            184
        );
    }

    public void render() {
        copyProducer(ChatBox.chatBoxImageProducer, 17, 16);
        copyProducer(MovedStatics.chatModes, 0, 112);
        copyProducerCutOff(MovedStatics.tabBottom, 496, 125, 20, MovedStatics.tabBottom.height, 0, 0);
        copyProducer(MovedStatics.chatboxRight, 0, 16);
        copyProducerCutOff(MovedStatics.chatboxTop, 0, 0, MovedStatics.chatboxTop.width - 37, MovedStatics.chatboxTop.height - 3, 0, 3);
        copyProducerCutOff(MovedStatics.tabPieceLowerRight, 496, 16, 20, MovedStatics.tabPieceLowerRight.height, 0, 0);
    }
}
