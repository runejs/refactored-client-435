package org.runejs.client.renderer;

import org.runejs.client.Game;

import java.awt.*;

import static org.runejs.client.MovedStatics.*;

public class SoftwareRenderer extends ScreenRenderer {
    private Font helveticaBold;
    private FontMetrics helveticaBoldMetrics;

    @Override
    public void drawLoadingText(int percent, Color color, String desc) {
        try {
            Graphics graphics = Game.gameCanvas.getGraphics();
            if (helveticaBold == null) {
                helveticaBold = new Font("Helvetica", Font.BOLD, 13);
                helveticaBoldMetrics = Game.gameCanvas.getFontMetrics(helveticaBold);
            }
            if (clearScreen) {
                clearScreen = false;
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, width, height);
            }
            if (color == null)
                color = new Color(140, 17, 17);
            try {
                if (loadingBoxImage == null)
                    loadingBoxImage = Game.gameCanvas.createImage(304, 34);
                Graphics loadingBoxGraphics = loadingBoxImage.getGraphics();
                loadingBoxGraphics.setColor(color);
                loadingBoxGraphics.drawRect(0, 0, 303, 33);
                loadingBoxGraphics.fillRect(2, 2, percent * 3, 30);
                loadingBoxGraphics.setColor(Color.black);
                loadingBoxGraphics.drawRect(1, 1, 301, 31);
                loadingBoxGraphics.fillRect(2 + 3 * percent, 2, 300 - 3 * percent, 30);
                loadingBoxGraphics.setFont(helveticaBold);
                loadingBoxGraphics.setColor(Color.white);
                loadingBoxGraphics.drawString(desc, (304 - (helveticaBoldMetrics.stringWidth(desc))) / 2, 22);
                graphics.drawImage(loadingBoxImage, width / 2 - 152, height / 2 - 18, null);
            } catch (Exception exception) {
                int centerWidth = width / 2 - 152;
                int centerHeight = height / 2 - 18;
                graphics.setColor(color);
                graphics.drawRect(centerWidth, centerHeight, 303, 33);
                graphics.fillRect(2 + centerWidth, centerHeight + 2, 3 * percent, 30);
                graphics.setColor(Color.black);
                graphics.drawRect(centerWidth + 1, 1 + centerHeight, 301, 31);
                graphics.fillRect(percent * 3 + 2 + centerWidth, 2 + centerHeight, 300 + -(3 * percent), 30);
                graphics.setFont(helveticaBold);
                graphics.setColor(Color.white);
                graphics.drawString(desc, (304 - (helveticaBoldMetrics.stringWidth(desc))) / 2 + centerWidth, 22 + centerHeight);
            }
        } catch (Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    @Override
    public void disposeLoadingText() {
        helveticaBoldMetrics = null;
        helveticaBold = null;
        loadingBoxImage = null;
    }
}
