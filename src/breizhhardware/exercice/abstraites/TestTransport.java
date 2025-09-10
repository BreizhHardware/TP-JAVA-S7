package breizhhardware.exercice.abstraites;

public class TestTransport {
    public static void main(String[] args) {
        // Création d'une liste de Transport
        Transport[] transports = {
                new Velo(20),
                new Voiture(100),
        };
        // Parcours de la liste et calcule du temps de trajet
        for (Transport t : transports) {
            double tpsTrajet = t.tempsTrajet(50);
            System.out.println(tpsTrajet + " heures");
        }
    }
}
