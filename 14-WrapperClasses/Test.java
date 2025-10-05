public class Test {
    public static void main(String[] args) {
        Integer a = 1; // Autoboxing (primitive to Object type)
        int b = a;     // Autounboxing (Object to primitive type)

        fun(a);

        System.out.println("Integer value : " + a);
        
        Student x = new Student();
        x.id = 10;
        
        fun(x);
        
        System.out.println("Student id : " + x.id);
    }

    static void fun(Integer b) {
        b = 2;
    }

    static void fun(Student b) {
        
        // Student student = new Student();
        // student.id = 40;
        // b = student;  // Output will remain the same x.id = 10; 
        
        b.id = 40; // Output will change as we have update he id property now with value 40;
    }
}

class Student {
    public String name; 
    public int id;
}