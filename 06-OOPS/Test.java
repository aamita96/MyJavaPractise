// import encapsulation.Car;

import inheritance_and_polymorphism.Animal;
import inheritance_and_polymorphism.Cat;
import inheritance_and_polymorphism.Dog;

public class Test {
    public static void main(String[] args) {
                
        // Encapsulation Example -
        // Car car = new Car("Black", "Tata", "Tiago", 2024, 40);
        // car.showCarInfo();

        // Inheritance Example -
        Cat cat = new Cat();
        cat.name = "tom";
        cat.breed = "persian";
        cat.age = 12;

        System.out.println(cat.name.toUpperCase() + " is a cat. " + cat.breed.toUpperCase() + " is the breed and the age is " + cat.age + ".");

        // Polymorphism Example -
        Animal dog = new Dog();
        Animal cat2 = new Cat();

        dog.makeSound();
        cat2.makeSound();
    }
}