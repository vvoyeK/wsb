package pri.vvoyek.wsb;

import java.time.Year;

public class Car {
    final String model;
    final String company;
    final Year year;
    double value;

    public Car(String model, String company, Year year, double value) {
        this.model = model;
        this.company = company;
        this.year = year;
        this.value = value;
    }

    public String toString() {
        return this.company + " " + this.model + " rocznik " + year + " o wartości " + value;
    }
}
