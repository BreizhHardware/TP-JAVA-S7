// Classe principale pour tester la gestion de la bibliothèque
package bzh.breizhhardware.exercice.training.bibiliotheque;

public class Bibliothèque {
    // Méthode principale : point d'entrée du programme
    public static void main(String[] args) {
        // Création de deux livres avec des informations différentes
        Livre livre1 = new Livre("Le Petit Prince", 1943, true, "Antoine de Saint-Exupéry", 96);
        Livre livre2 = new Livre("1984", 1949, true, "George Orwell", 328);

        // Création de deux DVD avec des informations différentes
        DVD dvd1 = new DVD("Inception", 2010, true, "Christopher Nolan", 148);
        DVD dvd2 = new DVD("The Matrix", 1999, true, "The Wachowskis", 136);

        // Création d'un adhérent
        Adherent adherent = new Adherent("Jean Dupont", "A12345", new java.util.ArrayList<Ressource>());

        // L'adhérent emprunte un livre
        adherent.emprunter(livre1);
        // Affichage des ressources empruntées
        adherent.afficherRessourcesEmpruntees();

        // L'adhérent rend le livre
        adherent.rendre(livre1);
        // Affichage après restitution
        adherent.afficherRessourcesEmpruntees();

        // L'adhérent emprunte plusieurs ressources
        adherent.emprunter(livre2);
        adherent.emprunter(dvd1);
        adherent.emprunter(dvd2);
        // Affichage des ressources empruntées
        adherent.afficherRessourcesEmpruntees();

        // L'adhérent rend un livre
        adherent.rendre(livre2);
        // Affichage final
        adherent.afficherRessourcesEmpruntees();
    }
}
