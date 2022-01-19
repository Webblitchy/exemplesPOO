package ClassesInternes;

public interface Bâtiment {
  Type getType();

  enum Type {
    DEFENSE("Défense"),
    PIEGE("Piege");

    final String nom;

    Type(String nom) {
      this.nom = nom;
    }

    @Override
    public String toString() {
      return nom;
    }
  }
}
