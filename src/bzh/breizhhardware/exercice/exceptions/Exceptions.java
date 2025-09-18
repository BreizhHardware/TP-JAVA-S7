package bzh.breizhhardware.exercice.exceptions;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Exceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Entrez le premier entier (a) : ");
            int a = scanner.nextInt();
            System.out.print("Entrez le deuxième entier (b) : ");
            int b = scanner.nextInt();
            int resultat = a / b;
            double resultatDouble = (double) a / b;
            System.out.println("Résultat de la division : " + resultatDouble);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : division par zéro interdite !");
        } catch (InputMismatchException e) {
            System.out.println("Erreur : saisie invalide, veuillez entrer des entiers !");
        } finally {
            System.out.println("Fin du programme");
            scanner.close();
        }
    }
}
