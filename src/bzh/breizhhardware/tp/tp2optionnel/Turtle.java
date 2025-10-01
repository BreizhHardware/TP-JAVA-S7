package bzh.breizhhardware.tp.tp2optionnel;

public class Turtle extends Paint {
    private boolean penDown;
    private Point position;
    private int heading;

    public Turtle() {
        super(800, 600);
        this.position = new Point(0, 0);
        this.penDown = true;
        this.heading = 0;
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
    public int getHeading() {
        return heading;
    }

    /**
     * Set the current heading in degrees
     *
     * @param heading the heading in degrees (0 is to the right, 90 is up)
     */
    public void setHeading(int heading) {
        this.heading = heading;
    }

    /**
     * Get the current position of the turtle
     *
     * @return the current position as a Point object
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Set the current position of the turtle
     *
     * @param position the new position as a Point object
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Move the turtle by a certain distance in the current heading direction
     *
     * @param distance the distance to move (positive for forward, negative for backward)
     */
    private void move(int distance) {
        double rad = Math.toRadians(heading);
        int newX = (int) Math.round(position.getX() + distance * Math.cos(rad));
        int newY = (int) Math.round(position.getY() + distance * Math.sin(rad));
        if (penDown) {
            drawLine(position.getX(), position.getY(), newX, newY);
        }
        position.setLocation(newX, newY);
    }

    /**
     * Move the turtle to an absolute position (x, y)
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void moveTo(int x, int y) {
        if (penDown) {
            drawLine(position.getX(), position.getY(), x, y);
        }
        position.setLocation(x, y);
    }

    /**
     * Turn the turtle to the right by a certain number of degrees
     *
     * @param degrees the number of degrees to turn right
     */
    public void right(int degrees) {
        heading = (heading - degrees) % 360;
        if (heading < 0) heading += 360;
    }

    /**
     * Turn the turtle to the left by a certain number of degrees
     *
     * @param degrees the number of degrees to turn left
     */
    public void left(int degrees) {
        heading = (heading + degrees) % 360;
    }

    /**
     * Move the turtle forward by a certain distance in the current heading direction
     *
     * @param distance the distance to move forward
     */
    public void forward(int distance) {
        move(distance);
    }

    /**
     * Move the turtle backward by a certain distance in the opposite of the current heading direction
     *
     * @param distance the distance to move backward
     */
    public void backward(int distance) {
        move(-distance);
    }
}
