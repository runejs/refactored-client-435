package org.runejs.whitelabel;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.runejs.client.Game;
import org.runejs.client.cache.media.ImageRGB;

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
            String classResource = Images.class.getResource("Images.class").toString();
            System.out.println(classResource);
            InputStream resource = Images.class.getClassLoader().getResourceAsStream("logo.png");
            System.out.println(resource);
            BufferedImage bufferedImage = ImageIO.read(resource);


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] data = baos.toByteArray();

            Images.logo = new ImageRGB(data, Game.gameCanvas);

            Images.setup = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

