package ExemplesTE.MagiciensV2;

public class Race {
    private final String nom;

    public Race(String nom) {
        this.nom = nom;
    }

    public static Race Elfes = new Race("Elfes");
    public static Race Orcs = new Race("Orcs");
    public static Race Humains = new Race("Humains");

    @Override
    public String toString() {
        return nom;
    }
}