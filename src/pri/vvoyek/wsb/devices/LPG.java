package pri.vvoyek.wsb.devices;

import java.time.Year;

public class LPG extends Car {
    public LPG(String model, String company, Year yearOfProduction, double value) {
        super(model, company, yearOfProduction, value);
    }
    public void refuel() {
    }
}
