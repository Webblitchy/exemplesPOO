package ClassesInternes;

public class Maison implements Bâtiment {
    private final Piege[] pieges;

    public Maison(Piege... pieges) {
        this.pieges = pieges;
    }

    public int activer() {
        int sum = 0;
        for (Piege p : pieges)
            sum += p.degats;
        return sum;
    }

    @Override
    public Type getType() {
        return Type.PIEGE;
    }

    static class Piege {
        int degats;

        Piege(int degats) {
            this.degats = degats;
        }
    }
}
