package pri.vvoyek.wsb.creatures;

import pri.vvoyek.wsb.Human;
import pri.vvoyek.wsb.Sellable;

public abstract class Animal implements Sellable, Feedable {
    final String species;
    private Double weight;
    private Human owner;

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

    public Animal(String species, double weight) {
        this.species = species;
        this.weight = weight;
    }

    public boolean isAlive() {
        return weight > 0.0;
    }

    public void feed(double food) {
        if (food < 0.0)
            throw new IllegalArgumentException();

        if (!isAlive()) {
            System.out.println("Sorry, can't feed as " + this + " is already dead");
            return;
        }

        weight += food;
    }

    public void takeForAWalk(double weightLost) {
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

    public void feed() {
        feed(weight / 100.0);
    }

    public void takeForAWalk() {
        takeForAWalk(getDefaultWeight(species) / 200.0);
    }

    public String toString() {
        return this.species + " " + this.weight + "kg";
    }

    public void sell(Human seller, Human buyer, Double price) {

        if (owner != null && !owner.equals(seller))
            throw new RuntimeException(seller + " nie posiada " + this);

        if (buyer.cash < price)
            throw new RuntimeException(buyer + " nie posiada " + price + " w gotówce!");

        buyer.cash -= price;
        seller.cash += price;

        owner = buyer;
        System.out.println(buyer + " kupił " + this + " za " + price);
    }

}
