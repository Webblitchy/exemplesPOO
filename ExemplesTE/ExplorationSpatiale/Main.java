package ExemplesTE.ExplorationSpatiale;

import java.util.LinkedList;

class Element {
    private String nom;
    private int id;
    private static int count;

    public static Element
            fer = new Element("fer"),
            carbone = new Element("carbone"),mercure = new Element("mercure");

    private Element(String nom){
        this.nom = nom;
        this.id = ++count;
    }
    public String toString(){
        return nom + "(#" + id + ")";
    }
    public static Element[] values(){
        return new Element[] {fer, carbone, mercure};
    }

}

abstract class Extracteur {
    private int id;

    public Extracteur(int id){
        this.id = id;
    }

    public String nom() {
        return "" + id;
    }

    abstract public Object extraire();

}

class Planete {
    private String nom;
    private Element[] elements;
    private int nbrSondes;

    public Planete(String nom, Element... elements){
        this.nom = nom;
        this.elements = new Element[elements.length];
        for(int i = 0; i < elements.length; ++i){  //on veut copier le tableau ici.
            this.elements[i] = elements[i];
            //this.elements = elements.clone(); //marche aussi.
        }
    }

    public String nom() {
        return nom;
    }

    public boolean contient(Element element) {
        for(Element e : elements){
            if(e == element){ //equals serait faux. On veut juste tester la référence.
                return true;
            }
        }
        return false;
    }

    public Extracteur construireSonde(Element element){ //vu que chaque extracteur est spécifique à la planète
        //on a définir une classe interne.
        Extracteur e = new Extracteur(++nbrSondes){
            public String nom(){
                return Planete.this.nom() + "-" + super.nom();
            }
            public Element extraire(){ //pour la beauté du geste le prof fait de la covariance. On était pas obligé.
                System.out.print(nom() + " recherche " + element + "...");
                if(contient(element)){
                    System.out.println(" extrait!");
                    return element;
                }else{
                    System.out.println(" inconnu!");
                    return null;
                }
            }
        };
        System.out.println("Construction de la sonde " + e.nom());
        return e;
    }
}

class TE {
    public static void main(String[] args) {
        System.out.println("-- Elements connus");
        for (Element e : Element.values())
            System.out.println(e);

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

        System.out.println("-- Eléments trouvés");
        System.out.println(list);
    }
}
