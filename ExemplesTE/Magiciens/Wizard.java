package ExemplesTE.Magiciens;

public class Wizard extends Entity {
    private final String name;

    public Wizard(String name, Location location) {
        super(location);
        this.name = name;
    }

    Bird invokeBird() {
        Bird b = new Bird(getLocation()) {
            @Override
            String words() {
                return "'I see " + getLocation().getRace().name() + "'";
            }

            @Override
            void move(Location location) {
                super.move(location);

                super.speak();
                if (location == Wizard.this.getLocation()) {
                    System.out.println(name() + " has found its master " + Wizard.this.name + " !");
                }
            }
        };
        System.out.println(name + " invokes " + b.name());
        return b;
    }

    @Override
    void speak() {
        super.speak();
    }

    @Override
    String words() {
        return "'I'm " + name + " the Wise'";
    }

    @Override
    String name() {
        return name;
    }
}
