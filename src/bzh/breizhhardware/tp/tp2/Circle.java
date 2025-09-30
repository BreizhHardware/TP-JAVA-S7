package bzh.breizhhardware.tp.tp2;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(Point center, int radius) {
        // Call the main constructor with default color and line width
        this(center, radius, Color.BLACK, 1);
    }

    public Circle(Point center, int radius, Color color, int lineWidth) {
        // Call the parent constructor
        super(center, lineWidth, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    /**
     * Print the circle information to the console
     *
     * Format: Circle - center : ({x}, {y}), radius : {r}
     */
    public void print() {
        System.out.println("Circle - center : " + getCenter() + ", radius : " + radius);
    }

    @Override
    /**
     * Draw the circle on the given Paint object
     * The circle is drawn as an arc of 360 degrees
     *
     * @param paint the Paint object to draw on
     */
    public void draw(Paint paint) {
        // Apply style
        applyStyle(paint);
        // Draw the circle as an arc of 360 degrees
        paint.drawArc(
                getCenter().getX(),
                getCenter().getY(),
                radius * 2,
                radius * 2,
                0,
                360
        );
    }

    @Override
    /**
     * Get the bounding box of the circle
     * A bounding box is a square that contains the circle
     * The top-left corner of the bounding box is at (center.x - radius, center.y - radius)
     * The size of the bounding box is (2 * radius, 2 * radius)
     */
    public Rectangle getBoundingBox() {
        int x = center.getX() - radius;
        int y = center.getY() - radius;
        int size = 2 * radius;
        return new Rectangle(new Point(x, y), size, size);
    }
}
