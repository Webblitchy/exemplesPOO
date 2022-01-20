package ExemplesTE.Magiciens;

public class Bird extends Entity {
    private static int nbOfBirds;
    private final int id;

    public Bird(Location location) {
        super(location);
        this.id = nbOfBirds++;
    }

    @Override
    String words() {
        return "'Chirp'";
    }

    @Override
    String name() {
        return "Bird #" + id;
    }

    @Override
    void speak() {
        super.speak();
    }
}
