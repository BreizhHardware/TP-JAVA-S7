import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Bibliotheque {
    private Oeuvre[] oeuvres;

    /**
     * Création d'une bibliotheque a partir d'un tableau d'oeuvre
     *
     * @param oeuvres tableau d'oeuvre a mettre dans la bibliotheque
     */
    public Bibliotheque(Oeuvre[] oeuvres) {
        Oeuvre[] oeuvreUnique = new Oeuvre[oeuvres.length];
        // Vérifie si un ID est dupliqué si c'est le cas ignore avec un message
        for (int i = 0; i < oeuvres.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                // Si oeuvre[i] egale oeuvre[j] alors il n'est pas unique et on l'ignore
                if (Objects.equals(oeuvres[i].getId(), oeuvres[j].getId())) {
                    isUnique = false;
                    System.out.println("ID dupliqué trouvé : " + oeuvres[i].getId() + ", ignoré.");
                    // Reduit la taille de oeuvreUnique
                    oeuvreUnique = Arrays.copyOf(oeuvreUnique, oeuvreUnique.length - 1);
                    break;
                }
            }
            // Si il est unique on l'ajoute a oeuvreUnique
            if (isUnique) {
                oeuvreUnique[i] = oeuvres[i];
            }
        }

        this.oeuvres = oeuvreUnique;
    }

    /**
     * Récupération des oeuvres de la bibliotheque
     *
     * @return oeuvres de la bibliotheque
     */
    public Oeuvre[] getOeuvres() {
        return oeuvres;
    }

    /**
     * Modification des oeuvres de la bibliotheque
     *
     * @param oeuvres nouvelles oeuvres de la bibliotheque
     */
    public void setOeuvres(Oeuvre[] oeuvres) {
        // Si oeuvres est null on crée un tableau vide
        if (this.oeuvres == null) {
            this.oeuvres = new Oeuvre[oeuvres.length];
        } else {
            this.oeuvres = oeuvres;
        }
    }

    /**
     * Ajout d'une nouvelle oeuvre a la bibliotheque
     *
     * @param oeuvre oeuvre a ajouter
     */
    public void insertOeuvre(Oeuvre oeuvre) {
        for (int i = 0; i < this.oeuvres.length; i++) {
            // Si l'id existe déjà alors throw une erreur
            if (Objects.equals(this.oeuvres[i].getId(), oeuvre.getId())) {
                throw new IllegalArgumentException("ID déjà dans la bibliotheque !");
            }
        }
        // Sinon ajoute au tableau oeuvre
        this.oeuvres = Arrays.copyOf(this.oeuvres, this.oeuvres.length + 1);
        this.oeuvres[this.oeuvres.length - 1] = oeuvre;
    }

    /**
     * Trie la bibliotheque en fonction de l'ordre demandée
     *
     * @param ordre ordre de trie (id, type, titre, annee)
     */
    public void trieBibliotheque(String ordre) {
        // On trie la bibliotheque différament en fonction de l'ordre demandé
        if (ordre.equals("id")) {
            Arrays.sort(this.oeuvres, Comparator.comparing(Oeuvre::getId));
        } else if (ordre.equals("type")) {
            Arrays.sort(this.oeuvres, Comparator.comparing(Oeuvre::getType));
        } else if (ordre.equals("titre")) {
            Arrays.sort(this.oeuvres, Comparator.comparing(Oeuvre::getTitre));
        } else if (ordre.equals("annee")) {
            Arrays.sort(this.oeuvres, Comparator.comparing(Oeuvre::getAnnee));
        }
        else {
            throw new IllegalArgumentException("Argument n'est pas id, type, titre ou annee");
        }
    }

    /**
     * Affiche la bibliotheque sans trie
     */
    public void afficherBibliotheque() {
        // Affiche la bibliotheque
        for (int i = 0; i < this.oeuvres.length; i++) {
            System.out.println(this.oeuvres[i].getType() + " " + this.oeuvres[i].toString());
        }
    }

    /**
     * Trie puis affiche la bibliotheque
     *
     * @param ordre trie de la bibliotheque (id ou type)
     */
    public void afficherBibliotheque(String ordre) {
        if (ordre.equals("id")) {
            // Affiche la bibiotheque trié par identifiant
            trieBibliotheque(ordre);
            afficherBibliotheque();
        } else if (ordre.equals("type")) {
            // Affiche la bibliotheque trié par type
            trieBibliotheque(ordre);
            afficherBibliotheque();
        } else {
            // Sinon affiche juste la bibliotheque
            afficherBibliotheque();
        }
    }

    /**
     * Renvoie la taille de la bibliotheque
     *
     * @return taille de la bibliotheque
     */
    public int size() {
        return this.oeuvres.length;
    }

    /**
     * Renvoie de l'oeuvre en position row dans la bibliotheque
     *
     * @param row position de l'oeuvre
     * @return l'oeuvre en position row dans la bibliotheque
     */
    public Oeuvre get(int row) {
        return this.oeuvres[row];
    }
}
