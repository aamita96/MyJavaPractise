import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        
        // Below code shows you the basic usage of try and catch.
        // int[] numerators = {10, 200, 30, 40};
        // int[] denominators = {1, 2, 0, 4};

        // for (int i = 0; i < 10; i++) {
        //     try {
        //         System.out.println(divide(numerators[i], denominators[i]));
        //     } catch(Exception e) {
        //         System.out.println(e);
        //     }
        // }

        // System.out.println("Good job!");
        
        // Method shows usage of try-with-resources
        // readUserInput();

        // Method displays throw and throws keyword examples.
        // methodToDoSomethingThenReadFile();

        // Usage of custom exception class to catch error
        BankAccount bankAccount = new BankAccount(10);
        try {
            bankAccount.withdraw(100);
        } catch(InsufficientFundsException e) {
            System.out.println(e);
        }
    }

    static int divide(int a, int b) {
        try {
            return a / b;
        }
        catch (ArithmeticException e) {
            System.out.println(e);
            return -1;
        }
        catch (RuntimeException e) {
            System.out.println(e);
            return -1;
        }
        catch (Exception e) {
            System.out.println(e);
            return -1;
        } finally {
            // This block will always run anyways even after you have returned the value!
            System.out.println("finally block");
        }
    }

    static void methodToDoSomethingThenReadFile() throws FileNotFoundException {
        readFile("a.txt");
    }

    static void readFile(String path) throws FileNotFoundException {
        try {
            FileReader file = new FileReader(path);
        } catch(FileNotFoundException e) {
            System.out.println(e);
            throw new FileNotFoundException("Fild could not be found!");
        }
    }

    static void readUserInput() {
        /* 
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        System.out.println("Output is -> " + line);

        // sc.close(); // either close the scanner manually or use try with resources. 
        // */

        // Simple example of try-with-resources
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();

            System.out.println("Output is -> " + line);
        }
    }
}