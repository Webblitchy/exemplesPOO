package Enum;

import java.util.ArrayList;
import java.util.Arrays;

public class Element {
    final int id;
    final String nom;

    public Element(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public static ArrayList<Element> values() {
        return new ArrayList<>(Arrays.asList(
                fer,
                carbone,
                mercure
        ));
    }

    public static Element fer = new Element(1, "fer");

    public static Element carbone = new Element(2, "carbone");

    public static Element mercure = new Element(3, "mercure");

    @Override
    public String toString() {
        return String.format("%s (#%d)", nom, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;

        Element element = (Element) o;

        return id == element.id && nom.equals(element.nom);
    }

    @Override
    public int hashCode() {
        return id + (nom != null ? nom.hashCode() : 0);
    }
}