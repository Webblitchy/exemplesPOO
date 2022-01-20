package ExemplesTE.MagiciensV2;

public class Location {
    private final String nom;
    private final Race race;

    public Location(String nom, Race race) {
        this.nom = nom;
        this.race = race;
    }

    public Race getRace() {
        return race;
    }

    public static Location Lorien = new Location("Lorien", Race.Elfes);
    public static Location Mordor = new Location("Mordor", Race.Orcs);
    public static Location Rohan = new Location("Rohan", Race.Humains);
    public static Location Gondor = new Location("Gondor", Race.Humains);

    @Override
    public String toString() {
        return nom;
    }
}
