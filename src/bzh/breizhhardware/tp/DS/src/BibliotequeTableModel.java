import javax.swing.table.AbstractTableModel;

public class BibliotequeTableModel extends AbstractTableModel {
    private final String[] columnNames;
    private Bibliotheque oeuvres;

    /**
     * Crée un modèle de tableau pour l'affichage de la biblotheque dans un tableau swing
     *
     * @param columnNames Le nom des colonnes
     * @param bibliotheque La bibliotheque a afficher dans le tableau
     */
    public BibliotequeTableModel(String[] columnNames, Bibliotheque  bibliotheque) {
        this.columnNames = columnNames;
        this.oeuvres = bibliotheque;
    }

    /**
     * Renvoie le nombre de ligne du lableau
     *
     * @return nombre de ligne du tableau
     */
    @Override
    public int getRowCount() {
        return oeuvres.size();
    }

    /**
     * Renvoie le nombre de colonne du tableau
     *
     * @return nombre de colonne du tableau
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Récupère le nom de la colonne col
     *
     * @param col  the column being queried
     * @return nom de la colonne col
     */
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * Récupère la valeur en position row, column
     *
     * @param row        the row whose value is to be queried
     * @param col     the column whose value is to be queried
     * @return valeur en position row, column
     */
    @Override
    public Object getValueAt(int row, int col) {
        //
        Oeuvre oeuvre = oeuvres.get(row);
        switch (col) {
            case 0: return oeuvre.getType();
            case 1: return oeuvre.getId();
            case 2: return oeuvre.getTitre();
            case 3: return oeuvre.getAnnee();
            case 4:
                // En fonction de la classe fait appele a la fonction spécifique
                if (oeuvre.getClass() == Livre.class) {
                    return ((Livre) oeuvre).getAuteur();
                } else if (oeuvre.getClass() == Film.class) {
                    return ((Film) oeuvre).getRealisateur();
                } else  if (oeuvre.getClass() ==Jeu.class) {
                    return ((Jeu) oeuvre).getEditeur();
                } else {
                    return null;
                }
            default: return null;
        }
    }

    /**
     * Récupère l'oeuvre de la ligne row
     *
     * @param row la ligne a récupérer
     * @return l'oeuvre de la ligne row
     */
    public Oeuvre getOeuvreAt(int row) {
        return oeuvres.get(row);
    }

    /**
     * Modifie la biblotheque (utile une fois qu'elle est retrié)
     *
     * @param bibliotheque la bibiliotheque a redéfinir
     */
    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.oeuvres = bibliotheque;
    }
}
