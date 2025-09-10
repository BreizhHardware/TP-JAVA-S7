package bzh.breizhhardware.exercice.training.parcautomobile;

public class Camion extends Vehicule implements Revisable {
    private double chargeMax; // Charge maximale en tonnes
    private double chargeActuelle; // Charge actuelle en tonnes

    public double getChargeMax() {
        return chargeMax;
    }

    public void setChargeMax(double chargeMax) {
        this.chargeMax = chargeMax;
    }

    public double getChargeActuelle() {
        return chargeActuelle;
    }

    public void setChargeActuelle(double chargeActuelle) {
        this.chargeActuelle = chargeActuelle;
    }

    public Camion(String marque, String modele, Integer annee, Double kilometrage, double chargeMax) {
        super(marque, modele, annee, kilometrage);
        setChargeMax(chargeMax);
        setChargeActuelle(0);
    }

    @Override
    public void afficherCaracteristiques() {
        System.out.println(" Caractéristiques du camion :\n" +
                " Marque : " + getMarque() + "\n" +
                " Modèle : " + getModele() + "\n" +
                " Année : " + getAnnee() + "\n" +
                " Kilométrage : " + getKilometrage() + " km\n" +
                " Charge Max : " + getChargeMax() + " tonnes\n" +
                " Charge Actuelle : " + getChargeActuelle() + " tonnes");
    }

    public void charger(double tonnes) {
        if (tonnes <= 0) {
            System.out.println("La quantité à charger doit être positive.");
            return;
        }
        double nouvelleCharge = getChargeActuelle() + tonnes;
        if (nouvelleCharge > getChargeMax()) {
            System.out.println("Erreur : Charge maximale dépassée !");
        } else {
            setChargeActuelle(nouvelleCharge);
            System.out.println("Chargement effectué. Charge actuelle : " + getChargeActuelle() + " tonnes.");
        }
    }

    @Override
    public void faireRevision() {
        System.out.println("Le camion est en révision.");
    }

    @Override
    public void terminerRevision() {
        System.out.println("La révision du camion est terminée.");
    }
}
