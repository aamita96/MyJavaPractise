import java.util.ArrayList;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        // List<String> list = new ArrayList<>();
        list.add(new Student("Alice", 3.5));
        list.add(new Student("Charlie", 3.2));
        list.add(new Student("Bob", 3.9));
        /* 
            Default there's no natural sorting mechanism or values for object type in list so you'll need to provide comparator function as argument to sort or implement comparable Interface on object class.
            But this is not the case with String or Integer or Double types.
        */ 
    //    list.add("Mango");
    //    list.add("Banana");
    //    list.add("Orange");
    //    list.add("Litchi");
    //    list.add("Dates");
        list.sort(null); 
        System.out.println(list);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return this.name;
    }

    public double getGpa() {
        return this.gpa;
    }

    @Override
    public int compareTo(Student s) {
        return Double.compare(s.getGpa(), this.getGpa());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " - Gpa: " + this.gpa;
    }
}
