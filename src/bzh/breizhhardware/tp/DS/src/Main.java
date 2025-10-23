void main() {
    // Initalise le jeu de donnée
    Oeuvre[] jeuxDeDonnees = DonneesObjet.jeuxDeDonnees();

    // Crée une bibliotheque a partir du jeux de donnée
    Bibliotheque bibliotheque = new Bibliotheque(jeuxDeDonnees);
    bibliotheque.afficherBibliotheque();
    Film testFilm = new Film("F006", "Star Wars", 1989, "George Lucas");
    bibliotheque.insertOeuvre(testFilm);

    // Lance l'application pour choisir le type de trie
    Application application = new Application(bibliotheque);

    // Lance l'application graphique d'affichage de la bibliotheque
    Window window = new Window(bibliotheque);
}
