// Classe représentant un adhérent de la bibliothèque
package bzh.breizhhardware.exercice.training.bibiliotheque;

import java.util.ArrayList;

public class Adherent {
    // Nom de l'adhérent
    private String nom;
    // Numéro d'adhérent
    private String numeroAdherent;
    // Liste des ressources empruntées
    private ArrayList<Ressource> ressources;

    // Accesseurs et mutateurs
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

    // Constructeur
    public Adherent(String nom, String numeroAdherent, ArrayList<Ressource> ressources) {
        setNom(nom);
        setNumeroAdherent(numeroAdherent);
        setRessources(ressources);
    }

    // Méthode pour emprunter une ressource
    public void emprunter(Ressource r) {
        this.ressources.add(r);
        r.setDisponible(false);
    }

    // Méthode pour rendre une ressource
    public void rendre(Ressource r) {
        this.ressources.remove(r);
        r.setDisponible(true);
    }

    // Affiche les ressources empruntées par l'adhérent
    public void afficherRessourcesEmpruntees() {
        System.out.println("Détails de l'adhérent " + getNom() + " (N°" + getNumeroAdherent() + ") :");
        System.out.println("Ressources empruntées :");
        for (Ressource r : ressources) {
            System.out.println(" " + r.getTitre() + " (" + r.getClass().getSimpleName() + ")");
        }
    }
}
