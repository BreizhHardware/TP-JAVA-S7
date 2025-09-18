package bzh.breizhhardware.exercice.swing.calculatrice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EasyCalculatriceActionPerformed extends JFrame implements ActionListener{

    // Champ de saisie du texte
    private JTextField textField;
    // Label pour afficher le texte saisi
    private JLabel label;
    // Boutons
    private JButton btnCopier;
    private JButton btnEffacer;

    public EasyCalculatriceActionPerformed(){
        // Configuration de la fenêtre
        setTitle("Exercice copier/effacer");

        setLayout(new BorderLayout());

        // Création du champ de saisie en haut
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        // Création du panneau de boutons au centre
        JPanel panelBoutons = new JPanel();
        btnCopier = new JButton("Copier");
        btnEffacer = new JButton("Effacer");
        panelBoutons.add(btnCopier);
        panelBoutons.add(btnEffacer);
        add(panelBoutons, BorderLayout.CENTER);

        // Label en bas pour afficher le texte saisi
        label = new JLabel("Texte saisi : ");
        add(label, BorderLayout.SOUTH);

        // Ajout des écouteurs d'événements aux boutons
        btnCopier.addActionListener(this);
        btnEffacer.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String texte = "";
        // Vérification de la source de l'événement
        if(e.getSource() == btnCopier){
            texte = textField.getText();
            label.setText("Texte saisi : " + texte);
        }else if(e.getSource() == btnEffacer){
            textField.setText("");
            label.setText("Texte saisi : ");
        }
    }

    public static void main(String[] args) {
        new EasyCalculatriceActionPerformed();
    }
}