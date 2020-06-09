package pri.vvoyek.wsb.devices;

import pri.vvoyek.wsb.Human;

import java.net.InetAddress;
import java.net.URL;
import java.time.Year;
import java.util.*;


public class Phone extends Device {
    public String number;
    public List<Application> apps;

    public static final String APP_SERVER_ADDRESS = "www.wsb.com";
    public static final String APP_SERVER_PROTO = "https";
    public static final String APP_VERSION = "1.0";

    public Phone(String number) {
        super("unknown", "noname", Year.now());
        this.apps = new Vector<Application>();
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

    public static class Application {
        public String name;
        public String version;
        public double price;

        public Application(String appName, String appVersion, double price) {
            this.name = appName;
            this.version = appVersion;
            this.price = price;
        }

        public String toString() {
            return name + " $" + price + "";
        }

        public static class ByNameComparator implements Comparator<Application> {
            public int compare(Application a, Application b) {
                return a.name.compareTo(b.name);
            }
        }

        public static class ByPriceComparator implements Comparator<Application> {
            public int compare(Application a, Application b) {
                return a.price < b.price ? - 1 : a.price == b.price ? 0 : 1;
            }
        }
    }

    public void installAnApp(Application app) {
        if (owner.cash < app.price)
            throw new RuntimeException(owner + " can't afford " + app);

        apps.add(app);
        owner.cash -= app.price;
        System.out.println(app.name + " was installed on " + this);
    }

    public boolean isAppInstalled(Application app) {
        return apps.contains(app);
    }

    public boolean isAppInstalled(String appName) {
        ListIterator<Application> it = apps.listIterator();

        while (it.hasNext()) {
            if (it.next().name.equals(appName))
                return true;
        }
        return false;
    }

    public void showFreeApps() {
        System.out.println("Free applications installed on " + this + ":");
        for (Application app : apps)
            if (app.price == 0.0)
                System.out.println(app);
    }

    public double getApplicationsValue() {
        double total = 0.0;
        for (Application app : apps)
            total += app.price;
        return total;
    }

    public void showAllAppsByName() {
        System.out.println("Applications installed on " + this +":");;
        Application[] arr = apps.toArray(new Application[0]);
        Arrays.sort(arr, new Application.ByNameComparator());
        for (Application app: arr)
            System.out.println(app);
    }

    public void showAllAppsByPrice() {
        System.out.println("Applications installed on " + this +":");;
        Application[] arr = apps.toArray(new Application[0]);
        Arrays.sort(arr, new Application.ByPriceComparator());
        for (Application app: arr)
            System.out.println(app);
    }
}