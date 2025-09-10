package bzh.breizhhardware.exercice.training.parcautomobile;

import java.util.ArrayList;

public class ParcAutomobile {
    public ArrayList<Vehicule> listeVehicules;

    public ArrayList<Vehicule> getListeVehicules() {
        return listeVehicules;
    }

    public void setListeVehicules(ArrayList<Vehicule> listeVehicules) {
        this.listeVehicules = listeVehicules;
    }

    public ParcAutomobile(ArrayList<Vehicule> listeVehicules) {
        setListeVehicules(listeVehicules);
    }

    public void ajouterVehicule(Vehicule v) {
        listeVehicules.add(v);
    }

    public void afficherParc() {
        for (Vehicule v : listeVehicules) {
            v.afficherCaracteristiques();
            System.out.println("---------------");
        }
    }

    public void faireReviserTout() {
        for (Vehicule v : listeVehicules) {
            if (v instanceof Revisable) {
                ((Revisable) v).faireRevision();
            }
        }
    }
}
