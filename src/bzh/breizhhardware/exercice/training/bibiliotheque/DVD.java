// Classe représentant un DVD dans la bibliothèque
package bzh.breizhhardware.exercice.training.bibiliotheque;

public class DVD extends Ressource {
    // Nom du réalisateur du DVD
    private String realisateur;
    // Durée du DVD en minutes
    private Integer duree;

    // Accesseur pour le réalisateur
    public String getRealisateur() {
        return realisateur;
    }

    // Mutateur pour le réalisateur
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    // Accesseur pour la durée
    public Integer getDuree() {
        return duree;
    }

    // Mutateur pour la durée
    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    // Constructeur
    public DVD(String titre, Integer anneePublication, Boolean disponible, String realisateur, Integer duree) {
        super(titre, anneePublication, disponible);
        setRealisateur(realisateur);
        setDuree(duree);
    }

    // Affiche les détails du DVD
    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Réalisateur: " + getRealisateur());
        System.out.println("Durée: " + getDuree());
    }
}
