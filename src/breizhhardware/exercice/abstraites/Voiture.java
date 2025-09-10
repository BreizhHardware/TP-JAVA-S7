package breizhhardware.exercice.abstraites;

public class Voiture extends Transport {
    public Voiture(double vitesseMoyenne) {
        // Appel au constructeur de la classe mère
        super(vitesseMoyenne);
    }

    @Override
    public double tempsTrajet(double distance) {
        // Calcul du temps de trajet en heures
        return distance / getVitesseMoyenne();
    }
}
