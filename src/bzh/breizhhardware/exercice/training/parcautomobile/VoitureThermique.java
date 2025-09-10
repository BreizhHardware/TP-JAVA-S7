package bzh.breizhhardware.exercice.training.parcautomobile;

public class VoitureThermique extends Vehicule implements Revisable, Locable {
    private String typeCarburant; // Essence ou Diesel
    private double reservoir; // Capacité du réservoir en litres

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public double getReservoir() {
        return reservoir;
    }

    public void setReservoir(double reservoir) {
        this.reservoir = reservoir;
    }

    public VoitureThermique(String marque, String modele, Integer annee, Double kilometrage, String typeCarburant, double reservoir) {
        super(marque, modele, annee, kilometrage);
        setTypeCarburant(typeCarburant);
        setReservoir(reservoir);
    }

    @Override
    public void afficherCaracteristiques() {
        System.out.println(" Caractéristiques de la voiture thermique :\n" +
                " Marque : " + getMarque() + "\n" +
                " Modèle : " + getModele() + "\n" +
                " Année : " + getAnnee() + "\n" +
                " Kilométrage : " + getKilometrage() + " km\n" +
                " Carburant : " + getTypeCarburant() + "\n" +
                " Réservoir : " + getReservoir() + " litres");
    }

    public void fairePlein(double litres) {
        if (litres <= 0) {
            System.out.println("La quantité de carburant doit être positive.");
            return;
        }
        double nouveauNiveau = getReservoir() + litres;
        setReservoir(nouveauNiveau);
        System.out.println("Plein effectué. Nouveau niveau de carburant : " + getReservoir() + " litres.");
    }

    @Override
    public void faireRevision() {
        System.out.println("Le véhicule thermique est en révision.");
    }

    @Override
    public void terminerRevision() {
        System.out.println("La révision du véhicule thermique est terminée.");
    }

    @Override
    public void louer() {
        System.out.println("La voiture thermique est louée.");
    }

    @Override
    public void retourner() {
        System.out.println("La voiture thermique est retournée.");
    }
}
