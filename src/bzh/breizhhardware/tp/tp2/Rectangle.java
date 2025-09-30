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

    @Override
    /**
     * Print the rectangle information to the console
     *
     * Format: Rectangle - center : ({x}, {y}), width : {r}, height : {h}
     */
    public void print() {
        System.out.println("Rectangle - center : " + getCenter() + ", width : " + width + ", height : " + height);
    }

    /**
     * Draw the rectangle on the given Paint object
     * The rectangle is drawn using 4 lines
     *
     * @param paint the Paint object to draw on
     */
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
    /**
     * Get the bounding box of the rectangle
     * A bounding box is a rectangle that contains the rectangle
     * The top-left corner of the bounding box is at (center.x - width/2, center.y - height/2)
     * The size of the bounding box is (width, height)
     */
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
