package inheritance_and_polymorphism;

public class Cat extends Animal {
    public String breed;

    @Override
    public void makeSound() {
        System.out.println("Cat says meow..");
    }
}