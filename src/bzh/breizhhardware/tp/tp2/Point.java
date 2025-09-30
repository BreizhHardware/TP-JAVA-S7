package bzh.breizhhardware.tp.tp2;

public class Point implements Moveable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Override the toString method to return the point coordinates in the format (x, y)
     *
     * @return the point coordinates as a string
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    /**
     * Move the point to the given coordinates
     *
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
}
