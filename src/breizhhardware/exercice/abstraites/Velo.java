package breizhhardware.exercice.abstraites;

public class Velo extends Transport {
    public Velo(double vitesseMoyenne) {
        // Appel au constructeur de la classe mère
        super(vitesseMoyenne);
    }

    @Override
    public double tempsTrajet(double distance) {
        // Calcul du temps de trajet en heures
        return distance / getVitesseMoyenne();
    }
}
