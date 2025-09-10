package bzh.breizhhardware.exercice.training.bibiliotheque;

import java.util.ArrayList;

public class Adherent {
    private String nom;
    private String numeroAdherent;
    private ArrayList<Ressource> ressources;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroAdherent() {
        return numeroAdherent;
    }

    public void setNumeroAdherent(String numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }

    public ArrayList<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(ArrayList<Ressource> ressources) {
        this.ressources = ressources;
    }

    public Adherent(String nom, String numeroAdherent, ArrayList<Ressource> ressources) {
        setNom(nom);
        setNumeroAdherent(numeroAdherent);
        setRessources(ressources);
    }

    public void emprunter(Ressource r) {
        this.ressources.add(r);
        r.setDisponible(false);
    }

    public void rendre(Ressource r) {
        this.ressources.remove(r);
        r.setDisponible(true);
    }

    public void afficherRessourcesEmpruntees() {
        System.out.println("Ressources empruntées par " + getNom() + " :");
        for (Ressource r : ressources) {
            r.afficherDetails();
            System.out.println("-----");
        }
    }
}
