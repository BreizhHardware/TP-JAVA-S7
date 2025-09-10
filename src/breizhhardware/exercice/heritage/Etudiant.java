package breizhhardware.exercice.heritage;

public class Etudiant extends Personne {
    public Etudiant(String nom) {
        // Appel du constructeur de la classe parente Personne
        super(nom);
    }

    @Override
    public void sePresenter() {
        // Affiche je suis l'étudiant
        System.out.println("Je suis l'étudiant " + getNom());
    }
}
