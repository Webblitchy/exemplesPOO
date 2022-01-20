package ExemplesTE.MagiciensV2;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Standard bird");

        Bird b1 = new Bird(Location.Lorien);
        b1.speak();
        b1.move(Location.Mordor);

        System.out.println("\n -- Gandalf");

        Wizard gandalf = new Wizard("Gandalf", Location.Lorien);
        gandalf.speak();
        Bird b2 = gandalf.invokeBird();
        b2.move(Location.Rohan);

        System.out.println("\n-- Saruman");

        Wizard saruman = new Wizard("Saruman", Location.Rohan);
        saruman.speak();

        Bird b3 = saruman.invokeBird();
        b3.move(Location.Lorien);

        saruman.move(Location.Gondor);
        b3.move(Location.Gondor);

        System.out.println("\n-- Existing entities");
        Entity.printEntities();
    }
}
