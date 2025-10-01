package bzh.breizhhardware.tp.tp2optionnel;

public class Main {
    public static void main(String[] args) {
        Turtle turtle = new Turtle();
        turtle.penUp();
        turtle.moveTo(200, 200);
        turtle.penDown();
        turtle.setColor(java.awt.Color.BLUE);
        turtle.setLineWidth(2);
        // Draw a square
        for (int i = 0; i < 4; i++) {
            turtle.forward(100);
            turtle.right(90);
        }
        turtle.penUp();
        turtle.moveTo(400, 400);
        turtle.penDown();
        turtle.setColor(java.awt.Color.RED);
        turtle.setLineWidth(3);
        // Draw a triangle
        for (int i = 0; i < 3; i++) {
            turtle.forward(100);
            turtle.right(120);
        }

        turtle.penUp();
        turtle.moveTo(300, 300);
        turtle.penDown();
        turtle.setColor(java.awt.Color.GREEN);
        turtle.setLineWidth(1);
        // Draw a tree
        Tree.drawTree(turtle, 100, 5);

        turtle.penUp();
        turtle.moveTo(300, 200);
        turtle.penDown();
        turtle.setColor(java.awt.Color.MAGENTA);
        turtle.setLineWidth(1);
        Tree.drawTree(turtle, 100, 5, 4.0 / 5.0, 15, 15);

        turtle.penUp();
        turtle.moveTo(300, 400);
        turtle.penDown();
        turtle.setColor(java.awt.Color.ORANGE);
        turtle.setLineWidth(1);
        Tree.drawTree(turtle, 100, 5, 2.0 / 3.0, 30, 30);

        turtle.penUp();
        turtle.moveTo(0, 300);
        turtle.penDown();
        turtle.setColor(java.awt.Color.CYAN);
        turtle.setLineWidth(1);
        Tree.drawTree(turtle, 100, 5, 2.0 / 3.0, -5, 30);
    }
}
