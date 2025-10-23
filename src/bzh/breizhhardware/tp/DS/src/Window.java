import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private BibliotequeTableModel tableModel;
    private final JComboBox<String> choix;
    private final JButton refreshButton;

    /**
     * Crée une fenetre d'affichage pour la bibliotheque
     *
     * @param bibliotheque La bibliotheque a afficher
     */
    public Window(Bibliotheque bibliotheque) {
        // Définition des propriété initales
        setTitle("Bibliotheque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Création du bouton refresh
        refreshButton = new JButton("Actualiser");
        // Quand le bouton est cliqué je recharge le tableau
        refreshButton.addActionListener(e -> {
            tableModel.fireTableDataChanged();
        });

        // Création du dropdown de choix
        choix = new JComboBox<>();
        // Ajout des choix
        choix.addItem("Type");
        choix.addItem("ID");
        choix.addItem("Titre");
        choix.addItem("Annee");

        // En fonction du choix trie la bibliotheque
        choix.addActionListener(e -> {
            if (choix.getSelectedItem().toString().equals("Type")) {
                bibliotheque.trieBibliotheque("type");
                tableModel.setBibliotheque(bibliotheque);
            } else if (choix.getSelectedItem().toString().equals("ID")) {
                bibliotheque.trieBibliotheque("id");
                tableModel.setBibliotheque(bibliotheque);
            } else  if (choix.getSelectedItem().toString().equals("Titre")) {
                bibliotheque.trieBibliotheque("titre");
                tableModel.setBibliotheque(bibliotheque);
            } else if (choix.getSelectedItem().toString().equals("Annee")) {
                bibliotheque.trieBibliotheque("annee");
                tableModel.setBibliotheque(bibliotheque);
            }
        });

        // Affiche dans la JTable le contenu de la bibilotheque sous le format
        // Type, Id, Titre, Année, Spécifique
        String[] columnNames = {"Type", "ID", "Titre", "Année", "Spécifique"};
        tableModel = new BibliotequeTableModel(columnNames, bibliotheque);
        // Crée le tableau avec les données dedans
        JTable table = new JTable(tableModel);

        // Crée le panel du haut puis lui ajoute le dropdown de choix, le refresh button
        JPanel choicePanel = new JPanel();
        choicePanel.add(choix);
        choicePanel.add(refreshButton);

        // Crée le panel du haut lui ajoute le groupe dropdown et bouton ainsi que les header du tableau
        JPanel topPanel = new  JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(choicePanel);
        topPanel.add(table.getTableHeader());

        // Ajoute le tous a la fenetre
        this.add(topPanel, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);

        // Mets visible la fenetre
        this.pack();
        this.setVisible(true);
    }
}
