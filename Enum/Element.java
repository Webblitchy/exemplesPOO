package Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Element {
    private final int id;
    private final String nom;
    private static int count = 0;

    public Element(String nom) {
        this.id = count++;
        this.nom = nom;
    }

    public static ArrayList<Element> values() {
        return new ArrayList<>(Arrays.asList(
                fer,
                carbone,
                mercure
        ));
    }

    public static Element fer = new Element("fer");

    public static Element carbone = new Element("carbone");

    public static Element mercure = new Element("mercure");

    @Override
    public String toString() {
        return String.format("%s (#%d)", nom, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return id == element.id && Objects.equals(nom, element.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}