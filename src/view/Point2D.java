package view;

/**
 * Created by Coen on 31-3-2017.
 */
public class Point2D {

    public static final Point2D ORIGIN = new Point2D(0, 0);

    private float x;
    private float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distance(Point2D p) {
        float dx = x - p.x;
        float dy = y - p.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

}
