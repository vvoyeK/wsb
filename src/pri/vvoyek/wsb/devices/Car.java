package pri.vvoyek.wsb.devices;

import java.time.Year;

public class Car extends Device {
    public double value;

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

}
