package inheritance_and_polymorphism;

public class Dog extends Animal {
    public String breed;

    @Override
    public void makeSound() {
        System.out.println("Dog says woof woof..");
    }
}