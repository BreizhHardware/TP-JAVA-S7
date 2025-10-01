package bzh.breizhhardware.tp.tp2optionnel;

public class Turtle extends Paint {
    private boolean penDown;
    private PointDouble position;
    private double heading;

    public Turtle() {
        super(800, 600);
        this.position = new PointDouble(0, 0);
        this.penDown = true;
        this.heading = 0.0;
    }

    /**
     * Check if the pen is down
     *
     * @return true if the pen is down, false otherwise
     */
    public boolean isDown() {
        return penDown;
    }

    /**
     * Put the pen down (drawing mode)
     */
    public void penDown() {
        this.penDown = true;
    }

    /**
     * Lift the pen up (moving mode)
     */
    public void penUp() {
        this.penDown = false;
    }

    /**
     * Get the current heading in degrees
     *
     * @return the heading in degrees (0 is to the right, 90 is up)
     */
    public double getHeading() {
        return heading;
    }

    /**
     * Set the current heading in degrees
     *
     * @param heading the heading in degrees (0 is to the right, 90 is up)
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    /**
     * Get the current position of the turtle
     *
     * @return the current position as a Point object
     */
    public PointDouble getPosition() {
        return position;
    }

    /**
     * Set the current position of the turtle
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setPosition(double x, double y) {
        this.position.setLocation(x, y);
    }

    /**
     * Move the turtle by a certain distance in the current heading direction
     *
     * @param distance the distance to move (positive for forward, negative for backward)
     */
    private void move(double distance) {
        double rad = Math.toRadians(heading);
        double newX = position.getX() + distance * Math.cos(rad);
        double newY = position.getY() - distance * Math.sin(rad);
        if (penDown) {
            drawLine((int) Math.round(position.getX()), (int) Math.round(position.getY()), (int) Math.round(newX), (int) Math.round(newY));
        }
        position.setLocation(newX, newY);
    }

    /**
     * Move the turtle to an absolute position (x, y)
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void moveTo(double x, double y) {
        if (penDown) {
            drawLine((int) Math.round(position.getX()), (int) Math.round(position.getY()), (int) Math.round(x), (int) Math.round(y));
        }
        position.setLocation(x, y);
    }

    /**
     * Turn the turtle to the right by a certain number of degrees
     *
     * @param degrees the number of degrees to turn right
     */
    public void right(double degrees) {
        heading = (heading - degrees) % 360.0;
        if (heading < 0) heading += 360.0;
    }

    /**
     * Turn the turtle to the left by a certain number of degrees
     *
     * @param degrees the number of degrees to turn left
     */
    public void left(double degrees) {
        heading = (heading + degrees) % 360.0;
    }

    /**
     * Move the turtle forward by a certain distance in the current heading direction
     *
     * @param distance the distance to move forward
     */
    public void forward(double distance) {
        move(distance);
    }

    /**
     * Move the turtle backward by a certain distance in the opposite of the current heading direction
     *
     * @param distance the distance to move backward
     */
    public void backward(double distance) {
        move(-distance);
    }
}
