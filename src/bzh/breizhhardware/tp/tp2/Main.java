package bzh.breizhhardware.tp.tp2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 3 - Concept de point
        /*
        Point p = new Point(100, 200);
        System.out.println(p.getX());
        p.setX(300);
        System.out.println(p.getX());
        System.out.println(p.getY());
        p.setY(400);
        System.out.println(p.getY());
        System.out.println(p);
         */
        // 4 - Surcharge de la méthode toString()
        /*
        Point p = new Point(100, 200);
        String s = "Point coordinates : " + p;
        System.out.println(s);
         */
        // 5 - Concept de forme
        /*
        Shape s = new Shape(new Point(100, 200));
        s.print();
         */
        // 6 - Concept de cercle
        /*
        Circle c = new Circle(new Point(100, 200), 50);
        c.print();
        c.setRadius(500);
        c.print();
         */
        // 7 - Concept de rectangle
        /*
        Rectangle r = new Rectangle(new Point(100, 200), 50, 100);
        r.print();
        r.setWidth(500);
        r.setHeight(1000);
        r.print();
         */
        // 8 - Affichage d'un ensemble de formes
        /*
        Circle c = new Circle(new Point(100, 200), 50);
        Rectangle r = new Rectangle(new Point(300, 400), 50, 100);
        Shape[] shapes = {c, r};
        Shape.printShapes(shapes);
         */
        // 9 – Récupération et test de la classe Paint
        /*
        Paint p = new Paint(500, 300);
        p.drawLine(100, 200, 200, 100);
        p.drawArc(300, 200, 200, 200, 0, 90);
         */
        // 10 - Méthode de dessin
        /*
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point(100, 100), 100);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100);
        Shape[] shapes = new Shape[2];
        shapes[0] = c;
        shapes[1] = r;
        Shape.drawShapes(shapes, p);
         */
        // 11 – Un peu de style
        /*
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point(100, 100), 100, Color.RED, 5);
        c.draw(p);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100, Color.BLUE, 2);
        r.draw(p);
        Circle c2 = new Circle(new Point(100, 100), 50);
        c2.draw(p);
         */
        // 12 - Déplacement d'un objet
        /*
        Paint p = new Paint(400, 400);
        Circle c = new Circle(new Point(100, 100), 100, Color.RED, 5);
        c.draw(p);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100, Color.BLUE, 2);
        r.draw(p);
        c.moveTo(300, 300);
        c.draw(p);
        r.moveTo(200, 200);
        r.draw(p);
         */
        // 13 - [Facultatif] Boîte englobante
        Paint p = new Paint(400, 400);
        Circle c = new Circle(new Point(100, 100), 100, Color.RED, 5);
        c.draw(p);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100, Color.BLUE, 2);
        r.draw(p);
        Circle c2 = new Circle(new Point(200, 200), 50);
        c2.draw(p);
        Rectangle r2 = new Rectangle(new Point(250, 250), 50, 50);
        r2.draw(p);
        Shape[] shapes = {c, r, c2, r2};
        Rectangle box = Shape.getBoundingBox(shapes);
        box.setColor(Color.MAGENTA);
        box.setLineWidth(3);
        box.print();
        box.draw(p);
    }
}
