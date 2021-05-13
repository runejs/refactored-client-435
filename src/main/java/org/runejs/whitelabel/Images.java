package org.runejs.whitelabel;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.input.MouseHandler;

import javax.imageio.ImageIO;

public class Images {
    private static ImageRGB logo;

    private static boolean setup = false;

    public static ImageRGB GetPart(String part) {
        if (!Images.setup) {
            Images.CreateParts();
        }
        switch (part) {
            case "logo":
                return logo;

        }
        return logo;
    }

    private static void CreateParts() {
        try {
            File imgPath = new File("./data/logo.png");
            BufferedImage bufferedImage = ImageIO.read(imgPath);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] data = baos.toByteArray();

            Images.logo = new ImageRGB(data, MouseHandler.gameCanvas);

            Images.setup = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

