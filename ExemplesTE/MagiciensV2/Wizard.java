package ExemplesTE.MagiciensV2;

public class Wizard extends Entity {
    public Wizard(String nom, Location location) {
        super(nom, String.format("I am %s the Wise", nom), location);
    }

    public Bird invokeBird() {
        Bird b = new Bird(location, this);
        System.out.printf("%s invokes %s%n", nom, b.nom);
        return b;
    }
}
