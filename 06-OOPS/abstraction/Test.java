public class Test {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
        dog.sleep();

        // Animal animal = new Animal(); // we can't create objects from Abstract classes but we can use reference of it.
    }
}