package ExemplesTE.MagiciensV2;

import java.util.ArrayList;

public abstract class Entity {
    protected final String nom;
    protected String phrase;
    protected Location location;

    private static final ArrayList<Entity> entities = new ArrayList<>();

    public Entity(String nom, String phrase, Location location) {
        this.nom = nom;
        this.phrase = phrase;
        this.location = location;
        entities.add(this);
    }

    public void speak() {
        System.out.printf("%s says '%s'%n", nom, phrase);
    }

    public void move(Location location) {
        this.location = location;
        System.out.printf("%s moves to %s%n", nom, location);
    }

    public static void printEntities() {
        for (Entity e : entities)
            System.out.println(e);
    }

    @Override
    public String toString() {
        return nom;
    }
}