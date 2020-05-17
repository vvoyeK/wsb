package pri.vvoyek.wsb.devices;

import java.time.Year;

public class Diesel extends Car {
    public Diesel(String model, String company, Year yearOfProduction, double value) {
        super(model, company, yearOfProduction, value);
    }

    public void refuel() {
        System.out.println(this + " został zaatankowany!");
    }
}
