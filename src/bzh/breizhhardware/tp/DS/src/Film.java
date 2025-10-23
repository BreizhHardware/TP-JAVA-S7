import java.util.Objects;

public class Film extends Oeuvre {
    private String realisateur;

    /**
     * Création d'un film (une oeuvre avec un realisateur en plus)
     *
     * @param id id du film
     * @param titre titre du film
     * @param annee annee du film
     * @param realisateur realisateur du film
     */
    public Film(String id, String titre, int annee, String realisateur) {
        // Si le realisateur est vide ou null alors on ne crée rien
        if (realisateur == null || realisateur.isEmpty()) {
            throw new IllegalArgumentException("realisateur null");
        }
        // Appel du constructeur de Oeuvre
        super(id, titre, annee);

        this.realisateur = realisateur;
    }

    /**
     * Renvoie le réalisateur du film
     *
     * @return réalisateur du film
     */
    public String getRealisateur() {
        return realisateur;
    }

    /**
     * Modifie le réalisateur du film
     *
     * @param realisateur nouveau réalisateur
     */
    public void setRealisateur(String realisateur) {
        // Si le realisateur n'est pas vide ou pas null alors il est valide
        if (realisateur != null && !realisateur.isEmpty()) {
            this.realisateur = realisateur;
        } else {
            System.err.println("Erreur: realisateur est null");
            throw new IllegalArgumentException("realisateur null");
        }
    }

    /**
     * Renvoie du film sous la forme id titre annee realisateur
     *
     * @return film sous la forme id titre annee realisateur
     */
    @Override
    public String toString() {
        return getId() + " " + getTitre() + " " + getAnnee() + " " + getRealisateur();
    }

    /**
     * Vérification de l'égalité entre 2 films
     *
     * @param obj   the reference object with which to compare.
     * @return si le film est égale a l'autre
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
     * @return Film
     */
    public String getType() {
        return "Film";
    }
}
