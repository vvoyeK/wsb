package pri.vvoyek.wsb;
import pri.vvoyek.wsb.creatures.Animal;
import pri.vvoyek.wsb.devices.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Human extends Animal {
    private String name;
    Animal pet;
    private Car[] garage;
    private double salary;
    public double cash;
    static private int DEFAULT_GARAGE_CAPACITY = 1;

    public Human(String name) {
        this(name, DEFAULT_GARAGE_CAPACITY);
    }

    public Human(String name, int garageCapacity) {
        super(Animal.HUMAN);
        this.name = name;
        this.garage = new Car[garageCapacity];
    }


    public double getSalary() {
        System.out.println("salary at " + LocalDateTime.now() + " was " + salary);
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0.0)
            throw new IllegalArgumentException("salary can't be negative");

        if (salary < this.salary)
            System.out.println("Przykro nam, dostałeś obniżkę o " + (this.salary - salary));
        else
            System.out.println("Gratulacje, dostałeś podwyżkę o " + (salary - this.salary));

        this.salary = salary;
        System.out.println("\tNowe dane zostały wysłane do systemu księgowego.");
        System.out.println("\tProszę zgłosić się do pani Hani z kadr po odbiór ankesu do umowy.");
        System.out.println("\tZUS i US już wiedzą o zmianie wypłaty u nie ma sensu ukrywać dochodów.");
    }

    public Car getCar(int garageSlot) {
        return garage[garageSlot];
    }

    public void setCar(Car newCar, int garageSlot) {
        if (salary > newCar.value){
            garage[garageSlot] = newCar;
            System.out.println("Kupiłeś " + newCar + " za gotówkę!");
        } else if(salary > newCar.value/12) {
            garage[garageSlot] = newCar;
            System.out.println("Udało ci się kupić " + newCar + " na kredyt!");
        } else {
            System.out.println("Zapisz się na studia i znajdź nową robotę albo idź po podwyżkę o " + (newCar.value - salary));
        }
    }

    public void showGarage() {
        System.out.println(name + "'s garage");
        for (int i = 0; i < garage.length; i++)
            System.out.println("mp #" + i + " " + garage[i]);
        System.out.println(name + "'s garage value is " + getGarageValue());
    }

    public void removeCar(Car sold) {
        for (int i = 0; i < garage.length; i++)
            if (garage[i].equals(sold))
                garage[i] = null;
    }

    public void addCar(Car bought) {
        for (int i = 0; i < garage.length; i++)
            if (garage[i] == null) {
                garage[i] = bought;
                return;
            }
        throw new RuntimeException("brak miejsca w garażu");
    }

    public boolean hasCarInGarage(Car other) {
        for (Car car : garage)
            if (car != null && car.equals(other))
                return true;
        return false;
    }

    public boolean hasFreeGarageSlot() {
        for (Car car : garage)
            if (car == null)
                return true;
        return false;
    }

    public double getGarageValue() {
        double total = 0.0;

        for (Car car : garage)
            if (car != null)
                total += car.value;

        return total;
    }

    public void sortCars() {
        Arrays.sort(garage, new Device.ByYearComparator());
    }

    public final void sell(Human seller, Human buyer, Double price) {
       throw new RuntimeException("Handel ludźmi jest zabroniony!");
    }

    public String toString() {
        return name;
    }
}