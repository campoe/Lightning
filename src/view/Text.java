package view;

import java.awt.*;

/**
 * Created by Coen on 30-3-2017.
 */
public class Text {

    private Color color;
    private float x, y;
    private String text;

    public Text(String text, float x, float y, Color color) {
        this.text = text;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(color);
        g.drawString(text, (int) x, (int) y);
    }

    public String toString() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
