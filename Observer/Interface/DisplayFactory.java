package Observer.Interface;

public class DisplayFactory {
    DisplayFactory(){
    }
    public DisplayElement generateNewDisplay(){
        //retourne une class Anonyme qui implémente DisplayElement
        return new DisplayElement (){
            @Override
            public void display() {
                System.out.println("Ceci est une class anonyme qui implémente Display, " +
                                           "l'interet dans ce cas est limité :/ ");
            }
        };
    }

}
