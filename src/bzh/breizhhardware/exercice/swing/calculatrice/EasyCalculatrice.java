package bzh.breizhhardware.exercice.swing.calculatrice;

import javax.swing.*;
import java.awt.*;

public class EasyCalculatrice extends JFrame {
    // Champ de saisie du texte
    private final JTextField champ;
    // Label pour afficher le texte saisi
    private final JLabel label;

    public EasyCalculatrice() {
        setTitle("Mini Calculatrice");
        setSize(250, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du champ de saisie en haut
        champ = new JTextField();
        add(champ, BorderLayout.NORTH);

        // Création du panneau de boutons au centre
        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new FlowLayout());

        // Bouton pour copier le texte
        JButton copier = new JButton("Copier");
        // Bouton pour effacer le texte
        JButton effacer = new JButton("Effacer");

        // Ajout des boutons au panneau
        panelBoutons.add(copier);
        panelBoutons.add(effacer);
        add(panelBoutons, BorderLayout.CENTER);

        // Label en bas pour afficher le texte saisi
        label = new JLabel("Texte saisi :");
        add(label, BorderLayout.SOUTH);

        // Action lors du clic sur "Copier"
        copier.addActionListener(e -> {
            label.setText("Texte saisi : " + champ.getText());
        });

        // Action lors du clic sur "Effacer"
        effacer.addActionListener(e -> {
            champ.setText("");
            label.setText("Texte saisi :");
        });
    }

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EasyCalculatrice().setVisible(true);
        });
    }
}
