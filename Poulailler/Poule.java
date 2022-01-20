package Poulailler;

public class Poule {
    private final String nom; // Nom de la poule
    private Integer nbPontes = 0; // Nombre d’oeufs pondus

    public Poule(String s) {
        nom = s;
    }

    public Oeuf pondre() { // Ponte d’un oeuf (de Poule)
        int pontes = ++nbPontes;
        System.out.println(nom + " pond son oeuf " + nbPontes);

        return new Oeuf() {
            public Poule eclore() {
                Poule poussin = new Poule(nom + pontes);
                System.out.println(poussin + " sort de l'oeuf #" + pontes + " de " + nom);
                return poussin;
            }
        };
    }

    public String toString() {
        return nom;
    }
}