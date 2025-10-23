import java.util.Objects;

public class Jeu extends Oeuvre{
    private String editeur;

    /**
     * Création d'un jeu (une oeuvre avec un editeur en plus)
     *
     * @param id id du jeu
     * @param titre titre du jeu
     * @param annee annee du jeu
     * @param editeur editeur du jeu
     */
    public Jeu(String id, String titre, int annee, String editeur) {
        // Si l'editeur est null ou vide alors on ne crée rien
        if (editeur == null || editeur.isEmpty()) {
            throw new IllegalArgumentException("editeur null");
        }
        // Appel du constructeur de Oeuvre
        super(id, titre, annee);

        this.editeur = editeur;
    }

    /**
     * Renvoie l'éditeur du jeu
     * @return éditeur du jeu
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * Modification de l'éditeur du jeu
     *
     * @param editeur nouvel éditeur
     */
    public void setEditeur(String editeur) {
        // Si l'editeur n'est pas null ou vide alors il est valide
        if (editeur != null && !editeur.isEmpty()) {
            this.editeur = editeur;
        } else {
            System.err.println("Erreur: editeur est null");
            throw new IllegalArgumentException("editeur null");
        }
    }

    /**
     * Renvoie du jeu sous la forme id titre annee editeur
     *
     * @return film sous la forme id titre annee editeur
     */
    @Override
    public String toString() {
        return getId() + " " + getTitre() + " " + getAnnee() + " " + getEditeur();
    }

    /**
     * Vérification de l'égalité entre 2 jeux
     *
     * @param obj   the reference object with which to compare.
     * @return si le jeu est égale a l'autre
     */
    @Override
    public boolean equals(Object obj) {
        // Si l'adresse memoire de obj est la même que celle de this alors ils sont identique
        if  (this == obj) {
            return true;
        }
        // Si obj est null alors ils ne peuvent pas être identique
        if (obj == null) {
            return false;
        }
        // Si les ID sont identique alors ils sont identiques
        if (Objects.equals(this.id, ((Oeuvre) obj).id)) {
            return true;
        }
        return false;
    }

    /**
     * Renvoie le type d'oeuvre
     *
     * @return Jeu
     */
    public String getType() {
        return "Jeu";
    }
}
