package bzh.breizhhardware.exercice.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatrice extends JFrame {
    // Champ d'affichage pour les chiffres et le résultat
    private final JTextField champAffichage;
    // Opérateur sélectionné (+, -, x, /)
    private String operateur = "";
    // Premier nombre saisi
    private double premierNombre = 0;
    // Indique si on commence à saisir un nouveau nombre
    private boolean nouveauNombre = true;

    public Calculatrice() {
        setTitle("Calculatrice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // Création du champ d'affichage en haut
        champAffichage = new JTextField();
        champAffichage.setEditable(false);
        champAffichage.setFont(new Font("Arial", Font.BOLD, 24));
        add(champAffichage, BorderLayout.NORTH);

        // Création du panneau de boutons (chiffres et opérations)
        JPanel panelBoutons = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] boutons = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "x",
                "0", ".", "=", "/"
        };

        // Ajout des boutons au panneau
        for (String texte : boutons) {
            JButton bouton = new JButton(texte);
            bouton.setFont(new Font("Arial", Font.BOLD, 18));
            // Action lors du clic sur un bouton
            bouton.addActionListener(e -> boutonClique(texte));
            panelBoutons.add(bouton);
        }
        add(panelBoutons, BorderLayout.CENTER);

        // Panneau du bas pour les boutons "C" et "Exit"
        JPanel panelBas = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton boutonC = new JButton("C");
        boutonC.setFont(new Font("Arial", Font.BOLD, 18));
        // Action pour effacer tout
        boutonC.addActionListener(e -> {
            champAffichage.setText("");
            operateur = "";
            premierNombre = 0;
            nouveauNombre = true;
        });
        panelBas.add(boutonC);

        JButton boutonExit = new JButton("Exit");
        boutonExit.setFont(new Font("Arial", Font.BOLD, 18));
        // Action pour quitter l'application
        boutonExit.addActionListener(e -> System.exit(0));
        panelBas.add(boutonExit);

        add(panelBas, BorderLayout.SOUTH);
    }

    // Méthode appelée lors du clic sur un bouton
    private void boutonClique(String texte) {
        // Si c'est un chiffre ou un point
        if ("0123456789.".contains(texte)) {
            if (nouveauNombre) {
                champAffichage.setText(texte);
                nouveauNombre = false;
            } else {
                champAffichage.setText(champAffichage.getText() + texte);
            }
        }
        // Si c'est un opérateur
        else if ("+-x/".contains(texte)) {
            premierNombre = Double.parseDouble(champAffichage.getText());
            operateur = texte;
            nouveauNombre = true;
        }
        // Si c'est le bouton "="
        else if ("=".equals(texte)) {
            double deuxiemeNombre = Double.parseDouble(champAffichage.getText());
            double resultat = 0;
            switch (operateur) {
                case "+": resultat = premierNombre + deuxiemeNombre; break;
                case "-": resultat = premierNombre - deuxiemeNombre; break;
                case "x": resultat = premierNombre * deuxiemeNombre; break;
                case "/":
                    if (deuxiemeNombre != 0) resultat = premierNombre / deuxiemeNombre;
                    else {
                        champAffichage.setText("Erreur");
                        return;
                    }
            }
            champAffichage.setText(String.valueOf(resultat));
            nouveauNombre = true;
        }
    }

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculatrice().setVisible(true);
        });
    }
}
