public class Student {
    private static int count = 0;
    // public static int count = 0;

    private int id;
    private String name;
    private int age;

    static {
        /*
            A static block is used to perform one-time initialization tasks for static variables, especially when the setup logic is complex. 
            It is executed only once when the class is first loaded into memory by the JVM, even before the main method or any object creation.

            Its main purpose is to initialize static variables that require more than a simple assignment, 
            such as logic involving if-else, loops, or complex operations like setting up a database connection.
        */
        System.out.println("Hello from static block!");
    }

    public Student() {
        count++;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void getCount() {
        System.out.println("Total Student Count: " + count);
    }
}