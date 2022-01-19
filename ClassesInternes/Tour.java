package ClassesInternes;

public class Tour implements Bâtiment {
  private final Cercle location;

  public Tour(Cercle location) {
    this.location = location;
  }

  @Override
  public Type getType() {
    return Type.DEFENSE;
  }

  @Override
  public String toString() {
    return String.format(
        "Tour de %s placée en %s et de rayon %.2f",
        getType(), location.getCenter(), location.getRayon());
  }
}
