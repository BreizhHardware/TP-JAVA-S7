package bzh.breizhhardware.tp.tp3;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingBallPanel extends JPanel implements Runnable, ChangeListener {

    // ball state
    private static final Color BALL_COLOR = Color.BLUE;
    private static final int BALL_SIZE = 80;     // ball diameter, in px
    // animation thread
    private static final int ANIMATION_STEP = 40;   // delay between 2 animation steps, in ms
    // ball speed
    private static final int MAX_SPEED = 100;
    private static final int INITIAL_SPEED = 10;
    private int x, y;                             // ball coordinates, in px
    private boolean down;                        // true if the balls moves down
    private Thread animationThread;
    private JSlider speedSlider;                 // JSlider used to change the ball speed
    private int speed;                           // ball speed, in px / step

    public BouncingBallPanel() {

        // initial ball state
        this.x = 100;
        this.y = BALL_SIZE;
        this.down = true;

        // animation thread (not started)
        this.animationThread = null;

        // ball speed
        this.speed = INITIAL_SPEED;
        this.speedSlider = new JSlider(JSlider.HORIZONTAL, 0, MAX_SPEED, this.speed);
        this.speedSlider.addChangeListener(this);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel sliderLabel = new JLabel("Ball speed", JLabel.CENTER);
        this.add(sliderLabel);
        this.add(this.speedSlider);

    }

    public void moveBall() {

        int orientation = this.down ? 1 : -1;
        this.y += orientation * this.speed;

        // bounce
        if (this.y + BALL_SIZE > this.getHeight()) {
            this.down = false;
        } else if (this.y < BALL_SIZE / 2) {
            this.down = true;
        }

        this.repaint();

    }

    public void animate() {
        if (this.animationThread == null || !this.animationThread.isAlive()) {
            this.animationThread = new Thread(this);
            this.animationThread.start();
        }
    }

    // méthode de dessin appelée par repaint()
    // dessine la balle
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(BALL_COLOR);
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
    }


    // boucle d'animation
    public void run() {
        while (true) {
            try {
                Thread.sleep(ANIMATION_STEP);
            } catch (InterruptedException exception) {

            }

            this.moveBall();
        }
    }

    @Override
    public void stateChanged(javax.swing.event.ChangeEvent e) {
        this.speed = this.speedSlider.getValue();
    }

}