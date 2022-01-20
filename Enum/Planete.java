package Enum;

public class Planete {
    String nom;
    Element[] elements;
    int nbSondes = 0;

    public Planete(String nom, Element... elements) {
        this.nom = nom;
        this.elements = elements;
    }

    public String nom() {
        return nom;
    }

    public Extracteur construireSonde(Element element) {
        nbSondes++;
        Extracteur ex = new Extracteur(nbSondes, element, this);
        System.out.println("Construction de la sonde " + ex);
        return ex;
    }

    boolean contient(Element element) {
        for (Element e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }
}