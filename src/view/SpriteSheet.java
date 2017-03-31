package view;

import java.awt.image.BufferedImage;

/**
 * Created by Coen on 30-3-2017.
 */
public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(String path) {
        image = ImageLoader.load(path);
    }

    public BufferedImage getSubImage(int row, int col, int width, int height) {
        return image.getSubimage((col * width) - width, (row * height) - height, width, height);
    }

}
