package pri.vvoyek.wsb.devices;

import java.net.InetAddress;
import java.net.URL;
import java.time.Year;


public class Phone extends Device {
    public String number;

    public static final String APP_SERVER_ADDRESS = "www.wsb.com";
    public static final String APP_SERVER_PROTO = "https";
    public static final String APP_VERSION = "1.0";

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

    public void installAnApp(String appName) {
    }

    public void installAnApp(String appName, String appVersion) {
    }

    public void installAnApp(String appName, String appVersion, InetAddress host) {
    }

    public void installAnApp(String[] appNames) {
    }

    public void installAnApp(URL url) {
    }

}