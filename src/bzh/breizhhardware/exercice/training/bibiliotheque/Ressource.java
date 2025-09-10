// Classe représentant une ressource générique de la bibliothèque
package bzh.breizhhardware.exercice.training.bibiliotheque;

public class Ressource {
    // Titre de la ressource
    protected String titre;
    // Année de publication de la ressource
    protected Integer anneePublication;
    // Indique si la ressource est disponible ou non
    protected Boolean disponible;

    // Accesseur pour le titre
    public String getTitre() {
        return titre;
    }

    // Accesseur pour la disponibilité
    public Boolean getDisponible() {
        return disponible;
    }

    // Accesseur pour l'année de publication
    public Integer getAnneePublication() {
        return anneePublication;
    }

    // Mutateur pour le titre
    public void setTitre(String titre) {
        this.titre = titre;
    }

    // Mutateur pour l'année de publication
    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }

    // Mutateur pour la disponibilité
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    // Constructeur
    public Ressource(String titre, Integer anneePublication, Boolean disponible) {
        setTitre(titre);
        setAnneePublication(anneePublication);
        setDisponible(disponible);
    }

    // Affiche les détails de la ressource
    public void afficherDetails() {
        System.out.println("Détails de la ressource de type " + this.getClass().getSimpleName() + " :");
        System.out.println("Titre : " + getTitre());
        System.out.println("Annee Publication : " + getAnneePublication());
        System.out.println("Disponible : " + getDisponible());
    }
}
