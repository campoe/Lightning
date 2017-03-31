package view;

import java.awt.*;

/**
 * Created by Coen on 30-3-2017.
 */
public class ImageTile extends AbstractGameObject {

    private Image image;

    public ImageTile(float x, float y, int width, int height, Image image) {
        super(x, y, width, height, ObjectType.Tile);
        this.image = image;
    }

    public ImageTile(float x, float y, int width, int height, String path) {
        super(x, y, width, height, ObjectType.Tile);
        image = new Image(path);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image.getImage(), (int) x, (int) y, width, height, null);
    }

}
