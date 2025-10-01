package bzh.breizhhardware.tp.tp2optionnel;

public class Tree {
    public static void drawTree(Turtle turtle, int length, int depth) {
        if (depth == 0 || length < 1) return;

        turtle.forward(length);

        if (depth > 1) {
            // Right branch
            turtle.right(15);
            drawTree(turtle, (int) (length * 2.0 / 3.0), depth - 1);
            turtle.left(15);

            // Left branch
            turtle.left(15);
            drawTree(turtle, (int) (length * 2.0 / 3.0), depth - 1);
            turtle.right(15);
        }

        turtle.backward(length);
    }
}
