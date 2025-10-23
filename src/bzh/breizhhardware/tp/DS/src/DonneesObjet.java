/**
 *
 * Cette classe fournit un jeu d'œuvres (livres, films, jeux) destiné à tester :
 * - le chargement d'une liste d'objets,
 * - les tris (par identifiant, par type puis titre),
 * - la gestion d'un doublon d'identifiant à ignorer proprement (avec message).
 *
 * Vous devez fournir ces classes et constructeurs :
 *   - abstract class Oeuvre { ... }
 *   - class Livre extends Oeuvre {
 *       public Livre(String id, String titre, int annee, String auteur)
 *     }
 *   - class Film extends Oeuvre {
 *       public Film(String id, String titre, int annee, String realisateur)
 *     }
 *   - class Jeu extends Oeuvre {
 *       public Jeu(String id, String titre, int annee, String studio)
 *     }
 *
 */
public final class DonneesObjet {

    private DonneesObjet() {
        // empêche l'instanciation
    }

    /**
     * Renvoie un tableau d'œuvres contenant des Livres, Films et Jeux.
     * Contient volontairement un DOUBLON d'identifiant (L003) pour les tests.
     */
    public static Oeuvre[] jeuxDeDonnees() {
        return new Oeuvre[] {
            new Livre("L001", "Le Seigneur des Anneaux", 1954, "J. R. R. Tolkien"),
            new Livre("L005", "La Horde du Contrevent", 2004, "Alain Damasio"),
            new Film("F001", "Inception", 2010, "Christopher Nolan"),
            new Livre("L002", "1984", 1949, "George Orwell"),
            new Film("F003", "Blade Runner", 1982, "Ridley Scott"),
            new Jeu("J003", "Hollow Knight", 2017, "Team Cherry"),
            new Film("F004", "Parasite", 2019, "Bong Joon-ho"),
            new Film("F005", "Interstellar", 2014, "Christopher Nolan"),
            new Jeu("J001", "The Legend of Zelda: Breath of the Wild", 2017, "Nintendo"),
            new Jeu("J002", "The Witcher 3: Wild Hunt", 2015, "CD Projekt"),
            new Livre("L003", "Dune", 1965, "Frank Herbert"),
            new Film("F002", "Le Voyage de Chihiro", 2001, "Hayao Miyazaki"),
            new Livre("L004", "Fondation", 1951, "Isaac Asimov"),
            new Jeu("J004", "Portal 2", 2011, "Valve"),
            new Jeu("J005", "Minecraft", 2011, "Mojang"),
            // --- DOUBLON VOLONTAIRE (même identifiant que L003) ---
            new Livre("L003", "Dune (édition collector)", 2021, "Frank Herbert")
        };
    }
}
