package bzh.breizhhardware.tp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionPanel extends JPanel {
    private JTextField urlField, userField;
    private JPasswordField passwordField;
    private JButton connectButton;
    private ConnectionListener listener;

    public ConnectionPanel() {
        // Create the flow layout
        setLayout(new FlowLayout(FlowLayout.LEFT));
        // Init components with default values
        add(new JLabel("URL:"));
        urlField = new JTextField("jdbc:mysql://10.30.40.173:3306/inventaire4", 25);
        add(urlField);

        add(new JLabel("Utilisateur:"));
        userField = new JTextField("guest", 10);
        add(userField);

        add(new JLabel("Mot de passe:"));
        passwordField = new JPasswordField("%Guest2025", 10);
        add(passwordField);

        connectButton = new JButton("Connexion");
        add(connectButton);

        // Add action listener to the button
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.onConnect(
                            urlField.getText(),
                            userField.getText(),
                            new String(passwordField.getPassword())
                    );
                }
            }
        });
    }

    /*
        * Setter for the connection listener
        * @param listener the listener to set
     */
    public void setConnectionListener(ConnectionListener listener) {
        this.listener = listener;
    }

    /*
        * Interface for the connection listener
     */
    public interface ConnectionListener {
        void onConnect(String url, String user, String password);
    }
}
