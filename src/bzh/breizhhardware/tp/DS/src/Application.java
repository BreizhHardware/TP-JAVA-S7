import java.util.Scanner;

public class Application {
    /**
     * Affiche un message demandant a l'utilisateur la manière dont il veut trier la bibliotheque
     *
     * @param bibliotheque La bibliotheque a trier
     */
    public Application(Bibliotheque bibliotheque) {
        // Affichage du message initial
        System.out.println("Pour avoir la bibliotheque trié par id tapez 1, par type tapez 2");

        // Démarrage du scanner d'entrée utilisateur
        Scanner s = new Scanner(System.in);

        // Récupération du choix de l'utilisateur
        String choix = s.nextLine();

        if (choix.equals("1")) {
            // Si l'utilisateur a choisi 1 on trie par id
            System.out.println("Bibliotheque trié par id: ");
            bibliotheque.afficherBibliotheque("id");
        } else if (choix.equals("2")) {
            // Si l'utilisateur a choisi 2 on trie par type
            System.out.println("Bibliotheque trié par type: ");
            bibliotheque.afficherBibliotheque("type");
        } else {
            // Si l'utilisateur a choisi autre chose on lui affiche un message d'erreur
            System.out.println("Erreur: choix invalide veuillez recommencer");
        }

        // Fermeture du scanner
        s.close();
    }
}
