package ExemplesTE.Pepiniere;

// TE POO MGF 18-19

import java.util.LinkedList;
import java.util.Random;

class Plante {

}

class Haricot extends Plante {

}

abstract class Graine {
    private int id;

    public Graine(int id) {
        this.id = id;
    }

    protected String getPhraseDePousse() {
        return String.format("Une nouvelle plante de %s pousse de %s", getType(), nom());
    }

    public String nom() {
        return String.format("la graine de %s #%d", getType(), id);
    }

    public abstract String getType();

    public abstract Plante pousser();
}

class GraineDeHaricot extends Graine {

    public GraineDeHaricot(int id) {
        super(id);
    }

    public String getType() {
        return "haricot";
    }

    @Override
    public Plante pousser() {
        System.out.println(getPhraseDePousse());
        return new Haricot();
    }
}

enum Couleur {
    RougeVif,
    Mauve,
    Orange,
    Rose;

    public static int count() {
        return values().length;
    }

    public static Couleur random() {
        int index = new Random().nextInt(values().length);
        return values()[index];
    }
}

class Geranium extends Plante {
    private static int[] history = new int[Couleur.count()];
    private int id;
    private int nbGraines;
    private Couleur couleur;
    private Geranium parent;

    public Geranium() {
        couleur = Couleur.random();
        id = ++history[couleur.ordinal()];
    }

    public Geranium(Geranium parent) {
        this();
        this.parent = parent;
    }

    public String nom() {
        return String.format("Géranium %s #%d", couleur, id);
    }

    public Graine produireGraine() {
        Graine graine = new Graine(++nbGraines) {
            public String nom() {
                return String.format("%s de %s", super.nom(), Geranium.this.nom());
            }

            public String getType() {
                return "géranium";
            }

            public Plante pousser() {
                Geranium newGeranium = new Geranium(Geranium.this);
                System.out.printf("Merveille! %s pousse de %s\n", newGeranium.nom(), nom());
                return newGeranium;
            }
        };
        System.out.printf("Production de %s\n", graine.nom());
        return graine;
    }
}

public class Pepiniere {
    public static void main(String[] args) {
        // Point 1
        Graine graine = new GraineDeHaricot(1);
        System.out.println(graine.nom());
        Haricot h = (Haricot) graine.pousser();

        // Point 3
        LinkedList<Geranium> geraniums = new LinkedList<>();
        LinkedList<Graine> graines;
        Geranium papi = new Geranium();
        geraniums.add(papi);

        for (int i = 1; i <= 5; ++i) {
            graines = new LinkedList<>();

            System.out.printf("\n## Saison %d\n", i);

            System.out.println("- Production de graines");
            for (Geranium g : geraniums) {
                if (new Random().nextBoolean())
                    graines.add(g.produireGraine());
            }

            System.out.println("- Pousses");
            for (Graine g : graines)
                geraniums.add((Geranium)g.pousser());
        }
    }
}
