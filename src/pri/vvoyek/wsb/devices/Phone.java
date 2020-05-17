package pri.vvoyek.wsb.devices;

import java.time.Year;


public class Phone extends Device {
    public String number;

    public Phone(String number) {
        super("unknown", "noname", Year.now());
        this.number = number;
    }

    public Phone(String model, String company, Year yearOfProduction, String number) {
        super(model, company, yearOfProduction);
        this.number = number;
    }

    public String toString() {

        return "Phone number " + this.number;
    }

    public void turnOn() {
        System.out.println(this + " is on");

    }
}