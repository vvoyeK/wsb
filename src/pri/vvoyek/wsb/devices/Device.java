package pri.vvoyek.wsb.devices;

import pri.vvoyek.wsb.Human;
import pri.vvoyek.wsb.Sellable;

import java.time.Year;
import java.util.Comparator;

public abstract class Device implements Sellable {
    final String company;
    final String model;
    final Year yearOfProduction;
    protected Human owner;
    public double value;

    public Device(String model, String company, Year yearOfProduction) {
        this.model = model;
        this.company = company;
        this.yearOfProduction = yearOfProduction;
    }

    public void setFirstOwner(Human owner) {
        this.owner = owner;
    }

    public String toString() {
        return company + "/" + model + "/" + yearOfProduction;
    }

    public abstract void turnOn();

    public void sell(Human seller, Human buyer, Double price) {

        if (owner != null && !owner.equals(seller))
            throw new RuntimeException(seller + " nie posiada " + this);

        if (buyer.cash < price)
            throw new RuntimeException(buyer + " nie posiada " + price + " w gotówce!");

        buyer.cash -= price;
        seller.cash += price;

        owner = buyer;
        System.out.println(buyer + " kupił " + this + " za " + price);
    }

    public static class ByYearComparator implements Comparator<Device> {
        public int compare(Device a, Device b) {
            if (a == null) {
                if (b == null)
                    return 0;
                return 1;
            }
            if (b == null)
                return -1;

            return a.yearOfProduction.getValue() < b.yearOfProduction.getValue() ? -1 :
                    a.yearOfProduction.equals(b.yearOfProduction) ? 0 : 1;
        }
    }
}

