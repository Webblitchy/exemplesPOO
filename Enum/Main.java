package Enum;

import java.util.LinkedList;

public class Main {
    /*
    public static void main(String[] args) {
        for (Element e : Element.values()) {
            System.out.println(e);
        }

        Planete mars = new Planete("Mars", Element.fer, Element.carbone);
        Element e = Element.mercure;
        System.out.println(mars.nom() + ". " + e + " : " + (mars.contient(e) ? "oui" : "non"));
    }
     */

    public static void main(String[] args) {
        Planete mars = new Planete("Mars", Element.fer, Element.carbone),
                venus = new Planete("Venus", Element.mercure);

        System.out.println("-- Construction des sondes");
        Extracteur[] sondes = {
                mars.construireSonde(Element.mercure),
                mars.construireSonde(Element.carbone),
                venus.construireSonde(Element.fer),
                venus.construireSonde(Element.mercure),
        };

        System.out.println("-- Extractions");

        LinkedList<Object> list = new LinkedList<>();
        for (Extracteur s : sondes) {
            Object e = s.extraire();
            if (e != null)
                list.add(e);
        }
    }
}