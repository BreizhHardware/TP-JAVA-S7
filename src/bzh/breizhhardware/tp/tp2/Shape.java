package bzh.breizhhardware.tp.tp2;

import java.awt.*;

public class Shape implements Moveable {
    protected Point center;
    protected int lineWidth;
    protected Color color;

    public Shape(Point center) {
        this(center, 1, Color.BLACK);
    }

    public Shape(Point center, int lineWidth, Color color) {
        this.center = center;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    /**
     * Print information of all shapes in the array
     *
     * @param shapes array of shapes to print
     */
    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.print();
        }
    }

    /**
     * Draw all shapes in the array using the given Paint object
     *
     * @param shapes array of shapes to draw
     * @param paint  Paint object to use for drawing
     */
    public static void drawShapes(Shape[] shapes, Paint paint) {
        for (Shape shape : shapes) {
            shape.draw(paint);
        }
    }

    /**
     * Calculate the bounding box that contains all shapes in the array
     * The bounding box is represented as a Rectangle object that encloses all shapes
     *
     * @param shapes array of shapes to calculate the bounding box for
     * @return Rectangle representing the bounding box, or null if the array is empty
     */
    public static Rectangle getBoundingBox(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) return null;

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        // Trouver les coordonnées minimales et maximales
        for (Shape shape : shapes) {
            // Utiliser la méthode getBoundingBox() de chaque forme
            Rectangle box = shape.getBoundingBox();
            // Si le X ou Y est plus petit ou plus grand, mettre à jour les valeurs min et max
            if (box.getX() < minX) minX = box.getX();
            if (box.getY() < minY) minY = box.getY();
            if (box.getX() + box.getWidth() > maxX) maxX = box.getX() + box.getWidth();
            if (box.getY() + box.getHeight() > maxY) maxY = box.getY() + box.getHeight();
        }
        // Calculer le centre, la largeur et la hauteur du rectangle englobant
        int width = maxX - minX;
        int height = maxY - minY;
        int centerX = minX + width / 2;
        int centerY = minY + height / 2;
        return new Rectangle(new Point(centerX, centerY), width, height);

    }

    /**
     * Get the bounding box of the shape
     * This method should be overridden in derived classes
     *
     * @return Rectangle representing the bounding box, or null if not implemented
     */
    public Rectangle getBoundingBox() {
        return null;
    }

    @Override
    /**
     * Move the shape center to the specified coordinates
     *
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    /**
     * Apply the style (color and line width) to the given Paint object
     *
     * @param paint the Paint object to apply the style to
     */
    protected void applyStyle(Paint paint) {
        paint.setColor(color);
        paint.setLineWidth(lineWidth);
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Draw the shape on the given Paint object
     * This method should be overridden in derived classes
     *
     * @param paint the Paint object to draw on
     */
    public void draw(Paint paint) {
    }

    /**
     * Print the shape information to the console
     * This method should be overridden in derived classes
     */
    public void print() {
        System.out.println("Shape - center : " + center);
    }
}
