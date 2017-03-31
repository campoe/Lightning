package view;

import java.awt.*;

/**
 * Created by Coen on 30-3-2017.
 */
public abstract class AbstractGameObject implements Renderable {

    protected float x, y;
    protected int width, height;
    protected ObjectType type;

    public AbstractGameObject(float x, float y, int width, int height, ObjectType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }

}
