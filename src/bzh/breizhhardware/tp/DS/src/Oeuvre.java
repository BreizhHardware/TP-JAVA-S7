import java.util.Objects;

public abstract class Oeuvre {
    protected String id;
    protected String titre;
    protected int annee;

    /**
     * Création d'une oeuvre
     *
     * @param id identifiant de l'oeuvre
     * @param titre titre de l'oeuvre
     * @param annee année de l'oeuvre
     */
    public Oeuvre(String id, String titre, int annee) {
        // Si id ou titre son null ou que annee est négative on ne crée rien
        if (id  == null || titre == null || annee < 0) {
            System.err.println("Erreur: ID or titre est null");
            throw new IllegalArgumentException();
        }
        // Si l'année est superieur a 2025 alors on ne crée rien
        if (annee > 2025) {
            System.err.println("Erreur: annee plus que 2025");
            throw new IllegalArgumentException("annee more than 2025");
        }
        // Si l'année est négative alors on ne crée rien
        if (annee < 0) {
            System.err.println("Erreur: annee est negative");
            throw new IllegalArgumentException("annee negative");
        }
        this.id = id;
        this.titre = titre;
        this.annee = annee;
    }

    /**
     * Récupération de l'id de l'oeuvre
     *
     * @return id de l'oeuvre
     */
    public String getId() {
        return id;
    }

    /**
     * Modification de l'id d'une oeuvre
     *
     * @param id nouvel identifiant de l'oeuvre
     */
    public void setId(String id) {
        // Si l'id n'est pas nul et pas vide alors il est valide
        if  (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            // Sinon envoie une erreur
            System.err.println("Erreur: ID est null");
            throw new IllegalArgumentException("ID null");
        }
    }

    /**
     * Récupération du titre de l'oeuvre
     *
     * @return titre de l'oeuvre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Modification du titre de l'oeuvre
     *
     * @param titre nouveau titre de l'oeuvre
     */
    public void setTitre(String titre) {
        // Si le titre n'est pas nul et pas vide alors il est valide
        if (titre != null && !titre.isEmpty()) {
            this.titre = titre;
        } else  {
            // Sinon envoie une erreur
            System.err.println("Erreur: titre est null");
            throw new IllegalArgumentException("titre null");
        }
    }

    /**
     * Récupération de l'année de l'oeuvre
     *
     * @return année de l'oeuvre
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Modification de l'année de l'oeuvre
     *
     * @param annee nouvelle année de l'oeuvre
     */
    public void setAnnee(int annee) {
        // Si l'année est positive alors elle est valide
        if (annee < 0) {
            this.annee = annee;
        }  else {
            System.err.println("Erreur: annee est negative");
            throw new IllegalArgumentException("annee negative");
        }
    }

    /**
     * Renvoie de l'oeuvre sous la forme id titre annee
     *
     * @return l'oeuvre sous la forme id titre annee
     */
    @Override
    public String toString() {
        return getId() + " " + getTitre() + " " + getAnnee();
    }

    /**
     * Vérification de l'égalité entre 2 oeuvres
     *
     * @param obj   the reference object with which to compare.
     * @return si l'oeuvre est égale a l'autre
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
     * Renvoie du type de l'oeuvre
     * @return oeuvre
     */
    public String getType() {
        return "Oeuvre";
    }
}
