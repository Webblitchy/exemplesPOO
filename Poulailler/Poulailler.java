package Poulailler;

import java.util.LinkedList;
import java.util.Random;

public class Poulailler {
    private int tour; // Numéro de tour dans la simulation
    private LinkedList<Poule> poules = new LinkedList<Poule>(); // Poules du poulailler
    private Random random = new Random(); // Générateur aléatoire

    public void ajouter(Poule p) { // Ajout d’une poule dans le poulailler
        poules.add(p);
    }

    public void tourSuivant() { // Nouveau tour (ponte + eclosion)

        LinkedList<Oeuf> oeufs = new LinkedList<>();
        for (Poule p : poules)
            for (int i = random.nextInt(2); i < 2; ++i)
                oeufs.add(p.pondre());

        for (Oeuf oeuf : oeufs)
            poules.add(oeuf.eclore());
    }

    public String toString() {
        StringBuilder bs = new StringBuilder();
        for (Poule p : poules)
            bs.append(p).append('\n');
        return bs.toString();
    }
}
