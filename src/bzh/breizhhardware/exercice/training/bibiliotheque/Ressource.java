package bzh.breizhhardware.exercice.training.bibiliotheque;

public class Ressource {
    protected String titre;
    protected Integer anneePublication;
    protected Boolean disponible;

    public String getTitre() {
        return titre;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public Integer getAnneePublication() {
        return anneePublication;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Ressource(String titre, Integer anneePublication, Boolean disponible) {
        setTitre(titre);
        setAnneePublication(anneePublication);
        setDisponible(disponible);
    }

    public void afficherDetails() {
        System.out.println("Titre : " + getTitre());
        System.out.println("Annee Publication : " + getAnneePublication());
        System.out.println("Disponible : " + getDisponible());
    }
}
