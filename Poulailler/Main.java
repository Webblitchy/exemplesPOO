package Poulailler;

public class Main {
    public static void main(String[] args) {
        Poulailler p = new Poulailler(); // d’un poulailler
        p.ajouter(new Poule("Cocotte")); // possédeant au départ 2 poules
        p.ajouter(new Poule("Rosette"));
        System.out.println("Condition initiale:");
        System.out.println(p);
        for (int i = 0; i < 4; i++) // sur 10 tours
        {
            System.out.println();
            System.out.println("========== Tour suivant, itération: " + i + "...");
            p.tourSuivant();
        }
    }
}

