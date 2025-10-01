package bzh.breizhhardware.tp.tp2optionnel;

public class Tree {
    /**
     * Draw a fractal tree using the turtle graphics system.
     *
     * @param turtle The turtle to use for drawing
     * @param length The length of the current branch
     * @param depth  The current depth of recursion
     * @param lratio The length ratio for each branch (default 2/3)
     * @param langle The angle for the left branch (default 15 degrees)
     * @param rangle The angle for the right branch (default 15 degrees)
     */
    public static void drawTree(Turtle turtle, int length, int depth, double lratio, double langle, double rangle) {
        if (depth == 0 || length < 1) return;

        turtle.forward(length);

        if (depth > 1) {
            // Right branch
            turtle.right(rangle);
            drawTree(turtle, (int) (length * lratio), depth - 1, lratio, langle, rangle);
            turtle.left(rangle);

            // Left branch
            turtle.left(langle);
            drawTree(turtle, (int) (length * lratio), depth - 1, lratio, langle, rangle);
            turtle.right(langle);
        }

        turtle.backward(length);
    }

    /**
     * Overloaded method to draw a fractal tree with default parameters.
     */
    public static void drawTree(Turtle turtle, int length, int depth) {
        drawTree(turtle, length, depth, 2.0 / 3.0, 15.0, 15.0);
    }
}
