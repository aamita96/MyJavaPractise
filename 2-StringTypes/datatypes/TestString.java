package datatypes;

public class TestString {
    public static void main(String[] args) {
        /*
            1) Primitive: byte, short, int, long, float, double, char, boolean
            2) Non-Primitive: String, Arrays, Classes, Interfaces, Objects

            What is String Pool?

            A Java String Pool is a place in heap memory where all the strings defined in the program are stored. 
            JVM checks for the presence of the object in the String pool, If String is available in the pool, 
            the same object reference is shared with the variable, else a new object is created.

            Difference between isEmpty() and isBlank()?

            The critical difference is that isBlank() returns true for whitespace characters, like some escape sequences. 
            On the other hand, isEmpty() only returns true when the String doesn’t contain any character.
        */

        // String is a sequence of characters
        // String is not a primitve type.
        
        // Java allows us two ways to declare string.
        String name = "Amit Khatri"; // This is string literal and all string defined are stored in a string pool.
        String name2 = "Amit khatri";

        // Using new keyword java creates a new object and allocates a space in the heap.
        String address = new String("Malviya Nagar");

        
        System.out.println(name);
        System.out.println(name.equals(name2)); // compares and checks for equality 
        System.out.println(name.equalsIgnoreCase(name2)); // compares and checks for equality by ignoring the case (uppercase and lowercase).
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        System.out.println(name.replace("Khatri", "Mittal"));
        System.out.println(name.isEmpty());
        System.out.println(name.isBlank()); 
        
        System.out.println("-----------------");
        System.out.println(address);
        System.out.println(address.length());
        System.out.println(address.charAt(0));
        System.out.println(address.substring(5, 8));
    }
}