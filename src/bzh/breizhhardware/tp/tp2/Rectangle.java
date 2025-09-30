package bzh.breizhhardware.tp.tp2;

import java.awt.*;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Point center, int width, int height) {
        this(center, width, height, Color.BLACK, 1);
    }

    public Rectangle(Point center, int width, int height, Color color, int lineWidth) {
        super(center, lineWidth, color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void print() {
        //Rectangle - center : ({x}, {y}), width : {r}, height : {h}
        System.out.println("Rectangle - center : " + getCenter() + ", width : " + width + ", height : " + height);
    }

    public void draw(Paint paint) {
        applyStyle(paint);
        // Draw top line
        paint.drawLine(
                getCenter().getX() - width / 2,
                getCenter().getY() - height / 2,
                getCenter().getX() + width / 2,
                getCenter().getY() - height / 2
        );
        // Draw right line
        paint.drawLine(
                getCenter().getX() + width / 2,
                getCenter().getY() - height / 2,
                getCenter().getX() + width / 2,
                getCenter().getY() + height / 2
        );
        // Draw bottom line
        paint.drawLine(
                getCenter().getX() + width / 2,
                getCenter().getY() + height / 2,
                getCenter().getX() - width / 2,
                getCenter().getY() + height / 2
        );
        // Draw left line
        paint.drawLine(
                getCenter().getX() - width / 2,
                getCenter().getY() + height / 2,
                getCenter().getX() - width / 2,
                getCenter().getY() - height / 2
        );
    }

    @Override
    public Rectangle getBoundingBox() {
        int x = center.getX();
        int y = center.getY();
        return new Rectangle(new Point(x, y), width, height);
    }

    public int getX() {
        return center.getX() - width / 2;
    }

    public int getY() {
        return center.getY() - height / 2;
    }
}
