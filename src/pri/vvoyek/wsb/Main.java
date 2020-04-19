package pri.vvoyek.wsb;


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
    }
}
