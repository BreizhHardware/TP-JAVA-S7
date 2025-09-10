package breizhhardware.exercice.heritage;

public class Personne {
    private String nom;

    public Personne(String nom) {
        // Initialisation du nom de la personne si non null
        setNom(nom);
    }

    public Personne() {
        // Si null initialise avec le nom Anonyme
        setNom("Anonyme");
    }

    public void setNom(String nom) {
        // Setter pour le nom
        this.nom = nom;
    }

    public String getNom() {
        // Getter pour le nom
        return nom;
    }

    public void sePresenter() {
        // Affiche je m'appelle
        System.out.println("Je m'appelle " + getNom());
    }
}
