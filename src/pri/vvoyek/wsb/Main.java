package pri.vvoyek.wsb;


import java.time.Year;

public class Main {

    public static void main(String[] args) {

        Human me = new Human();
        Animal dog = new Animal(Animal.DOG);
        Phone phone = new Phone();

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

        Car x3 = new Car("X3", "BMW", Year.of(2020));
        System.out.println(x3);

        me.car = x3;
        System.out.println(me);

        me.getSalary();

        try {
            me.setSalary(-1.0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        me.setSalary(100.0);
        me.setSalary(90.0);
    }
}
