package pri.vvoyek.wsb.devices;

import java.time.Year;

public class Car {
    final String model;
    final String company;
    final Year year;
    public double value;

    public Car(String model, String company, Year year, double value) {
        this.model = model;
        this.company = company;
        this.year = year;
        this.value = value;
    }

    public String toString() {
        return this.company + " " + this.model + " rocznik " + year + " o wartości " + value;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;

        Car otherCar = (Car)other;
        return model.equals(otherCar.model) &&
                company.equals(otherCar.company) &&
                year.equals(otherCar.year) &&
                value == otherCar.value;
    }

    public int hashCode() {
        return model.hashCode() ^ company.hashCode() ^ year.hashCode() ^ (int)(1234*value);
    }

}
