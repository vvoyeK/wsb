package pri.vvoyek.wsb.devices;

import pri.vvoyek.wsb.Human;

import java.time.Year;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public abstract class Car extends Device {

    private List<Human> owners;

    public Car(String model, String company, Year yearOfProduction, double value) {
        super(model, company, yearOfProduction);
        this.owners = new Vector<Human>();
        this.value = value;
    }

    public String toString() {
        return super.toString() + " o wartości " + value;
    }

    public void setFirstOwner(Human firstOwner) {
        if (!owners.isEmpty())
            throw new RuntimeException(this + " is already pre-owned");
        owners.add(firstOwner);
    }

    public void showOwners() {
        System.out.println(this + " list of owners:");
        for (Human owner : owners)
            System.out.println(owner);
    }

    public int transactionCount() {
        return owners.isEmpty() ? 0 : owners.size() - 1;
    }

    public boolean wasOwnedBy(Human oldOwner) {
        for (Human owner : owners)
            if (owner.equals(oldOwner))
                return true;
        return false;
    }

    public boolean wasSoldByTo(Human seller, Human buyer) {
        ListIterator<Human> it = owners.listIterator();

        while (it.hasNext()) {
            if (!seller.equals(it.next()))
                continue;
            if (!it.hasNext())
                return false;
            if (buyer.equals(it.next()))
                return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;

        Car otherCar = (Car)other;
        return model.equals(otherCar.model) &&
                company.equals(otherCar.company) &&
                yearOfProduction.equals(otherCar.yearOfProduction) &&
                value == otherCar.value;
    }

    public int hashCode() {
        return model.hashCode() ^ company.hashCode() ^ yearOfProduction.hashCode() ^ (int)(1234*value);
    }

     public void turnOn() {
         System.out.println(this + " was turned on");
    }

    public void sell(Human seller, Human buyer, Double price) {
        if (owners.isEmpty() || (owners.lastIndexOf(seller) + 1 != owners.size()))
            throw new RuntimeException(seller + " nie jest właścicielem " + this);
        if (!seller.hasCarInGarage(this))
            throw new RuntimeException(seller + " nie posiada w garażu " + this);
        if (!buyer.hasFreeGarageSlot())
            throw new RuntimeException(buyer + " nie posiada miejsca w garażu");

        super.sell(seller, buyer, price);

        seller.removeCar(this);
        buyer.addCar(this);

        owners.add(buyer);
    }


    public abstract void refuel();
}
