// package abstraction;

public abstract class Animal {
    public String name;
    public int age;

    public abstract void makeSound(); // Methods which doesn't have difination are abstract method.

    // Methods which have defination are concrete method.
    public void sleep() {
        System.out.println("Zzzzz....");
    }
}