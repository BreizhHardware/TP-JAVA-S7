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

    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.print();
        }
    }

    public static void drawShapes(Shape[] shapes, Paint paint) {
        for (Shape shape : shapes) {
            shape.draw(paint);
        }
    }

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

    public Rectangle getBoundingBox() {
        // Ne fait rien, méthode à surcharger dans les classes filles
        return null;
    }

    @Override
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

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

    public void draw(Paint paint) {
        // Ne fait rien, méthode à surcharger dans les classes filles
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void print() {
        System.out.println("Shape - center : " + center);
    }
}
