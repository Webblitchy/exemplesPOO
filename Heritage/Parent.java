package Heritage;

public class Parent extends Suisse{
    // attributs
    private String nom;
    private String prenom;
    private int annéeNaissance;

    // getter
    public int age(){
        return 2022 - annéeNaissance;
    }


    // méthode publique
    public String info(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : ");
        sb.append(nom);
        sb.append("\nPrenom : ");
        sb.append(prenom);
        sb.append("\nage : ");
        sb.append(age());
        return sb.toString();
    }


    // Implémente la fonction abstraite
    public boolean peutVoter() {
        return true;
    }


    // Constructeur
    Parent(String prenom, String nom, int annéeNaissance){
        this.prenom = prenom;
        this.nom = nom;
        this.annéeNaissance = annéeNaissance;
    }
}

