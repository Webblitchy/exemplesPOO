package Heritage;

public class Parent extends Suisse{
    // attributs
    private String nom;
    private String prenom;
    private int anneeNaissance;

    // getter
    public int age(){
        return 2022 - anneeNaissance;
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
    @Override
    public boolean peutVoter() {
        return true;
    }


    // Constructeur
    Parent(String prenom, String nom, int anneeNaissance){
        this.prenom = prenom;
        this.nom = nom;
        this.anneeNaissance = anneeNaissance;
    }
}

