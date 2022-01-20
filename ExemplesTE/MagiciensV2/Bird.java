package ExemplesTE.MagiciensV2;

public class Bird extends Entity {
    private static int nbOfBirds = 0;
    private Wizard master;

    public Bird(Location location) {
        super(String.format("Bird #%d", ++nbOfBirds), "Chirp", location);
    }

    public Bird(Location location, Wizard master) {
        super(String.format("Bird #%d", ++nbOfBirds), "Chirp", location);
        this.master = master;
    }

    @Override
    public void move(Location location) {
        super.move(location);
        if (master != null) {
            phrase = String.format("I see %s", location.getRace());
            speak();
            if (master.location == location) {
                System.out.printf("%s has found his master %s ! %n", nom, master.nom);
            }
        }
    }
}
