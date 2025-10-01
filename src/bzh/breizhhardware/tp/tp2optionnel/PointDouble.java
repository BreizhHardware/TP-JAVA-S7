package bzh.breizhhardware.tp.tp2optionnel;

public class PointDouble {
    private double x;
    private double y;

    public PointDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Set the location of the point
     *
     * @param x New x coordinate
     * @param y New y coordinate
     */
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
