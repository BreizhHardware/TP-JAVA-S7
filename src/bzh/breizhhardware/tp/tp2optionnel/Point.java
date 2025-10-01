package bzh.breizhhardware.tp.tp2optionnel;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Set the location of the point
     *
     * @param x New x coordinate
     * @param y New y coordinate
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
