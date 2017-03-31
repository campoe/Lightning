package view;

import java.awt.*;

/**
 * Created by Coen on 30-3-2017.
 */
public class SolidTile extends AbstractGameObject {

    private Color color;

    public SolidTile(float x, float y, int width, int height, Color color) {
        super(x, y, width, height, ObjectType.Tile);
        this.color = color;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, width, height);
    }

}
