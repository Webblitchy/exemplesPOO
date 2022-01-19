package Heritage;

public class Main {
    public static void main(String[] args) {
        Parent pere = new Parent("Jean","Dupuis", 1965);
        Parent mere = new Parent("Jeanne", "Dupuis", 1966);
        Enfant fils = new Enfant("George", "Dupuis", 2009, pere, mere);

        // appel de la méthode de Parent depuis l'enfant
        System.out.println(fils.age());

        System.out.println("---------------------------------------");

        // appel de la méthode interne
        System.out.println(mere.info());

        System.out.println("---------------------------------------");

        // appel de la méthode redéfinie dans enfant
        System.out.println(fils.info());

        System.out.println("---------------------------------------");

        // appel de la fonction de la classe abstraite
        pere.chanteHymne();
    }
}
