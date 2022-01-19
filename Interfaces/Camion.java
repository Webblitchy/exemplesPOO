package Interfaces;

// hérite d'une class abstraite et implémente une interface
public class Camion extends Transporteur implements Vehicule{
    private String marchandise;

    // override la version par défaut
    public int nbPassagers(){
        return 2;
    }

    // implémente la méthode de l'interface
    public void transporte(int quantite) {
        System.out.println("le véhicule transporte " + quantite + "kg");
    }
}
