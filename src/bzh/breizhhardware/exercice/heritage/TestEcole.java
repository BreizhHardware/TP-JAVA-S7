package bzh.breizhhardware.exercice.heritage;

public class TestEcole {
    public static void main(String[] args) {
        // Création d'une liste d'étudiants et de professeurs
        Personne[] personnes = {
            new Etudiant("Steven"),
            new Etudiant("Candice"),
            new Etudiant("Félix"),
            new Professeur("Jean-Christophe MOREAU"),
            new Personne("Phillipe"),
            new Personne(),
        };
        // Parcours de la liste et appel de la méthode sePresenter pour chaque personne
        for (Personne p : personnes) {
            p.sePresenter();
        }
    }
}