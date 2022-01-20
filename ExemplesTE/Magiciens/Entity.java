package ExemplesTE.Magiciens;

import java.util.LinkedList;
import java.util.List;

abstract class Entity {
    private Location location;
    private static List<Entity> instances = new LinkedList<>();

    Entity(Location location) {
        this.location = location;
        instances.add(this);
    }

    void speak() {
        System.out.println(name() + " says " + words());
    }

    abstract String name();

    abstract String words();

    void move(Location location) {
        this.location = location;
        System.out.println(name() + " moves to " + location.name());
    }

    public Location getLocation() {
        return location;
    }

    static void printEntities() {
        for (Entity e : instances) {
            System.out.println(e.name());
        }
    }
}
