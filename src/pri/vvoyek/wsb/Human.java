package pri.vvoyek.wsb;
import pri.vvoyek.wsb.creatures.Animal;
import pri.vvoyek.wsb.devices.Car;

import java.time.LocalDateTime;

public class Human extends Animal {
    private String name;
    Animal pet;
    private Car car;
    private double salary;
    public double cash;

    public Human(String name) {
        super(Animal.HUMAN);
        this.name = name;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car newCar) {
        if (salary > newCar.value){
            car = newCar;
            System.out.println("Kupiłeś " + newCar + " za gotówkę!");
        } else if(salary > newCar.value/12) {
            car = newCar;
            System.out.println("Udało ci się kupić " + newCar + " na kredyt!");
        } else {
            System.out.println("Zapisz się na studia i znajdź nową robotę albo idź po podwyżkę o " + (newCar.value - salary));
        }
    }

    public final void sell(Human seller, Human buyer, Double price) {
       throw new RuntimeException("Handel ludźmi jest zabroniony!");
    }

    public String toString() {
        return name;
    }
}