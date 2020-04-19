package pri.vvoyek.wsb;


import pri.vvoyek.wsb.devices.Car;
import pri.vvoyek.wsb.devices.Phone;

import java.time.Year;

public class Main {

    public static void main(String[] args) {

        Human me = new Human();
        Animal dog = new Animal(Animal.DOG);
        Phone phone = new Phone("112");

        System.out.println(me);
        System.out.println(dog);
        System.out.println(phone);

        dog.feed();
        System.out.println(dog);

        while (dog.isAlive())
            dog.takeForAWalk();

        System.out.println(dog);
        dog.feed();
        dog.takeForAWalk();

        Car x3 = new Car("X3", "BMW", Year.of(2020), 500);
        System.out.println(x3);

        me.setCar(x3);
        System.out.println(me);

        me.getSalary();

        try {
            me.setSalary(-1.0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        me.setSalary(100.0);
        me.setSalary(90.0);

        x3.value = 200;
        me.setCar(x3);

        x3.value = 50;
        me.setCar(x3);

        Car bmw = new Car("X3", "BMW", Year.of(2020), x3.value);
        System.out.println(x3);
        System.out.println(bmw);

        System.out.println(x3.hashCode());
        System.out.println(bmw.hashCode());
        System.out.println(bmw == x3);
        System.out.println(bmw.equals(x3));

    }
}
