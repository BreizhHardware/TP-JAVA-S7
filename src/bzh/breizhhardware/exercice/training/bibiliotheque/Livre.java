// Classe représentant un livre dans la bibliothèque
package bzh.breizhhardware.exercice.training.bibiliotheque;

public class Livre extends Ressource {
    // Nom de l'auteur du livre
    private String auteur;
    // Nombre de pages du livre
    private Integer nombrePages;

    // Accesseur pour l'auteur
    public String getAuteur() {
        return auteur;
    }

    // Mutateur pour l'auteur
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    // Accesseur pour le nombre de pages
    public Integer getNombrePages() {
        return nombrePages;
    }

    // Mutateur pour le nombre de pages
    public void setNombrePages(Integer nombrePages) {
        this.nombrePages = nombrePages;
    }

    // Constructeur
    public Livre(String titre, Integer anneePublication, Boolean disponible, String auteur, Integer nombrePages) {
        super(titre, anneePublication, disponible);
        setAuteur(auteur);
        setNombrePages(nombrePages);
    }

    // Affiche les détails du livre
    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Nombre Pages: " + getNombrePages());
    }
}
