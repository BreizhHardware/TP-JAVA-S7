package bzh.breizhhardware.tp.tp3;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    public JLabel okLabel;
    public JLabel cancelLabel;

    private JButton okButton;
    private JButton cancelButton;

    public Window() {
        super();
        this.setSize(300, 100);
        this.setTitle("My first JFrame");
        this.setLayout(new BorderLayout());

        // Add a label on the left side with two lines of text
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        okLabel = new JLabel("Click on OK");
        cancelLabel = new JLabel("Click on Cancel");
        labelPanel.add(okLabel);
        labelPanel.add(cancelLabel);
        this.add(labelPanel, BorderLayout.WEST);

        // Add two buttons ("OK" and "Cancel") centered at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked and update the corresponding label
        if (e.getSource() == okButton) {
            System.out.println("OK clicked !");
            okLabel.setText("OK clicked !");
        } else if (e.getSource() == cancelButton) {
            cancelLabel.setText("Cancel clicked !");
        }
    }
}
