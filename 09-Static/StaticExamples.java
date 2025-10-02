public class StaticExamples {
    public static void main(String[] args) {
        // Student.count = 99;
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();

        Student.getCount();
        System.out.println(Utils.max(1, 5));

        School instance = School.getInstance();
        System.out.println(instance);
    }
}