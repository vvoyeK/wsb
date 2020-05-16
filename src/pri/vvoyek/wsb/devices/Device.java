package pri.vvoyek.wsb.devices;

import java.time.Year;

public abstract class Device {
    final String company;
    final String model;
    final Year yearOfProduction;

    public Device(String model, String company, Year yearOfProduction) {
        this.model = model;
        this.company = company;
        this.yearOfProduction = yearOfProduction;
    }

    public String toString() {
        return company + "/" + model + "/" + yearOfProduction;
    }

    public abstract void turnOn();
}
