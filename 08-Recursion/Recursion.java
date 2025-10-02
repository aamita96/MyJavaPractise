public class Recursion {
    public static void main(String[] args) {
        // 5! = 5 * 4 * 3 * 2 * 1 = 120
        System.out.println("Factorial: "+factorial(5));
        // 5 + 4 + 3 + 2 + 1 = 15
        System.out.println("Sum of N natural numbers: " + sumOfNNaturalNumbers(5));
    }

    public static int factorial(int n) {
       /*  int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }

        System.out.println(fact); */

        if (n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    public static int sumOfNNaturalNumbers(int n) {
        if (n == 1)
            return 1;

        return n + sumOfNNaturalNumbers(n - 1);
    }
}