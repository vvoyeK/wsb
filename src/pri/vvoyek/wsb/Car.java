package pri.vvoyek.wsb;

import java.time.Year;

public class Car {
    final String model;
    final String company;
    final Year year;

    public Car(String model, String company, Year year) {
        this.model = model;
        this.company = company;
        this.year = year;
    }

    public String toString() {
        return this.company + " " + this.model + " " + year;
    }
}
