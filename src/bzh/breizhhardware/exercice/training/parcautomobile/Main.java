package bzh.breizhhardware.exercice.training.parcautomobile;

public class Main {
    public static void main(String[] args) {
        // Création des véhicules
        VoitureThermique vt = new VoitureThermique("Renault", "Mégane", 2019, 85000.0, "Essence", 47.0);
        VoitureElectrique ve = new VoitureElectrique("Audi", "Q6 e-tron", 2022, 12000.0, 400.0, 80);
        Camion camion = new Camion("Renault", "T520", 2018, 80000.0, 18.0);

        // Création du parc automobile et ajout des véhicules
        ParcAutomobile parc = new ParcAutomobile(new java.util.ArrayList<>());
        parc.ajouterVehicule(vt);
        parc.ajouterVehicule(ve);
        parc.ajouterVehicule(camion);

        // Faire rouler chaque véhicule
        vt.rouler(150.0);
        ve.rouler(200.0);
        camion.rouler(300.0);

        // Faire le plein, recharger, charger le camion
        vt.fairePlein(30.0); // Ajoute 30 litres
        ve.recharger(15);    // Ajoute 15% de batterie
        camion.charger(10.0); // Ajoute 10 tonnes

        // Louer les voitures (si elles sont Locable)
        if (vt instanceof Locable) {
            ((Locable) vt).louer();
        }
        if (ve instanceof Locable) {
            ((Locable) ve).louer();
        }

        // Afficher les caractéristiques de tous les véhicules
        parc.afficherParc();

        // Lancer la révision pour tous les véhicules
        parc.faireReviserTout();

        // Surcharger le camion pour tester la gestion d'erreur
        camion.charger(10.0); // Tente d'ajouter 10 tonnes de plus

        // Surcharger la voiture electrique pour tester la gestion d'erreur
        ve.recharger(30); // Tente d'ajouter 30% de batterie de plus
    }
}
