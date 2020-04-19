package pri.vvoyek.wsb;
import pri.vvoyek.wsb.*;

public class Human extends Animal {
    Animal pet;
    Car car;

    public Human() {
        super(Animal.HUMAN);
    }

    public String toString() {
        return super.toString() + " " + this.car;
    }
}