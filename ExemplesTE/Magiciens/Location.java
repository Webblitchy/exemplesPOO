package ExemplesTE.Magiciens;

enum Race {
    Orcs, Elves, Humans
}

enum Location {
    Lorien(Race.Elves),
    Gondor(Race.Humans),
    Mordor(Race.Orcs),
    Rohan(Race.Humans);

    private final Race race;

    private Location(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }
}

