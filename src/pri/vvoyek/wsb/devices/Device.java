package pri.vvoyek.wsb.devices;

import pri.vvoyek.wsb.Human;
import pri.vvoyek.wsb.Sellable;

import java.time.Year;

public abstract class Device implements Sellable {
    final String company;
    final String model;
    final Year yearOfProduction;
    private Human owner;

    public Device(String model, String company, Year yearOfProduction) {
        this.model = model;
        this.company = company;
        this.yearOfProduction = yearOfProduction;
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

}
