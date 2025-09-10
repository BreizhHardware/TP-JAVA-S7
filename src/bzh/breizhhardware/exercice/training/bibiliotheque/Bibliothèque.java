package bzh.breizhhardware.exercice.training.bibiliotheque;

public class Bibliothèque {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Le Petit Prince", 1943, true, "Antoine de Saint-Exupéry", 96);
        Livre livre2 = new Livre("1984", 1949, true, "George Orwell", 328);

        DVD dvd1 = new DVD("Inception", 2010, true, "Christopher Nolan", 148);
        DVD dvd2 = new DVD("The Matrix", 1999, true, "The Wachowskis", 136);

        Adherent adherent = new Adherent("Jean Dupont", "A12345", new java.util.ArrayList<Ressource>());

        adherent.emprunter(livre1);
        adherent.afficherRessourcesEmpruntees();

        adherent.rendre(livre1);

        adherent.afficherRessourcesEmpruntees();

        adherent.emprunter(livre2);
        adherent.emprunter(dvd1);
        adherent.emprunter(dvd2);
        adherent.afficherRessourcesEmpruntees();

        adherent.rendre(livre2);
        adherent.afficherRessourcesEmpruntees();
    }
}
