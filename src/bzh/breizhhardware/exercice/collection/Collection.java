package bzh.breizhhardware.exercice.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Collection {
    public static void main(String[] args) {
        // Création et affichage des ensembles
        Set<String> villesHashSet = creerEnsembleVilles(new HashSet<>());
        Set<String> villesTreeSet = creerEnsembleVilles(new TreeSet<>());

        // Affichage des ensembles
        afficherEnsemble("HashSet", villesHashSet);
        afficherEnsemble("TreeSet", villesTreeSet);

        // Explications
        afficherExplications();
    }

    private static Set<String> creerEnsembleVilles(Set<String> ensemble) {
        // Ajout des villes, y compris un doublon "Paris"
        String[] villes = {"Paris", "Lyon", "Marseille", "Toulouse", "Lille", "Paris"};
        // Utilisation de addAll pour ajouter toutes les villes à l'ensemble sans faire de boucle
        ensemble.addAll(Arrays.asList(villes));
        return ensemble;
    }

    private static void afficherEnsemble(String type, Set<String> ensemble) {
        System.out.println("Contenu du " + type + " : " + ensemble);
    }

    private static void afficherExplications() {
        System.out.println("\nExplications :");
        System.out.println("- HashSet ne garantit pas l'ordre d'affichage des éléments, il gère uniquement l'unicité (pas de doublons).");
        System.out.println("- TreeSet trie automatiquement les éléments par ordre alphabétique et gère aussi l'unicité (pas de doublons).");
        System.out.println("- Dans les deux cas, la ville 'Paris' n'apparaît qu'une seule fois car les ensembles ne stockent pas de doublons.");
    }
}
