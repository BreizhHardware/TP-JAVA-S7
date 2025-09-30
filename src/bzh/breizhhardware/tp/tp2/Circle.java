package bzh.breizhhardware.tp.tp2;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(Point center, int radius) {
        this(center, radius, Color.BLACK, 1);
    }

    public Circle(Point center, int radius, Color color, int lineWidth) {
        super(center, lineWidth, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void print() {
        // Circle - center : ({x}, {y}), radius : {r}
        System.out.println("Circle - center : " + getCenter() + ", radius : " + radius);
    }

    @Override
    public void draw(Paint paint) {
        applyStyle(paint);
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
    public Rectangle getBoundingBox() {
        int x = center.getX() - radius;
        int y = center.getY() - radius;
        int size = 2 * radius;
        return new Rectangle(new Point(x, y), size, size);
    }
}
