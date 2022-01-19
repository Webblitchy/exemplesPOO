package Interfaces;

public interface Vehicule {
    default int nbPassagers() { // Méthode par défaut
        return 5;
    }

    int nbRoues = 4; // est public static final
}
