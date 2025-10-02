package animals;

public interface Animal {
    /* 
     * Keywords like public and abstract for methods, and public, static, final for variables are redundant in an interface because they are implied.
     * We dont have to add those keywords explicitly.
     */
    public static final int MAX_AGE = 150;

    public abstract void eat();
    void sleep();
    // void information();

    /*
     * Static -
     * After Java 8+ versions, interfaces can have static methods with full implementation.
     * 
     * Default -
     * This allows adding new methods to an interface **without breaking existing classes** that implement it. 
     * Those classes don't need to be modified to implement the new method, which is a huge advantage if an interface is implemented by many classes.
     */
   static void info() {
        System.out.println("This is an Animal interface");
    }

    default void run() {
        this.eat();
        this.sleep();
        
        System.out.println("This is a default method and binded to all the instances of the implementing class.");
    }
}