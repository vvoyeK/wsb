package pri.vvoyek.wsb;

import pri.vvoyek.wsb.creatures.*;
import pri.vvoyek.wsb.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;

public class Main {

    public static void main(String[] args) {

        Human me = new Human("Wojtek");
        Human buzz = new Human("Buzz");
        Pet dog = new Pet(Pet.DOG);
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

        Car x3 = new Diesel("X3", "BMW", Year.of(2020), 500);
        x3.refuel();
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

        Device bmw = new Electric("X3", "BMW", Year.of(2020), x3.value);
        System.out.println(x3);
        System.out.println(bmw);

        System.out.println(x3.hashCode());
        System.out.println(bmw.hashCode());
        System.out.println(bmw == x3);
        System.out.println(bmw.equals(x3));
        
        bmw.turnOn();
        phone.turnOn();

        me.cash = 0.0;
        buzz.cash = 150.0;

        try {
            bmw.sell(me, buzz, 200.0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        bmw.sell(me, buzz, 100.0);

        try {
            bmw.sell(me, buzz, 10.0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        me.pet =  dog;
        dog.sell(me, me, 10.0);

        Human slave = new Human("Django");

        try {
            slave.sell(buzz, me, 1.0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        FarmAnimal cow = new FarmAnimal("cow", 500.0);
        System.out.println(cow);
        cow.feed();
        System.out.println(cow);
        cow.feed(15.0);
        System.out.println(cow);
        cow.beEaten();

        try {
            phone.installAnApp(new URL(Phone.APP_SERVER_PROTO, Phone.APP_SERVER_ADDRESS,"demo_2.0.0.apk"));
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
