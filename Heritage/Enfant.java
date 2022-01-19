package Heritage;

public class Enfant extends Parent {
    // prenom et nom est défini dans parent
    Parent parent1;
    Parent parent2;

    // méthode redéfinie
    @Override
    public String info(){
        String infos = super.info();
        infos += "\n\n\tParents : \n" + parent1.info() + "\n" + parent2.info();
        return infos;
    }

    // Implémente la fonction abstraite (héritée de parent)

    public boolean peutVoter() {
        return false;
    }

    // Constructeur
    Enfant(String prenom, String nom, int age, Parent p1, Parent p2) {
        // créé le parent
        super(prenom, nom, age);

        parent1 = p1;
        parent2 = p2;
    }
}
