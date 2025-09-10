package bzh.breizhhardware.exercice.training.bibiliotheque;

public class Livre extends Ressource {
    private String auteur;
    private Integer nombrePages;

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(Integer nombrePages) {
        this.nombrePages = nombrePages;
    }

    public Livre(String titre, Integer anneePublication, Boolean disponible, String auteur, Integer nombrePages) {
        super(titre, anneePublication, disponible);
        setAuteur(auteur);
        setNombrePages(nombrePages);
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Nombre Pages: " + getNombrePages());
    }
}
