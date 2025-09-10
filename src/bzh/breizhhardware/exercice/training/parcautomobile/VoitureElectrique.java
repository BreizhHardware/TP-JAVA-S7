package bzh.breizhhardware.exercice.training.parcautomobile;

public class VoitureElectrique extends Vehicule implements Revisable, Locable {
    private double autonomie; // Autonomie en km
    private int niveauBatterie; // Niveau de batterie en pourcentage (0-100)

    public double getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(double autonomie) {
        this.autonomie = autonomie;
    }

    public int getNiveauBatterie() {
        return niveauBatterie;
    }

    public void setNiveauBatterie(int niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    public VoitureElectrique(String marque, String modele, Integer annee, Double kilometrage, double autonomie, int niveauBatterie) {
        super(marque, modele, annee, kilometrage);
        setAutonomie(autonomie);
        setNiveauBatterie(niveauBatterie);
    }

    @Override
    public void afficherCaracteristiques() {
        System.out.println(" Caractéristiques de la voiture électrique :\n" +
                " Marque : " + getMarque() + "\n" +
                " Modèle : " + getModele() + "\n" +
                " Année : " + getAnnee() + "\n" +
                " Kilométrage : " + getKilometrage() + " km\n" +
                " Autonomie : " + getAutonomie() + " km\n" +
                " Niveau Batterie : " + getNiveauBatterie() + " %");
    }

    public void recharger(int pourcentage) {
        if (pourcentage <= 0) {
            System.out.println("Le pourcentage de recharge doit être positif.");
            return;
        }
        int nouveauNiveau = getNiveauBatterie() + pourcentage;
        if (nouveauNiveau > 100) {
            nouveauNiveau = 100;
        }
        setNiveauBatterie(nouveauNiveau);
        System.out.println("Recharge effectuée. Nouveau niveau de batterie : " + getNiveauBatterie() + " %.");
    }

    @Override
    public void faireRevision() {
        System.out.println("Le véhicule électrique est en révision.");
    }

    @Override
    public void terminerRevision() {
        System.out.println("La révision du véhicule électrique est terminée.");
    }

    @Override
    public void louer() {
        System.out.println("La voiture électrique est louée.");
    }

    @Override
    public void retourner() {
        System.out.println("La voiture électrique est retournée.");
    }
}
