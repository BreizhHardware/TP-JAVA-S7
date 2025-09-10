package breizhhardware.exercice.heritage;

public class Professeur extends Personne {
    public Professeur(String nom) {
        // Appel du constructeur de la classe parente Personne
        super(nom);
    }

    @Override
    public void sePresenter() {
        // Affiche je suis le professeur
        System.out.println("Je suis le professeur " + getNom());
    }
}
