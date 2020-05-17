package pri.vvoyek.wsb.devices;

import java.time.Year;

public class Electric extends Car {
    public Electric(String model, String company, Year yearOfProduction, double value) {
        super(model, company, yearOfProduction, value);
    }

    public void refuel() {
    }
}
