package ClassesInternes;

public class Cercle {
  private final Point center;
  private final float rayon;

  public Cercle(float x, float y, float rayon) {
    center = new Point(x, y);
    this.rayon = rayon;
  }

  public Point getCenter() {
    return center;
  }

  public float getRayon() {
    return rayon;
  }

  private class Point {
    float x, y;

    Point(float x, float y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return String.format("( %.2f ; %.2f )", x, y);
    }
  }
}
