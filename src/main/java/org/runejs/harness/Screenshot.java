package org.runejs.harness;

import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.Minimap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Composes the fixed-mode frame from the client's off-screen buffers, exactly where the window would blit them.
 * Evidence for a human, never the oracle.
 */
public final class Screenshot {
    private static final int WIDTH = 765;
    private static final int HEIGHT = 503;

    private Screenshot() {
    }

    public static void write(File target) throws IOException {
        BufferedImage frame = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        if (MovedStatics.aProducingGraphicsBuffer_2213 != null) {
            blit(frame, MovedStatics.aProducingGraphicsBuffer_2213, 0, 0);
        }
        blit(frame, MovedStatics.gameScreenImageProducer, 4, 4);
        blit(frame, ChatBox.chatBoxImageProducer, 17, 357);
        blit(frame, MovedStatics.tabImageProducer, 553, 205);
        blit(frame, Minimap.mapbackProducingGraphicsBuffer, 550, 4);
        ImageIO.write(frame, "png", target);
    }

    private static void blit(BufferedImage frame, ProducingGraphicsBuffer buffer, int atX, int atY) {
        if (buffer == null || buffer.pixels == null) {
            return;
        }
        int width = Math.min(buffer.width, WIDTH - atX);
        int height = Math.min(buffer.height, HEIGHT - atY);
        for (int y = 0; y < height; y++) {
            frame.setRGB(atX, atY + y, width, 1, buffer.pixels, y * buffer.width, buffer.width);
        }
    }
}
