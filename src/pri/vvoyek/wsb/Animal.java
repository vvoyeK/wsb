package pri.vvoyek.wsb;

public class Animal {
    final String species;
    private Double weight;

    static final public String HUMAN = "human";
    static final public String DOG = "dog";
    static final public String CAT = "cat";
    static final public String RAT = "rat";

    static final private Double DEFAULT_HUMAN_WEIGHT = 100.0;
    static final private Double DEFAULT_DOG_WEIGHT = 50.0;
    static final private Double DEFAULT_CAT_WEIGHT = 10.0;
    static final private Double DEFAULT_RAT_WEIGHT = 0.5;

    static private Double getDefaultWeight(String species) {
        switch (species) {
            case HUMAN:
                return DEFAULT_HUMAN_WEIGHT;
            case DOG:
                return DEFAULT_DOG_WEIGHT;
            case CAT:
                return DEFAULT_CAT_WEIGHT;
            case RAT:
                return DEFAULT_RAT_WEIGHT;
            default:
                return 0.0;
        }
    }

    public Animal(String species) {
        this.species = species;
        this.weight = getDefaultWeight(species);
    }

    boolean isAlive() {
        return weight > 0.0;
    }

    void feed(double food) {
        if (food < 0.0)
            throw new IllegalArgumentException();

        if (!isAlive()) {
            System.out.println("Sorry, can't feed as " + this + " is already dead");
            return;
        }

        weight += food;
    }

    void takeForAWalk(double weightLost) {
        if (weightLost < 0.0)
            throw new IllegalArgumentException();

        if (!isAlive()) {
            System.out.println("Sorry, can't walk as " + this + " is already dead");
            return;
        }

        weight -= weightLost;

        if (weight <= 0.0) {
            weight = 0.0;
            System.out.println("Sorry, " + this + " died during walk");
        }
    }

    void feed() {
        feed(getDefaultWeight(species) / 100.0);
    }

    void takeForAWalk() {
        takeForAWalk(getDefaultWeight(species) / 200.0);
    }

    public String toString() {
        return this.species + " " + this.weight + "kg";
    }
}