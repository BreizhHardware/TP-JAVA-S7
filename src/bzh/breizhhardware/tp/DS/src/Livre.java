import java.util.Objects;

public class Livre extends Oeuvre {
    private String auteur;

    /**
     * Création d'un livre (une oeuvre avec un auteur en plus)
     *
     * @param id id du livre
     * @param titre titre du livre
     * @param annee annee du livre
     * @param auteur auteur du livre
     */
    public Livre(String id, String titre, int annee, String auteur) {
        // Si l'auteur est null ou vide crée une erreur
        if (auteur == null || auteur.isEmpty()) {
            throw new IllegalArgumentException("auteur null");
        }
        // Appel du constructeur de Oeuvre
        super(id, titre, annee);

        this.auteur = auteur;
    }

    /**
     * Récupération de l'auteur
     *
     * @return l'auteur du livre
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Modification de l'auteur du livre
     *
     * @param auteur nouvel auteur
     */
    public void setAuteur(String auteur) {
        // Si l'auteur n'est pas vide ou null alors il est valide
        if (auteur != null && !auteur.isEmpty()) {
            this.auteur = auteur;
        } else {
            System.err.println("Erreur: auteur est null");
            throw new IllegalArgumentException("auteur null");
        }
    }

    /**
     * Renvoie du livre sous la forme id titre annee auteur
     *
     * @return livre sous la forme id titre annee auteur
     */
    @Override
    public String toString() {
        return getId() + " " + getTitre() + " " + getAnnee() + " " + getAuteur();
    }

    /**
     * Vérification de l'égalité entre 2 livres
     *
     * @param obj   the reference object with which to compare.
     * @return si le livre est égale a l'autre
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
        if (Objects.equals(this.id, ((Oeuvre) obj).getId())) {
            return true;
        }
        return false;
    }

    /**
     * Renvoie le type d'oeuvre
     *
     * @return Livre
     */
    public String getType() {
        return "Livre";
    }
}
