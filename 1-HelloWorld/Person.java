class Person {
    public static void main(String[] args) {
        System.out.println("Hello World after that a new line will be printed!");
        System.out.print("Hello World with no new line!");
        
        String operation = "Multiplication";
        int num1 = 10;
        int num2 = 20;
        double res = (num1 * num2);
        float PI = 3.14159265359f;
        boolean isEmpty = true;
        char a = 'a';

        System.out.printf("%s of %d * %d = %.2f\n", operation, num1, num2, res);
        System.out.printf("PI value is %.2f\n", PI);
        System.out.printf("PI value in exponential form %e\n", PI);
        System.out.printf("Is the classroom empty?  %b %B\n", isEmpty, isEmpty);
        System.out.printf("An alphabet %c %C\n", a, a);
    }
}