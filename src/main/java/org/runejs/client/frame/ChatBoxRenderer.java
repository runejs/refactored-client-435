package org.runejs.client.frame;

import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer;
import org.runejs.client.media.RasterizerInstanced;

/**
 * Renders the chat box.
 */
public class ChatBoxRenderer extends FramePieceRenderer {
    private final ProducingGraphicsBuffer graphics;

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

        graphics = MovedStatics.createGraphicsBuffer(this.width, this.height, Game.gameCanvas);
        rasterizerInstanced = new RasterizerInstanced(graphics);
    }

    public ProducingGraphicsBuffer getDrawable() {
        return graphics;
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
