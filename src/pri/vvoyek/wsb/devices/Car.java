package pri.vvoyek.wsb.devices;

import pri.vvoyek.wsb.Human;

import java.time.Year;

public abstract class Car extends Device {

    public Car(String model, String company, Year yearOfProduction, double value) {
        super(model, company, yearOfProduction);
        this.value = value;
    }

    public String toString() {
        return super.toString() + " o wartości " + value;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;

        Car otherCar = (Car)other;
        return model.equals(otherCar.model) &&
                company.equals(otherCar.company) &&
                yearOfProduction.equals(otherCar.yearOfProduction) &&
                value == otherCar.value;
    }

    public int hashCode() {
        return model.hashCode() ^ company.hashCode() ^ yearOfProduction.hashCode() ^ (int)(1234*value);
    }

     public void turnOn() {
         System.out.println(this + " was turned on");
    }

    public void sell(Human seller, Human buyer, Double price) {

        if (!seller.hasCarInGarage(this))
            throw new RuntimeException(seller + " nie posiada w garażu " + this);
        if (!buyer.hasFreeGarageSlot())
            throw new RuntimeException(buyer + " nie posiada miejsca w garażu");

        super.sell(seller, buyer, price);

        seller.removeCar(this);
        buyer.addCar(this);
    }


    public abstract void refuel();
}
