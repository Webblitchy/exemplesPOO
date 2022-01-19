package ClassesInternes;

public class Main {
  public static void main(String[] args) {
    Tour t = new Tour(new Cercle(3.4f, 5.6f, 7.8f));
    Maison m = new Maison(new Maison.Piege(10_000), new Maison.Piege(500));

    System.out.println(t);
    System.out.println("Activation de la maison piégée ! dégâts totaux : " + m.activer());
  }
}
