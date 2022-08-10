package main.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    
    public BufferedImage getImage(String type) {

        try {

            BufferedImage image = ImageIO.read(getClass().getResource("../../res/tile" + type + ".png"));
            
            return image;

        } catch (IOException e) {
            
            e.printStackTrace();

        }

        return null;

    }

}
