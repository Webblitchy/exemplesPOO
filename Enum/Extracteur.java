package Enum;

public class Extracteur {
    Element element;
    int id;
    Planete planete;

    public Extracteur(int id, Element element, Planete planete) {
        this.id = id;
        this.element = element;
        this.planete = planete;
    }

    public Element extraire() {
        System.out.printf("%s recherche %s ... ", nom(), element);
        if (planete.contient(element)) {
            System.out.println("extrait !");
            return element;
        }
        System.out.println("inconnu");
        return null;
    }

    public String nom() {
        return String.format("%s-%d", planete.nom(), id);
    }

    @Override
    public String toString() {
        return nom();
    }
}
