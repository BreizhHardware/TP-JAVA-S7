package bzh.breizhhardware.exercice.training.bibiliotheque;

public class DVD extends Ressource {
    private String realisateur;
    private Integer duree;

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public DVD(String titre, Integer anneePublication, Boolean disponible, String realisateur, Integer duree) {
        super(titre, anneePublication, disponible);
        setRealisateur(realisateur);
        setDuree(duree);
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Réalisateur: " + getRealisateur());
        System.out.println("Durée: " + getDuree());
    }
}
