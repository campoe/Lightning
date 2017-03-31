package view;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Coen on 30-3-2017.
 */
public class Image implements Renderable {

    private int width, height;
    private BufferedImage image;

    public Image(String path) {
        image = ImageLoader.load(path);
        assert image != null;
        width = image.getWidth();
        height = image.getHeight();
        image.flush();
    }

    public void scale(float factor) {
        width *= factor;
        height *= factor;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(image, 0, 0, width, height, null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
