package bzh.breizhhardware.tp.tp3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoundingBallsWindow extends JFrame implements ActionListener {

    private BouncingBallPanel ballPanel1, ballPanel2;

    public BoundingBallsWindow() {
        super();
        this.setSize(800, 500);
        this.setTitle("Bouncing balls");

        GridLayout mainLayout = new GridLayout(1, 3);


        JButton startButton = new JButton("Start");
        this.ballPanel1 = new BouncingBallPanel();
        this.ballPanel2 = new BouncingBallPanel();

        this.setLayout(mainLayout);

        this.add(startButton);
        this.add(this.ballPanel1);
        this.add(this.ballPanel2);

        startButton.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) {

        BoundingBallsWindow mainWindow = new BoundingBallsWindow();

    }

    public void actionPerformed(ActionEvent e) {

        this.ballPanel1.animate();
        this.ballPanel2.animate();

    }


}

